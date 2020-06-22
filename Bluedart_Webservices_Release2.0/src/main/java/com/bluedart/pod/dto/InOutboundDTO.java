
package com.bluedart.pod.dto;

import java.util.Date;
import java.util.List;

/**
 * @author AK765612
 *
 */
public class InOutboundDTO {
	
	private String loginId;
	private String userType;
	private String destination;
	private String fromPickUpDate;
	private String toPickUpDate;
	private String origin;
	private String  custCode;
	private String shipperCode;
	private String statusType;
	private String sortBy;
	private String inOrder;
	private Integer shipmentPerPage;
	private Integer pageNumber;
	private Integer secLevel;
	private Integer reqScanFlag;
	private String valueAddedService;
	private Long recordSize;
	private String viewBy;
	private String downloadFlag;
	private String reportAsOn;
	private String prodCode;
	private String parcelShopCode;
	private String destServiceCenterCode;
	private List<ShipmentDto> shipmentList;
	private List<PodObjDto> podList;
	private String sortOrder;
	private List<?> downLoadDataList;
	private List<?> reportDataList;
	
	
	public String getParcelShopCode() {
		return parcelShopCode;
	}
	public void setParcelShopCode(String parcelShopCode) {
		this.parcelShopCode = parcelShopCode;
	}
	public String getDestServiceCenterCode() {
		return destServiceCenterCode;
	}
	public void setDestServiceCenterCode(String destServiceCenterCode) {
		this.destServiceCenterCode = destServiceCenterCode;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * @return the fromPickUpDate
	 */
	public String getFromPickUpDate() {
		return fromPickUpDate;
	}
	/**
	 * @param fromPickUpDate the fromPickUpDate to set
	 */
	public void setFromPickUpDate(String fromPickUpDate) {
		this.fromPickUpDate = fromPickUpDate;
	}
	/**
	 * @return the toPickUpDate
	 */
	public String getToPickUpDate() {
		return toPickUpDate;
	}
	/**
	 * @param toPickUpDate the toPickUpDate to set
	 */
	public void setToPickUpDate(String toPickUpDate) {
		this.toPickUpDate = toPickUpDate;
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
	 * @return the shipperCode
	 */
	public String getShipperCode() {
		return shipperCode;
	}
	/**
	 * @param shipperCode the shipperCode to set
	 */
	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
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
	 * @return the inOrder
	 */
	public String getInOrder() {
		return inOrder;
	}
	/**
	 * @param inOrder the inOrder to set
	 */
	public void setInOrder(String inOrder) {
		this.inOrder = inOrder;
	}
	/**
	 * @return the shipmentPerPage
	 */
	public Integer getShipmentPerPage() {
		return shipmentPerPage;
	}
	/**
	 * @param shipmentPerPage the shipmentPerPage to set
	 */
	public void setShipmentPerPage(Integer shipmentPerPage) {
		this.shipmentPerPage = shipmentPerPage;
	}
	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
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
	 * @return the valueAddedService
	 */
	public String getValueAddedService() {
		return valueAddedService;
	}
	/**
	 * @param valueAddedService the valueAddedService to set
	 */
	public void setValueAddedService(String valueAddedService) {
		this.valueAddedService = valueAddedService;
	}
	/**
	 * @return the shipmentList
	 */
	public List<ShipmentDto> getShipmentList() {
		return shipmentList;
	}
	/**
	 * @param shipmentList the shipmentList to set
	 */
	public void setShipmentList(List<ShipmentDto> shipmentList) {
		this.shipmentList = shipmentList;
	}
	/**
	 * @return the podList
	 */
	public List<PodObjDto> getPodList() {
		return podList;
	}
	/**
	 * @param podList the podList to set
	 */
	public void setPodList(List<PodObjDto> podList) {
		this.podList = podList;
	}
	/**
	 * @return the recordSize
	 */
	public Long getRecordSize() {
		return recordSize;
	}
	/**
	 * @param recordSize the recordSize to set
	 */
	public void setRecordSize(Long recordSize) {
		this.recordSize = recordSize;
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
	 * @return the reportAsOn
	 */
	public String getReportAsOn() {
		return reportAsOn;
	}
	/**
	 * @param reportAsOn the reportAsOn to set
	 */
	public void setReportAsOn(String reportAsOn) {
		this.reportAsOn = reportAsOn;
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
	 * @return the downLoadDataList
	 */
	public List<?> getDownLoadDataList() {
		return downLoadDataList;
	}
	/**
	 * @param downLoadDataList the downLoadDataList to set
	 */
	public void setDownLoadDataList(List<?> downLoadDataList) {
		this.downLoadDataList = downLoadDataList;
	}
	/**
	 * @return the reportDataList
	 */
	public List<?> getReportDataList() {
		return reportDataList;
	}
	/**
	 * @param reportDataList the reportDataList to set
	 */
	public void setReportDataList(List<?> reportDataList) {
		this.reportDataList = reportDataList;
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
}
