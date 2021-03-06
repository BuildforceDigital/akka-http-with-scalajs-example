# Akka-http RESTless Web App with react, bootstrap as sbt-web-scalajs project.

This is a simple example application showing how you can integrate an Akka HTTP project with a Scala.js project.

The application contains three directories:
* `server` Akka HTTP application (server side)
* `client` Scala.js application (client side)
* `shared` Scala code that you want to share between the server and the client

## Run the application
```shell
$ sbt
sbt (server)> reStart
[info] Application server not yet started
[info] Starting application server in the background ...
server Starting example.WebServer.main()
[success] Total time: 19 s, completed 2017-01-02T08:15 W1
sbt (server)> server Server online at http://0.0.0.0:8080
```
Use 'reStop' to stop the erver
## Features

The application uses the [sbt-web-scalajs](https://github.com/vmunier/sbt-web-scalajs) sbt plugin.

- `compile`, `run`, `re-start` trigger the Scala.js fastOptJS command
- `~compile`, `~run`, `~re-start` continuous compilation is also available
- Production archives (e.g. using `assembly`, `universal:packageBin`) contain the optimised javascript
- Source maps
  - Open your browser dev tool to set breakpoints or to see the guilty line of code when an exception is thrown
  - Source Maps is _disabled in production_ by default to prevent your users from seeing the source files. But it can easily be enabled in production too by setting `emitSourceMaps in fullOptJS := true` in the Scala.js projects.

## Cleaning

The root project aggregates all the other projects by default.
Use this root project, called `akka-http-with-scalajs-example`, to clean all the projects at once.
```shell
$ sbt
> akka-http-with-scalajs-example/clean
```

## IDE integration

### Eclipse

1. `$ sbt "eclipse with-source=true"`
2. Inside Eclipse, `File/Import/General/Existing project...`, choose the root folder. Uncheck the first and the last checkboxes to only import client, server and one shared, click `Finish`. ![Alt text](screenshots/eclipse-akka-http-with-scalajs-example.png?raw=true "eclipse akka-http-with-scalajs-example screenshot")

### IntelliJ

In IntelliJ, open Project wizard, select `Import Project`, choose the root folder and click `OK`.
Select `Import project from external model` option, choose `SBT project` and click `Next`. Select additional import options and click `Finish`.
Make sure you use the IntelliJ Scala Plugin v1.3.3 or higher. There are known issues with prior versions of the plugin.

## Classpath during development

The assets (js files, sourcemaps, etc.) are added to the classpath during development thanks to the following lines:
```
WebKeys.packagePrefix in Assets := "public/",
managedClasspath in Runtime += (packageBin in Assets).value
```

Note that `packageBin in Assets` also executes any tasks appended to `pipelineStages`, e.g. `gzip`.
You may want to avoid executing tasks under `pipelineStages` during development, because it could take long to execute.

In that case, in order to still have access to the assets under `WebKeys.packagePrefix in Assets` during development, you can use the following code instead:
```
lazy val server = (project in file("server")).settings(
...
WebKeys.packagePrefix in Assets := "public/",
WebKeys.exportedMappings in Assets ++= (for ((file, path) <- (mappings in Assets).value)
  yield file -> ((WebKeys.packagePrefix in Assets).value + path)),
...
)
```
