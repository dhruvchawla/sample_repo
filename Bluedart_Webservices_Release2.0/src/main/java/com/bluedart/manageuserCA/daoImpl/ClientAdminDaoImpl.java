package com.bluedart.manageuserCA.daoImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bluedart.bdmanagecorporateusers.dao.BDManageCorporateUsersDao;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.PermissionDto;
import com.bluedart.common.dto.PermissionMappingDto;
import com.bluedart.common.dto.ValidCustomerDto;
import com.bluedart.common.entity.AffiliatesMaster;
import com.bluedart.common.entity.Feature;
import com.bluedart.common.entity.Login;
import com.bluedart.common.entity.User;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.manageuserCA.dao.ClientAdminDao;
import com.bluedart.manageuserCA.dto.AffiliatesDto;
import com.bluedart.manageuserCA.dto.ClientAdminResponseDto;
import com.bluedart.manageuserCA.dto.CorporateCustomerDto;
import com.bluedart.manageuserCA.dto.RegisterDetailDto;
import com.bluedart.manageuserCA.dto.UserBasicDetailsDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * 
 * @author TH334025 
 * This class is having methods for corporate/client admin and
 *         bluedart admin functionalities
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class ClientAdminDaoImpl extends BaseDaoImpl implements ClientAdminDao {

	private static final Logger logger = Logger.getLogger(ClientAdminDaoImpl.class);

	@Autowired
	private RegistrationDaoImpl registerDBHandler;

	private PasswordUtil passwordUtil = new PasswordUtil();

	@Autowired
	private Environment environment;
	
	@Autowired
	private MISLogDao misLogDao;
	
	@Autowired
	private BDManageCorporateUsersDao bdManageCDaoImpl;
	
	
	private List<AffiliatesDto> affiliateslist = null;
	private UserBasicDetailsDto userBasicDetailsDto = null;
	private List<UserBasicDetailsDto> userBasicDetails = null;
	private UserBasicDetailsDto userDetails = null;
	private EmailContent emailContent = null;
	private CorporateCustomerDto corporateCustomerDto = null;
	Session session= null;
	
	private ClientAdminResponseDto clResponseDto = null;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#getAffiliates(java.lang.String,
	 * java.lang.String) This method returns a list of affliates objects for the
	 * given loginId
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto getAffiliates(String loginId) {
		logger.debug("ClientAdminDaoImpl:getAffiliates");
		session = getSession();
		affiliateslist = new ArrayList<>();
		clResponseDto = new ClientAdminResponseDto();

		try {
			affiliateslist =  session.doReturningWork(new ReturningWork<List<AffiliatesDto>>() {

				@SuppressWarnings("null")
				@Override
				public List<AffiliatesDto> execute(Connection connection) throws SQLException {
					List<AffiliatesDto> afflist = new ArrayList<AffiliatesDto>();
					CallableStatement callableStatement = null;
					ResultSet rs = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();

						try {
							localMap.put(environment.getProperty("AFFOBJ"),
									Class.forName(Constants.MANAGEUSERCA_AFFILIATESDTO));
						} catch (ClassNotFoundException e) {
							logger.error("ClassNotFound");
							logger.error("EXCEPTION TYPE :",e);
						}
						connection.setTypeMap(localMap);

						String procedurecall = "{call UPROFILE4.aff_mang_bd_admin. getAffiliates_clientadmin(?, ?, ?)}";

						callableStatement = connection.prepareCall(procedurecall);

						((OracleCallableStatement) callableStatement).setString(1, loginId);
						((OracleCallableStatement) callableStatement).setString(2, null);
						((OracleCallableStatement) callableStatement).registerOutParameter(3, OracleTypes.CURSOR);
						//((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
							//	environment.getProperty("AFFLIST"));
						callableStatement.execute();

						//ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(3);
						 rs = (ResultSet) callableStatement.getObject(3);
						 
						 while (rs.next()) {
							AffiliatesDto affDto = new AffiliatesDto();
							
							 affDto.setLoginid(rs.getString("loginid"));
							 affDto.setAc(rs.getString("aff_ac"));
							 affDto.setCc(rs.getString("aff_cc"));
							 affDto.setBpFlag(rs.getString("BPFlag"));
							 affDto.setCustname(rs.getString("ccustname"));
							 affDto.setCreated_by(rs.getString("CREATED_BY"));
							 affDto.setBaseAffiliateFlag(rs.getString("CBASEAFFILIATE"));
							 
							 afflist.add(affDto);
						}
						/*if (affiliates != null && affiliates.length() != 0) {
							afflist = getAffiliateDetails(affiliates);
						}*/
					} catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------getAffiliates finally-----------------------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closeCallableStatement(callableStatement);
					}
					return afflist;
				}
			});

		}catch(DataBaseException cuException)	{
			logger.error("EXCEPTION TYPE :",cuException);
			//logger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl:getAffiliates ::" + affiliateslist);
		clResponseDto.setAffiliatesDtoList(affiliateslist);
		return clResponseDto;
	}

	/*
	 * Private method to convert sql array into list of AffiliatesDto objects
	 */
	private List<AffiliatesDto> getAffiliateDetails(ARRAY affArray) throws SQLException {
		affiliateslist = new ArrayList<>();

		Object[] object = (Object[]) affArray.getArray();
		AffiliatesDto affiliatesDto;
		if(object!=null){
		for (int i = 0; i < object.length; i++) {
			affiliatesDto = new AffiliatesDto();
			affiliatesDto = (AffiliatesDto) object[i];
			logger.info("object"+object[i]+"::::::"+ affiliatesDto.getAc() );
			affiliateslist.add(affiliatesDto);
		}
		}
		return affiliateslist;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#createNewUser(com.bluedart
	 * .dto.UserBasicDetailsDto) To create an user under corporate admin.
	 * Returns 0 if user created successfully, else 1.
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto createNewUser(UserBasicDetailsDto userBasicDetails) {
		logger.debug("ClientAdminDaoImpl : createNewUser");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		
		misLogDao.saveMIS(Constants.FEATURE_NAME_MANAGE_USER_CREATEUSER, userBasicDetails.getClientAdminId());
		
		String methodResponse = "";
		String adminLoginId = userBasicDetails.getClientAdminId();
		Login login = (Login) session.get(Login.class, adminLoginId);
		if (login != null) {
			User user = (User) session.get(User.class, login.getUserID());
			logger.debug("User in create method :: "+user);
			if (user != null) {
				user.setStatus("FORCE");
				user.setUser_type("CREDIT_CUST");

				String password = passwordUtil.generateStrongPassword();
				String encPassword = passwordUtil.encryptPassword(password);
				logger.info("password: "+ password +"encPassword: "+encPassword);
				String[] feature = userBasicDetails.getFeatures().split(",");
				try {
					for (int i = 0; i < feature.length; i++) {
						if ("Schedule a Pickup".equals(feature[i])) {
							login.setSpickUpPayOnlineFlag("y");
							login.setRateDisplayFlag("y");
						} else if ("BILL_PAYMENTS_PAYONLINE".equals(feature[i])) {
							login.setPartialPayFlag("y");
							login.setPayOnlineFlag("y");
						}
					}
					List<Integer> features = assignfeatures(feature, session);
					//PermissionMappingDto perMappingDto = new PermissionMappingDto();
					//List<PermissionDto> permissionList = permiList(feature,session);
					
					Integer procedureResponse = 3;
					procedureResponse = (Integer) session.doReturningWork(new ReturningWork<Integer>() {
						
					@Override
					public Integer execute(Connection connection) throws SQLException {
						Integer returnValue = 3;
						CallableStatement callableStatement = null;
						try {
							logger.debug("Calling procedure  PrcCreateuser_updated ");
							String procedurecall = "{call UPROFILE4.PKGCLIENT_CORPORATE.PrcCreateuser_updated(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							callableStatement = connection.prepareCall(procedurecall);
							callableStatement.setString(1, userBasicDetails.getLoginId());
							callableStatement.setString(2, encPassword);
							callableStatement.setString(3, password);
							callableStatement.setInt(4, login.getDBID());
							callableStatement.setString(5, login.getMachineID());
							callableStatement.setInt(6, login.getBad_signon_count());
							callableStatement.setString(7, login.getClientAdminID());
							callableStatement.setInt(8, login.getNoOfUsers());
							callableStatement.setString(9, login.getPayOnlineFlag());
							callableStatement.setString(10, userBasicDetails.getName());
							callableStatement.setString(11, user.getCcustcode());
							callableStatement.setString(12, user.getUser_type());
							callableStatement.setInt(13, user.getSecurity_level());
							callableStatement.setInt(14, user.getDbdownload());
							callableStatement.setInt(15, user.getNo_of_affiliates());
							callableStatement.setString(16, user.getDesignation());
							callableStatement.setString(17, user.getDeptName());
							callableStatement.setString(18, user.getAddr1());
							callableStatement.setString(19, user.getAddr2());
							callableStatement.setString(20, user.getAddr3());
							callableStatement.setString(21, user.getPinCode());
							callableStatement.setString(22, userBasicDetails.getEmailId());
							callableStatement.setString(23, userBasicDetails.getPhoneNo());
							callableStatement.setString(24, user.getFax());
							callableStatement.setString(25, user.getStatus());
							callableStatement.setString(26, user.getMode_of_shipment());
							callableStatement.setInt(27, user.getNo_of_shipments());
							callableStatement.setString(28, user.getCity());
							callableStatement.setString(29, user.getCarea());
							callableStatement.setString(30, user.getCregion());
							callableStatement.setString(31, login.getPartialPayFlag());
							callableStatement.setString(32, login.getRateDisplayFlag());
							callableStatement.setString(33, login.getSpickUpPayOnlineFlag());
							callableStatement.setString(34, userBasicDetails.getCountryCode());
							ArrayDescriptor des = ArrayDescriptor
									.createDescriptor(environment.getProperty("FEATUREINLIST"), connection);
							ARRAY array_to_pass = new ARRAY(des, connection, features.toArray());

							callableStatement.setArray(35, array_to_pass);
							callableStatement.registerOutParameter(36, Types.INTEGER);
							callableStatement.execute();
							logger.debug("procedure  result PrcCreateuser_updated :: "+returnValue);
							returnValue = callableStatement.getInt(36);
							logger.info(returnValue);
						}catch(DataBaseException exception)	{
							logger.error("EXCEPTION TYPE :",exception);
							//logger.debug(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally{
							logger.debug("------------------------createNewUser finally-----------------------");
							CloseConnections.closeCallableStatement(callableStatement);
						}
					    return returnValue;
					}
					});
					
					logger.debug("ClientAdminDaoImpl : createNewUser ::" + procedureResponse);
					if (procedureResponse == 0) {
						AffiliatesMaster affiliatesMaster = new AffiliatesMaster();
						affiliatesMaster.setAffiliateCustomerCode(user.getCcustcode());
						affiliatesMaster.setAreaCode(user.getCarea());
						affiliatesMaster.setLoginId(userBasicDetails.getLoginId());
						affiliatesMaster.setBpFlag("0");
						createNewAffiliate(affiliatesMaster, session, userBasicDetails.getClientAdminId());
						methodResponse = password;
					} else {
						methodResponse += procedureResponse;
					}
				} catch(DataBaseException exception)	{
					logger.error("EXCEPTION TYPE :",exception);
				//	logger.debug(exception);
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}
			}
		}
		clResponseDto.setCreateNewUserResponse(methodResponse);
		logger.info(" return: "+clResponseDto.getCreateNewUserResponse());
		return clResponseDto;
	}

	private void createNewAffiliate(AffiliatesMaster affiliatesMaster, Session session, String clientAdminId){
		clResponseDto = new ClientAdminResponseDto();
		try {
			clResponseDto = getAffiliates(clientAdminId);
		} catch (Exception e1) {
			logger.error("Error in getting affiliates list "+e1.getMessage());
		}
		if (clResponseDto.getAffiliatesDtoList() != null && !(clResponseDto.getAffiliatesDtoList().isEmpty())) {
			
			List<AffiliatesDto> userAffiliates = new ArrayList<>();
			for (AffiliatesDto affiliate : clResponseDto.getAffiliatesDtoList()) {
				affiliate.setSql_type("UPROFILE4.AFFOBJ_BD_ADMIN");
				affiliate.setLoginid(affiliatesMaster.getLoginId());
				userAffiliates.add(affiliate);
			}
			try {
				addAffiliates(userAffiliates);
			} catch (Exception e) {
				logger.error("EXCEPTION TYPE :",e);
				logger.error("Error in adding affiliates "+e.getMessage());
			}
			logger.debug("ClientAdminDaoImpl : createNewAffiliate  ::" + "Admin affiliates added");

		} else {
			session.save(affiliatesMaster);
			logger.debug("ClientAdminDaoImpl : createNewAffiliate  ::" + "new affiliate added");
		}
	}

	/*
	 * Privte method to get the featureIds for the given features
	 */
	private List<Integer> assignfeatures(String[] feature, Session session) {

		List<Integer> features = new ArrayList<>();
		if (feature != null) {
			/*Criteria criteria = session.createCriteria(Feature.class).add(Restrictions.in("description", feature));
			List<Feature> featureIdList = criteria.list();
*/
			Properties featureProperties = new Properties();

			try {
				featureProperties.load(getClass().getClassLoader().getResourceAsStream("feature.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}


			
			for (String featureDB : feature) {
				if(featureDB.equalsIgnoreCase("TRACK AND TRACE")){
					features.add(Integer.parseInt((featureProperties.getProperty("TRACK_AND_TRACE"))));
				}
				if(featureDB.equalsIgnoreCase("DOWNLOADS")){
					features.add(Integer.parseInt((featureProperties.getProperty("INTERNET_DART_REPORT_DOWNLOAD"))));
				}
			}
		} else {
			features.add(Integer.parseInt((environment.getProperty("TRACK_AND_TRACE"))));
		}
		return features;
	}
	
	private List<PermissionDto> permiList(String[] feature, Session session) {

		List<PermissionDto> permissionDtoList = new ArrayList<>();
		PermissionDto permissionDto = null;
		
		
		if (feature != null) {
		
			if(feature.length<=1){
				permissionDto = new PermissionDto();
				permissionDto.setPermissionName("TRACK_AND_TRACE");
				permissionDto.setPermissionValue("Y");
				permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
				permissionDtoList.add(permissionDto);
				
				permissionDto = new PermissionDto();
				permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
				permissionDto.setPermissionValue("N");
				permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
				permissionDtoList.add(permissionDto);
			}else{
				for (String featureDB : feature) {
					permissionDto = new PermissionDto();
					if(featureDB.equalsIgnoreCase("TRACK AND TRACE")){
						permissionDto.setPermissionName("TRACK_AND_TRACE");
					}
					if(featureDB.equalsIgnoreCase("DOWNLOADS")){
						permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
					}
					
					permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
					permissionDto.setPermissionValue("Y");
					permissionDtoList.add(permissionDto);
				}
			}
		} else {
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName("TRACK_AND_TRACE");
			permissionDto.setPermissionValue("Y");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtoList.add(permissionDto);
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
			permissionDto.setPermissionValue("N");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtoList.add(permissionDto);
		}

		return permissionDtoList;
	}
	

	/*private List<PermissionDto> permiList(String[] feature, Session session) {

		List<PermissionDto> permissionDtoList = new ArrayList<>();
		PermissionDto permissionDto = null;
		
		
		if (feature != null) {
		
			for (String featureDB : feature) {
				permissionDto = new PermissionDto();
				if(featureDB.equalsIgnoreCase("TRACK AND TRACE")){
					permissionDto.setPermissionName("TRACK_AND_TRACE");
				}
				if(featureDB.equalsIgnoreCase("DOWNLOADS")){
					permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
				}
				
				permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
				permissionDto.setPermissionValue("Y");
				permissionDtoList.add(permissionDto);
			}
		} else {
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName("TRACK_AND_TRACE");
			permissionDto.setPermissionValue("Y");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtoList.add(permissionDto);
			
			permissionDto = new PermissionDto();
			permissionDto.setPermissionName("INTERNET_DART_REPORT_DOWNLOAD");
			permissionDto.setPermissionValue("N");
			permissionDto.setSql_type("UPROFILE4.PERMISSIONMPNGOBJ");
			permissionDtoList.add(permissionDto);
		}

		return permissionDtoList;
	}*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluedart.dao.ClientAdminDao#deleteUser(java.lang.String)
	 * Method to delete an user under bluedart admin. Returns 0 if deleted
	 * successfully
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto deleteUser(String loginId) {
		logger.debug("ClientAdminDaoImpl : deleteUser");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		Integer returnvalue = 1;
		
		misLogDao.saveMIS(Constants.FEATURE_NAME_MANAGE_USER_DELETEUSER, loginId.toUpperCase());
		
		try {
			returnvalue = (Integer) session.doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int response = 1;
					CallableStatement callableStatement = null;
					try {
						String procedureCall = "{ call UPROFILE4.PKGCLIENT_CORPORATE.Prcdeleteuser(?,?)}";
						callableStatement = connection.prepareCall(procedureCall);
						callableStatement.setString(1, loginId);
						callableStatement.registerOutParameter(2, Types.INTEGER);
						callableStatement.execute();
						response = callableStatement.getInt(2);
					}catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------deleteUser finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return response;
				}
			});
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : deleteUser ::" + returnvalue);
		clResponseDto.setDeleteUserResponse(returnvalue);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluedart.dao.ClientAdminDao#viewUsers(java.lang.String,
	 * java.lang.String) To view the users under an corporate admin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto viewUsers(String loginId, String flag) {
		logger.debug("ClientAdminDaoImpl : viewUsers");
		clResponseDto = new ClientAdminResponseDto();
		session = getSession();
		userBasicDetails = new ArrayList<>();
		try {
			List<User> userList = null;
			if (flag == null || "all".equalsIgnoreCase(flag)) {
				logger.debug("all condition");
				String hql = "SELECT A FROM Login B, User A WHERE B.loginID <> B.clientAdminID AND UPPER(B.flag) = 'Y'"
						+ " AND A.userID = B.userID AND B.clientAdminID = ? order by A.name ASC";
				/*Query qry = session.createQuery(hql);
				if (qry.list() != null) {
					userList = qry.list();
				}*/
				userList = (List<User>) getHibernateTemplate().find(hql, loginId);
				logger.debug("userList in viewUsers (ALL) :: "+userList);
			} else {
				logger.debug("alphabet condition :: "+flag);
				String upperCase = flag.toUpperCase() + "%";
				String lowercase = flag.toLowerCase() + "%";
				String hql = "SELECT A FROM Login B, User A WHERE B.clientAdminID = '" + loginId
						+ "' AND B.loginID <> B.clientAdminID AND UPPER(B.flag) = 'Y' AND A.userID = B.userID AND (A.name LIKE '"
						+ upperCase + "' OR A.name LIKE '" + lowercase + "') ORDER BY A.name ASC ";
				Query qry = session.createQuery(hql);
				if (qry.list() != null) {
					userList = qry.list();
					logger.debug("userList in viewUsers (alphabet):: "+userList);
				}
			}
			
			for (User user : userList) {
				userBasicDetailsDto = new UserBasicDetailsDto();
				userBasicDetailsDto.setUserId(user.getUserID());
				userBasicDetailsDto.setLoginId(getSpecificLoginId(user.getUserID(), session));
				userBasicDetailsDto.setEmailId(user.getEmailid());
				userBasicDetailsDto.setName(user.getName());
				userBasicDetailsDto.setPhoneNo(user.getPhone());
				userBasicDetails.add(userBasicDetailsDto);
			}
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.debug(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : viewUsers  ::" + userBasicDetails);
		clResponseDto.setUserBasicDetailsDtos(userBasicDetails);
		logger.debug("viewUsers  DTO :: "+clResponseDto.toString());
		return clResponseDto;
	}

	private String getSpecificLoginId(Integer userId, Session session) {
		Criteria criteria = session.createCriteria(Login.class).add(Restrictions.eq("userID", userId));
		Login login = (Login) criteria.uniqueResult();
		return login.getLoginID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#modifyUserClientAdmin(com.wipro
	 * .bluedart.dto.UserBasicDetailsDto) To change name, emailId, phoneNo,
	 * features for an user under corporate admin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto modifyUserClientAdmin(UserBasicDetailsDto userBasicDetails) {
		logger.debug("ClientAdminDaoImpl : modifyUserClientAdmin");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		
		misLogDao.saveMIS(Constants.FEATURE_NAME_MANAGE_USER_EDITUSER, userBasicDetails.getClientAdminId());
		
		Integer returnvalue = -1;
		String[] feature = userBasicDetails.getFeatures().split(",");
		for (int i = 0; i < feature.length; i++) {
			if ("Schedule a Pickup".equals(feature[i])) {
				userBasicDetails.setSpickUpPayOnlineFlag("y");
				userBasicDetails.setRateDisplayFlag("y");
			} else if ("BILL_PAYMENTS_PAYONLINE".equals(feature[i])) {
				userBasicDetails.setPartialPayFlag("y");
				userBasicDetails.setPayOnlineFlag("y");
			}
		}
		try {
			List<Integer> featureArray = assignfeatures(feature, session);
			/*PermissionMappingDto perMappingDto = new PermissionMappingDto();
			List<PermissionDto> permissionList = permiList(feature,session);
			*/
			
			returnvalue = (Integer) session.doReturningWork(new ReturningWork<Integer>() {

				@Override
				public Integer execute(Connection connection) throws SQLException {
					int response = -1;
					CallableStatement callableStatement = null;
					try {
						String procedureCall = "{ call UPROFILE4.PKGCLIENT_CORPORATE.PrcEdituser_new(?,?,?,?,?,?,?,?,?,?,?,?)}";
						callableStatement = connection.prepareCall(procedureCall);
						callableStatement.setString(1, userBasicDetails.getLoginId());
						callableStatement.setString(2, userBasicDetails.getPayOnlineFlag());
						callableStatement.setString(3, userBasicDetails.getPartialPayFlag());
						callableStatement.setString(4, userBasicDetails.getRateDisplayFlag());
						callableStatement.setString(5, userBasicDetails.getSpickUpPayOnlineFlag());
						callableStatement.setString(6, userBasicDetails.getName());
						callableStatement.setString(7, userBasicDetails.getEmailId());
						callableStatement.setString(8, userBasicDetails.getPhoneNo());
						callableStatement.setString(9, userBasicDetails.getCregion());
						callableStatement.setString(10, userBasicDetails.getCountryCode());
						
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty("FEATUREINLIST"),
								connection);
						ARRAY array_to_pass = new ARRAY(des, connection, featureArray.toArray());
						callableStatement.setArray(11, array_to_pass);
						callableStatement.registerOutParameter(12, Types.INTEGER);
						callableStatement.execute();
						response = callableStatement.getInt(12);
				
					}catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------modifyUserClientAdmin finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				    return response;
				}
			});

		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : modifyUserClientAdmin ::" + returnvalue);
		clResponseDto.setModifyUserClientAdminResponse(returnvalue);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#getSingleUser(java.lang.String) To
	 * get the whole details about the user for the given loginId
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto getSingleUser(String loginId) {
		logger.debug("ClientAdminDaoImpl : getSingleUser ::");
		userDetails = new UserBasicDetailsDto();
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		try {
			Login login = (Login) session.get(Login.class, loginId);

			if (login != null) {
				User user = (User) session.get(User.class, login.getUserID());
				userDetails.setLoginId(loginId);
				userDetails.setName(user.getName());
				userDetails.setPassword(login.getPassword());
				userDetails.setCity(user.getCity());
				userDetails.setAddr1(user.getAddr1());
				userDetails.setAddr2(user.getAddr2());
				userDetails.setAddr3(user.getAddr3());
				userDetails.setCarea(user.getCarea());
				userDetails.setCcustcode(user.getCcustcode());
				userDetails.setCntPerson(user.getCntPerson());
				userDetails.setEmailId(user.getEmailid());
				userDetails.setFax(user.getFax());
				userDetails.setNo_of_affiliates(user.getNo_of_affiliates());
				userDetails.setNoOfUsers(login.getNoOfUsers());
				userDetails.setPartialPayFlag(login.getPartialPayFlag());
				userDetails.setPayOnlineFlag(login.getPayOnlineFlag());
				userDetails.setPhoneNo(user.getPhone());
				userDetails.setPinCode(user.getPinCode());
				userDetails.setRateDisplayFlag(login.getRateDisplayFlag());
				userDetails.setSd_awbqty(login.getSd_awbqty());
				userDetails.setSd_qtyusagechk(login.getSd_qtyusagechk());
				userDetails.setSecureid(login.getSecureid());
				userDetails.setSecurity_level(user.getSecurity_level());
				userDetails.setSpickUpPayOnlineFlag(login.getSpickUpPayOnlineFlag());
				userDetails.setStatus(user.getStatus());
				userDetails.setUser_type(user.getUser_type());
				userDetails.setUserId(user.getUserID());
				userDetails.setCountryCode(user.getCountryCode());
			}
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : getSingleUser ::" + userDetails);
		clResponseDto.setUserBasicDetailsDto(userDetails);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#resetPassword(java.lang.String) To
	 * reset the password for a given loginId. This feature is for bluedartadmin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto resetPassword(String loginId, String emailId) {
		logger.debug("ClientAdminDaoImpl : resetPassword ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		
		misLogDao.saveMIS(Constants.FEATURE_NAME_MANAGE_USER_RESET_PWD, loginId.toUpperCase());
		
		String generatedPassword = passwordUtil.generateStrongPassword();
		String passWord = null;
		Integer returnValue = -2;
		try {
			String encryptedPassword = passwordUtil.encryptPassword(generatedPassword);
			returnValue = session.doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer returnValue = -2;
					CallableStatement callableStatement = null;
					try {
						callableStatement = connection.prepareCall("{ call UPROFILE4.ADMIN_CORPORATE.resetpassword(?,?,?,?)}");
						callableStatement.setString(1, loginId);
						callableStatement.setString(2, generatedPassword);
						callableStatement.setString(3, encryptedPassword);
						callableStatement.registerOutParameter(4, Types.INTEGER);
						callableStatement.execute();
						returnValue = callableStatement.getInt(4);
					} catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------resetPassword finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return returnValue;
				}
			});
			if (returnValue == 0) {
				passWord = generatedPassword;
			}
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : resetPassword ::" + returnValue);
		clResponseDto.setResetPwdResponse(passWord);
		return clResponseDto;
	}

	public ClientAdminResponseDto sendMail(String emailId, String loginId, String pwd, String status) {
		logger.info(" pwd : "+pwd);
		boolean isMailSent = false;
		clResponseDto = new ClientAdminResponseDto();
		emailContent = new EmailContent();
		emailContent.setFrom("response@bluedart.com");
		emailContent.setTo(emailId);

		if ("create".equals(status)) {
			emailContent.setSubject("New user created under Corporate Admin");
			emailContent.setText("New user details are as follows:  Username:" + loginId + " & Pwd:" + pwd);
			logger.info(emailContent.getText());
		} else if ("reset".equals(status)) {
			emailContent.setSubject("Your password has been reset successfully");
			emailContent.setText("New password details are as follows:  Username:" + loginId + "& Pwd:" + pwd);
			
		}
		
		try {
			EmailUtil.sendEmail(emailContent);
			isMailSent = true;
		} catch (Exception e) {
			logger.error("EXCEPTION TYPE :",e);
			throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(), ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
		}
		clResponseDto.setMailSent(isMailSent);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluedart.dao.ClientAdminDao#addAffiliates(java.util.List)
	 * To add affiliates for the given user by bluedartadmin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto addAffiliates(List<AffiliatesDto> affList) {
		logger.debug("ClientAdminDaoImpl : addAffiliates ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		//List<AffiliatesDto> affiliatesList = null;
		AffiliatesDto[] affliates = affList.toArray(new AffiliatesDto[affList.size()]);
		try {
			affiliateslist = session.doReturningWork(new ReturningWork<List<AffiliatesDto>>() {
				@Override
				public List<AffiliatesDto> execute(Connection connection) throws SQLException {
					List<AffiliatesDto> afflist = new ArrayList<AffiliatesDto>();
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						try {
							localMap.put(environment.getProperty("AFFOBJ_BD_ADMIN"),
									Class.forName(Constants.MANAGEUSERCA_AFFILIATESDTO));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						connection.setTypeMap(localMap);

						String procedurecall = "{call UPROFILE4.aff_mang_bd_admin.addAffiliates_clientadmin(?,?)}";
						callableStatement = connection.prepareCall(procedurecall);
						
						
						ARRAY arrayToPass = null;
						try {
							ArrayDescriptor	des = ArrayDescriptor.createDescriptor(environment.getProperty("AFFLIST_BD_ADMIN"),	connection);
							arrayToPass = new ARRAY(des, connection, affliates);
						} catch (Exception e) {
							logger.error("EXCEPTION TYPE :",e);
							//e.printStackTrace();
						}
						
						((OracleCallableStatement) callableStatement).setArray(1, arrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,	environment.getProperty("AFFLIST_BD_ADMIN"));
						((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
								
						((OracleCallableStatement) callableStatement).execute();
						Integer result = callableStatement.getInt(2);
						
						if(result == 0){
							
						ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(1);
						//afflist = getAffiliateDetails(affiliates);
						if (affiliates != null && affiliates.length() != 0) {
							afflist = getAffiliateDetails(affiliates);
						}
							//clResponseDto.setStatusCode("SUCCESS");
							clResponseDto.setAffiliatesDtoList(affList);
						}
					} 
					catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------addAffiliates finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return afflist;
				}
			});
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		logger.debug("ClientAdminDaoImpl : addAffiliates ::");
		//clResponseDto.setAffiliatesDtoList(affiliatesList);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#updateAffiliates(java.util.List) To
	 * update affiliates for the given user by bluedartadmin. Method changes
	 * bills and payment flag
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto updateAffiliates(List<AffiliatesDto> affList) {
		logger.debug("ClientAdminDaoImpl : updateAffiliates ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		List<AffiliatesDto> affiliatesList = null;
		AffiliatesDto[] affliates = affList.toArray(new AffiliatesDto[affList.size()]);
		try {
			affiliatesList = (List<AffiliatesDto>) session.doReturningWork(new ReturningWork<List<AffiliatesDto>>() {
				@Override
				public List<AffiliatesDto> execute(Connection connection) throws SQLException {
					List<AffiliatesDto> afflist = null;
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();

						try {
							localMap.put(environment.getProperty("AFFOBJ"),
									Class.forName(Constants.MANAGEUSERCA_AFFILIATESDTO));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						connection.setTypeMap(localMap);

						String procedurecall = "{call UPROFILE4.AFF_MANG.modAffiliates(?)}";
						callableStatement = connection.prepareCall(procedurecall);

						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty("AFFLIST"),
								connection);
						ARRAY array_to_pass = new ARRAY(des, connection, affliates);
						((OracleCallableStatement) callableStatement).setArray(1, array_to_pass);
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
								environment.getProperty("AFFLIST"));
						((OracleCallableStatement) callableStatement).execute();
						ARRAY affiliates =((OracleCallableStatement) callableStatement).getARRAY(1);
						//afflist = getAffiliateDetails(affiliates);
						if (affiliates != null && affiliates.length() != 0) {
							afflist = getAffiliateDetails(affiliates);
						}

					}catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------updateAffiliates finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return afflist;
				}
			});
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : updateAffiliates ::" + affiliatesList);
		clResponseDto.setAffiliatesDtoList(affiliatesList);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#deleteAffiliates(java.util.List) To
	 * delete affiliates for the given user by bluedartadmin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto deleteAffiliates(List<AffiliatesDto> affList) {
		logger.debug("ClientAdminDaoImpl : deleteAffiliates ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		List<AffiliatesDto> affiliatesList = null;
		AffiliatesDto[] affliates = affList.toArray(new AffiliatesDto[affList.size()]);
		try {
			affiliatesList = (List<AffiliatesDto>) session.doReturningWork(new ReturningWork<List<AffiliatesDto>>() {
				@Override
				public List<AffiliatesDto> execute(Connection connection) throws SQLException {
					List<AffiliatesDto> afflist = null;
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();

						try {
							localMap.put(environment.getProperty("AFFOBJ"),
									Class.forName(Constants.MANAGEUSERCA_AFFILIATESDTO));
						} catch (ClassNotFoundException e) {
							logger.error("EXCEPTION TYPE :",e);
							//e.printStackTrace();
						}
						connection.setTypeMap(localMap);

						String procedurecall = "{call UPROFILE4.AFF_MANG.delAffiliates(?)}";
						callableStatement = connection.prepareCall(procedurecall);

						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty("AFFLIST"),
								connection);
						ARRAY array_to_pass = new ARRAY(des, connection, affliates);
						((OracleCallableStatement) callableStatement).setArray(1, array_to_pass);
						((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
								environment.getProperty("AFFLIST"));
						((OracleCallableStatement) callableStatement).execute();
						ARRAY affiliates = ((OracleCallableStatement) callableStatement).getARRAY(1);
						//afflist = getAffiliateDetails(affiliates);
						
						if (affiliates != null && affiliates.length() != 0) {
							afflist = getAffiliateDetails(affiliates);
						}
						
						
					} 
					catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------deleteAffiliates finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return afflist;
				}
			});
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : deleteAffiliates ::" + affiliatesList);
		clResponseDto.setAffiliatesDtoList(affiliatesList);
		return clResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.dao.ClientAdminDao#updateUserBAdmin(com.bluedart
	 * .dto.UserBasicDetailsDto) Method to modify an user under bluedartadmin
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto updateUserBAdmin(UserBasicDetailsDto userBasicDetails) {
		logger.debug("ClientAdminDaoImpl : updateUserBAdmin ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		int returnvalue = 2;

		String[] feature = userBasicDetails.getFeatures().split(",");
		try {
			for (int i = 0; i < feature.length; i++) {

				if ("Schedule a Pickup".equals(feature[i])) {
					userBasicDetails.setSpickUpPayOnlineFlag("y");
					userBasicDetails.setRateDisplayFlag("y");
				} else if ("BILL_PAYMENTS_PAYONLINE".equals(feature[i])) {
					userBasicDetails.setPartialPayFlag("y");
					userBasicDetails.setPayOnlineFlag("y");
				}
			}

			List<Integer> features = assignfeatures(feature, session);
			returnvalue = session.doReturningWork(new ReturningWork<Integer>() {

				@Override
				public Integer execute(Connection connection) throws SQLException {
					int response = 2;
					CallableStatement callableStatement = null;
					try {
						String procedureCall = "{ call UPROFILE4.ADMIN_CORPORATE.Prcnoofuser(?,?,?,?,?,?,?,?,?,?,?)}";
						callableStatement = connection.prepareCall(procedureCall);
						callableStatement.setString(1, userBasicDetails.getLoginId());
						callableStatement.setString(2, userBasicDetails.getPayOnlineFlag());
						callableStatement.setString(3, userBasicDetails.getPartialPayFlag());
						callableStatement.setString(4, userBasicDetails.getRateDisplayFlag());
						callableStatement.setString(5, userBasicDetails.getSpickUpPayOnlineFlag());
						callableStatement.setInt(6, userBasicDetails.getSecurity_level());
						callableStatement.setInt(7, userBasicDetails.getNoOfUsers());
						callableStatement.setInt(8, userBasicDetails.getSd_awbqty());
						callableStatement.setString(9, userBasicDetails.getSd_qtyusagechk());

						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty("FEATUREINLIST"),
								connection);
						ARRAY array_to_pass = new ARRAY(des, connection, features.toArray());

						callableStatement.setArray(10, array_to_pass);
						callableStatement.registerOutParameter(11, Types.INTEGER);

						callableStatement.execute();
						response = callableStatement.getInt(11);
					}
					catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------deleteAffiliates finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return response;
				}
			});
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.debug("ClientAdminDaoImpl : updateUserBAdmin ::" + returnvalue);
		clResponseDto.setUpdateBDAdminResponse(returnvalue);
		return clResponseDto;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto viewUsersForAdmin(String loginId, String letter) {
		logger.debug("ClientAdminDaoImpl : viewUsersForAdmin ::");
		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		
		misLogDao.saveMIS(Constants.FEATURE_NAME_MANAGE_USER_VIEWUSER, loginId);
		
		Login login = (Login) session.get(Login.class, loginId);

		if (login != null) {
			User user = (User) session.get(User.class, login.getUserID());
			String cregion = user.getCregion();
			List<UserBasicDetailsDto> list = null;
			try {
				list = (List<UserBasicDetailsDto>) session.doReturningWork(new ReturningWork<List<UserBasicDetailsDto>>() {
				List<UserBasicDetailsDto> userlist = new ArrayList<>();

				@Override
				public List<UserBasicDetailsDto> execute(Connection connection) throws SQLException {
					ResultSet resultSet = null;
					CallableStatement callableStatement = null;
					try {
						String procedurecall = "{call UPROFILE4.ADMIN_CORPORATE.viewuser_new (?,?,?,?)}";
						callableStatement = connection.prepareCall(procedurecall);
						callableStatement.setString(1, cregion);
						callableStatement.setString(2, letter);
						int flag = 0;
						if ("HO".equalsIgnoreCase(cregion)) {
							flag = 1;
						}
						callableStatement.setInt(3, flag);
						callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
						callableStatement.execute();

						resultSet = (ResultSet) callableStatement.getObject(4);
						while (resultSet.next()) {
							UserBasicDetailsDto userBasicDetails = new UserBasicDetailsDto();
							userBasicDetails.setLoginId(resultSet.getString("loginid"));
							userBasicDetails.setName(resultSet.getString("name"));
							userBasicDetails.setUserId(resultSet.getInt("userid"));
							userBasicDetails.setClientAdminId(resultSet.getString("client_adminid"));
							userBasicDetails.setLicense_t(resultSet.getString("license_t"));
							userBasicDetails.setLicense_s(resultSet.getString("license_s"));
							userlist.add(userBasicDetails);
						}
					} catch(DataBaseException exception)	{
						logger.error("EXCEPTION TYPE :",exception);
						//logger.debug(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("------------------------viewUsersForAdmin finally-----------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return userlist;
				}
			  });
			}  catch(DataBaseException exception)	{
				logger.error("EXCEPTION TYPE :",exception);
				//logger.error(exception);
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}
			logger.debug("ClientAdminDaoImpl : viewUsersForAdmin ::" + list);
			clResponseDto.setUserBasicDetailsDtos(list);
		} 
		return clResponseDto;
	}

	@Override
	//@Transactional
	public ClientAdminResponseDto getFeatures(String loginID) {
		logger.info("Inside DAO"+loginID);
		Map<Integer, String> featureMap = new HashMap<>();
		clResponseDto = new ClientAdminResponseDto();
		session = getSession();
		
		// session = getSession();
		try {
			Query query = session.createSQLQuery("SELECT FEATUREID FROM UPROFILE4.ACCESSRIGHTS_T WHERE LOGINID =:loginId");
			query.setParameter("loginId", loginID);
			List<BigDecimal> list = query.list();
			//List<BigDecimal> list = (List<BigDecimal>) getHibernateTemplate().find(query, loginID);
			List<Integer> idList = new ArrayList<>();
			if (list != null) {
				for (BigDecimal accessRights : list) {
					idList.add(accessRights.intValue());
				}
				if(!CollectionUtils.isEmpty(idList)){
				Criteria criteria = session.createCriteria(Feature.class).add(Restrictions.in("featureId", idList));
				List<Feature> featureList = criteria.list();
				for (Feature feature : featureList) {
						featureMap.put(feature.getFeatureId(), feature.getDescription());
					}
				}
				}
			
		} catch(DataBaseException exception)	{
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		clResponseDto.setFeaturesMap(featureMap);
		return clResponseDto;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto createNewUserBDAdmin(UserBasicDetailsDto userBasicDetails) {
		logger.debug("ClientAdminDaoImpl : createNewUserBDAdmin");
		session = getSession();
		Integer returnValue = -1;
		String response = "";
		corporateCustomerDto = new CorporateCustomerDto();

		corporateCustomerDto.setAddr1(userBasicDetails.getAddr1());
		corporateCustomerDto.setAddr2(userBasicDetails.getAddr1());
		corporateCustomerDto.setCcontactPerson(userBasicDetails.getCntPerson());
		corporateCustomerDto.setCcustomerCode(userBasicDetails.getCcustcode());
		corporateCustomerDto.setCity(userBasicDetails.getCity());
		corporateCustomerDto.setCustomerArea(userBasicDetails.getCarea());
		corporateCustomerDto.setDbDownload(0);
		corporateCustomerDto.setEmailId(userBasicDetails.getEmailId());
		corporateCustomerDto.setFax(userBasicDetails.getFax());
		corporateCustomerDto.setFirstName(userBasicDetails.getName());
		corporateCustomerDto.setMode_of_shipment(userBasicDetails.getMode_of_shipment());
		corporateCustomerDto.setNo_of_affiliates(userBasicDetails.getNo_of_affiliates());
		corporateCustomerDto.setNo_of_shipments(userBasicDetails.getNo_of_shipments());
		corporateCustomerDto.setPhone(userBasicDetails.getPhoneNo());
		corporateCustomerDto.setPinCode(userBasicDetails.getPinCode());
		corporateCustomerDto.setStatus(userBasicDetails.getStatus());
		corporateCustomerDto.setUserType(userBasicDetails.getUser_type());

		Long userId;
		
		userId = registerDBHandler.registerCorporateCustomer(session, corporateCustomerDto);
	
		RegisterDetailDto loginDetail = new RegisterDetailDto();
		String loginId = generateLoginId(userBasicDetails.getCity());
		loginDetail.setLoginId(loginId);
		loginDetail.setUserId(userId);
		String originalPassword = passwordUtil.generateStrongPassword();
		String encryptedPassword;

		encryptedPassword = passwordUtil.encryptPassword(originalPassword);
		loginDetail.setPassword(encryptedPassword);
		loginDetail.setOrgPassword(originalPassword);
		
		loginDetail.setDbId(0);
		loginDetail.setMachineId(null);
		loginDetail.setBadSignonCount(0);
		loginDetail.setClientAdminId(loginId);
		loginDetail.setNoOfUsers(userBasicDetails.getNoOfUsers());

		String[] feature = userBasicDetails.getFeatures().split(",");
		for (int i = 0; i < feature.length; i++) {

			if ("Schedule a Pickup".equals(feature[i])) {
				loginDetail.setPonlineFlag("y");
				loginDetail.setPartPayFlag("y");
			} else if ("BILL_PAYMENTS_PAYONLINE".equals(feature[i])) {
				loginDetail.setRateDisplayFlag("y");
				loginDetail.setSpickupPayonline("y");
			}
		}
		loginDetail.setSdAwbqty(0);
		loginDetail.setSdQtyUsageChk(null);
		List<Integer> features = assignfeatures(feature, session);
		ArrayList<Integer> featureid = new ArrayList<>();
		for (Integer id : features) {
			featureid.add(id);
		}
		loginDetail.setFeatureIdList(featureid);
		
		returnValue = registerDBHandler.insertToLogin(session, loginDetail);
		
		if (returnValue == 0) {
			AffiliatesMaster affiliatesMaster = new AffiliatesMaster();
			//affiliatesMaster.setAffiliateCustomerCode(userBasicDetails.getCcustcode());
			//affiliatesMaster.setAreaCode(userBasicDetails.getCarea());
			affiliatesMaster.setLoginId(loginId);
			//affiliatesMaster.setBpFlag("0");
			createNewAffiliate(affiliatesMaster, session, loginId);

			response = originalPassword;
		} else {
			response += returnValue;
		}
		logger.debug("ClientAdminDaoImpl : createNewUserBDAdmin ::" + returnValue);
		clResponseDto.setCreateBDAdminresponse(response);
		return clResponseDto;
	}

	private String generateLoginId(String city) {
		String loginId = city.toUpperCase().trim().substring(0, 3);
		long randomNumber = (long) ((Math.random() * 9000) + 1000);
		String finalLoginId = loginId + randomNumber;
		return finalLoginId;
	}
	
/*	private boolean saveMIS(String featureName, String loginId) {
		boolean flag = false;
		try{
			flag = misLogDao.saveMIS(featureName, loginId);
		}catch(Exception exception){
			logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}*/

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ClientAdminResponseDto createnewuserPermission(
			UserBasicDetailsDto userBasicDetails) {

		session = getSession();
		clResponseDto = new ClientAdminResponseDto();
		
		//String adminLoginId = userBasicDetails.getClientAdminId();
		//Login login = (Login) session.get(Login.class, adminLoginId);
			
				//String password = passwordUtil.generateStrongPassword();
				//String encPassword = passwordUtil.encryptPassword(password);
				String[] feature = userBasicDetails.getFeatures().split(",");
				
					
					//List<Integer> features = assignfeatures(feature, session);
					PermissionMappingDto perMappingDto = new PermissionMappingDto();
					List<PermissionDto> permissionList = permiList(feature,session);
			
	// ........ calling BDManageCorporateUsersDaoImpl for save login permissions................................................//
	
							perMappingDto.setLoginId(userBasicDetails.getLoginId());
							perMappingDto.setModifiedBy("111111");
							perMappingDto.setPermissionDtosList(permissionList);
							ValidCustomerDto validCustomerDto = new ValidCustomerDto();
							try{
								validCustomerDto = 	bdManageCDaoImpl.saveLoginPermissions(perMappingDto);
							}
							catch (Exception exception) {
								logger.error("EXCEPTION TYPE :",exception);
								//logger.error(exception);
								throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
							}
							
							String result =	validCustomerDto.getValidFlag();
						
						logger.error("permission: : "+result);
						clResponseDto.setCreateNewUserPermissionResponse(result);
					    return clResponseDto;
					}
				
	
}