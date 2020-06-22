package com.bluedart.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/*
 * @Author CH848113
 */
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext appContext;
	public static String STARTSCHEDULER = "FALSE";
	public static Properties schedulerProperty; 
	
		
    private SpringApplicationContext() {}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;
		int loglevel = 0;
		Properties prop = new Properties(); 
        InputStream inputStream = null;
        InputStream schedulerInputStream = null;
		try {
			// String path = "E:/bluedart_db/database.properties";
			// inputStream = new FileInputStream(new File(path));
			inputStream = new FileInputStream(new File(System.getProperty(Constants.DATABASE_PROPERTY)));
			//inputStream = new FileInputStream(new File("F:/PropertyFiles/C2PC.properties"));
			//inputStream = new FileInputStream(new File("F:/PropertyFiles/database.properties"));
			
			 if (inputStream != null) {
	              try {
	                    prop.load(inputStream);
	                    STARTSCHEDULER = prop.getProperty("STARTSCHEDULER");
	                    loglevel = Integer.parseInt(prop.getProperty("LOG_LEVEL"));
	                    
	              } catch (IOException e) {
	            	  System.out.println("*****Exception while loading database property*****");
	                    e.printStackTrace();
	              }
	        }
			 
			schedulerInputStream = new FileInputStream(new File(System.getProperty(Constants.scheduler_prop_file)));
			// schedulerInputStream = new FileInputStream(new File("F:/PropertyFiles/C2PC.properties"));
			 //schedulerInputStream = new FileInputStream(new File("F:/PropertyFiles/database.properties"));
			 if (schedulerInputStream != null) {
		            try {
		            	 schedulerProperty = new Properties();
		            	 schedulerProperty.load(schedulerInputStream);
		            	
		                
		                  
		            } catch (IOException e) {
		                 System.out.println("*****Exception while loading Scheduler property*****");
		                  e.printStackTrace();
		            }
		      }
						
			Logger root = Logger.getRootLogger();
			Enumeration allLoggers = root.getLoggerRepository().getCurrentCategories();
			 
			//set logging level of root and all logging instances in the system
			
			    root.setLevel(Level.ERROR);
			    while (allLoggers.hasMoreElements()){
			        Category tmpLogger = (Category) allLoggers.nextElement();
			        if(loglevel==0){
			        	 tmpLogger.setLevel(Level.ERROR);	
			        }else if(loglevel==1){
			       	 tmpLogger.setLevel(Level.INFO);	
			        }else if(loglevel==2){
				       	 tmpLogger.setLevel(Level.DEBUG);	
				     }else if(loglevel==3){
				       	 tmpLogger.setLevel(Level.OFF);	
				     }else if(loglevel==4){
				       	 tmpLogger.setLevel(Level.ALL);	
				     }else if(loglevel==5){
				       	 tmpLogger.setLevel(Level.TRACE);	
				     }else if(loglevel==6){
				       	 tmpLogger.setLevel(Level.WARN);	
				     }
			       
			    }
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

       
        
      
        
       
        
        
       
		

	}

	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}
	
/*	public String loadSchedulerProperty(String propertyName){
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
	}*/
	
	

}