package com.bluedart.custreg.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.exception.VelocityException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bluedart.bdmanagecorporateusers.service.BDManageCorporateUsersService;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.PermissionDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.common.entity.AffiliatesMaster;
import com.bluedart.common.entity.CustomerMst;
import com.bluedart.common.entity.LoginMaster;
import com.bluedart.common.entity.UserInfo;
import com.bluedart.custreg.dao.CustomerRegistrationDao;
import com.bluedart.custreg.dto.AffiliatesMasterDto;
import com.bluedart.custreg.dto.CorporateResponseDto;
import com.bluedart.custreg.dto.CustomerDetailDto;
import com.bluedart.custreg.dto.CustomerMasterDto;
import com.bluedart.custreg.dto.LoginDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.manageuserCA.daoImpl.RegistrationDaoImpl;
import com.bluedart.manageuserCA.dto.CorporateCustomerDto;
import com.bluedart.manageuserCA.dto.RegisterDetailDto;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.Constants;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;


/**
 * @author PR334023 BlueDart customer registration for existing and new customer
 */
@Repository
@PropertySource("classpath:corporateAdmin.properties")
public class CustomerRegistrationDaoImpl extends BaseDaoImpl implements CustomerRegistrationDao {

	private static final Logger registrationLogger = Logger.getLogger(CustomerRegistrationDaoImpl.class);

	@Autowired
	private RegistrationDaoImpl registrationDaoImpl;

	@Autowired
	private Environment environment;

	@Autowired
	private MISLogDao misLogDao;
	
	@Autowired
	private BDManageCorporateUsersService bdManageCorporateUsersService;

	/*
	 * Validate customer code and emailId in CUSTMST and CUSEMAIL table
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wipro.bluedart.dao.CustomerRegistrationDao#getExistingUser(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@Transactional
	public CorporateResponseDto getExistingUser(String customerCode, String emailId){
		registrationLogger.debug(" CustomerRegistrationDaoImpl : getExistingUser " + System.currentTimeMillis());

		CorporateResponseDto corporateResponseDto = new CorporateResponseDto();
		CustomerMst customerMst = new CustomerMst();

		try {  
			/*String hql = "select m FROM CustomerEmail e,CustomerMst m where (e.customerType LIKE 'A' OR "
					+ "e.customerType LIKE 'D') AND m.customerPincode IS NOT NULL AND lower(m.customerCode)=e.customerCode "
					+ "AND rownum=1 AND e.customerCode=? AND lower(e.customerEmailId)=?";*/
			
		/*	String hql = "select m FROM CustomerEmail e,CustomerMst m where e.customerType in ('A','D') "
					+ "AND lower(m.customerCode)=lower(e.customerCode) AND rownum=1 AND e.customerCode=? "
					+ "and e.customerArea=m.customerArea AND lower(e.customerEmailId)=?";*/
			
			// Updating the query based on Confirmation by Ajit on 29Jan2019
			String hql = "select m FROM CustomerEmail e,CustomerMst m where "
					+ "lower(m.customerCode)=lower(e.customerCode) AND rownum=1 AND e.customerCode=? "
					+ "and lower(e.customerArea)=lower(m.customerArea) AND lower(e.customerEmailId)=?";
			
			Object[] params  = {customerCode , emailId};
			List<CustomerMst> masterList = (List<CustomerMst>) getHibernateTemplate().find(hql, params);
			if(!CollectionUtils.isEmpty(masterList) && masterList!=null){
				customerMst = masterList.get(0);

				if (customerMst != null) {
					CustomerMasterDto customerMasterDto = new CustomerMasterDto();
					CopyUtils.copy(customerMst, customerMasterDto);

					corporateResponseDto.setCustMasterExists(true);
					corporateResponseDto.setCustomerMasterDto(customerMasterDto);

					List<LoginDto> loginDtoList = new ArrayList<>();
					loginDtoList = receiveCorporateCustomerDetail(customerCode, emailId);
					corporateResponseDto.setLoginDtoList(loginDtoList);
				}
			}
		}catch(DataBaseException cuException)	{
			registrationLogger.error("EXCEPTION TYPE :",cuException);
			
			//registrationLogger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return corporateResponseDto;
	}

	/*
	 * Validate customer code and emailId in USER_T table
	 */
	private List<LoginDto> receiveCorporateCustomerDetail(String customerCode, String emailId){
		registrationLogger.debug(" CustomerRegistrationDaoImpl : receiveCorporateCustomerDetail ");

		List<LoginDto> loginDtoList = new ArrayList<>();
		try {
			String hql = "select l FROM LoginMaster l,UserInfo u where u.userId=l.userID AND "
					+ "lower(u.customerCode)=? AND lower(u.emailId)=?";
			Object[] params  = {customerCode , emailId};
			List<LoginMaster> existingIdList = (List<LoginMaster>) getHibernateTemplate().find(hql, params);

			if (existingIdList != null && !existingIdList.isEmpty()) {
				for (LoginMaster loginMaster : existingIdList) {
					LoginDto loginDto = new LoginDto();
					CopyUtils.copy(loginMaster, loginDto);
					if (loginDto.getLoginID() != null
							&& loginDto.getLoginID().equalsIgnoreCase(loginDto.getClientAdminId())) { // only corp admin
						loginDtoList.add(loginDto);
					}
				}
			}
		}catch(DataBaseException cuException)	{
			
			registrationLogger.error("EXCEPTION TYPE :",cuException);
			
			//registrationLogger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return loginDtoList;
	}

	/*
	 * Register Corporate new customer
	 */
	@Override
	@Transactional
	public CorporateResponseDto registerCorporateCustomer(CorporateCustomerDto corporateCustomerDto){
		registrationLogger.debug(" CustomerRegistrationDaoImpl : registerCorporateCustomer " + System.currentTimeMillis());
		CorporateResponseDto corporateResponseDto = new CorporateResponseDto();
		AffiliatesMasterDto affiliatesMasterDto = new AffiliatesMasterDto();
		PermissionDto permissionDto = null;

		RegisterDetailDto registerDetailDto = new RegisterDetailDto();
		if(corporateCustomerDto!=null){
			saveMISWithOutLogin(Constants.FEATURE_CORPORATE_REGISTRATION, corporateCustomerDto.getEmailId(),
					corporateCustomerDto.getIpAddress() , "", "");
		}
		try {
			int procedureCallResponse;
			Long insertedUserId;
			CustomerDetailDto customerDetail = null;
			
			PermissionMappingDto perMappingDto = new PermissionMappingDto();
			perMappingDto.setAreaCode(null);
			perMappingDto.setCustCode(null);
			perMappingDto.setLoginId(corporateCustomerDto.getLoginId());
			List<PermissionDto> permissionDtosList = new ArrayList<>();
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName(BDAdminConstants.PERMISSION_TRACK_AND_TRACE);
			permissionDto.setPermissionValue("Y");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtosList.add(permissionDto);
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName(BDAdminConstants.PERMISSION_INTERNET_DART_REPORT_DOWNLOAD);
			permissionDto.setPermissionValue("Y");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtosList.add(permissionDto);
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName(BDAdminConstants.PERMISSION_SECURITY_LEVEL);
			permissionDto.setPermissionValue(environment.getProperty("securitylevel"));
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtosList.add(permissionDto);
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName(BDAdminConstants.PERMISSION_NO_OF_USERS_TO_BE_CREATED);
			permissionDto.setPermissionValue(environment.getProperty("no_of_corporateUsers"));
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtosList.add(permissionDto);
			
			perMappingDto.setPermissionDtosList(permissionDtosList );
			
			ValidCustomerDto validCustomerDto = bdManageCorporateUsersService.saveLoginPermissions(perMappingDto );
			
			if(null!=validCustomerDto && validCustomerDto.getValidFlag().equalsIgnoreCase("SUCCESS")){
				insertedUserId = registrationDaoImpl.registerCorporateCustomer(getSession(), corporateCustomerDto);
				registrationLogger.info("CustomerRegistrationDaoImpl: Newly generated Userid by registerCorporateCustomer"+insertedUserId+"For loginid"+corporateCustomerDto.getLoginId());
				if (insertedUserId != null) {
					customerDetail = fetchUserDetailByUserId(getSession(), insertedUserId);
				}
				if (customerDetail != null) {
					registerDetailDto.setLoginId(corporateCustomerDto.getLoginId());
					registerDetailDto.setUserId(customerDetail.getUserId());
					String originalPassword = corporateCustomerDto.getOriginalPassword();
					String encryptedPassword = corporateCustomerDto.getEncryptedPassword();
					registerDetailDto.setPassword(encryptedPassword);
					registerDetailDto.setOrgPassword(originalPassword);
					registerDetailDto.setDbId(Integer.parseInt(environment.getProperty("DBId")));
					registerDetailDto.setMachineId(environment.getProperty("machineId"));
					registerDetailDto.setBadSignonCount(Integer.parseInt(environment.getProperty("badSignonCount")));
					registerDetailDto.setClientAdminId(registerDetailDto.getLoginId());
					registerDetailDto.setNoOfUsers(Integer.parseInt(environment.getProperty("no_of_corporateUsers")));

					registerDetailDto.setPonlineFlag(Constants.REG_FLAG_NO);
					registerDetailDto.setPartPayFlag(Constants.REG_FLAG_NO);  
					registerDetailDto.setRateDisplayFlag(Constants.REG_FLAG_NO);
					registerDetailDto.setSpickupPayonline(Constants.REG_FLAG_NO);
					registerDetailDto.setSdAwbqty(Integer.parseInt(environment.getProperty("AWBQuantity")));
					registerDetailDto.setSdQtyUsageChk(null);
					ArrayList<Integer> featureid = new ArrayList<>();
					featureid.add(Constants.FEATURE_ID_TRACKTRACE);
					featureid.add(Constants.FEATURE_ID_DOWNLOADS);
					registerDetailDto.setFeatureIdList(featureid);

					procedureCallResponse = registrationDaoImpl.insertToLogin(getSession(), registerDetailDto); //saves in LOGIN_T
					registrationLogger.info("CustomerRegistrationDaoImpl: insertToLogin Response"+procedureCallResponse);
					if (procedureCallResponse == 0) //if registered successfully
					{
						corporateResponseDto.setErrorMessage(BDAdminConstants.SUCCESS);
						List<Long> idList = new ArrayList<>();
						idList.add(insertedUserId);
					/*	List<LoginDto> loginDetailDtoList = fetchLoginDetailsByUserId(session, idList);
						for (LoginDto log : loginDetailDtoList) {
							loginDtoList.add(log); // to save in liferay DB
							finalLoginId = log.getLoginID();
						}*/
						affiliatesMasterDto.setLoginId(corporateCustomerDto.getLoginId());
						affiliatesMasterDto.setAffiliateCustomerCode(corporateCustomerDto.getCcustomerCode());
						affiliatesMasterDto.setAreaCode(corporateCustomerDto.getCustomerArea());
						affiliatesMasterDto.setBpFlag(Constants.REG_FLAG_NO);
						addAffiliates(getSession(), affiliatesMasterDto);
						registrationLogger.debug(" CustomerRegistrationDaoImpl : sending Email to registered customer");
						// send mail
						EmailContent emailContent = new EmailContent();
						emailContent.setFrom("response@bluedart.com");
						emailContent.setTo(corporateCustomerDto.getEmailId().toLowerCase());
						emailContent.setSubject("Your BlueDart login credentials");
						
				        Map <String, Object> mailModel = new HashMap <> ();
				        mailModel.put("username", corporateCustomerDto.getFirstName().toUpperCase());
				        mailModel.put("loginid", corporateCustomerDto.getLoginId().toUpperCase());
				        mailModel.put("password", originalPassword);   
				        emailContent.setModel(mailModel);
				        boolean isMailSent = false;
						try {
							isMailSent = EmailUtil.sendEmailWithImage(emailContent,"custRegConfirmation-template.vm");
							corporateResponseDto.setMailSent(isMailSent);
						} catch (VelocityException e) {
							corporateResponseDto.setMailSent(false); 
							
							registrationLogger.error("EXCEPTION TYPE :",e);
							
							throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
						}
						
						
						/*EmailContent emailContent = new EmailContent();
						emailContent.setFrom("response@bluedart.com");
						emailContent.setTo(corporateCustomerDto.getEmailId().toLowerCase());
						emailContent.setSubject("Your BlueDart login credentials");
						StringBuilder emailText = new StringBuilder();
						emailText.append("Dear ");
						emailText.append(corporateCustomerDto.getFirstName());
						emailText.append(Constants.COMMA_DELIMETER + Constants.NEW_LINE + Constants.NEW_LINE);
						emailText.append("Thank you for registering with BlueDart. ");
						emailText.append(Constants.NEW_LINE + "" + Constants.NEW_LINE);
						emailText.append("Use the following credentials to login to our website." + Constants.NEW_LINE
								+ Constants.NEW_LINE);
						emailText.append("Login ID: " + corporateCustomerDto.getLoginId().toUpperCase() + Constants.NEW_LINE);
						emailText.append("Pwd: " + originalPassword + Constants.NEW_LINE);
						emailContent.setText(emailText.toString());
						try {
							EmailUtil.sendEmail(emailContent);
							corporateResponseDto.setMailSent(true);
						} catch (MessagingException e) {
							corporateResponseDto.setMailSent(false); 
							throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
						}*/
					}else{
						
						deletePermissionMapping(corporateCustomerDto.getLoginId());
						corporateResponseDto.setErrorMessage(BDAdminConstants.FAILURE);
						registrationLogger.info("CustomerRegistrationDaoImpl: Deleting Permission mapping");
					}
			}
			}else{
				corporateResponseDto.setErrorMessage(BDAdminConstants.FAILURE);
			}
		}catch(DataBaseException cuException)	{
			
			registrationLogger.error("EXCEPTION TYPE :",cuException);
			
			//registrationLogger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
	//	corporateResponseDto.setLoginDtoList(loginDtoList);
		return corporateResponseDto;
	}

	/**
	 * Method to delete permissions mapped to any loginID
	 * @param vloginid
	 */
	private void deletePermissionMapping(String vloginid) {
		String sql = "delete from UPROFILE4.BD_PERMISSION_MAPPING where upper(LOGINID)=upper(:vloginid)"
				+ " and AFF_AC is null and aff_cc is null";
		Query query = getSession().createSQLQuery(sql);
		query.setString("vloginid", vloginid);
		try {
			query.executeUpdate();
		} catch (HibernateException exception) {
			registrationLogger.error("EXCEPTION TYPE :",exception);
			
			//registrationLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
	}

	/*
	 * Send Corporate Customer details to UI for auto fill
	 */
	@Override
	@Transactional
	public CustomerDetailDto getCorporateCustDetails(String loginId){
		CustomerDetailDto cuDetailDto = new CustomerDetailDto();
		try {
			LoginDto loginDetailRow = fetchLoginDetailsByLoginId(getSession(), loginId.toUpperCase());
			if (loginDetailRow != null) {
				cuDetailDto = fetchUserDetailByUserId(getSession(), loginDetailRow.getUserID());
			}
		}catch(DataBaseException cuException)	{
			registrationLogger.error("EXCEPTION TYPE :",cuException);
			
			//registrationLogger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return cuDetailDto;
	}

	/*
	 * To generate one time password
	 */
	@Override
	@Transactional
	public CorporateResponseDto generateOTP(String emailId, long otp) {
		registrationLogger.debug(" CustomerRegistrationDaoImpl : generateOTP ");

		CorporateResponseDto corporateResponseDto = new CorporateResponseDto();
		//send email
		EmailContent otpEmailContent = new EmailContent();
		otpEmailContent.setFrom("response@bluedart.com");
		otpEmailContent.setTo(emailId);
		otpEmailContent.setSubject("OTP for Blue Dart registration.");
		
        Map <String, Object> otpModel = new HashMap <> ();
        otpModel.put("otp", otp);
        otpEmailContent.setModel(otpModel);
        boolean isMailSent = false;
		try {
			isMailSent = EmailUtil.sendEmailWithImage(otpEmailContent,"custRegOtp-template.vm");
			corporateResponseDto.setMailSent(isMailSent);
		} catch (VelocityException e) {
			registrationLogger.error("EXCEPTION TYPE :",e);
			
			//registrationLogger.error("Not able to send Mail : "+e);
			corporateResponseDto.setMailSent(false); 
			throw new DataBaseException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
		}
		
		/*EmailContent emailContent = new EmailContent();
		emailContent.setFrom("response@bluedart.com");
		emailContent.setTo(emailId);
		emailContent.setSubject("OTP for BlueDart registration.");
		StringBuilder emailText = new StringBuilder();
		emailText.append("Dear User, " + Constants.NEW_LINE + Constants.NEW_LINE);
		emailText.append("\t" + "Use OTP " + otp + " to authenticate your request. OTP Validity: 10 mins. "
				+ Constants.NEW_LINE);
		emailText.append("Please do not share this OTP with anyone.");
		emailContent.setText(emailText.toString());

		try {
			EmailUtil.sendEmail(emailContent);
			corporateResponseDto.setMailSent(true);
		} catch (MessagingException e) {
			logger.error("Not able to send Mail : "+e);
			corporateResponseDto.setMailSent(false); 
			throw new DataBaseException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
		}*/
		corporateResponseDto.setErrorMessage("mail sent");
		corporateResponseDto.setGeneratedOTP(otp);
		return corporateResponseDto;
	}

	/*
	 * To get user detail by userId from USER_T
	 */
	private CustomerDetailDto fetchUserDetailByUserId(Session session, Long userId) {
		registrationLogger.debug(" CustomerRegistrationDaoImpl : fetchUserDetailByUserId " + System.currentTimeMillis());

		CustomerDetailDto customerDetailDto = new CustomerDetailDto();
		if (userId != null) {
			UserInfo userInfo = (UserInfo) session.get(UserInfo.class, userId);
			if (userInfo != null) {
				CopyUtils.copy(userInfo, customerDetailDto);
			}
		}
		return customerDetailDto;
	}

	/*
	 * To fetch login detail from LOGIN_T by loginId
	 */
	private LoginDto fetchLoginDetailsByLoginId(Session session, String loginId) {
		registrationLogger.debug(" CustomerRegistrationDaoImpl : fetchLoginDetailsByLoginId " + System.currentTimeMillis());
		LoginDto loginDetailDto = null;
		if(loginId != null){
			loginDetailDto = new LoginDto();
			Criteria criteria = session.createCriteria(LoginMaster.class);
			criteria.add(Restrictions.eq("loginID", loginId).ignoreCase());
			LoginMaster loginMaster  = (LoginMaster) criteria.uniqueResult();
			if (loginMaster != null) {
				CopyUtils.copy(loginMaster, loginDetailDto);
			}
		}
		return loginDetailDto;
	}

	/*
	 * To fetch login detail from LOGIN_T by userIds list
	 */
	@Transactional
	private List<LoginDto> fetchLoginDetailsByUserId(Session session, List<Long> userIds) {
		registrationLogger.debug(" CustomerRegistrationDaoImpl : fetchLoginDetailsByUserId " + System.currentTimeMillis());
		Criteria criteria = session.createCriteria(LoginMaster.class);
		criteria.add(Restrictions.in("userID", userIds));
		List<LoginMaster> loginDetails = criteria.list();
		List<LoginDto> loginDtoList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(loginDetails)) {
			LoginDto loginDto;
			for (LoginMaster loginMaster : loginDetails) {
				loginDto = new LoginDto();
				CopyUtils.copy(loginMaster, loginDto);
				loginDtoList.add(loginDto);
			}
		}
		return loginDtoList;
	}

	/*
	 * Method to add affiliates while new corporate registration
	 */
	private boolean addAffiliates(Session session, AffiliatesMasterDto affiliatesMasterDto) {
		registrationLogger.debug(" CustomerRegistrationDaoImpl : addAffiliates " + System.currentTimeMillis());
		Criteria criteria = session.createCriteria(AffiliatesMaster.class);
		criteria.add(Restrictions.eq("loginId", affiliatesMasterDto.getLoginId()).ignoreCase());
		criteria.add(Restrictions.eq("affiliateCustomerCode", affiliatesMasterDto.getAffiliateCustomerCode()).ignoreCase());
		criteria.add(Restrictions.eq("areaCode", affiliatesMasterDto.getAreaCode()).ignoreCase());
		criteria.add(Restrictions.eqOrIsNull("baseAffiliateFlag", Constants.BASE_AFF_FLAG));
		
		AffiliatesMaster affiliatesMaster = (AffiliatesMaster) criteria.uniqueResult();
		AffiliatesMaster affiliatesMasterDB;
		if (affiliatesMaster == null) {
			affiliatesMasterDB = new AffiliatesMaster();
			affiliatesMasterDB.setLoginId(affiliatesMasterDto.getLoginId());
			affiliatesMasterDB.setAffiliateCustomerCode(affiliatesMasterDto.getAffiliateCustomerCode());
			affiliatesMasterDB.setAreaCode(affiliatesMasterDto.getAreaCode());
			affiliatesMasterDB.setBpFlag(affiliatesMasterDto.getBpFlag());
			//affiliatesMasterDB.setInsertionDate(new Date(0)); 
			affiliatesMasterDB.setBaseAffiliateFlag(Constants.BASE_AFF_FLAG);

			session.save(affiliatesMasterDB);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to save MIS log
	 * @param featureName
	 * @param emailId
	 * @param ip
	 * @param awbnos
	 * @param maildate
	 * @return
	 */
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		boolean flag = false;
		try{
			flag = misLogDao.saveMISWithOutLogin(featureName, emailId, ip, awbnos, maildate);
		}catch(Exception exception){
			registrationLogger.error("EXCEPTION TYPE :",exception);
			
			//registrationLogger.error("MIS logging exception:::  "+exception);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}
}