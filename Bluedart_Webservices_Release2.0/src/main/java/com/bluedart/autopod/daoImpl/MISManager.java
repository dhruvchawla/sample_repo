/* Company      : NetKraft Pvt Ltd
 * Project      : BlueDart
 * Module   	: API
 * Class Name 	: MISManager
 * Filename 	: MISManager.java
 * Created on	: March 20, 2001
 * Version	    : 1.0
 * Author       : Mitesh Saraf
 * Copyright    : This software contains confidential and proprietary information of
 *                NetKraft Pvt Ltd.
 */

package com.bluedart.autopod.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleCallableStatement;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.bluedart.common.util.CloseConnections;



public class MISManager {

	private static final Logger logger = Logger.getLogger(MISManager.class);

	public static int updateMIS(int featureId, String loginId, Session session) {
		
		//Session session = PODMAILScheduler.getSession();

		int result = 0;

		int count = session.doReturningWork(new ReturningWork<Integer>() {
			public Integer execute(Connection connection) throws SQLException {
				// in this current form, users must handle try/catches
				// themselves for proper resource release

				CallableStatement callableStatement = null;
				int result = 0;
				try{
				callableStatement = connection
						.prepareCall("{ call PkgMisReport.PrcUpdateFeature(?,?,?)}");
				callableStatement.clearParameters();
				((OracleCallableStatement) callableStatement).setInt(1,
						featureId);
				((OracleCallableStatement) callableStatement).setString(2,
						loginId);

				((OracleCallableStatement) callableStatement)
						.registerOutParameter(3, Types.INTEGER);

				callableStatement.execute();
				result = ((OracleCallableStatement) callableStatement)
						.getInt(3);
				}catch(Exception ex){
					logger.error("EXCEPTION TYPE :",ex);
			
				}
				finally{
					logger.debug("------------------updateMIS finally-------------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return result;
			}

		}

		);
		return count;

	}

	/*
	 * Function Name : updateDownloadFilesizeMIS Input parameters : loginId,
	 * filesize Output parameters : Errors -2, -1; Success 0 Description :
	 * Function to update the MIS records in the database based on loginid
	 */
	public static int updateDownloadFilesizeMIS(String loginId, long filesize,Session session) {

		//Session session = PODMAILScheduler.getSession();

		int result = 0;

		int count = session.doReturningWork(new ReturningWork<Integer>() {
			public Integer execute(Connection connection) throws SQLException {
				// in this current form, users must handle try/catches
				// themselves for proper resource release
				int result = 0;
				CallableStatement callableStatement = null;
				try{
				callableStatement = connection
						.prepareCall("{ call PkgMisReport.PrcUpdateDownloadFilesize(?,?,?)}");
				callableStatement.clearParameters();
				((OracleCallableStatement) callableStatement).setString(1,
						loginId);
				((OracleCallableStatement) callableStatement).setLong(2,
						filesize);

				((OracleCallableStatement) callableStatement)
						.registerOutParameter(3, Types.INTEGER);

				callableStatement.execute();
				result = ((OracleCallableStatement) callableStatement)
						.getInt(3);
				}catch(Exception ex){
					logger.error("EXCEPTION TYPE :",ex);
				}
				finally{
					logger.debug("------------------updateDownloadFilesizeMIS finally-------------------------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				return result;
			}

		}

		);
		return count;

	}

	/*public static int updateNonLoginMIS(int featureId, String emailid,
			String ip, String awbnos, String maildate) {
		int result = -2;
		ConnectionObj c = null;
		ConnectionManagerMin cm = null;
		Connection con = null;
		Statement stmt = null;

		try {
			cm = DbGlobal.getConnMgr(1); // hard coded - only 1 database
											// instance
			if (cm != null) {
				c = cm.getConnection();
				con = c.getConnection();
			}
			if (con == null) {
				System.out.println("Could not connect");
			} else {
				stmt = con.createStatement();
				if (ip.length() >= 50) {
					ip = ip.substring(0, 49);
				}
				String sql = "insert into detail_mis_log (featureid,cemailid,cip,access_date,access_time,cawbnos,maildate) values("
						+ featureId
						+ ",'"
						+ emailid
						+ "','"
						+ ip
						+ "',sysdate,to_char(sysdate,'hh:mi'),'"
						+ awbnos
						+ "','" + maildate + "')";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				stmt.close();
			}
		} catch (SQLException sqle) {
			result = -1;
			System.out.println("SQLException: " + sqle.getMessage());

		} finally {
			if (c != null) {
				cm.putConnection(c);
			}
			stmt = null;
			con = null;
			c = null;
			cm = null;
		}

		return result;
	}
*/
}
