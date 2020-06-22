package com.bluedart.contactus.dto;

import java.io.Serializable;
import java.util.List;

public class ContactUsDto implements Serializable{
	
	/**
	 * @author CH848113
	 */
	private static final long serialVersionUID = 1L;

	private List<CustomerFeedbackResponseDto> customerFeedBackResponse ;
	
	private List<FeedBackReasonDto> feedBackReason;
	
	private boolean isMailSent;
	
	private String statusCode;
	
	private String statusMessage;

	public List<CustomerFeedbackResponseDto> getCustomerFeedBackResponse() {
		return customerFeedBackResponse;
	}

	public void setCustomerFeedBackResponse(List<CustomerFeedbackResponseDto> customerFeedBackResponse) {
		this.customerFeedBackResponse = customerFeedBackResponse;
	}

	
	public List<FeedBackReasonDto> getFeedBackReason() {
		return feedBackReason;
	}
	public void setFeedBackReason(List<FeedBackReasonDto> feedBackReason) {
		this.feedBackReason = feedBackReason;
	}


	public boolean isMailSent() {
		return isMailSent;
	}

	public void setMailSent(boolean isMailSent) {
		this.isMailSent = isMailSent;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
}
