package com.bluedart.managelicensekey.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.entity.APILicKey;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.managelicensekey.dao.ManageLicenseDao;
import com.bluedart.managelicensekey.dto.LicenseKeyStatusDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeyDto;
import com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto;
import com.bluedart.managelicensekey.dto.ManageLicenseUserDetailsDto;
import com.bluedart.manageparcelshoppodusers.dto.NotificationsDto;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

@Repository
@PropertySource("classpath:emailConfig.properties")
public class ManageLicenseDaoImpl extends BaseDaoImpl implements ManageLicenseDao {

	private static Log log = LogFactory.getLog(ManageLicenseDaoImpl.class);

	@Autowired
	Environment environment;

	/*
	 * Method to list users based on search criteria
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.dao.ManageLicenseDao#getUsers(com.bluedart.managelicensekey.dto.ManageLicenseKeySearchDto)
	 */
	@Transactional
	@Override
	public ManageLicenseKeyDto getUsers(ManageLicenseKeySearchDto manageLicenseKeySearchDto) {
		log.debug("ManageLicenseDaoImpl :: getUsers");
		ManageLicenseKeyDto manageLicenseKeyDto = null;
		try {
			manageLicenseKeyDto = getSession().doReturningWork(new ReturningWork<ManageLicenseKeyDto>() {
				@Override
				public ManageLicenseKeyDto execute(Connection connection) {
					ManageLicenseKeyDto manageLicenseKeyDtoInner = new ManageLicenseKeyDto();
					CallableStatement callableStatement = null;
					ResultSet userArray = null;
					try {
						Map<String, Class<?>> map = connection.getTypeMap();
						connection.setTypeMap(map);

						ArrayDescriptor descAwbnoList = ArrayDescriptor.createDescriptor("UPROFILE4.GENERIC_VARCHAR_TYPE",connection);
						List<String> regionsList = manageLicenseKeySearchDto.getRegionsList();
						String[] regions = regionsList.toArray(new String[regionsList.size()]);
						ARRAY regionList = new ARRAY(descAwbnoList, connection, regions);
						Date loginCreationDate = null; 
						if(!(manageLicenseKeySearchDto.getLoginCreationDate().equalsIgnoreCase("")) || manageLicenseKeySearchDto.getLoginCreationDate()!=""){
							loginCreationDate =  DateUtil.getFormatedSqlDateDefaultFormat(manageLicenseKeySearchDto.getLoginCreationDate());
						}
						callableStatement = connection.prepareCall("{call UPROFILE4.PACK_MANAGEUSERS.GET_USERS_LICENSE(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						callableStatement.clearParameters();
						callableStatement.setString(1, manageLicenseKeySearchDto.getName()); 
						callableStatement.setString(2, manageLicenseKeySearchDto.getCustCode()); 
						callableStatement.setString(3, manageLicenseKeySearchDto.getGroupCode());
						callableStatement.setDate(4, loginCreationDate);
						callableStatement.setString(5, manageLicenseKeySearchDto.getLicenseKeyStatus());
						callableStatement.setArray(6, regionList);
						callableStatement.setInt(7, manageLicenseKeySearchDto.getPageSize());
						callableStatement.setInt(8, manageLicenseKeySearchDto.getPageNumber());
						callableStatement.setString(9, manageLicenseKeySearchDto.getApiType()); 
						callableStatement.setString(10, manageLicenseKeySearchDto.getLoginId());
						callableStatement.setString(11, manageLicenseKeySearchDto.getAreaCode());

						((OracleCallableStatement) callableStatement).registerOutParameter(12, OracleTypes.CURSOR);
						((OracleCallableStatement) callableStatement).registerOutParameter(13, Types.NUMERIC);
						((OracleCallableStatement) callableStatement).execute();
						 userArray = (ResultSet) callableStatement.getObject(12);
						Integer totalCount = callableStatement.getInt(13);
						if (userArray != null) {
							ManageLicenseUserDetailsDto manageLicenseUserDetailsDto;
							List<ManageLicenseUserDetailsDto> usersList = new ArrayList<>();
							try {
								while (userArray.next()) {
									manageLicenseUserDetailsDto = new ManageLicenseUserDetailsDto();
									manageLicenseUserDetailsDto.setName(userArray.getString("NAME"));
									manageLicenseUserDetailsDto.setLoginid(userArray.getString("LOGINID"));
									manageLicenseUserDetailsDto.setApiType(userArray.getString("API_TYPE"));
									manageLicenseUserDetailsDto.setLicense(userArray.getString("LICENSE"));
									manageLicenseUserDetailsDto.setLicenseStatus(userArray.getString("LICENSE_STATUS"));
									manageLicenseUserDetailsDto.setLicenseKeyId(userArray.getString("CLICENSEID"));
									manageLicenseUserDetailsDto.setInsertionDate(userArray.getDate("INSERTION_DATE"));
									if((userArray.getString("USER_TYPE")).equalsIgnoreCase("POD_USER")){
										if(regionsList!=null){
											manageLicenseUserDetailsDto.setRegion(regionsList.get(0));
										}
									}else{
										manageLicenseUserDetailsDto.setRegion(userArray.getString("CREGION"));
									}
									manageLicenseUserDetailsDto.setEmailid(userArray.getString("EMAILID"));
									usersList.add(manageLicenseUserDetailsDto);
								}
							} catch (SQLException e) {
								log.error("EXCEPTION TYPE :",e);
								//log.error(e);
								throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
							}
						manageLicenseKeyDtoInner.setUsersList(usersList);
						}
						manageLicenseKeyDtoInner.setTotalCount(totalCount);
						
					} catch (Exception e) {
						log.error("EXCEPTION TYPE :",e);
						log.error("Error Occured while fetching users : " + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}finally{
						log.debug("---------------------getUsers finally----------------------");
						CloseConnections.closeResultSet(userArray);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return manageLicenseKeyDtoInner;
				}
			});
		} catch (Exception e) {
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching users : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		if (manageLicenseKeyDto == null || manageLicenseKeyDto.getUsersList() == null || manageLicenseKeyDto.getUsersList().isEmpty()) {
			manageLicenseKeyDto.setErrorCode("300");
			manageLicenseKeyDto.setErrorMsg("Empty Users List");
		}
		return manageLicenseKeyDto;
	}

	/*
	 * Method to generate license key
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.dao.ManageLicenseDao#generateLicenseKey(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public LicenseKeyStatusDto generateLicenseKey(String userName, String apiType, String version, String emailId, String adminEmailId, String loginId) {
		log.debug("ManageLicenseDaoImpl :: generateLicenseKey");
		java.util.Date insertionDate = new java.util.Date();
		LicenseKeyStatusDto licenseKeyStatusDto = new LicenseKeyStatusDto();
		String licenseKey = generateLicenseKeySequence(loginId.toLowerCase());
		org.hibernate.Query query = getSession().createQuery("select max(licenseKeyId) from APILicKey");
		Integer idValue = (Integer) query.uniqueResult();
		try {
			APILicKey aPILicKey = new APILicKey();
			int status = 1;

			aPILicKey.setLoginId(loginId);
			aPILicKey.setLicenseKeyId(idValue + 1);
			aPILicKey.setApiType(apiType);
			aPILicKey.setLicense(licenseKey);
			aPILicKey.setStatus(status);
			aPILicKey.setInsertionDate(insertionDate);  
			aPILicKey.setVersion(environment.getProperty("manageLicenseKey.version"));
			getSession().save(aPILicKey);
			licenseKeyStatusDto.setGeneratedKey(licenseKey);
			licenseKeyStatusDto.setStatusMessage("SUCCESS");
			boolean isEmailSent = false;
			// Email Content for User
			if(emailId!=null && !(emailId.equalsIgnoreCase("null")) && adminEmailId!=null && !(adminEmailId.equalsIgnoreCase("null")) 
					&& !(emailId.equalsIgnoreCase("undefined")) && !(adminEmailId.equalsIgnoreCase("undefined"))){
				EmailContent content = new EmailContent();
				String apiTypeName = "Shipping";
				 if(apiType.equalsIgnoreCase("S")){
					 apiTypeName = "Shipping";
				 }else if(apiType.equalsIgnoreCase("T")){
					 apiTypeName = "Tracking";
				 }else{
					 apiTypeName = "POD";
				 }
				 
				content.setFrom(environment.getProperty("fromEmailId"));
				content.setTo(emailId);
				content.setSubject(environment.getProperty("managelicensekey.licenseGenerate.subject1")+apiTypeName+environment.getProperty("managelicensekey.licenseGenerate.subject2"));

				Map<String, Object> createUserModel = new HashMap<>();
				createUserModel.put("userid", loginId);
				createUserModel.put("apitype", apiType+" ");
				createUserModel.put("username", userName);
				createUserModel.put("licensekey", licenseKey);
				createUserModel.put("versionnumber", environment.getProperty("manageLicenseKey.version"));
				content.setModel(createUserModel);
				try {
					isEmailSent = EmailUtil.sendEmailWithImage(content, environment.getProperty("managelicensekey.userLicenceKeyGeneration.template"));
				} catch (Exception e) {
					log.error("Failed to send email : " + e.getMessage());
				}
				// Email Content for admin
				EmailContent adminContent = new EmailContent();
				adminContent.setFrom(environment.getProperty("fromEmailId"));
				adminContent.setTo(adminEmailId);
				
				adminContent.setSubject(environment.getProperty("managelicensekey.licenseGenerate.subject1")+apiTypeName+environment.getProperty("managelicensekey.licenseGenerate.subject2"));

				Map<String, Object> adminUserModel = new HashMap<>();
				adminUserModel.put("username", userName);
				adminUserModel.put("loginid", loginId);
				adminUserModel.put("apitype", apiType+" ");
				adminContent.setModel(adminUserModel);

				try {
					isEmailSent = EmailUtil.sendEmailWithImage(adminContent, environment.getProperty("managelicensekey.adminLicenceKeyGeneration.template"));
				} catch (Exception e) {
					log.error("EXCEPTION TYPE :",e);
					log.error("Failed to send email " + e.getMessage());
				}
			}
			licenseKeyStatusDto.setMailSent(isEmailSent); 
		} catch (Exception e) {
			log.error("EXCEPTION TYPE :",e);
			licenseKeyStatusDto.setStatusMessage("FAILURE");
			log.error("Error Occured while gen : " + e.getMessage());
		}
		return licenseKeyStatusDto;
	}

	/*
	 * Method to generate license key random string
	 * @param loginID
	 * @return
	 */
	private static String generateLicenseKeySequence(String loginID) {
		log.debug("ManageLicenseDaoImpl :: generateLicenseKeySequence");
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890" + loginID;
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 32) {
			int index = (int) (rnd.nextInt()*SALTCHARS.length());
			while(index>41){
				index=index/10;
			}
			if(index>0 && index<=SALTCHARS.length()){
			   salt.append(SALTCHARS.charAt(index));
		   }
		}
		String saltStr = salt.toString();
		return saltStr;
	}
	
	/*
	 * Delete license key method
	 * (non-Javadoc)
	 * @see com.bluedart.managelicensekey.dao.ManageLicenseDao#deleteLicenseKey(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public LicenseKeyStatusDto deleteLicenseKey(String apiType, String licenseKey, String licenseKeyId, String emailId,
			String adminEmailId, String loginId, String userName) {
		log.debug("ManageLicenseDaoImpl :: deleteLicenseKey");
		LicenseKeyStatusDto licenseKeyStatusDto = new LicenseKeyStatusDto();
		Integer deleteFlag = 1;
		try {
			deleteFlag = getSession().doReturningWork(new ReturningWork<Integer>() {
			@Override
			public Integer execute(Connection connection) throws SQLException {
				int status = 0;
				CallableStatement callableStatement = null;
				
				try{
					callableStatement = connection.prepareCall("{ call UPROFILE4.pack_manageusers.DELETE_API_LICENSE(?,?,?,?,?,?)}");
				
				callableStatement.clearParameters();
				((OracleCallableStatement) callableStatement).setString(1, loginId);
				((OracleCallableStatement) callableStatement).setString(2, licenseKey);
				((OracleCallableStatement) callableStatement).setString(3, licenseKeyId);
				((OracleCallableStatement) callableStatement).setString(4, apiType);
				((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.INTEGER);
				((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.VARCHAR);
				callableStatement.execute();
				status = ((OracleCallableStatement) callableStatement).getInt(5);
				}catch(Exception exception){
					log.error("EXCEPTION TYPE :",exception);
					log.error("---------------------deleteLicenseKey exception----------------------");
				}finally{
					log.debug("---------------------deleteLicenseKey finally----------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return status;
			}
		  });
			if(deleteFlag==0){
				 licenseKeyStatusDto.setStatusMessage("SUCCESS");
				 Boolean isEmailSent=false;
				 //Email Content for User
				 if(emailId!=null && !(emailId.equalsIgnoreCase("null")) && adminEmailId!=null && !(adminEmailId.equalsIgnoreCase("null")) 
						 && !(emailId.equalsIgnoreCase("undefined")) && !(adminEmailId.equalsIgnoreCase("undefined"))){
					 EmailContent content=new EmailContent();
					 content.setFrom(environment.getProperty("fromEmailId"));
					 content.setTo(emailId);
				//	 content.setSubject(environment.getProperty("managelicensekey.licenseDelete.subject"));
					 String apiTypeName = "Shipping";
					 if(apiType.equalsIgnoreCase("S")){
						 apiTypeName = "Shipping";
					 }else if(apiType.equalsIgnoreCase("T")){
						 apiTypeName = "Tracking";
					 }else{
						 apiTypeName = "POD";
					 }
					 content.setSubject(environment.getProperty("managelicensekey.licenseDelete.subject1")+apiTypeName+environment.getProperty("managelicensekey.licenseDelete.subject2"));
					
					 Map <String, Object> createUserModel = new HashMap<>();
					 createUserModel.put("username",loginId);
					 createUserModel.put("apitype", apiType+" ");
					 content.setModel(createUserModel);
					 try {
						 isEmailSent = EmailUtil.sendEmailWithImage(content,environment.getProperty("managelicensekey.userLicenceKeyDelete.template"));
					 }catch(Exception e)
					 {
						 log.error("EXCEPTION TYPE :",e);
						 log.error("Error Occured while gen : " + e.getMessage());
					 }
					 //Email Content for admin
					 EmailContent adminContent=new EmailContent();
					 adminContent.setFrom(environment.getProperty("fromEmailId"));
					 adminContent.setTo(adminEmailId);
					 adminContent.setSubject(environment.getProperty("managelicensekey.licenseDelete.subject1")+apiTypeName+environment.getProperty("managelicensekey.licenseDelete.subject2"));
					
					 Map <String, Object> adminUserModel = new HashMap<> ();
					 adminUserModel.put("username", loginId);
					 adminUserModel.put("apitype", apiType+" ");
					 adminContent.setModel(adminUserModel);
					 try {
						 isEmailSent = EmailUtil.sendEmailWithImage(adminContent,
						 environment.getProperty("managelicensekey.adminLicenceKeyDelete.template"));
					 }catch(Exception e)
					 {
						 log.error("EXCEPTION TYPE :",e);
						 log.error("Error Occured while gen : " + e.getMessage());
					 }
				 }
				 licenseKeyStatusDto.setMailSent(isEmailSent);
			 }else{
				 licenseKeyStatusDto.setStatusMessage("FAILURE");
			 }
		} catch (Exception exception) {
			licenseKeyStatusDto.setStatusMessage("FAILURE");
			 log.error("EXCEPTION TYPE :",exception);
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		 return licenseKeyStatusDto;
	}

	// ------------------------ Send Email Notifications ---------------------------
	@Override
	public Boolean sendEmailNotifications(NotificationsDto notificationsDto) {
		log.debug("ManageLicenseDaoImpl :: sendEmailNotifications");
		return false;
	}

}
