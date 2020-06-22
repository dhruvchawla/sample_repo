package com.bluedart.pod.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


/**
 * @author AK765612
 *
 */
public class PODDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public String awbNo; //Airway bill no
	public String productCode; //Product / service code
	public String valueAddedServices;
	public String senderName;
	public String parcelShop;
    public String originCode; //Origin service center code
    public String destCode;
    public String shipperCode; //Shipper code
    public String consignee; //Consignee
    public String pickupDate; //Pick up date
    public double weight; //Weight of shipment
    public String statusDesc;
    
	public String statusCode; //Status code
    public Date statusDate; //Status date
    public String statusTime; //Status time
    public String employeeCode; //Delivered Employee Code
    public String receivedBy; //Received by
    public String relation; //Relation
    public String identification; //identification
    public String remarks; //Remarks
    private String message;
    private String location;
    private String out;
    private Integer rec;
    
    private List<RelationTypeDto> RelationTypeDto;
    private List<IdentificationTypeDto> IdentificationTypeDto;
    
    //These two variables are used to carry the status of SorryInstruction
    private String sryAltInsStatus;
    private Boolean isSryAltInsError;
   
    public String returnC2PCValue;
	public String getReturnC2PCValue() {
		return returnC2PCValue;
	}
	public void setReturnC2PCValue(String returnC2PCValue) {
		this.returnC2PCValue = returnC2PCValue;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	/**
	 * @return the rec
	 */
	public Integer getRec() {
		return rec;
	}
	/**
	 * @param rec the rec to set
	 */
	public void setRec(Integer rec) {
		this.rec = rec;
	}
	/**
	 * @return the out
	 */
	public String getOut() {
		return out;
	}
	/**
	 * @param out the out to set
	 */
	public void setOut(String out) {
		this.out = out;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
    
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the valueAddedServices
	 */
	public String getValueAddedServices() {
		return valueAddedServices;
	}
	/**
	 * @param valueAddedServices the valueAddedServices to set
	 */
	public void setValueAddedServices(String valueAddedServices) {
		this.valueAddedServices = valueAddedServices;
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
		 * @return the senderName
		 */
		public String getSenderName() {
			return senderName;
		}
		/**
		 * @param senderName the senderName to set
		 */
		public void setSenderName(String senderName) {
			this.senderName = senderName;
		}
		/**
		 * @return the parcelShop
		 */
		public String getParcelShop() {
			return parcelShop;
		}
		/**
		 * @param parcelShop the parcelShop to set
		 */
		public void setParcelShop(String parcelShop) {
			this.parcelShop = parcelShop;
		}
	/**
	 * @return the originCode
	 */
	public String getOriginCode() {
		return originCode;
	}
	/**
	 * @param originCode the originCode to set
	 */
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	/**
	 * @return the destCode
	 */
	public String getDestCode() {
		return destCode;
	}
	/**
	 * @param destCode the destCode to set
	 */
	public void setDestCode(String destCode) {
		this.destCode = destCode;
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
	 * @return the pickupDate
	 */
	public String getPickupDate() {
		return pickupDate;
	}
	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	/**
	 * @return the statusDate
	 */
	public Date getStatusDate() {
		return statusDate;
	}
	/**
	 * @param statusDate the statusDate to set
	 */
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	/**
	 * @return the statusTime
	 */
	public String getStatusTime() {
		return statusTime;
	}
	/**
	 * @param statusTime the statusTime to set
	 */
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @return the receivedBy
	 */
	public String getReceivedBy() {
		return receivedBy;
	}
	/**
	 * @param receivedBy the receivedBy to set
	 */
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
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
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}
	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @return the relationTypeDto
	 */
	public List<RelationTypeDto> getRelationTypeDto() {
		return RelationTypeDto;
	}
	/**
	 * @param relationTypeDto the relationTypeDto to set
	 */
	public void setRelationTypeDto(List<RelationTypeDto> relationTypeDto) {
		RelationTypeDto = relationTypeDto;
	}
	/**
	 * @return the identificationTypeDto
	 */
	public List<IdentificationTypeDto> getIdentificationTypeDto() {
		return IdentificationTypeDto;
	}
	/**
	 * @param identificationTypeDto the identificationTypeDto to set
	 */
	public void setIdentificationTypeDto(
			List<IdentificationTypeDto> identificationTypeDto) {
		IdentificationTypeDto = identificationTypeDto;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * @return the sryAltInsStatus
	 */
	public String getSryAltInsStatus() {
		return sryAltInsStatus;
	}
	/**
	 * @param sryAltInsStatus the sryAltInsStatus to set
	 */
	public void setSryAltInsStatus(String sryAltInsStatus) {
		this.sryAltInsStatus = sryAltInsStatus;
	}
	
	/**
	 * @return the sryAltInsStatus
	 */
	public Boolean getSryAltInsError() {
		return isSryAltInsError;
	}
	/**
	 * @param sryAltInsStatus the sryAltInsStatus to set
	 */
	public void setSryAltInsError(Boolean isSryAltInsError) {
		this.isSryAltInsError = isSryAltInsError;
	}
}
