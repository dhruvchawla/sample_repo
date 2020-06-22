package com.bluedart.camanagecorpusers.dto;

import java.io.Serializable;
import java.util.List;
/**
 * DTO to hold list of corporate users
 * @author PR334023
 *
 */
public class CorporateUsersResponseDto extends CorporateStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<CorporateUsersDto> usersList;
	private int totalCount;
	private int noOfUsers;

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

	public List<CorporateUsersDto> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<CorporateUsersDto> usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "CorporateUsersResponseDto [usersList=" + usersList
				+ ", totalCount=" + totalCount + ", noOfUsers=" + noOfUsers
				+ "]";
	}
	
}
