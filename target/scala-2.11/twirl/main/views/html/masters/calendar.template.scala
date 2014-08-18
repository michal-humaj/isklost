
package views.html.masters

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
object calendar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(stylesheets: Html)(content: Html)(javascripts : Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.71*/("""

"""),_display_(/*3.2*/masters/*3.9*/.main(title)/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),format.raw/*4.5*/("""<!-- Datepicker for bootstrap -->
    <link href='"""),_display_(/*5.18*/routes/*5.24*/.Assets.at("css/datepicker3.css")),format.raw/*5.57*/("""' rel="stylesheet" type="text/css" />
    """),_display_(/*6.6*/stylesheets),format.raw/*6.17*/("""
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""

    """),format.raw/*9.5*/("""<div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
        <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                    <!-- Inline datepicker -->
                <div id="datepicker"></div>

            </section>
                <!-- /.sidebar -->
        </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
                <!-- Main content -->
            <section class="content">
                """),_display_(/*25.18*/content),format.raw/*25.25*/("""
            """),format.raw/*26.13*/("""</section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->

""")))}/*30.2*/ {_display_(Seq[Any](format.raw/*30.4*/("""
    """),format.raw/*31.5*/("""<!-- Datepicker for bootstrap -->
    <script src='"""),_display_(/*32.19*/routes/*32.25*/.Assets.at("js/bootstrap-datepicker.js")),format.raw/*32.65*/("""' type='text/javascript'></script>
    <script src='"""),_display_(/*33.19*/routes/*33.25*/.Assets.at("js/bootstrap-datepicker.sk.js")),format.raw/*33.68*/("""' type='text/javascript'></script>
    """),_display_(/*34.6*/javascripts),format.raw/*34.17*/("""
""")))}))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 15:03:25 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/calendar.scala.html
                  HASH: f43942339ff1cc5f06d10c52a5b1fe97b74fb900
                  MATRIX: 749->1|906->70|934->73|948->80|968->92|1007->94|1038->99|1115->150|1129->156|1182->189|1250->232|1281->243|1300->245|1338->247|1370->253|2060->916|2088->923|2129->936|2245->1034|2284->1036|2316->1041|2395->1093|2410->1099|2471->1139|2551->1192|2566->1198|2630->1241|2696->1281|2728->1292
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|33->5|33->5|33->5|34->6|34->6|35->7|35->7|37->9|53->25|53->25|54->26|58->30|58->30|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34
                  -- GENERATED --
              */
          