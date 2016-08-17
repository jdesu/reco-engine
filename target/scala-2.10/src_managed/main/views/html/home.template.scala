
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
object home extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Welcome", "homepage")/*1.29*/ {_display_(Seq[Any](format.raw/*1.31*/("""
	Welcome to Amazing Recommendations v 1.0
<!--
	<div>
		<label for="searchQuery">Search: <input _id="searchQuery"
			type="text" _id="searchQuery" />
		</label>
		<button _id="searchButton" onclick="">
		Search
		</button>
	</div>
	<div _id="searchResults">
	Search Results
	</div>
-->

	<script lang="text/javascript">
		function searchHandler() """),format.raw/*18.28*/("""{"""),format.raw/*18.29*/("""
			var q = $("#searchQuery").val();
			if (q) """),format.raw/*20.11*/("""{"""),format.raw/*20.12*/("""
				// alert("Selected: " + year + ", " + month);
			"""),format.raw/*22.4*/("""}"""),format.raw/*22.5*/(""" else """),format.raw/*22.11*/("""{"""),format.raw/*22.12*/("""
				alert("Empty query string");
				return;
			"""),format.raw/*25.4*/("""}"""),format.raw/*25.5*/("""

			$("#searchResults").html("Loading...");


			var searchUrl = "/search/?q="+q;
			$.get(searchUrl, function(data) """),format.raw/*31.36*/("""{"""),format.raw/*31.37*/("""
				var hits = data.hits.hits;
				var i;
				var htmlText = "Total hits: "+data.hits.total+"<br/>\n";
				for( i = 0; i < hits.length; i++) """),format.raw/*35.39*/("""{"""),format.raw/*35.40*/("""
				   var hit = hits[i]._source;
				   var asin = hit.asin;
				   var title = hit.title + "    (" + hit.group + ")";
				   var tags = "<a href='/product/asin/"+asin+"'>"+title+"</a>";
				   htmlText = htmlText + tags + "<br/>\n";
				"""),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""
				   htmlText = htmlText + "";
				$("#searchResults").html(htmlText);
			"""),format.raw/*44.4*/("""}"""),format.raw/*44.5*/(""");

		"""),format.raw/*46.3*/("""}"""),format.raw/*46.4*/("""

        $("#searchQuery").keypress(function(e) """),format.raw/*48.48*/("""{"""),format.raw/*48.49*/("""
            if(e.which == 13) """),format.raw/*49.31*/("""{"""),format.raw/*49.32*/("""
               searchHandler();
            """),format.raw/*51.13*/("""}"""),format.raw/*51.14*/("""
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/(""");
		$("#searchButton").click(searchHandler);
	</script>

""")))})),format.raw/*56.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 16 12:56:12 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/home.scala.html
                    HASH: 21fbbf9a610c60b405a9a015e1e857e0390b2c69
                    MATRIX: 645->1|680->28|719->30|1095->378|1124->379|1199->426|1228->427|1309->481|1337->482|1371->488|1400->489|1476->538|1504->539|1650->657|1679->658|1849->800|1878->801|2145->1041|2173->1042|2277->1119|2305->1120|2338->1126|2366->1127|2443->1176|2472->1177|2531->1208|2560->1209|2633->1254|2662->1255|2698->1264|2727->1265|2817->1324
                    LINES: 22->1|22->1|22->1|39->18|39->18|41->20|41->20|43->22|43->22|43->22|43->22|46->25|46->25|52->31|52->31|56->35|56->35|62->41|62->41|65->44|65->44|67->46|67->46|69->48|69->48|70->49|70->49|72->51|72->51|73->52|73->52|77->56
                    -- GENERATED --
                */
            