package com.bluedart.contactus.dto;

import java.io.Serializable;

public class CustomerFeedbackResponseDto implements Serializable{
	
	/**
	 * @author CH848113
	 */
	private static final long serialVersionUID = 1L;
	
	private String waybillNumber;
	
	private boolean isError;
	
	private String errorMessage;
	
	private String feedbackId;
	
	private String feedbackType;
	
	private String feedbackBy;
	
	

	public String getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	/**
	 * @return the feedbackBy
	 */
	public String getFeedbackBy() {
		return feedbackBy;
	}

	/**
	 * @param feedbackBy the feedbackBy to set
	 */
	public void setFeedbackBy(String feedbackBy) {
		this.feedbackBy = feedbackBy;
	}
	
	
}
