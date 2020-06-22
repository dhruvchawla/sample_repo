/*package com.bluedart.scheduler;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.bluedart.common.dto.EmailContent;
import com.bluedart.notification.dao.NotificationDao;
import com.bluedart.notification.dto.NotificationDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.SpringApplicationContext;

 * @author CH848113
 * NotificationScheduler class is used to Notify the email's to recipients.
 * 
 * 
 
@Component
public class NotificationScheduler implements Job{
	private static final Logger logger = Logger.getLogger(NotificationScheduler.class);
	 public void execute(JobExecutionContext context)throws JobExecutionException {
		 NotificationDao notificationDao; 
	    	boolean notificationSent = false;
	    	logger.debug("----------Executeing NotificationScheduler----------");
	    	
	    	notificationDao = (NotificationDao) SpringApplicationContext.getBean("notificationDao");
	    	try{
	    		Properties emailNotificationProperties = new Properties();
		    	emailNotificationProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream(Constants.EMAIL_CONFIGURATION__PROPERTIES));
	    		
		    	List<NotificationDto> notificationList = notificationDao.getNotificationLog();
	    		
	    		EmailContent mailContent = null;
	    	
	    		if(!CollectionUtils.isEmpty(notificationList)){
	    			
	    		for(NotificationDto notificationDto:notificationList ){
	    			
	    		 mailContent = new EmailContent();
	    		 mailContent.setFrom(emailNotificationProperties.getProperty("fromEmailId"));
			     
				 String toIds = notificationDto.getToEmailId();
			     if(null != toIds && !toIds.isEmpty()){
			     List<String> listOfToIds =  Arrays.asList(toIds.split(";"));
			     
			     if(null != listOfToIds && listOfToIds.size() == 1)
			       	mailContent.setTo(toIds);
			     else if(null != listOfToIds && listOfToIds.size() >1)
			       	mailContent.setListOfCCAddress(listOfToIds);
			     }
			     String ccIds = notificationDto.getCcEmailId();
			     if(null != ccIds && !ccIds.isEmpty()){
			    	 List<String> listOfCcIds =  Arrays.asList(ccIds.split(";"));
			    
			     if(null != listOfCcIds && listOfCcIds.size() == 1)
			       	mailContent.setTo(ccIds);
			     else if(listOfCcIds!= null && listOfCcIds.size() >1)
			       	mailContent.setListOfCCAddress(listOfCcIds);
			     }
			    
			     String subject = notificationDto.getModuleName()+"."+notificationDto.getAction()+"."+"subject";
			     mailContent.setSubject(emailNotificationProperties.getProperty(subject));
			    
			     Map < String, Object > model = new HashMap<> ();
			     if(notificationDto.getModel() != null){
			    	 String[] notifyDetails = notificationDto.getModel().split(";");
			    	 if(notifyDetails!= null){
			    	 for(int j=0;j<notifyDetails.length;j++){
			    		 String[] keyvalues= notifyDetails[j].split("-");
			    		 if(keyvalues!= null)
			    		 model.put(keyvalues[0].trim(), keyvalues[1].trim());
			    	 }
			    	 mailContent.setModel(model);
			    	 }
			     }
			
			     String templateName = notificationDto.getModuleName()+"."+notificationDto.getAction()+"."+"template";
			     logger.debug("Template Name :"+emailNotificationProperties.getProperty(templateName));
		     try {
					notificationSent =  EmailUtil.sendEmailNotification(mailContent,emailNotificationProperties.getProperty(templateName));
				} catch (MessagingException e) {
					notificationSent = false;
		    		logger.debug("NotificationScheduler : Message is not Delivered.");
				}
		     logger.debug("NotificationScheduler : Is Message Delivered ? :"+notificationSent);
		        
	    	if(notificationSent){
	    		logger.debug("NotificationScheduler : Email is sent to recepient");
	    		model.clear();
	    		int returnValue = notificationDao.deleteNotificationLog(notificationDto.getLogId());
	    		if(returnValue == 0){
	    			logger.debug("NotificationScheduler : Email is sent to recepient and deleted from table");
	    		}
	    	}else{
	    		logger.debug("NotificationScheduler : Email is not Delivered.");
	    	}
	    	}
	    	}else{
	    		logger.debug("NotificationScheduler : There are no notification to be sent.");
	    	}
	    	}
	    	catch (IOException e1) {
	    		logger.debug("NotificationScheduler : Email is not Delivered.");
	    		
			}
	    	
	    	
	    }
}
*/