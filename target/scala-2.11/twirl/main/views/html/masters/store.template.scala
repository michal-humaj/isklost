
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
object store extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

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
            <section class="sidebar" id="scroll-target">
                    <!-- Inline datepicker -->
                <div id="datepicker"></div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu nav">
                    """),_display_(/*19.22*/for(cat <- Category.values()) yield /*19.51*/ {_display_(Seq[Any](format.raw/*19.53*/("""
                        """),format.raw/*20.25*/("""<li>
                            <a href="#"""),_display_(/*21.40*/cat),format.raw/*21.43*/("""">
                                <span>"""),_display_(/*22.40*/Messages(cat.toString())),format.raw/*22.64*/("""</span>
                            </a>
                        </li>
                    """)))}),format.raw/*25.22*/("""
                """),format.raw/*26.17*/("""</ul>
            </section>
                <!-- /.sidebar -->
        </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
                <!-- Main content -->
            <section class="content">
                """),_display_(/*35.18*/content),format.raw/*35.25*/("""
            """),format.raw/*36.13*/("""</section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->

""")))}/*40.2*/ {_display_(Seq[Any](format.raw/*40.4*/("""
    """),format.raw/*41.5*/("""<!-- Datepicker for bootstrap -->
    <script src='"""),_display_(/*42.19*/routes/*42.25*/.Assets.at("js/bootstrap-datepicker.js")),format.raw/*42.65*/("""' type='text/javascript'></script>
    <script src='"""),_display_(/*43.19*/routes/*43.25*/.Assets.at("js/bootstrap-datepicker.sk.js")),format.raw/*43.68*/("""' type='text/javascript'></script>
    """),_display_(/*44.6*/javascripts),format.raw/*44.17*/("""
""")))}))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 00:00:22 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/store.scala.html
                  HASH: b0b93f91b2e6b90a4f6372c681f2c0f50ea99f95
                  MATRIX: 746->1|903->70|931->73|945->80|965->92|1004->94|1035->99|1112->150|1126->156|1179->189|1247->232|1278->243|1297->245|1335->247|1367->253|1935->794|1980->823|2020->825|2073->850|2144->894|2168->897|2237->939|2282->963|2405->1055|2450->1072|2771->1366|2799->1373|2840->1386|2956->1484|2995->1486|3027->1491|3106->1543|3121->1549|3182->1589|3262->1642|3277->1648|3341->1691|3407->1731|3439->1742
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|33->5|33->5|33->5|34->6|34->6|35->7|35->7|37->9|47->19|47->19|47->19|48->20|49->21|49->21|50->22|50->22|53->25|54->26|63->35|63->35|64->36|68->40|68->40|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44
                  -- GENERATED --
              */
          