
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
object product_view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.AmazonMeta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[model.AmazonMeta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import util.ReactiveDB.getCustomerNumber


Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/itemOpt/*4.9*/.map/*4.13*/ { item =>_display_(Seq[Any](format.raw/*4.23*/("""
	  <table>
	    <tr>
	      <td valign="top" width="40%">
<div>
	  <a href="/product/asin/"""),_display_(Seq[Any](/*9.28*/item/*9.32*/.asin)),format.raw/*9.37*/(""""><b>"""),_display_(Seq[Any](/*9.43*/(item.title))),format.raw/*9.55*/("""</b></a>
	  <a href="/product/group/"""),_display_(Seq[Any](/*10.29*/item/*10.33*/.group)),format.raw/*10.39*/("""">("""),_display_(Seq[Any](/*10.43*/item/*10.47*/.group)),format.raw/*10.53*/(""")</a>

	                       <br/>
	  ASIN: """),_display_(Seq[Any](/*13.11*/item/*13.15*/.asin)),format.raw/*13.20*/("""           <br/>
	  Title: """),_display_(Seq[Any](/*14.12*/item/*14.16*/.title)),format.raw/*14.22*/("""          <br/>
	  Sales Rank: """),_display_(Seq[Any](/*15.17*/item/*15.21*/.salesrank)),format.raw/*15.31*/("""      <br/>
	  Similar Items: </br>
	  """),_display_(Seq[Any](/*17.5*/for(s <- item.similar) yield /*17.27*/ {_display_(Seq[Any](format.raw/*17.29*/("""
	  	<a href="/product/asin/"""),_display_(Seq[Any](/*18.29*/s)),format.raw/*18.30*/("""">"""),_display_(Seq[Any](/*18.33*/s)),format.raw/*18.34*/("""</a> 
	  """)))})),format.raw/*19.5*/("""        <br/>
	   <br/>
	  Categories: </br></br>
	  """),_display_(Seq[Any](/*22.5*/for(cat <- item.categories) yield /*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
	    """),_display_(Seq[Any](/*23.7*/{cat.map(_.name).mkString("/")})),format.raw/*23.38*/(""" </br>
	  """)))})),format.raw/*24.5*/("""
	      </td>

	      <td>
<div>
	  Overall Review:
	   Total("""),_display_(Seq[Any](/*30.12*/item/*30.16*/.overallReview.total)),format.raw/*30.36*/("""),
	   Downloaded("""),_display_(Seq[Any](/*31.17*/item/*31.21*/.overallReview.downloaded)),format.raw/*31.46*/("""),
	    Average Rating ("""),_display_(Seq[Any](/*32.23*/item/*32.27*/.overallReview.averageRating)),format.raw/*32.55*/(""")
       <br/>
        <br/>
       Reviews:  <br/>
        <br/>
	  """),_display_(Seq[Any](/*37.5*/for(review <- item.reviews) yield /*37.32*/ {_display_(Seq[Any](format.raw/*37.34*/("""
	  	Date: """),_display_(Seq[Any](/*38.12*/review/*38.18*/.date)),format.raw/*38.23*/(""" <br/>
	  	Customer: <a href="/customer/"""),_display_(Seq[Any](/*39.35*/{getCustomerNumber(review.customer)})),format.raw/*39.71*/("""">"""),_display_(Seq[Any](/*39.74*/review/*39.80*/.customer)),format.raw/*39.89*/("""</a> <br/>
	  	Rating: """),_display_(Seq[Any](/*40.14*/review/*40.20*/.rating)),format.raw/*40.27*/(""" <br/>
	  	Rating: """),_display_(Seq[Any](/*41.14*/review/*41.20*/.votes)),format.raw/*41.26*/(""" <br/>
	  	Helpful: """),_display_(Seq[Any](/*42.15*/review/*42.21*/.helpful)),format.raw/*42.29*/(""" <br/>
	  	 <br/>
	  	""")))})),format.raw/*44.6*/("""
</div>
	      </td>

	    </tr>
	  </table>
	  
""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(itemOpt:Option[model.AmazonMeta]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[model.AmazonMeta]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 22:16:13 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/product_view.scala.html
                    HASH: 2261b6abb92d57a082407fb93ce84266de1557bb
                    MATRIX: 581->1|751->36|778->79|814->81|828->88|840->92|887->102|1014->194|1026->198|1052->203|1093->209|1126->221|1199->258|1212->262|1240->268|1280->272|1293->276|1321->282|1404->329|1417->333|1444->338|1508->366|1521->370|1549->376|1617->408|1630->412|1662->422|1737->462|1775->484|1815->486|1880->515|1903->516|1942->519|1965->520|2006->530|2095->584|2138->611|2178->613|2220->620|2273->651|2315->662|2414->725|2427->729|2469->749|2524->768|2537->772|2584->797|2645->822|2658->826|2708->854|2813->924|2856->951|2896->953|2944->965|2959->971|2986->976|3063->1017|3121->1053|3160->1056|3175->1062|3206->1071|3266->1095|3281->1101|3310->1108|3366->1128|3381->1134|3409->1140|3466->1161|3481->1167|3511->1175|3565->1198|3646->1248
                    LINES: 19->1|23->1|24->3|25->4|25->4|25->4|25->4|30->9|30->9|30->9|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|38->17|38->17|38->17|39->18|39->18|39->18|39->18|40->19|43->22|43->22|43->22|44->23|44->23|45->24|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|58->37|58->37|58->37|59->38|59->38|59->38|60->39|60->39|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|63->42|63->42|63->42|65->44|72->51
                    -- GENERATED --
                */
            