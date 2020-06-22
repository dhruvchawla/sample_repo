/**
 * 
 */
package com.bluedart.autopod.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RA848436
 *
 */
public class AutoPodDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1891562823072610371L;
	private String spReturnCode ;
	private String spReturnMsg ;
	private String loginid ;
	private String emailid;
	private String frequency;
	private String reporttype;
	private String errorcode;
	private String sortBy ;
	private String sortOrder;
	private String errorMessage;
	private int runday ;
	private int pageSize ;
	private int pageNo ;
	private Date lastrundate ;
	 private String lastruntime ;
	 private int totalRecord;
	private String attachment;
	private String createdBy;
	/**
	 * @return the status
	 */
	/*public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}*/
	private String orgAreaCode;
	private String dstAreaCode ;
	private int afterInsertionReturnVal ;
	private List<PodMailObjDto> autoPodList = new ArrayList<PodMailObjDto>();
	//private int status;
	private String status;
	private String userlogind ;
	/**
	 * @return the status
	 */
	 public String getUserlogind() {
		return userlogind;
	}

	public void setUserlogind(String userlogind) {
		this.userlogind = userlogind;
	}
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}
	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	/**
	 * @return the reporttype
	 */
	public String getReporttype() {
		return reporttype;
	}
	/**
	 * @param reporttype the reporttype to set
	 */
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}
	/**
	 * @return the runday
	 */
	public int getRunday() {
		return runday;
	}
	/**
	 * @param runday the runday to set
	 */
	public void setRunday(int runday) {
		this.runday = runday;
	}
	/**
	 * @return the lastrundate
	 */
	public Date getLastrundate() {
		return lastrundate;
	}
	/**
	 * @param lastrundate the lastrundate to set
	 */
	public void setLastrundate(Date lastrundate) {
		this.lastrundate = lastrundate;
	}
	/**
	 * @return the lastruntime
	 */
	public String getLastruntime() {
		return lastruntime;
	}
	/**
	 * @param lastruntime the lastruntime to set
	 */
	public void setLastruntime(String lastruntime) {
		this.lastruntime = lastruntime;
	}
	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**
	 * @return the orgAreaCode
	 */
	public String getOrgAreaCode() {
		return orgAreaCode;
	}
	/**
	 * @param orgAreaCode the orgAreaCode to set
	 */
	public void setOrgAreaCode(String orgAreaCode) {
		this.orgAreaCode = orgAreaCode;
	}
	/**
	 * @return the dstAreaCode
	 */
	public String getDstAreaCode() {
		return dstAreaCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @param dstAreaCode the dstAreaCode to set
	 */
	public void setDstAreaCode(String dstAreaCode) {
		this.dstAreaCode = dstAreaCode;
	}
	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}
	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	/**
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return sortOrder;
	}
	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	

	/**
	 * @return the afterInsertionReturnVal
	 */
	public int getAfterInsertionReturnVal() {
		return afterInsertionReturnVal;
	}
	/**
	 * @return the status
	 */
	
	/**
	 * @param afterInsertionReturnVal the afterInsertionReturnVal to set
	 */
	public void setAfterInsertionReturnVal(int afterInsertionReturnVal) {
		this.afterInsertionReturnVal = afterInsertionReturnVal;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the autoPodList
	 */
	public List<PodMailObjDto> getAutoPodList() {
		return autoPodList;
	}
	/**
	 * @param autoPodList the autoPodList to set
	 */
	public void setAutoPodList(List<PodMailObjDto> autoPodList) {
		this.autoPodList = autoPodList;
	}
	/**
	 * @return the errorcode
	 */
	public String getErrorcode() {
		return errorcode;
	}
	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	/**
	 * @return the spReturnMsg
	 */
	public String getSpReturnMsg() {
		return spReturnMsg;
	}
	/**
	 * @param spReturnMsg the spReturnMsg to set
	 */
	public void setSpReturnMsg(String spReturnMsg) {
		this.spReturnMsg = spReturnMsg;
	}
	/**
	 * @return the spReturnCode
	 */
	public String getSpReturnCode() {
		return spReturnCode;
	}
	/**
	 * @param spReturnCode the spReturnCode to set
	 */
	public void setSpReturnCode(String spReturnCode) {
		this.spReturnCode = spReturnCode;
	}
	/**
	 * @return the status
	 */
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	
	

}
