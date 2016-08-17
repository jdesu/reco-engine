
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
object most_popular_products extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[model.AmazonMeta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(items: Seq[model.AmazonMeta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/main("Most Popular Products", "mostpopular")/*3.46*/ {_display_(Seq[Any](format.raw/*3.48*/("""
	"""),_display_(Seq[Any](/*4.3*/for( item <- items) yield /*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
	  <a href="/product/asin/"""),_display_(Seq[Any](/*5.28*/item/*5.32*/.asin)),format.raw/*5.37*/(""""><b>"""),_display_(Seq[Any](/*5.43*/(item.title))),format.raw/*5.55*/("""</b></a>
	  <a href="#">("""),_display_(Seq[Any](/*6.18*/item/*6.22*/.group)),format.raw/*6.28*/(""")</a>
	  </br>
	""")))})),format.raw/*8.3*/("""
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(items:Seq[model.AmazonMeta]): play.api.templates.HtmlFormat.Appendable = apply(items)
    
    def f:((Seq[model.AmazonMeta]) => play.api.templates.HtmlFormat.Appendable) = (items) => apply(items)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 22:16:13 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/most_popular_products.scala.html
                    HASH: 9b03a20c9d1d2a0638758d09d67656950fe530d4
                    MATRIX: 587->1|711->31|748->34|800->78|839->80|876->83|910->102|949->104|1012->132|1024->136|1050->141|1091->147|1124->159|1185->185|1197->189|1224->195|1271->212|1303->214
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|26->5|26->5|27->6|27->6|27->6|29->8|30->9
                    -- GENERATED --
                */
            