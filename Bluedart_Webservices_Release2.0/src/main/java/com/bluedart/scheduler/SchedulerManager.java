/*package com.bluedart.scheduler;

import static org.quartz.JobBuilder.newJob;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import com.bluedart.common.dto.SchedulerDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;

 * @author CH848113
 

@Component
public class SchedulerManager implements Job {
	Scheduler scheduler =null;
	HashMap<String,SchedulerDto> map;
	private static final Logger logger = Logger.getLogger(SchedulerListener.class);
        public void execute(JobExecutionContext context)throws JobExecutionException {
        	logger.debug("-----------------Execute the Scheduler Manager-------------------------------");
        	readSchedulerProperties();
        }

        private void  readSchedulerProperties(){
        	
        	
        	Properties properties = new Properties();
        	String runFlag = "FALSE" ;
        	map = new HashMap<>();
          	
        	try {
        		
    			 properties.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
    			
    			 runFlag = properties.getProperty("MANAGERRUNFLAG");
    			 String[] schedulers = properties.getProperty("SCHEDULERS").split(Pattern.quote("$"));
    			 SchedulerDto schedulerDto ;
    			 for(int i=0;i<schedulers.length;i++){
    				 
    				 schedulerDto = new SchedulerDto();
    				 schedulerDto.setSchedulerName(schedulers[i]);
    				 if(properties.getProperty(schedulers[i]+"INTERVAL")!= null)
    					 schedulerDto.setSchedulerInterval(properties.getProperty(schedulers[i]+"INTERVAL"));
    				 if(properties.getProperty(schedulers[i]+"RUNFLAG")!= null)
    					 schedulerDto.setSchedulerRunFlag(properties.getProperty(schedulers[i]+"RUNFLAG"));
    				 schedulerDto.setSchedulerGroup(schedulers[i]+"Group");
    				 schedulerDto.setSchedulerJob(schedulers[i]+"Job");
    				 schedulerDto.setSchedulerTrigger(schedulers[i]+"Trigger");
    				 if(properties.getProperty(schedulers[i]+"RUNFLAG")!= null  && properties.getProperty(schedulers[i]+"RUNFLAG").equals("TRUE")){
    					 map.put(schedulers[i],schedulerDto);
    				 }
    			 }
    			
    			 if(runFlag.equals("TRUE")){
    				 executeSchedulers(map);
    			 }else{
    				 map.clear();
    			 }
        	}
    			 catch (IOException e) {
					 logger.debug("IOException :  in readSchedulerProperties method ");
						//throw new BlueDartException();
				}
        	
				
				
        }	
			
        
        private void executeSchedulers(HashMap<String,SchedulerDto> map){
        	
        	    Iterator itr=map.entrySet().iterator();  
        	    while(itr.hasNext()){  
        	        Map.Entry entry=(Map.Entry)itr.next();  
        	       
        	switch (entry.getKey().toString()) {
	        	case "NotificationScheduler" :  {
	          		SchedulerDto schedulerDto = map.get("NotificationScheduler");
				 try {
					 if(schedulerDto.getSchedulerRunFlag() != null && schedulerDto.getSchedulerRunFlag().equals("TRUE")){
						 schedulerExecution(schedulerDto,NotificationScheduler.class);
						 logger.debug("-----------------Execute the NotificationScheduler-------------------------------");
					}else{
						if(scheduler != null)
						scheduler.shutdown();
					}
					
				 }
			   catch (SchedulerException e) {
				   logger.debug("-----------------Execute the NotificationScheduler-------------------------------");
				  // throw new BlueDartException();
			   }
				 break;
	          } 
	         case "SMSScheduler" :  {
            		SchedulerDto schedulerDto = map.get("SMSScheduler");
  			 try {
				 if(schedulerDto.getSchedulerRunFlag() != null &&schedulerDto.getSchedulerRunFlag().equals("TRUE")){
					 schedulerExecution(schedulerDto,SMSScheduler.class);
					 logger.debug("-----------------Execute the SMSScheduler-------------------------------");
				}else{
					if(scheduler != null)
					scheduler.shutdown();
				}
				
			 }
			   catch (SchedulerException e) {
				   
				   logger.debug("Execute Schedulers Exception - SMSScheduler :   " + e);
				   //throw new BlueDartException();
			   }
			 break;
            } 
	         
	         	case "AwbQueryScheduler" :  {
	            	SchedulerDto schedulerDto = map.get("AwbQueryScheduler");
	            	 try {
	     				if(schedulerDto.getSchedulerRunFlag() != null &&schedulerDto.getSchedulerRunFlag().equals("TRUE")){
	        				schedulerExecution(schedulerDto,AwbQueryScheduler.class);
	        				logger.debug("-----------------Execute the AwbQueryScheduler-------------------------------");
	         			}else{
	         				
	         				if(scheduler != null)
	    					scheduler.shutdown();
	    				}
	            }
	            	 catch (SchedulerException e) {
	            		 
	            		 logger.debug("Execute Schedulers Exception - AwbQueryScheduler :   " + e);
	            		// throw new BlueDartException();
	     		   }
	     			 break;
	        	}
	            case "RefQueryScheduler" :  {
	            	SchedulerDto schedulerDto = map.get("RefQueryScheduler");
	            	 try {
	     				if(schedulerDto.getSchedulerRunFlag() != null &&schedulerDto.getSchedulerRunFlag().equals("TRUE")){
	        				schedulerExecution(schedulerDto,RefQueryScheduler.class);
	        				logger.debug("-----------------Execute the RefQueryScheduler-------------------------------");
	         			}else{
	         				
	         				if(scheduler != null)
	    					scheduler.shutdown();
	    				}
	            }
	            	 catch (SchedulerException e) {
	            		
	            		 logger.debug("Execute Schedulers Exception - RefQueryScheduler:   " + e);
	            		 //throw new BlueDartException();
	     		   }
	     			 break;
	        	}
	            
	            case "IntimateMeScheduler" :  {
	            	SchedulerDto schedulerDto = map.get("IntimateMeScheduler");
	            	 try {
	     				if(schedulerDto.getSchedulerRunFlag() != null &&schedulerDto.getSchedulerRunFlag().equals("TRUE")){
	        				schedulerExecution(schedulerDto,IntimateMeScheduler.class);
	        				logger.debug("-----------------Execute the IntimateMeScheduler-------------------------------");
	         			}else{
	         				
	         				if(scheduler != null)
	    					scheduler.shutdown();
	    				}
	            }
	            	 catch (SchedulerException e) {
	            		
	            		 logger.debug("Execute Schedulers Exception - IntimateMeScheduler:   " + e);
	            		 //throw new BlueDartException();
	     		   }
	     			 break;
	        	} 
	            
	            case "AutoPODScheduler" :  {
	            	SchedulerDto schedulerDto = map.get("AutoPODScheduler");
	            	 try {
	     				if(schedulerDto.getSchedulerRunFlag() != null &&schedulerDto.getSchedulerRunFlag().equals("TRUE")){
	        				schedulerExecution(schedulerDto,AutoPODScheduler.class);
	        				logger.debug("-----------------Execute the AutoPODScheduler-------------------------------");
	         			}else{
	         				if(scheduler != null)
	    					scheduler.shutdown();
	    				}
	            }
	            	 catch (SchedulerException e) {
	            		 logger.debug("Execute Schedulers Exception - AutoPODScheduler:   " + e);
	            		// throw new BlueDartException();
	     		   }
	     			 break;
	        	} 
           
		 }
        }
        }
        
        
        private void schedulerExecution(SchedulerDto schedulerDto,Class schedulerClass){
        	try{
        		logger.debug("-----------------Executeing  the schedulerExecution in Scheduler Manager-------------------------------");
			 JobKey jobKey = new JobKey(schedulerDto.getSchedulerJob(), schedulerDto.getSchedulerGroup());
			 JobDetail jobDetail = newJob(schedulerClass).withIdentity(
					 jobKey).build();
		     Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(schedulerDto.getSchedulerTrigger(), schedulerDto.getSchedulerGroup())
				.withSchedule(
					CronScheduleBuilder.cronSchedule(schedulerDto.getSchedulerInterval()))
				.build();
			scheduler = new StdSchedulerFactory().getScheduler();
			
			scheduler.start();
			
			if(!scheduler.checkExists(jobKey)){
				
				scheduler.scheduleJob(jobDetail, trigger);
				
			}else{
					
				
				if(scheduler != null){
					scheduler.shutdown();
		}
	}
      
        } catch (SchedulerException e) {
        	
        	 logger.debug("Execute Schedulers Exception :   " + e);
        	throw new BlueDartException();	
		   }
        }  
}
*/