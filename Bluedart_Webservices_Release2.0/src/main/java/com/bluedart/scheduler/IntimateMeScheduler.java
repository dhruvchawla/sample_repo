package com.bluedart.scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluedart.common.dao.MISLogSchedulerDao;
import com.bluedart.exception.BlueDartException;
import com.bluedart.maildart.dto.MailDartDto;
import com.bluedart.maildart.service.MailDartService;
import com.bluedart.scheduler.util.ReadEmailUtil;
import com.bluedart.trackdart.daoImpl.TrackTraceValidator;
import com.bluedart.utils.Constants;
import com.bluedart.utils.SpringApplicationContext;
/*
 * @author CH848113
 */
@Component("IntimateMeScheduler")
public class IntimateMeScheduler {
	private static final Logger logger = Logger.getLogger(IntimateMeScheduler.class);
	//Properties properties = new Properties();
	private MailDartService mailDartService;
	private MISLogSchedulerDao misLogSchedulerDao;
	//private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	
	
	
	public void executeIntimateMeScheduler(){
		//Properties propertiesMain = new Properties();
    	String runFlag = "FALSE" ;
    	String runFlagScheduler = "FALSE" ;
    	runFlag = SpringApplicationContext.STARTSCHEDULER;
    	
    	if(runFlag.equals("TRUE")){
		//try{
    	//propertiesMain.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
			
		 String[] schedulers = SpringApplicationContext.schedulerProperty.getProperty(Constants.SCHEDULERS).split(Pattern.quote("$"));
    	
		 for(int i=0;i<schedulers.length;i++){
			 
			if(schedulers[i].equals("IntimateMeScheduler")){
				logger.debug("--------------------"+schedulers[i]+"--------------------");
				runFlagScheduler = SpringApplicationContext.schedulerProperty.getProperty(Constants.IntimateMeSchedulerRUNFLAG);
			}
			
			
		 }
		 
		 
		//}catch (IOException e) {
		//	 logger.debug("IOException :  in readSchedulerProperties method ");
				//throw new BlueDartException();
		//}
		 if(runFlag.equals("TRUE") && runFlagScheduler.equals("TRUE") )
		{
		
		
		
			 logger.debug("-------------------Executing IntimateMeScheduler-------------------");
		boolean isMailSent= false;
		String featureName = null;
		mailDartService = (MailDartService) SpringApplicationContext.getBean("mailDartService");
		try{
		//properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
		
		//if(properties != null){
			
			Store store = ReadEmailUtil.readMailBox(SpringApplicationContext.schedulerProperty.getProperty(Constants.intimateMeUser), SpringApplicationContext.schedulerProperty.getProperty(Constants.intimateMePassword));
			Folder emailFolder=store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			List<String> awbNumbers;
			List<String> listOfValidAwnNos;
			List<String> invalidNumbers;
			MailDartDto mailDartDto;
	    	if(null != messages && messages.length >0){
	    		  for(int i = 0; i < messages.length; i++) {
	    			  logger.debug("Waybill Query: \tMessage # " + (i+1) + " of " +  (messages.length) + "...");
	    			  mailDartDto = new MailDartDto();
	    			  mailDartDto.setFromMailId(SpringApplicationContext.schedulerProperty.getProperty(Constants.intimateMeFromAddr));
	    			 
	    			  String fromEmailId=null;
					  int startTag = messages[i].getFrom()[0].toString().indexOf("<");
		                if(startTag != -1) {
		                    int endTag = messages[i].getFrom()[0].toString().indexOf(">");
		                if(endTag != -1) {
		                	fromEmailId = messages[i].getFrom()[0].toString().substring(startTag + 1, endTag);
		                    }
		                }
		                
	    			  mailDartDto.setToEmailId(fromEmailId);
	    			  awbNumbers = new ArrayList<>();
					  listOfValidAwnNos = new ArrayList<>();
					  invalidNumbers = new ArrayList<>();

					  awbNumbers = getAwbNumbers(messages[i]);
					  
					  if(null != awbNumbers && !awbNumbers.isEmpty()){
						  listOfValidAwnNos = TrackTraceValidator.getListOfAwbNos(awbNumbers, invalidNumbers);
					  }
					  
					  
					  /*StringTokenizer tokenizedLine = new StringTokenizer(messages[i].getSubject() +" " +messages[i].getContent().toString(), ","); 
					  while (tokenizedLine.hasMoreTokens()) {
						  awbNumbers.add(tokenizedLine.nextToken().trim()); 
						} 
					  
					  if(null != awbNumbers && !awbNumbers.isEmpty()){
							  listOfValidAwnNos = TrackTraceValidator.getListOfAwbNos(awbNumbers, invalidNumbers);
					 }*/
					  mailDartDto.setInvalidAwbNumbers(invalidNumbers);
					  if(null != listOfValidAwnNos){
					  logger.info("valid awbNumbers ------------------------------ -:"+listOfValidAwnNos);
					  }
					  mailDartDto.setAwbNumbers(listOfValidAwnNos);
					  boolean isInserted = false;
						  if (null != fromEmailId) {
		    				  isInserted= mailDartService.intimateMe(mailDartDto);
						  }
	    				  if(isInserted){
	    						featureName = Constants.MAILDART_INTIMATEMESCHEDULER;
	    						saveMISLog(featureName,null,null,fromEmailId,String.join(",", listOfValidAwnNos));
	    						messages[i].setFlag(Flag.DELETED,true);
	    						logger.info("MailBox is read and details are inserted.");
	    						
	    					}else{
	    						messages[i].setFlag(Flag.DELETED,false);
	    						logger.info("No Mails to read in mail inbox.");
	    					}
	    		  }
	    	
	    	}else{
	    		logger.info("No Mails to read in mail inbox.");
	    	}

	    	
	    	boolean expunge = true;
			emailFolder.close(expunge);
			store.close();
		//}
		}catch(MessagingException exception){
			logger.error("EXCEPTION TYPE :",exception);
			logger.debug("MessagingException " + exception);
		}
		catch (Exception e1) {
			logger.error("EXCEPTION TYPE :",e1);
			e1.printStackTrace();
		}
		
    	try {
    		isMailSent =mailDartService.intimateMeDeliveredInfo();
		if(isMailSent){
			logger.info("IntimateMeScheduler : MailBox is read and sent status information mail to recepient");
		}else{
			logger.info("IntimateMeScheduler :No Mails to read in mail inbox.");
		}
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			isMailSent = false;
		}
		}
    	}
	}
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		misLogSchedulerDao = (MISLogSchedulerDao) SpringApplicationContext.getBean("misLogSchedulerDao");
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogSchedulerDao.saveMIS(featureName, loginId);
		}else if(featureName != null && emailId != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogSchedulerDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
	
	private List<String> getAwbNumbers(Message messageContent){
		 List<String> awbNumbers = new ArrayList<>(); 
		 
		 try {
			 String message = getContent(messageContent);
			 Pattern pattern =Pattern.compile( "[0-9]+");
				Matcher matcher =pattern.matcher(message);
				  while (matcher.find()) {
					  awbNumbers.add(matcher.group());
				  }
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
	return awbNumbers;
	}
		 
	private String getContent(Message message) throws MessagingException, IOException {
	    String messageContent = message.getSubject()+", ";
	    if (message.isMimeType("text/plain")) {
	        messageContent = messageContent+ message.getContent().toString();
	    } else if (message.isMimeType("multipart/*")) {
	        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	        messageContent = messageContent+ getTextFromMimeMultipart(mimeMultipart);
	    }
	   
	    return messageContent;
	}

	private String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String messageContent = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            messageContent = messageContent + "\n" + bodyPart.getContent();
	            break; 
	        } 
	        else if (bodyPart.getContent() instanceof MimeMultipart){
	        	  messageContent = messageContent + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return messageContent;
	}
	

}
