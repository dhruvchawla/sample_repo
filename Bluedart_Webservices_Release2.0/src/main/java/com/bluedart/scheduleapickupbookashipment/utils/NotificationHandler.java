package com.bluedart.scheduleapickupbookashipment.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluedart.common.dto.EmailContent;
import com.bluedart.exception.BlueDartException;
import com.bluedart.mobiledart.helper.MobileDartHelper;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;

@Component
public class NotificationHandler {

	private static final Logger logger = Logger.getLogger(NotificationHandler.class);

	public boolean sendEmail(String tokenNumber, String confirmDate, String name, String toAddress, String address1, String address2, String pinCode) {
		boolean isEmailSent = false;
		EmailContent mailContent = new EmailContent();
		mailContent.setFrom(Constants.BD_MAIL);
		mailContent.setTo(toAddress);
		mailContent.setSubject(Constants.EMAIL_SUB);

		Map<String, Object> pickupRegModal = new HashMap<>();
		pickupRegModal.put("confirmDate", confirmDate);
		pickupRegModal.put("tokenNumber", tokenNumber);
		pickupRegModal.put("name", name);
		pickupRegModal.put("address1", address1);
		pickupRegModal.put("address2", address2);
		pickupRegModal.put("pincode", pinCode);
		
		mailContent.setModel(pickupRegModal);

		try {
			isEmailSent = EmailUtil.sendEmailPickupRegistration(mailContent, Constants.EMAIL_TEMPLATE);
		} catch (Exception e) {
			logger.error("SPBS_Email Exception " + e);
		}

		return isEmailSent;
	}

	public boolean sendSMS(String tokenNumber, String confirmDate, String mobileNumber) {
		boolean isSMSSent = false;
		try {
//			isSMSSent = generateMessage(tokenNumber, confirmDate, mobileNumber);
			logger.info("-----------Sending SMS-------------");
			String smsMessage = MessageFormat.format(
					"Thank You for choosing Blue Dart. The pickup of your shipment is "
					+ "scheduled on {0} under Token #{1}. Kindly use this number for future reference.",
					confirmDate,tokenNumber);
			sendSMS(mobileNumber, smsMessage, "SP", "");
			isSMSSent = true;
		} catch (Exception e) {
			logger.error("SPBS_SMS Exception " + e);
		}
		return isSMSSent;
	}

	/*private static boolean generateMessage(String tokenNumber, String confirmDate, String mobileNo) throws IOException {
		boolean isMessageSent = false;
		try {
			String smsMessage = MessageFormat.format(
					"Thank You for choosing Blue Dart. The pickup of your shipment is scheduled on {0} under Token #{1}. Kindly use this number for future reference.",
					confirmDate,tokenNumber);

			isMessageSent = constructXmlSendSms(mobileNo, smsMessage);
		} catch (BlueDartException e) {
			e.printStackTrace();
			logger.error("SPBS_SMS Exception " + e);
			isMessageSent = false;
		}
		return isMessageSent;
	}*/
	
	/*private static boolean constructXmlSendSms(String mobileNumber, String smsMessage) throws IOException {
		logger.info("constructXmlSendSms");
		String messageId = generateMessageId(mobileNumber);
		String masking = "true";
		String xmlSms = null;
		boolean isMessageSent = false;
		String smsId = null;
		String password = null;
		String smsAppId = null;
		String smsSubAppId = null;
		String aclHost = null;
		Properties properties = new Properties();
		try {
			properties.load(MobileDartHelper.class.getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));

			smsId = properties.getProperty("SMSUID");
			password = properties.getProperty("PWD");
			smsAppId = properties.getProperty("SMSAPPID");
			smsSubAppId = properties.getProperty("SMSSUBAPPID");
			aclHost = properties.getProperty("ACLHOST");

			xmlSms = "<?xml version=\"1.0\"?><push><appid>" + smsAppId + "</appid><subappid>" + smsSubAppId
					+ "</subappid><userid>" + smsId + "</userid>" + "<pass>" + password
					+ "</pass><acct-type>1</acct-type><msgid>" + messageId + "</msgid><content-type>1</content-type>"
					+ "<priority>true</priority><masking>" + masking + "</masking><from>BlueDart</from><to><address>"
					+ mobileNumber + "</address></to> " + "<msg>" + smsMessage
					+ "</msg> <dlr>true</dlr><alert>1</alert></push>";
			isMessageSent = sendSMS(xmlSms, aclHost);
			if (isMessageSent) {
				logger.info("Message is Sent!");
			} else {
				logger.info("Message is not delivered!");
			}
		} catch (Exception e1) {
			logger.info("error " + e1);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE, Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return isMessageSent;
	}*/
	
	private String sendSMS( String mobileNo, String message, String module, String statusCode ) {
		try { 	
			Properties properties = new Properties();
			
			logger.info("sendSMS Starts");
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

//			InputStream instream = conn.getInputStream();                       
//			buffer = new byte[3000];                                           
//			instream.read(buffer);
//			String responseId = buffer.toString();
//			logger.info(" buffer : "+buffer+" SMSSERVICE ::: "+smsService+" MODULE ::: "+module+" responseId is ::: "+responseId);
			/*if(responseId != null ) {
				if( smsService != null ) {
					smsService.saveSMS(responseId, module);
				}
			}else {
				logger.debug("Error while receiving responseId ::: "+responseId);
			}*/
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
		logger.info("sendSMS Ends");

		return statusCode;
	}
	
	private static boolean sendSMS(String xmlSms, String aclUrl) throws IOException {
		logger.info("sendSMS method");
		try {
			byte[] buffer = xmlSms.getBytes("ISO-8859-1");

			URL url = new URL(aclUrl);

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStream out = conn.getOutputStream();
			out.write(buffer);
			out.flush();
			InputStream instream = conn.getInputStream();
			buffer = new byte[3000];
			instream.read(buffer);
			logger.info("Response :" + new String(buffer).trim());
			return true;
		} catch (MalformedURLException ex) {
			logger.info(ex);
			logger.info("sendSMS " + ex);
			return false;
		}

	}

	private static String generateMessageId(String mobileNumber) {
		long currentTime = System.currentTimeMillis();
		Long longTimestamp = currentTime;
		return longTimestamp.toString() + mobileNumber;
	}

}
