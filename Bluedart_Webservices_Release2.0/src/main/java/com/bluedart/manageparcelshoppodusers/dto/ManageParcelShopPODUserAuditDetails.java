package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.sql.Timestamp;

public class ManageParcelShopPODUserAuditDetails implements SQLData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sql_type;
	private Integer sequence;
	private String loginId;
	private String moduleName;
	private String moduleAction;
	private String schemaName;
	private String tableName;
	private String columnName;
	private String oldValue;
	private String newValue;
	private Timestamp modifyDate;
	private String typeOfChange;
	private String cidMst;
	
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = "UPROFILE4.AUDITOBJ";
	}
	
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleAction() {
		return moduleAction;
	}
	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getTypeOfChange() {
		return typeOfChange;
	}
	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
	}
	public String getCidMst() {
		return cidMst;
	}
	public void setCidMst(String cidMst) {
		this.cidMst = cidMst;
	}
	
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(getSql_type());
		setSequence(paramSQLInput.readInt());
		setLoginId(paramSQLInput.readNString());
		setModuleName(paramSQLInput.readNString());
		setModuleAction(paramSQLInput.readNString());
		setSchemaName(paramSQLInput.readNString());
		setTableName(paramSQLInput.readNString());
		setColumnName(paramSQLInput.readNString());
		setOldValue(paramSQLInput.readNString());
		setNewValue(paramSQLInput.readNString());
		setModifyDate(paramSQLInput.readTimestamp());
		setTypeOfChange(paramSQLInput.readNString());
		setCidMst(paramSQLInput.readNString());
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeInt(getSequence());
		paramSQLOutput.writeString(getLoginId());
		paramSQLOutput.writeString(getModuleName());
		paramSQLOutput.writeString(getModuleAction());
		paramSQLOutput.writeString(getSchemaName());
		paramSQLOutput.writeString(getTableName());
		paramSQLOutput.writeString(getColumnName());
		paramSQLOutput.writeString(getOldValue());
		paramSQLOutput.writeString(getNewValue());
		paramSQLOutput.writeTimestamp(getModifyDate());
		paramSQLOutput.writeString(getTypeOfChange());
		paramSQLOutput.writeString(getCidMst());
	}
	
	
}
