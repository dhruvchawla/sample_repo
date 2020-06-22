package com.bluedart.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author CH851827
 *
 */
@Entity
@Table( name = "WEBMASTER.PINCDMST")
public class PincodeMst implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "CPINCODE")
	private String pinCode;
	
	@Column(name = "CPINDESC")
	private String pinCodeDesc;

	@Column(name = "CAREA")
	private String pinArea;
	
	@Column(name = "CSCRCD")
	private String cscrcd;
	
	@Column(name = "CSERVFLAG")
	private String serviceFlag;
	
	@Column(name = "CCRCRDSCR")
	private String ccrcrdscr;
	
	@Column(name = "CFLAG")
	private String cFlag;

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
	 * @return the pinCodeDesc
	 */
	public String getPinCodeDesc() {
		return pinCodeDesc;
	}

	/**
	 * @param pinCodeDesc the pinCodeDesc to set
	 */
	public void setPinCodeDesc(String pinCodeDesc) {
		this.pinCodeDesc = pinCodeDesc;
	}

	/**
	 * @return the pinArea
	 */
	public String getPinArea() {
		return pinArea;
	}

	/**
	 * @param pinArea the pinArea to set
	 */
	public void setPinArea(String pinArea) {
		this.pinArea = pinArea;
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
	 * @return the serviceFlag
	 */
	public String getServiceFlag() {
		return serviceFlag;
	}

	/**
	 * @param serviceFlag the serviceFlag to set
	 */
	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}

	/**
	 * @return the ccrcrdscr
	 */
	public String getCcrcrdscr() {
		return ccrcrdscr;
	}

	/**
	 * @param ccrcrdscr the ccrcrdscr to set
	 */
	public void setCcrcrdscr(String ccrcrdscr) {
		this.ccrcrdscr = ccrcrdscr;
	}

	/**
	 * @return the cFlag
	 */
	public String getcFlag() {
		return cFlag;
	}

	/**
	 * @param cFlag the cFlag to set
	 */
	public void setcFlag(String cFlag) {
		this.cFlag = cFlag;
	}

	@Override
	public String toString() {
		return "PincodeMst [pinCode=" + pinCode + ", pinCodeDesc="
				+ pinCodeDesc + ", pinArea=" + pinArea + ", cscrcd=" + cscrcd
				+ ", serviceFlag=" + serviceFlag + ", ccrcrdscr=" + ccrcrdscr
				+ ", cFlag=" + cFlag + "]";
	}

}
