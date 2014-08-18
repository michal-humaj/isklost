
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
      _display_ {import helper._

Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/masters/*5.9*/.store("IS Klost | Sklad")/*5.35*/ {_display_(Seq[Any](format.raw/*5.37*/("""
    """),format.raw/*6.5*/("""<link href='"""),_display_(/*6.18*/routes/*6.24*/.Assets.at("css/custom.css")),format.raw/*6.52*/("""' rel="stylesheet" type="text/css" />
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
    """),format.raw/*8.5*/("""<!-- MODALS -->
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

            <div class="box box-primary" style="width:960px;">
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
                                <th style="width :100px;">Začiatok</th>
                                <th style="width :100px;">Koniec</th>
                                <th style="width :150px;">Výpočet dostupnosti</th>
                            </tr>
                        </thead>
                        <tbody id="tableEvents"></tbody>
                    </table>
                </div>
                <div id="overlayEvents"></div>
                <div id="loadingEvents"></div>
            </div>

            <div class="box box-primary" style="width:840px;">
                <div class="box-header">
                    <h3 class="box-title" id="titleItems">Dostupnosť položiek</h3>
                    <div class="pull-right box-tools">
                            <!-- Button trigger for modal creating items -->
                        <button class="btn btn-primary" href='"""),_display_(/*76.64*/routes/*76.70*/.Store.newModal()),format.raw/*76.87*/("""' data-toggle="modal" data-target="#modal-item-create">
                            Vytvoriť položku
                        </button>
                    </div>
                </div><!-- /.box-header -->
                <div class="box-body no-padding">
                    <table class="table scrollTable">
                        <thead>
                            <tr>
                                <th style="width :390px;">Položka</th>
                                <th style="width :100px;">Dostupné</th>
                                <th style="width :100px;">Rezervované</th>
                                <th style="width :100px;">Prenajaté</th>
                                <th style="width :150px;">Akcia</th>
                            </tr>
                        </thead>
                        <tbody id="scroll-table"></tbody>
                    </table>
                </div><!-- /.box-body -->
                <div id="overlayItems"></div>
                <div id="loadingItems"></div>
            </div><!-- /.box -->


        </div><!-- /.col -->
    </div><!-- /.row -->
""")))}/*102.2*/ {_display_(Seq[Any](format.raw/*102.4*/("""
    """),format.raw/*103.5*/("""<script type="text/javascript" src='"""),_display_(/*103.42*/routes/*103.48*/.Assets.at("js/store.js")),format.raw/*103.73*/("""'></script>
""")))}),format.raw/*104.2*/("""

"""))}
  }

  def render(items:List[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((List[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 13:26:04 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/store.scala.html
                  HASH: f7de53a96ebd569d2efee084094bddd3653d9461
                  MATRIX: 733->1|861->26|889->45|916->47|930->54|964->80|1003->82|1034->87|1073->100|1087->106|1135->134|1191->173|1229->175|1260->180|5200->4093|5215->4099|5253->4116|6385->5229|6425->5231|6458->5236|6523->5273|6539->5279|6586->5304|6630->5317
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|33->6|33->6|33->6|33->6|34->7|34->7|35->8|103->76|103->76|103->76|129->102|129->102|130->103|130->103|130->103|130->103|131->104
                  -- GENERATED --
              */
          