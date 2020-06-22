package com.bluedart.common.webservice;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfPODStatusEntryApi;
import org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntry;
import org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryApi;
import org.datacontract.schemas._2004._07.bd_entities_common.EntityBase;
import org.datacontract.schemas._2004._07.bd_entities_common.ErrorBase;
import org.datacontract.schemas._2004._07.bd_entities_common.BDResponse;

import org.tempuri.OPSINBOUNDAPI;
import org.tempuri.OPSINBOUNDAPIResponse;

import org.tempuri.GetAwbSryAltInstruction;
import org.tempuri.GetAwbSryAltInstructionResponse;

import com.bluedart.pod.dto.PODDto;
import com.bluedart.pod.dto.SavePodEntryDto;
import com.bluedart.exception.FinderServiceException;
import com.bluedart.exception.FinderServiceFault;
import com.bluedart.utils.Constants;

public class SavePODEntryHandler {

	private static Log logger = LogFactory.getLog(SavePODEntryHandler.class);

	/**
	 * @param rateInputDto
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws RemoteException
	 * @throws FinderServiceException
	 */
	public static SavePodEntryDto savePODEntryDetails(SavePodEntryDto savePodEntryDtoObj) throws RemoteException, FinderServiceException {
		PODStatusEntryApi podStatusEntry = new PODStatusEntryApi();
		podStatusEntry.setHandheld(savePodEntryDtoObj.getHandHeld());
		podStatusEntry.setLocation(savePodEntryDtoObj.getLocation());
		podStatusEntry.setLoginId(savePodEntryDtoObj.getLoginId());
		podStatusEntry.setModifiedDate(savePodEntryDtoObj.getModifiedDate());
		podStatusEntry.setAWBNumber(savePodEntryDtoObj.getAwbNo());
		podStatusEntry.setBatchNumber(savePodEntryDtoObj.getBatchNumber());
		podStatusEntry.setConsigneeName(savePodEntryDtoObj.getConsignee());
		podStatusEntry.setCreditCardShipment(savePodEntryDtoObj.getCreditCardShipment());
		podStatusEntry.setDeliveryEmployeeCode(savePodEntryDtoObj.getDeliveryEmployeeCode());
		podStatusEntry.setIdentityGroup(savePodEntryDtoObj.getIdentityGroup());
		podStatusEntry.setIdentityNumber(savePodEntryDtoObj.getIdentityNumber());
		podStatusEntry.setIdentityType(savePodEntryDtoObj.getIdentityType());
		podStatusEntry.setLocationDetail(savePodEntryDtoObj.getLocationDetail());
		podStatusEntry.setLoggedInEmployeeCode(savePodEntryDtoObj.getLoggedInEmployeeCode());
		podStatusEntry.setMobileNumber(savePodEntryDtoObj.getMobileNumber());
		podStatusEntry.setNewAWBNumber(savePodEntryDtoObj.getNewAWBNumber());
		podStatusEntry.setNewDestination(savePodEntryDtoObj.getNewDestination());
		podStatusEntry.setOctroiConeeName(savePodEntryDtoObj.getOctroiConeeName());
		podStatusEntry.setOctroiDuty(savePodEntryDtoObj.getOctroiDuty());
		podStatusEntry.setOctroiMobileNo(savePodEntryDtoObj.getOctroiMobileNo());
		podStatusEntry.setPieces(savePodEntryDtoObj.getPieces());
		podStatusEntry.setPincode(savePodEntryDtoObj.getPinCode());
		podStatusEntry.setReceivedBy(savePodEntryDtoObj.getReceivedBy());
		podStatusEntry.setRelationCode(savePodEntryDtoObj.getRelationCode());
		podStatusEntry.setRemarks(savePodEntryDtoObj.getRemarks());
		podStatusEntry.setStatusCode(savePodEntryDtoObj.getStatusCode());
		podStatusEntry.setStatusDate(savePodEntryDtoObj.getStatusDate());
		podStatusEntry.setStatusTime(savePodEntryDtoObj.getStatusTime());
		podStatusEntry.setStatusType(savePodEntryDtoObj.getStatusType());
		podStatusEntry.setToDestinationArea(savePodEntryDtoObj.getToDestinationArea()); 

		ArrayOfPODStatusEntryApi arrOfPODStatusEntryApi = new ArrayOfPODStatusEntryApi();
		arrOfPODStatusEntryApi.addPODStatusEntryApi(podStatusEntry);

		ServiceOperationStub pickupQueryStub = new ServiceOperationStub();
		OPSINBOUNDAPI opsInboundAPI = new OPSINBOUNDAPI();

		opsInboundAPI.setStatusEntry(arrOfPODStatusEntryApi);
		OPSINBOUNDAPIResponse opsInboundAPIResp = pickupQueryStub.oPSINBOUNDAPI(opsInboundAPI);

		BDResponse bdResponse = opsInboundAPIResp.getOPSINBOUNDAPIResult();
		ErrorBase[] errors = bdResponse.getErrors().getErrorBase();
		savePodEntryDtoObj.setStatusInfo(errors[0].getStatusInformation().getValue());
		savePodEntryDtoObj.setErrorSeverity(errors[0].getErrorSeverity().getValue());
		logger.info("Status in savePODEntryDetails ::: "+errors[0].getStatusInformation().getValue());

		savePodEntryDtoObj.setStatusInfo(errors[0].getStatusInformation().getValue());
		return savePodEntryDtoObj;

	}

	public static PODDto getAwbSryAltInstruction( PODDto podDto ) {
		try {
			ServiceOperationStub pickupQueryStub = new ServiceOperationStub();

			GetAwbSryAltInstruction getAwbSryAltIns = new GetAwbSryAltInstruction();
			getAwbSryAltIns.setAwbNumber(podDto.getAwbNo());

			GetAwbSryAltInstructionResponse getAwbSryAltInsResp = pickupQueryStub.getAwbSryAltInstruction(getAwbSryAltIns);
			getAwbSryAltInsResp.getGetAwbSryAltInstructionResult();
			BDResponse getAwbSryAltResponse = getAwbSryAltInsResp.getGetAwbSryAltInstructionResult();
			ErrorBase[] getAwbSryAltErrors = getAwbSryAltResponse.getErrors().getErrorBase();
			podDto.setSryAltInsStatus(getAwbSryAltErrors[0].getStatusInformation().getValue());
			podDto.setSryAltInsError(getAwbSryAltResponse.getIsError());
			logger.info("awbSryAltInsStatus ::: "+getAwbSryAltErrors[0].getStatusInformation().getValue()+" isError ::: "+getAwbSryAltResponse.getIsError());
		}catch(Exception ex) {
			logger.error("EXCEPTION TYPE :",ex);
			logger.error("Exception caught in getAwbSryAltInstruction ::: "+ex);
		}

		return podDto;
	}

	/**
	 * @param errorCodeStr
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

}
