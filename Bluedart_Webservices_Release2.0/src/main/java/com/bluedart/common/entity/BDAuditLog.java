package com.bluedart.common.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BD_AUDIT_LOG")
public class BDAuditLog {

	
    @Id
	
	@Column(name = "AUD_LOGID")
	private int audLogId;
    
    @Column(name = "MOD_SEQ_NUMBER")
	private int modSeqNumber;
	
	@Column(name = "MODULE_NAME")
	private String moduleName;
	
	@Column(name = "TABLE_NAME")
	private String tableName;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "SCHEMA_NAME")
	private String schemaName;
	
	@Column(name = "LOG_DATE")
	private Date logDate;
	
	@Column(name = "LOGGED_BY")
	private String loggedBy;
	
	@Column(name = "LOGGED_TO")
	private String loggedTo;
	
	@OneToMany(mappedBy="audLogId")
	    private List<BDAuditLogValues> logValues;

	/**
	 * @return the audLogId
	 */
	public int getAudLogId() {
		return audLogId;
	}

	/**
	 * @param audLogId the audLogId to set
	 */
	public void setAudLogId(int audLogId) {
		this.audLogId = audLogId;
	}

	/**
	 * @return the modSeqNumber
	 */
	public int getModSeqNumber() {
		return modSeqNumber;
	}

	/**
	 * @param modSeqNumber the modSeqNumber to set
	 */
	public void setModSeqNumber(int modSeqNumber) {
		this.modSeqNumber = modSeqNumber;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the schemaName
	 */
	public String getSchemaName() {
		return schemaName;
	}

	/**
	 * @param schemaName the schemaName to set
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	/**
	 * @return the logDate
	 */
	public Date getLogDate() {
		return logDate;
	}

	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	/**
	 * @return the loggedBy
	 */
	public String getLoggedBy() {
		return loggedBy;
	}

	/**
	 * @param loggedBy the loggedBy to set
	 */
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}

	/**
	 * @return the loggedTo
	 */
	public String getLoggedTo() {
		return loggedTo;
	}

	/**
	 * @param loggedTo the loggedTo to set
	 */
	public void setLoggedTo(String loggedTo) {
		this.loggedTo = loggedTo;
	}

	/**
	 * @return the logValues
	 */
	public List<BDAuditLogValues> getLogValues() {
		return logValues;
	}

	/**
	 * @param logValues the logValues to set
	 */
	public void setLogValues(List<BDAuditLogValues> logValues) {
		this.logValues = logValues;
	}
	
	
	
}
