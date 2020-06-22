package com.bluedart.scheduleapickupbookashipment.dao;


import com.bluedart.common.dto.GenerateRequestPdfClientDto;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.scheduleapickupbookashipment.dto.CountryDto;
import com.bluedart.scheduleapickupbookashipment.dto.DeliveryTimeSlotDto;
import com.bluedart.scheduleapickupbookashipment.dto.ParcelShopDto;
import com.bluedart.scheduleapickupbookashipment.dto.StateDto;
import com.bluedart.scheduleapickupbookashipment.dto.ValueAddedPaperWorkDto;

/**
 * 
 * @author DH839598
 *
 */
public interface ScheduleBookShipmentDao {

	public DeliveryTimeSlotDto getDeliveryTimeSlot(String pincode);
	
	public Boolean updateAddressID(String adressID);
	
	public ParcelShopDto getParcelShop(String pincode);
	
	public String getRiskDetail(String custCode, String areaCode);
	
	public String updateMstlyCount(Integer addrId, String loginId, String custCode, String areaCode, Integer flag);
	
	public String getServiceCenterCode(String pincode);
	
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(String pincode);
	
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(String custCode,String custAreaCode);
	
	public String getUserId(String loginId);
	
	public ValueAddedPaperWorkDto getValueAddedService(String custCode, String custArea, String fromPincode,
			String toPincode, String productCode);
	
	public String validatePincode(String pincode, String addrType, String loginId);
	
	public int valDecValueWithDomestic(int fromPincode, int toPincode, int declaredValue, String vas);
	
	public float getConvertedCurrToINR(String currCode, int declaredValue);
	
	public String getCountryCode(String countryName);
	
	public String getCityName(String cityName);
	
	public String test();
	
	public StatusDto validateConsgnPin(String pincode, String countryName, String cityName);
	
	public StatusDto getInternationalCity(String cityName, String countryName);

	public StatusDto getGSTNumber(Integer addressId);
	
	public StateDto getStates(String countryCode);
	
	public CountryDto getCountry(String countryCode);
	
	
}
