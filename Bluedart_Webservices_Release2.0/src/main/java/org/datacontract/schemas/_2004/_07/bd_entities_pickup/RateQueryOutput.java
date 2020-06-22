
/**
 * RateQueryOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package org.datacontract.schemas._2004._07.bd_entities_pickup;


/**
 *  RateQueryOutput bean class
 */
@SuppressWarnings({"unchecked","unused"})

public  class RateQueryOutput extends org.datacontract.schemas._2004._07.bd_entities_common.EntityBase
implements org.apache.axis2.databinding.ADBBean{
	/* This type was generated from the piece of schema that had
                name = RateQueryOutput
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Pickup
                Namespace Prefix = ns12
	 */


	/**
	 * field for AWBFee
	 */


	protected double localAWBFee ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localAWBFeeTracker = false ;

	public boolean isAWBFeeSpecified(){
		return localAWBFeeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getAWBFee(){
		return localAWBFee;
	}



	/**
	 * Auto generated setter method
	 * @param param AWBFee
	 */
	public void setAWBFee(double param){

		// setting primitive attribute tracker to true
		localAWBFeeTracker =
				!java.lang.Double.isNaN(param);

		this.localAWBFee=param;


	}


	/**
	 * field for CAFCharges
	 */


	protected double localCAFCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localCAFChargesTracker = false ;

	public boolean isCAFChargesSpecified(){
		return localCAFChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getCAFCharges(){
		return localCAFCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param CAFCharges
	 */
	public void setCAFCharges(double param){

		// setting primitive attribute tracker to true
		localCAFChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localCAFCharges=param;


	}


	/**
	 * field for DCCharge
	 */


	protected double localDCCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localDCChargeTracker = false ;

	public boolean isDCChargeSpecified(){
		return localDCChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getDCCharge(){
		return localDCCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param DCCharge
	 */
	public void setDCCharge(double param){

		// setting primitive attribute tracker to true
		localDCChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localDCCharge=param;


	}


	/**
	 * field for DODCharge
	 */


	protected double localDODCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localDODChargeTracker = false ;

	public boolean isDODChargeSpecified(){
		return localDODChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getDODCharge(){
		return localDODCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param DODCharge
	 */
	public void setDODCharge(double param){

		// setting primitive attribute tracker to true
		localDODChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localDODCharge=param;


	}


	/**
	 * field for ECCCharges
	 */


	protected double localECCCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localECCChargesTracker = false ;

	public boolean isECCChargesSpecified(){
		return localECCChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getECCCharges(){
		return localECCCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param ECCCharges
	 */
	public void setECCCharges(double param){

		// setting primitive attribute tracker to true
		localECCChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localECCCharges=param;


	}


	/**
	 * field for EDLCharge
	 */


	protected double localEDLCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localEDLChargeTracker = false ;

	public boolean isEDLChargeSpecified(){
		return localEDLChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getEDLCharge(){
		return localEDLCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param EDLCharge
	 */
	public void setEDLCharge(double param){

		// setting primitive attribute tracker to true
		localEDLChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localEDLCharge=param;


	}
	
	/**
	 * field for ESSCharges
	 */


	protected double localESSCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localESSChargesTracker = false ;

	public boolean isESSChargesSpecified(){
		return localESSChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getESSCharges(){
		return localESSCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param ESSCharges
	 */
	public void setESSCharges(double param){

		// setting primitive attribute tracker to true
		localESSChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localESSCharges=param;


	}


	/**
	 * field for ElevRiskCharges
	 */


	protected double localElevRiskCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localElevRiskChargesTracker = false ;

	public boolean isElevRiskChargesSpecified(){
		return localElevRiskChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getElevRiskCharges(){
		return localElevRiskCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param ElevRiskCharges
	 */
	public void setElevRiskCharges(double param){

		// setting primitive attribute tracker to true
		localElevRiskChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localElevRiskCharges=param;


	}


	/**
	 * field for FODCharge
	 */


	protected double localFODCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localFODChargeTracker = false ;

	public boolean isFODChargeSpecified(){
		return localFODChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getFODCharge(){
		return localFODCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param FODCharge
	 */
	public void setFODCharge(double param){

		// setting primitive attribute tracker to true
		localFODChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localFODCharge=param;


	}


	/**
	 * field for FOVCharge
	 */


	protected double localFOVCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localFOVChargeTracker = false ;

	public boolean isFOVChargeSpecified(){
		return localFOVChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getFOVCharge(){
		return localFOVCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param FOVCharge
	 */
	public void setFOVCharge(double param){

		// setting primitive attribute tracker to true
		localFOVChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localFOVCharge=param;


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
	 * field for GrandTotal
	 */


	protected double localGrandTotal ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localGrandTotalTracker = false ;

	public boolean isGrandTotalSpecified(){
		return localGrandTotalTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getGrandTotal(){
		return localGrandTotal;
	}



	/**
	 * Auto generated setter method
	 * @param param GrandTotal
	 */
	public void setGrandTotal(double param){

		// setting primitive attribute tracker to true
		localGrandTotalTracker =
				!java.lang.Double.isNaN(param);

		this.localGrandTotal=param;


	}


	/**
	 * field for IDCCharges
	 */


	protected double localIDCCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localIDCChargesTracker = false ;

	public boolean isIDCChargesSpecified(){
		return localIDCChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getIDCCharges(){
		return localIDCCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param IDCCharges
	 */
	public void setIDCCharges(double param){

		// setting primitive attribute tracker to true
		localIDCChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localIDCCharges=param;


	}


	/**
	 * field for OWSPCharges
	 */


	protected double localOWSPCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localOWSPChargesTracker = false ;

	public boolean isOWSPChargesSpecified(){
		return localOWSPChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getOWSPCharges(){
		return localOWSPCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param OWSPCharges
	 */
	public void setOWSPCharges(double param){

		// setting primitive attribute tracker to true
		localOWSPChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localOWSPCharges=param;


	}


	/**
	 * field for OtherCharges
	 */


	protected double localOtherCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localOtherChargesTracker = false ;

	public boolean isOtherChargesSpecified(){
		return localOtherChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getOtherCharges(){
		return localOtherCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param OtherCharges
	 */
	public void setOtherCharges(double param){

		// setting primitive attribute tracker to true
		localOtherChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localOtherCharges=param;


	}


	/**
	 * field for OverHandCharges
	 */


	protected double localOverHandCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localOverHandChargesTracker = false ;

	public boolean isOverHandChargesSpecified(){
		return localOverHandChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getOverHandCharges(){
		return localOverHandCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param OverHandCharges
	 */
	public void setOverHandCharges(double param){

		// setting primitive attribute tracker to true
		localOverHandChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localOverHandCharges=param;


	}


	/**
	 * field for RASCharge
	 */


	protected double localRASCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localRASChargeTracker = false ;

	public boolean isRASChargeSpecified(){
		return localRASChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getRASCharge(){
		return localRASCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param RASCharge
	 */
	public void setRASCharge(double param){

		// setting primitive attribute tracker to true
		localRASChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localRASCharge=param;


	}


	/**
	 * field for RestrDSTCharges
	 */


	protected double localRestrDSTCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localRestrDSTChargesTracker = false ;

	public boolean isRestrDSTChargesSpecified(){
		return localRestrDSTChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getRestrDSTCharges(){
		return localRestrDSTCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param RestrDSTCharges
	 */
	public void setRestrDSTCharges(double param){

		// setting primitive attribute tracker to true
		localRestrDSTChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localRestrDSTCharges=param;


	}


	/**
	 * field for ServiceTaxPlusCess
	 */


	protected double localServiceTaxPlusCess ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localServiceTaxPlusCessTracker = false ;

	public boolean isServiceTaxPlusCessSpecified(){
		return localServiceTaxPlusCessTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getServiceTaxPlusCess(){
		return localServiceTaxPlusCess;
	}



	/**
	 * Auto generated setter method
	 * @param param ServiceTaxPlusCess
	 */
	public void setServiceTaxPlusCess(double param){

		// setting primitive attribute tracker to true
		localServiceTaxPlusCessTracker =
				!java.lang.Double.isNaN(param);

		this.localServiceTaxPlusCess=param;


	}


	/**
	 * field for TDDCharges
	 */


	protected double localTDDCharges ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localTDDChargesTracker = false ;

	public boolean isTDDChargesSpecified(){
		return localTDDChargesTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getTDDCharges(){
		return localTDDCharges;
	}



	/**
	 * Auto generated setter method
	 * @param param TDDCharges
	 */
	public void setTDDCharges(double param){

		// setting primitive attribute tracker to true
		localTDDChargesTracker =
				!java.lang.Double.isNaN(param);

		this.localTDDCharges=param;


	}


	/**
	 * field for Total
	 */


	protected double localTotal ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localTotalTracker = false ;

	public boolean isTotalSpecified(){
		return localTotalTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getTotal(){
		return localTotal;
	}



	/**
	 * Auto generated setter method
	 * @param param Total
	 */
	public void setTotal(double param){

		// setting primitive attribute tracker to true
		localTotalTracker =
				!java.lang.Double.isNaN(param);

		this.localTotal=param;


	}


	/**
	 * field for VCHCCharge
	 */


	protected double localVCHCCharge ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localVCHCChargeTracker = false ;

	public boolean isVCHCChargeSpecified(){
		return localVCHCChargeTracker;
	}



	/**
	 * Auto generated getter method
	 * @return double
	 */
	public  double getVCHCCharge(){
		return localVCHCCharge;
	}



	/**
	 * Auto generated setter method
	 * @param param VCHCCharge
	 */
	public void setVCHCCharge(double param){

		// setting primitive attribute tracker to true
		localVCHCChargeTracker =
				!java.lang.Double.isNaN(param);

		this.localVCHCCharge=param;


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


		java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Pickup");
		if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
			writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
					namespacePrefix+":RateQueryOutput",
					xmlWriter);
		} else {
			writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
					"RateQueryOutput",
					xmlWriter);
		}

		if (localHandheldTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
			writeStartElement(null, namespace, "Handheld", xmlWriter);


			if (localHandheld==null){
				// write the nil attribute

				writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			}else{


				xmlWriter.writeCharacters(localHandheld);

			}

			xmlWriter.writeEndElement();
		} if (localLocationTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
			writeStartElement(null, namespace, "Location", xmlWriter);


			if (localLocation==null){
				// write the nil attribute

				writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			}else{


				xmlWriter.writeCharacters(localLocation);

			}

			xmlWriter.writeEndElement();
		} if (localLoginIdTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
			writeStartElement(null, namespace, "LoginId", xmlWriter);


			if (localLoginId==null){
				// write the nil attribute

				writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

			}else{


				xmlWriter.writeCharacters(localLoginId);

			}

			xmlWriter.writeEndElement();
		} if (localAWBFeeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "AWBFee", xmlWriter);

			if (java.lang.Double.isNaN(localAWBFee)) {

				throw new org.apache.axis2.databinding.ADBException("AWBFee cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAWBFee));
			}

			xmlWriter.writeEndElement();
		} if (localCAFChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "CAFCharges", xmlWriter);

			if (java.lang.Double.isNaN(localCAFCharges)) {

				throw new org.apache.axis2.databinding.ADBException("CAFCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCAFCharges));
			}

			xmlWriter.writeEndElement();
		} if (localDCChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "DCCharge", xmlWriter);

			if (java.lang.Double.isNaN(localDCCharge)) {

				throw new org.apache.axis2.databinding.ADBException("DCCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDCCharge));
			}

			xmlWriter.writeEndElement();
		} if (localDODChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "DODCharge", xmlWriter);

			if (java.lang.Double.isNaN(localDODCharge)) {

				throw new org.apache.axis2.databinding.ADBException("DODCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDODCharge));
			}

			xmlWriter.writeEndElement();
		} if (localECCChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "ECCCharges", xmlWriter);

			if (java.lang.Double.isNaN(localECCCharges)) {

				throw new org.apache.axis2.databinding.ADBException("ECCCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localECCCharges));
			}

			xmlWriter.writeEndElement();
		} if (localEDLChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "EDLCharge", xmlWriter);

			if (java.lang.Double.isNaN(localEDLCharge)) {

				throw new org.apache.axis2.databinding.ADBException("EDLCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEDLCharge));
			}

			xmlWriter.writeEndElement();
		}if(localESSChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "ESSCharges", xmlWriter);

			if (java.lang.Double.isNaN(localESSCharges)) {

				throw new org.apache.axis2.databinding.ADBException("ESSCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localESSCharges));
			}

			xmlWriter.writeEndElement();

		} if (localElevRiskChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "ElevRiskCharges", xmlWriter);

			if (java.lang.Double.isNaN(localElevRiskCharges)) {

				throw new org.apache.axis2.databinding.ADBException("ElevRiskCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localElevRiskCharges));
			}

			xmlWriter.writeEndElement();
		} if (localFODChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "FODCharge", xmlWriter);

			if (java.lang.Double.isNaN(localFODCharge)) {

				throw new org.apache.axis2.databinding.ADBException("FODCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFODCharge));
			}

			xmlWriter.writeEndElement();
		} if (localFOVChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "FOVCharge", xmlWriter);

			if (java.lang.Double.isNaN(localFOVCharge)) {

				throw new org.apache.axis2.databinding.ADBException("FOVCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFOVCharge));
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
		} if (localGrandTotalTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "GrandTotal", xmlWriter);

			if (java.lang.Double.isNaN(localGrandTotal)) {

				throw new org.apache.axis2.databinding.ADBException("GrandTotal cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGrandTotal));
			}

			xmlWriter.writeEndElement();
		} if (localIDCChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "IDCCharges", xmlWriter);

			if (java.lang.Double.isNaN(localIDCCharges)) {

				throw new org.apache.axis2.databinding.ADBException("IDCCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIDCCharges));
			}

			xmlWriter.writeEndElement();
		} if (localOWSPChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "OWSPCharges", xmlWriter);

			if (java.lang.Double.isNaN(localOWSPCharges)) {

				throw new org.apache.axis2.databinding.ADBException("OWSPCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOWSPCharges));
			}

			xmlWriter.writeEndElement();
		} if (localOtherChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "OtherCharges", xmlWriter);

			if (java.lang.Double.isNaN(localOtherCharges)) {

				throw new org.apache.axis2.databinding.ADBException("OtherCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOtherCharges));
			}

			xmlWriter.writeEndElement();
		} if (localOverHandChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "OverHandCharges", xmlWriter);

			if (java.lang.Double.isNaN(localOverHandCharges)) {

				throw new org.apache.axis2.databinding.ADBException("OverHandCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOverHandCharges));
			}

			xmlWriter.writeEndElement();
		} if (localRASChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "RASCharge", xmlWriter);

			if (java.lang.Double.isNaN(localRASCharge)) {

				throw new org.apache.axis2.databinding.ADBException("RASCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRASCharge));
			}

			xmlWriter.writeEndElement();
		} if (localRestrDSTChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "RestrDSTCharges", xmlWriter);

			if (java.lang.Double.isNaN(localRestrDSTCharges)) {

				throw new org.apache.axis2.databinding.ADBException("RestrDSTCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRestrDSTCharges));
			}

			xmlWriter.writeEndElement();
		} if (localServiceTaxPlusCessTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "ServiceTaxPlusCess", xmlWriter);

			if (java.lang.Double.isNaN(localServiceTaxPlusCess)) {

				throw new org.apache.axis2.databinding.ADBException("ServiceTaxPlusCess cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServiceTaxPlusCess));
			}

			xmlWriter.writeEndElement();
		} if (localTDDChargesTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "TDDCharges", xmlWriter);

			if (java.lang.Double.isNaN(localTDDCharges)) {

				throw new org.apache.axis2.databinding.ADBException("TDDCharges cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTDDCharges));
			}

			xmlWriter.writeEndElement();
		} if (localTotalTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "Total", xmlWriter);

			if (java.lang.Double.isNaN(localTotal)) {

				throw new org.apache.axis2.databinding.ADBException("Total cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotal));
			}

			xmlWriter.writeEndElement();
		} if (localVCHCChargeTracker){
			namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			writeStartElement(null, namespace, "VCHCCharge", xmlWriter);

			if (java.lang.Double.isNaN(localVCHCCharge)) {

				throw new org.apache.axis2.databinding.ADBException("VCHCCharge cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVCHCCharge));
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


		attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
		attribList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","RateQueryOutput"));
		if (localHandheldTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common",
					"Handheld"));

			elementList.add(localHandheld==null?null:
				org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHandheld));
		} if (localLocationTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common",
					"Location"));

			elementList.add(localLocation==null?null:
				org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocation));
		} if (localLoginIdTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common",
					"LoginId"));

			elementList.add(localLoginId==null?null:
				org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLoginId));
		} if (localAWBFeeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"AWBFee"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAWBFee));
		} if (localCAFChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"CAFCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCAFCharges));
		} if (localDCChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"DCCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDCCharge));
		} if (localDODChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"DODCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDODCharge));
		} if (localECCChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"ECCCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localECCCharges));
		} if (localEDLChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"EDLCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEDLCharge));
		} if(localESSChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"ESSCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localESSCharges));
		} if (localElevRiskChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"ElevRiskCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localElevRiskCharges));
		} if (localFODChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"FODCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFODCharge));
		} if (localFOVChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"FOVCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFOVCharge));
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
		} if (localGrandTotalTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"GrandTotal"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGrandTotal));
		} if (localIDCChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"IDCCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIDCCharges));
		} if (localOWSPChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"OWSPCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOWSPCharges));
		} if (localOtherChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"OtherCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOtherCharges));
		} if (localOverHandChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"OverHandCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOverHandCharges));
		} if (localRASChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"RASCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRASCharge));
		} if (localRestrDSTChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"RestrDSTCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRestrDSTCharges));
		} if (localServiceTaxPlusCessTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"ServiceTaxPlusCess"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServiceTaxPlusCess));
		} if (localTDDChargesTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"TDDCharges"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTDDCharges));
		} if (localTotalTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"Total"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotal));
		} if (localVCHCChargeTracker){
			elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					"VCHCCharge"));

			elementList.add(
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVCHCCharge));
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
		public static RateQueryOutput parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
			RateQueryOutput object =
					new RateQueryOutput();

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

						if (!"RateQueryOutput".equals(type)){
							//find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (RateQueryOutput)org.tempuri.imports.ExtensionMapper.getTypeObject(
									nsUri,type,reader);
						}


					}


				}




				// Note all attributes that were handled. Used to differ normal attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();




				reader.next();


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Handheld").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						java.lang.String content = reader.getElementText();

						object.setHandheld(
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					} else {


						reader.getElementText(); // throw away text nodes if any.
					}

					reader.next();

				}  // End of if for expected property start element

				else {

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Location").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						java.lang.String content = reader.getElementText();

						object.setLocation(
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					} else {


						reader.getElementText(); // throw away text nodes if any.
					}

					reader.next();

				}  // End of if for expected property start element

				else {

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","LoginId").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){


						java.lang.String content = reader.getElementText();

						object.setLoginId(
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					} else {


						reader.getElementText(); // throw away text nodes if any.
					}

					reader.next();

				}  // End of if for expected property start element

				else {

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","AWBFee").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"AWBFee" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setAWBFee(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setAWBFee(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","CAFCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"CAFCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setCAFCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setCAFCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DCCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"DCCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setDCCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setDCCharge(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","DODCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"DODCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setDODCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setDODCharge(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ECCCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"ECCCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setECCCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setECCCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","EDLCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"EDLCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setEDLCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setEDLCharge(java.lang.Double.NaN);

				}

				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ESSCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"ESSCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setESSCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setESSCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ElevRiskCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"ElevRiskCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setElevRiskCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setElevRiskCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","FODCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"FODCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setFODCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setFODCharge(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","FOVCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"FOVCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setFOVCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setFOVCharge(java.lang.Double.NaN);

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

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","GrandTotal").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"GrandTotal" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setGrandTotal(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setGrandTotal(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","IDCCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"IDCCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setIDCCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setIDCCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OWSPCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"OWSPCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setOWSPCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setOWSPCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OtherCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"OtherCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setOtherCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setOtherCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","OverHandCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"OverHandCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setOverHandCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setOverHandCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","RASCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"RASCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setRASCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setRASCharge(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","RestrDSTCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"RestrDSTCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setRestrDSTCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setRestrDSTCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","ServiceTaxPlusCess").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"ServiceTaxPlusCess" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setServiceTaxPlusCess(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setServiceTaxPlusCess(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","TDDCharges").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"TDDCharges" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setTDDCharges(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setTDDCharges(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Total").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"Total" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setTotal(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setTotal(java.lang.Double.NaN);

				}


				while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","VCHCCharge").equals(reader.getName())){

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						throw new org.apache.axis2.databinding.ADBException("The element: "+"VCHCCharge" +"  cannot be null");
					}


					java.lang.String content = reader.getElementText();

					object.setVCHCCharge(
							org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

					reader.next();

				}  // End of if for expected property start element

				else {

					object.setVCHCCharge(java.lang.Double.NaN);

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

