package com.bluedart.scheduler;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.bluedart.autopod.service.AutoPodMailSchedulerService;

import com.bluedart.utils.SpringApplicationContext;
/*
 * @author VELAYUTHAM
 */
@Component
public class AutoPODScheduler implements Job{
	private static final Logger logger = Logger.getLogger(AutoPODScheduler.class);
	Properties properties = new Properties();
	private AutoPodMailSchedulerService autoPodMailSchedulerService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("-------------------AutoPODScheduler Job Scheduler Start -------------------");
		autoPodMailSchedulerService = (AutoPodMailSchedulerService) SpringApplicationContext.getBean("autoPodMailSchedulerService");
		autoPodMailSchedulerService.getPodmailTDetails();
		
		logger.info("--------------------AutoPODScheduler Job Scheduler Ends-------------------");
	}
}
