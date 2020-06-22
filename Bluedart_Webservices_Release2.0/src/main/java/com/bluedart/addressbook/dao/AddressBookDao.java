package com.bluedart.addressbook.dao;

import com.bluedart.addressbook.dto.AddressAreaDto;
import com.bluedart.addressbook.dto.AddressBookDto;
import com.bluedart.addressbook.dto.AddressBookListDto;
import com.bluedart.addressbook.dto.CityDto;
import com.bluedart.addressbook.dto.CountryDto;
import com.bluedart.addressbook.dto.ImportDto;
import com.bluedart.addressbook.dto.SearchDto;
import com.bluedart.addressbook.dto.StateDto;

/**
 * @author AN765570
 *
 */
public interface AddressBookDao {

	/**
	 * This method is used to retrieve the default and mostly used addresses.
	 * @param loginId
	 * @param addressType
	 * @param flag
	 * @return
	 */
	public AddressBookListDto getDefaultAndMostlyUsedAddresses(String loginId,String addressType,String flag);
	
	/**
	 * This method is used to retrieve the city,state and country from pin code.
	 * @param pincode
	 * @return
	 */
	public AddressAreaDto getDetailsFromPincode(String pincode);
	/**
	 * 
	 * @param pincode
	 * @return
	 */
	public AddressAreaDto validateDomesticIntlPin(String pincode);
	
	/**
	 * This method is used to retrieve the city,state and country from pin code.
	 * @param pincode
	 * @return
	 */
	public AddressAreaDto getDetailsFromPincodeBookaShipment(String loginId,String pincode);
	
	
	/**
	 * This method is used to retrieve all the countries.
	 * @return
	 */
	public CountryDto getCountries();
	
	/**
	 * This method is used to retrieve the cities based on country code.
	 * @param countryCode
	 * @return
	 */
	public CityDto getCities(String countryCode);

	/**
	 * This method is used to retrieve the cities based on country code with city filter
	 * @param countryCode
	 * @return
	 */
	public CityDto getCitiesWithFilter(String countryCode ,String cityValue);

	/**
	 * This method is used to retrieve the address list with pagination.
	 * @param addressBookListDto
	 * @return
	 */
	public AddressBookListDto getAddressList(AddressBookListDto addressBookListDto);
	
	/**
	 * This method is used to insert an address.
	 * @param addressBookDto
	 * @return
	 */
	public AddressBookDto addAddress(AddressBookDto addressBookDto);
	
	/**
	 * This method is used to retrieve an address based on address id.
	 * @param addrId
	 * @return
	 */
	public AddressBookDto getAddressById(long addrId);
	
	/**
	 * This method is used to update an address.
	 * @param addressBookDto
	 * @return
	 */
	public AddressBookDto updateAddress(AddressBookDto addressBookDto);
	
	/**
	 * This method is used to delete an address.
	 * @param addrId
	 * @return
	 */
	public AddressBookDto deleteAddress(long addrId);
	
	
	/**
	 * This method is used to insert addresses from an excel file.
	 * @param importDto
	 * @return
	 */
	public ImportDto importAddresses(ImportDto importDto);
	
	/**
	 * This method is used to retrieve addresses to an excel file.
	 * @param loginId
	 * @param addressType
	 * @return
	 */
	public AddressBookDto exportAddresses(String loginId, String addressType);
	
	/**
	 * @param loginId
	 * @param searchAddress
	 * @param addrType
	 * @return
	 */
	public AddressBookListDto getSearchAddress(String loginId, String searchAddress, String addrType);
	
	/**
	 * @param searchDto
	 * @return
	 */
	public AddressBookListDto getSearchAddress(SearchDto searchDto);
	
	/**
	 * @param addressBookDto
	 * @return
	 */
	public AddressBookDto getVendoCode(AddressBookDto addressBookDto);

	/**
	 * This method is used to retrieve the states based on country code.
	 * @param countryCode
	 * @return
	 */
	public StateDto getStates(String countryCode);
	
	public CountryDto getCountry(String countryName);
	
}
