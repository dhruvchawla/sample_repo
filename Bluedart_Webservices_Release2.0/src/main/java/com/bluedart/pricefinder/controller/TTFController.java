package com.bluedart.pricefinder.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.pricefinder.dto.AddressBookDto;
import com.bluedart.pricefinder.dto.RateAndTransitDTO;
import com.bluedart.pricefinder.service.FinderService;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DI334021
 * This is a rest controller which receives the input from the Liferay(Front end) side.
 *
 */
@RestController
public class TTFController {

	private static Logger log = Logger.getLogger(TTFController.class.getName()); 
	
	@Autowired
	FinderService finderService;
	
	/**
	 * 
	 * @param rateAndTransitDTO
	 * @return
	 * @Description This method receives the input required for calculating the transit time and price.
	 */
	@RequestMapping(value = "/ratetransitfinder/findTransitTimePrice", method = RequestMethod.POST)
	public RateAndTransitDTO findTransitTimePrice(@RequestBody RateAndTransitDTO rateAndTransitDTO){
		
		log.debug(" TTFController : findTransitTimePrice");
		
		
		RateAndTransitDTO rateTransitDTO = finderService.findTransitTimePrice(rateAndTransitDTO);
		if(!rateTransitDTO.isError()) 
			rateTransitDTO.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return rateTransitDTO;
	}
	
	@RequestMapping(value = "/ratetransitfinder/findTransitTimePrice/{originCity}/{originPincode}/{destinationCity}/{destinationPincode}/{destinationCountryCode}/{bookingDate}/{bookingTime}/{actualWeight}/{ipAddress}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public RateAndTransitDTO findTransitTimePrice(@PathVariable String originCity, @PathVariable String originPincode, @PathVariable String destinationCity, @PathVariable String destinationPincode,@PathVariable String destinationCountryCode, @PathVariable String bookingDate, @PathVariable String bookingTime, @PathVariable String actualWeight, @PathVariable String ipAddress, @PathVariable String loginId)
	{
		RateAndTransitDTO rateAndTransitDTO = new RateAndTransitDTO();
		AddressBookDto sourceAddressBookDto = new AddressBookDto();
		AddressBookDto destinationAddressBookDto = new AddressBookDto();
		
		// Origin
		if(originPincode == null || "null".equalsIgnoreCase(originPincode))
		{
			sourceAddressBookDto.setPincode("");
		}
		else
		{
			sourceAddressBookDto.setPincode(originPincode);
		}
		
		if(originCity == null || "null".equalsIgnoreCase(originCity))
		{
			sourceAddressBookDto.setCity("");
		}
		else
		{
			sourceAddressBookDto.setCity(originCity);
		}
		
		rateAndTransitDTO.setOriginAddress(sourceAddressBookDto);
		
		
		// Destination
		if(destinationPincode == null || "null".equalsIgnoreCase(destinationPincode))
		{
			destinationAddressBookDto.setPincode("");
		}
		else
		{
			destinationAddressBookDto.setPincode(destinationPincode);
		}
		
		if(destinationCity == null || "null".equalsIgnoreCase(destinationCity))
		{
			destinationAddressBookDto.setCity("");
		}
		else
		{
			destinationAddressBookDto.setCity(destinationCity);
		}
		
		destinationAddressBookDto.setCountryCode(destinationCountryCode);
		rateAndTransitDTO.setDestinationAddress(destinationAddressBookDto);
		
		// The date format is mm/dd/yy. While calling the service from liferay side, replace the "/" with "split", in the date string.
		// Later on java side replace "slpit" with "/" to obtain the orignal date format. This is shown in the below line.
		String bookingDateFormatted = bookingDate.replaceAll("split", "/");
		
		rateAndTransitDTO.setBookingDate(bookingDateFormatted);
		rateAndTransitDTO.setBookingTime(bookingTime);
		Double weight = Double.parseDouble(actualWeight);
		rateAndTransitDTO.setActualWeight(weight);
		rateAndTransitDTO.setIpAddress(ipAddress);
		rateAndTransitDTO.setLoginId(loginId);
		
		
		RateAndTransitDTO rateTransitDTO = finderService.findTransitTimePrice(rateAndTransitDTO);
		
		
		if(!rateTransitDTO.isError()) 
			rateTransitDTO.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		
		return rateTransitDTO;
		
	}
	/**
	 * 
	 * @param serviceException
	 * @return
	 * @Description Called when BlueDartException occurs.
	 */
	@ExceptionHandler(BlueDartException.class)
	private RateAndTransitDTO ttfException1(BlueDartException serviceException) {
		RateAndTransitDTO errorDto = new RateAndTransitDTO();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 * @Description Called when DataBaseException occurs.
	 */
	@ExceptionHandler(DataBaseException.class)
	private RateAndTransitDTO ttfException2(DataBaseException serviceException) {
		RateAndTransitDTO errorDto = new RateAndTransitDTO();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}

}
