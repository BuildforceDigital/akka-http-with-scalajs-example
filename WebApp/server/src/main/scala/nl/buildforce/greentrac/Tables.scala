package nl.buildforce.greentrac

import java.sql.{Blob, Date, Timestamp}

import slick.sql.SqlProfile.ColumnOption.SqlType

import scala.compat.Platform.currentTime

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  val schemaName : Option[String]

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  lazy val tableList = List(
    Activityskills,
    Contactpoints,
    Contracts,
    //    Credentials,
    Documents,
    Documenttypes,
    Employees,
    EmpTea50,
    Equipmentcertificates,
    Journalentries,
    Journals,
    Parties,
    Payments,
    PmpAct42,
    Priceplans,
    Projectmemberprofiles,
    Projects,
    Supplies,
    TagPrt62,
    Tags,
    Teams,
    Peripherals,
    Timeregistrations,
    Workerkits,
    Workingtimes
  )

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = tableList.map(_.schema).reduceLeft(_ ++ _)

  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Collection-like TableQuery object for table Activityskills */
  lazy val Activityskills = new TableQuery(tag => new Activityskills(tag))
  /** Collection-like TableQuery object for table Contactpoints */
  lazy val Contactpoints = new TableQuery(tag => new Contactpoints(tag))
  /** Collection-like TableQuery object for table Contracts */
  lazy val Contracts = new TableQuery(tag => new Contracts(tag))
  /** Collection-like TableQuery object for table Documents */
  lazy val Documents = new TableQuery(tag => new Documents(tag))
  /** Collection-like TableQuery object for table Documenttypes */
  lazy val Documenttypes = new TableQuery(tag => new Documenttypes(tag))
  /** Collection-like TableQuery object for table Employees */
  lazy val Employees = new TableQuery(tag => new Employees(tag))
  /** Collection-like TableQuery object for table EmpTea50 */
  lazy val EmpTea50 = new TableQuery(tag => new EmpTea50(tag))
  /** Collection-like TableQuery object for table Equipmentcertificates */
  lazy val Equipmentcertificates = new TableQuery(tag => new Equipmentcertificates(tag))
  /** Collection-like TableQuery object for table Journalentries */
  lazy val Journalentries = new TableQuery(tag => new Journalentries(tag))
  /** Collection-like TableQuery object for table Journals */
  lazy val Journals = new TableQuery(tag => new Journals(tag))
  /** Collection-like TableQuery object for table Parties */
  lazy val Parties = new TableQuery(tag => new Parties(tag))
  /** Collection-like TableQuery object for table Payments */
  lazy val Payments = new TableQuery(tag => new Payments(tag))
  /** Collection-like TableQuery object for table PmpAct42 */
  lazy val PmpAct42 = new TableQuery(tag => new PmpAct42(tag))
  /** Collection-like TableQuery object for table Priceplans */
  lazy val Priceplans = new TableQuery(tag => new Priceplans(tag))
  /** Collection-like TableQuery object for table Projectmemberprofiles */
  lazy val Projectmemberprofiles = new TableQuery(tag => new Projectmemberprofiles(tag))

  /** GetResult implicit for fetching ActivityskillsRow objects using plain SQL queries */
  implicit def GetResultActivityskillsRow(implicit e0: GR[String]): GR[ActivityskillsRow] =
    GR { prs =>
      import prs._
      ActivityskillsRow(<<[String])
    }
  /** Collection-like TableQuery object for table Projects */
  lazy val Projects = new TableQuery(tag => new Projects(tag))
  /** Collection-like TableQuery object for table Supplies */
  lazy val Supplies = new TableQuery(tag => new Supplies(tag))
  /** Collection-like TableQuery object for table TagPrt62 */
  lazy val TagPrt62 = new TableQuery(tag => new TagPrt62(tag))

  /** GetResult implicit for fetching ContactpointsRow objects using plain SQL queries */
  implicit def GetResultContactpointsRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Date]]): GR[ContactpointsRow] = GR {
    prs =>
      import prs._
      ContactpointsRow.tupled((<<[String], <<[String], <<?[String], <<?[Date], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Collection-like TableQuery object for table Tags */
  lazy val Tags = new TableQuery(tag => new Tags(tag))
  /** Collection-like TableQuery object for table Teams */
  lazy val Teams = new TableQuery(tag => new Teams(tag))
  /** Collection-like TableQuery object for table Peripherals */
  lazy val Peripherals = new TableQuery(tag => new Peripherals(tag))

  /** GetResult implicit for fetching ContractsRow objects using plain SQL queries */
  implicit def GetResultContractsRow(implicit e0: GR[String], e1: GR[Date]): GR[ContractsRow] = GR {
    prs =>
      import prs._
      ContractsRow.tupled((<<[String], <<[Date], <<[String], <<[Date]))
  }
  /** Collection-like TableQuery object for table Timeregistrations */
  lazy val Timeregistrations = new TableQuery(tag => new Timeregistrations(tag))
  /** Collection-like TableQuery object for table Workerkits */
  lazy val Workerkits = new TableQuery(tag => new Workerkits(tag))
  /** Collection-like TableQuery object for table Workingtimes */
  lazy val Workingtimes = new TableQuery(tag => new Workingtimes(tag))

  /** GetResult implicit for fetching EmployeesRow objects using plain SQL queries */
  implicit def GetResultEmployeesRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Date]]): GR[EmployeesRow] = GR {
    prs =>
      import prs._
      EmployeesRow.tupled((<<[String], <<[String], <<[Int], <<?[String], <<?[String], <<?[Date]))
  }

  /** GetResult implicit for fetching EmpTea50Row objects using plain SQL queries */
  implicit def GetResultEmpTea50Row(implicit e0: GR[String], e1: GR[Int]): GR[EmpTea50Row] = GR {
    prs =>
      import prs._
      EmpTea50Row.tupled((<<[String], <<[String], <<[String], <<[Int]))
  }


  //val profile: slick.jdbc.JdbcProfile

  /** GetResult implicit for fetching EquipmentcertificatesRow objects using plain SQL queries */
  implicit def GetResultEquipmentcertificatesRow(implicit e0: GR[String], e1: GR[Date], e2: GR[Option[Date]]): GR[EquipmentcertificatesRow] = GR {
    prs =>
      import prs._
      EquipmentcertificatesRow.tupled((<<[String], <<[Date], <<[String], <<?[Date], <<?[Date]))
  }

  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Activityskills
    *
    * @param activity Database column Activity SqlType(VARCHAR), PrimaryKey, Length(24,true) */
  /*final */ case class ActivityskillsRow(activity: String)

  /** Table description of table ActivitySkills. Objects of this class serve as prototypes for rows in queries. */
  class Activityskills(_tableTag: Tag) extends
    profile.api.Table[ActivityskillsRow](_tableTag, schemaName, "ActivitySkills") {
    /** Database column Activity SqlType(VARCHAR), PrimaryKey, Length(24,true) */
    val activity: Rep[String] = column[String]("Activity", O.Length(24, varying = true))

    def pk = primaryKey("ACT_PK", activity)

    def * = activity <> (ActivityskillsRow, ActivityskillsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(activity).shaped.<>(r => r.map(_ => ActivityskillsRow(r.get)),
      (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** GetResult implicit for fetching JournalentriesRow objects using plain SQL queries */
  implicit def GetResultJournalentriesRow(implicit e0: GR[Date], e1: GR[String], e2: GR[Int]): GR[JournalentriesRow] = GR {
    prs =>
      import prs._
      JournalentriesRow.tupled((<<[Date], <<[String], <<[String], <<[Int], <<[String]))
  }

  /** Entity class storing rows of table Contactpoints
    *
    * @param prtGuid         Database column PRT_GUID SqlType(VARCHAR), Length(36,true)
    * @param contactkind     Database column ContactKind SqlType(VARCHAR), Length(16,true)
    * @param branch          Database column Branch SqlType(VARCHAR), Length(240,true)
    * @param expirationdate  Database column ExpirationDate SqlType(DATE)
    * @param uri             Database column URI SqlType(VARCHAR), Length(80,true)
    * @param telephonenumber Database column TelephoneNumber SqlType(VARCHAR), Length(16,true)
    * @param addressline1    Database column AddressLine1 SqlType(VARCHAR), Length(40,true)
    * @param addressline2    Database column AddressLine2 SqlType(VARCHAR), Length(40,true)
    * @param streetnumber    Database column StreetNumber SqlType(VARCHAR), Length(8,true)
    * @param postalcity      Database column PostalCity SqlType(VARCHAR), Length(20,true)
    * @param postalcode      Database column PostalCode SqlType(VARCHAR), Length(16,true)
    * @param postalcountry   Database column PostalCountry SqlType(VARCHAR), Length(56,true) */
  /*final*/ case class ContactpointsRow(prtGuid: String,
                                        contactkind: String,
                                        branch: Option[String],
                                        expirationdate: Option[Date],
                                        uri: Option[String],
                                        telephonenumber: Option[String],
                                        addressline1: Option[String],
                                        addressline2: Option[String], streetnumber: Option[String],
                                        postalcity: Option[String],
                                        postalcode: Option[String],
                                        postalcountry: Option[String])

  /** Table description of table ContactPoints. Objects of this class serve as prototypes for rows in queries. */
  class Contactpoints(_tableTag: Tag) extends profile.api.Table[ContactpointsRow](_tableTag, schemaName, "ContactPoints") {
    /** Foreign key referencing Parties (database name CTP_PRT_FK) */
    lazy val partiesFk = foreignKey("CTP_PRT_FK", prtGuid, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column PRT_GUID SqlType(VARCHAR), Length(36,true) */
    val prtGuid: Rep[String] = column[String]("PRT_GUID", O.Length(36, varying = true))
    /** Database column ContactKind SqlType(VARCHAR), Length(16,true) */
    val contactkind: Rep[String] = column[String]("ContactKind", O.Length(16, varying = true))
    /** Database column Branch SqlType(VARCHAR), Length(240,true) */
    val branch: Rep[Option[String]] = column[Option[String]]("Branch", O.Length(240, varying = true))
    /** Database column ExpirationDate SqlType(DATE) */
    val expirationdate: Rep[Option[Date]] = column[Option[Date]]("ExpirationDate")
    /** Database column URI SqlType(VARCHAR), Length(160,true) */
    val uri: Rep[Option[String]] = column[Option[String]]("URI", O.Length(160, varying = true))
    /** Database column TelephoneNumber SqlType(VARCHAR), Length(16,true) */
    val telephonenumber: Rep[Option[String]] = column[Option[String]]("TelephoneNumber", O.Length(16, varying = true))
    /** Database column AddressLine1 SqlType(VARCHAR), Length(40,true) */
    val addressline1: Rep[Option[String]] = column[Option[String]]("AddressLine1", O.Length(40, varying = true))
    /** Database column AddressLine2 SqlType(VARCHAR), Length(40,true) */
    val addressline2: Rep[Option[String]] = column[Option[String]]("AddressLine2", O.Length(40, varying = true))
    /** Database column StreetNumber SqlType(VARCHAR), Length(8,true) */
    val streetnumber: Rep[Option[String]] = column[Option[String]]("StreetNumber", O.Length(8, varying = true))
    /** Database column PostalCity SqlType(VARCHAR), Length(20,true) */
    val postalcity: Rep[Option[String]] = column[Option[String]]("PostalCity", O.Length(20, varying = true))
    /** Database column PostalCode SqlType(VARCHAR), Length(16,true) */
    val postalcode: Rep[Option[String]] = column[Option[String]]("PostalCode", O.Length(16, varying = true))
    /** Database column PostalCountry SqlType(VARCHAR), Length(56,true) */
    val postalcountry: Rep[Option[String]] = column[Option[String]]("PostalCountry", O.Length(56, varying = true))
    /** Primary key of Contactpoints (database name CTP_PK) */
    val pk = primaryKey("CTP_PK", (contactkind, prtGuid))

    def * = (prtGuid, contactkind, branch, expirationdate, uri, telephonenumber, addressline1, addressline2, streetnumber, postalcity, postalcode, postalcountry) <>
      (ContactpointsRow.tupled, ContactpointsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(prtGuid), Rep.Some(contactkind), branch, expirationdate, uri, telephonenumber, addressline1, addressline2, streetnumber, postalcity, postalcode, postalcountry).shaped.<>({ r => import r._; _1.map(_ => ContactpointsRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Contracts
    *
    * @param prtContractingparty Database column PRT_ContractingParty SqlType(VARCHAR), Length(36,true)
    * @param expirationdate      Database column ExpirationDate SqlType(DATE)
    * @param prpPriceplancode    Database column PRP_PricePlanCode SqlType(VARCHAR), Length(10,true)
    * @param prpStartdate        Database column PRP_StartDate SqlType(DATE) */
  case class ContractsRow(prtContractingparty: String, expirationdate: Date, prpPriceplancode: String, prpStartdate: Date)

  /** GetResult implicit for fetching JournalsRow objects using plain SQL queries */
  implicit def GetResultJournalsRow(implicit e0: GR[Date], e1: GR[String]): GR[JournalsRow] = GR {
    prs =>
      import prs._
      JournalsRow.tupled((<<[Date], <<[String], <<[String], <<[String]))
  }

  /** Table description of table Contracts. Objects of this class serve as prototypes for rows in queries. */
  class Contracts(_tableTag: Tag) extends profile.api.Table[ContractsRow](_tableTag, schemaName, "Contracts") {
    /** Foreign key referencing Parties (database name CON_PRT_FK) */
    lazy val partiesFk = foreignKey("CON_PRT_FK", prtContractingparty, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Priceplans (database name CON_PRP_FK) */
    lazy val priceplansFk = foreignKey("CON_PRP_FK", (prpPriceplancode, prpStartdate), Priceplans)(r => (r.priceplancode, r.startdate), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column PRT_ContractingParty SqlType(VARCHAR), Length(36,true) */
    val prtContractingparty: Rep[String] = column[String]("PRT_ContractingParty", O.Length(36, varying = true))
    /** Database column ExpirationDate SqlType(DATE) */
    val expirationdate: Rep[Date] = column[Date]("ExpirationDate")
    /** Database column PRP_PricePlanCode SqlType(VARCHAR), Length(10,true) */
    val prpPriceplancode: Rep[String] = column[String]("PRP_PricePlanCode", O.Length(10, varying = true))
    /** Database column PRP_StartDate SqlType(DATE) */
    val prpStartdate: Rep[Date] = column[Date]("PRP_StartDate")

    /** Primary key of Contracts (database name CON_PK) */
    val pk = primaryKey("CON_PK", (prtContractingparty, expirationdate))

    def * = (prtContractingparty, expirationdate, prpPriceplancode, prpStartdate) <> (ContractsRow.tupled, ContractsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(prtContractingparty),
      Rep.Some(expirationdate),
      Rep.Some(prpPriceplancode),
      Rep.Some(prpStartdate)).shaped.<>({ r => import r._; _1.map(_ => ContractsRow.tupled((_1.get, _2.get, _3.get, _4.get))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Credentials */
  /*final*/ case class CredentialsRow()

  /** Entity class storing rows of table Documents
    *
    * @param dctDocumenttype      Database column DCT_DocumentType SqlType(VARCHAR), Length(16,true)
    * @param expirationdate       Database column ExpirationDate SqlType(DATE)
    * @param docid                Database column DocID SqlType(VARCHAR), Length(240,true)
    * @param prtOwner             Database column PRT_Owner SqlType(VARCHAR), Length(36,true)
    * @param issuedate            Database column IssueDate SqlType(DATE)
    * @param orgIssuer            Database column ORG_Issuer SqlType(VARCHAR), Length(36,true)
    * @param createdatdatetime    Database column CreatedAtDatetime SqlType(TIMESTAMP)
    * @param usrChecker           Database column USR_Checker SqlType(VARCHAR), Length(36,true)
    * @param checkedConfirmeddate Database column Checked_ConfirmedDate SqlType(DATE)
    * @param passkey              Database column Passkey SqlType(VARCHAR), Length(240,true)
    * @param notice               Database column Notice SqlType(VARCHAR), Length(480,true)
    * @param picture              Database column Picture SqlType(BLOB)
    * @param pictureurl           Database column PictureURL SqlType(VARCHAR), Length(160,true)
    * @param rejectedDatetime     Database column Rejected_Datetime SqlType(TIMESTAMP)
    * @param orgProjowner         Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode       Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param pmpStarttime         Database column PMP_Starttime SqlType(TIMESTAMP) */
  final case class DocumentsRow(dctDocumenttype: String,
                                expirationdate: Date,
                                docid: String,
                                prtOwner: String,
                                issuedate: Date,
                                orgIssuer: String,
                                createdatdatetime: Timestamp = new Timestamp(currentTime),
                                usrChecker: Option[String],
                                checkedConfirmeddate: Option[Date],
                                passkey: Option[String],
                                notice: Option[String],
                                picture: Option[Blob],
                                pictureurl: Option[String],
                                rejectedDatetime: Option[Timestamp],
                                orgProjowner: Option[String],
                                prjProjectcode: Option[String],
                                pmpStarttime: Option[Timestamp])

  /** GetResult implicit for fetching DocumentsRow objects using plain SQL queries */
  implicit def GetResultDocumentsRow(implicit e0: GR[String], e1: GR[Date], e2: GR[Timestamp], e3: GR[Option[String]], e4: GR[Option[Date]], e5: GR[Option[Blob]], e6: GR[Option[Timestamp]]): GR[DocumentsRow] = GR {
    prs =>
      import prs._
      DocumentsRow.tupled((<<[String], <<[Date], <<[String], <<[String], <<[Date], <<[String], <<[Timestamp], <<?[String], <<?[Date], <<?[String], <<?[String], <<?[Blob], <<?[String], <<?[Timestamp], <<?[String], <<?[String], <<?[Timestamp]))
  }

  /** Table description of table Documents. Objects of this class serve as prototypes for rows in queries. */
  class Documents(_tableTag: Tag) extends profile.api.Table[DocumentsRow](_tableTag, schemaName, "Documents") {
    /** Foreign key referencing Documenttypes (database name DOC_DCT_FK) */
    lazy val documenttypesFk = foreignKey("DOC_DCT_FK", dctDocumenttype, Documenttypes)(r => r.documenttype, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name DOC_PRT_FK) */
    lazy val partiesFk2 = foreignKey("DOC_PRT_FK", orgIssuer, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name DOC_PRT_FKv2) */
    lazy val partiesFk3 = foreignKey("DOC_PRT_FKv2", prtOwner, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name DOC_PRT_FKv3) */
    lazy val partiesFk4 = foreignKey("DOC_PRT_FKv3", usrChecker, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projectmemberprofiles (database name ACN_PMP_FK) */
    lazy val projectmemberprofilesFk = foreignKey("ACN_PMP_FK", (orgProjowner, prjProjectcode, prtOwner, pmpStarttime), Projectmemberprofiles)(r => (Rep.Some(r.orgProjowner), Rep.Some(r.prjProjectcode), r.usrWorker, Rep.Some(r.startdate)), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column DCT_DocumentType SqlType(VARCHAR), Length(16,true) */
    val dctDocumenttype: Rep[String] = column[String]("DCT_DocumentType", O.Length(16, varying = true))
    /** Database column ExpirationDate SqlType(DATE) */
    val expirationdate: Rep[Date] = column[Date]("ExpirationDate")
    /** Database column DocID SqlType(VARCHAR), Length(240,true) */
    val docid: Rep[String] = column[String]("DocID", O.Length(240, varying = true))
    /** Database column PRT_Owner SqlType(VARCHAR), Length(36,true) */
    val prtOwner: Rep[String] = column[String]("PRT_Owner", O.Length(36, varying = true))
    /** Database column IssueDate SqlType(DATE) */
    val issuedate: Rep[Date] = column[Date]("IssueDate")
    /** Database column ORG_Issuer SqlType(VARCHAR), Length(36,true) */
    val orgIssuer: Rep[String] = column[String]("ORG_Issuer", O.Length(36, varying = true))
    /** Database column Created_At_Datetime SqlType(TIMESTAMP) */
    val createdAtDatetime: Rep[Timestamp] = column[Timestamp]("Created_At_Datetime", SqlType("TIMESTAMP default CURRENT_TIMESTAMP"))
    /** Database column USR_Checker SqlType(VARCHAR), Length(36,true) */
    val usrChecker: Rep[Option[String]] = column[Option[String]]("USR_Checker", O.Length(36, varying = true))
    /** Database column Checked_ConfirmedDate SqlType(DATE) */
    val checkedConfirmeddate: Rep[Option[Date]] = column[Option[Date]]("Checked_ConfirmedDate")
    /** Database column Passkey SqlType(VARCHAR), Length(240,true) */
    val passkey: Rep[Option[String]] = column[Option[String]]("Passkey", O.Length(240, varying = true))
    /** Database column Notice SqlType(VARCHAR), Length(480,true) */
    val notice: Rep[Option[String]] = column[Option[String]]("Notice", O.Length(480, varying = true))
    /** Database column Picture SqlType(BLOB) */
    val picture: Rep[Option[Blob]] = column[Option[Blob]]("Picture")
    /** Database column PictureURL SqlType(VARCHAR), Length(160,true) */
    val pictureUrl: Rep[Option[String]] = column[Option[String]]("Picture_URL", O.Length(160, varying = true))
    /** Database column Rejected_Datetime SqlType(TIMESTAMP) */
    val rejectedDatetime: Rep[Option[Timestamp]] = column[Option[Timestamp]]("Rejected_Datetime")
    /** Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val orgProjowner: Rep[Option[String]] = column[Option[String]]("ORG_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[Option[String]] = column[Option[String]]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column PMP_Starttime SqlType(TIMESTAMP) */
    val pmpStarttime: Rep[Option[Timestamp]] = column[Option[Timestamp]]("PMP_Starttime")
    /** Primary key of Documents (database name DOC_PK) */
    val pk = primaryKey("DOC_PK", (dctDocumenttype, expirationdate, docid))
    /** Uniqueness Index over (dctDocumenttype,expirationdate,docid,prtOwner) (database name TMR_DOC_FK_INDEX_A) */
    val index1 = index("TMR_DOC_FK_INDEX_A", (dctDocumenttype, expirationdate, docid, prtOwner), unique = true)

    def * = (dctDocumenttype, expirationdate, docid, prtOwner, issuedate, orgIssuer, createdAtDatetime, usrChecker, checkedConfirmeddate, passkey, notice, picture, pictureUrl, rejectedDatetime, orgProjowner, prjProjectcode, pmpStarttime) <> (DocumentsRow.tupled, DocumentsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(dctDocumenttype), Rep.Some(expirationdate), Rep.Some(docid), Rep.Some(prtOwner), Rep.Some(issuedate), Rep.Some(orgIssuer), Rep.Some(createdAtDatetime), usrChecker, checkedConfirmeddate, passkey, notice, picture, pictureUrl, rejectedDatetime, orgProjowner, prjProjectcode, pmpStarttime).shaped.<>({ r => import r._; _1.map(_ => DocumentsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Documenttypes
    *
    * @param documenttype    Database column DocumentType SqlType(VARCHAR), PrimaryKey, Length(16,true)
    * @param editiondatetime Database column EditionDate SqlType(TIMESTAMP)
    * @param description     Database column Description SqlType(VARCHAR), Length(40,true)
    * @param prtEditor       Database column PRT_Editor SqlType(VARCHAR), Length(36,true)
    * @param remark          Database column PRT_Editor SqlType(VARCHAR), Length(36,true) */
  final case class DocumenttypesRow(documenttype: String, editiondatetime: Timestamp = new Timestamp(currentTime), prtEditor: Option[String], description: Option[String] = None, referenceUrl: Option[String] = None, remark: Option[String] = None)

  /** GetResult implicit for fetching DocumenttypesRow objects using plain SQL queries */
  implicit def GetResultDocumenttypesRow(implicit e0: GR[String], e1: GR[Option[Timestamp]], e2: GR[Option[String]]): GR[DocumenttypesRow] = GR {
    prs =>
      import prs._
      DocumenttypesRow.tupled((<<[String], <<[Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }

  /** Table description of table DocumentTypes. Objects of this class serve as prototypes for rows in queries. */
  class Documenttypes(_tableTag: Tag) extends profile.api.Table[DocumenttypesRow](_tableTag, schemaName, "DocumentTypes") {
    /** Foreign key referencing Parties (database name DCT_PRT_FK) */
    lazy val partiesFk = foreignKey("DCT_PRT_FK", prtEditor, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ImageURL SqlType(VARCHAR), Length(80,true) */
    val referenceUrl: Rep[Option[String]] = column[Option[String]]("ReferenceURL", O.Length(160, varying = true))
    /** Database column DocumentType SqlType(VARCHAR), PrimaryKey, Length(16,true) */
    val documenttype: Rep[String] = column[String]("DocumentType", O.PrimaryKey, O.Length(16, varying = true))
    /** Database column EditionDate SqlType(TIMESTAMP) */
    val editiondatetime: Rep[Timestamp] = column[Timestamp]("EditionDatetime", SqlType("TIMESTAMP default CURRENT_TIMESTAMP"))
    /** Database column Description SqlType(VARCHAR), Length(40,true) */
    val description: Rep[Option[String]] = column[Option[String]]("Description", O.Length(40, varying = true))
    /** Database column PRT_Editor SqlType(VARCHAR), Length(36,true) */
    val prtEditor: Rep[Option[String]] = column[Option[String]]("PRT_Editor", O.Length(36, varying = true))
    /** Database column PRT_Editor SqlType(VARCHAR), Length(36,true) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(480, varying = true))

    def * = (documenttype, editiondatetime, prtEditor, description, referenceUrl, remark) <> (DocumenttypesRow.tupled, DocumenttypesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(documenttype), Rep.Some(editiondatetime), prtEditor, description, referenceUrl, remark).shaped.<>({ r => import r._; _1.map(_ => DocumenttypesRow.tupled((_1.get, _2.get, _3, _4, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** GetResult implicit for fetching PaymentsRow objects using plain SQL queries */
  implicit def GetResultPaymentsRow(implicit e0: GR[String], e1: GR[Date], e2: GR[BigDecimal]): GR[PaymentsRow] = GR {
    prs =>
      import prs._
      PaymentsRow.tupled((<<[String], <<[Date], <<[BigDecimal], <<[Date]))
  }

  /** Entity class storing rows of table Employees
    *
    * @param orgCompany          Database column ORG_Company SqlType(VARCHAR), Length(36,true)
    * @param usrEmployee         Database column USR_Employee SqlType(VARCHAR), Length(36,true)
    * @param versionnumber       Database column VersionNumber SqlType(INTEGER), Default(0)
    * @param jobtitle            Database column JobTitle SqlType(VARCHAR), Length(40,true)
    * @param orgContactpersonfor Database column ORG_ContactPersonFor SqlType(VARCHAR), Length(36,true)
    * @param enddate             Database column EndDate SqlType(DATE) */
  /*final*/ case class EmployeesRow(orgCompany: String,
                                    usrEmployee: String,
                                    versionnumber: Int = 0,
                                    jobtitle: Option[String],
                                    orgContactpersonfor: Option[String],
                                    enddate: Option[Date])

  /** Table description of table Employees. Objects of this class serve as prototypes for rows in queries. */
  class Employees(_tableTag: Tag) extends profile.api.Table[EmployeesRow](_tableTag, schemaName, "Employees") {
    /** Foreign key referencing Parties (database name EMP_PRT_FK) */
    lazy val partiesFk1 = foreignKey("EMP_NPR_FK", usrEmployee, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name EMP_PRT_FKv2) */
    lazy val partiesFk2 = foreignKey("EMP_ORG_FKv2", orgCompany, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name EMP_PRT_FKv3) */
    lazy val partiesFk3 = foreignKey("EMP_ORG_FKv3", orgContactpersonfor, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ORG_Company SqlType(VARCHAR), Length(36,true) */
    val orgCompany: Rep[String] = column[String]("ORG_Company", O.Length(36, varying = true))
    /** Database column USR_Employee SqlType(VARCHAR), Length(36,true) */
    val usrEmployee: Rep[String] = column[String]("USR_Employee", O.Length(36, varying = true))
    /** Database column VersionNumber SqlType(INTEGER), Default(0) */
    val versionnumber: Rep[Int] = column[Int]("VersionNumber", O.Default(0))
    /** Database column JobTitle SqlType(VARCHAR), Length(40,true) */
    val jobtitle: Rep[Option[String]] = column[Option[String]]("JobTitle", O.Length(40, varying = true))
    /** Database column ORG_ContactPersonFor SqlType(VARCHAR), Length(36,true) */
    val orgContactpersonfor: Rep[Option[String]] = column[Option[String]]("ORG_ContactPersonFor", O.Length(36, varying = true))
    /** Database column EndDate SqlType(DATE) */
    val enddate: Rep[Option[Date]] = column[Option[Date]]("EndDate")
    /** Primary key of Employees (database name EMP_PK) */
    val pk = primaryKey("EMP_PK", (orgCompany, usrEmployee, versionnumber))

    def * = (orgCompany, usrEmployee, versionnumber, jobtitle, orgContactpersonfor, enddate) <> (EmployeesRow.tupled, EmployeesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(orgCompany), Rep.Some(usrEmployee), Rep.Some(versionnumber), jobtitle, orgContactpersonfor, enddate).shaped.<>({ r => import r._; _1.map(_ => EmployeesRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table EmpTea50
    *
    * @param teaTeamuuid        Database column TEA_TeamUUID SqlType(VARCHAR), Length(36,true)
    * @param empUsrEmployeeguid Database column EMP_USR_EmployeeGUID SqlType(VARCHAR), Length(36,true)
    * @param empOrgCompanyguid  Database column EMP_ORG_CompanyGUID SqlType(VARCHAR), Length(36,true)
    * @param empVersionnumber   Database column EMP_VersionNumber SqlType(INTEGER), Default(0) */
  case class EmpTea50Row(teaTeamuuid: String, empUsrEmployeeguid: String, empOrgCompanyguid: String, empVersionnumber: Int = 0)

  /** GetResult implicit for fetching PmpAct42Row objects using plain SQL queries */
  implicit def GetResultPmpAct42Row(implicit e0: GR[String], e1: GR[Date]): GR[PmpAct42Row] = GR {
    prs =>
      import prs._
      PmpAct42Row.tupled((<<[String], <<[String], <<[String], <<[String], <<[Timestamp]))
  }

  /** Table description of table Emp_Tea_50. Objects of this class serve as prototypes for rows in queries. */
  class EmpTea50(_tableTag: Tag) extends profile.api.Table[EmpTea50Row](_tableTag, schemaName, "Emp_Tea_50") {
    /** Foreign key referencing Employees (database name TEA_EMP_50_EMP_FK) */
    lazy val employeesFk = foreignKey("TXP_EMP_50_EMP_FK", (empUsrEmployeeguid, empOrgCompanyguid, empVersionnumber), Employees)(r => (r.orgCompany, r.usrEmployee, r.versionnumber), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Teams (database name TEA_EMP_50_TEA_FK) */
    lazy val teamsFk = foreignKey("TXP_EMP_50_TEA_FK", teaTeamuuid, Teams)(r => r.teamuuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column TEA_TeamUUID SqlType(VARCHAR), Length(36,true) */
    val teaTeamuuid: Rep[String] = column[String]("TEA_TeamUUID", O.Length(36, varying = true))
    /** Database column EMP_USR_EmployeeGUID SqlType(VARCHAR), Length(36,true) */
    val empUsrEmployeeguid: Rep[String] = column[String]("EMP_USR_EmployeeGUID", O.Length(36, varying = true))
    /** Database column EMP_ORG_CompanyGUID SqlType(VARCHAR), Length(36,true) */
    val empOrgCompanyguid: Rep[String] = column[String]("EMP_ORG_CompanyGUID", O.Length(36, varying = true))
    /** Database column EMP_VersionNumber SqlType(INTEGER), Default(0) */
    val empVersionnumber: Rep[Int] = column[Int]("EMP_VersionNumber", O.Default(0))

    /** Primary key of EmpTea50 (database name TEA_EMP_50_PK) */
    val pk = primaryKey("TXP_EMP_50_PK", (teaTeamuuid, empUsrEmployeeguid, empOrgCompanyguid, empVersionnumber))

    def * = (teaTeamuuid, empUsrEmployeeguid, empOrgCompanyguid, empVersionnumber) <> (EmpTea50Row.tupled, EmpTea50Row.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(teaTeamuuid), Rep.Some(empUsrEmployeeguid), Rep.Some(empOrgCompanyguid), Rep.Some(empVersionnumber)).shaped.<>({ r => import r._; _1.map(_ => EmpTea50Row.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Equipmentcertificates
    *
    * @param supSupplyguid         Database column SUP_SupplyGUID SqlType(VARCHAR), Length(36,true)
    * @param inspectiondate        Database column InspectionDate SqlType(DATE)
    * @param supOrgOwner           Database column SUP_ORG_Owner SqlType(VARCHAR), Length(36,true)
    * @param certificateexpiration Database column CertificateExpiration SqlType(DATE)
    * @param defectsince           Database column DefectSince SqlType(DATE) */
  case class EquipmentcertificatesRow(supSupplyguid: String,
                                      inspectiondate: Date,
                                      supOrgOwner: String,
                                      certificateexpiration: Option[Date],
                                      defectsince: Option[Date])

  /** Table description of table EquipmentCertificates. Objects of this class serve as prototypes for rows in queries. */
  class Equipmentcertificates(_tableTag: Tag) extends profile.api.Table[EquipmentcertificatesRow](_tableTag, schemaName, "EquipmentCertificates") {
    /** Foreign key referencing Supplies (database name EQC_SUP_FK) */
    lazy val suppliesFk = foreignKey("EQC_SUP_FK", (supSupplyguid, supOrgOwner), Supplies)(r => (r.supplyguid, r.orgOwner), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column SUP_SupplyGUID SqlType(VARCHAR), Length(36,true) */
    val supSupplyguid: Rep[String] = column[String]("SUP_SupplyGUID", O.Length(36, varying = true))
    /** Database column InspectionDate SqlType(DATE) */
    val inspectiondate: Rep[Date] = column[Date]("InspectionDate")
    /** Database column SUP_ORG_Owner SqlType(VARCHAR), Length(36,true) */
    val supOrgOwner: Rep[String] = column[String]("SUP_ORG_Owner", O.Length(36, varying = true))
    /** Database column CertificateExpiration SqlType(DATE) */
    val certificateexpiration: Rep[Option[Date]] = column[Option[Date]]("CertificateExpiration")
    /** Database column DefectSince SqlType(DATE) */
    val defectsince: Rep[Option[Date]] = column[Option[Date]]("DefectSince")
    /** Primary key of Equipmentcertificates (database name EQC_PK) */
    val pk = primaryKey("EQC_PK", (supSupplyguid, inspectiondate))

    def * = (supSupplyguid, inspectiondate, supOrgOwner, certificateexpiration, defectsince) <> (EquipmentcertificatesRow.tupled, EquipmentcertificatesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(supSupplyguid), Rep.Some(inspectiondate), Rep.Some(supOrgOwner), certificateexpiration, defectsince).shaped.<>({ r => import r._; _1.map(_ => EquipmentcertificatesRow.tupled((_1.get, _2.get, _3.get, _4, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** GetResult implicit for fetching PriceplansRow objects using plain SQL queries */
  implicit def GetResultPriceplansRow(implicit e0: GR[String], e1: GR[Date], e2: GR[Option[String]], e3: GR[Option[Date]], e4: GR[BigDecimal], e5: GR[Option[BigDecimal]]): GR[PriceplansRow] = GR {
    prs =>
      import prs._
      PriceplansRow.tupled((<<[String], <<[Date], <<?[String], <<?[Date], <<[BigDecimal], <<?[BigDecimal], <<?[BigDecimal]))
  }

  /** Entity class storing rows of table Journalentries
    *
    * @param jrnDay             Database column JRN_Day SqlType(DATE)
    * @param jrnPrjProjectcode  Database column JRN_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param jrnPrjPrtProjowner Database column JRN_PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param entrynumber        Database column EntryNumber SqlType(INTEGER), PrimaryKey, Default(0)
    * @param entry              Database column Entry SqlType(VARCHAR), Length(480,true) */
  case class JournalentriesRow(jrnDay: Date, jrnPrjProjectcode: String, jrnPrjPrtProjowner: String, entrynumber: Int = 0, entry: String)

  /** Table description of table JournalEntries. Objects of this class serve as prototypes for rows in queries. */
  class Journalentries(_tableTag: Tag) extends profile.api.Table[JournalentriesRow](_tableTag, schemaName, "JournalEntries") {
    /** Foreign key referencing Journals (database name JRE_JRN_FK) */
    lazy val journalsFk = foreignKey("JRE_JRN_FK", (jrnDay, jrnPrjProjectcode, jrnPrjPrtProjowner), Journals)(r => (r.day, r.prjProjectcode, r.prjPrtProjowner), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column JRN_Day SqlType(DATE) */
    val jrnDay: Rep[Date] = column[Date]("JRN_Day")
    /** Database column JRN_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val jrnPrjProjectcode: Rep[String] = column[String]("JRN_PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column JRN_PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val jrnPrjPrtProjowner: Rep[String] = column[String]("JRN_PRJ_PRT_ProjOwner", O.Length(36, varying = true))
    /** Database column EntryNumber SqlType(INTEGER), PrimaryKey, Default(0) */
    val entrynumber: Rep[Int] = column[Int]("EntryNumber", O.Default(0))
    /** Database column Entry SqlType(VARCHAR), Length(480,true) */
    val entry: Rep[String] = column[String]("Entry", O.Length(480, varying = true))

    def pk = primaryKey("JRE_PK", (jrnPrjPrtProjowner, jrnPrjProjectcode, jrnDay, entrynumber))

    def * = (jrnDay, jrnPrjProjectcode, jrnPrjPrtProjowner, entrynumber, entry) <> (JournalentriesRow.tupled, JournalentriesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(jrnDay), Rep.Some(jrnPrjProjectcode), Rep.Some(jrnPrjPrtProjowner), Rep.Some(entrynumber), Rep.Some(entry)).shaped.<>({ r => import r._; _1.map(_ => JournalentriesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Journals
    *
    * @param day             Database column Day SqlType(DATE)
    * @param prjPrtProjowner Database column PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode  Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param usrEditor       Database column USR_Editor SqlType(VARCHAR), Length(36,true) */
  case class JournalsRow(day: Date, prjPrtProjowner: String, prjProjectcode: String, usrEditor: String)

  /** Table description of table Journals. Objects of this class serve as prototypes for rows in queries. */
  class Journals(_tableTag: Tag) extends profile.api.Table[JournalsRow](_tableTag, schemaName, "Journals") {
    /** Foreign key referencing Parties (database name JRN_PRT_FK) */
    lazy val partiesFk = foreignKey("JRN_PRT_FK", usrEditor, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projects (database name JRN_PRJ_FK) */
    lazy val projectsFk = foreignKey("JRN_PRJ_FK", (prjPrtProjowner, prjProjectcode), Projects)(r => (r.orgProjowner, r.prjProjectcode), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column Day SqlType(DATE) */
    val day: Rep[Date] = column[Date]("Day")
    /** Database column PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val prjPrtProjowner: Rep[String] = column[String]("PRJ_PRT_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[String] = column[String]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column USR_Editor SqlType(VARCHAR), Length(36,true) */
    val usrEditor: Rep[String] = column[String]("USR_Editor", O.Length(36, varying = true))

    /** Primary key of Journals (database name JRN_PK) */
    val pk = primaryKey("JRN_PK", (day, prjProjectcode, prjPrtProjowner))

    def * = (day, prjPrtProjowner, prjProjectcode, usrEditor) <> (JournalsRow.tupled, JournalsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(day), Rep.Some(prjPrtProjowner), Rep.Some(prjProjectcode), Rep.Some(usrEditor)).shaped.<>({ r => import r._; _1.map(_ => JournalsRow.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Parties
    *
    * @param prtGuid          Database column PRT_GUID SqlType(VARCHAR), Length(36,true)
    * @param prtVersionnumber Database column PRT_VersionNumber SqlType(INTEGER), Default(0)
    * @param name             Database column Name SqlType(VARCHAR), Length(40,true)
    * @param languagetag      Database column LanguageTag SqlType(VARCHAR), Length(10,true), Default(nl_NL)
    * @param nationality      Database column Nationality SqlType(CHAR), Length(2,false), Default(')
    * @param superparty       Database column superPARTY SqlType(VARCHAR), Length(36,true)
    * @param remarks          Database column Remarks SqlType(VARCHAR), Length(480,true)
    * @param tilldate         Database column TillDate SqlType(DATE)
    * @param imageurl         Database column ImageURL SqlType(VARCHAR), Length(160,true)
    * @param picture          Database column Picture SqlType(BLOB)
    * @param prtIssuer        Database column PRT_Issuer SqlType(VARCHAR), Length(36,true)
    * @param username         Database column Username SqlType(VARCHAR), Length(40,true)
    * @param nickname         Database column Nickname SqlType(VARCHAR), Length(40,true)
    * @param birthday         Database column Birthday SqlType(DATE)
    * @param gender           Database column Gender SqlType(CHAR)
    * @param jobfunction      Database column JobFunction SqlType(VARCHAR), Length(40,true)
    * @param citizenservicenr Database column CitizenServiceNr SqlType(INTEGER)
    * @param systemrole       Database column SystemRole SqlType(VARCHAR), Length(16,true)
    * @param coc              Database column CoC SqlType(VARCHAR), Length(8,true)
    * @param vatnumber        Database column VATNumber SqlType(VARCHAR), Length(14,true) */
  final case class PartiesRow(prtGuid: String, prtVersionnumber: Int = 0, name: String, languagetag: String = "nl_NL", nationality: String = "EU", superparty: Option[String], remarks: Option[String], tilldate: Option[Date], imageurl: Option[String], picture: Option[Blob], prtIssuer: Option[String], username: Option[String], nickname: Option[String], birthday: Option[Date], gender: Option[Char], jobfunction: Option[String], citizenservicenr: Option[Int], systemrole: Option[String], coc: Option[String], vatnumber: Option[String])

  /** GetResult implicit for fetching PartiesRow objects using plain SQL queries */
  implicit def GetResultPartiesRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Date]], e4: GR[Option[Blob]], e5: GR[Option[Char]], e6: GR[Option[Int]]): GR[PartiesRow] = GR {
    prs =>
      import prs._
      PartiesRow.tupled((<<[String], <<[Int], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[Date], <<?[String], <<?[Blob], <<?[String], <<?[String], <<?[String], <<?[Date], <<?[Char], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String]))
  }

  /** Table description of table Parties. Objects of this class serve as prototypes for rows in queries. */
  class Parties(_tableTag: Tag) extends profile.api.Table[PartiesRow](_tableTag, schemaName, "Parties") {
    /** Foreign key referencing Parties (database name PRT_PRT_FK) */
    lazy val partiesFk = foreignKey("PRT_PRT_FK", prtIssuer, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column PRT_GUID SqlType(VARCHAR), Length(36,true) */
    val prtGuid: Rep[String] = column[String]("GUID", O.Length(36, varying = true))
    /** Database column PRT_VersionNumber SqlType(INTEGER), Default(0) */
    val prtVersionnumber: Rep[Int] = column[Int]("PRT_VersionNumber", O.Default(0))
    /** Database column Name SqlType(VARCHAR), Length(40,true) */
    val name: Rep[String] = column[String]("Name", O.Length(40, varying = true))
    /** Database column LanguageTag SqlType(VARCHAR), Length(10,true), Default(nl_NL) */
    val languagetag: Rep[String] = column[String]("LanguageTag", O.Length(10, varying = true), O.Default("nl_NL"))
    /** Database column Nationality SqlType(CHAR), Length(2,false), Default(') */
    val nationality: Rep[String] = column[String]("Nationality", O.Length(2, varying = false), O.Default("EU"))
    /** Database column superPARTY SqlType(VARCHAR), Length(36,true) */
    val superparty: Rep[Option[String]] = column[Option[String]]("superPARTY", O.Length(36, varying = true))
    /** Database column Remarks SqlType(VARCHAR), Length(480,true) */
    val remarks: Rep[Option[String]] = column[Option[String]]("Remarks", O.Length(480, varying = true))
    /** Database column TillDate SqlType(DATE) */
    val tilldate: Rep[Option[Date]] = column[Option[Date]]("TillDate")
    /** Database column ImageURL SqlType(VARCHAR), Length(160,true) */
    val imageurl: Rep[Option[String]] = column[Option[String]]("ImageURL", O.Length(160, varying = true))
    /** Database column Picture SqlType(BLOB) */
    val picture: Rep[Option[Blob]] = column[Option[Blob]]("Picture")
    /** Database column PRT_Issuer SqlType(VARCHAR), Length(36,true) */
    val prtIssuer: Rep[Option[String]] = column[Option[String]]("PRT_Issuer", O.Length(36, varying = true))
    /** Database column Username SqlType(VARCHAR), Length(40,true) */
    val username: Rep[Option[String]] = column[Option[String]]("Username", O.Length(40, varying = true))
    /** Database column Nickname SqlType(VARCHAR), Length(40,true) */
    val nickname: Rep[Option[String]] = column[Option[String]]("Nickname", O.Length(40, varying = true))
    /** Database column Birthday SqlType(DATE) */
    val birthday: Rep[Option[Date]] = column[Option[Date]]("Birthday")
    /** Database column Gender SqlType(CHAR) */
    val gender: Rep[Option[Char]] = column[Option[Char]]("Gender")
    /** Database column JobFunction SqlType(VARCHAR), Length(40,true) */
    val jobfunction: Rep[Option[String]] = column[Option[String]]("JobFunction", O.Length(40, varying = true))
    /** Database column CitizenServiceNr SqlType(INTEGER) */
    val citizenservicenr: Rep[Option[Int]] = column[Option[Int]]("CitizenServiceNr")
    /** Database column SystemRole SqlType(VARCHAR), Length(16,true) */
    val systemrole: Rep[Option[String]] = column[Option[String]]("SystemRole", O.Length(16, varying = true))
    /** Database column CoC SqlType(VARCHAR), Length(8,true) */
    val coc: Rep[Option[String]] = column[Option[String]]("CoC", O.Length(8, varying = true))
    /** Database column VATNumber SqlType(VARCHAR), Length(14,true) */
    val vatnumber: Rep[Option[String]] = column[Option[String]]("VATNumber", O.Length(14, varying = true))
    /** Primary key of Parties (database name PRT_PK) */
    val pk = primaryKey("PRT_PK", (prtGuid, prtVersionnumber))
    /** Uniqueness Index over (prtGuid) (database name CTP_PRT_FK_INDEX_3) */
    val index1 = index("CTP_PRT_FK_INDEX_3", prtGuid, unique = true)
    /** Uniqueness Index over (username) (database name USR_Username_UN_INDEX) */
    val index2 = index("USR_Username_UN_INDEX", username, unique = true)

    def * = (prtGuid, prtVersionnumber, name, languagetag, nationality, superparty, remarks, tilldate, imageurl, picture, prtIssuer, username, nickname, birthday, gender, jobfunction, citizenservicenr, systemrole, coc, vatnumber) <> (PartiesRow.tupled, PartiesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(prtGuid), Rep.Some(prtVersionnumber), Rep.Some(name), Rep.Some(languagetag), Rep.Some(nationality), superparty, remarks, tilldate, imageurl, picture, prtIssuer, username, nickname, birthday, gender, jobfunction, citizenservicenr, systemrole, coc, vatnumber).shaped.<>({ r => import r._; _1.map(_ => PartiesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }


  /** Entity class storing rows of table Payments
    *
    * @param conPrtGuid        Database column CON_PRT_GUID SqlType(VARCHAR), Length(36,true)
    * @param conExpirationdate Database column CON_ExpirationDate SqlType(DATE)
    * @param amount            Database column Amount SqlType(DECIMAL)
    * @param date              Database column Date SqlType(DATE) */
  /*final*/ case class PaymentsRow(conPrtGuid: String, conExpirationdate: Date, amount: BigDecimal, date: Date)

  /** Table description of table Payments. Objects of this class serve as prototypes for rows in queries. */
  class Payments(_tableTag: Tag) extends profile.api.Table[PaymentsRow](_tableTag, schemaName, "Payments") {
    /** Foreign key referencing Contracts (database name PAY_CON_FK) */
    lazy val contractsFk = foreignKey("PAY_CON_FK", (conPrtGuid, conExpirationdate), Contracts)(r => (r.prtContractingparty, r.expirationdate), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column CON_PRT_GUID SqlType(VARCHAR), Length(36,true) */
    val conPrtGuid: Rep[String] = column[String]("CON_PRT_GUID", O.Length(36, varying = true))
    /** Database column CON_ExpirationDate SqlType(DATE) */
    val conExpirationdate: Rep[Date] = column[Date]("CON_ExpirationDate")
    /** Database column Amount SqlType(DECIMAL) */
    val amount: Rep[BigDecimal] = column[BigDecimal]("Amount")
    /** Database column Date SqlType(DATE) */
    val date: Rep[Date] = column[Date]("Date")
    /** Primary key of Payments (database name PAY_PK) */
    val pk = primaryKey("PAY_PK", (conPrtGuid, conExpirationdate))

    def * = (conPrtGuid, conExpirationdate, amount, date) <> (PaymentsRow.tupled, PaymentsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(conPrtGuid), Rep.Some(conExpirationdate), Rep.Some(amount), Rep.Some(date)).shaped.<>({ r => import r._; _1.map(_ => PaymentsRow.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table PmpAct42
    *
    * @param actActivity       Database column ACT_Activity SqlType(VARCHAR), Length(24,true)
    * @param pmpUsrPersonguid  Database column PMP_USR_PersonGUID SqlType(VARCHAR), Length(36,true)
    * @param pmpPrjProjectcode Database column PMP_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param pmpPrjProjowner   Database column PMP_PRJ_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param pmpStartdate      Database column PMP_StartDate SqlType(DATE) */
  /*final*/ case class PmpAct42Row(actActivity: String, pmpUsrPersonguid: String, pmpPrjProjectcode: String, pmpPrjProjowner: String, pmpStartdate: Timestamp)

  /** GetResult implicit for fetching SuppliesRow objects using plain SQL queries */
  implicit def GetResultSuppliesRow(implicit e0: GR[String], e1: GR[Option[BigDecimal]]): GR[SuppliesRow] = GR {
    prs =>
      import prs._
      SuppliesRow.tupled((<<[String], <<[String], <<?[BigDecimal]))
  }

  /** Table description of table PMP_Act_42. Objects of this class serve as prototypes for rows in queries. */
  class PmpAct42(_tableTag: Tag) extends profile.api.Table[PmpAct42Row](_tableTag, schemaName, "Pmp_Act_42") {
    /** Foreign key referencing Activityskills (database name PMP_ACT_42_ACT_FK) */
    lazy val activityskillsFk = foreignKey("PXA_42_ACT_FK", actActivity, Activityskills)(r => r.activity, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projectmemberprofiles (database name PMP_ACT_42_PMP_FK) */
    lazy val projectmemberprofilesFk = foreignKey("PXA_ACT_42_PMP_FK", (pmpPrjProjowner, pmpPrjProjectcode, pmpUsrPersonguid, pmpStartdate), Projectmemberprofiles)(r => (r.orgProjowner, r.prjProjectcode, r.usrWorker, r.startdate), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ACT_Activity SqlType(VARCHAR), Length(24,true) */
    val actActivity: Rep[String] = column[String]("ACT_Activity", O.Length(24, varying = true))
    /** Database column PMP_USR_PersonGUID SqlType(VARCHAR), Length(36,true) */
    val pmpUsrPersonguid: Rep[String] = column[String]("PMP_USR_PersonGUID", O.Length(36, varying = true))
    /** Database column PMP_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val pmpPrjProjectcode: Rep[String] = column[String]("PMP_PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column PMP_PRJ_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val pmpPrjProjowner: Rep[String] = column[String]("PMP_PRJ_ProjOwner", O.Length(36, varying = true))
    /** Database column PMP_StartDate SqlType(DATE) */
    val pmpStartdate: Rep[Timestamp] = column[Timestamp]("PMP_StartDate")

    /** Primary key of PmpAct42 (database name PMP_ACT_42_PK) */
    val pk = primaryKey("PXA_ACT_42_PK", (actActivity, pmpUsrPersonguid, pmpPrjProjectcode, pmpPrjProjowner, pmpStartdate))

    def * = (actActivity, pmpUsrPersonguid, pmpPrjProjectcode, pmpPrjProjowner, pmpStartdate) <> (PmpAct42Row.tupled, PmpAct42Row.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(actActivity), Rep.Some(pmpUsrPersonguid), Rep.Some(pmpPrjProjectcode), Rep.Some(pmpPrjProjowner), Rep.Some(pmpStartdate)).shaped.
      <>({ r => import r._; _1.map(_ => PmpAct42Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) },
        (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Priceplans
    *
    * @param priceplancode        Database column PricePlanCode SqlType(VARCHAR), Length(10,true)
    * @param startdate            Database column StartDate SqlType(DATE)
    * @param priceplandescription Database column PricePlanDescription SqlType(VARCHAR), Length(240,true)
    * @param expirationdate       Database column ExpirationDate SqlType(DATE)
    * @param membershipfee        Database column MembershipFee SqlType(DECIMAL)
    * @param discount             Database column Discount SqlType(DECIMAL)
    * @param graceperiod          Database column GracePeriod SqlType(DECIMAL) */
  /*final*/ case class PriceplansRow(priceplancode: String, startdate: Date, priceplandescription: Option[String], expirationdate: Option[Date], membershipfee: BigDecimal, discount: Option[BigDecimal], graceperiod: Option[BigDecimal])

  /** Table description of table PricePlans. Objects of this class serve as prototypes for rows in queries. */
  class Priceplans(_tableTag: Tag) extends profile.api.Table[PriceplansRow](_tableTag, schemaName, "PricePlans") {
    /** Database column PricePlanCode SqlType(VARCHAR), Length(10,true) */
    val priceplancode: Rep[String] = column[String]("PricePlanCode", O.Length(10, varying = true))
    /** Database column StartDate SqlType(DATE) */
    val startdate: Rep[Date] = column[Date]("StartDate")
    /** Database column PricePlanDescription SqlType(VARCHAR), Length(240,true) */
    val priceplandescription: Rep[Option[String]] = column[Option[String]]("PricePlanDescription", O.Length(240, varying = true))
    /** Database column ExpirationDate SqlType(DATE) */
    val expirationdate: Rep[Option[Date]] = column[Option[Date]]("ExpirationDate")
    /** Database column MembershipFee SqlType(DECIMAL) */
    val membershipfee: Rep[BigDecimal] = column[BigDecimal]("MembershipFee")
    /** Database column Discount SqlType(DECIMAL) */
    val discount: Rep[Option[BigDecimal]] = column[Option[BigDecimal]]("Discount")
    /** Database column GracePeriod SqlType(DECIMAL) */
    val graceperiod: Rep[Option[BigDecimal]] = column[Option[BigDecimal]]("GracePeriod")
    /** Primary key of Priceplans (database name PRP_PK) */
    val pk = primaryKey("PRP_PK", (priceplancode, startdate))

    def * = (priceplancode, startdate, priceplandescription, expirationdate, membershipfee, discount, graceperiod) <> (PriceplansRow.tupled, PriceplansRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(priceplancode), Rep.Some(startdate), priceplandescription, expirationdate, Rep.Some(membershipfee), discount, graceperiod).shaped.
      <>({ r => import r._; _1.map(_ => PriceplansRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6, _7))) },
        (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** GetResult implicit for fetching TagPrt62Row objects using plain SQL queries */
  implicit def GetResultTagPrt62Row(implicit e0: GR[String]): GR[TagPrt62Row] = GR {
    prs =>
      import prs._
      TagPrt62Row.tupled((<<[String], <<[String]))
  }

  /** Entity class storing rows of table Projectmemberprofiles
    *
    * @param orgProjowner   Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param usrWorker      Database column USR_Worker SqlType(VARCHAR), Length(36,true)
    * @param startdate      Database column StartDate SqlType(TIMESTAMP)
    * @param enddate        Database column EndDate SqlType(DATE)
    * @param activities     Database column Activities SqlType(VARCHAR), Length(24,true) */
  final case class ProjectmemberprofilesRow(orgProjowner: String, prjProjectcode: String, usrWorker: String, startdate: Timestamp, enddate: Option[Date], activities: Option[String])

  /** GetResult implicit for fetching ProjectmemberprofilesRow objects using plain SQL queries */
  implicit def GetResultProjectmemberprofilesRow(implicit e0: GR[String], e1: GR[Timestamp], e2: GR[Option[Date]], e3: GR[Option[String]]): GR[ProjectmemberprofilesRow] = GR {
    prs =>
      import prs._
      ProjectmemberprofilesRow.tupled((<<[String], <<[String], <<[String], <<[Timestamp], <<?[Date], <<?[String]))
  }

  /** Table description of table ProjectMemberProfiles. Objects of this class serve as prototypes for rows in queries. */
  class Projectmemberprofiles(_tableTag: Tag) extends profile.api.Table[ProjectmemberprofilesRow](_tableTag, schemaName, "ProjectMemberProfiles") {
    /** Foreign key referencing Parties (database name PMP_PRT_FK) */
    lazy val partiesFk = foreignKey("PMP_PRT_FK", usrWorker, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projects (database name PMP_PRJ_FK) */
    lazy val projectsFk = foreignKey("PMP_PRJ_FK", (orgProjowner, prjProjectcode), Projects)(r => (r.orgProjowner, r.prjProjectcode), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val orgProjowner: Rep[String] = column[String]("ORG_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[String] = column[String]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column USR_Worker SqlType(VARCHAR), Length(36,true) */
    val usrWorker: Rep[String] = column[String]("USR_Worker", O.Length(36, varying = true))
    /** Database column StartDate SqlType(TIMESTAMP) */
    val startdate: Rep[Timestamp] = column[Timestamp]("StartDate")
    /** Database column EndDate SqlType(DATE) */
    val enddate: Rep[Option[Date]] = column[Option[Date]]("EndDate")
    /** Database column Activities SqlType(VARCHAR), Length(24,true) */
    val activities: Rep[Option[String]] = column[Option[String]]("Activities", O.Length(24, varying = true))

    /** Primary key of Projectmemberprofiles (database name PMP_PK) */
    val pk = primaryKey("PMP_PK", (orgProjowner, prjProjectcode, usrWorker, startdate))

    def * = (orgProjowner, prjProjectcode, usrWorker, startdate, enddate, activities) <> (ProjectmemberprofilesRow.tupled, ProjectmemberprofilesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(orgProjowner), Rep.Some(prjProjectcode), Rep.Some(usrWorker), Rep.Some(startdate), enddate, activities).shaped.<>({ r => import r._; _1.map(_ => ProjectmemberprofilesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Projects
    *
    * @param orgProjowner         Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode       Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param projectname          Database column ProjectName SqlType(VARCHAR), Length(40,true)
    * @param startdate            Database column StartDate SqlType(DATE)
    * @param enddate              Database column EndDate SqlType(DATE)
    * @param prjOrgSuperprojowner Database column PRJ_ORG_SuperProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjSuperprojectcode  Database column PRJ_SuperProjectCode SqlType(VARCHAR), Length(10,true)
    * @param prjOrgAccprojowner   Database column PRJ_Org_AccProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjAccprojcode       Database column PRJ_AccProjCode SqlType(VARCHAR), Length(10,true)
    * @param description          Database column Description SqlType(VARCHAR), Length(480,true) */
  final case class ProjectsRow(orgProjowner: String, prjProjectcode: String, projectname: String, startdate: Date, enddate: Option[Date], prjOrgSuperprojowner: Option[String], prjSuperprojectcode: Option[String], prjOrgAccprojowner: Option[String], prjAccprojcode: Option[String], description: Option[String])

  /** GetResult implicit for fetching ProjectsRow objects using plain SQL queries */
  implicit def GetResultProjectsRow(implicit e0: GR[String], e1: GR[Date], e2: GR[Option[Date]], e3: GR[Option[String]]): GR[ProjectsRow] = GR {
    prs =>
      import prs._
      ProjectsRow.tupled((<<[String], <<[String], <<[String], <<[Date], <<?[Date], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }

  /** Table description of table Projects. Objects of this class serve as prototypes for rows in queries. */
  class Projects(_tableTag: Tag) extends profile.api.Table[ProjectsRow](_tableTag, schemaName, "Projects") {
    /** Foreign key referencing Parties (database name PRJ_ORG_FK1) */
    lazy val partiesFk = foreignKey("PRJ_ORG_FK1", orgProjowner, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projects (database name PRJ_PRJ_FK2) */
    lazy val projectsFk2 = foreignKey("PRJ_PRJ_FK2", (prjOrgSuperprojowner, prjSuperprojectcode), Projects)(r => (Rep.Some(r.orgProjowner), Rep.Some(r.prjProjectcode)), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Projects (database name PRJ_PRJ_FK3) */
    lazy val projectsFk3 = foreignKey("PRJ_PRJ_FK3", (prjOrgAccprojowner, prjAccprojcode), Projects)(r => (Rep.Some(r.orgProjowner), Rep.Some(r.prjProjectcode)), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val orgProjowner: Rep[String] = column[String]("ORG_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[String] = column[String]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column ProjectName SqlType(VARCHAR), Length(40,true) */
    val projectname: Rep[String] = column[String]("ProjectName", O.Length(40, varying = true))
    /** Database column StartDate SqlType(DATE) */
    val startdate: Rep[Date] = column[Date]("StartDate")
    /** Database column EndDate SqlType(DATE) */
    val enddate: Rep[Option[Date]] = column[Option[Date]]("EndDate")
    /** Database column PRJ_ORG_SuperProjOwner SqlType(VARCHAR), Length(36,true) */
    val prjOrgSuperprojowner: Rep[Option[String]] = column[Option[String]]("PRJ_ORG_SuperProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_SuperProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjSuperprojectcode: Rep[Option[String]] = column[Option[String]]("PRJ_SuperProjectCode", O.Length(10, varying = true))
    /** Database column PRJ_Org_AccProjOwner SqlType(VARCHAR), Length(36,true) */
    val prjOrgAccprojowner: Rep[Option[String]] = column[Option[String]]("PRJ_Org_AccProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_AccProjCode SqlType(VARCHAR), Length(10,true) */
    val prjAccprojcode: Rep[Option[String]] = column[Option[String]]("PRJ_AccProjCode", O.Length(10, varying = true))
    /** Database column Description SqlType(VARCHAR), Length(480,true) */
    val description: Rep[Option[String]] = column[Option[String]]("Description", O.Length(480, varying = true))
    /** Primary key of Projects (database name PRJ_PK) */
    val pk = primaryKey("PRJ_PK", (orgProjowner, prjProjectcode))

    def * = (orgProjowner, prjProjectcode, projectname, startdate, enddate, prjOrgSuperprojowner, prjSuperprojectcode, prjOrgAccprojowner, prjAccprojcode, description) <> (ProjectsRow.tupled, ProjectsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(orgProjowner), Rep.Some(prjProjectcode), Rep.Some(projectname), Rep.Some(startdate), enddate, prjOrgSuperprojowner, prjSuperprojectcode, prjOrgAccprojowner, prjAccprojcode, description).shaped.<>({ r => import r._; _1.map(_ => ProjectsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Supplies
    *
    * @param supplyguid Database column SupplyGUID SqlType(VARCHAR), Length(36,true)
    * @param orgOwner   Database column ORG_Owner SqlType(VARCHAR), Length(36,true)
    * @param grossmass  Database column GrossMass SqlType(DECIMAL) */
  /*final*/ case class SuppliesRow(supplyguid: String, orgOwner: String, grossmass: Option[BigDecimal])

  /** Table description of table Supplies. Objects of this class serve as prototypes for rows in queries. */
  class Supplies(_tableTag: Tag) extends profile.api.Table[SuppliesRow](_tableTag, schemaName, "Supplies") {
    /** Foreign key referencing Parties (database name SUP_PRT_FK) */
    lazy val partiesFk = foreignKey("SUP_PRT_FK", orgOwner, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column SupplyGUID SqlType(VARCHAR), Length(36,true) */
    val supplyguid: Rep[String] = column[String]("SupplyGUID", O.Length(36, varying = true))
    /** Database column ORG_Owner SqlType(VARCHAR), Length(36,true) */
    val orgOwner: Rep[String] = column[String]("ORG_Owner", O.Length(36, varying = true))
    /** Database column GrossMass SqlType(DECIMAL) */
    val grossmass: Rep[Option[BigDecimal]] = column[Option[BigDecimal]]("GrossMass")
    /** Primary key of Supplies (database name SUP_PK) */
    val pk = primaryKey("SUP_PK", (supplyguid, orgOwner))

    def * = (supplyguid, orgOwner, grossmass) <> (SuppliesRow.tupled, SuppliesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(supplyguid), Rep.Some(orgOwner), grossmass).shaped.<>({ r => import r._; _1.map(_ => SuppliesRow.tupled((_1.get, _2.get, _3))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** GetResult implicit for fetching TeamsRow objects using plain SQL queries */
  implicit def GetResultTeamsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[TeamsRow] = GR {
    prs =>
      import prs._
      TeamsRow.tupled((<<[String], <<?[String]))
  }

  /** Entity class storing rows of table TagPrt62
    *
    * @param prtGuid    Database column PRT_GUID SqlType(VARCHAR), Length(36,true)
    * @param tagTagname Database column TAG_TagName SqlType(VARCHAR), Length(24,true) */
  /*final*/ case class TagPrt62Row(prtGuid: String, tagTagname: String)

  /** Table description of table Tag_Prt_62. Objects of this class serve as prototypes for rows in queries. */
  class TagPrt62(_tableTag: Tag) extends profile.api.Table[TagPrt62Row](_tableTag, schemaName, "Tag_Prt_62") {
    /** Foreign key referencing Parties (database name TAG_PRT_50_PRT_FK) */
    lazy val partiesFk = foreignKey("TgP_Prt_62_PRT_FK", prtGuid, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Tags (database name TAG_PRT_50_TAG_FK) */
    lazy val tagsFk = foreignKey("TgP_PRT_50_TAG_FK", tagTagname, Tags)(r => r.tagname, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column PRT_GUID SqlType(VARCHAR), Length(36,true) */
    val prtGuid: Rep[String] = column[String]("PRT_GUID", O.Length(36, varying = true))
    /** Database column TAG_TagName SqlType(VARCHAR), Length(24,true) */
    val tagTagname: Rep[String] = column[String]("TAG_TagName", O.Length(24, varying = true))

    /** Primary key of TagPrt62 (database name TAG_PRT_50_PK) */
    val pk = primaryKey("TgP_PRT_62_PK", (prtGuid, tagTagname))

    def * = (prtGuid, tagTagname) <> (TagPrt62Row.tupled, TagPrt62Row.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(prtGuid), Rep.Some(tagTagname)).shaped.<>({ r => import r._; _1.map(_ => TagPrt62Row.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Tags
    *
    * @param tagname Database column TagName SqlType(VARCHAR), PrimaryKey, Length(10,true) */
  /*final*/ case class TagsRow(tagname: String)

  /** Table description of table Tags. Objects of this class serve as prototypes for rows in queries. */
  class Tags(_tableTag: Tag) extends profile.api.Table[TagsRow](_tableTag, schemaName, "Tags") {
    /** Database column TagName SqlType(VARCHAR), PrimaryKey, Length(24,true) */
    val tagname: Rep[String] = column[String]("TagName", O.Length(24, varying = true))

    def pk = primaryKey("TAG_PK", tagname)

    def * = tagname <> (TagsRow, TagsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(tagname).shaped.<>(r => r.map(_ => TagsRow(r.get)), (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Teams
    *
    * @param teamuuid Database column TeamUUID SqlType(VARCHAR), PrimaryKey, Length(36,true)
    * @param name     Database column Name SqlType(VARCHAR), Length(40,true) */
  /*final*/ case class TeamsRow(teamuuid: String, name: Option[String])

  /** Table description of table Teams. Objects of this class serve as prototypes for rows in queries. */
  class Teams(_tableTag: Tag) extends profile.api.Table[TeamsRow](_tableTag, schemaName, "Teams") {
    /** Database column TeamUUID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val teamuuid: Rep[String] = column[String]("TeamUUID", O.Length(36, varying = true))
    /** Database column Name SqlType(VARCHAR), Length(40,true) */
    val name: Rep[Option[String]] = column[Option[String]]("Name", O.Length(40, varying = true))

    def pk = primaryKey("TEA_PK", teamuuid)

    def * = (teamuuid, name) <> (TeamsRow.tupled, TeamsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(teamuuid), name).shaped.<>({ r => import r._; _1.map(_ => TeamsRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Peripherals
    *
    * @param orgProjowner     Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode   Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param terGuid          Database column TER_GUID SqlType(VARCHAR), Length(36,true)
    * @param location         Database column Location SqlType(VARCHAR), Length(240,true)
    * @param coordinate       Database column Coordinate SqlType(VARCHAR), Length(240,true)
    * @param offlineSinceTime Database column Offline_Since_Time SqlType(TIMESTAMP)
    * @param onlineSinceTime  Database column Online_Since_Time SqlType(TIMESTAMP)
    * @param status           Database column Status SqlType(VARCHAR), Length(10,true)
    * @param billboardHtml    Database column billboard_Html SqlType(VARCHAR), Length(480,true) */
  final case class PeripheralsRow(orgProjowner: String, prjProjectcode: String, terGuid: String, location: Option[String], coordinate: Option[String], offlineSinceTime: Timestamp = new Timestamp(currentTime), onlineSinceTime: Option[Timestamp], status: Option[String], billboardHtml: Option[String])

  /** GetResult implicit for fetching PeripheralsRow objects using plain SQL queries */
  implicit def GetResultPeripheralsRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Timestamp], e3: GR[Option[Timestamp]]): GR[PeripheralsRow] = GR {
    prs =>
      import prs._
      PeripheralsRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<?[String], <<[Timestamp], <<?[Timestamp], <<?[String], <<?[String]))
  }

  /** Table description of table Peripherals. Objects of this class serve as prototypes for rows in queries. */
  class Peripherals(_tableTag: Tag) extends profile.api.Table[PeripheralsRow](_tableTag, schemaName, "Peripherals") {
    /** Foreign key referencing Projects (database name TER_PRJ_FK) */
    lazy val projectsFk = foreignKey("TER_PRJ_FK", (orgProjowner, prjProjectcode), Projects)(r => (r.orgProjowner, r.prjProjectcode), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column ORG_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val orgProjowner: Rep[String] = column[String]("ORG_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[String] = column[String]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column TER_GUID SqlType(VARCHAR), Length(36,true) */
    val terGuid: Rep[String] = column[String]("TER_GUID", O.Length(36, varying = true))
    /** Database column Location SqlType(VARCHAR), Length(240,true) */
    val location: Rep[Option[String]] = column[Option[String]]("Location", O.Length(240, varying = true))
    /** Database column Coordinate SqlType(VARCHAR), Length(240,true) */
    val coordinate: Rep[Option[String]] = column[Option[String]]("Coordinate", O.Length(240, varying = true))
    /** Database column Offline_Since_Time SqlType(TIMESTAMP) */
    val offlineSinceTime: Rep[Timestamp] = column[Timestamp]("Offline_Since_Time", SqlType("TIMESTAMP default CURRENT_TIMESTAMP"))
    /** Database column Online_Since_Time SqlType(TIMESTAMP) */
    val onlineSinceTime: Rep[Option[Timestamp]] = column[Option[Timestamp]]("Online_Since_Time")
    /** Database column Status SqlType(VARCHAR), Length(10,true) */
    val status: Rep[Option[String]] = column[Option[String]]("Status", O.Length(10, varying = true))
    /** Database column billboard_Html SqlType(VARCHAR), Length(480,true) */
    val billboardHtml: Rep[Option[String]] = column[Option[String]]("billboard_Html", O.Length(480, varying = true))
    /** Primary key of Peripherals (database name TER_PK) */
    val pk = primaryKey("TER_PK", (orgProjowner, prjProjectcode, terGuid))

    def * = (orgProjowner, prjProjectcode, terGuid, location, coordinate, offlineSinceTime, onlineSinceTime, status, billboardHtml) <> (PeripheralsRow.tupled, PeripheralsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(orgProjowner), Rep.Some(prjProjectcode), Rep.Some(terGuid), location, coordinate, Rep.Some(offlineSinceTime), onlineSinceTime, status, billboardHtml).shaped.<>({ r => import r._; _1.map(_ => PeripheralsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7, _8, _9))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Timeregistrations
    *
    * @param prjOrgProjowner   Database column PRJ_ORG_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param prjProjectcode    Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param terGuidIn         Database column TER_GUID_IN SqlType(VARCHAR), Length(36,true)
    * @param checkindatetime   Database column CheckInDateTime SqlType(TIMESTAMP)
    * @param docDocumenttype   Database column DOC_DocumentType SqlType(VARCHAR), Length(16,true)
    * @param docExpirationdate Database column DOC_ExpirationDate SqlType(DATE)
    * @param docDocid          Database column DOC_DocID SqlType(VARCHAR), Length(240,true)
    * @param docOwnerUsrWorker Database column DOC_OWNER_USR_WORKER SqlType(VARCHAR), Length(36,true)
    * @param terGuidOut        Database column TER_GUID_OUT SqlType(VARCHAR), Length(36,true)
    * @param checkoutdatetime  Database column CheckOutDateTime SqlType(TIMESTAMP)
    * @param actActivity       Database column ACT_Activity SqlType(VARCHAR), Length(24,true) */
  final case class TimeregistrationsRow(prjOrgProjowner: String, prjProjectcode: String, terGuidIn: String, checkindatetime: Timestamp, docDocumenttype: String, docExpirationdate: Date, docDocid: String, docOwnerUsrWorker: String, terGuidOut: Option[String], checkoutdatetime: Option[Timestamp], actActivity: Option[String])

  /** GetResult implicit for fetching TimeregistrationsRow objects using plain SQL queries */
  implicit def GetResultTimeregistrationsRow(implicit e0: GR[String], e1: GR[Timestamp], e2: GR[Date], e3: GR[Option[String]], e4: GR[Option[Timestamp]]): GR[TimeregistrationsRow] = GR {
    prs =>
      import prs._
      TimeregistrationsRow.tupled((<<[String], <<[String], <<[String], <<[Timestamp], <<[String], <<[Date], <<[String], <<[String], <<?[String], <<?[Timestamp], <<?[String]))
  }

  /** Table description of table TimeRegistrations. Objects of this class serve as prototypes for rows in queries. */
  class Timeregistrations(_tableTag: Tag) extends profile.api.Table[TimeregistrationsRow](_tableTag, schemaName, "TimeRegistrations") {
    /** Foreign key referencing Activityskills (database name TMR_ACT_FK) */
    lazy val activityskillsFk = foreignKey("TMR_ACT_FK", actActivity, Activityskills)(r => Rep.Some(r.activity), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Documents (database name TMR_DOC_FK) */
    lazy val documentsFk = foreignKey("TMR_DOC_FK", (docDocumenttype, docExpirationdate, docDocid, docOwnerUsrWorker), Documents)(r => (r.dctDocumenttype, r.expirationdate, r.docid, r.prtOwner), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Peripherals (database name TMR_TER_FK) */
    lazy val peripheralsFk3 = foreignKey("TMR_TER_FK", (prjOrgProjowner, prjProjectcode, terGuidIn), Peripherals)(r => (r.orgProjowner, r.prjProjectcode, r.terGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Peripherals (database name TMR_TER_FKv2) */
    lazy val peripheralsFk4 = foreignKey("TMR_TER_FKv2", (prjOrgProjowner, prjProjectcode, terGuidOut), Peripherals)(r => (r.orgProjowner, r.prjProjectcode, Rep.Some(r.terGuid)), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column PRJ_ORG_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val prjOrgProjowner: Rep[String] = column[String]("PRJ_ORG_ProjOwner", O.Length(36, varying = true))
    /** Database column PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val prjProjectcode: Rep[String] = column[String]("PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column TER_GUID_IN SqlType(VARCHAR), Length(36,true) */
    val terGuidIn: Rep[String] = column[String]("TER_GUID_IN", O.Length(36, varying = true))
    /** Database column CheckInDateTime SqlType(TIMESTAMP) */
    val checkindatetime: Rep[Timestamp] = column[Timestamp]("CheckInDateTime")
    /** Database column DOC_DocumentType SqlType(VARCHAR), Length(16,true) */
    val docDocumenttype: Rep[String] = column[String]("DOC_DocumentType", O.Length(16, varying = true))
    /** Database column DOC_ExpirationDate SqlType(DATE) */
    val docExpirationdate: Rep[Date] = column[Date]("DOC_ExpirationDate")
    /** Database column DOC_DocID SqlType(VARCHAR), Length(240,true) */
    val docDocid: Rep[String] = column[String]("DOC_DocID", O.Length(240, varying = true))
    /** Database column DOC_OWNER_USR_WORKER SqlType(VARCHAR), Length(36,true) */
    val docOwnerUsrWorker: Rep[String] = column[String]("DOC_OWNER_USR_WORKER", O.Length(36, varying = true))
    /** Database column TER_GUID_OUT SqlType(VARCHAR), Length(36,true) */
    val terGuidOut: Rep[Option[String]] = column[Option[String]]("TER_GUID_OUT", O.Length(36, varying = true))
    /** Database column CheckOutDateTime SqlType(TIMESTAMP) */
    val checkoutdatetime: Rep[Option[Timestamp]] = column[Option[Timestamp]]("CheckOutDateTime")
    /** Database column ACT_Activity SqlType(VARCHAR), Length(24,true) */
    val actActivity: Rep[Option[String]] = column[Option[String]]("ACT_Activity", O.Length(24, varying = true))
    /** Primary key of Timeregistrations (database name TMR_PK) */
    val pk = primaryKey("TMR_PK", (prjOrgProjowner, prjProjectcode, docOwnerUsrWorker, terGuidIn, checkindatetime))

    def * = (prjOrgProjowner, prjProjectcode, terGuidIn, checkindatetime, docDocumenttype, docExpirationdate, docDocid, docOwnerUsrWorker, terGuidOut, checkoutdatetime, actActivity) <> (TimeregistrationsRow.tupled, TimeregistrationsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(prjOrgProjowner), Rep.Some(prjProjectcode), Rep.Some(terGuidIn), Rep.Some(checkindatetime), Rep.Some(docDocumenttype), Rep.Some(docExpirationdate), Rep.Some(docDocid), Rep.Some(docOwnerUsrWorker), terGuidOut, checkoutdatetime, actActivity).shaped.<>({ r => import r._; _1.map(_ => TimeregistrationsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10, _11))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }


  /** Entity class storing rows of table Workerkits
    *
    * @param usrLender        Database column USR_Lender SqlType(VARCHAR), Length(36,true)
    * @param supSupplyguid    Database column SUP_SupplyGUID SqlType(VARCHAR), Length(36,true)
    * @param supOrgOwner      Database column SUP_ORG_Owner SqlType(VARCHAR), Length(36,true)
    * @param lendingdatetime  Database column LendingDateTime SqlType(TIMESTAMP)
    * @param returndatetime   Database column ReturnDateTime SqlType(TIMESTAMP)
    * @param outoforderremark Database column OutOfOrderRemark SqlType(VARCHAR), Length(480,true) */
  /*final*/ case class WorkerkitsRow(usrLender: String, supSupplyguid: String, supOrgOwner: String, lendingdatetime: Timestamp, returndatetime: Option[Timestamp], outoforderremark: Option[String])

  /** Table description of table WorkerKits. Objects of this class serve as prototypes for rows in queries. */
  class Workerkits(_tableTag: Tag) extends profile.api.Table[WorkerkitsRow](_tableTag, schemaName, "WorkerKits") {
    /** Foreign key referencing Parties (database name KIT_PRT_FK) */
    lazy val partiesFk = foreignKey("KIT_PRT_FK", usrLender, Parties)(r => r.prtGuid, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Supplies (database name KIT_SUP_FK) */
    lazy val suppliesFk = foreignKey("KIT_SUP_FK", (supSupplyguid, supOrgOwner), Supplies)(r => (r.supplyguid, r.orgOwner), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column USR_Lender SqlType(VARCHAR), Length(36,true) */
    val usrLender: Rep[String] = column[String]("USR_Lender", O.Length(36, varying = true))
    /** Database column SUP_SupplyGUID SqlType(VARCHAR), Length(36,true) */
    val supSupplyguid: Rep[String] = column[String]("SUP_SupplyGUID", O.Length(36, varying = true))
    /** Database column SUP_ORG_Owner SqlType(VARCHAR), Length(36,true) */
    val supOrgOwner: Rep[String] = column[String]("SUP_ORG_Owner", O.Length(36, varying = true))
    /** Database column LendingDateTime SqlType(TIMESTAMP) */
    val lendingdatetime: Rep[Timestamp] = column[Timestamp]("LendingDateTime")
    /** Database column ReturnDateTime SqlType(TIMESTAMP) */
    val returndatetime: Rep[Option[Timestamp]] = column[Option[Timestamp]]("ReturnDateTime")
    /** Database column OutOfOrderRemark SqlType(VARCHAR), Length(480,true) */
    val outoforderremark: Rep[Option[String]] = column[Option[String]]("OutOfOrderRemark", O.Length(480, varying = true))

    /** Primary key of Workerkits (database name KIT_PK) */
    val pk = primaryKey("KIT_PK", (lendingdatetime, supSupplyguid, usrLender))

    def * = (usrLender, supSupplyguid, supOrgOwner, lendingdatetime, returndatetime, outoforderremark) <> (WorkerkitsRow.tupled, WorkerkitsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(usrLender), Rep.Some(supSupplyguid), Rep.Some(supOrgOwner), Rep.Some(lendingdatetime), returndatetime, outoforderremark).shaped.<>({ r => import r._; _1.map(_ => WorkerkitsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }

  /** Entity class storing rows of table Workingtimes
    *
    * @param tmrPmpPrtGuid         Database column TMR_PMP_PRT_GUID SqlType(VARCHAR), Length(36,true)
    * @param tmrPmpPrjProjectcode  Database column TMR_PMP_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true)
    * @param tmrPmpStartdate       Database column TMR_PMP_StartDate SqlType(TIMESTAMP)
    * @param tmrPmpPrjPrtProjowner Database column TMR_PMP_PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true)
    * @param tmrTerTerminalguid    Database column TMR_TER_TerminalGUID SqlType(VARCHAR), Length(36,true)
    * @param tmrCheckindatetime    Database column TMR_CheckInDateTime SqlType(TIMESTAMP)
    * @param hourstype             Database column HoursType SqlType(VARCHAR), Length(16,true)
    * @param createdatetime        Database column CreateDateTime SqlType(TIMESTAMP)
    * @param hours                 Database column Hours SqlType(DECIMAL)
    * @param usrCorrector          Database column USR_Corrector SqlType(VARCHAR), Length(36,true)
    * @param usrApprover           Database column USR_Approver SqlType(VARCHAR), Length(36,true)
    * @param approvaldate          Database column ApprovalDate SqlType(TIMESTAMP)
    * @param remark                Database column Remark SqlType(VARCHAR), Length(240,true) */
  final case class WorkingtimesRow(tmrPmpPrtGuid: String, tmrPmpPrjProjectcode: String, tmrPmpStartdate: Timestamp, tmrPmpPrjPrtProjowner: String, tmrTerTerminalguid: String, tmrCheckindatetime: Timestamp, hourstype: String, createdatetime: Timestamp, hours: BigDecimal, usrCorrector: Option[String], usrApprover: Option[String], approvaldate: Option[Timestamp], remark: Option[String])

  /** GetResult implicit for fetching WorkingtimesRow objects using plain SQL queries */
  implicit def GetResultWorkingtimesRow(implicit e0: GR[String], e1: GR[Timestamp], e2: GR[BigDecimal], e3: GR[Option[String]], e4: GR[Option[Timestamp]]): GR[WorkingtimesRow] = GR {
    prs =>
      import prs._
      WorkingtimesRow.tupled((<<[String], <<[String], <<[Timestamp], <<[String], <<[String], <<[Timestamp], <<[String], <<[Timestamp], <<[BigDecimal], <<?[String], <<?[String], <<?[Timestamp], <<?[String]))
  }

  /** Table description of table WorkingTimes. Objects of this class serve as prototypes for rows in queries. */
  class Workingtimes(_tableTag: Tag) extends profile.api.Table[WorkingtimesRow](_tableTag, schemaName, "WorkingTimes") {
    /** Foreign key referencing Parties (database name WHR_PRT_FK) */
    lazy val partiesFk1 = foreignKey("WHR_PRT_FK", usrCorrector, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Parties (database name WHR_PRT_FKv2) */
    lazy val partiesFk2 = foreignKey("WHR_PRT_FKv2", usrApprover, Parties)(r => Rep.Some(r.prtGuid), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Foreign key referencing Timeregistrations (database name WHR_TMR_FK) */
    lazy val timeregistrationsFk = foreignKey("WHR_TMR_FK", (tmrPmpPrtGuid, tmrPmpPrjProjectcode, tmrPmpPrjPrtProjowner, tmrCheckindatetime, tmrTerTerminalguid), Timeregistrations)(r => (r.docOwnerUsrWorker, r.prjProjectcode, r.prjOrgProjowner, r.checkindatetime, r.terGuidIn), onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Restrict)
    /** Database column TMR_PMP_PRT_GUID SqlType(VARCHAR), Length(36,true) */
    val tmrPmpPrtGuid: Rep[String] = column[String]("TMR_PMP_PRT_GUID", O.Length(36, varying = true))
    /** Database column TMR_PMP_PRJ_ProjectCode SqlType(VARCHAR), Length(10,true) */
    val tmrPmpPrjProjectcode: Rep[String] = column[String]("TMR_PMP_PRJ_ProjectCode", O.Length(10, varying = true))
    /** Database column TMR_PMP_StartDate SqlType(TIMESTAMP) */
    val tmrPmpStartdate: Rep[Timestamp] = column[Timestamp]("TMR_PMP_StartDate")
    /** Database column TMR_PMP_PRJ_PRT_ProjOwner SqlType(VARCHAR), Length(36,true) */
    val tmrPmpPrjPrtProjowner: Rep[String] = column[String]("TMR_PMP_PRJ_PRT_ProjOwner", O.Length(36, varying = true))
    /** Database column TMR_TER_TerminalGUID SqlType(VARCHAR), Length(36,true) */
    val tmrTerTerminalguid: Rep[String] = column[String]("TMR_TER_TerminalGUID", O.Length(36, varying = true))
    /** Database column TMR_CheckInDateTime SqlType(TIMESTAMP) */
    val tmrCheckindatetime: Rep[Timestamp] = column[Timestamp]("TMR_CheckInDateTime")
    /** Database column HoursType SqlType(VARCHAR), Length(16,true) */
    val hourstype: Rep[String] = column[String]("HoursType", O.Length(16, varying = true))
    /** Database column CreateDateTime SqlType(TIMESTAMP) */
    val createdatetime: Rep[Timestamp] = column[Timestamp]("CreateDateTime")
    /** Database column Hours SqlType(DECIMAL) */
    val hours: Rep[BigDecimal] = column[BigDecimal]("Hours")
    /** Database column USR_Corrector SqlType(VARCHAR), Length(36,true) */
    val usrCorrector: Rep[Option[String]] = column[Option[String]]("USR_Corrector", O.Length(36, varying = true))
    /** Database column USR_Approver SqlType(VARCHAR), Length(36,true) */
    val usrApprover: Rep[Option[String]] = column[Option[String]]("USR_Approver", O.Length(36, varying = true))
    /** Database column ApprovalDate SqlType(TIMESTAMP) */
    val approvaldate: Rep[Option[Timestamp]] = column[Option[Timestamp]]("ApprovalDate")
    /** Database column Remark SqlType(VARCHAR), Length(240,true) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(240, varying = true))
    /** Primary key of Workingtimes (database name WHR_PK) */
    val pk = primaryKey("WHR_PK", (tmrPmpPrtGuid, tmrPmpPrjProjectcode, tmrPmpPrjPrtProjowner, tmrPmpStartdate, tmrCheckindatetime, tmrTerTerminalguid, createdatetime, hourstype))

    def * = (tmrPmpPrtGuid, tmrPmpPrjProjectcode, tmrPmpStartdate, tmrPmpPrjPrtProjowner, tmrTerTerminalguid, tmrCheckindatetime, hourstype, createdatetime, hours, usrCorrector, usrApprover, approvaldate, remark) <> (WorkingtimesRow.tupled, WorkingtimesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(tmrPmpPrtGuid), Rep.Some(tmrPmpPrjProjectcode), Rep.Some(tmrPmpStartdate), Rep.Some(tmrPmpPrjPrtProjowner), Rep.Some(tmrTerTerminalguid), Rep.Some(tmrCheckindatetime), Rep.Some(hourstype), Rep.Some(createdatetime), Rep.Some(hours), usrCorrector, usrApprover, approvaldate, remark).shaped.<>({ r => import r._; _1.map(_ => WorkingtimesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10, _11, _12, _13))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))
  }


}

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.H2Profile
  val schemaName = Some("GreenTrac00")
} with Tables