package scripts

import model.Book

import scala.concurrent.ExecutionContext.Implicits.global
import reactivemongo.api.MongoDriver
import reactivemongo.api.collections.default.BSONCollection

import scala.io.Source

object LoadBooks {

  def main(args: Array[String]) {

    val driver = new MongoDriver
    val connection = driver.connection(List("localhost"))

    val db = connection("amazon_dataset")
    val booksCollection = db[BSONCollection]("books")

    val (rows) = loadNames
    for (row <- rows) {

      val bookId = row(0).replaceAll("^\"|\"$", "")
      val title = row(1).replaceAll("^\"|\"$", "")
      val author = row(2).replaceAll("^\"|\"$", "")
      val imageUrl = row(6).replaceAll("^\"|\"$", "")

      val currentItem = Book(bookId, title, author, imageUrl)
      addToEntries(booksCollection, currentItem)
    }
  }

  def addToEntries(collection: BSONCollection, currentItem: Book) = {
   // println(currentItem)
    collection.save(currentItem)
  }


  def loadNames = {
    val datasetFolder = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/"

    val booksFile = datasetFolder + "books.csv"
    val bookRecord = Source.fromFile(booksFile,"ISO-8859-1").getLines.map {
        line => line.split(";").take(10)
      }.toArray
      bookRecord
  }
}