package com.bluedart.pod.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class SpslistDTO implements SQLData, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql_type;
	private String spscode;
	private String spsname;
	private String carea;
	
	public String getCarea() {
		return carea;
	}
	public void setCarea(String carea) {
		this.carea = carea;
	}
	/**
	 * @return the sql_type
	 */
	public String getSql_type() {
		return sql_type;
	}
	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	/**
	 * @return the spscode
	 */
	public String getSpscode() {
		return spscode;
	}
	/**
	 * @param spscode the spscode to set
	 */
	public void setSpscode(String spscode) {
		this.spscode = spscode;
	}
	/**
	 * @return the spsname
	 */
	public String getSpsname() {
		return spsname;
	}
	/**
	 * @param spsname the spsname to set
	 */
	public void setSpsname(String spsname) {
		this.spsname = spsname;
	}
	
	

	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return sql_type;
	}
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		// TODO Auto-generated method stub
		
		setSql_type(getSql_type());
		setSpscode(paramSQLInput.readNString());
		setSpsname(paramSQLInput.readNString());
		setCarea(paramSQLInput.readNString());
	}
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
