package com.bluedart.bdmanagecorporateusers.daoImpl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao;
import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AdminAuditDetails;
import com.bluedart.common.dto.AffiliateDetailDto;
import com.bluedart.common.dto.AuditDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.PermissionCascadeDto;
import com.bluedart.common.dto.PermissionDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.common.entity.CustomerEmail;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
/**
 * Implementation class for Managing Corporate users & Permissions
 * @author PR334023
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class BDManageCorporateUsersDaoImpl extends BaseDaoImpl implements BDManageCorporateUsersDao{

	private static final Logger appLogger = Logger.getLogger(BDManageCorporateUsersDaoImpl.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	@Autowired
	private BDCorporateNotificationHelper bdNotificationHelper;
	
	private List list = null;
	//private String emailId = null;

	/*
	 * Method to list corporate customers with pagination
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#listUsers(com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto)
	 */
	@Override 
	@Transactional
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: listusers");
		CustomerResponseDto customerResponseDto = new CustomerResponseDto(); 
		
		List<String> regionArray = usersSearchDto.getRegions();
		String[] regionArr = regionArray.toArray(new String[regionArray.size()]);
		
		try{
			customerResponseDto = getSession().doReturningWork(new ReturningWork<CustomerResponseDto>() {
				
			@Override
			public CustomerResponseDto execute(Connection connection) throws SQLException {
				
				ResultSet usersListResultSet = null;
				CallableStatement callableStatement = null;
				
				CustomerResponseDto custResponseDto = new CustomerResponseDto();
				/*Map<String, Class<?>> map = connection.getTypeMap();

				try {
					map.put(environment.getProperty(BDAdminConstants.USERSOBJ), Class.forName(BDAdminConstants.USERSOBJ_DTO));
				} catch (ClassNotFoundException e) {
					appLogger.error(e);
				}
				
				connection.setTypeMap(map);
				*/
				try{
				ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
				Array adminRegions = new ARRAY(des, connection, regionArr);
				
				callableStatement = connection.prepareCall(BDAdminConstants.CORP_LIST_PROC);
				callableStatement.clearParameters();
				
				Date creationDate =  DateUtil.getFormatedSqlDateDefaultFormat(usersSearchDto.getCreationDate());
				
				callableStatement.setString(1, usersSearchDto.getAdminType());
				callableStatement.setString(2, usersSearchDto.getLoginId()); 
				callableStatement.setString(3, usersSearchDto.getAreaCode());
				callableStatement.setString(4, usersSearchDto.getCustCode());
				callableStatement.setString(5, usersSearchDto.getEmailId());
				callableStatement.setString(6, usersSearchDto.getGroupCode());  //"102231"
				callableStatement.setDate(7, creationDate);
				callableStatement.setString(8,usersSearchDto.getStatus());  
				callableStatement.setArray(9,adminRegions);  
				callableStatement.setInt(10, usersSearchDto.getPageSize()); //page size
				callableStatement.setInt(11, usersSearchDto.getPageNumber());  // page number
				callableStatement.setString(12, usersSearchDto.getSalesEmpCode());  // sales employee code
				callableStatement.setString(13, usersSearchDto.getUserType());
				callableStatement.setString(14, usersSearchDto.getAdminLoginId()); 
				((OracleCallableStatement) callableStatement).registerOutParameter(15, OracleTypes.CURSOR);
				((OracleCallableStatement) callableStatement).registerOutParameter(16, Types.INTEGER);
				
				((OracleCallableStatement) callableStatement).executeQuery();
				usersListResultSet = (ResultSet) callableStatement.getObject(15);
				Integer totalCount = callableStatement.getInt(16);
				custResponseDto.setResultCount(totalCount);

				List<CorporateUserDto> corporateUserListDtos = new ArrayList<>();
				 while (usersListResultSet.next()) {
					 CorporateUserDto corporateUserDto = new CorporateUserDto();
					 
					 corporateUserDto.setName(usersListResultSet.getString("name"));
					 String loginId = usersListResultSet.getString("loginid");
					 corporateUserDto.setLoginId(loginId);
					 corporateUserDto.setcCustCode(usersListResultSet.getString("ccustcode"));
					 corporateUserDto.setEmailId(usersListResultSet.getString("emailid"));
					 String insertionDate = usersListResultSet.getString("INSERTION_DATE");
					 String client_adminid = usersListResultSet.getString("client_adminid");
					 corporateUserDto.setInsertion_date(insertionDate); 
					 corporateUserDto.setClientAdminId(client_adminid); 
					/* DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH); //dd-MMM-yy
					 java.util.Date insertionDateFormat;
					try {
						insertionDateFormat = format.parse(insertionDate);
						java.sql.Date createDate = new java.sql.Date(insertionDateFormat.getTime()); 
						SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
						String newDate = sdf.format(createDate);

						corporateUserDto.setInsertion_date(newDate); 
					} catch (ParseException e) { 
						appLogger.error(e.getMessage());
					}*/
					 if(client_adminid!=null && loginId.equalsIgnoreCase(client_adminid)){  
						 corporateUserDto.setAdminColorType("CA");
						 corporateUserDto.setCA(true);
					 }else if(client_adminid!=null && !(loginId.equalsIgnoreCase(client_adminid))){
						 corporateUserDto.setAdminColorType("CU_WITH_ADMIN");
						 corporateUserDto.setCA(false);
					 }else if(client_adminid==null){
						 corporateUserDto.setAdminColorType("CU_NO_ADMIN");
						 corporateUserDto.setCA(false);
					 }
					 corporateUserDto.setcCompGrp(usersListResultSet.getString("ccompgrp"));
					 corporateUserDto.setcCompName(usersListResultSet.getString("ccompname"));
					 corporateUserDto.setStatus(usersListResultSet.getString("status"));
					 corporateUserDto.setcArea(usersListResultSet.getString("carea"));
					 corporateUserDto.setcRegion(usersListResultSet.getString("cregion")); 
					 corporateUserDto.setUserId(Long.parseLong(usersListResultSet.getString("userid")));
					 //corporateUserDto.setUserId(Long.valueOf(usersListResultSet.getString("userid")));
					 corporateUserDto.setMobileNo(usersListResultSet.getString("phone"));
					 corporateUserListDtos.add(corporateUserDto);
				}
				custResponseDto.setCustList(corporateUserListDtos);
				
				}catch(Exception exception){
				
					appLogger.error("EXCEPTION TYPE :",exception);
					
					
					appLogger.error("Exception in listUsers");
				}finally{
					appLogger.debug("------------------------listUsers finally------------------------");
					CloseConnections.closeResultSet(usersListResultSet);
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return custResponseDto;
			}
		});
		}catch(Exception exception){

			appLogger.error("EXCEPTION TYPE :",exception);
			
			//appLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return customerResponseDto;
	}
		
	/*
	 * Method to generate and send OTP 
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#createSendOTP(java.lang.String, long)
	 */
	@Override
	public ValidCustomerDto createSendOTP(String emailID, long otp) {
		System.out.println(otp);
		appLogger.debug(" BDManageCorporateUsersDaoImpl : createSendOTP ");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		Long password = 0L;
		EmailContent emailContent = new EmailContent();
		if (emailID != null) {
			CorporateNotificationDto notificationDto = new CorporateNotificationDto();
			emailContent.setTo(emailID);
			notificationDto.setEmailContent(emailContent);
			notificationDto.setAction("CREATE_OTP");
			notificationDto.setPassword(String.valueOf(otp));
			
			boolean isEmailSent = sendEmailNotification(notificationDto);
			if(isEmailSent){
				password = otp;
				validCustomerDto.setEmailSent(true); 
			}
			validCustomerDto.setEmailSent(isEmailSent); 
			
			/*StringBuilder emailText = new StringBuilder();
			emailText.append("Dear User, " + Constants.NEW_LINE + Constants.NEW_LINE);
			emailText.append("\t" + "Please find the OTP to create your account : " + otp + Constants.NEW_LINE);
			emailContent.setText(emailText.toString());*/

			/*try {
				boolean isMailSent = EmailUtil.sendEmail(emailContent);
				if(isMailSent){
					password = otp;
					validCustomerDto.setEmailSent(true); 
				}
			} catch (MessagingException e) {
				logger.error(e);
				validCustomerDto.setEmailSent(false); 
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}*/
		}
		validCustomerDto.setOtp(password);
		return validCustomerDto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#createCorpUser(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto validateUserCreation(CorporateUserDto corporateUserDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl :: createCorpUser");
        String response = BDAdminConstants.FAILURE;
        String[] regionArray = (corporateUserDto.getAdminRegions()).toArray(new String[corporateUserDto.getAdminRegions().size()]);
		try {
			response = getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					Integer responseNum = -7;
					String response = BDAdminConstants.FAILURE;
					try {
						ArrayDescriptor des1 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY regionsArray = null;
						regionsArray = new ARRAY(des1, connection, regionArray);
						
						callableStatement = connection.prepareCall(BDAdminConstants.VALIDATE_USER_CREATION_PROC);
						((OracleCallableStatement) callableStatement).setString(1, corporateUserDto.getLoginId());
						((OracleCallableStatement) callableStatement).setString(2, corporateUserDto.getEmailId());
						((OracleCallableStatement) callableStatement).setString(3, corporateUserDto.getcArea());
						((OracleCallableStatement) callableStatement).setString(4, corporateUserDto.getcCustCode());
						((OracleCallableStatement) callableStatement).setString(5, corporateUserDto.getByLoginId());
						((OracleCallableStatement) callableStatement).setString(6, corporateUserDto.getByAdminType());
						((OracleCallableStatement) callableStatement).setArray(7, regionsArray);
						((OracleCallableStatement) callableStatement).registerOutParameter(8,Types.INTEGER);
						callableStatement.execute();
						responseNum  = callableStatement.getInt(8);
					} catch(DataBaseException exception) {
						System.out.println(exception.getMessage());
						appLogger.error("EXCEPTION TYPE : ,"+exception);
						
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------validateUserCreation finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);
					}
					if(responseNum==0){
						response=BDAdminConstants.SUCCESS;
					}else if(responseNum==-3){
						response=BDAdminConstants.ADD_EMAIL_DATA;
					}
					return response;
				}
			});
		}catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			
		//	appLogger.error(e);
		}
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		validCustomerDto.setStatusMessage(response);
		return validCustomerDto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#validateUserName(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ValidCustomerDto validateUserName(String userName, String emailId) {
		appLogger.debug("BDManageCorporateUsersDaoImpl : listUsersWithAff");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		String sql = "select count(1) from user_t where upper(EMAILID)=:emailId and upper(name)=:userName";
		Query query = getSession().createSQLQuery(sql);
		query.setString("userName", userName.toUpperCase());
		query.setString("emailId", emailId.toUpperCase());
		try {
			BigDecimal count1 = (BigDecimal) query.uniqueResult();
			Integer count = count1.intValue();
			if(count>0){
				validCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
			}else{
				validCustomerDto.setStatusMessage(BDAdminConstants.SUCCESS);
			}
		} catch (HibernateException e) {
			validCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
			appLogger.error("EXCEPTION TYPE :",e);
			
			
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return validCustomerDto;
	}
	 
	@Override
	@Transactional
	public ValidCustomerDto addCustomerEmailData(CorporateUserDto corporateUserDto) {
		CustomerEmail customerEmail = new CustomerEmail();
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		try {
			//org.hibernate.Query query = getSession().createQuery("SELECT CONCAT('WEB', lpad(S1_CUSEMAIL.NEXTVAL,'5','0')) FROM DUAL");
			//String customerRowId = (String) query.uniqueResult();
			//Integer idVal = Integer.parseInt(customerRowId);
			
			String customerRowId =  getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					String customerRowId= null;
					String query = "SELECT CONCAT('WEB', lpad(UPROFILE4.S1_CUSEMAIL.NEXTVAL,'7','0')) FROM DUAL";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
						customerRowId = rs.getString(1);
					
					logger.info("----------------customerRowId--------:"+customerRowId);
					return customerRowId;
				}
			});
			
			customerEmail.setCustomerArea(corporateUserDto.getcArea());
			customerEmail.setCustomerCode(corporateUserDto.getcCustCode());
			customerEmail.setCustomerEmailId(corporateUserDto.getEmailId());
			customerEmail.setCustomerName(corporateUserDto.getName());
			customerEmail.setCustomerRowId(corporateUserDto.getcArea()+String.valueOf(customerRowId));
			customerEmail.setCustomerType("D");
			getSession().save(customerEmail);
			validCustomerDto.setStatusMessage(BDAdminConstants.SUCCESS);
		} catch (NumberFormatException e) {
			validCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
			
			appLogger.error("EXCEPTION TYPE :",e);
			
			
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} catch (HibernateException e) {
			validCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
			appLogger.error("EXCEPTION TYPE :",e);
			
			
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return validCustomerDto;
	}

	
	@Override
	@Transactional
	public ValidCustomerDto createCorpUser(CorporateUserDto corporateUserDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl :: createCorpUser");
		List<AffiliateDetailDto> affList = new ArrayList<>();
        BDCustomerDto bdCustomerDto = new BDCustomerDto();
        ValidCustomerDto validCustomerDto = new ValidCustomerDto();
        String response = BDAdminConstants.FAILURE;
		try {
			response = getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					Integer responseNum = -7;
					String response = null;
					try {
						callableStatement = connection.prepareCall(BDAdminConstants.CREATE_CUSTOMER_PROC);
						((OracleCallableStatement) callableStatement).setString(1, corporateUserDto.getLoginId());
						((OracleCallableStatement) callableStatement).setString(2, corporateUserDto.getName());
						((OracleCallableStatement) callableStatement).setString(3, corporateUserDto.getEmailId());
						((OracleCallableStatement) callableStatement).setString(4, corporateUserDto.getMobileNo());
						((OracleCallableStatement) callableStatement).setString(5, corporateUserDto.getcArea());
						((OracleCallableStatement) callableStatement).setString(6, corporateUserDto.getcCustCode());
						((OracleCallableStatement) callableStatement).setString(7, corporateUserDto.getByLoginId());
						((OracleCallableStatement) callableStatement).setString(8, corporateUserDto.getByAdminType());
						((OracleCallableStatement) callableStatement).setString(9, corporateUserDto.getEncryptedPassword());
						((OracleCallableStatement) callableStatement).setString(10, corporateUserDto.getPassword());
						((OracleCallableStatement) callableStatement).registerOutParameter(11,Types.INTEGER);
						callableStatement.execute();
						responseNum  = callableStatement.getInt(11);
					} catch(DataBaseException exception) {
						//appLogger.error(exception);
						appLogger.error("EXCEPTION TYPE :",exception);
						
						
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------createCorpUser finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);
					}
					if(responseNum==0){
						response=BDAdminConstants.SUCCESS;
						CorporateNotificationDto coNotificationDto = new CorporateNotificationDto();
						coNotificationDto.setAction("BD_CREATE_USER");
						coNotificationDto.setCorporateUserDto(corporateUserDto); 
						boolean isEmailSent = sendEmailNotification(coNotificationDto);
						validCustomerDto.setEmailSent(isEmailSent); 
					}
					return response;
				}
			});
		}catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			
			
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		bdCustomerDto.setAffList(affList);
		validCustomerDto.setStatusMessage(response);
		return validCustomerDto;
	}
	/*
	 * Method to edit corporate user details
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#editCorpUser(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto editCorpUser(CorporateUserDto corporateUserDto){
		appLogger.debug("BDManageCorporateUsersDaoImpl :: createCorpUser");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		String editUserResponse = BDAdminConstants.FAILURE;
		try {
			editUserResponse = getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					Integer responseNum = -7;
					String response = null;
					try {
						callableStatement = connection.prepareCall(BDAdminConstants.EDIT_CUSTOMER_PROC); 
						((OracleCallableStatement) callableStatement).setString(1, corporateUserDto.getLoginId());
						((OracleCallableStatement) callableStatement).setString(2, corporateUserDto.getName());
						((OracleCallableStatement) callableStatement).setString(3, corporateUserDto.getEmailId());
						((OracleCallableStatement) callableStatement).setString(4, corporateUserDto.getMobileNo());
						((OracleCallableStatement) callableStatement).setString(5, BDAdminConstants.BD_MODULE_NAME);
						((OracleCallableStatement) callableStatement).setString(6, "EDIT_USER");
						((OracleCallableStatement) callableStatement).registerOutParameter(7,Types.INTEGER);
						callableStatement.execute();
						responseNum  = callableStatement.getInt(7);
					} catch(DataBaseException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------editCorpUser finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);

					}
					if(responseNum==0){
						response=BDAdminConstants.SUCCESS;
						CorporateNotificationDto coNotificationDto = new CorporateNotificationDto();
						coNotificationDto.setAction("EDIT_USER");
						coNotificationDto.setCorporateUserDto(corporateUserDto); 
						boolean isEmailSent = sendEmailNotification(coNotificationDto);
						validCustomerDto.setEmailSent(isEmailSent); 
					}else
					{
						response = BDAdminConstants.FAILURE;
					}
					return response;
				}
			});
		}catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			
			
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		validCustomerDto.setStatusMessage(editUserResponse); 
		return validCustomerDto;
	}
	/*
	 * Method to list affiliates under given loginID with pagination
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#listAffiliates(java.lang.String, int, int)
	 */
	@Override
	@Transactional
	public BDCustomerDto listAffiliates(String loginId, int pageSize, int pageNum,String orderBy) {
		appLogger.debug("BDManageCorporateUsersDaoImpl::listAffiliates");
		List<AffiliateDetailDto> affList = new ArrayList<>();
        BDCustomerDto bdCustomerDto = new BDCustomerDto();
		try {
			affList = getSession().doReturningWork(new ReturningWork<List<AffiliateDetailDto>>() {
				@Override
				public List<AffiliateDetailDto> execute(Connection connection) throws SQLException {
					List<AffiliateDetailDto> affiliatelist = new ArrayList<>();
					CallableStatement callableStatement = null;
					ResultSet rs = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN),
								Class.forName(BDAdminConstants.AFF_DTO));
						connection.setTypeMap(localMap);
					
						
							callableStatement = connection.prepareCall(BDAdminConstants.GET_AFFILIATES_PROC_V1);
							((OracleCallableStatement) callableStatement).setString(1, loginId);
							((OracleCallableStatement) callableStatement).setString(2, null);
							((OracleCallableStatement) callableStatement).setInt(3, pageSize);
							((OracleCallableStatement) callableStatement).setInt(4, pageNum);
							if(null!=orderBy && orderBy.equalsIgnoreCase("default")){
								((OracleCallableStatement) callableStatement).setString(5, "ASC");
							}else{
								((OracleCallableStatement) callableStatement).setString(5, orderBy.toUpperCase());
							}
							((OracleCallableStatement) callableStatement).registerOutParameter(6, OracleTypes.CURSOR);
							((OracleCallableStatement) callableStatement).registerOutParameter(7,Types.INTEGER);
							callableStatement.execute();
	 
							int totalCount  = callableStatement.getInt(7);
							bdCustomerDto.setTotalCount(totalCount); 
							rs = (ResultSet) callableStatement.getObject(6);
					
						 AffiliateDetailDto affiliateDetailDto = null;
						 while (rs.next()) {
							 affiliateDetailDto = new AffiliateDetailDto();
							 affiliateDetailDto.setCustCode(rs.getString("aff_cc"));
							 affiliateDetailDto.setAreaCode(rs.getString("aff_ac"));
							 affiliateDetailDto.setCbaseaffiliate(rs.getString("cbaseaffiliate"));
							 affiliatelist.add(affiliateDetailDto);
						}
					} catch(DataBaseException exception) {
						
						appLogger.error("EXCEPTION TYPE :",exception);
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} catch (ClassNotFoundException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------listAffiliates finally------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return affiliatelist;
				}
			});

		}catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			
			//appLogger.error(e);
		}
		bdCustomerDto.setAffList(affList);
		return bdCustomerDto;
	}
	/*
	 * Get users with given affiliate for add
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#getAffUsers(com.bluedart.common.dto.BDCustomerDto)
	 */
	@Override
	@Transactional
	public BDCustomerDto getAffUsers(BDCustomerDto bdCustDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl:: getAffUsers");
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		List<AffiliateDetailDto> affList = bdCustDto.getAffList();
			
	//	String[] affArray = (bdCustDto.getAffList()).toArray(new String[bdCustDto.getAffList().size()]);
		List<AffiliateDetailDto> affiliatesList = null;
	    AffiliateDetailDto[] affListArray = affList.toArray(new AffiliateDetailDto[affList.size()]);
		try {
			affiliatesList = getSession().doReturningWork(new ReturningWork<List<AffiliateDetailDto>>() {
				@Override
				public List<AffiliateDetailDto> execute(Connection connection) throws SQLException {
					List<AffiliateDetailDto> afflist = null;
					CallableStatement callableStatement = null;
					
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN),Class.forName(BDAdminConstants.AFF_DTO));
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN),connection);
						ARRAY affArrayToPass = new ARRAY(des, connection, affListArray);
						
						callableStatement = connection.prepareCall(BDAdminConstants.GET_AFF_USERS_PROC);
						callableStatement.clearParameters();						
						
						((OracleCallableStatement) callableStatement).setArray(1, affArrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY, environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN));
						((OracleCallableStatement) callableStatement).setString(3, bdCustDto.getAdminLoginId());
						((OracleCallableStatement) callableStatement).registerOutParameter(4, OracleTypes.INTEGER);
												
						((OracleCallableStatement) callableStatement).execute();
						Integer outresponse = ((OracleCallableStatement) callableStatement).getInt(4);
						ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(2);
						if (affiliates != null && affiliates.length() != 0) {
							list = Arrays.asList((Object[]) affiliates.getArray());
							afflist = new ArrayList<>(list);
						} 
					}catch(DataBaseException exception)	{
						appLogger.error("EXCEPTION TYPE :",exception);
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} catch (ClassNotFoundException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());					}
					finally {
						appLogger.debug("------------------------getAffUsers finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return afflist;
				}
			});
		} catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			
			//appLogger.error(e);
		}
		bdCustomerDto.setAffList(affiliatesList);
		return bdCustomerDto;
	}

	
	/*
	 * Method to add affiliates
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#addAffiliates(com.bluedart.bdmanagecorporateusers.dto.BDCustomerDto)
	 */
	@Override
	@Transactional
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl:: addAffiliates");
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		List<AffiliateDetailDto> affList = bdCustDto.getAffList();
			
		String[] regionArray = (bdCustDto.getRegions()).toArray(new String[bdCustDto.getRegions().size()]);
		List<AffiliateDetailDto> affiliatesList = null;
	    AffiliateDetailDto[] affListArray = affList.toArray(new AffiliateDetailDto[affList.size()]);
		try {
			affiliatesList = getSession().doReturningWork(new ReturningWork<List<AffiliateDetailDto>>() {
				@Override
				public List<AffiliateDetailDto> execute(Connection connection) throws SQLException {
					List<AffiliateDetailDto> afflist = null;
					CallableStatement callableStatement = null;
					
					ArrayDescriptor des1 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY regionsArray = null;
					try {
						regionsArray = new ARRAY(des1, connection, regionArray);
						Map<String, Class<?>> localMap = connection.getTypeMap();
						localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN),Class.forName(BDAdminConstants.AFF_DTO));
						
						connection.setTypeMap(localMap);

						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN),connection);
						ARRAY affArrayToPass = new ARRAY(des, connection, affListArray);
						
						callableStatement = connection.prepareCall(BDAdminConstants.ADD_AFFILIATES_PROC);
						callableStatement.clearParameters();						
						
						((OracleCallableStatement) callableStatement).setArray(1, affArrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY, environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN));
						((OracleCallableStatement) callableStatement).setString(2, bdCustDto.getGroupCode());
						((OracleCallableStatement) callableStatement).setString(3, bdCustDto.getCustCode());
						((OracleCallableStatement) callableStatement).setArray(4, regionsArray);
						appLogger.info("bdCustDto.getAdminType() ---- "+bdCustDto.getAdminType());
						if(bdCustDto.getAdminType().equalsIgnoreCase(BDAdminConstants.SALES_ADMIN)){
							appLogger.info("sales admin login ID ---- "+bdCustDto.getAdminLoginId());
							((OracleCallableStatement) callableStatement).setString(5, bdCustDto.getAdminLoginId());
						}else{
							((OracleCallableStatement) callableStatement).setString(5, null);
						}
						((OracleCallableStatement) callableStatement).setString(6, bdCustDto.getAdminType());
												
						((OracleCallableStatement) callableStatement).execute();
						ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(1);
						if (affiliates != null && affiliates.length() != 0) {
							list = Arrays.asList((Object[]) affiliates.getArray());
							afflist = new ArrayList<>(list);
						} 
					}catch(DataBaseException exception)	{
						appLogger.error("EXCEPTION TYPE :",exception);
							
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} catch (ClassNotFoundException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());					
					}
					finally {
						appLogger.debug("------------------------addAffiliates finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return afflist;
				}
			});
		} catch(Exception e){
			appLogger.error("EXCEPTION TYPE :",e);
			//appLogger.error(e);
		}
		bdCustomerDto.setAffList(affiliatesList);
		return bdCustomerDto;
	}
	
	
	/**
	 * Get list of users with given affiliate before delete
	 * @param areaCode
	 * @param custCode
	 * @param adminLoginId
	 * @return
	 */
	@Override
	@Transactional
	public BDCustomerDto listUsersWithAff(String areaCode, String custCode, String adminLoginId){
		appLogger.debug("BDManageCorporateUsersDaoImpl : listUsersWithAff");
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		String sql = "select alt.loginid, alt.aff_ac, alt.aff_cc, ALT.CAFFILIATEID, u.name"
				+ " from affiliates_t alt,login_t lt, user_t u,custmst c"
				+ " where upper(alt.loginid)=lt.loginid"
				+ " and u.userid=lt.userid "
				+ " and upper(Alt.Aff_Ac)=:v_aff_Ac "
				+ " and upper(Alt.Aff_Cc)=:v_aff_cc"
				+ " and upper(LT.ENABLE_FLAG)='Y'"
				+ " and Lt.loginid!=Lt.Client_Adminid "
				+ " and nvl(ALT.CBASEAFFILIATE,'N')!='Y'"
				+ " and upper(C.ccustcode)= upper(alt.aff_cc)"
				+ " and upper(C.carea)= upper(alt.aff_ac)"
				+ " and Lt.Client_Adminid=:v_loginid order by lt.loginid";
		Query query = getSession().createSQLQuery(sql);
		query.setString("v_aff_Ac", areaCode);
		query.setString("v_aff_cc", custCode);
		query.setString("v_loginid", adminLoginId);
		List<AffiliateDetailDto> affList = new ArrayList<>();
		AffiliateDetailDto affDetailDto = null;
		try {
			List<Object[]> list = query.list();
			bdCustomerDto.setStatusMessage(BDAdminConstants.SUCCESS);
			for (Object[] affiliateObj : list) {
				affDetailDto = new AffiliateDetailDto();
				affDetailDto.setLoginId((String) affiliateObj[0]);
				affDetailDto.setAreaCode((String) affiliateObj[1]);
				affDetailDto.setCustCode((String) affiliateObj[2]);
				BigDecimal affIdNum = (BigDecimal) affiliateObj[3];
				Integer affId = null;
				if(affIdNum!=null){
					affId = ((BigDecimal) affiliateObj[3]).intValueExact();
				}
				affDetailDto.setCustName((String) affiliateObj[4]);
				affDetailDto.setAffiliateId(affId);
				affList.add(affDetailDto);
			}
		} catch (HibernateException e) {
			appLogger.error("EXCEPTION TYPE :",e);
			bdCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
			//appLogger.error(e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		bdCustomerDto.setAffList(affList);
		return bdCustomerDto;
	}
	
	/*
	 * Method to delete affiliates
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#deleteAffiliates(com.bluedart.bdmanagecorporateusers.dto.BDCustomerDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto deleteAffiliates(BDCustomerDto bdCustDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl : deleteAffiliates ::");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		List<AffiliateDetailDto> affList = bdCustDto.getAffList();
		//	List<AffiliateDetailDto> affiliatesList = null;
			AffiliateDetailDto[] affiliatesArray = affList.toArray(new AffiliateDetailDto[affList.size()]);
		//AffiliateDetailDto affiliateDetailDto = affList.get(0);
		try {
			validCustomerDto = getSession().doReturningWork(new ReturningWork<ValidCustomerDto>() {
				@Override
				public ValidCustomerDto execute(Connection connection) throws SQLException {
					ValidCustomerDto validCustDto = new ValidCustomerDto();
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						try {
							localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN),
									Class.forName(BDAdminConstants.AFF_DTO));
						} catch (ClassNotFoundException e) {
							appLogger.error("EXCEPTION TYPE :",e);
							//appLogger.error("ClassNotFound "+e);
						}
						localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN), Class.forName(BDAdminConstants.AFF_DTO));
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN),connection);
						ARRAY affArrayToPass = null;
						try {
							affArrayToPass = new ARRAY(des, connection, affiliatesArray);
						} catch (Exception e) {
							appLogger.error("EXCEPTION TYPE :",e);
							e.printStackTrace();
							
						}
						callableStatement = connection.prepareCall(BDAdminConstants.DEL_AFFILIATES_PROC);
						callableStatement.clearParameters();
                
						((OracleCallableStatement) callableStatement).setArray(1, affArrayToPass);
					//	((OracleCallableStatement) callableStatement).setString(1, affiliateDetailDto.getLoginId());
					//	((OracleCallableStatement) callableStatement).setString(2, affiliateDetailDto.getCustCode());
					//	((OracleCallableStatement) callableStatement).setString(3, affiliateDetailDto.getAreaCode());
					//	((OracleCallableStatement) callableStatement).setString(4, affiliateDetailDto.getCreated_by());
						((OracleCallableStatement) callableStatement).setString(2, BDAdminConstants.BD_MODULE_NAME);
						((OracleCallableStatement) callableStatement).setString(3, "DELETE");
						((OracleCallableStatement) callableStatement).registerOutParameter(4, Types.INTEGER);
						((OracleCallableStatement) callableStatement).execute();
						Integer deleteResponse = callableStatement.getInt(4);
						if(deleteResponse==0){
							validCustDto.setStatusMessage(BDAdminConstants.SUCCESS);
						}else{
							validCustDto.setStatusMessage(BDAdminConstants.FAILURE);
						}
					} 
					catch(DataBaseException exception)	{
						appLogger.error("EXCEPTION TYPE :",exception);
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} catch (ClassNotFoundException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------deleteAffiliates finally------------------------");
						
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return validCustDto;
				}
			});
		} catch(Exception exception){
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		return validCustomerDto;
	}
	
	/*
	 * Method to get affiliate level permissions
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#getAffPermissions(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public BDCustomerDto getAffPermissions(String areaCode, String custCode, String loginId) {
		appLogger.debug("BDManageCorporateUsersDaoImpl : getAffPermissions ::");
	    BDCustomerDto bdCustomerDto = new BDCustomerDto();		
		List<PermissionDto> perMappingDtoList = null;	
		try {
			perMappingDtoList = getSession().doReturningWork(new ReturningWork<List<PermissionDto>>() {
				@Override
				public List<PermissionDto> execute(Connection connection) throws SQLException {
					List<PermissionDto> perList = new ArrayList<>();
					CallableStatement callableStatement = null;
					ResultSet rs = null;
					try{					
						callableStatement = connection.prepareCall(BDAdminConstants.GET_AFF_PERM_PROC);
						((OracleCallableStatement) callableStatement).setString(1, areaCode);
						((OracleCallableStatement) callableStatement).setString(2, custCode);
						((OracleCallableStatement) callableStatement).setString(3, loginId);
						((OracleCallableStatement) callableStatement).registerOutParameter(4, OracleTypes.CURSOR);
						((OracleCallableStatement) callableStatement).executeUpdate();
						rs = (ResultSet) callableStatement.getObject(4);
						 while (rs.next()) {
							 PermissionDto permissionDto = new PermissionDto();
							 if(null==rs.getString("PERMISSION_NAME")){
								 permissionDto.setPermissionName(rs.getString("sub_permission_name"));
							 }else{
								 permissionDto.setPermissionName(rs.getString("PERMISSION_NAME"));
							 }
							 permissionDto.setPermissionValue(rs.getString("PERMISSION_VALUE"));
							 perList.add(permissionDto);
						}
					}catch(DataBaseException exception)	{
						appLogger.error("EXCEPTION TYPE :",exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally {
						appLogger.debug("------------------------getAffPermissions finally------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return perList;
				}
			});
		} catch(Exception exception){
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		appLogger.debug("BDManageCorporateUsersDaoImpl : getAffPermissions ::" + perMappingDtoList);
		bdCustomerDto.setPerList(perMappingDtoList);
		return bdCustomerDto;
	}
	
	/*
	 * Method to fetch login level permissions of corporate customer
	 * @param loginId
	 * @return
	 */
	@Override
	@Transactional
	public BDCustomerDto getLoginPermissions(String loginId) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: getLoginPermissions");
		 List<PermissionDto> perList = new ArrayList<>(); 
		 BDCustomerDto bdCustomerDto = new BDCustomerDto();
			if(null!=loginId){
				try{
					bdCustomerDto = getSession().doReturningWork(new ReturningWork<BDCustomerDto>() {
					@Override
					public BDCustomerDto execute(Connection connection) throws SQLException {
						CallableStatement callableStatement = null;
						BDCustomerDto bdCustDto;
						ResultSet rset = null;
						try {
							bdCustDto = new BDCustomerDto();
							callableStatement = connection.prepareCall(BDAdminConstants.GET_LOGIN_PERM_PROC);
							callableStatement.clearParameters();
							callableStatement.setString(1, loginId.toUpperCase()); 
							((OracleCallableStatement) callableStatement).registerOutParameter(2, OracleTypes.CURSOR);
							((OracleCallableStatement) callableStatement).executeUpdate();
							 rset = (ResultSet)callableStatement.getObject (2);
							 while (rset.next ()){
								 PermissionDto permissionsDto = new PermissionDto();
								 if(null!=rset.getString ("Permission_Name")){
									 permissionsDto.setPermissionName(rset.getString ("Permission_Name"));
								 }else{
									 permissionsDto.setPermissionName(rset.getString ("Sub_Permission_Name"));
								 }
								 permissionsDto.setPermissionValue(rset.getString ("Permission_Value"));
								 perList.add(permissionsDto);
								 bdCustDto.setPerList(perList);
							 }
						} catch(DataBaseException exception)	{
							appLogger.error("EXCEPTION TYPE :",exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally {
							appLogger.debug("------------------------getLoginPermissions finally------------------------");
							CloseConnections.closeResultSet(rset);
							CloseConnections.closeCallableStatement(callableStatement);
						}
						return bdCustDto;
					}
				});
				}catch(Exception exception){
					appLogger.error("EXCEPTION TYPE :",exception);
					//appLogger.error(exception);
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}
			}
			return bdCustomerDto;
	}
	
	
	@Transactional
	public BDCustomerDto getAffPermUsers(PermissionMappingDto perMappingDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: getAffPermUsers");
		BDCustomerDto bdCustDto = new BDCustomerDto();
		try {
			bdCustDto = getSession().doReturningWork(new ReturningWork<BDCustomerDto>() {
				@Override
				public BDCustomerDto execute(Connection connection) throws SQLException {
					Integer procedureResponse = -3;
					BDCustomerDto bdCustomerDto = new BDCustomerDto();
					CallableStatement callableStatement = null;
					ResultSet usersListResultSet = null;
					try {
						String[] loginArray = (perMappingDto.getPermissionNames()).toArray(new String[perMappingDto.getPermissionNames().size()]);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY perArray = null;
						perArray = new ARRAY(des, connection, loginArray);
						try {
							callableStatement = connection.prepareCall(BDAdminConstants.GET_AFF_PER_USERS_PROC);
							callableStatement.setString(1, perMappingDto.getLoginId()); 
							callableStatement.setArray(2, perArray);
							callableStatement.setString(3, perMappingDto.getAreaCode());
							callableStatement.setString(4, perMappingDto.getCustCode());
							((OracleCallableStatement) callableStatement).registerOutParameter(5, OracleTypes.CURSOR);
							((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.INTEGER);
							((OracleCallableStatement) callableStatement).execute();
							procedureResponse = callableStatement.getInt(6);
							usersListResultSet = (ResultSet) callableStatement.getObject(5);
							List<String> loginIdList = new ArrayList<>();
							while (usersListResultSet.next()) {
								loginIdList.add(usersListResultSet.getString("loginid")+","+usersListResultSet.getString("name"));
							}
							if(procedureResponse == 0) {
								 bdCustomerDto.setStatusMessage(BDAdminConstants.SUCCESS);
								 bdCustomerDto.setLoginIdList(loginIdList);
							}else{
								bdCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
							}
						} catch (Exception exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						appLogger.debug("------------------------getAffPermUsers finally------------------------");
						CloseConnections.closeResultSet(usersListResultSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return bdCustomerDto;
				}
			});
		} catch(Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		return bdCustDto;
	}
	
	/*
	 * Method to save affiliate permissions
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#saveAffPermissions(com.bluedart.bdmanagecorporateusers.dto.PermissionMappingDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto saveAffPermissions(PermissionMappingDto perMappingDto) {
		 appLogger.debug("BDManageCorporateUsersDaoImpl : saveAffPermissions");
		 PermissionDto permissionDto = new PermissionDto();
		List<PermissionDto> perList = new ArrayList<>();
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		  for (PermissionDto perDto : perMappingDto.getPermissionDtosList()) { 
			permissionDto = new PermissionDto();	
			permissionDto.setPermissionName(perDto.getPermissionName());
			permissionDto.setPermissionValue(perDto.getPermissionValue());
			permissionDto.setSql_type(environment.getProperty(BDAdminConstants.PERMISSIONMPNGOBJ));
			perList.add(permissionDto);
		  }
			String areaCodeToPass = perMappingDto.getAreaCode();
			String custCodeToPass = perMappingDto.getCustCode();
			String loginIdToPass = perMappingDto.getLoginId();
			String modifiedBy = perMappingDto.getModifiedBy();
			
		PermissionDto[] permissions = perList.toArray(new PermissionDto[perList.size()]);
        Integer procedureResponse = -3;
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					
					Integer procedureResponse = -3;				
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						localMap.put(environment.getProperty(BDAdminConstants.PERMISSIONMPNGOBJ), Class.forName(BDAdminConstants.PERMISSION_DTO));
						connection.setTypeMap(localMap);
						ArrayDescriptor	des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.PERMISSIONMPNGLIST),connection);
					   try{							
						 ARRAY affArrayToPass = new ARRAY(des, connection, permissions);
						 callableStatement = connection.prepareCall(BDAdminConstants.SAVE_AFF_PERM_PROC);
						 callableStatement.clearParameters();
						 ((OracleCallableStatement) callableStatement).setArray(1, affArrayToPass);
						 ((OracleCallableStatement) callableStatement).setString(2, areaCodeToPass);
						 ((OracleCallableStatement) callableStatement).setString(3, custCodeToPass);
						 ((OracleCallableStatement) callableStatement).setString(4, loginIdToPass);
						 ((OracleCallableStatement) callableStatement).setString(5, modifiedBy);
						 ((OracleCallableStatement) callableStatement).setString(6, environment.getProperty("BD_FLAG"));
						 ((OracleCallableStatement) callableStatement).setString(7, BDAdminConstants.BD_MODULE_NAME);
						 ((OracleCallableStatement) callableStatement).setString(8, "UPDATE");
						 ((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.INTEGER);
						
						 ((OracleCallableStatement) callableStatement).execute();
						  procedureResponse = callableStatement.getInt(9);
					} catch(DataBaseException exception){
						appLogger.error("EXCEPTION TYPE :",exception);
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
				  } catch (ClassNotFoundException exception) {
					 appLogger.error("EXCEPTION TYPE :",exception);
					// appLogger.error(exception);
				}
				finally {
					appLogger.debug("------------------------saveAffPermissions finally------------------------");
					CloseConnections.closeCallableStatement(callableStatement);

				}
				return procedureResponse;
			   }
			 });
			}catch(Exception exception) {
				appLogger.error("EXCEPTION TYPE :",exception);
				//appLogger.error(exception);
			} 
			if (procedureResponse == 0){
				validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
			}
			appLogger.debug("BDManageCorporateUsersDaoImpl : saveAffiliatesPermissions ::" + procedureResponse);
			return validCustomerDto;
	}
	
	/**
	 * 
	 * @param perMappingDto
	 * @return
	 */
	@Override
	@Transactional
	public ValidCustomerDto saveCascadedAffPermissions(PermissionMappingDto perMappingDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: saveCascadedAffPermissions");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		
		List<String> loginIds = perMappingDto.getLoginIdsList();
		String[] loginArray =  loginIds.toArray(new String[loginIds.size()]);
				
		List<PermissionCascadeDto> perList = perMappingDto.getPerCascadeList();
		PermissionCascadeDto[] permissionsArray = perList.toArray(new PermissionCascadeDto[perList.size()]);
		Integer procedureResponse = -3;
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -3;
					CallableStatement callableStatement = null;
					try {
						Map<java.lang.String, Class<?>> localMap = connection.getTypeMap();
						try {
							localMap.put(environment.getProperty(BDAdminConstants.PERMISSIONMPNGOBJ_CAS), Class.forName("com.bluedart.common.dto.PermissionCascadeDto"));
						} catch (ClassNotFoundException e) {
							appLogger.error("EXCEPTION TYPE :",e);
							//appLogger.error(e);
						}
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.PERMISSIONMPNGLIST_CAS), connection);
						
						ArrayDescriptor des1 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY loginIDArray = null;
						loginIDArray = new ARRAY(des1, connection, loginArray);
						
						try {
							ARRAY permissionMappingArray = new ARRAY(des, connection, permissionsArray); 
							callableStatement = connection.prepareCall(BDAdminConstants.CASCADE_AFF_PER_PROC);
							callableStatement.setArray(1, permissionMappingArray);
							callableStatement.setString(2, perMappingDto.getAreaCode()); 
							callableStatement.setString(3,  perMappingDto.getCustCode()); 
							callableStatement.setArray(4, loginIDArray);  
							callableStatement.setString(5, perMappingDto.getModifiedBy()); 
						    ((OracleCallableStatement) callableStatement).setString(6, environment.getProperty("BD_FLAG"));
						    callableStatement.setString(7, BDAdminConstants.BD_MODULE_NAME); 
						    callableStatement.setString(8, "UPDATE"); 
							((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.INTEGER);
							((OracleCallableStatement) callableStatement).execute();
							procedureResponse = callableStatement.getInt(9);
						} catch (Exception exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						appLogger.debug("------------------------saveCascadedAffPermissions finally------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
		} catch(Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		if(procedureResponse == 0) {
			validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
		}else if (procedureResponse == -1) {
			validCustomerDto.setValidFlag(BDAdminConstants.NO_DATA);
		}else if (procedureResponse == -2) {
			validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
		}
		return validCustomerDto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#getLoginPermUsers(com.bluedart.common.dto.PermissionMappingDto)
	 */
	@Override
	@Transactional
	public BDCustomerDto getLoginPermUsers(PermissionMappingDto perMappingDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: saveLoginPermissions");
		BDCustomerDto bdCustDto = new BDCustomerDto();
		try {
			bdCustDto = getSession().doReturningWork(new ReturningWork<BDCustomerDto>() {
				@Override
				public BDCustomerDto execute(Connection connection) throws SQLException {
					Integer procedureResponse = -3;
					BDCustomerDto bdCustomerDto = new BDCustomerDto();
					CallableStatement callableStatement = null;
					ResultSet usersListResultSet = null;
					try {
						String[] loginArray = (perMappingDto.getPermissionNames()).toArray(new String[perMappingDto.getPermissionNames().size()]);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY loginIDArray = null;
						loginIDArray = new ARRAY(des, connection, loginArray);
						try {
							callableStatement = connection.prepareCall(BDAdminConstants.GET_LOGINPERM_USERS_PROC);
							callableStatement.setString(1, perMappingDto.getLoginId()); 
							callableStatement.setArray(2, loginIDArray);
							((OracleCallableStatement) callableStatement).registerOutParameter(3, OracleTypes.CURSOR);
							((OracleCallableStatement) callableStatement).registerOutParameter(4, Types.INTEGER);
							((OracleCallableStatement) callableStatement).execute();
							procedureResponse = callableStatement.getInt(4);
							usersListResultSet = (ResultSet) callableStatement.getObject(3);
							List<String> loginIdList = new ArrayList<>();
							while (usersListResultSet.next()) {
								loginIdList.add(usersListResultSet.getString("loginid")+","+usersListResultSet.getString("name"));
							}
							if(procedureResponse == 0) {
								 bdCustomerDto.setStatusMessage(BDAdminConstants.SUCCESS);
								 bdCustomerDto.setLoginIdList(loginIdList);
							}else{
								bdCustomerDto.setStatusMessage(BDAdminConstants.FAILURE);
							}
						} catch (Exception exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						appLogger.debug("------------------------getLoginPermUsers finally------------------------");
						CloseConnections.closeResultSet(usersListResultSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return bdCustomerDto;
				}
			});
		} catch(Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		return bdCustDto;
	}
	
	
	/*
	 * Method to save/update login level permissions of corporate customer
	 * @param perMappingDto
	 * @return
	 */
	@Override
	@Transactional
	public ValidCustomerDto saveLoginPermissions(PermissionMappingDto perMappingDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: saveLoginPermissions");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		
		List<PermissionDto> perList = perMappingDto.getPermissionDtosList();
		PermissionDto[] permissionsArray = perList.toArray(new PermissionDto[perList.size()]);
		Integer procedureResponse = -3;
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -3;
					CallableStatement callableStatement = null;
					try {
						Map<java.lang.String, Class<?>> localMap = connection.getTypeMap();
						try {
							localMap.put(environment.getProperty(BDAdminConstants.PERMISSIONMPNGOBJ), Class.forName("com.bluedart.common.dto.PermissionDto"));
						} catch (ClassNotFoundException e) {
							appLogger.error("EXCEPTION TYPE :",e);
							//appLogger.error(e);
						}
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.PERMISSIONMPNGLIST), connection);
						try {
							ARRAY permissionMappingArray = new ARRAY(des, connection, permissionsArray); 
							callableStatement = connection.prepareCall(BDAdminConstants.SAVE_LOGIN_PERMISSION_PROC);
							callableStatement.setArray(1, permissionMappingArray);
							callableStatement.setString(2, null); 
							callableStatement.setString(3,  null); 
							callableStatement.setString(4, perMappingDto.getLoginId());  
							callableStatement.setString(5, perMappingDto.getModifiedBy()); 
						    ((OracleCallableStatement) callableStatement).setString(6, environment.getProperty("BD_FLAG"));
						    callableStatement.setString(7, BDAdminConstants.BD_MODULE_NAME); 
						    callableStatement.setString(8, "UPDATE"); 
							((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.INTEGER);
							((OracleCallableStatement) callableStatement).execute();
							procedureResponse = callableStatement.getInt(9);
						} catch (Exception exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						appLogger.debug("------------------------saveLoginPermissions finally------------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return procedureResponse;
				}
			});
		} catch(Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		if(procedureResponse == 0) {
			validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
		}else if (procedureResponse == -1) {
			validCustomerDto.setValidFlag(BDAdminConstants.NO_DATA);
		}else if (procedureResponse == -2) {
			validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
		}
		return validCustomerDto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#saveCascadedLoginPermissions(com.bluedart.common.dto.PermissionMappingDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto saveCascadedLoginPermissions(PermissionMappingDto perMappingDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: saveLoginPermissions");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		
		List<String> loginIds = perMappingDto.getLoginIdsList();
		String[] loginArray =  loginIds.toArray(new String[loginIds.size()]);
				
		List<PermissionCascadeDto> perList = perMappingDto.getPerCascadeList();
		PermissionCascadeDto[] permissionsArray = perList.toArray(new PermissionCascadeDto[perList.size()]);
		Integer procedureResponse = -3;
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -3;
					CallableStatement callableStatement = null;
					try {
						Map<java.lang.String, Class<?>> localMap = connection.getTypeMap();
						try {
							localMap.put(environment.getProperty(BDAdminConstants.PERMISSIONMPNGOBJ_CAS), Class.forName("com.bluedart.common.dto.PermissionCascadeDto"));
						} catch (ClassNotFoundException e) {
							appLogger.error("EXCEPTION TYPE :",e);
							//appLogger.error(e);
						}
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.PERMISSIONMPNGLIST_CAS), connection);
						
						ArrayDescriptor des1 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY loginIDArray = null;
						loginIDArray = new ARRAY(des1, connection, loginArray);
						
						try {
							ARRAY permissionMappingArray = new ARRAY(des, connection, permissionsArray); 
							callableStatement = connection.prepareCall(BDAdminConstants.CASCADE_LOGIN_PER_PROC);
							callableStatement.setArray(1, permissionMappingArray);
							callableStatement.setString(2, null); 
							callableStatement.setString(3,  null); 
							callableStatement.setArray(4, loginIDArray);  
							callableStatement.setString(5, perMappingDto.getModifiedBy()); 
						    ((OracleCallableStatement) callableStatement).setString(6, environment.getProperty("BD_FLAG"));
						    callableStatement.setString(7, BDAdminConstants.BD_MODULE_NAME); 
						    callableStatement.setString(8, "UPDATE"); 
							((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.INTEGER);
							((OracleCallableStatement) callableStatement).execute();
							procedureResponse = callableStatement.getInt(9);
						} catch (Exception exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
					} finally {
						appLogger.debug("------------------------saveCascadedLoginPermissions finally------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
		} catch(Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
		} 
		if(procedureResponse == 0) {
			validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
		}else if (procedureResponse == -1) {
			validCustomerDto.setValidFlag(BDAdminConstants.NO_DATA);
		}else if (procedureResponse == -2) {
			validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
		}
		return validCustomerDto;
	}
	
	/*
	 * Method to activate or deactivate corporate customer
	 * @param corporateUserDto
	 * @return
	 */
	@Override
	@Transactional
	public ValidCustomerDto activateOrDeactivate(CustomerResponseDto custResponseDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: activateOrDeactivate");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		if(custResponseDto!=null){ 
			Integer procedureResp = -4;
			try {
				procedureResp = getSession().doReturningWork(new ReturningWork<Integer>() {
					@Override
					public Integer execute(Connection connection) throws SQLException {
						Integer procedureResponse = -4;
						CallableStatement callableStatement = null;
						
						String[] loginArray = custResponseDto.getLoginIDList().toArray(new String[custResponseDto.getLoginIDList().size()]);
						ArrayDescriptor des1 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY loginIDArray = null;
						loginIDArray = new ARRAY(des1, connection, loginArray);
						try {
							callableStatement = connection.prepareCall(BDAdminConstants.ADMIN_UPDATE_STATUS);
							callableStatement.setArray(1, loginIDArray);
							callableStatement.setString(2, custResponseDto.getStatus());
							callableStatement.setString(3, BDAdminConstants.BD_MODULE_NAME);
							callableStatement.setString(4, custResponseDto.getStatus());
							callableStatement.registerOutParameter(5, Types.INTEGER);
							callableStatement.registerOutParameter(6, Types.VARCHAR);
							callableStatement.execute();
							procedureResponse = callableStatement.getInt(5);
						} catch(Exception exception){
							appLogger.error("EXCEPTION TYPE :",exception);
						}
						finally {
							appLogger.debug("------------------------activateOrDeactivate finally------------------------");
							CloseConnections.closeCallableStatement(callableStatement);
						}
						return procedureResponse;
					}
				});
			} catch (Exception exception) {
				appLogger.error("EXCEPTION TYPE :",exception);
				//appLogger.error(exception);
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			} 
			if(procedureResp==0){
				validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
				CorporateNotificationDto coNotificationDto = new CorporateNotificationDto();
				coNotificationDto.setAction(custResponseDto.getStatus());
				coNotificationDto.setCoList(custResponseDto.getCustList());
				boolean isEmailSent = sendEmailNotification(coNotificationDto);
				validCustomerDto.setEmailSent(isEmailSent); 
			}else{
				validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
			}
		}else{
			validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
		}
		return validCustomerDto;
	}
	
	/*
	 * Method to reset corporate customer password
	 * @param corporateUserDto
	 * @return
	 */
	@Override
	@Transactional
	public ValidCustomerDto resetUserPassword(CorporateUserDto corporateUserDto) {
		appLogger.info("BDManageCorporateUsersDaoImpl :: resetUserPassword");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		String originalPassword = corporateUserDto.getPassword();
		Integer procedureResponse = -2;
		try {
			String encryptedPassword = passwordUtil.encryptPassword(originalPassword);
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -2;
					CallableStatement callableStatement = null;
					try {
						callableStatement = connection.prepareCall(BDAdminConstants.CORP_RESET_PWD);
						callableStatement.setString(1, corporateUserDto.getLoginId());
						callableStatement.setString(2, originalPassword);
						callableStatement.setString(3, encryptedPassword);
						callableStatement.setString(4, BDAdminConstants.BD_MODULE_NAME);
						callableStatement.setString(5, "RESET_PWD");
						callableStatement.registerOutParameter(6, Types.INTEGER);
						callableStatement.execute();
						procedureResponse = callableStatement.getInt(6);
					}catch(Exception exception){
						appLogger.error("EXCEPTION TYPE :",exception);
						}
					finally {
						appLogger.debug("------------------------resetUserPassword finally------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
			if (procedureResponse == 0) {
				validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
				if(!corporateUserDto.isCA()){
					CorporateNotificationDto coNotificationDto = new CorporateNotificationDto();
					coNotificationDto.setCorporateUserDto(corporateUserDto); 
					coNotificationDto.setPassword(originalPassword);
					coNotificationDto.setAction("RESET_PASSWORD");
					try {
						boolean mailSent = sendEmailNotification(coNotificationDto);
						validCustomerDto.setEmailSent(mailSent); 
					} catch (Exception e) {
						appLogger.error("EXCEPTION TYPE :",e);
						appLogger.error("Failed to send email : "+e);
					} 
				}
			}
		} catch (Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		return validCustomerDto;
	}

	/*
	 * method to send email notification
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#sendEmailNotification(com.bluedart.bdmanagecorporateusers.dto.CorporateNotificationDto)
	 */
	@Override
	public boolean sendEmailNotification(CorporateNotificationDto coNotificationDto) {
		return bdNotificationHelper.sendEmailNotification(coNotificationDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#getUsersToUpdateStatus(java.lang.String)
	 */
	@Override
	@Transactional
	public CustomerResponseDto getUsersToUpdateStatus(String adminLoginId,String status) {
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		List<CorporateUserDto> coList = new ArrayList<>();
		CorporateUserDto corporateUserDto = null;
		//List<Long> userIdList = new ArrayList<>();
		
		String sql = "select lt.loginid,ur.userid,u.name,U.EMAILID from login_t lt,webportal.user_ ur, user_t u"
				+ " where u.userid=lt.userid and upper(lt.CLIENT_ADMINID)=upper(:ploginid)"
				+ " and lt.loginid!=lt.CLIENT_ADMINID and upper(lt.loginid) = upper(ur.screenname)"
				+ " and upper(lt.enable_flag)=:pstatus order by lt.loginid";
		Query query = getSession().createSQLQuery(sql);
		query.setString("ploginid", adminLoginId);
		query.setString("pstatus", status);
		
		List<Object[]> list = query.list();
		for (Object[] string2 : list) {
			corporateUserDto = new CorporateUserDto();
			corporateUserDto.setLoginId((String) string2[0]);
			corporateUserDto.setName((String) string2[2]);
			BigDecimal value = (BigDecimal) string2[1];
			corporateUserDto.setEmailId((String) string2[3]);
			corporateUserDto.setUserId(value.longValue());
			coList.add(corporateUserDto);
		}
		
		/*BDCustomerDto bdCustomerDto = new BDCustomerDto();
		List<Long> userIdList = null;
		try {
			userIdList = getSession().doReturningWork(new ReturningWork<List<Long>>() {
				@Override
				public List<Long> execute(Connection connection) throws SQLException {
					
					CallableStatement callableStatement = null;
					try {
						callableStatement = connection.prepareCall(BDAdminConstants.GET_CORP_USERS_PROC);
						((OracleCallableStatement) callableStatement).setString(1, adminLoginId);
						((OracleCallableStatement) callableStatement).registerOutParameter(2,Types.INTEGER);
						((OracleCallableStatement) callableStatement).registerOutParameter(3, OracleTypes.CURSOR);
						callableStatement.execute();
						callableStatement.getInt(2);
						ResultSet rs = (ResultSet) callableStatement.getObject(3);
						 while (rs.next()) {
							 userIdList.add(Long.valueOf(rs.getString("userid")));
						}
					} catch(DataBaseException exception) {
						appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} finally {
						if(!callableStatement.isClosed()){
							callableStatement.close();
						}
					}
					return userIdList;
				}
			});
		}catch(Exception e){
			appLogger.error(e);
		}*/
		customerResponseDto.setCustList(coList);
		return customerResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#saveAuditLog(java.util.List)
	 */
	@Override
	@Transactional
	public AuditDto saveAuditLog(AuditDto auditDto) {
		appLogger.debug("BDManageCorporateUsersDaoImpl :: saveAuditLog");
		AuditDto auditdto = new AuditDto();
		Integer procedureResponse = -2;
		List<AdminAuditDetails> adminAuditLogList = auditDto.getAdminAuditDtoList();
		List<AdminAuditDetails> finalAuditList = new ArrayList<>();
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					List<Integer> seqList = new ArrayList<>();
					for (AdminAuditDetails adutiListObj : adminAuditLogList) {
						String sql = BDAdminConstants.AUDIT_SEQ_QUERY;
						PreparedStatement pst = connection.prepareStatement(sql);
						ResultSet rs = null;
						try {
							rs = pst.executeQuery(); 
							if(rs.next()){
								 Integer seq = rs.getInt(1);
								 adutiListObj.setSequence(seq);
								 seqList.add(seq);
								finalAuditList.add(adutiListObj);
							}
							auditdto.setSequenceNumbers(seqList);
						} catch (HibernateException exception) {
							appLogger.error("EXCEPTION TYPE :",exception);
							//appLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally{
							appLogger.debug("------------------------saveAuditLog inner finally------------------------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closePreparedStatement(pst);

						}
					}
					Integer procedureResponse = -1;
					CallableStatement callableStatement = null;
					AdminAuditDetails[] logValues = finalAuditList.toArray(new AdminAuditDetails[finalAuditList.size()]);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(BDAdminConstants.AUDITLIST, connection);
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						try {   
							localMap.put(BDAdminConstants.AUDITOBJ,Class.forName(BDAdminConstants.AUDIT_DTO));
						} catch (ClassNotFoundException e) {
							appLogger.error("EXCEPTION TYPE :",e);
						//appLogger.error(e);
						}
						connection.setTypeMap(localMap);
						ARRAY auditLogArray = null;
						try {
							auditLogArray = new ARRAY(des, connection, logValues);
						} catch (Exception e) {
							appLogger.error("EXCEPTION TYPE :",e);
							//appLogger.error(e);
						}
						callableStatement = connection.prepareCall(BDAdminConstants.SAVE_AUDIT_PROC);
						callableStatement.setArray(1, auditLogArray);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
						((OracleCallableStatement) callableStatement).executeUpdate();
						procedureResponse = callableStatement.getInt(2);
					} finally {
						appLogger.debug("------------------------saveAuditLog finally------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
		} catch (Exception exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		if(procedureResponse==0){
			auditdto.setStatusMessage(BDAdminConstants.SUCCESS);
		}
		return auditdto;
	}
		
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao#deleteAuditLog(com.bluedart.common.dto.AuditDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto deleteAuditLog(AuditDto auditDto){
		appLogger.debug("BDManageCorporateUsersDaoImpl :: deleteAuditLog");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		List<Integer> seqList = auditDto.getSequenceNumbers();
		StringBuilder sequences = new StringBuilder();
		for (Integer sequenceNumber : seqList) {
			sequences.append(sequenceNumber);
			sequences.append(",");
		}
		sequences.deleteCharAt(sequences.length() - 1).toString();
		try {
			String sql = "delete from uprofile4.bd_audit_log where cid in ("+sequences+")";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.executeUpdate();
		} catch (HibernateException exception) {
			appLogger.error("EXCEPTION TYPE :",exception);
			//appLogger.error(exception);
			validCustomerDto.setValidFlag(BDAdminConstants.FAILURE);
		}
		validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
		return validCustomerDto;
	}

	
}