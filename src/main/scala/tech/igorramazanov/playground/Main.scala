package tech.igorramazanov.playground

import cats.effect.*
import com.amazonaws.ec2.*
import epollcat.EpollApp
import org.http4s.ember.client.EmberClientBuilder
import smithy4s.aws.*
import smithy4s.aws.http4s.*

object Main extends EpollApp.Simple:
  def run: IO[Unit] =
    EmberClientBuilder
      .default[IO]
      .build
      .flatMap(client => EC2.awsClient(client, AwsRegion.EU_NORTH_1))
      .use(ec2 => ec2.describeImages().run)
      .flatMap(IO.println)
      .void
