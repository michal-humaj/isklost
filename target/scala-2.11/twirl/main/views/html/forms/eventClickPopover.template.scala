
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
import helper._
/**/
object eventClickPopover extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*3.2*/form(routes.Kalendar.create(), 'class -> "form-horizontal", 'style -> "width:240px;")/*3.87*/{_display_(Seq[Any](format.raw/*3.88*/("""
    """),format.raw/*4.5*/("""<div class="form-group">
        <div class="col-sm-12">
           <h4></h4>
        </div>
    </div>

    <input type="hidden" id="startDate" name="startDate">
    <input type="hidden" id="endDate" name="endDate">
    <input type="hidden" id="allDay" name="allDay">

    <div class="btn-group">
        <a type="button" class="btn btn-info btnEdit">Upravit</a>
        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
            <span class="caret"></span>
            <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul id="eventClickUl" class="dropdown-menu" role="menu">
        </ul>
    </div>
    <div class="pull-right">
        <a type="button" class="btn btn-danger btnDelete" data-toggle="modal" data-target="#modal-event-delete" >Vymazat</a>
    </div>
""")))}),format.raw/*26.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:01 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/eventClickPopover.scala.html
                  HASH: 60e4aa059dcc7e5b480902df993899ee82652fdf
                  MATRIX: 831->21|924->106|962->107|994->113|1872->961
                  LINES: 29->3|29->3|29->3|30->4|52->26
                  -- GENERATED --
              */
          