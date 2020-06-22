/**
 * 
 */
package com.bluedart.shipdart.dto;

import java.io.Serializable;

/**
 * @author CH851827
 *
 */
public class TrackAwbDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	private String licKey;
	private int qty;
	private String prodCode;
	private String verNo;
	private int reqScanFlag;
	private String type;

	private String awbStartNo;
	private String awbEndNo;
	
	private int ErrorCode;
	private String ErrorMessage;
	
	private String action;
	private String handler;
	
	private String error;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public int getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
	public int getReqScanFlag() {
		return reqScanFlag;
	}

	public void setReqScanFlag(int reqScanFlag) {
		this.reqScanFlag = reqScanFlag;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getAwbStartNo() {
		return awbStartNo;
	}
	public void setAwbStartNo(String awbStartNo) {
		this.awbStartNo = awbStartNo;
	}
	public String getAwbEndNo() {
		return awbEndNo;
	}
	public void setAwbEndNo(String awbEndNo) {
		this.awbEndNo = awbEndNo;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLicKey() {
		return licKey;
	}
	public void setLicKey(String licKey) {
		this.licKey = licKey;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	public String getVerNo() {
		return verNo;
	}
	public void setVerNo(String verNo) {
		this.verNo = verNo;
	}


}
