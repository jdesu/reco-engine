
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
object book_view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[model.Book],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(itemOpt: Option[model.Book]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""
"""),_display_(Seq[Any](/*2.2*/itemOpt/*2.9*/.map/*2.13*/ { item =>_display_(Seq[Any](format.raw/*2.23*/("""
    <table>
        <tr>
            <td valign="top" width="40%">
                <div>
                    <br/>
                    <img src="""),_display_(Seq[Any](/*8.31*/item/*8.35*/.imageUrl)),format.raw/*8.44*/(""">                <br/>
                    Title:    """),_display_(Seq[Any](/*9.32*/item/*9.36*/.title)),format.raw/*9.42*/("""                   <br/>
                    Author:   """),_display_(Seq[Any](/*10.32*/item/*10.36*/.author)),format.raw/*10.43*/("""                  <br/>
                    </div>
            </td>
        </tr>
    </table>
""")))})))}
    }
    
    def render(itemOpt:Option[model.Book]): play.api.templates.HtmlFormat.Appendable = apply(itemOpt)
    
    def f:((Option[model.Book]) => play.api.templates.HtmlFormat.Appendable) = (itemOpt) => apply(itemOpt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Aug 15 13:49:07 PDT 2016
                    SOURCE: /Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/app/views/book_view.scala.html
                    HASH: 7e6dc293bf2f014fc6915e7e4871ed17fd5a2feb
                    MATRIX: 572->1|695->30|731->32|745->39|757->43|804->53|985->199|997->203|1027->212|1116->266|1128->270|1155->276|1247->332|1260->336|1289->343
                    LINES: 19->1|22->1|23->2|23->2|23->2|23->2|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10
                    -- GENERATED --
                */
            