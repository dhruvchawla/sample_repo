package com.bluedart.pod.exception;

import org.apache.log4j.Logger;

/**
 * 
 * @author DH839598
 */
public class BusinessRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 8503412399410976733L;
	
	private static Logger logger = Logger.getLogger(BusinessRuntimeException.class);
	
	public BusinessRuntimeException(String exceptionMsg) {
		logger.error("BLUE DART :::::  BusinessException " + exceptionMsg);
	}

}