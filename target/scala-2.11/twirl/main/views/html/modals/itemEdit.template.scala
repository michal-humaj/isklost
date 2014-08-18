
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
object itemEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Long,Form[StoredItem],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, itemForm: Form[StoredItem]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal
import views.html.forms.item

Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/modal("Úprava položky")/*6.25*/("Uložiť")/*6.35*/(routes.Store.update(id))/*6.60*/("btn-primary")/*6.75*/{_display_(Seq[Any](format.raw/*6.76*/("""
    """),_display_(/*7.6*/item(itemForm)),format.raw/*7.20*/("""
""")))}))}
  }

  def render(id:Long,itemForm:Form[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(id,itemForm)

  def f:((Long,Form[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (id,itemForm) => apply(id,itemForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 11:59:43 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/itemEdit.scala.html
                  HASH: 8b5f3af0fb8995b31e94dba9fd2e1c892e380e6c
                  MATRIX: 748->1|934->39|962->104|989->106|1020->129|1038->139|1071->164|1094->179|1132->180|1163->186|1197->200
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|33->6|33->6|34->7|34->7
                  -- GENERATED --
              */
          