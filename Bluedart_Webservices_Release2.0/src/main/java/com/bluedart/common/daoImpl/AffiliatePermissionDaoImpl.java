package com.bluedart.common.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.Work;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.AffiliatePermissionDao;
import com.bluedart.common.dto.AffiliatePermissionDto;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.StringUtils;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

@Repository
@PropertySource("classpath:procedure.properties")
public class AffiliatePermissionDaoImpl extends BaseDaoImpl implements AffiliatePermissionDao {

	private static final Logger logger = Logger.getLogger(AffiliatePermissionDaoImpl.class);
	
	@Transactional
	@Override
	public List<AffiliatePermissionDto> getAffiliateLevelPermissions(String loginId, String areaCode,
			String customerCode, String permissionName) {
		
		List<AffiliatePermissionDto> affiliatePermissionDtos = new ArrayList<>();

		try {
			getSession().doWork(new Work() {
				@Override
				public void execute(Connection connection) {
					ResultSet permissionSet = null;
					CallableStatement callableStatement = null;
					try {
						String[] arrayOfModuleName = null;
						List<String> listOfModuleName = StringUtils.getListFromStringWithComma(permissionName);
						if (!StringUtils.isNullOrEmpty(listOfModuleName)) {
							arrayOfModuleName = listOfModuleName.toArray(new String[listOfModuleName.size()]);
						}

						ArrayDescriptor des = ArrayDescriptor.createDescriptor("UPROFILE4.GENERIC_VARCHAR_TYPE",
								connection);
						ARRAY permissionNameArrayToPass = new ARRAY(des, connection, arrayOfModuleName);

						 callableStatement = connection
								.prepareCall(Constants.GET_AFFILIATE_PERMISSION);
						((OracleCallableStatement) callableStatement).setString(1, loginId);
						((OracleCallableStatement) callableStatement).setString(2, areaCode);
						((OracleCallableStatement) callableStatement).setString(3, customerCode);
						((OracleCallableStatement) callableStatement).setArray(4, permissionNameArrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(5, OracleTypes.CURSOR);
						((OracleCallableStatement) callableStatement).registerOutParameter(6, OracleTypes.NUMBER);

						
						callableStatement.execute();
						permissionSet = (ResultSet) callableStatement.getObject(5);
						AffiliatePermissionDto affiliatePermissionDto = null;
						while (permissionSet.next()) {
							affiliatePermissionDto = new AffiliatePermissionDto();
							affiliatePermissionDto.setAreaCode(permissionSet.getString("AFF_AC"));
							affiliatePermissionDto.setCustomerCode(permissionSet.getString("AFF_CC"));
							if (permissionSet.getString(Constants.PERMISSION_NAME) != null)
								affiliatePermissionDto
										.setPermissionName(permissionSet.getString(Constants.PERMISSION_NAME));
							else
								affiliatePermissionDto
										.setPermissionName(permissionSet.getString(Constants.SUB_PERMISSION_NAME));

							affiliatePermissionDto
									.setPermissionValue(permissionSet.getString(Constants.PERMISSION_VALUE));
							affiliatePermissionDtos.add(affiliatePermissionDto);
						}
						
						
						
					} catch (Exception e) {
						logger.error("EXCEPTION TYPE :",e);
						
						
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("----------getAffiliateLevelPermissions finally---------");
						CloseConnections.closeResultSet(permissionSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			
			logger.info("----------getAffiliateLevelPermissions---------"+exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return affiliatePermissionDtos;
	}
}
