package example

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.backend.Database
import upickle.Js
import upickle.Js.Value
import upickle.default._


trait ApiService {
  this: ServiceContext =>
  lazy val routeApi: Route =
    path(Segments) { s =>
      entity(as[String]) { e =>
        complete {
          AutowireServer.route[Api](ApiImpl)(
            autowire.Core.Request(s, upickle.json.read(e).asInstanceOf[Js.Obj].value.toMap)
            // autowire.Core.Request(s, upickle.default.read[Map[String, String]](e).asInstanceOf[Js.Obj].value.toMap)
          ).map(upickle.json.write(_, 0))
        }
      }
    }

}

object ApiImpl extends Api {
  val db = Database.forConfig("greenTrac00")
  val profile = slick.jdbc.H2Profile


  def CheckInOutEvent(pass: CheckInOutEventData):Boolean = {
    println(pass)
    nl.buildforce.greentrac.GTbackendMain.checkIn(db, pass)
    true}

  def allTodo0(): Seq[Task0] = TaskStore.selectAll.reverse

  def createTodo(taskWithoutId: Task0): Task0 = TaskStore.create(taskWithoutId)

  def updateTodo(oldTask: Task0, newTask: Task0): Task0 = TaskStore.update(oldTask, newTask)

  def deleteTodo(itemToDelete: Task0): Task0 = TaskStore.delete(itemToDelete)

  def clearCompletedTasks(): Seq[Task0] = Nil


  /*  def addTodo(text: String): Unit = {
      println(s"addTodo: $text")
      data = data :+ TodoItem0(text, LocalDateTime.now().toLocalTime.toString)
    }

    def allTodos(): Seq[TodoItem0] = {
      println("allTodos")
      data
    }*/
}

object AutowireServer extends autowire.Server[Js.Value, Reader, Writer] {
  def read[Result: Reader](p: Js.Value): Result = upickle.default.readJs[Result](p)

  def write[Result: Writer](r: Result): Value = upickle.default.writeJs(r)
}
