package com.bluedart.camanagecorpusers.daoimpl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.bdmanagecorporateusers.dto.UsersSearchDto;
import com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao;
import com.bluedart.camanagecorpusers.dto.ClientUserDto;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AffiliateDetailDto;
import com.bluedart.common.dto.BDCustomerDto;
import com.bluedart.common.dto.CorporateNotificationDto;
import com.bluedart.common.dto.CorporateUserDto;
import com.bluedart.common.dto.CustomerResponseDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.common.entity.Login;
import com.bluedart.common.entity.User;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;
/**
 * Class to implement corporate admin managing corporate users
 * @author PR334023
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class CAManageCorpUsersDaoImpl extends BaseDaoImpl implements CAManageCorpUsersDao {

	private static final Logger appLogger = Logger.getLogger(CAManageCorpUsersDaoImpl.class);
	
	@Autowired
	private CANotificationHelper caNotificationHelper;
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private MISLogDao misLogDao;
	
	private List list = null;
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#getCARegion(java.lang.String)
	 */
	@Override
	@Transactional
	public String getCARegion(String adminLoginId){
		appLogger.debug("CAManageCorpUsersDaoImpl :: getCARegion");
		String region = null;
		String hql = "select UT.CREGION from user_t ut, login_t lt "
				+ "where ut.userid=lt.userid "
				+ "and upper(lt.loginid)=upper(:loginID)";
		Query query = getSession().createSQLQuery(hql);
	    query.setParameter("loginID", adminLoginId.toUpperCase());
	    region = (String) query.uniqueResult();
		return region;
	}
	
	/*
	 * Method to get number of users allowed for client admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#getNoOfUsers(java.lang.String)
	 */
	@Override
	@Transactional
	public ClientUserDto getNoOfUsers(String adminLoginId) {
		appLogger.debug("CAManageCorpUsersDaoImpl :: getNoOfUsers");
		ClientUserDto clientUserDto = new ClientUserDto();
		String hql = "SELECT l.no_Of_Users,(select count(*) FROM uprofile4.login_t l where upper(l.CLIENT_ADMINID)=upper(:loginID) "
				+ "and upper(L.LOGINID)!=upper(L.CLIENT_ADMINID)) as existing_count "
				+ "FROM uprofile4.login_t l where "
				+ "upper(L.loginid)=upper(:loginID) GROUP BY l.no_Of_Users";
		Query query = getSession().createSQLQuery(hql);
	    query.setParameter("loginID", adminLoginId.toUpperCase());
	    List<Object> noOfUsersList = query.list(); 
	    Iterator itr = noOfUsersList.iterator();
	    while(itr.hasNext()){
	       Object[] obj = (Object[]) itr.next();
	       Integer noOfUsers = Integer.parseInt(String.valueOf(obj[0]));
	       clientUserDto.setNoOfUsers(noOfUsers);
	       Integer existingCount = Integer.parseInt(String.valueOf(obj[1]));
	       clientUserDto.setExistingNoOfUsers(existingCount);
	    }
		return clientUserDto;
	}
	/*
	 * Method to verify if affiliate belongs to corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#verifyAdminAffiliate(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ClientUserDto verifyAdminAffiliate(String adminLoginId, String areaCode, String custCode){
		appLogger.debug("CAManageCorpUsersDaoImpl :: verifyAdminAffiliate");
		ClientUserDto clientUserDto = new ClientUserDto();
		String sql = "select count(1) from UPROFILE4.AFFILIATES_T "
				+ "where upper(LOGINID)=upper(:adminLoginId) "
				+ "and upper(AFF_AC)=upper(:areaCode) "
				+ "and upper(AFF_CC)=upper(:custCode)";
		Query query = getSession().createSQLQuery(sql);
	    query.setParameter("adminLoginId", adminLoginId.toUpperCase());
	    query.setParameter("areaCode", areaCode.toUpperCase());
	    query.setParameter("custCode", custCode.toUpperCase());
	    BigDecimal count1 = (BigDecimal) query.uniqueResult();
		Integer count = count1.intValue();
	    clientUserDto.setTotalCount(count);
		return clientUserDto;
	}
	
	/*
	 * Method to list users based on client admin's login id and filtered alphabet with pagination
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#listCorpUsers(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public CustomerResponseDto listUsers(UsersSearchDto usersSearchDto){/*
		appLogger.debug("CAManageCorpUsersDaoImpl :: CorporateUsersResponseDto");
		CustomerResponseDto coUsersResponseDto = new CustomerResponseDto();
		List<CorporateUsersDto> corporateUsersDtos = new ArrayList<>();
		try {
			saveMIS(Constants.FEATURE_CA_VIEW_USERS, usersSearchDto.getLoginId());
			coUsersResponseDto = getSession().doReturningWork(new ReturningWork<CustomerResponseDto>() {
				@Override
				public CustomerResponseDto execute(Connection connection) throws SQLException {
					CustomerResponseDto coresponseDto = new CustomerResponseDto();
					CallableStatement callableStatement = null; 
					
					try {
						callableStatement = connection.prepareCall(Constants.CA_LIST_USER_PROC);
						callableStatement.setString(1, usersSearchDto.getAdminLoginId());
						callableStatement.setInt(3, usersSearchDto.getPageNumber());
						callableStatement.setInt(4, usersSearchDto.getPageSize());
						((OracleCallableStatement) callableStatement).registerOutParameter(5, OracleTypes.CURSOR);
						callableStatement.registerOutParameter(6, Types.INTEGER);
						callableStatement.registerOutParameter(7, Types.INTEGER);

						callableStatement.execute();
						coresponseDto.setNoOfUsers(callableStatement.getInt(6));
						coresponseDto.setTotalCount(callableStatement.getInt(7));
						ResultSet rset = (ResultSet)callableStatement.getObject (5);
						CorporateUsersDto coUsersDto = null;
						if(rset!=null){
							while (rset.next ()){
								coUsersDto = new CorporateUsersDto();
								coUsersDto.setUserId(Long.valueOf(rset.getString ("userid")));
								coUsersDto.setUserName(rset.getString ("name").toUpperCase());
								coUsersDto.setUserloginId(rset.getString ("loginid").toUpperCase());
								coUsersDto.setUserEmailId(rset.getString ("emailid").toLowerCase());
								coUsersDto.setUserMobile(rset.getString("phone"));
								if("Y".equalsIgnoreCase(rset.getString("enable_flag"))){
									coUsersDto.setUserStatus("DEACTIVATE");
								}else{
									coUsersDto.setUserStatus("ACTIVATE");
								}
								corporateUsersDtos.add(coUsersDto);
							 }
						}
						rset.close();	
					} finally {
						if(!callableStatement.isClosed()){
							callableStatement.close();
						}
					}
					coresponseDto.setUsersList(corporateUsersDtos); 
					return coresponseDto;
				}
			});
		} catch (Exception exception) {
			appLogger.error(exception.getMessage()); 
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		return coUsersResponseDto;
	*/
		return null;
	}

	/*
	 * Method to create new corporate users by corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#createCorpUser(com.bluedart.manageuserCA.dto.UserBasicDetailsDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto createCorpUser(UserBasicDetailsDto userBasicDetails) {
		appLogger.debug("CAManageCorpUsersDaoImpl :: createCorpUser");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		
		saveMIS(Constants.FEATURE_CA_CREATE_USER, userBasicDetails.getClientAdminId());
		Login adminLoginDetails = (Login) getSession().get(Login.class, userBasicDetails.getClientAdminId());
		if (adminLoginDetails != null) {
			User adminUserDetails = (User) getSession().get(User.class, adminLoginDetails.getUserID());
			if (adminUserDetails != null) {
				adminUserDetails.setStatus(Constants.CA_DEFAULT_STATUS);
				adminUserDetails.setUser_type(Constants.CORP_USERTYPE);

				String originalPassword = userBasicDetails.getPassword();
				String encryptedPassword = passwordUtil.encryptPassword(originalPassword);
				try {
					Integer procedureResponse = 3;
					procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
						
					@Override
					public Integer execute(Connection connection) throws SQLException {
						Integer returnValue = 3;
						CallableStatement callableStatement = null;
						try {
							String procedurecall = Constants.CA_CREATE_PROC;
							callableStatement = connection.prepareCall(procedurecall);
							callableStatement.setString(1, userBasicDetails.getLoginId());
							callableStatement.setString(2, encryptedPassword);
							callableStatement.setString(3, originalPassword);
							callableStatement.setInt(4, adminLoginDetails.getDBID());
							callableStatement.setString(5, adminLoginDetails.getMachineID());
							callableStatement.setInt(6, adminLoginDetails.getBad_signon_count());
							callableStatement.setString(7, adminLoginDetails.getClientAdminID());
							callableStatement.setInt(8, adminLoginDetails.getNoOfUsers());
							callableStatement.setString(9, adminLoginDetails.getPayOnlineFlag());
							callableStatement.setString(10, userBasicDetails.getName());
							callableStatement.setString(11, adminUserDetails.getCcustcode());
							callableStatement.setString(12, adminUserDetails.getUser_type());
							callableStatement.setInt(13, adminUserDetails.getSecurity_level());
							callableStatement.setInt(14, adminUserDetails.getDbdownload());
							callableStatement.setInt(15, adminUserDetails.getNo_of_affiliates());
							callableStatement.setString(16, adminUserDetails.getDesignation());
							callableStatement.setString(17, adminUserDetails.getDeptName());
							callableStatement.setString(18, adminUserDetails.getAddr1());
							callableStatement.setString(19, adminUserDetails.getAddr2());
							callableStatement.setString(20, adminUserDetails.getAddr3());
							callableStatement.setString(21, adminUserDetails.getPinCode());
							callableStatement.setString(22, userBasicDetails.getEmailId());
							callableStatement.setString(23, userBasicDetails.getPhoneNo());
							callableStatement.setString(24, adminUserDetails.getFax());
							callableStatement.setString(25, adminUserDetails.getStatus());
							callableStatement.setString(26, adminUserDetails.getMode_of_shipment());
							callableStatement.setInt(27, adminUserDetails.getNo_of_shipments());
							callableStatement.setString(28, adminUserDetails.getCity());
							callableStatement.setString(29, adminUserDetails.getCarea());
							callableStatement.setString(30, adminUserDetails.getCregion());
							callableStatement.setString(31, adminLoginDetails.getPartialPayFlag());
							callableStatement.setString(32, adminLoginDetails.getRateDisplayFlag());
							callableStatement.setString(33, adminLoginDetails.getSpickUpPayOnlineFlag());
							callableStatement.setString(34, userBasicDetails.getCountryCode());
							ArrayDescriptor des = ArrayDescriptor.createDescriptor("UPROFILE4.FEATUREINLIST", connection);
							List<Integer> features = new ArrayList<>();
							features.add(27);
							features.add(31);
							ARRAY featuresArray = new ARRAY(des, connection, features.toArray());

							callableStatement.setArray(35, featuresArray);
							callableStatement.registerOutParameter(36, Types.INTEGER);
							callableStatement.execute();
							returnValue = callableStatement.getInt(36);
						}catch(DataBaseException exception)	{

							appLogger.error("EXCEPTION TYPE :",exception);
							
							
							//appLogger.error(exception); 
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally{
							appLogger.debug("--------------------createCorpUser finally-----------------------");
							CloseConnections.closeCallableStatement(callableStatement);
						}
					    return returnValue;
					}
					});
					if (procedureResponse == 0) {
						CorporateNotificationDto notificationDto = new CorporateNotificationDto();
						notificationDto.setAction("CREATE_CORP_USER");
						notificationDto.setUserBasicDetailsDto(userBasicDetails); 
						validCustomerDto.setEmailSent(caNotificationHelper.sendEmailNotification(notificationDto ));
						validCustomerDto.setStatusMessage("SUCCESS");
					}if (procedureResponse == 99) {
						validCustomerDto.setStatusMessage("NO_OF_USERS EXCEEDED");
					}if (procedureResponse == 2) {
						validCustomerDto.setStatusMessage("NO_DATA_FOUND");				
					}if (procedureResponse == 4) {
						validCustomerDto.setStatusMessage("DUPLICATE_LOGINID");
					}if (procedureResponse == 5) {
						validCustomerDto.setStatusMessage("NO_BASE_AFFILIATE");
					}else {
						validCustomerDto.setStatusMessage("FAILURE");
					}
				} catch(DataBaseException exception)	{
					appLogger.error("EXCEPTION TYPE :",exception);
					
					
					appLogger.error(exception); 
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}
			}
		}
		return validCustomerDto;
	}
	
	/*
	 * Method to search affiliates by corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#searchAffiliates(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ClientUserDto searchAffiliates(String areaCode, String custCode, String adminLoginId, String userLoginId,
			int pageSize, int pageNumber) {
		appLogger.debug("CAManageCorpUsersDaoImpl :: searchAffiliates");
		ClientUserDto clientUserDto = new ClientUserDto();
		List<AffiliateDetailDto> affList = new ArrayList<>();
		try{
			saveMIS(Constants.FEATURE_CA_SEARCH_AFF, adminLoginId);
			affList = getSession().doReturningWork(new ReturningWork<List<AffiliateDetailDto>>() {
				ResultSet rset = null;
			@Override
			public List<AffiliateDetailDto> execute(Connection connection) throws SQLException {
				List<AffiliateDetailDto> affList = new ArrayList<>();
				CallableStatement callableStatement = null;
				try{
				callableStatement = connection.prepareCall(Constants.CA_SEARCH_AFF_PROC);
				
				callableStatement.clearParameters();
				String areaCode1 = null;
				String custCode1= null;
				if(areaCode==null || areaCode.equalsIgnoreCase("null")){
					areaCode1=null;
				}else{
					areaCode1=areaCode;
				}
				if(custCode==null || custCode.equalsIgnoreCase("null")){
					custCode1=null;
				}else{
					custCode1=custCode;
				}
				callableStatement.setString(1, areaCode1); 
				callableStatement.setString(2, custCode1); 
				callableStatement.setString(3, adminLoginId); 
				callableStatement.setString(4, userLoginId); 
				callableStatement.setInt(5, pageSize); 
				callableStatement.setInt(6, pageNumber); 
				((OracleCallableStatement) callableStatement).registerOutParameter(7, OracleTypes.CURSOR);
				((OracleCallableStatement) callableStatement).registerOutParameter(8, Types.INTEGER);
				
				((OracleCallableStatement) callableStatement).executeUpdate();

				rset = (ResultSet)callableStatement.getObject (7);
				Integer totalCount = callableStatement.getInt(8);
				clientUserDto.setTotalCount(totalCount); 
				
				 while (rset.next ()){
					 AffiliateDetailDto affiliateDetailDto = new AffiliateDetailDto();
					 affiliateDetailDto.setAreaCode(rset.getString ("AFF_AC"));
					 affiliateDetailDto.setCustCode(rset.getString ("AFF_CC"));
					 affList.add(affiliateDetailDto); 
				 }
				}catch(Exception exception){
					appLogger.error("EXCEPTION TYPE :",exception);
					
				}
				finally{
					appLogger.debug("-------------------searchAffiliates---------------------");
					CloseConnections.closeResultSet(rset);
					CloseConnections.closeCallableStatement(callableStatement);
				}
			
				return affList;
			}
		});
		}catch(Exception exception){
			appLogger.error("EXCEPTION TYPE :",exception);
			
			//appLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		clientUserDto.setAffList(affList); 
		
		return clientUserDto;
	}

	@Override
	@Transactional
	public BDCustomerDto addAffiliates(BDCustomerDto bdCustDto){
		appLogger.debug("CAManageCorpUsersDaoImpl:: addAffiliates");
		BDCustomerDto bdCustomerDto = new BDCustomerDto();
		List<AffiliateDetailDto> affList = bdCustDto.getAffList();
		List<AffiliateDetailDto> affiliatesList = null;
		AffiliateDetailDto[] affListArray = affList.toArray(new AffiliateDetailDto[affList.size()]);
		try {
			affiliatesList = getSession().doReturningWork(new ReturningWork<List<AffiliateDetailDto>>() {
				@Override
				public List<AffiliateDetailDto> execute(Connection connection) throws SQLException {
					List<AffiliateDetailDto> affList = null;
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						localMap.put(environment.getProperty(BDAdminConstants.AFFOBJ_BD_ADMIN),Class.forName(BDAdminConstants.AFF_DTO));
						connection.setTypeMap(localMap);
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN),connection);
						ARRAY affArrayToPass = new ARRAY(des, connection, affListArray);
						
						callableStatement = connection.prepareCall("{call UPROFILE4.aff_mang_bd_admin.addAffiliates_clientadmin(?,?)}");
						callableStatement.clearParameters();						
						((OracleCallableStatement) callableStatement).setArray(1, affArrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY, environment.getProperty(BDAdminConstants.AFFLIST_BD_ADMIN));
						((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
						((OracleCallableStatement) callableStatement).execute();
						Integer output = callableStatement.getInt(2);
						if(output==0){
							bdCustomerDto.setStatusMessage("SUCCESS");
							ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(1);
							if (affiliates != null && affiliates.length() != 0) {
								list = Arrays.asList((Object[]) affiliates.getArray());
								affList = new ArrayList<>(list);
							} 
						}else{
							bdCustomerDto.setStatusMessage("FAILURE");
						}
					}catch(DataBaseException exception)	{
						appLogger.error("EXCEPTION TYPE :",exception);
						
						//appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} catch (ClassNotFoundException exception) {
						appLogger.error("EXCEPTION TYPE :",exception);
						
						appLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());					
					}
					finally {
						appLogger.debug("-------------------addAffiliates finally---------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return affList;
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
	 * Method to activate or deactivate corporate user by corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#activateOrDeactivate(com.bluedart.common.dto.CorporateUserDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto activateOrDeactivate(CorporateUserDto corporateUserDto) {
		appLogger.debug("CAManageCorpUsersDaoImpl :: activateOrDeactivate");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		
		if(null!=corporateUserDto){ 
			saveMIS(Constants.FEATURE_CA_UPDATE_STATUS, corporateUserDto.getByLoginId());
			Integer procedureResp = -2;
			try {
				procedureResp = getSession().doReturningWork(new ReturningWork<Integer>() {
					@Override
					public Integer execute(Connection connection) throws SQLException {
						Integer procedureResponse = -2;
						CallableStatement callableStatement = null;
						try {
							callableStatement = connection.prepareCall(Constants.CA_UPDATESTATUS_PROC);
							callableStatement.setString(1, corporateUserDto.getLoginId());
							callableStatement.setString(2, corporateUserDto.getStatus());
							callableStatement.setString(3, Constants.CA_MODULE_NAME);
							callableStatement.setString(4, corporateUserDto.getStatus());
							callableStatement.setString(5, Constants.CA_ADMINFLAG);
							callableStatement.registerOutParameter(6, Types.INTEGER);
							callableStatement.registerOutParameter(7, Types.VARCHAR);
							callableStatement.execute();
							procedureResponse = callableStatement.getInt(6);
							callableStatement.getString(7);
						}catch(Exception exception){
							appLogger.error("EXCEPTION TYPE :",exception);
							
							appLogger.error(exception); 
						}
						finally {
							
							appLogger.debug("-------------------activateOrDeactivate finally---------------------");
							CloseConnections.closeCallableStatement(callableStatement);
						}
						return procedureResponse;
					}
				});
			} catch (Exception exception) {
				appLogger.error("EXCEPTION TYPE :",exception);
				
				appLogger.error(exception); 
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			} 
			if(procedureResp==0){
				validCustomerDto.setValidFlag(BDAdminConstants.SUCCESS);
				CorporateNotificationDto notificationDto = new CorporateNotificationDto();
				if(corporateUserDto.getStatus().equalsIgnoreCase("DEACTIVATE")){
					notificationDto.setAction("DEACTIVATE_CORP_USER");
				}else{
					notificationDto.setAction("ACTIVATE_CORP_USER");
				}
				notificationDto.setCorporateUserDto(corporateUserDto); 
				caNotificationHelper.sendEmailNotification(notificationDto);
			}
		}else{
			validCustomerDto.setValidFlag("FAILURE");
		}
		return validCustomerDto;
	}

	/*
	 * Method to update corporate user details by corporate admin
	 * (non-Javadoc)
	 * @see com.bluedart.camanagecorpusers.dao.CAManageCorpUsersDao#editCorpUser(com.bluedart.manageuserCA.dto.UserBasicDetailsDto)
	 */
	@Override
	@Transactional
	public ValidCustomerDto editCorpUser(UserBasicDetailsDto userBasicDetails) {
		appLogger.debug("CAManageCorpUsersDaoImpl :: editCorpUser");
		ValidCustomerDto validCustomerDto = new ValidCustomerDto();
		if(userBasicDetails!=null && userBasicDetails.getLoginId()!=null){
			saveMIS(Constants.FEATURE_CA_EDIT_USER, userBasicDetails.getClientAdminId());
			Integer procedureResp = -2;
			try {
				procedureResp = getSession().doReturningWork(new ReturningWork<Integer>() {
					@Override
					public Integer execute(Connection connection) throws SQLException {
						Integer procedureResponse = -2;
						CallableStatement callableStatement = null;
						try {
							callableStatement = connection.prepareCall(Constants.CA_EDIT_USER_PROC);
							callableStatement.setString(1, userBasicDetails.getName());
							callableStatement.setString(2, userBasicDetails.getEmailId());
							callableStatement.setString(3, userBasicDetails.getPhoneNo());
							callableStatement.setString(4, userBasicDetails.getLoginId());
							callableStatement.setString(5, Constants.CA_MODULE_NAME);
							callableStatement.setString(6, "EDIT_USER");
							callableStatement.registerOutParameter(7, Types.INTEGER);
							callableStatement.registerOutParameter(8, Types.VARCHAR);
							callableStatement.execute();
							procedureResponse = callableStatement.getInt(7);
							callableStatement.getString(8);
						}catch(Exception exception){
							appLogger.error("EXCEPTION TYPE :",exception);
							
							appLogger.error(exception); 
						}
						finally {
							appLogger.debug("-------------------editCorpUser finally---------------------");
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
				validCustomerDto.setStatusMessage(Constants.SUCESSMESSAGE);
			}
		}
		return validCustomerDto;
	}
	
	/**
	 * Method to save MIS log
	 * @param featureName
	 * @param loginId
	 * @return
	 */
	private boolean saveMIS(String featureName, String loginId) {
		boolean flag = false;
		try{
			flag = misLogDao.saveMIS(featureName, loginId);
		}catch(Exception exception){
			
			appLogger.error("EXCEPTION TYPE :",exception);
			
			appLogger.error("CAManageCorpUsersDaoImpl : saveMIS  "+exception);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}
}
