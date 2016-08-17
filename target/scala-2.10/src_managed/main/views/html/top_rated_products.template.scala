
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
object top_rated_products extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[model.AmazonMeta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(items: Seq[model.AmazonMeta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/main("Top Rated Products", "toprated")/*3.40*/ {_display_(Seq[Any](format.raw/*3.42*/("""
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
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/top_rated_products.scala.html
                    HASH: e2965351a17dc454eff46dcd3ff665c0f84caee5
                    MATRIX: 584->1|708->31|745->34|791->72|830->74|867->77|901->96|940->98|1003->126|1015->130|1041->135|1082->141|1115->153|1176->179|1188->183|1215->189|1262->206|1294->208
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|26->5|26->5|27->6|27->6|27->6|29->8|30->9
                    -- GENERATED --
                */
            