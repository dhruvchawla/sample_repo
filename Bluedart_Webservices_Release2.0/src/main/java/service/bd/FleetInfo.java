
/**
 * FleetInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package service.bd;
            

            /**
            *  FleetInfo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class FleetInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = FleetInfo
                Namespace URI = BD.Service
                Namespace Prefix = ns11
                */
            

                        /**
                        * field for ActivityCode
                        */

                        
                                    protected java.lang.String localActivityCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localActivityCodeTracker = false ;

                           public boolean isActivityCodeSpecified(){
                               return localActivityCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getActivityCode(){
                               return localActivityCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ActivityCode
                               */
                               public void setActivityCode(java.lang.String param){
                            localActivityCodeTracker = true;
                                   
                                            this.localActivityCode=param;
                                    

                               }
                            

                        /**
                        * field for ContainerID
                        */

                        
                                    protected java.lang.String localContainerID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContainerIDTracker = false ;

                           public boolean isContainerIDSpecified(){
                               return localContainerIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContainerID(){
                               return localContainerID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContainerID
                               */
                               public void setContainerID(java.lang.String param){
                            localContainerIDTracker = true;
                                   
                                            this.localContainerID=param;
                                    

                               }
                            

                        /**
                        * field for FleetDate
                        */

                        
                                    protected java.util.Calendar localFleetDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFleetDateTracker = false ;

                           public boolean isFleetDateSpecified(){
                               return localFleetDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getFleetDate(){
                               return localFleetDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FleetDate
                               */
                               public void setFleetDate(java.util.Calendar param){
                            localFleetDateTracker = true;
                                   
                                            this.localFleetDate=param;
                                    

                               }
                            

                        /**
                        * field for FleetNo
                        */

                        
                                    protected java.lang.String localFleetNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFleetNoTracker = false ;

                           public boolean isFleetNoSpecified(){
                               return localFleetNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFleetNo(){
                               return localFleetNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FleetNo
                               */
                               public void setFleetNo(java.lang.String param){
                            localFleetNoTracker = true;
                                   
                                            this.localFleetNo=param;
                                    

                               }
                            

                        /**
                        * field for IsNormalMpsTally
                        */

                        
                                    protected java.lang.String localIsNormalMpsTally ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsNormalMpsTallyTracker = false ;

                           public boolean isIsNormalMpsTallySpecified(){
                               return localIsNormalMpsTallyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIsNormalMpsTally(){
                               return localIsNormalMpsTally;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsNormalMpsTally
                               */
                               public void setIsNormalMpsTally(java.lang.String param){
                            localIsNormalMpsTallyTracker = true;
                                   
                                            this.localIsNormalMpsTally=param;
                                    

                               }
                            

                        /**
                        * field for LocationCode
                        */

                        
                                    protected java.lang.String localLocationCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLocationCodeTracker = false ;

                           public boolean isLocationCodeSpecified(){
                               return localLocationCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLocationCode(){
                               return localLocationCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LocationCode
                               */
                               public void setLocationCode(java.lang.String param){
                            localLocationCodeTracker = true;
                                   
                                            this.localLocationCode=param;
                                    

                               }
                            

                        /**
                        * field for RunCode
                        */

                        
                                    protected java.lang.String localRunCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRunCodeTracker = false ;

                           public boolean isRunCodeSpecified(){
                               return localRunCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRunCode(){
                               return localRunCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RunCode
                               */
                               public void setRunCode(java.lang.String param){
                            localRunCodeTracker = true;
                                   
                                            this.localRunCode=param;
                                    

                               }
                            

                        /**
                        * field for RunDate
                        */

                        
                                    protected java.util.Calendar localRunDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRunDateTracker = false ;

                           public boolean isRunDateSpecified(){
                               return localRunDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getRunDate(){
                               return localRunDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RunDate
                               */
                               public void setRunDate(java.util.Calendar param){
                            localRunDateTracker = true;
                                   
                                            this.localRunDate=param;
                                    

                               }
                            

                        /**
                        * field for RunId
                        */

                        
                                    protected java.lang.String localRunId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRunIdTracker = false ;

                           public boolean isRunIdSpecified(){
                               return localRunIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRunId(){
                               return localRunId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RunId
                               */
                               public void setRunId(java.lang.String param){
                            localRunIdTracker = true;
                                   
                                            this.localRunId=param;
                                    

                               }
                            

                        /**
                        * field for RunOrigin
                        */

                        
                                    protected java.lang.String localRunOrigin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRunOriginTracker = false ;

                           public boolean isRunOriginSpecified(){
                               return localRunOriginTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRunOrigin(){
                               return localRunOrigin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RunOrigin
                               */
                               public void setRunOrigin(java.lang.String param){
                            localRunOriginTracker = true;
                                   
                                            this.localRunOrigin=param;
                                    

                               }
                            

                        /**
                        * field for VehicleNumber
                        */

                        
                                    protected java.lang.String localVehicleNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVehicleNumberTracker = false ;

                           public boolean isVehicleNumberSpecified(){
                               return localVehicleNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVehicleNumber(){
                               return localVehicleNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VehicleNumber
                               */
                               public void setVehicleNumber(java.lang.String param){
                            localVehicleNumberTracker = true;
                                   
                                            this.localVehicleNumber=param;
                                    

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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"BD.Service");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":FleetInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "FleetInfo",
                           xmlWriter);
                   }

               
                   }
                if (localActivityCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ActivityCode", xmlWriter);
                             

                                          if (localActivityCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActivityCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContainerIDTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ContainerID", xmlWriter);
                             

                                          if (localContainerID==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContainerID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFleetDateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "FleetDate", xmlWriter);
                             

                                          if (localFleetDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFleetDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFleetNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "FleetNo", xmlWriter);
                             

                                          if (localFleetNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFleetNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsNormalMpsTallyTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "IsNormalMpsTally", xmlWriter);
                             

                                          if (localIsNormalMpsTally==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIsNormalMpsTally);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLocationCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "LocationCode", xmlWriter);
                             

                                          if (localLocationCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocationCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "RunCode", xmlWriter);
                             

                                          if (localRunCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRunCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunDateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "RunDate", xmlWriter);
                             

                                          if (localRunDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunIdTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "RunId", xmlWriter);
                             

                                          if (localRunId==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRunId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunOriginTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "RunOrigin", xmlWriter);
                             

                                          if (localRunOrigin==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRunOrigin);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleNumberTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "VehicleNumber", xmlWriter);
                             

                                          if (localVehicleNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVehicleNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("BD.Service")){
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


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localActivityCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ActivityCode"));
                                 
                                         elementList.add(localActivityCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActivityCode));
                                    } if (localContainerIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ContainerID"));
                                 
                                         elementList.add(localContainerID==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContainerID));
                                    } if (localFleetDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "FleetDate"));
                                 
                                         elementList.add(localFleetDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFleetDate));
                                    } if (localFleetNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "FleetNo"));
                                 
                                         elementList.add(localFleetNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFleetNo));
                                    } if (localIsNormalMpsTallyTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "IsNormalMpsTally"));
                                 
                                         elementList.add(localIsNormalMpsTally==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNormalMpsTally));
                                    } if (localLocationCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "LocationCode"));
                                 
                                         elementList.add(localLocationCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocationCode));
                                    } if (localRunCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "RunCode"));
                                 
                                         elementList.add(localRunCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunCode));
                                    } if (localRunDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "RunDate"));
                                 
                                         elementList.add(localRunDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunDate));
                                    } if (localRunIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "RunId"));
                                 
                                         elementList.add(localRunId==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunId));
                                    } if (localRunOriginTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "RunOrigin"));
                                 
                                         elementList.add(localRunOrigin==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunOrigin));
                                    } if (localVehicleNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "VehicleNumber"));
                                 
                                         elementList.add(localVehicleNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVehicleNumber));
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
        public static FleetInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            FleetInfo object =
                new FleetInfo();

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
                    
                            if (!"FleetInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FleetInfo)org.tempuri.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ActivityCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActivityCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ContainerID").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContainerID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","FleetDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFleetDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","FleetNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFleetNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","IsNormalMpsTally").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsNormalMpsTally(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","LocationCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocationCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","RunCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRunCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","RunDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRunDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","RunId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRunId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","RunOrigin").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRunOrigin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","VehicleNumber").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVehicleNumber(
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
           
    