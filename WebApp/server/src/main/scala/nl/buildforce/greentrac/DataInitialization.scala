package nl.buildforce.greentrac

import java.sql.{Date, Timestamp}

import slick.dbio.DBIOAction
import slick.dbio.Effect.Write
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait DataInitialization {
  this: GTbackendMain.type =>

  def insertInitialData(): DBIOAction[Unit, NoStream, Write] = {
    val (vendor, vendorGUID) = ("Buildƒorce Digital i.o.", "Buildƒorce Digital")
    val thisDay = java.time.LocalDate.now()
    val sqlThisDay = Date.valueOf(thisDay)
    val sqlMonthLater = Date.valueOf(thisDay.plusMonths(1))
    val dontCareDt = new Date(0L)

    val dbio = DBIO.seq(

      Parties.map(p => (p.username, p.gender, p.prtGuid, p.name, p.nickname, p.nationality, p.coc, p.vatnumber, p.tilldate, p.imageurl)) ++=
        List((None, None, "Covw Opleidingen", "Covw Opleidingen bv", None, "NL", Option("14093058"), Some("NL812244771B01"), None, None),
          (None, None, "TÜV Nederland", "TÜV Nederland QA bv", None, "NL", Option("17091102"), Some("NL008440116B01"), None, None),
          (None, None, "Bricksburg Construction", "Bricksburg Construction", None, "EU", Option("0"), Some("XXXXXXXXXXXXXX"), None, None),
          (None, None, "Heijmans Infra", "Heijmans Infra bv", None, "NL", Option("17104126"), Some("NL007837185B01"), None, None),
          (Some("frank@lego.com"), Some('M'), "Frank the Foreman", "Frank the Foreman", Some("Frank"), "EU", None, None, None, Some("http://68.media.tumblr.com/226c3a7920892f46c7185a90892a02ac/tumblr_n0kf7elw1l1rir6lho2_1280.jpg")),
          (Some("gail@lego.com"), Some('F'), "Gail", "Gail", Some("Gail"), "EU", None, None, None, None),
          (Some("emmet@lego.com"), Some('M'), "Hard Hat Emmet", "Hard Hat Emmet", Some("Emmet"), "EU", None, None, None, None),
          (Some("paul@example.nl"), Some('M'), "Paul", "Paul de Vlieger", Some("Paul"), "NL", None, None, None, None),
          (Some("piet@example.nl"), Some('M'), "Piet", "Piet Duivenvoorden", Some("Piet"), "NL", None, None, Some(Date.valueOf("2017-2-28")), None),
          (None, None, vendorGUID, vendor, None, "NL", Some("0" * 8), Some("123456789B01"), None, None),
          (None, None, "GreenTrac", "GreenTrac i.o", None, "NL", Some("0" * 8), Some("123456789B01"), None, None)
        ),

      Employees.map(emp => (emp.orgCompany, emp.usrEmployee, emp.jobtitle)) ++=
        List(("Bricksburg Construction", "Frank the Foreman", Some("Foreman")),
          ("Bricksburg Construction", "Gail", Some("Construction Worker"))
        ),

      Activityskills += ActivityskillsRow("Wall paperer"),

      Teams += TeamsRow("0", Some("Bricksburg Construction Team")),

      // teaTeamuuid: String, empUsrEmployeeguid: String, empOrgCompanyguid: String,
      EmpTea50 ++= List(EmpTea50Row("0", "Bricksburg Construction", "Frank the Foreman"),
        EmpTea50Row("0", "Bricksburg Construction", "Gail")
      ),

      Tags ++= List(TagsRow("Certifiers"), TagsRow("DummyTag"), TagsRow("Constructors"), TagsRow("LEGO © minifigures")),

      TagPrt62 ++= List(TagPrt62Row("TÜV Nederland", "Certifiers"),
        TagPrt62Row("Covw Opleidingen", "Certifiers"),
        TagPrt62Row("Frank the Foreman", "LEGO © minifigures"),
        TagPrt62Row("Hard Hat Emmet", "LEGO © minifigures"),
        TagPrt62Row("Gail", "LEGO © minifigures"),
        TagPrt62Row("Bricksburg Construction", "Constructors"),
        TagPrt62Row("Heijmans Infra", "Constructors")
      ),

      Contactpoints.map(ct => (ct.prtGuid, ct.contactkind, ct.branch, ct.uri, ct.telephonenumber, ct.addressline1, ct.postalcode, ct.postalcity)) ++=
        List(("TÜV Nederland", "PostalAddress", Some("Hoofdkantoor Best"), None, None, Some("Postbus 120"), Some("5680 AC"), Some("Best")),
          ("TÜV Nederland", "Domicile", Some("Hoofdkantoor Best"), None, None, Some("Waal"), Some("5684 PH"), Some("Best")),
          ("TÜV Nederland", "LandlinePhone", Some("Hoofdkantoor Best"), None, Some("+31 499 339 500"), None, None, None),
          ("TÜV Nederland", "Web", Some("Hoofdkantoor Best"), Some("https://www.tuv.nl/"), None, None, None, None),
          ("TÜV Nederland", "eMail", Some("Hoofdkantoor Best"), Some("mailto:info@tuv.nl"), None, None, None, None)),


      Documenttypes ++= List(
        DocumenttypesRow(documenttype = "AccessNote", description = Some("Notice of Site Access"), prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "A1/E101 Cert", description = Some("A1/E101 Certificate"), prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "Basiscursus BHV", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "DriverLicence", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "GVVA", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "GreenTracPass", prtEditor = Some("GreenTrac")),
        DocumenttypesRow(documenttype = "Hoisting cert.", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "MembershipsPass", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "Nat.Passport", description = Some("National passport"), prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "NL-TWV", description = Some("Dutch Employment permit"), prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "VCA-Groen", prtEditor = Some("GreenTrac")),
        DocumenttypesRow(documenttype = "VCA-VOL", prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "VCA/SCC", description = Some("VCA/SCC Basic Safety"), prtEditor = Some(vendorGUID)),
        DocumenttypesRow(documenttype = "VIL-VCU", prtEditor = Some(vendorGUID))),

      Projects.map(prj => (prj.orgProjowner, prj.prjProjectcode, prj.projectname, prj.startdate, prj.prjOrgSuperprojowner, prj.prjSuperprojectcode, prj.prjOrgAccprojowner, prj.prjAccprojcode, prj.enddate)) ++=
        List(("Heijmans Infra", "PROJCODE00", "Blabla", Date.valueOf("2017-01-1"), None, None, None, None, None),
          ("Bricksburg Construction", "COMPLEX000", "Complex", Date.valueOf("2017-01-1"), None, None, None, None, None),
          ("Bricksburg Construction", "COMPLEX001", "Complex", Date.valueOf("2017-01-1"),
            Some("Bricksburg Construction"), Some("COMPLEX000"), Some("Bricksburg Construction"), Some("COMPLEX000"), None)),

      Projectmemberprofiles.map(pmp => (pmp.orgProjowner, pmp.prjProjectcode, pmp.usrWorker, pmp.startdate, pmp.enddate)) ++=
        List(("Heijmans Infra", "PROJCODE00", "Paul", Timestamp.valueOf("2017-01-1 00:00:00"), Some(Date.valueOf("2017-06-30"))),
          ("Heijmans Infra", "PROJCODE00", "Frank the Foreman", Timestamp.valueOf("2017-01-1 00:00:00"), None),
          ("Heijmans Infra", "PROJCODE00", "Frank the Foreman", Timestamp.valueOf("2017-01-1 00:00:01"), None),
          ("Heijmans Infra", "PROJCODE00", "Gail", Timestamp.valueOf("2017-01-1 00:00:00"), None)
        ),

      Documents.map(doc => (doc.prtOwner, doc.docid, doc.dctDocumenttype, doc.expirationdate, doc.issuedate, doc.orgIssuer, doc.notice, doc.orgProjowner, doc.prjProjectcode, doc.checkedConfirmeddate)) ++=
        List(("Paul", "AccessNote 012345", "AccessNote", dontCareDt, sqlThisDay, "Frank the Foreman", Some("Melden bij de uitvoerder."), Some("Heijmans Infra"), Some("PROJCODE00"), None),
          ("Paul", "AccessNote 012346", "AccessNote", dontCareDt, sqlThisDay, "Frank the Foreman", Some("Melden bij de uitvoerder."), Some("Heijmans Infra"), Some("PROJCODE00"), None),
          ("Paul", "Doc 012345", "GreenTracPass", sqlMonthLater, sqlThisDay, "GreenTrac", None, None, None, None),
          ("Frank the Foreman", "Doc 123456", "GreenTracPass", sqlMonthLater, sqlThisDay, "GreenTrac", None, None, None, None),
          ("Gail", "Doc 123457", "GreenTracPass", sqlMonthLater, sqlThisDay, "GreenTrac", None, None, None, None),
          ("Frank the Foreman", "AccessNote 123456", "AccessNote", dontCareDt, sqlThisDay, "Frank the Foreman", Some("Melden bij de uitvoerder."), Some("Heijmans Infra"), Some("PROJCODE00"), None),
          ("Gail", "AccessNote 123457", "AccessNote", dontCareDt, sqlThisDay, "Frank the Foreman", Some("Melden bij de uitvoerder."), Some("Heijmans Infra"), Some("PROJCODE00"), Some(sqlThisDay)),
          ("Gail", "AccessNote 123458", "AccessNote", dontCareDt, sqlThisDay, "Frank the Foreman", Some("Melden bij de uitvoerder."), Some("Heijmans Infra"), Some("PROJCODE00"), Some(sqlThisDay))),

      Peripherals.map(ter => (ter.terGuid, ter.orgProjowner, ter.prjProjectcode)) ++=
        List(("TERMINAL0000001", "Heijmans Infra", "PROJCODE00"),
          ("TERMINAL0000002", "Heijmans Infra", "PROJCODE00")),


      Timeregistrations.map(tmr => (tmr.terGuidIn,
        tmr.prjOrgProjowner,
        tmr.prjProjectcode,
        tmr.docOwnerUsrWorker,
        tmr.checkindatetime,
        tmr.docDocid,
        tmr.docDocumenttype,
        tmr.docExpirationdate)) += ("TERMINAL0000001", "Heijmans Infra", "PROJCODE00", "Paul",
        Timestamp.valueOf("2017-03-25 00:00:00"), "Doc 012345", "GreenTracPass", sqlMonthLater)



      /*      Contactpoints forceInsertQuery (
              Parties/*.filter(_.guid === vendor)*/.map ( prt =>
                ("dada", "PostalAddress", Some("Hoofdkantoor Best"), None, None, Some("Postbus 120"), Some("5680 AC"), Some("Best"))
                )
            )*/

    )

    dbio
  }

  def summarizePopulation(): DBIOAction[Unit, NoStream, Effect] = {
    sql"""select * from #$objectNamePostFix"AllTablesSummarized"""".as[(String, Int)].map { cs =>
      logInfo("Database population summarization:")
      for (c <- cs) logInfo(f"${c._1}%24s, population: ${c._2}%6d rows")
      logInfo(f"${"  • − • − •" * 3}%40s")
    }
  }

  def dropNamedSchema(schemaName: Option[String]): DBIO[Unit] = DBIO.seq(
    sqlu"""DROP SCHEMA IF EXISTS #${schemaName.mkString("\"", "", "\"")}"""
  ).map(_ => logInfo(s"Schema ${schemaName.getOrElse("<default>")} dropped"))

  def createNamedSchema(schemaName: Option[String]): DBIO[Unit] = DBIO.seq(
    sqlu"""CREATE SCHEMA #${schemaName.mkString("\"", "", "\"")}"""
  ).map(_ => logInfo(s"Schema ${schemaName.getOrElse("<default>")} created"))

}