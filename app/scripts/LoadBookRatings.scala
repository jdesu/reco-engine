package scripts

//import model.Book
import model.Book
import reactivemongo.api.MongoDriver
import reactivemongo.api.collections.default.BSONCollection
import reactivemongo.bson.BSONDocument

import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

object LoadBookRatings {

  def main(args: Array[String]) {

    val driver = new MongoDriver
    val connection = driver.connection(List("localhost"))
    val db = connection("amazon_dataset")
    val booksCollection = db[BSONCollection]("books")

    val (rows) = loadNames
    for (row <- rows) {
     // val bookId = row(1).replaceAll("^\"|\"$", "")
      val bookId = "0425176428"
      println {bookId}
      val asin = "0826449379"
     // val bookCursor =  ReactiveDB.getByASIN(asin)
      val bookCursor = getBookByISBN(bookId)
      val itemsF = bookCursor.collect[List](1,true)
      itemsF.map { items =>
        for(item <- items) {
          println(s"found $item")
        }

        //println { itemOpt }
      }
    }
  }

  def addToEntries(collection: BSONCollection, currentItem: Book) = {
    // println(currentItem)
    collection.save(currentItem)
  }

  def getBookByISBN(id: String) = {
    val collection = bookCollection()
    val query = BSONDocument("id" -> id)
    val rs = bookCollection.find(query).cursor[Book]
    (rs)
  }

  def bookCollection() = {
    val driver = new MongoDriver
    val connection = driver.connection(List("localhost"))
    val db = connection("amazon_dataset")
    val collection = db("books")
    collection
  }


  def loadNames = {
    val datasetFolder = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/book/BX-CSV-Dump/"

    val booksFile = datasetFolder + "sample.csv"
    val bookRecord = Source.fromFile(booksFile,"ISO-8859-1").getLines.map {
      line => line.split(";").take(10)
    }.toArray
    bookRecord
  }
}