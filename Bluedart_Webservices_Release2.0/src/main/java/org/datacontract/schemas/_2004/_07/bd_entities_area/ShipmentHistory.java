
/**
 * ShipmentHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  ShipmentHistory bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ShipmentHistory extends org.datacontract.schemas._2004._07.bd_entities_area.AreaEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ShipmentHistory
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
                        * field for Attention
                        */

                        
                                    protected java.lang.String localAttention ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAttentionTracker = false ;

                           public boolean isAttentionSpecified(){
                               return localAttentionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAttention(){
                               return localAttention;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Attention
                               */
                               public void setAttention(java.lang.String param){
                            localAttentionTracker = true;
                                   
                                            this.localAttention=param;
                                       

                               }
                            

                        /**
                        * field for Bagged
                        */

                        
                                    protected java.lang.String localBagged ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBaggedTracker = false ;

                           public boolean isBaggedSpecified(){
                               return localBaggedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBagged(){
                               return localBagged;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Bagged
                               */
                               public void setBagged(java.lang.String param){
                            localBaggedTracker = true;
                                   
                                            this.localBagged=param;
                                       

                               }
                            

                        /**
                        * field for BaggingInboundHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory localBaggingInboundHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBaggingInboundHistoryTracker = false ;

                           public boolean isBaggingInboundHistorySpecified(){
                               return localBaggingInboundHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory getBaggingInboundHistory(){
                               return localBaggingInboundHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BaggingInboundHistory
                               */
                               public void setBaggingInboundHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory param){
                            localBaggingInboundHistoryTracker = true;
                                   
                                            this.localBaggingInboundHistory=param;
                                       

                               }
                            

                        /**
                        * field for BaggingOutboundHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory localBaggingOutboundHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBaggingOutboundHistoryTracker = false ;

                           public boolean isBaggingOutboundHistorySpecified(){
                               return localBaggingOutboundHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory getBaggingOutboundHistory(){
                               return localBaggingOutboundHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BaggingOutboundHistory
                               */
                               public void setBaggingOutboundHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory param){
                            localBaggingOutboundHistoryTracker = true;
                                   
                                            this.localBaggingOutboundHistory=param;
                                       

                               }
                            

                        /**
                        * field for BaggingSplit
                        */

                        
                                    protected java.lang.String localBaggingSplit ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBaggingSplitTracker = false ;

                           public boolean isBaggingSplitSpecified(){
                               return localBaggingSplitTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBaggingSplit(){
                               return localBaggingSplit;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BaggingSplit
                               */
                               public void setBaggingSplit(java.lang.String param){
                            localBaggingSplitTracker = true;
                                   
                                            this.localBaggingSplit=param;
                                       

                               }
                            

                        /**
                        * field for BasicOrigin
                        */

                        
                                    protected java.lang.String localBasicOrigin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBasicOriginTracker = false ;

                           public boolean isBasicOriginSpecified(){
                               return localBasicOriginTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBasicOrigin(){
                               return localBasicOrigin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BasicOrigin
                               */
                               public void setBasicOrigin(java.lang.String param){
                            localBasicOriginTracker = true;
                                   
                                            this.localBasicOrigin=param;
                                       

                               }
                            

                        /**
                        * field for BatchNumber
                        */

                        
                                    protected java.lang.String localBatchNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBatchNumberTracker = false ;

                           public boolean isBatchNumberSpecified(){
                               return localBatchNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBatchNumber(){
                               return localBatchNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BatchNumber
                               */
                               public void setBatchNumber(java.lang.String param){
                            localBatchNumberTracker = true;
                                   
                                            this.localBatchNumber=param;
                                       

                               }
                            

                        /**
                        * field for BatchOrigin
                        */

                        
                                    protected java.lang.String localBatchOrigin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBatchOriginTracker = false ;

                           public boolean isBatchOriginSpecified(){
                               return localBatchOriginTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBatchOrigin(){
                               return localBatchOrigin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BatchOrigin
                               */
                               public void setBatchOrigin(java.lang.String param){
                            localBatchOriginTracker = true;
                                   
                                            this.localBatchOrigin=param;
                                       

                               }
                            

                        /**
                        * field for ByEmployee
                        */

                        
                                    protected java.lang.String localByEmployee ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localByEmployeeTracker = false ;

                           public boolean isByEmployeeSpecified(){
                               return localByEmployeeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getByEmployee(){
                               return localByEmployee;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ByEmployee
                               */
                               public void setByEmployee(java.lang.String param){
                            localByEmployeeTracker = true;
                                   
                                            this.localByEmployee=param;
                                       

                               }
                            

                        /**
                        * field for Commodity
                        */

                        
                                    protected java.lang.String localCommodity ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCommodityTracker = false ;

                           public boolean isCommoditySpecified(){
                               return localCommodityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCommodity(){
                               return localCommodity;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Commodity
                               */
                               public void setCommodity(java.lang.String param){
                            localCommodityTracker = true;
                                   
                                            this.localCommodity=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeAddr1
                        */

                        
                                    protected java.lang.String localConsigneeAddr1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeAddr1Tracker = false ;

                           public boolean isConsigneeAddr1Specified(){
                               return localConsigneeAddr1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeAddr1(){
                               return localConsigneeAddr1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeAddr1
                               */
                               public void setConsigneeAddr1(java.lang.String param){
                            localConsigneeAddr1Tracker = true;
                                   
                                            this.localConsigneeAddr1=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeAddr2
                        */

                        
                                    protected java.lang.String localConsigneeAddr2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeAddr2Tracker = false ;

                           public boolean isConsigneeAddr2Specified(){
                               return localConsigneeAddr2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeAddr2(){
                               return localConsigneeAddr2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeAddr2
                               */
                               public void setConsigneeAddr2(java.lang.String param){
                            localConsigneeAddr2Tracker = true;
                                   
                                            this.localConsigneeAddr2=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeAddr3City
                        */

                        
                                    protected java.lang.String localConsigneeAddr3City ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeAddr3CityTracker = false ;

                           public boolean isConsigneeAddr3CitySpecified(){
                               return localConsigneeAddr3CityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeAddr3City(){
                               return localConsigneeAddr3City;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeAddr3City
                               */
                               public void setConsigneeAddr3City(java.lang.String param){
                            localConsigneeAddr3CityTracker = true;
                                   
                                            this.localConsigneeAddr3City=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeCode
                        */

                        
                                    protected java.lang.String localConsigneeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeCodeTracker = false ;

                           public boolean isConsigneeCodeSpecified(){
                               return localConsigneeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeCode(){
                               return localConsigneeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeCode
                               */
                               public void setConsigneeCode(java.lang.String param){
                            localConsigneeCodeTracker = true;
                                   
                                            this.localConsigneeCode=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeMobileNo
                        */

                        
                                    protected java.lang.String localConsigneeMobileNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeMobileNoTracker = false ;

                           public boolean isConsigneeMobileNoSpecified(){
                               return localConsigneeMobileNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeMobileNo(){
                               return localConsigneeMobileNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeMobileNo
                               */
                               public void setConsigneeMobileNo(java.lang.String param){
                            localConsigneeMobileNoTracker = true;
                                   
                                            this.localConsigneeMobileNo=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeName
                        */

                        
                                    protected java.lang.String localConsigneeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeNameTracker = false ;

                           public boolean isConsigneeNameSpecified(){
                               return localConsigneeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeName(){
                               return localConsigneeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeName
                               */
                               public void setConsigneeName(java.lang.String param){
                            localConsigneeNameTracker = true;
                                   
                                            this.localConsigneeName=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneePhoneNo
                        */

                        
                                    protected java.lang.String localConsigneePhoneNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneePhoneNoTracker = false ;

                           public boolean isConsigneePhoneNoSpecified(){
                               return localConsigneePhoneNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneePhoneNo(){
                               return localConsigneePhoneNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneePhoneNo
                               */
                               public void setConsigneePhoneNo(java.lang.String param){
                            localConsigneePhoneNoTracker = true;
                                   
                                            this.localConsigneePhoneNo=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneePincode
                        */

                        
                                    protected java.lang.String localConsigneePincode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneePincodeTracker = false ;

                           public boolean isConsigneePincodeSpecified(){
                               return localConsigneePincodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneePincode(){
                               return localConsigneePincode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneePincode
                               */
                               public void setConsigneePincode(java.lang.String param){
                            localConsigneePincodeTracker = true;
                                   
                                            this.localConsigneePincode=param;
                                       

                               }
                            

                        /**
                        * field for ConsigneeSenderAtn
                        */

                        
                                    protected java.lang.String localConsigneeSenderAtn ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeSenderAtnTracker = false ;

                           public boolean isConsigneeSenderAtnSpecified(){
                               return localConsigneeSenderAtnTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsigneeSenderAtn(){
                               return localConsigneeSenderAtn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConsigneeSenderAtn
                               */
                               public void setConsigneeSenderAtn(java.lang.String param){
                            localConsigneeSenderAtnTracker = true;
                                   
                                            this.localConsigneeSenderAtn=param;
                                       

                               }
                            

                        /**
                        * field for ContainerHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfContainerDetailStatistics localContainerHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContainerHistoryTracker = false ;

                           public boolean isContainerHistorySpecified(){
                               return localContainerHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfContainerDetailStatistics
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfContainerDetailStatistics getContainerHistory(){
                               return localContainerHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContainerHistory
                               */
                               public void setContainerHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfContainerDetailStatistics param){
                            localContainerHistoryTracker = true;
                                   
                                            this.localContainerHistory=param;
                                       

                               }
                            

                        /**
                        * field for ContainerHoldHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfHoldHistory localContainerHoldHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContainerHoldHistoryTracker = false ;

                           public boolean isContainerHoldHistorySpecified(){
                               return localContainerHoldHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfHoldHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfHoldHistory getContainerHoldHistory(){
                               return localContainerHoldHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContainerHoldHistory
                               */
                               public void setContainerHoldHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfHoldHistory param){
                            localContainerHoldHistoryTracker = true;
                                   
                                            this.localContainerHoldHistory=param;
                                       

                               }
                            

                        /**
                        * field for CurrentLocation
                        */

                        
                                    protected java.lang.String localCurrentLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCurrentLocationTracker = false ;

                           public boolean isCurrentLocationSpecified(){
                               return localCurrentLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCurrentLocation(){
                               return localCurrentLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CurrentLocation
                               */
                               public void setCurrentLocation(java.lang.String param){
                            localCurrentLocationTracker = true;
                                   
                                            this.localCurrentLocation=param;
                                       

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
                        * field for DataEntryModifiedBy
                        */

                        
                                    protected java.lang.String localDataEntryModifiedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataEntryModifiedByTracker = false ;

                           public boolean isDataEntryModifiedBySpecified(){
                               return localDataEntryModifiedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDataEntryModifiedBy(){
                               return localDataEntryModifiedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataEntryModifiedBy
                               */
                               public void setDataEntryModifiedBy(java.lang.String param){
                            localDataEntryModifiedByTracker = true;
                                   
                                            this.localDataEntryModifiedBy=param;
                                       

                               }
                            

                        /**
                        * field for DeclaredValue
                        */

                        
                                    protected double localDeclaredValue ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeclaredValueTracker = false ;

                           public boolean isDeclaredValueSpecified(){
                               return localDeclaredValueTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getDeclaredValue(){
                               return localDeclaredValue;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeclaredValue
                               */
                               public void setDeclaredValue(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localDeclaredValueTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localDeclaredValue=param;
                                       

                               }
                            

                        /**
                        * field for DeliverySheetSrNo
                        */

                        
                                    protected java.lang.String localDeliverySheetSrNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeliverySheetSrNoTracker = false ;

                           public boolean isDeliverySheetSrNoSpecified(){
                               return localDeliverySheetSrNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeliverySheetSrNo(){
                               return localDeliverySheetSrNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeliverySheetSrNo
                               */
                               public void setDeliverySheetSrNo(java.lang.String param){
                            localDeliverySheetSrNoTracker = true;
                                   
                                            this.localDeliverySheetSrNo=param;
                                       

                               }
                            

                        /**
                        * field for Destination
                        */

                        
                                    protected java.lang.String localDestination ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDestinationTracker = false ;

                           public boolean isDestinationSpecified(){
                               return localDestinationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDestination(){
                               return localDestination;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Destination
                               */
                               public void setDestination(java.lang.String param){
                            localDestinationTracker = true;
                                   
                                            this.localDestination=param;
                                       

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
                        * field for DestinationServiceCenter
                        */

                        
                                    protected java.lang.String localDestinationServiceCenter ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDestinationServiceCenterTracker = false ;

                           public boolean isDestinationServiceCenterSpecified(){
                               return localDestinationServiceCenterTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDestinationServiceCenter(){
                               return localDestinationServiceCenter;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DestinationServiceCenter
                               */
                               public void setDestinationServiceCenter(java.lang.String param){
                            localDestinationServiceCenterTracker = true;
                                   
                                            this.localDestinationServiceCenter=param;
                                       

                               }
                            

                        /**
                        * field for DimBreadth
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localDimBreadth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDimBreadthTracker = false ;

                           public boolean isDimBreadthSpecified(){
                               return localDimBreadthTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getDimBreadth(){
                               return localDimBreadth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DimBreadth
                               */
                               public void setDimBreadth(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localDimBreadthTracker = true;
                                   
                                            this.localDimBreadth=param;
                                       

                               }
                            

                        /**
                        * field for DimHeight
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localDimHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDimHeightTracker = false ;

                           public boolean isDimHeightSpecified(){
                               return localDimHeightTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getDimHeight(){
                               return localDimHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DimHeight
                               */
                               public void setDimHeight(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localDimHeightTracker = true;
                                   
                                            this.localDimHeight=param;
                                       

                               }
                            

                        /**
                        * field for DimLength
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localDimLength ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDimLengthTracker = false ;

                           public boolean isDimLengthSpecified(){
                               return localDimLengthTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getDimLength(){
                               return localDimLength;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DimLength
                               */
                               public void setDimLength(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localDimLengthTracker = true;
                                   
                                            this.localDimLength=param;
                                       

                               }
                            

                        /**
                        * field for DimPieces
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint localDimPieces ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDimPiecesTracker = false ;

                           public boolean isDimPiecesSpecified(){
                               return localDimPiecesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint getDimPieces(){
                               return localDimPieces;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DimPieces
                               */
                               public void setDimPieces(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint param){
                            localDimPiecesTracker = true;
                                   
                                            this.localDimPieces=param;
                                       

                               }
                            

                        /**
                        * field for DutyPaidAmount
                        */

                        
                                    protected double localDutyPaidAmount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDutyPaidAmountTracker = false ;

                           public boolean isDutyPaidAmountSpecified(){
                               return localDutyPaidAmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getDutyPaidAmount(){
                               return localDutyPaidAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DutyPaidAmount
                               */
                               public void setDutyPaidAmount(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localDutyPaidAmountTracker =
                                       !java.lang.Double.isNaN(param);
                                   
                                            this.localDutyPaidAmount=param;
                                       

                               }
                            

                        /**
                        * field for EDD
                        */

                        
                                    protected java.util.Calendar localEDD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEDDTracker = false ;

                           public boolean isEDDSpecified(){
                               return localEDDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getEDD(){
                               return localEDD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EDD
                               */
                               public void setEDD(java.util.Calendar param){
                            localEDDTracker = true;
                                   
                                            this.localEDD=param;
                                       

                               }
                            

                        /**
                        * field for EDL
                        */

                        
                                    protected java.lang.String localEDL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEDLTracker = false ;

                           public boolean isEDLSpecified(){
                               return localEDLTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEDL(){
                               return localEDL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EDL
                               */
                               public void setEDL(java.lang.String param){
                            localEDLTracker = true;
                                   
                                            this.localEDL=param;
                                       

                               }
                            

                        /**
                        * field for FlightDate
                        */

                        
                                    protected java.util.Calendar localFlightDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlightDateTracker = false ;

                           public boolean isFlightDateSpecified(){
                               return localFlightDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getFlightDate(){
                               return localFlightDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlightDate
                               */
                               public void setFlightDate(java.util.Calendar param){
                            localFlightDateTracker = true;
                                   
                                            this.localFlightDate=param;
                                       

                               }
                            

                        /**
                        * field for FlightDescription
                        */

                        
                                    protected java.lang.String localFlightDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlightDescriptionTracker = false ;

                           public boolean isFlightDescriptionSpecified(){
                               return localFlightDescriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFlightDescription(){
                               return localFlightDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlightDescription
                               */
                               public void setFlightDescription(java.lang.String param){
                            localFlightDescriptionTracker = true;
                                   
                                            this.localFlightDescription=param;
                                       

                               }
                            

                        /**
                        * field for FlightNumber
                        */

                        
                                    protected java.lang.String localFlightNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlightNumberTracker = false ;

                           public boolean isFlightNumberSpecified(){
                               return localFlightNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFlightNumber(){
                               return localFlightNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlightNumber
                               */
                               public void setFlightNumber(java.lang.String param){
                            localFlightNumberTracker = true;
                                   
                                            this.localFlightNumber=param;
                                       

                               }
                            

                        /**
                        * field for FodCodFlag
                        */

                        
                                    protected java.lang.String localFodCodFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFodCodFlagTracker = false ;

                           public boolean isFodCodFlagSpecified(){
                               return localFodCodFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFodCodFlag(){
                               return localFodCodFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FodCodFlag
                               */
                               public void setFodCodFlag(java.lang.String param){
                            localFodCodFlagTracker = true;
                                   
                                            this.localFodCodFlag=param;
                                       

                               }
                            

                        /**
                        * field for InFleetDate
                        */

                        
                                    protected java.util.Calendar localInFleetDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInFleetDateTracker = false ;

                           public boolean isInFleetDateSpecified(){
                               return localInFleetDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getInFleetDate(){
                               return localInFleetDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InFleetDate
                               */
                               public void setInFleetDate(java.util.Calendar param){
                            localInFleetDateTracker = true;
                                   
                                            this.localInFleetDate=param;
                                       

                               }
                            

                        /**
                        * field for InFleetNumber
                        */

                        
                                    protected java.lang.String localInFleetNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInFleetNumberTracker = false ;

                           public boolean isInFleetNumberSpecified(){
                               return localInFleetNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInFleetNumber(){
                               return localInFleetNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InFleetNumber
                               */
                               public void setInFleetNumber(java.lang.String param){
                            localInFleetNumberTracker = true;
                                   
                                            this.localInFleetNumber=param;
                                       

                               }
                            

                        /**
                        * field for InboundPaperworkTallyDate
                        */

                        
                                    protected java.lang.String localInboundPaperworkTallyDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInboundPaperworkTallyDateTracker = false ;

                           public boolean isInboundPaperworkTallyDateSpecified(){
                               return localInboundPaperworkTallyDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInboundPaperworkTallyDate(){
                               return localInboundPaperworkTallyDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InboundPaperworkTallyDate
                               */
                               public void setInboundPaperworkTallyDate(java.lang.String param){
                            localInboundPaperworkTallyDateTracker = true;
                                   
                                            this.localInboundPaperworkTallyDate=param;
                                       

                               }
                            

                        /**
                        * field for InboundShipmentTallyPiecesCount
                        */

                        
                                    protected java.lang.String localInboundShipmentTallyPiecesCount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInboundShipmentTallyPiecesCountTracker = false ;

                           public boolean isInboundShipmentTallyPiecesCountSpecified(){
                               return localInboundShipmentTallyPiecesCountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInboundShipmentTallyPiecesCount(){
                               return localInboundShipmentTallyPiecesCount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InboundShipmentTallyPiecesCount
                               */
                               public void setInboundShipmentTallyPiecesCount(java.lang.String param){
                            localInboundShipmentTallyPiecesCountTracker = true;
                                   
                                            this.localInboundShipmentTallyPiecesCount=param;
                                       

                               }
                            

                        /**
                        * field for InboundVehicleNumber
                        */

                        
                                    protected java.lang.String localInboundVehicleNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInboundVehicleNumberTracker = false ;

                           public boolean isInboundVehicleNumberSpecified(){
                               return localInboundVehicleNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInboundVehicleNumber(){
                               return localInboundVehicleNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InboundVehicleNumber
                               */
                               public void setInboundVehicleNumber(java.lang.String param){
                            localInboundVehicleNumberTracker = true;
                                   
                                            this.localInboundVehicleNumber=param;
                                       

                               }
                            

                        /**
                        * field for InscanDateTime
                        */

                        
                                    protected java.util.Calendar localInscanDateTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInscanDateTimeTracker = false ;

                           public boolean isInscanDateTimeSpecified(){
                               return localInscanDateTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getInscanDateTime(){
                               return localInscanDateTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InscanDateTime
                               */
                               public void setInscanDateTime(java.util.Calendar param){
                            localInscanDateTimeTracker = true;
                                   
                                            this.localInscanDateTime=param;
                                       

                               }
                            

                        /**
                        * field for IsCollectDuty
                        */

                        
                                    protected java.lang.String localIsCollectDuty ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsCollectDutyTracker = false ;

                           public boolean isIsCollectDutySpecified(){
                               return localIsCollectDutyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIsCollectDuty(){
                               return localIsCollectDuty;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsCollectDuty
                               */
                               public void setIsCollectDuty(java.lang.String param){
                            localIsCollectDutyTracker = true;
                                   
                                            this.localIsCollectDuty=param;
                                       

                               }
                            

                        /**
                        * field for IsCreditCardReference
                        */

                        
                                    protected boolean localIsCreditCardReference ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsCreditCardReferenceTracker = false ;

                           public boolean isIsCreditCardReferenceSpecified(){
                               return localIsCreditCardReferenceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsCreditCardReference(){
                               return localIsCreditCardReference;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsCreditCardReference
                               */
                               public void setIsCreditCardReference(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsCreditCardReferenceTracker =
                                       true;
                                   
                                            this.localIsCreditCardReference=param;
                                       

                               }
                            

                        /**
                        * field for IsLastUpdatedByOtm
                        */

                        
                                    protected boolean localIsLastUpdatedByOtm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsLastUpdatedByOtmTracker = false ;

                           public boolean isIsLastUpdatedByOtmSpecified(){
                               return localIsLastUpdatedByOtmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsLastUpdatedByOtm(){
                               return localIsLastUpdatedByOtm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsLastUpdatedByOtm
                               */
                               public void setIsLastUpdatedByOtm(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsLastUpdatedByOtmTracker =
                                       true;
                                   
                                            this.localIsLastUpdatedByOtm=param;
                                       

                               }
                            

                        /**
                        * field for Octroi
                        */

                        
                                    protected java.lang.String localOctroi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiTracker = false ;

                           public boolean isOctroiSpecified(){
                               return localOctroiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOctroi(){
                               return localOctroi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Octroi
                               */
                               public void setOctroi(java.lang.String param){
                            localOctroiTracker = true;
                                   
                                            this.localOctroi=param;
                                       

                               }
                            

                        /**
                        * field for OperationDetailedHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentDetailedHistory localOperationDetailedHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperationDetailedHistoryTracker = false ;

                           public boolean isOperationDetailedHistorySpecified(){
                               return localOperationDetailedHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentDetailedHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentDetailedHistory getOperationDetailedHistory(){
                               return localOperationDetailedHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OperationDetailedHistory
                               */
                               public void setOperationDetailedHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentDetailedHistory param){
                            localOperationDetailedHistoryTracker = true;
                                   
                                            this.localOperationDetailedHistory=param;
                                       

                               }
                            

                        /**
                        * field for OperationHistory
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentOperationHistory localOperationHistory ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperationHistoryTracker = false ;

                           public boolean isOperationHistorySpecified(){
                               return localOperationHistoryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentOperationHistory
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentOperationHistory getOperationHistory(){
                               return localOperationHistory;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OperationHistory
                               */
                               public void setOperationHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentOperationHistory param){
                            localOperationHistoryTracker = true;
                                   
                                            this.localOperationHistory=param;
                                       

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
                        * field for OriginServiceCenter
                        */

                        
                                    protected java.lang.String localOriginServiceCenter ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOriginServiceCenterTracker = false ;

                           public boolean isOriginServiceCenterSpecified(){
                               return localOriginServiceCenterTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOriginServiceCenter(){
                               return localOriginServiceCenter;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OriginServiceCenter
                               */
                               public void setOriginServiceCenter(java.lang.String param){
                            localOriginServiceCenterTracker = true;
                                   
                                            this.localOriginServiceCenter=param;
                                       

                               }
                            

                        /**
                        * field for OutboundVehicleNumber
                        */

                        
                                    protected java.lang.String localOutboundVehicleNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOutboundVehicleNumberTracker = false ;

                           public boolean isOutboundVehicleNumberSpecified(){
                               return localOutboundVehicleNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOutboundVehicleNumber(){
                               return localOutboundVehicleNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OutboundVehicleNumber
                               */
                               public void setOutboundVehicleNumber(java.lang.String param){
                            localOutboundVehicleNumberTracker = true;
                                   
                                            this.localOutboundVehicleNumber=param;
                                       

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
                        * field for PaperworkDeLinkedBy
                        */

                        
                                    protected java.lang.String localPaperworkDeLinkedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaperworkDeLinkedByTracker = false ;

                           public boolean isPaperworkDeLinkedBySpecified(){
                               return localPaperworkDeLinkedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPaperworkDeLinkedBy(){
                               return localPaperworkDeLinkedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PaperworkDeLinkedBy
                               */
                               public void setPaperworkDeLinkedBy(java.lang.String param){
                            localPaperworkDeLinkedByTracker = true;
                                   
                                            this.localPaperworkDeLinkedBy=param;
                                       

                               }
                            

                        /**
                        * field for PaperworkLinkedBy
                        */

                        
                                    protected java.lang.String localPaperworkLinkedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaperworkLinkedByTracker = false ;

                           public boolean isPaperworkLinkedBySpecified(){
                               return localPaperworkLinkedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPaperworkLinkedBy(){
                               return localPaperworkLinkedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PaperworkLinkedBy
                               */
                               public void setPaperworkLinkedBy(java.lang.String param){
                            localPaperworkLinkedByTracker = true;
                                   
                                            this.localPaperworkLinkedBy=param;
                                       

                               }
                            

                        /**
                        * field for ParentContainerID
                        */

                        
                                    protected java.lang.String localParentContainerID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParentContainerIDTracker = false ;

                           public boolean isParentContainerIDSpecified(){
                               return localParentContainerIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getParentContainerID(){
                               return localParentContainerID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ParentContainerID
                               */
                               public void setParentContainerID(java.lang.String param){
                            localParentContainerIDTracker = true;
                                   
                                            this.localParentContainerID=param;
                                       

                               }
                            

                        /**
                        * field for PickupDate
                        */

                        
                                    protected java.util.Calendar localPickupDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPickupDateTracker = false ;

                           public boolean isPickupDateSpecified(){
                               return localPickupDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getPickupDate(){
                               return localPickupDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PickupDate
                               */
                               public void setPickupDate(java.util.Calendar param){
                            localPickupDateTracker = true;
                                   
                                            this.localPickupDate=param;
                                       

                               }
                            

                        /**
                        * field for PickupEmployeeCode
                        */

                        
                                    protected java.lang.String localPickupEmployeeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPickupEmployeeCodeTracker = false ;

                           public boolean isPickupEmployeeCodeSpecified(){
                               return localPickupEmployeeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPickupEmployeeCode(){
                               return localPickupEmployeeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PickupEmployeeCode
                               */
                               public void setPickupEmployeeCode(java.lang.String param){
                            localPickupEmployeeCodeTracker = true;
                                   
                                            this.localPickupEmployeeCode=param;
                                       

                               }
                            

                        /**
                        * field for Pieces
                        */

                        
                                    protected java.lang.String localPieces ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPiecesTracker = false ;

                           public boolean isPiecesSpecified(){
                               return localPiecesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPieces(){
                               return localPieces;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pieces
                               */
                               public void setPieces(java.lang.String param){
                            localPiecesTracker = true;
                                   
                                            this.localPieces=param;
                                       

                               }
                            

                        /**
                        * field for Priority
                        */

                        
                                    protected java.lang.String localPriority ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPriorityTracker = false ;

                           public boolean isPrioritySpecified(){
                               return localPriorityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPriority(){
                               return localPriority;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Priority
                               */
                               public void setPriority(java.lang.String param){
                            localPriorityTracker = true;
                                   
                                            this.localPriority=param;
                                       

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
                        * field for RTOAWBRelation
                        */

                        
                                    protected java.lang.String localRTOAWBRelation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRTOAWBRelationTracker = false ;

                           public boolean isRTOAWBRelationSpecified(){
                               return localRTOAWBRelationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRTOAWBRelation(){
                               return localRTOAWBRelation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RTOAWBRelation
                               */
                               public void setRTOAWBRelation(java.lang.String param){
                            localRTOAWBRelationTracker = true;
                                   
                                            this.localRTOAWBRelation=param;
                                       

                               }
                            

                        /**
                        * field for ReceivedBy
                        */

                        
                                    protected java.lang.String localReceivedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReceivedByTracker = false ;

                           public boolean isReceivedBySpecified(){
                               return localReceivedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getReceivedBy(){
                               return localReceivedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReceivedBy
                               */
                               public void setReceivedBy(java.lang.String param){
                            localReceivedByTracker = true;
                                   
                                            this.localReceivedBy=param;
                                       

                               }
                            

                        /**
                        * field for ReferenceNumber
                        */

                        
                                    protected java.lang.String localReferenceNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReferenceNumberTracker = false ;

                           public boolean isReferenceNumberSpecified(){
                               return localReferenceNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getReferenceNumber(){
                               return localReferenceNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReferenceNumber
                               */
                               public void setReferenceNumber(java.lang.String param){
                            localReferenceNumberTracker = true;
                                   
                                            this.localReferenceNumber=param;
                                       

                               }
                            

                        /**
                        * field for Relation
                        */

                        
                                    protected java.lang.String localRelation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRelationTracker = false ;

                           public boolean isRelationSpecified(){
                               return localRelationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelation(){
                               return localRelation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Relation
                               */
                               public void setRelation(java.lang.String param){
                            localRelationTracker = true;
                                   
                                            this.localRelation=param;
                                       

                               }
                            

                        /**
                        * field for RelationIdDetail
                        */

                        
                                    protected java.lang.String localRelationIdDetail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRelationIdDetailTracker = false ;

                           public boolean isRelationIdDetailSpecified(){
                               return localRelationIdDetailTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelationIdDetail(){
                               return localRelationIdDetail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RelationIdDetail
                               */
                               public void setRelationIdDetail(java.lang.String param){
                            localRelationIdDetailTracker = true;
                                   
                                            this.localRelationIdDetail=param;
                                       

                               }
                            

                        /**
                        * field for Run
                        */

                        
                                    protected java.lang.String localRun ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRunTracker = false ;

                           public boolean isRunSpecified(){
                               return localRunTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRun(){
                               return localRun;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Run
                               */
                               public void setRun(java.lang.String param){
                            localRunTracker = true;
                                   
                                            this.localRun=param;
                                       

                               }
                            

                        /**
                        * field for Sender
                        */

                        
                                    protected java.lang.String localSender ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSenderTracker = false ;

                           public boolean isSenderSpecified(){
                               return localSenderTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSender(){
                               return localSender;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sender
                               */
                               public void setSender(java.lang.String param){
                            localSenderTracker = true;
                                   
                                            this.localSender=param;
                                       

                               }
                            

                        /**
                        * field for SerialNumber
                        */

                        
                                    protected java.lang.String localSerialNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSerialNumberTracker = false ;

                           public boolean isSerialNumberSpecified(){
                               return localSerialNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSerialNumber(){
                               return localSerialNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SerialNumber
                               */
                               public void setSerialNumber(java.lang.String param){
                            localSerialNumberTracker = true;
                                   
                                            this.localSerialNumber=param;
                                       

                               }
                            

                        /**
                        * field for ShipmentDate
                        */

                        
                                    protected java.util.Calendar localShipmentDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipmentDateTracker = false ;

                           public boolean isShipmentDateSpecified(){
                               return localShipmentDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getShipmentDate(){
                               return localShipmentDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipmentDate
                               */
                               public void setShipmentDate(java.util.Calendar param){
                            localShipmentDateTracker = true;
                                   
                                            this.localShipmentDate=param;
                                       

                               }
                            

                        /**
                        * field for ShipmentDeLinkedBy
                        */

                        
                                    protected java.lang.String localShipmentDeLinkedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipmentDeLinkedByTracker = false ;

                           public boolean isShipmentDeLinkedBySpecified(){
                               return localShipmentDeLinkedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipmentDeLinkedBy(){
                               return localShipmentDeLinkedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipmentDeLinkedBy
                               */
                               public void setShipmentDeLinkedBy(java.lang.String param){
                            localShipmentDeLinkedByTracker = true;
                                   
                                            this.localShipmentDeLinkedBy=param;
                                       

                               }
                            

                        /**
                        * field for ShipmentLinkedBy
                        */

                        
                                    protected java.lang.String localShipmentLinkedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipmentLinkedByTracker = false ;

                           public boolean isShipmentLinkedBySpecified(){
                               return localShipmentLinkedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipmentLinkedBy(){
                               return localShipmentLinkedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipmentLinkedBy
                               */
                               public void setShipmentLinkedBy(java.lang.String param){
                            localShipmentLinkedByTracker = true;
                                   
                                            this.localShipmentLinkedBy=param;
                                       

                               }
                            

                        /**
                        * field for ShipperAddr1
                        */

                        
                                    protected java.lang.String localShipperAddr1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperAddr1Tracker = false ;

                           public boolean isShipperAddr1Specified(){
                               return localShipperAddr1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperAddr1(){
                               return localShipperAddr1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperAddr1
                               */
                               public void setShipperAddr1(java.lang.String param){
                            localShipperAddr1Tracker = true;
                                   
                                            this.localShipperAddr1=param;
                                       

                               }
                            

                        /**
                        * field for ShipperAddr2
                        */

                        
                                    protected java.lang.String localShipperAddr2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperAddr2Tracker = false ;

                           public boolean isShipperAddr2Specified(){
                               return localShipperAddr2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperAddr2(){
                               return localShipperAddr2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperAddr2
                               */
                               public void setShipperAddr2(java.lang.String param){
                            localShipperAddr2Tracker = true;
                                   
                                            this.localShipperAddr2=param;
                                       

                               }
                            

                        /**
                        * field for ShipperAddr3City
                        */

                        
                                    protected java.lang.String localShipperAddr3City ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperAddr3CityTracker = false ;

                           public boolean isShipperAddr3CitySpecified(){
                               return localShipperAddr3CityTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperAddr3City(){
                               return localShipperAddr3City;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperAddr3City
                               */
                               public void setShipperAddr3City(java.lang.String param){
                            localShipperAddr3CityTracker = true;
                                   
                                            this.localShipperAddr3City=param;
                                       

                               }
                            

                        /**
                        * field for ShipperCode
                        */

                        
                                    protected java.lang.String localShipperCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperCodeTracker = false ;

                           public boolean isShipperCodeSpecified(){
                               return localShipperCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperCode(){
                               return localShipperCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperCode
                               */
                               public void setShipperCode(java.lang.String param){
                            localShipperCodeTracker = true;
                                   
                                            this.localShipperCode=param;
                                       

                               }
                            

                        /**
                        * field for ShipperMobileNo
                        */

                        
                                    protected java.lang.String localShipperMobileNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperMobileNoTracker = false ;

                           public boolean isShipperMobileNoSpecified(){
                               return localShipperMobileNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperMobileNo(){
                               return localShipperMobileNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperMobileNo
                               */
                               public void setShipperMobileNo(java.lang.String param){
                            localShipperMobileNoTracker = true;
                                   
                                            this.localShipperMobileNo=param;
                                       

                               }
                            

                        /**
                        * field for ShipperName
                        */

                        
                                    protected java.lang.String localShipperName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperNameTracker = false ;

                           public boolean isShipperNameSpecified(){
                               return localShipperNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperName(){
                               return localShipperName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperName
                               */
                               public void setShipperName(java.lang.String param){
                            localShipperNameTracker = true;
                                   
                                            this.localShipperName=param;
                                       

                               }
                            

                        /**
                        * field for ShipperPhoneNo
                        */

                        
                                    protected java.lang.String localShipperPhoneNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperPhoneNoTracker = false ;

                           public boolean isShipperPhoneNoSpecified(){
                               return localShipperPhoneNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperPhoneNo(){
                               return localShipperPhoneNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperPhoneNo
                               */
                               public void setShipperPhoneNo(java.lang.String param){
                            localShipperPhoneNoTracker = true;
                                   
                                            this.localShipperPhoneNo=param;
                                       

                               }
                            

                        /**
                        * field for ShipperPincode
                        */

                        
                                    protected java.lang.String localShipperPincode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperPincodeTracker = false ;

                           public boolean isShipperPincodeSpecified(){
                               return localShipperPincodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperPincode(){
                               return localShipperPincode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperPincode
                               */
                               public void setShipperPincode(java.lang.String param){
                            localShipperPincodeTracker = true;
                                   
                                            this.localShipperPincode=param;
                                       

                               }
                            

                        /**
                        * field for ShipperSenderAtn
                        */

                        
                                    protected java.lang.String localShipperSenderAtn ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperSenderAtnTracker = false ;

                           public boolean isShipperSenderAtnSpecified(){
                               return localShipperSenderAtnTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipperSenderAtn(){
                               return localShipperSenderAtn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipperSenderAtn
                               */
                               public void setShipperSenderAtn(java.lang.String param){
                            localShipperSenderAtnTracker = true;
                                   
                                            this.localShipperSenderAtn=param;
                                       

                               }
                            

                        /**
                        * field for SpecialInstruction
                        */

                        
                                    protected java.lang.String localSpecialInstruction ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSpecialInstructionTracker = false ;

                           public boolean isSpecialInstructionSpecified(){
                               return localSpecialInstructionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSpecialInstruction(){
                               return localSpecialInstruction;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SpecialInstruction
                               */
                               public void setSpecialInstruction(java.lang.String param){
                            localSpecialInstructionTracker = true;
                                   
                                            this.localSpecialInstruction=param;
                                       

                               }
                            

                        /**
                        * field for StatusCode
                        */

                        
                                    protected java.lang.String localStatusCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusCodeTracker = false ;

                           public boolean isStatusCodeSpecified(){
                               return localStatusCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusCode(){
                               return localStatusCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusCode
                               */
                               public void setStatusCode(java.lang.String param){
                            localStatusCodeTracker = true;
                                   
                                            this.localStatusCode=param;
                                       

                               }
                            

                        /**
                        * field for StatusDescription
                        */

                        
                                    protected java.lang.String localStatusDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusDescriptionTracker = false ;

                           public boolean isStatusDescriptionSpecified(){
                               return localStatusDescriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusDescription(){
                               return localStatusDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusDescription
                               */
                               public void setStatusDescription(java.lang.String param){
                            localStatusDescriptionTracker = true;
                                   
                                            this.localStatusDescription=param;
                                       

                               }
                            

                        /**
                        * field for StatusUpdateDate
                        */

                        
                                    protected java.util.Calendar localStatusUpdateDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusUpdateDateTracker = false ;

                           public boolean isStatusUpdateDateSpecified(){
                               return localStatusUpdateDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getStatusUpdateDate(){
                               return localStatusUpdateDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusUpdateDate
                               */
                               public void setStatusUpdateDate(java.util.Calendar param){
                            localStatusUpdateDateTracker = true;
                                   
                                            this.localStatusUpdateDate=param;
                                       

                               }
                            

                        /**
                        * field for StatusUpdateTime
                        */

                        
                                    protected java.lang.String localStatusUpdateTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusUpdateTimeTracker = false ;

                           public boolean isStatusUpdateTimeSpecified(){
                               return localStatusUpdateTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusUpdateTime(){
                               return localStatusUpdateTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusUpdateTime
                               */
                               public void setStatusUpdateTime(java.lang.String param){
                            localStatusUpdateTimeTracker = true;
                                   
                                            this.localStatusUpdateTime=param;
                                       

                               }
                            

                        /**
                        * field for SubCode
                        */

                        
                                    protected java.lang.String localSubCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubCodeTracker = false ;

                           public boolean isSubCodeSpecified(){
                               return localSubCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubCode(){
                               return localSubCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubCode
                               */
                               public void setSubCode(java.lang.String param){
                            localSubCodeTracker = true;
                                   
                                            this.localSubCode=param;
                                       

                               }
                            

                        /**
                        * field for SubProductCode
                        */

                        
                                    protected java.lang.String localSubProductCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubProductCodeTracker = false ;

                           public boolean isSubProductCodeSpecified(){
                               return localSubProductCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubProductCode(){
                               return localSubProductCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubProductCode
                               */
                               public void setSubProductCode(java.lang.String param){
                            localSubProductCodeTracker = true;
                                   
                                            this.localSubProductCode=param;
                                       

                               }
                            

                        /**
                        * field for Tally
                        */

                        
                                    protected java.lang.String localTally ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTallyTracker = false ;

                           public boolean isTallySpecified(){
                               return localTallyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTally(){
                               return localTally;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tally
                               */
                               public void setTally(java.lang.String param){
                            localTallyTracker = true;
                                   
                                            this.localTally=param;
                                       

                               }
                            

                        /**
                        * field for TokenNumber
                        */

                        
                                    protected java.lang.String localTokenNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTokenNumberTracker = false ;

                           public boolean isTokenNumberSpecified(){
                               return localTokenNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTokenNumber(){
                               return localTokenNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TokenNumber
                               */
                               public void setTokenNumber(java.lang.String param){
                            localTokenNumberTracker = true;
                                   
                                            this.localTokenNumber=param;
                                       

                               }
                            

                        /**
                        * field for Weight
                        */

                        
                                    protected java.lang.String localWeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWeightTracker = false ;

                           public boolean isWeightSpecified(){
                               return localWeightTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getWeight(){
                               return localWeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Weight
                               */
                               public void setWeight(java.lang.String param){
                            localWeightTracker = true;
                                   
                                            this.localWeight=param;
                                       

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
                           namespacePrefix+":ShipmentHistory",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ShipmentHistory",
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
                             } if (localAttentionTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Attention", xmlWriter);
                             

                                          if (localAttention==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAttention);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBaggedTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Bagged", xmlWriter);
                             

                                          if (localBagged==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBagged);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBaggingInboundHistoryTracker){
                                    if (localBaggingInboundHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "BaggingInboundHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBaggingInboundHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BaggingInboundHistory"),
                                        xmlWriter);
                                    }
                                } if (localBaggingOutboundHistoryTracker){
                                    if (localBaggingOutboundHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "BaggingOutboundHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBaggingOutboundHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BaggingOutboundHistory"),
                                        xmlWriter);
                                    }
                                } if (localBaggingSplitTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BaggingSplit", xmlWriter);
                             

                                          if (localBaggingSplit==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBaggingSplit);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBasicOriginTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BasicOrigin", xmlWriter);
                             

                                          if (localBasicOrigin==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBasicOrigin);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBatchNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BatchNumber", xmlWriter);
                             

                                          if (localBatchNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBatchNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBatchOriginTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BatchOrigin", xmlWriter);
                             

                                          if (localBatchOrigin==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBatchOrigin);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localByEmployeeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ByEmployee", xmlWriter);
                             

                                          if (localByEmployee==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localByEmployee);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommodityTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Commodity", xmlWriter);
                             

                                          if (localCommodity==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCommodity);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeAddr1Tracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeAddr1", xmlWriter);
                             

                                          if (localConsigneeAddr1==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeAddr1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeAddr2Tracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeAddr2", xmlWriter);
                             

                                          if (localConsigneeAddr2==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeAddr2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeAddr3CityTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeAddr3City", xmlWriter);
                             

                                          if (localConsigneeAddr3City==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeAddr3City);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeCode", xmlWriter);
                             

                                          if (localConsigneeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeMobileNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeMobileNo", xmlWriter);
                             

                                          if (localConsigneeMobileNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeMobileNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeName", xmlWriter);
                             

                                          if (localConsigneeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneePhoneNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneePhoneNo", xmlWriter);
                             

                                          if (localConsigneePhoneNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneePhoneNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneePincodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneePincode", xmlWriter);
                             

                                          if (localConsigneePincode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneePincode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeSenderAtnTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConsigneeSenderAtn", xmlWriter);
                             

                                          if (localConsigneeSenderAtn==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeSenderAtn);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContainerHistoryTracker){
                                    if (localContainerHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "ContainerHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localContainerHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContainerHistory"),
                                        xmlWriter);
                                    }
                                } if (localContainerHoldHistoryTracker){
                                    if (localContainerHoldHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "ContainerHoldHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localContainerHoldHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContainerHoldHistory"),
                                        xmlWriter);
                                    }
                                } if (localCurrentLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CurrentLocation", xmlWriter);
                             

                                          if (localCurrentLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCurrentLocation);
                                            
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
                             } if (localDataEntryModifiedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DataEntryModifiedBy", xmlWriter);
                             

                                          if (localDataEntryModifiedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDataEntryModifiedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeclaredValueTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeclaredValue", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localDeclaredValue)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DeclaredValue cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeclaredValue));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeliverySheetSrNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeliverySheetSrNo", xmlWriter);
                             

                                          if (localDeliverySheetSrNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeliverySheetSrNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestinationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Destination", xmlWriter);
                             

                                          if (localDestination==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestination);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestinationAreaTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DestinationArea", xmlWriter);
                             

                                          if (localDestinationArea==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestinationArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestinationServiceCenterTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DestinationServiceCenter", xmlWriter);
                             

                                          if (localDestinationServiceCenter==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestinationServiceCenter);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDimBreadthTracker){
                                    if (localDimBreadth==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "DimBreadth", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localDimBreadth.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimBreadth"),
                                        xmlWriter);
                                    }
                                } if (localDimHeightTracker){
                                    if (localDimHeight==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "DimHeight", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localDimHeight.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimHeight"),
                                        xmlWriter);
                                    }
                                } if (localDimLengthTracker){
                                    if (localDimLength==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "DimLength", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localDimLength.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimLength"),
                                        xmlWriter);
                                    }
                                } if (localDimPiecesTracker){
                                    if (localDimPieces==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "DimPieces", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localDimPieces.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimPieces"),
                                        xmlWriter);
                                    }
                                } if (localDutyPaidAmountTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DutyPaidAmount", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localDutyPaidAmount)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DutyPaidAmount cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDutyPaidAmount));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEDDTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "EDD", xmlWriter);
                             

                                          if (localEDD==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEDD));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEDLTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "EDL", xmlWriter);
                             

                                          if (localEDL==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEDL);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlightDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FlightDate", xmlWriter);
                             

                                          if (localFlightDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlightDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlightDescriptionTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FlightDescription", xmlWriter);
                             

                                          if (localFlightDescription==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFlightDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlightNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FlightNumber", xmlWriter);
                             

                                          if (localFlightNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFlightNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFodCodFlagTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FodCodFlag", xmlWriter);
                             

                                          if (localFodCodFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFodCodFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInFleetDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InFleetDate", xmlWriter);
                             

                                          if (localInFleetDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInFleetDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInFleetNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InFleetNumber", xmlWriter);
                             

                                          if (localInFleetNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInFleetNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInboundPaperworkTallyDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InboundPaperworkTallyDate", xmlWriter);
                             

                                          if (localInboundPaperworkTallyDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInboundPaperworkTallyDate);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInboundShipmentTallyPiecesCountTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InboundShipmentTallyPiecesCount", xmlWriter);
                             

                                          if (localInboundShipmentTallyPiecesCount==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInboundShipmentTallyPiecesCount);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInboundVehicleNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InboundVehicleNumber", xmlWriter);
                             

                                          if (localInboundVehicleNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInboundVehicleNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInscanDateTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InscanDateTime", xmlWriter);
                             

                                          if (localInscanDateTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInscanDateTime));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsCollectDutyTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsCollectDuty", xmlWriter);
                             

                                          if (localIsCollectDuty==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIsCollectDuty);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsCreditCardReferenceTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsCreditCardReference", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsCreditCardReference cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsCreditCardReference));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsLastUpdatedByOtmTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsLastUpdatedByOtm", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsLastUpdatedByOtm cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsLastUpdatedByOtm));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOctroiTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Octroi", xmlWriter);
                             

                                          if (localOctroi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOctroi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOperationDetailedHistoryTracker){
                                    if (localOperationDetailedHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "OperationDetailedHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOperationDetailedHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OperationDetailedHistory"),
                                        xmlWriter);
                                    }
                                } if (localOperationHistoryTracker){
                                    if (localOperationHistory==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "OperationHistory", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOperationHistory.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OperationHistory"),
                                        xmlWriter);
                                    }
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
                             } if (localOriginAreaTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OriginArea", xmlWriter);
                             

                                          if (localOriginArea==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOriginArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOriginServiceCenterTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OriginServiceCenter", xmlWriter);
                             

                                          if (localOriginServiceCenter==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOriginServiceCenter);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOutboundVehicleNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OutboundVehicleNumber", xmlWriter);
                             

                                          if (localOutboundVehicleNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOutboundVehicleNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPackageTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PackageType", xmlWriter);
                             

                                          if (localPackageType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPackageType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPaperworkDeLinkedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PaperworkDeLinkedBy", xmlWriter);
                             

                                          if (localPaperworkDeLinkedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPaperworkDeLinkedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPaperworkLinkedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PaperworkLinkedBy", xmlWriter);
                             

                                          if (localPaperworkLinkedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPaperworkLinkedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localParentContainerIDTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ParentContainerID", xmlWriter);
                             

                                          if (localParentContainerID==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localParentContainerID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPickupDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PickupDate", xmlWriter);
                             

                                          if (localPickupDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPickupDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPickupEmployeeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PickupEmployeeCode", xmlWriter);
                             

                                          if (localPickupEmployeeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPickupEmployeeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPiecesTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Pieces", xmlWriter);
                             

                                          if (localPieces==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPieces);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPriorityTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Priority", xmlWriter);
                             

                                          if (localPriority==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPriority);
                                            
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
                             } if (localProductTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ProductType", xmlWriter);
                             

                                          if (localProductType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRTOAWBRelationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RTOAWBRelation", xmlWriter);
                             

                                          if (localRTOAWBRelation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRTOAWBRelation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localReceivedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReceivedBy", xmlWriter);
                             

                                          if (localReceivedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localReceivedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localReferenceNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReferenceNumber", xmlWriter);
                             

                                          if (localReferenceNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localReferenceNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRelationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Relation", xmlWriter);
                             

                                          if (localRelation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRelationIdDetailTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RelationIdDetail", xmlWriter);
                             

                                          if (localRelationIdDetail==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelationIdDetail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Run", xmlWriter);
                             

                                          if (localRun==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRun);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSenderTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Sender", xmlWriter);
                             

                                          if (localSender==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSender);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSerialNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "SerialNumber", xmlWriter);
                             

                                          if (localSerialNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSerialNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipmentDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipmentDate", xmlWriter);
                             

                                          if (localShipmentDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShipmentDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipmentDeLinkedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipmentDeLinkedBy", xmlWriter);
                             

                                          if (localShipmentDeLinkedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipmentDeLinkedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipmentLinkedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipmentLinkedBy", xmlWriter);
                             

                                          if (localShipmentLinkedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipmentLinkedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperAddr1Tracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperAddr1", xmlWriter);
                             

                                          if (localShipperAddr1==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperAddr1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperAddr2Tracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperAddr2", xmlWriter);
                             

                                          if (localShipperAddr2==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperAddr2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperAddr3CityTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperAddr3City", xmlWriter);
                             

                                          if (localShipperAddr3City==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperAddr3City);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperCode", xmlWriter);
                             

                                          if (localShipperCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperMobileNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperMobileNo", xmlWriter);
                             

                                          if (localShipperMobileNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperMobileNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperName", xmlWriter);
                             

                                          if (localShipperName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperPhoneNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperPhoneNo", xmlWriter);
                             

                                          if (localShipperPhoneNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperPhoneNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperPincodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperPincode", xmlWriter);
                             

                                          if (localShipperPincode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperPincode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperSenderAtnTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ShipperSenderAtn", xmlWriter);
                             

                                          if (localShipperSenderAtn==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperSenderAtn);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSpecialInstructionTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "SpecialInstruction", xmlWriter);
                             

                                          if (localSpecialInstruction==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSpecialInstruction);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusCode", xmlWriter);
                             

                                          if (localStatusCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusDescriptionTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusDescription", xmlWriter);
                             

                                          if (localStatusDescription==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusUpdateDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusUpdateDate", xmlWriter);
                             

                                          if (localStatusUpdateDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusUpdateDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusUpdateTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusUpdateTime", xmlWriter);
                             

                                          if (localStatusUpdateTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusUpdateTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "SubCode", xmlWriter);
                             

                                          if (localSubCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubProductCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "SubProductCode", xmlWriter);
                             

                                          if (localSubProductCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubProductCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTallyTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Tally", xmlWriter);
                             

                                          if (localTally==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTally);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTokenNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "TokenNumber", xmlWriter);
                             

                                          if (localTokenNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTokenNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWeightTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Weight", xmlWriter);
                             

                                          if (localWeight==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localWeight);
                                            
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
        public static ShipmentHistory parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ShipmentHistory object =
                new ShipmentHistory();

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
                    
                            if (!"ShipmentHistory".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ShipmentHistory)org.tempuri.imports.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Attention").equals(reader.getName()) || new javax.xml.namespace.QName("","Attention").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAttention(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Bagged").equals(reader.getName()) || new javax.xml.namespace.QName("","Bagged").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBagged(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BaggingInboundHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","BaggingInboundHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBaggingInboundHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBaggingInboundHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BaggingOutboundHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","BaggingOutboundHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBaggingOutboundHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBaggingOutboundHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentBaggingHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BaggingSplit").equals(reader.getName()) || new javax.xml.namespace.QName("","BaggingSplit").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBaggingSplit(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BasicOrigin").equals(reader.getName()) || new javax.xml.namespace.QName("","BasicOrigin").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBasicOrigin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BatchNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","BatchNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBatchNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BatchOrigin").equals(reader.getName()) || new javax.xml.namespace.QName("","BatchOrigin").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBatchOrigin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ByEmployee").equals(reader.getName()) || new javax.xml.namespace.QName("","ByEmployee").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setByEmployee(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Commodity").equals(reader.getName()) || new javax.xml.namespace.QName("","Commodity").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCommodity(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeAddr1").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeAddr1").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeAddr1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeAddr2").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeAddr2").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeAddr2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeAddr3City").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeAddr3City").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeAddr3City(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeMobileNo").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeMobileNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeMobileNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeName").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneePhoneNo").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneePhoneNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneePhoneNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneePincode").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneePincode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneePincode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConsigneeSenderAtn").equals(reader.getName()) || new javax.xml.namespace.QName("","ConsigneeSenderAtn").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsigneeSenderAtn(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContainerHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","ContainerHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setContainerHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setContainerHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfContainerDetailStatistics.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContainerHoldHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","ContainerHoldHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setContainerHoldHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setContainerHoldHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfHoldHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CurrentLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","CurrentLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCurrentLocation(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DataEntryModifiedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","DataEntryModifiedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataEntryModifiedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeclaredValue").equals(reader.getName()) || new javax.xml.namespace.QName("","DeclaredValue").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DeclaredValue" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeclaredValue(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setDeclaredValue(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeliverySheetSrNo").equals(reader.getName()) || new javax.xml.namespace.QName("","DeliverySheetSrNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeliverySheetSrNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Destination").equals(reader.getName()) || new javax.xml.namespace.QName("","Destination").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDestination(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DestinationArea").equals(reader.getName()) || new javax.xml.namespace.QName("","DestinationArea").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DestinationServiceCenter").equals(reader.getName()) || new javax.xml.namespace.QName("","DestinationServiceCenter").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDestinationServiceCenter(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimBreadth").equals(reader.getName()) || new javax.xml.namespace.QName("","DimBreadth").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setDimBreadth(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setDimBreadth(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimHeight").equals(reader.getName()) || new javax.xml.namespace.QName("","DimHeight").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setDimHeight(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setDimHeight(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimLength").equals(reader.getName()) || new javax.xml.namespace.QName("","DimLength").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setDimLength(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setDimLength(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DimPieces").equals(reader.getName()) || new javax.xml.namespace.QName("","DimPieces").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setDimPieces(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setDimPieces(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DutyPaidAmount").equals(reader.getName()) || new javax.xml.namespace.QName("","DutyPaidAmount").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DutyPaidAmount" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDutyPaidAmount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setDutyPaidAmount(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","EDD").equals(reader.getName()) || new javax.xml.namespace.QName("","EDD").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEDD(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","EDL").equals(reader.getName()) || new javax.xml.namespace.QName("","EDL").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEDL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FlightDate").equals(reader.getName()) || new javax.xml.namespace.QName("","FlightDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlightDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FlightDescription").equals(reader.getName()) || new javax.xml.namespace.QName("","FlightDescription").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlightDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FlightNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","FlightNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlightNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FodCodFlag").equals(reader.getName()) || new javax.xml.namespace.QName("","FodCodFlag").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFodCodFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InFleetDate").equals(reader.getName()) || new javax.xml.namespace.QName("","InFleetDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInFleetDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InFleetNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","InFleetNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInFleetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InboundPaperworkTallyDate").equals(reader.getName()) || new javax.xml.namespace.QName("","InboundPaperworkTallyDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInboundPaperworkTallyDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InboundShipmentTallyPiecesCount").equals(reader.getName()) || new javax.xml.namespace.QName("","InboundShipmentTallyPiecesCount").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInboundShipmentTallyPiecesCount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InboundVehicleNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","InboundVehicleNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInboundVehicleNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InscanDateTime").equals(reader.getName()) || new javax.xml.namespace.QName("","InscanDateTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInscanDateTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsCollectDuty").equals(reader.getName()) || new javax.xml.namespace.QName("","IsCollectDuty").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsCollectDuty(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsCreditCardReference").equals(reader.getName()) || new javax.xml.namespace.QName("","IsCreditCardReference").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsCreditCardReference" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsCreditCardReference(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsLastUpdatedByOtm").equals(reader.getName()) || new javax.xml.namespace.QName("","IsLastUpdatedByOtm").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsLastUpdatedByOtm" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsLastUpdatedByOtm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Octroi").equals(reader.getName()) || new javax.xml.namespace.QName("","Octroi").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOctroi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OperationDetailedHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","OperationDetailedHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOperationDetailedHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOperationDetailedHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentDetailedHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OperationHistory").equals(reader.getName()) || new javax.xml.namespace.QName("","OperationHistory").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOperationHistory(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOperationHistory(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfShipmentOperationHistory.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OriginArea").equals(reader.getName()) || new javax.xml.namespace.QName("","OriginArea").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OriginServiceCenter").equals(reader.getName()) || new javax.xml.namespace.QName("","OriginServiceCenter").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOriginServiceCenter(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OutboundVehicleNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","OutboundVehicleNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOutboundVehicleNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PackageType").equals(reader.getName()) || new javax.xml.namespace.QName("","PackageType").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PaperworkDeLinkedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","PaperworkDeLinkedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPaperworkDeLinkedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PaperworkLinkedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","PaperworkLinkedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPaperworkLinkedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ParentContainerID").equals(reader.getName()) || new javax.xml.namespace.QName("","ParentContainerID").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setParentContainerID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PickupDate").equals(reader.getName()) || new javax.xml.namespace.QName("","PickupDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPickupDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PickupEmployeeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","PickupEmployeeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPickupEmployeeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Pieces").equals(reader.getName()) || new javax.xml.namespace.QName("","Pieces").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPieces(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Priority").equals(reader.getName()) || new javax.xml.namespace.QName("","Priority").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPriority(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ProductType").equals(reader.getName()) || new javax.xml.namespace.QName("","ProductType").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RTOAWBRelation").equals(reader.getName()) || new javax.xml.namespace.QName("","RTOAWBRelation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRTOAWBRelation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReceivedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","ReceivedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReceivedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReferenceNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","ReferenceNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReferenceNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Relation").equals(reader.getName()) || new javax.xml.namespace.QName("","Relation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RelationIdDetail").equals(reader.getName()) || new javax.xml.namespace.QName("","RelationIdDetail").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelationIdDetail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Run").equals(reader.getName()) || new javax.xml.namespace.QName("","Run").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRun(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Sender").equals(reader.getName()) || new javax.xml.namespace.QName("","Sender").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSender(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SerialNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","SerialNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSerialNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentDate").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipmentDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipmentDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentDeLinkedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipmentDeLinkedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipmentDeLinkedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentLinkedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipmentLinkedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipmentLinkedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperAddr1").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperAddr1").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperAddr1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperAddr2").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperAddr2").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperAddr2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperAddr3City").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperAddr3City").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperAddr3City(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperCode").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperMobileNo").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperMobileNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperMobileNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperName").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperPhoneNo").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperPhoneNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperPhoneNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperPincode").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperPincode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperPincode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipperSenderAtn").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipperSenderAtn").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipperSenderAtn(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SpecialInstruction").equals(reader.getName()) || new javax.xml.namespace.QName("","SpecialInstruction").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSpecialInstruction(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusCode").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusDescription").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusDescription").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusUpdateDate").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusUpdateDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusUpdateDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusUpdateTime").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusUpdateTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusUpdateTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SubCode").equals(reader.getName()) || new javax.xml.namespace.QName("","SubCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SubProductCode").equals(reader.getName()) || new javax.xml.namespace.QName("","SubProductCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubProductCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Tally").equals(reader.getName()) || new javax.xml.namespace.QName("","Tally").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTally(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","TokenNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","TokenNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTokenNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Weight").equals(reader.getName()) || new javax.xml.namespace.QName("","Weight").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWeight(
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
           
    