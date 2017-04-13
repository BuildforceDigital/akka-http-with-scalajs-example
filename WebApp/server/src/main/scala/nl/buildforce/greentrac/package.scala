package nl.buildforce

import nl.buildforce.greentrac.GTbackendMain.logInfo

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

package object greentrac {
  def printResults[T](f: Future[Iterable[T]], header: Option[String]): Unit = {
    if (header.nonEmpty) logInfo(header.get)
    Await.result(f, Duration.Inf).foreach(t => logInfo(t.toString))
    logInfo(f"${"  • − • − •" * 3}%40s")
  }


}
