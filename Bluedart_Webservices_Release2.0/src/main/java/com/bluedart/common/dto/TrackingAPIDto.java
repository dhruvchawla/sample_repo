package com.bluedart.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Velayutham Balasubramanian
 *
 */
public class TrackingAPIDto implements Serializable {

	private TrackDto trackDto;
	private boolean errorFlag;
	private int secLevel;
	private String errorDetail ="";


	private String refNo = "";
	private String loginId   = "";
	private int reqScanFlagTNTMang = 0;
	private String licKey = "";
	private String verNo = "";

	/**
	 * @return the shipmentList
	 */
	public TrackDto getTrackDto() {
		return trackDto;
	}
	/***
	 * @param shipmentList the shipmentList to set
	 */
	public void setTrackDto(TrackDto trackDto) {
		this.trackDto = trackDto;
	}

	/**
	 * @return the errorFlag
	 */
	public boolean isErrorFlag() {
		return errorFlag;
	}
	/**
	 * @param mailSentFlag the mailSentFlag to set
	 */
	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	/**
	 * @return the errorDetail
	 */
	public String getErrorDetails() {
		return errorDetail;
	}
	/**
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetails(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	/**
	 * @return the secLevel
	 */
	public int getSecLevel() {
		return secLevel;
	}
	/**
	 * @param secLevel the secLevel to set
	 */
	public void setSecLevel(int secLevel) {
		this.secLevel = secLevel;
	}

	/**
	 * @return the Refno
	 */
	public String getRefNo() {
		return refNo;
	}
	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo( String  refNo ) {
		this.refNo = refNo;
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
	public void setLoginId( String  loginId ) {
		this.loginId = loginId;
	}

	/**
	 * @return the reqScanFlagTNTMang
	 */
	public int getReqScanFlag() {
		return reqScanFlagTNTMang;
	}
	/**
	 * @param reqScanFlagTNTMang the reqScanFlagTNTMang to set
	 */
	public void setReqScanFlag(int reqScanFlagTNTMang) {
		this.reqScanFlagTNTMang = reqScanFlagTNTMang;
	}

	/**
	 * @return the licKey
	 */
	public String getLicKey() {
		return licKey;
	}
	/**
	 * @param licKey the licKey to set
	 */
	public void setLicKey( String  licKey ) {
		this.licKey = licKey;
	}

	/**
	 * @return the verNo
	 */
	public String getVerNo() {
		return verNo;
	}
	/**
	 * @param verNo the verNo to set
	 */
	public void setVerNo( String  verNo ) {
		this.verNo = verNo;
	}

}