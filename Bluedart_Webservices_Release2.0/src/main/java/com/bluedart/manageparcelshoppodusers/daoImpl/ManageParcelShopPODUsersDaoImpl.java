package com.bluedart.manageparcelshoppodusers.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao;
import com.bluedart.manageparcelshoppodusers.dto.AreaRegionDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUserAuditDetails;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersAuditDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersDbObjectDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersDto;
import com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto;
import com.bluedart.manageparcelshoppodusers.dto.ParcelShopsDto;
import com.bluedart.manageparcelshoppodusers.dto.ServiceCentersDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * 
 * @author DI334021
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class ManageParcelShopPODUsersDaoImpl extends BaseDaoImpl implements ManageParcelShopPODUsersDao {

	private static Logger log = Logger.getLogger(ManageParcelShopPODUsersDaoImpl.class.getName());

	@Autowired
	Environment environment;
	
	@Autowired
	ManageParcelShopPODUsersHelper manageParcelShopPODUsersHelper;
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	
//---------------------------------------------------------------GET PARCEL SHOPS------------------------------------------------------------------------------------------------------
	
	/* 
	 * Method to get parcel shops.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#getParcelShopsList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto getParcelShopsList(String region, String area,String searchParcelShopName) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : getParcelShopsList");
		
		String[] allRegionArray = region.split(Constants.AT);
		
        ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		List<ParcelShopsDto> parcelShopsList = new ArrayList<ParcelShopsDto>();
		String fetchParcelShops = Constants.FETCH_PARCELSHOPS_PROCEDURE;
		try{
		getSession().doWork(new Work() {
			CallableStatement callableStatement = null;
			ResultSet rs = null;
            
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					ParcelShopsDto parcelShopsSO = null;
					
					callableStatement = connection.prepareCall(fetchParcelShops);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.GENERIC_VARCHAR_TYPE,connection);
					ARRAY arrayToPass = new ARRAY(des, connection, allRegionArray);
					
					((OracleCallableStatement) callableStatement).setARRAY(1, arrayToPass);
					
					if(area.equalsIgnoreCase(Constants.NULL) || area == null)
					{
						callableStatement.setString(2, null);
					}
					else
					{
						callableStatement.setString(2, area);
					}
					if(searchParcelShopName.equalsIgnoreCase(Constants.NULL) || searchParcelShopName == null)
					{
						callableStatement.setString(3, null);
					}
					else
					{
						callableStatement.setString(3, searchParcelShopName);
					}
					callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
					callableStatement.execute();
					rs = (ResultSet) callableStatement.getObject(4);
					
					while(rs.next()){
						parcelShopsSO = new ParcelShopsDto();
						parcelShopsSO.setPsCode(rs.getString("CPSCODE"));
						parcelShopsSO.setPsName(rs.getString("CPSNAME"));
						parcelShopsSO.setParcelshopRegion(rs.getString("CREGION"));
						parcelShopsSO.setParcelshopArea(rs.getString("CAREA"));
						parcelShopsSO.setParcelshopCscrcd(rs.getString("CSCRCD"));
						parcelShopsSO.setParcelshopCscrcdDesc(rs.getString("CSCRCDDESC"));
						parcelShopsSO.setEmailId1(rs.getString("CEMAILID1"));
						parcelShopsSO.setEmailId2(rs.getString("CEMAILID2"));
						parcelShopsList.add(parcelShopsSO);
					}
					
				} 
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured while fetching parcel shops : " + e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());

				}finally {
					log.debug("---------------------getParcelShopsList finally------------------------------------");
					CloseConnections.closeResultSet(rs);
					CloseConnections.closeCallableStatement(callableStatement);
				}
			}
			});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching parcel shops : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
		manageParcelShopPODUsersDto.setParcelShopsList(parcelShopsList);
		return manageParcelShopPODUsersDto;
	}


//---------------------------------------------------------------GET SERVICE CENTERS------------------------------------------------------------------------------------------------------
	
	
	/* 
	 * Method to get service centers.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#getServiceCentersList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto getServiceCentersList(String region, String area,String searchServiceCenterCode,String searchServiceCenterName) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : getServiceCentersList");

		
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		List<ServiceCentersDto> serviceCentersList = new ArrayList<ServiceCentersDto>();
		String[] allRegionArray = region.split(Constants.AT);
		String fetchServiceCenters = Constants.FETCH_SERVICECENTERS_PROCEDURE;
		
		try{
		    getSession().doWork(new Work() {
			CallableStatement callableStatement = null;
			ResultSet rs = null;
            
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					ServiceCentersDto serviceCentersSO = null;
					callableStatement = connection.prepareCall(fetchServiceCenters);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.GENERIC_VARCHAR_TYPE,connection);
					ARRAY arrayToPass = new ARRAY(des, connection, allRegionArray);
					
					((OracleCallableStatement) callableStatement).setARRAY(1, arrayToPass);
					
					if(area.equalsIgnoreCase(Constants.NULL))
					{
						callableStatement.setString(2, null);
					}
					else
					{
						callableStatement.setString(2, area);
					}
					if(searchServiceCenterCode.equalsIgnoreCase(Constants.NULL))
					{
						callableStatement.setString(3, null);
					}
					else
					{
						callableStatement.setString(3, searchServiceCenterCode);
					}
					if(searchServiceCenterName.equalsIgnoreCase(Constants.NULL))
					{
						callableStatement.setString(4, null);
					}
					else
					{
						callableStatement.setString(4, searchServiceCenterName);
					}
					callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
					callableStatement.execute();
					rs = (ResultSet) callableStatement.getObject(5);
					while (rs.next()) {
						serviceCentersSO = new ServiceCentersDto();
						serviceCentersSO.setCscrcd(rs.getString("CSCRCD"));
						serviceCentersSO.setCscrcdDesc(rs.getString("CSCRCDDESC"));
						serviceCentersSO.setServiceCenterRegion(rs.getString("CREGION"));
						serviceCentersSO.setServiceCenterArea(rs.getString("CAREA"));
						serviceCentersList.add(serviceCentersSO);
					}
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured while fetching service centers : " + e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
				finally {
					log.debug("---------------------getServiceCentersList finally------------------------------------");
					CloseConnections.closeResultSet(rs);
					CloseConnections.closeCallableStatement(callableStatement);
				}
			}
			});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching service centers : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		manageParcelShopPODUsersDto.setServiceCentersList(serviceCentersList);
		return manageParcelShopPODUsersDto;
	}

//----------------------------------------------------CREATE USER-----------------------------------------------------------------------------------------------------------
	
	
	/* 
	 * Method to create parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#createParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto createParcelShopPODUser(
			ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : createParcelShopPODUser");
	
		
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		
		Integer userCreationStatus = null;
		ManageParcelShopPODUsersDbObjectDto manageParcelShopPODUsersDbObjectDto = null;
		int securityLevel = Integer.parseInt(parcelShopPODUsersDetailsDto.getSecurityLevel());
		
		String encryptedPassword = passwordUtil.encryptPasswordByBase64(parcelShopPODUsersDetailsDto.getPassword());
		List<ManageParcelShopPODUsersDbObjectDto> psOrssListDb = new ArrayList<ManageParcelShopPODUsersDbObjectDto>();
		
		if(parcelShopPODUsersDetailsDto.getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER))
		{
			for (ServiceCentersDto serviceCentersDto : parcelShopPODUsersDetailsDto.getSelectedServiceCenters()) {
				manageParcelShopPODUsersDbObjectDto = new ManageParcelShopPODUsersDbObjectDto();
				
				manageParcelShopPODUsersDbObjectDto.setCscrcd(serviceCentersDto.getCscrcd());
				manageParcelShopPODUsersDbObjectDto.setCregion(serviceCentersDto.getServiceCenterRegion());
				manageParcelShopPODUsersDbObjectDto.setCarea(serviceCentersDto.getServiceCenterArea());
				manageParcelShopPODUsersDbObjectDto.setCenableflag(null);
				manageParcelShopPODUsersDbObjectDto.setCloginid(null);
				manageParcelShopPODUsersDbObjectDto.setCname(null);
				manageParcelShopPODUsersDbObjectDto.setCpscode(null);
				manageParcelShopPODUsersDbObjectDto.setCusertype(null);
				manageParcelShopPODUsersDbObjectDto.setSql_type(Constants.UPROFILE4_PARCELSHOPOBJ);
				psOrssListDb.add(manageParcelShopPODUsersDbObjectDto);
			}
		}
		else if(parcelShopPODUsersDetailsDto.getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL))
		{
			for (ParcelShopsDto parcelShopsDto : parcelShopPODUsersDetailsDto.getSelectedParcelshops()) {
				manageParcelShopPODUsersDbObjectDto = new ManageParcelShopPODUsersDbObjectDto();
				
				manageParcelShopPODUsersDbObjectDto.setCscrcd(null);
				manageParcelShopPODUsersDbObjectDto.setCregion(parcelShopsDto.getParcelshopRegion());
				manageParcelShopPODUsersDbObjectDto.setCarea(parcelShopsDto.getParcelshopArea());
				manageParcelShopPODUsersDbObjectDto.setCenableflag(null);
				manageParcelShopPODUsersDbObjectDto.setCloginid(null);
				manageParcelShopPODUsersDbObjectDto.setCname(null);
				manageParcelShopPODUsersDbObjectDto.setCpscode(parcelShopsDto.getPsCode());
				manageParcelShopPODUsersDbObjectDto.setCusertype(null);
				manageParcelShopPODUsersDbObjectDto.setSql_type(Constants.UPROFILE4_PARCELSHOPOBJ);
				psOrssListDb.add(manageParcelShopPODUsersDbObjectDto);
			}
		}
		ManageParcelShopPODUsersDbObjectDto[] psOrSSArray = psOrssListDb.toArray(new ManageParcelShopPODUsersDbObjectDto[psOrssListDb.size()]);
		
		try{
			userCreationStatus = getSession().doReturningWork(new ReturningWork<Integer>(){
			CallableStatement callableStatement = null;
			@Override
			public Integer execute(Connection connection) throws SQLException {
				Integer userCreationResultInner = null;
				
				try{
				Map<String, Class<?>> map = connection.getTypeMap();
				
				map.put(environment.getProperty(Constants.PARCELSHOPOBJ_PROPERTY), Class.forName(Constants.UPROFILE4_PARCELSHOPPODUSER_DTO));
					  
				connection.setTypeMap(map);
				ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.PARCELSHOP_LIST,connection);
				ARRAY arrayToPass = new ARRAY(des, connection, psOrSSArray);
				callableStatement = connection.prepareCall(Constants.CREATE_PARCELSHOPPODUSER_PROCEDURE);
				callableStatement.clearParameters();
				callableStatement.setString(1,parcelShopPODUsersDetailsDto.getLoginId());
				callableStatement.setInt(2,securityLevel);
				callableStatement.setString(3,parcelShopPODUsersDetailsDto.getCreatedBy());
				callableStatement.setString(4,parcelShopPODUsersDetailsDto.getEmployeeCode());
				callableStatement.setString(5,parcelShopPODUsersDetailsDto.getUserType());
				((OracleCallableStatement) callableStatement).setArray(6, arrayToPass);
				callableStatement.setString(7,parcelShopPODUsersDetailsDto.getCustCode());
				callableStatement.setString(8,parcelShopPODUsersDetailsDto.getArea());
				callableStatement.setString(9,parcelShopPODUsersDetailsDto.getEmailId());
				callableStatement.setString(10,parcelShopPODUsersDetailsDto.getUserName());
				callableStatement.setString(11,parcelShopPODUsersDetailsDto.getRegion());
				callableStatement.setString(12,encryptedPassword);
				callableStatement.setString(13,parcelShopPODUsersDetailsDto.getBd_flag());
				callableStatement.setString(14,parcelShopPODUsersDetailsDto.getPodStatus());// if Parcel shop user set Y always. if POD user, set Y or N based on input
				((OracleCallableStatement) callableStatement).registerOutParameter(15, Types.NUMERIC);
				
				((OracleCallableStatement) callableStatement).execute();
				
				userCreationResultInner = callableStatement.getInt(15);
				
				
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured while creating parcel shop/pod user : " + e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
				finally {
					log.debug("---------------------createParcelShopPODUser finally------------------------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				
				return userCreationResultInner;
			}
		});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while creating parcel shop/pod user : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
	
		if(userCreationStatus == 0)
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserCreationStatus(Constants.SUCCESS_STRING);
			
			
			//-------------------------SEND EMAIL-------------------------------------------------------------------------------------------------------------
			if(!(Constants.USERTYPE_POD_USER).equalsIgnoreCase(parcelShopPODUsersDetailsDto.getUserType()) && !(Constants.STRING_N).equalsIgnoreCase(parcelShopPODUsersDetailsDto.getPodStatus())){
			try{
				ManageParcelShopPODUsersDto manageParcelShopPODUsersDto_email = getParcelShopPODUserDetails(parcelShopPODUsersDetailsDto.getLoginId(),parcelShopPODUsersDetailsDto.getLoggedInAdminRegion(),parcelShopPODUsersDetailsDto.getPodStatus());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setUserType(parcelShopPODUsersDetailsDto.getUserType());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setPassword(parcelShopPODUsersDetailsDto.getPassword());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setLoginId(parcelShopPODUsersDetailsDto.getLoginId());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setLoggedInAdminEmailId(parcelShopPODUsersDetailsDto.getLoggedInAdminEmailId());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setEmailId(parcelShopPODUsersDetailsDto.getEmailId());
				manageParcelShopPODUsersDto_email.getParcelShopUserDetails().setUserName(parcelShopPODUsersDetailsDto.getUserName());
				
				ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto = new ManageParcelShopPODUsersNotificationsDto();
				manageParcelShopPODUsersNotificationsDto.setAction(Constants.CREATE_USER_ACTION);
				manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersDetailsDto(manageParcelShopPODUsersDto_email.getParcelShopUserDetails());
				manageParcelShopPODUsersNotificationsDto.getParcelShopPODUsersDetailsDto().setSelectedParcelshops(parcelShopPODUsersDetailsDto.getSelectedParcelshops());
				manageParcelShopPODUsersNotificationsDto.setModuleName(Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
				String emailStatus = sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
				if(Constants.EMAIL_SUCCESS.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_SUCCESS);
				}
				else if(Constants.EMAIL_FAILURE.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_FAILURE);
				}
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Exception occured while fetching email details : "+e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
			
			}
			else
			{
				manageParcelShopPODUsersDto.setEmailStatus(Constants.NO_EMAIL_REQUIRED);
			}
		}
		else
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserCreationStatus(Constants.FAILURE_STRING);
		}
		manageParcelShopPODUsersDto.setParcelShopUserDetails(parcelShopPODUsersDetailsDto);
		
		return manageParcelShopPODUsersDto;
	}

//----------------------------------------------------------GET USER DETAILS----------------------------------------------------------------------------------------------------
	
	
	/* 
	 * Method to get parcel shop/POD user details.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#getParcelShopPODUserDetails(java.lang.String, java.util.ArrayList, java.lang.String)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto getParcelShopPODUserDetails(String loginId,ArrayList<String> region,String podStatus) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : getParcelShopPODUserDetails");
		
		ArrayList<String> regionClean = new ArrayList<String>();
		for (String temp : region) {
			String tempRegion = temp;
			tempRegion = tempRegion.replaceAll(Constants.STRING_RAND1, Constants.EMPTY_STRING).replaceAll(Constants.STRING_RAND2, Constants.EMPTY_STRING);
			regionClean.add(tempRegion);
		}
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		
		ArrayList<String> loggedInAdminRegionsList;
		loggedInAdminRegionsList = regionClean;
		
		String[] region1 = new String[loggedInAdminRegionsList.size()];
		region1 = loggedInAdminRegionsList.toArray(region1);	
		String[] region2 = region1;
		
		ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto = new ParcelShopPODUsersDetailsDto();
		ArrayList<ParcelShopsDto> parcelShopsList = new ArrayList<ParcelShopsDto>();
		ArrayList<ServiceCentersDto> serviceCentersList = new ArrayList<ServiceCentersDto>();
		
		String getUserDetails = Constants.GET_PARCELSHOP_POD_USERDETAILS_PROCEDURE;
		try{
		    getSession().doWork(new Work() {
			CallableStatement callableStatement = null;
			ResultSet rs = null;
			
			@Override
			public void execute(Connection connection) throws SQLException {
				try{
					
				callableStatement = connection.prepareCall(getUserDetails);
				ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.GENERIC_VARCHAR_TYPE,connection);
				ARRAY arrayToPass = new ARRAY(des, connection, region2);
				
				callableStatement.setString(1, loginId);
				((OracleCallableStatement) callableStatement).setARRAY(2, arrayToPass);
				callableStatement.setString(3, podStatus);
				callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
				callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
				((OracleCallableStatement) callableStatement).registerOutParameter(6, Types.NUMERIC);
				callableStatement.execute();
				String userType = "";
				ParcelShopsDto parcelShopsDto = null;
				ServiceCentersDto serviceCentersDto = null;
				
				rs = (ResultSet) callableStatement.getObject(4);
				while(rs.next()){
					parcelShopPODUsersDetailsDto.setUserType(rs.getString("USER_TYPE"));
					parcelShopPODUsersDetailsDto.setUserName(rs.getString("NAME"));
					parcelShopPODUsersDetailsDto.setSecurityLevel(rs.getString("SECURITY_LEVEL"));
					parcelShopPODUsersDetailsDto.setEmailId(rs.getString("EMAILID"));
					
					if(Constants.STRING_Y.equalsIgnoreCase(podStatus)){
					parcelShopPODUsersDetailsDto.setUserId(rs.getString("USERID"));
					}
					else
					{
					parcelShopPODUsersDetailsDto.setUserId(Constants.EMPTY_STRING);
					}
					
					if(rs.getString("USER_TYPE").equalsIgnoreCase(Constants.USERTYPE_PARCEL))
					{
						userType = Constants.USERTYPE_PARCEL;
					}
					else if(rs.getString("USER_TYPE").equalsIgnoreCase(Constants.USERTYPE_POD_USER))
					{
						userType = Constants.USERTYPE_POD_USER;
					}
					parcelShopPODUsersDetailsDto.setPodStatus(podStatus);
				}
				
				rs = (ResultSet) callableStatement.getObject(5);
				
				while(rs.next()){
					if(userType.equalsIgnoreCase(Constants.USERTYPE_PARCEL))
					{
						parcelShopsDto = new ParcelShopsDto();
						parcelShopsDto.setPsCode(rs.getString("CPSCODE"));
                        parcelShopsDto.setPsName(rs.getString("CPSNAME"));
                        parcelShopsDto.setParcelshopCscrcd(rs.getString("CSCRCD"));
                        parcelShopsDto.setParcelshopCscrcdDesc(rs.getString("CSCRCDDESC"));
                        parcelShopsDto.setParcelshopRegion(rs.getString("CREGION"));
                        parcelShopsDto.setParcelshopArea(rs.getString("CAREA"));
                        if(Constants.EMPTY_STRING.equalsIgnoreCase(rs.getString("CEMAILID1")) || rs.getString("CEMAILID1") == null)
                        {
                        	 parcelShopsDto.setEmailId1(Constants.NULL_STRING);
                        }
                        else
                        {
                        	 parcelShopsDto.setEmailId1(rs.getString("CEMAILID1"));
                        }
                        if(Constants.EMPTY_STRING.equalsIgnoreCase(rs.getString("CEMAILID2")) || rs.getString("CEMAILID2") == null)
                        {
                        	parcelShopsDto.setEmailId2(Constants.NULL_STRING);
                        }
                        else
                        {
                        	parcelShopsDto.setEmailId2(rs.getString("CEMAILID2"));
                        }
                        
                        parcelShopsDto.setEnableFlag(rs.getString("E_FLAG"));
                        parcelShopsList.add(parcelShopsDto);
					}
					else if(userType.equalsIgnoreCase(Constants.USERTYPE_POD_USER))
					{
						serviceCentersDto = new ServiceCentersDto();
						
						    if(Constants.STRING_Y.equalsIgnoreCase(podStatus)){
						    	serviceCentersDto.setCscrcd(rs.getString("CSCRCD"));
							}
							else
							{
								serviceCentersDto.setCscrcd(rs.getString("PSCRCD"));
							}
						    
						serviceCentersDto.setCscrcdDesc(rs.getString("CSCRCDDESC"));
						serviceCentersDto.setServiceCenterRegion(rs.getString("CREGION"));
						serviceCentersDto.setServiceCenterArea(rs.getString("CAREA"));
						serviceCentersDto.setEnableFlag(rs.getString("E_FLAG"));
						serviceCentersList.add(serviceCentersDto);
					}
				}
				
				
				if(userType.equalsIgnoreCase(Constants.USERTYPE_PARCEL)){
					parcelShopPODUsersDetailsDto.setSelectedParcelshops(parcelShopsList);
				}
				else if(userType.equalsIgnoreCase(Constants.USERTYPE_POD_USER))
				{
				parcelShopPODUsersDetailsDto.setSelectedServiceCenters(serviceCentersList);
				}
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured while fetching user details : " + e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
				finally { 
					log.debug("---------------------getParcelShopPODUserDetails finally------------------------------------");
					CloseConnections.closeResultSet(rs);
					CloseConnections.closeCallableStatement(callableStatement);
				}
			}
			
		});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching user details : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
     manageParcelShopPODUsersDto.setParcelShopUserDetails(parcelShopPODUsersDetailsDto);

		return manageParcelShopPODUsersDto;
	}

	
	
//------------------------------------------------------------------DEACTIVATE USER--------------------------------------------------------------------------
	
	
	/* 
	 * Method to deactivate parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#deactivateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto deactivateParcelShopPODUser(ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : deactivateParcelShopPODUser");
		
		String enableFlag = Constants.STRING_N;
		
		ArrayList<String> loggedInAdminRegionsList;
		loggedInAdminRegionsList = parcelShopPODUsersSearchResultDto.getLoggedInAdminRegion();
		
		String[] region = new String[loggedInAdminRegionsList.size()];
		region = loggedInAdminRegionsList.toArray(region);	
		String password = "";
		
		int deactivationReactivationStatus = deactivateReactivateUser(parcelShopPODUsersSearchResultDto.getLoginId(), region , parcelShopPODUsersSearchResultDto.getUserType(), enableFlag,"Deactivate",parcelShopPODUsersSearchResultDto.getPodStatus(),password);
        ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
        
		if(deactivationReactivationStatus == 0)
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.SUCCESS_STRING);
			try{
			ManageParcelShopPODUsersDto manageParcelShopPODUsersDto_email = getParcelShopPODUserDetails(parcelShopPODUsersSearchResultDto.getLoginId(),parcelShopPODUsersSearchResultDto.getLoggedInAdminRegion(),parcelShopPODUsersSearchResultDto.getPodStatus());
			
			ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto = new ManageParcelShopPODUsersNotificationsDto();
			manageParcelShopPODUsersNotificationsDto.setAction(Constants.DEACTIVATE_USER_ACTION);
			manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersSearchResultDto(parcelShopPODUsersSearchResultDto);
			manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersDetailsDto(manageParcelShopPODUsersDto_email.getParcelShopUserDetails());
			manageParcelShopPODUsersNotificationsDto.setModuleName(Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
			String emailStatus = sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
			if(Constants.EMAIL_SUCCESS.equalsIgnoreCase(emailStatus))
			{
				manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_SUCCESS);
			}
			else if(Constants.EMAIL_FAILURE.equalsIgnoreCase(emailStatus))
			{
				manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_FAILURE);
			}
			}
			catch(Exception e)
			{
				log.error("EXCEPTION TYPE :",e);
				log.error("Exception occured while fetching email details : "+e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}
		
		}
		else if(deactivationReactivationStatus == 1)
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.UNABLE_TO_DEACTIVATE);
		}
		else
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.FAILURE_STRING);
		}
		
		return manageParcelShopPODUsersDto;
	}
	
//------------------------------------------------------------------REACTIVATE USER--------------------------------------------------------------------------

	

//----------------------------------------------------------------REACTIVATE USER----------------------------------------------------------------------------------
	
	/* 
	 * Method to reactivate parcel shop/POD user.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#reactivateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchResultDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto reactivateParcelShopPODUser(ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : reactivateParcelShopPODUser");
		
		String enableFlag = Constants.STRING_Y;
		ArrayList<String> loggedInAdminRegionsList;
		loggedInAdminRegionsList = parcelShopPODUsersSearchResultDto.getLoggedInAdminRegion();
		
		String[] region = new String[loggedInAdminRegionsList.size()];
		region = loggedInAdminRegionsList.toArray(region);	
		String encryptedPassword = passwordUtil.encryptPasswordByBase64(parcelShopPODUsersSearchResultDto.getNewPasswordReactivate());
		
		int deactivationReactivationStatus = deactivateReactivateUser(parcelShopPODUsersSearchResultDto.getLoginId(), region, parcelShopPODUsersSearchResultDto.getUserType(), enableFlag,"Reactivate",parcelShopPODUsersSearchResultDto.getPodStatus(),encryptedPassword);
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		if(deactivationReactivationStatus == 0)
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.SUCCESS_STRING);
			try{
				ManageParcelShopPODUsersDto manageParcelShopPODUsersDto_email = getParcelShopPODUserDetails(parcelShopPODUsersSearchResultDto.getLoginId(),parcelShopPODUsersSearchResultDto.getLoggedInAdminRegion(),parcelShopPODUsersSearchResultDto.getPodStatus());

				ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto = new ManageParcelShopPODUsersNotificationsDto();
				manageParcelShopPODUsersNotificationsDto.setAction(Constants.REACTIVATE_USER_ACTION);
				manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersSearchResultDto(parcelShopPODUsersSearchResultDto);
				manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersDetailsDto(manageParcelShopPODUsersDto_email.getParcelShopUserDetails());
				manageParcelShopPODUsersNotificationsDto.setModuleName(Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
				String emailStatus = sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
				
				                        
				if(Constants.EMAIL_SUCCESS.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_SUCCESS);
				}
				else if(Constants.EMAIL_FAILURE.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_FAILURE);
				}
				
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Exception occured while fetching email details : "+e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
		}
		else if(deactivationReactivationStatus == 1)
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.UNABLE_TO_REACTIVATE);
		}
		else
		{
			manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus(Constants.FAILURE_STRING);
		}
		
		return manageParcelShopPODUsersDto;
	}
	
	//-------------------------------------GET USERS LIST----------------------------------------------------------------------------------------
	
	
	/* 
	 * Method to get parcel shop/POD users.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#getParcelShopPODUsers(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersSearchDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto getParcelShopPODUsers(ParcelShopPODUsersSearchDto parcelShopPODUsersSearchDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : getParcelShopPODUsers");
		
		ArrayList<String> loggedInAdminRegionsList;
		loggedInAdminRegionsList = parcelShopPODUsersSearchDto.getAdminRegion();
		
		String[] region_temp = new String[loggedInAdminRegionsList.size()];
		String[] region = loggedInAdminRegionsList.toArray(region_temp);	
		
		
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = null;
		try{
			manageParcelShopPODUsersDto = getSession().doReturningWork(new ReturningWork<ManageParcelShopPODUsersDto>(){
				ResultSet rs = null;
				CallableStatement callableStatement = null;
				@Override
				public ManageParcelShopPODUsersDto execute(Connection connection) throws SQLException {
					ManageParcelShopPODUsersDto manageParcelShopPODUsersDtoInner = new ManageParcelShopPODUsersDto();
					try{
					Map<String, Class<?>> map = connection.getTypeMap();
					
					map.put(environment.getProperty(Constants.PARCELSHOPOBJ_PROPERTY), Class.forName(Constants.UPROFILE4_PARCELSHOPPODUSER_DTO));
					
					connection.setTypeMap(map);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.GENERIC_VARCHAR_TYPE,connection);
					ARRAY arrayToPass = new ARRAY(des, connection, region);
					callableStatement = connection.prepareCall(Constants.GET_LIST_PARCELSHOP_POD_USERS_PROCEDURE);
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setArray(1, arrayToPass);//region array
					callableStatement.setString(2, parcelShopPODUsersSearchDto.getUserType());//userType
					callableStatement.setString(3, parcelShopPODUsersSearchDto.getParcelShop());//ps code
					callableStatement.setString(4, parcelShopPODUsersSearchDto.getServiceCenter());//ss code
					callableStatement.setString(5, parcelShopPODUsersSearchDto.getStatus());//status
					callableStatement.setInt(6, parcelShopPODUsersSearchDto.getPageSize());//page size
					callableStatement.setInt(7, parcelShopPODUsersSearchDto.getPageNumber());// page num
					callableStatement.registerOutParameter(8, OracleTypes.CURSOR);
					((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.NUMERIC);
					((OracleCallableStatement) callableStatement).execute();
					Integer totalCount = callableStatement.getInt(9);
					List<ParcelShopPODUsersSearchResultDto> parcelShopPODUsersSearchResultList = new ArrayList<>();
					rs = (ResultSet) callableStatement.getObject(8);
					ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto = null;
					
					while(rs.next()){
						parcelShopPODUsersSearchResultDto = new ParcelShopPODUsersSearchResultDto();
						
						
						parcelShopPODUsersSearchResultDto.setLoginId(rs.getString("LOGINID"));
						parcelShopPODUsersSearchResultDto.setStatus(rs.getString("ENABLE_FLAG"));
						parcelShopPODUsersSearchResultDto.setUserId(rs.getString("USERID"));
						parcelShopPODUsersSearchResultDto.setUserName(rs.getString("NAME"));
						parcelShopPODUsersSearchResultDto.setUserType(rs.getString("USER_TYPE"));
						parcelShopPODUsersSearchResultDto.setDeactivationReacivationPossibilityStatus(rs.getString("ACTIVATED"));
						parcelShopPODUsersSearchResultDto.setPodStatus(rs.getString("POD_STATUS"));
						parcelShopPODUsersSearchResultDto.setUserEmailId(rs.getString("EMAILID"));
						parcelShopPODUsersSearchResultList.add(parcelShopPODUsersSearchResultDto);
						
						
					}
					
					manageParcelShopPODUsersDtoInner.setParcelShopPODUsersSearchResultList(parcelShopPODUsersSearchResultList);
					
					manageParcelShopPODUsersDtoInner.setTotalCount(totalCount);
					}
					catch(Exception e)
					{
						log.error("EXCEPTION TYPE :",e);
						log.error("Error Occured while fetching users list : " + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}
					finally{
						log.debug("---------------------getParcelShopPODUsers finally------------------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return manageParcelShopPODUsersDtoInner;
				}
				
			});
			
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching users list : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
		return manageParcelShopPODUsersDto;
	}
	
	//---------------------------------------UPDATE USER-----------------------------------------------------------------------------------------------------
	
	
	/* 
	 * Method to update parcel shop/POD users.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#updateParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ParcelShopPODUsersDetailsDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto updateParcelShopPODUser(
			ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : updateParcelShopPODUser");
		
		
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDtoBefore = new ManageParcelShopPODUsersDto();
		ArrayList<ParcelShopsDto> deletedPS = new ArrayList<>();
    	ArrayList<ParcelShopsDto> newlyAddedPS = new ArrayList<>();
    	ArrayList<ServiceCentersDto> deletedSS = new ArrayList<ServiceCentersDto>();
    	ArrayList<ServiceCentersDto> newlyAddedSS = new ArrayList<ServiceCentersDto>();
		
		//-------------------------------------------------GET USER DETAILS-----------------------------------------------------
		
		try{
			manageParcelShopPODUsersDtoBefore = getParcelShopPODUserDetails(parcelShopPODUsersDetailsDto.getLoginId(),parcelShopPODUsersDetailsDto.getLoggedInAdminRegion(),parcelShopPODUsersDetailsDto.getPodStatus());
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Exception occured while fetching email details : "+e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		//-----------------------------------------------------------------------------------------------------------------------
		
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		Integer userUpdateStatus = null;
		ManageParcelShopPODUsersDbObjectDto manageParcelShopPODUsersDbObjectDto = null;
		int securityLevel = Integer.parseInt(parcelShopPODUsersDetailsDto.getSecurityLevel());
		
		List<ManageParcelShopPODUsersDbObjectDto> psOrssListDb = new ArrayList<>();
		
		if(parcelShopPODUsersDetailsDto.getUserType().equalsIgnoreCase(Constants.USERTYPE_POD_USER))
		{
			for (ServiceCentersDto serviceCentersDto : parcelShopPODUsersDetailsDto.getSelectedServiceCenters()) {
				manageParcelShopPODUsersDbObjectDto = new ManageParcelShopPODUsersDbObjectDto();
				
				manageParcelShopPODUsersDbObjectDto.setCscrcd(serviceCentersDto.getCscrcd());
				manageParcelShopPODUsersDbObjectDto.setCregion(serviceCentersDto.getServiceCenterRegion());
				manageParcelShopPODUsersDbObjectDto.setCarea(serviceCentersDto.getServiceCenterArea());
				manageParcelShopPODUsersDbObjectDto.setCenableflag(null);
				manageParcelShopPODUsersDbObjectDto.setCloginid(null);
				manageParcelShopPODUsersDbObjectDto.setCname(null);
				manageParcelShopPODUsersDbObjectDto.setCpscode(null);
				manageParcelShopPODUsersDbObjectDto.setCusertype(null);
				manageParcelShopPODUsersDbObjectDto.setSql_type(Constants.UPROFILE4_PARCELSHOPOBJ);
				psOrssListDb.add(manageParcelShopPODUsersDbObjectDto);
			}
		}
		else if(parcelShopPODUsersDetailsDto.getUserType().equalsIgnoreCase(Constants.USERTYPE_PARCEL))
		{
			for (ParcelShopsDto parcelShopsDto : parcelShopPODUsersDetailsDto.getSelectedParcelshops()) {
				manageParcelShopPODUsersDbObjectDto = new ManageParcelShopPODUsersDbObjectDto();
				
				manageParcelShopPODUsersDbObjectDto.setCscrcd(null);
				manageParcelShopPODUsersDbObjectDto.setCregion(parcelShopsDto.getParcelshopRegion());
				manageParcelShopPODUsersDbObjectDto.setCarea(parcelShopsDto.getParcelshopArea());
				manageParcelShopPODUsersDbObjectDto.setCenableflag(null);
				manageParcelShopPODUsersDbObjectDto.setCloginid(null);
				manageParcelShopPODUsersDbObjectDto.setCname(null);
				manageParcelShopPODUsersDbObjectDto.setCpscode(parcelShopsDto.getPsCode());
				manageParcelShopPODUsersDbObjectDto.setCusertype(null);
				manageParcelShopPODUsersDbObjectDto.setSql_type(Constants.UPROFILE4_PARCELSHOPOBJ);
				psOrssListDb.add(manageParcelShopPODUsersDbObjectDto);
			}
		}
		ManageParcelShopPODUsersDbObjectDto[] psOrSSArray = psOrssListDb.toArray(new ManageParcelShopPODUsersDbObjectDto[psOrssListDb.size()]);
		try{
			userUpdateStatus = getSession().doReturningWork(new ReturningWork<Integer>(){
			CallableStatement callableStatement = null;
			@Override
			public Integer execute(Connection connection) throws SQLException {
				Integer userCreationResultInner = null;
				
				try{
				Map<String, Class<?>> map = connection.getTypeMap();
				
				map.put(environment.getProperty(Constants.PARCELSHOPOBJ_PROPERTY), Class.forName(Constants.UPROFILE4_PARCELSHOPPODUSER_DTO));

				connection.setTypeMap(map);
				ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.PARCELSHOP_LIST,connection);
				ARRAY arrayToPass = new ARRAY(des, connection, psOrSSArray);
				callableStatement = connection.prepareCall(Constants.UPDATE_PARCELSHOP_POD_USER_PROCEDURE);
				callableStatement.clearParameters();
				callableStatement.setString(1,parcelShopPODUsersDetailsDto.getLoginId());
				callableStatement.setInt(2,securityLevel);//security level
				callableStatement.setString(3,parcelShopPODUsersDetailsDto.getEmailId());
				callableStatement.setString(4,parcelShopPODUsersDetailsDto.getUserName());
				callableStatement.setString(5,parcelShopPODUsersDetailsDto.getModifiedBy());
				callableStatement.setString(6,parcelShopPODUsersDetailsDto.getUserType());
				((OracleCallableStatement) callableStatement).setArray(7, arrayToPass);
				callableStatement.setString(8,parcelShopPODUsersDetailsDto.getBd_flag());
				callableStatement.setString(9,Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
				callableStatement.setString(10,Constants.UPDATE_USER_ACTION);
				callableStatement.setString(11,parcelShopPODUsersDetailsDto.getPodStatus());
				((OracleCallableStatement) callableStatement).registerOutParameter(12, Types.NUMERIC);
				((OracleCallableStatement) callableStatement).execute();
				userCreationResultInner = callableStatement.getInt(12);
				
				}
				catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Exception Occured while creating parcel shop/pod user :  "+e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
				finally {
					log.debug("---------------------updateParcelShopPODUser finally------------------------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				
				return userCreationResultInner;
			}
		});
			if(userUpdateStatus == 0)
			{
				manageParcelShopPODUsersDto.setParcelShopPODUserUpdateStatus(Constants.UPDATE_SUCCESS);
				if(!Constants.USERTYPE_POD_USER.equalsIgnoreCase(parcelShopPODUsersDetailsDto.getUserType()) && Constants.STRING_Y.equalsIgnoreCase(parcelShopPODUsersDetailsDto.getPodStatus())){
				
				//------------------------------COMPARING DELETED AND NEWLY ADDED PARCEL SHOPS / SERVICE CENTERS------------------------------------------------
				
					if(Constants.USERTYPE_PARCEL.equalsIgnoreCase(parcelShopPODUsersDetailsDto.getUserType()))
				{
			    	 
			    	 for (ParcelShopsDto outer : manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getSelectedParcelshops()) {
			    		 
			    		 Boolean flag = false;
			    		 
			    		 for (ParcelShopsDto inner : parcelShopPODUsersDetailsDto.getSelectedParcelshops()) {
			    			 if(outer.getPsCode().equalsIgnoreCase(inner.getPsCode()))
			    			 {
			    				 flag = true;
			    				 break;
			    			 }
			    			
						}
			    		 
			    		 if(flag == false)
						 {
							 deletedPS.add(outer);
						 }
						
					}
					
					for (ParcelShopsDto outer :  parcelShopPODUsersDetailsDto.getSelectedParcelshops()) {
			   		 
			   		 Boolean flag = false;
			   		 
			   		 for (ParcelShopsDto inner :  manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getSelectedParcelshops()) {
			   			 if(outer.getPsCode().equalsIgnoreCase(inner.getPsCode()))
			   			 {
			   				 flag = true;
			   				 break;
			   			 }
						}
			   		 
			   		 if(flag == false)
						 {
			   			   newlyAddedPS.add(outer);
						 }
						
					}
					
				}
				
				if(Constants.USERTYPE_POD_USER.equalsIgnoreCase(parcelShopPODUsersDetailsDto.getUserType()))
				{
			    	 for (ServiceCentersDto outer : manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getSelectedServiceCenters()) {
			    		 
			    		 Boolean flag = false;
			    		 
			    		 for (ServiceCentersDto inner : parcelShopPODUsersDetailsDto.getSelectedServiceCenters()) {
			    			 if(outer.getCscrcd().equalsIgnoreCase(inner.getCscrcd()))
			    			 {
			    				 flag = true;
			    				 break;
			    			 }
			    			
						}
			    		 
			    		 if(flag == false)
						 {
							 deletedSS.add(outer);
						 }
						
					}
			    	 
					for (ServiceCentersDto outer :  parcelShopPODUsersDetailsDto.getSelectedServiceCenters()) {
			   		 
			   		 Boolean flag = false;
			   		 
			   		 for (ServiceCentersDto inner :  manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getSelectedServiceCenters()) {
			   			 if(outer.getCscrcd().equalsIgnoreCase(inner.getCscrcd()))
			   			 {
			   				 flag = true;
			   				 break;
			   			 }
						}
			   		 
			   		 if(flag == false)
						 {
			   			  newlyAddedSS.add(outer);
						 }
						
					}
			    	
				}
				
				//--------------------------------------EMAIL----------------------------------------------------------------------
				
				ParcelShopPODUsersDetailsDto parcelShopPODUsersDetailsDto_email = new ParcelShopPODUsersDetailsDto();
				if(!(manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getUserName().equalsIgnoreCase(parcelShopPODUsersDetailsDto.getUserName())))
				{
					parcelShopPODUsersDetailsDto_email.setUserName(parcelShopPODUsersDetailsDto.getUserName());
				}
				if(!(manageParcelShopPODUsersDtoBefore.getParcelShopUserDetails().getEmailId().equalsIgnoreCase(parcelShopPODUsersDetailsDto.getEmailId())))
				{
					parcelShopPODUsersDetailsDto_email.setEmailId(parcelShopPODUsersDetailsDto.getEmailId());
				}
				parcelShopPODUsersDetailsDto_email.setDeletedParcelShops(deletedPS);
				parcelShopPODUsersDetailsDto_email.setAddedParcelShops(newlyAddedPS);
				parcelShopPODUsersDetailsDto_email.setDeletedServiceCenters(deletedSS);
				parcelShopPODUsersDetailsDto_email.setAddedServiceCenters(newlyAddedSS);
				parcelShopPODUsersDetailsDto_email.setSelectedParcelshops(parcelShopPODUsersDetailsDto.getSelectedParcelshops());
				parcelShopPODUsersDetailsDto_email.setSelectedServiceCenters(parcelShopPODUsersDetailsDto.getSelectedServiceCenters());
				parcelShopPODUsersDetailsDto_email.setLoginId(parcelShopPODUsersDetailsDto.getLoginId());
				parcelShopPODUsersDetailsDto_email.setUserType(parcelShopPODUsersDetailsDto.getUserType());
				parcelShopPODUsersDetailsDto_email.setLoggedInAdminEmailId(parcelShopPODUsersDetailsDto.getLoggedInAdminEmailId());
				
				
				ParcelShopPODUsersSearchResultDto parcelShopPODUsersSearchResultDto = new ParcelShopPODUsersSearchResultDto();
				parcelShopPODUsersSearchResultDto.setUserEmailId(parcelShopPODUsersDetailsDto.getEmailId());
				
				ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto = new ManageParcelShopPODUsersNotificationsDto();
				manageParcelShopPODUsersNotificationsDto.setAction(Constants.UPDATE_USER_ACTION);
				manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersSearchResultDto(parcelShopPODUsersSearchResultDto);
				manageParcelShopPODUsersNotificationsDto.setParcelShopPODUsersDetailsDto(parcelShopPODUsersDetailsDto_email);
				manageParcelShopPODUsersNotificationsDto.setModuleName(Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
				String emailStatus = sendEmailManageParcelShopPODUser(manageParcelShopPODUsersNotificationsDto);
				if(Constants.EMAIL_SUCCESS.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_SUCCESS);
				}
				else if(Constants.EMAIL_FAILURE.equalsIgnoreCase(emailStatus))
				{
					manageParcelShopPODUsersDto.setEmailStatus(Constants.EMAIL_FAILURE);
				}
				
			}
			else
			{
				manageParcelShopPODUsersDto.setEmailStatus(Constants.NO_EMAIL_REQUIRED);
			}
				
				
			}
			else
			{
				manageParcelShopPODUsersDto.setParcelShopPODUserUpdateStatus(Constants.UPDATE_FAIL);
			}
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while creating parcel shop/pod user : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
		
		
		manageParcelShopPODUsersDto.setParcelShopUserDetails(parcelShopPODUsersDetailsDto);

		return manageParcelShopPODUsersDto;
	}

   
	
	//--------------------------------------------------------GET AREAS-----------------------------------------------------------------------------------------
	
	/* 
	 * Method to get areas based on region
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#getAreaRegionList(java.util.ArrayList)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersDto getAreaRegionList(ArrayList<String> region) {

		log.debug("ManageParcelShopPODUsersDaoImpl : getAreaRegionList");

		
		String regionString = region.toString();
       
		regionString = regionString.replaceAll(Constants.STRING_RAND1, Constants.EMPTY_STRING).replaceAll(Constants.STRING_RAND2, Constants.EMPTY_STRING).replaceAll(Constants.STRING_RAND3, Constants.EMPTY_STRING);
		
		String[] regionArray = regionString.split(Constants.COMMA_DELIMETER);
		String regionIn = Constants.LEFT_ROUND_BRACKET;
		for (String regionElement : regionArray) {
			regionIn = regionIn +Constants.SINGLE_QUOTE+regionElement+Constants.SINGLE_QUOTE_COMMA;
		}
		regionIn = regionIn.substring(0, regionIn.length()-1);
		regionIn = regionIn +Constants.RIGHT_ROUND_BRACKET;
		
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(Constants.GET_AREAS_PROCEDURE+regionIn);
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = null;
		try{
		manageParcelShopPODUsersDto = getSession().doReturningWork(new ReturningWork<ManageParcelShopPODUsersDto>() {

			@Override
			public ManageParcelShopPODUsersDto execute(Connection connection) throws SQLException {
				ManageParcelShopPODUsersDto manageParcelShopPODUsersDtoInner = null;
				
				ResultSet rs = null;
				PreparedStatement pStmt= null;
				try{
				List<AreaRegionDto> areaRegionList = new ArrayList<>();
				 manageParcelShopPODUsersDtoInner = new ManageParcelShopPODUsersDto();
				AreaRegionDto areaRegionDto = null;
				pStmt = connection.prepareStatement(sqlQuery.toString());
				rs = pStmt.executeQuery();
				if (rs != null && rs.next())
				{
					do{
					areaRegionDto = new AreaRegionDto();
					areaRegionDto.setRegion(rs.getString(1));
					areaRegionDto.setAreaCode(rs.getString(2));
					areaRegionDto.setAreaDesc(rs.getString(3));
					areaRegionList.add(areaRegionDto);
					}while(rs.next());
					manageParcelShopPODUsersDtoInner.setAreaRegionList(areaRegionList);
				}
				}catch(Exception e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured while fetching users list : " + e.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}finally{
					log.debug("---------------------getAreaRegionList finally------------------------------------");
					CloseConnections.closeResultSet(rs);
					CloseConnections.closePreparedStatement(pStmt);
				}
				return manageParcelShopPODUsersDtoInner;
			}
			
			
		});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching deactivating/reactivating user : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		return manageParcelShopPODUsersDto;
	}

	//--------------------------------------------------------AUDIT LOG---------------------------------------------------------------------------------------
	
	/* 
	 * Method to save audit log data.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#manageParcelShopPODUsersSaveAuditLogDetails(com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersAuditDto)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersSaveAuditLogDetails(
			ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersAuditDto) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : manageParcelShopPODUsersSaveAuditLogDetails");
		
		ArrayList<String> auditSequenceNumbers = new ArrayList<String>();
		ManageParcelShopPODUsersAuditDto return_manageParcelShopPODUsersAuditDto = new ManageParcelShopPODUsersAuditDto();
		
		Integer procedureResponse = -2;
		List<ManageParcelShopPODUserAuditDetails> finalParcelShopPODUserAuditList = new ArrayList<>();	
		ManageParcelShopPODUsersDto manageParcelShopPODUsersDto = new ManageParcelShopPODUsersDto();
		
		
		try {
			procedureResponse = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					ResultSet rs = null;
					PreparedStatement pst = null;
					for (ManageParcelShopPODUserAuditDetails parcelShopPODUserAdutiListObj : manageParcelShopPODUsersAuditDto.getAdminAuditDtoList()) {
						String sql = Constants.GET_AUDITLOG_SEQUENCE;
						 pst = connection.prepareStatement(sql);
						try {
							rs = pst.executeQuery(); 
							if(rs.next()){
								 Integer seq = rs.getInt(1);
								 auditSequenceNumbers.add(String.valueOf(seq));
								 parcelShopPODUserAdutiListObj.setSequence(seq);
								finalParcelShopPODUserAuditList.add(parcelShopPODUserAdutiListObj);
							}
						
						} catch (HibernateException e) {
							log.error("EXCEPTION TYPE :",e);
							throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
						}finally{
							log.debug("---------------------manageParcelShopPODUsersSaveAuditLogDetails finally------------------------------------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closePreparedStatement(pst);
						}
						
					}
					
					Integer procedureResponse = -1;
					ManageParcelShopPODUserAuditDetails[] logValues = finalParcelShopPODUserAuditList.toArray(new ManageParcelShopPODUserAuditDetails[finalParcelShopPODUserAuditList.size()]);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor(Constants.UPROFILE4_AUDITLIST, connection);
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();
						  
							localMap.put(Constants.UPROFILE_AUDITOBJ,Class.forName(Constants.PARCELSHOP_POD_AUDIT_DETAILS_DTO));
						
						connection.setTypeMap(localMap);
						ARRAY auditLogArray = null;
						
							auditLogArray = new ARRAY(des, connection, logValues);
						
						
						callableStatement = connection.prepareCall(Constants.AUDIT_LOG_PROCEDURE);
						callableStatement.setArray(1, auditLogArray);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
						((OracleCallableStatement) callableStatement).executeUpdate();
						procedureResponse = callableStatement.getInt(2);
						
					}
					catch (Exception e) {
						log.error("EXCEPTION TYPE :",e);
						log.error("Exception Occured in manageParcelShopPODUsersSaveAuditLogDetails : "+e.getMessage());
					}finally {
						log.debug("---------------------manageParcelShopPODUsersSaveAuditLogDetails finally------------------------------------");
						CloseConnections.closePreparedStatement(pst);
					}
					return procedureResponse;
				}
			});
		} catch (Exception e) {
			log.error("EXCEPTION TYPE :",e);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		if(procedureResponse==0){
			return_manageParcelShopPODUsersAuditDto.setAuditingStatus(true);
			return_manageParcelShopPODUsersAuditDto.setSequenceNumbers(auditSequenceNumbers);
			return return_manageParcelShopPODUsersAuditDto;
		}
		manageParcelShopPODUsersDto.setParcelShopPODUserDeactivationReactivationStatus("For liferay audit log deactivate: FAIL");
		return_manageParcelShopPODUsersAuditDto.setAuditingStatus(false);
		return_manageParcelShopPODUsersAuditDto.setSequenceNumbers(auditSequenceNumbers);
		
		return return_manageParcelShopPODUsersAuditDto;
	}
	

	
	
	/* 
	 * Method to delete audit log data.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#deleteAuditLog(java.util.ArrayList)
	 */
	@Transactional
	@Override
	public ManageParcelShopPODUsersAuditDto deleteAuditLog(ArrayList<String> auditSequenceList) {
		
		log.debug("ManageParcelShopPODUsersDaoImpl : deleteAuditLog");

		
		ManageParcelShopPODUsersAuditDto manageParcelShopPODUsersAuditDto = new ManageParcelShopPODUsersAuditDto();
		String auditSequenceListString = auditSequenceList.toString();
	       
		auditSequenceListString = auditSequenceListString.replaceAll(Constants.STRING_RAND1, Constants.EMPTY_STRING).replaceAll(Constants.STRING_RAND2, Constants.EMPTY_STRING).replaceAll(Constants.STRING_RAND3, Constants.EMPTY_STRING);
		
		String[] auditSequenceListArray = auditSequenceListString.split(Constants.COMMA_DELIMETER);
		String sequences = Constants.EMPTY_STRING;
		for (String auditSequenceElement : auditSequenceListArray) {
			sequences = sequences +"'"+auditSequenceElement+"',";
		}
		sequences = sequences.substring(0, sequences.length()-1);
		
		try{
			String sql = Constants.DELETE_AUDIT_LOG_RECORDS_QUERY+sequences+")";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.executeUpdate();
			manageParcelShopPODUsersAuditDto.setAuditLogDetailsDeleted(true);
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Exception occured in deleting key : "+e.getMessage());
			manageParcelShopPODUsersAuditDto.setAuditLogDetailsDeleted(false);
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
		return manageParcelShopPODUsersAuditDto;
	}

	//-------------------------------------------------SEND EMAIL--------------------------------------------------------------------------------------------

	/* 
	 * Method to send email notifications.
	 * (non-Javadoc)
	 * @see com.bluedart.manageparcelshoppodusers.dao.ManageParcelShopPODUsersDao#sendEmailManageParcelShopPODUser(com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersNotificationsDto)
	 */
	@Override
	public String sendEmailManageParcelShopPODUser(ManageParcelShopPODUsersNotificationsDto manageParcelShopPODUsersNotificationsDto) {

		log.debug("ManageParcelShopPODUsersDaoImpl : sendEmailManageParcelShopPODUser");
		
		Boolean status = manageParcelShopPODUsersHelper.sendEmailNotification(manageParcelShopPODUsersNotificationsDto);
		if(status)
		{
			return Constants.EMAIL_SUCCESS;
		}
		else
		{
			return Constants.EMAIL_FAILURE;
		}
		
	}
	
	
	//--------------------------------------------------------------PRIVATE METHODS---------------------------------------------------------------------------
	
	
	/**
	 * Method to deactivate/reactivate parcel shop/POD user.
	 * @param loginId
	 * @param region
	 * @param userType
	 * @param enableFlag
	 * @param userAction
	 * @param podStatus
	 * @return
	 */
	@Transactional
	public Integer deactivateReactivateUser(String loginId, String[] region, String userType,
			String enableFlag,String userAction,String podStatus,String password)
	{
		
		log.debug("ManageParcelShopPODUsersDaoImpl : deactivateReactivateUser");
		
		Integer userActivationDeactivationStatus = null;
		try{
		userActivationDeactivationStatus = getSession().doReturningWork(new ReturningWork<Integer>(){
			CallableStatement callableStatement = null;
			@Override
			public Integer execute(Connection connection) throws SQLException {
				Integer userActivationDeactivationStatusInner = null;
				try{
					Map<String, Class<?>> map = connection.getTypeMap();
					connection.setTypeMap(map);
				
					
					callableStatement = connection.prepareCall(Constants.DEACTIVATE_REACTIVATE_PARCELSHOP_POD_USER_PROCEDURE);
					ArrayDescriptor des = ArrayDescriptor.createDescriptor("UPROFILE4.GENERIC_VARCHAR_TYPE",connection);
					ARRAY arrayToPass = new ARRAY(des, connection, region);
					
					callableStatement.setString(1, loginId);
					((OracleCallableStatement) callableStatement).setARRAY(2, arrayToPass);
					callableStatement.setString(3, userType);
					callableStatement.setString(4, enableFlag);
					callableStatement.setString(5, Constants.MODULE_NAME_MANAGEPARCELSHOPPODUSERS);
					callableStatement.setString(6, userAction);
					callableStatement.setString(7, podStatus);//pod flag
					callableStatement.setString(8,password);
					((OracleCallableStatement) callableStatement).registerOutParameter(9, Types.NUMERIC);
					callableStatement.execute();
					
					userActivationDeactivationStatusInner = callableStatement.getInt(9);
					
				    }catch(Exception e)
					{
				    	log.error("EXCEPTION TYPE :",e);
						log.error("Error Occured deactivate user method : " + e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}
					finally {
						log.debug("---------------------deactivateReactivateUser finally------------------------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				return userActivationDeactivationStatusInner;
			}
			
		});
		}
		catch(Exception e)
		{
			log.error("EXCEPTION TYPE :",e);
			log.error("Error Occured while fetching deactivating/reactivating user : " + e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		
		return userActivationDeactivationStatus;
	}
	
	/**
	 * releaseResult
	 * @param resultSet
	 */
/*	private void releaseResult(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
			throw new DataBaseException();
		}
	}*/
	
}
