import sbt.Package.ManifestAttributes

scalaVersion := "2.9.3"

scalaSource in Compile := { baseDirectory.value  / "src" }

javaSource in Compile  := { baseDirectory.value / "src" }

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xlint", "-Xfatal-warnings",
                        "-encoding", "us-ascii")

javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-encoding", "us-ascii")

name := "Hello-Extension"

libraryDependencies +=
  "org.nlogo" % "NetLogo" % "5.2.0" from "http://ccl.northwestern.edu/netlogo/5.2/NetLogo.jar"

enablePlugins(org.nlogo.build.NetLogoExtension)

netLogoClassManager := "HelloScalaExtension"

netLogoExtName      := "helloscala"
