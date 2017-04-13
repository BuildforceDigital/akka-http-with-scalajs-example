package nl.buildforce.greentrac

import example.CheckInOutEventData
import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._
import slick.jdbc.meta.MSchema

import scala.compat.Platform.currentTime
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Success

object GTbackendMain extends DataInitialization with Tables with Views with CheckConstraints {
  val db: H2Profile.backend.Database = Database.forConfig("greenTrac00")
  val profile = slick.jdbc.H2Profile
  val schemaName = Some("GreenTrac00")
  val objectNamePostFix = Some(schemaName.mkString("\"", "", "\".")).filter(_.length > 3).mkString

  def createSchemaIfNotExists(schemaName: Option[String]): Future[_] =
    db.run(MSchema.getSchemas(None, schemaName)).flatMap {
      case tables => if (tables.isEmpty || schemaName.isEmpty)
        db.run(DBIO.seq(
          createNamedSchema(schemaName),
          schema.create,
          createViews(schemaName),
          addCheckConstraints(schemaName)
        )).andThen {
          case Success(_) => db.run(insertInitialData().transactionally).map(_ => logInfo("and populated"))
        } else {
        logInfo(s"Schema ${schemaName.getOrElse("<default>")} already exists")
        Future.successful(Unit)
      }

    }

  def logInfo(info: String): Unit = println(f"[Info]$info")

  def checkIn(db: H2Profile.backend.Database, pass: CheckInOutEventData) = {
    Await.result(db.run(DBIO.seq(
    Timeregistrations.map(tmr => (
      tmr.terGuidIn,
      tmr.prjOrgProjowner,
      tmr.prjProjectcode,
      tmr.docOwnerUsrWorker,
      tmr.checkindatetime,
      tmr.docDocid,
      tmr.docDocumenttype,
      tmr.docExpirationdate)) forceInsertQuery checkAccess.filter(p => p._1 === "TERMINAL0000001" && p._2._6 === "Doc 123457" /*&& p.map(_.) === Some(Some(0))*/)
      .map { p => (p._1.get, p._2._1.get, p._2._2.get, /*p._2._3,*/ p._2._5, p._2._4, p._2._6, p._2._7, p._2._8) }

  ).transactionally), Duration(10, "sec"))}

/*  try {
    def reporting: DBIO[Unit] = DBIO.seq(

      summarizePopulation()

    ).transactionally

    Await.result(db.run(dropNamedSchema(schemaName)), Duration(10, "sec"))

    Await.result(createSchemaIfNotExists(schemaName), Duration(10, "sec"))

    Await.result(db.run(reporting), Duration(10, "sec"))

  } finally db.close

  logInfo("Run successfully completed")*/
}