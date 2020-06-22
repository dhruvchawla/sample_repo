package com.bluedart.bdmanagecorporateusers.dto;

import java.io.Serializable;

/**
 * 
 * @author PR334023
 *
 */
public class PermissionResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String permissionName;
	private String permissionValue;
	private String visibleFlag;
	private String enableFlag;
	
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionValue() {
		return permissionValue;
	}
	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}
	public String getVisibleFlag() {
		return visibleFlag;
	}
	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	@Override
	public String toString() {
		return "PermissionResponseDto [permissionName=" + permissionName
				+ ", permissionValue=" + permissionValue + ", visibleFlag="
				+ visibleFlag + ", enableFlag=" + enableFlag + "]";
	}
	
}
