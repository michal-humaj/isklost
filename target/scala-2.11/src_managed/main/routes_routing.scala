// @SOURCE:C:/Users/MiHu/Documents/projects-Idea/my-first-app/conf/routes
// @HASH:168c9f1f1268f01f14fcf6f080a52e31c4724e30
// @DATE:Tue Aug 19 17:01:30 UTC 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:2
private[this] lazy val controllers_Kalendar_list0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Kalendar_list0_invoker = createInvoker(
controllers.Kalendar.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "list", Nil,"GET", """ Calendar""", Routes.prefix + """"""))
        

// @LINE:4
private[this] lazy val controllers_Kalendar_upcomingActions1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("events"))))
private[this] lazy val controllers_Kalendar_upcomingActions1_invoker = createInvoker(
controllers.Kalendar.upcomingActions(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "upcomingActions", Nil,"GET", """""", Routes.prefix + """events"""))
        

// @LINE:5
private[this] lazy val controllers_Kalendar_toDateEvents2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("events/"),DynamicPart("millis", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_toDateEvents2_invoker = createInvoker(
controllers.Kalendar.toDateEvents(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "toDateEvents", Seq(classOf[String]),"GET", """""", Routes.prefix + """events/$millis<[^/]+>"""))
        

// @LINE:6
private[this] lazy val controllers_Kalendar_sinceNowToDateEvents3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("events/sincenow/"),DynamicPart("millis", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_sinceNowToDateEvents3_invoker = createInvoker(
controllers.Kalendar.sinceNowToDateEvents(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "sinceNowToDateEvents", Seq(classOf[String]),"GET", """""", Routes.prefix + """events/sincenow/$millis<[^/]+>"""))
        

// @LINE:7
private[this] lazy val controllers_Store_carpetsPbAvailability4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/carpets"))))
private[this] lazy val controllers_Store_carpetsPbAvailability4_invoker = createInvoker(
controllers.Store.carpetsPbAvailability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "carpetsPbAvailability", Nil,"POST", """""", Routes.prefix + """store/carpets"""))
        

// @LINE:9
private[this] lazy val controllers_Kalendar_create5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/new"))))
private[this] lazy val controllers_Kalendar_create5_invoker = createInvoker(
controllers.Kalendar.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "create", Nil,"POST", """""", Routes.prefix + """event/new"""))
        

// @LINE:10
private[this] lazy val controllers_Kalendar_drag6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/drag"))))
private[this] lazy val controllers_Kalendar_drag6_invoker = createInvoker(
controllers.Kalendar.drag(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "drag", Nil,"POST", """""", Routes.prefix + """event/drag"""))
        

// @LINE:12
private[this] lazy val controllers_Kalendar_move7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/move/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_move7_invoker = createInvoker(
controllers.Kalendar.move(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "move", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/move/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_Kalendar_priceOffer8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/priceOffer/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_priceOffer8_invoker = createInvoker(
controllers.Kalendar.priceOffer(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "priceOffer", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/priceOffer/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Kalendar_edit9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_edit9_invoker = createInvoker(
controllers.Kalendar.edit(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "edit", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_Kalendar_update10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_update10_invoker = createInvoker(
controllers.Kalendar.update(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "update", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:18
private[this] lazy val controllers_Kalendar_deleteModal11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/delete/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_deleteModal11_invoker = createInvoker(
controllers.Kalendar.deleteModal(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "deleteModal", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_Kalendar_delete12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/delete/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_delete12_invoker = createInvoker(
controllers.Kalendar.delete(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "delete", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_Store_list13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items"))))
private[this] lazy val controllers_Store_list13_invoker = createInvoker(
controllers.Store.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "list", Nil,"GET", """ StoredItem""", Routes.prefix + """store/items"""))
        

// @LINE:22
private[this] lazy val controllers_Store_availability14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items"))))
private[this] lazy val controllers_Store_availability14_invoker = createInvoker(
controllers.Store.availability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "availability", Nil,"POST", """""", Routes.prefix + """store/items"""))
        

// @LINE:23
private[this] lazy val controllers_Store_listInCategory15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items/"),DynamicPart("category", """[^/]+""",true))))
private[this] lazy val controllers_Store_listInCategory15_invoker = createInvoker(
controllers.Store.listInCategory(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "listInCategory", Seq(classOf[String]),"GET", """""", Routes.prefix + """store/items/$category<[^/]+>"""))
        

// @LINE:25
private[this] lazy val controllers_Store_create16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item"))))
private[this] lazy val controllers_Store_create16_invoker = createInvoker(
controllers.Store.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "create", Nil,"POST", """""", Routes.prefix + """store/item"""))
        

// @LINE:26
private[this] lazy val controllers_Store_newModal17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item"))))
private[this] lazy val controllers_Store_newModal17_invoker = createInvoker(
controllers.Store.newModal(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "newModal", Nil,"GET", """""", Routes.prefix + """store/item"""))
        

// @LINE:28
private[this] lazy val controllers_Store_update18_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Store_update18_invoker = createInvoker(
controllers.Store.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_Store_editModal19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Store_editModal19_invoker = createInvoker(
controllers.Store.editModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "editModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>"""))
        

// @LINE:31
private[this] lazy val controllers_Store_delete20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Store_delete20_invoker = createInvoker(
controllers.Store.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/delete"""))
        

// @LINE:32
private[this] lazy val controllers_Store_deleteModal21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Store_deleteModal21_invoker = createInvoker(
controllers.Store.deleteModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "deleteModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/delete"""))
        

// @LINE:34
private[this] lazy val controllers_Store_increase22_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/inc"))))
private[this] lazy val controllers_Store_increase22_invoker = createInvoker(
controllers.Store.increase(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increase", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/inc"""))
        

// @LINE:35
private[this] lazy val controllers_Store_increaseModal23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/inc"))))
private[this] lazy val controllers_Store_increaseModal23_invoker = createInvoker(
controllers.Store.increaseModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increaseModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/inc"""))
        

// @LINE:37
private[this] lazy val controllers_Store_decrease24_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/dec"))))
private[this] lazy val controllers_Store_decrease24_invoker = createInvoker(
controllers.Store.decrease(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decrease", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/dec"""))
        

// @LINE:38
private[this] lazy val controllers_Store_decreaseModal25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/dec"))))
private[this] lazy val controllers_Store_decreaseModal25_invoker = createInvoker(
controllers.Store.decreaseModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decreaseModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/dec"""))
        

// @LINE:41
private[this] lazy val controllers_Tents_list26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents"))))
private[this] lazy val controllers_Tents_list26_invoker = createInvoker(
controllers.Tents.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Nil,"GET", """Tents""", Routes.prefix + """tents"""))
        

// @LINE:43
private[this] lazy val controllers_Tents_neu27_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/new"))))
private[this] lazy val controllers_Tents_neu27_invoker = createInvoker(
controllers.Tents.neu(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Nil,"GET", """""", Routes.prefix + """tents/new"""))
        

// @LINE:44
private[this] lazy val controllers_Tents_create28_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/new"))))
private[this] lazy val controllers_Tents_create28_invoker = createInvoker(
controllers.Tents.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "create", Nil,"POST", """""", Routes.prefix + """tents/new"""))
        

// @LINE:46
private[this] lazy val controllers_Tents_edit29_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_edit29_invoker = createInvoker(
controllers.Tents.edit(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tents/$id<[^/]+>"""))
        

// @LINE:47
private[this] lazy val controllers_Tents_update30_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_update30_invoker = createInvoker(
controllers.Tents.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tents/$id<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_Tents_deleteModal31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Tents_deleteModal31_invoker = createInvoker(
controllers.Tents.deleteModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "deleteModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tents/$id<[^/]+>/delete"""))
        

// @LINE:50
private[this] lazy val controllers_Tents_delete32_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Tents_delete32_invoker = createInvoker(
controllers.Tents.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tents/$id<[^/]+>/delete"""))
        

// @LINE:53
private[this] lazy val controllers_Application_login33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login33_invoker = createInvoker(
controllers.Application.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """ Play-authenticate routes""", Routes.prefix + """login"""))
        

// @LINE:54
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout34_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.logout,
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:55
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate35_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.authenticate(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>"""))
        

// @LINE:56
private[this] lazy val controllers_Application_oAuthDenied36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true),StaticPart("/denied"))))
private[this] lazy val controllers_Application_oAuthDenied36_invoker = createInvoker(
controllers.Application.oAuthDenied(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "oAuthDenied", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>/denied"""))
        

// @LINE:59
private[this] lazy val controllers_Assets_at37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at37_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Kalendar.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events""","""controllers.Kalendar.upcomingActions()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events/$millis<[^/]+>""","""controllers.Kalendar.toDateEvents(millis:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events/sincenow/$millis<[^/]+>""","""controllers.Kalendar.sinceNowToDateEvents(millis:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/carpets""","""controllers.Store.carpetsPbAvailability()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/new""","""controllers.Kalendar.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/drag""","""controllers.Kalendar.drag()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/move/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.move(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/priceOffer/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.priceOffer(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.edit(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.update(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/delete/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.deleteModal(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/delete/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.delete(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items""","""controllers.Store.list()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items""","""controllers.Store.availability()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items/$category<[^/]+>""","""controllers.Store.listInCategory(category:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item""","""controllers.Store.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item""","""controllers.Store.newModal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>""","""controllers.Store.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>""","""controllers.Store.editModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/delete""","""controllers.Store.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/delete""","""controllers.Store.deleteModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/inc""","""controllers.Store.increase(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/inc""","""controllers.Store.increaseModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/dec""","""controllers.Store.decrease(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/dec""","""controllers.Store.decreaseModal(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents""","""controllers.Tents.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/new""","""controllers.Tents.neu()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/new""","""controllers.Tents.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>""","""controllers.Tents.edit(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>""","""controllers.Tents.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>/delete""","""controllers.Tents.deleteModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>/delete""","""controllers.Tents.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""com.feth.play.module.pa.controllers.Authenticate.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>""","""com.feth.play.module.pa.controllers.Authenticate.authenticate(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>/denied""","""controllers.Application.oAuthDenied(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:2
case controllers_Kalendar_list0_route(params) => {
   call { 
        controllers_Kalendar_list0_invoker.call(controllers.Kalendar.list())
   }
}
        

// @LINE:4
case controllers_Kalendar_upcomingActions1_route(params) => {
   call { 
        controllers_Kalendar_upcomingActions1_invoker.call(controllers.Kalendar.upcomingActions())
   }
}
        

// @LINE:5
case controllers_Kalendar_toDateEvents2_route(params) => {
   call(params.fromPath[String]("millis", None)) { (millis) =>
        controllers_Kalendar_toDateEvents2_invoker.call(controllers.Kalendar.toDateEvents(millis))
   }
}
        

// @LINE:6
case controllers_Kalendar_sinceNowToDateEvents3_route(params) => {
   call(params.fromPath[String]("millis", None)) { (millis) =>
        controllers_Kalendar_sinceNowToDateEvents3_invoker.call(controllers.Kalendar.sinceNowToDateEvents(millis))
   }
}
        

// @LINE:7
case controllers_Store_carpetsPbAvailability4_route(params) => {
   call { 
        controllers_Store_carpetsPbAvailability4_invoker.call(controllers.Store.carpetsPbAvailability())
   }
}
        

// @LINE:9
case controllers_Kalendar_create5_route(params) => {
   call { 
        controllers_Kalendar_create5_invoker.call(controllers.Kalendar.create())
   }
}
        

// @LINE:10
case controllers_Kalendar_drag6_route(params) => {
   call { 
        controllers_Kalendar_drag6_invoker.call(controllers.Kalendar.drag())
   }
}
        

// @LINE:12
case controllers_Kalendar_move7_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_move7_invoker.call(controllers.Kalendar.move(eventType, id))
   }
}
        

// @LINE:14
case controllers_Kalendar_priceOffer8_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_priceOffer8_invoker.call(controllers.Kalendar.priceOffer(eventType, id))
   }
}
        

// @LINE:15
case controllers_Kalendar_edit9_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_edit9_invoker.call(controllers.Kalendar.edit(eventType, id))
   }
}
        

// @LINE:16
case controllers_Kalendar_update10_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_update10_invoker.call(controllers.Kalendar.update(eventType, id))
   }
}
        

// @LINE:18
case controllers_Kalendar_deleteModal11_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_deleteModal11_invoker.call(controllers.Kalendar.deleteModal(eventType, id))
   }
}
        

// @LINE:19
case controllers_Kalendar_delete12_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_delete12_invoker.call(controllers.Kalendar.delete(eventType, id))
   }
}
        

// @LINE:21
case controllers_Store_list13_route(params) => {
   call { 
        controllers_Store_list13_invoker.call(controllers.Store.list())
   }
}
        

// @LINE:22
case controllers_Store_availability14_route(params) => {
   call { 
        controllers_Store_availability14_invoker.call(controllers.Store.availability())
   }
}
        

// @LINE:23
case controllers_Store_listInCategory15_route(params) => {
   call(params.fromPath[String]("category", None)) { (category) =>
        controllers_Store_listInCategory15_invoker.call(controllers.Store.listInCategory(category))
   }
}
        

// @LINE:25
case controllers_Store_create16_route(params) => {
   call { 
        controllers_Store_create16_invoker.call(controllers.Store.create())
   }
}
        

// @LINE:26
case controllers_Store_newModal17_route(params) => {
   call { 
        controllers_Store_newModal17_invoker.call(controllers.Store.newModal())
   }
}
        

// @LINE:28
case controllers_Store_update18_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_update18_invoker.call(controllers.Store.update(id))
   }
}
        

// @LINE:29
case controllers_Store_editModal19_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_editModal19_invoker.call(controllers.Store.editModal(id))
   }
}
        

// @LINE:31
case controllers_Store_delete20_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_delete20_invoker.call(controllers.Store.delete(id))
   }
}
        

// @LINE:32
case controllers_Store_deleteModal21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_deleteModal21_invoker.call(controllers.Store.deleteModal(id))
   }
}
        

// @LINE:34
case controllers_Store_increase22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_increase22_invoker.call(controllers.Store.increase(id))
   }
}
        

// @LINE:35
case controllers_Store_increaseModal23_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_increaseModal23_invoker.call(controllers.Store.increaseModal(id))
   }
}
        

// @LINE:37
case controllers_Store_decrease24_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_decrease24_invoker.call(controllers.Store.decrease(id))
   }
}
        

// @LINE:38
case controllers_Store_decreaseModal25_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_decreaseModal25_invoker.call(controllers.Store.decreaseModal(id))
   }
}
        

// @LINE:41
case controllers_Tents_list26_route(params) => {
   call { 
        controllers_Tents_list26_invoker.call(controllers.Tents.list())
   }
}
        

// @LINE:43
case controllers_Tents_neu27_route(params) => {
   call { 
        controllers_Tents_neu27_invoker.call(controllers.Tents.neu())
   }
}
        

// @LINE:44
case controllers_Tents_create28_route(params) => {
   call { 
        controllers_Tents_create28_invoker.call(controllers.Tents.create())
   }
}
        

// @LINE:46
case controllers_Tents_edit29_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_edit29_invoker.call(controllers.Tents.edit(id))
   }
}
        

// @LINE:47
case controllers_Tents_update30_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_update30_invoker.call(controllers.Tents.update(id))
   }
}
        

// @LINE:49
case controllers_Tents_deleteModal31_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_deleteModal31_invoker.call(controllers.Tents.deleteModal(id))
   }
}
        

// @LINE:50
case controllers_Tents_delete32_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_delete32_invoker.call(controllers.Tents.delete(id))
   }
}
        

// @LINE:53
case controllers_Application_login33_route(params) => {
   call { 
        controllers_Application_login33_invoker.call(controllers.Application.login())
   }
}
        

// @LINE:54
case com_feth_play_module_pa_controllers_Authenticate_logout34_route(params) => {
   call { 
        com_feth_play_module_pa_controllers_Authenticate_logout34_invoker.call(com.feth.play.module.pa.controllers.Authenticate.logout)
   }
}
        

// @LINE:55
case com_feth_play_module_pa_controllers_Authenticate_authenticate35_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        com_feth_play_module_pa_controllers_Authenticate_authenticate35_invoker.call(com.feth.play.module.pa.controllers.Authenticate.authenticate(provider))
   }
}
        

// @LINE:56
case controllers_Application_oAuthDenied36_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_Application_oAuthDenied36_invoker.call(controllers.Application.oAuthDenied(provider))
   }
}
        

// @LINE:59
case controllers_Assets_at37_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at37_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     