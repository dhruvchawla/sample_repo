package com.bluedart.scheduleapickupbookashipment.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class PermissionDto extends ErrorDto implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private List<String> permissionName;
	

	/**
	 * @return the permissionName
	 */
	public List<String> getPermissionName() {
		return permissionName;
	}

	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(List<String> permissionName) {
		this.permissionName = permissionName;
	}
	
	

}
