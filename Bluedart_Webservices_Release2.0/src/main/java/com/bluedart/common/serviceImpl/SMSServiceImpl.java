package com.bluedart.common.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.SMSServiceDao;
import com.bluedart.common.service.SMSService;
import com.bluedart.exception.BlueDartException;

@Service
public class SMSServiceImpl implements SMSService  {

	private static final Logger logger = Logger.getLogger(SMSServiceImpl.class);
	
	@Autowired
	private SMSServiceDao smsServiceDao;
	
	@Override
	public String saveSMS(String responseId, String module ) {
		return smsServiceDao.saveSMS(responseId, module);
	}
}
