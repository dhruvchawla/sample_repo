package com.bluedart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
/**
 * 
 * @author PR334023
 * Class to load properties from C2PC.properties file
 *
 */
@Component
public class C2PCPropertiesLoader {
	
	private static final Logger propLogger = Logger.getLogger(C2PCPropertiesLoader.class);
	
	public String loadC2PCProperty(String propertyName){
		propLogger.info("C2PCPropertiesLoader: loadC2PCProperty "+propertyName);
		InputStream inputStrm = null;
	    Properties prop = null;
	    String propertyVal = null;
	    try {
	        prop = new Properties();
	        inputStrm = new FileInputStream(new File("F:/PropertyFiles/C2PC.properties"));
	         //inputStrm = new FileInputStream(new File(System.getProperty(C2PCConstants.c2pc_prop_file)));
	        prop.load(inputStrm);
	        propertyVal = prop.getProperty(propertyName); 
	    } catch (FileNotFoundException e) {
	    	propLogger.error("Exception occurred while loading C2PC properties "+e.getMessage());
	    } catch (IOException e) {
	    	propLogger.error("Exception occurred while loading C2PC properties "+e.getMessage());
	    }
	    return propertyVal;
	}

}
