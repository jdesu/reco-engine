
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
object customers extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[model.Customer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(items: Seq[model.Customer]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),_display_(Seq[Any](/*3.2*/main("Customers", "customers")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

	"""),_display_(Seq[Any](/*5.3*/for( item <- items) yield /*5.22*/ {_display_(Seq[Any](format.raw/*5.24*/("""
	  <a href="/customer/"""),_display_(Seq[Any](/*6.24*/(item.EmailAddress))),format.raw/*6.43*/(""""><b>"""),_display_(Seq[Any](/*6.49*/(item.GivenName))),format.raw/*6.65*/(""" """),_display_(Seq[Any](/*6.67*/(item.Surname))),format.raw/*6.81*/("""</b></a>
	  </br>
	""")))})),format.raw/*8.3*/("""

""")))})),format.raw/*10.2*/("""
"""))}
    }
    
    def render(items:Seq[model.Customer]): play.api.templates.HtmlFormat.Appendable = apply(items)
    
    def f:((Seq[model.Customer]) => play.api.templates.HtmlFormat.Appendable) = (items) => apply(items)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 25 20:53:18 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/customers.scala.html
                    HASH: 8426d0fb59397a6a25ab768a40e70642b0359c4a
                    MATRIX: 573->1|695->29|732->32|770->62|809->64|847->68|881->87|920->89|979->113|1019->132|1060->138|1097->154|1134->156|1169->170|1219->190|1253->193
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|27->6|27->6|27->6|27->6|27->6|27->6|29->8|31->10
                    -- GENERATED --
                */
            