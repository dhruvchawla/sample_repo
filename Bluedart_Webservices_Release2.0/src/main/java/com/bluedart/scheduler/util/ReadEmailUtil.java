package com.bluedart.scheduler.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.bluedart.utils.Constants;
import com.bluedart.utils.SpringApplicationContext;

@Component
public class ReadEmailUtil {
	private static final Logger logger = Logger.getLogger(ReadEmailUtil.class);
	  //private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	  
	public static Store readMailBox(String userId, String password) {
	/*	Properties po3Properties = new Properties();
		logger.debug("-----------------------Reading MailBox -----------------------"+userId+" : "+password);
		try {
			logger.debug("-----------------------********************-----------------------");
			po3Properties.load(ReadEmailUtil.class.getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
			logger.debug("----------------------------------------------");
		} catch (IOException exception) {
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}*/
		  //Properties properties = new Properties();
		  Properties properties = System.getProperties();
		  logger.debug("-----------------------*****Creating EmailSession*****-----------------------"+SpringApplicationContext.schedulerProperty.getProperty(Constants.pop3Host)+"---"+SpringApplicationContext.schedulerProperty.getProperty(Constants.pop3Port));
		  //properties.put("mail.smtp.host", po3Properties.getProperty("smtpMailHost"));
		  //properties.put("mail.store.protocol", "pop3");
	      properties.put("mail.pop3.host", SpringApplicationContext.schedulerProperty.getProperty(Constants.pop3Host)  );
	      properties.put("mail.pop3.port", SpringApplicationContext.schedulerProperty.getProperty(Constants.pop3Port));
	      properties.put("mail.pop3.connectiontimeout", "300000");
	      properties.put("mail.pop3.timeout", "300000");
	     // properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
	      logger.debug("-----------------------Created EmailSession -----------------------");
	      //create the POP3 store object and connect with the pop server
	     // Store store = null;Folder emailFolder = null;
	     // Message[] messages = null ;
	     // Folder emailFolder= null;
	      Store store = null;
		try {
			
			logger.debug("-----------------------connecting to pop 3 store-----------------------");
			store = emailSession.getStore("pop3"); //pop3s
			logger.debug("-----------------------connecting to pop 3  2 time store-----------------------");
		    store.connect(SpringApplicationContext.schedulerProperty.getProperty(Constants.pop3Host).trim(),userId.trim(), password.trim());
		    logger.debug("-----------------------connected to pop 3 store-----------------------");
		  //create the folder object and open it
		   
		    // emailFolder = store.getFolder("INBOX");
		   // emailFolder.open(Folder.READ_WRITE);
		    logger.debug("-----------------------connected to pop 3 emailFolder-----------------------");
	       // messages = emailFolder.getMessages();
	        //logger.debug("No of Mails in MailBox -------------------:"+messages.length);
		} catch (NoSuchProviderException e) {
			logger.error("EXCEPTION TYPE :",e);
			e.printStackTrace();
			 logger.debug("-----------------------NoSuchProviderException ----------------------- " + e);
		} catch (MessagingException e) {
			logger.error("EXCEPTION TYPE :",e);
			e.printStackTrace();
			 logger.debug("-----------------------MessagingException ----------------------- " + e);
		}catch(Exception exception){
			 logger.error("EXCEPTION TYPE :",exception);
			 logger.debug("-----------------------exception ----------------------- " + exception);
		}finally{
			// try {
				 logger.debug("-----------------------Finally block of readMailBox -----------------------");
				//emailFolder.close(false);
				//store.close();
			//} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//} catch (MessagingException e) {
				
			//}
		}

		return store;
	}
	

}
