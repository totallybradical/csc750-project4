name := """bingers-project4"""
organization := "edu.ncsu"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

resolvers += "public-jboss" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"

libraryDependencies += guice
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7"
libraryDependencies += "com.github.galigator.openllet" % "openllet-jena" % "2.6.4"
libraryDependencies += "org.drools" % "drools-core" % "7.3.0.Final"
libraryDependencies += "org.drools" % "drools-compiler" % "7.3.0.Final"