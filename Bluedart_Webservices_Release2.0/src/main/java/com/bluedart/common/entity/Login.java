package com.bluedart.common.entity;

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
@Table(name = "UPROFILE4.LOGIN_T")
public class Login {
	@Id
	@Column(name = "LOGINID")
	private String loginID;
	@Column(name = "USERID")
	private Integer userID;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "DBID")
	private Integer DBID;
	@Column(name = "MACHINEID")
	private String machineID;
	@Column(name = "LAST_LOGIN_DATE")
	private Date last_login_date;
	@Column(name = "BAD_SIGNON_COUNT")
	private Integer bad_signon_count;
	@Column(name = "INSERTION_DATE")
	private Date insertion_date;
	@Column(name = "ENABLE_FLAG")
	private String flag;
	@Column(name = "CLIENT_ADMINID")
	private String clientAdminID;
	@Column(name = "NO_OF_USERS")
	private Integer noOfUsers;
	@Column(name = "BP_PAYONLINE")
	private String payOnlineFlag;
	@Column(name = "RATEDISPLAY_FLAG")
	private String rateDisplayFlag;
	@Column(name = "SPICKUP_PAYONLINE")
	private String spickUpPayOnlineFlag;
	@Column(name = "BPMAILS_ENABLE")
	private String bpMails_enable;
	@Column(name = "BP_PARTIALPAY")
	private String partialPayFlag;
	@Column(name = "SECUREID")
	private String secureid;
	@Column(name = "SD_AWBQTY")
	private Integer sd_awbqty;
	@Column(name = "SD_QTYUSAGECHK")
	private String sd_qtyusagechk;

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDBID() {
		return DBID;
	}

	public void setDBID(Integer dBID) {
		DBID = dBID;
	}

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}

	public Integer getBad_signon_count() {
		return bad_signon_count;
	}

	public void setBad_signon_count(Integer bad_signon_count) {
		this.bad_signon_count = bad_signon_count;
	}

	public Date getInsertion_date() {
		return insertion_date;
	}

	public void setInsertion_date(Date insertion_date) {
		this.insertion_date = insertion_date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getClientAdminID() {
		return clientAdminID;
	}

	public void setClientAdminID(String clientAdminID) {
		this.clientAdminID = clientAdminID;
	}

	public Integer getNoOfUsers() {
		return noOfUsers;
	}

	public void setNoOfUsers(Integer noOfUsers) {
		this.noOfUsers = noOfUsers;
	}

	public String getPayOnlineFlag() {
		return payOnlineFlag;
	}

	public void setPayOnlineFlag(String payOnlineFlag) {
		this.payOnlineFlag = payOnlineFlag;
	}

	public String getRateDisplayFlag() {
		return rateDisplayFlag;
	}

	public void setRateDisplayFlag(String rateDisplayFlag) {
		this.rateDisplayFlag = rateDisplayFlag;
	}

	public String getSpickUpPayOnlineFlag() {
		return spickUpPayOnlineFlag;
	}

	public void setSpickUpPayOnlineFlag(String spickUpPayOnlineFlag) {
		this.spickUpPayOnlineFlag = spickUpPayOnlineFlag;
	}

	public String getBpMails_enable() {
		return bpMails_enable;
	}

	public void setBpMails_enable(String bpMails_enable) {
		this.bpMails_enable = bpMails_enable;
	}

	public String getPartialPayFlag() {
		return partialPayFlag;
	}

	public void setPartialPayFlag(String partialPayFlag) {
		this.partialPayFlag = partialPayFlag;
	}

	public String getSecureid() {
		return secureid;
	}

	public void setSecureid(String secureid) {
		this.secureid = secureid;
	}

	public Integer getSd_awbqty() {
		return sd_awbqty;
	}

	public void setSd_awbqty(Integer sd_awbqty) {
		this.sd_awbqty = sd_awbqty;
	}

	public String getSd_qtyusagechk() {
		return sd_qtyusagechk;
	}

	public void setSd_qtyusagechk(String sd_qtyusagechk) {
		this.sd_qtyusagechk = sd_qtyusagechk;
	}

}
