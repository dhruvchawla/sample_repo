package com.bluedart.addressbook.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.addressbook.dto.AddressAreaDto;
import com.bluedart.addressbook.dto.AddressBookDto;
import com.bluedart.addressbook.dto.AddressBookListDto;
import com.bluedart.addressbook.dto.CityDto;
import com.bluedart.addressbook.dto.CountryDto;
import com.bluedart.addressbook.dto.ImportDto;
import com.bluedart.addressbook.dto.SearchDto;
import com.bluedart.addressbook.dto.StateDto;
import com.bluedart.addressbook.service.AddressBookService;
import com.bluedart.common.dto.AffiliatePermissionDto;
import com.bluedart.common.service.AffiliatePermissionService;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author AN765570
 *
 */
@RestController
public class AddressBookController {

	@Autowired
	private AddressBookService addressBookService;
	
	@Autowired
	private AffiliatePermissionService affiliatePermissionService;
	
	private static final Logger logger = Logger.getLogger(AddressBookController.class);
	
	/**
	 * This method is used to retrieve the default and mostly used addresses.
	 * @param loginId
	 * @param addressType
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getdefaultandmostlyusedaddresses/{loginId}/{addressType}/{flag}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookListDto getDefaultAndMostlyUsedAddresses(@PathVariable String loginId,@PathVariable String addressType, @PathVariable String flag){
		logger.debug(" AddressBookController : getDefaultAndMostlyUsedAddresses");
		AddressBookListDto addressBookListDto = addressBookService.getDefaultAndMostlyUsedAddresses(loginId, addressType ,flag);	
		addressBookListDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookListDto;
	}
	
	
	/**
	 * This method is used to retrieve the affiliates.
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getaffiliates/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AffiliatePermissionDto getAffiliates(@PathVariable String loginId) {
		logger.debug(" AddressBookController : getAffiliates");
		String permissionName = "SHIPPER_ADDRESS_BOOK-CREATE_UPDATE_DELETE";
		List<AffiliatePermissionDto> affiliatePermissionDtos = affiliatePermissionService.getAffiliateLevelPermissions(loginId, null, null, permissionName);
		AffiliatePermissionDto affiliatesPermissionDto = new AffiliatePermissionDto();
		affiliatesPermissionDto.setAffiliatePermissionList(affiliatePermissionDtos);
		affiliatesPermissionDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return affiliatesPermissionDto;
	}
	
	
	/**
	 * This method is used to retrieve the city,state and country from pin code.
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getdetailsfrompincode/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressAreaDto getDetailsFromPincode(@PathVariable String pincode) {
		logger.debug(" AddressBookController : getDetailsFromPincode");
		AddressAreaDto addressAreaDto = addressBookService.getDetailsFromPincode(pincode);
		if(null!=addressAreaDto){
			addressAreaDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}
		return addressAreaDto;
	}
	
	/**
	 * This method is used to retrieve the city,state and country from pin code.
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "/addressbook/validatedomesticintlpin/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressAreaDto validateDomesticIntlPin(@PathVariable String pincode) {
		logger.debug(" AddressBookController : validateDomesticIntlPin");
		AddressAreaDto addressAreaDto = addressBookService.validateDomesticIntlPin(pincode);
		if(null!=addressAreaDto){
			addressAreaDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}
		return addressAreaDto;
	}
	
	/**
	 * This method is used to retrieve the city,state and country from pin code.
	 * @param pincode
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getDetailsBookaShipmentFromPincode/{loginId}/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressAreaDto getDetailsBookaShipmentFromPincode(@PathVariable String loginId,@PathVariable String pincode) {
		logger.debug(" AddressBookController : getDetailsBookaShipmentFromPincode");
		AddressAreaDto addressAreaDto = addressBookService.getDetailsFromPincodeBookaShipment(loginId, pincode);
		if(null!=addressAreaDto){
			addressAreaDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}
		return addressAreaDto;
	}
	
	/**
	 * This method is used to retrieve all the countries.
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getcountries/", method = RequestMethod.GET, headers = "Accept=application/json")
	public CountryDto getCountries() {
		logger.debug(" AddressBookController : getCountries");
		CountryDto cntryDto = addressBookService.getCountries();
		cntryDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return cntryDto;
	}
	
	/**
	 * This method is used to retrieve the cities based on country code.
	 * @param countryCode
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getcities/{countryCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CityDto getCities(@PathVariable String countryCode) {
		logger.debug(" AddressBookController : getCities");
		CityDto cityDto = addressBookService.getCities(countryCode);
		cityDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return cityDto;
	}
	
	@RequestMapping(value = "/addressbook/getcities/{countryCode}/{cityValue}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CityDto getCitiesWithFilter(@PathVariable String countryCode ,@PathVariable String cityValue)
	{
		logger.debug(" AddressBookController : getCities");
		CityDto cityDto = addressBookService.getCitiesWithFilter(countryCode ,cityValue);
		cityDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return cityDto;
	}
	
	/**
	 * This method is used to retrieve the address list with pagination.
	 * @param addressBookListDto
	 * @return
	 */
	@RequestMapping(value = "/addressbook/addressBookList", method = RequestMethod.POST)
	public AddressBookListDto getAddressList(@RequestBody AddressBookListDto addressBookListDto){
		logger.debug(" AddressBookController : getAddressList");
		AddressBookListDto addressBookListDto1 = addressBookService.getAddressList(addressBookListDto);
		addressBookListDto1.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookListDto1;
	}
	
	/**
	 * This method is used to insert an address.
	 * @param addressBookDto
	 * @return
	 */
	@RequestMapping(value = "/addressbook/addAddressBookDto", method = RequestMethod.POST)
	public AddressBookDto addAddress(@RequestBody AddressBookDto addressBookDto){
		logger.debug(" AddressBookController : addAddress");
		AddressBookDto addressBookDto1 = addressBookService.addAddress(addressBookDto);
		addressBookDto1.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto1;
	}
	
	/**
	 * This method is used to retrieve an address based on address id.
	 * @param addrId
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getaddressbyid/{addrId}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookDto getAddressById(@PathVariable long addrId){
		logger.debug(" AddressBookController : getAddressById");
		AddressBookDto addressBookDto = addressBookService.getAddressById(addrId);
		addressBookDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto;
	}
	
	/**
	 * This method is used to update an address.
	 * @param addressBookDto
	 * @return
	 */
	@RequestMapping(value = "/addressbook/updateAddressBookDto", method = RequestMethod.POST)
	public AddressBookDto updateAddress(@RequestBody AddressBookDto addressBookDto){
		logger.debug(" AddressBookController : updateAddress");
		AddressBookDto addressBookDto1 = addressBookService.updateAddress(addressBookDto);
		addressBookDto1.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto1;
	}
	
	/**
	 * This method is used to delete an address.
	 * @param addrId
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/addressbook/deleteaddress/{addrId}/{loginId}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookDto deleteAddress(@PathVariable long addrId,@PathVariable String loginId){
		logger.debug(" AddressBookController : deleteAddress");
		AddressBookDto addressBookDto = addressBookService.deleteAddress(addrId,loginId);
		addressBookDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto;
	}
	
	/**
	 * This method is used to insert addresses from an excel file.
	 * @param importDto
	 * @return
	 */
	@RequestMapping(value = "/addressbook/importaddressesdto", method = RequestMethod.POST)
	public ImportDto importAddresses(@RequestBody ImportDto importDto){
		logger.debug(" AddressBookController : importAddresses");
		ImportDto importDto2 = addressBookService.importAddresses(importDto);
		importDto2.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return importDto2; 
	}
	
	/**
	 * This method is used to retrieve addresses to an excel file.
	 * @param loginId
	 * @param addressType
	 * @return
	 */
	@RequestMapping(value = "/addressbook/exportaddresses/{loginId}/{addressType}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookDto exportAddresses(@PathVariable String loginId, @PathVariable String addressType){
		logger.debug(" AddressBookController : exportAddresses");
		AddressBookDto addressBookDto = addressBookService.exportAddresses(loginId, addressType);
		addressBookDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto;
	}
	
	/**
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getsearchaddressdto", method = RequestMethod.POST)
	public AddressBookListDto getSearchAddress(@RequestBody SearchDto searchDto){
		logger.debug(" AddressBookController : getSearchAddress");
		AddressBookListDto addressBookListDto = addressBookService.getSearchAddress(searchDto);	
		addressBookListDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookListDto;
	}
	
	/**
	 * @param loginId
	 * @param searchAddress
	 * @param addrType
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getsearchaddress/{loginId}/{searchAddress}/{addrType}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookListDto getSearchAddress(@PathVariable String loginId,@PathVariable String searchAddress, @PathVariable String addrType){
		logger.debug(" AddressBookController : getSearchAddress");
		AddressBookListDto addressBookListDto = addressBookService.getSearchAddress(loginId, searchAddress ,addrType);	
		addressBookListDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookListDto;
	}
	
	/**
	 * This method is used to check if an affiliate has exceeded the number of addresses allowed to be created. 
	 * @param loginId
	 * @param areaCode
	 * @param customerCode
	 * @param permissionName
	 * @return
	 */
	@RequestMapping(value = "/addressbook/checknoofaddresses/{loginId}/{areaCode}/{customerCode}/{permissionName}",method = RequestMethod.GET, headers = "Accept=application/json")
	public AddressBookDto checkNoOfAddresses(@PathVariable String loginId,@PathVariable String areaCode,@PathVariable String customerCode,@PathVariable String permissionName){
		logger.debug(" AddressBookController : checkNoOfAddresses");
		AddressBookDto addressBookDto = new AddressBookDto();
		String noOfAddresses;
		boolean addressCreationAllowed = false;
        List<AffiliatePermissionDto> affiliates = affiliatePermissionService.getAffiliateLevelPermissions(loginId, areaCode, customerCode, permissionName);	
		for (AffiliatePermissionDto affiliatePermissionDto : affiliates) {
			if(permissionName.equalsIgnoreCase(affiliatePermissionDto.getPermissionName())){
				noOfAddresses = affiliatePermissionDto.getPermissionValue();
				String[] addressCountSplitted = noOfAddresses.split("-");
				if(Integer.parseInt(addressCountSplitted[1]) < Integer.parseInt(addressCountSplitted[0])){
					addressCreationAllowed = true;
				}else{
					addressCreationAllowed = false;
				}
			}
		}
        addressBookDto.setAddressCreationAllowed(addressCreationAllowed);
		addressBookDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto;
	}
	
	/**
	 * This private method is used for exception handling
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private AddressBookDto myError(DataBaseException serviceException) {
		AddressBookDto addressBookDto = new AddressBookDto();
		addressBookDto.setErrorCode(serviceException.getErrorCode());
		addressBookDto.setErrorMessage(serviceException.getErrorMessage());
		return addressBookDto;
	}
	
	@RequestMapping(value = "/addressbook/getVendoCodeDto", method = RequestMethod.POST)
	public AddressBookDto getVendoCode(@RequestBody AddressBookDto addressBookDto){
		//logger.debug(" AddressBookController : addAddress");
		AddressBookDto addressBookDto2 = addressBookService.getVendoCode(addressBookDto);
		addressBookDto2.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return addressBookDto2;
	}
	
	/**
	 * This method is used to retrieve the states based on country code.
	 * @param countryCode
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getstates/{countryCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public StateDto getStates(@PathVariable String countryCode) {
		logger.debug(" AddressBookController : getStates");
		StateDto stateDto = addressBookService.getStates(countryCode);
		stateDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return stateDto;
	}
	
	
	/**
	 * This method is used to retrieve the country.
	 * @return
	 */
	@RequestMapping(value = "/addressbook/getcountry/{countryName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CountryDto getCountry(@PathVariable String countryName) {
		logger.debug(" AddressBookController : getCountries");
		CountryDto cntryDto = addressBookService.getCountry(countryName);
		cntryDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return cntryDto; 
	}
	
	
}

