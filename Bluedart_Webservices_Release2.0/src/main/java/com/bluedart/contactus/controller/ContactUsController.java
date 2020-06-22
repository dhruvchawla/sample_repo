package com.bluedart.contactus.controller;

/**
 * @author CH848113
 */
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.contactus.dto.ContactUsDto;
import com.bluedart.contactus.dto.CustomerFeedbackRequestDto;
import com.bluedart.contactus.service.ContactUsService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;

/**
 * @author CH848113
 * This Class is used to process the Customer feed back data for complaint and appreciation. 
 */

@RestController
public class ContactUsController {
	
	private static final Logger logger = Logger.getLogger(ContactUsController.class);

	
	@Autowired
	private ContactUsService contactUsService;
	
	/*
	 * This method is used to update the customer feed back request for complaint and appreciation.
	 */
	@RequestMapping(value = "/contactus/feedbackrequest", method = RequestMethod.POST)
	public ContactUsDto updateCustomerFeedback(@RequestBody CustomerFeedbackRequestDto customerFeedback)
			throws RemoteException,  java.net.ConnectException{
		logger.debug("----------ContactUsController Complaint or Appreciation----------");
		ContactUsDto contactUsDto = contactUsService.updateCustomerFeedback(customerFeedback);
		contactUsDto.setStatusCode(Constants.SUCESSCODE);
		contactUsDto.setStatusMessage(Constants.SUCESSMESSAGE);
		return contactUsDto;
	}

	/*
	 * This method is used to update the customer feed back request for complaint and appreciation for mobile team.
	 */
	@RequestMapping(value = "/contactus/feedbackrequest/{waybillNumber}/{feedbackType}/{feedbackBy}/{feedbackDescription}/{destinationArea}/{contactNumber}/{customerName}/{customerEmailId}/{feedbackReason}/{feedbackRefno}/{employeeName}/{ipAddress}/{loginId}/{locationName}/{pinCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ContactUsDto updateCustomerFeedback(@PathVariable String waybillNumber,@PathVariable String feedbackType,@PathVariable String feedbackBy,@PathVariable String feedbackDescription,@PathVariable String destinationArea,@PathVariable String contactNumber,@PathVariable String customerName,@PathVariable String customerEmailId,@PathVariable String feedbackReason,@PathVariable String feedbackRefno,@PathVariable String employeeName,@PathVariable String ipAddress,@PathVariable String loginId, @PathVariable String locationName, @PathVariable String pinCode)
			throws RemoteException,  java.net.ConnectException{
		logger.debug("----------ContactUsController Complaint or Appreciation----------");
		String waybillNumber1 = "null".equalsIgnoreCase(waybillNumber)?"":waybillNumber;
		CustomerFeedbackRequestDto customerFeedback = new CustomerFeedbackRequestDto();
		customerFeedback.setWaybillNumber(waybillNumber1);
		customerFeedback.setFeedbackType(feedbackType);
		customerFeedback.setFeedbackBy(feedbackBy);
		customerFeedback.setFeedbackDescription(feedbackDescription);
		customerFeedback.setDestinationArea(destinationArea);
		customerFeedback.setContactNumber(contactNumber);
		customerFeedback.setCustomerName(customerName);
		customerFeedback.setCustomerEmailId(customerEmailId);
		customerFeedback.setFeedbackReason(feedbackReason);
		customerFeedback.setFeedbackRefno(feedbackRefno);
		customerFeedback.setEmployeeName(employeeName);
		customerFeedback.setIpAddress(ipAddress);
		customerFeedback.setLoginId(loginId);
		customerFeedback.setLocationName(locationName);
		customerFeedback.setPinCode(pinCode);
		ContactUsDto contactUsDto = contactUsService.updateCustomerFeedback(customerFeedback);
		contactUsDto.setStatusCode(Constants.SUCESSCODE);
		contactUsDto.setStatusMessage(Constants.SUCESSMESSAGE);
		return contactUsDto;
	}
   
	/*
	 * This method is used to get all the feed back reasons from caress based on feed back type i.e complaint or appreciation.
	 * 
	 */
	@RequestMapping(value = "/contactus/feedbackreason/{feedBackType}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ContactUsDto getFeedBackReason(@PathVariable String feedBackType) throws  RemoteException {
		logger.debug("feedBackType------------------------"+feedBackType);
		ContactUsDto contactUsDto = contactUsService.getFeedBackReason(feedBackType);
		contactUsDto.setStatusCode(Constants.SUCESSCODE);
		contactUsDto.setStatusMessage(Constants.SUCESSMESSAGE);

		return contactUsDto;
	}
	
	
	@RequestMapping(value = "/contactus/isvalidwaybillno/{awbNo}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Boolean isValidWayBillNo(@PathVariable String awbNo) throws  RemoteException {
		return contactUsService.isValidWayBillNo(awbNo);
	}

	/*
	 * This method is used process the write to us functionality for mobile team;
	 */
	@RequestMapping(value = "/contactus/writetousrequest/{waybillNumber}/{feedbackType}/{feedbackBy}/{feedbackDescription}/{destinationArea}/{contactNumber}/{customerName}/{customerEmailId}/{feedbackReason}/{feedbackRefno}/{employeeName}/{ipAddress}/{loginId}/{locationName}/{pinCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ContactUsDto isEmailSent(@PathVariable String waybillNumber,@PathVariable String feedbackType,@PathVariable String feedbackBy,@PathVariable String feedbackDescription,@PathVariable String destinationArea,@PathVariable String contactNumber,@PathVariable String customerName,@PathVariable String customerEmailId,@PathVariable String feedbackReason,@PathVariable String feedbackRefno,@PathVariable String employeeName,@PathVariable String ipAddress,@PathVariable String loginId, @PathVariable String locationName, @PathVariable String pinCode){
		logger.debug("----------ContactUsController WriteToUs----------");
		String waybillNumber1 = "null".equalsIgnoreCase(waybillNumber)?"":waybillNumber;
		CustomerFeedbackRequestDto customerFeedback = new CustomerFeedbackRequestDto();
		customerFeedback.setWaybillNumber(waybillNumber1);
		customerFeedback.setFeedbackType(feedbackType);
		customerFeedback.setFeedbackBy(feedbackBy);
		customerFeedback.setFeedbackDescription(feedbackDescription);
		customerFeedback.setDestinationArea(destinationArea);
		customerFeedback.setContactNumber(contactNumber);
		customerFeedback.setCustomerName(customerName);
		customerFeedback.setCustomerEmailId(customerEmailId);
		customerFeedback.setFeedbackReason(feedbackReason);
		customerFeedback.setFeedbackRefno(feedbackRefno);
		customerFeedback.setEmployeeName(employeeName);
		customerFeedback.setIpAddress(ipAddress);
		customerFeedback.setLoginId(loginId);
		customerFeedback.setLocationName(locationName);
		customerFeedback.setPinCode(pinCode);	
		ContactUsDto contactUsDto = contactUsService.isEmailSent(customerFeedback);
		contactUsDto.setStatusCode(Constants.SUCESSCODE);
		contactUsDto.setStatusMessage(Constants.SUCESSMESSAGE);
		return contactUsDto;
	}
	
	/*
	 * This method is used process the write to us functionality;
	 */
	@RequestMapping(value = "/contactus/writetousrequest", method = RequestMethod.POST)
	public ContactUsDto isEmailSent(@RequestBody CustomerFeedbackRequestDto customerFeedback) {
		logger.debug("----------ContactUsController WriteToUs----------");
		ContactUsDto contactUsDto = contactUsService.isEmailSent(customerFeedback);
		contactUsDto.setStatusCode(Constants.SUCESSCODE);
		contactUsDto.setStatusMessage(Constants.SUCESSMESSAGE);
		return contactUsDto;
	}
	
	@ExceptionHandler(DataBaseException.class) 
	private ContactUsDto myError(BlueDartException serviceException) {
		ContactUsDto contactUsDto = new ContactUsDto();
		contactUsDto.setStatusCode(serviceException.getErrorCode());
		contactUsDto.setStatusMessage(serviceException.getErrorMessage());
	    return contactUsDto;
	}
	
	
	@ExceptionHandler(BlueDartException.class)
	private ContactUsDto emailServiceError(BlueDartException serviceException) {
		ContactUsDto contactUsDto = new ContactUsDto();
		contactUsDto.setStatusCode(serviceException.getErrorCode());
		contactUsDto.setStatusMessage(serviceException.getErrorMessage());
	    return contactUsDto;
	}
	

}
