
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
object itemInc extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[StoredItem,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(item: StoredItem):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal
import views.html.forms.itemIncDec

Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/modal("Príjem na sklad")/*6.26*/("Naskladniť")/*6.40*/(routes.Store.increase(item.id))/*6.72*/("btn-primary")/*6.87*/{_display_(Seq[Any](format.raw/*6.88*/("""
    """),_display_(/*7.6*/itemIncDec(item)),format.raw/*7.22*/("""
""")))}))}
  }

  def render(item:StoredItem): play.twirl.api.HtmlFormat.Appendable = apply(item)

  def f:((StoredItem) => play.twirl.api.HtmlFormat.Appendable) = (item) => apply(item)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Sep 18 17:11:22 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/itemInc.scala.html
                  HASH: 54e63f1d08867c5b387b6b7787e0f5e37250cad4
                  MATRIX: 736->1|908->19|936->90|963->92|995->116|1017->130|1057->162|1080->177|1118->178|1149->184|1185->200
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|33->6|33->6|34->7|34->7
                  -- GENERATED --
              */
          