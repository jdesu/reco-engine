package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.{ Action, Controller }
import util.ReactiveDB
import util.Recommender
import play.Logger

object BookCustomerController extends Controller {

  def list() = Action.async {
    val itemsF = ReactiveDB.allCustomers.collect[Seq](100, true)
    itemsF map { items =>
      Ok(views.html.book_customers(items))
    }
  }

  def get(EmailAddress: String) = Action.async {
    //val PROFILE_CONSTANT = 50000
    //val customerNumber = (Math.random() * PROFILE_CONSTANT).toInt
    //val customerNumber = 19684

    val customerProfileNumber = ReactiveDB.getProfileForEmailAddress(EmailAddress)

    val itemF = ReactiveDB.getOneCustomerByEmailAddress(EmailAddress)
    itemF.map { itemOpt =>
      Ok(views.html.book_customer(itemOpt, customerProfileNumber))
    }
  }

  def getBook(asin: String) = Action.async {
    val itemCursor = ReactiveDB.getBookByISBN(asin)
    val itemsF = itemCursor.collect[List](1, true)
    itemsF.map { items =>
      val itemOpt = items match {
        case x :: xs => Some(x)
        case _ => None
      }
      Ok(views.html.book(itemOpt))
    }
  }
}
