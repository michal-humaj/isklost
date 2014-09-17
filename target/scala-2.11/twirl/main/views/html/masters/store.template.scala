
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
      _display_ {import com.feth.play.module.pa.views.html._

Seq[Any](format.raw/*1.71*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/masters/*5.9*/.main(title)/*5.21*/ {_display_(Seq[Any](format.raw/*5.23*/("""
    """),format.raw/*6.5*/("""<!-- Datepicker for bootstrap -->
    <link href='"""),_display_(/*7.18*/routes/*7.24*/.Assets.at("css/datepicker3.css")),format.raw/*7.57*/("""' rel="stylesheet" type="text/css" />
    """),_display_(/*8.6*/stylesheets),format.raw/*8.17*/("""
""")))}/*9.2*/ {_display_(Seq[Any](format.raw/*9.4*/("""

    """),format.raw/*11.5*/("""<div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
        <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar" id="scroll-target">
                    <!-- Inline datepicker -->
                """),_display_(/*17.18*/currentAuth()/*17.31*/ { auth =>_display_(Seq[Any](format.raw/*17.41*/("""
                    """),_display_(/*18.22*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*18.68*/ {_display_(Seq[Any](format.raw/*18.70*/("""
                        """),format.raw/*19.25*/("""<div id="datepicker"></div>
                    """)))}),format.raw/*20.22*/("""
                """)))}),format.raw/*21.18*/("""

                    """),format.raw/*23.21*/("""<!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu nav">
                    """),_display_(/*25.22*/for(cat <- Category.values()) yield /*25.51*/ {_display_(Seq[Any](format.raw/*25.53*/("""
                            """),_display_(/*26.30*/if(!cat.equals(Category.TENTS))/*26.61*/ {_display_(Seq[Any](format.raw/*26.63*/("""
                                """),format.raw/*27.33*/("""<li>
                                <a href="#"""),_display_(/*28.44*/cat),format.raw/*28.47*/("""">
                                    <span>"""),_display_(/*29.44*/Messages(cat.toString())),format.raw/*29.68*/("""</span>
                                </a>
                                </li>
                            """)))}),format.raw/*32.30*/("""
                    """)))}),format.raw/*33.22*/("""
                """),format.raw/*34.17*/("""</ul>
            </section>
                <!-- /.sidebar -->
        </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
                <!-- Main content -->
            <section class="content">
                """),_display_(/*43.18*/content),format.raw/*43.25*/("""
            """),format.raw/*44.13*/("""</section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->

""")))}/*48.2*/ {_display_(Seq[Any](format.raw/*48.4*/("""
    """),format.raw/*49.5*/("""<!-- Datepicker for bootstrap -->
    <script src='"""),_display_(/*50.19*/routes/*50.25*/.Assets.at("js/bootstrap-datepicker.js")),format.raw/*50.65*/("""' type='text/javascript'></script>
    <script src='"""),_display_(/*51.19*/routes/*51.25*/.Assets.at("js/bootstrap-datepicker.sk.js")),format.raw/*51.68*/("""' type='text/javascript'></script>
    """),_display_(/*52.6*/javascripts),format.raw/*52.17*/("""
""")))}))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:01 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/store.scala.html
                  HASH: 7644adc81c701d85e1d058a8587b3817798eccb7
                  MATRIX: 746->1|946->70|974->117|1001->119|1015->126|1035->138|1074->140|1105->145|1182->196|1196->202|1249->235|1317->278|1348->289|1367->291|1405->293|1438->299|1831->665|1853->678|1901->688|1950->710|2005->756|2045->758|2098->783|2178->832|2227->850|2277->872|2431->999|2476->1028|2516->1030|2573->1060|2613->1091|2653->1093|2714->1126|2789->1174|2813->1177|2886->1223|2931->1247|3074->1359|3127->1381|3172->1398|3493->1692|3521->1699|3562->1712|3678->1810|3717->1812|3749->1817|3828->1869|3843->1875|3904->1915|3984->1968|3999->1974|4063->2017|4129->2057|4161->2068
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|33->6|34->7|34->7|34->7|35->8|35->8|36->9|36->9|38->11|44->17|44->17|44->17|45->18|45->18|45->18|46->19|47->20|48->21|50->23|52->25|52->25|52->25|53->26|53->26|53->26|54->27|55->28|55->28|56->29|56->29|59->32|60->33|61->34|70->43|70->43|71->44|75->48|75->48|76->49|77->50|77->50|77->50|78->51|78->51|78->51|79->52|79->52
                  -- GENERATED --
              */
          