
package views.html

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
object calendar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/masters/*1.9*/.calendar("IS Klost | Kalendár")/*1.41*/{_display_(Seq[Any](format.raw/*1.42*/("""
    """),format.raw/*2.5*/("""<!-- fullCalendar -->
    <link href='"""),_display_(/*3.18*/routes/*3.24*/.Assets.at("css/fullcalendar/fullcalendar.css")),format.raw/*3.71*/("""' rel="stylesheet" type="text/css" />
    <link href='"""),_display_(/*4.18*/routes/*4.24*/.Assets.at("css/fullcalendar/fullcalendar.print.css")),format.raw/*4.77*/("""' rel="stylesheet" type="text/css" media='print' />
""")))}/*5.2*/{_display_(Seq[Any](format.raw/*5.3*/("""
    """),format.raw/*6.5*/("""<div class="modal" id="modal-event-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>

    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body no-padding">
                    <!-- FULL CALENDAR -->
                    <div id="calendar"></div>
                </div>
            </div>
        </div>
    </div>

    <div id="newEventPopover" class="hide">
        """),_display_(/*20.10*/forms/*20.15*/.newEventPopover()),format.raw/*20.33*/("""
    """),format.raw/*21.5*/("""</div>
    <div id="eventClickPopover" class="hide">
        """),_display_(/*23.10*/forms/*23.15*/.eventClickPopover()),format.raw/*23.35*/("""
    """),format.raw/*24.5*/("""</div>
    <div id="selectActionGroup" class="hide">
        <div class="form-group">
            <div class="col-sm-12">
                <select name="actionId" class="form-control selectAction" required="true">
                </select>
            </div>
        </div>
    </div>

""")))}/*34.2*/{_display_(Seq[Any](format.raw/*34.3*/("""
    """),format.raw/*35.5*/("""<!---------------------JAVASCRIPTS-------------------------------------------------------------->
    <script src='"""),_display_(/*36.19*/routes/*36.25*/.Assets.at("js/jquery-ui-1.10.3.min.js")),format.raw/*36.65*/("""' type="text/javascript"></script>
    <!-- fullCalendar -->
    <script src='"""),_display_(/*38.19*/routes/*38.25*/.Assets.at("js/plugins/fullcalendar/fullcalendar.min.js")),format.raw/*38.82*/("""' type="text/javascript"></script>
    <script src='"""),_display_(/*39.19*/routes/*39.25*/.Assets.at("js/plugins/fullcalendar/gcal.js")),format.raw/*39.70*/("""' type='text/javascript'></script>
    <script type="text/javascript" src='"""),_display_(/*40.42*/routes/*40.48*/.Assets.at("js/calendar.js")),format.raw/*40.76*/("""'></script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 15:03:25 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/calendar.scala.html
                  HASH: a33ea8347e4547635dfd24908ab0a8ca89bb7b05
                  MATRIX: 801->1|815->8|855->40|893->41|925->47|991->87|1005->93|1072->140|1154->196|1168->202|1241->255|1312->309|1349->310|1381->316|1908->816|1922->821|1961->839|1994->845|2085->909|2099->914|2140->934|2173->940|2487->1236|2525->1237|2558->1243|2702->1360|2717->1366|2778->1406|2886->1487|2901->1493|2979->1550|3060->1604|3075->1610|3141->1655|3245->1732|3260->1738|3309->1766
                  LINES: 29->1|29->1|29->1|29->1|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|34->6|48->20|48->20|48->20|49->21|51->23|51->23|51->23|52->24|62->34|62->34|63->35|64->36|64->36|64->36|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40
                  -- GENERATED --
              */
          