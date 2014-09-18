// @SOURCE:C:/Users/MiHu/Documents/projects-Idea/my-first-app/conf/routes
// @HASH:4c67d795f216f4342b4dc53c2f3f2af78e6f7bfe
// @DATE:Thu Sep 18 17:39:47 BST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:61
// @LINE:60
package com.feth.play.module.pa.controllers {

// @LINE:61
// @LINE:60
class ReverseAuthenticate {


// @LINE:60
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:61
def authenticate(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)))
}
                        

}
                          
}
                  

// @LINE:65
// @LINE:62
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
package controllers {

// @LINE:65
class ReverseAssets {


// @LINE:65
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
class ReverseKalendar {


// @LINE:6
def sinceNowToDateEvents(millis:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "events/sincenow/" + implicitly[PathBindable[String]].unbind("millis", dynamicString(millis)))
}
                        

// @LINE:16
def priceOffer(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/priceOffer/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:5
def toDateEvents(millis:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "events/" + implicitly[PathBindable[String]].unbind("millis", dynamicString(millis)))
}
                        

// @LINE:11
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/new")
}
                        

// @LINE:20
def update(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:22
def deleteModal(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/delete/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:12
def drag(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/drag")
}
                        

// @LINE:14
def move(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/move/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:23
def delete(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/delete/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:8
def storemanUpdate(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "storeman/event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/")
}
                        

// @LINE:17
def contract(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/contract/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:19
def edit(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:4
def upcomingActions(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "events")
}
                        

// @LINE:2
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def storemanEdit(eventType:String, id:String, name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "storeman/event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

}
                          

// @LINE:62
// @LINE:59
class ReverseApplication {


// @LINE:62
def oAuthDenied(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)) + "/denied")
}
                        

// @LINE:59
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
class ReverseTents {


// @LINE:55
def deleteModal(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:56
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tents/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:50
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tents/new")
}
                        

// @LINE:52
def edit(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:53
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tents/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:47
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents")
}
                        

// @LINE:49
def neu(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents/new")
}
                        

}
                          

// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseStore {


// @LINE:38
def deleteModal(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:37
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:28
def listInCategory(category:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/items/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
}
                        

// @LINE:31
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/item")
}
                        

// @LINE:35
def editModal(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:27
def availability(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/items")
}
                        

// @LINE:40
def increase(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/inc")
}
                        

// @LINE:34
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:32
def newModal(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/item")
}
                        

// @LINE:44
def decreaseModal(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/dec")
}
                        

// @LINE:41
def increaseModal(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/inc")
}
                        

// @LINE:26
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/items")
}
                        

// @LINE:29
def carpetsPbAvailability(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/carpets")
}
                        

// @LINE:43
def decrease(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "store/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/dec")
}
                        

}
                          
}
                  


// @LINE:61
// @LINE:60
package com.feth.play.module.pa.controllers.javascript {
import ReverseRouteContext.empty

// @LINE:61
// @LINE:60
class ReverseAuthenticate {


// @LINE:60
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.feth.play.module.pa.controllers.Authenticate.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:61
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.feth.play.module.pa.controllers.Authenticate.authenticate",
   """
      function(provider) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("provider", encodeURIComponent(provider))})
      }
   """
)
                        

}
              
}
        

// @LINE:65
// @LINE:62
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:65
class ReverseAssets {


// @LINE:65
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
class ReverseKalendar {


// @LINE:6
def sinceNowToDateEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.sinceNowToDateEvents",
   """
      function(millis) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "events/sincenow/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("millis", encodeURIComponent(millis))})
      }
   """
)
                        

// @LINE:16
def priceOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.priceOffer",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/priceOffer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:5
def toDateEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.toDateEvents",
   """
      function(millis) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "events/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("millis", encodeURIComponent(millis))})
      }
   """
)
                        

// @LINE:11
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/new"})
      }
   """
)
                        

// @LINE:20
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.update",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:22
def deleteModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.deleteModal",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/delete/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:12
def drag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.drag",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/drag"})
      }
   """
)
                        

// @LINE:14
def move : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.move",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/move/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:23
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.delete",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/delete/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:8
def storemanUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.storemanUpdate",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "storeman/event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/"})
      }
   """
)
                        

// @LINE:17
def contract : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.contract",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/contract/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:19
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.edit",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:4
def upcomingActions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.upcomingActions",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "events"})
      }
   """
)
                        

// @LINE:2
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def storemanEdit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Kalendar.storemanEdit",
   """
      function(eventType,id,name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "storeman/event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

}
              

// @LINE:62
// @LINE:59
class ReverseApplication {


// @LINE:62
def oAuthDenied : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.oAuthDenied",
   """
      function(provider) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("provider", encodeURIComponent(provider)) + "/denied"})
      }
   """
)
                        

// @LINE:59
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
class ReverseTents {


// @LINE:55
def deleteModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.deleteModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:56
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:50
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/new"})
      }
   """
)
                        

// @LINE:52
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:53
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:47
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents"})
      }
   """
)
                        

// @LINE:49
def neu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.neu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents/new"})
      }
   """
)
                        

}
              

// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseStore {


// @LINE:38
def deleteModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.deleteModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:37
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:28
def listInCategory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.listInCategory",
   """
      function(category) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/items/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category))})
      }
   """
)
                        

// @LINE:31
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item"})
      }
   """
)
                        

// @LINE:35
def editModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.editModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:27
def availability : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.availability",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/items"})
      }
   """
)
                        

// @LINE:40
def increase : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.increase",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/inc"})
      }
   """
)
                        

// @LINE:34
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:32
def newModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.newModal",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item"})
      }
   """
)
                        

// @LINE:44
def decreaseModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.decreaseModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/dec"})
      }
   """
)
                        

// @LINE:41
def increaseModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.increaseModal",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/inc"})
      }
   """
)
                        

// @LINE:26
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/items"})
      }
   """
)
                        

// @LINE:29
def carpetsPbAvailability : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.carpetsPbAvailability",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/carpets"})
      }
   """
)
                        

// @LINE:43
def decrease : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Store.decrease",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "store/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/dec"})
      }
   """
)
                        

}
              
}
        


// @LINE:61
// @LINE:60
package com.feth.play.module.pa.controllers.ref {


// @LINE:61
// @LINE:60
class ReverseAuthenticate {


// @LINE:60
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.logout(), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:61
def authenticate(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.authenticate(provider), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>""")
)
                      

}
                          
}
        

// @LINE:65
// @LINE:62
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
package controllers.ref {


// @LINE:65
class ReverseAssets {


// @LINE:65
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
// @LINE:2
class ReverseKalendar {


// @LINE:6
def sinceNowToDateEvents(millis:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.sinceNowToDateEvents(millis), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "sinceNowToDateEvents", Seq(classOf[String]), "GET", """""", _prefix + """events/sincenow/$millis<[^/]+>""")
)
                      

// @LINE:16
def priceOffer(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.priceOffer(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "priceOffer", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/priceOffer/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:5
def toDateEvents(millis:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.toDateEvents(millis), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "toDateEvents", Seq(classOf[String]), "GET", """""", _prefix + """events/$millis<[^/]+>""")
)
                      

// @LINE:11
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "create", Seq(), "POST", """""", _prefix + """event/new""")
)
                      

// @LINE:20
def update(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.update(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "update", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:22
def deleteModal(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.deleteModal(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "deleteModal", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:12
def drag(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.drag(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "drag", Seq(), "POST", """""", _prefix + """event/drag""")
)
                      

// @LINE:14
def move(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.move(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "move", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """event/move/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:23
def delete(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.delete(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "delete", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:8
def storemanUpdate(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.storemanUpdate(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "storemanUpdate", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/""")
)
                      

// @LINE:17
def contract(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.contract(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "contract", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/contract/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:19
def edit(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.edit(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "edit", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:4
def upcomingActions(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.upcomingActions(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "upcomingActions", Seq(), "GET", """""", _prefix + """events""")
)
                      

// @LINE:2
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "list", Seq(), "GET", """ Calendar""", _prefix + """""")
)
                      

// @LINE:7
def storemanEdit(eventType:String, id:String, name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Kalendar.storemanEdit(eventType, id, name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "storemanEdit", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/$name<[^/]+>""")
)
                      

}
                          

// @LINE:62
// @LINE:59
class ReverseApplication {


// @LINE:62
def oAuthDenied(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.oAuthDenied(provider), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "oAuthDenied", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>/denied""")
)
                      

// @LINE:59
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Seq(), "GET", """ Play-authenticate routes""", _prefix + """login""")
)
                      

}
                          

// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
// @LINE:47
class ReverseTents {


// @LINE:55
def deleteModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.deleteModal(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "deleteModal", Seq(classOf[Long]), "GET", """""", _prefix + """tents/$id<[^/]+>/delete""")
)
                      

// @LINE:56
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]), "POST", """""", _prefix + """tents/$id<[^/]+>/delete""")
)
                      

// @LINE:50
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "create", Seq(), "POST", """""", _prefix + """tents/new""")
)
                      

// @LINE:52
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.edit(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]), "GET", """""", _prefix + """tents/$id<[^/]+>""")
)
                      

// @LINE:53
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]), "POST", """""", _prefix + """tents/$id<[^/]+>""")
)
                      

// @LINE:47
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Seq(), "GET", """Tents""", _prefix + """tents""")
)
                      

// @LINE:49
def neu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.neu(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Seq(), "GET", """""", _prefix + """tents/new""")
)
                      

}
                          

// @LINE:44
// @LINE:43
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:35
// @LINE:34
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
class ReverseStore {


// @LINE:38
def deleteModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.deleteModal(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "deleteModal", Seq(classOf[Long]), "GET", """""", _prefix + """store/item/$id<[^/]+>/delete""")
)
                      

// @LINE:37
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "delete", Seq(classOf[Long]), "POST", """""", _prefix + """store/item/$id<[^/]+>/delete""")
)
                      

// @LINE:28
def listInCategory(category:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.listInCategory(category), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "listInCategory", Seq(classOf[String]), "GET", """""", _prefix + """store/items/$category<[^/]+>""")
)
                      

// @LINE:31
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "create", Seq(), "POST", """""", _prefix + """store/item""")
)
                      

// @LINE:35
def editModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.editModal(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "editModal", Seq(classOf[Long]), "GET", """""", _prefix + """store/item/$id<[^/]+>""")
)
                      

// @LINE:27
def availability(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.availability(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "availability", Seq(), "POST", """""", _prefix + """store/items""")
)
                      

// @LINE:40
def increase(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.increase(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increase", Seq(classOf[Long]), "POST", """""", _prefix + """store/item/$id<[^/]+>/inc""")
)
                      

// @LINE:34
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "update", Seq(classOf[Long]), "POST", """""", _prefix + """store/item/$id<[^/]+>""")
)
                      

// @LINE:32
def newModal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.newModal(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "newModal", Seq(), "GET", """""", _prefix + """store/item""")
)
                      

// @LINE:44
def decreaseModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.decreaseModal(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decreaseModal", Seq(classOf[Long]), "GET", """""", _prefix + """store/item/$id<[^/]+>/dec""")
)
                      

// @LINE:41
def increaseModal(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.increaseModal(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increaseModal", Seq(classOf[Long]), "GET", """""", _prefix + """store/item/$id<[^/]+>/inc""")
)
                      

// @LINE:26
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "list", Seq(), "GET", """ StoredItem""", _prefix + """store/items""")
)
                      

// @LINE:29
def carpetsPbAvailability(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.carpetsPbAvailability(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "carpetsPbAvailability", Seq(), "POST", """""", _prefix + """store/carpets""")
)
                      

// @LINE:43
def decrease(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Store.decrease(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decrease", Seq(classOf[Long]), "POST", """""", _prefix + """store/item/$id<[^/]+>/dec""")
)
                      

}
                          
}
        
    