package com.bluedart.emailnotification;

import java.rmi.RemoteException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.exception.BlueDartException;
@RestController
public class MailNotificationController {
	
	
	@RequestMapping(value = "/mailNotificationService/test")
	public void test() throws BlueDartException, RemoteException, MessagingException {

		/* 
		
		 EmailContent mailContent = new EmailContent();
	        mailContent.setFrom("response@bluedart.com");
	        
	        String toIds = "chadnana.hadagali@wipro.com";
	        List listOfToIds = (List) Arrays.asList(toIds.split(";"));
	        //System.out.println(listOfToIds.size());
	        if(listOfToIds != null && listOfToIds.size() == 1)
	        	mailContent.setTo(toIds);
	        else if(listOfToIds!= null && listOfToIds.size() >1)
	        	mailContent.setListOfCCAddress(listOfToIds);
	      
	        String ccIds = "divya@wipro.com;chandana@wipro.com;priyanka@wipro.com";
	        List listOfCcIds = (List) Arrays.asList(ccIds.split(";"));
	        //System.out.println(listOfToIds.size());
	        if(listOfCcIds != null && listOfCcIds.size() == 1)
	        	mailContent.setTo(ccIds);
	        else if(listOfCcIds!= null && listOfCcIds.size() >1)
	        	mailContent.setListOfCCAddress(listOfCcIds);
	        
	       // userLicenceKeyGeneration-template
	        mailContent.setSubject("BlueDart account License Key generated");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("apiType", "Tracking");
	        model.put("loginId", "chandana1234");
	        model.put("userName", "Chandana");
	        model.put("licenseKey", "ABCD12345");
	        model.put("versionNumber", "2.0");
	        mailContent.setModel(model);
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"userLicenceKeyGeneration-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	        
	        
	        /*// adminLicenceKeyGeneration-template
	        mailContent.setSubject("BlueDart account License Key generated");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("apiType", "Tracking");
	        model.put("userName", "Chandana Hadagali");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"adminLicenceKeyGeneration-template.vm");
	        System.out.println(isMailSent);*/
		    
	        
	        
	        /*// userLicenceKeyDelete-template
	        mailContent.setSubject("BlueDart account License Key deleted");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("apiType", "Tracking");
	        model.put("userName", "Chandana Hadagali");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"userLicenceKeyDelete-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	        
	        /*// adminLicenceKeyDelete-template
	        mailContent.setSubject("BlueDart account License Key deleted");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("apiType", "Tracking");
	        model.put("userName", "Chandana Hadagali");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"adminLicenceKeyDelete-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	        /*// createUser-template
	        mailContent.setSubject("User created under BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeName", "Priyanka");
	        model.put("loginId", "chandana12345");
	        model.put("role", "Admin");
	        model.put("url", "http://adminportalurl.com");
	        model.put("password", "abcd@1234");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"createUser-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	       
	        
	        /*// createAdmin-template
	        mailContent.setSubject("User created under BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("role", "Admin");
	        model.put("employeeCode", "P12345");
	        model.put("adminRole", "Super Admin");
	        model.put("adminEmployeeCode", "AP12345");
	        model.put("region", "Bangalore,Mumbai");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"createAdmin-template.vm");
	        System.out.println(isMailSent);*/
			
	        
	       /* // modifyUser-template
	        mailContent.setSubject("User modified by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeName", "Priyanka");
	        model.put("region", "Bangalore,Mumbai");
	        model.put("userType", "User Type");
	        model.put("url", "http://adminportalurl.com");
	        model.put("loginId", "chandana12345");
	        model.put("password", "abcd@1234");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"modifyUser-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	       /* //modifyAdmin-template
	        mailContent.setSubject("User modified by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeCode", "PR123456");
	        model.put("region", "Bangalore,Mumbai");
	        model.put("userType", "User Type");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"modifyAdmin-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	        /*//deactivateUser-template
	        mailContent.setSubject("User deactivated by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeName", "Priyanka");
	        
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"deactivateUser-template.vm");
	        System.out.println(isMailSent); */
	        
	       /*//deactivateAdmin-template
	        mailContent.setSubject("User deactivated by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeCode", "PI12345");
	        model.put("adminEmployeeCode", "AD4567");
	        
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"deactivateAdmin-template.vm");
	        System.out.println(isMailSent); 
	        */
	        
	      /*//re-activateUser-template
	        mailContent.setSubject("User reactivated by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("employeeName", "Priyanka");
	        model.put("employeeCode", "PI4567");
	        model.put("password", "abcd1234");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"reactivateUser-template.vm");
	        System.out.println(isMailSent); */
	        
	        /*//re-activateUser-template
	        mailContent.setSubject("User reactivated by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	     
	        model.put("employeeCode", "PI4567");
	        model.put("role", "Admin");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"reactivateAdmin-template.vm");
	        System.out.println(isMailSent); */
	        
	       /* //userPasswordReset-template
	        mailContent.setSubject("Password Reset by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("url", "http://adminportalurl.com");
	        model.put("loginId", "chandana12345");
	        model.put("password", "abcd@1234");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"userPasswordReset-template.vm");
	        System.out.println(isMailSent); */
	        
	       /* //adminPasswordReset-template
	        mailContent.setSubject("Password Reset by BD Admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("loginId", "chandana12345");
	        model.put("adminName", "Admin");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"adminPasswordReset-template.vm");
	        System.out.println(isMailSent);
	        */
	        
	        /*//reactivateCorporateUser-template
	        mailContent.setSubject("Corporate account activated by BD admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("loginId", "chandana12345");
	        model.put("password", "abcd@1234");
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"reactivateCorporateUser-template.vm");
	        System.out.println(isMailSent);*/
	        
	        
	        
	        /* //reactivateCorporateAdmin-template
	        mailContent.setSubject("Corporate account activated by BD admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("adminName", "Super Admin");
	        model.put("loginId", "chandana12345");
	        
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"reactivateCorporateAdmin-template.vm");
	        System.out.println(isMailSent); */
	        
	        
	        /*//deactivateCorporateUser-template
	        mailContent.setSubject("Corporate account deactivated by BD admin");
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"deactivateCorporateUser-template.vm");
	        System.out.println(isMailSent); */
	        
	       /* //deactivateCorporateAdmin-template
	        mailContent.setSubject("Corporate account deactivated by BD admin");
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("adminName", "Super Admin");
	        model.put("loginId", "chandana12345");
	        
	        mailContent.setModel(model);
	 
	        boolean isMailSent =  EmailUtil.sendEmailNotification(mailContent,"deactivateCorporateAdmin-template.vm");
	        System.out.println(isMailSent); 
	       */ 
	       
	}


}
