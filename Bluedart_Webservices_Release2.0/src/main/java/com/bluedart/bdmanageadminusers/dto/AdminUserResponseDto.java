package com.bluedart.bdmanageadminusers.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.common.dto.StatusDto;

/**
 * 
 * @author PR334023
 * DTO to send admins list
 *
 */
public class AdminUserResponseDto extends StatusDto implements Serializable{

private static final long serialVersionUID = 1L;
	
	private List<AdminDetailDto> adminsList;
	private int totalCount;
	
	public List<AdminDetailDto> getAdminsList() {
		return adminsList;
	}

	public void setAdminsList(List<AdminDetailDto> adminsList) {
		this.adminsList = adminsList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "AdminUserResponseDto [adminsList=" + adminsList
				+ ", totalCount=" + totalCount + "]";
	}
}