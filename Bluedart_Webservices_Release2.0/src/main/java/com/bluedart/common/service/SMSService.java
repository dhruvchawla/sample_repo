package com.bluedart.common.service;

import com.bluedart.exception.BlueDartException;

public interface SMSService {

	public String saveSMS( String responseId, String module) throws BlueDartException;
}
