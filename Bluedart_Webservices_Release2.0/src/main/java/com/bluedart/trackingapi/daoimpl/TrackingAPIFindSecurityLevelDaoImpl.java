package com.bluedart.trackingapi.daoimpl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.dao.TrackingAPIFindSecurityLevelDao;

import oracle.jdbc.OracleCallableStatement;

@Repository
public class TrackingAPIFindSecurityLevelDaoImpl extends BaseDaoImpl implements TrackingAPIFindSecurityLevelDao{
	
	private static final Logger logger = Logger.getLogger(TrackingAPIFindSecurityLevelDaoImpl.class);
	
	
	/**
	 * get sec level
	 */
	@Override
	public int findSecurityLevel(String loginId) {
	
		int sceLevel = 0;
		try {
			sceLevel =  findSecurityLevel(getSession(), loginId);
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new BlueDartException();
		} finally{
			logger.debug("-----Finally block of security level------");
		}
		return sceLevel;
	}
	
	/**
	 * 
	 * @param session
	 * @param loginId
	 * @return
	 * @throws IOException
	 */
	private Integer findSecurityLevel(Session session, String loginId ) throws IOException {
		logger.trace(" FindSecurityLevelDaoImpl ::: findSecurityLevel ");
		
		Integer secLevel = session.doReturningWork(new ReturningWork<Integer>() {
			@Override
			public Integer execute(Connection connection) throws SQLException {
				int secLevel = 0;
				CallableStatement callableStatement = null;
				try{
				callableStatement = connection.prepareCall("{ call admin.getsecuritylevel(?,?)}");
				callableStatement.clearParameters();
			
				((OracleCallableStatement) callableStatement).setString(1, loginId);
				((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
				 callableStatement.execute();
				
				 secLevel = ((OracleCallableStatement) callableStatement).getInt(2);
				}catch(Exception exception){
					logger.error("EXCEPTION TYPE :",exception);
				}finally{
					logger.debug("---------findSecurityLevel finally-----------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return secLevel;
			}
		});
		logger.info(" FindSecurityLevelDaoImpl ::: findSecurityLevel " + secLevel);
		return secLevel;
	}

}
