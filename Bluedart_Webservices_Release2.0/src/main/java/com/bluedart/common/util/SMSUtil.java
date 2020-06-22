package com.bluedart.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedart.common.service.SMSService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */

public final class SMSUtil {

	private Properties properties = new Properties();

	private static final Logger logger = Logger.getLogger(SMSUtil.class);

	@Autowired
	private SMSService smsService;

	public String sendSMS( String mobileNo, String message, String module, String statusCode ) {
		try { 	

			logger.debug("sendSMS Starts");
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.EXT_WEBSERVICE_PROPERTIES));

			String AclURL = properties.getProperty(Constants.ACL_URL);
			String PathURL = properties.getProperty(Constants.ACL_URL_PATH)+mobileNo+"&sender=BluDrt&msgtext="+message;
 
			byte buffer[] = PathURL.getBytes("ISO-8859-1");                       
			URL url = new URL(AclURL);

			URLConnection conn = url.openConnection();                          
			conn.setDoOutput(true);                                           
			OutputStream out = conn.getOutputStream();                         
			out.write(buffer);                                                
			out.flush();
			
			InputStream instream = conn.getInputStream();                       
			buffer = new byte[3000];                                           
			instream.read(buffer);
			String responseId = buffer.toString();
			smsService.saveSMS(responseId, module);
			logger.info(" Response ID : "+buffer);
			statusCode = "000";
		}catch ( MalformedURLException ex) {                                                 
			ex.printStackTrace();   
			logger.error("Error caught in MalformedURLException "+ex);
			statusCode = "001";
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error("Error caught in Exception "+ex);
			statusCode = "001";
		}
		logger.debug("sendSMS Ends");
		
		return statusCode;
	}

}

