package com.bluedart.camanagecorpusers.dto;

import java.io.Serializable;
import java.util.List;

import com.bluedart.common.dto.AffiliateDetailDto;
import com.bluedart.common.dto.StatusDto;

/**
 * DTO to hold status code and message
 * @author PR334023
 *
 */
public class ClientUserDto extends StatusDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private CorporateUsersDto corporateUsersDto;
	private List<AffiliateDetailDto> affList;
	private int totalCount;
	private int noOfUsers;
	private int existingNoOfUsers;
	
	public int getExistingNoOfUsers() {
		return existingNoOfUsers;
	}
	public void setExistingNoOfUsers(int existingNoOfUsers) {
		this.existingNoOfUsers = existingNoOfUsers;
	}
	public int getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(int noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public CorporateUsersDto getCorporateUsersDto() {
		return corporateUsersDto;
	}
	public void setCorporateUsersDto(CorporateUsersDto corporateUsersDto) {
		this.corporateUsersDto = corporateUsersDto;
	}
	public List<AffiliateDetailDto> getAffList() {
		return affList;
	}
	public void setAffList(List<AffiliateDetailDto> affList) {
		this.affList = affList;
	}
	@Override
	public String toString() {
		return "ClientUserDto [corporateUsersDto=" + corporateUsersDto
				+ ", affList=" + affList + ", totalCount=" + totalCount
				+ ", noOfUsers=" + noOfUsers + ", existingNoOfUsers="
				+ existingNoOfUsers + "]";
	}
}