
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(stylesheets: Html)(content: Html)(javascripts : Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import com.feth.play.module.pa.views.html._

Seq[Any](format.raw/*1.71*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>"""),_display_(/*9.17*/title),format.raw/*9.22*/("""</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
            <!-- bootstrap 3.0.2 -->
        <link href='"""),_display_(/*12.22*/routes/*12.28*/.Assets.at("css/bootstrap.min.css")),format.raw/*12.63*/("""' rel="stylesheet" type="text/css" />
            <!-- font Awesome -->
        <link href='"""),_display_(/*14.22*/routes/*14.28*/.Assets.at("css/font-awesome.min.css")),format.raw/*14.66*/("""' rel="stylesheet" type="text/css" />
            <!-- Ionicons -->
        <link href='"""),_display_(/*16.22*/routes/*16.28*/.Assets.at("css/ionicons.min.css")),format.raw/*16.62*/("""' rel="stylesheet" type="text/css" />
            <!-- Theme style -->
        <link href='"""),_display_(/*18.22*/routes/*18.28*/.Assets.at("css/AdminLTE.css")),format.raw/*18.58*/("""' rel="stylesheet" type="text/css" />
        """),_display_(/*19.10*/stylesheets),format.raw/*19.21*/("""
    """),format.raw/*20.5*/("""</head>
    <body class="skin-blue">
            <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href='"""),_display_(/*24.23*/routes/*24.29*/.Kalendar.list()),format.raw/*24.45*/("""' class="logo">
                    <!-- Add the class icon to your logo image or logo icon to add the margining -->
                    <img src='"""),_display_(/*26.32*/routes/*26.38*/.Assets.at("img/logo.png")),format.raw/*26.64*/("""'>
            </a>
                <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-left">
                    <ul class="nav navbar-nav">
                        <li><a href='"""),_display_(/*39.39*/routes/*39.45*/.Kalendar.list()),format.raw/*39.61*/("""'>Kalendár</a></li>
                        <li><a href='"""),_display_(/*40.39*/routes/*40.45*/.Store.list()),format.raw/*40.58*/("""'>Sklad</a></li>
                        <li><a href='"""),_display_(/*41.39*/routes/*41.45*/.Tents.list()),format.raw/*41.58*/("""'>Stany</a></li>
                    </ul>
                </div>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>"""),_display_(/*50.40*/session/*50.47*/.get("username")),format.raw/*50.63*/("""<i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                    <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src='"""),_display_(/*55.48*/routes/*55.54*/.Assets.at("img/avatar3.png")),format.raw/*55.83*/("""' class="img-circle" alt="User Image" />
                                    <p>
                                        Jane Doe - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                    <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-right">
                                        <a href=""""),_display_(/*64.51*/com/*64.54*/.feth.play.module.pa.controllers.routes.Authenticate.logout),format.raw/*64.113*/("""" class="btn btn-default btn-flat">
                                            Odhlásiť sa</a>
                                    </div>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>
        </header>
        """),_display_(/*75.10*/content),format.raw/*75.17*/("""
            """),format.raw/*76.13*/("""<!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- Bootstrap -->
        <script src='"""),_display_(/*79.23*/routes/*79.29*/.Assets.at("js/bootstrap.min.js")),format.raw/*79.62*/("""' type="text/javascript"></script>
            <!-- AdminLTE App -->
        <script src='"""),_display_(/*81.23*/routes/*81.29*/.Assets.at("js/AdminLTE/app.js")),format.raw/*81.61*/("""' type="text/javascript"></script>
        """),_display_(/*82.10*/javascripts),format.raw/*82.21*/("""
    """),format.raw/*83.5*/("""</body>
</html>"""))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 17 22:57:24 CEST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/main.scala.html
                  HASH: baca9aca1b091d9e5f9621ff01ca69df2461fecb
                  MATRIX: 745->1|945->70|973->117|1000->118|1107->199|1132->204|1338->383|1353->389|1409->424|1529->517|1544->523|1603->561|1719->650|1734->656|1789->690|1908->782|1923->788|1974->818|2048->865|2080->876|2112->881|2298->1040|2313->1046|2350->1062|2525->1210|2540->1216|2587->1242|3297->1925|3312->1931|3349->1947|3434->2005|3449->2011|3483->2024|3565->2079|3580->2085|3614->2098|4146->2603|4162->2610|4199->2626|4517->2917|4532->2923|4582->2952|5136->3479|5148->3482|5229->3541|5593->3878|5621->3885|5662->3898|5860->4069|5875->4075|5929->4108|6047->4199|6062->4205|6115->4237|6186->4281|6218->4292|6250->4297
                  LINES: 26->1|29->1|31->4|32->5|36->9|36->9|39->12|39->12|39->12|41->14|41->14|41->14|43->16|43->16|43->16|45->18|45->18|45->18|46->19|46->19|47->20|51->24|51->24|51->24|53->26|53->26|53->26|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|77->50|77->50|77->50|82->55|82->55|82->55|91->64|91->64|91->64|102->75|102->75|103->76|106->79|106->79|106->79|108->81|108->81|108->81|109->82|109->82|110->83
                  -- GENERATED --
              */
          