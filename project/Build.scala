import sbt._
import Keys._
import wartremover._
import com.typesafe.sbt.SbtGit._

object QualityBuild extends Build {

	val appName = "quality"
	val ScalaVersion = "2.11.6"
	val javacVersion = "1.8"
	sbtVersion := "0.13.7"

	val commonSettings = Project.defaultSettings ++ 
		Seq(
			scalaVersion := ScalaVersion,
			scalacOptions in Compile ++= Seq(
				"-Xlint", 
				"-deprecation",
				"-Xfatal-warnings", 
				"-feature")
		)

        wartremoverErrors ++= Warts.unsafe


	lazy val main = (project in file("."))
 		.enablePlugins(com.typesafe.sbt.GitBranchPrompt)
		.settings(commonSettings: _*)
		.settings(
			libraryDependencies ++= Seq(
				"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
        			"org.scalactic" % "scalactic_2.11" % "2.2.4"
			),
			version := "1.0"
		)
	
}
