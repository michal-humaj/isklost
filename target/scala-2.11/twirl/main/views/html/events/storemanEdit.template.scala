
package views.html.events

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object storemanEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Form[EventTO],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String)(id: String)(eventForm: Form[EventTO]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import views.html.helpers._
def /*7.6*/entryGroup/*7.16*/(field: Field, className: String = "entryGroup", style: String = ""):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.88*/("""
        """),format.raw/*8.9*/("""<tr class=""""),_display_(/*8.21*/className),format.raw/*8.30*/("""" style=""""),_display_(/*8.40*/style),format.raw/*8.45*/("""">
            <td>
            """),_display_(/*10.14*/if(style.equals(""))/*10.34*/ {_display_(Seq[Any](format.raw/*10.36*/("""
                """),_display_(/*11.18*/select(
                    field("item.id"),
                    options(Item.getMapOfItemsForCategory( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect", 'required -> "true"
                )/*15.18*/(implicitField, null)),format.raw/*15.39*/("""
            """)))}/*16.14*/else/*16.18*/{_display_(Seq[Any](format.raw/*16.19*/("""
                """),_display_(/*17.18*/select(
                    field("item.id"),
                    options(Item.getMapOfItemsForCategory( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect"
                )/*21.18*/(implicitField, null)),format.raw/*21.39*/("""
            """)))}),format.raw/*22.14*/("""
            """),format.raw/*23.13*/("""</td>
            <td>
            """),_display_(/*25.14*/if(style.equals(""))/*25.34*/ {_display_(Seq[Any](format.raw/*25.36*/("""
                """),_display_(/*26.18*/inputText(
                    field("amount"),
                    'type -> "number", 'class -> "form-control amountInput", 'min -> "0.01", 'step -> "0.01", 'required -> "true"
                )),format.raw/*29.18*/("""
            """)))}/*30.14*/else/*30.18*/{_display_(Seq[Any](format.raw/*30.19*/("""
                """),_display_(/*31.18*/inputText(
                    field("amount"),
                    'class -> "form-control amountInput"
                )),format.raw/*34.18*/("""
            """)))}),format.raw/*35.14*/("""
            """),format.raw/*36.13*/("""</td>
            <td>
                <button type="button" class="btn btn-danger removeEntry">
                    <i class="fa fa-times"></i>
                </button>
            </td>
        </tr>
    """)))};implicit def /*5.6*/implicitField/*5.19*/ = {{ FieldConstructor(plainElement.f) }};
Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*5.1*/("""    """),format.raw/*5.59*/("""

    """),format.raw/*43.6*/("""

"""),_display_(/*45.2*/masters/*45.9*/.calendar("IS Klost | " + Messages(eventType))/*45.55*/{_display_(Seq[Any](format.raw/*45.56*/("""

""")))}/*47.2*/{_display_(Seq[Any](format.raw/*47.3*/("""
    """),format.raw/*48.5*/("""<div class="row">
        <div class="col-md-12">

            <div class="box box-primary" style="width:960px;">

                <div class="box-header">
                    <h3 class="box-title" >"""),_display_(/*54.45*/eventForm/*54.54*/.apply("name").value),format.raw/*54.74*/("""</h3>
                    <div class="pull-right box-tools">
                        <a class="btn btn-primary" href='"""),_display_(/*56.59*/routes/*56.65*/.Kalendar.contract(eventType, id)),format.raw/*56.98*/("""'>
                            <i class="fa fa-download"></i>
                            """),_display_(/*58.30*/if(EventType.SELFTRANSPORT.toString.equals(eventType))/*58.84*/{_display_(Seq[Any](format.raw/*58.85*/("""
                                """),format.raw/*59.33*/("""Zmluva
                            """)))}/*60.30*/else/*60.34*/{_display_(Seq[Any](format.raw/*60.35*/("""
                                """),format.raw/*61.33*/("""Výkaz
                            """)))}),format.raw/*62.30*/("""
                        """),format.raw/*63.25*/("""</a>
                    </div>
                </div>
                """),_display_(/*66.18*/form(routes.Kalendar.storemanUpdate(eventType, id), 'id -> "form", 'class -> "form-horizontal")/*66.113*/{_display_(Seq[Any](format.raw/*66.114*/("""
                    """),format.raw/*67.21*/("""<div class="box-body">
                        <ul class="list-unstyled">
                            """),_display_(/*69.30*/repeat(eventForm("entries"))/*69.58*/ { entry =>_display_(Seq[Any](format.raw/*69.69*/("""
                                """),_display_(/*70.34*/if(entry.apply("item.category").value != None && entry.apply("item.category").value.get != "CARPETS")/*70.135*/{_display_(Seq[Any](format.raw/*70.136*/("""
                                    """),format.raw/*71.37*/("""<li>
                                       <b>"""),_display_(/*72.44*/entry/*72.49*/.apply("amount").value.get.split('.')/*72.86*/(0)),format.raw/*72.89*/("""
                                        """),format.raw/*73.41*/("""KS</b>
                                        """),_display_(/*74.42*/entry/*74.47*/.apply("item.name").value.get),format.raw/*74.76*/("""
                                    """),format.raw/*75.37*/("""</li>
                                """)))}),format.raw/*76.34*/("""
                            """)))}),format.raw/*77.30*/("""
                        """),format.raw/*78.25*/("""</ul>
                        <hr>
                        <h4>Potrebné koberce</h4>
                    </div>

                    <div class="box-body no-padding">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th style="width:820px;">Koberec</th>
                                    <th>Dlžka</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                """),_display_(/*93.34*/repeat(eventForm("entries"))/*93.62*/ { entry =>_display_(Seq[Any](format.raw/*93.73*/("""
                                    """),_display_(/*94.38*/if(entry.apply("item.category").value != None && entry.apply("item.category").value.get == "CARPETS")/*94.139*/{_display_(Seq[Any](format.raw/*94.140*/("""
                                        """),_display_(/*95.42*/entryGroup(entry)),format.raw/*95.59*/("""
                                    """)))}),format.raw/*96.38*/("""
                                """)))}),format.raw/*97.34*/("""
                                """),_display_(/*98.34*/entryGroup(
                                    eventForm("entries[x]"),
                                    "entryGroupTemplate",
                                    "display:none;"
                                )),format.raw/*102.34*/("""
                            """),format.raw/*103.29*/("""</tbody>
                        </table>
                    </div>

                    <div class="box-footer">

                        <button type="submit" class="btn btn-primary">Uložiť</button>
                        <a type="button" class="btn btn-default" href=""""),_display_(/*110.73*/routes/*110.79*/.Kalendar.list()),format.raw/*110.95*/("""">Späť</a>
                        <button type="button" style="margin-right: -2px;" class="pull-right btn btn-info" id="addEntry">
                            <i class="fa fa-plus"></i>
                        </button>

                    </div>
                """)))}),format.raw/*116.18*/("""
            """),format.raw/*117.13*/("""</div>

        </div>
    </div>
""")))}/*121.2*/{_display_(Seq[Any](format.raw/*121.3*/("""
    """),format.raw/*122.5*/("""<script type="text/javascript" src='"""),_display_(/*122.42*/routes/*122.48*/.Assets.at("js/storeman/event.js")),format.raw/*122.82*/("""'></script>
""")))}))}
  }

  def render(eventType:String,id:String,eventForm:Form[EventTO]): play.twirl.api.HtmlFormat.Appendable = apply(eventType)(id)(eventForm)

  def f:((String) => (String) => (Form[EventTO]) => play.twirl.api.HtmlFormat.Appendable) = (eventType) => (id) => (eventForm) => apply(eventType)(id)(eventForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Oct 01 17:51:24 UTC 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/events/storemanEdit.scala.html
                  HASH: 27bae661a14d2394992b30ab30424010e9a9eb67
                  MATRIX: 758->1|929->171|947->181|1095->253|1130->262|1168->274|1197->283|1233->293|1258->298|1318->331|1347->351|1387->353|1432->371|1703->633|1745->654|1778->668|1791->672|1830->673|1875->691|2125->932|2167->953|2212->967|2253->980|2316->1016|2345->1036|2385->1038|2430->1056|2646->1251|2679->1265|2692->1269|2731->1270|2776->1288|2919->1410|2964->1424|3005->1437|3244->111|3265->124|3335->58|3363->106|3394->164|3427->1645|3456->1648|3471->1655|3526->1701|3565->1702|3586->1705|3624->1706|3656->1711|3883->1911|3901->1920|3942->1940|4088->2059|4103->2065|4157->2098|4275->2189|4338->2243|4377->2244|4438->2277|4493->2313|4506->2317|4545->2318|4606->2351|4672->2386|4725->2411|4824->2483|4929->2578|4969->2579|5018->2600|5148->2703|5185->2731|5234->2742|5295->2776|5406->2877|5446->2878|5511->2915|5586->2963|5600->2968|5646->3005|5670->3008|5739->3049|5814->3097|5828->3102|5878->3131|5943->3168|6013->3207|6074->3237|6127->3262|6755->3863|6792->3891|6841->3902|6906->3940|7017->4041|7057->4042|7126->4084|7164->4101|7233->4139|7298->4173|7359->4207|7597->4423|7655->4452|7957->4726|7973->4732|8011->4748|8309->5014|8351->5027|8405->5062|8444->5063|8477->5068|8542->5105|8558->5111|8614->5145
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|34->10|34->10|35->11|39->15|39->15|40->16|40->16|40->16|41->17|45->21|45->21|46->22|47->23|49->25|49->25|49->25|50->26|53->29|54->30|54->30|54->30|55->31|58->34|59->35|60->36|67->5|67->5|68->1|70->5|70->5|72->43|74->45|74->45|74->45|74->45|76->47|76->47|77->48|83->54|83->54|83->54|85->56|85->56|85->56|87->58|87->58|87->58|88->59|89->60|89->60|89->60|90->61|91->62|92->63|95->66|95->66|95->66|96->67|98->69|98->69|98->69|99->70|99->70|99->70|100->71|101->72|101->72|101->72|101->72|102->73|103->74|103->74|103->74|104->75|105->76|106->77|107->78|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|125->96|126->97|127->98|131->102|132->103|139->110|139->110|139->110|145->116|146->117|150->121|150->121|151->122|151->122|151->122|151->122
                  -- GENERATED --
              */
          