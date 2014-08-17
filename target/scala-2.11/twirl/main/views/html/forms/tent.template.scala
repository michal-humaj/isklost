
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
                    options(Item.options( field("item.category").value.toString)),
                    'id -> "itemSelect0", 'class -> "form-control itemSelect", 'required -> "true"
                )/*22.18*/(implicitField, null)),format.raw/*22.39*/("""
            """)))}/*23.14*/else/*23.18*/{_display_(Seq[Any](format.raw/*23.19*/("""
                """),_display_(/*24.18*/select(
                    field("item.id"),
                    options(Item.options( field("item.category").value.toString)),
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
                  DATE: Sun Aug 17 22:21:35 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/tent.scala.html
                  HASH: b0fc5e12705390b68543e9c555cfee91589af9d6
                  MATRIX: 771->1|985->212|1007->226|1159->302|1191->308|1229->320|1258->329|1294->339|1319->344|1377->375|1580->569|1622->590|1659->600|1720->634|1749->654|1789->656|1835->675|2093->924|2135->945|2169->960|2182->964|2221->965|2267->984|2504->1212|2546->1233|2592->1248|2629->1258|2690->1292|2719->1312|2759->1314|2805->1333|3004->1511|3038->1526|3051->1530|3090->1531|3136->1550|3282->1675|3328->1690|3365->1700|3587->154|3608->167|3679->101|3710->207|3741->1891|3772->1896|3787->1903|3809->1916|3848->1917|3871->1922|3909->1923|3942->1929|4032->1992|4095->2046|4134->2047|4178->2063|4352->2210|4380->2217|4499->2309|4646->2434|4696->2456|5324->3057|5364->3088|5417->3103|5479->3138|5525->3163|5587->3194|5645->3225|5881->3440|5935->3466|6135->3639|6167->3650|6273->3729|6288->3735|6322->3748|6629->4023|6669->4035|6709->4056|6748->4057|6782->4063|6847->4100|6863->4106|6910->4131
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|38->14|38->14|39->15|41->17|41->17|41->17|42->18|46->22|46->22|47->23|47->23|47->23|48->24|52->28|52->28|53->29|54->30|56->32|56->32|56->32|57->33|60->36|61->37|61->37|61->37|62->38|65->41|66->42|67->43|74->5|74->5|75->1|77->5|79->50|81->52|81->52|81->52|81->52|83->54|83->54|84->55|87->58|87->58|87->58|89->60|91->62|91->62|94->65|94->65|95->66|109->80|109->80|109->80|110->81|110->81|111->82|112->83|116->87|117->88|121->92|121->92|122->93|122->93|122->93|130->101|132->103|134->105|134->105|135->106|135->106|135->106|135->106
                  -- GENERATED --
              */
          