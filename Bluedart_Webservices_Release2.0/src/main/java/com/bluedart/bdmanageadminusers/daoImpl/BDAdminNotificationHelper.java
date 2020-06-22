package com.bluedart.bdmanageadminusers.daoImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.bdmanageadminusers.dto.NotificationDto;
import com.bluedart.common.dao.MailLinkDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.entity.MailLink;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.EmailUtil;

/**
 * 
 * @author PR334023
 * Helper class for Email notifications in BlueDart admin functionality
 *
 */
@Component
@PropertySource("classpath:emailConfig.properties")
public class BDAdminNotificationHelper extends BaseDaoImpl{

	@Autowired
	private MailLinkDao mailLinkDao;
	
	@Autowired
	private Environment environment;
	
	private EmailContent mailContent = null;
	
	private static final Logger notificationLogger = Logger.getLogger(BDAdminNotificationHelper.class);
	
	/**
	 * Method to send email notification
	 * @param notificationDto
	 * @return
	 */
	@Transactional
	public boolean sendEmailNotification(NotificationDto notificationDto) {
		notificationLogger.info("sendEmailNotification : "+System.currentTimeMillis());
		notificationLogger.debug("BDAdminNotificationHelper :: sendEmailNotification");
		String interfaceCode = "0";
		boolean isEmailSent = false;
		
		if (null != notificationDto && null != notificationDto.getBdAdminDto()
				&& notificationDto.getBdAdminDto().getUserType().equalsIgnoreCase(BDAdminConstants.ADMIN)) {
			interfaceCode = "13";
		}else if (null != notificationDto && null != notificationDto.getBdAdminDto()
				&& notificationDto.getBdAdminDto().getUserType().equalsIgnoreCase(BDAdminConstants.SALES_ADMIN)){
			interfaceCode = "14";
		}
		 
		switch (notificationDto.getAction()) {
		case "CREATE":
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty("fromEmailId"));
			mailContent.setTo(notificationDto.getBdAdminDto().getEmailId());
			mailContent.setSubject(environment.getProperty("bdmanageadmins.createuser.subject"));
			
	        Map <String, Object> createUserModel = new HashMap <> ();
	        createUserModel.put("employeename", notificationDto.getBdAdminDto().getEmployeeName());
	        createUserModel.put("loginid", notificationDto.getBdAdminDto().getToLoginId()); 
	        createUserModel.put("role", notificationDto.getBdAdminDto().getUserType()); 
	        createUserModel.put("url", notificationDto.getBdAdminDto().getSiteURL());  
	        mailContent.setModel(createUserModel);
	        
	        try {
	        	isEmailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty("bdmanageadmins.createuser.template"));
			}catch (Exception e) {
				isEmailSent=false;
				
				notificationLogger.error("EXCEPTION TYPE :",e);
		
				//notificationLogger.error(e);
			}
	        
        	List<MailLink> createMailLinkData = mailLinkDao.getEmailIds(notificationDto.getBdAdminDto().getUserRegions(), interfaceCode);
			for (MailLink mailLink : createMailLinkData) {
				EmailContent emailData = setEmailData(mailLink);
				
				notificationDto.setMailLink(mailLink);
				emailData.setSubject(environment.getProperty("bdmanageadmins.createadmin.subject"));
		        Map <String, Object> createAdminModel = new HashMap <> ();
		        createAdminModel.put("role", notificationDto.getBdAdminDto().getUserType());
		        createAdminModel.put("employeecode", notificationDto.getBdAdminDto().getEmployeeCode()); 
		        createAdminModel.put("adminrole", notificationDto.getBdAdminDto().getAdminRole());  
		        createAdminModel.put("adminemployeecode", notificationDto.getBdAdminDto().getAdminEmpCode()); 
		      
				StringBuilder builder = new StringBuilder();
				for(String reg : notificationDto.getBdAdminDto().getUserRegions()) {
				    builder.append(reg);
				    builder.append(",");
				}
				builder.deleteCharAt(builder.length() - 1).toString();
				
		        createAdminModel.put("region", builder.toString());  
		        emailData.setModel(createAdminModel);
		        
				try {
					isEmailSent = EmailUtil.sendEmailWithImage(emailData,environment.getProperty("bdmanageadmins.createadmin.template"));
				} catch(Exception e) {
					isEmailSent=false;
					notificationLogger.error("EXCEPTION TYPE :",e);
			
					
					//notificationLogger.error(e);
				} 
			}
			break;
		case "UPDATE":
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty("fromEmailId"));
			mailContent.setTo(notificationDto.getBdAdminDto().getEmailId());
			mailContent.setSubject(environment.getProperty("bdmanageadmins.modifyuser.subject"));
			
	        Map <String, Object> editUserModel = new HashMap <> ();
	        editUserModel.put("employeename", notificationDto.getBdAdminDto().getEmployeeName());
	       
	        StringBuilder builder = new StringBuilder();
			for(String reg : notificationDto.getBdAdminDto().getUserRegions()) {
			    builder.append(reg);
			    builder.append(",");
			}
			builder.deleteCharAt(builder.length() - 1).toString();
			
			editUserModel.put("region", builder.toString());  
	        editUserModel.put("usertype", notificationDto.getBdAdminDto().getUserType()); 
	        editUserModel.put("url", notificationDto.getBdAdminDto().getSiteURL());
	        editUserModel.put("loginid", notificationDto.getBdAdminDto().getToLoginId()); 
	        mailContent.setModel(editUserModel);
	        
			try {
				isEmailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty("bdmanageadmins.modifyuser.template"));
			} catch( Exception e) {
				isEmailSent = false;
				
				notificationLogger.error("EXCEPTION TYPE :",e);
		
				
				//notificationLogger.error(e);
			} 
	        
        	List<MailLink> mailLinkDetails = mailLinkDao.getEmailIds(notificationDto.getBdAdminDto().getUserRegions(), interfaceCode);
			for (MailLink mailLink : mailLinkDetails) {
				EmailContent emailData = setEmailData(mailLink);
				
				notificationDto.setMailLink(mailLink);
				emailData.setSubject(environment.getProperty("bdmanageadmins.modifyadmin.subject"));
		        Map <String, Object> editAdminModel = new HashMap <> ();
		        editAdminModel.put("employeecode", notificationDto.getBdAdminDto().getEmployeeCode()); 
		        
		        StringBuilder sbuilder = new StringBuilder();
				for(String reg : notificationDto.getBdAdminDto().getUserRegions()) {
				    sbuilder.append(reg);
				    sbuilder.append(",");
				}
				sbuilder.deleteCharAt(sbuilder.length() - 1).toString();
				
				editAdminModel.put("region", sbuilder.toString()); 
		        editAdminModel.put("usertype", notificationDto.getBdAdminDto().getUserType());  
		        emailData.setModel(editAdminModel);
		        
				try {
					isEmailSent = EmailUtil.sendEmailWithImage(emailData,environment.getProperty("bdmanageadmins.modifyadmin.template"));
				} catch( Exception e) {
					isEmailSent=false;
					
					notificationLogger.error("EXCEPTION TYPE :",e);
			
					//notificationLogger.error(e);
				} 
	        }
			break;
		case "DEACTIVATE":
			notificationLogger.info("sendEmailNotification DEACTIVATE : "+System.currentTimeMillis());
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty("fromEmailId"));
			mailContent.setTo(notificationDto.getBdAdminDto().getEmailId());
			mailContent.setSubject(environment.getProperty("bdmanageadmins.deactivateuser.subject"));
			
	        Map <String, Object> deactivateUserModel = new HashMap <> ();
	        deactivateUserModel.put("employeename", notificationDto.getBdAdminDto().getEmployeeName());
	        mailContent.setModel(deactivateUserModel);
	        notificationLogger.info("sendEmailNotification DEACTIVATE sending user email : "+System.currentTimeMillis());
			try {
				isEmailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty("bdmanageadmins.deactivateuser.template"));
				notificationLogger.info("sendEmailNotification DEACTIVATE user email sent : "+System.currentTimeMillis());
			} catch( Exception e) {
				isEmailSent=false;
				notificationLogger.error("EXCEPTION TYPE :",e);
		
			}
			notificationLogger.info("sendEmailNotification DEACTIVATE fetching group email : "+System.currentTimeMillis());
        	List<MailLink> deactivateMailLinkData = mailLinkDao.getEmailIds(notificationDto.getBdAdminDto().getUserRegions(), interfaceCode);
			for (MailLink mailLink : deactivateMailLinkData) {
				notificationLogger.info("sendEmailNotification DEACTIVATE sending group email : "+System.currentTimeMillis());
				EmailContent emailData = setEmailData(mailLink);
				
				notificationDto.setMailLink(mailLink);
				emailData.setSubject(environment.getProperty("bdmanageadmins.deactivateadmin.subject"));
		        Map <String, Object> deactivateAdminModel = new HashMap <> ();
		        deactivateAdminModel.put("employeecode", notificationDto.getBdAdminDto().getToLoginId());  
		        deactivateAdminModel.put("adminemployeecode", notificationDto.getBdAdminDto().getAdminEmpCode());  
		        emailData.setModel(deactivateAdminModel);
		        
				try {
					isEmailSent = EmailUtil.sendEmailWithImage(emailData,environment.getProperty("bdmanageadmins.deactivateadmin.template"));
					notificationLogger.info("sendEmailNotification DEACTIVATE group email sent : "+System.currentTimeMillis());
				} catch( Exception e) {
					isEmailSent=false;
					notificationLogger.error("EXCEPTION TYPE :",e);
			
					//notificationLogger.error(e);
				}  
	        }
			break;
		case "ACTIVATE":
			notificationLogger.info("sendEmailNotification ACTIVATE : "+System.currentTimeMillis());
			mailContent = new EmailContent();
			mailContent.setFrom(environment.getProperty("fromEmailId"));
			mailContent.setTo(notificationDto.getBdAdminDto().getEmailId());
			mailContent.setSubject(environment.getProperty("bdmanageadmins.reactivateuser.subject"));
			
	        Map <String, Object> activateUserModel = new HashMap <> ();
	        activateUserModel.put("employeename", notificationDto.getBdAdminDto().getEmployeeName());
	        activateUserModel.put("employeecode", notificationDto.getBdAdminDto().getEmployeeCode());   
	        mailContent.setModel(activateUserModel);
	        
			try {
				notificationLogger.info("sendEmailNotification ACTIVATE user sending email : "+System.currentTimeMillis());
				isEmailSent = EmailUtil.sendEmailWithImage(mailContent,environment.getProperty("bdmanageadmins.reactivateuser.template"));
				notificationLogger.info("sendEmailNotification ACTIVATE user email sent : "+System.currentTimeMillis());
			} catch(Exception e) {
				isEmailSent=false;
				
				notificationLogger.error("EXCEPTION TYPE :",e);
		
				//notificationLogger.error(e);
			} 
			notificationLogger.info("sendEmailNotification ACTIVATE fetching group email : "+System.currentTimeMillis());
	        List<MailLink> activateMailLink = mailLinkDao.getEmailIds(notificationDto.getBdAdminDto().getUserRegions(), interfaceCode);
			for (MailLink mailLink : activateMailLink) {
				notificationLogger.info("sendEmailNotification ACTIVATE sending group email : "+System.currentTimeMillis());
				EmailContent emailData = setEmailData(mailLink);
				
				notificationDto.setMailLink(mailLink);
				emailData.setSubject(environment.getProperty("bdmanageadmins.reactivateadmin.subject"));
		        Map <String, Object> activateAdminModel = new HashMap <> ();
		        activateAdminModel.put("employeecode", notificationDto.getBdAdminDto().getEmployeeCode());
		        activateAdminModel.put("role", notificationDto.getBdAdminDto().getAdminRole()); 
		        emailData.setModel(activateAdminModel);
		        
				try {
					isEmailSent = EmailUtil.sendEmailWithImage(emailData,environment.getProperty("bdmanageadmins.reactivateadmin.template"));
					notificationLogger.info("sendEmailNotification ACTIVATE group email sent : "+System.currentTimeMillis());
				} catch( Exception e) {
					isEmailSent=false;
					notificationLogger.error("EXCEPTION TYPE :",e);
			
					//notificationLogger.error(e);
				} 
			}
			break;
		}
		return isEmailSent;
	}

	/**
	 * Method to set Email - from,To,Cc in EmailContent
	 * @param mailLink
	 * @return
	 */
	private EmailContent setEmailData(MailLink mailLink){
		notificationLogger.debug("BDAdminNotificationHelper :: setEmailData");
		mailContent = new EmailContent();
        mailContent.setFrom(environment.getProperty("fromEmailId"));
        
        String toIds = mailLink.getcMailTo(); 
        List listOfToIds = (List) Arrays.asList(toIds.split(";"));
        if(listOfToIds != null && listOfToIds.size() == 1)
        	mailContent.setTo(toIds);
        else if(listOfToIds!= null && listOfToIds.size() >1)
        	mailContent.setListOfCCAddress(listOfToIds);
      
        String ccIds = mailLink.getcMailCC();  
        List listOfCcIds = (List) Arrays.asList(ccIds.split(";"));
        if(listOfCcIds != null && listOfCcIds.size() == 1)
        	mailContent.setCc(ccIds);
        else if(listOfCcIds!= null && listOfCcIds.size() >1)
        	mailContent.setListOfCCAddress(listOfCcIds);
        return mailContent;
	}
	
}