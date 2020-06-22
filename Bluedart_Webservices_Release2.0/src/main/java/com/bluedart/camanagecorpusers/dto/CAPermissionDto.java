package com.bluedart.camanagecorpusers.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * DTO for client admin permissions
 * @author PR334023
 *
 */
public class CAPermissionDto implements SQLData, Serializable {
	
	private static final long serialVersionUID = -4218739635108876844L;
 	
 	
 	private String sql_type;
	private String permissionName;
	private String permissionValue;
	private String permissionLabel;
	private String fieldType;
	
	public String getPermissionLabel() {
		return permissionLabel;
	}
	public void setPermissionLabel(String permissionLabel) {
		this.permissionLabel = permissionLabel;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.PERMISSIONMPNGOBJ";
	}
    
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionValue() {
		return permissionValue;
	}
	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setPermissionName(paramSQLInput.readNString());
		setPermissionValue(paramSQLInput.readNString());	
		setPermissionLabel(paramSQLInput.readNString());
		setFieldType(paramSQLInput.readNString());
	}

	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getPermissionName());
	    paramSQLOutput.writeString(getPermissionValue());
	    paramSQLOutput.writeString(getPermissionLabel());
	    paramSQLOutput.writeString(getFieldType());
	}
}
