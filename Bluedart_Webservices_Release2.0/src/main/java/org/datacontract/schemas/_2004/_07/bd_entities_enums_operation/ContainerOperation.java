
/**
 * ContainerOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_enums_operation;
            

            /**
            *  ContainerOperation bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ContainerOperation
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Operation",
                "ContainerOperation",
                "ns9");

            

                        /**
                        * field for ContainerOperation
                        */

                        
                                    protected java.lang.String localContainerOperation ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected ContainerOperation(java.lang.String value, boolean isRegisterValue) {
                                    localContainerOperation = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localContainerOperation, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _None =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("None");
                                
                                    public static final java.lang.String _ShipmentInscannedForOutbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentInscannedForOutbound");
                                
                                    public static final java.lang.String _RapidDataEntry =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("RapidDataEntry");
                                
                                    public static final java.lang.String _AWBDataEntry =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AWBDataEntry");
                                
                                    public static final java.lang.String _SecurityScan =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SecurityScan");
                                
                                    public static final java.lang.String _PlasticBagCreated =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagCreated");
                                
                                    public static final java.lang.String _PlasticBagDeleted =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagDeleted");
                                
                                    public static final java.lang.String _ShipmentIncludedInPlasticBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentIncludedInPlasticBag");
                                
                                    public static final java.lang.String _ShipmentDelinkedFromPlasticBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentDelinkedFromPlasticBag");
                                
                                    public static final java.lang.String _PlasticBagClosed =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagClosed");
                                
                                    public static final java.lang.String _PlasticBagManifestGenerated =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagManifestGenerated");
                                
                                    public static final java.lang.String _ContainerCreated =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerCreated");
                                
                                    public static final java.lang.String _ContainerDeleted =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerDeleted");
                                
                                    public static final java.lang.String _PlasticBagIncludedInContainerBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagIncludedInContainerBag");
                                
                                    public static final java.lang.String _PlasticBagDelinkedFromContainerBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagDelinkedFromContainerBag");
                                
                                    public static final java.lang.String _ContainerClosed =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerClosed");
                                
                                    public static final java.lang.String _ContainerBagLinkedToRun =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagLinkedToRun");
                                
                                    public static final java.lang.String _ConnectedToFlight =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ConnectedToFlight");
                                
                                    public static final java.lang.String _PreAlertGeneratedForOutbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PreAlertGeneratedForOutbound");
                                
                                    public static final java.lang.String _StampdartShipmentDataImported =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("StampdartShipmentDataImported");
                                
                                    public static final java.lang.String _PreAlertProcessedForInbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PreAlertProcessedForInbound");
                                
                                    public static final java.lang.String _ContainerBagsTallied =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagsTallied");
                                
                                    public static final java.lang.String _PlasticBagsInscanedForInbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagsInscanedForInbound");
                                
                                    public static final java.lang.String _ShipmentsInscanedForInbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentsInscanedForInbound");
                                
                                    public static final java.lang.String _OveragesProcessed =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OveragesProcessed");
                                
                                    public static final java.lang.String _ShipmentsOutscannedForInbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentsOutscannedForInbound");
                                
                                    public static final java.lang.String _UndeliveredShipmentsInscanned =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UndeliveredShipmentsInscanned");
                                
                                    public static final java.lang.String _PODEntry =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PODEntry");
                                
                                    public static final java.lang.String _ShipementReconciled =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipementReconciled");
                                
                                    public static final java.lang.String _TcGenerated =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("TcGenerated");
                                
                                    public static final java.lang.String _DeliverySheetPrinted =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliverySheetPrinted");
                                
                                    public static final java.lang.String _SrNoWisePODEntryDone =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SrNoWisePODEntryDone");
                                
                                    public static final java.lang.String _MassUpdateDone =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MassUpdateDone");
                                
                                    public static final java.lang.String _ContainerBagInscanedAtHubInbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagInscanedAtHubInbound");
                                
                                    public static final java.lang.String _ContainerBagInscanedAtHubOutbound =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagInscanedAtHubOutbound");
                                
                                    public static final java.lang.String _ConnectedToFlightAtHub =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ConnectedToFlightAtHub");
                                
                                    public static final java.lang.String _ContainerBagLinkedToRunAtHub =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagLinkedToRunAtHub");
                                
                                    public static final java.lang.String _PODEntryAtHub =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PODEntryAtHub");
                                
                                    public static final java.lang.String _ShipmentDescanAtHub =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentDescanAtHub");
                                
                                    public static final java.lang.String _ShipmentLinkToFlightAtHub =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentLinkToFlightAtHub");
                                
                                    public static final java.lang.String _PlasticBagOpen =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagOpen");
                                
                                    public static final java.lang.String _ContainerOpen =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerOpen");
                                
                                    public static final java.lang.String _ShipmentIncludedInCanvasBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentIncludedInCanvasBag");
                                
                                    public static final java.lang.String _ShipmentDelinkedFormCanvasBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShipmentDelinkedFormCanvasBag");
                                
                                    public static final java.lang.String _ContainerBagIncludedInContainerBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagIncludedInContainerBag");
                                
                                    public static final java.lang.String _ContainerBagDelinkedFronContainer =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerBagDelinkedFronContainer");
                                
                                    public static final java.lang.String _PlasticBagIncludedInPlasticBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagIncludedInPlasticBag");
                                
                                    public static final java.lang.String _PickupChargesReceiptEntry =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PickupChargesReceiptEntry");
                                
                                    public static final java.lang.String _AssigningMPSNumber =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AssigningMPSNumber");
                                
                                    public static final java.lang.String _DeassigningMPSNumber =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeassigningMPSNumber");
                                
                                    public static final java.lang.String _PlasticBagDelinkFromPlasticBag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PlasticBagDelinkFromPlasticBag");
                                
                                    public static final java.lang.String _ContainerDelinkedFromRun =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerDelinkedFromRun");
                                
                                    public static final java.lang.String _ContainerTallied =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerTallied");
                                
                                    public static final java.lang.String _ContainerReconcilled =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerReconcilled");
                                
                                    public static final java.lang.String _ContainerHeld =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ContainerHeld");
                                
                                public static final ContainerOperation None =
                                    new ContainerOperation(_None,true);
                            
                                public static final ContainerOperation ShipmentInscannedForOutbound =
                                    new ContainerOperation(_ShipmentInscannedForOutbound,true);
                            
                                public static final ContainerOperation RapidDataEntry =
                                    new ContainerOperation(_RapidDataEntry,true);
                            
                                public static final ContainerOperation AWBDataEntry =
                                    new ContainerOperation(_AWBDataEntry,true);
                            
                                public static final ContainerOperation SecurityScan =
                                    new ContainerOperation(_SecurityScan,true);
                            
                                public static final ContainerOperation PlasticBagCreated =
                                    new ContainerOperation(_PlasticBagCreated,true);
                            
                                public static final ContainerOperation PlasticBagDeleted =
                                    new ContainerOperation(_PlasticBagDeleted,true);
                            
                                public static final ContainerOperation ShipmentIncludedInPlasticBag =
                                    new ContainerOperation(_ShipmentIncludedInPlasticBag,true);
                            
                                public static final ContainerOperation ShipmentDelinkedFromPlasticBag =
                                    new ContainerOperation(_ShipmentDelinkedFromPlasticBag,true);
                            
                                public static final ContainerOperation PlasticBagClosed =
                                    new ContainerOperation(_PlasticBagClosed,true);
                            
                                public static final ContainerOperation PlasticBagManifestGenerated =
                                    new ContainerOperation(_PlasticBagManifestGenerated,true);
                            
                                public static final ContainerOperation ContainerCreated =
                                    new ContainerOperation(_ContainerCreated,true);
                            
                                public static final ContainerOperation ContainerDeleted =
                                    new ContainerOperation(_ContainerDeleted,true);
                            
                                public static final ContainerOperation PlasticBagIncludedInContainerBag =
                                    new ContainerOperation(_PlasticBagIncludedInContainerBag,true);
                            
                                public static final ContainerOperation PlasticBagDelinkedFromContainerBag =
                                    new ContainerOperation(_PlasticBagDelinkedFromContainerBag,true);
                            
                                public static final ContainerOperation ContainerClosed =
                                    new ContainerOperation(_ContainerClosed,true);
                            
                                public static final ContainerOperation ContainerBagLinkedToRun =
                                    new ContainerOperation(_ContainerBagLinkedToRun,true);
                            
                                public static final ContainerOperation ConnectedToFlight =
                                    new ContainerOperation(_ConnectedToFlight,true);
                            
                                public static final ContainerOperation PreAlertGeneratedForOutbound =
                                    new ContainerOperation(_PreAlertGeneratedForOutbound,true);
                            
                                public static final ContainerOperation StampdartShipmentDataImported =
                                    new ContainerOperation(_StampdartShipmentDataImported,true);
                            
                                public static final ContainerOperation PreAlertProcessedForInbound =
                                    new ContainerOperation(_PreAlertProcessedForInbound,true);
                            
                                public static final ContainerOperation ContainerBagsTallied =
                                    new ContainerOperation(_ContainerBagsTallied,true);
                            
                                public static final ContainerOperation PlasticBagsInscanedForInbound =
                                    new ContainerOperation(_PlasticBagsInscanedForInbound,true);
                            
                                public static final ContainerOperation ShipmentsInscanedForInbound =
                                    new ContainerOperation(_ShipmentsInscanedForInbound,true);
                            
                                public static final ContainerOperation OveragesProcessed =
                                    new ContainerOperation(_OveragesProcessed,true);
                            
                                public static final ContainerOperation ShipmentsOutscannedForInbound =
                                    new ContainerOperation(_ShipmentsOutscannedForInbound,true);
                            
                                public static final ContainerOperation UndeliveredShipmentsInscanned =
                                    new ContainerOperation(_UndeliveredShipmentsInscanned,true);
                            
                                public static final ContainerOperation PODEntry =
                                    new ContainerOperation(_PODEntry,true);
                            
                                public static final ContainerOperation ShipementReconciled =
                                    new ContainerOperation(_ShipementReconciled,true);
                            
                                public static final ContainerOperation TcGenerated =
                                    new ContainerOperation(_TcGenerated,true);
                            
                                public static final ContainerOperation DeliverySheetPrinted =
                                    new ContainerOperation(_DeliverySheetPrinted,true);
                            
                                public static final ContainerOperation SrNoWisePODEntryDone =
                                    new ContainerOperation(_SrNoWisePODEntryDone,true);
                            
                                public static final ContainerOperation MassUpdateDone =
                                    new ContainerOperation(_MassUpdateDone,true);
                            
                                public static final ContainerOperation ContainerBagInscanedAtHubInbound =
                                    new ContainerOperation(_ContainerBagInscanedAtHubInbound,true);
                            
                                public static final ContainerOperation ContainerBagInscanedAtHubOutbound =
                                    new ContainerOperation(_ContainerBagInscanedAtHubOutbound,true);
                            
                                public static final ContainerOperation ConnectedToFlightAtHub =
                                    new ContainerOperation(_ConnectedToFlightAtHub,true);
                            
                                public static final ContainerOperation ContainerBagLinkedToRunAtHub =
                                    new ContainerOperation(_ContainerBagLinkedToRunAtHub,true);
                            
                                public static final ContainerOperation PODEntryAtHub =
                                    new ContainerOperation(_PODEntryAtHub,true);
                            
                                public static final ContainerOperation ShipmentDescanAtHub =
                                    new ContainerOperation(_ShipmentDescanAtHub,true);
                            
                                public static final ContainerOperation ShipmentLinkToFlightAtHub =
                                    new ContainerOperation(_ShipmentLinkToFlightAtHub,true);
                            
                                public static final ContainerOperation PlasticBagOpen =
                                    new ContainerOperation(_PlasticBagOpen,true);
                            
                                public static final ContainerOperation ContainerOpen =
                                    new ContainerOperation(_ContainerOpen,true);
                            
                                public static final ContainerOperation ShipmentIncludedInCanvasBag =
                                    new ContainerOperation(_ShipmentIncludedInCanvasBag,true);
                            
                                public static final ContainerOperation ShipmentDelinkedFormCanvasBag =
                                    new ContainerOperation(_ShipmentDelinkedFormCanvasBag,true);
                            
                                public static final ContainerOperation ContainerBagIncludedInContainerBag =
                                    new ContainerOperation(_ContainerBagIncludedInContainerBag,true);
                            
                                public static final ContainerOperation ContainerBagDelinkedFronContainer =
                                    new ContainerOperation(_ContainerBagDelinkedFronContainer,true);
                            
                                public static final ContainerOperation PlasticBagIncludedInPlasticBag =
                                    new ContainerOperation(_PlasticBagIncludedInPlasticBag,true);
                            
                                public static final ContainerOperation PickupChargesReceiptEntry =
                                    new ContainerOperation(_PickupChargesReceiptEntry,true);
                            
                                public static final ContainerOperation AssigningMPSNumber =
                                    new ContainerOperation(_AssigningMPSNumber,true);
                            
                                public static final ContainerOperation DeassigningMPSNumber =
                                    new ContainerOperation(_DeassigningMPSNumber,true);
                            
                                public static final ContainerOperation PlasticBagDelinkFromPlasticBag =
                                    new ContainerOperation(_PlasticBagDelinkFromPlasticBag,true);
                            
                                public static final ContainerOperation ContainerDelinkedFromRun =
                                    new ContainerOperation(_ContainerDelinkedFromRun,true);
                            
                                public static final ContainerOperation ContainerTallied =
                                    new ContainerOperation(_ContainerTallied,true);
                            
                                public static final ContainerOperation ContainerReconcilled =
                                    new ContainerOperation(_ContainerReconcilled,true);
                            
                                public static final ContainerOperation ContainerHeld =
                                    new ContainerOperation(_ContainerHeld,true);
                            

                                public java.lang.String getValue() { return localContainerOperation;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localContainerOperation.toString();
                                    

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


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME));
            
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
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Operation");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":ContainerOperation",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "ContainerOperation",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localContainerOperation==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("ContainerOperation cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localContainerOperation);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();
                         

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://schemas.datacontract.org/2004/07/BD.Entities.Enums.Operation")){
                return "ns9";
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
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace,attName,attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace,attName,attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace,attName,attValue);
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
                    xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
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
      *  Factory class that keeps the parse method
      */
    public static class Factory{
        private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

        
        
                public static ContainerOperation fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    ContainerOperation enumeration = (ContainerOperation)
                       
                               _table_.get(value);
                           

                    // handle unexpected enumeration values properly
                    
                        if (enumeration == null  ) {
                            throw new java.lang.IllegalArgumentException();
                        }
                        return enumeration;
                    
                }
                public static ContainerOperation fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static ContainerOperation fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return ContainerOperation.Factory.fromString(content,namespaceUri);
                    } else {
                       return ContainerOperation.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ContainerOperation parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ContainerOperation object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();
            

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();
                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                   
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ContainerOperation" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = ContainerOperation.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = ContainerOperation.Factory.fromString(content,"");
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
           
    