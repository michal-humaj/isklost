
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
import java.text.DecimalFormat

Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*6.1*/("""
"""),_display_(/*7.2*/masters/*7.9*/.store("IS Klost | Sklad")/*7.35*/ {_display_(Seq[Any](format.raw/*7.37*/("""
    """),format.raw/*8.5*/("""<link href='"""),_display_(/*8.18*/routes/*8.24*/.Assets.at("css/custom.css")),format.raw/*8.52*/("""' rel="stylesheet" type="text/css" />
""")))}/*9.2*/ {_display_(Seq[Any](format.raw/*9.4*/("""
    """),format.raw/*10.5*/("""<!-- MODALS -->
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
            """),_display_(/*48.14*/currentAuth()/*48.27*/ { auth =>_display_(Seq[Any](format.raw/*48.37*/("""
                """),_display_(/*49.18*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*49.64*/ {_display_(Seq[Any](format.raw/*49.66*/("""
                    """),format.raw/*50.21*/("""<div class="box box-primary">
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
                                <button class="btn btn-primary" href='"""),_display_(/*79.72*/routes/*79.78*/.Store.newModal()),format.raw/*79.95*/("""' data-toggle="modal" data-target="#modal-item-create">
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
                """)))}/*101.18*/else/*101.22*/{_display_(Seq[Any](format.raw/*101.23*/("""
                    """),format.raw/*102.21*/("""<div class="box box-primary" style="width : 840px ;">
                        <div class="box-header">
                            <h3 class="box-title" id="titleItems">Skladové položky</h3>
                            <div class="pull-right box-tools">
                                    <!-- Button trigger for modal creating items -->
                                <button class="btn btn-primary" href='"""),_display_(/*107.72*/routes/*107.78*/.Store.newModal()),format.raw/*107.95*/("""' data-toggle="modal" data-target="#modal-item-create">
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
                                """),_display_(/*124.34*/defining(new DecimalFormat())/*124.63*/ { df =>_display_(Seq[Any](format.raw/*124.71*/("""
                                    """),_display_(/*125.38*/df/*125.40*/.setMaximumFractionDigits(2)),format.raw/*125.68*/("""
                                    """),_display_(/*126.38*/df/*126.40*/.setMinimumFractionDigits(0)),format.raw/*126.68*/("""
                                    """),_display_(/*127.38*/df/*127.40*/.setGroupingUsed(false)),format.raw/*127.63*/("""
                                    """),_display_(/*128.38*/for(i <- items) yield /*128.53*/ {_display_(Seq[Any](format.raw/*128.55*/("""
                                        """),format.raw/*129.41*/("""<tr id=""""),_display_(/*129.50*/i/*129.51*/.category),format.raw/*129.60*/("""">
                                            <td style='width : 390px ;'>"""),_display_(/*130.74*/i/*130.75*/.name),format.raw/*130.80*/("""</td>
                                            <td>"""),_display_(/*131.50*/df/*131.52*/.format(i.amount)),format.raw/*131.69*/("""</td>
                                            <td>"""),_display_(/*132.50*/df/*132.52*/.format(i.weight)),format.raw/*132.69*/("""</td>
                                            <td></td>
                                            <td style='width : 133px ;'>
                                                <div class="btn-group btn-group-xs">
                                                    <button id="btnInc" type="button" href='"""),_display_(/*136.94*/routes/*136.100*/.Store.increaseModal(i.id)),format.raw/*136.126*/("""' class="btn btn-primary" data-toggle="modal" data-target="#modal-item-inc" >Naskladniť</button>
                                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                                        <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a id="linkDec" href='"""),_display_(/*142.84*/routes/*142.90*/.Store.decreaseModal(i.id)),format.raw/*142.116*/("""' data-toggle="modal" data-target="#modal-item-dec" >Vyskladnit</a></li>
                                                        <li><a id="linkEdit" href='"""),_display_(/*143.85*/routes/*143.91*/.Store.editModal(i.id)),format.raw/*143.113*/("""' data-toggle="modal" data-target="#modal-item-edit" >Upravit</a></li>
                                                        <li class="divider"></li>
                                                        <li><a id="linkDelete" href='"""),_display_(/*145.87*/routes/*145.93*/.Store.deleteModal(i.id)),format.raw/*145.117*/("""' data-toggle="modal" data-target="#modal-item-delete" >Vymazat</a></li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    """)))}),format.raw/*150.38*/("""
                                """)))}),format.raw/*151.34*/("""
                                """),format.raw/*152.33*/("""</tbody>
                                <tbody id="scroll-table" class="scroll-table"></tbody>
                            </table>
                        </div><!-- /.box-body -->
                    </div> <!-- /.box -->
                """)))}),format.raw/*157.18*/("""
            """)))}),format.raw/*158.14*/("""
        """),format.raw/*159.9*/("""</div><!-- /.col -->
    </div><!-- /.row -->
""")))}/*161.2*/ {_display_(Seq[Any](format.raw/*161.4*/("""
    """),_display_(/*162.6*/currentAuth()/*162.19*/ { auth =>_display_(Seq[Any](format.raw/*162.29*/("""
        """),_display_(/*163.10*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*163.56*/ {_display_(Seq[Any](format.raw/*163.58*/("""
            """),format.raw/*164.13*/("""<script type="text/javascript" src='"""),_display_(/*164.50*/routes/*164.56*/.Assets.at("js/store.js")),format.raw/*164.81*/("""'></script>
        """)))}/*165.11*/else/*165.16*/{_display_(Seq[Any](format.raw/*165.17*/("""
            """),format.raw/*166.13*/("""<script type="text/javascript" src='"""),_display_(/*166.50*/routes/*166.56*/.Assets.at("js/storeman/store.js")),format.raw/*166.90*/("""'></script>
        """)))}),format.raw/*167.10*/("""
    """)))}),format.raw/*168.6*/("""
""")))}),format.raw/*169.2*/("""

"""))}
  }

  def render(items:List[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((List[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:00 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/store.scala.html
                  HASH: bd4682b86ebd222ce111f0229d00d73750bc8393
                  MATRIX: 733->1|936->26|964->122|991->124|1005->131|1039->157|1078->159|1109->164|1148->177|1162->183|1210->211|1266->250|1304->252|1336->257|3780->2674|3802->2687|3850->2697|3895->2715|3950->2761|3990->2763|4039->2784|5774->4492|5789->4498|5827->4515|7120->5788|7134->5792|7174->5793|7224->5814|7662->6224|7678->6230|7717->6247|8774->7276|8813->7305|8860->7313|8926->7351|8938->7353|8988->7381|9054->7419|9066->7421|9116->7449|9182->7487|9194->7489|9239->7512|9305->7550|9337->7565|9378->7567|9448->7608|9485->7617|9496->7618|9527->7627|9631->7703|9642->7704|9669->7709|9752->7764|9764->7766|9803->7783|9886->7838|9898->7840|9937->7857|10276->8168|10293->8174|10342->8200|11026->8856|11042->8862|11091->8888|11276->9045|11292->9051|11337->9073|11604->9312|11620->9318|11667->9342|12018->9661|12084->9695|12146->9728|12420->9970|12466->9984|12503->9993|12569->10040|12609->10042|12642->10048|12665->10061|12714->10071|12752->10081|12808->10127|12849->10129|12891->10142|12956->10179|12972->10185|13019->10210|13060->10232|13074->10237|13114->10238|13156->10251|13221->10288|13237->10294|13293->10328|13346->10349|13383->10355|13416->10357
                  LINES: 26->1|31->1|33->6|34->7|34->7|34->7|34->7|35->8|35->8|35->8|35->8|36->9|36->9|37->10|75->48|75->48|75->48|76->49|76->49|76->49|77->50|106->79|106->79|106->79|128->101|128->101|128->101|129->102|134->107|134->107|134->107|151->124|151->124|151->124|152->125|152->125|152->125|153->126|153->126|153->126|154->127|154->127|154->127|155->128|155->128|155->128|156->129|156->129|156->129|156->129|157->130|157->130|157->130|158->131|158->131|158->131|159->132|159->132|159->132|163->136|163->136|163->136|169->142|169->142|169->142|170->143|170->143|170->143|172->145|172->145|172->145|177->150|178->151|179->152|184->157|185->158|186->159|188->161|188->161|189->162|189->162|189->162|190->163|190->163|190->163|191->164|191->164|191->164|191->164|192->165|192->165|192->165|193->166|193->166|193->166|193->166|194->167|195->168|196->169
                  -- GENERATED --
              */
          