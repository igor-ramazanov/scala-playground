import scala.scalanative.build._
import smithy4s.codegen.BuildInfo._
import smithy4s.codegen.Smithy4sCodegenPlugin

ThisBuild / bspEnabled := true

val versions = new {
  val catsCore = "2.9.0"
  val catsEffect = "3.4.2"
  val circe = "0.14.3"
  val epollcat = "0.1.3"
  val fs2 = "3.4.0"
  val http4s = "0.23.16"
  val ip4s = "3.2.0"
  val log4cats = "2.5.0"
  val vault = "3.3.0"
}

lazy val `scala-playground` = project
  .in(file("."))
  .enablePlugins(ScalaNativePlugin, Smithy4sCodegenPlugin)
  .settings(
    scalaVersion := "3.2.1",
    Compile / smithy4sAllowedNamespaces := List(
      "smithy.rules",
      "com.amazonaws.ec2",
    ),
    scalacOptions ++= List(
      "-Wconf:msg=.*deprecated.*:silent"
    ),
    nativeConfig ~= {
      _.withBuildTarget(BuildTarget.application)
        .withCheck(true)
        .withCheckFatalWarnings(true)
        .withCompileOptions(List(s"-I${sys.props("user.home")}/.nix-profile/include", "-Qunused-arguments"))
        .withDump(false)
        .withEmbedResources(true)
        .withGC(GC.commix)
        .withIncrementalCompilation(true)
        .withLTO(LTO.none)
        .withLinkStubs(false)
        .withLinkingOptions(List(s"-L${sys.props("user.home")}/.nix-profile/lib"))
        .withMode(Mode.debug)
        .withOptimize(false)
    },
    libraryDependencies ++= List(
      "co.fs2" %%% "fs2-io" % versions.fs2,
      "com.armanbilge" %%% "epollcat" % versions.epollcat,
      "com.comcast" %%% "ip4s-core" % versions.ip4s,
      "com.disneystreaming.smithy4s" %%% "smithy4s-aws-http4s" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %%% "smithy4s-core" % smithy4sVersion.value,
      "io.circe" %%% "circe-core" % versions.circe,
      "org.http4s" %%% "http4s-circe" % versions.http4s,
      "org.http4s" %%% "http4s-client" % versions.http4s,
      "org.http4s" %%% "http4s-core" % versions.http4s,
      "org.http4s" %%% "http4s-dsl" % versions.http4s,
      "org.http4s" %%% "http4s-ember-client" % versions.http4s,
      "org.http4s" %%% "http4s-ember-server" % versions.http4s,
      "org.http4s" %%% "http4s-server" % versions.http4s,
      "org.typelevel" %%% "cats-core" % versions.catsCore,
      "org.typelevel" %%% "cats-effect" % versions.catsEffect,
      "org.typelevel" %%% "cats-effect-kernel" % versions.catsEffect,
      "org.typelevel" %%% "log4cats-core" % versions.log4cats,
      "org.typelevel" %%% "vault" % versions.vault,
      "software.amazon.smithy" % "smithy-rules-engine" % smithyVersion % Smithy4s,
    ),
  )
