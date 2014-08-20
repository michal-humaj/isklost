
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
object store extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[StoredItem],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(items: List[StoredItem]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import com.feth.play.module.pa.views.html._
import helper._

Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/masters/*6.9*/.store("IS Klost | Sklad")/*6.35*/ {_display_(Seq[Any](format.raw/*6.37*/("""
    """),format.raw/*7.5*/("""<link href='"""),_display_(/*7.18*/routes/*7.24*/.Assets.at("css/custom.css")),format.raw/*7.52*/("""' rel="stylesheet" type="text/css" />
""")))}/*8.2*/ {_display_(Seq[Any](format.raw/*8.4*/("""
    """),format.raw/*9.5*/("""<!-- MODALS -->
    <!-- Modal for creating StoredItem -->
    <div class="modal" id="modal-item-create" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
    <!-- Modal for StoredItem editing -->
    <div class="modal" id="modal-item-edit" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"></div>
    <!-- Modal asking to delete StoredItem -->
    <div class="modal" id="modal-item-delete" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"></div>
    <!-- Modal for new item pieces to store -->
    <div class="modal" id="modal-item-inc" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"></div>
    <!-- Modal for item pieces removal from store -->
    <div class="modal" id="modal-item-dec" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"></div>

    <div id="availCalcGroup" class="hide">
        <div class="btn-group btn-group-xs" data-toggle="btn-toggle" >
            <button type="button" class="btn btn-success disabled btnCheck"><i class="fa fa-check"></i></button>
            <button type="button" class="btn btn-default btnTimes"><i class="fa fa-times"></i></button>
        </div>
    </div>

    <div id="itemManipulationBtnsDiv" class="hide">
        <div class="btn-group btn-group-xs">
            <button id="btnInc" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#modal-item-inc" >Naskladniť</button>
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a id="linkDec" href='routes.Store.decreaseModal(item.id)' data-toggle="modal" data-target="#modal-item-dec" >Vyskladnit</a></li>
                <li><a id="linkEdit" href='routes.Store.editModal(item.id)' data-toggle="modal" data-target="#modal-item-edit" >Upravit</a></li>
                <li class="divider"></li>
                <li><a id="linkDelete" href='routes.Store.deleteModal(item.id)' data-toggle="modal" data-target="#modal-item-delete" >Vymazat</a></li>
            </ul>
        </div>
    </div>

    <!-- Page content -->
    <div class="row">
        <div class="col-md-12">
            """),_display_(/*47.14*/currentAuth()/*47.27*/ { auth =>_display_(Seq[Any](format.raw/*47.37*/("""
                """),_display_(/*48.18*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*48.64*/ {_display_(Seq[Any](format.raw/*48.66*/("""
                    """),format.raw/*49.21*/("""<div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title" id="titleEvents">Udalosti</h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-primary btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Udalosť</th>
                                        <th style="width : 100px ;">Začiatok</th>
                                        <th style="width : 100px ;">Koniec</th>
                                        <th style="width : 150px ;">Výpočet dostupnosti</th>
                                    </tr>
                                </thead>
                                <tbody id="tableEvents"></tbody>
                            </table>
                        </div>
                        <div id="overlayEvents"></div>
                        <div id="loadingEvents"></div>
                    </div>

                    <div class="box box-primary" style="width : 840px ;">
                        <div class="box-header">
                            <h3 class="box-title" id="titleItems">Dostupnosť položiek</h3>
                            <div class="pull-right box-tools">
                                    <!-- Button trigger for modal creating items -->
                                <button class="btn btn-primary" href='"""),_display_(/*78.72*/routes/*78.78*/.Store.newModal()),format.raw/*78.95*/("""' data-toggle="modal" data-target="#modal-item-create">
                                    Vytvoriť položku
                                </button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <table class="table scrollTable">
                                <thead>
                                    <tr>
                                        <th style="width : 390px ;">Položka</th>
                                        <th style="width : 100px ;">Dostupné</th>
                                        <th style="width : 100px ;">Rezervované</th>
                                        <th style="width : 100px ;">Prenajaté</th>
                                        <th style="width : 150px ;">Akcia</th>
                                    </tr>
                                </thead>
                                <tbody id="scroll-table" class="scroll-table"></tbody>
                            </table>
                        </div><!-- /.box-body -->
                        <div id="overlayItems"></div>
                        <div id="loadingItems"></div>
                    </div> <!-- /.box -->
                """)))}/*100.18*/else/*100.22*/{_display_(Seq[Any](format.raw/*100.23*/("""
                    """),format.raw/*101.21*/("""<div class="box box-primary" style="width : 840px ;">
                        <div class="box-header">
                            <h3 class="box-title" id="titleItems">Skladové položky</h3>
                            <div class="pull-right box-tools">
                                    <!-- Button trigger for modal creating items -->
                                <button class="btn btn-primary" href='"""),_display_(/*106.72*/routes/*106.78*/.Store.newModal()),format.raw/*106.95*/("""' data-toggle="modal" data-target="#modal-item-create">
                                    Vytvoriť položku
                                </button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <table class="table scrollTable">
                                <thead>
                                    <tr>
                                        <th style="width : 390px ;">Položka</th>
                                        <th style="width : 100px ;">Počet</th>
                                        <th style="width : 100px ;">Hmotnosť</th>
                                        <th style="width : 100px ;"></th>
                                        <th style="width : 150px ;">Akcia</th>
                                    </tr>
                                </thead>
                                <tbody id="scroll-table" class="scroll-table">
                                    """),_display_(/*123.38*/for(i <- items) yield /*123.53*/ {_display_(Seq[Any](format.raw/*123.55*/("""
                                        """),format.raw/*124.41*/("""<tr id=""""),_display_(/*124.50*/i/*124.51*/.category),format.raw/*124.60*/("""">
                                            <td style='width: 390px;'>"""),_display_(/*125.72*/i/*125.73*/.name),format.raw/*125.78*/("""</td>
                                            <td>"""),_display_(/*126.50*/i/*126.51*/.amount),format.raw/*126.58*/("""</td>
                                            <td>"""),_display_(/*127.50*/i/*127.51*/.weight),format.raw/*127.58*/(""" """),format.raw/*127.59*/("""kg</td>
                                            <td></td>
                                            <td style='width: 133px;'>
                                                <div class="btn-group btn-group-xs">
                                                    <button id="btnInc" type="button" href='"""),_display_(/*131.94*/routes/*131.100*/.Store.increaseModal(i.id)),format.raw/*131.126*/("""' class="btn btn-primary"  data-toggle="modal" data-target="#modal-item-inc" >Naskladniť</button>
                                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                                        <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a id="linkDec" href='"""),_display_(/*137.84*/routes/*137.90*/.Store.decreaseModal(i.id)),format.raw/*137.116*/("""' data-toggle="modal" data-target="#modal-item-dec" >Vyskladnit</a></li>
                                                        <li><a id="linkEdit" href='"""),_display_(/*138.85*/routes/*138.91*/.Store.editModal(i.id)),format.raw/*138.113*/("""' data-toggle="modal" data-target="#modal-item-edit" >Upravit</a></li>
                                                        <li class="divider"></li>
                                                        <li><a id="linkDelete" href='"""),_display_(/*140.87*/routes/*140.93*/.Store.deleteModal(i.id)),format.raw/*140.117*/("""' data-toggle="modal" data-target="#modal-item-delete" >Vymazat</a></li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    """)))}),format.raw/*145.38*/("""
                                """),format.raw/*146.33*/("""</tbody>
                                <tbody id="scroll-table" class="scroll-table"></tbody>
                            </table>
                        </div><!-- /.box-body -->
                    </div> <!-- /.box -->
                """)))}),format.raw/*151.18*/("""
            """)))}),format.raw/*152.14*/("""
        """),format.raw/*153.9*/("""</div><!-- /.col -->
    </div><!-- /.row -->
""")))}/*155.2*/ {_display_(Seq[Any](format.raw/*155.4*/("""
    """),_display_(/*156.6*/currentAuth()/*156.19*/ { auth =>_display_(Seq[Any](format.raw/*156.29*/("""
        """),_display_(/*157.10*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*157.56*/ {_display_(Seq[Any](format.raw/*157.58*/("""
            """),format.raw/*158.13*/("""<script type="text/javascript" src='"""),_display_(/*158.50*/routes/*158.56*/.Assets.at("js/store.js")),format.raw/*158.81*/("""'></script>
        """)))}/*159.11*/else/*159.16*/{_display_(Seq[Any](format.raw/*159.17*/("""
            """),format.raw/*160.13*/("""<script type="text/javascript" src='"""),_display_(/*160.50*/routes/*160.56*/.Assets.at("js/storeman/store.js")),format.raw/*160.90*/("""'></script>
        """)))}),format.raw/*161.10*/("""
    """)))}),format.raw/*162.6*/("""
""")))}),format.raw/*163.2*/("""

"""))}
  }

  def render(items:List[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((List[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Aug 20 18:15:37 UTC 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/store.scala.html
                  HASH: d56deb428b5814ced3c35316c6ad62e59815df9d
                  MATRIX: 733->1|905->26|933->90|960->92|974->99|1008->125|1047->127|1078->132|1117->145|1131->151|1179->179|1235->218|1273->220|1304->225|3748->2642|3770->2655|3818->2665|3863->2683|3918->2729|3958->2731|4007->2752|5742->4460|5757->4466|5795->4483|7088->5756|7102->5760|7142->5761|7192->5782|7630->6192|7646->6198|7685->6215|8746->7248|8778->7263|8819->7265|8889->7306|8926->7315|8937->7316|8968->7325|9070->7399|9081->7400|9108->7405|9191->7460|9202->7461|9231->7468|9314->7523|9325->7524|9354->7531|9384->7532|9723->7843|9740->7849|9789->7875|10474->8532|10490->8538|10539->8564|10724->8721|10740->8727|10785->8749|11052->8988|11068->8994|11115->9018|11466->9337|11528->9370|11802->9612|11848->9626|11885->9635|11951->9682|11991->9684|12024->9690|12047->9703|12096->9713|12134->9723|12190->9769|12231->9771|12273->9784|12338->9821|12354->9827|12401->9852|12442->9874|12456->9879|12496->9880|12538->9893|12603->9930|12619->9936|12675->9970|12728->9991|12765->9997|12798->9999
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|34->7|34->7|34->7|34->7|35->8|35->8|36->9|74->47|74->47|74->47|75->48|75->48|75->48|76->49|105->78|105->78|105->78|127->100|127->100|127->100|128->101|133->106|133->106|133->106|150->123|150->123|150->123|151->124|151->124|151->124|151->124|152->125|152->125|152->125|153->126|153->126|153->126|154->127|154->127|154->127|154->127|158->131|158->131|158->131|164->137|164->137|164->137|165->138|165->138|165->138|167->140|167->140|167->140|172->145|173->146|178->151|179->152|180->153|182->155|182->155|183->156|183->156|183->156|184->157|184->157|184->157|185->158|185->158|185->158|185->158|186->159|186->159|186->159|187->160|187->160|187->160|187->160|188->161|189->162|190->163
                  -- GENERATED --
              */
          