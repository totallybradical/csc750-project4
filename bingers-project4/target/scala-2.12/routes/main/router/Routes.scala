// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bingerso/GitHub-Projects/csc750-project4/bingers-project4/conf/routes
// @DATE:Sat Nov 10 17:54:40 EST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_1: controllers.Assets,
  // @LINE:13
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_1: controllers.Assets,
    // @LINE:13
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, Assets_1, HomeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addmerchant/""" + "$" + """uniqueID<[^/]+>""", """controllers.HomeController.addMerchant(uniqueID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addconsumer/""" + "$" + """uniqueID<[^/]+>""", """controllers.HomeController.addConsumer(uniqueID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addbank/""" + "$" + """nationality<[^/]+>/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.addBank(nationality:String, bankID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transactionrequest/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """bankID<[^/]+>/""" + "$" + """category<[^/]+>/""" + "$" + """amount<[^/]+>/""" + "$" + """transactionRequestID<[^/]+>""", """controllers.HomeController.addTransactionRequest(senderID:String, receiverID:String, bankID:String, category:String, amount:Integer, transactionRequestID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """iscommercial/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isCommercial(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ispersonal/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isPersonal(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ispurchase/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isPurchase(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isrefund/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isRefund(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """istrusted/""" + "$" + """merchantID<[^/]+>""", """controllers.HomeController.isTrusted(merchantID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isblacklisted/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.isBlacklisted(bankID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """bankrejections/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.getRejections(bankID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reset""", """controllers.HomeController.reset"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_addMerchant1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addmerchant/"), DynamicPart("uniqueID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addMerchant1_invoker = createInvoker(
    HomeController_0.addMerchant(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addMerchant",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addmerchant/""" + "$" + """uniqueID<[^/]+>""",
      """ Add an individual to Merchant class""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_addConsumer2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addconsumer/"), DynamicPart("uniqueID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addConsumer2_invoker = createInvoker(
    HomeController_0.addConsumer(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addConsumer",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addconsumer/""" + "$" + """uniqueID<[^/]+>""",
      """ Add an individual to Consumer class""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_addBank3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addbank/"), DynamicPart("nationality", """[^/]+""",true), StaticPart("/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addBank3_invoker = createInvoker(
    HomeController_0.addBank(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addBank",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """addbank/""" + "$" + """nationality<[^/]+>/""" + "$" + """bankID<[^/]+>""",
      """       P4 - ADDITION
 Nationality will be one of “local” or “international”, in lowercase. ID will be unique.""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_HomeController_addTransactionRequest4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transactionrequest/"), DynamicPart("senderID", """[^/]+""",true), StaticPart("/"), DynamicPart("receiverID", """[^/]+""",true), StaticPart("/"), DynamicPart("bankID", """[^/]+""",true), StaticPart("/"), DynamicPart("category", """[^/]+""",true), StaticPart("/"), DynamicPart("amount", """[^/]+""",true), StaticPart("/"), DynamicPart("transactionRequestID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addTransactionRequest4_invoker = createInvoker(
    HomeController_0.addTransactionRequest(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Integer], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addTransactionRequest",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Integer], classOf[String]),
      "POST",
      this.prefix + """transactionrequest/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """bankID<[^/]+>/""" + "$" + """category<[^/]+>/""" + "$" + """amount<[^/]+>/""" + "$" + """transactionRequestID<[^/]+>""",
      """       P4 - ADDITION
 Try to add a transaction. If successful, use the transactionRequestID as the transactionID. If unsuccessful, use
 the ID in the log anyway. A failure should specify the rule number that caused the failure. Category will be one
 of the ones listed before, in all lowercase. Amount will be a whole number.""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_HomeController_isCommercial5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("iscommercial/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isCommercial5_invoker = createInvoker(
    HomeController_0.isCommercial(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isCommercial",
      Seq(classOf[String]),
      "GET",
      this.prefix + """iscommercial/""" + "$" + """transactionID<[^/]+>""",
      """       P4 - MODIFIED
 Return whether a transaction is commercial. The additional error checking is to #make sure you didn’t add a
 transaction that should have been rejected.""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_HomeController_isPersonal6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ispersonal/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isPersonal6_invoker = createInvoker(
    HomeController_0.isPersonal(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isPersonal",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ispersonal/""" + "$" + """transactionID<[^/]+>""",
      """       P4 - MODIFIED
 Return whether a transaction is personal""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_HomeController_isPurchase7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ispurchase/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isPurchase7_invoker = createInvoker(
    HomeController_0.isPurchase(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isPurchase",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ispurchase/""" + "$" + """transactionID<[^/]+>""",
      """       P4 - MODIFIED
 Return whether a transaction is a purchase transaction""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_HomeController_isRefund8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isrefund/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isRefund8_invoker = createInvoker(
    HomeController_0.isRefund(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isRefund",
      Seq(classOf[String]),
      "GET",
      this.prefix + """isrefund/""" + "$" + """transactionID<[^/]+>""",
      """       P4 - MODIFIED
 Return whether a transaction is a refund transaction""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_HomeController_isTrusted9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("istrusted/"), DynamicPart("merchantID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isTrusted9_invoker = createInvoker(
    HomeController_0.isTrusted(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isTrusted",
      Seq(classOf[String]),
      "GET",
      this.prefix + """istrusted/""" + "$" + """merchantID<[^/]+>""",
      """       P4 - MODIFIED
 Return whether a merchant is trusted (return an error if the ID is not a merchant)""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_HomeController_isBlacklisted10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isblacklisted/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isBlacklisted10_invoker = createInvoker(
    HomeController_0.isBlacklisted(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isBlacklisted",
      Seq(classOf[String]),
      "GET",
      this.prefix + """isblacklisted/""" + "$" + """bankID<[^/]+>""",
      """       P4 - ADDITION
 Return whether a bank is blacklisted""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_HomeController_getRejections11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("bankrejections/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getRejections11_invoker = createInvoker(
    HomeController_0.getRejections(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRejections",
      Seq(classOf[String]),
      "GET",
      this.prefix + """bankrejections/""" + "$" + """bankID<[^/]+>""",
      """       P4 - ADDITION
 Returns the number of rejections suffered by a bank""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_HomeController_reset12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reset")))
  )
  private[this] lazy val controllers_HomeController_reset12_invoker = createInvoker(
    HomeController_0.reset,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "reset",
      Nil,
      "POST",
      this.prefix + """reset""",
      """       P4 - MODIFIED
 This should reload the ontology (or delete all added individuals), so that I can start the testing afresh
 Also delete all data in your #knowledge base about banks, and #any other data you were maintaining.
 Delete the log files too. This should reset the system to a “clean” state.""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:13
    case controllers_HomeController_addMerchant1_route(params@_) =>
      call(params.fromPath[String]("uniqueID", None)) { (uniqueID) =>
        controllers_HomeController_addMerchant1_invoker.call(HomeController_0.addMerchant(uniqueID))
      }
  
    // @LINE:16
    case controllers_HomeController_addConsumer2_route(params@_) =>
      call(params.fromPath[String]("uniqueID", None)) { (uniqueID) =>
        controllers_HomeController_addConsumer2_invoker.call(HomeController_0.addConsumer(uniqueID))
      }
  
    // @LINE:20
    case controllers_HomeController_addBank3_route(params@_) =>
      call(params.fromPath[String]("nationality", None), params.fromPath[String]("bankID", None)) { (nationality, bankID) =>
        controllers_HomeController_addBank3_invoker.call(HomeController_0.addBank(nationality, bankID))
      }
  
    // @LINE:30
    case controllers_HomeController_addTransactionRequest4_route(params@_) =>
      call(params.fromPath[String]("senderID", None), params.fromPath[String]("receiverID", None), params.fromPath[String]("bankID", None), params.fromPath[String]("category", None), params.fromPath[Integer]("amount", None), params.fromPath[String]("transactionRequestID", None)) { (senderID, receiverID, bankID, category, amount, transactionRequestID) =>
        controllers_HomeController_addTransactionRequest4_invoker.call(HomeController_0.addTransactionRequest(senderID, receiverID, bankID, category, amount, transactionRequestID))
      }
  
    // @LINE:35
    case controllers_HomeController_isCommercial5_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isCommercial5_invoker.call(HomeController_0.isCommercial(transactionID))
      }
  
    // @LINE:39
    case controllers_HomeController_isPersonal6_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isPersonal6_invoker.call(HomeController_0.isPersonal(transactionID))
      }
  
    // @LINE:43
    case controllers_HomeController_isPurchase7_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isPurchase7_invoker.call(HomeController_0.isPurchase(transactionID))
      }
  
    // @LINE:47
    case controllers_HomeController_isRefund8_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isRefund8_invoker.call(HomeController_0.isRefund(transactionID))
      }
  
    // @LINE:51
    case controllers_HomeController_isTrusted9_route(params@_) =>
      call(params.fromPath[String]("merchantID", None)) { (merchantID) =>
        controllers_HomeController_isTrusted9_invoker.call(HomeController_0.isTrusted(merchantID))
      }
  
    // @LINE:55
    case controllers_HomeController_isBlacklisted10_route(params@_) =>
      call(params.fromPath[String]("bankID", None)) { (bankID) =>
        controllers_HomeController_isBlacklisted10_invoker.call(HomeController_0.isBlacklisted(bankID))
      }
  
    // @LINE:59
    case controllers_HomeController_getRejections11_route(params@_) =>
      call(params.fromPath[String]("bankID", None)) { (bankID) =>
        controllers_HomeController_getRejections11_invoker.call(HomeController_0.getRejections(bankID))
      }
  
    // @LINE:65
    case controllers_HomeController_reset12_route(params@_) =>
      call { 
        controllers_HomeController_reset12_invoker.call(HomeController_0.reset)
      }
  }
}
