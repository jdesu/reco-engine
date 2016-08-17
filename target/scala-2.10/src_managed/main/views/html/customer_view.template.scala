
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
object customer_view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.Customer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[model.Customer]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.35*/("""

"""),_display_(Seq[Any](/*3.2*/itemOpt/*3.9*/.map/*3.13*/ { item =>_display_(Seq[Any](format.raw/*3.23*/("""

  Gender: """),_display_(Seq[Any](/*5.12*/item/*5.16*/.Gender)),format.raw/*5.23*/(""" <br/>
  Nameset: """),_display_(Seq[Any](/*6.13*/item/*6.17*/.NameSet)),format.raw/*6.25*/(""" <br/>
  Name: """),_display_(Seq[Any](/*7.10*/item/*7.14*/.Title)),format.raw/*7.20*/(""" """),_display_(Seq[Any](/*7.22*/item/*7.26*/.GivenName)),format.raw/*7.36*/(""" """),_display_(Seq[Any](/*7.38*/item/*7.42*/.MiddleInitial)),format.raw/*7.56*/(""" """),_display_(Seq[Any](/*7.58*/item/*7.62*/.Surname)),format.raw/*7.70*/(""" <br/>
  Address: <br/>
  """),_display_(Seq[Any](/*9.4*/item/*9.8*/.StreetAddress)),format.raw/*9.22*/(""" <br/>
  """),_display_(Seq[Any](/*10.4*/item/*10.8*/.City)),format.raw/*10.13*/(""" <br/>
  """),_display_(Seq[Any](/*11.4*/item/*11.8*/.StateFull)),format.raw/*11.18*/(""" <br/>
  """),_display_(Seq[Any](/*12.4*/item/*12.8*/.Country)),format.raw/*12.16*/(""" <br/>
  """),_display_(Seq[Any](/*13.4*/item/*13.8*/.CountryFull)),format.raw/*13.20*/(""" <br/>
  <br/>
  Email Address: """),_display_(Seq[Any](/*15.19*/item/*15.23*/.EmailAddress)),format.raw/*15.36*/(""" <br/>  
	
""")))})),format.raw/*17.2*/("""
"""))}
    }
    
    def render(itemOpt:Option[model.Customer]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[model.Customer]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 23 18:31:25 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/customer_view.scala.html
                    HASH: 2e417c920004f8eee3cf43e01bd2a62cbc6b613b
                    MATRIX: 580->1|707->34|744->37|758->44|770->48|817->58|865->71|877->75|905->82|959->101|971->105|1000->113|1051->129|1063->133|1090->139|1127->141|1139->145|1170->155|1207->157|1219->161|1254->175|1291->177|1303->181|1332->189|1393->216|1404->220|1439->234|1484->244|1496->248|1523->253|1568->263|1580->267|1612->277|1657->287|1669->291|1699->299|1744->309|1756->313|1790->325|1859->358|1872->362|1907->375|1950->387
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|28->7|28->7|28->7|28->7|28->7|28->7|28->7|28->7|28->7|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|36->15|36->15|36->15|38->17
                    -- GENERATED --
                */
            