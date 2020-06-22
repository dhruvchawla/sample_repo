package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author DH839598
 *
 */

public class StreamReportDto implements Serializable {


	private static final long serialVersionUID = 4920236997200297778L;
	
	private String recordNo;
	private String mode;
	private String npcs;
	private String nWeight;
	private String statCode;
	private String productCode;
	private String awbNo;
	private String refNo;
	private String puDate;
	private String orgArea;
	private String dstArea;
	private String consignee;
	private String statDesc;
	private String statGroup;
	private String statDate;
	private String statTime;
	private String recBy;
	private String relation;
	private String idType;
	private String idNo;
	private String orgCode;
	private String custCode;
	private String puTime;
	private String exptDlv;
	private String splInst;
	private String newAwNo;
	private String sender;
	private String rtoReason;
	private String productType;
	private String customerName;
	private long totalRecord;
	private boolean isLimitExceeded;
	private String errorCode;

	private List<StreamReportDto> streamReportDtoList;

	/**
	 * @return the recordNo
	 */
	public String getRecordNo() {
		return recordNo;
	}

	/**
	 * @param recordNo the recordNo to set
	 */
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the npcs
	 */
	public String getNpcs() {
		return npcs;
	}

	/**
	 * @param npcs the npcs to set
	 */
	public void setNpcs(String npcs) {
		this.npcs = npcs;
	}

	/**
	 * @return the nWeight
	 */
	public String getnWeight() {
		return nWeight;
	}

	/**
	 * @param nWeight the nWeight to set
	 */
	public void setnWeight(String nWeight) {
		this.nWeight = nWeight;
	}

	/**
	 * @return the statCode
	 */
	public String getStatCode() {
		return statCode;
	}

	/**
	 * @param statCode the statCode to set
	 */
	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the awbNo
	 */
	public String getAwbNo() {
		return awbNo;
	}

	/**
	 * @param awbNo the awbNo to set
	 */
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the puDate
	 */
	public String getPuDate() {
		return puDate;
	}

	/**
	 * @param puDate the puDate to set
	 */
	public void setPuDate(String puDate) {
		this.puDate = puDate;
	}

	/**
	 * @return the orgArea
	 */
	public String getOrgArea() {
		return orgArea;
	}

	/**
	 * @param orgArea the orgArea to set
	 */
	public void setOrgArea(String orgArea) {
		this.orgArea = orgArea;
	}

	/**
	 * @return the dstArea
	 */
	public String getDstArea() {
		return dstArea;
	}

	/**
	 * @param dstArea the dstArea to set
	 */
	public void setDstArea(String dstArea) {
		this.dstArea = dstArea;
	}

	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}

	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	/**
	 * @return the statDesc
	 */
	public String getStatDesc() {
		return statDesc;
	}

	/**
	 * @param statDesc the statDesc to set
	 */
	public void setStatDesc(String statDesc) {
		this.statDesc = statDesc;
	}

	/**
	 * @return the statGroup
	 */
	public String getStatGroup() {
		return statGroup;
	}

	/**
	 * @param statGroup the statGroup to set
	 */
	public void setStatGroup(String statGroup) {
		this.statGroup = statGroup;
	}

	/**
	 * @return the statDate
	 */
	public String getStatDate() {
		return statDate;
	}

	/**
	 * @param statDate the statDate to set
	 */
	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	/**
	 * @return the statTime
	 */
	public String getStatTime() {
		return statTime;
	}

	/**
	 * @param statTime the statTime to set
	 */
	public void setStatTime(String statTime) {
		this.statTime = statTime;
	}

	/**
	 * @return the recBy
	 */
	public String getRecBy() {
		return recBy;
	}

	/**
	 * @param recBy the recBy to set
	 */
	public void setRecBy(String recBy) {
		this.recBy = recBy;
	}

	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return the custCode
	 */
	public String getCustCode() {
		return custCode;
	}

	/**
	 * @param custCode the custCode to set
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	/**
	 * @return the puTime
	 */
	public String getPuTime() {
		return puTime;
	}

	/**
	 * @param puTime the puTime to set
	 */
	public void setPuTime(String puTime) {
		this.puTime = puTime;
	}

	/**
	 * @return the exptDlv
	 */
	public String getExptDlv() {
		return exptDlv;
	}

	/**
	 * @param exptDlv the exptDlv to set
	 */
	public void setExptDlv(String exptDlv) {
		this.exptDlv = exptDlv;
	}

	/**
	 * @return the splInst
	 */
	public String getSplInst() {
		return splInst;
	}

	/**
	 * @param splInst the splInst to set
	 */
	public void setSplInst(String splInst) {
		this.splInst = splInst;
	}

	/**
	 * @return the newAwNo
	 */
	public String getNewAwNo() {
		return newAwNo;
	}

	/**
	 * @param newAwNo the newAwNo to set
	 */
	public void setNewAwNo(String newAwNo) {
		this.newAwNo = newAwNo;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the rtoReason
	 */
	public String getRtoReason() {
		return rtoReason;
	}

	/**
	 * @param rtoReason the rtoReason to set
	 */
	public void setRtoReason(String rtoReason) {
		this.rtoReason = rtoReason;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the streamReportDtoList
	 */
	public List<StreamReportDto> getStreamReportDtoList() {
		return streamReportDtoList;
	}

	/**
	 * @param streamReportDtoList the streamReportDtoList to set
	 */
	public void setStreamReportDtoList(List<StreamReportDto> streamReportDtoList) {
		this.streamReportDtoList = streamReportDtoList;
	}

	/**
	 * @return the totalRecord
	 */
	public long getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the isLimitExceeded
	 */
	public boolean isLimitExceeded() {
		return isLimitExceeded;
	}

	/**
	 * @param isLimitExceeded the isLimitExceeded to set
	 */
	public void setLimitExceeded(boolean isLimitExceeded) {
		this.isLimitExceeded = isLimitExceeded;
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

	
	 
	
	

}
