// @SOURCE:/Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/conf/routes
// @HASH:1e4243a292bfe4a8b0538d6d18e00b548e0a09c9
// @DATE:Mon Aug 15 13:20:23 PDT 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_CustomerController_list1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("customers"))))
        

// @LINE:8
private[this] lazy val controllers_CustomerController_get2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("customer/"),DynamicPart("_id", """[^/]+""",true))))
        

// @LINE:9
private[this] lazy val controllers_BookCustomerController_list3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("book/customers"))))
        

// @LINE:10
private[this] lazy val controllers_BookCustomerController_get4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("book/customer/"),DynamicPart("_id", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_BookCustomerController_getBook5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("book/asin/"),DynamicPart("asin", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_ProductController_list6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products"))))
        

// @LINE:13
private[this] lazy val controllers_ProductController_getGroups7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/groups/"))))
        

// @LINE:14
private[this] lazy val controllers_ProductController_getForGroup8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/group/"),DynamicPart("group", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_ProductController_get9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/asin/"),DynamicPart("asin", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_RecommendationController_topRated10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/topRated"))))
        

// @LINE:17
private[this] lazy val controllers_RecommendationController_mostPopular11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/mostPopular"))))
        

// @LINE:19
private[this] lazy val controllers_RecommendationController_trends12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/trends"))))
        

// @LINE:21
private[this] lazy val controllers_RecommendationController_trendingProduct13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/trending/product/"),DynamicPart("year", """[^/]+""",true),StaticPart("/"),DynamicPart("month", """[^/]+""",true),StaticPart("/"))))
        

// @LINE:22
private[this] lazy val controllers_RecommendationController_trendingCustomer14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/trending/customer/"),DynamicPart("year", """[^/]+""",true),StaticPart("/"),DynamicPart("month", """[^/]+""",true),StaticPart("/"))))
        

// @LINE:23
private[this] lazy val controllers_RecommendationController_recommendationsForCustomer15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation/for/customer/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"))))
        

// @LINE:24
private[this] lazy val controllers_RecommendationController_productRecommendationsForCustomer16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/recommendation/for/customer/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"))))
        

// @LINE:26
private[this] lazy val controllers_SearchController_searchProducts17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/"))))
        

// @LINE:29
private[this] lazy val controllers_WebJarAssets_at18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webjars/"),DynamicPart("file", """.+""",false))))
        

// @LINE:30
private[this] lazy val controllers_Assets_at19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """customers""","""controllers.CustomerController.list"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """customer/$_id<[^/]+>""","""controllers.CustomerController.get(_id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """book/customers""","""controllers.BookCustomerController.list"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """book/customer/$_id<[^/]+>""","""controllers.BookCustomerController.get(_id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """book/asin/$asin<[^/]+>""","""controllers.BookCustomerController.getBook(asin:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products""","""controllers.ProductController.list"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/groups/""","""controllers.ProductController.getGroups"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/group/$group<[^/]+>""","""controllers.ProductController.getForGroup(group:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/asin/$asin<[^/]+>""","""controllers.ProductController.get(asin:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/topRated""","""controllers.RecommendationController.topRated"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/mostPopular""","""controllers.RecommendationController.mostPopular"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/trends""","""controllers.RecommendationController.trends"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/trending/product/$year<[^/]+>/$month<[^/]+>/""","""controllers.RecommendationController.trendingProduct(year:Int, month:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/trending/customer/$year<[^/]+>/$month<[^/]+>/""","""controllers.RecommendationController.trendingCustomer(year:Int, month:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation/for/customer/$id<[^/]+>/""","""controllers.RecommendationController.recommendationsForCustomer(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/recommendation/for/customer/$id<[^/]+>/""","""controllers.RecommendationController.productRecommendationsForCustomer(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/""","""controllers.SearchController.searchProducts()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""","""controllers.WebJarAssets.at(file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_CustomerController_list1(params) => {
   call { 
        invokeHandler(controllers.CustomerController.list, HandlerDef(this, "controllers.CustomerController", "list", Nil,"GET", """""", Routes.prefix + """customers"""))
   }
}
        

// @LINE:8
case controllers_CustomerController_get2(params) => {
   call(params.fromPath[String]("_id", None)) { (_id) =>
        invokeHandler(controllers.CustomerController.get(_id), HandlerDef(this, "controllers.CustomerController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """customer/$_id<[^/]+>"""))
   }
}
        

// @LINE:9
case controllers_BookCustomerController_list3(params) => {
   call { 
        invokeHandler(controllers.BookCustomerController.list, HandlerDef(this, "controllers.BookCustomerController", "list", Nil,"GET", """""", Routes.prefix + """book/customers"""))
   }
}
        

// @LINE:10
case controllers_BookCustomerController_get4(params) => {
   call(params.fromPath[String]("_id", None)) { (_id) =>
        invokeHandler(controllers.BookCustomerController.get(_id), HandlerDef(this, "controllers.BookCustomerController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """book/customer/$_id<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_BookCustomerController_getBook5(params) => {
   call(params.fromPath[String]("asin", None)) { (asin) =>
        invokeHandler(controllers.BookCustomerController.getBook(asin), HandlerDef(this, "controllers.BookCustomerController", "getBook", Seq(classOf[String]),"GET", """""", Routes.prefix + """book/asin/$asin<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_ProductController_list6(params) => {
   call { 
        invokeHandler(controllers.ProductController.list, HandlerDef(this, "controllers.ProductController", "list", Nil,"GET", """""", Routes.prefix + """products"""))
   }
}
        

// @LINE:13
case controllers_ProductController_getGroups7(params) => {
   call { 
        invokeHandler(controllers.ProductController.getGroups, HandlerDef(this, "controllers.ProductController", "getGroups", Nil,"GET", """""", Routes.prefix + """product/groups/"""))
   }
}
        

// @LINE:14
case controllers_ProductController_getForGroup8(params) => {
   call(params.fromPath[String]("group", None)) { (group) =>
        invokeHandler(controllers.ProductController.getForGroup(group), HandlerDef(this, "controllers.ProductController", "getForGroup", Seq(classOf[String]),"GET", """""", Routes.prefix + """product/group/$group<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_ProductController_get9(params) => {
   call(params.fromPath[String]("asin", None)) { (asin) =>
        invokeHandler(controllers.ProductController.get(asin), HandlerDef(this, "controllers.ProductController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """product/asin/$asin<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_RecommendationController_topRated10(params) => {
   call { 
        invokeHandler(controllers.RecommendationController.topRated, HandlerDef(this, "controllers.RecommendationController", "topRated", Nil,"GET", """""", Routes.prefix + """recommendation/topRated"""))
   }
}
        

// @LINE:17
case controllers_RecommendationController_mostPopular11(params) => {
   call { 
        invokeHandler(controllers.RecommendationController.mostPopular, HandlerDef(this, "controllers.RecommendationController", "mostPopular", Nil,"GET", """""", Routes.prefix + """recommendation/mostPopular"""))
   }
}
        

// @LINE:19
case controllers_RecommendationController_trends12(params) => {
   call { 
        invokeHandler(controllers.RecommendationController.trends, HandlerDef(this, "controllers.RecommendationController", "trends", Nil,"GET", """""", Routes.prefix + """recommendation/trends"""))
   }
}
        

// @LINE:21
case controllers_RecommendationController_trendingProduct13(params) => {
   call(params.fromPath[Int]("year", None), params.fromPath[Int]("month", None)) { (year, month) =>
        invokeHandler(controllers.RecommendationController.trendingProduct(year, month), HandlerDef(this, "controllers.RecommendationController", "trendingProduct", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """recommendation/trending/product/$year<[^/]+>/$month<[^/]+>/"""))
   }
}
        

// @LINE:22
case controllers_RecommendationController_trendingCustomer14(params) => {
   call(params.fromPath[Int]("year", None), params.fromPath[Int]("month", None)) { (year, month) =>
        invokeHandler(controllers.RecommendationController.trendingCustomer(year, month), HandlerDef(this, "controllers.RecommendationController", "trendingCustomer", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """recommendation/trending/customer/$year<[^/]+>/$month<[^/]+>/"""))
   }
}
        

// @LINE:23
case controllers_RecommendationController_recommendationsForCustomer15(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.RecommendationController.recommendationsForCustomer(id), HandlerDef(this, "controllers.RecommendationController", "recommendationsForCustomer", Seq(classOf[String]),"GET", """""", Routes.prefix + """recommendation/for/customer/$id<[^/]+>/"""))
   }
}
        

// @LINE:24
case controllers_RecommendationController_productRecommendationsForCustomer16(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.RecommendationController.productRecommendationsForCustomer(id), HandlerDef(this, "controllers.RecommendationController", "productRecommendationsForCustomer", Seq(classOf[String]),"GET", """""", Routes.prefix + """product/recommendation/for/customer/$id<[^/]+>/"""))
   }
}
        

// @LINE:26
case controllers_SearchController_searchProducts17(params) => {
   call { 
        invokeHandler(controllers.SearchController.searchProducts(), HandlerDef(this, "controllers.SearchController", "searchProducts", Nil,"GET", """""", Routes.prefix + """search/"""))
   }
}
        

// @LINE:29
case controllers_WebJarAssets_at18(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        invokeHandler(controllers.WebJarAssets.at(file), HandlerDef(this, "controllers.WebJarAssets", "at", Seq(classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """webjars/$file<.+>"""))
   }
}
        

// @LINE:30
case controllers_Assets_at19(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     