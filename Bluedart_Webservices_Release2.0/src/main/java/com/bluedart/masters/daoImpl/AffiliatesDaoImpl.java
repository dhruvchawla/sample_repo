package com.bluedart.masters.daoImpl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.masters.dao.AffiliatesDao;
import com.bluedart.masters.dto.AffiliatesDto;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;

@Repository
@PropertySource("classpath:procedure.properties")
public class AffiliatesDaoImpl extends BaseDaoImpl implements AffiliatesDao {

	
	private static final Logger logger = Logger.getLogger(AffiliatesDaoImpl.class); 
	@Autowired
	private Environment environment;
	
	private List<AffiliatesDto> affiliateslist = null;
	private AffiliatesDto affiliatesDto = null;
	
	@Override
	@Transactional()
	public AffiliatesDto getAffiliates(String loginId) {
		affiliateslist = new ArrayList<>();
		try {
			affiliatesDto = getSession().doReturningWork(new ReturningWork<AffiliatesDto>() {
				@Override
				public AffiliatesDto execute(Connection connection) throws SQLException {
					List<AffiliatesDto> afflist = null;
					affiliatesDto = new AffiliatesDto();
					CallableStatement callableStatement = null;
					try {
						Map<String, Class<?>> localMap = connection.getTypeMap();

						try {
							localMap.put(environment.getProperty("AFFOBJ"), Class.forName("com.bluedart.masters.dto.AffiliatesDto"));
						} catch (ClassNotFoundException e) {
							logger.error("ClassNotFound");
						}
						connection.setTypeMap(localMap);

						String procedurecall = "{call uprofile4.aff_mang.getAffiliates(?, ?, ?)}";

						callableStatement = connection.prepareCall(procedurecall);

						((OracleCallableStatement) callableStatement).setString(1, loginId);
						((OracleCallableStatement) callableStatement).setString(2, null);
						((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
								environment.getProperty("AFFLIST"));
						callableStatement.execute();

						Array affiliates = callableStatement.getArray(3);

						afflist = getAffiliateDetails(affiliates);
						affiliatesDto.setAffiliatesDtoList(afflist);
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}
					finally {
					logger.debug("--------------getAffiliates finally-------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return affiliatesDto;
				}
			});

		}catch(DataBaseException cuException)	{
			logger.error(cuException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return affiliatesDto;
	}
	
	
	private List<AffiliatesDto> getAffiliateDetails(Array affArray) throws SQLException {
		affiliateslist = new ArrayList<>();
		AffiliatesDto affiliatesDto = null;
		Object[] object = (Object[]) affArray.getArray();
		for (int i = 0; i < object.length; i++) {
			affiliatesDto = new AffiliatesDto();
			affiliatesDto = (AffiliatesDto) object[i];
			affiliateslist.add(affiliatesDto);
		}
		return affiliateslist;
	}
}