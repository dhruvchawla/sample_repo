package com.bluedart.manageuserCA.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bluedart.manageuserCA.daoImpl.ClientAdminDaoImpl;
import com.bluedart.manageuserCA.dto.CorporateCustomerDto;
import com.bluedart.manageuserCA.dto.RegisterDetailDto;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author PR334023 
 * To call database procedures in Corporate admin registration
 */
@Component
@PropertySource("classpath:corporateAdmin.properties")
public class RegistrationDaoImpl {
	private static final Logger logger = Logger.getLogger(ClientAdminDaoImpl.class);

	
	@Autowired
	private Environment environment;
	
	/**
	 * To insert user details into login_t
	 * @param session
	 * @param registerDetailDto
	 * @return
	 * @throws CustomerRegistrationServiceException
	 */
	public int insertToLogin(Session session,RegisterDetailDto registerDetailDto){
		logger.info(" RegistrationDBHandler : insertToLogin ");
		Integer procedureCallResponse;
		
		try {
			procedureCallResponse = session.doReturningWork(new ReturningWork<Integer>() {
			CallableStatement callableStatement = null;

			@Override
			public Integer execute(Connection connection) throws SQLException {
				try {
					Integer procedureCallResponse = 0;
					String procedureCall = "{ call uprofile4.admin_corporate.newUser(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

					callableStatement = connection.prepareCall(procedureCall);
					callableStatement.setString(1,registerDetailDto.getLoginId());
					callableStatement.setLong(2,registerDetailDto.getUserId());
					callableStatement.setString(4,registerDetailDto.getOrgPassword());
					callableStatement.setString(3,registerDetailDto.getPassword());
					callableStatement.setLong(5,registerDetailDto.getDbId());
					callableStatement.setString(6,registerDetailDto.getMachineId());
					callableStatement.setInt(7,registerDetailDto.getBadSignonCount());
					callableStatement.setString(8,registerDetailDto.getClientAdminId());
					callableStatement.setInt(9, registerDetailDto.getNoOfUsers());
					callableStatement.setString(10, registerDetailDto.getPonlineFlag());
					callableStatement.setString(11, registerDetailDto.getPartPayFlag());
					callableStatement.setString(12, registerDetailDto.getRateDisplayFlag());
					callableStatement.setString(13, registerDetailDto.getSpickupPayonline());
					callableStatement.setInt(14, registerDetailDto.getSdAwbqty());
					callableStatement.setString(15,registerDetailDto.getSdQtyUsageChk());
					ArrayDescriptor localArrayDescriptor = ArrayDescriptor
							.createDescriptor(environment.getProperty("FEATUREINLIST"),connection);
					List<Integer> featureIdList = new ArrayList<>();
					for (Integer featureId : registerDetailDto.getFeatureIdList()) {
						featureIdList.add(featureId);
					}
					Integer[] featureIds = new Integer[featureIdList.size()];
					for (int i = 0; i < featureIdList.size(); i++) {
						if (featureIdList.get(i) != null) {
							featureIds[i] = featureIdList.get(i);
						}
					}
					ARRAY arrayValues = new ARRAY(localArrayDescriptor, connection,featureIds);
					callableStatement.setArray(16, arrayValues);
					callableStatement.registerOutParameter(17, Types.NUMERIC);
					callableStatement.execute();
					procedureCallResponse = callableStatement.getInt(17);

					return procedureCallResponse;
				}
				finally {
					logger.debug("------------------------getAffiliates finally-----------------------");
				
					CloseConnections.closeCallableStatement(callableStatement);
				}
			}
		});
		}catch(DataBaseException cuException)	{
			logger.error("EXCEPTION TYPE :",cuException);
			//logger.error(" RegistrationDBHandler : insertToLogin "+cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.info(" RegistrationDBHandler : insertToLogin "
				+ procedureCallResponse);
		return procedureCallResponse;
	}

	/**
	 * To register corporate customer in USER_T
	 * 
	 * @param session
	 * @param corporateCustomerDto
	 * @return
	 * @throws CustomerRegistrationServiceException
	 */
	public Long registerCorporateCustomer(Session session,CorporateCustomerDto corporateCustomerDto){
		logger.info(" RegistrationDBHandler : registerCorporateCustomer ");
		Long procedureCallResponse;
		
		try {
			procedureCallResponse = session.doReturningWork(new ReturningWork<Long>() {
			CallableStatement callableStatement = null;

			@Override
			public Long execute(Connection connection)
					throws SQLException {
				try {
					long procedureCallResponse = 0;
					String procedureCall = "{call uprofile4.admin_corporate.insertuser_registration(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					callableStatement = connection.prepareCall(procedureCall);
					callableStatement.clearParameters();
					callableStatement.setString(1,corporateCustomerDto.getFirstName()
									.toUpperCase());
					callableStatement.setString(2, corporateCustomerDto.getCcustomerCode());
					callableStatement.setString(3,Constants.CORP_USERTYPE);
					callableStatement.setInt(4, Integer.parseInt(environment.getProperty("dbDownload")));
					callableStatement.setInt(5,Integer.parseInt(environment.getProperty("no_of_affiliates")));
					callableStatement.setString(6,corporateCustomerDto.getAddr1());
					callableStatement.setString(7,corporateCustomerDto.getAddr2());
					callableStatement.setString(8,corporateCustomerDto.getLandmark());
					callableStatement.setString(9,corporateCustomerDto.getPinCode());
					callableStatement.setString(10,corporateCustomerDto.getEmailId().toLowerCase());
					callableStatement.setString(11,corporateCustomerDto.getPhone());
					callableStatement.setString(12,corporateCustomerDto.getFax());
					callableStatement.setString(13,Constants.UNREG_CORP_ADMIN);
					callableStatement.setString(14,corporateCustomerDto.getMode_of_shipment());
					callableStatement.setLong(15,Long.parseLong(environment.getProperty("no_of_shipments")));
					callableStatement.setString(16,corporateCustomerDto.getCity());
					callableStatement.setString(17,corporateCustomerDto.getCustomerArea());
					callableStatement.setString(18, null);
					callableStatement.registerOutParameter(19,Types.LONGNVARCHAR); // userId
					callableStatement.execute();
					procedureCallResponse = callableStatement.getInt(19);
					return procedureCallResponse;
				}
				finally {
					logger.debug("------------------------registerCorporateCustomer finally-----------------------");
					
					CloseConnections.closeCallableStatement(callableStatement);
				}
			 }
			});
		}catch(DataBaseException cuException)	{
			logger.error("EXCEPTION TYPE :",cuException);
			//logger.error(" RegistrationDBHandler : registerCorporateCustomer "+cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		logger.info(" RegistrationDBHandler : registerCorporateCustomer "
				+ procedureCallResponse);
		return procedureCallResponse;
	}
}