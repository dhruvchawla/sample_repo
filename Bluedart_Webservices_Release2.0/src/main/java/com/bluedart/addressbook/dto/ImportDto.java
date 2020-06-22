package com.bluedart.addressbook.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author AN765570
 * 
 */
public class ImportDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String rowNo;
	private String columnName;
	private String errorMsg;
	private List<AddressBookDto> importAddressList;
	private List<AddressBookDto> importFailedAddressList;
	private String loginId;
	private String addressType;
	
	private boolean errorOccured;
	private String errorCode;
	private String errorMessage;
	/**
	 * @return the rowNo
	 */
	public String getRowNo() {
		return rowNo;
	}
	/**
	 * @param rowNo the rowNo to set
	 */
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
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
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the importAddressList
	 */
	public List<AddressBookDto> getImportAddressList() {
		return importAddressList;
	}
	/**
	 * @param importAddressList the importAddressList to set
	 */
	public void setImportAddressList(List<AddressBookDto> importAddressList) {
		this.importAddressList = importAddressList;
	}
	
	
	
	/**
	 * @return the importFailedAddressList
	 */
	public List<AddressBookDto> getImportFailedAddressList() {
		return importFailedAddressList;
	}
	/**
	 * @param importFailedAddressList the importFailedAddressList to set
	 */
	public void setImportFailedAddressList(
			List<AddressBookDto> importFailedAddressList) {
		this.importFailedAddressList = importFailedAddressList;
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
	
	
	
}
