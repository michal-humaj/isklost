
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
object tentDelete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Tent,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tent: Tent):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal

Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/modal("Vymazať stan")/*5.23*/("Vymazať")/*5.34*/(routes.Tents.delete(tent.id))/*5.64*/("btn-danger")/*5.78*/{_display_(Seq[Any](format.raw/*5.79*/("""
    """),format.raw/*6.5*/("""<p>Vymazať """),_display_(/*6.17*/tent/*6.21*/.name),format.raw/*6.26*/("""?</p>
    <p>Zo skladu nebudu vymazané žiadne položky</p>
""")))}))}
  }

  def render(tent:Tent): play.twirl.api.HtmlFormat.Appendable = apply(tent)

  def f:((Tent) => play.twirl.api.HtmlFormat.Appendable) = (tent) => apply(tent)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Sep 18 17:39:48 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/tentDelete.scala.html
                  HASH: 6aa90ce968bff415bd18c5ebd29e881f97a261d5
                  MATRIX: 733->1|864->13|894->51|922->54|951->75|970->86|1008->116|1030->130|1068->131|1100->137|1138->149|1150->153|1175->158
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|32->5|32->5|33->6|33->6|33->6|33->6
                  -- GENERATED --
              */
          