/**
 * CalledPickupEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:02:19 GMT)
 */
package org.datacontract.schemas._2004._07.bd_entities_pickup;


/**
 *  CalledPickupEntity bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class CalledPickupEntity extends org.datacontract.schemas._2004._07.bd_entities_pickup.CalledPickup
    implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = CalledPickupEntity
       Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Pickup
       Namespace Prefix = ns12
     */

    /**
     * field for OperationFlag
     */
    protected java.lang.String localOperationFlag;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOperationFlagTracker = false;

    /**
     * field for ProductDetails
     */
    protected org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails localProductDetails;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localProductDetailsTracker = false;

    public boolean isOperationFlagSpecified() {
        return localOperationFlagTracker;
    }

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public java.lang.String getOperationFlag() {
        return localOperationFlag;
    }

    /**
     * Auto generated setter method
     * @param param OperationFlag
     */
    public void setOperationFlag(java.lang.String param) {
        localOperationFlagTracker = true;

        this.localOperationFlag = param;
    }

    public boolean isProductDetailsSpecified() {
        return localProductDetailsTracker;
    }

    /**
     * Auto generated getter method
     * @return org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails
     */
    public org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails getProductDetails() {
        return localProductDetails;
    }

    /**
     * Auto generated setter method
     * @param param ProductDetails
     */
    public void setProductDetails(
        org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails param) {
        localProductDetailsTracker = true;

        this.localProductDetails = param;
    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {
        return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                this, parentQName));
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        java.lang.String prefix = null;
        java.lang.String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup");

        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "type", namespacePrefix + ":CalledPickupEntity", xmlWriter);
        } else {
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "type", "CalledPickupEntity", xmlWriter);
        }

        if (localHandheldTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
            writeStartElement(null, namespace, "Handheld", xmlWriter);

            if (localHandheld == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localHandheld);
            }

            xmlWriter.writeEndElement();
        }

        if (localLocationTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
            writeStartElement(null, namespace, "Location", xmlWriter);

            if (localLocation == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localLocation);
            }

            xmlWriter.writeEndElement();
        }

        if (localLoginIdTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Common";
            writeStartElement(null, namespace, "LoginId", xmlWriter);

            if (localLoginId == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localLoginId);
            }

            xmlWriter.writeEndElement();
        }

        if (localCIDTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CID", xmlWriter);

            if (java.lang.Double.isNaN(localCID)) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CID cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localCID));
            }

            xmlWriter.writeEndElement();
        }

        if (localAWBNOTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "AWBNO", xmlWriter);

            if (localAWBNO == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAWBNO);
            }

            xmlWriter.writeEndElement();
        }

        if (localActualPickupDateTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ActualPickupDate", xmlWriter);

            if (localActualPickupDate == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "ActualPickupDate cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localActualPickupDate));
            }

            xmlWriter.writeEndElement();
        }

        if (localActualPickupEmployeeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ActualPickupEmployee", xmlWriter);

            if (localActualPickupEmployee == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ActualPickupEmployee cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localActualPickupEmployee));
            }

            xmlWriter.writeEndElement();
        }

        if (localActualPickupTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ActualPickupTime", xmlWriter);

            if (localActualPickupTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localActualPickupTime);
            }

            xmlWriter.writeEndElement();
        }

        if (localAlternatePickupEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "AlternatePickupEmployeeCode",
                xmlWriter);

            if (localAlternatePickupEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAlternatePickupEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localAlternatePickupRouteTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "AlternatePickupRoute", xmlWriter);

            if (localAlternatePickupRoute == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAlternatePickupRoute);
            }

            xmlWriter.writeEndElement();
        }

        if (localAreaCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "AreaCode", xmlWriter);

            if (localAreaCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAreaCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localBoxTypeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "BoxType", xmlWriter);

            if (localBoxType == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localBoxType);
            }

            xmlWriter.writeEndElement();
        }

        if (localBulkUploadTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "BulkUpload", xmlWriter);

            if (localBulkUpload == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localBulkUpload);
            }

            xmlWriter.writeEndElement();
        }

        if (localCISDDNTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CISDDN", xmlWriter);

            if (localCISDDN == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCISDDN);
            }

            xmlWriter.writeEndElement();
        }

        if (localCREVPUTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CREVPU", xmlWriter);

            if (localCREVPU == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCREVPU);
            }

            xmlWriter.writeEndElement();
        }

        if (localCallerNameTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CallerName", xmlWriter);

            if (localCallerName == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCallerName);
            }

            xmlWriter.writeEndElement();
        }

        if (localCallerPhoneTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CallerPhone", xmlWriter);

            if (localCallerPhone == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCallerPhone);
            }

            xmlWriter.writeEndElement();
        }

        if (localCanceledTokenNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CanceledTokenNumber", xmlWriter);

            if (localCanceledTokenNumber == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CanceledTokenNumber cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localCanceledTokenNumber));
            }

            xmlWriter.writeEndElement();
        }

        if (localContactPersonNameTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ContactPersonName", xmlWriter);

            if (localContactPersonName == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localContactPersonName);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerAddress1Tracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerAddress1", xmlWriter);

            if (localCustomerAddress1 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerAddress1);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerAddress2Tracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerAddress2", xmlWriter);

            if (localCustomerAddress2 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerAddress2);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerAddress3Tracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerAddress3", xmlWriter);

            if (localCustomerAddress3 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerAddress3);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerCode", xmlWriter);

            if (localCustomerCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerFaxNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerFaxNumber", xmlWriter);

            if (localCustomerFaxNumber == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerFaxNumber);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerNameTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerName", xmlWriter);

            if (localCustomerName == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerName);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerPincodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerPincode", xmlWriter);

            if (localCustomerPincode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerPincode);
            }

            xmlWriter.writeEndElement();
        }

        if (localCustomerTelephoneNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "CustomerTelephoneNumber",
                xmlWriter);

            if (localCustomerTelephoneNumber == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCustomerTelephoneNumber);
            }

            xmlWriter.writeEndElement();
        }

        if (localDODShipmentIdentifierTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "DODShipmentIdentifier",
                xmlWriter);

            if (localDODShipmentIdentifier == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localDODShipmentIdentifier);
            }

            xmlWriter.writeEndElement();
        }

        if (localDTPTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "DTP", xmlWriter);

            if (localDTP == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localDTP);
            }

            xmlWriter.writeEndElement();
        }

        if (localDataEntryEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "DataEntryEmployeeCode",
                xmlWriter);

            if (localDataEntryEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localDataEntryEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localDoxNDoxTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "DoxNDox", xmlWriter);

            if (localDoxNDox == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localDoxNDox);
            }

            xmlWriter.writeEndElement();
        }

        if (localEmailIDTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "EmailID", xmlWriter);

            if (localEmailID == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localEmailID);
            }

            xmlWriter.writeEndElement();
        }

        if (localFODShipmentIdentifierTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "FODShipmentIdentifier",
                xmlWriter);

            if (localFODShipmentIdentifier == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localFODShipmentIdentifier);
            }

            xmlWriter.writeEndElement();
        }

        if (localForcePUTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ForcePU", xmlWriter);

            if (localForcePU == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localForcePU);
            }

            xmlWriter.writeEndElement();
        }

        if (localIMPEXPTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "IMPEXP", xmlWriter);

            if (localIMPEXP == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localIMPEXP);
            }

            xmlWriter.writeEndElement();
        }

        if (localIsConveyedTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "IsConveyed", xmlWriter);

            if (localIsConveyed == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localIsConveyed);
            }

            xmlWriter.writeEndElement();
        }

        if (localLoggedByEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "LoggedByEmployeeCode", xmlWriter);

            if (localLoggedByEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localLoggedByEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localMobileTelNoTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "MobileTelNo", xmlWriter);

            if (localMobileTelNo == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localMobileTelNo);
            }

            xmlWriter.writeEndElement();
        }

        if (localModeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "Mode", xmlWriter);

            if (localMode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localMode);
            }

            xmlWriter.writeEndElement();
        }

        if (localModifiedByEmployeeNameTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ModifiedByEmployeeName",
                xmlWriter);

            if (localModifiedByEmployeeName == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localModifiedByEmployeeName);
            }

            xmlWriter.writeEndElement();
        }

        if (localModifiedDateTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ModifiedDateTime", xmlWriter);

            if (localModifiedDateTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localModifiedDateTime));
            }

            xmlWriter.writeEndElement();
        }

        if (localNPUTMSLOTTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "NPUTMSLOT", xmlWriter);

            if (localNPUTMSLOT == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localNPUTMSLOT);
            }

            xmlWriter.writeEndElement();
        }

        if (localNewTokenNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "NewTokenNumber", xmlWriter);

            if (localNewTokenNumber == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NewTokenNumber cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localNewTokenNumber));
            }

            xmlWriter.writeEndElement();
        }

        if (localNumberofBoxTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "NumberofBox", xmlWriter);

            if (localNumberofBox == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localNumberofBox);
            }

            xmlWriter.writeEndElement();
        }

        if (localNumberofPiecesTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "NumberofPieces", xmlWriter);

            if (localNumberofPieces == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NumberofPieces cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localNumberofPieces));
            }

            xmlWriter.writeEndElement();
        }

        if (localODAShipmentIdentifierTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ODAShipmentIdentifier",
                xmlWriter);

            if (localODAShipmentIdentifier == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localODAShipmentIdentifier);
            }

            xmlWriter.writeEndElement();
        }

        if (localOfficeCloseTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "OfficeCloseTime", xmlWriter);

            if (localOfficeCloseTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localOfficeCloseTime);
            }

            xmlWriter.writeEndElement();
        }

        if (localOldPickupDateTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "OldPickupDate", xmlWriter);

            if (localOldPickupDate == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "OldPickupDate cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localOldPickupDate));
            }

            xmlWriter.writeEndElement();
        }

        if (localPassedByEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PassedByEmployeeCode", xmlWriter);

            if (localPassedByEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPassedByEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localPickupEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PickupEmployeeCode", xmlWriter);

            if (localPickupEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPickupEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localPickupPassedEmployeeCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PickupPassedEmployeeCode",
                xmlWriter);

            if (localPickupPassedEmployeeCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPickupPassedEmployeeCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localPickupPassedTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PickupPassedTime", xmlWriter);

            if (localPickupPassedTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPickupPassedTime);
            }

            xmlWriter.writeEndElement();
        }

        if (localPrintedorNotTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PrintedorNot", xmlWriter);

            if (localPrintedorNot == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPrintedorNot);
            }

            xmlWriter.writeEndElement();
        }

        if (localPriorityShipmentTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "PriorityShipment", xmlWriter);

            if (localPriorityShipment == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPriorityShipment);
            }

            xmlWriter.writeEndElement();
        }

        if (localProductCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ProductCode", xmlWriter);

            if (localProductCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localProductCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localProductTypeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ProductType", xmlWriter);

            if (localProductType == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localProductType);
            }

            xmlWriter.writeEndElement();
        }

        if (localRAWBNOTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RAWBNO", xmlWriter);

            if (localRAWBNO == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRAWBNO);
            }

            xmlWriter.writeEndElement();
        }

        if (localReRegisteredTokenNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ReRegisteredTokenNumber",
                xmlWriter);

            if (localReRegisteredTokenNumber == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReRegisteredTokenNumber cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localReRegisteredTokenNumber));
            }

            xmlWriter.writeEndElement();
        }

        if (localRefNoTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RefNo", xmlWriter);

            if (localRefNo == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRefNo);
            }

            xmlWriter.writeEndElement();
        }

        if (localRegisteredByEmployeeNameTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RegisteredByEmployeeName",
                xmlWriter);

            if (localRegisteredByEmployeeName == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRegisteredByEmployeeName);
            }

            xmlWriter.writeEndElement();
        }

        if (localRegisteredDateTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RegisteredDateTime", xmlWriter);

            if (localRegisteredDateTime == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "RegisteredDateTime cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localRegisteredDateTime));
            }

            xmlWriter.writeEndElement();
        }

        if (localRegisteredOrCallPickupIdentifierTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace,
                "RegisteredOrCallPickupIdentifier", xmlWriter);

            if (localRegisteredOrCallPickupIdentifier == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRegisteredOrCallPickupIdentifier);
            }

            xmlWriter.writeEndElement();
        }

        if (localRegisteredTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RegisteredTime", xmlWriter);

            if (localRegisteredTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRegisteredTime);
            }

            xmlWriter.writeEndElement();
        }

        if (localRemarksTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "Remarks", xmlWriter);

            if (localRemarks == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRemarks);
            }

            xmlWriter.writeEndElement();
        }

        if (localReminderTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "Reminder", xmlWriter);

            if (localReminder == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localReminder);
            }

            xmlWriter.writeEndElement();
        }

        if (localReminderDetailsTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ReminderDetails", xmlWriter);

            if (localReminderDetails == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localReminderDetails);
            }

            xmlWriter.writeEndElement();
        }

        if (localReminderEntryDateTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ReminderEntryDateTime",
                xmlWriter);

            if (localReminderEntryDateTime == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "ReminderEntryDateTime cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localReminderEntryDateTime));
            }

            xmlWriter.writeEndElement();
        }

        if (localRemindersTracker) {
            if (localReminders == null) {
                writeStartElement(null,
                    "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                    "Reminders", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localReminders.serialize(new javax.xml.namespace.QName(
                        "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                        "Reminders"), xmlWriter);
            }
        }

        if (localRescheduledDateTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RescheduledDate", xmlWriter);

            if (localRescheduledDate == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localRescheduledDate));
            }

            xmlWriter.writeEndElement();
        }

        if (localRescheduledPickupFlagTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RescheduledPickupFlag",
                xmlWriter);

            if (localRescheduledPickupFlag == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRescheduledPickupFlag);
            }

            xmlWriter.writeEndElement();
        }

        if (localRouteCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "RouteCode", xmlWriter);

            if (localRouteCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRouteCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localSIITracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "SII", xmlWriter);

            if (localSII == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localSII);
            }

            xmlWriter.writeEndElement();
        }

        if (localSerialNoTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "SerialNo", xmlWriter);

            if (localSerialNo == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SerialNo cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localSerialNo));
            }

            xmlWriter.writeEndElement();
        }

        if (localServiceCenterCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ServiceCenterCode", xmlWriter);

            if (localServiceCenterCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localServiceCenterCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localShipmentPickupDateTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ShipmentPickupDate", xmlWriter);

            if (localShipmentPickupDate == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "ShipmentPickupDate cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localShipmentPickupDate));
            }

            xmlWriter.writeEndElement();
        }

        if (localShipmentPickupTimeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ShipmentPickupTime", xmlWriter);

            if (localShipmentPickupTime == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localShipmentPickupTime);
            }

            xmlWriter.writeEndElement();
        }

        if (localStatusTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "Status", xmlWriter);

            if (localStatus == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localStatus);
            }

            xmlWriter.writeEndElement();
        }

        if (localStatusCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "StatusCode", xmlWriter);

            if (localStatusCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localStatusCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localStatusDescriptionTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "StatusDescription", xmlWriter);

            if (localStatusDescription == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localStatusDescription);
            }

            xmlWriter.writeEndElement();
        }

        if (localStatusTypeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "StatusType", xmlWriter);

            if (localStatusType == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localStatusType);
            }

            xmlWriter.writeEndElement();
        }

        if (localSubProductTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "SubProduct", xmlWriter);

            if (localSubProduct == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localSubProduct);
            }

            xmlWriter.writeEndElement();
        }

        if (localSubProductsTracker) {
            if (localSubProducts == null) {
                writeStartElement(null,
                    "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                    "SubProducts", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localSubProducts.serialize(new javax.xml.namespace.QName(
                        "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                        "SubProducts"), xmlWriter);
            }
        }

        if (localTDDShipmentIdentifierTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "TDDShipmentIdentifier",
                xmlWriter);

            if (localTDDShipmentIdentifier == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localTDDShipmentIdentifier);
            }

            xmlWriter.writeEndElement();
        }

        if (localToPayTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "ToPay", xmlWriter);

            if (localToPay == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localToPay);
            }

            xmlWriter.writeEndElement();
        }

        if (localTokenNumberTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "TokenNumber", xmlWriter);

            if (localTokenNumber == java.lang.Integer.MIN_VALUE) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TokenNumber cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localTokenNumber));
            }

            xmlWriter.writeEndElement();
        }

        if (localTransactionCodeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "TransactionCode", xmlWriter);

            if (localTransactionCode == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localTransactionCode);
            }

            xmlWriter.writeEndElement();
        }

        if (localTransmittedorPassedFlagTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "TransmittedorPassedFlag",
                xmlWriter);

            if (localTransmittedorPassedFlag == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localTransmittedorPassedFlag);
            }

            xmlWriter.writeEndElement();
        }

        if (localVolumeWeightTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "VolumeWeight", xmlWriter);

            if (java.lang.Double.isNaN(localVolumeWeight)) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VolumeWeight cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localVolumeWeight));
            }

            xmlWriter.writeEndElement();
        }

        if (localWeightofShipmentTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "WeightofShipment", xmlWriter);

            if (java.lang.Double.isNaN(localWeightofShipment)) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WeightofShipment cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localWeightofShipment));
            }

            xmlWriter.writeEndElement();
        }

        if (localPackTypeTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "packType", xmlWriter);

            if (localPackType == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPackType);
            }

            xmlWriter.writeEndElement();
        }

        if (localOperationFlagTracker) {
            namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
            writeStartElement(null, namespace, "OperationFlag", xmlWriter);

            if (localOperationFlag == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localOperationFlag);
            }

            xmlWriter.writeEndElement();
        }

        if (localProductDetailsTracker) {
            if (localProductDetails == null) {
                writeStartElement(null,
                    "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                    "ProductDetails", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localProductDetails.serialize(new javax.xml.namespace.QName(
                        "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                        "ProductDetails"), xmlWriter);
            }
        }

        xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals(
                    "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup")) {
            return "ns12";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

        if (writerPrefix != null) {
            xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
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
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

        if (writerPrefix != null) {
            xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
        } else {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
            xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
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
            xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                attributeValue);
        }
    }

    /**
     *  method to handle Qnames
     */
    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" +
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
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
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qnames[i]));
                }
            }

            xmlWriter.writeCharacters(stringToWrite.toString());
        }
    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

            while (true) {
                java.lang.String uri = nsContext.getNamespaceURI(prefix);

                if ((uri == null) || (uri.length() == 0)) {
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
     *  Factory class that keeps the parse method
     */
    public static class Factory {
        private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         *                If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static CalledPickupEntity parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            CalledPickupEntity object = new CalledPickupEntity();

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"CalledPickupEntity".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (CalledPickupEntity) org.tempuri.imports.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Common",
                            "Handheld").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Handheld").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setHandheld(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Common",
                            "Location").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Location").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setLocation(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Common",
                            "LoginId").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "LoginId").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setLoginId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CID").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CID").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "CID" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setCID(org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setCID(java.lang.Double.NaN);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "AWBNO").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "AWBNO").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setAWBNO(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ActualPickupDate").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ActualPickupDate").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ActualPickupDate" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setActualPickupDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ActualPickupEmployee").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ActualPickupEmployee").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ActualPickupEmployee" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setActualPickupEmployee(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setActualPickupEmployee(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ActualPickupTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ActualPickupTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setActualPickupTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "AlternatePickupEmployeeCode").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "AlternatePickupEmployeeCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setAlternatePickupEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "AlternatePickupRoute").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "AlternatePickupRoute").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setAlternatePickupRoute(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "AreaCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "AreaCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setAreaCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "BoxType").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "BoxType").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setBoxType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "BulkUpload").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "BulkUpload").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setBulkUpload(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CISDDN").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CISDDN").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCISDDN(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CREVPU").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CREVPU").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCREVPU(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CallerName").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CallerName").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCallerName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CallerPhone").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CallerPhone").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCallerPhone(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CanceledTokenNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CanceledTokenNumber").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "CanceledTokenNumber" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setCanceledTokenNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setCanceledTokenNumber(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ContactPersonName").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ContactPersonName").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setContactPersonName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerAddress1").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerAddress1").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerAddress1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerAddress2").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerAddress2").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerAddress2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerAddress3").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerAddress3").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerAddress3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerFaxNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerFaxNumber").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerFaxNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerName").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerName").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerPincode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "CustomerPincode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerPincode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "CustomerTelephoneNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "CustomerTelephoneNumber").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setCustomerTelephoneNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "DODShipmentIdentifier").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "DODShipmentIdentifier").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setDODShipmentIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "DTP").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "DTP").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setDTP(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "DataEntryEmployeeCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "DataEntryEmployeeCode").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setDataEntryEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "DoxNDox").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "DoxNDox").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setDoxNDox(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "EmailID").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "EmailID").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setEmailID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "FODShipmentIdentifier").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "FODShipmentIdentifier").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setFODShipmentIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ForcePU").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ForcePU").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setForcePU(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "IMPEXP").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "IMPEXP").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setIMPEXP(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "IsConveyed").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "IsConveyed").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setIsConveyed(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "LoggedByEmployeeCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "LoggedByEmployeeCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setLoggedByEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "MobileTelNo").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "MobileTelNo").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setMobileTelNo(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "Mode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Mode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setMode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ModifiedByEmployeeName").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "ModifiedByEmployeeName").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setModifiedByEmployeeName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ModifiedDateTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ModifiedDateTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setModifiedDateTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "NPUTMSLOT").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "NPUTMSLOT").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setNPUTMSLOT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "NewTokenNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "NewTokenNumber").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "NewTokenNumber" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setNewTokenNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setNewTokenNumber(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "NumberofBox").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "NumberofBox").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setNumberofBox(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "NumberofPieces").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "NumberofPieces").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "NumberofPieces" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setNumberofPieces(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setNumberofPieces(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ODAShipmentIdentifier").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "ODAShipmentIdentifier").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setODAShipmentIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "OfficeCloseTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "OfficeCloseTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setOfficeCloseTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "OldPickupDate").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "OldPickupDate").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "OldPickupDate" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setOldPickupDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PassedByEmployeeCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "PassedByEmployeeCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPassedByEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PickupEmployeeCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "PickupEmployeeCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPickupEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PickupPassedEmployeeCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "PickupPassedEmployeeCode").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPickupPassedEmployeeCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PickupPassedTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "PickupPassedTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPickupPassedTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PrintedorNot").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "PrintedorNot").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPrintedorNot(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "PriorityShipment").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "PriorityShipment").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPriorityShipment(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ProductCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ProductCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setProductCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ProductType").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ProductType").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setProductType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RAWBNO").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RAWBNO").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRAWBNO(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ReRegisteredTokenNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "ReRegisteredTokenNumber").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ReRegisteredTokenNumber" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setReRegisteredTokenNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setReRegisteredTokenNumber(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RefNo").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RefNo").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRefNo(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RegisteredByEmployeeName").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "RegisteredByEmployeeName").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRegisteredByEmployeeName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RegisteredDateTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RegisteredDateTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "RegisteredDateTime" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setRegisteredDateTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RegisteredOrCallPickupIdentifier").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "RegisteredOrCallPickupIdentifier").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRegisteredOrCallPickupIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RegisteredTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RegisteredTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRegisteredTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "Remarks").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Remarks").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRemarks(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "Reminder").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Reminder").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setReminder(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ReminderDetails").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ReminderDetails").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setReminderDetails(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ReminderEntryDateTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "ReminderEntryDateTime").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ReminderEntryDateTime" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setReminderEntryDateTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "Reminders").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Reminders").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        object.setReminders(null);
                        reader.next();

                        reader.next();
                    } else {
                        object.setReminders(org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfReminderReference.Factory.parse(
                                reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RescheduledDate").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RescheduledDate").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRescheduledDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RescheduledPickupFlag").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "RescheduledPickupFlag").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRescheduledPickupFlag(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "RouteCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "RouteCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setRouteCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "SII").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "SII").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setSII(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "SerialNo").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "SerialNo").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "SerialNo" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setSerialNo(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setSerialNo(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ServiceCenterCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ServiceCenterCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setServiceCenterCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ShipmentPickupDate").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ShipmentPickupDate").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ShipmentPickupDate" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setShipmentPickupDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ShipmentPickupTime").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ShipmentPickupTime").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setShipmentPickupTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "Status").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "Status").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setStatus(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "StatusCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "StatusCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setStatusCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "StatusDescription").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "StatusDescription").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setStatusDescription(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "StatusType").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "StatusType").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setStatusType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "SubProduct").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "SubProduct").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setSubProduct(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "SubProducts").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "SubProducts").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        object.setSubProducts(null);
                        reader.next();

                        reader.next();
                    } else {
                        object.setSubProducts(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(
                                reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "TDDShipmentIdentifier").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "TDDShipmentIdentifier").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setTDDShipmentIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ToPay").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ToPay").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setToPay(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "TokenNumber").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "TokenNumber").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "TokenNumber" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setTokenNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setTokenNumber(java.lang.Integer.MIN_VALUE);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "TransactionCode").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "TransactionCode").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setTransactionCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "TransmittedorPassedFlag").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("",
                            "TransmittedorPassedFlag").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setTransmittedorPassedFlag(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "VolumeWeight").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "VolumeWeight").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "VolumeWeight" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setVolumeWeight(org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setVolumeWeight(java.lang.Double.NaN);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "WeightofShipment").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "WeightofShipment").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "WeightofShipment" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setWeightofShipment(org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                    object.setWeightofShipment(java.lang.Double.NaN);
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "packType").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "packType").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setPackType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "OperationFlag").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "OperationFlag").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        java.lang.String content = reader.getElementText();

                        object.setOperationFlag(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
                            "ProductDetails").equals(reader.getName())) ||
                        new javax.xml.namespace.QName("", "ProductDetails").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        object.setProductDetails(null);
                        reader.next();

                        reader.next();
                    } else {
                        object.setProductDetails(org.datacontract.schemas._2004._07.bd_entities_pickup.ArrayOfPickupProductDetails.Factory.parse(
                                reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()) {
                    // 2 - A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }
    } //end of factory class
}
