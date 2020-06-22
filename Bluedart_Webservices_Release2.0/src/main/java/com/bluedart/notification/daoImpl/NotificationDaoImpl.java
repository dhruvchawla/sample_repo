package com.bluedart.notification.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.notification.dao.NotificationDao;
import com.bluedart.notification.dto.NotificationDto;
import com.bluedart.utils.Constants;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/*
 * @author CH848113
 * 
 * This Class is used to get the details for email notification details
 * and once the email is sent delete the email notification.
 *  
 */
@Repository
public class NotificationDaoImpl extends BaseDaoImpl implements NotificationDao {
	private static final Logger logger = Logger.getLogger(NotificationDaoImpl.class);
	 
	/*
	 * To get the Email Notification Logs details.
	 * @see com.bluedart.notification.dao.NotificationDao#getNotificationLog()
	 */
	@Transactional
	@Override
	public List<NotificationDto> getNotificationLog() {
		
		   List<NotificationDto> notifications = null ;
		try {
			
			notifications = getSession().doReturningWork(new ReturningWork<List<NotificationDto>>() {
				@Override
				public List<NotificationDto> execute(Connection connection) throws SQLException {
					
					
					CallableStatement callableStatement = null;
					
					List<NotificationDto> notificationsList = new ArrayList<>() ;
					 ResultSet resultSet =null;
					try{
					callableStatement = connection
							.prepareCall("{call UPROFILE4.PACK_MANAGEUSERS.GET_EMAILDETAILS(?, ?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).registerOutParameter(1,OracleTypes.CURSOR);
					((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
					callableStatement.execute();
					
                    resultSet = (ResultSet) callableStatement.getObject(1);
                    NotificationDto notificationDto = null;
                    
                    while (resultSet.next()) {
                    	notificationDto = new NotificationDto();
                    	notificationDto.setLogId(resultSet.getString("Logid"));
                    	notificationDto.setFromEmailId(resultSet.getString("from_id"));
                    	notificationDto.setToEmailId(resultSet.getString("to_id"));
                    	notificationDto.setCcEmailId(resultSet.getString("cc_id"));
                    	notificationDto.setModuleName(resultSet.getString("module_name"));
                    	notificationDto.setAction(resultSet.getString("action"));
                    	notificationDto.setModel(resultSet.getString("email_Values"));
                        notificationsList.add(notificationDto);
                   }
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}
					finally{
						logger.debug("---------------getNotificationLog finally--------------");
						CloseConnections.closeResultSet(resultSet);
						CloseConnections.closeCallableStatement(callableStatement);	
					}
                    return notificationsList;
				}
			});
		}
		catch (DataBaseException exception) {
			logger.error("EXCEPTION TYPE :",exception);
				logger.debug("Server down please try after some time.");
				throw new DataBaseException("Server down please try after some time.",Constants.DB_DOWN_ERROR_CODE);
		} 
		
		
		return notifications;
	}
		
		
	/*
	 * Delete the Notification Log
	 * @see com.bluedart.notification.dao.NotificationDao#deleteNotificationLog(java.lang.String)
	 */
	@Transactional
	@Override
	public int deleteNotificationLog(String logId){
		int returnValue = -1;
	try {
			
		returnValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					
					int returnValue = -1;
					CallableStatement callableStatement =null;
					try{
					callableStatement = connection
							.prepareCall("{call UPROFILE4.PACK_MANAGEUSERS.DELETE_EMAILDETAILS(?, ?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setString(1,logId);
					((OracleCallableStatement) callableStatement).registerOutParameter(2, Types.INTEGER);
					callableStatement.execute();
					
					returnValue = ((OracleCallableStatement) callableStatement).getInt(2);
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}
					finally{
					logger.debug("------------------deleteNotificationLog-----------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return returnValue;
				}
			});
		}
		catch (DataBaseException exception) {
			logger.error("EXCEPTION TYPE :",exception);
				logger.debug("Server down please try after some time.");
				throw new DataBaseException("Server down please try after some time.",Constants.DB_DOWN_ERROR_CODE);
		} 

		
		return returnValue;
	}	
		
	
}
