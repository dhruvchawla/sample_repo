package com.bluedart.common.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.entity.MIS_Log;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */

@Repository
@PropertySource("classpath:feature.properties")
public class MISLogDaoImpl extends BaseDaoImpl implements MISLogDao {

	private static final Logger logger = Logger.getLogger(MISLogDaoImpl.class);

	@Autowired 
	Environment env;

	@Transactional
	@Override
	public boolean saveDownloadedFileSizeMIS(String loginId, long filesize) {
		logger.debug(" MISLogDaoImpl : saveDownloadedFileSizeMIS ");
		boolean isSaved = false;
		try{
		isSaved = getSession().doReturningWork(new ReturningWork<Boolean>() {

			@Override
			public Boolean execute(Connection connection) throws SQLException {
				CallableStatement callableStatement = null;
				boolean isSaved1 = false;
				try {
					callableStatement = connection.prepareCall("{ call PkgMisReport.PrcUpdateDownloadFilesize(?,?,?)}");
					callableStatement.clearParameters();
					callableStatement.setString(1, loginId);
					callableStatement.setLong(2, filesize);
					callableStatement.registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();

					int result = callableStatement.getInt(3);
					if (result == 0) {
						isSaved1 = true;
					}
					
					
				} catch (Exception exception) {
					logger.error("EXCEPTION TYPE :",exception);
					
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
							ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}finally{
					logger.debug("---------saveDownloadedFileSizeMIS finally---------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return isSaved1;

			}

		});
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			
			
			logger.error("saveDownloadedFileSizeMIS exception---------");
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return isSaved;
	}

	@Transactional
	@Override
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		logger.debug(" MISLogDaoImpl : saveMISWithOutLogin ");
		boolean isSaved = false;
		if (!StringUtils.isEmpty(ip)) {
			logger.info("MIS LOG Without Login FeatureName :"+featureName+":IP Address:"+ip);
			MIS_Log mislog = null;
			SimpleDateFormat dateFormatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateFormatTimeStr = new SimpleDateFormat("HH:mm");
			int maxLength =2000;
			int minLength = 0;

			try {
				mislog = new MIS_Log();
				// to get 2017-05-26 08:56
				String date = dateFormatTime.format(new Date());

				// To get Time 08:56
				java.util.Date dateTime = dateFormatTime.parse(date);
				String time = dateFormatTimeStr.format(dateTime);

				// To get Date 26-MAY-17
				Date date1 = dateFormat.parse(date);
				java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

				mislog.setAccessDate(sqlDate);
				mislog.setAccessTime(time);
				mislog.setFeatureId(Integer.parseInt(env.getProperty(featureName)));
				mislog.setEmailId(emailId);
				mislog.setIp(ip);
				if(awbnos!= null && !(awbnos.isEmpty())&& awbnos.length()>=maxLength){
					awbnos = awbnos.substring(minLength,maxLength);
				}
				mislog.setAwbNos(awbnos);
				mislog.setMailDate(maildate);
				getSession().save(mislog);
				isSaved = true;

			} catch (Exception exception) {
				logger.error("EXCEPTION TYPE :",exception);
				
				//getSession().getTransaction().rollback();
				logger.error("saveMISWithOutLogin exception---------");
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
						ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}
		}
		return isSaved;
	}

	@Transactional
	@Override
	public boolean saveMIS(String featureName, String loginId) {
		logger.debug(" MISLogDaoImpl : saveMIS ");

		int featureId = Integer.parseInt(env.getProperty(featureName));

		boolean isSaved;
		try {
			isSaved = getSession().doReturningWork(new ReturningWork<Boolean>() {
				
				boolean isSaved = false;
				@Override
				public Boolean execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
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
								
						logger.error("---------saveMIS Exception---------");
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("---------saveMIS finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return isSaved;
				}
			});
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			
			logger.error("---------saveMIS Exception---------");
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return isSaved;
	}

}
