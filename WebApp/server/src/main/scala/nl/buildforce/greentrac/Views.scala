package nl.buildforce.greentrac

import scala.compat.Platform.currentTime

trait Views {
  this: GTbackendMain.type =>

  val profile: slick.jdbc.JdbcProfile

  import profile.api._

  def TimeReg = Timeregistrations.map(tmr => (
    tmr.terGuidIn,
    tmr.prjOrgProjowner,
    tmr.prjProjectcode,
    tmr.docOwnerUsrWorker,
    tmr.checkindatetime,
    tmr.docDocid,
    tmr.docDocumenttype,
    tmr.docExpirationdate))

  def createViews(schemaName: Option[String]) = {

    val objectNamePostFix = Some(schemaName.mkString("\"", "", "\".")).filter(_.length > 3).mkString

    /** Part of qryTextAllTags */
    def qryTextAllTables0 =
      tableList.map(tbl =>
        s"""select '${tbl.baseTableRow.tableName}' "Name",count(*) "Rows"from $objectNamePostFix"${tbl.baseTableRow.tableName}"""")
        .mkString(" union all ")

    def qryTextAllTags = for {
      (tag, tp) <- Tags joinLeft (TagPrt62 join Parties on (_.prtGuid === _.prtGuid)) on (_.tagname === _._1.tagTagname)
    } yield (tag.tagname, tp.map(_._2))

    def qryWhoIsIn =
      (Timeregistrations join Parties on (_.docOwnerUsrWorker === _.prtGuid)).map { case (tmr, prt) => (prt.name, tmr.docDocid, tmr.terGuidIn) }


    def qryTextUsers = Parties.filter(p => p.coc.isEmpty && p.vatnumber.isEmpty)
      .map(prt => (prt.prtGuid,
        prt.prtVersionnumber, prt.name, prt.languagetag, prt.nationality, prt.remarks, prt.tilldate, prt.imageurl, prt.picture,
        prt.username,
        prt.nickname,
        prt.birthday,
        prt.gender,
        prt.jobfunction,
        prt.citizenservicenr,
        prt.systemrole))

    def qryTextOrgs = Parties.filter(p =>
      p.citizenservicenr.isEmpty && p.gender.isEmpty && p.nickname.isEmpty && p.username.isEmpty && p.jobfunction.isEmpty)
      .map(prt =>
        (prt.prtGuid, prt.prtVersionnumber, prt.name, prt.languagetag, prt.nationality, prt.remarks, prt.tilldate,
          prt.imageurl, prt.picture, prt.birthday, prt.coc, prt.vatnumber))

    DBIO.seq(
      sqlu"""create or replace view #$objectNamePostFix"AllTables0" as #$qryTextAllTables0""",
      sqlu"""create or replace view #$objectNamePostFix"AllTablesSummarized"("Name", "Rows")as
       (select "Name", "Rows" from   #$objectNamePostFix"AllTables0" where "Rows" > 0)
        union all
       (select ( 'Totals # tables: '||Count(*) ), sum("Rows") from   #$objectNamePostFix"AllTables0")""",
      sqlu"""create or replace view #$objectNamePostFix"AllTags" as #${qryTextAllTags.result.statements.head}""",
      sqlu"""create or replace view #$objectNamePostFix"Experimental" as #${/*checkAccess*/ test.result.statements.head}""",
      sqlu"""create or replace view #$objectNamePostFix"Organizations" as #${qryTextOrgs.result.statements.head}""",
      sqlu"""create or replace view #$objectNamePostFix"TableAbbreviations" as select distinct substr(CONSTRAINT_NAME, 0, 3), TABLE_NAME FROM INFORMATION_SCHEMA.CONSTRAINTS order by 1""",
      sqlu"""create or replace view #$objectNamePostFix"Users" as #${qryTextUsers.result.statements.head}""",
      sqlu"""create or replace view #$objectNamePostFix"WhoIsIn" as #${qryWhoIsIn.result.statements.head}""")
  }

  def test = (checkAccess.filter(p => p._1 === "TERMINAL0000001" && p._2._6 === "Doc 123457" /*&& p.map(_.) === Some(Some(0))*/)
    .map { p => (p._1, p._2._1, p._2._2, p._2._3, p._2._5, p._2._4, p._2._6, p._2._7, p._2._8) })

  def checkAccess = {
    def projectMemberWithAccessNoticeGrouped = {
      def projectMemberWithAccessNotice = {
        def projectMember = (Projectmemberprofiles join Projects on { case (pmp, prj) =>
          pmp.orgProjowner === prj.orgProjowner && pmp.prjProjectcode === prj.prjProjectcode
        }).map { case (pmp, prj) => (pmp.usrWorker, pmp.orgProjowner, pmp.prjProjectcode,
          Case
            If pmp.enddate.isEmpty Then prj.enddate Else pmp.enddate)
        }.distinct

        (projectMember joinLeft Documents on {
          case (pm, doc) =>
            pm._1 === doc.prtOwner && pm._2 === doc.orgProjowner && pm._3 === doc.prjProjectcode && doc.dctDocumenttype === "AccessNote"
        }).map { case (pm, doc) => (pm, doc.map(Case If _.checkedConfirmeddate.isEmpty Then 1 Else 0)) }
      }

      projectMemberWithAccessNotice.groupBy(p => p._1).map { case (key, group) => (key, group.map(_._2).sum) }
    }

    def DocumentsWithPmp = (Documents joinLeft projectMemberWithAccessNoticeGrouped on {
      case (doc, pm) => pm._1._1 === doc.prtOwner
    }).filter(_._1.dctDocumenttype === "GreenTracPass")
      .map { case (doc, pm) => (pm.map(_._1._2), pm.map(_._1._3), /*pm.map(_._1._4),*/ pm.map(_._2), // Slick bug ??
        new java.sql.Timestamp(currentTime),
        doc.prtOwner, doc.docid, doc.dctDocumenttype, doc.expirationdate)
      }

    (DocumentsWithPmp joinLeft Peripherals on {
      case (dpmp, ter) => dpmp._1 === ter.orgProjowner && dpmp._2 === ter.prjProjectcode
    }).map { case (dpmp, ter) => (ter.map(_.terGuid), dpmp) }
  }
}