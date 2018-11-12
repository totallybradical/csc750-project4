package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import models.Bank;
import models.TransactionRequest;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.kie.api.runtime.rule.FactHandle;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import plugins.Drools;

import openllet.jena.PelletReasonerFactory;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.reasoner.*;
import org.apache.jena.shared.JenaException;

import java.io.InputStream;
import java.util.HashMap;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    Drools drools;

    private HashMap<String, Bank> banks;
    private HashMap<String, TransactionRequest> transactionRequests;

    private OntModel ontReasoned;
    private String NS;

    public void loadOntology() {
        String source_file = "./owl/bingers-project3.owl"; // This is your file on the disk
        String source_url = "http://www.semanticweb.org/bingerso/ontologies/2018/9/csc750.owl"; // Remember that IRI from before?
        this.NS = source_url + "#";

        // Read the ontology. No reasoner yet.
        OntModel baseOntology = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        try
        {
            InputStream in = FileManager.get().open(source_file);
            try
            {
                baseOntology.read(in, null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (JenaException je)
        {
            System.err.println("ERROR" + je.getMessage());
            je.printStackTrace();
            System.exit(0);
        }

        baseOntology.setNsPrefix( "csc750", NS); // Just for compact printing; doesn't really matter


        // This will create an ontology that has a reasoner attached.
        // This means that it will automatically infer classes an individual belongs to, according to restrictions, etc.
        this.ontReasoned = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC, baseOntology);
    }

    public void printOntology() {
        ExtendedIterator classes = ontReasoned.listClasses();

        while (classes.hasNext())
        {
            OntClass thisClass = (OntClass) classes.next();
            if (thisClass.toString().contains("http")) {
                System.out.println("Found class: " + thisClass.toString());
                ExtendedIterator instances = thisClass.listInstances();
                while (instances.hasNext()) {
                    Individual thisInstance = (Individual) instances.next();
                    System.out.println("  Found instance: " + thisInstance.toString());
                }
            }
        }
        System.out.println();
    }

    /**
     * Constructor
     */
    public HomeController() {

        loadOntology(); // Load the ontology
//        drools.kieSession.insert(this.ontReasoned);
//        drools.kieSession.setGlobal("NS", this.NS);
        banks = new HashMap<>();
        transactionRequests = new HashMap<>();
    }

    /**
     * Add an individual to Merchant class
     * @param uniqueID
     * @return
     */
    public Result addMerchant(String uniqueID) {
        // First, get the classes we need
        OntClass classMerchant = ontReasoned.getOntClass(NS + "Merchant");

        // Create the individuals we need
        Individual merchant = ontReasoned.createIndividual(NS + uniqueID, classMerchant);

        drools.kieSession.insert(merchant);

        // Print ontology
        printOntology();

        // Return appropriate JSON response
        ObjectNode result = Json.newObject();
        result.put("status", "success");
        return ok(result);
    }

    // Add an individual to Consumer class
    public Result addConsumer(String uniqueID) {
        // First, get the classes we need
        OntClass classConsumer = ontReasoned.getOntClass(NS + "Consumer");

        // Create the individuals we need
        Individual consumer = ontReasoned.createIndividual(NS + uniqueID, classConsumer);

        drools.kieSession.insert(consumer);

        // Print ontology
        printOntology();

        // Return appropriate JSON response
        ObjectNode result = Json.newObject();
        result.put("status", "success");
        return ok(result);
    }

    // Nationality will be one of “local” or “international”, in lowercase. ID will be unique.
    public Result addBank(String nationality, String uniqueID) {
        Bank b = new Bank(uniqueID, nationality);
        banks.put(uniqueID, b);

        drools.kieSession.insert(b);
//        drools.kieSession.fireAllRules();

        System.out.println("Banks: " + banks);
        System.out.println();

        // Return appropriate JSON response
        ObjectNode result = Json.newObject();
        result.put("status", "success");
        return ok(result);
    }

//    P4 - REPLACED BY TRANSACTION REQUEST
//    // Add an individual to Transaction class
//    public Result addTransaction(String senderID, String receiverID, String transactionID) {
//        // First, get the classes we need
//        OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");
//
//        // Get the properties we need
//        OntProperty hasSender = ontReasoned.getObjectProperty(NS + "hasSender");
//        OntProperty hasReceiver = ontReasoned.getObjectProperty(NS + "hasReceiver");
//
//        // Get existing individuals
//        Individual sender = ontReasoned.getIndividual( NS + senderID);
//        Individual receiver = ontReasoned.getIndividual(NS + receiverID);
//
//        // Create the individuals we need
//        Individual transaction = ontReasoned.createIndividual(NS + transactionID, classTransaction);
//
//        // Add the properties
//        transaction.addProperty(hasSender, sender);
//        transaction.addProperty(hasReceiver, receiver);
//
//        // Print ontology
//        printOntology();
//
//        // Return appropriate JSON response
//        ObjectNode result = Json.newObject();
//        result.put("result", "success");
//        return ok(result);
//    }

    public Result addTransactionRequest(String senderID, String receiverID, String bankID, String category, int amount, String transactionRequestID) {
        TransactionRequest t = new TransactionRequest(senderID, receiverID, bankID, category, amount, transactionRequestID);
        transactionRequests.put(transactionRequestID, t);

        FactHandle tFactHandle = drools.kieSession.insert(t);
        drools.kieSession.fireAllRules();

        System.out.println("Transaction Requests: " + transactionRequests);
        System.out.println();

        drools.kieSession.update(tFactHandle, t);

        if (t.isApproved()) {
            //  First, get the classes we need
            OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");

            // Get the properties we need
            OntProperty hasSender = ontReasoned.getObjectProperty(NS + "hasSender");
            OntProperty hasReceiver = ontReasoned.getObjectProperty(NS + "hasReceiver");

            // Get existing individuals
            Individual sender = ontReasoned.getIndividual( NS + senderID);
            Individual receiver = ontReasoned.getIndividual(NS + receiverID);

            // Update bank
            Bank b = banks.get(t.getBankID());
            b.setTotalApproved(b.getTotalApproved() + 1);
            b.setAvgAmount((b.getAvgAmount() + t.getAmount()) / b.getTotalApproved());
            if (sender.hasOntClass(NS + "Trusted") || receiver.hasOntClass(NS + "Trusted")) {
                b.setTotalTrusted(b.getTotalTrusted() + 1);
            }
            b.setConsecutiveRejections(0);
            System.out.println(b);

            // Update the bank instance in drools
            FactHandle bFactHandle = drools.kieSession.getFactHandle(b);
            drools.kieSession.update(bFactHandle, b);

            // Create the individuals we need
            Individual transaction = ontReasoned.createIndividual(NS + transactionRequestID, classTransaction);

            // Add the properties
            transaction.addProperty(hasSender, sender);
            transaction.addProperty(hasReceiver, receiver);

            // Print ontology
            printOntology();
        }

        // Return appropriate JSON response
        ObjectNode result = Json.newObject();
        result.put("status", "success");
        return ok(result);
    }

    // Return whether a transaction is commercial
    public Result isCommercial(String transactionID) {
        // First, get the classes we need
        OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");
        OntClass classCommercial = ontReasoned.getOntClass(NS + "Commercial");

        // Get existing individuals
        Individual transaction = ontReasoned.getIndividual( NS + transactionID);

        // Check if ID is a transaction
        boolean isTransaction = transaction.hasOntClass(classTransaction);

        if (isTransaction) {
            // Check if transaction is commercial
            boolean isCommercial = transaction.hasOntClass(classCommercial);

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isCommercial));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a transaction");
            return ok(result);
        }
    }

    // Return whether a transaction is personal
    public Result isPersonal(String transactionID) {
        // First, get the classes we need
        OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");
        OntClass classPersonal = ontReasoned.getOntClass(NS + "Personal");

        // Get existing individuals
        Individual transaction = ontReasoned.getIndividual( NS + transactionID);

        // Check if ID is a transaction
        boolean isTransaction = transaction.hasOntClass(classTransaction);

        if (isTransaction) {
            // Check if transaction is personal
            boolean isPersonal = transaction.hasOntClass(classPersonal);

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isPersonal));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a transaction");
            return ok(result);
        }
    }

    // Return whether a transaction is a purchase transaction
    public Result isPurchase(String transactionID) {
        // First, get the classes we need
        OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");
        OntClass classPurchase = ontReasoned.getOntClass(NS + "Purchase");

        // Get existing individuals
        Individual transaction = ontReasoned.getIndividual( NS + transactionID);

        // Check if ID is a transaction
        boolean isTransaction = transaction.hasOntClass(classTransaction);

        if (isTransaction) {
            // Check if transaction is a purchase
            boolean isPurchase = transaction.hasOntClass(classPurchase);

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isPurchase));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a transaction");
            return ok(result);
        }
    }

    // Return whether a transaction is a refund transaction
    public Result isRefund(String transactionID) {
        // First, get the classes we need
        OntClass classTransaction = ontReasoned.getOntClass(NS + "Transaction");
        OntClass classRefund = ontReasoned.getOntClass(NS + "Refund");

        // Get existing individuals
        Individual transaction = ontReasoned.getIndividual( NS + transactionID);

        // Check if ID is a transaction
        boolean isTransaction = transaction.hasOntClass(classTransaction);

        if (isTransaction) {
            // Check if transaction is a refund
            boolean isRefund = transaction.hasOntClass(classRefund);

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isRefund));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a transaction");
            return ok(result);
        }
    }

    // Return whether a merchant is trusted (return an error if the ID is not a merchant)
    public Result isTrusted(String merchantID) {
        // First, get the classes we need
        OntClass classTrusted = ontReasoned.getOntClass(NS + "Trusted");
        OntClass classMerchant = ontReasoned.getOntClass(NS + "Merchant");

        // Get existing individuals
        Individual merchant = ontReasoned.getIndividual( NS + merchantID);

        // Check if ID is a merchant
        boolean isMerchant = merchant.hasOntClass(classMerchant);

        if (isMerchant) {
            // Check if merchant is trusted
            boolean isTrusted = merchant.hasOntClass(classTrusted);

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isTrusted));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a merchant");
            return ok(result);
        }
    }

    // Returns whether a bank is blacklisted
    public Result isBlacklisted(String bankID) {
        // Check if ID is a bank
        boolean isBank = banks.containsKey(bankID);

        if (isBank) {
            // Check if bank is blacklisted
            boolean isBlacklisted = banks.get(bankID).isBlacklisted();

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("result", String.valueOf(isBlacklisted));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a bank");
            return ok(result);
        }
    }

    // Returns the number of rejections suffered by a bank
    public Result getRejections(String bankID) {
        // Check if ID is a bank
        boolean isBank = banks.containsKey(bankID);

        if (isBank) {
            // Get number of rejections
            int numOfRejections = banks.get(bankID).getTotalRejections();

            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "success");
            result.put("rejections", String.valueOf(numOfRejections));
            return ok(result);
        } else {
            // Return appropriate JSON response
            ObjectNode result = Json.newObject();
            result.put("status", "failure");
            result.put("reason", "not a bank");
            return ok(result);
        }
    }

    // This should reload the ontology (or delete all added individuals), so that I can start the testing afresh
    public Result reset() {
        // Reload ontology
        loadOntology();

        // Purge banks
        banks.clear();

        // Purge transactionRequests
        transactionRequests.clear();

        // Purge droolsSession
        drools.kieSession.dispose();

        // Print ontology
        printOntology();

        // Return success
        ObjectNode result = Json.newObject();
        result.put("result", "success");
        return ok(result);
    }
}
