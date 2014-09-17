// @SOURCE:C:/Users/MiHu/Documents/projects-Idea/my-first-app/conf/routes
// @HASH:4c67d795f216f4342b4dc53c2f3f2af78e6f7bfe
// @DATE:Wed Sep 17 11:23:56 BST 2014


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
private[this] lazy val controllers_Kalendar_storemanEdit4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("storeman/event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_storemanEdit4_invoker = createInvoker(
controllers.Kalendar.storemanEdit(fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "storemanEdit", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/$name<[^/]+>"""))
        

// @LINE:8
private[this] lazy val controllers_Kalendar_storemanUpdate5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("storeman/event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"))))
private[this] lazy val controllers_Kalendar_storemanUpdate5_invoker = createInvoker(
controllers.Kalendar.storemanUpdate(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "storemanUpdate", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/"""))
        

// @LINE:11
private[this] lazy val controllers_Kalendar_create6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/new"))))
private[this] lazy val controllers_Kalendar_create6_invoker = createInvoker(
controllers.Kalendar.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "create", Nil,"POST", """""", Routes.prefix + """event/new"""))
        

// @LINE:12
private[this] lazy val controllers_Kalendar_drag7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/drag"))))
private[this] lazy val controllers_Kalendar_drag7_invoker = createInvoker(
controllers.Kalendar.drag(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "drag", Nil,"POST", """""", Routes.prefix + """event/drag"""))
        

// @LINE:14
private[this] lazy val controllers_Kalendar_move8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/move/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_move8_invoker = createInvoker(
controllers.Kalendar.move(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "move", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/move/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_Kalendar_priceOffer9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/priceOffer/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_priceOffer9_invoker = createInvoker(
controllers.Kalendar.priceOffer(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "priceOffer", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/priceOffer/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_Kalendar_contract10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/contract/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_contract10_invoker = createInvoker(
controllers.Kalendar.contract(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "contract", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/contract/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_Kalendar_edit11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_edit11_invoker = createInvoker(
controllers.Kalendar.edit(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "edit", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_Kalendar_update12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_update12_invoker = createInvoker(
controllers.Kalendar.update(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "update", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_Kalendar_deleteModal13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/delete/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_deleteModal13_invoker = createInvoker(
controllers.Kalendar.deleteModal(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "deleteModal", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:23
private[this] lazy val controllers_Kalendar_delete14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/delete/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Kalendar_delete14_invoker = createInvoker(
controllers.Kalendar.delete(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Kalendar", "delete", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/delete/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:26
private[this] lazy val controllers_Store_list15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items"))))
private[this] lazy val controllers_Store_list15_invoker = createInvoker(
controllers.Store.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "list", Nil,"GET", """ StoredItem""", Routes.prefix + """store/items"""))
        

// @LINE:27
private[this] lazy val controllers_Store_availability16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items"))))
private[this] lazy val controllers_Store_availability16_invoker = createInvoker(
controllers.Store.availability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "availability", Nil,"POST", """""", Routes.prefix + """store/items"""))
        

// @LINE:28
private[this] lazy val controllers_Store_listInCategory17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/items/"),DynamicPart("category", """[^/]+""",true))))
private[this] lazy val controllers_Store_listInCategory17_invoker = createInvoker(
controllers.Store.listInCategory(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "listInCategory", Seq(classOf[String]),"GET", """""", Routes.prefix + """store/items/$category<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_Store_carpetsPbAvailability18_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/carpets"))))
private[this] lazy val controllers_Store_carpetsPbAvailability18_invoker = createInvoker(
controllers.Store.carpetsPbAvailability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "carpetsPbAvailability", Nil,"POST", """""", Routes.prefix + """store/carpets"""))
        

// @LINE:31
private[this] lazy val controllers_Store_create19_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item"))))
private[this] lazy val controllers_Store_create19_invoker = createInvoker(
controllers.Store.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "create", Nil,"POST", """""", Routes.prefix + """store/item"""))
        

// @LINE:32
private[this] lazy val controllers_Store_newModal20_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item"))))
private[this] lazy val controllers_Store_newModal20_invoker = createInvoker(
controllers.Store.newModal(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "newModal", Nil,"GET", """""", Routes.prefix + """store/item"""))
        

// @LINE:34
private[this] lazy val controllers_Store_update21_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Store_update21_invoker = createInvoker(
controllers.Store.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>"""))
        

// @LINE:35
private[this] lazy val controllers_Store_editModal22_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Store_editModal22_invoker = createInvoker(
controllers.Store.editModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "editModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>"""))
        

// @LINE:37
private[this] lazy val controllers_Store_delete23_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Store_delete23_invoker = createInvoker(
controllers.Store.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/delete"""))
        

// @LINE:38
private[this] lazy val controllers_Store_deleteModal24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Store_deleteModal24_invoker = createInvoker(
controllers.Store.deleteModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "deleteModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/delete"""))
        

// @LINE:40
private[this] lazy val controllers_Store_increase25_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/inc"))))
private[this] lazy val controllers_Store_increase25_invoker = createInvoker(
controllers.Store.increase(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increase", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/inc"""))
        

// @LINE:41
private[this] lazy val controllers_Store_increaseModal26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/inc"))))
private[this] lazy val controllers_Store_increaseModal26_invoker = createInvoker(
controllers.Store.increaseModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "increaseModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/inc"""))
        

// @LINE:43
private[this] lazy val controllers_Store_decrease27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/dec"))))
private[this] lazy val controllers_Store_decrease27_invoker = createInvoker(
controllers.Store.decrease(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decrease", Seq(classOf[Long]),"POST", """""", Routes.prefix + """store/item/$id<[^/]+>/dec"""))
        

// @LINE:44
private[this] lazy val controllers_Store_decreaseModal28_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/dec"))))
private[this] lazy val controllers_Store_decreaseModal28_invoker = createInvoker(
controllers.Store.decreaseModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Store", "decreaseModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """store/item/$id<[^/]+>/dec"""))
        

// @LINE:47
private[this] lazy val controllers_Tents_list29_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents"))))
private[this] lazy val controllers_Tents_list29_invoker = createInvoker(
controllers.Tents.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Nil,"GET", """Tents""", Routes.prefix + """tents"""))
        

// @LINE:49
private[this] lazy val controllers_Tents_neu30_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/new"))))
private[this] lazy val controllers_Tents_neu30_invoker = createInvoker(
controllers.Tents.neu(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Nil,"GET", """""", Routes.prefix + """tents/new"""))
        

// @LINE:50
private[this] lazy val controllers_Tents_create31_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/new"))))
private[this] lazy val controllers_Tents_create31_invoker = createInvoker(
controllers.Tents.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "create", Nil,"POST", """""", Routes.prefix + """tents/new"""))
        

// @LINE:52
private[this] lazy val controllers_Tents_edit32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_edit32_invoker = createInvoker(
controllers.Tents.edit(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tents/$id<[^/]+>"""))
        

// @LINE:53
private[this] lazy val controllers_Tents_update33_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_update33_invoker = createInvoker(
controllers.Tents.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tents/$id<[^/]+>"""))
        

// @LINE:55
private[this] lazy val controllers_Tents_deleteModal34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Tents_deleteModal34_invoker = createInvoker(
controllers.Tents.deleteModal(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "deleteModal", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tents/$id<[^/]+>/delete"""))
        

// @LINE:56
private[this] lazy val controllers_Tents_delete35_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Tents_delete35_invoker = createInvoker(
controllers.Tents.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tents/$id<[^/]+>/delete"""))
        

// @LINE:59
private[this] lazy val controllers_Application_login36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login36_invoker = createInvoker(
controllers.Application.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """ Play-authenticate routes""", Routes.prefix + """login"""))
        

// @LINE:60
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout37_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.logout,
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:61
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate38_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate38_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.authenticate(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>"""))
        

// @LINE:62
private[this] lazy val controllers_Application_oAuthDenied39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true),StaticPart("/denied"))))
private[this] lazy val controllers_Application_oAuthDenied39_invoker = createInvoker(
controllers.Application.oAuthDenied(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "oAuthDenied", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>/denied"""))
        

// @LINE:65
private[this] lazy val controllers_Assets_at40_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at40_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Kalendar.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events""","""controllers.Kalendar.upcomingActions()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events/$millis<[^/]+>""","""controllers.Kalendar.toDateEvents(millis:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events/sincenow/$millis<[^/]+>""","""controllers.Kalendar.sinceNowToDateEvents(millis:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/$name<[^/]+>""","""controllers.Kalendar.storemanEdit(eventType:String, id:String, name:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """storeman/event/$eventType<[^/]+>/$id<[^/]+>/""","""controllers.Kalendar.storemanUpdate(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/new""","""controllers.Kalendar.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/drag""","""controllers.Kalendar.drag()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/move/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.move(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/priceOffer/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.priceOffer(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/contract/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.contract(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.edit(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.update(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/delete/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.deleteModal(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/delete/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Kalendar.delete(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items""","""controllers.Store.list()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items""","""controllers.Store.availability()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/items/$category<[^/]+>""","""controllers.Store.listInCategory(category:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/carpets""","""controllers.Store.carpetsPbAvailability()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item""","""controllers.Store.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item""","""controllers.Store.newModal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>""","""controllers.Store.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>""","""controllers.Store.editModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/delete""","""controllers.Store.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/delete""","""controllers.Store.deleteModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/inc""","""controllers.Store.increase(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/inc""","""controllers.Store.increaseModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/dec""","""controllers.Store.decrease(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/item/$id<[^/]+>/dec""","""controllers.Store.decreaseModal(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents""","""controllers.Tents.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/new""","""controllers.Tents.neu()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/new""","""controllers.Tents.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>""","""controllers.Tents.edit(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>""","""controllers.Tents.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>/delete""","""controllers.Tents.deleteModal(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents/$id<[^/]+>/delete""","""controllers.Tents.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""com.feth.play.module.pa.controllers.Authenticate.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>""","""com.feth.play.module.pa.controllers.Authenticate.authenticate(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>/denied""","""controllers.Application.oAuthDenied(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Kalendar_storemanEdit4_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None), params.fromPath[String]("name", None)) { (eventType, id, name) =>
        controllers_Kalendar_storemanEdit4_invoker.call(controllers.Kalendar.storemanEdit(eventType, id, name))
   }
}
        

// @LINE:8
case controllers_Kalendar_storemanUpdate5_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_storemanUpdate5_invoker.call(controllers.Kalendar.storemanUpdate(eventType, id))
   }
}
        

// @LINE:11
case controllers_Kalendar_create6_route(params) => {
   call { 
        controllers_Kalendar_create6_invoker.call(controllers.Kalendar.create())
   }
}
        

// @LINE:12
case controllers_Kalendar_drag7_route(params) => {
   call { 
        controllers_Kalendar_drag7_invoker.call(controllers.Kalendar.drag())
   }
}
        

// @LINE:14
case controllers_Kalendar_move8_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_move8_invoker.call(controllers.Kalendar.move(eventType, id))
   }
}
        

// @LINE:16
case controllers_Kalendar_priceOffer9_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_priceOffer9_invoker.call(controllers.Kalendar.priceOffer(eventType, id))
   }
}
        

// @LINE:17
case controllers_Kalendar_contract10_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_contract10_invoker.call(controllers.Kalendar.contract(eventType, id))
   }
}
        

// @LINE:19
case controllers_Kalendar_edit11_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_edit11_invoker.call(controllers.Kalendar.edit(eventType, id))
   }
}
        

// @LINE:20
case controllers_Kalendar_update12_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_update12_invoker.call(controllers.Kalendar.update(eventType, id))
   }
}
        

// @LINE:22
case controllers_Kalendar_deleteModal13_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_deleteModal13_invoker.call(controllers.Kalendar.deleteModal(eventType, id))
   }
}
        

// @LINE:23
case controllers_Kalendar_delete14_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Kalendar_delete14_invoker.call(controllers.Kalendar.delete(eventType, id))
   }
}
        

// @LINE:26
case controllers_Store_list15_route(params) => {
   call { 
        controllers_Store_list15_invoker.call(controllers.Store.list())
   }
}
        

// @LINE:27
case controllers_Store_availability16_route(params) => {
   call { 
        controllers_Store_availability16_invoker.call(controllers.Store.availability())
   }
}
        

// @LINE:28
case controllers_Store_listInCategory17_route(params) => {
   call(params.fromPath[String]("category", None)) { (category) =>
        controllers_Store_listInCategory17_invoker.call(controllers.Store.listInCategory(category))
   }
}
        

// @LINE:29
case controllers_Store_carpetsPbAvailability18_route(params) => {
   call { 
        controllers_Store_carpetsPbAvailability18_invoker.call(controllers.Store.carpetsPbAvailability())
   }
}
        

// @LINE:31
case controllers_Store_create19_route(params) => {
   call { 
        controllers_Store_create19_invoker.call(controllers.Store.create())
   }
}
        

// @LINE:32
case controllers_Store_newModal20_route(params) => {
   call { 
        controllers_Store_newModal20_invoker.call(controllers.Store.newModal())
   }
}
        

// @LINE:34
case controllers_Store_update21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_update21_invoker.call(controllers.Store.update(id))
   }
}
        

// @LINE:35
case controllers_Store_editModal22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_editModal22_invoker.call(controllers.Store.editModal(id))
   }
}
        

// @LINE:37
case controllers_Store_delete23_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_delete23_invoker.call(controllers.Store.delete(id))
   }
}
        

// @LINE:38
case controllers_Store_deleteModal24_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_deleteModal24_invoker.call(controllers.Store.deleteModal(id))
   }
}
        

// @LINE:40
case controllers_Store_increase25_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_increase25_invoker.call(controllers.Store.increase(id))
   }
}
        

// @LINE:41
case controllers_Store_increaseModal26_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_increaseModal26_invoker.call(controllers.Store.increaseModal(id))
   }
}
        

// @LINE:43
case controllers_Store_decrease27_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_decrease27_invoker.call(controllers.Store.decrease(id))
   }
}
        

// @LINE:44
case controllers_Store_decreaseModal28_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Store_decreaseModal28_invoker.call(controllers.Store.decreaseModal(id))
   }
}
        

// @LINE:47
case controllers_Tents_list29_route(params) => {
   call { 
        controllers_Tents_list29_invoker.call(controllers.Tents.list())
   }
}
        

// @LINE:49
case controllers_Tents_neu30_route(params) => {
   call { 
        controllers_Tents_neu30_invoker.call(controllers.Tents.neu())
   }
}
        

// @LINE:50
case controllers_Tents_create31_route(params) => {
   call { 
        controllers_Tents_create31_invoker.call(controllers.Tents.create())
   }
}
        

// @LINE:52
case controllers_Tents_edit32_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_edit32_invoker.call(controllers.Tents.edit(id))
   }
}
        

// @LINE:53
case controllers_Tents_update33_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_update33_invoker.call(controllers.Tents.update(id))
   }
}
        

// @LINE:55
case controllers_Tents_deleteModal34_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_deleteModal34_invoker.call(controllers.Tents.deleteModal(id))
   }
}
        

// @LINE:56
case controllers_Tents_delete35_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_delete35_invoker.call(controllers.Tents.delete(id))
   }
}
        

// @LINE:59
case controllers_Application_login36_route(params) => {
   call { 
        controllers_Application_login36_invoker.call(controllers.Application.login())
   }
}
        

// @LINE:60
case com_feth_play_module_pa_controllers_Authenticate_logout37_route(params) => {
   call { 
        com_feth_play_module_pa_controllers_Authenticate_logout37_invoker.call(com.feth.play.module.pa.controllers.Authenticate.logout)
   }
}
        

// @LINE:61
case com_feth_play_module_pa_controllers_Authenticate_authenticate38_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        com_feth_play_module_pa_controllers_Authenticate_authenticate38_invoker.call(com.feth.play.module.pa.controllers.Authenticate.authenticate(provider))
   }
}
        

// @LINE:62
case controllers_Application_oAuthDenied39_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_Application_oAuthDenied39_invoker.call(controllers.Application.oAuthDenied(provider))
   }
}
        

// @LINE:65
case controllers_Assets_at40_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at40_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     