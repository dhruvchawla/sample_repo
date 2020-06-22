package com.bluedart.custreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.manageuserCA.dto.CorporateCustomerDto;
import com.bluedart.custreg.dto.CorporateResponseDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.custreg.service.CustomerRegistrationService;

@RestController
public class CustomerRegistrationController {
	
	@Autowired
	private CustomerRegistrationService cuRegistrationService;
	
	/**
	 * 
	 * @param coDto
	 * @return
	 */
	@RequestMapping(value = "customerregistration/getexistinguser", method = RequestMethod.POST)
	public ResponseEntity<CorporateResponseDto> getExistingUser(@RequestBody CorporateResponseDto coDto) {
		CorporateResponseDto cuCorporateResponseDto = null;
		cuCorporateResponseDto = cuRegistrationService.getExistingUser(coDto.getCustomerCode(), coDto.getCustomerEmail());
		cuCorporateResponseDto.setStatusCode("OK");
		return new ResponseEntity(cuCorporateResponseDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param coDto
	 * @return
	 */
	@RequestMapping(value = "customerregistration/getotpsendmail", method = RequestMethod.POST)
	public ResponseEntity<CorporateResponseDto> getotpsendmail(@RequestBody CorporateResponseDto coDto) {
		CorporateResponseDto cuCorporateResponseDto = null;
		cuCorporateResponseDto = cuRegistrationService.generateOTP(coDto.getCustomerEmail());
		cuCorporateResponseDto.setStatusCode("OK");
		return new ResponseEntity(cuCorporateResponseDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param corporateCustomerDto
	 * @return
	 */
	@RequestMapping(value = "customerregistration/registercorporatecustomer", method = RequestMethod.POST)
	public ResponseEntity<CorporateResponseDto> registerCorporateCustomer(@RequestBody CorporateCustomerDto corporateCustomerDto) {
		CorporateResponseDto cuCorporateResponseDto = null;
		cuCorporateResponseDto = cuRegistrationService.registerCorporateCustomer(corporateCustomerDto);
		cuCorporateResponseDto.setStatusCode("OK");
		return new ResponseEntity(cuCorporateResponseDto, HttpStatus.OK);
	}
   /**
   * 
   * @param cuException
   * @return
   */
	@ExceptionHandler(DataBaseException.class)
	private CorporateResponseDto myError(BlueDartException cuException) {
		CorporateResponseDto coResponseDto = new CorporateResponseDto();
		coResponseDto.setStatusCode(cuException.getErrorCode());
		coResponseDto.setErrorMessage(cuException.getErrorMessage());
	    return coResponseDto;
	}
	/**
	 * 
	 * @param emException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private CorporateResponseDto mailError(BlueDartException emException) {
		CorporateResponseDto coResponseDto = new CorporateResponseDto();
		coResponseDto.setStatusCode(emException.getErrorCode());
		coResponseDto.setErrorMessage(emException.getErrorMessage());
	    return coResponseDto;
	}
}