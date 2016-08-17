package model

import play.api.libs.json.Json
import reactivemongo.bson.{BSONDocument, BSONDocumentReader, Macros}

case class Review(date: String, customer: String, rating: Int, votes: Int, helpful: Int)

object Review {
  implicit val reviewHandler = Macros.handler[Review]
  implicit val reviewFormat = Json.format[Review]
}

case class OverallReview(total: Int, downloaded: Int, averageRating: Double)

object OverallReview {
  implicit val categoryHandler = Macros.handler[OverallReview]
  implicit val categoryFormat = Json.format[OverallReview]
}

case class Category(name: String, code: Int)

object Category {
  implicit val categoryHandler = Macros.handler[Category]
  implicit val categoryFormat = Json.format[Category]
}

case class AmazonMeta(
  var id: Int,
  var asin: String,
  var title: String,
  var group: String,
  var salesrank: Int,
  var similar: List[String],
  var categories: List[List[Category]],
  var reviews: List[Review],
  var overallReview: OverallReview)

object AmazonMeta {
  implicit val amazonRatingHandler = Macros.handler[AmazonMeta]
  implicit val amazonRatingFormat = Json.format[AmazonMeta]
}

case class CustomerMapping(
  customer_number: Double,
  _id: String) {
  def customerId = _id
  def customerNumber = customer_number
}

object CustomerMapping {
  implicit val customerMappingHandler = Macros.handler[CustomerMapping]
  implicit val customerMappingFormat = Json.format[CustomerMapping]
}

case class EmailProfileMapping(
                            profile: String,
                            _id: String) {
  def customerId = _id
  def customerProfile = profile
}

object EmailProfileMapping {
  implicit val customerMappingHandler = Macros.handler[EmailProfileMapping]
  implicit val customerMappingFormat = Json.format[EmailProfileMapping]
}

case class BookRating(customerId: String, rating: Double)
object BookRating {
  implicit val bookRatingHandler = Macros.handler[BookRating]
  implicit val bookRatingFormat = Json.format[BookRating]
}

case class Book(_id: String, title: String, author: String, imageUrl: String)

object Book {
  implicit val bookHandler = Macros.handler[Book]
  implicit val bookFormat = Json.format[Book]
}
