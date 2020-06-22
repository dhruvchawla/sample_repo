package com.bluedart.contactus.serviceImpl;

import java.net.ConnectException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.webservice.ContactUsHandler;
import com.bluedart.contactus.dao.ContactUsDao;
import com.bluedart.contactus.dto.ContactUsDto;
import com.bluedart.contactus.dto.CustomerFeedbackRequestDto;
import com.bluedart.contactus.service.ContactUsService;

/**
 * @author CH848113 
 * This is Service class for Complaint,appreciation and write to us;
 */
@Service
public class ContactUsServiceImpl implements ContactUsService {

	private static final Logger logger = Logger.getLogger(ContactUsServiceImpl.class);
	
	@Autowired
	private ContactUsHandler contactUsHandler;
	
	@Autowired
	private ContactUsDao contactUsDao;

	@Override
	public ContactUsDto updateCustomerFeedback(CustomerFeedbackRequestDto customerFeedback) throws ConnectException, RemoteException {
		logger.debug("ContactUsServiceImpl : updateCustomerFeedback");
		return contactUsHandler.updateCustomerFeedback(customerFeedback);
	}

	@Override
	public ContactUsDto getFeedBackReason(String feedBackType) throws RemoteException {
		logger.debug("ContactUsServiceImpl : getFeedBackReason"+feedBackType);
		return contactUsHandler.getFeedBackReason(feedBackType);
	}

	@Override
	public ContactUsDto isEmailSent(CustomerFeedbackRequestDto customerFeedback) {
		logger.debug("ContactUsServiceImpl : isEmailSent");
		return contactUsHandler.isEmailSent(customerFeedback);
	}

	@Override
	public Boolean isValidWayBillNo(String awbNo) {
		logger.debug("ContactUsServiceImpl : isValidWayBillNo");
		return contactUsDao.isValidWayBillNo(awbNo);
	}

}
