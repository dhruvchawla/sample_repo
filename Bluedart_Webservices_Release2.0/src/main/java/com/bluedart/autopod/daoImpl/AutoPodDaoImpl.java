package com.bluedart.autopod.daoImpl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.autopod.dao.AutoPodDao;
import com.bluedart.autopod.dto.AutoPodDto;
import com.bluedart.autopod.dto.PodMailObjDto;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.exception.PodMailServiceException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;


@Repository
@PropertySource("classpath:procedure.properties")
public class AutoPodDaoImpl extends BaseDaoImpl implements AutoPodDao {
	private static final Logger autoPodlogger = Logger.getLogger(AutoPodDaoImpl.class);
	

	//private Session session = null;

	//@Autowired
	//private SessionFactory sessionFactory;

	@Autowired
	static Environment environment;

	private AutoPodDto dto = null;

	private List<PodMailObjDto> autoPodList = null;
	private ARRAY podMailArrayList =null;

	//Session session = getSession();

	/**
	 * 
	 * 
	 */
	/*
	 * @Transactional
	 * 
	 * @Override public AutoPodDto createAutoPod(AutoPodDto autoPodDto) {
	 * 
	 * Session session = PODMAILScheduler.getSession(); try{
	 * session.beginTransaction();
	 * 
	 * 
	 * AutoPodDto val = session.doReturningWork(new ReturningWork<AutoPodDto>()
	 * { public AutoPodDto execute(Connection connection) throws SQLException {
	 * // in this current form, users must handle try/catches // themselves for
	 * proper resource release dto = new AutoPodDto();
	 * 
	 * CallableStatement callableStatement; callableStatement = connection
	 * .prepareCall
	 * ("{ call UPROFILE4.AUTO_POD_PKG.AUTO_POD_INSERT_PRC(?,?,?,?,?,?,?)}");
	 * callableStatement.clearParameters(); ((OracleCallableStatement)
	 * callableStatement).setString(1, autoPodDto.getLoginid());
	 * ((OracleCallableStatement) callableStatement).setString(2,
	 * autoPodDto.getEmailid()); ((OracleCallableStatement)
	 * callableStatement).setString(3, autoPodDto.getFrequency());
	 * 
	 * ((OracleCallableStatement) callableStatement).setString(4,
	 * autoPodDto.getSortOrder()); ((OracleCallableStatement)
	 * callableStatement).setString(5, autoPodDto.getReporttype());
	 * ((OracleCallableStatement) callableStatement).setString(6, "I");
	 * 
	 * ((OracleCallableStatement) callableStatement) .registerOutParameter(7,
	 * Types.INTEGER);
	 * 
	 * callableStatement.execute(); int result = ((OracleCallableStatement)
	 * callableStatement) .getInt(7); dto.setAfterInsertionReturnVal(result);
	 * callableStatement.close(); if (connection != null) { connection.close();
	 * }
	 * 
	 * return dto; } }
	 * 
	 * ); } catch (Exception exception) { throw new
	 * PodMailServiceException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
	 * ErrorMessageStatusCode.DATABASE_DOWN.getDescription()); }
	 * 
	 * return dto; }
	 */

	/**
	 * New stored Prcedure
	 * 
	 */

	/**
	 * 
	 * 
	 */
	@Autowired
	private MISLogDao misLogDao;

	@Transactional
	@Override
	public AutoPodDto createPod(AutoPodDto autoPodDto) {
		autoPodlogger.debug(" AutoPodDaoImpl : createPod");
		//Session session = PODMAILScheduler.getSession();
		saveMIS(Constants.FEATURE_AUTOPOD, autoPodDto.getLoginid());
		
		try {
			//session.beginTransaction();

			//AutoPodDto val = session.doReturningWork(new ReturningWork<AutoPodDto>() {
						AutoPodDto val = getSession().doReturningWork(new ReturningWork<AutoPodDto>() {
						public AutoPodDto execute(Connection connection)
								throws SQLException {
							// in this current form, users must handle
							// try/catches
							// themselves for proper resource release
							dto = new AutoPodDto();

							CallableStatement callableStatement =  null;
							try{
							callableStatement = connection
									.prepareCall("{ call UPROFILE4.PACK_AUTOPOD.insertautopoduser(?,?,?,?,?,?,?,?,?,?,?)}");
							callableStatement.clearParameters();
							((OracleCallableStatement) callableStatement)
									.setString(1, autoPodDto.getLoginid());
							((OracleCallableStatement) callableStatement)
									.setString(2, autoPodDto.getEmailid());
							((OracleCallableStatement) callableStatement)
									.setString(3, autoPodDto.getReporttype());
							((OracleCallableStatement) callableStatement)
									.setString(4, "N");
							((OracleCallableStatement) callableStatement)
									.setString(5, autoPodDto.getSortOrder());
							((OracleCallableStatement) callableStatement)
									.setString(6, autoPodDto.getFrequency());

							((OracleCallableStatement) callableStatement)
									.setString(7, "ADD");
							((OracleCallableStatement) callableStatement)
							.setInt(8, 0);  //0->Active Record for 1st time Auto POD created.
							
						/*	Integer stastusInt= new Integer(autoPodDto.getStatus());
							((OracleCallableStatement) callableStatement)
							.setInt(8, stastusInt);//To be tested
						 */
							((OracleCallableStatement) callableStatement)
							.setString(9, autoPodDto.getCreatedBy());
							
							((OracleCallableStatement) callableStatement)
									.registerOutParameter(10, Types.VARCHAR);

							((OracleCallableStatement) callableStatement)
									.registerOutParameter(11, Types.VARCHAR);

							callableStatement.execute();
							String spReturnCode = ((OracleCallableStatement) callableStatement)
									.getString(10);
							String spReturnMsg = ((OracleCallableStatement) callableStatement)
									.getString(11);

							dto.setSpReturnMsg(spReturnMsg);
							dto.setSpReturnCode(spReturnCode);

							
							System.out.println("createAutoPod()"
									+ dto.getSpReturnMsg() + "     >>>>>>  "
									+ dto.getSpReturnCode());
							}catch(Exception e){
								autoPodlogger.error("EXCEPTION TYPE :",e);
								
							}
							finally{
								autoPodlogger.debug("------------------createPod finally-------------------------");
								CloseConnections.closeCallableStatement(callableStatement);
							}
							return dto;
						}
					}

					);
		} catch (Exception exception) {
			autoPodlogger.error("EXCEPTION TYPE :",exception);
			
			
			//System.out.println("" + exception.getMessage());
			throw new PodMailServiceException(
					ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		System.out.println("createAutoPod()" + dto.getSpReturnMsg()
				+ "     >>>>>>  " + dto.getSpReturnCode());
		return dto;
	}

	

	/**
 * 
 * 
 */
	/*
	 * @Transactional
	 * 
	 * @Override public AutoPodDto searchAutoPodEntry(AutoPodDto autoPodDto) {
	 * dto = new AutoPodDto(); Properties properties = new Properties(); try {
	 * properties.load(getClass().getClassLoader().getResourceAsStream(
	 * Constants.PROCEDURE_PROPERTIES)); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try{ Session session =
	 * PODMAILScheduler.getSession(); session.beginTransaction(); // AutoPodDto
	 * autoPodDto = null;
	 * 
	 * AutoPodDto val = session .doReturningWork(new ReturningWork<AutoPodDto>()
	 * { public AutoPodDto execute(Connection connection) throws SQLException {
	 * // in this current form, users must handle try/catches // themselves for
	 * proper resource release // AutoPodDto autoPodDto = new AutoPodDto();
	 * System.out.println("called"); Map<String, Class<?>> map =
	 * connection.getTypeMap(); try { map.put(properties
	 * .getProperty(Constants.PODMAIL_OBJ), Class
	 * .forName(Constants.PODMAIL_OBJ_DTO));
	 * 
	 * } catch (Exception exception) { // logger.error(exception);
	 * System.out.println("error"); } connection.setTypeMap(map);
	 * 
	 * CallableStatement callableStatement; callableStatement = connection
	 * .prepareCall
	 * ("{ call UPROFILE4.AUTO_POD_PKG.AUTO_POD_SEARCH_PRC(?,?,?,?,?,?)}");
	 * callableStatement.clearParameters(); ((OracleCallableStatement)
	 * callableStatement) .setString(1, autoPodDto.getLoginid());
	 * ((OracleCallableStatement) callableStatement) .setString(2,
	 * autoPodDto.getEmailid()); ((OracleCallableStatement)
	 * callableStatement).setInt(3, autoPodDto.getPageSize());
	 * 
	 * ((OracleCallableStatement) callableStatement).setInt(4,
	 * autoPodDto.getPageNo());
	 * 
	 * ((OracleCallableStatement) callableStatement) .registerOutParameter(5,
	 * Types.INTEGER);
	 * 
	 * ((OracleCallableStatement) callableStatement) .registerOutParameter(6,
	 * java.sql.Types.ARRAY, Constants.PODMAIL_LIST);
	 * 
	 * callableStatement.execute(); ARRAY podMailArrayList =
	 * ((OracleCallableStatement) callableStatement) .getARRAY(6);
	 * 
	 * if (podMailArrayList != null && podMailArrayList.length() != 0) {
	 * autoPodList = getPodMailDetails(podMailArrayList);
	 * dto.setAutoPodList(autoPodList);
	 * 
	 * }
	 * 
	 * callableStatement.close(); if (connection != null) { connection.close();
	 * } return dto; } }
	 * 
	 * ); } catch (Exception exception) { throw new
	 * PodMailServiceException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
	 * ErrorMessageStatusCode.DATABASE_DOWN.getDescription()); }
	 * 
	 * return dto; }
	 */

	/**
	 * 
	 * 
	 */


	@Transactional
	@Override
	public AutoPodDto searchPod(AutoPodDto autoPodDto) {
		
		autoPodlogger.debug(" AutoPodDaoImpl : searchPod");
		
		dto = new AutoPodDto();
		Properties properties = new Properties();
		saveMIS(Constants.FEATURE_AUTOPOD, autoPodDto.getLoginid());
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));

		} catch (IOException e) {
			
			autoPodlogger.error("EXCEPTION TYPE :",e);
			
			// TODO Auto-generated catch block
			throw new DataBaseException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			//e.printStackTrace();
		}
		try {
			//Session session = PODMAILScheduler.getSession();
			//session.beginTransaction();
			// AutoPodDto autoPodDto = null;
			AutoPodDto val = getSession().doReturningWork(new ReturningWork<AutoPodDto>() {
				@Override
						public AutoPodDto execute(Connection connection)
								throws SQLException {
						
							CallableStatement callableStatement = null;
							try{
							Map<String, Class<?>> map = connection.getTypeMap();
							try {
								map.put(properties
										.getProperty(Constants.PODMAIL_OBJ),Class.forName(Constants.PODMAIL_OBJ_DTO));

							} catch (Exception exception) {
								
								autoPodlogger.error("EXCEPTION TYPE :",exception);
								
								autoPodlogger.error(exception);
								System.out.println("error");
							}
							connection.setTypeMap(map);
                           String V_EMP_LOGIN_ID=autoPodDto.getUserlogind();
							String loginId = autoPodDto.getLoginid();
							if(loginId=="")
								loginId=null;
							String emailID =  autoPodDto.getEmailid();
							if(emailID=="")
								emailID= null;
							int pageSize = autoPodDto.getPageSize();
							if(pageSize == 0 )
								pageSize = 10;
							int pageNo =     autoPodDto.getPageNo() ;
							   if(pageNo ==0)
							     pageNo=1;
							String  status = autoPodDto.getStatus();
							  System.out.println("status is >>  "+status);
							System.out.println("status is "+ status);
							if (status == "")
								 status = null;
							  
							   String reportType =  autoPodDto.getReporttype();
							   System.out.println("reportType >>   "+reportType);
							   if (reportType == "")
								   reportType = null;
							
							
							callableStatement = connection
									.prepareCall("{ call UPROFILE4.PACK_AUTOPOD.AUTO_POD_SEARCH_PRC(?,?,?,?,?,?,?,?,?)}");
							callableStatement.clearParameters();
							((OracleCallableStatement) callableStatement)
									.setString(1, loginId);
							System.out.println("Log in Id is  >>"+loginId);
							((OracleCallableStatement) callableStatement).setString(2, emailID);
							System.out.println("Email Id is  >>"+emailID);
							((OracleCallableStatement) callableStatement)
									.setInt(3, pageSize);
							System.out.println("Page size  is  >>"+pageSize);
							((OracleCallableStatement) callableStatement)
									.setInt(4, pageNo);
							System.out.println("Page no  is  >>"+pageNo);
							status = autoPodDto.getStatus();
							 System.out.println("status  is null records are coming but for 0 and 1 we need to check with Ram>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> >>"+status);
							((OracleCallableStatement) callableStatement).setString(5,status);
					       
					       ((OracleCallableStatement) callableStatement).setString(6,reportType);
						    ((OracleCallableStatement) callableStatement).setString(7, V_EMP_LOGIN_ID );
		         	         System.out.println("report type  is  >>"+reportType);
							((OracleCallableStatement) callableStatement)
									.registerOutParameter(8, Types.INTEGER);
							((OracleCallableStatement) callableStatement)
									.registerOutParameter(9,java.sql.Types.ARRAY,Constants.PODMAIL_LIST);
							callableStatement.execute();
							podMailArrayList = ((OracleCallableStatement) callableStatement).getARRAY(9);

							int totalRecord = ((OracleCallableStatement) callableStatement).getInt(8);
							System.out.println("totalRecord from procedure :: "+totalRecord);
							System.out.println("podMailArrayList from proc :: "+podMailArrayList.length());
							dto.setTotalRecord(totalRecord);

							if (podMailArrayList != null && podMailArrayList.length() != 0) {
								autoPodList = getAutoPODList(podMailArrayList);
								System.out.println("autoPodList value is login ID "+ autoPodList.get(0).getLOGINID());
								dto.setAutoPodList(autoPodList);
								System.out.println("autoPodList>>>>>>>>>>>>>>>>"+autoPodList.size());

							}

							System.out.println("searchAutoPodEntry()    "
									+ dto.getTotalRecord());
							}catch(Exception exception){
								autoPodlogger.error("EXCEPTION TYPE :",exception);
								
							}
							
							finally{
								autoPodlogger.debug("------------------searchPod finally-------------------------");
								CloseConnections.closeCallableStatement(callableStatement);
							}
							return dto;
						}
					}

					);
		} catch (Exception exception) {
			
			autoPodlogger.error("EXCEPTION TYPE :",exception);
			
			
			System.out.println("inside catch block");
			throw new PodMailServiceException(
					ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		System.out.println("Total Records are     "
				+ dto.getTotalRecord());
		return dto;
	}
	

	/**
	 * 
	 * 
	 */
	/*
	 * @Transactional
	 * 
	 * @Override public AutoPodDto getAutoPodToEdit(AutoPodDto autoPodDto) {
	 * 
	 * Session session = PODMAILScheduler.getSession();
	 * 
	 * session.beginTransaction();
	 * 
	 * try{ AutoPodDto val = session.doReturningWork(new
	 * ReturningWork<AutoPodDto>() { public AutoPodDto execute(Connection
	 * connection) throws SQLException { // in this current form, users must
	 * handle try/catches // themselves for proper resource release dto = new
	 * AutoPodDto();
	 * 
	 * CallableStatement callableStatement; callableStatement = connection
	 * .prepareCall
	 * ("{ call UPROFILE4.AUTO_POD_PKG.AUTO_POD_INSERT_PRC(?,?,?,?,?,?,?)}");
	 * callableStatement.clearParameters(); ((OracleCallableStatement)
	 * callableStatement).setString(1, autoPodDto.getLoginid());
	 * ((OracleCallableStatement) callableStatement).setString(2,
	 * autoPodDto.getEmailid()); ((OracleCallableStatement)
	 * callableStatement).setString(3, autoPodDto.getFrequency());
	 * 
	 * ((OracleCallableStatement) callableStatement).setString(4,
	 * autoPodDto.getSortOrder()); ((OracleCallableStatement)
	 * callableStatement).setString(5, autoPodDto.getReporttype());
	 * ((OracleCallableStatement) callableStatement).setString(6, "U");
	 * 
	 * ((OracleCallableStatement) callableStatement) .registerOutParameter(7,
	 * Types.INTEGER);
	 * 
	 * callableStatement.execute(); int result = ((OracleCallableStatement)
	 * callableStatement) .getInt(7); dto.setAfterInsertionReturnVal(result);
	 * callableStatement.close(); if (connection != null) { connection.close();
	 * }
	 * 
	 * return dto; } }
	 * 
	 * ); } catch (Exception exception) { throw new
	 * PodMailServiceException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
	 * ErrorMessageStatusCode.DATABASE_DOWN.getDescription()); }
	 * 
	 * return dto;
	 * 
	 * }
	 */

	@Transactional
	@Override
	public AutoPodDto editPod(AutoPodDto autoPodDto) {
		autoPodlogger.debug(" AutoPodDaoImpl : editPod");
		saveMIS(Constants.FEATURE_AUTOPOD, autoPodDto.getLoginid());
		try {
		//Session session = PODMAILScheduler.getSession();
		
			//session.beginTransaction();
			//AutoPodDto val = session.doReturningWork(new ReturningWork<AutoPodDto>() {
			AutoPodDto val = getSession().doReturningWork(new ReturningWork<AutoPodDto>() {
						public AutoPodDto execute(Connection connection)
								throws SQLException {
							// in this current form, users must handle
							// try/catches
							// themselves for proper resource release
							dto = new AutoPodDto();

							CallableStatement callableStatement = null;
							try{
							callableStatement = connection
									.prepareCall("{ call UPROFILE4.PACK_AUTOPOD.insertautopoduser(?,?,?,?,?,?,?,?,?,?,?)}");
							callableStatement.clearParameters();
							((OracleCallableStatement) callableStatement)
									.setString(1, autoPodDto.getLoginid());
							System.out.println("login Id is"+autoPodDto.getLoginid());
							((OracleCallableStatement) callableStatement)
									.setString(2, autoPodDto.getEmailid());
							System.out.println("email id is"+autoPodDto.getEmailid());
							((OracleCallableStatement) callableStatement)
									.setString(3, autoPodDto.getReporttype());
							System.out.println("report type is"+autoPodDto.getReporttype());
							((OracleCallableStatement) callableStatement)
									.setString(4, "N");
							((OracleCallableStatement) callableStatement)
									.setString(5, autoPodDto.getSortOrder());
							System.out.println("sort order  is"+autoPodDto.getSortOrder());
							((OracleCallableStatement) callableStatement)
									.setString(6, autoPodDto.getFrequency());
							System.out.println("frequncy  is"+autoPodDto.getFrequency());
							((OracleCallableStatement) callableStatement)
									.setString(7, "EDIT");
							Integer status=null;
							String statusStr=autoPodDto.getStatus();
							//statusStr = null means record is active(0)
							if(statusStr ==null)
								((OracleCallableStatement) callableStatement).setInt(8, 0);
							else
							{
							System.out.println("statusStr is >>  " +statusStr);
							 status= new Integer(statusStr);
							System.out.println("status is  >> "+status);
							((OracleCallableStatement) callableStatement).setInt(8, status);
							}
							((OracleCallableStatement) callableStatement)
							.setString(9, autoPodDto.getCreatedBy());
							((OracleCallableStatement) callableStatement)
									.registerOutParameter(10, Types.VARCHAR);

							((OracleCallableStatement) callableStatement)
									.registerOutParameter(11, Types.VARCHAR);

							callableStatement.execute();
							String spReturnCode = ((OracleCallableStatement) callableStatement)
									.getString(10);
							String spReturnMsg = ((OracleCallableStatement) callableStatement)
									.getString(11);

							dto.setSpReturnMsg(spReturnMsg);
							dto.setSpReturnCode(spReturnCode);

							
							System.out.println("getAutoPodToEdit()"
									+ dto.getSpReturnMsg() + "     >>>>>>  "
									+ dto.getSpReturnCode());
							}catch(Exception exception){
								autoPodlogger.error("EXCEPTION TYPE :",exception);
								
							}
							finally{
								autoPodlogger.debug("------------------edit finally-------------------------");
								CloseConnections.closeCallableStatement(callableStatement);
							}
							return dto;
						}
					}

					);
		} catch (Exception exception) {
			autoPodlogger.error("EXCEPTION TYPE :",exception);
			
			
			
			System.out.println("" + exception.getMessage());
			throw new PodMailServiceException(
					ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		System.out.println("getAutoPodToEdit()" + dto.getSpReturnMsg()
				+ "     >>>>>>  " + dto.getSpReturnCode());
		return dto;
	}

	/**
	 * 
	 * 
	 */

	/*
	 * @Transactional
	 * 
	 * @Override public AutoPodDto deleteAutoPodToEntry(AutoPodDto autoPodDto) {
	 * 
	 * System.out.println(
	 * "Inside delete deleteAutoPodToEntry() of daoimpl od BDServices");
	 * 
	 * Session session = PODMAILScheduler.getSession();
	 * 
	 * session.beginTransaction();
	 * 
	 * try{ AutoPodDto val = session.doReturningWork(new
	 * ReturningWork<AutoPodDto>() { public AutoPodDto execute(Connection
	 * connection) throws SQLException { // in this current form, users must
	 * handle try/catches // themselves for proper resource release dto = new
	 * AutoPodDto();
	 * 
	 * CallableStatement callableStatement; callableStatement = connection
	 * .prepareCall
	 * ("{ call UPROFILE4.AUTO_POD_PKG.AUTO_POD_INSERT_PRC(?,?,?,?,?,?,?)}");
	 * callableStatement.clearParameters(); ((OracleCallableStatement)
	 * callableStatement).setString(1, autoPodDto.getLoginid());
	 * System.out.println("autoPodDto.getLoginid()  " +autoPodDto.getLoginid());
	 * System.out.println("autoPodDto.getReporttype()"
	 * +autoPodDto.getReporttype()); ((OracleCallableStatement)
	 * callableStatement).setString(2, autoPodDto.getEmailid());
	 * ((OracleCallableStatement) callableStatement).setString(3,
	 * autoPodDto.getFrequency());
	 * 
	 * ((OracleCallableStatement) callableStatement).setString(4,
	 * autoPodDto.getSortOrder()); ((OracleCallableStatement)
	 * callableStatement).setString(5, autoPodDto.getReporttype());
	 * ((OracleCallableStatement) callableStatement).setString(6, "D");
	 * 
	 * ((OracleCallableStatement) callableStatement) .registerOutParameter(7,
	 * Types.INTEGER);
	 * 
	 * callableStatement.execute(); int result = ((OracleCallableStatement)
	 * callableStatement) .getInt(7); dto.setAfterInsertionReturnVal(result);
	 * callableStatement.close(); if (connection != null) { connection.close();
	 * }
	 * 
	 * return dto; } }
	 * 
	 * ); } catch (Exception exception) { throw new
	 * PodMailServiceException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
	 * ErrorMessageStatusCode.DATABASE_DOWN.getDescription()); }
	 * 
	 * return dto;
	 * 
	 * }
	 */

	@Transactional
	@Override
	public AutoPodDto softDeletePod(AutoPodDto autoPodDto) {
		autoPodlogger.debug(" AutoPodDaoImpl : softDeletePod");
		saveMIS(Constants.FEATURE_AUTOPOD, autoPodDto.getLoginid());
		try {
		//Session session = PODMAILScheduler.getSession();
		
			//session.beginTransaction();
			//AutoPodDto val = session.doReturningWork(new ReturningWork<AutoPodDto>() {
			AutoPodDto val = getSession().doReturningWork(new ReturningWork<AutoPodDto>() {
						public AutoPodDto execute(Connection connection)
								throws SQLException {
							// in this current form, users must handle
							// try/catches
							// themselves for proper resource release
							dto = new AutoPodDto();

							CallableStatement callableStatement = null;
							try{
							callableStatement = connection
									.prepareCall("{ call UPROFILE4.PACK_AUTOPOD.insertautopoduser(?,?,?,?,?,?,?,?,?,?,?)}");
							callableStatement.clearParameters();
							((OracleCallableStatement) callableStatement)
									.setString(1, autoPodDto.getLoginid());
							System.out.println("login Id is"+autoPodDto.getLoginid());
							((OracleCallableStatement) callableStatement)
									.setString(2, autoPodDto.getEmailid());
							System.out.println("email id is"+autoPodDto.getEmailid());
							((OracleCallableStatement) callableStatement)
									.setString(3, autoPodDto.getReporttype());
							System.out.println("report type is"+autoPodDto.getReporttype());
							((OracleCallableStatement) callableStatement)
									.setString(4, "N");
							((OracleCallableStatement) callableStatement)
									.setString(5, autoPodDto.getSortOrder());
							System.out.println("sort order  is"+autoPodDto.getSortOrder());
							((OracleCallableStatement) callableStatement)
									.setString(6, autoPodDto.getFrequency());
							System.out.println("frequncy  is"+autoPodDto.getFrequency());
							((OracleCallableStatement) callableStatement)
									.setString(7, "DELETE");
							Integer status= new Integer(autoPodDto.getStatus());
							System.out.println("status is  >> "+status);
							((OracleCallableStatement) callableStatement).setInt(8, status);
							((OracleCallableStatement) callableStatement)
							.setString(9, autoPodDto.getCreatedBy());

							((OracleCallableStatement) callableStatement)
									.registerOutParameter(10, Types.VARCHAR);

							((OracleCallableStatement) callableStatement)
									.registerOutParameter(11, Types.VARCHAR);

							callableStatement.execute();
							String spReturnCode = ((OracleCallableStatement) callableStatement)
									.getString(10);
							String spReturnMsg = ((OracleCallableStatement) callableStatement)
									.getString(11);

							dto.setSpReturnMsg(spReturnMsg);
							dto.setSpReturnCode(spReturnCode);

							
							System.out.println("getAutoPodToEdit()"
									+ dto.getSpReturnMsg() + "     >>>>>>  "
									+ dto.getSpReturnCode());
							}catch(Exception exception){
								autoPodlogger.error("EXCEPTION TYPE :",exception);
								
								
							}
							finally{
								autoPodlogger.debug("------------------softDeletePod finally-------------------------");
								CloseConnections.closeCallableStatement(callableStatement);
							}
							return dto;
						}
					}

					);
		} catch (Exception exception) {
			
			autoPodlogger.error("EXCEPTION TYPE :",exception);
			
			
			System.out.println("" + exception.getMessage());
			throw new PodMailServiceException(
					ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		System.out.println("getAutoPodToEdit()" + dto.getSpReturnMsg()
				+ "     >>>>>>  " + dto.getSpReturnCode());
		return dto;
	
	}

	/**
	 * 
	 * 
	 * @param autoPodList
	 * @return
	 * @throws SQLException
	 */
	
	private static List<PodMailObjDto> getAutoPODList(ARRAY autoPodList)
			throws SQLException {
		List<PodMailObjDto> podList = new ArrayList<PodMailObjDto>();
		Object[] object = (Object[]) autoPodList.getArray();
		PodMailObjDto pODMAIL_OBJDto;
		for (int i = 0; i < autoPodList.length(); i++) {
			pODMAIL_OBJDto = new PodMailObjDto();
			pODMAIL_OBJDto = (PodMailObjDto) object[i];
			podList.add(pODMAIL_OBJDto);
		}
		System.out.println("getAutoPODList"+podList.size());
		return podList;
	}

	private boolean saveMIS(String featureName, String loginId) {
		boolean flag = false;
		try{
			flag = misLogDao.saveMIS(featureName, loginId);
			
		}catch(Exception exception){
			autoPodlogger.error("EXCEPTION TYPE :",exception);
			
			
			//autoPodlogger.error("AutoPodDaoImpl : saveMIS  "+exception);
			throw new BlueDartException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}

}
