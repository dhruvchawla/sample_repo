/*package com.bluedart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
*//**
 * 
 * @author CH848113
 * Class to load properties from scheduler.properties file
 *
 *//*
@Component
public class SchedulerPropertiesLoader {
	
	private static final Logger propLogger = Logger.getLogger(SchedulerPropertiesLoader.class);
	
	public String loadSchedulerProperty(String propertyName){
		propLogger.debug("Scheduler Properties Loader:  "+propertyName);
		InputStream inputStrm = null;
	    Properties prop = null;
	    String propertyVal = null;
	    try {
	        prop = new Properties();
	        inputStrm = new FileInputStream(new File(System.getProperty(Constants.scheduler_prop_file)));
	        prop.load(inputStrm);
	        propertyVal = prop.getProperty(propertyName); 
	    } catch (FileNotFoundException e) {
	    	propLogger.error("Exception occurred while loading schedulers properties "+e.getMessage());
	    } catch (IOException e) {
	    	propLogger.error("Exception occurred while loading schedulers properties "+e.getMessage());
	    }
	    return propertyVal;
	}

}
*/