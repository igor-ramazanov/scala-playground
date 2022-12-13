package tech.igorramazanov.playground

import cats.effect.*
import cats.effect.std.*
import cats.syntax.all.*
import com.amazonaws.dynamodb.*
import com.comcast.ip4s.*
import epollcat.EpollApp
import org.http4s.*
import org.http4s.dsl.*
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.implicits.*
import org.typelevel.log4cats.Logger
import smithy4s.aws.*
import smithy4s.aws.http4s.*

object Main extends EpollApp.Simple:
  def run: IO[Unit] =
    EmberClientBuilder
      .default[IO]
      .build
      .flatMap(client => DynamoDB.awsClient(client, AwsRegion.EU_NORTH_1))
      .use(dynamodb => dynamodb.describeTable(TableName("omelois-test")))
      .flatMap(IO.println)
      .void
