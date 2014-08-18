
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
object newEventPopover extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*3.2*/form(routes.Kalendar.create(), 'class -> "form-horizontal formNewEvent", 'style -> "width:240px;")/*3.100*/{_display_(Seq[Any](format.raw/*3.101*/("""
    """),format.raw/*4.5*/("""<div class="form-group">
        <div class="col-sm-12">
            <input type="text" name="name" class="form-control inputEventName" placeholder="Názov" required="true" autocomplete="off">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-12">
            <select name="eventType" class="form-control selectEventType" required="true">
                <option value="ACTION">Akcia</option>
                <option value="RESERVATION">Rezervácia</option>
                <option value="SELFTRANSPORT">Vlastná doprava</option>
                <option value="INSTALLATION">Montáž</option>
            </select>
        </div>
    </div>
    <div class="selectActionContainer"></div>

    <input type="hidden" id="startDate" name="startDate">
    <input type="hidden" id="endDate" name="endDate">
    <input type="hidden" id="allDay" name="allDay">
    <button type="submit" class="btn btn-primary btnCreateEvent" >Vytvoriť</button>
""")))}),format.raw/*25.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 10:41:43 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/newEventPopover.scala.html
                  HASH: d5e8ae6a6ded34ae1108e6dd7eba83ea7f525d92
                  MATRIX: 829->21|936->119|975->120|1007->126|2022->1111
                  LINES: 29->3|29->3|29->3|30->4|51->25
                  -- GENERATED --
              */
          