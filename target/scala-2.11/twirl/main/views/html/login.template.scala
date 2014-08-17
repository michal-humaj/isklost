
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
import com.feth.play.module.pa.views.html._
/**/
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>Informačný systém Klost | Prihlásenie</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
            <!-- bootstrap 3.0.2 -->
        <link href='"""),_display_(/*10.22*/routes/*10.28*/.Assets.at("css/bootstrap.min.css")),format.raw/*10.63*/("""' rel="stylesheet" type="text/css" />
            <!-- font Awesome -->
        <link href='"""),_display_(/*12.22*/routes/*12.28*/.Assets.at("css/font-awesome.min.css")),format.raw/*12.66*/("""' rel="stylesheet" type="text/css" />
            <!-- Theme style -->
        <link href='"""),_display_(/*14.22*/routes/*14.28*/.Assets.at("css/AdminLTE.css")),format.raw/*14.58*/("""' rel="stylesheet" type="text/css" />
    </head>
    <body class="bg-black">

        <div class="form-box" id="login-box">
            <div class="header">Informačný systém Klost</div>
            """),_display_(/*20.14*/forProviders()/*20.28*/ { p =>_display_(Seq[Any](format.raw/*20.35*/("""
                """),format.raw/*21.17*/("""<form action=""""),_display_(/*21.32*/p/*21.33*/.getUrl()),format.raw/*21.42*/("""" method="get">
                    <div class="body bg-gray">
                        <div>
                            """),_display_(/*24.30*/if(flash.contains(Application.FLASH_MESSAGE_KEY))/*24.79*/ {_display_(Seq[Any](format.raw/*24.81*/("""
                                    """),_display_(/*25.38*/flash()/*25.45*/.get(Application.FLASH_MESSAGE_KEY)),format.raw/*25.80*/("""
                            """)))}),format.raw/*26.30*/("""
                        """),format.raw/*27.25*/("""</div>
                    </div>
                    <div class="footer">
                        <button type="submit" class="btn bg-olive btn-block">Prihlásiť sa</button>
                    </div>
                </form>
            """)))}),format.raw/*33.14*/("""
        """),format.raw/*34.9*/("""</div>

            <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- Bootstrap -->
        <script src='"""),_display_(/*39.23*/routes/*39.29*/.Assets.at("js/bootstrap.min.js")),format.raw/*39.62*/("""' type="text/javascript"></script>

    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Aug 18 00:00:22 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/login.scala.html
                  HASH: a9526d431a5f73dc094599c12cd7269a5f2e27b0
                  MATRIX: 841->48|1188->368|1203->374|1259->409|1381->504|1396->510|1455->548|1576->642|1591->648|1642->678|1875->884|1898->898|1943->905|1989->923|2031->938|2041->939|2071->948|2223->1073|2281->1122|2321->1124|2387->1163|2403->1170|2459->1205|2521->1236|2575->1262|2850->1506|2887->1516|3110->1712|3125->1718|3179->1751
                  LINES: 29->3|36->10|36->10|36->10|38->12|38->12|38->12|40->14|40->14|40->14|46->20|46->20|46->20|47->21|47->21|47->21|47->21|50->24|50->24|50->24|51->25|51->25|51->25|52->26|53->27|59->33|60->34|65->39|65->39|65->39
                  -- GENERATED --
              */
          