package com.bluedart.addressbook.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.bluedart.common.dto.AffiliatePermissionDto;

/**
 * @author AN765570
 * 
 */
public class AddressBookDto  implements Serializable {

	private static final long serialVersionUID = -7051197897214943436L;
	
	private String loginId; 
	private Long addressId;
	private String affiliateCode;
	private String areaCode;
	private String customerCode;
	private String name;
	private String vendorCode;
	private String addressLine1; 
	private String pincode;
	private String mobileNumber;
	private String contactPerson;
	private String addressLine2;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private String cityCode;
	private String stateCode;
	private String countryCode;
	private String emailId;
	private String telephoneNumber;
	private String defaultAddress;
	private Date creationDate;
	private Date modificationDate;
	private Date spbsDateTime;
	private String addressType;
	private String officeClosureTime;
	private Boolean status;
	private Integer mostlyUsedCounter;
	private Integer logId;
	private String searchAddress;
	private String importRemarks;
	private Integer rowNumber;
	private String columnName;
	private String pincodeFormats;
	private boolean addressCreationAllowed;
	private String gstIn;
	
	private List<AddressBookImportDetailDto> addressBookImportDetailDtoList;
	
	private List<AddressBookDto> addressBookDtoList;
	private List<AffiliatePermissionDto> affiliateCodes;
	private List<CountryDto> countryList;
	private List<CityDto> cityDtoList;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	
	public String getGstIn() {
		return gstIn;
	}
	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
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
	 * @return the affiliateCode
	 */
	public String getAffiliateCode() {
		return affiliateCode;
	}
	/**
	 * @param affiliateCode the affiliateCode to set
	 */
	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	/**
	 * @return the sp_bsDate
	 */
	public Date getSpbsDateTime() {
		return spbsDateTime;
	}
	/**
	 * @param sp_bsDate the sp_bsDate to set
	 */
	public void setSpbsDateTime(Date spbsDateTime) {
		this.spbsDateTime = spbsDateTime;
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
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return the mostlyUsedCounter
	 */
	public Integer getMostlyUsedCounter() {
		return mostlyUsedCounter;
	}
	/**
	 * @param mostlyUsedCounter the mostlyUsedCounter to set
	 */
	public void setMostlyUsedCounter(Integer mostlyUsedCounter) {
		this.mostlyUsedCounter = mostlyUsedCounter;
	}
	/**
	 * @return the addressBookDtoList
	 */
	public List<AddressBookDto> getAddressBookDtoList() {
		return addressBookDtoList;
	}
	/**
	 * @param addressBookDtoList the addressBookDtoList to set
	 */
	public void setAddressBookDtoList(List<AddressBookDto> addressBookDtoList) {
		this.addressBookDtoList = addressBookDtoList;
	}
	/**
	 * @return the logId
	 */
	public Integer getLogId() {
		return logId;
	}
	/**
	 * @param logId the logId to set
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	/**
	 * @return the errorOccured
	 */
	public boolean isErrorOccured() {
		return errorOccured;
	}
	/**
	 * @param errorOccured the errorOccured to set
	 */
	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the affiliateCodes
	 */
	public List<AffiliatePermissionDto> getAffiliateCodes() {
		return affiliateCodes;
	}
	/**
	 * @param affiliateCodes the affiliateCodes to set
	 */
	public void setAffiliateCodes(List<AffiliatePermissionDto> affiliateCodes) {
		this.affiliateCodes = affiliateCodes;
	}
	/**
	 * @return the countryList
	 */
	public List<CountryDto> getCountryList() {
		return countryList;
	}
	/**
	 * @param countryList the countryList to set
	 */
	public void setCountryList(List<CountryDto> countryList) {
		this.countryList = countryList;
	}
	/**
	 * @return the cityDtoList
	 */
	public List<CityDto> getCityDtoList() {
		return cityDtoList;
	}
	/**
	 * @param cityDtoList the cityDtoList to set
	 */
	public void setCityDtoList(List<CityDto> cityDtoList) {
		this.cityDtoList = cityDtoList;
	}
	/**
	 * @return the searchAddress
	 */
	public String getSearchAddress() {
		return searchAddress;
	}
	/**
	 * @param searchAddress the searchAddress to set
	 */
	public void setSearchAddress(String searchAddress) {
		this.searchAddress = searchAddress;
	}

	
	/**
	 * @return the importRemarks
	 */
	public String getImportRemarks() {
		return importRemarks;
	}
	/**
	 * @param importRemarks the importRemarks to set
	 */
	public void setImportRemarks(String importRemarks) {
		this.importRemarks = importRemarks;
	}
	/**
	 * @return the addressBookImportDetailDtoList
	 */
	public List<AddressBookImportDetailDto> getAddressBookImportDetailDtoList() {
		return addressBookImportDetailDtoList;
	}
	/**
	 * @param addressBookImportDetailDtoList the addressBookImportDetailDtoList to set
	 */
	public void setAddressBookImportDetailDtoList(
			List<AddressBookImportDetailDto> addressBookImportDetailDtoList) {
		this.addressBookImportDetailDtoList = addressBookImportDetailDtoList;
	}
	/**
	 * @return the rowNumber
	 */
	public Integer getRowNumber() {
		return rowNumber;
	}
	/**
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the pincodeFormats
	 */
	public String getPincodeFormats() {
		return pincodeFormats;
	}
	/**
	 * @param pincodeFormats the pincodeFormats to set
	 */
	public void setPincodeFormats(String pincodeFormats) {
		this.pincodeFormats = pincodeFormats;
	}
	/**
	 * @return the isAddressCreationAllowed
	 */
	public boolean isAddressCreationAllowed() {
		return addressCreationAllowed;
	}
	/**
	 * @param isAddressCreationAllowed the isAddressCreationAllowed to set
	 */
	public void setAddressCreationAllowed(boolean addressCreationAllowed) {
		this.addressCreationAllowed = addressCreationAllowed;
	}
	
	
	
}
