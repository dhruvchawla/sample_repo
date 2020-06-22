package com.bluedart.custreg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.service.OTPService;
import com.bluedart.custreg.dao.CustomerRegistrationDao;
import com.bluedart.custreg.dto.CorporateResponseDto;
import com.bluedart.custreg.dto.CustomerDetailDto;
import com.bluedart.custreg.service.CustomerRegistrationService;
/**
 * @author PR334023
 */
import com.bluedart.manageuserCA.dto.CorporateCustomerDto;



@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
	
	@Autowired
	private CustomerRegistrationDao customerRegistrationDao;
	
	@Autowired
	private OTPService otpService;
	
	@Override
	public CorporateResponseDto getExistingUser(String customerCode,String emailId) {
		return customerRegistrationDao.getExistingUser(customerCode, emailId);
	}

	@Override
	public CorporateResponseDto generateOTP(String id) {
		long otpLength = otpService.generateOTP(6);
		
		return customerRegistrationDao.generateOTP(id,otpLength);
	}

	@Override
	public CorporateResponseDto registerCorporateCustomer(CorporateCustomerDto corporateCustomerDto) {
		return customerRegistrationDao.registerCorporateCustomer(corporateCustomerDto);
	}

	@Override
	public CustomerDetailDto getCorporateCustDetails(String loginId) {
		return customerRegistrationDao.getCorporateCustDetails(loginId);
	}
}