
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
                        """),_display_(/*41.26*/currentAuth()/*41.39*/ { auth =>_display_(Seq[Any](format.raw/*41.49*/("""
                            """),_display_(/*42.30*/if(SecuredAdmin.ADMIN_ID.equals(auth.getId()))/*42.76*/ {_display_(Seq[Any](format.raw/*42.78*/("""
                                """),format.raw/*43.33*/("""<li><a href='"""),_display_(/*43.47*/routes/*43.53*/.Tents.list()),format.raw/*43.66*/("""'>Stany</a></li>
                            """)))}),format.raw/*44.30*/("""
                        """)))}),format.raw/*45.26*/("""
                    """),format.raw/*46.21*/("""</ul>
                </div>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>"""),_display_(/*54.40*/session/*54.47*/.get("username")),format.raw/*54.63*/("""<i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                    <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src='"""),_display_(/*59.48*/routes/*59.54*/.Assets.at("img/avatar3.png")),format.raw/*59.83*/("""' class="img-circle" alt="User Image" />
                                    <p>
                                        Jane Doe - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                    <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-right">
                                        <a href=""""),_display_(/*68.51*/com/*68.54*/.feth.play.module.pa.controllers.routes.Authenticate.logout),format.raw/*68.113*/("""" class="btn btn-default btn-flat">
                                            Odhlásiť sa</a>
                                    </div>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>
        </header>
        """),_display_(/*79.10*/content),format.raw/*79.17*/("""
            """),format.raw/*80.13*/("""<!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- Bootstrap -->
        <script src='"""),_display_(/*83.23*/routes/*83.29*/.Assets.at("js/bootstrap.min.js")),format.raw/*83.62*/("""' type="text/javascript"></script>
            <!-- AdminLTE App -->
        <script src='"""),_display_(/*85.23*/routes/*85.29*/.Assets.at("js/AdminLTE/app.js")),format.raw/*85.61*/("""' type="text/javascript"></script>
        """),_display_(/*86.10*/javascripts),format.raw/*86.21*/("""
    """),format.raw/*87.5*/("""</body>
</html>"""))}
  }

  def render(title:String,stylesheets:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(stylesheets)(content)(javascripts)

  def f:((String) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (stylesheets) => (content) => (javascripts) => apply(title)(stylesheets)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Sep 17 11:24:01 BST 2014
                  SOURCE: C:/Users/MiHu/Documents/projects-Idea/my-first-app/app/views/masters/main.scala.html
                  HASH: ea27a3fdcbd3fa56488d2cca9e73ea743ab787ea
                  MATRIX: 745->1|945->70|973->117|1000->118|1107->199|1132->204|1338->383|1353->389|1409->424|1529->517|1544->523|1603->561|1719->650|1734->656|1789->690|1908->782|1923->788|1974->818|2048->865|2080->876|2112->881|2298->1040|2313->1046|2350->1062|2525->1210|2540->1216|2587->1242|3297->1925|3312->1931|3349->1947|3434->2005|3449->2011|3483->2024|3552->2066|3574->2079|3622->2089|3679->2119|3734->2165|3774->2167|3835->2200|3876->2214|3891->2220|3925->2233|4002->2279|4059->2305|4108->2326|4603->2794|4619->2801|4656->2817|4974->3108|4989->3114|5039->3143|5593->3670|5605->3673|5686->3732|6050->4069|6078->4076|6119->4089|6317->4260|6332->4266|6386->4299|6504->4390|6519->4396|6572->4428|6643->4472|6675->4483|6707->4488
                  LINES: 26->1|29->1|31->4|32->5|36->9|36->9|39->12|39->12|39->12|41->14|41->14|41->14|43->16|43->16|43->16|45->18|45->18|45->18|46->19|46->19|47->20|51->24|51->24|51->24|53->26|53->26|53->26|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|70->43|70->43|70->43|70->43|71->44|72->45|73->46|81->54|81->54|81->54|86->59|86->59|86->59|95->68|95->68|95->68|106->79|106->79|107->80|110->83|110->83|110->83|112->85|112->85|112->85|113->86|113->86|114->87
                  -- GENERATED --
              */
          