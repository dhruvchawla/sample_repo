
/**
 * PickupValidationStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package org.datacontract.schemas._2004._07.bd_entities_enums_pickup;


/**
 *  PickupValidationStatus bean class
 */
@SuppressWarnings({"unchecked","unused"})

public  class PickupValidationStatus
implements org.apache.axis2.databinding.ADBBean{

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
			"http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Pickup",
			"PickupValidationStatus",
			"ns11");



	/**
	 * field for PickupValidationStatus
	 */


	protected java.lang.String localPickupValidationStatus ;

	private static java.util.HashMap _table_ = new java.util.HashMap();

	// Constructor

	protected PickupValidationStatus(java.lang.String value, boolean isRegisterValue) {
		localPickupValidationStatus = value;
		if (isRegisterValue){

			_table_.put(localPickupValidationStatus, this);

		}

	}

	public static final java.lang.String _Valid =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Valid");

	public static final java.lang.String _Invalid =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Invalid");

	public static final java.lang.String _InsertFailure =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InsertFailure");

	public static final java.lang.String _InsertSuccess =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InsertSuccess");

	public static final java.lang.String _UpdateFailure =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UpdateFailure");

	public static final java.lang.String _UpdateSuccess =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UpdateSuccess");

	public static final java.lang.String _DeleteFailure =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeleteFailure");

	public static final java.lang.String _DeleteSuccess =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeleteSuccess");

	public static final java.lang.String _CancelSuccess =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CancelSuccess");

	public static final java.lang.String _TokenNotFound =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TokenNotFound");

	public static final java.lang.String _TokenAPPLICATION_ERROR =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TokenAPPLICATION_ERROR");

	public static final java.lang.String _TokenNULL_VALUES =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TokenNULL_VALUES");

	public static final java.lang.String _InvalidPickupSerialNo =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupSerialNo");

	public static final java.lang.String _InvalidClientName =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidClientName");

	public static final java.lang.String _InvalidPinCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPinCode");

	public static final java.lang.String _InvalidAddress1 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAddress1");

	public static final java.lang.String _InvalidAddress2 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAddress2");

	public static final java.lang.String _InvalidAddress3 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAddress3");

	public static final java.lang.String _InvalidPickupDays =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupDays");

	public static final java.lang.String _InvalidPickupTime =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupTime");

	public static final java.lang.String _InfoPickupDoesNotExist =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPickupDoesNotExist");

	public static final java.lang.String _InvalidOfficeCloseTime =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOfficeCloseTime");

	public static final java.lang.String _InvalidOriginAreaCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOriginAreaCode");

	public static final java.lang.String _InvalidDestAreaCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidDestAreaCode");

	public static final java.lang.String _InvalidOriginScCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOriginScCode");

	public static final java.lang.String _InvalidDestScCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidDestScCode");

	public static final java.lang.String _InvalidOriginAreaCodeNotBlank =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOriginAreaCodeNotBlank");

	public static final java.lang.String _InvalidDestAreaCodeNotBlank =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidDestAreaCodeNotBlank");

	public static final java.lang.String _RegularDataTransfer =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RegularDataTransfer");

	public static final java.lang.String _ServiceCentreCannotBeBlank =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ServiceCentreCannotBeBlank");

	public static final java.lang.String _DestinationAreaNotInternational =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DestinationAreaNotInternational");

	public static final java.lang.String _ValueToLargeToCaculate =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ValueToLargeToCaculate");

	public static final java.lang.String _NoDataFoundException =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NoDataFoundException");

	public static final java.lang.String _UnauthorisedServiceCentre =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UnauthorisedServiceCentre");

	public static final java.lang.String _InfoCustNotBelongsToServicesCenter =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoCustNotBelongsToServicesCenter");

	public static final java.lang.String _InvalidClientCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidClientCode");

	public static final java.lang.String _InfoOffCreditedClient =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoOffCreditedClient");

	public static final java.lang.String _InvalidClientCodeIsInvalid =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidClientCodeIsInvalid");

	public static final java.lang.String _OnlyRoute99Present =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OnlyRoute99Present");

	public static final java.lang.String _InfoPickupAlreadyExist =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPickupAlreadyExist");

	public static final java.lang.String _InvalidPickupForClientNotExist =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupForClientNotExist");

	public static final java.lang.String _InvalidPickupRouteCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupRouteCode");

	public static final java.lang.String _InvalidAreaCodeNotExists =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAreaCodeNotExists");

	public static final java.lang.String _InfoAraNotAdditionalLocation =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoAraNotAdditionalLocation");

	public static final java.lang.String _InvalidServiceCentNotToArea =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidServiceCentNotToArea");

	public static final java.lang.String _InvalidSCAndServiceCentNotToArea =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidSCAndServiceCentNotToArea");

	public static final java.lang.String _InvalidAreaCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAreaCode");

	public static final java.lang.String _HolidayAreaDoesNotExist =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("HolidayAreaDoesNotExist");

	public static final java.lang.String _HolidayAreaExist =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("HolidayAreaExist");

	public static final java.lang.String _InvalidAreaScNotInRegion =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAreaScNotInRegion");

	public static final java.lang.String _InvalidServiceCenter =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidServiceCenter");

	public static final java.lang.String _InfoCustNotSendImpExpShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoCustNotSendImpExpShpt");

	public static final java.lang.String _InvalidOffCreditedClientNotAllowed =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOffCreditedClientNotAllowed");

	public static final java.lang.String _InfoCodifiedCashClient =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoCodifiedCashClient");

	public static final java.lang.String _InfoFreightCollectClient =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoFreightCollectClient");

	public static final java.lang.String _InfoDartCollectClient =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoDartCollectClient");

	public static final java.lang.String _InvalidProductNotAllowForCentCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidProductNotAllowForCentCust");

	public static final java.lang.String _InvalidCustNotSendCODShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustNotSendCODShpt");

	public static final java.lang.String _InvalidCustNotSendFODShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustNotSendFODShpt");

	public static final java.lang.String _InvalidCustNotSendTDDShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustNotSendTDDShpt");

	public static final java.lang.String _InvalidCustNotSendEDLShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustNotSendEDLShpt");

	public static final java.lang.String _InvalidCustomerCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustomerCode");

	public static final java.lang.String _InvalidProductNotValidForCentBilllingCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidProductNotValidForCentBilllingCust");

	public static final java.lang.String _InvalidOrgAreaCustNotValidForCentBilllingCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidOrgAreaCustNotValidForCentBilllingCust");

	public static final java.lang.String _InvalidDestAreaCustNotValidForCentBilllingCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidDestAreaCustNotValidForCentBilllingCust");

	public static final java.lang.String _InfoPickupAlreadyExistEnterAnother =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPickupAlreadyExistEnterAnother");

	public static final java.lang.String _InvalidPickupClient =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupClient");

	public static final java.lang.String _InfoRegPickupCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoRegPickupCust");

	public static final java.lang.String _InfoFieldStaffSignOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoFieldStaffSignOff");

	public static final java.lang.String _WarnCutoffTimeNotinPickup =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("WarnCutoffTimeNotinPickup");

	public static final java.lang.String _InfoPUTime1CutOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPUTime1CutOff");

	public static final java.lang.String _InfoPUTime2CutOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPUTime2CutOff");

	public static final java.lang.String _InfoPUTime3CutOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPUTime3CutOff");

	public static final java.lang.String _InfoPUTime4CutOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPUTime4CutOff");

	public static final java.lang.String _InfoPUTime5CutOff =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoPUTime5CutOff");

	public static final java.lang.String _InvalidEmployeeCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidEmployeeCode");

	public static final java.lang.String _InvalidProductCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidProductCode");

	public static final java.lang.String _OutBoundServiceNotAvailable =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OutBoundServiceNotAvailable");

	public static final java.lang.String _InvalidProdNotForCust =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidProdNotForCust");

	public static final java.lang.String _InvalidStatusCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidStatusCode");

	public static final java.lang.String _InvalidTransactionCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidTransactionCode");

	public static final java.lang.String _KeyCustomerCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("KeyCustomerCode");

	public static final java.lang.String _WarnLastCutoffTimeHandleWithCare =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("WarnLastCutoffTimeHandleWithCare");

	public static final java.lang.String _InfoFieldCutoffTimeSchedule =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InfoFieldCutoffTimeSchedule");

	public static final java.lang.String _InvalidProductCodeNottoServiceCenter =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidProductCodeNottoServiceCenter");

	public static final java.lang.String _CurrentTimeExceedsCutOffTime =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CurrentTimeExceedsCutOffTime");

	public static final java.lang.String _EmbargoLocation =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EmbargoLocation");

	public static final java.lang.String _NonCompLocation =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("NonCompLocation");

	public static final java.lang.String _InvalidCountryCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCountryCode");

	public static final java.lang.String _InvalidCityCode =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCityCode");

	public static final java.lang.String _LockFailed =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LockFailed");

	public static final java.lang.String _UnlockFailed =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UnlockFailed");

	public static final java.lang.String _InvalidCustomer =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustomer");

	public static final java.lang.String _AreaCodeIsNull =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AreaCodeIsNull");

	public static final java.lang.String _CountryCodeIsNull =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CountryCodeIsNull");

	public static final java.lang.String _PickupDateIsNull =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupDateIsNull");

	public static final java.lang.String _PickupTimeIsNull =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupTimeIsNull");

	public static final java.lang.String _OriginAreaCodeIsNullOrEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OriginAreaCodeIsNullOrEmpty");

	public static final java.lang.String _DestinationAreaCodeIsNullOrEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DestinationAreaCodeIsNullOrEmpty");

	public static final java.lang.String _OriginServiceCenterIsNullOrEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OriginServiceCenterIsNullOrEmpty");

	public static final java.lang.String _DestinationServiceCenterIsNullOrEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DestinationServiceCenterIsNullOrEmpty");

	public static final java.lang.String _ProductCodeIsNullOrEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ProductCodeIsNullOrEmpty");

	public static final java.lang.String _InvalidPickupDate =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidPickupDate");

	public static final java.lang.String _TDDServiceProvided =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TDDServiceProvided");

	public static final java.lang.String _TDDServiceNotProvided =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TDDServiceNotProvided");

	public static final java.lang.String _OriginCutOffTimeNotDefined =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OriginCutOffTimeNotDefined");

	public static final java.lang.String _ClientNameIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ClientNameIsNullorEmpty");

	public static final java.lang.String _ClientCodeIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ClientCodeIsNullorEmpty");

	public static final java.lang.String _RouteCodeIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RouteCodeIsNullorEmpty");

	public static final java.lang.String _PickSerialNumberIsnullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickSerialNumberIsnullorEmpty");

	public static final java.lang.String _AddressMandatoryIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AddressMandatoryIsNullorEmpty");

	public static final java.lang.String _PickUpTimeIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickUpTimeIsNullorEmpty");

	public static final java.lang.String _PickUpDaysIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickUpDaysIsNullorEmpty");

	public static final java.lang.String _CityCodeIsNullorEmpty =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CityCodeIsNullorEmpty");

	public static final java.lang.String _AreaCodeBelongsToMetro =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AreaCodeBelongsToMetro");

	public static final java.lang.String _OperationFailed =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OperationFailed");

	public static final java.lang.String _InvalidAWBNo =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidAWBNo");

	public static final java.lang.String _PickupIsAlreadyRegister =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupIsAlreadyRegister");

	public static final java.lang.String _ShipmentAlreadyPicked =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentAlreadyPicked");

	public static final java.lang.String _kFileDataNotFound =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("kFileDataNotFound");

	public static final java.lang.String _AWBAlreadyManifested =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AWBAlreadyManifested");

	public static final java.lang.String _CantReregisterCancelledPU =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CantReregisterCancelledPU");

	public static final java.lang.String _ShipMobNoMandatoryForRVP =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipMobNoMandatoryForRVP");

	public static final java.lang.String _InvalidCustForDDN =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustForDDN");

	public static final java.lang.String _InvalidSrcForDDN =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidSrcForDDN");

	public static final java.lang.String _InvalidCustNotSendEconomyShpt =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidCustNotSendEconomyShpt");

	public static final java.lang.String _PickupRegistrationNotAllowedforEmbargoLocation =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupRegistrationNotAllowedforEmbargoLocation");

	public static final java.lang.String _PickupRegistrationNotAllowedforRVPEmbargoLocation =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupRegistrationNotAllowedforRVPEmbargoLocation");

	public static final java.lang.String _ExchangeRVPCannotReassign =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ExchangeRVPCannotReassign");

	public static final java.lang.String _InvalidSCAndServiceCentNotInState =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidSCAndServiceCentNotInState");

	public static final PickupValidationStatus Valid =
			new PickupValidationStatus(_Valid,true);

	public static final PickupValidationStatus Invalid =
			new PickupValidationStatus(_Invalid,true);

	public static final PickupValidationStatus InsertFailure =
			new PickupValidationStatus(_InsertFailure,true);

	public static final PickupValidationStatus InsertSuccess =
			new PickupValidationStatus(_InsertSuccess,true);

	public static final PickupValidationStatus UpdateFailure =
			new PickupValidationStatus(_UpdateFailure,true);

	public static final PickupValidationStatus UpdateSuccess =
			new PickupValidationStatus(_UpdateSuccess,true);

	public static final PickupValidationStatus DeleteFailure =
			new PickupValidationStatus(_DeleteFailure,true);

	public static final PickupValidationStatus DeleteSuccess =
			new PickupValidationStatus(_DeleteSuccess,true);

	public static final PickupValidationStatus CancelSuccess =
			new PickupValidationStatus(_CancelSuccess,true);

	public static final PickupValidationStatus TokenNotFound =
			new PickupValidationStatus(_TokenNotFound,true);

	public static final PickupValidationStatus TokenAPPLICATION_ERROR =
			new PickupValidationStatus(_TokenAPPLICATION_ERROR,true);

	public static final PickupValidationStatus TokenNULL_VALUES =
			new PickupValidationStatus(_TokenNULL_VALUES,true);

	public static final PickupValidationStatus InvalidPickupSerialNo =
			new PickupValidationStatus(_InvalidPickupSerialNo,true);

	public static final PickupValidationStatus InvalidClientName =
			new PickupValidationStatus(_InvalidClientName,true);

	public static final PickupValidationStatus InvalidPinCode =
			new PickupValidationStatus(_InvalidPinCode,true);

	public static final PickupValidationStatus InvalidAddress1 =
			new PickupValidationStatus(_InvalidAddress1,true);

	public static final PickupValidationStatus InvalidAddress2 =
			new PickupValidationStatus(_InvalidAddress2,true);

	public static final PickupValidationStatus InvalidAddress3 =
			new PickupValidationStatus(_InvalidAddress3,true);

	public static final PickupValidationStatus InvalidPickupDays =
			new PickupValidationStatus(_InvalidPickupDays,true);

	public static final PickupValidationStatus InvalidPickupTime =
			new PickupValidationStatus(_InvalidPickupTime,true);

	public static final PickupValidationStatus InfoPickupDoesNotExist =
			new PickupValidationStatus(_InfoPickupDoesNotExist,true);

	public static final PickupValidationStatus InvalidOfficeCloseTime =
			new PickupValidationStatus(_InvalidOfficeCloseTime,true);

	public static final PickupValidationStatus InvalidOriginAreaCode =
			new PickupValidationStatus(_InvalidOriginAreaCode,true);

	public static final PickupValidationStatus InvalidDestAreaCode =
			new PickupValidationStatus(_InvalidDestAreaCode,true);

	public static final PickupValidationStatus InvalidOriginScCode =
			new PickupValidationStatus(_InvalidOriginScCode,true);

	public static final PickupValidationStatus InvalidDestScCode =
			new PickupValidationStatus(_InvalidDestScCode,true);

	public static final PickupValidationStatus InvalidOriginAreaCodeNotBlank =
			new PickupValidationStatus(_InvalidOriginAreaCodeNotBlank,true);

	public static final PickupValidationStatus InvalidDestAreaCodeNotBlank =
			new PickupValidationStatus(_InvalidDestAreaCodeNotBlank,true);

	public static final PickupValidationStatus RegularDataTransfer =
			new PickupValidationStatus(_RegularDataTransfer,true);

	public static final PickupValidationStatus ServiceCentreCannotBeBlank =
			new PickupValidationStatus(_ServiceCentreCannotBeBlank,true);

	public static final PickupValidationStatus DestinationAreaNotInternational =
			new PickupValidationStatus(_DestinationAreaNotInternational,true);

	public static final PickupValidationStatus ValueToLargeToCaculate =
			new PickupValidationStatus(_ValueToLargeToCaculate,true);

	public static final PickupValidationStatus NoDataFoundException =
			new PickupValidationStatus(_NoDataFoundException,true);

	public static final PickupValidationStatus UnauthorisedServiceCentre =
			new PickupValidationStatus(_UnauthorisedServiceCentre,true);

	public static final PickupValidationStatus InfoCustNotBelongsToServicesCenter =
			new PickupValidationStatus(_InfoCustNotBelongsToServicesCenter,true);

	public static final PickupValidationStatus InvalidClientCode =
			new PickupValidationStatus(_InvalidClientCode,true);

	public static final PickupValidationStatus InfoOffCreditedClient =
			new PickupValidationStatus(_InfoOffCreditedClient,true);

	public static final PickupValidationStatus InvalidClientCodeIsInvalid =
			new PickupValidationStatus(_InvalidClientCodeIsInvalid,true);

	public static final PickupValidationStatus OnlyRoute99Present =
			new PickupValidationStatus(_OnlyRoute99Present,true);

	public static final PickupValidationStatus InfoPickupAlreadyExist =
			new PickupValidationStatus(_InfoPickupAlreadyExist,true);

	public static final PickupValidationStatus InvalidPickupForClientNotExist =
			new PickupValidationStatus(_InvalidPickupForClientNotExist,true);

	public static final PickupValidationStatus InvalidPickupRouteCode =
			new PickupValidationStatus(_InvalidPickupRouteCode,true);

	public static final PickupValidationStatus InvalidAreaCodeNotExists =
			new PickupValidationStatus(_InvalidAreaCodeNotExists,true);

	public static final PickupValidationStatus InfoAraNotAdditionalLocation =
			new PickupValidationStatus(_InfoAraNotAdditionalLocation,true);

	public static final PickupValidationStatus InvalidServiceCentNotToArea =
			new PickupValidationStatus(_InvalidServiceCentNotToArea,true);

	public static final PickupValidationStatus InvalidSCAndServiceCentNotToArea =
			new PickupValidationStatus(_InvalidSCAndServiceCentNotToArea,true);

	public static final PickupValidationStatus InvalidAreaCode =
			new PickupValidationStatus(_InvalidAreaCode,true);

	public static final PickupValidationStatus HolidayAreaDoesNotExist =
			new PickupValidationStatus(_HolidayAreaDoesNotExist,true);

	public static final PickupValidationStatus HolidayAreaExist =
			new PickupValidationStatus(_HolidayAreaExist,true);

	public static final PickupValidationStatus InvalidAreaScNotInRegion =
			new PickupValidationStatus(_InvalidAreaScNotInRegion,true);

	public static final PickupValidationStatus InvalidServiceCenter =
			new PickupValidationStatus(_InvalidServiceCenter,true);

	public static final PickupValidationStatus InfoCustNotSendImpExpShpt =
			new PickupValidationStatus(_InfoCustNotSendImpExpShpt,true);

	public static final PickupValidationStatus InvalidOffCreditedClientNotAllowed =
			new PickupValidationStatus(_InvalidOffCreditedClientNotAllowed,true);

	public static final PickupValidationStatus InfoCodifiedCashClient =
			new PickupValidationStatus(_InfoCodifiedCashClient,true);

	public static final PickupValidationStatus InfoFreightCollectClient =
			new PickupValidationStatus(_InfoFreightCollectClient,true);

	public static final PickupValidationStatus InfoDartCollectClient =
			new PickupValidationStatus(_InfoDartCollectClient,true);

	public static final PickupValidationStatus InvalidProductNotAllowForCentCust =
			new PickupValidationStatus(_InvalidProductNotAllowForCentCust,true);

	public static final PickupValidationStatus InvalidCustNotSendCODShpt =
			new PickupValidationStatus(_InvalidCustNotSendCODShpt,true);

	public static final PickupValidationStatus InvalidCustNotSendFODShpt =
			new PickupValidationStatus(_InvalidCustNotSendFODShpt,true);

	public static final PickupValidationStatus InvalidCustNotSendTDDShpt =
			new PickupValidationStatus(_InvalidCustNotSendTDDShpt,true);

	public static final PickupValidationStatus InvalidCustNotSendEDLShpt =
			new PickupValidationStatus(_InvalidCustNotSendEDLShpt,true);

	public static final PickupValidationStatus InvalidCustomerCode =
			new PickupValidationStatus(_InvalidCustomerCode,true);

	public static final PickupValidationStatus InvalidProductNotValidForCentBilllingCust =
			new PickupValidationStatus(_InvalidProductNotValidForCentBilllingCust,true);

	public static final PickupValidationStatus InvalidOrgAreaCustNotValidForCentBilllingCust =
			new PickupValidationStatus(_InvalidOrgAreaCustNotValidForCentBilllingCust,true);

	public static final PickupValidationStatus InvalidDestAreaCustNotValidForCentBilllingCust =
			new PickupValidationStatus(_InvalidDestAreaCustNotValidForCentBilllingCust,true);

	public static final PickupValidationStatus InfoPickupAlreadyExistEnterAnother =
			new PickupValidationStatus(_InfoPickupAlreadyExistEnterAnother,true);

	public static final PickupValidationStatus InvalidPickupClient =
			new PickupValidationStatus(_InvalidPickupClient,true);

	public static final PickupValidationStatus InfoRegPickupCust =
			new PickupValidationStatus(_InfoRegPickupCust,true);

	public static final PickupValidationStatus InfoFieldStaffSignOff =
			new PickupValidationStatus(_InfoFieldStaffSignOff,true);

	public static final PickupValidationStatus WarnCutoffTimeNotinPickup =
			new PickupValidationStatus(_WarnCutoffTimeNotinPickup,true);

	public static final PickupValidationStatus InfoPUTime1CutOff =
			new PickupValidationStatus(_InfoPUTime1CutOff,true);

	public static final PickupValidationStatus InfoPUTime2CutOff =
			new PickupValidationStatus(_InfoPUTime2CutOff,true);

	public static final PickupValidationStatus InfoPUTime3CutOff =
			new PickupValidationStatus(_InfoPUTime3CutOff,true);

	public static final PickupValidationStatus InfoPUTime4CutOff =
			new PickupValidationStatus(_InfoPUTime4CutOff,true);

	public static final PickupValidationStatus InfoPUTime5CutOff =
			new PickupValidationStatus(_InfoPUTime5CutOff,true);

	public static final PickupValidationStatus InvalidEmployeeCode =
			new PickupValidationStatus(_InvalidEmployeeCode,true);

	public static final PickupValidationStatus InvalidProductCode =
			new PickupValidationStatus(_InvalidProductCode,true);

	public static final PickupValidationStatus OutBoundServiceNotAvailable =
			new PickupValidationStatus(_OutBoundServiceNotAvailable,true);

	public static final PickupValidationStatus InvalidProdNotForCust =
			new PickupValidationStatus(_InvalidProdNotForCust,true);

	public static final PickupValidationStatus InvalidStatusCode =
			new PickupValidationStatus(_InvalidStatusCode,true);

	public static final PickupValidationStatus InvalidTransactionCode =
			new PickupValidationStatus(_InvalidTransactionCode,true);

	public static final PickupValidationStatus KeyCustomerCode =
			new PickupValidationStatus(_KeyCustomerCode,true);

	public static final PickupValidationStatus WarnLastCutoffTimeHandleWithCare =
			new PickupValidationStatus(_WarnLastCutoffTimeHandleWithCare,true);

	public static final PickupValidationStatus InfoFieldCutoffTimeSchedule =
			new PickupValidationStatus(_InfoFieldCutoffTimeSchedule,true);

	public static final PickupValidationStatus InvalidProductCodeNottoServiceCenter =
			new PickupValidationStatus(_InvalidProductCodeNottoServiceCenter,true);

	public static final PickupValidationStatus CurrentTimeExceedsCutOffTime =
			new PickupValidationStatus(_CurrentTimeExceedsCutOffTime,true);

	public static final PickupValidationStatus EmbargoLocation =
			new PickupValidationStatus(_EmbargoLocation,true);

	public static final PickupValidationStatus NonCompLocation =
			new PickupValidationStatus(_NonCompLocation,true);

	public static final PickupValidationStatus InvalidCountryCode =
			new PickupValidationStatus(_InvalidCountryCode,true);

	public static final PickupValidationStatus InvalidCityCode =
			new PickupValidationStatus(_InvalidCityCode,true);

	public static final PickupValidationStatus LockFailed =
			new PickupValidationStatus(_LockFailed,true);

	public static final PickupValidationStatus UnlockFailed =
			new PickupValidationStatus(_UnlockFailed,true);

	public static final PickupValidationStatus InvalidCustomer =
			new PickupValidationStatus(_InvalidCustomer,true);

	public static final PickupValidationStatus AreaCodeIsNull =
			new PickupValidationStatus(_AreaCodeIsNull,true);

	public static final PickupValidationStatus CountryCodeIsNull =
			new PickupValidationStatus(_CountryCodeIsNull,true);

	public static final PickupValidationStatus PickupDateIsNull =
			new PickupValidationStatus(_PickupDateIsNull,true);

	public static final PickupValidationStatus PickupTimeIsNull =
			new PickupValidationStatus(_PickupTimeIsNull,true);

	public static final PickupValidationStatus OriginAreaCodeIsNullOrEmpty =
			new PickupValidationStatus(_OriginAreaCodeIsNullOrEmpty,true);

	public static final PickupValidationStatus DestinationAreaCodeIsNullOrEmpty =
			new PickupValidationStatus(_DestinationAreaCodeIsNullOrEmpty,true);

	public static final PickupValidationStatus OriginServiceCenterIsNullOrEmpty =
			new PickupValidationStatus(_OriginServiceCenterIsNullOrEmpty,true);

	public static final PickupValidationStatus DestinationServiceCenterIsNullOrEmpty =
			new PickupValidationStatus(_DestinationServiceCenterIsNullOrEmpty,true);

	public static final PickupValidationStatus ProductCodeIsNullOrEmpty =
			new PickupValidationStatus(_ProductCodeIsNullOrEmpty,true);

	public static final PickupValidationStatus InvalidPickupDate =
			new PickupValidationStatus(_InvalidPickupDate,true);

	public static final PickupValidationStatus TDDServiceProvided =
			new PickupValidationStatus(_TDDServiceProvided,true);

	public static final PickupValidationStatus TDDServiceNotProvided =
			new PickupValidationStatus(_TDDServiceNotProvided,true);

	public static final PickupValidationStatus OriginCutOffTimeNotDefined =
			new PickupValidationStatus(_OriginCutOffTimeNotDefined,true);

	public static final PickupValidationStatus ClientNameIsNullorEmpty =
			new PickupValidationStatus(_ClientNameIsNullorEmpty,true);

	public static final PickupValidationStatus ClientCodeIsNullorEmpty =
			new PickupValidationStatus(_ClientCodeIsNullorEmpty,true);

	public static final PickupValidationStatus RouteCodeIsNullorEmpty =
			new PickupValidationStatus(_RouteCodeIsNullorEmpty,true);

	public static final PickupValidationStatus PickSerialNumberIsnullorEmpty =
			new PickupValidationStatus(_PickSerialNumberIsnullorEmpty,true);

	public static final PickupValidationStatus AddressMandatoryIsNullorEmpty =
			new PickupValidationStatus(_AddressMandatoryIsNullorEmpty,true);

	public static final PickupValidationStatus PickUpTimeIsNullorEmpty =
			new PickupValidationStatus(_PickUpTimeIsNullorEmpty,true);

	public static final PickupValidationStatus PickUpDaysIsNullorEmpty =
			new PickupValidationStatus(_PickUpDaysIsNullorEmpty,true);

	public static final PickupValidationStatus CityCodeIsNullorEmpty =
			new PickupValidationStatus(_CityCodeIsNullorEmpty,true);

	public static final PickupValidationStatus AreaCodeBelongsToMetro =
			new PickupValidationStatus(_AreaCodeBelongsToMetro,true);

	public static final PickupValidationStatus OperationFailed =
			new PickupValidationStatus(_OperationFailed,true);

	public static final PickupValidationStatus InvalidAWBNo =
			new PickupValidationStatus(_InvalidAWBNo,true);

	public static final PickupValidationStatus PickupIsAlreadyRegister =
			new PickupValidationStatus(_PickupIsAlreadyRegister,true);

	public static final PickupValidationStatus ShipmentAlreadyPicked =
			new PickupValidationStatus(_ShipmentAlreadyPicked,true);

	public static final PickupValidationStatus kFileDataNotFound =
			new PickupValidationStatus(_kFileDataNotFound,true);

	public static final PickupValidationStatus AWBAlreadyManifested =
			new PickupValidationStatus(_AWBAlreadyManifested,true);

	public static final PickupValidationStatus CantReregisterCancelledPU =
			new PickupValidationStatus(_CantReregisterCancelledPU,true);

	public static final PickupValidationStatus ShipMobNoMandatoryForRVP =
			new PickupValidationStatus(_ShipMobNoMandatoryForRVP,true);

	public static final PickupValidationStatus InvalidCustForDDN =
			new PickupValidationStatus(_InvalidCustForDDN,true);

	public static final PickupValidationStatus InvalidSrcForDDN =
			new PickupValidationStatus(_InvalidSrcForDDN,true);

	public static final PickupValidationStatus InvalidCustNotSendEconomyShpt =
			new PickupValidationStatus(_InvalidCustNotSendEconomyShpt,true);

	public static final PickupValidationStatus PickupRegistrationNotAllowedforEmbargoLocation =
			new PickupValidationStatus(_PickupRegistrationNotAllowedforEmbargoLocation,true);

	public static final PickupValidationStatus PickupRegistrationNotAllowedforRVPEmbargoLocation =
			new PickupValidationStatus(_PickupRegistrationNotAllowedforRVPEmbargoLocation,true);

	public static final PickupValidationStatus ExchangeRVPCannotReassign =
			new PickupValidationStatus(_ExchangeRVPCannotReassign,true);

	public static final PickupValidationStatus InvalidSCAndServiceCentNotInState =
			new PickupValidationStatus(_InvalidSCAndServiceCentNotInState,true);


	public java.lang.String getValue() { return localPickupValidationStatus;}

	public boolean equals(java.lang.Object obj) {return (obj == this);}
	public int hashCode() { return toString().hashCode();}
	public java.lang.String toString() {

		return localPickupValidationStatus.toString();


	}





	/**
	 *
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement (
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



		org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
		return factory.createOMElement(dataSource,MY_QNAME);

	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter)
					throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
		serialize(parentQName,xmlWriter,false);
	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter,
			boolean serializeType)
					throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


		//We can safely assume an element has only one type associated with it

		java.lang.String namespace = parentQName.getNamespaceURI();
		java.lang.String _localName = parentQName.getLocalPart();

		writeStartElement(null, namespace, _localName, xmlWriter);

		// add the type details if this is used in a simple type
		if (serializeType){
			java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Pickup");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
				writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
						namespacePrefix+":PickupValidationStatus",
						xmlWriter);
			} else {
				writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
						"PickupValidationStatus",
						xmlWriter);
			}
		}

		if (localPickupValidationStatus==null){

			throw new org.apache.axis2.databinding.ADBException("PickupValidationStatus cannot be null !!");

		}else{

			xmlWriter.writeCharacters(localPickupValidationStatus);

		}

		xmlWriter.writeEndElement();


	}

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if(namespace.equals("http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Pickup")){
			return "ns11";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * Utility method to write an element start tag.
	 */
	private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
			javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
		java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
		if (writerPrefix != null) {
			xmlWriter.writeStartElement(namespace, localPart);
		} else {
			if (namespace.length() == 0) {
				prefix = "";
			} else if (prefix == null) {
				prefix = generatePrefix(namespace);
			}

			xmlWriter.writeStartElement(prefix, localPart, namespace);
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
			java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		xmlWriter.writeAttribute(namespace,attName,attValue);
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(java.lang.String namespace,java.lang.String attName,
			java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName,attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace,attName,attValue);
		}
	}


	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
			javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

		java.lang.String attributeNamespace = qname.getNamespaceURI();
		java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		java.lang.String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}
	/**
	 *  method to handle Qnames
	 */

	private void writeQName(javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
		java.lang.String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix,namespaceURI);
			}

			if (prefix.trim().length() > 0){
				xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}

		} else {
			xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
		}
	}

	private void writeQNames(javax.xml.namespace.QName[] qnames,
			javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not possible to write any
			// namespace data after writing the charactor data
			java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			java.lang.String namespaceURI = null;
			java.lang.String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix,namespaceURI);
					}

					if (prefix.trim().length() > 0){
						stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				} else {
					stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}


	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);
		if (prefix == null) {
			prefix = generatePrefix(namespace);
			javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
			while (true) {
				java.lang.String uri = nsContext.getNamespaceURI(prefix);
				if (uri == null || uri.length() == 0) {
					break;
				}
				prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
			}
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		return prefix;
	}



	/**
	 * databinding method to get an XML representation of this object
	 *
	 */
	public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
			throws org.apache.axis2.databinding.ADBException{




		//We can safely assume an element has only one type associated with it
		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
				new java.lang.Object[]{
						org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
						org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPickupValidationStatus)
		},
				null);

	}



	/**
	 *  Factory class that keeps the parse method
	 */
	public static class Factory{



		public static PickupValidationStatus fromValue(java.lang.String value)
				throws java.lang.IllegalArgumentException {
			PickupValidationStatus enumeration = (PickupValidationStatus)

					_table_.get(value);


			if ((enumeration == null) && !((value == null) || (value.equals("")))) {
				throw new java.lang.IllegalArgumentException();
			}
			return enumeration;
		}
		public static PickupValidationStatus fromString(java.lang.String value,java.lang.String namespaceURI)
				throws java.lang.IllegalArgumentException {
			try {

				return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));


			} catch (java.lang.Exception e) {
				throw new java.lang.IllegalArgumentException();
			}
		}

		public static PickupValidationStatus fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
				java.lang.String content) {
			if (content.indexOf(":") > -1){
				java.lang.String prefix = content.substring(0,content.indexOf(":"));
				java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
				return PickupValidationStatus.Factory.fromString(content,namespaceUri);
			} else {
				return PickupValidationStatus.Factory.fromString(content,"");
			}
		}


		/**
		 * static method to create the object
		 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
		 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
		 * Postcondition: If this object is an element, the reader is positioned at its end element
		 *                If this object is a complex type, the reader is positioned at the end element of its outer element
		 */
		public static PickupValidationStatus parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
			PickupValidationStatus object = null;
			// initialize a hash map to keep values
			java.util.Map attributeMap = new java.util.HashMap();
			java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


			int event;
			java.lang.String nillableValue = null;
			java.lang.String prefix ="";
			java.lang.String namespaceuri ="";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();




				// Note all attributes that were handled. Used to differ normal attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();



				while(!reader.isEndElement()) {
					if (reader.isStartElement()  || reader.hasText()){

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)){
							throw new org.apache.axis2.databinding.ADBException("The element: "+"PickupValidationStatus" +"  cannot be null");
						}


						java.lang.String content = reader.getElementText();

						if (content.indexOf(":") > 0) {
							// this seems to be a Qname so find the namespace and send
							prefix = content.substring(0, content.indexOf(":"));
							namespaceuri = reader.getNamespaceURI(prefix);
							object = PickupValidationStatus.Factory.fromString(content,namespaceuri);
						} else {
							// this seems to be not a qname send and empty namespace incase of it is
							// check is done in fromString method
							object = PickupValidationStatus.Factory.fromString(content,"");
						}


					} else {
						reader.next();
					}  
				}  // end of while loop




			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}//end of factory class



}

