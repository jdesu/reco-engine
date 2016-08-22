package recoserver

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http
import spray.http._
import spray.http.MediaTypes._
import spray.routing._

import spray.json._
import DefaultJsonProtocol._

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}

case class BookRecResults(message: String, results: Map[String, Double] = Map())
case class ProductRecResults(message: String, results: Map[String, Double] = Map())

// this trait defines our service behavior independently from the service actor
trait BookRecommendationService extends HttpService {

  implicit val impBookRecResults = jsonFormat2(BookRecResults)
  implicit val impProductRecResults = jsonFormat2(ProductRecResults)

  val myRoute = {
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                Welcome to Book RecommendationService.
              </body>
            </html>
          }
        }
      }
    }

    path("recommendations" / "foruser" / Segment) { user =>
      get {
        respondWithMediaType(`application/json`) {
          complete {
            val m = BookSharedData.alsModel
            val userId = BookSharedData.customerToIdMap.get(user)
            val rr = userId.map { id =>
              val recommendations: Array[Rating] = try {
                m.recommendProducts(id, 25)
              } catch {
                case t: Throwable => Array()
              }
              val recs: Array[(String, Double)] = recommendations.flatMap { r =>
                val asinOpt = BookSharedData.idToAsinMap.get(r.product)
                asinOpt.map(asin => asin -> r.rating)
              }

              BookRecResults(s"Found results for user: ${user}", recs.toMap)
            }.getOrElse(BookRecResults(s"No such user found: ${user}"))

            rr.toJson.prettyPrint

          }
        }
      }
    }

//    path("recommendations" / "forproduct" / Segment) { user =>
//      get {
//        respondWithMediaType(`application/json`) {
//          complete {
//            val m = ProductSharedData.alsModel
//            val userId = ProductSharedData.customerToIdMap.get(user)
//            val rr = userId.map { id =>
//              val recommendations: Array[Rating] = try {
//                m.recommendProducts(id, 10)
//              } catch {
//                case t: Throwable => Array()
//              }
//              val recs: Array[(String, Double)] = recommendations.flatMap { r =>
//                val asinOpt = ProductSharedData.idToAsinMap.get(r.product)
//                asinOpt.map(asin => asin -> r.rating)
//              }
//
//              ProductRecResults(s"Found results for user: ${user}", recs.toMap)
//            }.getOrElse(ProductRecResults(s"No such user found: ${user}"))
//
//            rr.toJson.prettyPrint
//
//          }
//        }
//      }
//    }
  }
}

class BookRecommendationServiceActor extends Actor with BookRecommendationService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}

object BookSharedData {
  val modelPath = "models/BookRatingsALSModel/"
  val asinToIdPath = "mappings/book_ratings/asinToId"
  val customerToIdPath = "mappings/book_ratings/customerToId"

  lazy val sc = getSparkContext()
  lazy val asinToIdMap: Map[String, Int] = loadAsinMap
  lazy val customerToIdMap: Map[String, Int] = loadCustomerMap

  lazy val idToAsinMap: Map[Int, String] = asinToIdMap.map(x => x._2 -> x._1)
  lazy val idToCustomerMap: Map[Int, String] = customerToIdMap.map(x => x._2 -> x._1)

  lazy val alsModel = loadALSModel

  private[this] def loadALSModel() = MatrixFactorizationModel.load(sc, modelPath)

  private[this] def loadAsinMap(): Map[String, Int] = {
    sc.textFile(asinToIdPath).flatMap { line =>
      line.split(",") match {
        case Array(x, y, _*) => Some(x -> y.toInt)
        case _ => None
      }
    }.collectAsMap.toMap
  }

  private[this] def loadCustomerMap(): Map[String, Int] = {
    sc.textFile(customerToIdPath).flatMap { line =>
      line.split(",") match {
        case Array(x, y, _*) => Some(x -> y.toInt)
        case _ => None
      }
    }.collectAsMap.toMap
  }

  private[this] def getSparkContext(): SparkContext = {
    val conf = new SparkConf(false)
      .setMaster("local[4]")
      .setAppName(BookRecommendationServer.getClass.getName)

    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    conf.set("spark.executor.memory", "2g")
    val sc = new SparkContext(conf)
    sc
  }
}

  object ProductSharedData {
    val modelPath = "models/AmazonRatingsALSModel/"
    val asinToIdPath = "mappings/asinToId"
    val customerToIdPath = "mappings/customerToId"

    lazy val sc = getSparkContext()
    lazy val asinToIdMap: Map[String, Int] = loadAsinMap
    lazy val customerToIdMap: Map[String, Int] = loadCustomerMap

    lazy val idToAsinMap: Map[Int, String] = asinToIdMap.map(x => x._2 -> x._1)
    lazy val idToCustomerMap: Map[Int, String] = customerToIdMap.map(x => x._2 -> x._1)

    lazy val alsModel = loadALSModel

    private[this] def loadALSModel() = MatrixFactorizationModel.load(sc, modelPath)

    private[this] def loadAsinMap(): Map[String, Int] = {
      sc.textFile(asinToIdPath).flatMap { line =>
        line.split(",") match {
          case Array(x, y, _*) => Some(x -> y.toInt)
          case _ => None
        }
      }.collectAsMap.toMap
    }

    private[this] def loadCustomerMap(): Map[String, Int] = {
      sc.textFile(customerToIdPath).flatMap { line =>
        line.split(",") match {
          case Array(x, y, _*) => Some(x -> y.toInt)
          case _ => None
        }
      }.collectAsMap.toMap
    }

  private[this] def getSparkContext(): SparkContext = {
    val conf = new SparkConf(false)
      .setMaster("local[4]")
      .setAppName(BookRecommendationServer.getClass.getName)

    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    conf.set("spark.executor.memory", "2g")
    val sc = new SparkContext(conf)
    sc
  }
}

object BookRecommendationServer {
  def main(args: Array[String]) {
    // we need an ActorSystem to host our application in
    implicit val system = ActorSystem("on-spray-can")

    // create and start our service actor
    val service = system.actorOf(Props[BookRecommendationServiceActor], "recommendation-service")

    implicit val timeout = Timeout(5.seconds)
    // start a new HTTP server on port 8080 with our service actor as the handler
    IO(Http) ? Http.Bind(service, interface = "localhost", port = 8082)
  }
}
