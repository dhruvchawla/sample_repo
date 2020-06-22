package com.bluedart.scheduleapickupbookashipment.serviceImpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfErrorBase;
import org.datacontract.schemas._2004._07.bd_entities_common.ErrorBase;
import org.datacontract.schemas._2004._07.bd_entities_enums_pickup.PickupValidationStatus;
import org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfInsertUpdateCalledPickupResponse;
import org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails;
import org.datacontract.schemas._2004._07.bd_entities_pickup.CalledPickupEntity;
import org.datacontract.schemas._2004._07.bd_entities_pickup.InsertUpdateCalledPickupResponse;
import org.datacontract.schemas._2004._07.bd_entities_pickup.PickupProductDetails;
import org.tempuri.RegisterCalledPickup;
import org.tempuri.RegisterCalledPickupResponse;

import com.bluedart.common.webservice.ServicePickupOperationStub;
import com.bluedart.exception.BlueDartException;
import com.bluedart.scheduleapickupbookashipment.dto.PickupRegistrationDto;
import com.bluedart.scheduleapickupbookashipment.dto.PickupResponseDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;

public class GenerateTokenNumberHelper {

	private static final Logger logger = Logger.getLogger(GenerateTokenNumberHelper.class);

	public PickupResponseDto invokeRegisterCalledPickup(PickupRegistrationDto pickupRegistrationDto) {

		PickupResponseDto pickupResponseDto = null;
		ServicePickupOperationStub servicePickupOperationStub = null;
		RegisterCalledPickup registerCalledPickup = null;
		CalledPickupEntity calledPickupEntity = null;
		PickupProductDetails pickupProductDetails = null;
		ArrayOfstring subProdCodeArray = null;
		RegisterCalledPickupResponse registerCalledPickupResponse = null;

		try {
			pickupResponseDto = new PickupResponseDto();
			servicePickupOperationStub = new ServicePickupOperationStub();

			registerCalledPickup = new RegisterCalledPickup();

			calledPickupEntity = new CalledPickupEntity();
			calledPickupEntity.setLoginId(pickupRegistrationDto.getLoginId());
		
			
			Calendar calendar = Calendar.getInstance();
			try {
				String[] listOfSplittedStr = stringSplit(pickupRegistrationDto.getShipmentPickupDate(), "/");

				if (null != listOfSplittedStr) {
					int day = Integer.parseInt(listOfSplittedStr[0]);
					int month = Integer.parseInt(listOfSplittedStr[1]) - 1;
					int year = Integer.parseInt(listOfSplittedStr[2]);

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar calendar1 = new GregorianCalendar(year, month, day);
					Date date1 = sdf.parse(sdf.format(calendar1.getTime()));
					calendar.setTime(date1);
				}
			} catch (ParseException e) {
				logger.error("EXCEPTION TYPE :",e);
				logger.error(e);
			}
			calledPickupEntity.setAreaCode(pickupRegistrationDto.getAreaCode());
			logger.info("AreaCode = "+pickupRegistrationDto.getAreaCode());
			
			calledPickupEntity.setContactPersonName(pickupRegistrationDto.getContactPerson());
			logger.info("ContactPersonName = "+pickupRegistrationDto.getContactPerson());
			
			calledPickupEntity.setCustomerAddress1(pickupRegistrationDto.getAddress1());
			logger.info("CustomerAddress1 = "+pickupRegistrationDto.getAddress1());
			
			calledPickupEntity.setCustomerAddress2(pickupRegistrationDto.getAddress2());
			logger.info("CustomerAddress2 = "+pickupRegistrationDto.getAddress2());
			
			calledPickupEntity.setCustomerAddress3(pickupRegistrationDto.getAddress3());
			logger.info("CustomerAddress3 = "+pickupRegistrationDto.getAddress3());
			
			calledPickupEntity.setCustomerCode(pickupRegistrationDto.getCustCode());
			logger.info("CustomerCode = "+pickupRegistrationDto.getCustCode());
			
			calledPickupEntity.setCustomerName(pickupRegistrationDto.getCustomerName());
			logger.info("CustomerName = "+pickupRegistrationDto.getCustomerName());
			
			calledPickupEntity.setCustomerPincode(pickupRegistrationDto.getPincode());
			logger.info("CustomerPincode = "+pickupRegistrationDto.getPincode());
			
			calledPickupEntity.setCustomerTelephoneNumber(pickupRegistrationDto.getTelephoneNumber());
			logger.info("CustomerTelephoneNumber = "+pickupRegistrationDto.getTelephoneNumber());
			
			calledPickupEntity.setMobileTelNo(pickupRegistrationDto.getMobileNumber());
			logger.info("MobileTelNo = "+pickupRegistrationDto.getMobileNumber());
			
			calledPickupEntity.setOfficeCloseTime(pickupRegistrationDto.getOfficeCloseTime()); //"1020"
			logger.info("OfficeCloseTime = "+pickupRegistrationDto.getOfficeCloseTime());
			
			calledPickupEntity.setShipmentPickupDate(calendar);
			logger.info("ShipmentPickupDate = "+calendar);
			
			calledPickupEntity.setShipmentPickupTime(
					pickupRegistrationDto.getShipmentPickupTime().trim());
			logger.info("ShipmentPickupTime = "+pickupRegistrationDto.getShipmentPickupTime().trim());
			
			calledPickupEntity.setVolumeWeight(Double.parseDouble(pickupRegistrationDto.getWeightOfTheShipment()));
			logger.info("VolumeWeight = "+Double.parseDouble(pickupRegistrationDto.getWeightOfTheShipment()));
			
			calledPickupEntity.setWeightofShipment(Double.parseDouble(pickupRegistrationDto.getWeightOfTheShipment()));
			logger.info("WeightofShipment = "+Double.parseDouble(pickupRegistrationDto.getWeightOfTheShipment()));
			
			int npcs = 1;
			if(pickupRegistrationDto.getNumberOfPieces()!="" && pickupRegistrationDto.getNumberOfPieces()!=null
					&& pickupRegistrationDto.getNumberOfPieces()!="0"){
				npcs = Integer.parseInt(pickupRegistrationDto.getNumberOfPieces());
			}else{
				npcs = 1;
			}
			
			calledPickupEntity.setNumberofPieces(npcs);
			logger.info("NumberOfPieces = "+npcs);
			
			calledPickupEntity.setAreaCode(pickupRegistrationDto.getAreaCode());
			logger.info("AreaCode = "+pickupRegistrationDto.getAreaCode());
			
			calledPickupEntity.setCustomerCode(pickupRegistrationDto.getCustCode());
			logger.info("CustomerCode = "+pickupRegistrationDto.getCustCode());
			
			calledPickupEntity.setRouteCode(Constants.ROUTECODE);
			logger.info("RouteCode = "+Constants.ROUTECODE);
			
			calledPickupEntity.setServiceCenterCode(pickupRegistrationDto.getServiceCenterCode());
			logger.info("ServiceCenterCode = "+pickupRegistrationDto.getServiceCenterCode());
			
			PickupProductDetails[] pickupProductDetailsArray = null;
			if (null != pickupRegistrationDto.getProductArray() && pickupRegistrationDto.getProductArray().length > 0) {
				
				// Iterator the ProductArray
				if (null != pickupRegistrationDto.getSubProductArray()
						&& pickupRegistrationDto.getSubProductArray().length > 0) {
					logger.info("-------- Product Code Details in If--------");
					pickupProductDetailsArray = new PickupProductDetails[pickupRegistrationDto.getSubProductArray().length ];
				for (int i = 0; i < pickupRegistrationDto.getSubProductArray().length; i++) {
					
					pickupProductDetails = new PickupProductDetails();
					
					pickupProductDetails.setProductCode(pickupRegistrationDto.getSubProductArray()[i].substring(0, 1));
						logger.info("ProductCode = "+pickupRegistrationDto.getSubProductArray()[i].substring(0, 1));
					//if (pickupRegistrationDto.getProductArray()[i]
					//		.equals(pickupRegistrationDto.getSubProductArray()[i].substring(0, 1))) {
						subProdCodeArray = new ArrayOfstring();
						logger.info("SubProductCode = "+pickupRegistrationDto.getSubProductArray()[i].substring(2,3));
						String[] subProdArrray = { pickupRegistrationDto.getSubProductArray()[i].substring(2,3) };
		 				subProdCodeArray.setString(subProdArrray);
						pickupProductDetails.setSubProductCode(subProdCodeArray);
						logger.info("PackType = "+pickupRegistrationDto.getSubProductArray()[i].substring(4,pickupRegistrationDto.getSubProductArray()[i].length()));
						pickupProductDetails.setPackType(pickupRegistrationDto.getSubProductArray()[i].substring(4,
								pickupRegistrationDto.getSubProductArray()[i].length()));
						
						pickupProductDetailsArray[i] = pickupProductDetails;
						
					//}
					// Iterator the SubProductArray
				/*	if (null != pickupRegistrationDto.getSubProductArray()
							&& pickupRegistrationDto.getSubProductArray().length > 0) {
						subProdCodeArray = new ArrayOfstring();
						
						for (int j = 0; j < pickupRegistrationDto.getSubProductArray().length; j++) {
							if (pickupRegistrationDto.getProductArray()[i]
									.equals(pickupRegistrationDto.getSubProductArray()[j].substring(0, 1))) {
								
								
								
								String[] subProdArrray = { pickupRegistrationDto.getSubProductArray()[j].substring(2,
										pickupRegistrationDto.getSubProductArray()[j].length()) };
								subProdCodeArray.setString(subProdArrray);
								
							}
						}
						pickupProductDetails.setSubProductCode(subProdCodeArray);
						
						// getSubProductArray End
						// If No value Added Service are selected, Then we need
						// set as empty
					} else {
						subProdCodeArray = new ArrayOfstring();
						String[] subProdArrray = {}; 
						subProdCodeArray.setString(subProdArrray);
						pickupProductDetails.setSubProductCode(subProdCodeArray);
						pickupProductDetailsArray[i] = pickupProductDetails;
					}*/
					//pickupProductDetailsArray[i] = pickupProductDetails;
 
				} // getProductArray End
			}else{
				logger.info("-------- Product Code Details in Else Block --------");
				int productLength = pickupRegistrationDto.getProductArray().length;
				pickupProductDetailsArray = new PickupProductDetails[productLength];
				for (int i = 0; i < productLength; i++) {
				pickupProductDetails = new PickupProductDetails();
				pickupProductDetails.setProductCode(pickupRegistrationDto.getProductArray()[i]);
				logger.info("ProductCode :"+pickupRegistrationDto.getProductArray()[i]);
				subProdCodeArray = new ArrayOfstring();
				String[] subProdArrray = {};
				subProdCodeArray.setString(subProdArrray);
				pickupProductDetails.setSubProductCode(subProdCodeArray);
				pickupProductDetailsArray[i] = pickupProductDetails;
				}
				}
			}
			
			ArrayOfPickupProductDetails arrayOfPickupProductDetails = new ArrayOfPickupProductDetails();
			arrayOfPickupProductDetails.setPickupProductDetails(pickupProductDetailsArray);

			calledPickupEntity.setProductDetails(arrayOfPickupProductDetails);
			
			registerCalledPickup.setCalledPickup(calledPickupEntity);
			logger.info("--------------------- Calling registerCalledPickup C2PC Service ---------------------");
			registerCalledPickupResponse = servicePickupOperationStub.registerCalledPickup(registerCalledPickup);

			ArrayOfInsertUpdateCalledPickupResponse arrayOfInsertUpdateCalledPickupResponse = registerCalledPickupResponse
					.getRegisterCalledPickupResult();
			InsertUpdateCalledPickupResponse[] calledPickupResponses = arrayOfInsertUpdateCalledPickupResponse
					.getInsertUpdateCalledPickupResponse();

			List<String> listOfTokenNumber = new ArrayList<>();
			logger.info("---------------------Recived Response from C2PC ---------------------");
			for (InsertUpdateCalledPickupResponse calledPickupResponse : calledPickupResponses) {

				ArrayOfErrorBase arrayOfErrorBases = calledPickupResponse.getErrors();
				ErrorBase[] bases = arrayOfErrorBases.getErrorBase();

				for (ErrorBase base : bases) {
					pickupResponseDto.setErrorSeverity(base.getErrorSeverity().getValue());
					pickupResponseDto.setStatusInformation(base.getStatusInformation().getValue());

				}
				
				SimpleDateFormat responseFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date responseDate = responseFormat
						.parse(responseFormat.format(calledPickupResponse.getShipmentPickupDate().getTime()));
				calendar.setTime(responseDate);
				pickupResponseDto.setScheduleConfirmedDate(responseFormat.format(calendar.getTime()));
				PickupValidationStatus pickupValidationStatus = calledPickupResponse.getStatus();
				pickupValidationStatus.getValue();
				listOfTokenNumber.add(calledPickupResponse.getTokenNumber());

				pickupResponseDto.setStatus(calledPickupResponse.getStatus().getValue());
				
				logger.info("ScheduleConfirmedDate =: "+responseFormat.format(calendar.getTime()));
				logger.info("Status =: "+calledPickupResponse.getStatus().getValue());
				logger.info("TokenNumbers =: "+calledPickupResponse.getTokenNumber());
				
			}

			pickupResponseDto.setListOfTokenNumber(listOfTokenNumber);
		} catch (RemoteException exception) {
			logger.error("EXCEPTION TYPE :",exception);
			logger.info("--------------Remote exception--------------");
			
			throw new BlueDartException(ErrorMessageStatusCode.C2PC_DOWN.getCode(),
					ErrorMessageStatusCode.C2PC_DOWN.getDescription());
		} catch (ParseException e) {
			logger.error("EXCEPTION TYPE :",e);
			logger.info("--------------Parse Exception exception--------------");
			throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),
					ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
		return pickupResponseDto;
	}

	private String[] stringSplit(String givenStr, String splitType) {
		String[] out = null;
		if (givenStr.contains(splitType)) {
			out = givenStr.split(splitType);
		}
		return out;
	}

}
