package com.bluedart.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author TH334025
 *
 */
@Entity
@Table(name="UPROFILE4.USER_T")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USERID")
	private Integer userID;
	@Column(name="CCUSTCODE")
	private String ccustcode;
	@Column(name="CAREA")
	private String carea;
	@Column(name="USER_TYPE")
	private String user_type;
	@Column(name="SECURITY_LEVEL")
	private Integer security_level;
	@Column(name="DBDOWNLOAD")
	private Integer dbdownload;
	@Column(name="NO_OF_AFFILIATES")
	private Integer no_of_affiliates;
	@Column(name="EMAILID")
	private String emailid;
	@Column(name="NAME")
	private String name;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="DEPARTMENT")
	private String deptName;
	@Column(name="ADDR1")
	private String addr1;
	@Column(name="ADDR2")
	private String addr2;
	@Column(name="ADDR3")
	private String addr3;
	@Column(name="CITY")
	private String city;
	@Column(name="PINCODE")
	private String pinCode;
	@Column(name="PHONE")
	private String phone;
	@Column(name="FAX")
	private String fax;
	@Column(name="REGISTRATION_DATE")
	private Date registration_date;
	@Column(name="MODIFY_DATE")
	private Date modify_date;
	@Column(name="STATUS")
	private String status;
	@Column(name="MODE_OF_SHIPMENT")
	private String mode_of_shipment;
	@Column(name="NO_OF_SHIPMENT")
	private Integer no_of_shipments;
	@Column(name="CREGION")
	private String cregion;
	@Column(name="CSCRCD")
	private String cscrcd;
	@Column(name="INSERTION_DATE")
	private Date Insertion_Date;
	@Column(name="CCNTPERSON")
	private String cntPerson;
	@Column(name="CCNTRYCODE")
	private String countryCode;
	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	/**
	 * @return the ccustcode
	 */
	public String getCcustcode() {
		return ccustcode;
	}
	/**
	 * @param ccustcode the ccustcode to set
	 */
	public void setCcustcode(String ccustcode) {
		this.ccustcode = ccustcode;
	}
	/**
	 * @return the carea
	 */
	public String getCarea() {
		return carea;
	}
	/**
	 * @param carea the carea to set
	 */
	public void setCarea(String carea) {
		this.carea = carea;
	}
	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}
	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	/**
	 * @return the security_level
	 */
	public Integer getSecurity_level() {
		return security_level;
	}
	/**
	 * @param security_level the security_level to set
	 */
	public void setSecurity_level(Integer security_level) {
		this.security_level = security_level;
	}
	/**
	 * @return the dbdownload
	 */
	public Integer getDbdownload() {
		return dbdownload;
	}
	/**
	 * @param dbdownload the dbdownload to set
	 */
	public void setDbdownload(Integer dbdownload) {
		this.dbdownload = dbdownload;
	}
	/**
	 * @return the no_of_affiliates
	 */
	public Integer getNo_of_affiliates() {
		return no_of_affiliates;
	}
	/**
	 * @param no_of_affiliates the no_of_affiliates to set
	 */
	public void setNo_of_affiliates(Integer no_of_affiliates) {
		this.no_of_affiliates = no_of_affiliates;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}
	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}
	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	/**
	 * @return the addr3
	 */
	public String getAddr3() {
		return addr3;
	}
	/**
	 * @param addr3 the addr3 to set
	 */
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the registration_date
	 */
	public Date getRegistration_date() {
		return registration_date;
	}
	/**
	 * @param registration_date the registration_date to set
	 */
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	/**
	 * @return the modify_date
	 */
	public Date getModify_date() {
		return modify_date;
	}
	/**
	 * @param modify_date the modify_date to set
	 */
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the mode_of_shipment
	 */
	public String getMode_of_shipment() {
		return mode_of_shipment;
	}
	/**
	 * @param mode_of_shipment the mode_of_shipment to set
	 */
	public void setMode_of_shipment(String mode_of_shipment) {
		this.mode_of_shipment = mode_of_shipment;
	}
	/**
	 * @return the no_of_shipments
	 */
	public Integer getNo_of_shipments() {
		return no_of_shipments;
	}
	/**
	 * @param no_of_shipments the no_of_shipments to set
	 */
	public void setNo_of_shipments(Integer no_of_shipments) {
		this.no_of_shipments = no_of_shipments;
	}
	/**
	 * @return the cregion
	 */
	public String getCregion() {
		return cregion;
	}
	/**
	 * @param cregion the cregion to set
	 */
	public void setCregion(String cregion) {
		this.cregion = cregion;
	}
	/**
	 * @return the cscrcd
	 */
	public String getCscrcd() {
		return cscrcd;
	}
	/**
	 * @param cscrcd the cscrcd to set
	 */
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	/**
	 * @return the insertion_Date
	 */
	public Date getInsertion_Date() {
		return Insertion_Date;
	}
	/**
	 * @param insertion_Date the insertion_Date to set
	 */
	public void setInsertion_Date(Date insertion_Date) {
		Insertion_Date = insertion_Date;
	}
	/**
	 * @return the cntPerson
	 */
	public String getCntPerson() {
		return cntPerson;
	}
	/**
	 * @param cntPerson the cntPerson to set
	 */
	public void setCntPerson(String cntPerson) {
		this.cntPerson = cntPerson;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
