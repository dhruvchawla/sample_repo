package com.bluedart.scheduleapickupbookashipment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bluedart.common.dto.AffiliatePermissionDto;
import com.bluedart.common.dto.CommodityDto;
import com.bluedart.common.dto.CurrencyDto;
import com.bluedart.common.dto.GenerateRequestPdfClientDto;
import com.bluedart.common.dto.GenerateRequestPdfDto;
import com.bluedart.common.dto.GenerateResponsePdfDto;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.common.service.AffiliatePermissionService;
import com.bluedart.common.service.CommodityService;
import com.bluedart.common.service.CurrencyService;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.scheduleapickupbookashipment.dto.CountryDto;
import com.bluedart.scheduleapickupbookashipment.dto.DeliveryTimeSlotDto;
import com.bluedart.scheduleapickupbookashipment.dto.ParcelShopDto;
import com.bluedart.scheduleapickupbookashipment.dto.PermissionDto;
import com.bluedart.scheduleapickupbookashipment.dto.PickupRegistrationDto;
import com.bluedart.scheduleapickupbookashipment.dto.PickupResponseDto;
import com.bluedart.scheduleapickupbookashipment.dto.StateDto;
import com.bluedart.scheduleapickupbookashipment.dto.ValueAddedPaperWorkDto;
import com.bluedart.scheduleapickupbookashipment.service.ScheduleBookShipmentService;
import com.bluedart.scheduleapickupbookashipment.utils.NotificationHandler;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */
@RestController
public class ScheduleaPickupBookaShipment {
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private ScheduleBookShipmentService scheduleBookShipmentService;
	
	@Autowired
	private AffiliatePermissionService affiliatePermissionService;
	
	@Autowired
	private NotificationHandler notificationHandler;
	
	
	/**
	 * 
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "spbs/getdeliverytimeslot/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public DeliveryTimeSlotDto getDeliveryTimeSlot(@PathVariable String pincode) {
		DeliveryTimeSlotDto deliveryTimeSlotDto = null;
		try{
			deliveryTimeSlotDto = scheduleBookShipmentService.getDeliveryTimeSlot(pincode);
			deliveryTimeSlotDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}catch(DataBaseException dataBaseException){
			deliveryTimeSlotDto = new DeliveryTimeSlotDto();
			deliveryTimeSlotDto.setErrorCode(dataBaseException.getErrorCode());
			deliveryTimeSlotDto.setErrorMessage(dataBaseException.getErrorMessage());
		}
		return deliveryTimeSlotDto;
	}
	
	/**
	 * 
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "spbs/getparcelshop/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ParcelShopDto getParcelShop(@PathVariable String pincode) {
		ParcelShopDto parcelShopDto = null;
		try{
			parcelShopDto = scheduleBookShipmentService.getParcelShop(pincode);
			parcelShopDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}catch(DataBaseException dataBaseException){
			parcelShopDto = new ParcelShopDto();
			parcelShopDto.setErrorCode(dataBaseException.getErrorCode());
			parcelShopDto.setErrorMessage(dataBaseException.getErrorMessage());
		}
		return parcelShopDto;
		
		
	}
	
	/**
	 * 
	 * @param adressID
	 * @return
	 */	
	@RequestMapping(value = "spbs/updatemostlyusedaddress/{adressID}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Boolean updatemostlyusedaddress(@PathVariable String adressID) {
		Boolean result = false;
		try{
			result = scheduleBookShipmentService.updateAddressID(adressID);
			
		}catch(DataBaseException dataBaseException){
			
		}
		return result;
		
		
	}
	
	/**
	 * 
	 * @param custcode
	 * @param areacode
	 * @return
	 */
	@RequestMapping(value = "spbs/getriskdetails/{custcode}/{areacode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getRiskDetails(@PathVariable String custcode, @PathVariable String areacode ) {
		return scheduleBookShipmentService.getRiskDetail(custcode, areacode);
	}
	
	/**
	 * 
	 * @param all
	 * @return
	 */
	@RequestMapping(value = "spbs/getcommoditydetails/{all}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CommodityDto getCommodityDetails(@PathVariable String all) {
		CommodityDto commodityDto = null;
		
		try{
			List<CommodityDto> listOfCommodityCode = commodityService.getCommodityDetails(); 
			if (null != listOfCommodityCode && !listOfCommodityCode.isEmpty()) {
				commodityDto = new CommodityDto();
				commodityDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
				commodityDto.setListOfCommodityCode(listOfCommodityCode);
			}
		}catch(DataBaseException dataBaseException){
			commodityDto = new CommodityDto();
			commodityDto.setErrorCode(dataBaseException.getErrorCode());
			commodityDto.setErrorMessage(dataBaseException.getErrorMessage());
		}
		
		
		return commodityDto;
	}
	
	/**
	 * 
	 * @param all
	 * @return
	 */
	@RequestMapping(value = "spbs/getcurrencycode/{all}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CurrencyDto getCurrencyCode(@PathVariable String all) {
		CurrencyDto currencyDto = null;
		try{
			List<CurrencyDto> listOfCurrencyCode = currencyService.getListOfCurrencyCode();
			if (null != listOfCurrencyCode && !listOfCurrencyCode.isEmpty()) {
				currencyDto = new CurrencyDto();
				currencyDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
				currencyDto.setListOfCurrencyCode(listOfCurrencyCode);
			}
		}catch(DataBaseException dataBaseException){
			currencyDto = new CurrencyDto();
			currencyDto.setErrorCode(dataBaseException.getErrorCode());
			currencyDto.setErrorMessage(dataBaseException.getErrorMessage());
		}
		
		return currencyDto;
	}
	
	/**
	 * 
	 * @param addrId
	 * @param loginId
	 * @param custCode
	 * @param areaCode
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "spbs/updatemstlycount/{addrId}/{loginId}/{custCode}/{areaCode}/{flag}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateMstlyCount(@PathVariable String addrId, @PathVariable String loginId,@PathVariable String custCode, @PathVariable String areaCode,@PathVariable String flag ) {
		return scheduleBookShipmentService.updateMstlyCount(Integer.valueOf(addrId), loginId, custCode, areaCode, Integer.valueOf(flag));
	}
	
	/**
	 * 
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "spbs/getservicecentercode/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateMstlyCount(@PathVariable String pincode ) {
		return scheduleBookShipmentService.getServiceCenterCode(pincode);
	}
	
	/**
	 * 
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "spbs/getservicecenterandareacode/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(@PathVariable String pincode ) {
		return scheduleBookShipmentService.getServiceCenterAndAreaCode(pincode);
	}
	
	/**
	 * 
	 * @param pickupRegistrationDto
	 * @return
	 */
	@RequestMapping(value = "spbs/generatetokennumber/pickupRegistrationDto", method = RequestMethod.POST)
	public PickupResponseDto generateTokenNumber(@RequestBody PickupRegistrationDto pickupRegistrationDto) {
		PickupResponseDto pickupResponseDto = null;
		try{
			pickupResponseDto = scheduleBookShipmentService.generateTokenNumber(pickupRegistrationDto);
			pickupResponseDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		} catch(BlueDartException blueDartException) {
			pickupResponseDto = new PickupResponseDto();
			pickupResponseDto.setErrorCode(blueDartException.getErrorCode());
			pickupResponseDto.setErrorMessage(blueDartException.getErrorMessage());
		}
		return pickupResponseDto;
	}
	
	@RequestMapping(value = "spbs/getvalueaddedservice/{custCode}/{custArea}/{fromPincode}/{toPincode}/{productCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ValueAddedPaperWorkDto getValueAddedService(@PathVariable String custCode, @PathVariable String custArea,
														@PathVariable String fromPincode, @PathVariable String toPincode,
														@PathVariable String productCode) {
		ValueAddedPaperWorkDto valueAddedPaperWorkDto = null; 
		try{
			valueAddedPaperWorkDto =  scheduleBookShipmentService.getValueAddedService(custCode, custArea, fromPincode, toPincode, productCode);
			valueAddedPaperWorkDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}catch(BlueDartException blueDartException) {
			valueAddedPaperWorkDto = new ValueAddedPaperWorkDto();
			valueAddedPaperWorkDto.setErrorCode(blueDartException.getErrorCode());
			valueAddedPaperWorkDto.setErrorMessage(blueDartException.getErrorMessage());
		}
		return valueAddedPaperWorkDto;
	}
	
	@RequestMapping(value = "spbs/validatepincode/{pincode}/{addrType}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String validatePincode(@PathVariable String pincode, @PathVariable String addrType, @PathVariable String loginId ) {
		String isValid = null;
		try{
			isValid = scheduleBookShipmentService.validatePincode(pincode, addrType, loginId);
		} catch(BlueDartException blueDartException){
			isValid = "EXP";
		}
		
		return isValid;
	}
	
	@RequestMapping(value = "spbs/getcountrycode/{countryName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountryCode(@PathVariable String countryName ) {
		String countryCode = null;
		try{
			countryCode = scheduleBookShipmentService.getCountryCode(countryName);
		} catch(BlueDartException blueDartException){
			countryCode = "EXP";
		}
		
		return countryCode;
	}
	
	@RequestMapping(value = "spbs/getcityname/{cityname}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCityName(@PathVariable String cityname ) {
		String returnCityName = null;
		try{
			returnCityName = scheduleBookShipmentService.getCityName(cityname);
		} catch(DataBaseException dataBaseException){
			returnCityName = "EXP";
		}
		
		return returnCityName;
	}
	
	@RequestMapping(value = "spbs/checkpermission/{loginId}/{areaCode}/{customerCode}/{permissionName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public PermissionDto checkPermission(@PathVariable String loginId, @PathVariable String areaCode,
			@PathVariable String customerCode,@PathVariable String permissionName) {
		PermissionDto permissionDto = new PermissionDto();
		List<String> list = new ArrayList<>();

		try {
			List<AffiliatePermissionDto> affiliatePermissionDtoList = affiliatePermissionService.getAffiliateLevelPermissions(loginId, areaCode, customerCode, permissionName);
			if (null != affiliatePermissionDtoList && !affiliatePermissionDtoList.isEmpty()) {
				for (AffiliatePermissionDto affiliatePermissionDto : affiliatePermissionDtoList) {
					list.add(affiliatePermissionDto.getPermissionName());
					list.add(affiliatePermissionDto.getPermissionValue());
				}
			}
			permissionDto.setPermissionName(list);
			permissionDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		} catch (BlueDartException blueDartException) {
			permissionDto.setErrorCode(blueDartException.getErrorCode());
			permissionDto.setErrorMessage(blueDartException.getErrorMessage());
		}
		return permissionDto;

	}
	
	@RequestMapping(value = "spbs/{all}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void test(){
		notificationHandler.sendSMS("12345678", "10-10-14", "9489866378");
	}
	
	/**
	 * 
	 * @param generateC2PCPDF
	 * @return
	 */
	@RequestMapping(value = "spbs/generatec2pcpdf/generateRequestPdfDto", method = RequestMethod.POST, headers="Accept=application/json")
	public GenerateResponsePdfDto generateC2PCPDF(@RequestBody GenerateRequestPdfDto generateRequestPdfDto) {
		GenerateResponsePdfDto generateResponsePdfDto = null;
		try{
			generateResponsePdfDto = scheduleBookShipmentService.generatePDF(generateRequestPdfDto);
			generateResponsePdfDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		} catch(BlueDartException blueDartException) {
			generateResponsePdfDto = new GenerateResponsePdfDto();
			generateResponsePdfDto.setErrorCode(blueDartException.getErrorCode());
			generateResponsePdfDto.setErrorMessage(blueDartException.getErrorMessage());
		}
		return generateResponsePdfDto;
	}
	
	@RequestMapping(value = "spbs/validatedeclaredvaluewithdomestic/{fromPincode}/{toPincode}/{declaredValue}/{vas}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int valDecValueWithDomestic(@PathVariable int fromPincode, @PathVariable int toPincode, @PathVariable int declaredValue, @PathVariable String vas ) {
		int validateDecValue = 0;
		System.out.println("test it");
		try{
			validateDecValue = scheduleBookShipmentService.valDecValueWithDomestic(fromPincode,toPincode,declaredValue,vas);
		} catch(BlueDartException blueDartException){
			//validateDecValue = "EXP";
		}
		return validateDecValue;
	}
	
	@RequestMapping(value = "spbs/convertcurrtoinr/{currCode}/{declaredValue}", method = RequestMethod.GET, headers = "Accept=application/json")
	public float getConvertedCurrToINR(@PathVariable String currCode, @PathVariable int declaredValue) {
		float inrValue = 0;
		try{
			inrValue = scheduleBookShipmentService.getConvertedCurrToINR(currCode,declaredValue);
		} catch(BlueDartException blueDartException){
			//validateDecValue = "EXP";
		}
		return inrValue;
	}
	
	/*@RequestMapping(value = "spbs/validateconsgnpin/{pincode}/{countryname}/{cityname}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<StatusDto> validateConsgnPin(@PathVariable("pincode") String pincode, @PathVariable("countryname") String countryName, @PathVariable("cityname") String cityName) {
		StatusDto statusDto = null;
		statusDto = scheduleBookShipmentService.validateConsgnPin(pincode, countryName, cityName);
		statusDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(statusDto, HttpStatus.OK);
	}*/
	
	/**
	 * Method to validtae consignee pincode
	 * @param pincode
	 * @param countryname
	 * @param cityname
	 * @return
	 */
	@RequestMapping(value = "spbs/validateconsgnpin/{pincode}/{countryname}/{cityname}", method = RequestMethod.GET, headers = "Accept=application/json")
	public StatusDto validateConsgnPin(@PathVariable String pincode, @PathVariable String countryname, @PathVariable String cityname ) {
		return scheduleBookShipmentService.validateConsgnPin(pincode, countryname, cityname);
	}
	
	@RequestMapping(value = "spbs/test2/{currCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public float test2(@PathVariable String currCode) {
		return 0L;
	}
	/**
	 * Method to get International city details
	 * @param cityname
	 * @param countrycode
	 * @return
	 */
	@RequestMapping(value = "spbs/getinternationalcity/{cityname}/{countrycode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<StatusDto> getInternationalCity(@PathVariable String cityname, @PathVariable String countrycode) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		statusDto = scheduleBookShipmentService.getInternationalCity(cityname, countrycode);
		return new ResponseEntity(statusDto, HttpStatus.OK);
	}
	/**
	 * Method to get GST Number
	 * @param loginid
	 * @param areacode
	 * @param custcode
	 * @return
	 */
	@RequestMapping(value = "spbs/getgstnumber/{addressid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<StatusDto> getGSTNumber(@PathVariable Integer addressid) {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		statusDto = scheduleBookShipmentService.getGSTNumber(addressid);
		return new ResponseEntity(statusDto, HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to retrieve the states based on country code.
	 * @param countryCode
	 * @return
	 */
	@RequestMapping(value = "/spbs/getstates/{countryCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public StateDto getStates(@PathVariable String countryCode) {		
		StateDto stateDto = scheduleBookShipmentService.getStates(countryCode);
		stateDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return stateDto;
	}
	
	
	@RequestMapping(value = "/spbs/getcountry/{countryCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CountryDto getCountry(@PathVariable String countryCode) {		
		CountryDto countryDto = scheduleBookShipmentService.getCountry(countryCode);
		countryDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return countryDto;
	}
	
}
