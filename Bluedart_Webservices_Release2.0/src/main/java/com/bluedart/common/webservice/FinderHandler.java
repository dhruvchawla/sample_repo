package com.bluedart.common.webservice;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.datacontract.schemas._2004._07.bd_entities_common.EntityBase;
import org.datacontract.schemas._2004._07.bd_entities_common.ErrorBase;
import org.datacontract.schemas._2004._07.bd_entities_enums_pickup.PickupValidationStatus;
import org.datacontract.schemas._2004._07.bd_entities_pickup.PickupError;
import org.datacontract.schemas._2004._07.bd_entities_pickup.PickupResponse;
import org.datacontract.schemas._2004._07.bd_entities_pickup.PickupShipmentDate;
import org.datacontract.schemas._2004._07.bd_entities_pickup.RateQueryInput;
import org.datacontract.schemas._2004._07.bd_entities_pickup.RateQueryOutput;
import org.tempuri.GetEDDDate;
import org.tempuri.GetEDDDateResponse;
import org.tempuri.GetTotalRateCA;
import org.tempuri.GetTotalRateCAResponse;

import com.bluedart.common.webservice.ServicePickupQueryStub;
import com.bluedart.pricefinder.dto.RateAndTransitDTO;
import com.bluedart.pricefinder.dto.RateInputDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.FinderServiceException;
import com.bluedart.exception.FinderServiceFault;
import com.bluedart.utils.Constants;

/**
 * @author Subhransu kumar Maharana
 * This is a helper class where C2PC web service is consumed and called    
 * 
 *
 */
public class FinderHandler {

	private FinderHandler() {
	}

	private static Log logger = LogFactory.getLog(FinderHandler.class);

	/**
	 * @param rateInputDto
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws RemoteException
	 * @throws FinderServiceException
	 * @Description In this method, C2PC method is called to find the price.
	 */
	public static double findRate(RateInputDto rateInputDto) throws RemoteException, FinderServiceException{
		ServicePickupQueryStub pickupQueryStub = new ServicePickupQueryStub();

		GetTotalRateCA getTotalRateCA = new GetTotalRateCA();
		RateQueryInput rateQueryInput = new RateQueryInput();
		RateQueryOutput rateQueryOutput = new RateQueryOutput();
		rateQueryInput.setCustomerCode(rateInputDto.getCustomerCode());
		rateQueryInput.setOriginArea(rateInputDto.getOriginAreaCode());
		rateQueryInput.setDestinationArea(rateInputDto.getDestinationAreaCode());
		rateQueryInput.setDestinationPincode(rateInputDto.getDestinationPincode());
		rateQueryInput.setProductCode(rateInputDto.getProductCode());
		rateQueryInput.setProductType(rateInputDto.getProductType());
		rateQueryInput.setActualWeight(rateInputDto.getActualWeight());
		rateQueryInput.setInsurance(rateInputDto.getInsurance());
		rateQueryInput.setTransactionCode("1");

		getTotalRateCA.setRateQueryInput(rateQueryInput);
		GetTotalRateCAResponse getTotalRateCAResponse = pickupQueryStub.getTotalRateCA(getTotalRateCA);
		PickupResponse pickupResponse = getTotalRateCAResponse.getGetTotalRateCAResult();
		ErrorBase[] errors = pickupResponse.getErrors().getErrorBase();

		if (errors == null || errors.length == 0
				|| "Warning".equalsIgnoreCase(errors[0].getErrorSeverity().getValue())) {
			EntityBase[] entityBases = pickupResponse.getEntity().getEntityBase();
			for (EntityBase entityBase2 : entityBases) {
				rateQueryOutput.setGrandTotal(((RateQueryOutput) entityBase2).getGrandTotal());
			}
		} else {
			logger.error("Error Occured");

			for (ErrorBase errorBase : errors) {
				PickupValidationStatus errorCode = ((PickupError) errorBase).getErrorCode();
				String errorCodeStr = errorCode.getValue();
				FinderServiceFault fault = getFault(errorCodeStr);
				logger.error("EXCEPTION TYPE :" + errorCodeStr);
			
				throw new BlueDartException(errorCodeStr, fault.getFaultString());
			}
		}
		return rateQueryOutput.getGrandTotal();
	}

	/**
	 * 
	 * @param errorCodeStr
	 * @return
	 * @Description This method returns the fault details
	 */
	private static FinderServiceFault getFault(String errorCodeStr) {
		FinderServiceFault fault = new FinderServiceFault();
		switch (errorCodeStr.toUpperCase()) {
		case "INVALIDORIGINAREACODE":
			fault.setFaultCode(Constants.FINDER_ORIGIN_ERRORCODE);
			fault.setFaultString("InvalidOriginAreaCode");
			break;
		case "INVALIDDESTAREACODE":
			fault.setFaultCode(Constants.FINDER_DESTINATION_ERRORCODE);
			fault.setFaultString("InvalidDestAreaCode");
			break;
		case "INVALIDPINCODE":
			fault.setFaultCode(Constants.FINDER_PINCODE_ERRORCODE);
			fault.setFaultString("InvalidPinCode");
			break;
		case "DESTINATIONAREANOTINTERNATIONAL":
			fault.setFaultCode(Constants.FINDER_DESTINATION_INTL_ERRORCODE);
			fault.setFaultString("DestinationAreaNotInternational");
			break;
		default:
			fault.setFaultCode("999");
			fault.setFaultString(errorCodeStr);
			break;
		}

		return fault;
	}
	
	public static String findTransitTime(RateAndTransitDTO rateAndTransitDTO,String originPincode, String destinationPincode) throws RemoteException, FinderServiceException{
		ServicePickupQueryStub pickupQueryStub = new ServicePickupQueryStub();

		PickupShipmentDate shipdateOutput = new PickupShipmentDate();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date= new Date();
		GetEDDDate getNewShipmentDate = new GetEDDDate();
		try {
			date = sdf.parse(rateAndTransitDTO.getBookingDate());
			String date1= new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println("formatted Date : "+date1);
			Date date12 =sdf1.parse(date1);
			System.out.println("Date sent : "+date12);
			getNewShipmentDate.setPickupDate(date12);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		getNewShipmentDate.setAwbNumber("11111111111");
		getNewShipmentDate.setOriginAreaCode(rateAndTransitDTO.getOriginAreaCode());
		getNewShipmentDate.setOriginServiceCenterCode(rateAndTransitDTO.getOriginServiceCenterCode());
		getNewShipmentDate.setPickupTime(rateAndTransitDTO.getBookingTime());
		getNewShipmentDate.setDestinationAreaCode(rateAndTransitDTO.getDestinationAreaCode());
		getNewShipmentDate.setDestinationServiceCenterCode(rateAndTransitDTO.getDestinationServiceCenterCode());
		getNewShipmentDate.setProductCode(rateAndTransitDTO.getProductCode());
		getNewShipmentDate.setOriginPincode(originPincode);
		getNewShipmentDate.setDestinationPincode(destinationPincode);
		getNewShipmentDate.setSubProductCode(null);
		GetEDDDateResponse newShipmentDateResponse = new GetEDDDateResponse();
		PickupResponse pickupResponse= new PickupResponse();
		try{
			 newShipmentDateResponse=  pickupQueryStub.getEDDDate(getNewShipmentDate);
			 pickupResponse = newShipmentDateResponse.getGetEDDDateResult();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error :"+ e);
		}
		

		if (pickupResponse.getErrors() == null) {
			EntityBase[] entityBases = pickupResponse.getEntity().getEntityBase();
			
			if (entityBases != null && entityBases.length > 0) 
			{				
				for (EntityBase entityBase2 : entityBases) {
					shipdateOutput.setExpectedDateDelivery(((PickupShipmentDate) entityBase2).getExpectedDateDelivery());
				}
			}
		}
		else 
		{
			logger.error("Error Occured");
			ErrorBase[] errors = pickupResponse.getErrors().getErrorBase();
			for (ErrorBase errorBase : errors) {
				PickupValidationStatus errorCode = ((PickupError) errorBase).getErrorCode();
				String errorCodeStr = errorCode.getValue();
				FinderServiceFault fault = getFault(errorCodeStr);
				logger.error("Error Code :" + errorCodeStr);
				throw new BlueDartException(errorCodeStr, fault.getFaultString());
			}			
		}

		String strDate ="";
		try {			
			date = new SimpleDateFormat("dd-MMM-yy").parse(shipdateOutput.getExpectedDateDelivery());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
			strDate = dateFormat.format(date);  
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return strDate;
	}

}
