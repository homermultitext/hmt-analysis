ThisBuild / crossScalaVersions  := List("2.11.8", "2.12.4")

name := "hmt-analysis"
organization := "org.homermultitext"
version := "0.0.1"

licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")

// must be at least 2.11 to use hmt_textmodel
scalaVersion := "2.12.4"

// need a lot of RAM
javaOptions in run ++= Seq(
   "-Xms256M",
   "-Xmx4G"
 )

enablePlugins(TutPlugin)
tutTargetDirectory := file("docs")

libraryDependencies ++= Seq(
  "edu.holycross.shot.cite" %% "xcite" % "4.0.2",
  "edu.holycross.shot" %% "ohco2" % "10.12.5",
  "edu.holycross.shot" %% "dse" % "4.2.2",
  "edu.holycross.shot" %% "citeobj" % "7.3.1",
  "edu.holycross.shot" %% "scm" % "6.2.1",
  "edu.holycross.shot" %% "greek" % "2.1.1",
  "edu.holycross.shot" %% "gsphone" % "1.4.0",


  "org.scalatest" %% "scalatest" % "3.0.1" %  "test"

)
