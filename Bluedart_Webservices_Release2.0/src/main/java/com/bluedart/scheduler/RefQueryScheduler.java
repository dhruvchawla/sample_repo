package com.bluedart.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;

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
@Component("RefQueryScheduler")
public class RefQueryScheduler{
	private static final Logger logger = Logger.getLogger(RefQueryScheduler.class);
	
	//Properties properties = new Properties();
	
	private MailDartService mailDartService;
	
	 // private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	
	private MISLogSchedulerDao misLogSchedulerDao;
	
	public void executeRefQueryScheduler() {
		
		//Properties propertiesMain = new Properties();
    	String runFlag = "FALSE" ;
    	String runFlagScheduler = "FALSE" ;
    	runFlag = SpringApplicationContext.STARTSCHEDULER;
   	 if(runFlag.equals("TRUE")){
    	//try{
    	//propertiesMain.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
			
		 String[] schedulers = SpringApplicationContext.schedulerProperty.getProperty(Constants.SCHEDULERS).split(Pattern.quote("$"));
    	
		 for(int i=0;i<schedulers.length;i++){
			 
			if(schedulers[i].equals("RefQueryScheduler")){
				logger.debug("--------------------"+schedulers[i]+"--------------------");
				runFlagScheduler =SpringApplicationContext.schedulerProperty.getProperty(Constants.RefQuerySchedulerRUNFLAG);
			}
			
			
		 }
		 
		 
		//}catch (IOException e) {
		//	 logger.debug("IOException :  in readSchedulerProperties method ");
				//throw new BlueDartException();
		//}
		 if(runFlag.equals("TRUE") && runFlagScheduler.equals("TRUE") )
		{
		
		
			 logger.debug("-------------------Executing RefQueryScheduler-------------------");
		boolean readAndSendMail= false;
		String featureName = null;
		mailDartService = (MailDartService) SpringApplicationContext.getBean("mailDartService");
		try {
		//properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
		//if(null != properties){
			
			Store store = ReadEmailUtil.readMailBox(SpringApplicationContext.schedulerProperty.getProperty(Constants.refUser), SpringApplicationContext.schedulerProperty.getProperty(Constants.refPassword));
			Folder emailFolder=store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message[] messages = emailFolder.getMessages();
			
				if(null != messages && messages.length >0){
					 for(int i = 0; i < messages.length; i++) {
						
						  MailDartDto mailDartDto = new MailDartDto();
						  mailDartDto.setFromMailId(SpringApplicationContext.schedulerProperty.getProperty(Constants.refFromAddr));
						  String fromEmailId=null;
						  int startTag = messages[i].getFrom()[0].toString().indexOf("<");
			                if(startTag != -1) {
			                    int endTag = messages[i].getFrom()[0].toString().indexOf(">");
			                if(endTag != -1) {
			                	fromEmailId = messages[i].getFrom()[0].toString().substring(startTag + 1, endTag);
			                    }
			                }
						  logger.debug("fromEmailId " + fromEmailId);
						  mailDartDto.setToEmailId(fromEmailId);
						 // List<String> refNumbers = getValidRefNumbers(messages[i].getSubject() +","+ messages[i].getContent().toString() );
						  List<String> refNumbers = getValidRefNumbers(messages[i].getSubject());
						  logger.debug("Reference Number set-----------------"+refNumbers);
						  mailDartDto.setRefNumbers(refNumbers);
						  try {
							if (null != fromEmailId) {
								readAndSendMail= mailDartService.trackByRef(mailDartDto);
							  }
							
							
							if(readAndSendMail){
								featureName = Constants.MAILDART_REFQUERYSCHEDULER;
								saveMISLog(featureName,null,null,fromEmailId,String.join(",", refNumbers));
								messages[i].setFlag(Flag.DELETED,true);
								logger.debug("Deleteing the mail "+messages[i].getFrom()[0]+" from Inbox :");
								logger.debug("MailBox is read and sent status information mail to recepient");
				    			logger.debug("RefQueryScheduler : MailBox is read and sent status information mail to recepient");
							}else{
								messages[i].setFlag(Flag.DELETED,false);
								logger.debug("No Mails to read in mail inbox.");
				    			logger.debug("RefQueryScheduler :No Mails to read in mail inbox.");
							}
						  } catch (BlueDartException e) {
							  logger.error("EXCEPTION TYPE :",e);
							e.printStackTrace();
						  } 
			  			
						 } 
	    	}else{
	    		logger.debug("No Mails to read in mail inbox.");
	    	}
				boolean expunge = true;
				emailFolder.close(expunge);
				store.close();
			
		//}
		}catch (MessagingException e) {
			readAndSendMail = false;
			e.printStackTrace();
			logger.error("EXCEPTION TYPE :",e);
		}catch (Exception e1) {
			e1.printStackTrace();
			logger.error("EXCEPTION TYPE :",e1);
		} /*catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
			logger.error("Unexpected Error.");
		}
*/		}
    	 }
	}
	

	private List<String> getValidRefNumbers(String message) {
		List<String> refNumbers = new ArrayList<>();
		List<String> validRefNumbers = new ArrayList<>();
		StringTokenizer tokenizedLine = new StringTokenizer(message, ","); 
		
		while (tokenizedLine.hasMoreTokens()) {
			 refNumbers.add(tokenizedLine.nextToken().trim()); 
		}
		  logger.debug("refNumbers-Before------------------------"+validRefNumbers);
		  if(refNumbers != null && !refNumbers.isEmpty()){
			  validRefNumbers = TrackTraceValidator.getListOfRefNos(refNumbers);
		  }
		  logger.debug("List of valid reference number-------------------------"+validRefNumbers);
		  return validRefNumbers;
		
	}
	
	//Saving in to MIS Log
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
}
