package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManageParcelShopPODUsersAuditDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private List<ManageParcelShopPODUserAuditDetails> adminAuditDtoList;
	private Boolean auditingStatus;
	private List<String> sequenceNumbers;
	private Boolean auditLogDetailsDeleted;
	private String errorCode;
	private String errorMsg;
	/**
	 * @return the adminAuditDtoList
	 */
	public List<ManageParcelShopPODUserAuditDetails> getAdminAuditDtoList() {
		return adminAuditDtoList;
	}
	/**
	 * @param adminAuditDtoList the adminAuditDtoList to set
	 */
	public void setAdminAuditDtoList(List<ManageParcelShopPODUserAuditDetails> adminAuditDtoList) {
		this.adminAuditDtoList = adminAuditDtoList;
	}
	/**
	 * @return the auditingStatus
	 */
	public Boolean getAuditingStatus() {
		return auditingStatus;
	}
	/**
	 * @param auditingStatus the auditingStatus to set
	 */
	public void setAuditingStatus(Boolean auditingStatus) {
		this.auditingStatus = auditingStatus;
	}
	/**
	 * @return the sequenceNumbers
	 */
	public List<String> getSequenceNumbers() {
		return sequenceNumbers;
	}
	/**
	 * @param sequenceNumbers the sequenceNumbers to set
	 */
	public void setSequenceNumbers(List<String> sequenceNumbers) {
		this.sequenceNumbers = sequenceNumbers;
	}
	/**
	 * @return the auditLogDetailsDeleted
	 */
	public Boolean getAuditLogDetailsDeleted() {
		return auditLogDetailsDeleted;
	}
	/**
	 * @param auditLogDetailsDeleted the auditLogDetailsDeleted to set
	 */
	public void setAuditLogDetailsDeleted(Boolean auditLogDetailsDeleted) {
		this.auditLogDetailsDeleted = auditLogDetailsDeleted;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManageParcelShopPODUsersAuditDto [adminAuditDtoList=" + adminAuditDtoList + ", auditingStatus="
				+ auditingStatus + ", sequenceNumbers=" + sequenceNumbers + ", auditLogDetailsDeleted="
				+ auditLogDetailsDeleted + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}
	
}
