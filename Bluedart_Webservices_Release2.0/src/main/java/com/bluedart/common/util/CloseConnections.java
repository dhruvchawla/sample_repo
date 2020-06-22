package com.bluedart.common.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.ScrollableResults;

import oracle.jdbc.driver.OracleConnection;
/*
 * @author CH848113 
 */

public class CloseConnections {
	private static final Logger logger = Logger.getLogger(CloseConnections.class);

	
	
	//Closing the CallableStatement
	public static void closeCallableStatement(CallableStatement callableStatement){
		if(null != callableStatement){
			try {
				callableStatement.close();
				callableStatement = null;
				logger.debug("-----------------Closeing Callable Statement-----------------");
			} catch (SQLException e) {
				logger.info("-----------------Exception while Closeing Callable Statement-----------------");
			}
		}
		
	}
	//Closing the ResultSet
	public static void closeResultSet(ResultSet resultSet){
		if(null != resultSet){
			try {
				resultSet.close();
				resultSet = null;
				logger.debug("-----------------Closeing ResultSet-----------------");
			} catch (SQLException e) {
				logger.info("-----------------Exception while Closeing ResultSet-----------------");
			}
		}
		
	}
	
	//Closing the ScrollableResults
	public static void closeScrollableResults(ScrollableResults resultSet){
		if(null != resultSet){
				resultSet.close();
				resultSet = null;
				logger.debug("-----------------Closeing Scrollable Results-----------------");
		}	
	}
	
	//Closing the PreparedStatement
	public static void closePreparedStatement(PreparedStatement preparedStatement){
		if(null != preparedStatement){
			try {
				preparedStatement.close();
				preparedStatement = null;
				logger.debug("-----------------Closeing Prepared Statement-----------------");
			} catch (SQLException e) {
				logger.info("-----------------Exception while Closeing Prepared Statement-----------------");
			}
		}
		
	}
	
	//Closing the OracleConnection
	public static void closeOracleConnection(OracleConnection oracleConnection){
		if(null != oracleConnection){
			try {
				oracleConnection.close();
				oracleConnection = null;
				logger.debug("-----------------Closeing Oracle Connection-----------------");
			} catch (SQLException e) {
				logger.info("-----------------Exception while Closeing Oracle Connection-----------------");
			}
			
		}
		
	}

}
