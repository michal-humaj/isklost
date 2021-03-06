
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
object item extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[StoredItem],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(itemForm: Form[StoredItem]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import views.html.helpers._
implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(horizontalForm.render) }};
Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*5.73*/("""

"""),_display_(/*7.2*/select(
    itemForm("category"),
    options(Category.storeOptions),
    'id -> "categorySelect", '_label -> "Kategória", 'class -> "form-control categorySelect", 'required -> "true"
)),format.raw/*11.2*/("""
"""),_display_(/*12.2*/inputText(itemForm("name"), '_label -> "Názov", 'class -> "form-control", 'placeholder -> "Stolička ratan", 'required -> "true")),format.raw/*12.130*/("""
"""),format.raw/*13.1*/("""<div class="form-group">
    <label class="col-sm-2 control-label" id="amountLabel">Počet</label>
    <div class="col-sm-4">
        <div class="input-group">
            <input id="amountInput" name="amount" type="number" min="1" step="1" max="9999" required class="form-control" placeholder="45" value=""""),_display_(/*17.148*/itemForm/*17.156*/.apply("amount").value),format.raw/*17.178*/("""">
            <span class="input-group-addon" id="amountUnits">ks</span>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-2 control-label">Hmotnosť</label>
    <div class="col-sm-4">
        <div class="input-group">
            <input name="weight" type="number" min="0.01" step="0.01" max="9999" required class="form-control" placeholder="2,35" value=""""),_display_(/*26.139*/itemForm/*26.147*/.apply("weight").value),format.raw/*26.169*/("""">
            <span class="input-group-addon" id="weightUnits">kg</span>
        </div>
    </div>
</div>

<script type="text/javascript">
    function changeForm() """),format.raw/*33.27*/("""{"""),format.raw/*33.28*/("""
        """),format.raw/*34.9*/("""var e = document.getElementById("categorySelect");
        if (e.options[e.selectedIndex].value == 'CARPETS')"""),format.raw/*35.59*/("""{"""),format.raw/*35.60*/("""
            """),format.raw/*36.13*/("""$("#amountUnits" ).html("m");
            $("#weightUnits").html('kg/m');
            $("#amountLabel" ).html('Dĺžka');
            $("#amountInput").attr("min",0.01);
            $("#amountInput").attr("step",0.01);
            $("#amountInput").attr("placeholder",'24,55');
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/("""else"""),format.raw/*42.14*/("""{"""),format.raw/*42.15*/("""
            """),format.raw/*43.13*/("""$("#amountUnits" ).html("ks");
            $("#weightUnits").html('kg');
            $("#amountLabel" ).html('Počet');
            $("#amountInput").attr("min",1);
            $("#amountInput").attr("step",1);
            $("#amountInput").attr("placeholder",'45');
        """),format.raw/*49.9*/("""}"""),format.raw/*49.10*/("""
    """),format.raw/*50.5*/("""}"""),format.raw/*50.6*/("""

    """),format.raw/*52.5*/("""$(document).ready(function() """),format.raw/*52.34*/("""{"""),format.raw/*52.35*/("""
        """),format.raw/*53.9*/("""changeForm();
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""");
    $("#categorySelect").change(function() """),format.raw/*55.44*/("""{"""),format.raw/*55.45*/("""
        """),format.raw/*56.9*/("""changeForm();
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""");
</script>"""))}
  }

  def render(itemForm:Form[StoredItem]): play.twirl.api.HtmlFormat.Appendable = apply(itemForm)

  def f:((Form[StoredItem]) => play.twirl.api.HtmlFormat.Appendable) = (itemForm) => apply(itemForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Oct 01 15:55:03 UTC 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/forms/item.scala.html
                  HASH: 82a758605b4d707563b2a67be81bff29c4696610
                  MATRIX: 738->1|889->82|921->106|998->29|1029->153|1059->158|1268->347|1297->350|1447->478|1476->480|1814->790|1832->798|1876->820|2303->1219|2321->1227|2365->1249|2566->1422|2595->1423|2632->1433|2770->1543|2799->1544|2841->1558|3158->1848|3187->1849|3219->1853|3248->1854|3290->1868|3597->2148|3626->2149|3659->2155|3687->2156|3722->2164|3779->2193|3808->2194|3845->2204|3891->2223|3919->2224|3994->2271|4023->2272|4060->2282|4106->2301|4134->2302
                  LINES: 26->1|29->5|29->5|30->1|32->5|34->7|38->11|39->12|39->12|40->13|44->17|44->17|44->17|53->26|53->26|53->26|60->33|60->33|61->34|62->35|62->35|63->36|69->42|69->42|69->42|69->42|70->43|76->49|76->49|77->50|77->50|79->52|79->52|79->52|80->53|81->54|81->54|82->55|82->55|83->56|84->57|84->57
                  -- GENERATED --
              */
          