
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
object installationEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Form[EventTO],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String)(id: String)(eventForm: Form[EventTO]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import views.html.helpers._
implicit def /*5.2*/implicitField/*5.15*/ = {{ FieldConstructor(plainElement.f) }};
Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*5.55*/("""

"""),_display_(/*7.2*/masters/*7.9*/.calendar("IS Klost | Montáž")/*7.39*/{_display_(Seq[Any](format.raw/*7.40*/("""

""")))}/*9.2*/{_display_(Seq[Any](format.raw/*9.3*/("""
    """),format.raw/*10.5*/("""<div class="row">
        <div class="col-md-12">

            <div class="box box-solid box-primary" style="width:960px;">

                <div class="box-header">
                    <h3 class="box-title">Montáž</h3>
                </div>

                """),_display_(/*19.18*/form(routes.Kalendar.update(eventType, id), 'id -> "form", 'class -> "form-horizontal")/*19.105*/{_display_(Seq[Any](format.raw/*19.106*/("""
                    """),format.raw/*20.21*/("""<div class="box-body">

                        <div class="form-group">
                            <label class="col-sm-1 control-label">Názov</label>
                            <div class="col-sm-11">
                            """),_display_(/*25.30*/inputText(eventForm("name"), 'class -> "form-control", 'required -> "true")),format.raw/*25.105*/("""
                            """),format.raw/*26.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label"></label>
                            <div class="col-sm-11">
                                <div class="checkbox">
                                    <label id="checkboxAllDay">
                                        """),_display_(/*33.42*/if(eventForm.apply("allDay").value.equals("true"))/*33.92*/{_display_(Seq[Any](format.raw/*33.93*/("""
                                            """),_display_(/*34.46*/inputText(eventForm("allDay"), 'type -> "checkbox", 'checked -> "true")),format.raw/*34.117*/("""
                                        """)))}/*35.42*/else/*35.47*/{_display_(Seq[Any](format.raw/*35.48*/("""
                                            """),_display_(/*36.46*/inputText(eventForm("allDay"), 'type -> "checkbox")),format.raw/*36.97*/("""
                                        """)))}),format.raw/*37.42*/("""
                                        """),format.raw/*38.41*/("""Celý deň
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Začiatok</label>
                            <div class="col-sm-3">
                            """),_display_(/*46.30*/inputText(eventForm("startDate"), 'id -> "startDate", 'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*46.147*/("""
                            """),format.raw/*47.29*/("""</div>
                            <div class="col-sm-2">
                            """),_display_(/*49.30*/inputText(eventForm("startTime"), 'id -> "timeInputStart", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*49.152*/("""
                            """),format.raw/*50.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Koniec</label>
                            <div class="col-sm-3">
                            """),_display_(/*55.30*/inputText(eventForm("endDate"), 'id -> "endDate",  'type -> "date", 'class -> "form-control", 'required -> "true")),format.raw/*55.144*/("""
                            """),format.raw/*56.29*/("""</div>
                            <div class="col-sm-2">
                            """),_display_(/*58.30*/inputText(eventForm("endTime"), 'id -> "timeInputEnd", 'type -> "time", 'class -> "form-control", 'required -> "true")),format.raw/*58.148*/("""
                            """),format.raw/*59.29*/("""</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Ku akcii</label>
                            <div class="col-sm-5">
                                """),_display_(/*64.34*/select(
                                    eventForm("actionId"),
                                    options(Kalendar.options),
                                    'class -> "form-control", 'required -> "true"
                                )),format.raw/*68.34*/("""
                            """),format.raw/*69.29*/("""</div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Uložiť</button>
                        <a type="button" class="btn btn-default" href=""""),_display_(/*74.73*/routes/*74.79*/.Kalendar.list()),format.raw/*74.95*/("""">Späť</a>
                    </div>
                """)))}),format.raw/*76.18*/("""
            """),format.raw/*77.13*/("""</div>

        </div>
    </div>
""")))}/*81.2*/{_display_(Seq[Any](format.raw/*81.3*/("""
    """),format.raw/*82.5*/("""<script type="text/javascript" src='"""),_display_(/*82.42*/routes/*82.48*/.Assets.at("js/event.js")),format.raw/*82.73*/("""'></script>
""")))}))}
  }

  def render(eventType:String,id:String,eventForm:Form[EventTO]): play.twirl.api.HtmlFormat.Appendable = apply(eventType)(id)(eventForm)

  def f:((String) => (String) => (Form[EventTO]) => play.twirl.api.HtmlFormat.Appendable) = (eventType) => (id) => (eventForm) => apply(eventType)(id)(eventForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Sep 18 17:11:22 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/events/installationEdit.scala.html
                  HASH: 8fd2777120bff0a86c7656ecc93cbf46fe3f62ed
                  MATRIX: 762->1|942->111|963->124|1033->58|1064->164|1094->169|1108->176|1146->206|1184->207|1206->212|1243->213|1276->219|1573->489|1670->576|1710->577|1760->599|2026->838|2123->913|2181->943|2589->1324|2648->1374|2687->1375|2761->1422|2854->1493|2916->1536|2929->1541|2968->1542|3042->1589|3114->1640|3188->1683|3258->1725|3664->2104|3803->2221|3861->2251|3977->2340|4121->2462|4179->2492|4459->2745|4595->2859|4653->2889|4769->2978|4909->3096|4967->3126|5253->3385|5523->3634|5581->3664|5881->3937|5896->3943|5933->3959|6021->4016|6063->4030|6120->4069|6158->4070|6191->4076|6255->4113|6270->4119|6316->4144
                  LINES: 26->1|29->5|29->5|30->1|32->5|34->7|34->7|34->7|34->7|36->9|36->9|37->10|46->19|46->19|46->19|47->20|52->25|52->25|53->26|60->33|60->33|60->33|61->34|61->34|62->35|62->35|62->35|63->36|63->36|64->37|65->38|73->46|73->46|74->47|76->49|76->49|77->50|82->55|82->55|83->56|85->58|85->58|86->59|91->64|95->68|96->69|101->74|101->74|101->74|103->76|104->77|108->81|108->81|109->82|109->82|109->82|109->82
                  -- GENERATED --
              */
          