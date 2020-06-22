/**
 * 
 */
package com.bluedart.autopod.daoImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.autopod.dao.AutoPodMailSchedulerDao;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.exception.PodMailServiceException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.SpringApplicationContext;

/**
 * @author RA848436
 *
 */
@Repository
public class AutoPodMailSchedulerDaoImpl extends BaseDaoImpl implements AutoPodMailSchedulerDao {

	//private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	

	private static final Logger logger = Logger.getLogger(AutoPodMailSchedulerDaoImpl.class);

	@Autowired
	private MISLogDao misLogDao;


	
	@Transactional
	public long createReportFile(boolean trackByLoginId, int secLevel,
			String loginid, String custCC, String custAC, Date dateFrom,
			Date dateTo, String prodCode, String status, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder,
			String frequency) throws PodMailServiceException {

		SimpleDateFormat sdf = new SimpleDateFormat();
		String TempPath =SpringApplicationContext.schedulerProperty.getProperty(Constants.podMailSchedulerPath); 
				//"/home/APPADMIN/Software/autopod_temp/";//"F:/AutoPODScheduler/";

		

		SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMddHm");
		SimpleDateFormat dfDownloadFileName = new SimpleDateFormat("ddMMHHmm");
		java.util.Date today = new java.util.Date();

		StringBuffer query = new StringBuffer();
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
		if (secLevel > 1) {
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
		query.append("RPAD(NVL(S.corgarea, ' '), 3, ' ') AS ORGACODE, ");
		query.append("RPAD(NVL(S.ccustcode, ' '), 6, ' ') AS CUSTCODE ");

		query.append("FROM ");

		if (trackByLoginId) {
			query.append("affiliates_t AFF, ");
		}
		if (status != null && status.equalsIgnoreCase("DL")) {
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

		if (status != null && status.equalsIgnoreCase("DL")) {
			if (trackByLoginId) {
				query.append("AFF.loginid = '" + loginid + "' ");
				query.append("AND p.ccustcode = AFF.aff_cc ");
				query.append("AND p.corgarea = AFF.aff_ac ");
			} else {
				query.append("p.ccustcode = '" + custCC + "' ");
				query.append("AND p.corgarea = '" + custAC + "' ");
			}
			query.append("AND S.ccustcode =p.ccustcode ");
			query.append("AND S.corgarea = p.corgarea ");
			query.append("AND S.cawbno = p.cawbno ");
			query.append("AND S.cprodcode = p.cprodcode ");
			query.append("AND S.corgscrcd = p.corgscrcd ");
		} else {
			if (trackByLoginId) {
				query.append("AFF.loginid = '" + loginid + "' ");
				query.append("AND S.ccustcode = AFF.aff_cc ");
				query.append("AND S.corgarea = AFF.aff_ac ");
			} else {
				query.append("S.ccustcode = '" + custCC + "' ");
				query.append("AND S.corgarea = '" + custAC + "' ");
			}
		}

		if (status != null && status.equalsIgnoreCase("DL")) {

			query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDDHH24MM') >= '"
					+ dfDownloads.format(dateFrom) + "' ");
			query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDDHH24MM') <= '"
					+ dfDownloads.format(dateTo) + "' ");

		} else {
			if (!(status != null && status.equalsIgnoreCase("UD"))) {
				query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') >= '"
						+ dfDownloads.format(dateFrom) + "' ");
			}
			query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') <= '"
					+ dfDownloads.format(dateTo) + "' ");
		}

		if (status != null && status.equalsIgnoreCase("DL")) {
			if ((prodCode != null) && (prodCode.trim().length() > 0)) {
				query.append("AND P.cprodcode = '" + prodCode + "' ");
			}
		} else {
			if ((prodCode != null) && (prodCode.trim().length() > 0)) {
				query.append("AND S.cprodcode = '" + prodCode + "' ");
			}
		}
		if (status != null) {
			if (status.equalsIgnoreCase("DL")) {
				query.append("AND STAT.cstattype = S.cstattype ");
				query.append("AND STAT.cstatcode = S.cstatcode ");
				query.append("AND STAT.cqrygrp = 'DL' ");
			} else if (status.equalsIgnoreCase("RT")) {
				query.append("AND STAT.cstattype = S.cstattype ");
				query.append("AND STAT.cstatcode = S.cstatcode ");
				query.append("AND STAT.cqrygrp = 'RT' ");
			} else if (status.equalsIgnoreCase("RD")) {
				query.append("AND STAT.cstattype = S.cstattype ");
				query.append("AND STAT.cstatcode = S.cstatcode ");
				query.append("AND STAT.cqrygrp = 'RD' ");
			} else if (status.equalsIgnoreCase("UD")) {
				query.append("AND STAT.cstattype (+) = S.cstattype ");
				query.append("AND STAT.cstatcode (+) = S.cstatcode ");
				query.append("AND (STAT.cqrygrp = 'UD' OR STAT.cqrygrp IS NULL)");
			} else {
				query.append("AND STAT.cstattype (+) = S.cstattype ");
				query.append("AND STAT.cstatcode (+) = S.cstatcode ");
			}
		} else {
			query.append("AND STAT.cstattype (+) = S.cstattype ");
			query.append("AND STAT.cstatcode (+) = S.cstatcode ");
		}

		if (status != null && status.equalsIgnoreCase("DL")) {
			if (trackByLoginId && (orgAreaCode != null)
					&& (orgAreaCode.trim().length() > 0)) {
				query.append("AND p.corgarea = '" + orgAreaCode + "' ");
			}
		} else {
			if (trackByLoginId && (orgAreaCode != null)
					&& (orgAreaCode.trim().length() > 0)) {
				query.append("AND S.corgarea = '" + orgAreaCode + "' ");
			}
		}

		if (status != null && status.equalsIgnoreCase("DL")) {
			if ((dstAreaCode != null) && (dstAreaCode.trim().length() > 0)) {
				query.append("AND p.cdstarea = '" + dstAreaCode + "' ");
			}
		} else {
			if ((dstAreaCode != null) && (dstAreaCode.trim().length() > 0)) {
				query.append("AND S.cdstarea = '" + dstAreaCode + "' ");
			}
		}
		query.append("AND AO1.cscrcd (+) = S.corgscrcd ");
		query.append("AND CTO1.ccitycode (+) = S.corgarea ");
		query.append("AND AD1.cscrcd (+) = S.cdstscrcd ");
		query.append("AND AD2.carea (+) = S.cdstarea ");
		query.append("AND CTD1.ccitycode (+) = S.cdstarea ");

		String sortString = " PUDATE DESC, AWBNO DESC ";

		if ((sortBy != null) && (sortBy.trim().length() > 0)) {
			if (sortBy.equalsIgnoreCase("PICKUPDATE")) {
				sortString = " PUDATE ";
			} else if (sortBy.equalsIgnoreCase("AWBNO")) {
				sortString = " AWBNO ";
			} else if (sortBy.equalsIgnoreCase("REFNO")) {
				sortString = " REFNO ";
			} else if (sortBy.equalsIgnoreCase("ORGAREA")) {
				sortString = " ORGAREA ";
			} else if (sortBy.equalsIgnoreCase("DSTAREA")) {
				sortString = " DSTAREA ";
			} else if (sortBy.equalsIgnoreCase("CONSIGNEE")) {
				sortString = " CONSIGNEE ";
			} else {
				sortString = " PUDATE ";
			}

			if ((sortOrder != null) && (sortOrder.trim().length() > 0)) {
				if (sortOrder.equalsIgnoreCase("A")) {
					sortString = sortString.concat(" ASC, AWBNO ASC ");
				} else {
					sortString = sortString.concat(" DESC, AWBNO DESC ");
				}
			} else {
				sortString = sortString.concat(" DESC, AWBNO DESC ");
			}
		}

		query.append(" ORDER BY ORGACODE,CUSTCODE ");
		if ((sortBy != null) && (sortBy.trim().length() > 0)) {
			query.append(" ," + sortBy);
		}
		query.append(") a");
		logger.info("DL or UD status query is :" + query);
		/*if (Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
			logger.info("Download query is " + query.toString());
		}*/

		ZipOutputStream zipOut = null;
		PrintStream pOut = null;
		long compressedSize = 0;
		
		try {

			SQLQuery sqlQuery = getSession().createSQLQuery(query
					.toString());
			List<Object[]> objects = sqlQuery.list();
			logger.info("DL or UD status report size is : :" + objects.size());
			if(objects.size() >0){
			String fileName = dfDownloadFileName.format(today);
			zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(TempPath + loginid + ".zip")));
			zipOut.setComment("BlueDart >> AutoPOD >> Downloads");
			pOut = new PrintStream(zipOut);

			ZipEntry downloadFile = new ZipEntry(fileName + ".txt");
			downloadFile
			.setComment("BlueDart >> AutoPOD >> Downloads >> Data file");
			zipOut.putNextEntry(downloadFile);

			String orgarea = null;
			String custcode = null;
			SimpleDateFormat dateFormatForReport = new SimpleDateFormat("MM/dd/yy HH:mm a");
			for (Object[] record : objects) {

				//MISManager.updateMIS(Type.DOWNLOADS, loginid,sessioncreateReportFile);
			
				if ((sortBy != null) && (sortBy.trim().length() > 0)
						&& sortBy.equals("REFNO")) {

					if (orgarea == null
							|| custcode == null
							|| !orgarea.equalsIgnoreCase(record[20].toString())
							|| !custcode
							.equalsIgnoreCase(record[21].toString())) {
						if (orgarea != null && custcode != null) {
							pOut.print("\n================================================================================================================================================================================================================================");

							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
						}

						//for (Object[] record1 : objects) {
							orgarea = record[20].toString();

							custcode = record[21].toString();

						//}

						try {

							String custquery = "select ccustname from custmst where carea = '"
									+ orgarea
									+ "' and ccustcode = '"
									+ custcode + "'";

							SQLQuery sqlQueryCcustName = getSession()
									.createSQLQuery(custquery.toString());

							List<String> objectLists = sqlQueryCcustName
									.list();
						//	logger.info("Object size are-------@@@@@@@------ "
						//			+ objectLists.size());

							for (String records : objectLists) {
								String ccustname = records.toString();

								pOut.print("Date:" + dateFormatForReport.format(today).toString()
								+ "              Status " + status
								+ "Report for - " + orgarea + " "
								+ custcode + " " + ccustname);
							}

						} catch (Exception ex) {
							
							logger.error("EXCEPTION TYPE :",ex);
					
							
							
							//ex.printStackTrace();
							logger.info("Exception in Download : "
									+ ex.getMessage());

						}
						pOut.print("\r\n");
						pOut.print("================================================================================================================================================================================================================================");
						pOut.print("\r\n");
						pOut.print("Sr No Reference No         M P/U Date  Pcs Weight Destination     Consignee Name       Status Dt Time   Received By          Status Description             P Waybill No   Relation             IDNo                   IDType   ");
						pOut.print("\r\n");
						pOut.print("================================================================================================================================================================================================================================");
						pOut.print("\r\n");
						pOut.print("\r\n");
					}

					pOut.print(record[0].toString());
					pOut.print(" ");

					pOut.print(record[7].toString());
					pOut.print(" ");

					pOut.print(record[1].toString());
					pOut.print(" ");

					pOut.print(record[8].toString());
					pOut.print(" ");

					pOut.print(record[2].toString());
					pOut.print(" ");

					pOut.print(record[3].toString());
					pOut.print(" ");

					pOut.print(record[10].toString());
					pOut.print(" ");

					pOut.print(record[11].toString());
					pOut.print(" ");

					pOut.print(record[14].toString());

					pOut.print(" ");

					pOut.print(record[15].toString());
					pOut.print(" ");

					pOut.print(record[16].toString());
					pOut.print(" ");

					pOut.print(record[12].toString());
					pOut.print(" ");

					pOut.print(record[5].toString());
					pOut.print(" ");

					pOut.print(record[6].toString());
					pOut.print(" ");

					pOut.print(record[17].toString());
					pOut.print(" ");

					pOut.print(record[19].toString());
					pOut.print(" ");

					pOut.print(record[18].toString());
					pOut.print("\r\n");
					

				} else {

					if (orgarea == null || custcode == null

							|| !orgarea.equalsIgnoreCase(record[20].toString())

							|| !custcode.equalsIgnoreCase(record[21].toString())) {

						if (orgarea != null && custcode != null) {
							pOut.print("================================================================================================================================================================================================================================");
							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
							pOut.print("\r\n");
						}

						orgarea = record[20].toString();
						custcode = record[21].toString();

						// DatabaseAccess custda = new DatabaseAccess();
						try {
							// if (custda.connect(1)) {
							String custquery = "select ccustname from custmst where carea = '"
									+ orgarea
									+ "' and ccustcode = '"
									+ custcode + "'";

							SQLQuery sqlcustquery = getSession()
									.createSQLQuery(custquery);

							/*List<Object[]> objectcustqueryLists = sqlcustquery
									.list();
							logger.info("Object size are "
									+ objectcustqueryLists.size());

							for (String[] records : objectcustqueryLists) {
								String ccustname1 = records[0].toString();

								pOut.print("Date:" + sdf.format(today)
								+ "              Status Report for - "
								+ orgarea + " " + custcode + " "
								+ ccustname1);
							}*/
							List<String> objectcustqueryLists = sqlcustquery
									.list();
							
						//	logger.info("Object size are--------#######----- "
						//			+ objectcustqueryLists.size());
							for (String recordList : objectcustqueryLists) {
								String ccustname1 = recordList;
								pOut.print("Date:" + dateFormatForReport.format(today).toString()
								+ "              Status Report for - "
								+ orgarea + " " + custcode + " "
								+ ccustname1);
							}
						} catch (Exception ex) {
							logger.error("EXCEPTION TYPE :",ex);
					

							
							//ex.printStackTrace();
							logger.info("Exception in Download : "
									+ ex.getMessage());

						}
						pOut.print("\r\n");
						pOut.print("================================================================================================================================================================================================================================");
						pOut.print("\r\n");
						pOut.print("Sr No P Waybill No   M P/U Date  Pcs Weight Destination     Consignee Name       Status Dt Time   Received By          Status Description             Reference No         Relation             IDNo                 IDType      ");
						pOut.print("\r\n");
						pOut.print("================================================================================================================================================================================================================================");
						pOut.print("\r\n");
						pOut.print("\r\n");
					}

					pOut.print(record[0].toString());
					pOut.print(" ");

					pOut.print(record[5].toString());
					pOut.print(" ");

					pOut.print(record[6].toString());
					pOut.print(" ");

					pOut.print(record[1].toString());
					pOut.print(" ");

					pOut.print(record[8].toString());
					pOut.print(" ");

					pOut.print(record[2].toString());
					pOut.print(" ");

					pOut.print(record[3].toString());
					pOut.print(" ");

					pOut.print(record[10].toString());
					pOut.print(" ");

					pOut.print(record[11].toString());
					pOut.print(" ");

					pOut.print(record[14].toString());
					pOut.print(" ");

					pOut.print(record[15].toString());
					pOut.print(" ");

					pOut.print(record[16].toString());
					pOut.print(" ");

					pOut.print(record[12].toString());
					pOut.print(" ");

					pOut.print(record[7].toString());
					pOut.print(" ");

					pOut.print(record[17].toString());
					pOut.print(" ");

					pOut.print(record[19].toString());
					pOut.print(" ");

					pOut.print(record[18].toString());
					pOut.print("\r\n");
					

				}
	
				//MISManager.updateDownloadFilesizeMIS(loginid, compressedSize,sessioncreateReportFile);
			}
			zipOut.closeEntry();
			compressedSize += downloadFile.getCompressedSize();
			compressedSize += 387;

			}
			
			/*if (Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
				logger.info("Compressed file size is : "
						+ compressedSize);
			} */ 
		} catch (Exception ex) {
			logger.error("EXCEPTION TYPE :",ex);
	

			
			//ex.printStackTrace();
			logger.info("Exception in Download : " + ex.getMessage());

		} finally {
			try {

				if (zipOut != null) {
					zipOut.close();
				}
				if (pOut != null) {
					pOut.close();
				}
			} catch (Exception exp) {
				logger.error("EXCEPTION TYPE :",exp);
		

				
				exp.printStackTrace();
				/*if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
					System.out
					.println("Exception in Download while flushing and closing streams : "
							+ exp.getMessage());
					exp.printStackTrace();
				}*/
			}
		}
		return compressedSize;
	}


	@Transactional
	@Override
	public List<Object[]> getPodmailTDetails() {

		//logger.info("AutoPODMailScheduler execution starts at getPodMailTDetails");
		long lToday = ((new GregorianCalendar()).getTime()).getTime();
		java.sql.Date sToday = new java.sql.Date(lToday);
		
		String query = " select loginid , emailid , frequency , reporttype , runday ,  lastrundate ,  lastrundate || ' '||  lastruntime lastrundate1 , lastruntime , ATTACHMENT , SORTORDER from uprofile4.PODMAIL_T  where CSTATUS='0'";

		SQLQuery sqlQuery = getSession().createSQLQuery(query
				.toString());

		List<Object[]> objects = sqlQuery.list();
		logger.info("Scheduler should run for --------------"+objects.size());
		for (Object[] record : objects) {
			// streamReportDto = new StreamReportDto();
		//	String test = record[7].toString();
			int val = Integer.parseInt(record[7].toString().substring(1, 2));
			
			
			String lastrundateStr = record[5].toString();
			String rundayStr = record[4].toString();
			int runday = Integer.parseInt(rundayStr);


			Date lastrunDate = DateUtil.getFormatedSqlDateGivenFormat(lastrundateStr,
					"yyyy-MM-dd HH:mm:ss");
			/*Date rundayDate = DateUtil.getFormatedSqlDateGivenFormat(rundayStr,
					"yyyy-MM-dd HH:mm:ss");*/
			logger.info("=========================================================");
			logger.info("Login Id :"+record[0].toString());
			logger.info("frequency :"+record[2].toString());
			logger.info("Last run date from db---------"+ record[5].toString());
			logger.info("Last run time to be update :"+lastrunDate.getTime());
			logger.info("Report type is :"+record[3].toString());
			logger.info("=========================================================");
			
			
			//logger.info("Login Id : "+record[0].toString() + " Last run date configuration is  :"+record[2].toString() +" : and Date and Time is :"+lastrunDate.getTime());
			
			if ("H".equals(record[2].toString()) && Calendar.HOUR_OF_DAY > val) {
				/*logger.info("generate hourly report " + " Hour :"
						+ Calendar.HOUR_OF_DAY + " : " + record[2].toString()
						+ " : " + record[0].toString() + " ReportType "
						+ record[3].toString() + "date :"
						+ record[6].toString());*/
				
				logger.info("Generating Report For : H");
				logger.info("Hourly Last run="+lastrunDate);
				
			  runReport(record[0].toString(),record[1].toString(),record[2].toString(),
			  record[3].toString(),runday,lastrunDate,
			  record[7].toString(),record[8].toString(),null,null,record[9].toString(),null);
				
			}

			else if ("D".equals(record[2].toString())
					&& lastrunDate.getTime() < sToday.getTime()
					- (1000 * 60 * 60 * 24)) {
				
				/* logger.info("record[0]"+record[0].toString());*/
				// podmail.getString("LOGINID") + "<BR>");
				//logger.info("Generating Report For : D Last Run is :" + lastrunDate.getTime() +" and : " + (sToday.getTime() - (1000 * 60 * 60 * 24)));
				logger.info("Generating Report For : D");
				logger.info("Daily Last run="+lastrunDate);
				runReport(record[0].toString(), record[1].toString(),
						record[2].toString(), record[3].toString(), runday,
						lastrunDate, record[7].toString(),
						record[8].toString(), null, null, record[9].toString(),
						null); 
			}


			else if("W".equals(record[2].toString()) &&
					lastrunDate.getTime() < sToday.getTime() - (1000 * 60 * 60 * 24 * 7) &&
					Calendar.DAY_OF_WEEK >= runday) {
				//logger.info("Generating Report For : W Last Run is :" + lastrunDate.getTime() +" and : " + (sToday.getTime() - (1000 * 60 * 60 * 24 * 7)));
				logger.info("Generating Report For :W");
				logger.info("Weekly Last run="+lastrunDate);
				runReport(record[0].toString(),record[1].toString(),record[2].toString(),
						record[3].toString(),runday,lastrunDate,
						record[7].toString(),record[8].toString(),null,null,null,null);
			}



			else {
				sToday = new java.sql.Date(lToday);
			}
		}
	

		return objects;

	}

	/**
	 * 
	 * 
	 * @param loginid
	 * @param emailid
	 * @param frequency
	 * @param reporttype
	 * @param runday
	 * @param lastrundate
	 * @param lastruntime
	 * @param attachment
	 * @param orgAreaCode
	 * @param dstAreaCode
	 * @param sortBy
	 * @param sortOrder
	 */
	@Transactional
	private void runReport(String loginid, String emailid,
			String frequency, String reporttype, int runday, Date lastrundate,
			String lastruntime, String attachment, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder) {
	

		logger.info("AutoPODMailScheduler execution starts at runReport");

		SimpleDateFormat sdf = new SimpleDateFormat();
		String TempPath =SpringApplicationContext.schedulerProperty.getProperty(Constants.podMailSchedulerPath);
				//"/home/APPADMIN/Software/autopod_temp/"; //"F:/AutoPODScheduler/";
		String SmtpServer = "203.201.209.116";
	

		//long lToday = ((new GregorianCalendar()).getTime()).getTime()
		//		- (1000 * 60 * 60 * 24);
		java.sql.Date startdate = null;
		java.sql.Date enddate = null;
		//java.sql.Date sToday = new java.sql.Date(lToday);
		//SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmm");
		//String lastrundate1 = "201407061010";
		sdf.setLenient(false);
		try {
			startdate = new java.sql.Date(
					((new GregorianCalendar()).getTime()).getTime());
			enddate = new java.sql.Date(
					((new GregorianCalendar()).getTime()).getTime());

			
			if (frequency.equals("H")) {
				
				/*startdate = new java.sql.Date(
						((new GregorianCalendar()).getTime()).getTime());
				//enddate = lastrundate; */
			
				startdate = lastrundate;
				enddate = new java.sql.Date(
						((new GregorianCalendar()).getTime()).getTime());
				
				
			} else if (frequency.equals("D")) {
				startdate = lastrundate;
				
			} else if (frequency.equals("W")) {
				GregorianCalendar weekdate = new GregorianCalendar();
				weekdate.setTime(lastrundate);
				weekdate.add(Calendar.DAY_OF_MONTH,
						((Calendar.DAY_OF_WEEK - 1) * -1));
				enddate = new java.sql.Date(weekdate.getTime().getTime());
				weekdate.add(Calendar.DAY_OF_MONTH, (-6));
				startdate = new java.sql.Date(weekdate.getTime().getTime());
			} else if (frequency.equals("M")) {
				GregorianCalendar monthdate = new GregorianCalendar();
				monthdate.setTime(lastrundate);
				monthdate.add(Calendar.MONTH, -1);
				monthdate.set(Calendar.DAY_OF_MONTH, 1);
				startdate = new java.sql.Date(monthdate.getTime().getTime());
				monthdate.set(Calendar.DAY_OF_MONTH,
						monthdate.getActualMaximum(Calendar.DAY_OF_MONTH));
				enddate = new java.sql.Date(monthdate.getTime().getTime());
			}

			SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMdd");

			long reportsize = 0 ;
			String reportstatus = "OK";
			boolean notificationSent = false;
			Multipart mp = new MimeMultipart();
			//logger.info("reporttype ::: "+reporttype);
			String templateName ="AutoPODWithoutAttachment-template.vm";
			Properties properties = new Properties();
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
		
			
			if (reporttype.equals("DL") || reporttype.equals("UD")) {
				logger.info("Login id is "+loginid+"Report Type :"+reporttype+" and frequency :"+frequency+" and sratdate :"+startdate+" end date :"+enddate);
			
				reportsize = createReportFile(true, 1, loginid, null, null,
						startdate, enddate, null, reporttype, null, null,
						sortBy, null, frequency);
				logger.info("AutoPODMailScheduler reporttype  :"+reporttype +" and size is :"+reportsize);
			
				try {
					
					EmailContent mailContent = null;
					mailContent = new EmailContent();
					//boolean notificationSent = false;
					//mailContent.setFrom("response@bluedart.com");
					mailContent.setFrom(properties.getProperty("podmailSchedulerFromEmailId"));
					String toIds = emailid;
					if(null != toIds && !toIds.isEmpty()){
						//toIds = toIds.replace(",", ";");
						
						String[] elements = toIds.split(","); 
						List<String> multipleEmailId = Arrays.asList(elements);
					
						if(multipleEmailId.size() >1){
						mailContent.setListOfTOAddress(multipleEmailId);
						}else{
							mailContent.setTo(multipleEmailId.get(0));
						}
					}
					
					//mailContent.setTo(toIds);
					if(reporttype.equals("DL")){
						
						mailContent.setSubject(properties.getProperty("podMailSchedulerDeliveredSubject"));
					}else if(reporttype.equals("UD")){
						
						mailContent.setSubject(properties.getProperty("podMailSchedulerUnDeliveredSubject"));
					}else{
						mailContent.setSubject(properties.getProperty("podMailSchedulerSchedulerSubject"));
						
					}
					MimeBodyPart mbp1 = new MimeBodyPart();
					StringBuffer message = new StringBuffer();
					MimeBodyPart mbp2 = new MimeBodyPart();
					Map <String, Object> bsEmailModel = new HashMap <> ();
					if(reportsize > 0){
					FileDataSource fds = new FileDataSource(TempPath + loginid
							+ ".zip");
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());
					bsEmailModel.put("message1", "Dear Customer,");
					bsEmailModel.put("message2", "As requested by you, find attached status updates of your shipment(s)");
					templateName = "AutoPODWithAttachment-template.vm";
					mp.addBodyPart(mbp2);
					}else{
						bsEmailModel.put("message1", "Dear Customer,");
						bsEmailModel.put("message2", "There are no updates for your shipment(s).");
						//bsEmailModel.put("message3", "There are no updates for your shipment(s).");
						templateName = "AutoPODWithoutAttachment-template.vm";
					}
					Properties emailProperties = new Properties();
					try {
						emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
					} catch (IOException e) {
						logger.error("EXCEPTION TYPE :",e);
				

						
						//logger.error("Error : "+e);
					}
					File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
					File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
					message.append(EmailUtil.geContentFromTemplate(bsEmailModel, templateName));
					
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					DataSource bannerFileDataSource = new FileDataSource(bannerFile);
					messageBodyPart.setDataHandler(new DataHandler(bannerFileDataSource));
					messageBodyPart.setHeader("Content-ID", "<banner>");
					messageBodyPart.setDisposition(MimeBodyPart.INLINE);
					mp.addBodyPart(messageBodyPart);
					
					MimeBodyPart messageBodyPart1 = new MimeBodyPart();
					DataSource bannerFileDataSource1 = new FileDataSource(logoFile);
					messageBodyPart1.setDataHandler(new DataHandler(bannerFileDataSource1));
					messageBodyPart1.setHeader("Content-ID", "<logo>");
					messageBodyPart1.setDisposition(MimeBodyPart.INLINE);
					mp.addBodyPart(messageBodyPart1);
					
					mbp1.setContent(message.toString(), "text/html"); //setText(message.toString());
					mp.addBodyPart(mbp1);
				
					mailContent.setModel(bsEmailModel);
					notificationSent = EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp,templateName);
					if(notificationSent){
						reportstatus = "Mail was sent successfully";
					}else{
						reportstatus = "Mail is not Delivered.";
					}
					
					
					File f = new File(TempPath + loginid + ".zip");
					logger.info("AutoPODMailScheduler execution Mail was sent successfully. ");
					f.delete();
					f = null;
				}catch (Exception e1) {
					
					logger.error("EXCEPTION TYPE :",e1);
			

					reportstatus = "Mail is not Delivered.";
					//e1.printStackTrace();
					logger.debug("AutoPodMailScheduler : Email is not Delivered."+e1);

				}
					
			/*		EmailContent mailContent = null;

					mailContent = new EmailContent();
					mailContent.setFrom("response@bluedart.com");
					
					String toIds = emailid;//notificationDto.getToEmailId();
					if(null != toIds && !toIds.isEmpty()){
						toIds = toIds.replace(",", ";");
						logger.info("-------------------Email Id's" +toIds);
						mailContent.setTo(toIds);
						List<String> listOfToIds =  Arrays.asList(toIds.split(","));

						if(null != listOfToIds && listOfToIds.size() == 1)
							mailContent.setTo(toIds);
						else if(null != listOfToIds && listOfToIds.size() >1)
							mailContent.setListOfCCAddress(listOfToIds);
					}
					

					mailContent.setSubject("BlueDart >> AutoPOD");
					// create and fill the first message part
					MimeBodyPart mbp1 = new MimeBodyPart();
					StringBuffer message = new StringBuffer();
					// create the second message part
					Multipart mp = new MimeMultipart();
					MimeBodyPart mbp2 = new MimeBodyPart();
					if (reportsize > 0) {
						message.append("Dear Customer,\nEnclosed is the update on your shipment(s) as requested.\n");
						// attach the file to the message
					
						FileDataSource fds = new FileDataSource(TempPath + loginid
								+ ".zip");
						mbp2.setDataHandler(new DataHandler(fds));
						mbp2.setFileName(fds.getName());
					} else {
						message.append("Dear Customer,\nThis is an auto generated email. \nThere are no updates for your shipment(s).\n");
					}
					mbp1.setText(message.toString());
					// create the Multipart and its parts to it
					mp.addBodyPart(mbp1);
					try {
					if (reportsize > 0) {
						mp.addBodyPart(mbp2);
					

						notificationSent =  EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp, "AutoPODWithAttachment-template.vm");
					}else{
						notificationSent =  EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp, "AutoPODWithoutAttachment-template.vm");
					}
					reportstatus = "Mail was sent successfully";
					} catch (MessagingException e) {
						e.printStackTrace();
						logger.info("AutoPodScheduler : Message is not Delivered.");
						reportstatus = "Mail is not Delivered.";
					}

					logger.info("AutoPodMailScheduler : Is Message Delivered ? :"+notificationSent);

				}catch (Exception e1) {
					reportstatus = "Mail is not Delivered.";
					e1.printStackTrace();
					logger.debug("AutoPodMailScheduler : Email is not Delivered."+e1);

				}*/

				// logger.info("\nMail was sent successfully.");
			
				

			} else if (reporttype.equals("OP")) { // Override pod Logic will
				// come here

				StringBuffer messageBody = new StringBuffer();
				logger.info("Login id is "+loginid+"Report Type :"+reporttype+" and frequency :"+frequency+" and sratdate :"+startdate+" end date :"+enddate);
				
				messageBody = GetOverridePODDetails(true, 1, loginid, null,
						null, startdate, enddate, null, reporttype, null, null,
						sortBy, null, frequency);
			//	StringBuffer message = new StringBuffer();
				logger.info("AutoPODMailScheduler  for OP status size is: "+messageBody.length());
				try {
					
					EmailContent mailContent = null;
					mailContent = new EmailContent();
					//boolean notificationSent = false;
					//mailContent.setFrom("response@bluedart.com");
					mailContent.setFrom(properties.getProperty("podmailSchedulerFromEmailId"));
					String toIds = emailid;
					if(null != toIds && !toIds.isEmpty()){
						//toIds = toIds.replace(",", ";");
						
						String[] elements = toIds.split(","); 
						List<String> multipleEmailId = Arrays.asList(elements);
						
						if(multipleEmailId.size() >1){
						mailContent.setListOfTOAddress(multipleEmailId);
						}else{
							mailContent.setTo(multipleEmailId.get(0));
						}
					}
					
					//mailContent.setTo(toIds);
					
					mailContent.setSubject(properties.getProperty("podMailSchedulerOpodDeliveredSubject"));
					MimeBodyPart mbp1 = new MimeBodyPart();
					StringBuffer message = new StringBuffer();
					MimeBodyPart mbp2 = new MimeBodyPart();
					Map <String, Object> bsEmailModel = new HashMap <> ();
					if(messageBody.length() > 0){
					/*FileDataSource fds = new FileDataSource(TempPath + loginid
							+ ".zip");
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());*/
					bsEmailModel.put("message1", "Dear Customer,");
					bsEmailModel.put("message2", "As requested by you, find attached the shipments which has undergone status correction.");
					bsEmailModel.put("message3", messageBody);
					templateName = "AutoPODoverideStatus-template.vm";
					}else{
						bsEmailModel.put("message1", "Dear Customer,");
						bsEmailModel.put("message2", "There are no updates for your shipment(s).");
						//bsEmailModel.put("message3", "There are no updates for your shipment(s).");
						templateName = "AutoPODWithoutAttachment-template.vm";
					}
					Properties emailProperties = new Properties();
					try {
						emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
					} catch (IOException e) {
						
						logger.error("EXCEPTION TYPE :",e);
				
						
						//logger.error("Error : "+e);
					}
					File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
					File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
					
					message.append(EmailUtil.geContentFromTemplate(bsEmailModel, templateName));
					
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					DataSource bannerFileDataSource = new FileDataSource(bannerFile);
					messageBodyPart.setDataHandler(new DataHandler(bannerFileDataSource));
					messageBodyPart.setHeader("Content-ID", "<banner>");
					messageBodyPart.setDisposition(MimeBodyPart.INLINE);
					mp.addBodyPart(messageBodyPart);
					
					MimeBodyPart messageBodyPart1 = new MimeBodyPart();
					DataSource bannerFileDataSource1 = new FileDataSource(logoFile);
					messageBodyPart1.setDataHandler(new DataHandler(bannerFileDataSource1));
					messageBodyPart1.setHeader("Content-ID", "<logo>");
					messageBodyPart1.setDisposition(MimeBodyPart.INLINE);
					mp.addBodyPart(messageBodyPart1);
					
					mbp1.setContent(message.toString(), "text/html"); //setText(message.toString());
					mp.addBodyPart(mbp1);
					//mp.addBodyPart(mbp2);
				
					notificationSent = EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp,templateName);
					if(notificationSent){
						reportstatus = "Mail was sent successfully";
					}else{
						reportstatus = "Mail is not Delivered.";
					}
					
					
				/*	File f = new File("" + loginid + ".zip");
					logger.info("AutoPODMailScheduler execution Mail was sent successfully. ");
					f.delete();
					f = null;*/
				}catch (Exception e1) {
					logger.error("EXCEPTION TYPE :",e1);
			

					
					reportstatus = "Mail is not Delivered.";
					//e1.printStackTrace();
					logger.debug("AutoPodMailScheduler : Email is not Delivered."+e1);

				}
				
				
				
				
				/*
				 * 
				try {

					EmailContent mailContent = null;

					mailContent = new EmailContent();
					mailContent.setFrom("response@bluedart.com");
					logger.info("emailId in second try catchv ::: "+emailid);
					String toIds = emailid; //"velayutham.balasubramanian@wipro.com";//notificationDto.getToEmailId();
					if(null != toIds && !toIds.isEmpty()){
						toIds = toIds.replace(",", ";");
						logger.info("------Override pod-------------Email Id's" +toIds);
						List<String> listOfToIds =  Arrays.asList(toIds.split(","));

						if(null != listOfToIds && listOfToIds.size() == 1)
							mailContent.setTo(toIds);
						else if(null != listOfToIds && listOfToIds.size() >1)
							mailContent.setListOfCCAddress(listOfToIds);
					}
					
					mailContent.setSubject("BlueDart >> AutoPOD");

					

					// create and fill the first message part
					MimeBodyPart mbp1 = new MimeBodyPart();
					// create the second message part
					Multipart mp = new MimeMultipart();
					MimeBodyPart mbp2 = new MimeBodyPart();
					if (messageBody.length() == 0) {
						// attach the file to the message
						message.append("Dear Customer,\nThis is an auto generated email. \nThere are no updates for your shipment(s).\n");
					} else {
						message.append("Dear Customer,\nEnclosed is the update on your shipment(s) as requested.\n");
						message.append(messageBody.toString());
						reportsize = messageBody.length();
					}
					mbp1.setText(message.toString());
					// create the Multipart and its parts to it
					mp.addBodyPart(mbp1);

					try {
						notificationSent =  EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp, "AutoPODWithAttachment-template.vm");
						reportstatus = "Mail was sent successfully";

					} catch (MessagingException e) {
						reportstatus = "Mail is not Delivered.";

						e.printStackTrace();
						logger.info("AutoPodScheduler : Message is not Delivered.");
					}

					logger.info("AutoPodMailScheduler : Is Message Delivered ? :"+notificationSent);

				}catch (Exception e1) {
					reportstatus = "Mail is not Delivered.";
					e1.printStackTrace();
					logger.debug("AutoPodMailScheduler : Email is not Delivered."+e1);

				}
				*/
				
			}// Override pod Logic will come here


			try {
				long reportSizenew = reportsize;
				String reportStatusnew = reportstatus;
			
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HHmm");
				java.util.Date toDayDate = new java.util.Date();
				
				String toDayIs =formatter.format(toDayDate).toString();
				String toDayTimeIs =formatter.format(toDayDate).toString();
				String sysDate = toDayIs.substring(0,11);
				String sysTime = toDayTimeIs.substring(12,16);
		
				//logger.info(" Today date------sysDate-----"+sysDate);
				//logger.info(" Today date------sysTime-----"+sysTime);
				
				int retValue = -1;
				
				try {
				 retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
						@Override
						public Integer execute(Connection connection) throws SQLException {
							int retValue = -1;
							PreparedStatement preparedStatement = null;
							PreparedStatement preparedStatmnt = null;
							try{
							String updateQuery ="update uprofile4.PODMAIL_T  set LASTRUNDATE = to_date(sysDate,'DD-MON-RR'),LASTRUNTIME = '"+sysTime+"' where loginid = '" + loginid + "' and REPORTTYPE = '" + reporttype + "' and FREQUENCY = '" + frequency + "'";
							preparedStatement = connection.prepareStatement(updateQuery);
							int res= preparedStatement.executeUpdate();
							logger.info("Update result ------------:"+res);
							String insertQuery = "insert into UPROFILE4.PODMailtrn_T (LOGINID,FREQUENCY,REPORTTYPE,LASTRUNDATE,LASTRUNTIME,REPORTSIZE,REPORTSTATUS) VALUES ('" + loginid + "','" + frequency + "','" + reporttype + "',to_date(sysdate,'DD-MON-RR'),'" + sysTime + "'," + reportSizenew + ",'" + reportStatusnew + "')";
							preparedStatmnt = connection.prepareStatement(insertQuery);
							
							int res2 = preparedStatmnt.executeUpdate();
							logger.info("Insert result ------------:"+res);
							if(res > 0 && res2 >0){
								retValue = 1;
								connection.commit();
							}
							
							}catch(Exception exception){
								logger.error("EXCEPTION TYPE :",exception);
						

								
								exception.printStackTrace();
								//log.error("-----------------intimateMe exception blocak-------------------------");
							}finally{
								logger.info("---------------------finally-----------------");
								
								CloseConnections.closePreparedStatement(preparedStatement);
								CloseConnections.closePreparedStatement(preparedStatmnt);
							}
							return retValue;
						}
					});
				
				
				}
				catch (DataBaseException exception) {
					
					logger.error("EXCEPTION TYPE :",exception);
			
					//exception.printStackTrace();
					
				} 
			
			
			} catch (Exception ex) {
				logger.error("EXCEPTION TYPE :",ex);
		
				
				//ex.printStackTrace();
				logger.info("Exception in updating query : " + ex.getMessage());
			}
		


		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
	
			
			//e.printStackTrace();
			logger.info("Exception in outside try-catch :::: "+e);
			
		}
		String featureName = null;
		if(reporttype.equals("DL")){
			featureName =Constants.DELIVERED_AUTOPODSCHEDULER;
		}else if(reporttype.equals("UD")){ 
			featureName =Constants.UNDELIVERED_AUTOPODSCHEDULER;
		}else if(reporttype.equals("OP")){
			featureName =Constants.OVERRIDE_AUTOPODSCHEDULER;
		}
		saveMISLog(featureName,loginid,null,null,null);
		
	}
	@Transactional
	private  StringBuffer GetOverridePODDetails(boolean trackByLoginId,
			int secLevel, String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode,
			String status, String orgAreaCode, String dstAreaCode,
			String sortBy, String sortOrder, String frequency) {

		StringBuffer message = new StringBuffer();
		SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMddHm");
		StringBuffer query = new StringBuffer();

		query.append("SELECT ");
		query.append("RPAD(NVL(S.cawbno, ' '), 12, ' ') AS AWBNO ");
		query.append("FROM ");
		if (trackByLoginId) {
			query.append("affiliates_t AFF, ");
		}
		query.append("shipment S, webdba.overridepod o ");
		query.append("WHERE ");
		if (trackByLoginId) {
			query.append("AFF.loginid = '" + loginid + "' ");
			query.append("AND s.ccustcode = AFF.aff_cc ");
			query.append("AND s.corgarea = AFF.aff_ac ");
		} else {
			query.append(" s.ccustcode = '" + custCC + "' ");
			query.append("AND s.corgarea = '" + custAC + "' ");
		}
		query.append("AND S.cawbno = o.cawbno ");
		query.append("AND TO_CHAR(o.dentrydate, 'YYYYMMDDHH24MM') >= '"
				+ dfDownloads.format(dateFrom) + "' ");
		query.append("AND TO_CHAR(o.dentrydate, 'YYYYMMDDHH24MM') <= '"
				+ dfDownloads.format(dateTo) + "' ");

		// origin filter only if track all affiliates
		if (trackByLoginId && (orgAreaCode != null)
				&& (orgAreaCode.trim().length() > 0)) {
			query.append("AND p.corgarea = '" + orgAreaCode + "' ");
		}

		//if (Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
		logger.info("Override POD status query : " + query.toString());
		//}
				
		SQLQuery getOverridePODDetailsquery = getSession().createSQLQuery(query.toString());
		List<String> getOverridePODDetailsqueryLists = getOverridePODDetailsquery.list();
		logger.info("Override POD object size : " + getOverridePODDetailsqueryLists.size());

		

		

		try {
		

			for (String records : getOverridePODDetailsqueryLists) {
				
				if (message.length() == 0) {
					message = message.append(records.toString());
				} else {
					message = message.append(",\n" + records.toString());
				}
			}
			//	MISManager.updateMIS(Type.DOWNLOADS, loginid,getOverridePODDetailssession);
		} catch (Exception ex) {
			logger.error("EXCEPTION TYPE :",ex);
	
			
			//ex.printStackTrace();
			//if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
			logger.info("Override POD exception: " + ex.getMessage());
			//}
		} finally {
			
			logger.info("Finally block");
		}
		logger.info("override message size finally is : " + message.length());
		return message;

	}

	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
}
