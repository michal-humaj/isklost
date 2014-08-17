
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
            """),_display_(/*33.14*/inputText(
                field("amount"),
                'type -> "number", 'class -> "form-control amountInput", 'min -> "1", 'required -> "true"
            )),format.raw/*36.14*/("""
        """)))}/*37.10*/else/*37.14*/{_display_(Seq[Any](format.raw/*37.15*/("""
            """),_display_(/*38.14*/inputText(
                field("amount"),
                'class -> "form-control amountInput"
            )),format.raw/*41.14*/("""
        """)))}),format.raw/*42.10*/("""
        """),format.raw/*43.9*/("""</td>
        <td>
            <button type="button" class="btn btn-danger removeEntry">
                <i class="fa fa-times"></i>
            </button>
        </td>
    </tr>
""")))};implicit def /*5.2*/implicitField/*5.15*/ = {{ FieldConstructor(plainElement.f) }};
Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*5.55*/("""

"""),format.raw/*50.2*/("""

"""),_display_(/*52.2*/masters/*52.9*/.calendar("IS Klost | " + Messages(eventType))/*52.55*/{_display_(Seq[Any](format.raw/*52.56*/("""

""")))}/*54.2*/{_display_(Seq[Any](format.raw/*54.3*/("""
    """),format.raw/*55.5*/("""<div class="row">
        <div class="col-md-12">

            <div class="box box-solid box-primary" style="width:960px;">

                <div class="box-header">
                    <h3 class="box-title">"""),_display_(/*61.44*/Messages(eventType)),format.raw/*61.63*/("""</h3>
                </div>

                """),_display_(/*64.18*/form(routes.Kalendar.update(eventType, id), 'id -> "form", 'class -> "form-horizontal")/*64.105*/{_display_(Seq[Any](format.raw/*64.106*/("""
                    """),format.raw/*65.21*/("""<div class="box-body">

                        <div class="form-group">
                            <label class="col-sm-1 control-label">Názov</label>
                            <div class="col-sm-11">
                                """),_display_(/*70.34*/inputText(eventForm("name"), 'class -> "form-control", 'required -> "true")),format.raw/*70.109*/("""
                            """),format.raw/*71.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label"></label>
                            <div class="col-sm-11">
                                <div class="checkbox">
                                    <label id="checkboxAllDay">
                                        """),_display_(/*78.42*/if(eventForm.apply("allDay").value.equals("true"))/*78.92*/{_display_(Seq[Any](format.raw/*78.93*/("""
                                            """),_display_(/*79.46*/inputText(eventForm("allDay"), 'type -> "checkbox", 'checked -> "true")),format.raw/*79.117*/("""
                                        """)))}/*80.42*/else/*80.47*/{_display_(Seq[Any](format.raw/*80.48*/("""
                                            """),_display_(/*81.46*/inputText(eventForm("allDay"), 'type -> "checkbox")),format.raw/*81.97*/("""
                                        """)))}),format.raw/*82.42*/("""
                                        """),format.raw/*83.41*/("""Celý deň
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Začiatok</label>
                            <div class="col-sm-3">
                                """),_display_(/*91.34*/inputText(eventForm("startDate"), 'id -> "startDate", 'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*91.151*/("""
                            """),format.raw/*92.29*/("""</div>
                            <div class="col-sm-2">
                                """),_display_(/*94.34*/inputText(eventForm("startTime"), 'id -> "timeInputStart", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*94.156*/("""
                            """),format.raw/*95.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Koniec</label>
                            <div class="col-sm-3">
                                """),_display_(/*100.34*/inputText(eventForm("endDate"), 'id -> "endDate",  'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*100.148*/("""
                            """),format.raw/*101.29*/("""</div>
                            <div class="col-sm-2">
                                """),_display_(/*103.34*/inputText(eventForm("endTime"), 'id -> "timeInputEnd", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*103.152*/("""
                            """),format.raw/*104.29*/("""</div>
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
                                """),_display_(/*122.34*/repeat(eventForm("entries"))/*122.62*/ { entry =>_display_(Seq[Any](format.raw/*122.73*/("""
                                    """),_display_(/*123.38*/entryGroup(entry)),format.raw/*123.55*/("""
                                """)))}),format.raw/*124.34*/("""
                                """),_display_(/*125.34*/entryGroup(
                                    eventForm("entries[x]"),
                                    "entryGroupTemplate",
                                    "display:none;"
                                )),format.raw/*129.34*/("""
                            """),format.raw/*130.29*/("""</tbody>
                        </table>
                    </div>

                    <div class="box-footer">

                        <button type="submit" class="btn btn-primary">Uložiť</button>
                        <a type="button" class="btn btn-default" href=""""),_display_(/*137.73*/routes/*137.79*/.Kalendar.list()),format.raw/*137.95*/("""">Späť</a>
                        <button type="button" style="margin-right: -2px;" class="pull-right btn btn-info" id="addEntry">
                            <i class="fa fa-plus"></i>
                        </button>

                    </div>
                """)))}),format.raw/*143.18*/("""
            """),format.raw/*144.13*/("""</div>

        </div>
    </div>
""")))}/*148.2*/{_display_(Seq[Any](format.raw/*148.3*/("""
    """),format.raw/*149.5*/("""<script type="text/javascript" src='"""),_display_(/*149.42*/routes/*149.48*/.Assets.at("js/event.js")),format.raw/*149.73*/("""'></script>
""")))}))}
  }

  def render(eventType:String,id:String,eventForm:Form[EventTO]): play.twirl.api.HtmlFormat.Appendable = apply(eventType)(id)(eventForm)

  def f:((String) => (String) => (Form[EventTO]) => play.twirl.api.HtmlFormat.Appendable) = (eventType) => (id) => (eventForm) => apply(eventType)(id)(eventForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 23:37:31 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/events/eventEdit.scala.html
                  HASH: c4f98c40b197f173a933bdc9fd7d80183509f785
                  MATRIX: 755->1|926->169|944->179|1092->251|1124->257|1162->269|1191->278|1227->288|1252->293|1306->320|1494->499|1536->520|1573->530|1630->560|1659->580|1699->582|1741->597|1983->830|2025->851|2055->862|2068->866|2107->867|2149->882|2370->1094|2412->1115|2454->1126|2491->1136|2548->1166|2577->1186|2617->1188|2659->1203|2846->1369|2876->1380|2889->1384|2928->1385|2970->1400|3104->1513|3146->1524|3183->1534|3401->111|3422->124|3492->58|3523->164|3554->1721|3585->1726|3600->1733|3655->1779|3694->1780|3717->1785|3755->1786|3788->1792|4030->2007|4070->2026|4147->2076|4244->2163|4284->2164|4334->2186|4604->2429|4701->2504|4759->2534|5167->2915|5226->2965|5265->2966|5339->3013|5432->3084|5494->3127|5507->3132|5546->3133|5620->3180|5692->3231|5766->3274|5836->3316|6246->3699|6385->3816|6443->3846|6563->3939|6707->4061|6765->4091|7050->4348|7187->4462|7246->4492|7367->4585|7508->4703|7567->4733|8323->5461|8361->5489|8411->5500|8478->5539|8517->5556|8584->5591|8647->5626|8889->5846|8948->5876|9257->6157|9273->6163|9311->6179|9615->6451|9658->6465|9716->6504|9755->6505|9789->6511|9854->6548|9870->6554|9917->6579
                  LINES: 26->1|29->7|29->7|31->7|32->8|32->8|32->8|32->8|32->8|34->10|38->14|38->14|39->15|41->17|41->17|41->17|42->18|46->22|46->22|47->23|47->23|47->23|48->24|52->28|52->28|53->29|54->30|56->32|56->32|56->32|57->33|60->36|61->37|61->37|61->37|62->38|65->41|66->42|67->43|74->5|74->5|75->1|77->5|79->50|81->52|81->52|81->52|81->52|83->54|83->54|84->55|90->61|90->61|93->64|93->64|93->64|94->65|99->70|99->70|100->71|107->78|107->78|107->78|108->79|108->79|109->80|109->80|109->80|110->81|110->81|111->82|112->83|120->91|120->91|121->92|123->94|123->94|124->95|129->100|129->100|130->101|132->103|132->103|133->104|151->122|151->122|151->122|152->123|152->123|153->124|154->125|158->129|159->130|166->137|166->137|166->137|172->143|173->144|177->148|177->148|178->149|178->149|178->149|178->149
                  -- GENERATED --
              */
          