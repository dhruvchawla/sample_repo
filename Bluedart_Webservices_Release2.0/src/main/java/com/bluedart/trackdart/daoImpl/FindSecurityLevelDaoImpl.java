package com.bluedart.trackdart.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.trackdart.dao.FindSecurityLevelDao;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;

/**
 * 
 * @author DH839598
 *
 */

@Repository
public class FindSecurityLevelDaoImpl extends BaseDaoImpl implements FindSecurityLevelDao {

	private static final Logger findSecuritylogger = Logger.getLogger(FindSecurityLevelDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.dao.FindSecurityLevelDao#findSecurityLevel(java.lang.String)
	 */
	@Transactional
	@Override
	public int findSecurityLevel(String loginId) {
		findSecuritylogger.debug(" FindSecurityLevelDaoImpl : findSecurityLevel");
		int secLevel = -1;
		try {
			secLevel = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					int secLevel = 0;
					
					try{
						callableStatement = connection.prepareCall("{ call admin.getsecuritylevel(?,?)}");
					
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).setString(1, loginId);
					((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
					callableStatement.execute();

					secLevel = ((OracleCallableStatement) callableStatement).getInt(2);
					
					return secLevel;
					}catch(Exception exception){
						findSecuritylogger.error("EXCEPTION TYPE :",exception);
						findSecuritylogger.error("----------findSecurityLevel---------"+exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
	
					}finally{
						findSecuritylogger.debug("----------findSecurityLevel finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});

		} catch (Exception exception) {
			findSecuritylogger.error("EXCEPTION TYPE :",exception);
			//findSecuritylogger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return secLevel;
	}
}
