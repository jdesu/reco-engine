
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
object trending extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.1*/("""
"""),_display_(Seq[Any](/*3.2*/main("Monthly Trends", "trends")/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""
	
	Select year and and a month and then click on Fetch
	
	<div>
	Select a year:
	<select _id="select_year">
	  <option value="2002">2002</option>
	  <option value="2003">2003</option>
	  <option value="2004">2004</option>
	  <option value="2005">2005</option>
	</select>
	
	Select a month: 
	
	<select _id="select_month">
	  <option value="1">January</option>
	  <option value="2">February</option>
	  <option value="3">March</option>
	  <option value="4">April</option>
	  <option value="5">May</option>
	  <option value="6">June</option>
	  <option value="7">July</option>
	  <option value="8">August</option>
	  <option value="9">September</option>
	  <option value="10">October</option>
	  <option value="11">November</option>
	  <option value="12">December</option>
	</select> 
	
	<button _id="btn_fetch">Fetch</button>
	
	</div>
	
	<h3>Trending Products</h3>
	<div _id="trending_products">
	Select year and and a month and then click on Fetch
	</div>
	
	<h3>Trending Customers</h3>
	<div _id="trending_customers">
	Select year and and a month and then click on Fetch
	</div>
	
	<script lang="text/javascript">
		function clickHandler() """),format.raw/*48.27*/("""{"""),format.raw/*48.28*/("""
			var year = $("#select_year").val();
			var month = $("#select_month").val();
			if (year && month) """),format.raw/*51.23*/("""{"""),format.raw/*51.24*/("""
				// alert("Selected: " + year + ", " + month);
			"""),format.raw/*53.4*/("""}"""),format.raw/*53.5*/(""" else """),format.raw/*53.11*/("""{"""),format.raw/*53.12*/("""
				alert("Select year and a month");
			"""),format.raw/*55.4*/("""}"""),format.raw/*55.5*/("""

			$("#trending_products").html("Loading...");
			
			var yearMonth = year + "/" + month + "/"; //"year-month"
			var trendingProductsUrl = "/recommendation/trending/product/"
					+ yearMonth;
			$.get(trendingProductsUrl, function(data) """),format.raw/*62.46*/("""{"""),format.raw/*62.47*/("""
				var htmlText = "";
				for(i in data) """),format.raw/*64.20*/("""{"""),format.raw/*64.21*/("""
					htmlText += data[i] + "<br/>";
				"""),format.raw/*66.5*/("""}"""),format.raw/*66.6*/("""
				$("#trending_products").html(htmlText);
				
			"""),format.raw/*69.4*/("""}"""),format.raw/*69.5*/(""");

			var trendingCustomersUrl = "/recommendation/trending/customer/"
					+ yearMonth;
			
			$("#trending_customers").html("Loading...");
			$.get(trendingCustomersUrl, function(data) """),format.raw/*75.47*/("""{"""),format.raw/*75.48*/("""
				var htmlText = "";
				for(i in data) """),format.raw/*77.20*/("""{"""),format.raw/*77.21*/("""
					htmlText += data[i] + "<br/>";
				"""),format.raw/*79.5*/("""}"""),format.raw/*79.6*/("""
				$("#trending_customers").html(htmlText);

			"""),format.raw/*82.4*/("""}"""),format.raw/*82.5*/(""");
		"""),format.raw/*83.3*/("""}"""),format.raw/*83.4*/("""

		$("#btn_fetch").click(clickHandler);
	</script>
	
	
""")))})),format.raw/*89.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Aug 12 17:25:54 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/trending.scala.html
                    HASH: f1f637414e432bed27531c1372d833a2d8c2a158
                    MATRIX: 656->17|692->19|732->51|771->53|1942->1196|1971->1197|2102->1300|2131->1301|2212->1355|2240->1356|2274->1362|2303->1363|2372->1405|2400->1406|2669->1647|2698->1648|2769->1691|2798->1692|2866->1733|2894->1734|2974->1787|3002->1788|3217->1975|3246->1976|3317->2019|3346->2020|3414->2061|3442->2062|3519->2112|3547->2113|3579->2118|3607->2119|3695->2176
                    LINES: 23->2|24->3|24->3|24->3|69->48|69->48|72->51|72->51|74->53|74->53|74->53|74->53|76->55|76->55|83->62|83->62|85->64|85->64|87->66|87->66|90->69|90->69|96->75|96->75|98->77|98->77|100->79|100->79|103->82|103->82|104->83|104->83|110->89
                    -- GENERATED --
                */
            