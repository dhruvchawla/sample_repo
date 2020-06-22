
/**
 * RateQueryInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package org.datacontract.schemas._2004._07.bd_entities_pickup;


/**
 *  RateQueryInput bean class
 */
@SuppressWarnings({"unchecked","unused"})

public  class RateQueryInput
implements org.apache.axis2.databinding.ADBBean{
	/* This type was generated from the piece of schema that had
                name = RateQueryInput
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Pickup
                Namespace Prefix = ns12
	 */


	/**
	 * field for ActualWeight
	 */


	protected double localActualWeight ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localActualWeightTracker = false ;

	public boolean isActualWeightSpecified(){
		return localActualWeightTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	 public  double getActualWeight(){
		 return localActualWeight;
	 }



	 /**
	  * Auto generated setter method
	  * @param param ActualWeight
	  */
	 public void setActualWeight(double param){

		 // setting primitive attribute tracker to true
		 localActualWeightTracker =
				 !java.lang.Double.isNaN(param);

		 this.localActualWeight=param;


	 }


	 /**
	  * field for AwbNo
	  */


	 protected java.lang.String localAwbNo ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localAwbNoTracker = false ;

	 public boolean isAwbNoSpecified(){
		 return localAwbNoTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getAwbNo(){
		 return localAwbNo;
	 }



	 /**
	  * Auto generated setter method
	  * @param param AwbNo
	  */
	 public void setAwbNo(java.lang.String param){
		 localAwbNoTracker = true;

		 this.localAwbNo=param;


	 }


	 /**
	  * field for BatchDate
	  */


	 protected java.lang.String localBatchDate ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localBatchDateTracker = false ;

	 public boolean isBatchDateSpecified(){
		 return localBatchDateTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getBatchDate(){
		 return localBatchDate;
	 }



	 /**
	  * Auto generated setter method
	  * @param param BatchDate
	  */
	 public void setBatchDate(java.lang.String param){
		 localBatchDateTracker = true;

		 this.localBatchDate=param;


	 }


	 /**
	  * field for CriticalExpressFlag
	  */


	 protected java.lang.String localCriticalExpressFlag ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localCriticalExpressFlagTracker = false ;

	 public boolean isCriticalExpressFlagSpecified(){
		 return localCriticalExpressFlagTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getCriticalExpressFlag(){
		 return localCriticalExpressFlag;
	 }



	 /**
	  * Auto generated setter method
	  * @param param CriticalExpressFlag
	  */
	 public void setCriticalExpressFlag(java.lang.String param){
		 localCriticalExpressFlagTracker = true;

		 this.localCriticalExpressFlag=param;


	 }


	 /**
	  * field for CurrencyAdjustFlag
	  */


	 protected java.lang.String localCurrencyAdjustFlag ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localCurrencyAdjustFlagTracker = false ;

	 public boolean isCurrencyAdjustFlagSpecified(){
		 return localCurrencyAdjustFlagTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getCurrencyAdjustFlag(){
		 return localCurrencyAdjustFlag;
	 }



	 /**
	  * Auto generated setter method
	  * @param param CurrencyAdjustFlag
	  */
	 public void setCurrencyAdjustFlag(java.lang.String param){
		 localCurrencyAdjustFlagTracker = true;

		 this.localCurrencyAdjustFlag=param;


	 }


	 /**
	  * field for CustomerCode
	  */


	 protected java.lang.String localCustomerCode ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localCustomerCodeTracker = false ;

	 public boolean isCustomerCodeSpecified(){
		 return localCustomerCodeTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getCustomerCode(){
		 return localCustomerCode;
	 }



	 /**
	  * Auto generated setter method
	  * @param param CustomerCode
	  */
	 public void setCustomerCode(java.lang.String param){
		 localCustomerCodeTracker = true;

		 this.localCustomerCode=param;


	 }


	 /**
	  * field for DCFlag
	  */


	 protected java.lang.String localDCFlag ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localDCFlagTracker = false ;

	 public boolean isDCFlagSpecified(){
		 return localDCFlagTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return java.lang.String
	  */
	 public  java.lang.String getDCFlag(){
		 return localDCFlag;
	 }



	 /**
	  * Auto generated setter method
	  * @param param DCFlag
	  */
	 public void setDCFlag(java.lang.String param){
		 localDCFlagTracker = true;

		 this.localDCFlag=param;


	 }


	 /**
	  * field for DeclareValue
	  */


	 protected double localDeclareValue ;

	 /*  This tracker boolean wil be used to detect whether the user called the set method
	  *   for this attribute. It will be used to determine whether to include this field
	  *   in the serialized XML
	  */
	 protected boolean localDeclareValueTracker = false ;

	 public boolean isDeclareValueSpecified(){
		 return localDeclareValueTracker;
	 }



	 /**
	  * Auto generated getter method
	  * @return double
	  */
	  public  double getDeclareValue(){
		  return localDeclareValue;
	  }



	  /**
	   * Auto generated setter method
	   * @param param DeclareValue
	   */
	  public void setDeclareValue(double param){

		  // setting primitive attribute tracker to true
		  localDeclareValueTracker =
				  !java.lang.Double.isNaN(param);

		  this.localDeclareValue=param;


	  }


	  /**
	   * field for DestinationArea
	   */


	  protected java.lang.String localDestinationArea ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localDestinationAreaTracker = false ;

	  public boolean isDestinationAreaSpecified(){
		  return localDestinationAreaTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getDestinationArea(){
		  return localDestinationArea;
	  }



	  /**
	   * Auto generated setter method
	   * @param param DestinationArea
	   */
	  public void setDestinationArea(java.lang.String param){
		  localDestinationAreaTracker = true;

		  this.localDestinationArea=param;


	  }


	  /**
	   * field for DestinationPincode
	   */


	  protected java.lang.String localDestinationPincode ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localDestinationPincodeTracker = false ;

	  public boolean isDestinationPincodeSpecified(){
		  return localDestinationPincodeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getDestinationPincode(){
		  return localDestinationPincode;
	  }



	  /**
	   * Auto generated setter method
	   * @param param DestinationPincode
	   */
	  public void setDestinationPincode(java.lang.String param){
		  localDestinationPincodeTracker = true;

		  this.localDestinationPincode=param;


	  }


	  /**
	   * field for DestinationSC
	   */


	  protected java.lang.String localDestinationSC ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localDestinationSCTracker = false ;

	  public boolean isDestinationSCSpecified(){
		  return localDestinationSCTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getDestinationSC(){
		  return localDestinationSC;
	  }



	  /**
	   * Auto generated setter method
	   * @param param DestinationSC
	   */
	  public void setDestinationSC(java.lang.String param){
		  localDestinationSCTracker = true;

		  this.localDestinationSC=param;


	  }


	  /**
	   * field for EDLFlag
	   */


	  protected java.lang.String localEDLFlag ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localEDLFlagTracker = false ;

	  public boolean isEDLFlagSpecified(){
		  return localEDLFlagTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getEDLFlag(){
		  return localEDLFlag;
	  }



	  /**
	   * Auto generated setter method
	   * @param param EDLFlag
	   */
	  public void setEDLFlag(java.lang.String param){
		  localEDLFlagTracker = true;

		  this.localEDLFlag=param;


	  }


	  /**
	   * field for ESACode
	   */


	  protected java.lang.String localESACode ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localESACodeTracker = false ;

	  public boolean isESACodeSpecified(){
		  return localESACodeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getESACode(){
		  return localESACode;
	  }



	  /**
	   * Auto generated setter method
	   * @param param ESACode
	   */
	  public void setESACode(java.lang.String param){
		  localESACodeTracker = true;

		  this.localESACode=param;


	  }


	  /**
	   * field for FSAmount
	   */


	  protected java.lang.String localFSAmount ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localFSAmountTracker = false ;

	  public boolean isFSAmountSpecified(){
		  return localFSAmountTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getFSAmount(){
		  return localFSAmount;
	  }



	  /**
	   * Auto generated setter method
	   * @param param FSAmount
	   */
	  public void setFSAmount(java.lang.String param){
		  localFSAmountTracker = true;

		  this.localFSAmount=param;


	  }


	  /**
	   * field for Freight
	   */


	  protected double localFreight ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localFreightTracker = false ;

	  public boolean isFreightSpecified(){
		  return localFreightTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return double
	   */
	  public  double getFreight(){
		  return localFreight;
	  }



	  /**
	   * Auto generated setter method
	   * @param param Freight
	   */
	  public void setFreight(double param){

		  // setting primitive attribute tracker to true
		  localFreightTracker =
				  !java.lang.Double.isNaN(param);

		  this.localFreight=param;


	  }


	  /**
	   * field for FuelSurcharge
	   */


	  protected double localFuelSurcharge ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localFuelSurchargeTracker = false ;

	  public boolean isFuelSurchargeSpecified(){
		  return localFuelSurchargeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return double
	   */
	  public  double getFuelSurcharge(){
		  return localFuelSurcharge;
	  }



	  /**
	   * Auto generated setter method
	   * @param param FuelSurcharge
	   */
	  public void setFuelSurcharge(double param){

		  // setting primitive attribute tracker to true
		  localFuelSurchargeTracker =
				  !java.lang.Double.isNaN(param);

		  this.localFuelSurcharge=param;


	  }


	  /**
	   * field for Insurance
	   */


	  protected java.lang.String localInsurance ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localInsuranceTracker = false ;

	  public boolean isInsuranceSpecified(){
		  return localInsuranceTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getInsurance(){
		  return localInsurance;
	  }



	  /**
	   * Auto generated setter method
	   * @param param Insurance
	   */
	  public void setInsurance(java.lang.String param){
		  localInsuranceTracker = true;

		  this.localInsurance=param;


	  }


	  /**
	   * field for KGPound
	   */


	  protected java.lang.String localKGPound ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localKGPoundTracker = false ;

	  public boolean isKGPoundSpecified(){
		  return localKGPoundTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getKGPound(){
		  return localKGPound;
	  }



	  /**
	   * Auto generated setter method
	   * @param param KGPound
	   */
	  public void setKGPound(java.lang.String param){
		  localKGPoundTracker = true;

		  this.localKGPound=param;


	  }


	  /**
	   * field for Namount
	   */


	  protected java.lang.String localNamount ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localNamountTracker = false ;

	  public boolean isNamountSpecified(){
		  return localNamountTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getNamount(){
		  return localNamount;
	  }



	  /**
	   * Auto generated setter method
	   * @param param Namount
	   */
	  public void setNamount(java.lang.String param){
		  localNamountTracker = true;

		  this.localNamount=param;


	  }


	  /**
	   * field for OWSPFlag
	   */


	  protected java.lang.String localOWSPFlag ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localOWSPFlagTracker = false ;

	  public boolean isOWSPFlagSpecified(){
		  return localOWSPFlagTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getOWSPFlag(){
		  return localOWSPFlag;
	  }



	  /**
	   * Auto generated setter method
	   * @param param OWSPFlag
	   */
	  public void setOWSPFlag(java.lang.String param){
		  localOWSPFlagTracker = true;

		  this.localOWSPFlag=param;


	  }


	  /**
	   * field for OriginArea
	   */


	  protected java.lang.String localOriginArea ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localOriginAreaTracker = false ;

	  public boolean isOriginAreaSpecified(){
		  return localOriginAreaTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getOriginArea(){
		  return localOriginArea;
	  }



	  /**
	   * Auto generated setter method
	   * @param param OriginArea
	   */
	  public void setOriginArea(java.lang.String param){
		  localOriginAreaTracker = true;

		  this.localOriginArea=param;


	  }


	  /**
	   * field for OriginPincode
	   */


	  protected java.lang.String localOriginPincode ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localOriginPincodeTracker = false ;

	  public boolean isOriginPincodeSpecified(){
		  return localOriginPincodeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getOriginPincode(){
		  return localOriginPincode;
	  }



	  /**
	   * Auto generated setter method
	   * @param param OriginPincode
	   */
	  public void setOriginPincode(java.lang.String param){
		  localOriginPincodeTracker = true;

		  this.localOriginPincode=param;


	  }


	  /**
	   * field for OriginSC
	   */


	  protected java.lang.String localOriginSC ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localOriginSCTracker = false ;

	  public boolean isOriginSCSpecified(){
		  return localOriginSCTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getOriginSC(){
		  return localOriginSC;
	  }



	  /**
	   * Auto generated setter method
	   * @param param OriginSC
	   */
	  public void setOriginSC(java.lang.String param){
		  localOriginSCTracker = true;

		  this.localOriginSC=param;


	  }


	  /**
	   * field for OverHandlingFlag
	   */


	  protected java.lang.String localOverHandlingFlag ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localOverHandlingFlagTracker = false ;

	  public boolean isOverHandlingFlagSpecified(){
		  return localOverHandlingFlagTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getOverHandlingFlag(){
		  return localOverHandlingFlag;
	  }



	  /**
	   * Auto generated setter method
	   * @param param OverHandlingFlag
	   */
	  public void setOverHandlingFlag(java.lang.String param){
		  localOverHandlingFlagTracker = true;

		  this.localOverHandlingFlag=param;


	  }


	  /**
	   * field for PackageType
	   */


	  protected java.lang.String localPackageType ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localPackageTypeTracker = false ;

	  public boolean isPackageTypeSpecified(){
		  return localPackageTypeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getPackageType(){
		  return localPackageType;
	  }



	  /**
	   * Auto generated setter method
	   * @param param PackageType
	   */
	  public void setPackageType(java.lang.String param){
		  localPackageTypeTracker = true;

		  this.localPackageType=param;


	  }


	  /**
	   * field for ProductCode
	   */


	  protected java.lang.String localProductCode ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localProductCodeTracker = false ;

	  public boolean isProductCodeSpecified(){
		  return localProductCodeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getProductCode(){
		  return localProductCode;
	  }



	  /**
	   * Auto generated setter method
	   * @param param ProductCode
	   */
	  public void setProductCode(java.lang.String param){
		  localProductCodeTracker = true;

		  this.localProductCode=param;


	  }


	  /**
	   * field for ProductType
	   */


	  protected java.lang.String localProductType ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localProductTypeTracker = false ;

	  public boolean isProductTypeSpecified(){
		  return localProductTypeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getProductType(){
		  return localProductType;
	  }



	  /**
	   * Auto generated setter method
	   * @param param ProductType
	   */
	  public void setProductType(java.lang.String param){
		  localProductTypeTracker = true;

		  this.localProductType=param;


	  }


	  /**
	   * field for SubProduct
	   */


	  protected java.lang.String localSubProduct ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localSubProductTracker = false ;

	  public boolean isSubProductSpecified(){
		  return localSubProductTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getSubProduct(){
		  return localSubProduct;
	  }



	  /**
	   * Auto generated setter method
	   * @param param SubProduct
	   */
	  public void setSubProduct(java.lang.String param){
		  localSubProductTracker = true;

		  this.localSubProduct=param;


	  }


	  /**
	   * field for TDDServiceFlag
	   */


	  protected java.lang.String localTDDServiceFlag ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localTDDServiceFlagTracker = false ;

	  public boolean isTDDServiceFlagSpecified(){
		  return localTDDServiceFlagTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getTDDServiceFlag(){
		  return localTDDServiceFlag;
	  }



	  /**
	   * Auto generated setter method
	   * @param param TDDServiceFlag
	   */
	  public void setTDDServiceFlag(java.lang.String param){
		  localTDDServiceFlagTracker = true;

		  this.localTDDServiceFlag=param;


	  }


	  /**
	   * field for TransactionCode
	   */


	  protected java.lang.String localTransactionCode ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localTransactionCodeTracker = false ;

	  public boolean isTransactionCodeSpecified(){
		  return localTransactionCodeTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getTransactionCode(){
		  return localTransactionCode;
	  }



	  /**
	   * Auto generated setter method
	   * @param param TransactionCode
	   */
	  public void setTransactionCode(java.lang.String param){
		  localTransactionCodeTracker = true;

		  this.localTransactionCode=param;


	  }


	  /**
	   * field for VolumetricWeight
	   */


	  protected double localVolumetricWeight ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localVolumetricWeightTracker = false ;

	  public boolean isVolumetricWeightSpecified(){
		  return localVolumetricWeightTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return double
	   */
	  public  double getVolumetricWeight(){
		  return localVolumetricWeight;
	  }



	  /**
	   * Auto generated setter method
	   * @param param VolumetricWeight
	   */
	  public void setVolumetricWeight(double param){

		  // setting primitive attribute tracker to true
		  localVolumetricWeightTracker =
				  !java.lang.Double.isNaN(param);

		  this.localVolumetricWeight=param;


	  }


	  /**
	   * field for Gtot
	   */


	  protected double localGtot ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localGtotTracker = false ;

	  public boolean isGtotSpecified(){
		  return localGtotTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return double
	   */
	  public  double getGtot(){
		  return localGtot;
	  }



	  /**
	   * Auto generated setter method
	   * @param param Gtot
	   */
	  public void setGtot(double param){

		  // setting primitive attribute tracker to true
		  localGtotTracker =
				  !java.lang.Double.isNaN(param);

		  this.localGtot=param;


	  }


	  /**
	   * field for PromoCD
	   */


	  protected java.lang.String localPromoCD ;

	  /*  This tracker boolean wil be used to detect whether the user called the set method
	   *   for this attribute. It will be used to determine whether to include this field
	   *   in the serialized XML
	   */
	  protected boolean localPromoCDTracker = false ;

	  public boolean isPromoCDSpecified(){
		  return localPromoCDTracker;
	  }



	  /**
	   * Auto generated getter method
	   * @return java.lang.String
	   */
	  public  java.lang.String getPromoCD(){
		  return localPromoCD;
	  }



	  /**
	   * Auto generated setter method
	   * @param param PromoCD
	   */
	  public void setPromoCD(java.lang.String param){
		  localPromoCDTracker = true;

		  this.localPromoCD=param;


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
				  new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
		  return factory.createOMElement(dataSource,parentQName);

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




		  java.lang.String prefix = null;
		  java.lang.String namespace = null;


		  prefix = parentQName.getPrefix();
		  namespace = parentQName.getNamespaceURI();
		  writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

		  if (serializeType){


			  java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Pickup");
			  if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
						  namespacePrefix+":RateQueryInput",
						  xmlWriter);
			  } else {
				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
						  "RateQueryInput",
						  xmlWriter);
			  }


		  }
		  if (localActualWeightTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "ActualWeight", xmlWriter);

			  if (java.lang.Double.isNaN(localActualWeight)) {

				  throw new org.apache.axis2.databinding.ADBException("ActualWeight cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActualWeight));
			  }

			  xmlWriter.writeEndElement();
		  } if (localAwbNoTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "AwbNo", xmlWriter);


			  if (localAwbNo==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localAwbNo);

			  }

			  xmlWriter.writeEndElement();
		  } if (localBatchDateTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "BatchDate", xmlWriter);


			  if (localBatchDate==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localBatchDate);

			  }

			  xmlWriter.writeEndElement();
		  } if (localCriticalExpressFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "CriticalExpressFlag", xmlWriter);


			  if (localCriticalExpressFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localCriticalExpressFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localCurrencyAdjustFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "CurrencyAdjustFlag", xmlWriter);


			  if (localCurrencyAdjustFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localCurrencyAdjustFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localCustomerCodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "CustomerCode", xmlWriter);


			  if (localCustomerCode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localCustomerCode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localDCFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "DCFlag", xmlWriter);


			  if (localDCFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localDCFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localDeclareValueTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "DeclareValue", xmlWriter);

			  if (java.lang.Double.isNaN(localDeclareValue)) {

				  throw new org.apache.axis2.databinding.ADBException("DeclareValue cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeclareValue));
			  }

			  xmlWriter.writeEndElement();
		  } if (localDestinationAreaTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "DestinationArea", xmlWriter);


			  if (localDestinationArea==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localDestinationArea);

			  }

			  xmlWriter.writeEndElement();
		  } if (localDestinationPincodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "DestinationPincode", xmlWriter);


			  if (localDestinationPincode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localDestinationPincode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localDestinationSCTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "DestinationSC", xmlWriter);


			  if (localDestinationSC==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localDestinationSC);

			  }

			  xmlWriter.writeEndElement();
		  } if (localEDLFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "EDLFlag", xmlWriter);


			  if (localEDLFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localEDLFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localESACodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "ESACode", xmlWriter);


			  if (localESACode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localESACode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localFSAmountTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "FSAmount", xmlWriter);


			  if (localFSAmount==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localFSAmount);

			  }

			  xmlWriter.writeEndElement();
		  } if (localFreightTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "Freight", xmlWriter);

			  if (java.lang.Double.isNaN(localFreight)) {

				  throw new org.apache.axis2.databinding.ADBException("Freight cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFreight));
			  }

			  xmlWriter.writeEndElement();
		  } if (localFuelSurchargeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "FuelSurcharge", xmlWriter);

			  if (java.lang.Double.isNaN(localFuelSurcharge)) {

				  throw new org.apache.axis2.databinding.ADBException("FuelSurcharge cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFuelSurcharge));
			  }

			  xmlWriter.writeEndElement();
		  } if (localInsuranceTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "Insurance", xmlWriter);


			  if (localInsurance==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localInsurance);

			  }

			  xmlWriter.writeEndElement();
		  } if (localKGPoundTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "KGPound", xmlWriter);


			  if (localKGPound==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localKGPound);

			  }

			  xmlWriter.writeEndElement();
		  } if (localNamountTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "Namount", xmlWriter);


			  if (localNamount==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localNamount);

			  }

			  xmlWriter.writeEndElement();
		  } if (localOWSPFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "OWSPFlag", xmlWriter);


			  if (localOWSPFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localOWSPFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localOriginAreaTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "OriginArea", xmlWriter);


			  if (localOriginArea==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localOriginArea);

			  }

			  xmlWriter.writeEndElement();
		  } if (localOriginPincodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "OriginPincode", xmlWriter);


			  if (localOriginPincode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localOriginPincode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localOriginSCTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "OriginSC", xmlWriter);


			  if (localOriginSC==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localOriginSC);

			  }

			  xmlWriter.writeEndElement();
		  } if (localOverHandlingFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "OverHandlingFlag", xmlWriter);


			  if (localOverHandlingFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localOverHandlingFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localPackageTypeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "PackageType", xmlWriter);


			  if (localPackageType==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localPackageType);

			  }

			  xmlWriter.writeEndElement();
		  } if (localProductCodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "ProductCode", xmlWriter);


			  if (localProductCode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localProductCode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localProductTypeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "ProductType", xmlWriter);


			  if (localProductType==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localProductType);

			  }

			  xmlWriter.writeEndElement();
		  } if (localSubProductTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "SubProduct", xmlWriter);


			  if (localSubProduct==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localSubProduct);

			  }

			  xmlWriter.writeEndElement();
		  } if (localTDDServiceFlagTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "TDDServiceFlag", xmlWriter);


			  if (localTDDServiceFlag==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localTDDServiceFlag);

			  }

			  xmlWriter.writeEndElement();
		  } if (localTransactionCodeTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "TransactionCode", xmlWriter);


			  if (localTransactionCode==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localTransactionCode);

			  }

			  xmlWriter.writeEndElement();
		  } if (localVolumetricWeightTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "VolumetricWeight", xmlWriter);

			  if (java.lang.Double.isNaN(localVolumetricWeight)) {

				  throw new org.apache.axis2.databinding.ADBException("VolumetricWeight cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVolumetricWeight));
			  }

			  xmlWriter.writeEndElement();
		  } if (localGtotTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "gtot", xmlWriter);

			  if (java.lang.Double.isNaN(localGtot)) {

				  throw new org.apache.axis2.databinding.ADBException("gtot cannot be null!!");

			  } else {
				  xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGtot));
			  }

			  xmlWriter.writeEndElement();
		  } if (localPromoCDTracker){
			  namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			  writeStartElement(null, namespace, "promoCD", xmlWriter);


			  if (localPromoCD==null){
				  // write the nil attribute

				  writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			  }else{


				  xmlWriter.writeCharacters(localPromoCD);

			  }

			  xmlWriter.writeEndElement();
		  }
		  xmlWriter.writeEndElement();


	  }

	  private static java.lang.String generatePrefix(java.lang.String namespace) {
		  if(namespace.equals("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup")){
			  return "ns12";
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



		  java.util.ArrayList elementList = new java.util.ArrayList();
		  java.util.ArrayList attribList = new java.util.ArrayList();

		  if (localActualWeightTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "ActualWeight"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActualWeight));
		  } if (localAwbNoTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "AwbNo"));

			  elementList.add(localAwbNo==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAwbNo));
		  } if (localBatchDateTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "BatchDate"));

			  elementList.add(localBatchDate==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatchDate));
		  } if (localCriticalExpressFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "CriticalExpressFlag"));

			  elementList.add(localCriticalExpressFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCriticalExpressFlag));
		  } if (localCurrencyAdjustFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "CurrencyAdjustFlag"));

			  elementList.add(localCurrencyAdjustFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrencyAdjustFlag));
		  } if (localCustomerCodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "CustomerCode"));

			  elementList.add(localCustomerCode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustomerCode));
		  } if (localDCFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "DCFlag"));

			  elementList.add(localDCFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDCFlag));
		  } if (localDeclareValueTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "DeclareValue"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeclareValue));
		  } if (localDestinationAreaTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "DestinationArea"));

			  elementList.add(localDestinationArea==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDestinationArea));
		  } if (localDestinationPincodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "DestinationPincode"));

			  elementList.add(localDestinationPincode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDestinationPincode));
		  } if (localDestinationSCTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "DestinationSC"));

			  elementList.add(localDestinationSC==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDestinationSC));
		  } if (localEDLFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "EDLFlag"));

			  elementList.add(localEDLFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEDLFlag));
		  } if (localESACodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "ESACode"));

			  elementList.add(localESACode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localESACode));
		  } if (localFSAmountTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "FSAmount"));

			  elementList.add(localFSAmount==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFSAmount));
		  } if (localFreightTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "Freight"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFreight));
		  } if (localFuelSurchargeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "FuelSurcharge"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFuelSurcharge));
		  } if (localInsuranceTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "Insurance"));

			  elementList.add(localInsurance==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInsurance));
		  } if (localKGPoundTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "KGPound"));

			  elementList.add(localKGPound==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localKGPound));
		  } if (localNamountTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "Namount"));

			  elementList.add(localNamount==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNamount));
		  } if (localOWSPFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "OWSPFlag"));

			  elementList.add(localOWSPFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOWSPFlag));
		  } if (localOriginAreaTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "OriginArea"));

			  elementList.add(localOriginArea==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOriginArea));
		  } if (localOriginPincodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "OriginPincode"));

			  elementList.add(localOriginPincode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOriginPincode));
		  } if (localOriginSCTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "OriginSC"));

			  elementList.add(localOriginSC==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOriginSC));
		  } if (localOverHandlingFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "OverHandlingFlag"));

			  elementList.add(localOverHandlingFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOverHandlingFlag));
		  } if (localPackageTypeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "PackageType"));

			  elementList.add(localPackageType==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPackageType));
		  } if (localProductCodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "ProductCode"));

			  elementList.add(localProductCode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductCode));
		  } if (localProductTypeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "ProductType"));

			  elementList.add(localProductType==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductType));
		  } if (localSubProductTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "SubProduct"));

			  elementList.add(localSubProduct==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubProduct));
		  } if (localTDDServiceFlagTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "TDDServiceFlag"));

			  elementList.add(localTDDServiceFlag==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTDDServiceFlag));
		  } if (localTransactionCodeTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "TransactionCode"));

			  elementList.add(localTransactionCode==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTransactionCode));
		  } if (localVolumetricWeightTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "VolumetricWeight"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVolumetricWeight));
		  } if (localGtotTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "gtot"));

			  elementList.add(
					  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGtot));
		  } if (localPromoCDTracker){
			  elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					  "promoCD"));

			  elementList.add(localPromoCD==null?null:
				  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromoCD));
		  }

		  return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



	  }



	  /**
	   *  Factory class that keeps the parse method
	   */
	  public static class Factory{




		  /**
		   * static method to create the object
		   * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
		   *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
		   * Postcondition: If this object is an element, the reader is positioned at its end element
		   *                If this object is a complex type, the reader is positioned at the end element of its outer element
		   */
		  public static RateQueryInput parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
			  RateQueryInput object =
					  new RateQueryInput();

			  int event;
			  java.lang.String nillableValue = null;
			  java.lang.String prefix ="";
			  java.lang.String namespaceuri ="";
			  try {

				  while (!reader.isStartElement() && !reader.isEndElement())
					  reader.next();


				  if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
					  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
							  "type");
					  if (fullTypeName!=null){
						  java.lang.String nsPrefix = null;
						  if (fullTypeName.indexOf(":") > -1){
							  nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
						  }
						  nsPrefix = nsPrefix==null?"":nsPrefix;

						  java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

						  if (!"RateQueryInput".equals(type)){
							  //find namespace for the prefix
							  java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							  return (RateQueryInput)org.tempuri.imports.ExtensionMapper.getTypeObject(
									  nsUri,type,reader);
						  }


					  }


				  }




				  // Note all attributes that were handled. Used to differ normal attributes
				  // from anyAttributes.
				  java.util.Vector handledAttributes = new java.util.Vector();




				  reader.next();


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ActualWeight").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"ActualWeight" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setActualWeight(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setActualWeight(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","AwbNo").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setAwbNo(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","BatchDate").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setBatchDate(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","CriticalExpressFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setCriticalExpressFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","CurrencyAdjustFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setCurrencyAdjustFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","CustomerCode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setCustomerCode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DCFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setDCFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DeclareValue").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"DeclareValue" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setDeclareValue(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setDeclareValue(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DestinationArea").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setDestinationArea(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DestinationPincode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setDestinationPincode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DestinationSC").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setDestinationSC(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","EDLFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setEDLFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ESACode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setESACode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","FSAmount").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setFSAmount(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Freight").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"Freight" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setFreight(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setFreight(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","FuelSurcharge").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"FuelSurcharge" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setFuelSurcharge(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setFuelSurcharge(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Insurance").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setInsurance(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","KGPound").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setKGPound(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Namount").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setNamount(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OWSPFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setOWSPFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OriginArea").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setOriginArea(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OriginPincode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setOriginPincode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OriginSC").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setOriginSC(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OverHandlingFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setOverHandlingFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","PackageType").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setPackageType(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ProductCode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setProductCode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ProductType").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setProductType(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","SubProduct").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setSubProduct(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","TDDServiceFlag").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setTDDServiceFlag(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","TransactionCode").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setTransactionCode(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","VolumetricWeight").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"VolumetricWeight" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setVolumetricWeight(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setVolumetricWeight(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","gtot").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						  throw new org.apache.axis2.databinding.ADBException("The element: "+"gtot" +"  cannot be null");
					  }


					  java.lang.String content = reader.getElementText();

					  object.setGtot(
							  org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					  reader.next();

				  }  // End of if for expected property start element

				  else {

					  object.setGtot(java.lang.Double.NaN);

				  }


				  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				  if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","promoCD").equals(reader.getName())){

					  nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					  if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						  java.lang.String content = reader.getElementText();

						  object.setPromoCD(
								  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					  } else {


						  reader.getElementText(); // throw away text nodes if any.
					  }

					  reader.next();

				  }  // End of if for expected property start element

				  else {

				  }

				  while (!reader.isStartElement() && !reader.isEndElement())
					  reader.next();

				  if (reader.isStartElement())
					  // A start element we are not expecting indicates a trailing invalid property
					  throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());




			  } catch (javax.xml.stream.XMLStreamException e) {
				  throw new java.lang.Exception(e);
			  }

			  return object;
		  }

	  }//end of factory class



}

