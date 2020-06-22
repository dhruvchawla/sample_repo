package com.bluedart.bdmanagecorporateusers.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bluedart.common.dao.MailLinkDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.utils.EmailUtil;

/**
 * Helper class for sending email notifications in BlueDart admin functionality
 * @author PR334023
 *
 */
@Component
@PropertySource("classpath:emailConfig.properties")
public class BDCorporateNotificationHelper extends BaseDaoImpl{

	private static final Logger bdlogger = Logger.getLogger(BDCorporateNotificationHelper.class);
	
	@Autowired
	private MailLinkDao mailLinkDao;
	
	@Autowired
	private Environment environment;

	/**
	 * Method to send email notification
	 * @param notificationDto
	 * @return
	 */
	public boolean sendEmailNotification(CorporateNotificationDto notificationDto) {
		bdlogger.debug("BDCorporateNotificationHelper :: sendEmailNotification");
		boolean isMailSent = false;
		 
		switch (notificationDto.getAction()) {
		case "DEACTIVATE":
			StringBuilder loginIDs = new StringBuilder();
			String adminName = "";
			String adminEmailId = "";
			for (CorporateUserDto coUserDto : notificationDto.getCoList()) {
				if (loginIDs.length()==0) {
					loginIDs.append(coUserDto.getLoginId());
					adminName = coUserDto.getByAdminName();
					adminEmailId = coUserDto.getByEmailId();
				}else{
					loginIDs.append(", " + coUserDto.getLoginId());
				} 
				EmailContent deactivateUserContent = new EmailContent();
				deactivateUserContent.setFrom(environment.getProperty("fromEmailId"));
				deactivateUserContent.setTo(coUserDto.getEmailId());
				deactivateUserContent.setSubject(environment.getProperty("bdmanagecorporate.deactivateuser.subject"));
				
				Map <String, Object> deactivateUserModel = new HashMap <> ();
				deactivateUserModel.put("name", coUserDto.getName());
		     
				deactivateUserContent.setModel(deactivateUserModel);
		        
				try {
					isMailSent = EmailUtil.sendEmailWithImage(deactivateUserContent,environment.getProperty("bdmanagecorporate.deactivateuser.template"));
				} catch (VelocityException e) {
					isMailSent = false;
					bdlogger.error("EXCEPTION TYPE :",e);
					
					
				//	bdlogger.error(e);
				}
			}
			EmailContent deactivateAdminContent = new EmailContent();
			deactivateAdminContent.setFrom(environment.getProperty("fromEmailId"));
			deactivateAdminContent.setTo(adminEmailId);
			deactivateAdminContent.setSubject(environment.getProperty("bdmanagecorporate.deactivateadmin.subject"));
			
			Map <String, Object> deactivateAdminModel = new HashMap <> ();
	        deactivateAdminModel.put("adminname", adminName);
	        deactivateAdminModel.put("loginid", loginIDs.toString());  
	     
	        deactivateAdminContent.setModel(deactivateAdminModel);
	        try {
				isMailSent = EmailUtil.sendEmailWithImage(deactivateAdminContent,environment.getProperty("bdmanagecorporate.deactivateadmin.template"));
			} catch (Exception e) {
				isMailSent = false;
				
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			break;
		case "ACTIVATE":
			StringBuilder activatedLoginIDs = new StringBuilder();
			String activatedAdminName = "";
			String activatedAdminEmailId = "";
			for (CorporateUserDto coUserDto : notificationDto.getCoList()) {
				if (activatedLoginIDs.length()==0) {
					activatedLoginIDs.append(coUserDto.getLoginId());
					activatedAdminName = coUserDto.getByAdminName();
					activatedAdminEmailId = coUserDto.getByEmailId();
				}else{
					activatedLoginIDs.append("," + coUserDto.getLoginId());
				} 
				EmailContent activateUserContent = new EmailContent();
				activateUserContent.setFrom(environment.getProperty("fromEmailId"));
				activateUserContent.setTo(coUserDto.getEmailId());
				activateUserContent.setSubject(environment.getProperty("bdmanagecorporate.reactivateuser.subject"));
				
		        Map <String, Object> activateUserModel = new HashMap <> ();
		        activateUserModel.put("name", coUserDto.getName());
		        activateUserModel.put("loginid", coUserDto.getLoginId());
		        activateUserModel.put("password", coUserDto.getPassword());  
		        activateUserContent.setModel(activateUserModel);
				try {
					isMailSent = EmailUtil.sendEmailWithImage(activateUserContent,environment.getProperty("bdmanagecorporate.reactivateuser.template"));
				}catch(VelocityException e){
					isMailSent = false;
					bdlogger.error("EXCEPTION TYPE :",e);
					
					bdlogger.error(e);
				}
			}
			EmailContent activateAdminContent = new EmailContent();
			activateAdminContent.setFrom(environment.getProperty("fromEmailId"));
			activateAdminContent.setTo(activatedAdminEmailId);
			activateAdminContent.setSubject(environment.getProperty("bdmanagecorporate.reactivateadmin.subject"));
			
			 Map <String, Object> activateAdminModel = new HashMap <> ();
			 activateAdminModel.put("adminname", activatedAdminName);
			 activateAdminModel.put("loginid", activatedLoginIDs.toString());  
			 activateAdminContent.setModel(activateAdminModel);
			try {
				isMailSent = EmailUtil.sendEmailWithImage(activateAdminContent,environment.getProperty("bdmanagecorporate.reactivateadmin.template"));
			} catch (VelocityException e) {
				isMailSent=false;
				bdlogger.error("EXCEPTION TYPE :",e);
				
				bdlogger.error(e);
			}
			break;
		case "RESET_PASSWORD":
			EmailContent resetEmailContent = new EmailContent();
			resetEmailContent.setFrom(environment.getProperty("fromEmailId"));
			resetEmailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
			resetEmailContent.setSubject(environment.getProperty("bdmanagecorporate.resetpwduser.subject"));
			
	        Map <String, Object> resetUserModel = new HashMap <> ();
	        resetUserModel.put("employeename", notificationDto.getCorporateUserDto().getcCompName());
	        resetUserModel.put("url", notificationDto.getCorporateUserDto().getSiteUrl());  
	        resetUserModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
	        resetUserModel.put("password", notificationDto.getPassword());   
	        resetEmailContent.setModel(resetUserModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(resetEmailContent,environment.getProperty("bdmanagecorporate.resetpwduser.template"));
			} catch (VelocityException e) {
				isMailSent = false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			EmailContent resetMailContent = new EmailContent();
			resetMailContent.setFrom(environment.getProperty("fromEmailId"));
			resetMailContent.setTo(notificationDto.getCorporateUserDto().getByEmailId());
			resetMailContent.setSubject(environment.getProperty("bdmanagecorporate.resetpwdadmin.subject"));
			
			 Map <String, Object> resetAdminModel = new HashMap <> ();
			 resetAdminModel.put("adminname", notificationDto.getCorporateUserDto().getByAdminName());
			 resetAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
		     resetMailContent.setModel(resetAdminModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(resetMailContent,environment.getProperty("bdmanagecorporate.resetpwdadmin.template"));
			} catch (VelocityException e) {
				isMailSent=false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			break;
		case "BD_CREATE_USER":
			EmailContent createEmailContent = new EmailContent();
			createEmailContent.setFrom(environment.getProperty("fromEmailId"));
			createEmailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
			createEmailContent.setSubject(environment.getProperty("bdmanagecorporate.createuser.subject"));
			
	        Map <String, Object> createUserModel = new HashMap <> ();
	        createUserModel.put("username", notificationDto.getCorporateUserDto().getName());
	        createUserModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
	        createUserModel.put("password", notificationDto.getCorporateUserDto().getPassword());   
	        createUserModel.put("url", environment.getProperty("bluedart.siteurl"));   
	        createEmailContent.setModel(createUserModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(createEmailContent,environment.getProperty("bdmanagecorporate.createuser.template"));
			} catch (VelocityException e) {
				isMailSent = false;
				bdlogger.error("EXCEPTION TYPE :",e);
				
				//bdlogger.error(e);
			}
			EmailContent createMailContent = new EmailContent();
			createMailContent.setFrom(environment.getProperty("fromEmailId"));
			createMailContent.setTo(notificationDto.getCorporateUserDto().getByEmailId());
			createMailContent.setSubject(environment.getProperty("bdmanagecorporate.createadmin.subject"));
			
			 Map <String, Object> createAdminModel = new HashMap<>();
			 createAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
			 createMailContent.setModel(createAdminModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(createMailContent,environment.getProperty("bdmanagecorporate.createadmin.template"));
			} catch (VelocityException e) {
				isMailSent=false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			break;
		case "EDIT_USER":
			EmailContent editEmailContent = new EmailContent();
			editEmailContent.setFrom(environment.getProperty("fromEmailId"));
			editEmailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
			editEmailContent.setSubject(environment.getProperty("bdmanagecorporate.edituser.subject"));
			
	        Map <String, Object> editUserModel = new HashMap <> ();
	        editUserModel.put("username", notificationDto.getCorporateUserDto().getName());
	        editUserModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
	        editUserModel.put("emailid", notificationDto.getCorporateUserDto().getEmailId());  
	        editUserModel.put("mobileno", notificationDto.getCorporateUserDto().getMobileNo());   
	        editUserModel.put("url", environment.getProperty("bluedart.siteurl"));   
	        editEmailContent.setModel(editUserModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(editEmailContent,environment.getProperty("bdmanagecorporate.edituser.template"));
			} catch (VelocityException e) {
				isMailSent = false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			EmailContent editMailContent = new EmailContent();
			editMailContent.setFrom(environment.getProperty("fromEmailId"));
			editMailContent.setTo(notificationDto.getCorporateUserDto().getByEmailId());
			editMailContent.setSubject(environment.getProperty("bdmanagecorporate.editadmin.subject"));
			
			 Map <String, Object> editAdminModel = new HashMap<>();
			 editAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());  
			 editMailContent.setModel(editAdminModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailWithImage(editMailContent,environment.getProperty("bdmanagecorporate.editadmin.template"));
			} catch (VelocityException e) {
				isMailSent=false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			break;
		case "CREATE_OTP":
			EmailContent otpEmailContent = new EmailContent();
			otpEmailContent.setFrom(environment.getProperty("fromEmailId"));
			otpEmailContent.setTo(notificationDto.getEmailContent().getTo());
			otpEmailContent.setSubject(environment.getProperty("bdmanagecorporate.createotp.subject"));
			
	        Map <String, Object> otpModel = new HashMap <> ();
	        otpModel.put("otp", notificationDto.getPassword());   
	        otpEmailContent.setModel(otpModel);
			try {
				isMailSent = EmailUtil.sendEmailWithImage(otpEmailContent,environment.getProperty("bdmanagecorporate.createotp.template"));
			} catch (VelocityException e) {
				isMailSent = false;
				bdlogger.error("EXCEPTION TYPE :",e);
				//bdlogger.error(e);
			}
			break;
	}
		return isMailSent;
	}
}