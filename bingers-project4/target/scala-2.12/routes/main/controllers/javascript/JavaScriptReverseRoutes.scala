// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bingerso/GitHub-Projects/csc750-project4/bingers-project4/conf/routes
// @DATE:Sat Nov 10 17:54:40 EST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:13
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addMerchant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addMerchant",
      """
        function(uniqueID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addmerchant/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uniqueID", uniqueID0))})
        }
      """
    )
  
    // @LINE:35
    def isCommercial: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isCommercial",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "iscommercial/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:39
    def isPersonal: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isPersonal",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ispersonal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:47
    def isRefund: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isRefund",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "isrefund/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:30
    def addTransactionRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addTransactionRequest",
      """
        function(senderID0,receiverID1,bankID2,category3,amount4,transactionRequestID5) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "transactionrequest/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("senderID", senderID0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("receiverID", receiverID1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID2)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("category", category3)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("amount", amount4)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionRequestID", transactionRequestID5))})
        }
      """
    )
  
    // @LINE:59
    def getRejections: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getRejections",
      """
        function(bankID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bankrejections/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID0))})
        }
      """
    )
  
    // @LINE:55
    def isBlacklisted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isBlacklisted",
      """
        function(bankID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "isblacklisted/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID0))})
        }
      """
    )
  
    // @LINE:20
    def addBank: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addBank",
      """
        function(nationality0,bankID1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addbank/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nationality", nationality0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID1))})
        }
      """
    )
  
    // @LINE:43
    def isPurchase: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isPurchase",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ispurchase/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:16
    def addConsumer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addConsumer",
      """
        function(uniqueID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addconsumer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uniqueID", uniqueID0))})
        }
      """
    )
  
    // @LINE:51
    def isTrusted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isTrusted",
      """
        function(merchantID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "istrusted/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("merchantID", merchantID0))})
        }
      """
    )
  
    // @LINE:65
    def reset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.reset",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reset"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
