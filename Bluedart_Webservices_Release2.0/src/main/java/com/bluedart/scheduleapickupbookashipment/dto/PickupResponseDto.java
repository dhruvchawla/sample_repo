package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
/**
 * @author DH839598
 *
 */
public class PickupResponseDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = -6824038214573389523L;
	
	private String status;
	private String errorSeverity;
	private String statusInformation;
	private Calendar shipmentPickupdate;
	private String scheduleConfirmedDate;
	private Boolean emailSent;
	private Boolean smsSent;
	
	private List<String> listOfTokenNumber;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorSeverity() {
		return errorSeverity;
	}

	public void setErrorSeverity(String errorSeverity) {
		this.errorSeverity = errorSeverity;
	}

	public String getStatusInformation() {
		return statusInformation;
	}

	public void setStatusInformation(String statusInformation) {
		this.statusInformation = statusInformation;
	}

	public Calendar getShipmentPickupdate() {
		return shipmentPickupdate;
	}

	public void setShipmentPickupdate(Calendar shipmentPickupdate) {
		this.shipmentPickupdate = shipmentPickupdate;
	}

	public String getScheduleConfirmedDate() {
		return scheduleConfirmedDate;
	}

	public void setScheduleConfirmedDate(String scheduleConfirmedDate) {
		this.scheduleConfirmedDate = scheduleConfirmedDate;
	}

	public List<String> getListOfTokenNumber() {
		return listOfTokenNumber;
	}

	public void setListOfTokenNumber(List<String> listOfTokenNumber) {
		this.listOfTokenNumber = listOfTokenNumber;
	}

	/**
	 * @return the emailSent
	 */
	public Boolean getEmailSent() {
		return emailSent;
	}

	/**
	 * @param emailSent the emailSent to set
	 */
	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	/**
	 * @return the smsSent
	 */
	public Boolean getSmsSent() {
		return smsSent;
	}

	/**
	 * @param smsSent the smsSent to set
	 */
	public void setSmsSent(Boolean smsSent) {
		this.smsSent = smsSent;
	}
	

	
	
	 

}
