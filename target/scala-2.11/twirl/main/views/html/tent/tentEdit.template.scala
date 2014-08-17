
package views.html.tent

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
object tentEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Long,Form[Tent],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long)(tentForm: Form[Tent]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.34*/("""

"""),_display_(/*3.2*/forms/*3.7*/.tent(tentForm)/*3.22*/("IS Klost | Uprava stanu")/*3.49*/(routes.Tents.update(id))/*3.74*/("Uprava stanu")/*3.90*/("Uložiť")))}
  }

  def render(id:Long,tentForm:Form[Tent]): play.twirl.api.HtmlFormat.Appendable = apply(id)(tentForm)

  def f:((Long) => (Form[Tent]) => play.twirl.api.HtmlFormat.Appendable) = (id) => (tentForm) => apply(id)(tentForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 23:37:31 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/tent/tentEdit.scala.html
                  HASH: 7a5c823b89c064205ecf5a0b5f005488b807bbd9
                  MATRIX: 740->1|860->33|890->38|902->43|925->58|960->85|993->110|1017->126
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3
                  -- GENERATED --
              */
          