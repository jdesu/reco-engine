
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
object customer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[scala.Tuple2[model.Customer, Option[String]]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[(model.Customer, Option[String])]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.53*/("""

"""),_display_(Seq[Any](/*3.2*/main("Customer Details", "customer")/*3.38*/ {_display_(Seq[Any](format.raw/*3.40*/("""
	"""),_display_(Seq[Any](/*4.3*/for(item <- itemOpt) yield /*4.23*/ {_display_(Seq[Any](format.raw/*4.25*/("""
<table>
<tr>
<td valign="top">
    	"""),_display_(Seq[Any](/*8.7*/customer_view(Some(item._1)))),format.raw/*8.35*/("""
</td>
<td valign="top">
		"""),_display_(Seq[Any](/*11.4*/defining(item._2)/*11.21*/ { amazonItemOpt =>_display_(Seq[Any](format.raw/*11.40*/("""
			"""),_display_(Seq[Any](/*12.5*/amazonItemOpt/*12.18*/.map/*12.22*/ { aitem =>_display_(Seq[Any](format.raw/*12.33*/("""
				Amazon Customer ID:	<b>"""),_display_(Seq[Any](/*13.29*/aitem)),format.raw/*13.34*/("""</b>
				<div>
				  Top 10 recommendations <div class="productRecommendations">Loading...</div>
				</div>
				
	<script lang="text/javascript">
		console.log("searching user recommendations");
		function searchHandler() """),format.raw/*20.28*/("""{"""),format.raw/*20.29*/("""
			var dataUrl = "/product/recommendation/for/customer/"""),_display_(Seq[Any](/*21.57*/aitem)),format.raw/*21.62*/("""/";
			$.get(dataUrl, function(data) """),format.raw/*22.34*/("""{"""),format.raw/*22.35*/("""
				var hits = data.results;
				var i;
				var htmlText = "<br/>\n";
				for (asin in hits) """),format.raw/*26.24*/("""{"""),format.raw/*26.25*/("""
					var rating = hits[asin];
				    var tags = "<a target='_blank' href='/product/asin/"+asin+"'>"+asin+" ("+rating+")"+"</a>";
					htmlText = htmlText + tags + "<br/>\n";
				"""),format.raw/*30.5*/("""}"""),format.raw/*30.6*/("""
				htmlText = htmlText + "";
				$("div.productRecommendations").html(htmlText);
			"""),format.raw/*33.4*/("""}"""),format.raw/*33.5*/(""");

		"""),format.raw/*35.3*/("""}"""),format.raw/*35.4*/("""
		$(document).ready(searchHandler());
	</script>
</td>
</tr>
</table>
			""")))})),format.raw/*41.5*/("""
		""")))})),format.raw/*42.4*/("""
	""")))})),format.raw/*43.3*/("""
""")))})),format.raw/*44.2*/("""

"""))}
    }
    
    def render(itemOpt:Option[scala.Tuple2[model.Customer, Option[String]]]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[scala.Tuple2[model.Customer, Option[String]]]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Aug 15 11:57:03 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/customer.scala.html
                    HASH: 840fd22bcf3b122eea1140aa3d70ccf17f8c43e1
                    MATRIX: 605->1|750->52|787->55|831->91|870->93|907->96|942->116|981->118|1053->156|1102->184|1165->212|1191->229|1248->248|1288->253|1310->266|1323->270|1372->281|1437->310|1464->315|1714->537|1743->538|1836->595|1863->600|1928->637|1957->638|2079->732|2108->733|2315->913|2343->914|2456->1000|2484->1001|2517->1007|2545->1008|2651->1083|2686->1087|2720->1090|2753->1092
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|29->8|29->8|32->11|32->11|32->11|33->12|33->12|33->12|33->12|34->13|34->13|41->20|41->20|42->21|42->21|43->22|43->22|47->26|47->26|51->30|51->30|54->33|54->33|56->35|56->35|62->41|63->42|64->43|65->44
                    -- GENERATED --
                */
            