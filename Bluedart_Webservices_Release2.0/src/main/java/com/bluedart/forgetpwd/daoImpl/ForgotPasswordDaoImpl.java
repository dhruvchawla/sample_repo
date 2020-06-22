package com.bluedart.forgetpwd.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.exception.VelocityException;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.entity.LoginMaster;
import com.bluedart.common.entity.UserInfo;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.custreg.daoImpl.CustomerRegistrationDaoImpl;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.forgetpwd.dao.ForgotPasswordDao;
import com.bluedart.forgetpwd.dto.ForgotPasswordResponseDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;

@Repository
/**
 * Implementation class for Forgot Password functionality
 * 
 * @author PR334023
 */
public class ForgotPasswordDaoImpl extends BaseDaoImpl implements ForgotPasswordDao {

	private static final Logger logger = Logger.getLogger(CustomerRegistrationDaoImpl.class);

	@Autowired
	private PasswordUtil passwordUtil;
	
	@Autowired
	private MISLogDao misLogDao;
	
	/*
	 * To check for valid Login ID (non-Javadoc)
	 * @see com.wipro.bluedart.dao.ForgotPasswordDao#checkeExistingLoginId(java.lang.
	 * String)
	 */
	@Override
	@Transactional
	public ForgotPasswordResponseDto checkExistingLoginId(String loginId){
		logger.debug(" ForgotPasswordDaoImpl : checkExistingLoginId ");
		
		ForgotPasswordResponseDto foResponseDto = new ForgotPasswordResponseDto();
		String mailID = null;
		try { 
			if (loginId != null && !(loginId.isEmpty())) {
				String hql = "select u FROM LoginMaster l,UserInfo u where u.userId=l.userID AND UPPER(l.loginID)=?";
				List<UserInfo> userList = (List<UserInfo>) getHibernateTemplate().find(hql, loginId.toUpperCase());
				if(!CollectionUtils.isEmpty(userList) && userList!=null){
					mailID = userList.get(0).getEmailId();
				}
			}
		}catch(DataBaseException cuException)	{
			
			logger.error("EXCEPTION TYPE :",cuException);
			
			//logger.error(" ForgotPasswordDaoImpl : changeNewPassword "+cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		foResponseDto.setExistingMailId(mailID);
		return foResponseDto;
	}

	/**
	 * Method to send OTP to valid emailId for a given loginId
	 */
	@Override
	public ForgotPasswordResponseDto sendForgotPasswordOTP(String mailID, long otp) {
		logger.debug(" ForgotPasswordDaoImpl : sendForgotPasswordOTP ");
		ForgotPasswordResponseDto foResponseDto = new ForgotPasswordResponseDto();
		//Long password = 0L;
		//EmailContent emailContent = new EmailContent();
		if (mailID != null) {
			EmailContent otpEmailContent = new EmailContent();
			otpEmailContent.setFrom("response@bluedart.com");
			otpEmailContent.setTo(mailID);
			otpEmailContent.setSubject("OTP for Blue Dart forgot pwd.");
			
	        Map <String, Object> otpModel = new HashMap <> ();
	        otpModel.put("otp", otp);   
	        otpEmailContent.setModel(otpModel);
	        boolean isMailSent = false;
			try {
				isMailSent = EmailUtil.sendEmailWithImage(otpEmailContent,"forgotPwdOtp-template.vm");
				if(isMailSent){
				//	password = otp;
					foResponseDto.setMailSent(true);
				}else{
					foResponseDto.setMailSent(false);
				}
			} catch (VelocityException e) {
				logger.error("EXCEPTION TYPE :",e);
				
				//logger.error(e);
				foResponseDto.setMailSent(false);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
			
			
			/*emailContent.setFrom("response@bluedart.com");
			emailContent.setTo(mailID);
			emailContent.setSubject("OTP for BlueDart forgot pwd.");
			
			StringBuilder emailText = new StringBuilder();
			emailText.append("Dear User, " + Constants.NEW_LINE + Constants.NEW_LINE);
			emailText
					.append("\t" + "Please find the OTP to reset your pwd : " + otp + Constants.NEW_LINE);
			emailContent.setText(emailText.toString());

			try {
				boolean isMailSent = EmailUtil.sendEmail(emailContent);
				if(isMailSent){
					password = otp;
				}
				foResponseDto.setMailSent(true);
			} catch (MessagingException e) {
				logger.error(e);
				foResponseDto.setMailSent(false); 
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}*/
		}
		//password = otp;
		foResponseDto.setForgotPwdOtp(otp);
		return foResponseDto;
	}

	/**
	 * Method to change to new password
	 */
	@Override
	@Transactional
	public ForgotPasswordResponseDto changeNewPassword(ForgotPasswordResponseDto forgotPwdDto){
		logger.debug(" ForgotPasswordDaoImpl : changeNewPassword ");

		ForgotPasswordResponseDto foResponseDto = new ForgotPasswordResponseDto();
		if (forgotPwdDto!=null && forgotPwdDto.getNewPassword() != null) {
			saveMISWithOutLogin(Constants.FEATURE_CORPORATE_FORGOT_PASSWORD, forgotPwdDto.getMailId(), forgotPwdDto.getIpAddress() , "", "");
			
			String password = null;
			try {
				password = getSession().doReturningWork(new ReturningWork<String>() {
				CallableStatement callableStatement = null;

				@Override
				public String execute(Connection connection) throws SQLException {
					try {
						String password = null;
						Integer procedureCallResponse = -2;
						String procedureCall = "{call uprofile4.admin_corporate.resetpassword(?,?,?,?)}";

						callableStatement = connection.prepareCall(procedureCall);
						callableStatement.setString(1, forgotPwdDto.getLoginId());
						callableStatement.setString(2, forgotPwdDto.getNewPassword());
						callableStatement.setString(3, passwordUtil.encryptPassword(forgotPwdDto.getNewPassword()));
						callableStatement.registerOutParameter(4, Types.INTEGER);
						callableStatement.execute();
						procedureCallResponse = callableStatement.getInt(4);
						if (procedureCallResponse == 0) {
							password = forgotPwdDto.getNewPassword();

							EmailContent emailContent = new EmailContent();
							emailContent.setFrom("response@bluedart.com");
							LoginMaster loginMaster = (LoginMaster) getSession().get(LoginMaster.class,
									forgotPwdDto.getLoginId());
							UserInfo userInfo = new UserInfo();
							if (loginMaster != null) {
								userInfo = (UserInfo) getSession().get(UserInfo.class, loginMaster.getUserID());
							}
							if(userInfo != null && userInfo.getEmailId() != null) {
								emailContent.setTo(userInfo.getEmailId());
							}
							emailContent.setSubject("Password change successfull.");
							
					        Map <String, Object> otpModel = new HashMap <> ();
					        otpModel.put("loginid", forgotPwdDto.getLoginId().toUpperCase());   
					        emailContent.setModel(otpModel);
					        boolean isMailSent = false;
							try {
								isMailSent = EmailUtil.sendEmailWithImage(emailContent,"forgotPwdSuccess-template.vm");
								if(isMailSent){
									foResponseDto.setMailSent(true);
								}else{
									foResponseDto.setMailSent(false);
								}
							} catch (VelocityException e) {
								logger.error(e);
								foResponseDto.setMailSent(false);
								throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
							}
							
							/*EmailContent emailContent = new EmailContent();
							emailContent.setFrom("response@bluedart.com");
							LoginMaster loginMaster = (LoginMaster) getSession().get(LoginMaster.class,
									forgotPwdDto.getLoginId());
							UserInfo userInfo = new UserInfo();
							if (loginMaster != null) {
								userInfo = (UserInfo) getSession().get(UserInfo.class, loginMaster.getUserID());
							}
							if(userInfo != null && userInfo.getEmailId() != null) {
								emailContent.setTo(userInfo.getEmailId());
							}
							emailContent.setSubject("Password change successfull.");
							emailContent.setText("Dear User" + Constants.COMMA_DELIMETER + Constants.NEW_LINE
									+ "You have successfully changed your password for LoginID : "
									+forgotPwdDto.getLoginId().toUpperCase()+Constants.NEW_LINE+
									"Please login using your new password.");
							try {
								EmailUtil.sendEmail(emailContent);
								foResponseDto.setMailSent(true);
							} catch (MessagingException e) {
								logger.error(e);
								foResponseDto.setMailSent(false);
								throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
							}*/
						} else {
							password = null;
						}
						return password;
					}finally{
						logger.debug("----------------changeNewPassword finally----------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				  }
				});
			}catch(DataBaseException cuException)	{
				logger.error("EXCEPTION TYPE :",cuException);
				
				//logger.error(" ForgotPasswordDaoImpl : changeNewPassword " + cuException);
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}
			foResponseDto.setChangePwdResponse(password);
		}
		return foResponseDto;
	}
	
	/*
	 * Method to save MIS log
	 * (non-Javadoc)
	 * @see com.bluedart.common.daoImpl.BaseDaoImpl#saveMISWithOutLogin(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		boolean flag = false;
		try{
		flag = misLogDao.saveMISWithOutLogin(featureName, emailId, ip, awbnos, maildate);
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			
			//logger.error("MIS logging exception:::  "+exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}
}