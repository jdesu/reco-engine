
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
object book_customer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Option[scala.Tuple2[model.Customer, Option[String]]],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[(model.Customer, Option[String])], customerNumber: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.77*/("""

"""),_display_(Seq[Any](/*3.2*/main("Customer Details", "customer")/*3.38*/ {_display_(Seq[Any](format.raw/*3.40*/("""
    """),_display_(Seq[Any](/*4.6*/for(item <- itemOpt) yield /*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
        <table>
            <tr>
                <td valign="top">
                """),_display_(Seq[Any](/*8.18*/book_customer_view(Some(item._1)))),format.raw/*8.51*/("""
                </td>
            </tr>

            <tr>
                <td valign="top">
                """),_display_(Seq[Any](/*14.18*/defining(item._2)/*14.35*/ { amazonItemOpt =>_display_(Seq[Any](format.raw/*14.54*/("""
                    """),_display_(Seq[Any](/*15.22*/amazonItemOpt/*15.35*/.map/*15.39*/ { aitem =>_display_(Seq[Any](format.raw/*15.50*/("""
                        Amazon Customer ID: <b>"""),_display_(Seq[Any](/*16.49*/customerNumber)),format.raw/*16.63*/("""</b>
                        <div>
                            Top recommendations <div class="bookRecommendations">Loading...</div>
                        </div>

                        <script lang="text/javascript">
                                console.log("searching user recommendations");
                                function searchHandler() """),format.raw/*23.58*/("""{"""),format.raw/*23.59*/("""
                                    var dataUrl = "/recommendation/for/customer/"""),_display_(Seq[Any](/*24.82*/customerNumber)),format.raw/*24.96*/("""/";
                                    $.get(dataUrl, function (data) """),format.raw/*25.68*/("""{"""),format.raw/*25.69*/("""
                                        console.log(data);
                                        var hits = data;
                                        console.log("hits: " + hits);
                                        var i;
                                        var htmlText = "<br/>\n";
                                        for (Object in hits) """),format.raw/*31.62*/("""{"""),format.raw/*31.63*/("""
                                            var book = hits[Object];
                                            if (!(book.imageUrl === ''
                                                    || book.imageUrl === null
                                                    || book.imageUrl == null
                                                    || book.imageUrl === undefined)) """),format.raw/*36.86*/("""{"""),format.raw/*36.87*/("""
                                                var tags = "<td>"

                                                        + "<img style=vertical-algin:middle height=150px width=150px hspace=20px vspace=20px src="
                                                        + book.imageUrl + "/>"
                                                        + "</td>";
                                                htmlText = htmlText + tags;
                                            """),format.raw/*43.45*/("""}"""),format.raw/*43.46*/("""
                                        """),format.raw/*44.41*/("""}"""),format.raw/*44.42*/("""
                                        console.log("htmlText: " + htmlText);
                                        htmlText = htmlText + "";
                                        $("div.bookRecommendations").html(htmlText);
                                    """),format.raw/*48.37*/("""}"""),format.raw/*48.38*/(""");
                                """),format.raw/*49.33*/("""}"""),format.raw/*49.34*/("""
                                $(document).ready(searchHandler());
                        </script>
                    </td>
            </tr>
        </table>
    """)))})),format.raw/*55.6*/("""
    """)))})),format.raw/*56.6*/("""
    """)))})),format.raw/*57.6*/("""
""")))})))}
    }
    
    def render(itemOpt:Option[scala.Tuple2[model.Customer, Option[String]]],customerNumber:String): play.api.templates.HtmlFormat.Appendable = apply(itemOpt,customerNumber)
    
    def f:((Option[scala.Tuple2[model.Customer, Option[String]]],String) => play.api.templates.HtmlFormat.Appendable) = (itemOpt,customerNumber) => apply(itemOpt,customerNumber)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 16 12:19:49 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/book_customer.scala.html
                    HASH: af76c8ae715d612fba7bb646ecc0a4268bd63ba5
                    MATRIX: 617->1|786->76|823->79|867->115|906->117|946->123|981->143|1020->145|1140->230|1194->263|1340->373|1366->390|1423->409|1481->431|1503->444|1516->448|1565->459|1650->508|1686->522|2071->879|2100->880|2218->962|2254->976|2353->1047|2382->1048|2771->1409|2800->1410|3209->1791|3238->1792|3747->2273|3776->2274|3845->2315|3874->2316|4168->2582|4197->2583|4260->2618|4289->2619|4489->2788|4526->2794|4563->2800
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|29->8|29->8|35->14|35->14|35->14|36->15|36->15|36->15|36->15|37->16|37->16|44->23|44->23|45->24|45->24|46->25|46->25|52->31|52->31|57->36|57->36|64->43|64->43|65->44|65->44|69->48|69->48|70->49|70->49|76->55|77->56|78->57
                    -- GENERATED --
                */
            