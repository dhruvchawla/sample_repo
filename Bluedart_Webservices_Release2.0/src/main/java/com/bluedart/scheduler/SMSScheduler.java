package com.bluedart.scheduler;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluedart.exception.BlueDartException;
import com.bluedart.mobiledart.service.MobileDartService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.SpringApplicationContext;
/*
 * @author CH848113
 */
@Component("SMSScheduler")
public class SMSScheduler  {
	private static final Logger logger = Logger.getLogger(SMSScheduler.class);
	//private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	
	 private MobileDartService mobileDartService;
	 public void executeSmsScheduler() {
		 //Properties propertiesMain = new Properties();
	    	String runFlag = "FALSE" ;
	    	String runFlagScheduler = "FALSE" ;
	    	runFlag = SpringApplicationContext.STARTSCHEDULER;
    	 if(runFlag.equals("TRUE")){
	    	try{
	    	//propertiesMain.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
				
			 String[] schedulers = SpringApplicationContext.schedulerProperty.getProperty(Constants.SCHEDULERS).split(Pattern.quote("$"));
	    	
			 for(int i=0;i<schedulers.length;i++){
				 
				if(schedulers[i].equals("SMSScheduler")){
					logger.debug("--------------------"+schedulers[i]+"--------------------");
					runFlagScheduler = SpringApplicationContext.schedulerProperty.getProperty(Constants.SMSSchedulerRUNFLAG);
				}
				
				
			 }
			 
			 
			}catch (Exception e) {
				logger.error("EXCEPTION TYPE :",e);
				 logger.debug("IOException :  in readSchedulerProperties method ");
					//throw new BlueDartException();
			}
			 if(runFlag.equals("TRUE") && runFlagScheduler.equals("TRUE") )
			{
		 
		 
			 boolean messaheSent = false;
			 logger.debug("-------------------Executing SMSScheduler-------------------");
	    	
	    	mobileDartService = (MobileDartService) SpringApplicationContext.getBean("mobileDartService");
	    	messaheSent = isMessageSent();
	    	if(messaheSent){
	    		logger.debug("SMSScheduler :Delivered message is sent to recepient");
	    	}else{
	    		logger.debug("SMSScheduler : Message is not Delivered.");
	    	}
		}
	   }
    }
    
    private boolean isMessageSent(){
    	boolean isMessageSent =false;
    			try {
					 isMessageSent = mobileDartService.intimateMe();
				} catch (BlueDartException e) {
					logger.error("EXCEPTION TYPE :",e);
					throw new BlueDartException();
				   
				}
    			return isMessageSent;
    }
    			
}
