package com.bluedart.contactus.service;

import java.net.ConnectException;
import java.rmi.RemoteException;

import com.bluedart.contactus.dto.ContactUsDto;
import com.bluedart.contactus.dto.CustomerFeedbackRequestDto;

/**
 * @author CH848113
 */

public interface ContactUsService {

	public ContactUsDto updateCustomerFeedback(CustomerFeedbackRequestDto customerFeedback) throws ConnectException,  RemoteException;

	public ContactUsDto getFeedBackReason(String feedBackType) throws RemoteException;

	public ContactUsDto isEmailSent(CustomerFeedbackRequestDto customerFeedback);
	
	public Boolean isValidWayBillNo(String awbNo);
	
	
}
