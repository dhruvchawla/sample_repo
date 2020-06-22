package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * 
 * @author PR334023
 * DTO to get BlueDart admin details
 *
 */
public class AdminDetailDto  implements SQLData, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sql_type;
	private String cRegion;
	private String cEmpName;
	private String cEmplCode;
	private String cRoleName;
	private Integer cUserId;
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	public String getcRegion() {
		return cRegion;
	}
	public void setcRegion(String cRegion) {
		this.cRegion = cRegion;
	}
	public String getcEmpName() {
		return cEmpName;
	}
	public void setcEmpName(String cEmpName) {
		this.cEmpName = cEmpName;
	}
	public String getcEmplCode() {
		return cEmplCode;
	}
	public void setcEmplCode(String cEmplCode) {
		this.cEmplCode = cEmplCode;
	}
	public String getcRoleName() {
		return cRoleName;
	}
	public void setcRoleName(String cRoleName) {
		this.cRoleName = cRoleName;
	}
	public Integer getcUserId() {
		return cUserId;
	}
	public void setcUserId(Integer cUserId) {
		this.cUserId = cUserId;
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(typeName);
		setcRegion(paramSQLInput.readNString());
		setcEmpName(paramSQLInput.readNString());
		setcEmplCode(paramSQLInput.readNString());
		setcRoleName(paramSQLInput.readNString());
		setcUserId(paramSQLInput.readInt());
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		
	}
}