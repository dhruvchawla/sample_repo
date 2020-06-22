/*package com.bluedart.scheduler;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;

 * @author CH848113
 
public class SchedulerListener implements ServletContextListener {
        Scheduler scheduler = null;
        private static final Logger logger = Logger.getLogger(SchedulerListener.class);
        @Override
        public void contextInitialized(ServletContextEvent servletContext) {
        	
        	logger.debug("------------------------Context Initialized------------------------");
        		executeTask(scheduler);
            }
       
        @Override
        public void contextDestroyed(ServletContextEvent servletContext) {
                try 
                {
                	logger.debug("------------------------Context Destoryed------------------------");
                	
                    if(scheduler != null)
                    	scheduler.shutdown();
                } 
                catch (SchedulerException e) 
                {
                	throw new BlueDartException();
                }
        }
        
        private void executeTask(Scheduler scheduler){
        	logger.debug("------------------------Execute Task  Scheduler Listener------------------------");
        	String fileReadInterval = "0 0/1 * * * ?"; //S M H D E Y
        	Properties properties = new Properties();
        	String startSchedulerFlag = "FALSE" ;
	        	try {
					 properties.load(getClass().getClassLoader().getResourceAsStream(Constants.SCHEDULER_PROPERTIES));
					 fileReadInterval = properties.getProperty("FILEREADINTERVAL");
					 startSchedulerFlag = properties.getProperty("STARTSCHEDULER");
					 // Setup the Job class and the Job group
					if(startSchedulerFlag.equals("TRUE")){
					 try {
						 JobKey schedulerManagerJobKey = new JobKey("SchedulerManagerJob", "SchedulerManagerGroup");
						 JobDetail schedulerManagerJob = newJob(SchedulerManager.class).withIdentity(
								 schedulerManagerJobKey).build();
						

		            // Create a Trigger that fires every 1 minutes.
		            Trigger schedulerManagerTrigger = newTrigger()
		            .withIdentity("SchedulerManagerTrigger", "SchedulerManagerGroup")
		            .withSchedule(CronScheduleBuilder.cronSchedule(fileReadInterval)) //"0/5 * * * * ?"
		            .build();
					 
		            // Setup the Job and Trigger with Scheduler & schedule jobs
		           
						scheduler = new StdSchedulerFactory().getScheduler();
						scheduler.start();
						if(!scheduler.checkExists(schedulerManagerJobKey)){
							scheduler.scheduleJob(schedulerManagerJob, schedulerManagerTrigger);
						}else{
							scheduler.shutdown();
						}
					} catch (SchedulerException e) {
						throw new BlueDartException();
					}
				} 

				
        	} catch (IOException e1) {
        		throw new BlueDartException();
			}

        }
        
}*/