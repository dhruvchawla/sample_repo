package com.bluedart.ebusinesssolutions.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dao.MailLinkDao;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.entity.MailLink;
import com.bluedart.ebusinesssolutions.dto.EBusinessSolutionsDto;
import com.bluedart.ebusinesssolutions.service.EBusinessSolutionsService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.masters.dao.MasterDao;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;
/**
 * @author CH848113
 */

@Service
public class EBusinessSolutionsServiceImpl implements EBusinessSolutionsService{
	private static final Logger logger = Logger.getLogger(EBusinessSolutionsServiceImpl.class); 

	@Autowired
	private MasterDao masterDao;
	
	@Autowired
	private MailLinkDao mailLinkDao;
	
	private String featureName = null;
	@Autowired
	private MISLogDao misLogDao;
	
	private static Properties properties = new Properties();
	
	@Override
	public boolean submitEBusinessSolutions(EBusinessSolutionsDto eBusinessSolutions) throws BlueDartException {
		return isEmailSent(eBusinessSolutions);
	}	
	
	private boolean isEmailSent(EBusinessSolutionsDto eBusinessSolutions) throws BlueDartException{
		EmailContent emailContent = new EmailContent();
		boolean isMailSent= false;
			try{
			MailLink mailLink = getEmailIds(eBusinessSolutions.getPinCode(), eBusinessSolutions.getInterfaceCode());
			if(mailLink != null){
			emailContent.setFrom(eBusinessSolutions.getEmailId());
			try {
				properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
				emailContent.setSubject(properties.getProperty("eBusinessSolutionsEmailSubject"));
			} catch (IOException e1) {
				emailContent.setSubject("Techsol Message");  
			}
		
			if(mailLink.getcMailTo() != null){
					emailContent.setTo(mailLink.getcMailTo());			
					logger.info("To Mail Ids :"+mailLink.getcMailTo());
			}
			if(mailLink.getcMailCC() != null) {
				emailContent.setTo(mailLink.getcMailCC());
				logger.info("CC Mail Ids :"+mailLink.getcMailCC());
			}
			
			
			 Map <String, Object> eBusinessSolutionModel = new HashMap <> ();
			 eBusinessSolutionModel.put("organisationName", eBusinessSolutions.getOrganisationName());
			 eBusinessSolutionModel.put("contactPerson", eBusinessSolutions.getContactPerson()); 
			 eBusinessSolutionModel.put("emailId", eBusinessSolutions.getEmailId()); 
			 eBusinessSolutionModel.put("mobileNumber", eBusinessSolutions.getCountryCode()+ " - "+eBusinessSolutions.getMobileNumber() ); 
			 eBusinessSolutionModel.put("pinCode",eBusinessSolutions.getPinCode());
			 
			 if(eBusinessSolutions.getWebsite() != null && !(eBusinessSolutions.getWebsite().isEmpty()) ){
				 	eBusinessSolutionModel.put("website",eBusinessSolutions.getWebsite());
			 }
			if(eBusinessSolutions.getAreYouUsingBlueDart() != null && !(eBusinessSolutions.getAreYouUsingBlueDart().isEmpty()) ){
					eBusinessSolutionModel.put("areYouUsingBlueDart",eBusinessSolutions.getAreYouUsingBlueDart());
			}
			if(eBusinessSolutions.getAreYouLookingFor() != null && !(eBusinessSolutions.getAreYouLookingFor().isEmpty()) ){
			 String CUSTOMIZED = "Customized Integration With Blue Dart";
			 String STANDARD = "Standard Solution";
			 
			 eBusinessSolutionModel.put("areYouLookingFor",(eBusinessSolutions.getAreYouLookingFor().equals("C")?CUSTOMIZED:STANDARD));	
			}
			if(eBusinessSolutions.getAreYouLookingFor() != null && !(eBusinessSolutions.getAreYouLookingFor().isEmpty()) && eBusinessSolutions.getAreYouLookingFor().equals("C") ){
				if(eBusinessSolutions.getDoYouHaveWebService() != null && !(eBusinessSolutions.getDoYouHaveWebService().isEmpty()) ){
					eBusinessSolutionModel.put("doYouHaveWebService",eBusinessSolutions.getDoYouHaveWebService()); 
				}
				if(eBusinessSolutions.getPlatformCurrentlyUse() != null && !(eBusinessSolutions.getPlatformCurrentlyUse().isEmpty()) ){
					eBusinessSolutionModel.put("platformCurrentlyUse",eBusinessSolutions.getPlatformCurrentlyUse() );
				}
				if(eBusinessSolutions.getSoftwareCurrentlyUse() != null && !(eBusinessSolutions.getSoftwareCurrentlyUse().isEmpty()) ){
					eBusinessSolutionModel.put("softwareCurrentlyUs",eBusinessSolutions.getSoftwareCurrentlyUse());
				}
				if(eBusinessSolutions.getDataBaseCurrentlyUse() != null && !(eBusinessSolutions.getDataBaseCurrentlyUse().isEmpty()) ){
					eBusinessSolutionModel.put("dataBaseCurrentlyUse",eBusinessSolutions.getDataBaseCurrentlyUse());
				}
			}
			if(eBusinessSolutions.getTechnologyToIntigrate() != null && !(eBusinessSolutions.getTechnologyToIntigrate().isEmpty()) ){
				eBusinessSolutionModel.put("technologyToIntigrate",eBusinessSolutions.getTechnologyToIntigrate());
			}
			if(eBusinessSolutions.getYourCustomerCode() != null && !(eBusinessSolutions.getYourCustomerCode().isEmpty()) ){
			 eBusinessSolutionModel.put("yourCustomerCode",eBusinessSolutions.getYourCustomerCode());
			}
			if(eBusinessSolutions.getMessage() != null && !(eBusinessSolutions.getMessage().isEmpty()) ){
			 eBusinessSolutionModel.put("message",eBusinessSolutions.getMessage());
			} 
			
			 emailContent.setModel(eBusinessSolutionModel);
			
			
			//String emailText = generateEmailContent(eBusinessSolutions);
			logger.info("--------------- E-BUSINESS SOLUTIONS CONTENT IS FORMED -----------------------");
			
			//emailContent.setText(emailText);
			try {	
				  logger.info("------------------E Business Solution--------------------");
				  isMailSent = EmailUtil.sendEmailWithImage(emailContent,"eBusinessSolution-template.vm");
				  logger.info("----------------E Business Solution Mail Sent----------------------");
				} 
				catch (Exception e) {
				  logger.error(e.getMessage());
				  isMailSent = false;
				  throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
				} 
			 }
			}catch(BlueDartException e){
				logger.error(e.getMessage());				
				throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
			}
			featureName = Constants.E_BUSINESS_SOLUTIONS;
			saveMISLog(featureName,eBusinessSolutions.getLoginId(),eBusinessSolutions.getIpAddress(),eBusinessSolutions.getEmailId(),null);
			logger.info("Is mail sent::"+isMailSent);
			
		return isMailSent;
	}

/*
	private static String generateEmailContent(EBusinessSolutionsDto businessSolution){
		StringBuilder emailText = new StringBuilder();

		String topCol1CSS = "width='275' style=\" font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; font-weight:bold;  padding:5px 10px;\"";
		String topCol2CSS = "width='375' style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px;  padding:5px 10px;\"";
		
		emailText.append("<html><body style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:12px; \">");
		emailText.append("<p>Dear Team,</p> ");
		emailText.append("<p>Inquiry for E - Business Solution has been submitted. Kindly find the details below.</p>");
		emailText.append("<p></p>");
		emailText.append("<table cellspacing='0' style=' padding:0px;'>");
		emailText.append("<tr><td  "+topCol1CSS+" >"
				+ "Organisation Name</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getOrganisationName() 
				+ "</td></tr>");
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Contact Person</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getContactPerson() 
				+ "</td></tr>");
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Email ID</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getEmailId() 
				+ "</td></tr>");
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Mobile Number</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getCountryCode() + " - "+businessSolution.getMobileNumber() 
				+ "</td></tr>");
		
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "PIN Code</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getPinCode() 
				+ "</td></tr>");
		
		if(businessSolution.getWebsite() != null && !(businessSolution.getWebsite().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Organisation's Site Address</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getWebsite()
				+ "</td></tr>");
		}
		if(businessSolution.getAreYouUsingBlueDart() != null && !(businessSolution.getAreYouUsingBlueDart().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Are You Using Blue Dart?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getAreYouUsingBlueDart()
				+ "</td></tr>");
		}
		if(businessSolution.getAreYouLookingFor() != null && !(businessSolution.getAreYouLookingFor().isEmpty()) ){
			String CUSTOMIZED = "Customized Integration With Blue Dart";
			String STANDARD = "Standard Solution";
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Are You Looking For</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ (businessSolution.getAreYouLookingFor().equals("C")?CUSTOMIZED:STANDARD)	
				+ "</td></tr>");
		}
		if(businessSolution.getAreYouLookingFor() != null && !(businessSolution.getAreYouLookingFor().isEmpty()) && businessSolution.getAreYouLookingFor().equals("C") ){
		if(businessSolution.getDoYouHaveWebService() != null && !(businessSolution.getDoYouHaveWebService().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Do You Have A Web Service?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getDoYouHaveWebService() 
				+ "</td></tr>");
		}
		if(businessSolution.getPlatformCurrentlyUse() != null && !(businessSolution.getPlatformCurrentlyUse().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Which Platform Do You Currently Use?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getPlatformCurrentlyUse() 
				+ "</td></tr>");
		}
		if(businessSolution.getSoftwareCurrentlyUse() != null && !(businessSolution.getSoftwareCurrentlyUse().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Which Software Do You Currently Use For Program Coding?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getSoftwareCurrentlyUse()
				+ "</td></tr>");
		}
		if(businessSolution.getDataBaseCurrentlyUse() != null && !(businessSolution.getDataBaseCurrentlyUse().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Which Backend Database Server Do You Currently Use?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getDataBaseCurrentlyUse()
				+ "</td></tr>");
		}
		}
		if(businessSolution.getTechnologyToIntigrate() != null && !(businessSolution.getTechnologyToIntigrate().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Please Indicate The Blue Dart Technology Solution(s) You Would Like To Integrate?</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getTechnologyToIntigrate()
				+ "</td></tr>");
		}
		if(businessSolution.getYourCustomerCode() != null && !(businessSolution.getYourCustomerCode().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Your Customer Code</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getYourCustomerCode()
				+ "</td></tr>");
		}
		
		if(businessSolution.getMessage() != null && !(businessSolution.getMessage().isEmpty()) ){
		emailText.append("<tr><td "+topCol1CSS+" >"
				+ "Please Share Additional Information(if any)</td>"
				+ "<td "+topCol2CSS+" > : " 
				+ businessSolution.getMessage()
				+ "</td></tr>");
		}
		emailText.append("</table></body></html>");
		return emailText.toString();
	}*/
	
	private MailLink getEmailIds(String pinCode,String interfaceCode) throws BlueDartException {
		MailLink mailLink = null;
		try{	
			AreaDTO area = masterDao.getSABR(pinCode);
			//if(area != null){
				mailLink = mailLinkDao.getEmailIds(area, interfaceCode);
			//}
		}catch(BlueDartException e){
			logger.error(e.getMessage());
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return mailLink;		
	}
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.info("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.info("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
	
}
