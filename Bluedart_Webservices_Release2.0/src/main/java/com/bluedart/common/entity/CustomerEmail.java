package com.bluedart.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author PR334023
 *
 */
@Entity
@Table (name = "CUSEMAIL")
public class CustomerEmail {
	@Id
	@Column (name = "CAREA")
	private String customerArea;
	@Column (name = "CCUSTCODE")
	private String customerCode;
	@Column (name = "CTYPE")
	private String customerType;
	@Column (name = "CNAME")
	private String customerName;
	@Column (name = "CEMAILID")
	private String customerEmailId;
	@Column (name = "CROWID")
	private String customerRowId;
	/**
	 * @return the customerArea
	 */
	public String getCustomerArea() {
		return customerArea;
	}
	/**
	 * @param customerArea the customerArea to set
	 */
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerEmailId
	 */
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	/**
	 * @param customerEmailId the customerEmailId to set
	 */
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	/**
	 * @return the customerRowId
	 */
	public String getCustomerRowId() {
		return customerRowId;
	}
	/**
	 * @param customerRowId the customerRowId to set
	 */
	public void setCustomerRowId(String customerRowId) {
		this.customerRowId = customerRowId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerEmailDetail [customerArea=" + customerArea
				+ ", customerCode=" + customerCode + ", customerType="
				+ customerType + ", customerName=" + customerName
				+ ", customerEmailId=" + customerEmailId + ", customerRowId="
				+ customerRowId + "]";
	}
}
