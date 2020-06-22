package com.bluedart.common.webservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.ArrayOfstring;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.CustomerFeedbackRequest;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.CustomerFeedbackResponse;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.GetFeedbackReasonDetails;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.GetFeedbackReasonDetailsResponse;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.GetFeedbackReasonRequest;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.GetFeedbackReasonResponse;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.UpdateCustomerFeedback;
import com.bluedart.common.webservice.CustomerFeedbackServiceStub.UpdateCustomerFeedbackResponse;
import com.bluedart.contactus.dao.ContactUsDao;
import com.bluedart.contactus.dto.ContactUsDto;
import com.bluedart.contactus.dto.CustomerFeedbackRequestDto;
import com.bluedart.contactus.dto.CustomerFeedbackResponseDto;
import com.bluedart.contactus.dto.FeedBackReasonDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.FeedBackReasonComparatorUtil;

/**
 * @author CH848113
 * Class is used to call the Caress web service and submit the customer feed back request for complaint and appreciation. 
 */
@Component 
public class ContactUsHandler {
	//protected static final Log logger = LogFactory.getLog("ContactUsHandler");
	private static final Logger logger = Logger.getLogger(ContactUsHandler.class);
	private String featureName = null;
	@Autowired
	private MISLogDao misLogDao;
	
	@Autowired
	private ContactUsDao contactUsDao;
	
	// Method is used for customer feed back i.e Complaint & Appreciation, it will call 3rd party caress webservice to submit.
	public ContactUsDto updateCustomerFeedback(CustomerFeedbackRequestDto customerFeedback) throws RemoteException{
		ContactUsDto contactUsDto = new ContactUsDto();
	try{
		logger.debug("ContactUsHandler for Complaint & Appreciation");
		CustomerFeedbackRequest customerFeedbackRequest = new CustomerFeedbackRequest();
		Date systemCurrentDate = new Date();
		String sysDate = DateUtil.formatDateToStringGivenFormat(systemCurrentDate, "dd-MMM-YYYY");
		String sysTime = DateUtil.formatDateToStringGivenFormat(systemCurrentDate, "HHmm");
			
			customerFeedbackRequest.setCustomerName(customerFeedback.getCustomerName());
			customerFeedbackRequest.setFeedbackRefno(customerFeedback.getEmployeeName()); // need to be changed
			customerFeedbackRequest.setCustomerEmailID(customerFeedback.getCustomerEmailId());
			
			String locationCode = null;
			
			locationCode = getLocation(customerFeedback.getLocationName(),customerFeedback.getPinCode());
		
			logger.debug("locationCode-----------------------"+locationCode);
			customerFeedbackRequest.setDestinationArea(locationCode);
			customerFeedbackRequest.setTelephoneNumber(customerFeedback.getContactNumber());
			
			String[] wayBillNumber =customerFeedback.getWaybillNumber().split(",");
			
			for(String awb:wayBillNumber){
				logger.debug("WaybillNumber :"+awb);
			}
			
			ArrayOfstring wayBillArray = new ArrayOfstring();
			wayBillArray.setString(wayBillNumber);
			customerFeedbackRequest.setWaybillNumber(wayBillArray);
			
			customerFeedbackRequest.setFeedbackreason(customerFeedback.getFeedbackReason());
			customerFeedbackRequest.setFeedbackType(customerFeedback.getFeedbackType());
			
			customerFeedbackRequest.setCommitCallbackDate(Calendar.getInstance()); //2016-09-22 	
			customerFeedbackRequest.setCommitCallbackTime(sysTime);//0911
			
			customerFeedbackRequest.setFeedbackDate(sysDate);
			customerFeedbackRequest.setFeedbackTime(sysTime);
			customerFeedbackRequest.setFeedbackLetterDate(sysDate);
			
			
			if(Constants.CONTACTUS_COMPLAINT.equals(customerFeedback.getFeedbackType())){
				featureName = Constants.CONTACTUS_FEEDBACK_COMPLAINT;
			if(Constants.CONTACTUS_NOT_IDENTIFIED.equals(customerFeedback.getFeedbackBy())){
				customerFeedbackRequest.setFeedbackBy(Constants.CONTACTUS_SHIPPER);
				customerFeedbackRequest.setFeedbackGist("Complaint By : Third Party "+customerFeedback.getFeedbackDescription());
			}else{
				customerFeedbackRequest.setFeedbackBy(customerFeedback.getFeedbackBy());
				customerFeedbackRequest.setFeedbackGist(customerFeedback.getFeedbackDescription());
			}
			}else if(Constants.CONTACTUS_APPRECIATION.equals(customerFeedback.getFeedbackType())){
				featureName = Constants.CONTACTUS_FEEDBACK_APPRECIATION;
				if(Constants.CONTACTUS_NOT_IDENTIFIED.equals(customerFeedback.getFeedbackBy())){
					customerFeedbackRequest.setFeedbackBy(Constants.CONTACTUS_SHIPPER);
					customerFeedbackRequest.setFeedbackGist("Appreciation By : Third Party "+customerFeedback.getFeedbackDescription());
				}else{
					customerFeedbackRequest.setFeedbackBy(customerFeedback.getFeedbackBy());
					customerFeedbackRequest.setFeedbackGist(customerFeedback.getFeedbackDescription());
				}
			}	
			
			logger.debug("--------------------Inputs to Caress--------------------");
			
			logger.debug("CustomerName	: "+customerFeedbackRequest.getCustomerName());
			logger.debug("FeedbackRefno	:"+customerFeedbackRequest.getFeedbackRefno());
			logger.debug("CustomerEmailID :"+customerFeedbackRequest.getCustomerEmailID());
			logger.debug("DestinationArea :"+customerFeedbackRequest.getDestinationArea());
			logger.debug("TelephoneNumber	:"+customerFeedbackRequest.getTelephoneNumber());
			logger.debug("Feedbackreason 	:"+customerFeedbackRequest.getFeedbackreason());
			logger.debug("FeedbackType	:"+customerFeedbackRequest.getFeedbackType());
			logger.debug("CommitCallbackDate	:"+customerFeedbackRequest.getCommitCallbackDate());
			logger.debug("CommitCallbackTime	:"+customerFeedbackRequest.getCommitCallbackTime());
			logger.debug("FeedbackDate	:"+customerFeedbackRequest.getFeedbackDate());
			logger.debug("FeedbackTime	:"+customerFeedbackRequest.getFeedbackTime());
			logger.debug("FeedbackLetterDate	:"+customerFeedbackRequest.getFeedbackLetterDate());
			logger.debug("FeedbackGist	:"+customerFeedbackRequest.getFeedbackGist());
			logger.debug("FeedbackBy	:"+customerFeedbackRequest.getFeedbackBy());
			logger.debug("-----------------------------------------------------------------");
			
			
		CustomerFeedbackServiceStub customerFeedbackService = new CustomerFeedbackServiceStub();
		UpdateCustomerFeedback updateCustomerFeedback = new UpdateCustomerFeedback();
		
		// setting to request
		updateCustomerFeedback.setReq(customerFeedbackRequest);
		// calling the stub
		
		UpdateCustomerFeedbackResponse updateCustomerFeedbackResponse = customerFeedbackService.updateCustomerFeedback(updateCustomerFeedback);
		
		
		List<CustomerFeedbackResponseDto> customerFeedbackResponseDtoList = new ArrayList<>();
	
		if (null != updateCustomerFeedbackResponse  && null != updateCustomerFeedbackResponse.getUpdateCustomerFeedbackResult() 
				&& null != updateCustomerFeedbackResponse.getUpdateCustomerFeedbackResult().getCustomerFeedbackResponse() ) {
			logger.debug("Response for  Complaint or Appreciation is recived");
			List<CustomerFeedbackResponse> customerFeedbackResponseList = Arrays.asList(updateCustomerFeedbackResponse.getUpdateCustomerFeedbackResult().getCustomerFeedbackResponse());
			CustomerFeedbackResponseDto customerFeedbackResponse ;
			for(CustomerFeedbackResponse customerFeedbackResponseObj :customerFeedbackResponseList){
				customerFeedbackResponse = new CustomerFeedbackResponseDto();
				if(null != customerFeedbackResponseObj.getAWBNo() ){
					logger.debug("Response AWB :"+customerFeedbackResponseObj.getAWBNo());
					customerFeedbackResponse.setWaybillNumber(customerFeedbackResponseObj.getAWBNo());
				}
				if(null != customerFeedbackResponseObj.getErrorMsg()){
					logger.debug("Response Message :"+customerFeedbackResponseObj.getErrorMsg());
					customerFeedbackResponse.setErrorMessage(customerFeedbackResponseObj.getErrorMsg());
				}
				if(null != customerFeedbackResponseObj.getFeedbackBy() ){
					logger.debug("Response Feed Back By :"+customerFeedbackResponseObj.getFeedbackBy());
					customerFeedbackResponse.setFeedbackBy(customerFeedbackResponseObj.getFeedbackBy());
				}
				if(null != customerFeedbackResponseObj.getFeedbackType() ){
					logger.debug("Response Feed Back Type :"+customerFeedbackResponseObj.getFeedbackType());
					customerFeedbackResponse.setFeedbackType(customerFeedbackResponseObj.getFeedbackType());
				}
				if(null != customerFeedbackResponseObj.getFeedbackID() ){
					logger.debug("Response Feed Id :"+customerFeedbackResponseObj.getFeedbackID());
					customerFeedbackResponse.setFeedbackId(customerFeedbackResponseObj.getFeedbackID());
				}
				logger.debug("Response Is Error :"+customerFeedbackResponseObj.getIsError());
				customerFeedbackResponse.setError(customerFeedbackResponseObj.getIsError());
				customerFeedbackResponseDtoList.add(customerFeedbackResponse);
			}
			
			contactUsDto.setCustomerFeedBackResponse(customerFeedbackResponseDtoList);

		}
		} catch ( BlueDartException e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.debug("Contact Us Service Exception ");
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		catch (DataBaseException e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.debug("Contact Us Service Exception ");
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		saveMISLog(featureName,customerFeedback.getLoginId(),customerFeedback.getIpAddress(),customerFeedback.getCustomerEmailId(),customerFeedback.getWaybillNumber());
		logger.debug("Returning response ContactUsHandler for  Complaint & Appreciation");
		return contactUsDto;
	}
	
	// method is used to fetch the feed back reasons from caress for complaint and appreciation based on feed back type
	public ContactUsDto getFeedBackReason(String feedBackType) throws RemoteException {
		ContactUsDto feedBackReason= null;
		try{
		feedBackReason = new ContactUsDto();
		feedBackReason.setFeedBackReason(getFeedBackReasons(feedBackType));
		return feedBackReason;
		}catch (BlueDartException e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.debug("Contact Us Service Exception could not load feedback reasons ");
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
	}
	// method is used to fetch the feed back reasons from caress for complaint and appreciation based on feed back type using stub object
	private List<FeedBackReasonDto> getFeedBackReasons(String feedBackType) throws RemoteException {
		
		logger.debug("FeedBack Type ------------------------"+feedBackType);
		List<FeedBackReasonDto> feedBackReasonsList= new ArrayList<>();
		
		CustomerFeedbackServiceStub customerFeedbackService = new CustomerFeedbackServiceStub();
		
		// setting to request
		GetFeedbackReasonDetails getFeedbackReasonDetails = new GetFeedbackReasonDetails();
		GetFeedbackReasonRequest feedbackReasonRequest = new GetFeedbackReasonRequest();
		feedbackReasonRequest.setFeedbackReasonType(feedBackType);
		getFeedbackReasonDetails.setReq(feedbackReasonRequest);
		GetFeedbackReasonDetailsResponse  feedbackReasonDetailsResponse  = customerFeedbackService.getFeedbackReasonDetails(getFeedbackReasonDetails );
		
		if(null != feedbackReasonDetailsResponse  && null != feedbackReasonDetailsResponse.getGetFeedbackReasonDetailsResult()
				&& null != feedbackReasonDetailsResponse.getGetFeedbackReasonDetailsResult().getGetFeedbackReasonResponse() ){
			FeedBackReasonDto feedBackReasonDto ;
			for(GetFeedbackReasonResponse feedbackReasonDetailsResult: feedbackReasonDetailsResponse.getGetFeedbackReasonDetailsResult().getGetFeedbackReasonResponse()){
				 feedBackReasonDto = new FeedBackReasonDto();
				 feedBackReasonDto.setReasonCode(feedbackReasonDetailsResult.getFeedbackReasonCode());
				 feedBackReasonDto.setReasonDescription(feedbackReasonDetailsResult.getFeedbackReasonDesc());
				 feedBackReasonsList.add(feedBackReasonDto);
				
		}
		}
		Collections.sort(feedBackReasonsList,new FeedBackReasonComparatorUtil());
		return feedBackReasonsList ;  
	}

	// method is called when user submit the write to us form. 
	public ContactUsDto isEmailSent(CustomerFeedbackRequestDto customerFeedback){
		ContactUsDto contactUs = new ContactUsDto();
		EmailContent emailContent = new EmailContent();
		
		boolean isMailSent= false;
		if(null != customerFeedback.getCustomerEmailId() )
		{
			
			Properties emailProperties = new Properties();
			try {
				emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
			} catch (Exception exception) {
				logger.debug("Propery file emailConfig.properties not found in the classpath.");
				throw new BlueDartException(exception.getMessage(),"Property file emailConfig.properties not found in the classpath.");
			}
			
			emailContent.setFrom(customerFeedback.getCustomerEmailId());
			
			emailContent.setTo(emailProperties.getProperty("writeToUsMailId"));
			
			emailContent.setSubject("Net Email : "+generateSequence()+" : "+customerFeedback.getFeedbackRefno()); //getFeedbackRefno used for subject
			
			String feedBackBy ;
			if("S".equals(customerFeedback.getFeedbackBy())){
				feedBackBy = "You sent the shipment";
			}else if("C".equals(customerFeedback.getFeedbackBy())){
				feedBackBy = "You are a receiver";
			}else if("TP".equals(customerFeedback.getFeedbackBy())){
				feedBackBy = "You do not wish to be identified";
			}else{
				feedBackBy = "You sent the shipment";
			}
			
			 Map <String, Object>customerFeedbackModel = new HashMap <> ();
			 customerFeedbackModel.put("Name", customerFeedback.getCustomerName());
			 customerFeedbackModel.put("EmailID", customerFeedback.getCustomerEmailId() ); 
			 customerFeedbackModel.put("Contactnumber", customerFeedback.getContactNumber()  ); 
			 customerFeedbackModel.put("City", customerFeedback.getDestinationArea() ); 
			 customerFeedbackModel.put("Youare", feedBackBy ); 
			 if(!(customerFeedback.getWaybillNumber().isEmpty()) && null != customerFeedback.getWaybillNumber() ){
			 customerFeedbackModel.put("AWB", customerFeedback.getWaybillNumber() ); 
			 }
			 if(!(customerFeedback.getEmployeeName().isEmpty()) && null != customerFeedback.getEmployeeName()  ){
			 customerFeedbackModel.put("BDemployeename", customerFeedback.getEmployeeName() ); 
			 }
			 customerFeedbackModel.put("Description", customerFeedback.getFeedbackDescription() ); 
			 emailContent.setModel(customerFeedbackModel);
			 
			
			
			//String emailText = generateEmailBody(customerFeedback);
			
			//emailContent.setText(emailText);
			
			try {
				isMailSent = EmailUtil.sendEmailWithImageForAppreciationAndFeedback(emailContent,"writeToUs-template.vm");
				contactUs.setMailSent(isMailSent);
			} catch (Exception e) {
				isMailSent = false;
				contactUs.setMailSent(isMailSent);
				logger.error("EXCEPTION TYPE :",e);
				logger.debug("Email Service Exception - IsMailSent:"+isMailSent);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			
			logger.debug("Is mail sent :"+isMailSent);
			featureName = Constants.CONTACTUS_FEEDBACK_WRITE_TO_US;
			saveMISLog(featureName,customerFeedback.getLoginId(),customerFeedback.getIpAddress(),customerFeedback.getCustomerEmailId(),customerFeedback.getWaybillNumber());
		}
		return contactUs;
		
		
	}
	
	// method is used to generate  sequence number using current system date and random number.
	private String generateSequence(){
		Date systemCurrentDate = new Date();
		
		String sysDate = DateUtil.formatDateToStringGivenFormat(systemCurrentDate, "yyyyMMdd");
		String sysTime = DateUtil.formatDateToStringGivenFormat(systemCurrentDate, "HHmmss");
		Random randomno = new Random();
		long randomInt= Long.parseLong(sysTime)+randomno.nextInt(1000);
		logger.debug("Sequence No : "+ sysDate+randomInt);
		return sysDate+randomInt;
		
	}
	
	//This method is used to generate email content for complaint , appreciation and write to us. 
/*	private String generateEmailBody(CustomerFeedbackRequestDto customerFeedback){
		
		String feedBackBy ;
		if("S".equals(customerFeedback.getFeedbackBy())){
			feedBackBy = "You sent the shipment";
		}else if("C".equals(customerFeedback.getFeedbackBy())){
			feedBackBy = "You are a receiver";
		}else if("TP".equals(customerFeedback.getFeedbackBy())){
			feedBackBy = "You do not wish to be identified";
		}else{
			feedBackBy = "You sent the shipment";
		}
		
		StringBuilder emailText = new StringBuilder();
		final String openTabelTag = "<tr><td style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; font-weight:bold; border-bottom:solid 1px #ccc; border-right:solid 1px #ccc; padding:5px 10px;\">";
		final String closeTabelTag = "</td></tr>";
		emailText.append("<html><body style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; \">");
		emailText.append("<p>Dear Team,</p> ");
		
		emailText.append("<p>Kindly find the below details.</p>");
				
		emailText.append("<p></p>");
		emailText.append("<table cellspacing='0' style='border:solid 1px #ccc; padding:0px;'>");
		
		emailText.append("<tr><td width='200' style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; font-weight:bold; border-bottom:solid 1px #ccc; border-right:solid 1px #ccc; padding:5px 10px;\">"
				+ "Name</td>"
				+ "<td width='350' style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px;\">" 
				+ customerFeedback.getCustomerName() 
				+ closeTabelTag);
		emailText.append(openTabelTag
				+ "Email ID</td>"
				+ "<td style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px; \">" 
		    	+ customerFeedback.getCustomerEmailId() 
		    	+ closeTabelTag);
		emailText.append(openTabelTag
				+ "City</td>"
				+ "<td style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px; \">" 
		    	+ customerFeedback.getDestinationArea() 
		    	+ closeTabelTag);
		emailText.append(openTabelTag
				+ "Contact number</td>"
				+ "<td  style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px; \">" 
				+ customerFeedback.getContactNumber() 
				+ closeTabelTag);
		
		emailText.append(openTabelTag
				+ "You are</td>"
				+ "<td  style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px; \">" 
				+ feedBackBy 
				+ closeTabelTag);
		if(!(customerFeedback.getWaybillNumber().isEmpty()) && null != customerFeedback.getWaybillNumber() ){
			emailText.append(openTabelTag
					+ "AWB</td>"
					+ "<td  style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px;\">" 
					+ customerFeedback.getWaybillNumber() 
					+ closeTabelTag);
		}
		if(!(customerFeedback.getEmployeeName().isEmpty()) && null != customerFeedback.getEmployeeName()  ){
			emailText.append(openTabelTag
					+ "BD employee name</td>"
					+ "<td  style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  border-bottom:solid 1px #ccc; padding:5px 10px;\">" 
					+ customerFeedback.getEmployeeName() 
					+ closeTabelTag);
		}
		emailText.append("<tr><td style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; font-weight:bold;  border-right:solid 1px #ccc; padding:5px 10px;\">"
				+ "Description</td>"
				+ "<td  style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  padding:5px 10px; \">" 
				+ customerFeedback.getFeedbackDescription() 
				+ closeTabelTag);
		
		
		emailText.append("</table></body></html>");
		
		return emailText.toString();
		
	}*/

	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(null != featureName && null != loginId ){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(null != featureName && null != ipAddress ){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
	
	private String getLocation(String locationName,String locationPinCode) {
		logger.debug("ContactUsHandler :Geting code for location-------------"+locationName+"-----"+locationPinCode);
		return contactUsDao.getLocation(locationName,locationPinCode);
				
	}
	
}
