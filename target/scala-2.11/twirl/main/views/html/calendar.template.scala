
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
import com.feth.play.module.pa.views.html._
/**/
object calendar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*2.2*/masters/*2.9*/.calendar("IS Klost | Kalendár")/*2.41*/{_display_(Seq[Any](format.raw/*2.42*/("""
    """),format.raw/*3.5*/("""<!-- fullCalendar -->
    <link href='"""),_display_(/*4.18*/routes/*4.24*/.Assets.at("css/fullcalendar/fullcalendar.css")),format.raw/*4.71*/("""' rel="stylesheet" type="text/css" />
    <link href='"""),_display_(/*5.18*/routes/*5.24*/.Assets.at("css/fullcalendar/fullcalendar.print.css")),format.raw/*5.77*/("""' rel="stylesheet" type="text/css" media='print' />
""")))}/*6.2*/{_display_(Seq[Any](format.raw/*6.3*/("""
    """),format.raw/*7.5*/("""<div class="modal" id="modal-event-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>

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
        """),_display_(/*21.10*/forms/*21.15*/.newEventPopover()),format.raw/*21.33*/("""
    """),format.raw/*22.5*/("""</div>
    <div id="eventClickPopover" class="hide">
        """),_display_(/*24.10*/forms/*24.15*/.eventClickPopover()),format.raw/*24.35*/("""
    """),format.raw/*25.5*/("""</div>
    <div id="selectActionGroup" class="hide">
        <div class="form-group">
            <div class="col-sm-12">
                <select name="actionId" class="form-control selectAction" required="true">
                </select>
            </div>
        </div>
    </div>

""")))}/*35.2*/{_display_(Seq[Any](format.raw/*35.3*/("""
    """),format.raw/*36.5*/("""<!---------------------JAVASCRIPTS-------------------------------------------------------------->
    <script src='"""),_display_(/*37.19*/routes/*37.25*/.Assets.at("js/jquery-ui-1.10.3.min.js")),format.raw/*37.65*/("""' type="text/javascript"></script>
    <!-- fullCalendar -->
    <script src='"""),_display_(/*39.19*/routes/*39.25*/.Assets.at("js/plugins/fullcalendar/fullcalendar.min.js")),format.raw/*39.82*/("""' type="text/javascript"></script>
    <script src='"""),_display_(/*40.19*/routes/*40.25*/.Assets.at("js/plugins/fullcalendar/gcal.js")),format.raw/*40.70*/("""' type='text/javascript'></script>
    """),_display_(/*41.6*/currentAuth()/*41.19*/ { auth =>_display_(Seq[Any](format.raw/*41.29*/("""
        """),_display_(/*42.10*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*42.56*/ {_display_(Seq[Any](format.raw/*42.58*/("""
            """),format.raw/*43.13*/("""<script type="text/javascript" src='"""),_display_(/*43.50*/routes/*43.56*/.Assets.at("js/calendar.js")),format.raw/*43.84*/("""'></script>
        """)))}/*44.11*/else/*44.16*/{_display_(Seq[Any](format.raw/*44.17*/("""
            """),format.raw/*45.13*/("""<script type="text/javascript" src='"""),_display_(/*45.50*/routes/*45.56*/.Assets.at("js/storeman/calendar.js")),format.raw/*45.93*/("""'></script>
        """)))}),format.raw/*46.10*/("""
    """)))}),format.raw/*47.6*/("""

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Sep 18 17:11:21 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/calendar.scala.html
                  HASH: fb0b4de739445232cd38fc619254998bdc427a68
                  MATRIX: 844->47|858->54|898->86|936->87|968->93|1034->133|1048->139|1115->186|1197->242|1211->248|1284->301|1355->355|1392->356|1424->362|1951->862|1965->867|2004->885|2037->891|2128->955|2142->960|2183->980|2216->986|2530->1282|2568->1283|2601->1289|2745->1406|2760->1412|2821->1452|2929->1533|2944->1539|3022->1596|3103->1650|3118->1656|3184->1701|3251->1742|3273->1755|3321->1765|3359->1776|3414->1822|3454->1824|3496->1838|3560->1875|3575->1881|3624->1909|3665->1932|3678->1937|3717->1938|3759->1952|3823->1989|3838->1995|3896->2032|3949->2054|3986->2061
                  LINES: 29->2|29->2|29->2|29->2|30->3|31->4|31->4|31->4|32->5|32->5|32->5|33->6|33->6|34->7|48->21|48->21|48->21|49->22|51->24|51->24|51->24|52->25|62->35|62->35|63->36|64->37|64->37|64->37|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|70->43|70->43|71->44|71->44|71->44|72->45|72->45|72->45|72->45|73->46|74->47
                  -- GENERATED --
              */
          