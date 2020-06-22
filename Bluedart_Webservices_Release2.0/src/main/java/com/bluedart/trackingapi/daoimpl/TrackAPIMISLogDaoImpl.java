package com.bluedart.trackingapi.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.TrackingAPIMIS_Log;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.trackingapi.dao.MISLogDao;

/**
 * 
 * @author DH839598
 *
 */

@Repository
@PropertySource("classpath:feature.properties")
public class TrackAPIMISLogDaoImpl extends BaseDaoImpl implements MISLogDao {

	private static final Logger logger = Logger.getLogger(TrackAPIMISLogDaoImpl.class);

	@Autowired
	Environment env;

	@Override
	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize) {
		logger.trace(" MISLogDaoImpl : saveDownloadedFileSizeMIS ");
		
		boolean isSaved = getSession().doReturningWork(new ReturningWork<Boolean>() {

			@Override
			public Boolean execute(Connection connection) throws SQLException {
				CallableStatement callableStatement = null;
				
				boolean isSaved = false;
				try{
				callableStatement = connection.prepareCall("{ call PkgMisReport.PrcUpdateDownloadFilesize(?,?,?)}");
				callableStatement.clearParameters();
				callableStatement.setString(1, loginId);
				callableStatement.setLong(2, filesize);
				callableStatement.registerOutParameter(3, Types.INTEGER);
				callableStatement.execute();

				int result = callableStatement.getInt(3);
				if (result == 0) {
					isSaved = true;
				}
				}catch(Exception exception){
					logger.error("EXCEPTION TYPE :",exception);
				}
				finally{
					 logger.debug("---------saveDownloadedFileSizeMIS finally-----------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return isSaved;
			}
		});
		logger.trace(" MISLogDaoImpl : saveDownloadedFileSizeMIS " + isSaved);
		return isSaved;
	}

	@Override
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
			boolean isSaved = false;
		if (!StringUtils.isEmpty(ip)) {

			int featureId = Integer.parseInt(env.getProperty(featureName));

			TrackingAPIMIS_Log log = new TrackingAPIMIS_Log();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateFormatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String sql = "select sysdate from dual";
			Object dateObj = (Object) getSession().createSQLQuery(sql).uniqueResult();
			try {
				java.util.Date dateTime = dateFormatTime.parse(dateObj.toString());
				SimpleDateFormat dateFormatTimeStr = new SimpleDateFormat("HH:mm");
				String time = dateFormatTimeStr.format(dateTime);

				java.util.Date date = dateFormat.parse(dateObj.toString());
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				log.setAccessDate(sqlDate);
				log.setAccessTime(time);

				log.setFeatureId(featureId);
				log.setEmailId(emailId);
				log.setIp(ip);
				log.setAwbNos(awbnos);
				log.setMailDate(maildate);
				getSession().save(log);
				
				isSaved = true;

			} catch (ParseException exception) {
				logger.error("EXCEPTION TYPE :",exception);
				//logger.error(exception);
				throw new BlueDartException();
			} finally {
				logger.debug("---------saveMISWithOutLogin finally-----------");
			}
		}
		logger.info(" MISLogDaoImpl : saveMISWithOutLogin " + isSaved);
		return isSaved;
	}

	@Override
	public boolean saveMIS(String featureName, String loginId) {
		logger.trace(" MISLogDaoImpl : saveMIS ");
		
		int featureId = Integer.parseInt(env.getProperty(featureName));

		boolean isSaved;
		try {
			isSaved = getSession().doReturningWork(new ReturningWork<Boolean>() {

				@Override
				public Boolean execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					boolean isSaved = false;
					try{
					callableStatement = connection.prepareCall("{ call PkgMisReport.PrcUpdateFeature(?,?,?)}");
					callableStatement.clearParameters();
					callableStatement.setInt(1, featureId);
					callableStatement.setString(2, loginId);
					callableStatement.registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();

					int result = callableStatement.getInt(3);
					if (result == 0) {
						isSaved = true;
					}
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}finally{
						logger.debug("---------saveMIS finally-----------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return isSaved;
				}
			});
		} finally {
		}
		logger.info(" MISLogDaoImpl : saveMIS " + isSaved);
		return isSaved;
	}
}
