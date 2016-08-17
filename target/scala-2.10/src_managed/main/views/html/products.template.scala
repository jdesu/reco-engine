
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
object products extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[model.AmazonMeta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(items: Seq[model.AmazonMeta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/main("Product Listing", "products")/*3.37*/ {_display_(Seq[Any](format.raw/*3.39*/("""
	"""),_display_(Seq[Any](/*4.3*/for( item <- items) yield /*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
	  <a href="/product/asin/"""),_display_(Seq[Any](/*5.28*/item/*5.32*/.asin)),format.raw/*5.37*/(""""><b>"""),_display_(Seq[Any](/*5.43*/(item.title))),format.raw/*5.55*/("""</b></a>
	  <a href="#">("""),_display_(Seq[Any](/*6.18*/item/*6.22*/.group)),format.raw/*6.28*/(""")</a>
	  <br/>
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
                    DATE: Sat Jul 23 11:43:13 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/products.scala.html
                    HASH: aee2aadfad307e365dd9a66a71a8306867253a32
                    MATRIX: 574->1|698->31|735->34|778->69|817->71|854->74|888->93|927->95|990->123|1002->127|1028->132|1069->138|1102->150|1163->176|1175->180|1202->186|1249->203|1281->205
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|26->5|26->5|27->6|27->6|27->6|29->8|30->9
                    -- GENERATED --
                */
            