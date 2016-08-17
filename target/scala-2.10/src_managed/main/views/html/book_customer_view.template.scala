
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
object book_customer_view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.Customer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[model.Customer]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.35*/("""

"""),_display_(Seq[Any](/*3.2*/itemOpt/*3.9*/.map/*3.13*/ { item =>_display_(Seq[Any](format.raw/*3.23*/("""
  Name: """),_display_(Seq[Any](/*4.10*/item/*4.14*/.Title)),format.raw/*4.20*/(""" """),_display_(Seq[Any](/*4.22*/item/*4.26*/.GivenName)),format.raw/*4.36*/(""" """),_display_(Seq[Any](/*4.38*/item/*4.42*/.MiddleInitial)),format.raw/*4.56*/(""" """),_display_(Seq[Any](/*4.58*/item/*4.62*/.Surname)),format.raw/*4.70*/(""" <br/>
  Address: <br/>
  """),_display_(Seq[Any](/*6.4*/item/*6.8*/.StreetAddress)),format.raw/*6.22*/(""" <br/>
  """),_display_(Seq[Any](/*7.4*/item/*7.8*/.City)),format.raw/*7.13*/(""" <br/>
  """),_display_(Seq[Any](/*8.4*/item/*8.8*/.StateFull)),format.raw/*8.18*/(""" <br/>
  """),_display_(Seq[Any](/*9.4*/item/*9.8*/.CountryFull)),format.raw/*9.20*/(""" <br/>
  Email Address: """),_display_(Seq[Any](/*10.19*/item/*10.23*/.EmailAddress)),format.raw/*10.36*/(""" <br/>
""")))})))}
    }
    
    def render(itemOpt:Option[model.Customer]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[model.Customer]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Aug 15 23:40:09 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/book_customer_view.scala.html
                    HASH: 6e39b86be1e149f0e8ae70c6c8be1c464e64f17a
                    MATRIX: 585->1|712->34|749->37|763->44|775->48|822->58|867->68|879->72|906->78|943->80|955->84|986->94|1023->96|1035->100|1070->114|1107->116|1119->120|1148->128|1209->155|1220->159|1255->173|1299->183|1310->187|1336->192|1380->202|1391->206|1422->216|1466->226|1477->230|1510->242|1571->267|1584->271|1619->284
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|25->4|25->4|25->4|25->4|25->4|25->4|25->4|25->4|25->4|25->4|25->4|25->4|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10
                    -- GENERATED --
                */
            