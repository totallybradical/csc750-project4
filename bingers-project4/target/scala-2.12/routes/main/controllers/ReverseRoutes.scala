// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bingerso/GitHub-Projects/csc750-project4/bingers-project4/conf/routes
// @DATE:Sat Nov 10 17:54:40 EST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:13
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addMerchant(uniqueID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addmerchant/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uniqueID", uniqueID)))
    }
  
    // @LINE:35
    def isCommercial(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "iscommercial/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:39
    def isPersonal(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ispersonal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:47
    def isRefund(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "isrefund/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:30
    def addTransactionRequest(senderID:String, receiverID:String, bankID:String, category:String, amount:Integer, transactionRequestID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "transactionrequest/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("senderID", senderID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("receiverID", receiverID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("category", category)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("amount", amount)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionRequestID", transactionRequestID)))
    }
  
    // @LINE:59
    def getRejections(bankID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "bankrejections/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:55
    def isBlacklisted(bankID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "isblacklisted/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:20
    def addBank(nationality:String, bankID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addbank/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nationality", nationality)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:43
    def isPurchase(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ispurchase/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:16
    def addConsumer(uniqueID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addconsumer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uniqueID", uniqueID)))
    }
  
    // @LINE:51
    def isTrusted(merchantID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "istrusted/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("merchantID", merchantID)))
    }
  
    // @LINE:65
    def reset(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "reset")
    }
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
