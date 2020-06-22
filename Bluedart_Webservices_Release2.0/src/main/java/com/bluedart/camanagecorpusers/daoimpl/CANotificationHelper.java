package com.bluedart.camanagecorpusers.daoimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.utils.EmailUtil;

/**
 * Helper class for sending email notifications in BlueDart admin functionality
 * @author PR334023
 *
 */
@Component
@PropertySource("classpath:emailConfig.properties")
public class CANotificationHelper extends BaseDaoImpl{

	private static final Logger notificationLogger = Logger.getLogger(CANotificationHelper.class);
	
	@Autowired
	private Environment environment;
	
	/**
	 * Method to send email notification
	 * 
	 * @param notificationDto
	 * @return
	 */
	public boolean sendEmailNotification(CorporateNotificationDto notificationDto) {
		notificationLogger.debug("CANotificationHelper :: sendEmailNotification");
		boolean isMailSent = false;
		 
		switch (notificationDto.getAction()) {
		case "CREATE_CORP_USER":
			EmailContent createMailCotent = new EmailContent();
			createMailCotent.setFrom(environment.getProperty("fromEmailId"));
			createMailCotent.setTo(notificationDto.getUserBasicDetailsDto().getEmailId());
			createMailCotent.setSubject(environment.getProperty("ca.modifyuser.subject"));
			
			Map <String, Object> createUserModel = new HashMap <> ();
			createUserModel.put("username", notificationDto.getUserBasicDetailsDto().getName());
			createUserModel.put("loginid", notificationDto.getUserBasicDetailsDto().getLoginId());
			createUserModel.put("adminloginid", notificationDto.getUserBasicDetailsDto().getClientAdminId());
			createUserModel.put("url", environment.getProperty("bluedart.siteurl"));
			createUserModel.put("password", notificationDto.getUserBasicDetailsDto().getPassword());  
	        createMailCotent.setModel(createUserModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailNotification(createMailCotent,environment.getProperty("caCreateUser-template.vm"));
			} catch(MessagingException e) {
				notificationLogger.error("EXCEPTION TYPE :",e);
			
				//notificationLogger.error(e);
				isMailSent = false;
			} catch (VelocityException e) {
				notificationLogger.error("EXCEPTION TYPE :",e);
			
				
				//notificationLogger.error(e);
				isMailSent = false;
			} catch (IOException e) {
				notificationLogger.error("EXCEPTION TYPE :",e);
			
				//notificationLogger.error(e);
				isMailSent = false;
			}
	        
			/*mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty("fromEmailId"));
			mailContent.setTo(notificationDto.getUserBasicDetailsDto().getEmailId());
			mailContent.setSubject(environment.getProperty("ca.modifyadmin.subject"));
			
			Map <String, Object> createAdminModel = new HashMap <> ();
			createAdminModel.put("adminloginid", notificationDto.getUserBasicDetailsDto().getAdminName());  
			createAdminModel.put("loginid", notificationDto.getUserBasicDetailsDto().getLoginId());  
	        mailContent.setModel(createAdminModel);
	        
			try {
				isMailSent = EmailUtil.sendEmailNotification(mailContent,environment.getProperty("caCreateAdmin-template.vm"));
			} catch(MessagingException e) {
				isMailSent = false;
			} catch (VelocityException e) {
				isMailSent = false;
			} catch (IOException e) {
				isMailSent = false;
			}*/
			break;
	case "DEACTIVATE_CORP_USER":
		EmailContent deactivateMailContent = new EmailContent();
		deactivateMailContent.setFrom(environment.getProperty("fromEmailId"));
		deactivateMailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
		deactivateMailContent.setSubject(environment.getProperty("ca.deactivateuser.subject"));
		
		Map <String, Object> deactivateAdminModel = new HashMap <> ();
		deactivateAdminModel.put("username", notificationDto.getCorporateUserDto().getName());
		deactivateAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());
        deactivateMailContent.setModel(deactivateAdminModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(deactivateMailContent,environment.getProperty("ca.deactivateuser.template"));
		} catch(MessagingException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		} catch (VelocityException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		} catch (IOException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		}
        
		/*mailContent = new EmailContent();
		mailContent.setFrom(environment.getProperty("fromEmailId"));
		mailContent.setTo(notificationDto.getUserBasicDetailsDto().getEmailId());
		mailContent.setSubject(environment.getProperty("ca.deactivateadmin.subject"));
		
		Map <String, Object> deactivateUserModel = new HashMap <> ();
        deactivateUserModel.put("loginid", notificationDto.getUserBasicDetailsDto().getLoginId());  
        mailContent.setModel(deactivateUserModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(mailContent,environment.getProperty("ca.deactivateadmin.template"));
		} catch(MessagingException e) {
			isMailSent = false;
		} catch (VelocityException e) {
			isMailSent = false;
		} catch (IOException e) {
			isMailSent = false;
		}*/
		break;
	case "ACTIVATE_CORP_USER":
		EmailContent activateMailContent = new EmailContent();
		activateMailContent.setFrom(environment.getProperty("fromEmailId"));
		activateMailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
		activateMailContent.setSubject(environment.getProperty("ca.activateuser.subject"));
		
		Map <String, Object> activateAdminModel = new HashMap <> ();
		activateAdminModel.put("username", notificationDto.getCorporateUserDto().getName());
		activateAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());
		activateAdminModel.put("password", notificationDto.getCorporateUserDto().getPassword());
        activateMailContent.setModel(activateAdminModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(activateMailContent,environment.getProperty("ca.activateuser.template"));
		} catch(MessagingException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		} catch (VelocityException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		} catch (IOException e) {
		
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		}
        
		/*mailContent = new EmailContent();
		mailContent.setFrom(environment.getProperty("fromEmailId"));
		mailContent.setTo(notificationDto.getUserBasicDetailsDto().getEmailId());
		mailContent.setSubject(environment.getProperty("ca.activateadmin.subject"));
		
		Map <String, Object> activateUserModel = new HashMap <> ();
        activateUserModel.put("loginid", notificationDto.getUserBasicDetailsDto().getLoginId());  
        mailContent.setModel(activateUserModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(mailContent,environment.getProperty("ca.activateadmin.template"));
		} catch(MessagingException e) {
			isMailSent = false;
		} catch (VelocityException e) {
			isMailSent = false;
		} catch (IOException e) {
			isMailSent = false;
		}*/
		break;
	case "RESET_PWD_CORP_USER":
		EmailContent resetPwdMailContent = new EmailContent();
		resetPwdMailContent.setFrom(environment.getProperty("fromEmailId"));
		resetPwdMailContent.setTo(notificationDto.getCorporateUserDto().getEmailId());
		resetPwdMailContent.setSubject(environment.getProperty("ca.resetpwduser.subject"));
		
		Map <String, Object> resetAdminModel = new HashMap <> ();
		resetAdminModel.put("username", notificationDto.getCorporateUserDto().getName());
		resetAdminModel.put("url", environment.getProperty("bluedart.siteurl"));
		resetAdminModel.put("loginid", notificationDto.getCorporateUserDto().getLoginId());
		resetAdminModel.put("password", notificationDto.getCorporateUserDto().getPassword());
        resetPwdMailContent.setModel(resetAdminModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(resetPwdMailContent,environment.getProperty("ca.resetpwduser.template"));
		} catch(MessagingException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
			} catch (VelocityException e) {
				notificationLogger.error("EXCEPTION TYPE :",e);
			
				//notificationLogger.error(e);
			isMailSent = false;
		} catch (IOException e) {
			notificationLogger.error("EXCEPTION TYPE :",e);
		
			//notificationLogger.error(e);
			isMailSent = false;
		}
        
		/*mailContent = new EmailContent();
		mailContent.setFrom(environment.getProperty("fromEmailId"));
		mailContent.setTo(notificationDto.getUserBasicDetailsDto().getEmailId());
		mailContent.setSubject(environment.getProperty("ca.resetpwdadmin.subject"));
		
		Map <String, Object> resetUserModel = new HashMap <> ();
		resetUserModel.put("loginid", notificationDto.getUserBasicDetailsDto().getLoginId());  
        mailContent.setModel(resetUserModel);
        
		try {
			isMailSent = EmailUtil.sendEmailNotification(mailContent,environment.getProperty("ca.resetpwdadmin.template"));
		} catch(MessagingException e) {
			isMailSent = false;
		} catch (VelocityException e) {
			isMailSent = false;
		} catch (IOException e) {
			isMailSent = false;
		}*/
		break;
	}
		return isMailSent;
	}
}