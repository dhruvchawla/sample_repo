package com.bluedart.custreg.dao;

import com.bluedart.custreg.dto.CorporateResponseDto;
import com.bluedart.custreg.dto.CustomerDetailDto;
import com.bluedart.manageuserCA.dto.CorporateCustomerDto;
/**
 * 
 * @author PR334023
 *
 */
public interface CustomerRegistrationDao
{
	public CorporateResponseDto getExistingUser(String customerCode, String emailId);
	
	public CorporateResponseDto generateOTP(String emailId, long otp);
	
	public CustomerDetailDto getCorporateCustDetails(String loginId);
	
	public CorporateResponseDto registerCorporateCustomer(CorporateCustomerDto corporateCustomerDto);
}
