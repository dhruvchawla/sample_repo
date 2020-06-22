
/**
 * SecurityBaggingHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  SecurityBaggingHistory bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class SecurityBaggingHistory extends org.datacontract.schemas._2004._07.bd_entities_area.AreaEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = SecurityBaggingHistory
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Area
                Namespace Prefix = ns10
                */
            

                        /**
                        * field for AWBNumber
                        */

                        
                                    protected java.lang.String localAWBNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAWBNumberTracker = false ;

                           public boolean isAWBNumberSpecified(){
                               return localAWBNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAWBNumber(){
                               return localAWBNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AWBNumber
                               */
                               public void setAWBNumber(java.lang.String param){
                            localAWBNumberTracker = true;
                                   
                                            this.localAWBNumber=param;
                                       

                               }
                            

                        /**
                        * field for CBBaggingHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBBaggingHistory localCBBaggingHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCBBaggingHistoryTracker = false ;

                           public boolean isCBBaggingHistorySpecified(){
                               return localCBBaggingHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBBaggingHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBBaggingHistory getCBBaggingHistory(){
                               return localCBBaggingHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CBBaggingHistory
                               */
                               public void setCBBaggingHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBBaggingHistory param){
                            localCBBaggingHistoryTracker = true;
                                   
                                            this.localCBBaggingHistory=param;
                                       

                               }
                            

                        /**
                        * field for CBReopenHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBReopenHistory localCBReopenHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCBReopenHistoryTracker = false ;

                           public boolean isCBReopenHistorySpecified(){
                               return localCBReopenHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBReopenHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBReopenHistory getCBReopenHistory(){
                               return localCBReopenHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CBReopenHistory
                               */
                               public void setCBReopenHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBReopenHistory param){
                            localCBReopenHistoryTracker = true;
                                   
                                            this.localCBReopenHistory=param;
                                       

                               }
                            

                        /**
                        * field for ClosedDateAndBy
                        */

                        
                                    protected java.lang.String localClosedDateAndBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localClosedDateAndByTracker = false ;

                           public boolean isClosedDateAndBySpecified(){
                               return localClosedDateAndByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getClosedDateAndBy(){
                               return localClosedDateAndBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ClosedDateAndBy
                               */
                               public void setClosedDateAndBy(java.lang.String param){
                            localClosedDateAndByTracker = true;
                                   
                                            this.localClosedDateAndBy=param;
                                       

                               }
                            

                        /**
                        * field for CreatedDateAndBy
                        */

                        
                                    protected java.lang.String localCreatedDateAndBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCreatedDateAndByTracker = false ;

                           public boolean isCreatedDateAndBySpecified(){
                               return localCreatedDateAndByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCreatedDateAndBy(){
                               return localCreatedDateAndBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreatedDateAndBy
                               */
                               public void setCreatedDateAndBy(java.lang.String param){
                            localCreatedDateAndByTracker = true;
                                   
                                            this.localCreatedDateAndBy=param;
                                       

                               }
                            

                        /**
                        * field for DataEntryDoneBy
                        */

                        
                                    protected java.lang.String localDataEntryDoneBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataEntryDoneByTracker = false ;

                           public boolean isDataEntryDoneBySpecified(){
                               return localDataEntryDoneByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDataEntryDoneBy(){
                               return localDataEntryDoneBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataEntryDoneBy
                               */
                               public void setDataEntryDoneBy(java.lang.String param){
                            localDataEntryDoneByTracker = true;
                                   
                                            this.localDataEntryDoneBy=param;
                                       

                               }
                            

                        /**
                        * field for HeldBy
                        */

                        
                                    protected java.lang.String localHeldBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHeldByTracker = false ;

                           public boolean isHeldBySpecified(){
                               return localHeldByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHeldBy(){
                               return localHeldBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HeldBy
                               */
                               public void setHeldBy(java.lang.String param){
                            localHeldByTracker = true;
                                   
                                            this.localHeldBy=param;
                                       

                               }
                            

                        /**
                        * field for ImportORManual
                        */

                        
                                    protected java.lang.String localImportORManual ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImportORManualTracker = false ;

                           public boolean isImportORManualSpecified(){
                               return localImportORManualTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImportORManual(){
                               return localImportORManual;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ImportORManual
                               */
                               public void setImportORManual(java.lang.String param){
                            localImportORManualTracker = true;
                                   
                                            this.localImportORManual=param;
                                       

                               }
                            

                        /**
                        * field for InscanDateAndBy
                        */

                        
                                    protected java.lang.String localInscanDateAndBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInscanDateAndByTracker = false ;

                           public boolean isInscanDateAndBySpecified(){
                               return localInscanDateAndByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInscanDateAndBy(){
                               return localInscanDateAndBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InscanDateAndBy
                               */
                               public void setInscanDateAndBy(java.lang.String param){
                            localInscanDateAndByTracker = true;
                                   
                                            this.localInscanDateAndBy=param;
                                       

                               }
                            

                        /**
                        * field for InscanLocation
                        */

                        
                                    protected java.lang.String localInscanLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInscanLocationTracker = false ;

                           public boolean isInscanLocationSpecified(){
                               return localInscanLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInscanLocation(){
                               return localInscanLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InscanLocation
                               */
                               public void setInscanLocation(java.lang.String param){
                            localInscanLocationTracker = true;
                                   
                                            this.localInscanLocation=param;
                                       

                               }
                            

                        /**
                        * field for Origin
                        */

                        
                                    protected java.lang.String localOrigin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOriginTracker = false ;

                           public boolean isOriginSpecified(){
                               return localOriginTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOrigin(){
                               return localOrigin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Origin
                               */
                               public void setOrigin(java.lang.String param){
                            localOriginTracker = true;
                                   
                                            this.localOrigin=param;
                                       

                               }
                            

                        /**
                        * field for PBIncludeDateAndBy
                        */

                        
                                    protected java.lang.String localPBIncludeDateAndBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPBIncludeDateAndByTracker = false ;

                           public boolean isPBIncludeDateAndBySpecified(){
                               return localPBIncludeDateAndByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPBIncludeDateAndBy(){
                               return localPBIncludeDateAndBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PBIncludeDateAndBy
                               */
                               public void setPBIncludeDateAndBy(java.lang.String param){
                            localPBIncludeDateAndByTracker = true;
                                   
                                            this.localPBIncludeDateAndBy=param;
                                       

                               }
                            

                        /**
                        * field for PBIncludedIn
                        */

                        
                                    protected java.lang.String localPBIncludedIn ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPBIncludedInTracker = false ;

                           public boolean isPBIncludedInSpecified(){
                               return localPBIncludedInTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPBIncludedIn(){
                               return localPBIncludedIn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PBIncludedIn
                               */
                               public void setPBIncludedIn(java.lang.String param){
                            localPBIncludedInTracker = true;
                                   
                                            this.localPBIncludedIn=param;
                                       

                               }
                            

                        /**
                        * field for PBReopenHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingPBReopenHistory localPBReopenHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPBReopenHistoryTracker = false ;

                           public boolean isPBReopenHistorySpecified(){
                               return localPBReopenHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingPBReopenHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingPBReopenHistory getPBReopenHistory(){
                               return localPBReopenHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PBReopenHistory
                               */
                               public void setPBReopenHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingPBReopenHistory param){
                            localPBReopenHistoryTracker = true;
                                   
                                            this.localPBReopenHistory=param;
                                       

                               }
                            

                        /**
                        * field for PlasticBag
                        */

                        
                                    protected java.lang.String localPlasticBag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPlasticBagTracker = false ;

                           public boolean isPlasticBagSpecified(){
                               return localPlasticBagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPlasticBag(){
                               return localPlasticBag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PlasticBag
                               */
                               public void setPlasticBag(java.lang.String param){
                            localPlasticBagTracker = true;
                                   
                                            this.localPlasticBag=param;
                                       

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
                        * field for ShipmentIncludedDateAndBy
                        */

                        
                                    protected java.lang.String localShipmentIncludedDateAndBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipmentIncludedDateAndByTracker = false ;

                           public boolean isShipmentIncludedDateAndBySpecified(){
                               return localShipmentIncludedDateAndByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipmentIncludedDateAndBy(){
                               return localShipmentIncludedDateAndBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipmentIncludedDateAndBy
                               */
                               public void setShipmentIncludedDateAndBy(java.lang.String param){
                            localShipmentIncludedDateAndByTracker = true;
                                   
                                            this.localShipmentIncludedDateAndBy=param;
                                       

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


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,parentQName));
            
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
                

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Area");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":SecurityBaggingHistory",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "SecurityBaggingHistory",
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
                             } if (localModifiedDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ModifiedDate", xmlWriter);
                             

                                          if (localModifiedDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ModifiedDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModifiedDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAWBNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "AWBNumber", xmlWriter);
                             

                                          if (localAWBNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAWBNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCBBaggingHistoryTracker){
                                    if (localCBBaggingHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "CBBaggingHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCBBaggingHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CBBaggingHistory"),
                                        xmlWriter);
                                    }
                                } if (localCBReopenHistoryTracker){
                                    if (localCBReopenHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "CBReopenHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCBReopenHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CBReopenHistory"),
                                        xmlWriter);
                                    }
                                } if (localClosedDateAndByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ClosedDateAndBy", xmlWriter);
                             

                                          if (localClosedDateAndBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localClosedDateAndBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCreatedDateAndByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CreatedDateAndBy", xmlWriter);
                             

                                          if (localCreatedDateAndBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCreatedDateAndBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDataEntryDoneByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DataEntryDoneBy", xmlWriter);
                             

                                          if (localDataEntryDoneBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDataEntryDoneBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHeldByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "HeldBy", xmlWriter);
                             

                                          if (localHeldBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHeldBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImportORManualTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ImportORManual", xmlWriter);
                             

                                          if (localImportORManual==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImportORManual);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInscanDateAndByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InscanDateAndBy", xmlWriter);
                             

                                          if (localInscanDateAndBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInscanDateAndBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInscanLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InscanLocation", xmlWriter);
                             

                                          if (localInscanLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInscanLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOriginTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Origin", xmlWriter);
                             

                                          if (localOrigin==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOrigin);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPBIncludeDateAndByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PBIncludeDateAndBy", xmlWriter);
                             

                                          if (localPBIncludeDateAndBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPBIncludeDateAndBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPBIncludedInTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PBIncludedIn", xmlWriter);
                             

                                          if (localPBIncludedIn==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPBIncludedIn);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPBReopenHistoryTracker){
                                    if (localPBReopenHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "PBReopenHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localPBReopenHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PBReopenHistory"),
                                        xmlWriter);
                                    }
                                } if (localPlasticBagTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PlasticBag", xmlWriter);
                             

                                          if (localPlasticBag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPlasticBag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProductCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ProductCode", xmlWriter);
                             

                                          if (localProductCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipmentIncludedDateAndByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipmentIncludedDateAndBy", xmlWriter);
                             

                                          if (localShipmentIncludedDateAndBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipmentIncludedDateAndBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://schemas.datacontract.org/2004/07/BD.Entities.Area")){
                return "ns10";
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

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static SecurityBaggingHistory parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            SecurityBaggingHistory object =
                new SecurityBaggingHistory();

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();
                
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
                    
                            if (!"SecurityBaggingHistory".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SecurityBaggingHistory)org.tempuri.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Handheld").equals(reader.getName()) || new javax.xml.namespace.QName("","Handheld").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Location").equals(reader.getName()) || new javax.xml.namespace.QName("","Location").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","LoginId").equals(reader.getName()) || new javax.xml.namespace.QName("","LoginId").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ModifiedDate").equals(reader.getName()) || new javax.xml.namespace.QName("","ModifiedDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ModifiedDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setModifiedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","AWBNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","AWBNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAWBNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CBBaggingHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","CBBaggingHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCBBaggingHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCBBaggingHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBBaggingHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CBReopenHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","CBReopenHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCBReopenHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCBReopenHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingCBReopenHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ClosedDateAndBy").equals(reader.getName()) || new javax.xml.namespace.QName("","ClosedDateAndBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setClosedDateAndBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CreatedDateAndBy").equals(reader.getName()) || new javax.xml.namespace.QName("","CreatedDateAndBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCreatedDateAndBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DataEntryDoneBy").equals(reader.getName()) || new javax.xml.namespace.QName("","DataEntryDoneBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataEntryDoneBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","HeldBy").equals(reader.getName()) || new javax.xml.namespace.QName("","HeldBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHeldBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ImportORManual").equals(reader.getName()) || new javax.xml.namespace.QName("","ImportORManual").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImportORManual(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InscanDateAndBy").equals(reader.getName()) || new javax.xml.namespace.QName("","InscanDateAndBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInscanDateAndBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InscanLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","InscanLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInscanLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Origin").equals(reader.getName()) || new javax.xml.namespace.QName("","Origin").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOrigin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PBIncludeDateAndBy").equals(reader.getName()) || new javax.xml.namespace.QName("","PBIncludeDateAndBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPBIncludeDateAndBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PBIncludedIn").equals(reader.getName()) || new javax.xml.namespace.QName("","PBIncludedIn").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPBIncludedIn(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PBReopenHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","PBReopenHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setPBReopenHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setPBReopenHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSecurityBaggingPBReopenHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PlasticBag").equals(reader.getName()) || new javax.xml.namespace.QName("","PlasticBag").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPlasticBag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ProductCode").equals(reader.getName()) || new javax.xml.namespace.QName("","ProductCode").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentIncludedDateAndBy").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipmentIncludedDateAndBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipmentIncludedDateAndBy(
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
                                // 2 - A start element we are not expecting indicates a trailing invalid property
                                
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    