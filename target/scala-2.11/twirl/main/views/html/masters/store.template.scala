
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
                            """),_display_(/*21.30*/if(!cat.equals(Category.TENTS))/*21.61*/ {_display_(Seq[Any](format.raw/*21.63*/("""
                                """),format.raw/*22.33*/("""<a href="#"""),_display_(/*22.44*/cat),format.raw/*22.47*/("""">
                                    <span>"""),_display_(/*23.44*/Messages(cat.toString())),format.raw/*23.68*/("""</span>
                                </a>
                            """)))}),format.raw/*25.30*/("""
                        """),format.raw/*26.25*/("""</li>
                    """)))}),format.raw/*27.22*/("""
                """),format.raw/*28.17*/("""</ul>
            </section>
                <!-- /.sidebar -->
        </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
                <!-- Main content -->
            <section class="content">
                """),_display_(/*37.18*/content),format.raw/*37.25*/("""
            """),format.raw/*38.13*/("""</section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->

""")))}/*42.2*/ {_display_(Seq[Any](format.raw/*42.4*/("""
    """),format.raw/*43.5*/("""<!-- Datepicker for bootstrap -->
    <script src='"""),_display_(/*44.19*/routes/*44.25*/.Assets.at("js/bootstrap-datepicker.js")),format.raw/*44.65*/("""' type='text/javascript'></script>
    <script src='"""),_display_(/*45.19*/routes/*45.25*/.Assets.at("js/bootstrap-datepicker.sk.js")),format.raw/*45.68*/("""' type='text/javascript'></script>
    """),_display_(/*46.6*/javascripts),format.raw/*46.17*/("""
""")))}))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Aug 19 09:55:17 UTC 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/store.scala.html
                  HASH: 25a5ee6ce8307fc13ac673a667f33dafb36ea44f
                  MATRIX: 746->1|903->70|931->73|945->80|965->92|1004->94|1035->99|1112->150|1126->156|1179->189|1247->232|1278->243|1297->245|1335->247|1367->253|1935->794|1980->823|2020->825|2073->850|2134->884|2174->915|2214->917|2275->950|2313->961|2337->964|2410->1010|2455->1034|2560->1108|2613->1133|2671->1160|2716->1177|3037->1471|3065->1478|3106->1491|3222->1589|3261->1591|3293->1596|3372->1648|3387->1654|3448->1694|3528->1747|3543->1753|3607->1796|3673->1836|3705->1847
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|33->5|33->5|33->5|34->6|34->6|35->7|35->7|37->9|47->19|47->19|47->19|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|53->25|54->26|55->27|56->28|65->37|65->37|66->38|70->42|70->42|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46
                  -- GENERATED --
              */
          