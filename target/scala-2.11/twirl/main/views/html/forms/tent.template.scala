
package views.html.forms

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
object tent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[Tent],String,play.api.mvc.Call,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tentForm: Form[Tent])(title: String)(call: play.api.mvc.Call)(heading: String)(submitLabel: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import views.html.helpers._
def /*7.2*/accessoryGroup/*7.16*/(field: Field, className: String = "accessoryGroup", style: String = ""):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.92*/("""
    """),format.raw/*8.5*/("""<tr class=""""),_display_(/*8.17*/className),format.raw/*8.26*/("""" style=""""),_display_(/*8.36*/style),format.raw/*8.41*/("""">
        <td>
            """),_display_(/*10.14*/select(
                field("item.category"),
                options(Category.tentOptions),
                'id -> "categorySelect0", 'class -> "form-control categorySelect"
            )/*14.14*/(implicitField, null)),format.raw/*14.35*/("""
        """),format.raw/*15.9*/("""</td>
        <td>
            """),_display_(/*17.14*/if(style.equals(""))/*17.34*/ {_display_(Seq[Any](format.raw/*17.36*/("""
                """),_display_(/*18.18*/select(
                    field("item.id"),
                    options(Item.getMapOfItemsForCategory( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect", 'required -> "true"
                )/*22.18*/(implicitField, null)),format.raw/*22.39*/("""
            """)))}/*23.14*/else/*23.18*/{_display_(Seq[Any](format.raw/*23.19*/("""
                """),_display_(/*24.18*/select(
                    field("item.id"),
                    options(Item.getMapOfItemsForCategory( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect"
                )/*28.18*/(implicitField, null)),format.raw/*28.39*/("""
            """)))}),format.raw/*29.14*/("""
        """),format.raw/*30.9*/("""</td>
        <td>
            """),_display_(/*32.14*/if(style.equals(""))/*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
                """),_display_(/*33.18*/inputText(
                    field("amount"),
                    'type -> "number", 'class -> "form-control amountInput", 'min -> "1", 'required -> "true"
                )),format.raw/*36.18*/("""
            """)))}/*37.14*/else/*37.18*/{_display_(Seq[Any](format.raw/*37.19*/("""
                """),_display_(/*38.18*/inputText(
                    field("amount"),
                    'class -> "form-control amountInput"
                )),format.raw/*41.18*/("""
            """)))}),format.raw/*42.14*/("""
        """),format.raw/*43.9*/("""</td>
        <td>
            <button type="button" class="btn btn-danger removeAccessory">
                <i class="fa fa-times"></i>
            </button>
        </td>
    </tr>
""")))};implicit def /*5.2*/implicitField/*5.15*/ = {{ FieldConstructor(plainElement.f) }};
Seq[Any](format.raw/*1.102*/("""

"""),format.raw/*5.55*/("""

"""),format.raw/*50.2*/("""

"""),_display_(/*52.2*/masters/*52.9*/.tents(title)/*52.22*/{_display_(Seq[Any](format.raw/*52.23*/("""

""")))}/*54.2*/{_display_(Seq[Any](format.raw/*54.3*/("""
    """),format.raw/*55.5*/("""<div class="row">
        <div class="col-md-12">

        """),_display_(/*58.10*/form(call, 'id -> "form", 'class -> "form-horizontal")/*58.64*/{_display_(Seq[Any](format.raw/*58.65*/("""

            """),format.raw/*60.13*/("""<div class="box box-solid box-primary" style="width:960px;">
                <div class="box-header">
                    <h3 class="box-title">"""),_display_(/*62.44*/heading),format.raw/*62.51*/("""</h3>
                </div>
                <div class="box-body">
                    """),_display_(/*65.22*/inputText(tentForm("name"), '_label -> "Názov", 'class -> "form-control", 'placeholder -> "Názov stanu", 'required -> "true")),format.raw/*65.147*/("""
                    """),format.raw/*66.21*/("""<hr>
                    <h4>Položky stanu</h4>
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
                            """),_display_(/*80.30*/repeat(tentForm("accessories"))/*80.61*/ { accessory =>_display_(Seq[Any](format.raw/*80.76*/("""
                                """),_display_(/*81.34*/accessoryGroup(accessory)),format.raw/*81.59*/("""
                            """)))}),format.raw/*82.30*/("""
                            """),_display_(/*83.30*/accessoryGroup(
                                tentForm("accessories[x]"),
                                "accessoryGroupTemplate",
                                "display:none;"
                            )),format.raw/*87.30*/("""
                        """),format.raw/*88.25*/("""</tbody>
                    </table>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">"""),_display_(/*92.68*/submitLabel),format.raw/*92.79*/("""</button>
                    <a type="button" class="btn btn-default" href=""""),_display_(/*93.69*/routes/*93.75*/.Tents.list()),format.raw/*93.88*/("""" >Späť</a>
                    <button type="button" style="margin-right: -2px;" class="pull-right btn btn-info" id="addAccessory">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>

            </div>

        """)))}),format.raw/*101.10*/("""

        """),format.raw/*103.9*/("""</div>
    </div>
""")))}/*105.2*/{_display_(Seq[Any](format.raw/*105.3*/("""
    """),format.raw/*106.5*/("""<script type="text/javascript" src='"""),_display_(/*106.42*/routes/*106.48*/.Assets.at("js/tents.js")),format.raw/*106.73*/("""'></script>
""")))}))}
  }

  def render(tentForm:Form[Tent],title:String,call:play.api.mvc.Call,heading:String,submitLabel:String): play.twirl.api.HtmlFormat.Appendable = apply(tentForm)(title)(call)(heading)(submitLabel)

  def f:((Form[Tent]) => (String) => (play.api.mvc.Call) => (String) => (String) => play.twirl.api.HtmlFormat.Appendable) = (tentForm) => (title) => (call) => (heading) => (submitLabel) => apply(tentForm)(title)(call)(heading)(submitLabel)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Oct 01 17:51:44 UTC 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/tent.scala.html
                  HASH: 90ac39e7ccb8dc6548ab25e33191eb6311efbc8f
                  MATRIX: 771->1|985->212|1007->226|1159->302|1191->308|1229->320|1258->329|1294->339|1319->344|1377->375|1580->569|1622->590|1659->600|1720->634|1749->654|1789->656|1835->675|2110->941|2152->962|2186->977|2199->981|2238->982|2284->1001|2538->1246|2580->1267|2626->1282|2663->1292|2724->1326|2753->1346|2793->1348|2839->1367|3038->1545|3072->1560|3085->1564|3124->1565|3170->1584|3316->1709|3362->1724|3399->1734|3621->154|3642->167|3713->101|3744->207|3775->1925|3806->1930|3821->1937|3843->1950|3882->1951|3905->1956|3943->1957|3976->1963|4066->2026|4129->2080|4168->2081|4212->2097|4386->2244|4414->2251|4533->2343|4680->2468|4730->2490|5358->3091|5398->3122|5451->3137|5513->3172|5559->3197|5621->3228|5679->3259|5915->3474|5969->3500|6169->3673|6201->3684|6307->3763|6322->3769|6356->3782|6663->4057|6703->4069|6743->4090|6782->4091|6816->4097|6881->4134|6897->4140|6944->4165
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|38->14|38->14|39->15|41->17|41->17|41->17|42->18|46->22|46->22|47->23|47->23|47->23|48->24|52->28|52->28|53->29|54->30|56->32|56->32|56->32|57->33|60->36|61->37|61->37|61->37|62->38|65->41|66->42|67->43|74->5|74->5|75->1|77->5|79->50|81->52|81->52|81->52|81->52|83->54|83->54|84->55|87->58|87->58|87->58|89->60|91->62|91->62|94->65|94->65|95->66|109->80|109->80|109->80|110->81|110->81|111->82|112->83|116->87|117->88|121->92|121->92|122->93|122->93|122->93|130->101|132->103|134->105|134->105|135->106|135->106|135->106|135->106
                  -- GENERATED --
              */
          