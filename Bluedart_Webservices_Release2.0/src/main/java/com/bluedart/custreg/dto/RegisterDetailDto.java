package com.bluedart.custreg.dto;

import java.io.Serializable;
import java.util.List;
/**
 * @author PR334023
 * Login details 
 */
public class RegisterDetailDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	private Long userId;
	private String password;
	private String orgPassword;
	private int dbId;
	private String machineId;
	private int badSignonCount;
	private String clientAdminId;
	private int noOfUsers;
	
	private String ponlineFlag;
	private String partPayFlag;
	private String rateDisplayFlag;
	private String spickupPayonline;
	private int sdAwbqty;
	private String sdQtyUsageChk;
	private List<Integer> featureIdList;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the orgPassword
	 */
	public String getOrgPassword() {
		return orgPassword;
	}
	/**
	 * @param orgPassword the orgPassword to set
	 */
	public void setOrgPassword(String orgPassword) {
		this.orgPassword = orgPassword;
	}
	/**
	 * @return the dbId
	 */
	public int getDbId() {
		return dbId;
	}
	/**
	 * @param dbId the dbId to set
	 */
	public void setDbId(int dbId) {
		this.dbId = dbId;
	}
	/**
	 * @return the machineId
	 */
	public String getMachineId() {
		return machineId;
	}
	/**
	 * @param machineId the machineId to set
	 */
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	/**
	 * @return the badSignonCount
	 */
	public int getBadSignonCount() {
		return badSignonCount;
	}
	/**
	 * @param badSignonCount the badSignonCount to set
	 */
	public void setBadSignonCount(int badSignonCount) {
		this.badSignonCount = badSignonCount;
	}
	/**
	 * @return the clientAdminId
	 */
	public String getClientAdminId() {
		return clientAdminId;
	}
	/**
	 * @param clientAdminId the clientAdminId to set
	 */
	public void setClientAdminId(String clientAdminId) {
		this.clientAdminId = clientAdminId;
	}
	/**
	 * @return the noOfUsers
	 */
	public int getNoOfUsers() {
		return noOfUsers;
	}
	/**
	 * @param noOfUsers the noOfUsers to set
	 */
	public void setNoOfUsers(int noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	/**
	 * @return the ponlineFlag
	 */
	public String getPonlineFlag() {
		return ponlineFlag;
	}
	/**
	 * @param ponlineFlag the ponlineFlag to set
	 */
	public void setPonlineFlag(String ponlineFlag) {
		this.ponlineFlag = ponlineFlag;
	}
	/**
	 * @return the partPayFlag
	 */
	public String getPartPayFlag() {
		return partPayFlag;
	}
	/**
	 * @param partPayFlag the partPayFlag to set
	 */
	public void setPartPayFlag(String partPayFlag) {
		this.partPayFlag = partPayFlag;
	}
	/**
	 * @return the rateDisplayFlag
	 */
	public String getRateDisplayFlag() {
		return rateDisplayFlag;
	}
	/**
	 * @param rateDisplayFlag the rateDisplayFlag to set
	 */
	public void setRateDisplayFlag(String rateDisplayFlag) {
		this.rateDisplayFlag = rateDisplayFlag;
	}
	/**
	 * @return the spickupPayonline
	 */
	public String getSpickupPayonline() {
		return spickupPayonline;
	}
	/**
	 * @param spickupPayonline the spickupPayonline to set
	 */
	public void setSpickupPayonline(String spickupPayonline) {
		this.spickupPayonline = spickupPayonline;
	}
	/**
	 * @return the sdAwbqty
	 */
	public int getSdAwbqty() {
		return sdAwbqty;
	}
	/**
	 * @param sdAwbqty the sdAwbqty to set
	 */
	public void setSdAwbqty(int sdAwbqty) {
		this.sdAwbqty = sdAwbqty;
	}
	/**
	 * @return the sdQtyUsageChk
	 */
	public String getSdQtyUsageChk() {
		return sdQtyUsageChk;
	}
	/**
	 * @param sdQtyUsageChk the sdQtyUsageChk to set
	 */
	public void setSdQtyUsageChk(String sdQtyUsageChk) {
		this.sdQtyUsageChk = sdQtyUsageChk;
	}
	/**
	 * @return the featureIdList
	 */
	public List<Integer> getFeatureIdList() {
		return featureIdList;
	}
	/**
	 * @param featureIdList the featureIdList to set
	 */
	public void setFeatureIdList(List<Integer> featureIdList) {
		this.featureIdList = featureIdList;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
