
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
object modal extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,play.api.mvc.Call,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(submitLabel: String)(call: play.api.mvc.Call)(btnClass: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.96*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<div class="modal-dialog">
    <div class="modal-content">

    """),_display_(/*8.6*/form(call, 'class -> "form-horizontal")/*8.45*/ {_display_(Seq[Any](format.raw/*8.47*/("""
        """),format.raw/*9.9*/("""<div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">"""),_display_(/*13.56*/title),format.raw/*13.61*/("""</h4>
        </div>
        <div class="modal-body">
            """),_display_(/*16.14*/content),format.raw/*16.21*/("""
        """),format.raw/*17.9*/("""</div>
        <div class="modal-footer">
            <button type="submit" class="btn """),_display_(/*19.47*/btnClass),format.raw/*19.55*/("""">"""),_display_(/*19.58*/submitLabel),format.raw/*19.69*/("""</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Späť</button>
        </div>
    """)))}),format.raw/*22.6*/("""

    """),format.raw/*24.5*/("""</div>
</div>"""))}
  }

  def render(title:String,submitLabel:String,call:play.api.mvc.Call,btnClass:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(submitLabel)(call)(btnClass)(content)

  def f:((String) => (String) => (play.api.mvc.Call) => (String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (submitLabel) => (call) => (btnClass) => (content) => apply(title)(submitLabel)(call)(btnClass)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 22:57:24 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/modal.scala.html
                  HASH: 4be153af83ffae94d0fc2d217ab2c0f0762eaa94
                  MATRIX: 768->1|965->95|995->117|1023->119|1116->187|1163->226|1202->228|1238->238|1533->506|1559->511|1656->581|1684->588|1721->598|1838->688|1867->696|1897->699|1929->710|2085->836|2120->844
                  LINES: 26->1|29->1|31->4|32->5|35->8|35->8|35->8|36->9|40->13|40->13|43->16|43->16|44->17|46->19|46->19|46->19|46->19|49->22|51->24
                  -- GENERATED --
              */
          