
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, tab: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""

<!DOCTYPE html>

<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
    <title>"""),_display_(Seq[Any](/*10.13*/title)),format.raw/*10.18*/("""</title>

    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*12.55*/routes/*12.61*/.Assets.at("images/favicon.png"))),format.raw/*12.93*/("""">
    <!-- Font -->
    <!-- link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500' rel='stylesheet' type='text/css' / -->

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*17.66*/routes/*17.72*/.WebJarAssets.at(WebJarAssets.locate("css/bootstrap.min.css")))),format.raw/*17.134*/("""" />
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*18.50*/routes/*18.56*/.Assets.at("stylesheets/main.css"))),format.raw/*18.90*/("""">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src=""""),_display_(Seq[Any](/*23.21*/routes/*23.27*/.WebJarAssets.at(WebJarAssets.locate("html5shiv.js")))),format.raw/*23.80*/(""""></script>
      <script src=""""),_display_(Seq[Any](/*24.21*/routes/*24.27*/.WebJarAssets.at(WebJarAssets.locate("respond.min.js")))),format.raw/*24.82*/(""""></script>
    <![endif]-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*28.42*/routes/*28.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js")))),format.raw/*28.102*/("""'></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=""""),_display_(Seq[Any](/*31.19*/routes/*31.25*/.WebJarAssets.at(WebJarAssets.locate("js/bootstrap.min.js")))),format.raw/*31.85*/(""""></script>
  </head>
  <body data-spy="scroll" data-twttr-rendered="true">
    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="/">Amazing Recommendations</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class=""""),_display_(Seq[Any](/*42.25*/("active".when(tab == "groups")))),format.raw/*42.57*/(""""><a href="/product/groups/">Product Groups</a></li>
            <li class=""""),_display_(Seq[Any](/*43.25*/("active".when(tab == "customers")))),format.raw/*43.60*/(""""><a href="/customers">Product Recomendations</a></li>
            <li class=""""),_display_(Seq[Any](/*44.25*/("active".when(tab == "bookcustomers")))),format.raw/*44.64*/(""""><a href="/book/customers">Book Recomendations</a></li>
            <li class=""""),_display_(Seq[Any](/*45.25*/("active".when(tab == "toprated")))),format.raw/*45.59*/(""""><a href="/recommendation/topRated">Top Rated</a></li>
           <!-- <li class=""""),_display_(Seq[Any](/*46.29*/("active".when(tab == "mostpopular")))),format.raw/*46.66*/(""""><a href="/recommendation/mostPopular">Most Popular</a></li> -->
          </ul>
        </div> <!--/.nav-collapse -->
      </div>
    </div> <!-- /container -->
    <div class="container theme-showcase" role="main">
      """),_display_(Seq[Any](/*52.8*/content)),format.raw/*52.15*/("""
    </div>
    <footer class="footer">
      <div class="container">
      </div>
    </footer>
  </body>
</html>
"""))}
    }
    
    def render(title:String,tab:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,tab)(content)
    
    def f:((String,String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,tab) => (content) => apply(title,tab)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 16 12:55:26 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/main.scala.html
                    HASH: 4a4e3b3ca3a2b1cb9ad05242bd717e4048df2ebc
                    MATRIX: 567->1|704->44|972->276|999->281|1099->345|1114->351|1168->383|1437->616|1452->622|1537->684|1627->738|1642->744|1698->778|1946->990|1961->996|2036->1049|2104->1081|2119->1087|2196->1142|2370->1280|2385->1286|2462->1340|2618->1460|2633->1466|2715->1526|3189->1964|3243->1996|3356->2073|3413->2108|3528->2187|3589->2226|3706->2307|3762->2341|3882->2425|3941->2462|4202->2688|4231->2695
                    LINES: 19->1|22->1|31->10|31->10|33->12|33->12|33->12|38->17|38->17|38->17|39->18|39->18|39->18|44->23|44->23|44->23|45->24|45->24|45->24|49->28|49->28|49->28|52->31|52->31|52->31|63->42|63->42|64->43|64->43|65->44|65->44|66->45|66->45|67->46|67->46|73->52|73->52
                    -- GENERATED --
                */
            