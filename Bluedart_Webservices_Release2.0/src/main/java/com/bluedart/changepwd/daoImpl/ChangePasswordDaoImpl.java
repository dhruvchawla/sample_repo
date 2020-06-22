package com.bluedart.changepwd.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.changepwd.dao.ChangePasswordDao;
import com.bluedart.changepwd.dto.ChangePasswordResponseDto;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.entity.LoginMaster;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.PasswordUtil;

/**
 * Implementation class for Change Password functionality
 * @author PR334023
 */
@Repository
public class ChangePasswordDaoImpl extends BaseDaoImpl implements ChangePasswordDao {

	private static final Logger changePwdLogger = Logger.getLogger(ChangePasswordDaoImpl.class);

	@Autowired
	private PasswordUtil passwordUtil;
	
	@Autowired
	private MISLogDao misLogDao;
	
	/**
	 * @author PR334023
	 * @Description This method is used to change the user Password.
	 */
	@Override
	@Transactional
	public ChangePasswordResponseDto changePassword(ChangePasswordResponseDto changePwdDto){
		changePwdLogger.debug(" ChangePasswordDaoImpl : changePassword " + changePwdDto.getLogId() + " --- " + changePwdDto.getOldPassword() + " --- " + changePwdDto.getNewPassword());
		ChangePasswordResponseDto chResponseDto = new ChangePasswordResponseDto();		
		String procedureResult = "FAILURE";
		
		saveMIS(Constants.FEATURE_CORPORATE_CHANGE_PASSWORD, changePwdDto.getLogId());
		
		try {
			Integer returnValue;
			String encryptedOldPassword = passwordUtil.encryptPassword(changePwdDto.getOldPassword());
			String encryptedNewPassword = passwordUtil.encryptPassword(changePwdDto.getNewPassword());
			returnValue = getChangePassword(encryptedOldPassword,encryptedNewPassword,changePwdDto.getLogId());
			
			if (returnValue == 0) {
				procedureResult = "SUCCESS";
				
			} else if (returnValue == 1) {
				procedureResult = "EXISTS";
			}else if (returnValue == 3) {
				procedureResult = "FAILURE";
			}
		}catch(BlueDartException chException)	{
			changePwdLogger.error("EXCEPTION TYPE :",chException);
			
			changePwdLogger.error(chException);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		chResponseDto.setChangePwdResponse(procedureResult);
		return chResponseDto;
	}
	
	/**
	 * @param encryptedOldPassword
	 * @param encryptedNewPassword
	 * @param loginId
	 * @return
	 * Method to call change password procedure
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Integer  getChangePassword(String encryptedOldPassword,String encryptedNewPassword,String loginId) {
		changePwdLogger.debug("change password method");
		return getSession().doReturningWork(new ReturningWork<Integer>() {
			CallableStatement callableStatement = null;
			Integer returnValue =-2;
			@Override
			public Integer execute(Connection connection) throws SQLException {
			try {
				Integer val =0;
				callableStatement = connection.prepareCall("{call uprofile4.admin_corporate.changepassword_liferay(?,?,?,?)}");
				callableStatement.setString(1, loginId);
				callableStatement.setString(2, encryptedOldPassword);
				callableStatement.setString(3, encryptedNewPassword);
				callableStatement.registerOutParameter(4, Types.INTEGER);
				callableStatement.execute();
				val = callableStatement.getInt(4);
				return val;
			}
			catch(BlueDartException e) {
				changePwdLogger.error("EXCEPTION TYPE :",e);
				
				//changePwdLogger.error("Error Message : "+e);
				return returnValue;
			}
			finally{
				changePwdLogger.debug("----------------getChangePassword finally----------------");
				CloseConnections.closeCallableStatement(callableStatement);
			}
			}
		});
	}
	
	/**
	 * @author PR334023
	 * @Description Method to verify existing password for a given LoginId
	 *              (non-Javadoc)
	 * @see com.bluedart.dao.ChangePasswordDao#checkExistingPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	@Transactional
	public ChangePasswordResponseDto checkExistingPassword(String loginId, String oldPassword){
		changePwdLogger.debug(" ChangePasswordDaoImpl : checkExistingPassword ");
		ChangePasswordResponseDto chResponseDto = new ChangePasswordResponseDto();
		boolean isExisting = false;
		String encryptedOldPassword = passwordUtil.encryptPassword(oldPassword);
		try {
			Criteria criteria = getSession().createCriteria(LoginMaster.class);
			criteria.add(Restrictions.eq("loginID", loginId).ignoreCase());
			criteria.add(Restrictions.eq("password", encryptedOldPassword));
			LoginMaster loginRow = (LoginMaster) criteria.uniqueResult();
			if (loginRow != null) {
				chResponseDto.setUserId(loginRow.getUserID());
				isExisting = true;
			}
		} catch(BlueDartException exception)	{
			changePwdLogger.error("EXCEPTION TYPE :",exception);
			
			
			changePwdLogger.error("ChangePasswordDaoImpl : changePassword "+exception);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		chResponseDto.setOldPwdExisting(isExisting);
		return chResponseDto;
	}
	
	/**
	 * Method to save MIS log
	 * @param featureName
	 * @param loginId
	 * @return
	 */
	private boolean saveMIS(String featureName, String loginId) {
		boolean flag = false;
		try{
			flag = misLogDao.saveMIS(featureName, loginId);
		}catch(Exception exception){
			changePwdLogger.error("EXCEPTION TYPE :",exception);
			
			changePwdLogger.error("ChangePasswordDaoImpl : saveMIS  "+exception);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}
	
}