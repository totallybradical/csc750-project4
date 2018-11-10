package models;

public class TransactionRequest {

    private String id;
    private boolean isApproved;
    private String senderID;
    private String receiverID;
    private String bankID;
    private String category;
    private int amount;

    // senderID: String, receiverID: String, bankID: String, category: String, amount: int, transactionRequestID: String
    public TransactionRequest(String senderID, String receiverID, String bankID, String category, int amount, String id) {
        this.id = id;
        this.isApproved = true; // Assume approved unless rejected by a rule
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.bankID = bankID;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRequest(" + this.id + ", " + this.isApproved + ", " + this.senderID + ", " +
                this.receiverID + ", " + this.bankID + ", " + this.category + ", " + this.amount + ")";
    }

    public String getId() {
        return this.id;
    }

    public boolean isApproved() {
        return this.isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getSenderID() {
        return this.senderID;
    }

    public String getReceiverID() {
        return this.receiverID;
    }

    public String getBankID() {
        return this.bankID;
    }

    public String getCategory() {
        return this.category;
    }

    public int getAmount() {
        return this.amount;
    }
}
