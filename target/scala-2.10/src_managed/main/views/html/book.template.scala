
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
object book extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.Book],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(books: Option[model.Book]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.29*/("""

"""),_display_(Seq[Any](/*3.2*/main(s"Book Details", "book")/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
  """),_display_(Seq[Any](/*4.4*/for( book <- books) yield /*4.23*/ {_display_(Seq[Any](format.raw/*4.25*/("""
    <img src="""),_display_(Seq[Any](/*5.15*/book/*5.19*/.imageUrl)),format.raw/*5.28*/(""">                <br/>
    Title:    """),_display_(Seq[Any](/*6.16*/book/*6.20*/.title)),format.raw/*6.26*/("""                   <br/>
    Author:   """),_display_(Seq[Any](/*7.16*/book/*7.20*/.author)),format.raw/*7.27*/("""                  <br/>
    </div>
    </br>
  """)))})),format.raw/*10.4*/("""
""")))})),format.raw/*11.2*/("""

"""))}
    }
    
    def render(books:Option[model.Book]): play.api.templates.HtmlFormat.Appendable = apply(books)
    
    def f:((Option[model.Book]) => play.api.templates.HtmlFormat.Appendable) = (books) => apply(books)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Aug 15 22:29:43 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/book.scala.html
                    HASH: e952f180aa688ada0e49862c64c86792aaf8beae
                    MATRIX: 567->1|688->28|725->31|762->60|801->62|839->66|873->85|912->87|962->102|974->106|1004->115|1077->153|1089->157|1116->163|1191->203|1203->207|1231->214|1310->262|1343->264
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|31->10|32->11
                    -- GENERATED --
                */
            