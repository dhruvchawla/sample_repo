package com.bluedart.addressbook.dto;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @author AN765570
 * 
 */
public class AddressBookImportDetailDto  implements SQLData, Serializable{

	private static final long serialVersionUID = 1L;
	private String sql_type; 
	private Integer rowNumber;
	private String columnName;
	private String areaCode;
	private String customerCode;
	private String name;
	private String contactPerson;
	private String addressLine1; 
	private String addressLine2;
	private String landmark;
	private String pincode;
	private String telephoneNumber;
	private String mobileNumber;
	private String emailId;
	private String officeClosureTime;
	private String defaultAddress;
	private String countryCode;
	private String cityCode;
	private String importRemarks;
	private String gstIn;
	
	public String getGstIn() {
		return gstIn;
	}
	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}
	/**
	 * @return the sql_type
	 */
	public String getSql_type() {
		return sql_type;
	}
	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
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
	
	@Override
	public void readSQL(SQLInput paramSQLInput, String typeName) throws SQLException {
		setSql_type(getSql_type());
		setRowNumber(paramSQLInput.readInt());
		setColumnName(paramSQLInput.readNString());
		setAreaCode(paramSQLInput.readNString());
		setCustomerCode(paramSQLInput.readNString());
		setName(paramSQLInput.readNString());
		setContactPerson(paramSQLInput.readNString());
		setAddressLine1(paramSQLInput.readNString());
		setAddressLine2(paramSQLInput.readNString());
		setLandmark(paramSQLInput.readNString());
		setPincode(paramSQLInput.readNString());
		setTelephoneNumber(paramSQLInput.readNString());
		setMobileNumber(paramSQLInput.readNString());
		setEmailId(paramSQLInput.readNString());
		setOfficeClosureTime(paramSQLInput.readNString());
		setDefaultAddress(paramSQLInput.readNString());
		setCountryCode(paramSQLInput.readNString());
		setCityCode(paramSQLInput.readNString());
		setImportRemarks(paramSQLInput.readNString());
		setGstIn(paramSQLInput.readNString());
	}
	@Override
	public void writeSQL(SQLOutput paramSQLOutput) throws SQLException {
		paramSQLOutput.writeInt(getRowNumber());
	    paramSQLOutput.writeString(getColumnName());
		paramSQLOutput.writeString(getAreaCode());
	    paramSQLOutput.writeString(getCustomerCode());
	    paramSQLOutput.writeString(getName());
	    paramSQLOutput.writeString(getContactPerson());
	    paramSQLOutput.writeString(getAddressLine1());
	    paramSQLOutput.writeString(getAddressLine2());
	    paramSQLOutput.writeString(getLandmark());
	    paramSQLOutput.writeString(getPincode());
	    paramSQLOutput.writeString(getTelephoneNumber());
	    paramSQLOutput.writeString(getMobileNumber());
	    paramSQLOutput.writeString(getEmailId());
	    paramSQLOutput.writeString(getOfficeClosureTime());
	    paramSQLOutput.writeString(getDefaultAddress());
	    paramSQLOutput.writeString(getCountryCode());
	    paramSQLOutput.writeString(getCityCode());
	    paramSQLOutput.writeString(getImportRemarks());
	    paramSQLOutput.writeString(getGstIn());
	}
	@Override
	public String getSQLTypeName() throws SQLException {
		return sql_type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressBookImportDetailDto [sql_type=" + sql_type
				+ ", rowNumber=" + rowNumber + ", columnName=" + columnName
				+ ", areaCode=" + areaCode + ", customerCode=" + customerCode
				+ ", name=" + name + ", contactPerson=" + contactPerson
				+ ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", landmark=" + landmark + ", pincode="
				+ pincode + ", telephoneNumber=" + telephoneNumber
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", officeClosureTime=" + officeClosureTime
				+ ", defaultAddress=" + defaultAddress + ", countryCode="
				+ countryCode + ", cityCode=" + cityCode + ", importRemarks="
				+ importRemarks + "]";
	}
	
	
	
}
