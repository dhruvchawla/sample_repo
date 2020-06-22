package com.bluedart.maildart.dto;
import java.io.Serializable;
import java.util.List;
/**
 * @author CH848113
 */
public class MailDartDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<String> awbNumbers;
	private List<String> refNumbers;
	private String fromMailId;
	private String toEmailId;
	private String statusCode;
	private String statusMessage;
	private List<String> invalidAwbNumbers;
	

	public List<String> getAwbNumbers() {
		return awbNumbers;
	}

	public void setAwbNumbers(List<String> awbNumbers) {
		this.awbNumbers = awbNumbers;
	}

	public List<String> getRefNumbers() {
		return refNumbers;
	}

	public void setRefNumbers(List<String> refNumbers) {
		this.refNumbers = refNumbers;
	}

	public String getFromMailId() {
		return fromMailId;
	}

	public void setFromMailId(String fromMailId) {
		this.fromMailId = fromMailId;
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
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

	public List<String> getInvalidAwbNumbers() {
		return invalidAwbNumbers;
	}

	public void setInvalidAwbNumbers(List<String> invalidAwbNumbers) {
		this.invalidAwbNumbers = invalidAwbNumbers;
	}
	
	
}
