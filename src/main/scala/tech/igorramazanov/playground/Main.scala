package tech.igorramazanov.playground

import cats.effect._
import com.amazonaws.ec2._
import epollcat.EpollApp
import org.http4s.ember.client.EmberClientBuilder
import smithy4s.aws._
import smithy4s.aws.http4s._

object Main extends EpollApp.Simple {
  def run: IO[Unit] =
    EmberClientBuilder
      .default[IO]
      .build
      .flatMap(client => EC2.awsClient(client, AwsRegion.EU_NORTH_1))
      .use(ec2 => ec2.describeImages().run)
      .flatMap(IO.println)
      .void
}
