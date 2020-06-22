package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */

public class StreamDataDto implements Serializable {

	private static final long serialVersionUID = -5147697679166455310L;
	
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
	private String nWeight;
	private String puTime;
	private String npcs;
	private String exptDlv;
	private String splInst;
	private String newAwNo;
	private String sender;
	private String rtoReason;
	private String productCode;
	private String productType;
	private long totalRecord;
	private boolean isLimitExceeded;
	private String flag;
	private String errorCode;
	
	private List<StreamDataDto> streamDataList;
	

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
	 * @return the streamDataList
	 */
	public List<StreamDataDto> getStreamDataList() {
		return streamDataList;
	}

	/**
	 * @param streamDataList the streamDataList to set
	 */
	public void setStreamDataList(List<StreamDataDto> streamDataList) {
		this.streamDataList = streamDataList;
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
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
