
package views.html.helpers

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
object horizontalForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elements: helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*3.1*/("""<div class="form-group">
    <label class="col-sm-2 control-label">"""),_display_(/*4.44*/elements/*4.52*/.label),format.raw/*4.58*/("""</label>
    <div class="col-sm-10">
        """),_display_(/*6.10*/elements/*6.18*/.input),format.raw/*6.24*/("""
    """),format.raw/*7.5*/("""</div>
</div>"""))}
  }

  def render(elements:helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(elements)

  def f:((helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (elements) => apply(elements)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:01 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/helpers/horizontalForm.scala.html
                  HASH: 8fbc0d55e0a32d074fce04e342a1c5855ac032ce
                  MATRIX: 754->1|874->33|902->35|996->103|1012->111|1038->117|1110->163|1126->171|1152->177|1183->182
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|35->7
                  -- GENERATED --
              */
          