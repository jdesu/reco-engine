package controllers

import java.util.concurrent.TimeUnit

import model.Book

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import play.api.mvc.Action
import play.api.mvc.Controller
import util.Database
import util.ReactiveDB
import play.api.libs.json.Json
import play.api.libs.json.JsValue
import util.Recommender

import scala.concurrent.duration.Duration

object RecommendationController extends Controller {

  def topRated() = Action.async {
    val itemsF = ReactiveDB.topRatedProducts.collect[Seq](100, true)
    itemsF map { items =>
      Ok(views.html.top_rated_products(items))
    }
  }

  def mostPopular() = Action.async {
    val itemsF = ReactiveDB.mostPopularProducts.collect[Seq](100, true)
    itemsF map { items =>
      Ok(views.html.most_popular_products(items))
    }
  }

  def trends() = Action {
    Ok(views.html.trending())
  }

  def trendingProduct(year: Int, month: Int) = Action.async {
    val tpF = Recommender.findTrendingProductsFor(year, month - 1)
    tpF.map { items =>
      Ok(Json.toJson(items))
    }
  }

  def trendingCustomer(year: Int, month: Int) = Action.async {
    val tpF = Recommender.findTrendingCustomersFor(year, month - 1)
    tpF.map { items =>
      Ok(Json.toJson(items))
    }
  }

//  def recommendationsForCustomer(EmailAddress: String) = Action.async {
//    val tpF = Recommender.findOneAmazonCustomerForEmailAddress(EmailAddress)
//    tpF.map { items =>
//      Ok(Json.toJson(items))
//    }
//  }

  def recommendationsForCustomer(customerId: String) = Action.async {
    val bookIds = Recommender.findForCustomer(customerId)
    val bookSet = Await.result(bookIds, Duration.apply(1, TimeUnit.MINUTES))
    val booksF = ReactiveDB.getBulkBooksByISBN(bookSet)
    booksF.map { books =>
      Ok(Json.toJson(books))
    }
  }

  def productRecommendationsForCustomer(customerId: String) = Action.async {
    val tpF = Recommender.findProductForCustomer(customerId)
    tpF.map { items =>
      Ok(Json.toJson(items))
    }
  }

}