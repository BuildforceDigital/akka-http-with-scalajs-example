val commonSettings = Seq(
                  name := "RESTless webapp Akka HTTP, react as sbtweb-ScalaJs",
               version := "0.1-SNAPSHOT",
           description := "Akka-http RESTless Web App with react, bootstrap as a sbt-web-scalajs project with webjars",
          organization := "nl.amsscala",
      organizationName := "Amsterdam.scala Meetup Group",
  organizationHomepage := Some(url("http://www.meetup.com/amsterdam-scala/")),
              homepage := Some(url("http://github.com/amsterdam-scala/akka-http-with-scalajs-example")),
             startYear := Some(2017),
licenses += "EUPL-1.1" -> url("http://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11"),

          scalaVersion := scalaV,
  libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "autowire" % autowireV,
      "com.lihaoyi" %%% "scalarx"  % "0.3.2",
      "com.lihaoyi" %%% "upickle"  % upickleV,
      "com.lihaoyi" %%% "scalatags" % "0.6.3",
    "com.h2database" % "h2" % "1.4.194",
"com.typesafe.slick" %% "slick" % "3.2.0",
"org.slf4j" % "slf4j-nop" % "1.7.25",
"org.scalatest" %% "scalatest" % "3.0.1" % "test"
))

lazy val akkaHttpV   = "10.0.3"
     val autowireV   = "0.2.6"
lazy val reactV      = "15.4.2"
lazy val scaJSreactV = "0.11.3"
lazy val scalaDomV   = "0.9.1"
     val scalaV      = "2.12.1"
     val upickleV    = "0.4.4"
lazy val webAppDir   = "WebApp"

scalaVersion := scalaV

scalacOptions in ThisBuild ++= Seq("-deprecation", "-feature", "-unchecked")

lazy val client = (project in file(webAppDir + "/client")).settings(
  commonSettings,
  jsDependencies ++= Seq(
    "org.webjars" % "bootstrap" % "3.3.7" / "bootstrap.js" minified "bootstrap.min.js" dependsOn "3.1.1/jquery.js",
    "org.webjars" % "jquery" % "3.1.1" / "3.1.1/jquery.js",
    "org.webjars.bower" % "react" % reactV / "react-dom-server.js" minified "react-dom-server.min.js" dependsOn "react-dom.js" commonJSName "ReactDOMServer",
    "org.webjars.bower" % "react" % reactV / "react-dom.js" minified "react-dom.min.js" dependsOn "react-with-addons.js" commonJSName "ReactDOM",
    "org.webjars.bower" % "react" % reactV / "react-with-addons.js" minified "react-with-addons.min.js" commonJSName "React"
  ),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % "0.9.1",
    "com.github.japgolly.scalajs-react" %%% "core"        % scaJSreactV,
    "com.github.karasiq"                %%% "scalajs-bootstrap" % "1.1.4"
//  "com.github.japgolly.scalajs-react" %%% "ext-monocle" % scaJSreactV,
//  "com.github.japgolly.scalajs-react" %%% "ext-scalaz72"% scaJSreactV,
//  "com.github.japgolly.scalajs-react" %%% "extra"       % scaJSreactV,
  ),
  // KEEP THIS normalizedName CONSTANTLY THE SAME, otherwise the outputted JS filename will be changed.
  normalizedName := "main" ,
  scalaJSUseMainModuleInitializer := true //,
  //persistLauncher in Test := false
).enablePlugins(ScalaJSPlugin, ScalaJSWeb).dependsOn(sharedJs)

lazy val server = (project in file(webAppDir + "/server")).settings(
  commonSettings,
  // triggers scalaJSPipeline when using compile or continuous compilation
  compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,
  // Compile the project before generating Eclipse files, so that generated .scala or .class files for Twirl templates are present
  //EclipseKeys.preTasks := Seq(compile in Compile)
  libraryDependencies += "com.typesafe.akka" %% "akka-http"% akkaHttpV,
  managedClasspath in Runtime += (packageBin in Assets).value,
  name := "SERVER",
  pipelineStages in Assets := Seq(scalaJSPipeline),
  scalaJSProjects := Seq(client),
  WebKeys.packagePrefix in Assets := "public/"
  ).enablePlugins(SbtWeb /*, JavaAppPackaging*/).dependsOn(sharedJvm)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file(webAppDir + "/shared")).
  settings(commonSettings).jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJs = shared.js
lazy val sharedJvm = shared.jvm

// loads the server project at sbt startup
onLoad in Global := (Command.process("project server", _: State))