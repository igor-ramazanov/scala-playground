import scala.scalanative.build._

ThisBuild / bspEnabled := true

val versions = new {
  val catsCore = "2.9.0"
  val catsEffect = "3.4.2"
  val circe = "0.14.3"
  val epollcat = "0.1.3"
  val fs2 = "3.4.0"
  val http4s = "1.0.0-M37"
  val ip4s = "3.2.0"
  val vault = "3.3.0"
}

lazy val `scala-playground` = project
  .in(file("."))
  .enablePlugins(ScalaNativePlugin)
  .settings(
    scalaVersion := "3.2.1",
    nativeConfig ~= {
      _.withBuildTarget(BuildTarget.application)
        .withCheck(true)
        .withCheckFatalWarnings(true)
        .withCompileOptions(List("-I/home/igor/.nix-profile/include", "-Qunused-arguments"))
        .withDump(false)
        .withEmbedResources(true)
        .withGC(GC.default)
        .withIncrementalCompilation(true)
        .withLTO(LTO.full)
        .withLinkStubs(true)
        .withLinkingOptions(List("-L/home/igor/.nix-profile/lib"))
        .withMode(Mode.releaseFull)
        .withOptimize(true)
    },
    libraryDependencies ++= List(
      "co.fs2" %%% "fs2-io" % versions.fs2,
      "com.armanbilge" %%% "epollcat" % versions.epollcat,
      "com.comcast" %%% "ip4s-core" % versions.ip4s,
      "io.circe" %%% "circe-core" % versions.circe,
      "org.http4s" %%% "http4s-circe" % versions.http4s,
      "org.http4s" %%% "http4s-core" % versions.http4s,
      "org.http4s" %%% "http4s-dsl" % versions.http4s,
      "org.http4s" %%% "http4s-ember-server" % versions.http4s,
      "org.http4s" %%% "http4s-server" % versions.http4s,
      "org.typelevel" %%% "cats-core" % versions.catsCore,
      "org.typelevel" %%% "cats-effect" % versions.catsEffect,
      "org.typelevel" %%% "cats-effect-kernel" % versions.catsEffect,
      "org.typelevel" %%% "vault" % versions.vault,
    ),
  )
