package com.bluedart.autopod.scheduler;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer query = new StringBuffer();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		query.append("SELECT ");
		query.append("RPAD(NVL(S.cawbno, ' '), 12, ' ') AS AWBNO ");
		query.append("FROM ");
		if (true) {
			query.append("affiliates_t AFF, ");
		}
		query.append("shipment S, webdba.overridepod o ");
		query.append("WHERE ");
		if (true) {
			query.append("AFF.loginid = '" + "101" + "' ");
			query.append("AND s.ccustcode = AFF.aff_cc ");
			query.append("AND s.corgarea = AFF.aff_ac ");
		} else {
			query.append(" s.ccustcode = '" + "102" + "' ");
			query.append("AND s.corgarea = '" + "103" + "' ");
		}
		query.append("AND S.cawbno = o.cawbno ");
		query.append("AND TO_CHAR(o.dentrydate, 'YYYYMMDDHH24MM') >= '"
				+ "20170220042400" + "' ");
		query.append("AND TO_CHAR(o.dentrydate, 'YYYYMMDDHH24MM') <= '"
				+ "20170220042400" + "' ");

		// origin filter only if track all affiliates
		if (true) {
			query.append("AND p.corgarea = '" + "102" + "' ");
		}
		
		
		System.out.println("query is     "+query.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////
		query.append("SELECT ");
		query.append("RPAD(TO_CHAR(rownum), 5, ' ') AS RECNO, a.* ");
		query.append(" from (");
		query.append("SELECT  DISTINCT ");
		query.append("RPAD(NVL(S.CMODE, ' '), 1, ' ') AS CMODE, ");
		query.append("RPAD(TO_CHAR(S.NPCS), 4, ' ') AS NPCS, ");
		query.append("RPAD(TO_CHAR(S.NWEIGHT), 5, ' ') AS NWEIGHT, ");
		query.append("RPAD(NVL(S.CSTATCODE, ' '), 8, ' ') AS CSTATCODE, ");
		query.append("RPAD(NVL(S.cprodcode, ' '), 1, ' ') AS CPRODCODE, ");

		query.append("RPAD(NVL(S.cawbno, ' '), 12, ' ') AS AWBNO, ");
		query.append("RPAD(NVL(S.ccrcrdref, ' '), 20, ' ') AS REFNO, ");
		query.append("RPAD(NVL(TO_CHAR(S.dpudate, 'dd-Mon-yy'), ' '), 9, ' ') AS PUDATE, ");
		query.append("RPAD(NVL(DECODE (S.cprodcode, 'X', CTO1.ccityname, AO1.careadesc), ' '), 25, ' ') AS ORGAREA, ");
		query.append("SUBSTR(RPAD(NVL(DECODE (S.cprodcode, 'I', CTD1.ccityname, NVL(AD1.careadesc, AD2.careadesc)), ' '), 25, ' '),1,15) AS DSTAREA, ");
		query.append("RPAD(NVL(S.cattention, ' '), 20, ' ') AS CONSIGNEE, ");
		if (5 > 1) {
			query.append("SUBSTR(RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc), ' '), 50, ' '),1,30) AS STATDESC, ");
		} else {
			query.append("SUBSTR(RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc2), ' '), 50, ' '),1,30) AS STATDESC, ");
		}
		query.append("RPAD(NVL(STAT.cqrygrp, 'IT'), 2, ' ') AS STATGROUP, ");
		query.append("RPAD(NVL(TO_CHAR(S.dstatdate, 'dd-Mon-yy'), ' '), 9, ' ') AS STATDATE, ");
		query.append("RPAD(NVL(S.cstattime, ' '), 6, ' ') AS STATTIME, ");
		query.append("SUBSTR(RPAD(NVL(DECODE(S.cstattype, 'T', DECODE(S.cstatcode, '000', S.crecdby, ' '), ' '), ' '), 30, ' '),1,20) AS RECDBY, ");
		query.append("SUBSTR(RPAD(NVL(S.crelation, ' '), 30, ' '),1,20) AS RELATION, ");
		query.append("RPAD(NVL(S.cidtype, ' '), 2, ' ') AS IDTYPE, ");
		query.append("RPAD(NVL(S.cidno, ' '), 20, ' ') AS IDNO, ");
		query.append("RPAD(NVL(S.corgarea, ' '), 3, ' ') AS ORGACODE, "); // Changed
																			// on
																			// 28/09/2001
																			// by
																			// Shahrukh
																			// as
																			// per
																			// Milind's
																			// Request
		query.append("RPAD(NVL(S.ccustcode, ' '), 6, ' ') AS CUSTCODE "); // so
																			// that
																			// customer
																			// are
																			// able
																			// to
																			// identify
																			// Customer
																			// Code
																			// on
																			// which
																			// shipment
																			// was
																			// sent

		query.append("FROM ");

		// affiliates table only if track all affiliates
		if (true) {
			query.append("affiliates_t AFF, ");
		}
		if ("DL" != null && "DL".equalsIgnoreCase("DL")) {
			query.append("subpod p, ");

		}

		query.append("shipment S, ");
		query.append("statmst STAT, ");
		query.append("areamst AO1, ");
		query.append("citymst CTO1, ");
		query.append("areamst AD1, ");
		query.append("(SELECT carea, careadesc FROM areamst WHERE (ROWID, carea) IN (SELECT MIN(ROWID), carea FROM areamst GROUP BY carea)) AD2, ");
		query.append("citymst CTD1 ");

		query.append("WHERE ");

		// affiliatest join only if track all affiliates
		if ( "DL".equalsIgnoreCase("DL")) {
			if (true) {
				query.append("AFF.loginid = '" + "101" + "' ");
				query.append("AND p.ccustcode = AFF.aff_cc ");
				query.append("AND p.corgarea = AFF.aff_ac ");
			} else {
				query.append("p.ccustcode = '" + "101" + "' ");
				query.append("AND p.corgarea = '" + "105" + "' ");
			}
			query.append("AND S.ccustcode =p.ccustcode ");
			query.append("AND S.corgarea = p.corgarea ");
			query.append("AND S.cawbno = p.cawbno ");
			query.append("AND S.cprodcode = p.cprodcode ");
			query.append("AND S.corgscrcd = p.corgscrcd ");
		} else {
			if (true) {
				query.append("AFF.loginid = '" + "101" + "' ");
				query.append("AND S.ccustcode = AFF.aff_cc ");
				query.append("AND S.corgarea = AFF.aff_ac ");
			} else {
				query.append("S.ccustcode = '" + "102" + "' ");
				query.append("AND S.corgarea = '" + "105" + "' ");
			}
		}
		// from and to dates compulsory
		if ("DL".equalsIgnoreCase("DL")) {
			// query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDD') >= '" +
			// dfDownloads.format(dateFrom) + "' ");
			// query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDD') <= '" +
			// dfDownloads.format(dateTo) + "' ");
			query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDDHH24MM') >= '"
					+ "01-01-2016" + "' ");
			query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDDHH24MM') <= '"
					+ "01-01-2016" + "' ");
			
		} else {
			if (true) {
				query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') >= '"
						+ "01-01-2016" + "' ");
			}
			query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') <= '"
					+ "01-01-2016" + "' ");
		}

		if (true) {
			if (true) {
				query.append("AND P.cprodcode = '" + "560092" + "' ");
			}
		} else {
			if (false) {
				query.append("AND S.cprodcode = '" + "101" + "' ");
			}
		}
		if (true) {
			if (true) {
				query.append("AND STAT.cstattype = S.cstattype ");
				query.append("AND STAT.cstatcode = S.cstatcode ");
				query.append("AND STAT.cqrygrp = 'DL' ");
			
		} else {
			query.append("AND STAT.cstattype (+) = S.cstattype ");
			query.append("AND STAT.cstatcode (+) = S.cstatcode ");
		}

		// origin filter only if track all affiliates
		if (true) {
			if (true)
					 {
				query.append("AND p.corgarea = '" + "908" + "' ");
			}
		} else {
			if (false) {
				query.append("AND S.corgarea = '" + "907" + "' ");
			}
		}

		if (true) {
			if (true) {
				query.append("AND p.cdstarea = '" + "908" + "' ");
			}
		} else {
			if (true) {
				query.append("AND S.cdstarea = '" + "765" + "' ");
			}
		}
		query.append("AND AO1.cscrcd (+) = S.corgscrcd ");
		query.append("AND CTO1.ccitycode (+) = S.corgarea ");
		query.append("AND AD1.cscrcd (+) = S.cdstscrcd ");
		query.append("AND AD2.carea (+) = S.cdstarea ");
		query.append("AND CTD1.ccitycode (+) = S.cdstarea ");

		String sortString = " PUDATE DESC, AWBNO DESC ";

		if (true) {
			if (true) {
				sortString = " AWBNO ";
			} else {
				sortString = " PUDATE ";
			}

			if (true) {
				if (true) {
					sortString = sortString.concat(" ASC, AWBNO ASC ");
				} else {
					sortString = sortString.concat(" DESC, AWBNO DESC ");
				}
			} else {
				sortString = sortString.concat(" DESC, AWBNO DESC ");
			}
		}

		query.append(" ORDER BY ORGACODE,CUSTCODE ");
		
		//System.out.println("query is     "+query.toString());
		

	}

}
}
