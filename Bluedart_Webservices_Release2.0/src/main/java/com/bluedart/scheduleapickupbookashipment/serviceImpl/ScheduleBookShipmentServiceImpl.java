package com.bluedart.scheduleapickupbookashipment.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.dto.GenerateRequestPdfClientDto;
import com.bluedart.common.dto.GenerateRequestPdfDto;
import com.bluedart.common.dto.GenerateResponsePdfDto;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.common.webservice.bookshipment.GenerateC2pcPdfHelper;
import com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao;
import com.bluedart.scheduleapickupbookashipment.dto.CountryDto;
import com.bluedart.scheduleapickupbookashipment.dto.DeliveryTimeSlotDto;
import com.bluedart.scheduleapickupbookashipment.dto.ParcelShopDto;
import com.bluedart.scheduleapickupbookashipment.dto.PickupRegistrationDto;
import com.bluedart.scheduleapickupbookashipment.dto.PickupResponseDto;
import com.bluedart.scheduleapickupbookashipment.dto.StateDto;
import com.bluedart.scheduleapickupbookashipment.dto.ValueAddedPaperWorkDto;
import com.bluedart.scheduleapickupbookashipment.service.ScheduleBookShipmentService;
import com.bluedart.scheduleapickupbookashipment.utils.NotificationHandler;
import com.bluedart.utils.Constants;
import com.bluedart.utils.StringUtils;

/**
 * 
 * @author DH839598
 *
 */
@Service
public class ScheduleBookShipmentServiceImpl implements ScheduleBookShipmentService{
	
	private static final Logger logger = Logger.getLogger(ScheduleBookShipmentServiceImpl.class);

	@Autowired
	private ScheduleBookShipmentDao scheduleBookShipmentDao;

	@Autowired
	private NotificationHandler notificationHandler;
	
	@Autowired
	private MISLogDao misLogDao;
	
	private String featureName = null;

	@Override
	public DeliveryTimeSlotDto getDeliveryTimeSlot(String pincode) {
		return scheduleBookShipmentDao.getDeliveryTimeSlot(pincode);
	}
	
	@Override
	public Boolean updateAddressID(String adressID) {
		return scheduleBookShipmentDao.updateAddressID(adressID);
	}
	

	@Override
	public ParcelShopDto getParcelShop(String pincode) {
		return scheduleBookShipmentDao.getParcelShop(pincode);
	}

	@Override
	public String getRiskDetail(String custCode, String areaCode) {
		return scheduleBookShipmentDao.getRiskDetail(custCode, areaCode);
	}

	@Override
	public String updateMstlyCount(Integer addrId, String loginId, String custCode, String areaCode, Integer flag) {
		return scheduleBookShipmentDao.updateMstlyCount(addrId, loginId, custCode, areaCode, flag);
	}

	@Override
	public String getServiceCenterCode(String pincode) {
		return scheduleBookShipmentDao.getServiceCenterCode(pincode);
	}
	
	@Override
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(String pincode) {
		return scheduleBookShipmentDao.getServiceCenterAndAreaCode(pincode);
	}

	@Override
	public PickupResponseDto generateTokenNumber(PickupRegistrationDto pickupRegistrationDto) {
		String loginId=pickupRegistrationDto.getLoginId();
		String userId =  scheduleBookShipmentDao.getUserId(pickupRegistrationDto.getLoginId());
		String serviceCenterCode = scheduleBookShipmentDao.getServiceCenterCode(pickupRegistrationDto.getPincode());
		pickupRegistrationDto.setLoginId(userId);
		pickupRegistrationDto.setServiceCenterCode(serviceCenterCode);
		PickupResponseDto pickupResponseDto = null;
		try{
		logger.info("--------------------------Calling invokeRegisterCalledPickup Method-----------------------------");
		 pickupResponseDto = new  GenerateTokenNumberHelper().invokeRegisterCalledPickup(pickupRegistrationDto);
		StringBuilder tokenNo = null;
		if (null != pickupResponseDto && null != pickupResponseDto.getListOfTokenNumber()) {
			tokenNo = new StringBuilder();
			for(String token : pickupResponseDto.getListOfTokenNumber()){
				tokenNo.append(token);
				tokenNo.append(",");
			}
		}

		String token = null;
		if (null != tokenNo && !(tokenNo.toString().trim().equalsIgnoreCase(","))) {
			token = tokenNo.toString();
		} 
		if(token!=null && !(token.equalsIgnoreCase("")) 
				&& null!=pickupResponseDto && null != pickupResponseDto.getListOfTokenNumber() 
				&& !(pickupResponseDto.getListOfTokenNumber().isEmpty())){
			boolean isMailSent = notificationHandler.sendEmail(StringUtils.removeLastComma(token), pickupResponseDto.getScheduleConfirmedDate(), 
					pickupRegistrationDto.getCustomerName(), pickupRegistrationDto.getEmailId(),
					pickupRegistrationDto.getAddress1(), pickupRegistrationDto.getAddress2(), pickupRegistrationDto.getPincode());
			logger.info(" shedule a pick sending email ::: "+isMailSent);
	        logger.info("confirmPickupDate From C2pc Java Serviceimpl::: "+pickupResponseDto.getScheduleConfirmedDate());
	        pickupResponseDto.setEmailSent(isMailSent);
			boolean isSMSSent = notificationHandler.sendSMS(StringUtils.removeLastComma(token), pickupResponseDto.getScheduleConfirmedDate(), pickupRegistrationDto.getMobileNumber());
			pickupResponseDto.setSmsSent(isSMSSent);
		}else{
			pickupResponseDto = new PickupResponseDto();
			pickupResponseDto.setErrorMessage("Error");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			logger.info("--------------------------Finally Block of generateTokenNumber method-----------------------------");
		featureName = Constants.SCHEDULE_PICKUP;
		logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+loginId);
		saveMISLog(featureName,loginId,null,null,null);
		logger.debug("---------- SAVED TO MIS LOG ----------");
		}
		return pickupResponseDto; 
	}

	@Override
	public String getUserId(String loginId) {
		return scheduleBookShipmentDao.getUserId(loginId);
	}

	@Override
	public ValueAddedPaperWorkDto getValueAddedService(String custCode, String custArea, String fromPincode,
			String toPincode, String productCode) {
		return scheduleBookShipmentDao.getValueAddedService(custCode, custArea, fromPincode, toPincode, productCode);
	}

	@Override
	public String validatePincode(String pincode, String addrType, String loginId) {
		return scheduleBookShipmentDao.validatePincode(pincode, addrType, loginId);
	}
	
	@Override
	public String getCountryCode(String countryName) {
		return scheduleBookShipmentDao.getCountryCode(countryName);
	}

	@Override
	public String getCityName(String cityName) {
		return scheduleBookShipmentDao.getCityName(cityName);
	}

	@Override
	public String test() {
		return null;
	}

	@Override
	public GenerateResponsePdfDto generatePDF(GenerateRequestPdfDto generateRequestPdfDto) {
		GenerateC2pcPdfHelper generateC2pcPdfHelper = new GenerateC2pcPdfHelper();
		GenerateRequestPdfClientDto generateReqPdfClientDto = new GenerateRequestPdfClientDto();
		String cntryCode = this.getCountryCode(generateRequestPdfDto.getCntryname());
		generateRequestPdfDto.setCcntrycode(cntryCode);
		System.out.println("cntryCode ::: "+cntryCode);
		generateReqPdfClientDto = scheduleBookShipmentDao.getServiceCenterAndAreaCode(generateRequestPdfDto.getCcneepin());
		generateRequestPdfDto.setCdstarea(generateReqPdfClientDto.getAreaCode());
		
		
		generateRequestPdfDto.setCdstscrcd(generateReqPdfClientDto.getServiceCentreCode());
		String loginId = generateRequestPdfDto.getLoginId();
		//else
			
		
		generateReqPdfClientDto = scheduleBookShipmentDao.getServiceCenterAndAreaCode(generateRequestPdfDto.getCcustcode(),generateRequestPdfDto.getCcustareacode());
		generateRequestPdfDto.setCorgarea(generateReqPdfClientDto.getAreaCode());
		generateRequestPdfDto.setCorgscrcd(generateReqPdfClientDto.getServiceCentreCode());
		
		System.out.println(generateReqPdfClientDto.getAreaCode());
		GenerateResponsePdfDto generateResponsePdfDto = null;
		try{
			 generateResponsePdfDto = generateC2pcPdfHelper.generatePDFData(generateRequestPdfDto, generateReqPdfClientDto);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			featureName = Constants.BOOK_SHIPMENT;
			logger.debug("---------- MIS LOG FOR FEATURE----------"+featureName+"LOGIN ID :"+loginId);
			saveMISLog(featureName,loginId,null,null,null);
			logger.debug("---------- SAVED TO MIS LOG ----------");
		}
		return generateResponsePdfDto;
	}
	
	@Override
	public int valDecValueWithDomestic(int fromPincode, int toPincode, int declaredValue, String vas) {
		return scheduleBookShipmentDao.valDecValueWithDomestic(fromPincode, toPincode,declaredValue,vas);
	}
	
	@Override
	public float getConvertedCurrToINR(String currCode, int declaredValue) {
		return scheduleBookShipmentDao.getConvertedCurrToINR(currCode,declaredValue);
	}

	@Override
	public StatusDto validateConsgnPin(String pincode, String countryName, String cityName){
		return scheduleBookShipmentDao.validateConsgnPin(pincode, countryName, cityName);
	}
	
	@Override
	public StatusDto getInternationalCity(String cityName, String countryCode){
		return scheduleBookShipmentDao.getInternationalCity(cityName, countryCode); 
	}

	@Override
	public StatusDto getGSTNumber(Integer addressId) {
		return scheduleBookShipmentDao.getGSTNumber(addressId);
	}
	
	
	@Override
	public StateDto getStates(String countryCode) {
		return scheduleBookShipmentDao.getStates(countryCode);
	}
	
	@Override
	public CountryDto getCountry(String countryCode) {
		return scheduleBookShipmentDao.getCountry(countryCode);
	}
	
	private boolean saveMISLog(String featureName, String loginId, String ipAddress,String emailId,String awbNo){
		if(featureName != null && loginId != null){
			logger.debug("MIS Log With Feature Name & LoginId : "+featureName);
			return misLogDao.saveMIS(featureName, loginId);
		}else if(featureName != null && ipAddress != null){
			logger.debug("MIS Log With Feature Name & IPAddress : "+featureName);
			return misLogDao.saveMISWithOutLogin(featureName, emailId,ipAddress,awbNo, "");
		}else
			return false;
	}
	
}
