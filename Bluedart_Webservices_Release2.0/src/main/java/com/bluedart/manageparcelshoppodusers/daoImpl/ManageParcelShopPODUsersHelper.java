package com.bluedart.manageparcelshoppodusers.daoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopsDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;

/**
 * 
 * 
 * @author DI334021
 *
 */
@Component
@PropertySource("classpath:emailConfig.properties")
public class ManageParcelShopPODUsersHelper extends BaseDaoImpl {

	
	
	@Autowired
	private Environment environment;
	
	private static Logger log = Logger.getLogger(ManageParcelShopPODUsersDaoImpl.class.getName());

	
	public boolean sendEmailNotification(ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto) {
	
		log.debug("ManageParcelShopPODUsersHelper : sendEmailNotification");
		
		boolean isMailSent = false;
		EmailContent mailContent = null;

		switch (manageParcelShopPODUsersNotificationsDto.getAction()) {
		
		case Constants.DEACTIVATE_USER_ACTION:
			
			ArrayList<String> toEmailidDeactivate = new ArrayList<>();
			
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
			for (ParcelShopsDto dto : manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedParcelshops()) {
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId1())) &&  (dto.getEmailId1() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId1())))
				{
					toEmailidDeactivate.add(dto.getEmailId1());
				}
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId2()))  &&  (dto.getEmailId2() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId2())))
				{
					toEmailidDeactivate.add(dto.getEmailId2());
				}

			}
			}
			toEmailidDeactivate.add(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
			
			Set<String> toEmailidDeactivateSet = new HashSet<>();
			toEmailidDeactivateSet.addAll(toEmailidDeactivate);
			toEmailidDeactivate.clear();
			toEmailidDeactivate.addAll(toEmailidDeactivateSet);
		
			
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty(Constants.FROM_EMAIL_ID));
			mailContent.setListOfTOAddress(toEmailidDeactivate);
			mailContent.setCc(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getLoggedInAdminEmailId());
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
			mailContent.setSubject(environment.getProperty(Constants.DEACTIVATE_PARCELSHOP_USER_EMAIL_SUBJECT));
			}
			else if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER)){
				mailContent.setSubject(environment.getProperty(Constants.DEACTIVATE_POD_USER_EMAIL_SUBJECT));
			}
			Map <String, Object> deactivateUserModel = new HashMap <> ();
			deactivateUserModel.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getLoginId());
	        mailContent.setModel(deactivateUserModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.DEACTIVATE_PARCELSHOP_POD_USER_EMAIL_TEMPLATE));

			} 
			catch (Exception e) {
				log.error("EXCEPTION TYPE :",e);
				log.error("Exception occured in email helper : "+e.getMessage());
				isMailSent = false;
			}
			break;
		
		case Constants.REACTIVATE_USER_ACTION:
			
			ArrayList<String> toEmailidsReactivate = new ArrayList<>();
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
			for (ParcelShopsDto dto : manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedParcelshops()) {
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId1()))  &&  (dto.getEmailId1() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId1())))
				{
					toEmailidsReactivate.add(dto.getEmailId1());
				}
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId2()))  && (dto.getEmailId2() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId2())))
				{
					toEmailidsReactivate.add(dto.getEmailId2());
				}

			}}
			toEmailidsReactivate.add(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
			
			Set<String> toEmailidReactivateSet = new HashSet<>();
			toEmailidReactivateSet.addAll(toEmailidsReactivate);
			toEmailidsReactivate.clear();
			toEmailidsReactivate.addAll(toEmailidReactivateSet);
			
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty(Constants.FROM_EMAIL_ID));
			mailContent.setListOfTOAddress(toEmailidsReactivate);
			mailContent.setCc(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getLoggedInAdminEmailId());
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
				mailContent.setSubject(environment.getProperty(Constants.REACTIVATE_PARCELSHOP_USER_EMAIL_SUBJECT));
				}
				else if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER)){
					mailContent.setSubject(environment.getProperty(Constants.REACTIVATE_POD_USER_EMAIL_SUBJECT));
				}
			Map <String, Object> reactivateUserModel = new HashMap <> ();
			reactivateUserModel.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getLoginId());
	        mailContent.setModel(reactivateUserModel);
		
			try {
				isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.REACTIVATE_PARCELSHOP_POD_USER_EMAIL_TEMPLATE));
		       

			} 
			catch (Exception e) {
				log.error("EXCEPTION TYPE :",e);
				log.error("Exception occured in email helper : "+e.getMessage());
				isMailSent = false;
			}
			
			//--------------------------------------------Login Credentials Mail - Reactivate-------------------------------------------------------------
			
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty(Constants.FROM_EMAIL_ID));
			mailContent.setTo(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
			
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL))
			{
				mailContent.setSubject(environment.getProperty(Constants.REACTIVATE_PARCELSHOP_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT));
			}
				
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER))
			{
				mailContent.setSubject(environment.getProperty(Constants.REACTIVATE_POD_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT));
			}
				Map <String, Object> reactivateUserModelLoginCredentials = new HashMap <> ();
				reactivateUserModelLoginCredentials.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getLoginId());
				reactivateUserModelLoginCredentials.put("password", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getNewPasswordReactivate());
				reactivateUserModelLoginCredentials.put("url",Constants.ADMIN_SITE_URL);
				
				mailContent.setModel(reactivateUserModelLoginCredentials);
		        

				try {
					
					if("Y".equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getPodStatus())){

					isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.REACTIVATE_PARCELSHOP_POD_USER_EMAIL_LOGIN_CREDENTIALS_TEMPLATE));
					}
				} 
				catch (Exception e) {
					log.error("EXCEPTION TYPE :",e);
					log.error("Exception occured in email helper : "+e.getMessage());
					isMailSent = false;
				}
			
			
			break;
			
			
			
		case Constants.CREATE_USER_ACTION :
			
			//-----------------------------------------------------Login credentials mail - create user--------------------------------------------------------------------
			
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty(Constants.FROM_EMAIL_ID));
			mailContent.setTo(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
			
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL))
			{
				mailContent.setSubject(environment.getProperty(Constants.CREATE_PARCELSHOP_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT));
			}
				
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER))
			{
				mailContent.setSubject(environment.getProperty(Constants.CREATE_POD_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT));
			}
				Map <String, Object> createUserModel = new HashMap <> ();
				createUserModel.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getLoginId());
				createUserModel.put("password", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getPassword());
				createUserModel.put("url",Constants.ADMIN_SITE_URL);
				
				if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType()))
				{
					createUserModel.put("userType", Constants.PARCEL_SHOP_STRING);

				}
				if(Constants.USERTYPE_POD_USER.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType()))
				{
					createUserModel.put("userType", Constants.POD_STRING);
				}
				mailContent.setModel(createUserModel);
				
				try {
					isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.CREATE_PARCELSHOP_POD_USER_EMAIL_LOGIN_CREDENTIALS_TEMPLATE));
				} 
				catch (Exception e) {
					log.error("EXCEPTION TYPE :",e);
					log.error("Exception occured in email helper : "+e.getMessage());
					isMailSent = false;
				}
			
			
			//----------------------------------------------------General Mail-----------------------------------------------------------	
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
			    mailContent.setSubject(environment.getProperty(Constants.CREATE_PARCELSHOP_USER_EMAIL_SUBJECT));}//"manageparcelshoppouser.createuserparcel.subject"
			if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER)){
				mailContent.setSubject(environment.getProperty(Constants.CREATE_POD_USER_EMAIL_SUBJECT));}
			ArrayList<String> toEmailidsCreate = new ArrayList<>();
			if((Constants.USERTYPE_PARCEL).equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
				for (ParcelShopsDto dto : manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedParcelshops()) {
					if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId1()))  &&  (dto.getEmailId1() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId1())))
					{
						toEmailidsCreate.add(dto.getEmailId1());
					}
					
					if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId2()))  && (dto.getEmailId2() != null) &&  !("null".equalsIgnoreCase(dto.getEmailId2())))
					{
						toEmailidsCreate.add(dto.getEmailId2());
					}

				}}
			    toEmailidsCreate.add(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
			    Set<String> toEmailidsCreateSet = new HashSet<>();
			    toEmailidsCreateSet.addAll(toEmailidsCreate);
			    toEmailidsCreate.clear();
			    toEmailidsCreate.addAll(toEmailidsCreateSet);
			    mailContent.setTo("");
				mailContent.setListOfTOAddress(toEmailidsCreate);
				mailContent.setCc(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getLoggedInAdminEmailId());
			Map <String, Object> createUserModelLoginDetails = new HashMap <> ();
			
			createUserModelLoginDetails.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getLoginId());
			createUserModelLoginDetails.put("userName", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserName());
			
			if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType()))
			{
				createUserModelLoginDetails.put("userType", Constants.PARCEL_SHOP_STRING);

			}
			if(Constants.USERTYPE_POD_USER.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType()))
			{
				createUserModel.put("userType", Constants.POD_STRING);
			}
			
			
			createUserModelLoginDetails.put("parcelShopDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedParcelshops());
			createUserModelLoginDetails.put("serviceCenterDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedServiceCenters());
			
			mailContent.setModel(createUserModelLoginDetails);
			try {
				if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
				isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.CREATE_PARCELSHOP_USER_EMAIL_TEMPLATE));

				}
				
				if(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER)){
					isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.CREATE_POD_USER_EMAIL_TEMPLATE));//"manageparcelshoppouser.createuserpod.template"
				 log.error(" create isMailSent  parcel: "+isMailSent);

				}
			} 
			catch (Exception e) {
				log.error("EXCEPTION TYPE :",e);
				log.error("Exception occured in email helper : "+e.getMessage());
				isMailSent = false;
			}
			break;
			
      case Constants.UPDATE_USER_ACTION:
			
    	  
			ArrayList<String> toEmailidsUpdate = new ArrayList<>();
			
			
			if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
			for (ParcelShopsDto dto : manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getSelectedParcelshops()) {
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId1()))  && (dto.getEmailId1() != null) && !(Constants.NULL.equalsIgnoreCase(dto.getEmailId1())))
				{
					toEmailidsUpdate.add(dto.getEmailId1());
				}
				
				if(!(Constants.EMPTY_STRING.equalsIgnoreCase(dto.getEmailId2()))  && (dto.getEmailId2() != null) && !(Constants.NULL.equalsIgnoreCase(dto.getEmailId2())))
				{
					toEmailidsUpdate.add(dto.getEmailId2());
				}

			}}
			
			toEmailidsUpdate.add(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersSearchResultDto().getUserEmailId());
			
			 Set<String> toEmailidsUpdateSet = new HashSet<>();
			    toEmailidsUpdateSet.addAll(toEmailidsUpdate);
			    toEmailidsUpdate.clear();
			    toEmailidsUpdate.addAll(toEmailidsUpdateSet);
			
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty(Constants.FROM_EMAIL_ID));
			mailContent.setListOfTOAddress(toEmailidsUpdate);
			mailContent.setCc(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getLoggedInAdminEmailId());
			
			
			
			if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
				mailContent.setSubject(environment.getProperty(Constants.UPDATE_PARCELSHOP_USER_EMAIL_SUBJECT));
				}
				else if(Constants.USERTYPE_POD_USER.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
					mailContent.setSubject(environment.getProperty(Constants.UPDATE_POD_USER_EMAIL_SUBJECT));
				}
			
			Map <String, Object> updateUserModel = new HashMap <> ();
			updateUserModel.put("loginId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getLoginId());
			if(Constants.EMPTY_STRING.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId()) || manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId() == null)
			{
				updateUserModel.put("emailId", Constants.NO_CHANGE);
			}
			else{			
				updateUserModel.put("emailId", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getEmailId());
                }
			
			if(Constants.EMPTY_STRING.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserName()) || manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserName() == null)
			{
				updateUserModel.put("userName", Constants.NO_CHANGE);
			}
			else
			{
				updateUserModel.put("userName", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserName());
			}
			updateUserModel.put("removedParcelShopDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getDeletedParcelShops());
			updateUserModel.put("assignedParcelShopDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getAddedParcelShops());
			updateUserModel.put("removedServiceCenterDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getDeletedServiceCenters());
			updateUserModel.put("assignedServiceCenterDetails", manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getDeletedServiceCenters());
	        mailContent.setModel(updateUserModel);
	        
		
			try {
				if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
				isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.UPDATE_PARCELSHOP_USER_EMAIL_TEMPLATE));

				}
				
				if(Constants.USERTYPE_POD_USER.equalsIgnoreCase(manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().getUserType())){
					isMailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty(Constants.UPDATE_POD_USER_EMAIL_TEMPLATE));}

			} 
			catch (Exception e) {
				log.error("EXCEPTION TYPE :",e);
				log.error("Exception occured in email helper : "+e.getMessage());
				isMailSent = false;
			}
			break;
		default:
			isMailSent = false;
			break;
		}
		
		return isMailSent;
	}
	
	
}
