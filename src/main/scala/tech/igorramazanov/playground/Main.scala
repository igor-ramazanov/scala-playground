package tech.igorramazanov.playground

import cats.effect.*

object Main extends IOApp.Simple:
  def run: IO[Unit] = IO.println("Hello World")
