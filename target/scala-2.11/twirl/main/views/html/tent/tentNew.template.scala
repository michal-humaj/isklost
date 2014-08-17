
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
object tentNew extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Tent],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tentForm: Form[Tent]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.24*/("""

"""),_display_(/*3.2*/forms/*3.7*/.tent(tentForm)/*3.22*/("IS Klost | Nový stan")/*3.46*/(routes.Tents.create())/*3.69*/("Nový stan")/*3.82*/("Vytvoriť")))}
  }

  def render(tentForm:Form[Tent]): play.twirl.api.HtmlFormat.Appendable = apply(tentForm)

  def f:((Form[Tent]) => play.twirl.api.HtmlFormat.Appendable) = (tentForm) => apply(tentForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 00:00:22 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/tent/tentNew.scala.html
                  HASH: f8461dffc86dbdf98b9934ea2691487e77b09468
                  MATRIX: 734->1|844->23|874->28|886->33|909->48|941->72|972->95|993->108
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3
                  -- GENERATED --
              */
          