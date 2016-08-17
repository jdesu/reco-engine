
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
object product_groups extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(groups: Seq[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""

"""),_display_(Seq[Any](/*3.2*/main("Product Groups", "groups")/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""
	"""),_display_(Seq[Any](/*4.3*/for( group <- groups) yield /*4.24*/ {_display_(Seq[Any](format.raw/*4.26*/("""
	  <a href="/product/group/"""),_display_(Seq[Any](/*5.29*/group)),format.raw/*5.34*/(""""><b>"""),_display_(Seq[Any](/*5.40*/group)),format.raw/*5.45*/("""</b></a>
	  </br>
	""")))})),format.raw/*7.3*/("""
""")))})),format.raw/*8.2*/("""
"""))}
    }
    
    def render(groups:Seq[String]): play.api.templates.HtmlFormat.Appendable = apply(groups)
    
    def f:((Seq[String]) => play.api.templates.HtmlFormat.Appendable) = (groups) => apply(groups)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 22:16:13 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/product_groups.scala.html
                    HASH: 4953a02dc5fefd356af3b678c98664321388b902
                    MATRIX: 570->1|685->22|722->25|762->57|801->59|838->62|874->83|913->85|977->114|1003->119|1044->125|1070->130|1120->150|1152->152
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|26->5|28->7|29->8
                    -- GENERATED --
                */
            