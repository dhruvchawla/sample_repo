package com.bluedart.common.daoImpl;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.SMSServiceDao;
import com.bluedart.common.entity.BD_SMSLog;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */

@Repository
public class SMSServiceDaoImpl extends BaseDaoImpl implements SMSServiceDao  {

	private static final Logger logger = Logger.getLogger(SMSServiceDaoImpl.class);

	@Transactional
	public String saveSMS( String responseId, String module ) {
		BD_SMSLog bdSmsLog = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		Date logDate = calendar.getTime();
		SimpleDateFormat dateFormatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormatTimeStr = new SimpleDateFormat("HH:mm");

		try {
			String date = dateFormatTime.format(new Date());
			
			// To get Time  08:56
			java.util.Date dateTime = dateFormatTime.parse(date);
			String time = dateFormatTimeStr.format(dateTime);
			
			// To get Date 26-MAY-17
			Date date1 = dateFormat.parse(date);
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

			bdSmsLog = new BD_SMSLog();
			bdSmsLog.setSmsLogId(30);
			bdSmsLog.setResponseId(responseId);
			bdSmsLog.setModuleName(module);
			bdSmsLog.setLogDate(sqlDate);

			getSession().save(bdSmsLog);
			logger.info("ResponseID updated in BD_SMSLog"+responseId);

		}catch(Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			
			logger.error("ResponseID did not update in BD_SMSLog"+exception.getMessage());
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return responseId;
	}

}
