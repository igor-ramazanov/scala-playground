import smithy4s.codegen.BuildInfo._
import smithy4s.codegen.Smithy4sCodegenPlugin

ThisBuild / bspEnabled := true

val versions = new {
  val alloy = "0.2.8"
  val catsCore = "2.10.0"
  val catsEffect = "3.5.2"
  val fs2 = "3.9.3"
  val http4s = "0.23.23"
  val ip4s = "3.4.0"
}

lazy val `scala-playground` = project
  .in(file("."))
  .enablePlugins(Smithy4sCodegenPlugin)
  .settings(
    scalaVersion := "3.3.1",
    libraryDependencies ++= List(
      "co.fs2" %% "fs2-io" % versions.fs2,
      "com.disneystreaming.alloy" % "alloy-core" % versions.alloy,
      "com.disneystreaming.smithy4s" %% "smithy4s-core" % smithy4sVersion.value,
      "org.typelevel" %% "cats-core" % versions.catsCore,
      "org.typelevel" %% "cats-effect" % versions.catsEffect,
      "org.typelevel" %% "cats-effect-kernel" % versions.catsEffect,
    ),
  )
