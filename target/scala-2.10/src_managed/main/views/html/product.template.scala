
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
object product extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.AmazonMeta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[model.AmazonMeta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""

"""),_display_(Seq[Any](/*3.2*/main(s"Product Details", "product")/*3.37*/ {_display_(Seq[Any](format.raw/*3.39*/("""
	"""),_display_(Seq[Any](/*4.3*/product_view(itemOpt))),format.raw/*4.24*/("""
""")))})))}
    }
    
    def render(itemOpt:Option[model.AmazonMeta]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[model.AmazonMeta]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 22:16:13 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/product.scala.html
                    HASH: b4f307ccb56401594716901c043ad7897860d3f9
                    MATRIX: 576->1|705->36|742->39|785->74|824->76|861->79|903->100
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4
                    -- GENERATED --
                */
            