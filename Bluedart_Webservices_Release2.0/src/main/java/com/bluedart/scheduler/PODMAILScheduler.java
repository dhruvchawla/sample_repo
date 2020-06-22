package com.bluedart.scheduler;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluedart.autopod.service.AutoPodMailSchedulerService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.SpringApplicationContext;
@Component("PODMAILScheduler")
public class  PODMAILScheduler{
	//private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	private AutoPodMailSchedulerService autoPodMailSchedulerService;
	private static final Logger logger = Logger.getLogger(PODMAILScheduler.class);
	public void executePODMAILScheduler() {
		
		//Properties propertiesMain = new Properties();
    	String runFlag = "FALSE" ;
    	String runFlagScheduler = "FALSE" ;
    	runFlag = SpringApplicationContext.STARTSCHEDULER; 
    	if(runFlag.equals("TRUE")){
    	try{
    	//propertiesMain.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
			
		 String[] schedulers = SpringApplicationContext.schedulerProperty.getProperty(Constants.SCHEDULERS).split(Pattern.quote("$"));
    	
		 for(int i=0;i<schedulers.length;i++){
			 
			if(schedulers[i].equals("PODMAILScheduler")){
				logger.debug("--------------------"+schedulers[i]+"--------------------");
				runFlagScheduler = SpringApplicationContext.schedulerProperty.getProperty(Constants.PODMAILSchedulerRUNFLAG);
			} 
			
			
		 }
		 
		 
		}catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			 logger.debug("IOException :  in readSchedulerProperties method ");
				//throw new BlueDartException();
		}
		try{
		 if(runFlag.equals("TRUE") && runFlagScheduler.equals("TRUE") )
			{
			 logger.debug("--------------------PODMAILScheduler Started--------------------");
			 autoPodMailSchedulerService = (AutoPodMailSchedulerService) SpringApplicationContext.getBean("autoPodMailSchedulerService");
			 
			 autoPodMailSchedulerService.getPodmailTDetails();
			 
			}
		}catch(Exception exc){
			logger.error("EXCEPTION TYPE :",exc);
			exc.printStackTrace();
		}
	}
	}
}






























/*package com.bluedart.scheduler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bluedart.autopod.daoImpl.MISManager;
import com.bluedart.autopod.scheduler.Type;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.SpringApplicationContext;

public class PODMAILScheduler implements Job {
	static SimpleDateFormat sdf = new SimpleDateFormat();
	static String TempPath = "F:\\RAMESH\\AutopodSche\\";
	// String TempPath = "c:\\";
	// String SmtpServer = "203.201.209.122";
	static String SmtpServer = "203.201.209.116";
	// String SmtpServer = "172.18.1.242";
	private static SessionFactory sessionFactory;

	// private static Session session;

	public static Session getSession() {
System.out.println("-------------------------------------------PODMAILScheduler-------------------");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-persistance-config-servlet.xml");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.openSession();

		return session;

	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		long lToday = ((new GregorianCalendar()).getTime()).getTime();
		java.sql.Date sToday = new java.sql.Date(lToday);
		System.out.println("-------------------------------------------PODMAILScheduler-----create text file zip and send to mail--------------");
		System.out.println("create text file zip and send to mail");
		sessionFactory = (SessionFactory) SpringApplicationContext
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		System.out.println(session);
		String query = " select loginid , emailid , frequency , reporttype , runday ,  lastrundate ,  lastrundate || ' '||  lastruntime lastrundate1 , lastruntime , ATTACHMENT , SORTORDER from podmail_t ";

		SQLQuery sqlQuery = session.createSQLQuery(query.toString());
		System.out.println(query.toString());
		long lStartTime = System.currentTimeMillis();
		List<Object[]> objects = sqlQuery.list();
		System.out.println("Object size are " + objects.size());

		for (Object[] record : objects) {
			// streamReportDto = new StreamReportDto();
			String test = record[7].toString();
			int val = Integer.parseInt(record[7].toString().substring(1, 2));
			System.out.println(val);

			// loginid=record[0].toString()
			// emailid=record[1].toString()
			// frequency=record[2].toString()
			// reporttype=record[3].toString()
			// runday=record[4].toString()

			// lastrundate=record[5].toString()
			// lastrundate1=record[6].toString()
			// lstruntime=record[7].toString()
			// attachment=record[8].toString()
			// sortorder=record[9].toString()
			String test1 = record[5].toString();
			int lastrundateInt = Integer.parseInt(record[5].toString());
			System.out.println("test1  " + test1);
			Date date = new Date(lastrundateInt);
			if ("H".equals(record[2].toString()) && Calendar.HOUR_OF_DAY > val) {
				System.out.println("generate hourly report " + " Hour :"
						+ Calendar.HOUR_OF_DAY + " : " + record[2].toString()
						+ " : " + record[0].toString() + " ReportType "
						+ record[3].toString() + "date :"
						+ record[6].toString() + "<BR>");
			}
			// since there is no time and only date so i am using lastrundate1
			

			
			
			
			
			
			
			 * else if( "D".equals(record[2].toString()) && date.getTime() <
			 * sToday.getTime() - (1000 * 60 * 60 * 24)) { //
			 * System.out.println("generate daily report " +
			 * podmail.getString("LOGINID") + "<BR>");
			 * runReport(record[0].toString
			 * (),record[1].toString(),podmail.getString("frequency"),
			 * podmail.getString
			 * ("reporttype"),podmail.getInt("runday"),podmail.getDate
			 * ("lastrundate"),
			 * podmail.getString("lastruntime"),podmail.getString
			 * ("ATTACHMENT"),null,null,podmail.getString("SORTORDER"),null); }
			 

			// streamReportDto.setRecordNo(record[0].toString());

		}

	}

	
	*//**
	 * 
	 * @param args
	 *//*
	public static void main(String[] args) {

		Session session = getSession();
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("spring-persistance-config-servlet.xml");
		long lToday = ((new GregorianCalendar()).getTime()).getTime();
		java.sql.Date sToday = new java.sql.Date(lToday);
		// sessionFactory = (SessionFactory) ctx
		// .getBean("sessionFactory");
		// Session session = sessionFactory.openSession();

		System.out.println(session);
		String query = " select loginid , emailid , frequency , reporttype , runday ,  lastrundate ,  lastrundate || ' '||  lastruntime lastrundate1 , lastruntime , ATTACHMENT , SORTORDER from podmail_t ";

		SQLQuery sqlQuery = session.createSQLQuery(query.toString());
		System.out.println(query.toString());
		long lStartTime = System.currentTimeMillis();
		List<Object[]> objects = sqlQuery.list();
		System.out.println("Object size are " + objects.size());

		for (Object[] record : objects) {
			// streamReportDto = new StreamReportDto();
			String test = record[7].toString();
			int val = Integer.parseInt(record[7].toString().substring(1, 2));
			System.out.println(val);

			// loginid=record[0].toString()
			// emailid=record[1].toString()
			// frequency=record[2].toString()
			// reporttype=record[3].toString()
			// runday=record[4].toString()

			// lastrundate=record[5].toString()
			// lastrundate1=record[6].toString()
			// lstruntime=record[7].toString()
			// attachment=record[8].toString()
			// sortorder=record[9].toString()
			// since there is no time and only date so i am using lastrundate1

			// long lToday = date.getTime();

			String lastrundateStr = record[5].toString();
			String rundayStr = record[4].toString();
			int runday = Integer.parseInt(rundayStr);
			

			Date lastrunDate = DateUtil.getFormatedSqlDateGivenFormat(lastrundateStr,
					"yyyy-MM-dd HH:mm:ss");
			Date rundayDate = DateUtil.getFormatedSqlDateGivenFormat(rundayStr,
					"yyyy-MM-dd HH:mm:ss");
			System.out.println(lastrunDate.getTime());
			
			
			
			

			if ("H".equals(record[2].toString()) && Calendar.HOUR_OF_DAY > val) {
				System.out.println("generate hourly report " + " Hour :"
						+ Calendar.HOUR_OF_DAY + " : " + record[2].toString()
						+ " : " + record[0].toString() + " ReportType "
						+ record[3].toString() + "date :"
						+ record[6].toString() + "<BR>");
			}

			else if ("D".equals(record[2].toString())
					&& lastrunDate.getTime() < sToday.getTime()
							- (1000 * 60 * 60 * 24)) {
				// System.out.println("generate daily report " +
				// podmail.getString("LOGINID") + "<BR>");
				runReport(record[0].toString(), record[1].toString(),
						record[2].toString(), record[3].toString(), runday,
						lastrunDate, record[7].toString(),
						record[8].toString(), null, null, record[9].toString(),
						null,session);
			}
			
			
			else if("W".equals(record[2].toString()) &&
					lastrunDate.getTime() < sToday.getTime() - (1000 * 60 * 60 * 24 * 7) &&
					Calendar.DAY_OF_WEEK >= runday) {
						System.out.println("generate weekly report");
						runReport(record[0].toString(),record[1].toString(),record[2].toString(),
								record[3].toString(),runday,lastrunDate,
								record[7].toString(),record[8].toString(),null,null,null,null,session);
					}
				
			

			else {
				sToday = new java.sql.Date(lToday);
			}

		}

	}

	
	*//**
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
	 *//*
	private static void runReport(String loginid, String emailid,
			String frequency, String reporttype, int runday, Date lastrundate,
			String lastruntime, String attachment, String orgAreaCode,
			String dstAreaCode, String sortBy, String sortOrder,Session sess) {
		//Session sessionDb=getSession();
		Session sessionDb= sess;

		long lToday = ((new GregorianCalendar()).getTime()).getTime()
				- (1000 * 60 * 60 * 24);
		java.sql.Date startdate = null;
		java.sql.Date enddate = null;
		java.sql.Date sToday = new java.sql.Date(lToday);
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmm");
		String lastrundate1 = "201407061010";
		sdf.setLenient(false);
		try {
			startdate = new java.sql.Date(
					((new GregorianCalendar()).getTime()).getTime());
			enddate = new java.sql.Date(
					((new GregorianCalendar()).getTime()).getTime());

			if (frequency.equals("H")) {
				
				 * try{ Date d = formater.parse(lastrundate1); }catch(Exception
				 * e){ System.out.println("err" + e.getMessage()); }//startdate
				 * = d;
				 
				startdate = new java.sql.Date(
						((new GregorianCalendar()).getTime()).getTime());
				enddate = lastrundate;
			} else if (frequency.equals("D")) {
				startdate = lastrundate;
				// enddate = lastrundate;
				// System.out.println ( " startdate :" + startdate +
				// " enddate : " + enddate );
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

			long reportsize = 0;
			String reportstatus = "OK";
			// System.out.println (" Before Reached here :" );
			if (reporttype.equals("DL") || reporttype.equals("UD")) {
				// System.out.println (" Reached here :" );
				reportsize = createReportFile(true, 1, loginid, null, null,
						startdate, enddate, null, reporttype, null, null,
						sortBy, null, frequency,sessionDb);
				Properties props = System.getProperties();
				props.put("mail.smtp.host", SmtpServer);
				javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, null);
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("AutoPOD@bluedart.com"));
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(emailid, false));
				msg.setSubject("BlueDart >> AutoPOD");
				msg.setHeader("X-Mailer", "bluedart Mailer");
				msg.setSentDate(new java.util.Date());

				// create and fill the first message part
				MimeBodyPart mbp1 = new MimeBodyPart();
				StringBuffer message = new StringBuffer();
				message.append("As requested by you, find attached status updates of your shipment(s)\n");
				// create the second message part
				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp2 = new MimeBodyPart();
				if (reportsize > 0) {
					// attach the file to the message
					FileDataSource fds = new FileDataSource(TempPath + loginid
							+ ".zip");
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());
				} else {
					message.append("There were no status updates for your shipments \n");
				}
				mbp1.setText(message.toString());
				// create the Multipart and its parts to it
				mp.addBodyPart(mbp1);
				if (reportsize > 0) {
					mp.addBodyPart(mbp2);
				}

				// add the Multipart to the message
				msg.setContent(mp);

				//Transport.send(msg);

				// System.out.println("\nMail was sent successfully.");
				reportstatus = "Mail was sent successfully";
				File f = new File("" + loginid + ".zip");
				f.delete();
				f = null;

			} else if (reporttype.equals("OP")) { // Override pod Logic will
													// come here

				StringBuffer messageBody = new StringBuffer();

				messageBody = GetOverridePODDetails(true, 1, loginid, null,
						null, startdate, enddate, null, reporttype, null, null,
						sortBy, null, frequency,sessionDb);
				StringBuffer message = new StringBuffer();
				Properties props = System.getProperties();
				props.put("mail.smtp.host", SmtpServer);
				javax.mail.Session  session = javax.mail.Session.getDefaultInstance(props, null);
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("AutoPOD@bluedart.com"));
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(emailid, false));
				msg.setSubject("BlueDart >> Status Correction");
				msg.setHeader("X-Mailer", "bluedart Mailer");
				msg.setSentDate(new java.util.Date());

				// create and fill the first message part
				MimeBodyPart mbp1 = new MimeBodyPart();
				message.append("As requested by you, find attached the shipments which has undergone status correction.\n");
				// create the second message part
				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp2 = new MimeBodyPart();
				if (messageBody.length() == 0) {
					message.append("There were no status updates for your shipments \n");
				} else {
					message.append(messageBody.toString());
					reportsize = messageBody.length();
				}
				mbp1.setText(message.toString());
				// create the Multipart and its parts to it
				mp.addBodyPart(mbp1);

				// add the Multipart to the message
				msg.setContent(mp);
				//Transport.send(msg);

				// System.out.println("\n OverridePOD Mail was sent successfully."
				// + reportsize );
				reportstatus = "Mail was sent successfully";

			}// Override pod Logic will come here

			GregorianCalendar gupdatedate = new GregorianCalendar();
			gupdatedate.setTime(enddate);
			if (!frequency.equals("H")) {
				// System.out.println (" gupdatedate : Before :" + gupdatedate
				// );
				gupdatedate.add(Calendar.DAY_OF_MONTH, 0);
				// System.out.println ( " startdate :" + startdate +
				// " enddate : " + enddate );
				// System.out.println (" gupdatedate : After :" + gupdatedate );
			} else {
				gupdatedate.add(Calendar.DAY_OF_MONTH, 0);
			}

			java.sql.Date updatedate = new java.sql.Date(gupdatedate.getTime()
					.getTime());
			
			
			String sql = "select sysdate from dual";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateFormatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			Object dateObj = (Object) sessionDb.createSQLQuery(sql).uniqueResult();
			
				java.util.Date dateTime = dateFormatTime.parse(dateObj.toString());
			
				java.util.Date date = dateFormat.parse(dateObj.toString());
				//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
				//String delquery = "update PODMail_T set LASTRUNDATE = "
				//	+ DatabaseAccess.formatTimeStamp(new Timestamp(updatedate
						//	.getTime()))
			
			String delquery = "update PODMail_T set LASTRUNDATE = "+ date.getTime()
			
							
					+ ",LASTRUNTIME = to_char(sysdate,'hh24mi') where loginid = '"
					+ loginid + "' and REPORTTYPE = '" + reporttype
					+ "' and FREQUENCY = '" + frequency + "'";
			String insertquery = "insert into PODMailtrn_T (LOGINID,FREQUENCY,REPORTTYPE,LASTRUNDATE,LASTRUNTIME,REPORTSIZE,REPORTSTATUS) VALUES ('"
					+ loginid
					+ "','"
					+ frequency
					+ "','"
					+ reporttype
					+ "',"
					+ lastrundate.getTime() ////Dhandapani validate
					
					//+ DatabaseAccess.formatTimeStamp(new Timestamp(lastrundate
					//		.getTime()))//Dhandapani 
					+ ",'"
					+ lastruntime
					+ "',"
					+ reportsize + ",'" + reportstatus + "')";

			// System.out.println("Delete Query := " + delquery);
			// System.out.println("Insert Query := " + insertquery );
			//DatabaseAccess da = new DatabaseAccess();
			
		    //  Session session=	getSession();
				Session session=	sessionDb;
			try {
				//if (da.connect(1)) {
					//da.doUpdateQuery(delquery.toString());
					//da.doUpdateQuery(insertquery.toString());
					session.update(delquery.toString());
					session.update(insertquery.toString());
				//}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out
						.println("Exception in Download1 : " + ex.getMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Download2 " + e.getMessage());
		}
	}

	// /create report file here.

	@SuppressWarnings("unused")
	private static long createReportFile(boolean trackByLoginId, int secLevel,
			String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode,
			String status, String orgAreaCode, String dstAreaCode,
			String sortBy, String sortOrder, String frequency, Session sess) {
		
		//Session sessioncreateReportFile=getSession();
		Session sessioncreateReportFile=sess;
    	// SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMddHm");
		SimpleDateFormat dfDownloadFileName = new SimpleDateFormat("ddMMHHmm");
		java.util.Date today = new java.util.Date();

		boolean retVal = false;

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
		
		// Changed  on 28/09/2001 by Shahrukh as  per Milind's Request
		query.append("RPAD(NVL(S.ccustcode, ' '), 6, ' ') AS CUSTCODE "); 
		// so that customer  are  able to identify Customer Code  on which shipment was sent
		query.append("FROM ");
		// affiliates table only if track all affiliates
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

		// affiliatest join only if track all affiliates
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
		// from and to dates compulsory
		if (status != null && status.equalsIgnoreCase("DL")) {
			// query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDD') >= '" +
			// dfDownloads.format(dateFrom) + "' ");
			// query.append("AND TO_CHAR(p.DPODUPDT, 'YYYYMMDD') <= '" +
			// dfDownloads.format(dateTo) + "' ");
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

		// origin filter only if track all affiliates
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
		 System.out.println("Query " + query);
		if (Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
			System.out.println("Download query is " + query.toString());
		}
		long compressedSize = 0;
		ResultSet rs = null;
		ResultSet custrs = null;
		ZipOutputStream zipOut =null;
		PrintStream pOut = null;
		try {
			zipOut =  new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(TempPath + loginid + ".zip")));
			zipOut.setComment("BlueDart >> AutoPOD >> Downloads");
			pOut = new PrintStream(zipOut);			
			String fileName = dfDownloadFileName.format(today);
			ZipEntry downloadFile = new ZipEntry(fileName + ".txt");
			System.out.println("Zipentry is  " + downloadFile);
			downloadFile.setComment("BlueDart >> AutoPOD >> Downloads >> Data file");
			zipOut.putNextEntry(downloadFile);
			
			
			

			
		

		//DatabaseAccess da = new DatabaseAccess();

		
			//if (da.connect(1)) {
		
		SQLQuery sqlQuery = sessioncreateReportFile.createSQLQuery(query.toString());
		System.out.println(query.toString());
		
		List<Object[]> objects = sqlQuery.list();
		System.out.println("Object size are " + objects.size());
//  how to handel do while in for loop.
		int i=0;
		for (Object[] record : objects)
		{
			i++;
				System.out.println("SNo: "+i);
				System.out.println("AWB No : "+record[6]);
				System.out.println("sortBy : "+sortBy);
				//rs = da.executeQuery(query.toString());
				// Make the zip ONLY IF any record exists
				//if (rs.next()) {
					retVal = true;
					//MISManager.updateMIS(Type.DOWNLOADS, loginid,sessioncreateReportFile);
					String fileName = dfDownloadFileName.format(today);
					zipOut = new ZipOutputStream(new BufferedOutputStream(
							new FileOutputStream(TempPath + loginid + ".zip")));
					
					zipOut.setComment("BlueDart >> AutoPOD >> Downloads");
					pOut = new PrintStream(zipOut);
					
					 * ZipEntry readme = new ZipEntry("README.TXT");
					 * readme.setComment
					 * ("BlueDart >> AutoPOD >> Downloads >> Help file");
					 * zipOut.putNextEntry(readme); try { String line = null;
					 * BufferedReader br = new BufferedReader(new
					 * FileReader(Config.getDownloadReadmeFile())); while( (line
					 * = br.readLine()) != null) { pOut.print(line + "\r\n"); }
					 * br.close(); //pOut.flush(); } catch (IOException ioe) {
					 * if(Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
					 * System.out.println(
					 * "IOException in Download while reading readme.txt file: "
					 * + ioe.getMessage() ); } } //zipOut.flush();
					 * zipOut.closeEntry(); compressedSize +=
					 * readme.getCompressedSize();
					 
					ZipEntry downloadFile = new ZipEntry(fileName + ".txt");
					System.out.println("Zipentry is  " + downloadFile);
					downloadFile
							.setComment("BlueDart >> AutoPOD >> Downloads >> Data file");
					zipOut.putNextEntry(downloadFile);
					
					String orgarea = null;
					String custcode = null;
					if ((sortBy != null) && (sortBy.trim().length() > 0)
							&& sortBy.equals("REFNO")) {
						//do {
							if (orgarea == null
									|| custcode == null
									|| !orgarea.equalsIgnoreCase(record[20].toString())
									|| !custcode.equalsIgnoreCase(record[21].toString())) {
								if (orgarea != null && custcode != null) {
									pOut.print("\n================================================================================================================================================================================================================================");

									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
								}
								//orgarea = rs.getString("ORGACODE");
								//custcode = rs.getString("CUSTCODE");
								for (Object[] record1 : objects) {
								orgarea=record1[20].toString();
								custcode=record1[21].toString();
								}
								orgarea=record[20].toString();
								custcode=record[21].toString();
								//DatabaseAccess custda = new DatabaseAccess();
								try {
									//if (custda.connect(1)) {
										String custquery = "select ccustname from custmst where carea = '"
												+ orgarea
												+ "' and ccustcode = '"
												+ custcode + "'";
										//custrs = custda.executeQuery(custquery
											//	.toString());
										
										SQLQuery sqlQueryCcustName = sessioncreateReportFile.createSQLQuery(custquery.toString());
										System.out.println(" query is customer name  " +sqlQueryCcustName );
										List<Object[]> objectLists = sqlQueryCcustName.list();
										System.out.println("Object size are " + objectLists.size());

										for (Object[] records : objectLists) {
											String ccustname = records[0].toString();
											
											pOut.print("Date:" + sdf.format(today)
													+ "              Status "
													+ status + "Report for - "
													+ orgarea + " " + custcode
													+ " " + ccustname);
										}
										String ccustname = new String();
										if (custrs.next())
											ccustname = custrs
													.getString("CCUSTNAME");
										custrs.close();
										pOut.print("Date:" + sdf.format(today)
												+ "              Status "
												+ status + "Report for - "
												+ orgarea + " " + custcode
												+ " " + ccustname);
												
												
												
									
							
								} catch (Exception ex) {
									if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
										System.out
												.println("Exception in Download3 : "
														+ ex.getMessage());
									}
								} finally {
									if (custrs != null) {
										//custrs.close();
									}
									//custda.disconnect();
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
							
							// recno=record[0].toString()
							// cmode=record[1].toString()
							// npcs=record[2].toString()
							// nweight=record[3].toString()
							// cstacode=record[4].toString()
							
							// cprodcode=record[5].toString()
							
							// awbno=record[6].toString()
							
							// refno=record[7].toString()
							// pudate=record[8].toString()
							// orgarea=record[9].toString()
							
							// dstarea=record[10].toString()
							// consignee=record[11].toString()
							// statdesc=record[12].toString()
							// statgroup=record[13].toString()
							// statdate=record[14].toString()
							// stattime=record[15].toString()
							// recdby=record[16].toString()
							// relation=record[17].toString()
							// idtype=record[18].toString()
							// idno=record[19].toString()
							// orgacode=record[20].toString()
							// custcode=record[21].toString()
							// loginid=record[22].toString()
							
							//pOut.print(rs.getString("RECNO"));
							pOut.print(record[0].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("REFNO"));
							pOut.print(record[7].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CMODE"));
							pOut.print(record[1].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("PUDATE"));
							pOut.print(record[8].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("NPCS"));
							pOut.print(record[2].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("NWEIGHT"));
							pOut.print(record[3].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("DSTAREA"));
							pOut.print(record[10].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CONSIGNEE"));
							pOut.print(record[11].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("STATDATE"));
							pOut.print(record[14].toString());
							
							pOut.print(" ");
							//pOut.print(rs.getString("STATTIME"));
							
							pOut.print(record[15].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("RECDBY"));
							pOut.print(record[16].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("STATDESC"));
							pOut.print(record[12].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CPRODCODE"));
							pOut.print(record[5].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("AWBNO"));
							pOut.print(record[6].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("RELATION"));
							pOut.print(record[17].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("IDNO"));
							pOut.print(record[19].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("IDTYPE"));
							pOut.print(record[18].toString());
							pOut.print("\r\n");
						//} 
					//while (rs.next());
					} else {
						//do {
							if (orgarea == null
									|| custcode == null
									//|| !orgarea.equalsIgnoreCase(rs
										//	.getString("ORGACODE"))
											|| !orgarea.equalsIgnoreCase(record[20].toString())
									//|| !custcode.equalsIgnoreCase(rs
										//	.getString("CUSTCODE"))) {
								
								|| !custcode.equalsIgnoreCase(record[21].toString())) {
								if (orgarea != null && custcode != null) {
									pOut.print("================================================================================================================================================================================================================================");
									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
									pOut.print("\r\n");
								}
								//orgarea = rs.getString("ORGACODE");
								//custcode = rs.getString("CUSTCODE");
								
								orgarea = record[20].toString();
								custcode = record[21].toString();
								//DatabaseAccess custda = new DatabaseAccess();
								try {
									//if (custda.connect(1)) {
										String custquery = "select ccustname from custmst where carea = '"
												+ orgarea
												+ "' and ccustcode = '"
												+ custcode + "'";
										
										SQLQuery sqlcustquery = sessioncreateReportFile.createSQLQuery(custquery);
										System.out.println("sql query before object are " + sqlcustquery);
										List<Object[]> objectcustqueryLists = sqlcustquery.list();
										System.out.println("Object size are " + objectcustqueryLists.size());
										//custrs = custda.executeQuery(custquery
											//	.toString());
										String ccustname = new String();
										//if (custrs.next())
										for (Object records : objectcustqueryLists) {
											ccustname = records.toString();
											//Object ccustname1 = records[0].toString();
											//String ccustname = custrs.getString("CCUSTNAME");//This loop is not required may be //Rasmi
											//custrs.close();
											pOut.print("Date:"
													+ sdf.format(today)
													+ "              Status Report for - "
													+ orgarea + " " + custcode
													+ " " + ccustname);
										}
								} catch (Exception ex) {
									if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
										System.out
												.println("Exception in Download4: "
														+ ex.getMessage());
									}
								} finally {
									try {
										if (custrs != null) {
											custrs.close();
										}
										//custda.disconnect();
									} catch (SQLException sqle) {
									//	if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
											System.out
													.println("Exception in Download while returning database connection : "
															+ sqle.getMessage());
									//	}
									}
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
							//pOut.print(rs.getString("RECNO"));
							pOut.print(record[0].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CPRODCODE"));
							pOut.print(record[5].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("AWBNO"));
							pOut.print(record[6].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CMODE"));
							pOut.print(record[1].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("PUDATE"));
							pOut.print(record[8].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("NPCS"));
							pOut.print(record[2].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("NWEIGHT"));
							pOut.print(record[3].toString());
							pOut.print(" ");
							
							//pOut.print(rs.getString("DSTAREA"));
							pOut.print(record[10].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("CONSIGNEE"));
							pOut.print(record[11].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("STATDATE"));
							pOut.print(record[14].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("STATTIME"));
							pOut.print(record[15].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("RECDBY"));
							pOut.print(record[16].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("STATDESC"));
							pOut.print(record[12].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("REFNO"));
							pOut.print(record[7].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("RELATION"));
							pOut.print(record[17].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("IDNO"));
							pOut.print(record[19].toString());
							pOut.print(" ");
							//pOut.print(rs.getString("IDTYPE"));
							pOut.print(record[18].toString());
							pOut.print("\r\n");
							
					//	} while (rs.next());
					}
					zipOut.closeEntry();
					compressedSize += downloadFile.getCompressedSize();
					compressedSize += 387; // Difference in combined zip entries
											// compressed size and zipfile size

				//	MISManager.updateDownloadFilesizeMIS(loginid,compressedSize,sessioncreateReportFile);
				} // if there are any records satisfying user criteria.Rasmi 
			
			if (Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
				System.out.println("Compressed file size is : "
						+ compressedSize);
			}
		} catch (Exception ex) {
			if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
				System.out
						.println("Exception in Download5 : " + ex.getMessage());
				System.out
				.println("Exception in Download5 : " + ex);
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			//	da.disconnect();
			} catch (SQLException sqle) {
				if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
					System.out
							.println("Exception in Download while returning database connection : "
									+ sqle.getMessage());
				}
			}
			try {
				// pOut.flush();
				// zipOut.flush();
				if (zipOut != null) {
					zipOut.close();
				}
				if (pOut != null) {
					pOut.close();
				}
			} catch (Exception exp) {
			if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
					System.out
							.println("Exception in Download while flushing and closing streams : "
									+ exp.getMessage());
					exp.printStackTrace();
				}
			}
		}
		return compressedSize;
	}
	private static StringBuffer GetOverridePODDetails(boolean trackByLoginId,
			int secLevel, String loginid, String custCC, String custAC,
			java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode,
			String status, String orgAreaCode, String dstAreaCode,
			String sortBy, String sortOrder, String frequency,Session getOverridePODDetailssession) {

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
			System.out.println("Download query is " + query.toString());
		//}
			//Session getOverridePODDetailssession = getSession();			
			SQLQuery getOverridePODDetailsquery = getOverridePODDetailssession.createSQLQuery(query.toString());
			List<Object[]> getOverridePODDetailsqueryLists = getOverridePODDetailsquery.list();
			System.out.println("Object size are " + getOverridePODDetailsqueryLists.size());
			
		ResultSet rs = null;
		
		//DatabaseAccess da = new DatabaseAccess();

		try {
			//if (da.connect(1)) {
				//rs = da.executeQuery(query.toString());
				// Make the zip ONLY IF any record exists
				//while (rs.next()) {
					
					for (Object[] records : getOverridePODDetailsqueryLists) {
						String ccustname1 = records[0].toString();
					if (message.length() == 0) {
						message = message.append(records[0].toString());
					} else {
						mesPODMAILSchedulersage = message.append(",\n" + records[0].toString());
					}
				}
			//	MISManager.updateMIS(Type.DOWNLOADS, loginid,getOverridePODDetailssession);
		} catch (Exception ex) {
			//if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
				System.out.println("Exception in Download6 : " + ex.getMessage());
			//}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				//da.disconnect();
			} catch (SQLException sqle) {
				//if (Type.DEBUG_LEVEL > Type.DEBUG_STANDARD_EXCEPTION) {
					System.out
							.println("Exception in Download while returning database connection : "
									+ sqle.getMessage());
				//}
			}
		}
		return message;

	}

}
*/