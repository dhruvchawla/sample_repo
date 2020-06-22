package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * 
 * @author PR334023
 *
 */
public class EmailNotifyValuesRecord implements SQLData, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sql_type;
	private String notify_name;
	private String notify_value;
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.EMAIL_VALUE_OBJ";
	}
	public String getNotify_name() {
		return notify_name;
	}
	public void setNotify_name(String notify_name) {
		this.notify_name = notify_name;
	}
	public String getNotify_value() {
		return notify_value;
	}
	public void setNotify_value(String notify_value) {
		this.notify_value = notify_value;
	}
	@Override
	public String toString() {
		return "EmailNotifyValuesRecord [notify_name=" + notify_name
				+ ", notify_value=" + notify_value + "]";
	}
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(getSql_type());
		setNotify_name(paramSQLInput.readNString());
		setNotify_value(paramSQLInput.readNString());
		
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
	    paramSQLOutput.writeString(getNotify_name());
	    paramSQLOutput.writeString(getNotify_value());
	}
	
	
}
