
package views.html.modals

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
object eventDelete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String)(eventType: String)(id: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal

Seq[Any](format.raw/*1.47*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/modal("Vymazať udalost")/*5.26*/("Vymazať")/*5.37*/(routes.Kalendar.delete(eventType, id))/*5.76*/("btn-danger")/*5.90*/{_display_(Seq[Any](format.raw/*5.91*/("""
    """),format.raw/*6.5*/("""<p>Vymazať """),_display_(/*6.17*/name),format.raw/*6.21*/("""?</p>
""")))}))}
  }

  def render(name:String,eventType:String,id:String): play.twirl.api.HtmlFormat.Appendable = apply(name)(eventType)(id)

  def f:((String) => (String) => (String) => play.twirl.api.HtmlFormat.Appendable) = (name) => (eventType) => (id) => apply(name)(eventType)(id)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 13:26:04 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/eventDelete.scala.html
                  HASH: b5df5ad76bf6054e54bc49052c23986ee71f6322
                  MATRIX: 750->1|914->46|944->84|972->87|1004->111|1023->122|1070->161|1092->175|1130->176|1162->182|1200->194|1224->198
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|32->5|32->5|33->6|33->6|33->6
                  -- GENERATED --
              */
          