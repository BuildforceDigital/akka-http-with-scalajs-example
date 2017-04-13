package nl.buildforce.greentrac

import slick.jdbc.H2Profile.api._

trait CheckConstraints {
  this: GTbackendMain.type =>

  def addCheckConstraints(schemaName: Option[String]): DBIO[Unit] = {

    // Projects.filter(p => p.orgProjowner.length < 0 ).result.statements.head

    DBIO.seq(
      {
        val tablename = s"""$objectNamePostFix"${Projects.baseTableRow.tableName}"""
        sqlu"""ALTER TABLE #$tablename" ADD CONSTRAINT "PRJ_EndDate"
         CHECK("EndDate" >= (select max("EndDate") from "GreenTrac00"."ProjectMemberProfiles" X
         where #$tablename"."ORG_ProjOwner" = X."ORG_ProjOwner" and #$tablename"."PRJ_ProjectCode" = X."PRJ_ProjectCode"))"""
      }, {
        val tablename = s"""$objectNamePostFix"${Projectmemberprofiles.baseTableRow.tableName}"""
        sqlu"""ALTER TABLE #$tablename" ADD CONSTRAINT "PMP_EndDate"
         CHECK("EndDate" <= (select "EndDate" from #$objectNamePostFix"#${Projects.baseTableRow.tableName}" X
         where #$tablename"."ORG_ProjOwner" = X."ORG_ProjOwner" and #$tablename"."PRJ_ProjectCode" = X."PRJ_ProjectCode"))"""
      },

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Documents.baseTableRow.tableName}" ADD CONSTRAINT "DOC_AccessNotice"
         CHECK ("#${Documents.baseTableRow.dctDocumenttype.toString().split('.').last}" = 'AccessNote' !=
         ("#${Documents.baseTableRow.orgProjowner.column.toString().split('.').last}" IS NULL OR "#${Documents.baseTableRow.prjProjectcode.toString().split('.').last}" IS NULL)) NOCHECK""",

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Documents.baseTableRow.tableName}" ADD CONSTRAINT "DOC_AccessNotice1"
         CHECK ("#${Documents.baseTableRow.dctDocumenttype.toString().split('.').last}" != 'AccessNote' OR ("#${Documents.baseTableRow.notice.toString().split('.').last}" IS NOT NULL AND "#${Documents.baseTableRow.notice.toString().split('.').last}" regexp '\w{2,}')) NOCHECK""",

      // Either the business or the user columns are not used
      sqlu"""ALTER TABLE #$objectNamePostFix"#${Parties.baseTableRow.tableName}" ADD CONSTRAINT "PRT_BusinessColumns0"
         CHECK ("#${Parties.baseTableRow.coc.toString().split('.').last}" IS NULL AND
         "#${Parties.baseTableRow.vatnumber.toString().split('.').last}" IS NULL) !=
         ("#${Parties.baseTableRow.username.toString().split('.').last}" IS NULL AND
          "#${Parties.baseTableRow.nickname.toString().split('.').last}" IS NULL AND
          "#${Parties.baseTableRow.gender.toString().split('.').last}" IS NULL AND
          "#${Parties.baseTableRow.jobfunction.toString().split('.').last}" IS NULL AND
          "#${Parties.baseTableRow.citizenservicenr.toString().split('.').last}" IS NULL AND
          "#${Parties.baseTableRow.systemrole.toString().split('.').last}" IS NULL) NOCHECK""",

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Contactpoints.baseTableRow.tableName}" ADD CONSTRAINT "CTP_ContactPoints"
        CHECK "#${Contactpoints.baseTableRow.contactkind.toString().split('.').last}" IN
        ('Domicile', 'ICoE LandlinePhone', 'ICoE MobilePhone', 'LandlinePhone', 'MobilePhone', 'PostalAddress', 'Web', 'eMail') NOCHECK""",

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Parties.baseTableRow.tableName}" ADD CONSTRAINT "PRT_LanguageTag" CHECK "#${Parties.baseTableRow.languagetag.toString().split('.').last}" IN ('nl_NL') NOCHECK""",

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Parties.baseTableRow.tableName}" ADD CONSTRAINT "PRT_Gender2" CHECK "#${Parties.baseTableRow.gender.toString().split('.').last}" IN ('F','M') NOCHECK""",

      sqlu"""ALTER TABLE #$objectNamePostFix"#${Parties.baseTableRow.tableName}" ADD CONSTRAINT "PRT_Nationality"
    CHECK "#${Parties.baseTableRow.nationality.toString().split('.').last}" IN (
    'AD', 'AE', 'AF', 'AG', 'AI', 'AL', 'AM', 'AO', 'AQ', 'AR', 'AS', 'AT', 'AU', 'AW', 'AX', 'AZ', 'BA', 'BB', 'BD', 'BE', 'BF', 'BG', 'BH',
    'BI', 'BJ', 'BL', 'BM', 'BN', 'BO', 'BQ', 'BR', 'BS', 'BT', 'BV', 'BW', 'BY', 'BZ', 'CA', 'CC', 'CD', 'CF', 'CG', 'CH', 'CI', 'CK', 'CL',
    'CM', 'CN', 'CO', 'CR', 'CU', 'CV', 'CW', 'CX', 'CY', 'CZ', 'DE', 'DJ', 'DK', 'DM', 'DO', 'DZ', 'EC', 'EE', 'EG', 'EH', 'ER', 'ES', 'ET',
    'EU', 'FI', 'FJ', 'FK', 'FM', 'FO', 'FR', 'GA', 'GB', 'GD', 'GE', 'GF', 'GG', 'GH', 'GI', 'GL', 'GM', 'GN', 'GP', 'GQ', 'GR', 'GS', 'GT',
    'GU', 'GW', 'GY', 'HK', 'HM', 'HN', 'HR', 'HT', 'HU', 'ID', 'IE', 'IL', 'IM', 'IN', 'IO', 'IQ', 'IR', 'IS', 'IT', 'JE', 'JM', 'JO', 'JP',
    'KE', 'KG', 'KH', 'KI', 'KM', 'KN', 'KP', 'KR', 'KW', 'KY', 'KZ', 'LA', 'LB', 'LC', 'LI', 'LK', 'LR', 'LS', 'LT', 'LU', 'LV', 'LY', 'MA',
    'MC', 'MD', 'ME', 'MF', 'MG', 'MH', 'MK', 'ML', 'MM', 'MN', 'MO', 'MP', 'MQ', 'MR', 'MS', 'MT', 'MU', 'MV', 'MW', 'MX', 'MY', 'MZ', 'NA',
    'NC', 'NE', 'NF', 'NG', 'NI', 'NL', 'NO', 'NP', 'NR', 'NU', 'NZ', 'OM', 'PA', 'PE', 'PF', 'PG', 'PH', 'PK', 'PL', 'PM', 'PN', 'PR', 'PS',
    'PT', 'PW', 'PY', 'QA', 'RE', 'RO', 'RS', 'RU', 'RW', 'SA', 'SB', 'SC', 'SD', 'SE', 'SG', 'SH', 'SI', 'SJ', 'SK', 'SL', 'SM', 'SN', 'SO',
    'SR', 'SS', 'ST', 'SV', 'SX', 'SY', 'SZ', 'TC', 'TD', 'TF', 'TG', 'TH', 'TJ', 'TK', 'TL', 'TM', 'TN', 'TO', 'TR', 'TT', 'TV', 'TW', 'TZ',
    'UA', 'UG', 'UM', 'US', 'UY', 'UZ', 'VA', 'VC', 'VE', 'VG', 'VI', 'VN', 'VU', 'WF', 'WS', 'XX', 'YE', 'YT', 'ZA', 'ZM', 'ZW') NOCHECK"""
    )
  }
}
