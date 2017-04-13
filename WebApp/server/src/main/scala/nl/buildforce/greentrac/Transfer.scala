package nl.buildforce.greentrac

import java.sql.Date

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Transfer {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._

  /** Collection-like TableQuery object for table Timeregistration */
  lazy val timeRegistration = new TableQuery(tag => new TimeRegistration(tag))

  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** GetResult implicit for fetching TimeregistrationRow objects using plain SQL queries */
  implicit def GetResultTimeregistrationRow(implicit e0: GR[String], e1: GR[Date], e2: GR[Option[Date]]): GR[TimeregistrationRow] = GR {
    prs =>
      import prs._
      TimeregistrationRow.tupled((<<[String], <<[String], <<[Date], <<[Date], <<[String], <<[String], <<[Date], <<[String], <<?[Date], <<[String]))
  }

  /** Entity class storing rows of table Timeregistration
    *
    * @param projectMemberProfielPartyGuid          Database column PROJECTMEMBERPROFIEL_PARTY_GUID SqlType(CHAR), Length(36,false)
    * @param projectMemberProfielProjectProjectcode Database column PROJECTMEMBERPROFIEL_PROJECT_PROJECTCODE SqlType(VARCHAR), Length(10,true)
    * @param projectMemberProfielStartdate          Database column PROJECTMEMBERPROFIEL_STARTDATE SqlType(DATE)
    * @param checkInDatetime                        Database column CHECKINDATETIME SqlType(DATE)
    * @param terminalTerminalGuid                   Database column TERMINAL_TERMINALGUID SqlType(CHAR), Length(36,false)
    * @param documentDocumentType                   Database column DOCUMENT_DOCUMENTTYPE SqlType(VARCHAR), Length(16,true)
    * @param documentExpirationDate                 Database column DOCUMENT_EXPIRATIONDATE SqlType(DATE)
    * @param documentPartyGuid1                     Database column DOCUMENT_PARTY_GUID1 SqlType(CHAR), Length(36,false)
    * @param checkoutDatetime                       Database column CHECKOUTDATETIME SqlType(DATE)
    * @param activitySkillActivity                  Database column ACTIVITYSKILL_ACTIVITY SqlType(VARCHAR), Length(10,true) */
  /*final*/ case class TimeregistrationRow(projectMemberProfielPartyGuid: String,
                                           projectMemberProfielProjectProjectcode: String,
                                           projectMemberProfielStartdate: Date,
                                           checkInDatetime: Date,
                                           terminalTerminalGuid: String,
                                           documentDocumentType: String,
                                           documentExpirationDate: Date,
                                           documentPartyGuid1: String,
                                           checkoutDatetime: Option[Date],
                                           activitySkillActivity: String)

  /** Table description of table TIMEREGISTRATION. Objects of this class serve as prototypes for rows in queries. */
  class TimeRegistration(_tableTag: Tag) extends Table[TimeregistrationRow](_tableTag, "TIMEREGISTRATIONS") {
    /** Database column PROJECTMEMBERPROFIEL_PARTY_GUID SqlType(CHAR), Length(36,false) */
    val projectmemberprofielPartyGuid: Rep[String] = column[String]("PMP_PRT_GUID", O.Length(36, varying = false))
    /** Database column PROJECTMEMBERPROFIEL_PROJECT_PROJECTCODE SqlType(VARCHAR), Length(10,true) */
    val projectmemberprofielProjectProjectcode: Rep[String] = column[String]("PROJECTMEMBERPROFIEL_PROJECT_PROJECTCODE", O.Length(10, varying = true))
    /** Database column PROJECTMEMBERPROFIEL_STARTDATE SqlType(DATE) */
    val projectmemberprofielStartdate: Rep[Date] = column[Date]("PROJECTMEMBERPROFIEL_STARTDATE")
    /** Database column CHECKINDATETIME SqlType(DATE) */
    val checkindatetime: Rep[Date] = column[Date]("CHECKINDATETIME")
    /** Database column TERMINAL_TERMINALGUID SqlType(CHAR), Length(36,false) */
    val terminalTerminalguid: Rep[String] = column[String]("TERMINAL_TERMINALGUID", O.Length(36, varying = false))
    /** Database column DOCUMENT_DOCUMENTTYPE SqlType(VARCHAR), Length(16,true) */
    val documentDocumenttype: Rep[String] = column[String]("DOCUMENT_DOCUMENTTYPE", O.Length(16, varying = true))
    /** Database column DOCUMENT_EXPIRATIONDATE SqlType(DATE) */
    val documentExpirationdate: Rep[Date] = column[Date]("DOCUMENT_EXPIRATIONDATE")
    /** Database column DOCUMENT_PARTY_GUID1 SqlType(CHAR), Length(36,false) */
    val documentPartyGuid1: Rep[String] = column[String]("DOCUMENT_PARTY_GUID1", O.Length(36, varying = false))
    /** Database column CHECKOUTDATETIME SqlType(DATE) */
    val checkoutdatetime: Rep[Option[Date]] = column[Option[Date]]("CHECKOUTDATETIME")
    /** Database column ACTIVITYSKILL_ACTIVITY SqlType(VARCHAR), Length(10,true) */
    val activityskillActivity: Rep[String] = column[String]("ACTIVITYSKILL_ACTIVITY", O.Length(10, varying = true))

    def * = (projectmemberprofielPartyGuid, projectmemberprofielProjectProjectcode, projectmemberprofielStartdate, checkindatetime, terminalTerminalguid, documentDocumenttype, documentExpirationdate, documentPartyGuid1, checkoutdatetime, activityskillActivity) <> (TimeregistrationRow.tupled, TimeregistrationRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(projectmemberprofielPartyGuid), Rep.Some(projectmemberprofielProjectProjectcode), Rep.Some(projectmemberprofielStartdate), Rep.Some(checkindatetime), Rep.Some(terminalTerminalguid), Rep.Some(documentDocumenttype), Rep.Some(documentExpirationdate), Rep.Some(documentPartyGuid1), checkoutdatetime, Rep.Some(activityskillActivity)).shaped.<>({ r => import r._; _1.map(_ => TimeregistrationRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

}
