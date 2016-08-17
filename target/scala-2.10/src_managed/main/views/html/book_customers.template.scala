
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
object book_customers extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[model.Customer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(items: Seq[model.Customer]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),_display_(Seq[Any](/*3.2*/main("Customers", "customers")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

  """),_display_(Seq[Any](/*5.4*/for( item <- items) yield /*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
    <a href="customer/"""),_display_(Seq[Any](/*6.24*/(item.EmailAddress))),format.raw/*6.43*/(""""><b>"""),_display_(Seq[Any](/*6.49*/(item.GivenName))),format.raw/*6.65*/(""" """),_display_(Seq[Any](/*6.67*/(item.Surname))),format.raw/*6.81*/("""</b></a>
    </br>
  """)))})),format.raw/*8.4*/("""
""")))})))}
    }
    
    def render(items:Seq[model.Customer]): play.api.templates.HtmlFormat.Appendable = apply(items)
    
    def f:((Seq[model.Customer]) => play.api.templates.HtmlFormat.Appendable) = (items) => apply(items)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 14 01:13:10 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/book_customers.scala.html
                    HASH: 36830879cd42a9d4f57c7623b3f519f57b8479c2
                    MATRIX: 578->1|700->29|737->32|775->62|814->64|853->69|887->88|926->90|985->114|1025->133|1066->139|1103->155|1140->157|1175->171|1227->193
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|27->6|27->6|27->6|27->6|27->6|27->6|29->8
                    -- GENERATED --
                */
            