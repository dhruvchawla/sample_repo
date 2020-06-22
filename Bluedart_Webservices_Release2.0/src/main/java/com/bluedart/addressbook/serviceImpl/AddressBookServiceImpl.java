package com.bluedart.addressbook.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bluedart.addressbook.dao.AddressBookDao;
import com.bluedart.addressbook.dto.AddressAreaDto;
import com.bluedart.addressbook.dto.AddressBookDto;
import com.bluedart.addressbook.dto.AddressBookListDto;
import com.bluedart.addressbook.dto.CityDto;
import com.bluedart.addressbook.dto.CountryDto;
import com.bluedart.addressbook.dto.ImportDto;
import com.bluedart.addressbook.dto.SearchDto;
import com.bluedart.addressbook.dto.StateDto;
import com.bluedart.addressbook.service.AddressBookService;
import com.bluedart.common.dao.MISLogDao;
import com.bluedart.utils.Constants;

/**
 * @author AN765570
 *
 */
@Service
public class AddressBookServiceImpl implements AddressBookService{
	
	@Autowired
	private AddressBookDao addressBookDao;
	@Autowired
	private MISLogDao misLogDao;
	
	private static final Logger logger = Logger.getLogger(AddressBookServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getDetailsFromPincode(java.lang.String)
	 */
	@Override
	public AddressAreaDto getDetailsFromPincode(String pincode) {
		logger.debug(" AddressBookServiceImpl : checkNoOfAddresses");
		return addressBookDao.getDetailsFromPincode(pincode);
	}
	
	
	public AddressAreaDto getDetailsFromPincodeBookaShipment(String loginId,String pincode){
		logger.debug(" AddressBookServiceImpl : getDetailsFromPincodeBookaShipment");
		return addressBookDao.getDetailsFromPincodeBookaShipment(loginId,pincode);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getCountries()
	 */
	@Override
	public CountryDto getCountries() {
		logger.debug(" AddressBookServiceImpl : getCountries");
		return addressBookDao.getCountries();
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getCities(java.lang.String)
	 */
	@Override
	public CityDto getCities(String countryCode) {
		logger.debug(" AddressBookServiceImpl : getCities");
		return addressBookDao.getCities(countryCode);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getDefaultAndMostlyUsedAddresses(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AddressBookListDto getDefaultAndMostlyUsedAddresses(String loginId,
			String addressType,String flag) {
		logger.debug(" AddressBookServiceImpl : getDefaultAndMostlyUsedAddresses");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK,loginId);
		return addressBookDao.getDefaultAndMostlyUsedAddresses(loginId, addressType,flag);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getAddressList(com.bluedart.addressbook.dto.AddressBookListDto)
	 */
	@Override
	public AddressBookListDto getAddressList(AddressBookListDto addressBookListDto) {
		logger.debug(" AddressBookServiceImpl : getAddressList");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, addressBookListDto.getLoginId());
		return addressBookDao.getAddressList(addressBookListDto);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#addAddress(com.bluedart.addressbook.dto.AddressBookDto)
	 */
	@Override
	public AddressBookDto addAddress(AddressBookDto addressBookDto) {
		logger.debug(" AddressBookServiceImpl : addAddress");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, addressBookDto.getLoginId());
		return addressBookDao.addAddress(addressBookDto);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getAddressById(long, java.lang.String)
	 */
	@Override
	public AddressBookDto getAddressById(long addrId) {
		logger.debug(" AddressBookServiceImpl : getAddressById");
		return addressBookDao.getAddressById(addrId);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#updateAddress(com.bluedart.addressbook.dto.AddressBookDto)
	 */
	@Override
	public AddressBookDto updateAddress(AddressBookDto addressBookDto) {
		logger.debug(" AddressBookServiceImpl : updateAddress");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, addressBookDto.getLoginId());
		return addressBookDao.updateAddress(addressBookDto);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#deleteAddress(long, java.lang.String)
	 */
	@Override
	public AddressBookDto deleteAddress(long addrId,String loginId) {
		logger.debug(" AddressBookServiceImpl : deleteAddress");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, loginId);
		return addressBookDao.deleteAddress(addrId);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#importAddresses(com.bluedart.addressbook.dto.ImportDto)
	 */
	@Override
	public ImportDto importAddresses(ImportDto importDto) {
		logger.debug(" AddressBookServiceImpl : importAddresses");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, importDto.getLoginId());
		return addressBookDao.importAddresses(importDto);
	}

	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#exportAddresses(java.lang.String, java.lang.String)
	 */
	@Override
	public AddressBookDto exportAddresses(String loginId, String addressType) {
		logger.debug(" AddressBookServiceImpl : exportAddresses");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, loginId);
		return addressBookDao.exportAddresses(loginId, addressType);
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getSearchAddress(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AddressBookListDto getSearchAddress(String loginId,
			String searchAddress, String addrType) {
		logger.debug(" AddressBookServiceImpl : getSearchAddress");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, loginId);
		return addressBookDao.getSearchAddress(loginId, searchAddress, addrType);
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getSearchAddress(com.bluedart.addressbook.dto.SearchDto)
	 */
	@Override
	public AddressBookListDto getSearchAddress(SearchDto searchDto){
		logger.debug(" AddressBookServiceImpl : getSearchAddress");
		misLog(Constants.FEATURE_NAME_ADDRESS_BOOK, searchDto.getLoginId());
		return addressBookDao.getSearchAddress(searchDto);
	}
	
	/**
	 * This method is for MIS logs
	 * @param featureName
	 * @param loginId
	 */
	private void misLog(String featureName, String loginId) {
		if (!StringUtils.isEmpty(loginId)) {
			misLogDao.saveMIS(featureName, loginId);
		} else {
			misLogDao.saveMISWithOutLogin(featureName, "", "", "", "");
		} 
	}
	
	/**
	 * @param addressBookDto
	 * return addressBookDto
	 */
	
	public AddressBookDto getVendoCode(AddressBookDto addressBookDto)
	{
		return addressBookDao.getVendoCode(addressBookDto);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#validateDomesticIntlPin(java.lang.String)
	 */
	@Override
	public AddressAreaDto validateDomesticIntlPin(String pincode) {
		return addressBookDao.validateDomesticIntlPin(pincode);
	}
	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.service.AddressBookService#getStatess(java.lang.String)
	 */
	@Override
	public StateDto getStates(String countryCode) {
		logger.debug(" AddressBookServiceImpl : getStates");
		return addressBookDao.getStates(countryCode);
	}

	@Override
	public CountryDto getCountry(String countryName) {
		logger.debug(" AddressBookServiceImpl : getStates");
		return addressBookDao.getCountry(countryName);
	}


	@Override
	public CityDto getCitiesWithFilter(String countryCode, String cityValue) {
		logger.debug(" AddressBookServiceImpl : getCities");
		return addressBookDao.getCitiesWithFilter(countryCode ,cityValue);
	}

}
