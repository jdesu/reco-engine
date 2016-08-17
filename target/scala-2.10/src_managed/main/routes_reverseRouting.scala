// @SOURCE:/Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/webapp-recommender/conf/routes
// @HASH:1e4243a292bfe4a8b0538d6d18e00b548e0a09c9
// @DATE:Mon Aug 15 13:20:23 PDT 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:30
class ReverseAssets {
    

// @LINE:30
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:29
class ReverseWebJarAssets {
    

// @LINE:29
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
class ReverseCustomerController {
    

// @LINE:7
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "customers")
}
                                                

// @LINE:8
def get(_id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "customer/" + implicitly[PathBindable[String]].unbind("_id", dynamicString(_id)))
}
                                                
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseBookCustomerController {
    

// @LINE:9
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "book/customers")
}
                                                

// @LINE:11
def getBook(asin:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "book/asin/" + implicitly[PathBindable[String]].unbind("asin", dynamicString(asin)))
}
                                                

// @LINE:10
def get(_id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "book/customer/" + implicitly[PathBindable[String]].unbind("_id", dynamicString(_id)))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseProductController {
    

// @LINE:12
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "products")
}
                                                

// @LINE:14
def getForGroup(group:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/group/" + implicitly[PathBindable[String]].unbind("group", dynamicString(group)))
}
                                                

// @LINE:13
def getGroups(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/groups/")
}
                                                

// @LINE:15
def get(asin:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/asin/" + implicitly[PathBindable[String]].unbind("asin", dynamicString(asin)))
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:26
class ReverseSearchController {
    

// @LINE:26
def searchProducts(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/")
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
class ReverseRecommendationController {
    

// @LINE:19
def trends(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/trends")
}
                                                

// @LINE:23
def recommendationsForCustomer(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/for/customer/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/")
}
                                                

// @LINE:16
def topRated(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/topRated")
}
                                                

// @LINE:21
def trendingProduct(year:Int, month:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/trending/product/" + implicitly[PathBindable[Int]].unbind("year", year) + "/" + implicitly[PathBindable[Int]].unbind("month", month) + "/")
}
                                                

// @LINE:17
def mostPopular(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/mostPopular")
}
                                                

// @LINE:22
def trendingCustomer(year:Int, month:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recommendation/trending/customer/" + implicitly[PathBindable[Int]].unbind("year", year) + "/" + implicitly[PathBindable[Int]].unbind("month", month) + "/")
}
                                                

// @LINE:24
def productRecommendationsForCustomer(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/recommendation/for/customer/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/")
}
                                                
    
}
                          
}
                  


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:30
class ReverseAssets {
    

// @LINE:30
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:29
class ReverseWebJarAssets {
    

// @LINE:29
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebJarAssets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
class ReverseCustomerController {
    

// @LINE:7
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CustomerController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customers"})
      }
   """
)
                        

// @LINE:8
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CustomerController.get",
   """
      function(_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("_id", encodeURIComponent(_id))})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseBookCustomerController {
    

// @LINE:9
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookCustomerController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "book/customers"})
      }
   """
)
                        

// @LINE:11
def getBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookCustomerController.getBook",
   """
      function(asin) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "book/asin/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("asin", encodeURIComponent(asin))})
      }
   """
)
                        

// @LINE:10
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BookCustomerController.get",
   """
      function(_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "book/customer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("_id", encodeURIComponent(_id))})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseProductController {
    

// @LINE:12
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
      }
   """
)
                        

// @LINE:14
def getForGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.getForGroup",
   """
      function(group) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/group/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("group", encodeURIComponent(group))})
      }
   """
)
                        

// @LINE:13
def getGroups : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.getGroups",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/groups/"})
      }
   """
)
                        

// @LINE:15
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.get",
   """
      function(asin) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/asin/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("asin", encodeURIComponent(asin))})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:26
class ReverseSearchController {
    

// @LINE:26
def searchProducts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchController.searchProducts",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/"})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
class ReverseRecommendationController {
    

// @LINE:19
def trends : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.trends",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/trends"})
      }
   """
)
                        

// @LINE:23
def recommendationsForCustomer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.recommendationsForCustomer",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/for/customer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/"})
      }
   """
)
                        

// @LINE:16
def topRated : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.topRated",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/topRated"})
      }
   """
)
                        

// @LINE:21
def trendingProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.trendingProduct",
   """
      function(year,month) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/trending/product/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("year", year) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("month", month) + "/"})
      }
   """
)
                        

// @LINE:17
def mostPopular : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.mostPopular",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/mostPopular"})
      }
   """
)
                        

// @LINE:22
def trendingCustomer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.trendingCustomer",
   """
      function(year,month) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation/trending/customer/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("year", year) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("month", month) + "/"})
      }
   """
)
                        

// @LINE:24
def productRecommendationsForCustomer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecommendationController.productRecommendationsForCustomer",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/recommendation/for/customer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:30
class ReverseAssets {
    

// @LINE:30
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:29
class ReverseWebJarAssets {
    

// @LINE:29
def at(file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebJarAssets.at(file), HandlerDef(this, "controllers.WebJarAssets", "at", Seq(classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """webjars/$file<.+>""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
class ReverseCustomerController {
    

// @LINE:7
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CustomerController.list(), HandlerDef(this, "controllers.CustomerController", "list", Seq(), "GET", """""", _prefix + """customers""")
)
                      

// @LINE:8
def get(_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CustomerController.get(_id), HandlerDef(this, "controllers.CustomerController", "get", Seq(classOf[String]), "GET", """""", _prefix + """customer/$_id<[^/]+>""")
)
                      
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseBookCustomerController {
    

// @LINE:9
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookCustomerController.list(), HandlerDef(this, "controllers.BookCustomerController", "list", Seq(), "GET", """""", _prefix + """book/customers""")
)
                      

// @LINE:11
def getBook(asin:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookCustomerController.getBook(asin), HandlerDef(this, "controllers.BookCustomerController", "getBook", Seq(classOf[String]), "GET", """""", _prefix + """book/asin/$asin<[^/]+>""")
)
                      

// @LINE:10
def get(_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BookCustomerController.get(_id), HandlerDef(this, "controllers.BookCustomerController", "get", Seq(classOf[String]), "GET", """""", _prefix + """book/customer/$_id<[^/]+>""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseProductController {
    

// @LINE:12
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.list(), HandlerDef(this, "controllers.ProductController", "list", Seq(), "GET", """""", _prefix + """products""")
)
                      

// @LINE:14
def getForGroup(group:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.getForGroup(group), HandlerDef(this, "controllers.ProductController", "getForGroup", Seq(classOf[String]), "GET", """""", _prefix + """product/group/$group<[^/]+>""")
)
                      

// @LINE:13
def getGroups(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.getGroups(), HandlerDef(this, "controllers.ProductController", "getGroups", Seq(), "GET", """""", _prefix + """product/groups/""")
)
                      

// @LINE:15
def get(asin:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.get(asin), HandlerDef(this, "controllers.ProductController", "get", Seq(classOf[String]), "GET", """""", _prefix + """product/asin/$asin<[^/]+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:26
class ReverseSearchController {
    

// @LINE:26
def searchProducts(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SearchController.searchProducts(), HandlerDef(this, "controllers.SearchController", "searchProducts", Seq(), "GET", """""", _prefix + """search/""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
class ReverseRecommendationController {
    

// @LINE:19
def trends(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.trends(), HandlerDef(this, "controllers.RecommendationController", "trends", Seq(), "GET", """""", _prefix + """recommendation/trends""")
)
                      

// @LINE:23
def recommendationsForCustomer(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.recommendationsForCustomer(id), HandlerDef(this, "controllers.RecommendationController", "recommendationsForCustomer", Seq(classOf[String]), "GET", """""", _prefix + """recommendation/for/customer/$id<[^/]+>/""")
)
                      

// @LINE:16
def topRated(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.topRated(), HandlerDef(this, "controllers.RecommendationController", "topRated", Seq(), "GET", """""", _prefix + """recommendation/topRated""")
)
                      

// @LINE:21
def trendingProduct(year:Int, month:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.trendingProduct(year, month), HandlerDef(this, "controllers.RecommendationController", "trendingProduct", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """recommendation/trending/product/$year<[^/]+>/$month<[^/]+>/""")
)
                      

// @LINE:17
def mostPopular(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.mostPopular(), HandlerDef(this, "controllers.RecommendationController", "mostPopular", Seq(), "GET", """""", _prefix + """recommendation/mostPopular""")
)
                      

// @LINE:22
def trendingCustomer(year:Int, month:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.trendingCustomer(year, month), HandlerDef(this, "controllers.RecommendationController", "trendingCustomer", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """recommendation/trending/customer/$year<[^/]+>/$month<[^/]+>/""")
)
                      

// @LINE:24
def productRecommendationsForCustomer(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecommendationController.productRecommendationsForCustomer(id), HandlerDef(this, "controllers.RecommendationController", "productRecommendationsForCustomer", Seq(classOf[String]), "GET", """""", _prefix + """product/recommendation/for/customer/$id<[^/]+>/""")
)
                      
    
}
                          
}
        
    