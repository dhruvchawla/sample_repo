package com.bluedart.common.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UPROFILE4.CNEEMST_T")
public class AddressBookMaster {
		
		@Id
		
		@Column(name = "CCADDRID")
		private Long addressId;
		@Column(name = "CLOGINID")
		private String loginId;
		@Column(name = "CCNTRYCODE")
		private String countryCode;
		@Column(name = "CCNEENAME")
		private String name;
		@Column(name = "CCNEEADR1")
		private String addressLine1;
		@Column(name = "CCNEEADR2")
		private String addressLine2;
		@Column(name = "CCNEEADR3")
		private String landmark;
		@Column(name = "CCNEEEML")
		private String emailId;
		@Column(name = "CCNEEPIN")
		private String pincode;
		@Column(name = "CCNEETEL")
		private String telephoneNumber;
		@Column(name = "CCNEECODE")
		private String vendorCode;
		@Column(name = "CCONTACT")
		private String contactPerson;
		
		@Column(name = "INSERTIONDATE")
		private Date creationDate;
		@Column(name = "AFF_AC")
		private String areaCode;
		@Column(name = "AFF_CC")
		private String customerCode;
		@Column(name = "CCITYCODE")
		private String cityCode;
		@Column(name = "CSTATECD")
		private String stateCode;
		@Column(name = "CADDRESSTYPE")
		private String addressType;
		@Column(name = "CCNEEMOB")
		private String mobileNumber;
		@Column(name = "CDEFAULTADDRESS")
		private String defaultAddress;
		@Column(name = "DMODIFICATIONDATE")
		private String modificationDate;
		@Column(name = "DSPBSDATE")
		private Date spbsDate;
		@Column(name = "COFFICECLOSURETIME")
		private String officeClosureTime;
		@Column(name = "NMOSTLYUSEDCOUNTER")
		private String mostlyUsedCounter;
		@Column(name = "CGSTN_UIDCODE")
		private String gstIn;
		@Column(name = "CCITYNAME")
		private String city;
		
		/**
		 * @return the addressId
		 */
		public Long getAddressId() {
			return addressId;
		}
		/**
		 * @param addressId the addressId to set
		 */
		public void setAddressId(Long addressId) {
			this.addressId = addressId;
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
		public void setLoginId(String loginId) {
			this.loginId = loginId;
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
		 * @return the addressLine1
		 */
		public String getAddressLine1() {
			return addressLine1;
		}
		/**
		 * @param addressLine1 the addressLine1 to set
		 */
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		/**
		 * @return the addressLine2
		 */
		public String getAddressLine2() {
			return addressLine2;
		}
		/**
		 * @param addressLine2 the addressLine2 to set
		 */
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		/**
		 * @return the landmark
		 */
		public String getLandmark() {
			return landmark;
		}
		/**
		 * @param landmark the landmark to set
		 */
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		/**
		 * @return the emailId
		 */
		public String getEmailId() {
			return emailId;
		}
		/**
		 * @param emailId the emailId to set
		 */
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		/**
		 * @return the pincode
		 */
		public String getPincode() {
			return pincode;
		}
		/**
		 * @param pincode the pincode to set
		 */
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		/**
		 * @return the telephoneNumber
		 */
		public String getTelephoneNumber() {
			return telephoneNumber;
		}
		/**
		 * @param telephoneNumber the telephoneNumber to set
		 */
		public void setTelephoneNumber(String telephoneNumber) {
			this.telephoneNumber = telephoneNumber;
		}
		/**
		 * @return the vendorCode
		 */
		public String getVendorCode() {
			return vendorCode;
		}
		/**
		 * @param vendorCode the vendorCode to set
		 */
		public void setVendorCode(String vendorCode) {
			this.vendorCode = vendorCode;
		}
		/**
		 * @return the contactPerson
		 */
		public String getContactPerson() {
			return contactPerson;
		}
		/**
		 * @param contactPerson the contactPerson to set
		 */
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}
		/**
		 * @return the creationDate
		 */
		public Date getCreationDate() {
			return creationDate;
		}
		/**
		 * @param creationDate the creationDate to set
		 */
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
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
		 * @return the cityCode
		 */
		public String getCityCode() {
			return cityCode;
		}
		/**
		 * @param cityCode the cityCode to set
		 */
		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}
		/**
		 * @return the stateCode
		 */
		public String getStateCode() {
			return stateCode;
		}
		/**
		 * @param stateCode the stateCode to set
		 */
		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}
		/**
		 * @return the addressType
		 */
		public String getAddressType() {
			return addressType;
		}
		/**
		 * @param addressType the addressType to set
		 */
		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		/**
		 * @return the mobileNumber
		 */
		public String getMobileNumber() {
			return mobileNumber;
		}
		/**
		 * @param mobileNumber the mobileNumber to set
		 */
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		/**
		 * @return the defaultAddress
		 */
		public String getDefaultAddress() {
			return defaultAddress;
		}
		/**
		 * @param defaultAddress the defaultAddress to set
		 */
		public void setDefaultAddress(String defaultAddress) {
			this.defaultAddress = defaultAddress;
		}
		/**
		 * @return the modificationDate
		 */
		public String getModificationDate() {
			return modificationDate;
		}
		/**
		 * @param modificationDate the modificationDate to set
		 */
		public void setModificationDate(String modificationDate) {
			this.modificationDate = modificationDate;
		}
		/**
		 * @return the sp_bsDate
		 */
		public Date getSpbsDate() {
			return spbsDate;
		}
		/**
		 * @param sp_bsDate the sp_bsDate to set
		 */
		public void setSpbsDate(Date spbsDate) {
			this.spbsDate = spbsDate;
		}
		/**
		 * @return the officeClosureTime
		 */
		public String getOfficeClosureTime() {
			return officeClosureTime;
		}
		/**
		 * @param officeClosureTime the officeClosureTime to set
		 */
		public void setOfficeClosureTime(String officeClosureTime) {
			this.officeClosureTime = officeClosureTime;
		}
		/**
		 * @return the mostlyUsedCounter
		 */
		public String getMostlyUsedCounter() {
			return mostlyUsedCounter;
		}
		/**
		 * @param mostlyUsedCounter the mostlyUsedCounter to set
		 */
		public void setMostlyUsedCounter(String mostlyUsedCounter) {
			this.mostlyUsedCounter = mostlyUsedCounter;
		}
		public String getGstIn() {
			return gstIn;
		}
		public void setGstIn(String gstIn) {
			this.gstIn = gstIn;
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
		public void setCity(String cityName) {
			this.city = cityName;
		}
		
		
}
