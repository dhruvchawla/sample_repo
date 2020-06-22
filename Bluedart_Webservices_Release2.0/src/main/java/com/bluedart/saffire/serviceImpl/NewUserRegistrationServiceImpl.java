package com.bluedart.saffire.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.entity.MailLink;
import com.bluedart.common.service.OTPService;
import com.bluedart.common.service.SMSService;
import com.bluedart.common.webservice.WebServiceStub;
import com.bluedart.exception.BlueDartException;
import com.bluedart.saffire.dto.NewUserRegistrationDTO;
import com.bluedart.saffire.service.NewUserRegistrationService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;
import com.providian.bluedart.wipro.ws.LeadInfo;
import com.providian.bluedart.wipro.ws.SendLeadInfoToSafire;
import com.providian.bluedart.wipro.ws.SendLeadInfoToSafireRequest;
import com.providian.bluedart.wipro.ws.SendLeadInfoToSafireResponseE;

@Service
public final class NewUserRegistrationServiceImpl implements NewUserRegistrationService{

	private static final Logger logger = Logger.getLogger(NewUserRegistrationServiceImpl.class);

	private Properties properties = new Properties();

	@Autowired
	private OTPService otpService;

	@Autowired
	private SMSService smsService;
	
	@Autowired
	private MISLogDao misLogDao;

	@Override
	public NewUserRegistrationDTO saveNewUserRegistration(NewUserRegistrationDTO newUserRegistrationDTO) throws AxisFault,RemoteException {

		// TODO Auto-generated method stub
		try{
			logger.info("saveNewUserRegisteration in NewUserRegisterationServiceImpl starts");
			WebServiceStub webServiceStub = new WebServiceStub();

			SendLeadInfoToSafireRequest param=new SendLeadInfoToSafireRequest();
			LeadInfo leadInfo=new LeadInfo();
			leadInfo.setCompanyName(newUserRegistrationDTO.getCompanyName());
			leadInfo.setAddress1(newUserRegistrationDTO.getAddressLine1());
			leadInfo.setAddress2(newUserRegistrationDTO.getAddressLine2());
			leadInfo.setLandmark(newUserRegistrationDTO.getLandmark());
			leadInfo.setLocation(newUserRegistrationDTO.getLocation());
			leadInfo.setPincode(newUserRegistrationDTO.getPincode());
			leadInfo.setEmailID(newUserRegistrationDTO.getEmailId());
			leadInfo.setPhoneNumber(newUserRegistrationDTO.getMobileNo());
			if (newUserRegistrationDTO.getNumberofShipmentsPerMonth() >0)
				leadInfo.setShippingMode(newUserRegistrationDTO.getShippingMode() +" - "+newUserRegistrationDTO.getNumberofShipmentsPerMonth());
			else
				leadInfo.setShippingMode(newUserRegistrationDTO.getShippingMode());
			leadInfo.setPrefix(newUserRegistrationDTO.getYourName());
			leadInfo.setFirstName(newUserRegistrationDTO.getFirstName());
			leadInfo.setLastName(newUserRegistrationDTO.getLastName());
			leadInfo.setBusinessPotential(newUserRegistrationDTO.getAnnualSpendonLogistics());
			leadInfo.setEmpCode("90001");
			param.setLeadinput(leadInfo);
			SendLeadInfoToSafire sendLeadInfoToSafire=new SendLeadInfoToSafire();
			sendLeadInfoToSafire.setRequest(param);
			logger.info("Before Sending");
			SendLeadInfoToSafireResponseE result=webServiceStub.sendLeadInfoToSafire(sendLeadInfoToSafire);
			result.getSendLeadInfoToSafireResult().getLeadoutout().getResponse();
			logger.info("Response : "+result.getSendLeadInfoToSafireResult().getLeadoutout().getResponse());
			newUserRegistrationDTO.setResult(result.getSendLeadInfoToSafireResult().getLeadoutout().getResponse());
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			logger.error("Exception caught in saveNewUserRegisteration in NewUserRegisterationServiceImpl ::: "+exception);
			throw new BlueDartException("-1", "Not able to Call Service");
		}

		
		String featureName= Constants.NEW_USER_REGISTRATION;
		saveMISLog(featureName,null,newUserRegistrationDTO.getIpAddress(),newUserRegistrationDTO.getEmailId(),null);
		
		logger.debug("saveNewUserRegisteration in NewUserRegisterationServiceImpl ends");
		return newUserRegistrationDTO;
	}

	/*@Override
	public NewUserRegistrationDTO getOTPAndSendSMS(int length, String mobilenumber) {
		logger.info("getOTPAndSendSMS in getOTPAndSendSMS starts");
		NewUserRegistrationDTO newUserRegistrationDto = new NewUserRegistrationDTO();
		String statusCode = "";
		long otp = 0 ;
		otp = otpService.generateOTP(length);
		newUserRegistrationDto.setOtp(String.valueOf(otp));
		logger.info("OTP is "+newUserRegistrationDto.getOtp());
		//SMSUtil smsUtilObj = new SMSUtil();
		String message = MessageFormat.format("One Time Password (OTP) for new user registration is {0}. Valid for 10 minutes only. Please do not share with anyone.", newUserRegistrationDto.getOtp());
		statusCode = sendSMS(mobilenumber, message, "SAFIREINTEGRATION", statusCode);

		if(statusCode == "" && statusCode != "000") {
			newUserRegistrationDto.setErrorCode("-1");
		}

		logger.info("getOTPAndSendSMS in getOTPAndSendSMS ends");
		//String featureName= Constants.NEW_USER_REGISTRATION;
		//saveMISLog(featureName,null,newUserRegistrationDTO.getIpAddress(),newUserRegistrationDTO.getEmailId(),null);
		return newUserRegistrationDto;
	}*/

	
	private String sendSMS( String mobileNo, String message, String module, String statusCode ) {
		try { 	

			logger.debug("sendSMS Starts");
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.EXT_WEBSERVICE_PROPERTIES));

			String AclURL = properties.getProperty(Constants.ACL_URL);
			String PathURL = properties.getProperty(Constants.ACL_URL_PATH)+mobileNo+"&sender=BluDrt&msgtext="+message;
			//String PathURL = properties.getProperty(Constants.ACL_URL_PATH)+mobileNo+"&sender=BluDrt&msgtext="+message+"&user=122396&password=BdSoftDev2020";
			byte buffer[] = PathURL.getBytes("ISO-8859-1");                       
			URL url = new URL(AclURL);
			URLConnection conn = url.openConnection();                          
			conn.setDoOutput(true);                                           
			OutputStream out = conn.getOutputStream();                         
			out.write(buffer);                                                
			out.flush();

			InputStream instream = conn.getInputStream();                       
			buffer = new byte[3000];                                           
			instream.read(buffer);
			String responseId = buffer.toString();
			//logger.info(" buffer : "+buffer+" SMSSERVICE ::: "+smsService+" MODULE ::: "+module+" responseId is ::: "+responseId);
			if(responseId != null ) {
				if( smsService != null ) {
					smsService.saveSMS(responseId, module);
				}
			}else {
				logger.debug("Error while receiving responseId ::: "+responseId);
			}
			statusCode = "000";
		}catch ( MalformedURLException ex) {  
			logger.error("EXCEPTION TYPE :",ex);
			ex.printStackTrace();   
			logger.debug("Error caught in MalformedURLException "+ex);
			statusCode = "001";
		}catch(Exception ex) {
			logger.error("EXCEPTION TYPE :",ex);
			ex.printStackTrace();
			logger.debug("Error caught in Exception "+ex);
			statusCode = "001";
		}
		logger.debug("sendSMS Ends");

		return statusCode;
	}
	
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}

	@Override
	public boolean  submitUserRegisterationData(NewUserRegistrationDTO newUserRegisteration)
	{
		return isUserEmailSent(newUserRegisteration);
	}

	private boolean isUserEmailSent(NewUserRegistrationDTO newUserRegisteration) 
	{
		 EmailContent emailContent = new EmailContent();
	     boolean isMailSent= false;
	 try {

	        properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
	        emailContent.setFrom(properties.getProperty("fromMailId"));
	        emailContent.setTo(properties.getProperty("ToMailId"));
		    emailContent.setSubject(properties.getProperty("userRegisterationEmailSubject"));
	       } 
	   catch (IOException e1) {
		emailContent.setSubject("Error Message");  
	   }
	
	 Map <String, Object> userRegisterationModel = new HashMap <> ();
	 userRegisterationModel.put("companyName", newUserRegisteration.getCompanyName());
	 userRegisterationModel.put("contactPerson", newUserRegisteration.getYourName()+". "+newUserRegisteration.getFirstName()+" "+ newUserRegisteration.getLastName()); 
	 userRegisterationModel.put("address1", newUserRegisteration.getAddressLine1()) ;
	 userRegisterationModel.put("address2",newUserRegisteration.getAddressLine2()) ;
	if(newUserRegisteration.getLandmark()!=null)
	{
	 userRegisterationModel.put("landMark", newUserRegisteration.getLandmark());
	}
	userRegisterationModel.put("location", newUserRegisteration.getLocation());
	userRegisterationModel.put("pincode", newUserRegisteration.getPincode());
	 userRegisterationModel.put("emailId", newUserRegisteration.getEmailId()); 
	 userRegisterationModel.put("mobileNumber", newUserRegisteration.getMobileNo()); 
	 userRegisterationModel.put("shippingMode",newUserRegisteration.getShippingMode());
	 userRegisterationModel.put("numberOfShipmentsPerMonth", newUserRegisteration.getNumberofShipmentsPerMonth());
	 userRegisterationModel.put("annualSpendOnLogistics", newUserRegisteration.getAnnualSpendonLogistics());
	 
	 emailContent.setModel(userRegisterationModel);
	
	
	//String emailText = generateEmailContent(newUserRegisteration);
	logger.info("--------------- CREDIT ACCOUNT FORMED -----------------------");
	
	//emailContent.setText(emailText);
	try {	
		  logger.info("------------------User Registeration --------------------");
		  isMailSent = EmailUtil.sendMail(emailContent,"userRegisteration.vm");
		  logger.info("----------------User Registeration Mail Sent----------------------");
		} 
		catch (Exception e) {
		  logger.error(e.getMessage());
		  isMailSent = false;
		  throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		} 
	 
	 /* featureName = Constants.USER_REGISTERATION;
	  saveMISLog(featureName,eBusinessSolutions.getLoginId(),eBusinessSolutions.getIpAddress(),eBusinessSolutions.getEmailId(),null);*/
		
		String featureName= Constants.NEW_USER_REGISTRATION;
		saveMISLog(featureName,null,newUserRegisteration.getIpAddress(),newUserRegisteration.getEmailId(),null);	 
		logger.info("Is mail sent::"+isMailSent);
	
    return isMailSent;

	}

	
	@Override
	public NewUserRegistrationDTO getOTPAndSendSMS(int length, String mobilenumber) {
		logger.info("getOTPAndSendSMS in getOTPAndSendSMS starts");
		NewUserRegistrationDTO newUserRegistrationDto = new NewUserRegistrationDTO();
		String statusCode = "";
		long otp = 0 ;
		otp = otpService.generateOTP(length);
		System.out.println("OTP :" + otp);
		newUserRegistrationDto.setOtp(String.valueOf(otp));
		logger.info("OTP is "+newUserRegistrationDto.getOtp());
		//SMSUtil smsUtilObj = new SMSUtil();
		String message = MessageFormat.format("One Time Password (OTP) for new user registration is {0}. Valid for 10 minutes only. Please do not share with anyone.", newUserRegistrationDto.getOtp());
		statusCode = sendSMS(mobilenumber, message, "SAFIREINTEGRATION", statusCode);
        
		if(statusCode == "" && statusCode != "000") {
			newUserRegistrationDto.setErrorCode("-1");
		}

		logger.info("getOTPAndSendSMS in getOTPAndSendSMS ends");
		String featureName= Constants.NEW_USER_REGISTRATION;
		saveMISLog(featureName,null,newUserRegistrationDto.getIpAddress(),newUserRegistrationDto.getEmailId(),null);
		return newUserRegistrationDto;
	}
}
