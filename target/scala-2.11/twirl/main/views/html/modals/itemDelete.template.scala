
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
object itemDelete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[StoredItem,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(item: StoredItem):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.masters.modal

Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/modal("Vymazať položku")/*5.26*/("Vymazať")/*5.37*/(routes.Store.delete(item.id))/*5.67*/("btn-danger")/*5.81*/{_display_(Seq[Any](format.raw/*5.82*/("""
    """),format.raw/*6.5*/("""<p>Vymazať """),_display_(/*6.17*/item/*6.21*/.name),format.raw/*6.26*/(""" """),format.raw/*6.27*/("""zo skladu?</p>
""")))}))}
  }

  def render(item:StoredItem): play.twirl.api.HtmlFormat.Appendable = apply(item)

  def f:((StoredItem) => play.twirl.api.HtmlFormat.Appendable) = (item) => apply(item)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 11:02:17 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/modals/itemDelete.scala.html
                  HASH: 84359f94e28c8917ec3d41d4843ca1e8786e6a28
                  MATRIX: 739->1|876->19|904->54|931->56|963->80|982->91|1020->121|1042->135|1080->136|1111->141|1149->153|1161->157|1186->162|1214->163
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|32->5|32->5|33->6|33->6|33->6|33->6|33->6
                  -- GENERATED --
              */
          