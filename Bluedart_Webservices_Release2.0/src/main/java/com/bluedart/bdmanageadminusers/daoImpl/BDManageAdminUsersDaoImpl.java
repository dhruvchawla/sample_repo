package com.bluedart.bdmanageadminusers.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
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
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao;
import com.bluedart.bdmanageadminusers.dto.AdminDetailDto;
import com.bluedart.bdmanageadminusers.dto.AdminUserResponseDto;
import com.bluedart.bdmanageadminusers.dto.BDAdminDto;
import com.bluedart.bdmanageadminusers.dto.NotificationDto;
import com.bluedart.bdmanageadminusers.dto.UserSearchDto;
import com.bluedart.bdmanageadminusers.dto.ValidUserDto;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AdminAuditDetails;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.BDAdminConstants;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;


/**
 * 
 * @author PR334023
 * DAO implementation for Bluedart admin - Manage Admin users
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class BDManageAdminUsersDaoImpl extends BaseDaoImpl implements BDManageAdminUsersDao {

	private static final Logger bdAdminLogger = Logger.getLogger(BDManageAdminUsersDaoImpl.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BDAdminNotificationHelper notificationHelper;
	
//	private AdminUserResponseDto adminUserResponseDto = null;
//	private ValidUserDto validUserDto = null;
//	private NotificationDto notificationDto = null;
//	private List adminsList = null;
//	private List<AdminDetailDto> bdAdminDtoList = null;
	private String salesAdminRegion = null;
	
	/*
	 * Method to list admin users under any BlueDart admin along with pagination
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#listAdminUsers(com.bluedart.bdmanageadminusers.dto.UserSearchDto)
	 */
	@Override
	@Transactional
	public AdminUserResponseDto listAdminUsers(UserSearchDto bdAdminSearchDto) {
		
		bdAdminLogger.debug("BDManageAdminUsersDaoImpl :: listAdminUsers");
		//List<AdminDetailDto> bdAdminDtoList = new ArrayList<>();
		AdminUserResponseDto adminUserResponseDto = new AdminUserResponseDto();
		
		String[] regionArray = bdAdminSearchDto.getAdminRegions();
		
		try {
			adminUserResponseDto = getSession().doReturningWork(new ReturningWork<AdminUserResponseDto>() {
				@Override
				public AdminUserResponseDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					AdminUserResponseDto adminUserResponseDto = new AdminUserResponseDto();
					try {
						Map<String, Class<?>> adminListMap = connection.getTypeMap();
						
						try {
							adminListMap.put(environment.getProperty(BDAdminConstants.ADMINOBJ), Class.forName(BDAdminConstants.ADMIN_DTO));
						} catch (ClassNotFoundException exception) {
							
							bdAdminLogger.error("EXCEPTION TYPE :",exception);
							
							//bdAdminLogger.error("Failed to load 'procedure.properties' :: "+exception);
							throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}
						connection.setTypeMap(adminListMap);

						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
						ARRAY adminRegions = null;
							int totalCount = 0;
							adminRegions = new ARRAY(des, connection, regionArray);
							
							callableStatement = connection.prepareCall(BDAdminConstants.GET_ADMINS_LIST_PROC);
							
							callableStatement.setString(1, bdAdminSearchDto.getAdminEmployeeCode());
							callableStatement.setString(2, bdAdminSearchDto.getUserType());
							callableStatement.setArray(3, adminRegions);
							callableStatement.setInt(4, bdAdminSearchDto.getStatus());  // status
							callableStatement.setInt(5, bdAdminSearchDto.getPageSize());  //page size
							callableStatement.setInt(6, bdAdminSearchDto.getPageNumber());  // page number
							callableStatement.setString(7, bdAdminSearchDto.getSortBy());  // sortBy
							callableStatement.setString(8, bdAdminSearchDto.getOrder());
							
							((OracleCallableStatement) callableStatement).registerOutParameter(9, java.sql.Types.ARRAY,environment.getProperty(BDAdminConstants.ADMINOBJLIST));
							((OracleCallableStatement) callableStatement).registerOutParameter(10, Types.INTEGER);
							
							((OracleCallableStatement) callableStatement).execute();
							ARRAY adminsArray = ((OracleCallableStatement) callableStatement).getARRAY(9);
							totalCount = callableStatement.getInt(10);
						
							List adminsList = Arrays.asList((Object[])adminsArray.getArray());  
							List<AdminDetailDto> bdAdminDtoList = new ArrayList<AdminDetailDto>(adminsList);
							
							adminUserResponseDto.setAdminsList(bdAdminDtoList);
							adminUserResponseDto.setTotalCount(totalCount);
					} catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					}
					finally {
						bdAdminLogger.debug("--------------------------listAdminUsers finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return adminUserResponseDto;
				}
			});
		} catch(Exception exception) {
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			//bdAdminLogger.error("Exception in listAdminUsers :: "+exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		return adminUserResponseDto;
	}
	
	/*
	 * Method to validate employee code from EMPMST table and BD_USERS table
	 * @return AdminDto
	 */
	@Override
	@Transactional
	public ValidUserDto validateEmployeeCode(String employeeCode, String adminRegions, String userType, String superAdminFlag) {
	
		ValidUserDto validUserDto = new ValidUserDto();
		Integer validateEmpCodeResponse = -2;
		try {
			validateEmpCodeResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -2;
					CallableStatement callableStatement = null;
					
					String[] reg = adminRegions.split(",");
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY adminRegion = null;
					
					try {
						adminRegion = new ARRAY(des, connection, reg);
						callableStatement = connection.prepareCall(BDAdminConstants.VALIDATE_EMPCODE_PROC);
						callableStatement.setString(1, employeeCode);
						callableStatement.setArray(2, adminRegion);
						callableStatement.setString(3, superAdminFlag);
						callableStatement.setString(4, userType);
						((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.INTEGER);
						((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.VARCHAR);
						((OracleCallableStatement) callableStatement).registerOutParameter(7, Types.VARCHAR);
						((OracleCallableStatement) callableStatement).execute();
						
						procedureResponse = callableStatement.getInt(5);
						String empName = callableStatement.getString(6);
						String emialID = callableStatement.getString(7);
						
						validUserDto.setEmployeeName(empName);
						validUserDto.setEmailId(emialID);
					} catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					}
					finally {
						bdAdminLogger.debug("--------------------------validateEmployeeCode finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
			if(validateEmpCodeResponse == 1) {
				validUserDto.setUserflag("VALID");
			}else if (validateEmpCodeResponse == 2) {
				validUserDto.setUserflag("USER_EXIST");
			}else { //if (validateEmpCodeResponse == -1 || validateEmpCodeResponse == -3) {
				validUserDto.setUserflag("INVALID");
			}
		} catch (Exception exception) {
			
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			//bdAdminLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		return validUserDto;
	}
	
	/*
	 * Method to create admin user by BlueDart admin
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#createAdminUser(com.bluedart.bdmanageadminusers.dto.BDAdminDto)
	 */
@Override
	@Transactional
	public ValidUserDto createAdminUser(BDAdminDto bdAdminDto) {
		bdAdminLogger.debug("BDAdminManageUsersDaoImpl :: createAdminUser");
		ValidUserDto validUserDto=new ValidUserDto();
		
		String[] regionArray = bdAdminDto.getUserRegions();
		Integer procedureResponse = -2;
		
		try { 
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer createResponse = -2;
					
					CallableStatement callableStatement = null;
					
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY regionsToCreate = null;
					
					try {
						regionsToCreate = new ARRAY(des, connection, regionArray);
						callableStatement = connection.prepareCall(BDAdminConstants.CREATE_ADMIN_PROC);
						callableStatement.setString(1, bdAdminDto.getToLoginId());
						callableStatement.setString(2, bdAdminDto.getEmployeeCode());
						callableStatement.setString(3, bdAdminDto.getByLoginId()); 
						callableStatement.setString(4, bdAdminDto.getUserType());
						callableStatement.setArray(5, regionsToCreate);
						
						((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.INTEGER);
						((OracleCallableStatement) callableStatement).registerOutParameter(7, Types.VARCHAR);
						((OracleCallableStatement) callableStatement).executeUpdate();
						createResponse = callableStatement.getInt(6);
						salesAdminRegion = callableStatement.getString(7);
					} catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					}
					finally {
						bdAdminLogger.debug("--------------------------createAdminUser finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					bdAdminLogger.info("-------------------createResponse value inside execute----"+createResponse);
					return createResponse;
				}
			});
		} catch (Exception exception) {
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			bdAdminLogger.info("-------------------Exception Block------------------------------");
			//bdAdminLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		bdAdminLogger.info("-------------------procedureResponse value outside----"+procedureResponse);
		if(procedureResponse==0){
			validUserDto.setUserflag("USER_CREATED");
		}		
		
		if(null!=validUserDto && "USER_CREATED".equalsIgnoreCase(validUserDto.getUserflag())){
			NotificationDto notificationDto = new NotificationDto();
			if(null!=salesAdminRegion || "".equalsIgnoreCase(salesAdminRegion)){
				String[] salesAdminReg = {salesAdminRegion};
				bdAdminDto.setUserRegions(salesAdminReg);
			}
			
			notificationDto.setBdAdminDto(bdAdminDto);
			notificationDto.setAction("CREATE");
			boolean ismailSent = sendEmailNotification(notificationDto);
			validUserDto.setEmailSent(ismailSent); 
			bdAdminLogger.info("------------------User created-ismailSent----"+ismailSent);
		}
		bdAdminLogger.info("------------------Returning from Procedure call at the end---------------");
		return validUserDto;
	}

	/*
	 * Method to update admin user details by BlueDart admin
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#editAdminUser(com.bluedart.bdmanageadminusers.dto.BDAdminDto)
	 */
	@Override
	@Transactional
	public ValidUserDto editAdminUser(BDAdminDto bdAdminDto) {
		bdAdminLogger.debug("BDAdminManageUsersDaoImpl :: editAdminUser");
		ValidUserDto validUserDto=new ValidUserDto();
		
		Integer procedureResponse = -2;
		String[] tArray = bdAdminDto.getRolesToEdit();
		String[] regArray = bdAdminDto.getUserRegions();
		
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer procedureResponse = -1;
					CallableStatement callableStatement = null;
					
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY typeArray = null;
					
					ArrayDescriptor des2 = ArrayDescriptor.createDescriptor(environment.getProperty(BDAdminConstants.GENERIC_VARCHAR_TYPE), connection);
					ARRAY regionArray = null;
					
					try {
						typeArray = new ARRAY(des, connection, tArray);
						regionArray = new ARRAY(des2, connection, regArray);
						
						callableStatement = connection.prepareCall(BDAdminConstants.UPDATE_ADMIN_PROC);
						callableStatement.setString(1, bdAdminDto.getEmployeeCode());
						callableStatement.setArray(2, typeArray);
						callableStatement.setArray(3, regionArray);
						callableStatement.setString(4, bdAdminDto.getToLoginId());
						callableStatement.setString(5, bdAdminDto.getByLoginId());
						((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.INTEGER);
						((OracleCallableStatement) callableStatement).registerOutParameter(7, Types.VARCHAR);
						((OracleCallableStatement) callableStatement).registerOutParameter(8, Types.VARCHAR);
						callableStatement.setString(9, BDAdminConstants.BD_MODULE_NAME);
						callableStatement.setString(10, "UPDATE");
						((OracleCallableStatement) callableStatement).registerOutParameter(11, Types.VARCHAR);
						((OracleCallableStatement) callableStatement).executeUpdate();
						
						String empName = callableStatement.getString(7);
						String emialID = callableStatement.getString(8);
						String salesAdminRegion = callableStatement.getString(11);
						
						bdAdminDto.setEmployeeName(empName);
						bdAdminDto.setEmailId(emialID);
						
						if(!bdAdminDto.getUserType().equalsIgnoreCase(BDAdminConstants.ADMIN)){
							String[] reg = {salesAdminRegion};
							bdAdminDto.setUserRegions(reg);
						}else{
							bdAdminDto.setUserRegions(regArray); 
						}
						
						procedureResponse = callableStatement.getInt(6);
					}catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					}
					finally {
						bdAdminLogger.debug("--------------------------editAdminUser finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					
					if(procedureResponse==0){
						NotificationDto notificationDto = new NotificationDto();
						notificationDto.setBdAdminDto(bdAdminDto); 
						notificationDto.setAction("UPDATE");
						
						boolean ismailSent = sendEmailNotification(notificationDto);
						validUserDto.setEmailSent(ismailSent); 
					}
					return procedureResponse;
				}
			});
		} catch (Exception exception) {
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			
			//bdAdminLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		
		if(0==procedureResponse){
			validUserDto.setUserflag("USER_UPDATED");
		}else if(-2==procedureResponse){
			validUserDto.setUserflag("NO_SUCH_USER");
		}else if(-1==procedureResponse){
			validUserDto.setUserflag("FAILURE");
		}
		return validUserDto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#sendEmailNotification(com.bluedart.bdmanageadminusers.dto.NotificationDto)
	 */
	@Override
	public boolean sendEmailNotification(NotificationDto notificationDto) {
		bdAdminLogger.debug("BDAdminManageUsersDaoImpl :: sendEmailNotification");
		return notificationHelper.sendEmailNotification(notificationDto);
	}

	/*
	 * Method to save Audit Log details
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#saveAuditLog(com.bluedart.common.dto.AdminAuditLogDto)
	 */
	@Override
	@Transactional
	public boolean saveAuditLog(List<AdminAuditDetails> adminAuditLogList) {
		bdAdminLogger.debug("BDAdminManageUsersDaoImpl :: saveAuditLog");
		Integer procedureResponse = -2;
		//List<Integer> auditSequenceList = new ArrayList<>(); 
		List<AdminAuditDetails> finalAuditList = new ArrayList<>();
		try {
		
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					
					for (AdminAuditDetails adutiListObj : adminAuditLogList) {
						String sql = BDAdminConstants.AUDIT_SEQ_QUERY;
						PreparedStatement pst = connection.prepareStatement(sql);
						ResultSet rs = null;
						try {
							rs = pst.executeQuery(); 
							if(rs.next()){
								 Integer seq = rs.getInt(1);
								 adutiListObj.setSequence(seq);
								finalAuditList.add(adutiListObj);
							}
						
						} catch (HibernateException exception) {
							bdAdminLogger.error("EXCEPTION TYPE :",exception);
							
							
							//bdAdminLogger.error(exception);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally{
							
							bdAdminLogger.debug("--------------------------saveAuditLog inner finally--------------------------");
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
							bdAdminLogger.error("EXCEPTION TYPE :",e);
							
							
							//bdAdminLogger.error(e); 
						}
						connection.setTypeMap(localMap);
						
						ARRAY auditLogArray = null;
						try {
							auditLogArray = new ARRAY(des, connection, logValues);
						} catch (Exception e) { 
							bdAdminLogger.error("EXCEPTION TYPE :",e);
							
							
							//bdAdminLogger.error(e); 
						}
						
						callableStatement = connection.prepareCall(BDAdminConstants.SAVE_AUDIT_PROC);
						callableStatement.setArray(1, auditLogArray);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
						((OracleCallableStatement) callableStatement).executeUpdate();
						
						procedureResponse = callableStatement.getInt(2);
					} catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					
					}
					finally {
						bdAdminLogger.debug("--------------------------saveAuditLog finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return procedureResponse;
				}
			});
		} catch (Exception exception) {
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		if(procedureResponse==0){
			return true;
		}
		return false;
		
	}

	/*
	 * Method to create BlueDart Super Admin
	 * (non-Javadoc)
	 * @see com.bluedart.bdmanageadminusers.dao.BDManageAdminUsersDao#createSuperAdmin(com.bluedart.bdmanageadminusers.dto.BDAdminDto)
	 */
	@Override
	@Transactional
	public ValidUserDto createSuperAdmin(BDAdminDto bdAdminDto) {
		bdAdminLogger.debug("BDAdminManageUsersDaoImpl :: createSuperAdmin");
		ValidUserDto validUserDto=new ValidUserDto();
		
		Integer procedureResponse = -2;
		try { 
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					Integer createResponse = -2;
					
					CallableStatement callableStatement = null;
					
					try {
						callableStatement = connection.prepareCall(BDAdminConstants.CREATE_SUPERADMIN_PROC);
						callableStatement.setString(1, bdAdminDto.getToLoginId());
						callableStatement.setString(2, bdAdminDto.getEmployeeCode());
						callableStatement.setString(3, bdAdminDto.getUserType());
						callableStatement.setString(4, bdAdminDto.getByLoginId());
						
						((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.INTEGER);
						((OracleCallableStatement) callableStatement).executeUpdate();
						createResponse = callableStatement.getInt(5);
					} catch(Exception exception){
						bdAdminLogger.error("EXCEPTION TYPE :",exception);
						
					}
					finally {
						bdAdminLogger.debug("--------------------------createSuperAdmin finally--------------------------");
						CloseConnections.closeCallableStatement(callableStatement);

					}
					return createResponse;
				}
			});
		} catch (Exception exception) {
			
			bdAdminLogger.error("EXCEPTION TYPE :",exception);
			
			//bdAdminLogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		
		if(procedureResponse==0){
			validUserDto.setUserflag("SUCCESS");
			
	        try {
	        	EmailContent mailContent = new EmailContent();
				mailContent.setFrom(environment.getProperty("fromEmailId"));
				mailContent.setTo(bdAdminDto.getEmailId());
				mailContent.setSubject("Super Admin created");
	        	EmailUtil.sendEmailWithImage(mailContent,"superadmin.vm");
			}catch (Exception e) {
				bdAdminLogger.error("EXCEPTION TYPE :",e);
				
				bdAdminLogger.error("Error in sending mail while super admin creation");
			}
	        
		}else{
			validUserDto.setUserflag("FAILURE");
		}
		return validUserDto;
	
	}
	
}