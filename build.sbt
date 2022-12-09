scalaVersion := "3.2.1"

enablePlugins(ScalaNativePlugin)

libraryDependencies := List(
  "com.disneystreaming.smithy4s" %%% "smithy4s-aws-http4s" % "0.17.0-213-644f5ae",
  compilerPlugin("com.github.ghik" % "zerowaste" % "0.2.1" cross CrossVersion.full)
)

scalacOptions ++= List(
  "-Yno-predef",
  "-explain",
  "-indent",
  "-new-syntax"
)
