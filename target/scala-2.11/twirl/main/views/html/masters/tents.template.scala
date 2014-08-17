
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
object tents extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(stylesheets: Html)(content: Html)(javascripts : Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.71*/("""

"""),_display_(/*3.2*/masters/*3.9*/.main(title)/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),_display_(/*4.6*/stylesheets),format.raw/*4.17*/("""
""")))}/*5.2*/ {_display_(Seq[Any](format.raw/*5.4*/("""

    """),format.raw/*7.5*/("""<div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
        <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">

            </section>
                <!-- /.sidebar -->
        </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
                <!-- Main content -->
            <section class="content">
                """),_display_(/*21.18*/content),format.raw/*21.25*/("""
            """),format.raw/*22.13*/("""</section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div> <!-- ./wrapper -->

""")))}/*26.2*/ {_display_(Seq[Any](format.raw/*26.4*/("""
    """),_display_(/*27.6*/javascripts),format.raw/*27.17*/("""
""")))}))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 22:57:24 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/tents.scala.html
                  HASH: 6d71bcc56c26c1582aa0681e810b41d25b66e945
                  MATRIX: 746->1|903->70|931->73|945->80|965->92|1004->94|1035->100|1066->111|1085->113|1123->115|1155->121|1754->693|1782->700|1823->713|1940->812|1979->814|2011->820|2043->831
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|33->5|33->5|35->7|49->21|49->21|50->22|54->26|54->26|55->27|55->27
                  -- GENERATED --
              */
          