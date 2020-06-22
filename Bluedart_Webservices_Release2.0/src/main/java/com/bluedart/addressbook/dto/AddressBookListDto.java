/**
 * 
 */
package com.bluedart.addressbook.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author AN765570
 *
 */
public class AddressBookListDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long addressId;
	private Integer pageNumber;
	private Integer pageSize;
	private String areaCode;
	private String customerCode;
	private String name;
	private String addressLine1;
	private String pincode;
	private String loginId;
	private String addressType;
	private String contactPerson;
	private String mobileNumber;
	private List<AddressBookListDto> addressBookListDtos;
	private Integer totalRecords;
	private List<AddressBookListDto> listOfDefltMstlyAddress;
	private List<AddressBookListDto> listOfMatchedAddress;
	private String editDeletePermissionFlag;
	
	private String cityCode;
	private CityDto listOfCityNames;
	private String stateCode;
	private String countryCode;
	private CountryDto listOfCountryNames;
	private String addressLine2;
	private String landmark;
	private String telephoneNumber;
	private String emailId;
	private String vendorCode;
	private String defaultAddress;
	private String officeClosureTime;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	private String countryName;
	private String cityName;
	
	
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
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @return the addressBookListDtos
	 */
	public List<AddressBookListDto> getAddressBookListDtos() {
		return addressBookListDtos;
	}
	/**
	 * @param addressBookListDtos the addressBookListDtos to set
	 */
	public void setAddressBookListDtos(List<AddressBookListDto> addressBookListDtos) {
		this.addressBookListDtos = addressBookListDtos;
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
	 * @return the totalRecords
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}
	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	/**
	 * @return the listOfDefltMstlyAddress
	 */
	public List<AddressBookListDto> getListOfDefltMstlyAddress() {
		return listOfDefltMstlyAddress;
	}
	/**
	 * @param listOfDefltMstlyAddress the listOfDefltMstlyAddress to set
	 */
	public void setListOfDefltMstlyAddress(
			List<AddressBookListDto> listOfDefltMstlyAddress) {
		this.listOfDefltMstlyAddress = listOfDefltMstlyAddress;
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
	 * @return the listOfMatchedAddress
	 */
	public List<AddressBookListDto> getListOfMatchedAddress() {
		return listOfMatchedAddress;
	}
	/**
	 * @param listOfMatchedAddress the listOfMatchedAddress to set
	 */
	public void setListOfMatchedAddress(
			List<AddressBookListDto> listOfMatchedAddress) {
		this.listOfMatchedAddress = listOfMatchedAddress;
	}
	/**
	 * @return the editDeletePermissionFlag
	 */
	public String getEditDeletePermissionFlag() {
		return editDeletePermissionFlag;
	}
	/**
	 * @param editDeletePermissionFlag the editDeletePermissionFlag to set
	 */
	public void setEditDeletePermissionFlag(String editDeletePermissionFlag) {
		this.editDeletePermissionFlag = editDeletePermissionFlag;
	}
	public CityDto getListOfCityNames() {
		return listOfCityNames;
	}
	public void setListOfCityNames(CityDto listOfCityNames) {
		this.listOfCityNames = listOfCityNames;
	}
	public CountryDto getListOfCountryNames() {
		return listOfCountryNames;
	}
	public void setListOfCountryNames(CountryDto listOfCountryNames) {
		this.listOfCountryNames = listOfCountryNames;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
