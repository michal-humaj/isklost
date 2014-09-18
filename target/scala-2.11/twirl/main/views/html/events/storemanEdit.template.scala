
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
                    options(Item.options( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect", 'required -> "true"
                )/*15.18*/(implicitField, null)),format.raw/*15.39*/("""
            """)))}/*16.14*/else/*16.18*/{_display_(Seq[Any](format.raw/*16.19*/("""
                """),_display_(/*17.18*/select(
                    field("item.id"),
                    options(Item.options( field("item.category").value.toString)),
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
                  DATE: Thu Sep 18 17:11:22 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/events/storemanEdit.scala.html
                  HASH: 3b143f29fc75828960c8aa47cf94802f6ae2bdaa
                  MATRIX: 758->1|929->171|947->181|1095->253|1130->262|1168->274|1197->283|1233->293|1258->298|1318->331|1347->351|1387->353|1432->371|1686->616|1728->637|1761->651|1774->655|1813->656|1858->674|2091->898|2133->919|2178->933|2219->946|2282->982|2311->1002|2351->1004|2396->1022|2612->1217|2645->1231|2658->1235|2697->1236|2742->1254|2885->1376|2930->1390|2971->1403|3210->111|3231->124|3301->58|3329->106|3360->164|3393->1611|3422->1614|3437->1621|3492->1667|3531->1668|3552->1671|3590->1672|3622->1677|3849->1877|3867->1886|3908->1906|4054->2025|4069->2031|4123->2064|4241->2155|4304->2209|4343->2210|4404->2243|4459->2279|4472->2283|4511->2284|4572->2317|4638->2352|4691->2377|4790->2449|4895->2544|4935->2545|4984->2566|5114->2669|5151->2697|5200->2708|5261->2742|5372->2843|5412->2844|5477->2881|5552->2929|5566->2934|5612->2971|5636->2974|5705->3015|5780->3063|5794->3068|5844->3097|5909->3134|5979->3173|6040->3203|6093->3228|6721->3829|6758->3857|6807->3868|6872->3906|6983->4007|7023->4008|7092->4050|7130->4067|7199->4105|7264->4139|7325->4173|7563->4389|7621->4418|7923->4692|7939->4698|7977->4714|8275->4980|8317->4993|8371->5028|8410->5029|8443->5034|8508->5071|8524->5077|8580->5111
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|34->10|34->10|35->11|39->15|39->15|40->16|40->16|40->16|41->17|45->21|45->21|46->22|47->23|49->25|49->25|49->25|50->26|53->29|54->30|54->30|54->30|55->31|58->34|59->35|60->36|67->5|67->5|68->1|70->5|70->5|72->43|74->45|74->45|74->45|74->45|76->47|76->47|77->48|83->54|83->54|83->54|85->56|85->56|85->56|87->58|87->58|87->58|88->59|89->60|89->60|89->60|90->61|91->62|92->63|95->66|95->66|95->66|96->67|98->69|98->69|98->69|99->70|99->70|99->70|100->71|101->72|101->72|101->72|101->72|102->73|103->74|103->74|103->74|104->75|105->76|106->77|107->78|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|125->96|126->97|127->98|131->102|132->103|139->110|139->110|139->110|145->116|146->117|150->121|150->121|151->122|151->122|151->122|151->122
                  -- GENERATED --
              */
          