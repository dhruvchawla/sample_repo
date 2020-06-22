/**
 * 
 */
package com.bluedart.common.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @author CH851827
 *
 */
public class PermissionDto implements SQLData, Serializable, Comparable<PermissionDto>{

 	private static final long serialVersionUID = -4218739635108876844L;
 	
 	
 	private String sql_type;
	private String permissionName;
	private String permissionValue;
	

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
	}

	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeString(getPermissionName());
	    paramSQLOutput.writeString(getPermissionValue());
	}
	@Override
	public int compareTo(PermissionDto o) {
		return this.getPermissionName().compareTo(o.getPermissionName());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permissionName == null) ? 0 : permissionName.hashCode());
		result = prime * result
				+ ((permissionValue == null) ? 0 : permissionValue.hashCode());
		result = prime * result
				+ ((sql_type == null) ? 0 : sql_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionDto other = (PermissionDto) obj;
		if (permissionName == null) {
			if (other.permissionName != null)
				return false;
		} else if (!permissionName.equals(other.permissionName))
			return false;
		if (permissionValue == null) {
			if (other.permissionValue != null)
				return false;
		} else if (!permissionValue.equals(other.permissionValue))
			return false;
		if (sql_type == null) {
			if (other.sql_type != null)
				return false;
		} else if (!sql_type.equals(other.sql_type))
			return false;
		return true;
	}


}
