
package views.html.forms

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
object itemIncDec extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[StoredItem,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(item: StoredItem):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*3.1*/("""<div class="form-group">
    <label class="col-sm-4 control-label">"""),_display_(/*4.44*/item/*4.48*/.name),format.raw/*4.53*/("""</label>
    <div class="col-sm-4">
        <div class="input-group">
            """),_display_(/*7.14*/if(item.category == Category.CARPETS)/*7.51*/{_display_(Seq[Any](format.raw/*7.52*/("""
                """),format.raw/*8.17*/("""<input name="amount" type="number" min="0.01" step="0.01" required class="form-control">
                <span class="input-group-addon">m</span>
            """)))}/*10.14*/else/*10.18*/{_display_(Seq[Any](format.raw/*10.19*/("""
                """),format.raw/*11.17*/("""<input name="amount" type="number" min="1" step="1" required class="form-control">
                <span class="input-group-addon">ks</span>
            """)))}),format.raw/*13.14*/("""
        """),format.raw/*14.9*/("""</div>
    </div>
</div>"""))}
  }

  def render(item:StoredItem): play.twirl.api.HtmlFormat.Appendable = apply(item)

  def f:((StoredItem) => play.twirl.api.HtmlFormat.Appendable) = (item) => apply(item)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:01 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/itemIncDec.scala.html
                  HASH: a5ab7caa6b055b63c6ecaa89c7afa59e9995f5cf
                  MATRIX: 738->1|844->19|872->21|966->89|978->93|1003->98|1112->181|1157->218|1195->219|1239->236|1417->395|1430->399|1469->400|1514->417|1699->571|1735->580
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|35->7|35->7|35->7|36->8|38->10|38->10|38->10|39->11|41->13|42->14
                  -- GENERATED --
              */
          