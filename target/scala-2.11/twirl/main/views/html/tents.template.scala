
package views.html

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
object tents extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Tent],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tents: List[Tent]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""

"""),_display_(/*3.2*/masters/*3.9*/.tents("IS Klost | Stany")/*3.35*/{_display_(Seq[Any](format.raw/*3.36*/("""

""")))}/*5.2*/{_display_(Seq[Any](format.raw/*5.3*/("""
    """),format.raw/*6.5*/("""<!-- MODALS -->
    <!-- Modal asking to delete Tent -->
    <div class="modal" id="modal-tent-delete" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"></div>

    <div class="row">
        <div class="col-md-12">

            <div class="box box-primary" style="width:640px;">

                <div class="box-header">
                    <h3 class="box-title">Typy stanov</h3>
                    <div class="pull-right box-tools">
                        <form action='"""),_display_(/*18.40*/routes/*18.46*/.Tents.neu()),format.raw/*18.58*/("""' method="GET">
                            <button type="submit" class="btn btn-primary">
                                Vytvoriť stan
                            </button>
                        </form>
                    </div>
                </div>

                <div class="box-body no-padding">
                    <table class="table table-striped">
                        <tbody>
                            <tr>
                                <th>Názov</th>
                                <th>Akcia</th>
                            </tr>
                            """),_display_(/*33.30*/for(tent <- tents) yield /*33.48*/ {_display_(Seq[Any](format.raw/*33.50*/("""
                                """),format.raw/*34.33*/("""<tr>
                                    <td>"""),_display_(/*35.42*/tent/*35.46*/.name),format.raw/*35.51*/("""</td>
                                    <td>
                                        <div class="btn-group btn-group-xs">
                                            <a type="button" href='"""),_display_(/*38.69*/routes/*38.75*/.Tents.edit(tent.id)),format.raw/*38.95*/("""' class="btn btn-primary">Upraviť</a>
                                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href='"""),_display_(/*44.63*/routes/*44.69*/.Tents.deleteModal(tent.id)),format.raw/*44.96*/("""' data-toggle="modal" data-target="#modal-tent-delete" >Vymazať</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            """)))}),format.raw/*49.30*/("""
                        """),format.raw/*50.25*/("""</tbody>
                    </table>
                </div>

            </div>

        </div>
    </div>
""")))}/*58.2*/{_display_(Seq[Any](format.raw/*58.3*/("""

""")))}))}
  }

  def render(tents:List[Tent]): play.twirl.api.HtmlFormat.Appendable = apply(tents)

  def f:((List[Tent]) => play.twirl.api.HtmlFormat.Appendable) = (tents) => apply(tents)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 13:26:04 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/tents.scala.html
                  HASH: 41b9cf32ac1a0ebae8929078ac193460af4d4b0e
                  MATRIX: 727->1|834->20|864->25|878->32|912->58|950->59|972->64|1009->65|1041->71|1587->590|1602->596|1635->608|2263->1209|2297->1227|2337->1229|2399->1263|2473->1310|2486->1314|2512->1319|2734->1514|2749->1520|2790->1540|3359->2082|3374->2088|3422->2115|3737->2399|3791->2425|3926->2542|3964->2543
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|33->5|33->5|34->6|46->18|46->18|46->18|61->33|61->33|61->33|62->34|63->35|63->35|63->35|66->38|66->38|66->38|72->44|72->44|72->44|77->49|78->50|86->58|86->58
                  -- GENERATED --
              */
          