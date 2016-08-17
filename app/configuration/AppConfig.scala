package configuration

import play.api.Play

object AppConfig {
  lazy val c = Play.current.configuration

  object ES {
    val server = c.getString("elasticsearch.server").get
    val port = c.getInt("elasticsearch.port").get
    val productsIndex = c.getString("elasticsearch.products_index").get
  }

  object DBConfig {
    val dbHost = c.getString("mongodb.host").get
    val dbPort = c.getInt("mongodb.port").get
    val dbName = c.getString("mongodb.database").get
  }

  object BRS {
    val host = c.getString("bookRecommenderService.host").get
    val port = c.getInt("bookRecommenderService.port").get
  }

  object PRS {
    val host = c.getString("productRecommenderService.host").get
    val port = c.getInt("productRecommenderService.port").get
  }
}
