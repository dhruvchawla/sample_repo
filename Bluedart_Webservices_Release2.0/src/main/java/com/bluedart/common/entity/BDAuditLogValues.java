package com.bluedart.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BD_AUDIT_LOG_VALUES")
public class BDAuditLogValues {

    @Id
	
	@Column(name = "AUD_VALUEID")
	private int audValueId;
	
	@Column(name = "AUD_LOGID")
	private int  audLogId;
	
	@Column(name = "COLUMN_VALUE")
	private String columnValue;

	
	
	
	/**
	 * @return the audValueId
	 */
	public int getAudValueId() {
		return audValueId;
	}

	/**
	 * @param audValueId the audValueId to set
	 */
	public void setAudValueId(int audValueId) {
		this.audValueId = audValueId;
	}

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
	 * @return the columnValue
	 */
	public String getColumnValue() {
		return columnValue;
	}

	/**
	 * @param columnValue the columnValue to set
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	
	
	
}
