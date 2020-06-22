package com.bluedart.manageuserCA.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Client admin returning dto
 * @author PR334023
 *
 */
public class ClientAdminResponseDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<UserBasicDetailsDto> userBasicDetailsDtos;
	private List<AffiliatesDto> affiliatesDtoList;
	
	private String createNewUserResponse;
	private String createNewUserPermissionResponse;
	
	private int deleteUserResponse;
	private UserBasicDetailsDto userBasicDetailsDto;
	private int modifyUserClientAdminResponse;
	private String resetPwdResponse;
	private Map<Integer,String> featuresMap;
	private boolean isMailSent;
	private String createBDAdminresponse;
	private int updateBDAdminResponse;
	
	private String statusCode;
	private String errorMessage;
	/**
	 * @return the userBasicDetailsDtos
	 */
	public List<UserBasicDetailsDto> getUserBasicDetailsDtos() {
		return userBasicDetailsDtos;
	}
	/**
	 * @param userBasicDetailsDtos the userBasicDetailsDtos to set
	 */
	public void setUserBasicDetailsDtos(
			List<UserBasicDetailsDto> userBasicDetailsDtos) {
		this.userBasicDetailsDtos = userBasicDetailsDtos;
	}
	/**
	 * @return the affiliatesDtoList
	 */
	public List<AffiliatesDto> getAffiliatesDtoList() {
		return affiliatesDtoList;
	}
	/**
	 * @param affiliatesDtoList the affiliatesDtoList to set
	 */
	public void setAffiliatesDtoList(List<AffiliatesDto> affiliatesDtoList) {
		this.affiliatesDtoList = affiliatesDtoList;
	}
	/**
	 * @return the createNewUserResponse
	 */
	public String getCreateNewUserResponse() {
		return createNewUserResponse;
	}
	/**
	 * @param createNewUserResponse the createNewUserResponse to set
	 */
	public void setCreateNewUserResponse(String createNewUserResponse) {
		this.createNewUserResponse = createNewUserResponse;
	}
	/**
	 * @return the deleteUserResponse
	 */
	public int getDeleteUserResponse() {
		return deleteUserResponse;
	}
	/**
	 * @param deleteUserResponse the deleteUserResponse to set
	 */
	public void setDeleteUserResponse(int deleteUserResponse) {
		this.deleteUserResponse = deleteUserResponse;
	}
	/**
	 * @return the userBasicDetailsDto
	 */
	public UserBasicDetailsDto getUserBasicDetailsDto() {
		return userBasicDetailsDto;
	}
	/**
	 * @param userBasicDetailsDto the userBasicDetailsDto to set
	 */
	public void setUserBasicDetailsDto(UserBasicDetailsDto userBasicDetailsDto) {
		this.userBasicDetailsDto = userBasicDetailsDto;
	}
	/**
	 * @return the modifyUserClientAdminResponse
	 */
	public int getModifyUserClientAdminResponse() {
		return modifyUserClientAdminResponse;
	}
	/**
	 * @param modifyUserClientAdminResponse the modifyUserClientAdminResponse to set
	 */
	public void setModifyUserClientAdminResponse(int modifyUserClientAdminResponse) {
		this.modifyUserClientAdminResponse = modifyUserClientAdminResponse;
	}
	/**
	 * @return the resetPwdResponse
	 */
	public String getResetPwdResponse() {
		return resetPwdResponse;
	}
	/**
	 * @param resetPwdResponse the resetPwdResponse to set
	 */
	public void setResetPwdResponse(String resetPwdResponse) {
		this.resetPwdResponse = resetPwdResponse;
	}
	/**
	 * @return the featuresMap
	 */
	public Map<Integer, String> getFeaturesMap() {
		return featuresMap;
	}
	/**
	 * @param featuresMap the featuresMap to set
	 */
	public void setFeaturesMap(Map<Integer, String> featuresMap) {
		this.featuresMap = featuresMap;
	}
	/**
	 * @return the isMailSent
	 */
	public boolean isMailSent() {
		return isMailSent;
	}
	/**
	 * @param isMailSent the isMailSent to set
	 */
	public void setMailSent(boolean isMailSent) {
		this.isMailSent = isMailSent;
	}
	/**
	 * @return the createBDAdminresponse
	 */
	public String getCreateBDAdminresponse() {
		return createBDAdminresponse;
	}
	/**
	 * @param createBDAdminresponse the createBDAdminresponse to set
	 */
	public void setCreateBDAdminresponse(String createBDAdminresponse) {
		this.createBDAdminresponse = createBDAdminresponse;
	}
	/**
	 * @return the updateBDAdminResponse
	 */
	public int getUpdateBDAdminResponse() {
		return updateBDAdminResponse;
	}
	/**
	 * @param updateBDAdminResponse the updateBDAdminResponse to set
	 */
	public void setUpdateBDAdminResponse(int updateBDAdminResponse) {
		this.updateBDAdminResponse = updateBDAdminResponse;
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
	public String getCreateNewUserPermissionResponse() {
		return createNewUserPermissionResponse;
	}
	public void setCreateNewUserPermissionResponse(
			String createNewUserPermissionResponse) {
		this.createNewUserPermissionResponse = createNewUserPermissionResponse;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientAdminResponseDto [userBasicDetailsDtos="
				+ userBasicDetailsDtos + ", affiliatesDtoList="
				+ affiliatesDtoList + ", createNewUserResponse="
				+ createNewUserResponse + ", deleteUserResponse="
				+ deleteUserResponse + ", userBasicDetailsDto="
				+ userBasicDetailsDto + ", modifyUserClientAdminResponse="
				+ modifyUserClientAdminResponse + ", resetPwdResponse="
				+ resetPwdResponse + ", featuresMap=" + featuresMap
				+ ", isMailSent=" + isMailSent + ", createBDAdminresponse="
				+ createBDAdminresponse + ", updateBDAdminResponse="
				+ updateBDAdminResponse + ", statusCode=" + statusCode
				+ ", errorMessage=" + errorMessage + "]";
	}
}