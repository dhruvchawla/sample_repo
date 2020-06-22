 package com.bluedart.logindetail.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.LoginMaster;
import com.bluedart.common.entity.UserInfo;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.logindetail.dao.LoginDetailDao;
import com.bluedart.logindetail.dto.LoginDetailDto;
import com.bluedart.logindetail.dto.StatusDto;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

@Repository
public class LoginDaoImpl extends BaseDaoImpl implements LoginDetailDao {

	private static final Logger loginLogger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	private Environment environment;
	
	@Transactional
	@Override
	public LoginDetailDto getLoginDetails(String loginId) {

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select Bu.Loginid LOGINID,Bur.Cregion REGION ")
		.append("from ")
		.append("UPROFILE4.Bd_Users bu, ")
		.append("UPROFILE4.Bd_Users_Region bur ")
		.append("where upper(bu.Loginid)=nvl(upper(:vloginid),upper(bu.loginid))")
		.append("and Bu.Bd_User_Id=Bur.Bd_User_Id order by Bu.Loginid, Bur.Cregion");
		
		LoginDetailDto loginDetail;    
		try {
			loginDetail = getSession().doReturningWork(new ReturningWork<LoginDetailDto>() {
				@Override
				public LoginDetailDto execute(Connection connection) throws SQLException {
					LoginDetailDto loginDetailsDTO = new LoginDetailDto();
					ResultSet rs = null;
					PreparedStatement pStmt = connection.prepareStatement(sqlQuery.toString());
					pStmt.setString(1, loginId);
					try {
						List<String> regionList = new ArrayList<>();
						rs = pStmt.executeQuery();
							  while(rs.next()) {
                                  regionList.add(rs.getString(2));
                                  loginDetailsDTO.setRegionList(regionList);
                                  loginDetailsDTO.setLoginId(loginId);
                            }
						return loginDetailsDTO;
					} catch (DataBaseException e){
						
						loginLogger.error("EXCEPTION TYPE :",e);
						
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					} finally {
						loginLogger.debug("-------------getLoginDetails finally --------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closePreparedStatement(pStmt);	
					}
				}
			});
		} catch (DataBaseException e){
			loginLogger.error("EXCEPTION TYPE :",e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return loginDetail;
	}

	/*
	 * Method to get Login permission details
	 * (non-Javadoc)
	 * @see com.bluedart.logindetail.dao.LoginDetailDao#getLoginPermissionDetails(java.lang.String)
	 */
	@Transactional
	@Override
	public LoginDetailDto getLoginPermissionDetails(String loginId) {
		LoginDetailDto loginDto = new LoginDetailDto();
		try{
			loginDto = getSession().doReturningWork(new ReturningWork<LoginDetailDto>() {
			@Override
			public LoginDetailDto execute(Connection connection) throws SQLException {
				CallableStatement callableStatement = null;
				ResultSet rset = null;
				LoginDetailDto permission = new LoginDetailDto();
				try{
				
				Map<String, String> permissionMap = new HashMap<>();
				
				callableStatement = connection.prepareCall("{call UPROFILE4.PACK_MANAGEUSERS.GET_LOGIN_PERMISSION(?,?)}");
				callableStatement.clearParameters();
				
				callableStatement.setString(1, loginId); 
				((OracleCallableStatement) callableStatement).registerOutParameter(2, OracleTypes.CURSOR);
				((OracleCallableStatement) callableStatement).executeUpdate();
				 rset = (ResultSet)callableStatement.getObject (2);
				 while (rset.next ()){
					 /*permissionMap.put(rset.getString ("Permission_Name"),rset.getString ("Permission_Value"));
					 permission.setPermissionMap(permissionMap);
					 permission.setLoginId(loginId);*/
					 
					 // To fetch sub permissions
					 if(rset.getString ("Permission_Name")!=null){
						 permissionMap.put(rset.getString ("Permission_Name"),rset.getString ("Permission_Value"));
					 }else{
						 permissionMap.put(rset.getString ("Sub_Permission_Name"),rset.getString ("Permission_Value"));
					 }
					 permission.setPermissionMap(permissionMap);
					 permission.setLoginId(loginId);
				 }
				
				}catch(Exception e){
					loginLogger.error("EXCEPTION TYPE :",e);
					loginLogger.info("-------------getLoginPermissionDetails finally --------------------");
				}finally{
					loginLogger.debug("-------------getLoginPermissionDetails finally --------------------");
					CloseConnections.closeResultSet(rset);
					CloseConnections.closeCallableStatement(callableStatement);	
				}
				return permission;
			}
		});
		}catch (DataBaseException e){
			loginLogger.error("EXCEPTION TYPE :",e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return loginDto;
	}

	/**
	 * Method to get permissions for given login id to build user dash-board
	 * @param loginId
	 * @param permissionsList
	 * @return
	 */
	@Override
	@Transactional
	public LoginDetailDto getAllPermissions(String loginId, List<String> permissionsList) {
		loginLogger.debug("LoginDaoImpl :: getDashboardPermissions");
		LoginDetailDto loginDto = new LoginDetailDto();
		try{
			loginDto = getSession().doReturningWork(new ReturningWork<LoginDetailDto>() {
			@Override
			public LoginDetailDto execute(Connection connection) throws SQLException {
				Map<String, String> permissionMap = new HashMap<>();
				LoginDetailDto loginDto = new LoginDetailDto();
				
				CallableStatement callableStatement = null; 
				ResultSet rset = null;
				try {
					String[] permissions = permissionsList.toArray(new String[permissionsList.size()]);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY permissionsArray = new ARRAY(des, connection, permissions);
					
					callableStatement = connection.prepareCall("{call UPROFILE4.PKGClient_corporate.PrcGetPermission_v1(?,?,?,?,?)}");
					callableStatement.clearParameters();
					
					callableStatement.setString(1, loginId.toUpperCase()); 
					((OracleCallableStatement) callableStatement).setArray(2, permissionsArray);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).registerOutParameter(4, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).registerOutParameter(5, OracleTypes.CURSOR);
					((OracleCallableStatement) callableStatement).executeUpdate();
					loginDto.setAreaCode(callableStatement.getString(3));
					loginDto.setCustCode(callableStatement.getString(4));
					 rset = (ResultSet)callableStatement.getObject (5);
					 while (rset.next ()){
						 permissionMap.put(rset.getString("permission_name"),rset.getString("permission_value"));
					 }
					 for (String permissionName : permissionsList) {
						if(!(permissionMap.containsKey(permissionName))){
							permissionMap.put(permissionName, "N");
						}
					 }
					 loginDto.setPermissionMap(permissionMap);
					 loginDto.setLoginId(loginId);
				} catch (Exception exception) {
					loginLogger.error("EXCEPTION TYPE :",exception);
					//loginLogger.error(exception);
				}finally{
					loginLogger.debug("-------------getAllPermissions finally --------------------");
					CloseConnections.closeResultSet(rset);
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return loginDto;
			}
		});
		}catch (DataBaseException exception){
			loginLogger.error("EXCEPTION TYPE :",exception);
			//loginLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return loginDto;
}

	/*
	 * Method to save session details of user
	 * (non-Javadoc)
	 * @see com.bluedart.logindetail.dao.LoginDetailDao#saveUserSessionDetails(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean saveUserSessionDetails(String sessionId, String areaCode, String custCode, String loginId) {
		loginLogger.debug("LoginDaoImpl :: saveUserSessionDetails");
		Boolean output = false;
		try {
			output = getSession().doReturningWork(new ReturningWork<Boolean>() {
				@Override
				public Boolean execute(Connection connection) throws SQLException {
					Boolean out = false;
					CallableStatement callableStatement = null;
					try {
						callableStatement = connection.prepareCall("{call UPROFILE4.StoreSSOSession(?,?,?,?)}");
						((OracleCallableStatement) callableStatement).setString(1, sessionId);
						((OracleCallableStatement) callableStatement).setString(2, areaCode);
						((OracleCallableStatement) callableStatement).setString(3, custCode);
						((OracleCallableStatement) callableStatement).setString(4, loginId);
						callableStatement.execute();
						out=true;
						
					} catch(DataBaseException exception) {
						loginLogger.error("EXCEPTION TYPE :",exception);
						//loginLogger.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						loginLogger.debug("-------------saveUserSessionDetails finally --------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return out;
				}
			});
		}catch(Exception e){
			loginLogger.error("EXCEPTION TYPE :",e);
			//loginLogger.error(e);
		}
		return output;
	}
	
	/**
     * Method to validate user details for given loginId, password and flag
	 * @param loginId
	 * @param password
	 * @param flag
	 * @return
	 */
	@Override
	@Transactional
	public StatusDto isValidUser(String loginId, String password, String flag) {				
		loginLogger.debug(" LoginDaoImpl : isValidUser ");		
		StatusDto statusDto = new StatusDto();
			
		try {
			Criteria criteria = getSession().createCriteria(LoginMaster.class);
			criteria.add(Restrictions.eq("loginID", loginId).ignoreCase());
			criteria.add(Restrictions.eq("password", password));
			LoginMaster loginRow = (LoginMaster) criteria.uniqueResult();
				
			if (loginRow != null) {
				statusDto.setIsAuthorized(true);
			} 					
			statusDto = fetchUserDetailsbyUserId(getSession(),loginRow.getUserID(), statusDto);			
		
		} catch(BlueDartException exception)	{
			loginLogger.error("EXCEPTION TYPE :",exception);
			//loginLogger.error("LoginDaoImpl : isValidUser "+exception);
			statusDto.setIsServerDown(true);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		
	    return statusDto;		
	}
	
	
	/*
	 * To fetch login detail from USER_T by userId 
	 */
	@Transactional
	private StatusDto fetchUserDetailsbyUserId(Session session, Long userId, StatusDto statusDto) {
		loginLogger.info(" LoginDaoImpl : fetchUserDetailsByUserId " +userId );
		
		try{
		if(userId != null){
			Criteria criteria = session.createCriteria(UserInfo.class);
			criteria.add(Restrictions.eq("userId", userId));
			UserInfo user  = (UserInfo) criteria.uniqueResult();
				
			if (user != null) {
				loginLogger.info(" LoginDaoImpl : fetchUserDetailsByUserId User details found in DB" );
				statusDto.setUserName(user.getName());
				statusDto.setMailId(user.getEmailId());
				statusDto.setUserType(user.getUserType());				
			}
		}
		} catch (Exception exception) {
			loginLogger.error("EXCEPTION TYPE :",exception);
			//loginLogger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return statusDto;
	}

	@Transactional
	public StatusDto fetchLoginDetails(String loginId , String flag) {
		loginLogger.info(" LoginDaoImpl : isValidUser ");		
		StatusDto statusDto = new StatusDto();
			
		try {
			Criteria criteria = getSession().createCriteria(LoginMaster.class);
			criteria.add(Restrictions.eq("loginID", loginId).ignoreCase());
			LoginMaster loginRow = (LoginMaster) criteria.uniqueResult();
				
			if (loginRow != null) {
				statusDto.setIsAuthorized(true);
				loginLogger.info(" LoginDaoImpl : loginRow in non empty ");		
			} 					
			statusDto = fetchUserDetailsbyUserId(getSession(),loginRow.getUserID(), statusDto);			
		
		} catch(BlueDartException exception)	{
			loginLogger.error("LoginDaoImpl : isValidUser "+exception);
			statusDto.setIsServerDown(true);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		
	    return statusDto;	
	}	

}

	