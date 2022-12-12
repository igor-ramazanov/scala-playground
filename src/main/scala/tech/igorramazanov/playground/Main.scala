package tech.igorramazanov.playground

import cats.effect.*
import cats.effect.std.*
import cats.syntax.all.*
import com.comcast.ip4s.*
import epollcat.EpollApp
import org.http4s.*
import org.http4s.dsl.*
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits.*
import org.typelevel.log4cats.Logger

object Main extends EpollApp.Simple:
  def run: IO[Unit] =
    val service = HttpRoutes.of[IO] { case _ => IO.pure(Response()) }
    val app = service.orNotFound
    println("Server listening on 0.0.0.0:8080")
    EmberServerBuilder
      .default[IO]
      .withHttpApp(app)
      .withHost(host"0.0.0.0")
      .withPort(port"8080")
      .build
      .evalMap(server => IO.println(server))
      .useForever
