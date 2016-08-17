package util


import com.mongodb.casbah.{MongoClient, MongoCollection}
import configuration.AppConfig
import model._
import reactivemongo.api.MongoDriver
import reactivemongo.bson.{BSONDateTime, BSONDocument, BSONDouble}
import reactivemongo.bson.Producer.nameValue2Producer

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.Logger

import scala.concurrent._
import scala.concurrent.duration._
import scala.util.Random

object ReactiveDB {

  val DBConfig = AppConfig.DBConfig

  def getCollection(collectionName: String) = {
    val mongoClient = MongoClient(DBConfig.dbHost, DBConfig.dbPort)
    val db = mongoClient(DBConfig.dbName)
    db(collectionName)
  }

  def productCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("products")
    collection
  }

  def bookCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("books")
    collection
  }

  def customerCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("customers")
    collection
  }

  def customerMappingCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("customer_mapping")
    collection
  }

  def emailProfileMappingCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("email_to_profile_mapping")
    collection
  }

  def reviewsCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List(DBConfig.dbHost))
    val db = connection(DBConfig.dbName)
    val collection = db("reviews")
    collection
  }

  def getByASIN(asin: String) = {
    val collection = productCollection()
    val query = BSONDocument("asin" -> asin)
    val rs = collection.find(query).cursor[AmazonMeta]
    rs
  }

  def getByGroup(group: String) = {
    val collection = productCollection()
    val query = BSONDocument("group" -> group)
    val rs = collection.find(query).cursor[AmazonMeta]
    (rs)
  }

  def getBookByISBN(id: String) = {
    val collection = bookCollection()
    val query = BSONDocument("_id" -> id)
    val rs = collection.find(query).cursor[Book]
    (rs)
  }

  def getBulkBooksByISBN(ids: Set[String]):Future[Set[Book]] = {
    val collection = bookCollection()
    val query = BSONDocument("_id" -> BSONDocument("$in"-> ids))
    val rs = collection.find(query).cursor[Book]
    val books = rs.collect[Set](25, true)
    books
  }


  def getAll(asin: String) = {
    val collection = productCollection()
    val query = BSONDocument.empty
    val rs = collection.find(query).cursor[AmazonMeta]
    rs
  }

  def allProducts() = {
    val query = BSONDocument.empty
    val collection = productCollection()
    val cursor = collection.find(query).cursor[AmazonMeta]
    cursor
  }

  def topRatedProducts() = {
    val query = BSONDocument.empty
    val sortCriteria = BSONDocument("overallReview.averageRating" -> -1)
    val collection = productCollection()
    val cursor = collection.find(query).sort(sortCriteria).cursor[AmazonMeta]
    cursor
  }

  def mostPopularProducts() = {
    val query = BSONDocument.empty
    val sortCriteria = BSONDocument("overallReview.total" -> -1)
    val collection = productCollection()
    val cursor = collection.find(query).sort(sortCriteria).cursor[AmazonMeta]
    cursor
  }

  def allCustomers() = {
    val query = BSONDocument.empty
    val collection = customerCollection()
    val cursor = collection.find(query).cursor[Customer]
    cursor
  }

  def getCustomerByEmailAddress(EmailAddress: String) = {
    val collection = customerCollection()
    val query = BSONDocument("EmailAddress" -> EmailAddress)
    val rs = collection.find(query).cursor[Customer]
    rs
  }

  def getOneCustomerByEmailAddress(EmailAddress: String): Future[Option[(Customer, Option[String])]] = {
    val itemCursor = getCustomerByEmailAddress(EmailAddress)
    val optF = itemCursor.headOption

    val PROFILE_CONSTANT = 50000
    val customerNumber = (Math.random() * PROFILE_CONSTANT).toInt

    val p = for {
      customerOpt <- optF
      t <- customerOpt match {
        case Some(customer) =>
          val f1 = Recommender.findOneAmazonCustomerForNumber(customerNumber)
            .map { x =>
              val y = Some(customer, x)
              y
            }
          f1.onFailure {
            case t: Throwable => Logger.info(s"onFailure: $t")
          }
          f1.fallbackTo(Future {
            val y = Some(customer, None)
            y
          })
        case None =>
          Future(None)
      }
    } yield t
    p.fallbackTo(Future(None))
  }

  def getCustomerByID(id: String) = {
    val collection = customerCollection()
    val query = BSONDocument("id" -> id)
    val rs = collection.find(query).cursor[Customer]
    rs
  }

  def trendingCustomers(year: Int, month: Int) = {
    val query = BSONDocument.empty
    val sortCriteria = BSONDocument("overallReview.total" -> -1)
    val collection = reviewsCollection()
    val cursor = collection.find(query).sort(sortCriteria).cursor[AmazonMeta]
    cursor
  }

  def oneMonthReviewsFrom(year: Int, month: Int) = {

    val start = DateUtils.dateFor(year, month, 1)
    val end = DateUtils.dateFor(year, month + 1, 1)
    println("Start Date: %s, End Date: %s".format(
      DateUtils.sdfFull.format(start),
      DateUtils.sdfFull.format(end)))

    println(start.getTime(), end.getTime())
    val query = BSONDocument(
      "date" -> BSONDocument(
        "$gte" -> BSONDateTime(start.getTime()),
        "$lt" -> BSONDateTime(end.getTime()) //
        ) //
        )

    val sortCriteria = BSONDocument("votes" -> -1)
    val collection = reviewsCollection()
    val cursor = collection
      .find(query)
      //.sort(sortCriteria)
      .cursor[BSONDocument]

    cursor
  }

  def getAmazonCustomersForCustomerNumber(number: Int) = {
    val collection = customerMappingCollection()
    val query = BSONDocument("customer_number" -> number)
    val rs = collection.find(query).cursor[CustomerMapping]
    rs
  }

  def getAmazonCustomersForEmailAddress(EmailAddress: String) = {
    val collection = customerMappingCollection()
    val query = BSONDocument("EmailAddress" -> EmailAddress)
    val rs = collection.find(query).cursor[CustomerMapping]
    rs
  }

  def getProfileForEmailAddress(id: String):String = {
    val collection = emailProfileMappingCollection()
    val query = BSONDocument("_id" -> id)
    val rs = collection.find(query).cursor[EmailProfileMapping]
    val result = rs.headOption.map(_.map(_.customerProfile.toString).getOrElse("19684"))
    Await.result(result, 10 seconds)
  }

  def getCustomerNumber(custID: String): Int = {
    val collection = customerMappingCollection()
    val query = BSONDocument("_id" -> custID)
    val cursor = collection.find(query).cursor[CustomerMapping]
    val result = cursor.headOption.map(_.map(_.customerNumber.toInt).getOrElse(0))
    Await.result(result, 10 seconds)
  }

  def main(args: Array[String]) {
    val c = oneMonthReviewsFrom(2005, 1)
    val seqF = c.collect[Seq](10, false)
    seqF.onFailure {
      case _ =>
        println("Failed")
    }

    seqF.onSuccess {
      case x @ _ =>
        println(s"Succeeded with $x")
    }

    val resF = seqF.map { seq =>
      seq foreach { x =>
        val productId = x.get("productId").map { v =>
          v.asInstanceOf[BSONDouble].value.toLong
        }.get
        println(productId)
      }
    }

    Await.result(resF, 1 minute)
  }

}
