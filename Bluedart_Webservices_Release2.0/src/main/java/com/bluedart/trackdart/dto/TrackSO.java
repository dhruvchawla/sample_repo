package com.bluedart.trackdart.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

public class TrackSO implements Serializable {

	 
	private static final long serialVersionUID = 1L;
	
	private String selectedAwbNos;
	private String loginId;
	private String radioBtn;
	private String trackingNos;
	private String awbNos;
	private String awbNo;
	private String refNos;
	private List<ShipmentSO> shipmentList;
	private List<PodSO> podList;
	private Integer intimateRetVal;
	private StringBuilder feedBackBody;
	private String areaCode;
	private Integer interfaceCode;
	private StringBuilder groupOfAwbNumber;
	private boolean mailSentFlag;
	private List<String> notFoundList;
	private List<String> noInfoList;
	private String errorFlag;
	
	private Blob blob;
	
	private String img;
	
	
	
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public String getErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}
	public String getAwbNo() {
		return awbNo;
	}
	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}
	public String getSelectedAwbNos() {
		return selectedAwbNos;
	}
	public void setSelectedAwbNos(String selectedAwbNos) {
		this.selectedAwbNos = selectedAwbNos;
	}
	public List<String> getNotFoundList() {
		return notFoundList;
	}
	public void setNotFoundList(List<String> notFoundList) {
		this.notFoundList = notFoundList;
	}
	public List<String> getNoInfoList() {
		return noInfoList;
	}
	public void setNoInfoList(List<String> noInfoList) {
		this.noInfoList = noInfoList;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the refNos
	 */
	public String getRefNos() {
		return refNos;
	}
	/**
	 * @param refNos the refNos to set
	 */
	public void setRefNos(String refNos) {
		this.refNos = refNos;
	}
	/**
	 * @return the radioBtn
	 */
	public String getRadioBtn() {
		return radioBtn;
	}
	/**
	 * @param radioBtn the radioBtn to set
	 */
	public void setRadioBtn(String radioBtn) {
		this.radioBtn = radioBtn;
	}
	/**
	 * @return the trackingNos
	 */
	public String getTrackingNos() {
		return trackingNos;
	}
	/**
	 * @param trackingNos the trackingNos to set
	 */
	public void setTrackingNos(String trackingNos) {
		this.trackingNos = trackingNos;
	}
	/**
	 * @return the awbNos
	 */
	public String getAwbNos() {
		return awbNos;
	}
	/**
	 * @param awbNos the awbNos to set
	 */
	public void setAwbNos(String awbNos) {
		this.awbNos = awbNos;
	}
	/**
	 * @return the shipmentList
	 */
	public List<ShipmentSO> getShipmentList() {
		return shipmentList;
	}
	/**
	 * @param shipmentList the shipmentList to set
	 */
	public void setShipmentList(List<ShipmentSO> shipmentList) {
		this.shipmentList = shipmentList;
	}
	/**
	 * @return the podList
	 */
	public List<PodSO> getPodList() {
		return podList;
	}
	/**
	 * @param podList the podList to set
	 */
	public void setPodList(List<PodSO> podList) {
		this.podList = podList;
	}
	 
	/**
	 * @return the intimateRetVal
	 */
	public Integer getIntimateRetVal() {
		return intimateRetVal;
	}
	/**
	 * @param intimateRetVal the intimateRetVal to set
	 */
	public void setIntimateRetVal(Integer intimateRetVal) {
		this.intimateRetVal = intimateRetVal;
	}
	/**
	 * @return the feedBackBody
	 */
	public StringBuilder getFeedBackBody() {
		return feedBackBody;
	}
	/**
	 * @param feedBackBody the feedBackBody to set
	 */
	public void setFeedBackBody(StringBuilder feedBackBody) {
		this.feedBackBody = feedBackBody;
	}
	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * @return the interfaceCode
	 */
	public Integer getInterfaceCode() {
		return interfaceCode;
	}
	/**
	 * @param interfaceCode the interfaceCode to set
	 */
	public void setInterfaceCode(Integer interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	/**
	 * @return the groupOfAwbNumber
	 */
	public StringBuilder getGroupOfAwbNumber() {
		return groupOfAwbNumber;
	}
	/**
	 * @param groupOfAwbNumber the groupOfAwbNumber to set
	 */
	public void setGroupOfAwbNumber(StringBuilder groupOfAwbNumber) {
		this.groupOfAwbNumber = groupOfAwbNumber;
	}
	/**
	 * @return the mailSentFlag
	 */
	public boolean isMailSentFlag() {
		return mailSentFlag;
	}
	/**
	 * @param mailSentFlag the mailSentFlag to set
	 */
	public void setMailSentFlag(boolean mailSentFlag) {
		this.mailSentFlag = mailSentFlag;
	}
	
	
}