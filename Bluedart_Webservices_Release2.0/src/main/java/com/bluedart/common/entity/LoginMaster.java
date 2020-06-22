package com.bluedart.common.entity;

import java.util.Date;

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
@Table(name = "UPROFILE4.LOGIN_T")
public class LoginMaster {
	@Id
	@Column(name = "LOGINID")
	private String loginID;
	@Column(name = "USERID")
	private Long userID;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "DBID")
	private Long dbId;
	@Column(name = "MACHINEID")
	private String machineID;
	@Column(name = "LAST_LOGIN_DATE")
	private Date lastLoginDate;
	@Column(name = "BAD_SIGNON_COUNT")
	private Integer badSignonCount;
	@Column(name = "INSERTION_DATE")
	private Date insertionDate;
	@Column(name = "ENABLE_FLAG")
	private String enableFlag;
	@Column(name = "CLIENT_ADMINID")
	private String clientAdminId;
	@Column(name = "NO_OF_USERS")
	private Integer noOfUsers;
	@Column(name = "BP_PAYONLINE")
	private String payOnlineFlag;
	@Column(name = "RATEDISPLAY_FLAG")
	private String rateDisplayFlag;
	@Column(name = "SPICKUP_PAYONLINE")
	private String spickUpPayOnlineFlag;
	@Column(name = "BPMAILS_ENABLE")
	private String bpMailsEnable;
	@Column(name = "BP_PARTIALPAY")
	private String partialPayFlag;
	@Column(name = "SECUREID")
	private String secureid;
	@Column(name = "SD_AWBQTY")
	private Integer sdAwbqty;
	@Column(name = "SD_QTYUSAGECHK")
	private String sdQtyusagechk;
	/**
	 * @return the loginID
	 */
	public String getLoginID() {
		return loginID;
	}
	/**
	 * @param loginID the loginID to set
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
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
	 * @return the dbId
	 */
	public Long getDbId() {
		return dbId;
	}
	/**
	 * @param dbId the dbId to set
	 */
	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	/**
	 * @return the machineID
	 */
	public String getMachineID() {
		return machineID;
	}
	/**
	 * @param machineID the machineID to set
	 */
	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}
	/**
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	/**
	 * @return the badSignonCount
	 */
	public Integer getBadSignonCount() {
		return badSignonCount;
	}
	/**
	 * @param badSignonCount the badSignonCount to set
	 */
	public void setBadSignonCount(Integer badSignonCount) {
		this.badSignonCount = badSignonCount;
	}
	/**
	 * @return the insertionDate
	 */
	public Date getInsertionDate() {
		return insertionDate;
	}
	/**
	 * @param insertionDate the insertionDate to set
	 */
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	/**
	 * @return the enableFlag
	 */
	public String getEnableFlag() {
		return enableFlag;
	}
	/**
	 * @param enableFlag the enableFlag to set
	 */
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
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
	public Integer getNoOfUsers() {
		return noOfUsers;
	}
	/**
	 * @param noOfUsers the noOfUsers to set
	 */
	public void setNoOfUsers(Integer noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	/**
	 * @return the payOnlineFlag
	 */
	public String getPayOnlineFlag() {
		return payOnlineFlag;
	}
	/**
	 * @param payOnlineFlag the payOnlineFlag to set
	 */
	public void setPayOnlineFlag(String payOnlineFlag) {
		this.payOnlineFlag = payOnlineFlag;
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
	 * @return the spickUpPayOnlineFlag
	 */
	public String getSpickUpPayOnlineFlag() {
		return spickUpPayOnlineFlag;
	}
	/**
	 * @param spickUpPayOnlineFlag the spickUpPayOnlineFlag to set
	 */
	public void setSpickUpPayOnlineFlag(String spickUpPayOnlineFlag) {
		this.spickUpPayOnlineFlag = spickUpPayOnlineFlag;
	}
	/**
	 * @return the bpMailsEnable
	 */
	public String getBpMailsEnable() {
		return bpMailsEnable;
	}
	/**
	 * @param bpMailsEnable the bpMailsEnable to set
	 */
	public void setBpMailsEnable(String bpMailsEnable) {
		this.bpMailsEnable = bpMailsEnable;
	}
	/**
	 * @return the partialPayFlag
	 */
	public String getPartialPayFlag() {
		return partialPayFlag;
	}
	/**
	 * @param partialPayFlag the partialPayFlag to set
	 */
	public void setPartialPayFlag(String partialPayFlag) {
		this.partialPayFlag = partialPayFlag;
	}
	/**
	 * @return the secureid
	 */
	public String getSecureid() {
		return secureid;
	}
	/**
	 * @param secureid the secureid to set
	 */
	public void setSecureid(String secureid) {
		this.secureid = secureid;
	}
	/**
	 * @return the sdAwbqty
	 */
	public Integer getSdAwbqty() {
		return sdAwbqty;
	}
	/**
	 * @param sdAwbqty the sdAwbqty to set
	 */
	public void setSdAwbqty(Integer sdAwbqty) {
		this.sdAwbqty = sdAwbqty;
	}
	/**
	 * @return the sdQtyusagechk
	 */
	public String getSdQtyusagechk() {
		return sdQtyusagechk;
	}
	/**
	 * @param sdQtyusagechk the sdQtyusagechk to set
	 */
	public void setSdQtyusagechk(String sdQtyusagechk) {
		this.sdQtyusagechk = sdQtyusagechk;
	}
}
