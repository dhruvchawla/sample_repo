package com.bluedart.internetdart.dto;

import java.io.Serializable;

/**
 * 
 * @author DH839598
 *
 */
public class SearchDto implements Serializable {
	
	private static final long serialVersionUID = 4130400076767979317L;
	
	private String custAff;
	private String dateFrom;
	private String dateTo;
	private String origin;
	private String dest;
	private String loginId;
	private Integer pageSize;
	private String sortBy;
	private String sortOrder;
	private String viewBy;
	private Integer reqScanFlag;
	private Integer reqAffiliatesFlag;
	private String prodCode;
	private String status;
	private Integer secLevel;	
	private String outputFlag;
	private Integer pageNo;
	private String downloadFlag;
	
	private String custCC;
	private String custAC;
	private String orgAreaCode;
	private String dstAreaCode;
	private java.sql.Date fromDate;
	private java.sql.Date toDate;
	
	private String destinationCountry;
	
	/**
	 * @return the custAff
	 */
	public String getCustAff() {
		return custAff;
	}
	/**
	 * @param custAff the custAff to set
	 */
	public void setCustAff(String custAff) {
		this.custAff = custAff;
	}
	/**
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * @return the dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @return the viewBy
	 */
	public String getViewBy() {
		return viewBy;
	}
	/**
	 * @param viewBy the viewBy to set
	 */
	public void setViewBy(String viewBy) {
		this.viewBy = viewBy;
	}
	/**
	 * @return the reqScanFlag
	 */
	public Integer getReqScanFlag() {
		return reqScanFlag;
	}
	/**
	 * @param reqScanFlag the reqScanFlag to set
	 */
	public void setReqScanFlag(Integer reqScanFlag) {
		this.reqScanFlag = reqScanFlag;
	}
	/**
	 * @return the reqAffiliatesFlag
	 */
	public Integer getReqAffiliatesFlag() {
		return reqAffiliatesFlag;
	}
	/**
	 * @param reqAffiliatesFlag the reqAffiliatesFlag to set
	 */
	public void setReqAffiliatesFlag(Integer reqAffiliatesFlag) {
		this.reqAffiliatesFlag = reqAffiliatesFlag;
	}
	/**
	 * @return the prodCode
	 */
	public String getProdCode() {
		return prodCode;
	}
	/**
	 * @param prodCode the prodCode to set
	 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	/**
	 * @return the status
	 */
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
	 * @return the secLevel
	 */
	public Integer getSecLevel() {
		return secLevel;
	}
	/**
	 * @param secLevel the secLevel to set
	 */
	public void setSecLevel(Integer secLevel) {
		this.secLevel = secLevel;
	}
	/**
	 * @return the outputFlag
	 */
	public String getOutputFlag() {
		return outputFlag;
	}
	/**
	 * @param outputFlag the outputFlag to set
	 */
	public void setOutputFlag(String outputFlag) {
		this.outputFlag = outputFlag;
	}
	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the downloadFlag
	 */
	public String getDownloadFlag() {
		return downloadFlag;
	}
	/**
	 * @param downloadFlag the downloadFlag to set
	 */
	public void setDownloadFlag(String downloadFlag) {
		this.downloadFlag = downloadFlag;
	}
	/**
	 * @return the custCC
	 */
	public String getCustCC() {
		return custCC;
	}
	/**
	 * @param custCC the custCC to set
	 */
	public void setCustCC(String custCC) {
		this.custCC = custCC;
	}
	/**
	 * @return the custAC
	 */
	public String getCustAC() {
		return custAC;
	}
	/**
	 * @param custAC the custAC to set
	 */
	public void setCustAC(String custAC) {
		this.custAC = custAC;
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
	 * @param dstAreaCode the dstAreaCode to set
	 */
	public void setDstAreaCode(String dstAreaCode) {
		this.dstAreaCode = dstAreaCode;
	}
	/**
	 * @return the fromDate
	 */
	public java.sql.Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(java.sql.Date fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public java.sql.Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(java.sql.Date toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the destinationCountry
	 */
	public String getDestinationCountry() {
		return destinationCountry;
	}
	/**
	 * @param destinationCountry the destinationCountry to set
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	
	
	
	
	
	 
	
	
	

}
