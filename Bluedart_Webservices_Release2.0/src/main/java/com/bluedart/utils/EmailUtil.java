package com.bluedart.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.CollectionUtils;

import com.bluedart.common.dto.EmailContent;
import com.bluedart.exception.BlueDartException;

@Component
public class EmailUtil {

	/*
	 * To set Email configuration
	 */
	private static final Logger logger = Logger.getLogger(EmailUtil.class);
	static VelocityEngine velocityEngine = new VelocityEngine();
	
	private static JavaMailSenderImpl setEmailConfig() {
	/*	Properties emailProperties = new Properties();

		try {
			emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
		} catch (IOException e) {
			logger.error("EXCEPTION TYPE",e);
			// TODO Auto-generated catch block
			logger.error("Error : "+e);
			throw new BlueDartException("", "");
		}*/


		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(SpringApplicationContext.schedulerProperty.getProperty("host"));
		mailSender.setPort(Integer.parseInt(SpringApplicationContext.schedulerProperty.getProperty("port")));

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", SpringApplicationContext.schedulerProperty.getProperty("host"));
		properties.setProperty("mail.smtp.auth", "false");
		mailSender.setJavaMailProperties(properties);
		return mailSender;
	}

	/*
	 * To set Email Content
	 */
	private static SimpleMailMessage setEmailContent(EmailContent emailContent) {
		boolean msg = false;
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		if (emailContent.getFrom() != null && emailContent.getFrom().length() > 0) {
			mailMessage.setFrom(emailContent.getFrom());
			msg = true;
		}
		if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
			mailMessage.setTo(emailContent.getTo());
			mailMessage.setReplyTo(emailContent.getTo());
			msg = true;
		} else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
				&& emailContent.getListOfTOAddress().size() > 0) {
			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
			mailMessage.setTo(emailIdsTosends);
			msg = true;
		}
		if (emailContent.getCc() != null && emailContent.getCc().length() > 0) {
			mailMessage.setCc(emailContent.getCc());
		}
		if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
				&& emailContent.getListOfCCAddress().size() > 0) {
			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
			mailMessage.setCc(listOfCCMailIds);
		}
		if (emailContent != null && emailContent.getBcc() != null && emailContent.getBcc().length() > 0) {
			mailMessage.setBcc(emailContent.getBcc());
		}
		if (emailContent.getSubject() != null && emailContent.getSubject().length() > 0) {
			mailMessage.setSubject(emailContent.getSubject());
		} else {
			mailMessage.setSubject("No Subject!");
		}
		if (emailContent.getText() != null && emailContent.getText().length() > 0) {
			mailMessage.setText(emailContent.getText());
		} else {
			mailMessage.setText("From BlueDart");
		}
		if (!msg)
			return null;
		
		mailMessage.setFrom(emailContent.getFrom());
		mailMessage.setTo(emailContent.getTo());
		mailMessage.setSubject(emailContent.getSubject());
		mailMessage.setText(emailContent.getText());

		return mailMessage;
	}

	
	public static boolean sendEmailForScheduler(EmailContent emailContent) throws MessagingException {

		boolean isSent = false;
		boolean msg = false;
		JavaMailSenderImpl mailSender = setEmailConfig();

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		if (emailContent.getFrom() != null && emailContent.getFrom().length() > 0) {
			helper.setFrom(emailContent.getFrom());
			msg = true;
		}
		if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
			helper.setTo(emailContent.getTo());
			msg = true;
		} else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
				&& emailContent.getListOfTOAddress().size() > 0) {
			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
			helper.setTo(emailIdsTosends);
			msg = true;
		}
		if (emailContent.getCc() != null && emailContent.getCc().length() > 0) {
			helper.setCc(emailContent.getCc());
		}
		if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
				&& emailContent.getListOfCCAddress().size() > 0) {
			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
			helper.setCc(listOfCCMailIds);
		}
		if (emailContent != null && emailContent.getBcc() != null && emailContent.getBcc().length() > 0) {
			helper.setBcc(emailContent.getBcc());
		}
		if (emailContent.getSubject() != null && emailContent.getSubject().length() > 0) {
			helper.setSubject(emailContent.getSubject());
		} else {
			helper.setSubject("No Subject!");
		}
		if (emailContent.getText() != null && emailContent.getText().length() > 0) {
			message.setContent(emailContent.getText(), "text/html");
		} else {
			message.setContent("From BlueDart","text/html");
		}
		if (!msg) {
			isSent = false;
		} else {
			try {
				if (null != emailContent.getTo()){
					mailSender.send(message);
					isSent = true;
				} else {
					isSent = false;
				}
			} catch (Exception exception) {
				isSent = false;
				logger.error("EXCEPTION TYPE",exception);
				logger.error("Error : "+exception);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
		}
		return isSent;
	
	}
	
	
	public static boolean sendEmailWithAttachment(EmailContent emailContent, Multipart mp) throws MessagingException {

		boolean isSent = false;
		boolean msg = false;
		JavaMailSenderImpl mailSender = setEmailConfig();

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		if (emailContent.getFrom() != null && emailContent.getFrom().length() > 0) {
			helper.setFrom(emailContent.getFrom());
			msg = true;
		}
		if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
			helper.setTo(emailContent.getTo());
			msg = true;
		} else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
				&& emailContent.getListOfTOAddress().size() > 0) {
			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
			helper.setTo(emailIdsTosends);
			msg = true;
		}
		if (emailContent.getCc() != null && emailContent.getCc().length() > 0) {
			helper.setCc(emailContent.getCc());
		}
		if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
				&& emailContent.getListOfCCAddress().size() > 0) {
			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
			helper.setCc(listOfCCMailIds);
		}
		if (emailContent != null && emailContent.getBcc() != null && emailContent.getBcc().length() > 0) {
			helper.setBcc(emailContent.getBcc());
		}
		if (emailContent.getSubject() != null && emailContent.getSubject().length() > 0) {
			helper.setSubject(emailContent.getSubject());
		} else {
			helper.setSubject("No Subject!");
		}
		/*if (emailContent.getText() != null && emailContent.getText().length() > 0) {
			message.setContent(mp);
		} else {
			message.setContent("From BlueDart","text/html");
		}*/
		if(mp != null ) {
			message.setContent(mp);
		}else {
			message.setContent("From BlueDart","text/html");
		}
		
		
		if (!msg) {
			isSent = false;
		} else {
			try {
				if (null != emailContent.getTo()){
					mailSender.send(message);
					isSent = true;
				} else {
					isSent = false;
				}
			} catch (Exception exception) {
				isSent = false;
				logger.error("EXCEPTION TYPE",exception);
				logger.error("Error : "+exception);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
		}
		return isSent;
	
	}
	
	/*
	 * To send Email without html contents
	 */
	public static boolean sendEmail(EmailContent emailContent) throws MessagingException {
		boolean isSent = false;
		try{
			JavaMailSenderImpl mailSender = setEmailConfig();
			SimpleMailMessage mailMessage = setEmailContent(emailContent);

			if(mailMessage==null){
				isSent=false;
			}else {
				try{
					if (null != mailMessage.getTo() && mailMessage.getTo().length !=0) {
						mailSender.send(mailMessage);
						isSent = true;
					} else {
						isSent = false;
					}
					
				}catch(Exception exception){
					logger.error("EXCEPTION TYPE",exception);
					logger.error("Error : "+exception);
					isSent = false;
				}
			}
			
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE",exception);
			isSent = false;
		}
		return isSent;
	}

	public static boolean sendEmailWithHtmlText(EmailContent emailContent) throws MessagingException {
		boolean isSent = false;
		boolean msg = false;
		JavaMailSenderImpl mailSender = setEmailConfig();

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		if (emailContent.getFrom() != null && emailContent.getFrom().length() > 0) {
			helper.setFrom(emailContent.getFrom());
			msg = true;
		}
		if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
			helper.setTo(emailContent.getTo());
			msg = true;
		} else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
				&& emailContent.getListOfTOAddress().size() > 0) {
			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
			helper.setTo(emailIdsTosends);
			msg = true;
		}
		if (emailContent.getCc() != null && emailContent.getCc().length() > 0) {
			helper.setCc(emailContent.getCc());
		}
		if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
				&& emailContent.getListOfCCAddress().size() > 0) {
			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
			helper.setCc(listOfCCMailIds);
		}
		if (emailContent != null && emailContent.getBcc() != null && emailContent.getBcc().length() > 0) {
			helper.setBcc(emailContent.getBcc());
		}
		if (emailContent.getSubject() != null && emailContent.getSubject().length() > 0) {
			helper.setSubject(emailContent.getSubject());
		} else {
			helper.setSubject("No Subject!");
		}
		if (emailContent.getText() != null && emailContent.getText().length() > 0) {
			message.setContent(emailContent.getText(), "text/html");
		} else {
			message.setContent("<html><body><b>From BlueDart</b></body></html>", "text/html");
		}
		if (!msg) {
			isSent = false;
		} else {
			try {
				logger.info("Before Send");
				mailSender.send(message);
				logger.info("After Send");
				isSent = true;
			} catch (Exception exception) {
				isSent = false;
				logger.error("Error : "+exception);
				logger.error("EXCEPTION TYPE",exception);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
		}
		return isSent;
	}
	
	
	
	
	private static VelocityEngine getVelocityEngine() throws VelocityException, IOException,BlueDartException {
	        VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
	        Properties emailNotificationProperties = new Properties();
			try {
				emailNotificationProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream(Constants.EMAIL_CONFIGURATION__PROPERTIES));
			} catch (IOException e) {
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
	        
	        
	        Properties props = new Properties();
	        props.put("resource.loader", emailNotificationProperties.getProperty("resourceLoader"));
	        props.put("class.resource.loader.class", emailNotificationProperties.getProperty("resourceClassLoader"));
	       
	        velocityEngineFactory.setVelocityProperties(props);
	        return velocityEngineFactory.createVelocityEngine();
	    }
	 /*
	  * Method is used to send email notification
	  */
	 public static boolean sendEmailNotification(EmailContent emailContent,String templateName) throws MessagingException, VelocityException, IOException {
			boolean isSent = false;

			JavaMailSender mailSender = setEmailConfig();
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			 	if(emailContent.getSubject() != null)
			 		mimeMessageHelper.setSubject(emailContent.getSubject());
			 	mimeMessageHelper.setFrom(emailContent.getFrom());
	            if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
	            	mimeMessageHelper.setTo(emailContent.getTo());
	            } else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
	    				&& emailContent.getListOfTOAddress().size() > 0) {
	    			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
	    			mimeMessageHelper.setTo(emailIdsTosends);
	    		}
	            if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
	            	mimeMessageHelper.setCc(emailContent.getCc());
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& emailContent.getListOfCCAddress().size() > 0) {
	    			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
	    			mimeMessageHelper.setCc(listOfCCMailIds);
	    		}
	            mimeMessageHelper.setText(geContentFromTemplate(emailContent.getModel(),templateName), true);
	            
			if(mimeMessageHelper==null){
				isSent=false;
			}else {
				try{
					logger.info("Before Send");
					mailSender.send(mimeMessageHelper.getMimeMessage());
					 logger.info("After Send");
					isSent = true;
				}catch(BlueDartException exception){
					isSent = false;
					logger.error("EXCEPTION TYPE",exception);
					logger.error("Error : "+exception);
					//throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
				}
			}
			return isSent;
		}


		public static String geContentFromTemplate(Map<String, Object> model,String templateName) throws VelocityException, IOException {
	        StringBuffer emailContent = new StringBuffer();
	        try {
	        	//System.out.println("-----geContentFromTemplate--------");
	        	velocityEngine = getVelocityEngine();
	            emailContent.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/"+templateName, model));
	        } catch (BlueDartException e) {
	        	logger.error("Error : "+e);
	        	logger.error("EXCEPTION TYPE",e);
	        	throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
	        }
	        //System.out.println(emailContent.toString());
	        return emailContent.toString();
	    }
		/**
		 * Sending email notification with image
		 * @param emailContent
		 * @param templateName
		 * @return
		 */
		public static boolean sendEmailWithImageForAppreciationAndFeedback(EmailContent emailContent,String templateName) {
			//System.out.println("-----------sendEmailWithImage-------------------");
			boolean isEmailSent = false;
			HtmlEmail email = new HtmlEmail();
			Properties emailProperties = new Properties();
			try {
				emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
				email.setHostName(SpringApplicationContext.schedulerProperty.getProperty("host"));
				email.setSmtpPort(Integer.parseInt(SpringApplicationContext.schedulerProperty.getProperty("port")));
				if((emailContent.getTo()==null || emailContent.getTo()=="") && !(CollectionUtils.isEmpty(emailContent.getListOfTOAddress())) ){
					for (String toAdrs : emailContent.getListOfTOAddress()) {
						email.addTo(toAdrs);
					}
				}else{
					email.addTo(emailContent.getTo());
				}
				//email.addTo(emailContent.getTo());
				email.setFrom(emailContent.getFrom());
				email.setSubject(emailContent.getSubject());
				
				if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
					String[] ccArray = emailContent.getCc().split(";");
					for (String ccAdrs : ccArray) {
						email.addCc(ccAdrs);
					}
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& emailContent.getListOfCCAddress().size() > 0) {
	            	for (String ccAdrs : emailContent.getListOfCCAddress()) {
	            		email.addCc(ccAdrs);
					}
	    		}
				
				Map<String, Object> emailContentModal = emailContent.getModel();
				//File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
				//File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
				//String banner = email.embed(bannerFile);
				//String logo = email.embed(logoFile);
				if(emailContentModal==null){
					emailContentModal = new HashMap<>();
				}
				//emailContentModal.put("banner", banner);
				//emailContentModal.put("logo", logo);
				email.setHtmlMsg(geContentFromTemplate(emailContentModal,templateName));
				logger.info("Before Send");
				email.send();
				isEmailSent=true;
				logger.info("After Send");
			} catch (IOException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Failed to load email configuration : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (EmailException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			return isEmailSent;
		}
		/**
		 * Sending email notification with image
		 * @param emailContent
		 * @param templateName
		 * @return
		 */
		public static boolean sendEmailWithImage(EmailContent emailContent,String templateName) {
			//System.out.println("-----------sendEmailWithImage-------------------");
			boolean isEmailSent = false;
			HtmlEmail email = new HtmlEmail();
			email.setSocketConnectionTimeout(300000);
			email.setSocketTimeout(300000);
			Properties emailProperties = new Properties();
			try {
				emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
				//emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("email.properties"));
				email.setHostName(SpringApplicationContext.schedulerProperty.getProperty("host"));
				email.setSmtpPort(Integer.parseInt(SpringApplicationContext.schedulerProperty.getProperty("port")));
				if((emailContent.getTo()==null || emailContent.getTo()=="") && !(CollectionUtils.isEmpty(emailContent.getListOfTOAddress())) ){
					for (String toAdrs : emailContent.getListOfTOAddress()) {
						email.addTo(toAdrs);
					}
				}else{
					email.addTo(emailContent.getTo());
				}
				//email.addTo(emailContent.getTo());
				email.setFrom(emailContent.getFrom());
				email.setSubject(emailContent.getSubject());
				
				if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
					String[] ccArray = emailContent.getCc().split(";");
					for (String ccAdrs : ccArray) {
						email.addCc(ccAdrs);
					}
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& emailContent.getListOfCCAddress().size() > 0) {
	            	for (String ccAdrs : emailContent.getListOfCCAddress()) {
	            		email.addCc(ccAdrs);
					}
	    		}
				
				Map<String, Object> emailContentModal = emailContent.getModel();
				File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
				File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
				String banner = email.embed(bannerFile);
				String logo = email.embed(logoFile);
				if(emailContentModal==null){
					emailContentModal = new HashMap<>();
				}
				emailContentModal.put("banner", banner);
				emailContentModal.put("logo", logo);
				email.setHtmlMsg(geContentFromTemplate(emailContentModal,templateName));
				logger.debug("Before Send");
				email.send();
				isEmailSent=true;
				logger.debug("After Send");
			} catch (IOException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Failed to load email configuration : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (EmailException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (Exception e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			return isEmailSent;
		}
		
		/**
		 * Send email notification for Schedule A Pickup 
		 * @param emailContent
		 * @param templateName
		 * @return
		 */
		public static boolean sendEmailPickupRegistration(EmailContent emailContent,String templateName) {
			boolean isEmailSent = false;
			HtmlEmail email = new HtmlEmail();
			Properties emailProperties = new Properties();
			try {
				emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
				email.setHostName(SpringApplicationContext.schedulerProperty.getProperty("host"));
				email.setSmtpPort(Integer.parseInt(SpringApplicationContext.schedulerProperty.getProperty("port")));
				if((emailContent.getTo()==null || emailContent.getTo()=="") && !(CollectionUtils.isEmpty(emailContent.getListOfTOAddress())) ){
					for (String toAdrs : emailContent.getListOfTOAddress()) {
						email.addTo(toAdrs);
					}
				}else{
					email.addTo(emailContent.getTo());
				}
				email.setFrom(emailContent.getFrom());
				email.setSubject(emailContent.getSubject());
				
				if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
					String[] ccArray = emailContent.getCc().split(";");
					for (String ccAdrs : ccArray) {
						email.addCc(ccAdrs);
					}
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& !(emailContent.getListOfCCAddress().isEmpty())) {
	            	for (String ccAdrs : emailContent.getListOfCCAddress()) {
	            		email.addCc(ccAdrs);
					}
	    		}
				Map<String, Object> emailContentModal = emailContent.getModel();
				File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
				File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
				File transitFile = new File(emailProperties.getProperty("bluedart.image.transit"));
				String banner = email.embed(bannerFile);
				String logo = email.embed(logoFile);
				String transit = email.embed(transitFile);
				if(emailContentModal==null){
					emailContentModal = new HashMap<>();
				}
				emailContentModal.put("banner", banner);
				emailContentModal.put("logo", logo);
				emailContentModal.put("transit", transit);
				email.setHtmlMsg(geContentFromTemplate(emailContentModal,templateName));
				email.send();
				isEmailSent=true;
			} catch (IOException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Failed to load email configuration : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (EmailException e) {
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			return isEmailSent;
		}
		
		/**
		 * Sending email notification with image
		 * @param emailContent
		 * @param mp
		 * @param templateName
		 * @return
		 */
		
		public static boolean sendEmailWithImageAndAttachment(EmailContent emailContent, Multipart mp,String templateName)throws MessagingException {
			//System.out.println("----------- sendEmailWithImageAndAttachment checks without mmp 04-------------------");
			boolean isSent = false;
			boolean msg = false;
			JavaMailSenderImpl mailSender = setEmailConfig();

			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			HtmlEmail email = new HtmlEmail();
			Properties emailProperties = new Properties();

			if (emailContent.getFrom() != null && emailContent.getFrom().length() > 0) {
				helper.setFrom(emailContent.getFrom());
				msg = true;
			}
			if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
				helper.setTo(emailContent.getTo());
				msg = true;
			} else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
					&& emailContent.getListOfTOAddress().size() > 0) {
				//String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
				//helper.setTo(emailIdsTosends);
				
				for (String toAdrs : emailContent.getListOfTOAddress()) {
					helper.addTo(toAdrs);
				}
			
				msg = true;
			}
			if (emailContent.getCc() != null && emailContent.getCc().length() > 0) {
				helper.setCc(emailContent.getCc());
			}
			if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
					&& emailContent.getListOfCCAddress().size() > 0) {
				String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
				helper.setCc(listOfCCMailIds);
			}
			if (emailContent != null && emailContent.getBcc() != null && emailContent.getBcc().length() > 0) {
				helper.setBcc(emailContent.getBcc());
			}
			if (emailContent.getSubject() != null && emailContent.getSubject().length() > 0) {
				helper.setSubject(emailContent.getSubject());
			} else {
				helper.setSubject("No Subject!");
			}
			if(mp != null ) {
				message.setContent(mp, "text/html");
			}else {
				message.setContent("From BlueDart","text/html");
			}
			
			
			if (!msg) {
				isSent = false; 
			} else {
				try {
					logger.info("emailContent ::: "+emailContent+" emailContent.getTo() :::: "+emailContent.getTo()+" emailContent.getModel ::: "+emailContent.getModel());
					if (null != emailContent.getTo() || !(emailContent.getListOfTOAddress().isEmpty() )){
						/*Map<String, Object> emailContentModal = emailContent.getModel();
						emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
						File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
						File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
						logger.info("bannerFile ::: "+bannerFile+" logoFile ::: "+logoFile);
						String banner = email.embed(bannerFile);
						String logo = email.embed(logoFile);
						logger.info("banner ::: "+banner+" logo ::: "+logo+" templateName check::: "+templateName);
						if(emailContentModal==null){
							emailContentModal = new HashMap<>();
						}
						emailContentModal.put("banner", banner);
						emailContentModal.put("logo", logo);
						email.setBoolHasAttachments(true);*/
						//helper.setText(geContentFromTemplate(emailContent.getModel(),templateName),true);
						//message.setText(geContentFromTemplate(emailContentModal,templateName),true);
						//email.setHtmlMsg(geContentFromTemplate(emailContentModal,templateName));
						logger.info("Before Sending04");
						mailSender.send(helper.getMimeMessage());
						isSent = true;
					} else {
						isSent = false;
					}
				} catch (Exception exception) {
					isSent = false;
					logger.error("EXCEPTION TYPE",exception);
					logger.error("Error check condition : "+exception.getMessage());
					throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
				}
			}
			return isSent;
		}

		public static boolean sendMail(EmailContent emailContent, String templateName) 
		{
			String toMail=emailContent.getTo();
			boolean isEmailSent = false;
			HtmlEmail email = new HtmlEmail();
			email.setSocketConnectionTimeout(300000);
			email.setSocketTimeout(300000);
			Properties emailProperties = new Properties();
			try {
				 emailProperties.load(EmailUtil.class.getClassLoader().getResourceAsStream("emailConfig.properties"));
				 email.setHostName(emailProperties.getProperty("host"));
				 email.setSmtpPort(Integer.parseInt(emailProperties.getProperty("port")));
				if(emailContent.getTo()==null || emailContent.getTo()=="") 
				{
					for (String toAdrs : emailContent.getListOfTOAddress()) {
						email.addTo(toAdrs);
					}
				}else{
					email.addTo(emailContent.getTo());
				}
				email.addTo(emailContent.getTo());
				email.setFrom(emailContent.getFrom());
				email.setSubject(emailContent.getSubject());
				
				if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
					String[] ccArray = emailContent.getCc().split(";");
					for (String ccAdrs : ccArray) {
						email.addCc(ccAdrs);
					}
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& emailContent.getListOfCCAddress().size() > 0) {
	            	for (String ccAdrs : emailContent.getListOfCCAddress()) {
	            		email.addCc(ccAdrs);
					}
	    		}
				Map<String, Object> emailContentModal = emailContent.getModel();
				File bannerFile = new File(emailProperties.getProperty("bluedart.image.bdbanner")); 
				File logoFile = new File(emailProperties.getProperty("bluedart.image.bdlogo"));
				String banner = email.embed(bannerFile);
				String logo = email.embed(logoFile);
				if(emailContentModal==null){
					emailContentModal = new HashMap<>();
				}
				emailContentModal.put("banner", banner);
				emailContentModal.put("logo", logo);
			//email.setHtmlMsg(aHtml);
				email.setHtmlMsg(geContentFromTemplate(emailContentModal,templateName));
				logger.debug("Before Send");
				email.send();
				isEmailSent=true;
				logger.debug("After Send");
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("EXCEPTION TYPE",e);
				logger.error("Failed to load email configuration : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (EmailException e) {
				e.printStackTrace();
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("EXCEPTION TYPE",e);
				logger.error("Error sending email : "+e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			return isEmailSent;
		} 
		
		///Test
		/*
		public static boolean sendEmailWithImageAndAttachment(EmailContent emailContent, Multipart mp,String templateName)throws MessagingException, VelocityException, IOException {
			System.out.println("----------- sendEmailWithImageAndAttachment checking -------------------");
			boolean isSent = false;

			JavaMailSender mailSender = setEmailConfig();
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			 if(mp != null ) {
	            	mimeMessage.setContent(mp);
				}else {
					mimeMessage.setContent("From BlueDart","text/html");
				}
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			 	if(emailContent.getSubject() != null)
			 		mimeMessageHelper.setSubject(emailContent.getSubject());
			 	mimeMessageHelper.setFrom(emailContent.getFrom());
	            if (emailContent.getTo() != null && emailContent.getTo().length() > 0) {
	            	mimeMessageHelper.setTo(emailContent.getTo());
	            } else if (emailContent.getListOfTOAddress() != null && !emailContent.getListOfTOAddress().isEmpty()
	    				&& emailContent.getListOfTOAddress().size() > 0) {
	    			String[] emailIdsTosends = emailContent.getListOfTOAddress().toArray(new String[0]);
	    			mimeMessageHelper.setTo(emailIdsTosends);
	    		}
	            if(emailContent.getCc() != null &&  emailContent.getCc().length() > 0){
	            	mimeMessageHelper.setCc(emailContent.getCc());
	            }else if (emailContent.getListOfCCAddress() != null && !emailContent.getListOfCCAddress().isEmpty()
	    				&& emailContent.getListOfCCAddress().size() > 0) {
	    			String[] listOfCCMailIds = emailContent.getListOfCCAddress().toArray(new String[0]);
	    			mimeMessageHelper.setCc(listOfCCMailIds);
	    		}
	           
	            mimeMessageHelper.setText(geContentFromTemplate(emailContent.getModel(),templateName), true);
	            
			if(mimeMessageHelper==null){
				isSent=false;
			}else {
				try{
					logger.info("Before Send");
					mailSender.send(mimeMessageHelper.getMimeMessage());
					 logger.info("After Send");
					isSent = true;
				}catch(BlueDartException exception){
					isSent = false;
					logger.error("Error : "+exception);
					//throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
				}
			}
			return isSent;
		}*/
		
		
}
