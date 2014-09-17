
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
object eventEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Form[EventTO],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String)(id: String)(eventForm: Form[EventTO]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import views.html.helpers._
def /*7.2*/entryGroup/*7.12*/(field: Field, className: String = "entryGroup", style: String = ""):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.84*/("""
    """),format.raw/*8.5*/("""<tr class=""""),_display_(/*8.17*/className),format.raw/*8.26*/("""" style=""""),_display_(/*8.36*/style),format.raw/*8.41*/("""">
        <td>
        """),_display_(/*10.10*/select(
            field("item.category"),
            options(Category.eventOptions),
            'id -> "categorySelect0", 'class -> "form-control categorySelect"
        )/*14.10*/(implicitField, null)),format.raw/*14.31*/("""
        """),format.raw/*15.9*/("""</td>
        <td>
        """),_display_(/*17.10*/if(style.equals(""))/*17.30*/ {_display_(Seq[Any](format.raw/*17.32*/("""
            """),_display_(/*18.14*/select(
                field("item.id"),
                options(Item.options( field("item.category").value.toString)),
                'id -> "itemSelect0", 'class -> "form-control itemSelect", 'required -> "true"
            )/*22.14*/(implicitField, null)),format.raw/*22.35*/("""
        """)))}/*23.10*/else/*23.14*/{_display_(Seq[Any](format.raw/*23.15*/("""
            """),_display_(/*24.14*/select(
                field("item.id"),
                options(Item.options( field("item.category").value.toString)),
                'id -> "itemSelect0", 'class -> "form-control itemSelect"
            )/*28.14*/(implicitField, null)),format.raw/*28.35*/("""
        """)))}),format.raw/*29.10*/("""
        """),format.raw/*30.9*/("""</td>
        <td>
        """),_display_(/*32.10*/if(style.equals(""))/*32.30*/ {_display_(Seq[Any](format.raw/*32.32*/("""
            """),_display_(/*33.14*/if(field("item.category").value.toString == "Some(CARPETS)")/*33.74*/ {_display_(Seq[Any](format.raw/*33.76*/("""
                """),_display_(/*34.18*/inputText(
                    field("amount"),
                    'type -> "number", 'class -> "form-control amountInput", 'min -> "0.01", 'step -> "0.01", 'required -> "true"
                )),format.raw/*37.18*/("""
            """)))}/*38.14*/else/*38.19*/{_display_(Seq[Any](format.raw/*38.20*/("""
                """),_display_(/*39.18*/inputText(
                    field("amount"),
                    'type -> "number", 'class -> "form-control amountInput", 'min -> "1", 'required -> "true"
                )),format.raw/*42.18*/("""
            """)))}),format.raw/*43.14*/("""
        """)))}/*44.10*/else/*44.15*/{_display_(Seq[Any](format.raw/*44.16*/("""
            """),_display_(/*45.14*/inputText(
                field("amount"),
                'class -> "form-control amountInput"
            )),format.raw/*48.14*/("""
        """)))}),format.raw/*49.10*/("""
        """),format.raw/*50.9*/("""</td>
        <td>
            <button type="button" class="btn btn-danger removeEntry">
                <i class="fa fa-times"></i>
            </button>
        </td>
    </tr>
""")))};implicit def /*5.2*/implicitField/*5.15*/ = {{ FieldConstructor(plainElement.f) }};
Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*5.55*/("""

"""),format.raw/*57.2*/("""

"""),_display_(/*59.2*/masters/*59.9*/.calendar("IS Klost | " + Messages(eventType))/*59.55*/{_display_(Seq[Any](format.raw/*59.56*/("""

""")))}/*61.2*/{_display_(Seq[Any](format.raw/*61.3*/("""
    """),format.raw/*62.5*/("""<div class="row">
        <div class="col-md-12">

            <div class="box box-solid box-primary" style="width:960px;">

                <div class="box-header">
                    <h3 class="box-title">"""),_display_(/*68.44*/Messages(eventType)),format.raw/*68.63*/("""</h3>
                </div>

                """),_display_(/*71.18*/form(routes.Kalendar.update(eventType, id), 'id -> "form", 'class -> "form-horizontal")/*71.105*/{_display_(Seq[Any](format.raw/*71.106*/("""
                    """),format.raw/*72.21*/("""<div class="box-body">

                        <div class="form-group">
                            <label class="col-sm-1 control-label">Názov</label>
                            <div class="col-sm-11">
                                """),_display_(/*77.34*/inputText(eventForm("name"), 'class -> "form-control", 'required -> "true")),format.raw/*77.109*/("""
                            """),format.raw/*78.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label"></label>
                            <div class="col-sm-11">
                                <div class="checkbox">
                                    <label id="checkboxAllDay">
                                        """),_display_(/*85.42*/if(eventForm.apply("allDay").value.equals("true"))/*85.92*/{_display_(Seq[Any](format.raw/*85.93*/("""
                                            """),_display_(/*86.46*/inputText(eventForm("allDay"), 'type -> "checkbox", 'checked -> "true")),format.raw/*86.117*/("""
                                        """)))}/*87.42*/else/*87.47*/{_display_(Seq[Any](format.raw/*87.48*/("""
                                            """),_display_(/*88.46*/inputText(eventForm("allDay"), 'type -> "checkbox")),format.raw/*88.97*/("""
                                        """)))}),format.raw/*89.42*/("""
                                        """),format.raw/*90.41*/("""Celý deň
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Začiatok</label>
                            <div class="col-sm-3">
                                """),_display_(/*98.34*/inputText(eventForm("startDate"), 'id -> "startDate", 'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*98.151*/("""
                            """),format.raw/*99.29*/("""</div>
                            <div class="col-sm-2">
                                """),_display_(/*101.34*/inputText(eventForm("startTime"), 'id -> "timeInputStart", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*101.156*/("""
                            """),format.raw/*102.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Koniec</label>
                            <div class="col-sm-3">
                                """),_display_(/*107.34*/inputText(eventForm("endDate"), 'id -> "endDate",  'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*107.148*/("""
                            """),format.raw/*108.29*/("""</div>
                            <div class="col-sm-2">
                                """),_display_(/*110.34*/inputText(eventForm("endTime"), 'id -> "timeInputEnd", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*110.152*/("""
                            """),format.raw/*111.29*/("""</div>
                        </div>
                        <hr>
                        <h4>Potrebné položky</h4>

                    </div>

                    <div class="box-body no-padding">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th style="width:240px;">Kategoria</th>
                                    <th style="width:580px;">Položka</th>
                                    <th>Počet</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                """),_display_(/*129.34*/repeat(eventForm("entries"))/*129.62*/ { entry =>_display_(Seq[Any](format.raw/*129.73*/("""
                                    """),_display_(/*130.38*/entryGroup(entry)),format.raw/*130.55*/("""
                                """)))}),format.raw/*131.34*/("""
                                """),_display_(/*132.34*/entryGroup(
                                    eventForm("entries[x]"),
                                    "entryGroupTemplate",
                                    "display:none;"
                                )),format.raw/*136.34*/("""
                            """),format.raw/*137.29*/("""</tbody>
                        </table>
                    </div>

                    <div class="box-footer">

                        <button type="submit" class="btn btn-primary">Uložiť</button>
                        <a type="button" class="btn btn-default" href=""""),_display_(/*144.73*/routes/*144.79*/.Kalendar.list()),format.raw/*144.95*/("""">Späť</a>
                        <button type="button" style="margin-right: -2px;" class="pull-right btn btn-info" id="addEntry">
                            <i class="fa fa-plus"></i>
                        </button>

                    </div>
                """)))}),format.raw/*150.18*/("""
            """),format.raw/*151.13*/("""</div>

        </div>
    </div>
""")))}/*155.2*/{_display_(Seq[Any](format.raw/*155.3*/("""
    """),format.raw/*156.5*/("""<script type="text/javascript" src='"""),_display_(/*156.42*/routes/*156.48*/.Assets.at("js/event.js")),format.raw/*156.73*/("""'></script>
""")))}))}
  }

  def render(eventType:String,id:String,eventForm:Form[EventTO]): play.twirl.api.HtmlFormat.Appendable = apply(eventType)(id)(eventForm)

  def f:((String) => (String) => (Form[EventTO]) => play.twirl.api.HtmlFormat.Appendable) = (eventType) => (id) => (eventForm) => apply(eventType)(id)(eventForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:00 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/events/eventEdit.scala.html
                  HASH: bb51c17c4d93de48d403f2356741c4d35a96cefb
                  MATRIX: 755->1|926->169|944->179|1092->251|1124->257|1162->269|1191->278|1227->288|1252->293|1306->320|1494->499|1536->520|1573->530|1630->560|1659->580|1699->582|1741->597|1983->830|2025->851|2055->862|2068->866|2107->867|2149->882|2370->1094|2412->1115|2454->1126|2491->1136|2548->1166|2577->1186|2617->1188|2659->1203|2728->1263|2768->1265|2814->1284|3033->1482|3067->1497|3080->1502|3119->1503|3165->1522|3364->1700|3410->1715|3440->1726|3453->1731|3492->1732|3534->1747|3668->1860|3710->1871|3747->1881|3965->111|3986->124|4056->58|4087->164|4118->2068|4149->2073|4164->2080|4219->2126|4258->2127|4281->2132|4319->2133|4352->2139|4594->2354|4634->2373|4711->2423|4808->2510|4848->2511|4898->2533|5168->2776|5265->2851|5323->2881|5731->3262|5790->3312|5829->3313|5903->3360|5996->3431|6058->3474|6071->3479|6110->3480|6184->3527|6256->3578|6330->3621|6400->3663|6810->4046|6949->4163|7007->4193|7128->4286|7273->4408|7332->4438|7617->4695|7754->4809|7813->4839|7934->4932|8075->5050|8134->5080|8890->5808|8928->5836|8978->5847|9045->5886|9084->5903|9151->5938|9214->5973|9456->6193|9515->6223|9824->6504|9840->6510|9878->6526|10182->6798|10225->6812|10283->6851|10322->6852|10356->6858|10421->6895|10437->6901|10484->6926
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|38->14|38->14|39->15|41->17|41->17|41->17|42->18|46->22|46->22|47->23|47->23|47->23|48->24|52->28|52->28|53->29|54->30|56->32|56->32|56->32|57->33|57->33|57->33|58->34|61->37|62->38|62->38|62->38|63->39|66->42|67->43|68->44|68->44|68->44|69->45|72->48|73->49|74->50|81->5|81->5|82->1|84->5|86->57|88->59|88->59|88->59|88->59|90->61|90->61|91->62|97->68|97->68|100->71|100->71|100->71|101->72|106->77|106->77|107->78|114->85|114->85|114->85|115->86|115->86|116->87|116->87|116->87|117->88|117->88|118->89|119->90|127->98|127->98|128->99|130->101|130->101|131->102|136->107|136->107|137->108|139->110|139->110|140->111|158->129|158->129|158->129|159->130|159->130|160->131|161->132|165->136|166->137|173->144|173->144|173->144|179->150|180->151|184->155|184->155|185->156|185->156|185->156|185->156
                  -- GENERATED --
              */
          