import sbt._
import Keys._

object QualityBuild extends Build {

	val appName = "quality"
	val ScalaVersion = "2.11.6"
	val javacVersion = "1.8"

	val commonSettings = Project.defaultSettings ++ 
		Seq(
			scalaVersion := ScalaVersion,
			scalacOptions in Compile ++= Seq(
				"-Xlint", 
				"-deprecation",
				"-Xfatal-warnings", 
				"-feature")
		)

	lazy val main = Project(
		id = "main",
		base = file("."),
		settings = commonSettings ++ Seq(
			libraryDependencies ++= Seq(
				"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
			)
		)
	)
}
