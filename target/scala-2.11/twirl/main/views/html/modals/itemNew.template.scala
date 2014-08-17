
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
object itemNew extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[StoredItem],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(itemForm: Form[StoredItem]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal
import views.html.forms.item

Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/modal("Nová položka")/*6.23*/("Vytvoriť")/*6.35*/(routes.Store.create())/*6.58*/("btn-primary")/*6.73*/{_display_(Seq[Any](format.raw/*6.74*/("""
    """),_display_(/*7.6*/item(itemForm)),format.raw/*7.20*/("""
""")))}))}
  }

  def render(itemForm:Form[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(itemForm)

  def f:((Form[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (itemForm) => apply(itemForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 22:21:36 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/itemNew.scala.html
                  HASH: 6aa6c73c4bbc67e4e5c4dd1ac3bce7a8066ec66d
                  MATRIX: 742->1|918->29|946->94|973->96|1002->117|1022->129|1053->152|1076->167|1114->168|1145->174|1179->188
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|33->6|33->6|34->7|34->7
                  -- GENERATED --
              */
          