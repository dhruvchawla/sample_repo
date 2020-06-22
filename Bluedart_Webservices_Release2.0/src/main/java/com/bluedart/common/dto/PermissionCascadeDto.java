package com.bluedart.common.dto;

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
public class PermissionCascadeDto implements SQLData, Serializable{

 	private static final long serialVersionUID = -4218739635108876844L;
 	
	private String permissionName;
	private String permissionValue;
	private String permissionFlag;
	private String sql_type;

	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.PERMISSIONMPNGOBJ_CAS";
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
	
	public String getPermissionFlag() {
		return permissionFlag;
	}
	public void setPermissionFlag(String permissionFlag) {
		this.permissionFlag = permissionFlag;
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setPermissionName(paramSQLInput.readNString());
		setPermissionValue(paramSQLInput.readNString());	
		setPermissionFlag(paramSQLInput.readNString());
		setSql_type(typeName);
	}

	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getPermissionName());
	    paramSQLOutput.writeString(getPermissionValue());
	    paramSQLOutput.writeString(getPermissionFlag());
	}
	@Override
	public String toString() {
		return "PermissionCascadeDto [sql_type=" + sql_type
				+ ", permissionName=" + permissionName + ", permissionValue="
				+ permissionValue + ", permissionFlag=" + permissionFlag + "]";
	}

}
