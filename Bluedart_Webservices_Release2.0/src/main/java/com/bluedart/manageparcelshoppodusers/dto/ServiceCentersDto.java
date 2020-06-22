package com.bluedart.manageparcelshoppodusers.dto;

import java.io.Serializable;

public class ServiceCentersDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String cscrcd;
	String cscrcdDesc;
	String serviceCenterRegion;
	String serviceCenterArea;
	String enableFlag;
	
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getCscrcd() {
		return cscrcd;
	}
	public void setCscrcd(String cscrcd) {
		this.cscrcd = cscrcd;
	}
	public String getCscrcdDesc() {
		return cscrcdDesc;
	}
	public void setCscrcdDesc(String cscrcdDesc) {
		this.cscrcdDesc = cscrcdDesc;
	}
	public String getServiceCenterRegion() {
		return serviceCenterRegion;
	}
	public void setServiceCenterRegion(String serviceCenterRegion) {
		this.serviceCenterRegion = serviceCenterRegion;
	}
	public String getServiceCenterArea() {
		return serviceCenterArea;
	}
	public void setServiceCenterArea(String serviceCenterArea) {
		this.serviceCenterArea = serviceCenterArea;
	}
	@Override
	public String toString() {
		return "ServiceCentersSO [cscrcd=" + cscrcd + ", cscrcdDesc=" + cscrcdDesc + ", serviceCenterRegion="
				+ serviceCenterRegion + ", serviceCenterArea=" + serviceCenterArea + "]";
	}
	
	
}
