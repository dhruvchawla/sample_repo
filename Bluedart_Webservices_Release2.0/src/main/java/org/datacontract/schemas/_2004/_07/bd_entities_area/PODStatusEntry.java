
/**
 * PODStatusEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  PODStatusEntry bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class PODStatusEntry extends org.datacontract.schemas._2004._07.bd_entities_area.AreaEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = PODStatusEntry
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
                        * field for AdditionalDetailsConsigneeName
                        */

                        
                                    protected java.lang.String localAdditionalDetailsConsigneeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdditionalDetailsConsigneeNameTracker = false ;

                           public boolean isAdditionalDetailsConsigneeNameSpecified(){
                               return localAdditionalDetailsConsigneeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAdditionalDetailsConsigneeName(){
                               return localAdditionalDetailsConsigneeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdditionalDetailsConsigneeName
                               */
                               public void setAdditionalDetailsConsigneeName(java.lang.String param){
                            localAdditionalDetailsConsigneeNameTracker = true;
                                   
                                            this.localAdditionalDetailsConsigneeName=param;
                                       

                               }
                            

                        /**
                        * field for BatchNo
                        */

                        
                                    protected java.lang.String localBatchNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBatchNoTracker = false ;

                           public boolean isBatchNoSpecified(){
                               return localBatchNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBatchNo(){
                               return localBatchNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BatchNo
                               */
                               public void setBatchNo(java.lang.String param){
                            localBatchNoTracker = true;
                                   
                                            this.localBatchNo=param;
                                       

                               }
                            

                        /**
                        * field for CommonFields
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryCommonFields localCommonFields ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCommonFieldsTracker = false ;

                           public boolean isCommonFieldsSpecified(){
                               return localCommonFieldsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryCommonFields
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryCommonFields getCommonFields(){
                               return localCommonFields;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CommonFields
                               */
                               public void setCommonFields(org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryCommonFields param){
                            localCommonFieldsTracker = true;
                                   
                                            this.localCommonFields=param;
                                       

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
                        * field for CreditCardShipment
                        */

                        
                                    protected java.lang.String localCreditCardShipment ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCreditCardShipmentTracker = false ;

                           public boolean isCreditCardShipmentSpecified(){
                               return localCreditCardShipmentTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCreditCardShipment(){
                               return localCreditCardShipment;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreditCardShipment
                               */
                               public void setCreditCardShipment(java.lang.String param){
                            localCreditCardShipmentTracker = true;
                                   
                                            this.localCreditCardShipment=param;
                                       

                               }
                            

                        /**
                        * field for DSTATUSDT
                        */

                        
                                    protected java.util.Calendar localDSTATUSDT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDSTATUSDTTracker = false ;

                           public boolean isDSTATUSDTSpecified(){
                               return localDSTATUSDTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDSTATUSDT(){
                               return localDSTATUSDT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DSTATUSDT
                               */
                               public void setDSTATUSDT(java.util.Calendar param){
                            localDSTATUSDTTracker = param != null;
                                   
                                            this.localDSTATUSDT=param;
                                       

                               }
                            

                        /**
                        * field for DeliveryDate
                        */

                        
                                    protected java.util.Calendar localDeliveryDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeliveryDateTracker = false ;

                           public boolean isDeliveryDateSpecified(){
                               return localDeliveryDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDeliveryDate(){
                               return localDeliveryDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeliveryDate
                               */
                               public void setDeliveryDate(java.util.Calendar param){
                            localDeliveryDateTracker = param != null;
                                   
                                            this.localDeliveryDate=param;
                                       

                               }
                            

                        /**
                        * field for DeliveryEmployeeName
                        */

                        
                                    protected java.lang.String localDeliveryEmployeeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeliveryEmployeeNameTracker = false ;

                           public boolean isDeliveryEmployeeNameSpecified(){
                               return localDeliveryEmployeeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeliveryEmployeeName(){
                               return localDeliveryEmployeeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeliveryEmployeeName
                               */
                               public void setDeliveryEmployeeName(java.lang.String param){
                            localDeliveryEmployeeNameTracker = true;
                                   
                                            this.localDeliveryEmployeeName=param;
                                       

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
                        * field for DisplayWarnings
                        */

                        
                                    protected boolean localDisplayWarnings ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDisplayWarningsTracker = false ;

                           public boolean isDisplayWarningsSpecified(){
                               return localDisplayWarningsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getDisplayWarnings(){
                               return localDisplayWarnings;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DisplayWarnings
                               */
                               public void setDisplayWarnings(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localDisplayWarningsTracker =
                                       true;
                                   
                                            this.localDisplayWarnings=param;
                                       

                               }
                            

                        /**
                        * field for Duty
                        */

                        
                                    protected java.lang.String localDuty ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDutyTracker = false ;

                           public boolean isDutySpecified(){
                               return localDutyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDuty(){
                               return localDuty;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Duty
                               */
                               public void setDuty(java.lang.String param){
                            localDutyTracker = true;
                                   
                                            this.localDuty=param;
                                       

                               }
                            

                        /**
                        * field for FODCODFlag
                        */

                        
                                    protected java.lang.String localFODCODFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFODCODFlagTracker = false ;

                           public boolean isFODCODFlagSpecified(){
                               return localFODCODFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFODCODFlag(){
                               return localFODCODFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FODCODFlag
                               */
                               public void setFODCODFlag(java.lang.String param){
                            localFODCODFlagTracker = true;
                                   
                                            this.localFODCODFlag=param;
                                       

                               }
                            

                        /**
                        * field for IdentityGroup
                        */

                        
                                    protected java.lang.String localIdentityGroup ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdentityGroupTracker = false ;

                           public boolean isIdentityGroupSpecified(){
                               return localIdentityGroupTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdentityGroup(){
                               return localIdentityGroup;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentityGroup
                               */
                               public void setIdentityGroup(java.lang.String param){
                            localIdentityGroupTracker = true;
                                   
                                            this.localIdentityGroup=param;
                                       

                               }
                            

                        /**
                        * field for IdentityNumber
                        */

                        
                                    protected java.lang.String localIdentityNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdentityNumberTracker = false ;

                           public boolean isIdentityNumberSpecified(){
                               return localIdentityNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdentityNumber(){
                               return localIdentityNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentityNumber
                               */
                               public void setIdentityNumber(java.lang.String param){
                            localIdentityNumberTracker = true;
                                   
                                            this.localIdentityNumber=param;
                                       

                               }
                            

                        /**
                        * field for IdentityType
                        */

                        
                                    protected java.lang.String localIdentityType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdentityTypeTracker = false ;

                           public boolean isIdentityTypeSpecified(){
                               return localIdentityTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdentityType(){
                               return localIdentityType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentityType
                               */
                               public void setIdentityType(java.lang.String param){
                            localIdentityTypeTracker = true;
                                   
                                            this.localIdentityType=param;
                                       

                               }
                            

                        /**
                        * field for InscanDate
                        */

                        
                                    protected java.util.Calendar localInscanDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInscanDateTracker = false ;

                           public boolean isInscanDateSpecified(){
                               return localInscanDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getInscanDate(){
                               return localInscanDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InscanDate
                               */
                               public void setInscanDate(java.util.Calendar param){
                            localInscanDateTracker = param != null;
                                   
                                            this.localInscanDate=param;
                                       

                               }
                            

                        /**
                        * field for IsClosureStatus
                        */

                        
                                    protected boolean localIsClosureStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsClosureStatusTracker = false ;

                           public boolean isIsClosureStatusSpecified(){
                               return localIsClosureStatusTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsClosureStatus(){
                               return localIsClosureStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsClosureStatus
                               */
                               public void setIsClosureStatus(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsClosureStatusTracker =
                                       true;
                                   
                                            this.localIsClosureStatus=param;
                                       

                               }
                            

                        /**
                        * field for IsCod
                        */

                        
                                    protected boolean localIsCod ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsCodTracker = false ;

                           public boolean isIsCodSpecified(){
                               return localIsCodTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsCod(){
                               return localIsCod;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsCod
                               */
                               public void setIsCod(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsCodTracker =
                                       true;
                                   
                                            this.localIsCod=param;
                                       

                               }
                            

                        /**
                        * field for IsIDCheckRequired
                        */

                        
                                    protected boolean localIsIDCheckRequired ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsIDCheckRequiredTracker = false ;

                           public boolean isIsIDCheckRequiredSpecified(){
                               return localIsIDCheckRequiredTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsIDCheckRequired(){
                               return localIsIDCheckRequired;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsIDCheckRequired
                               */
                               public void setIsIDCheckRequired(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsIDCheckRequiredTracker =
                                       true;
                                   
                                            this.localIsIDCheckRequired=param;
                                       

                               }
                            

                        /**
                        * field for IsLastOutscanned
                        */

                        
                                    protected boolean localIsLastOutscanned ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsLastOutscannedTracker = false ;

                           public boolean isIsLastOutscannedSpecified(){
                               return localIsLastOutscannedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsLastOutscanned(){
                               return localIsLastOutscanned;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsLastOutscanned
                               */
                               public void setIsLastOutscanned(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsLastOutscannedTracker =
                                       true;
                                   
                                            this.localIsLastOutscanned=param;
                                       

                               }
                            

                        /**
                        * field for IsOTMDelivery
                        */

                        
                                    protected boolean localIsOTMDelivery ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsOTMDeliveryTracker = false ;

                           public boolean isIsOTMDeliverySpecified(){
                               return localIsOTMDeliveryTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsOTMDelivery(){
                               return localIsOTMDelivery;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsOTMDelivery
                               */
                               public void setIsOTMDelivery(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsOTMDeliveryTracker =
                                       true;
                                   
                                            this.localIsOTMDelivery=param;
                                       

                               }
                            

                        /**
                        * field for LocationDetail
                        */

                        
                                    protected java.lang.String localLocationDetail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLocationDetailTracker = false ;

                           public boolean isLocationDetailSpecified(){
                               return localLocationDetailTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLocationDetail(){
                               return localLocationDetail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LocationDetail
                               */
                               public void setLocationDetail(java.lang.String param){
                            localLocationDetailTracker = true;
                                   
                                            this.localLocationDetail=param;
                                       

                               }
                            

                        /**
                        * field for LoggerType
                        */

                        
                                    protected java.lang.String localLoggerType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLoggerTypeTracker = false ;

                           public boolean isLoggerTypeSpecified(){
                               return localLoggerTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLoggerType(){
                               return localLoggerType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LoggerType
                               */
                               public void setLoggerType(java.lang.String param){
                            localLoggerTypeTracker = true;
                                   
                                            this.localLoggerType=param;
                                       

                               }
                            

                        /**
                        * field for MobileNumber
                        */

                        
                                    protected java.lang.String localMobileNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMobileNumberTracker = false ;

                           public boolean isMobileNumberSpecified(){
                               return localMobileNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMobileNumber(){
                               return localMobileNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MobileNumber
                               */
                               public void setMobileNumber(java.lang.String param){
                            localMobileNumberTracker = true;
                                   
                                            this.localMobileNumber=param;
                                       

                               }
                            

                        /**
                        * field for Mode
                        */

                        
                                    protected java.lang.String localMode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localModeTracker = false ;

                           public boolean isModeSpecified(){
                               return localModeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMode(){
                               return localMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mode
                               */
                               public void setMode(java.lang.String param){
                            localModeTracker = true;
                                   
                                            this.localMode=param;
                                       

                               }
                            

                        /**
                        * field for NewAWBNumber
                        */

                        
                                    protected java.lang.String localNewAWBNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewAWBNumberTracker = false ;

                           public boolean isNewAWBNumberSpecified(){
                               return localNewAWBNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNewAWBNumber(){
                               return localNewAWBNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewAWBNumber
                               */
                               public void setNewAWBNumber(java.lang.String param){
                            localNewAWBNumberTracker = true;
                                   
                                            this.localNewAWBNumber=param;
                                       

                               }
                            

                        /**
                        * field for NewDestination
                        */

                        
                                    protected java.lang.String localNewDestination ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewDestinationTracker = false ;

                           public boolean isNewDestinationSpecified(){
                               return localNewDestinationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNewDestination(){
                               return localNewDestination;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewDestination
                               */
                               public void setNewDestination(java.lang.String param){
                            localNewDestinationTracker = true;
                                   
                                            this.localNewDestination=param;
                                       

                               }
                            

                        /**
                        * field for NumberOfDCs
                        */

                        
                                    protected java.lang.String localNumberOfDCs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNumberOfDCsTracker = false ;

                           public boolean isNumberOfDCsSpecified(){
                               return localNumberOfDCsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNumberOfDCs(){
                               return localNumberOfDCs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NumberOfDCs
                               */
                               public void setNumberOfDCs(java.lang.String param){
                            localNumberOfDCsTracker = true;
                                   
                                            this.localNumberOfDCs=param;
                                       

                               }
                            

                        /**
                        * field for NumberOfDaysForSOP
                        */

                        
                                    protected java.lang.String localNumberOfDaysForSOP ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNumberOfDaysForSOPTracker = false ;

                           public boolean isNumberOfDaysForSOPSpecified(){
                               return localNumberOfDaysForSOPTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNumberOfDaysForSOP(){
                               return localNumberOfDaysForSOP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NumberOfDaysForSOP
                               */
                               public void setNumberOfDaysForSOP(java.lang.String param){
                            localNumberOfDaysForSOPTracker = true;
                                   
                                            this.localNumberOfDaysForSOP=param;
                                       

                               }
                            

                        /**
                        * field for OctroiConeeName
                        */

                        
                                    protected java.lang.String localOctroiConeeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiConeeNameTracker = false ;

                           public boolean isOctroiConeeNameSpecified(){
                               return localOctroiConeeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOctroiConeeName(){
                               return localOctroiConeeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OctroiConeeName
                               */
                               public void setOctroiConeeName(java.lang.String param){
                            localOctroiConeeNameTracker = true;
                                   
                                            this.localOctroiConeeName=param;
                                       

                               }
                            

                        /**
                        * field for OctroiDuty
                        */

                        
                                    protected java.lang.String localOctroiDuty ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiDutyTracker = false ;

                           public boolean isOctroiDutySpecified(){
                               return localOctroiDutyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOctroiDuty(){
                               return localOctroiDuty;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OctroiDuty
                               */
                               public void setOctroiDuty(java.lang.String param){
                            localOctroiDutyTracker = true;
                                   
                                            this.localOctroiDuty=param;
                                       

                               }
                            

                        /**
                        * field for OctroiMobileNo
                        */

                        
                                    protected java.lang.String localOctroiMobileNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiMobileNoTracker = false ;

                           public boolean isOctroiMobileNoSpecified(){
                               return localOctroiMobileNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOctroiMobileNo(){
                               return localOctroiMobileNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OctroiMobileNo
                               */
                               public void setOctroiMobileNo(java.lang.String param){
                            localOctroiMobileNoTracker = true;
                                   
                                            this.localOctroiMobileNo=param;
                                       

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
                        * field for OutscanDate
                        */

                        
                                    protected java.util.Calendar localOutscanDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOutscanDateTracker = false ;

                           public boolean isOutscanDateSpecified(){
                               return localOutscanDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getOutscanDate(){
                               return localOutscanDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OutscanDate
                               */
                               public void setOutscanDate(java.util.Calendar param){
                            localOutscanDateTracker = param != null;
                                   
                                            this.localOutscanDate=param;
                                       

                               }
                            

                        /**
                        * field for PODEDDDate
                        */

                        
                                    protected java.util.Calendar localPODEDDDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEDDDateTracker = false ;

                           public boolean isPODEDDDateSpecified(){
                               return localPODEDDDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getPODEDDDate(){
                               return localPODEDDDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEDDDate
                               */
                               public void setPODEDDDate(java.util.Calendar param){
                            localPODEDDDateTracker = param != null;
                                   
                                            this.localPODEDDDate=param;
                                       

                               }
                            

                        /**
                        * field for PODEntDate
                        */

                        
                                    protected java.util.Calendar localPODEntDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEntDateTracker = false ;

                           public boolean isPODEntDateSpecified(){
                               return localPODEntDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getPODEntDate(){
                               return localPODEntDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEntDate
                               */
                               public void setPODEntDate(java.util.Calendar param){
                            localPODEntDateTracker = param != null;
                                   
                                            this.localPODEntDate=param;
                                       

                               }
                            

                        /**
                        * field for PODEntTime
                        */

                        
                                    protected java.lang.String localPODEntTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEntTimeTracker = false ;

                           public boolean isPODEntTimeSpecified(){
                               return localPODEntTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPODEntTime(){
                               return localPODEntTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEntTime
                               */
                               public void setPODEntTime(java.lang.String param){
                            localPODEntTimeTracker = true;
                                   
                                            this.localPODEntTime=param;
                                       

                               }
                            

                        /**
                        * field for PODEntryDate
                        */

                        
                                    protected java.util.Calendar localPODEntryDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEntryDateTracker = false ;

                           public boolean isPODEntryDateSpecified(){
                               return localPODEntryDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getPODEntryDate(){
                               return localPODEntryDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEntryDate
                               */
                               public void setPODEntryDate(java.util.Calendar param){
                            localPODEntryDateTracker = param != null;
                                   
                                            this.localPODEntryDate=param;
                                       

                               }
                            

                        /**
                        * field for PODEntryEmployeeCode
                        */

                        
                                    protected java.lang.String localPODEntryEmployeeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEntryEmployeeCodeTracker = false ;

                           public boolean isPODEntryEmployeeCodeSpecified(){
                               return localPODEntryEmployeeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPODEntryEmployeeCode(){
                               return localPODEntryEmployeeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEntryEmployeeCode
                               */
                               public void setPODEntryEmployeeCode(java.lang.String param){
                            localPODEntryEmployeeCodeTracker = true;
                                   
                                            this.localPODEntryEmployeeCode=param;
                                       

                               }
                            

                        /**
                        * field for PODEntryEmployeeName
                        */

                        
                                    protected java.lang.String localPODEntryEmployeeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPODEntryEmployeeNameTracker = false ;

                           public boolean isPODEntryEmployeeNameSpecified(){
                               return localPODEntryEmployeeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPODEntryEmployeeName(){
                               return localPODEntryEmployeeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PODEntryEmployeeName
                               */
                               public void setPODEntryEmployeeName(java.lang.String param){
                            localPODEntryEmployeeNameTracker = true;
                                   
                                            this.localPODEntryEmployeeName=param;
                                       

                               }
                            

                        /**
                        * field for PSCODE
                        */

                        
                                    protected java.lang.String localPSCODE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPSCODETracker = false ;

                           public boolean isPSCODESpecified(){
                               return localPSCODETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPSCODE(){
                               return localPSCODE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PSCODE
                               */
                               public void setPSCODE(java.lang.String param){
                            localPSCODETracker = true;
                                   
                                            this.localPSCODE=param;
                                       

                               }
                            

                        /**
                        * field for ParcelShopPhoneNumber
                        */

                        
                                    protected java.lang.String localParcelShopPhoneNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParcelShopPhoneNumberTracker = false ;

                           public boolean isParcelShopPhoneNumberSpecified(){
                               return localParcelShopPhoneNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getParcelShopPhoneNumber(){
                               return localParcelShopPhoneNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ParcelShopPhoneNumber
                               */
                               public void setParcelShopPhoneNumber(java.lang.String param){
                            localParcelShopPhoneNumberTracker = true;
                                   
                                            this.localParcelShopPhoneNumber=param;
                                       

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
                            localPickupDateTracker = param != null;
                                   
                                            this.localPickupDate=param;
                                       

                               }
                            

                        /**
                        * field for PickupTime
                        */

                        
                                    protected java.lang.String localPickupTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPickupTimeTracker = false ;

                           public boolean isPickupTimeSpecified(){
                               return localPickupTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPickupTime(){
                               return localPickupTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PickupTime
                               */
                               public void setPickupTime(java.lang.String param){
                            localPickupTimeTracker = true;
                                   
                                            this.localPickupTime=param;
                                       

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
                        * field for Pincode
                        */

                        
                                    protected java.lang.String localPincode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPincodeTracker = false ;

                           public boolean isPincodeSpecified(){
                               return localPincodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPincode(){
                               return localPincode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pincode
                               */
                               public void setPincode(java.lang.String param){
                            localPincodeTracker = true;
                                   
                                            this.localPincode=param;
                                       

                               }
                            

                        /**
                        * field for PreviousStatusGroup
                        */

                        
                                    protected java.lang.String localPreviousStatusGroup ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPreviousStatusGroupTracker = false ;

                           public boolean isPreviousStatusGroupSpecified(){
                               return localPreviousStatusGroupTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPreviousStatusGroup(){
                               return localPreviousStatusGroup;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PreviousStatusGroup
                               */
                               public void setPreviousStatusGroup(java.lang.String param){
                            localPreviousStatusGroupTracker = true;
                                   
                                            this.localPreviousStatusGroup=param;
                                       

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
                        * field for RecievedBy
                        */

                        
                                    protected java.lang.String localRecievedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecievedByTracker = false ;

                           public boolean isRecievedBySpecified(){
                               return localRecievedByTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRecievedBy(){
                               return localRecievedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecievedBy
                               */
                               public void setRecievedBy(java.lang.String param){
                            localRecievedByTracker = true;
                                   
                                            this.localRecievedBy=param;
                                       

                               }
                            

                        /**
                        * field for RelationCode
                        */

                        
                                    protected java.lang.String localRelationCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRelationCodeTracker = false ;

                           public boolean isRelationCodeSpecified(){
                               return localRelationCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelationCode(){
                               return localRelationCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RelationCode
                               */
                               public void setRelationCode(java.lang.String param){
                            localRelationCodeTracker = true;
                                   
                                            this.localRelationCode=param;
                                       

                               }
                            

                        /**
                        * field for RelationDescription
                        */

                        
                                    protected java.lang.String localRelationDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRelationDescriptionTracker = false ;

                           public boolean isRelationDescriptionSpecified(){
                               return localRelationDescriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelationDescription(){
                               return localRelationDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RelationDescription
                               */
                               public void setRelationDescription(java.lang.String param){
                            localRelationDescriptionTracker = true;
                                   
                                            this.localRelationDescription=param;
                                       

                               }
                            

                        /**
                        * field for RelationGroup
                        */

                        
                                    protected java.lang.String localRelationGroup ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRelationGroupTracker = false ;

                           public boolean isRelationGroupSpecified(){
                               return localRelationGroupTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelationGroup(){
                               return localRelationGroup;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RelationGroup
                               */
                               public void setRelationGroup(java.lang.String param){
                            localRelationGroupTracker = true;
                                   
                                            this.localRelationGroup=param;
                                       

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
                        * field for ServiceCenterPhoneNumber
                        */

                        
                                    protected java.lang.String localServiceCenterPhoneNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localServiceCenterPhoneNumberTracker = false ;

                           public boolean isServiceCenterPhoneNumberSpecified(){
                               return localServiceCenterPhoneNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getServiceCenterPhoneNumber(){
                               return localServiceCenterPhoneNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ServiceCenterPhoneNumber
                               */
                               public void setServiceCenterPhoneNumber(java.lang.String param){
                            localServiceCenterPhoneNumberTracker = true;
                                   
                                            this.localServiceCenterPhoneNumber=param;
                                       

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
                        * field for SorryAlternateInstruction
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSorryCardAlternateInstruction localSorryAlternateInstruction ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSorryAlternateInstructionTracker = false ;

                           public boolean isSorryAlternateInstructionSpecified(){
                               return localSorryAlternateInstructionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSorryCardAlternateInstruction
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSorryCardAlternateInstruction getSorryAlternateInstruction(){
                               return localSorryAlternateInstruction;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SorryAlternateInstruction
                               */
                               public void setSorryAlternateInstruction(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSorryCardAlternateInstruction param){
                            localSorryAlternateInstructionTracker = true;
                                   
                                            this.localSorryAlternateInstruction=param;
                                       

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
                        * field for StatusEntryTime
                        */

                        
                                    protected java.lang.String localStatusEntryTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusEntryTimeTracker = false ;

                           public boolean isStatusEntryTimeSpecified(){
                               return localStatusEntryTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusEntryTime(){
                               return localStatusEntryTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusEntryTime
                               */
                               public void setStatusEntryTime(java.lang.String param){
                            localStatusEntryTimeTracker = true;
                                   
                                            this.localStatusEntryTime=param;
                                       

                               }
                            

                        /**
                        * field for StatusGroup
                        */

                        
                                    protected java.lang.String localStatusGroup ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusGroupTracker = false ;

                           public boolean isStatusGroupSpecified(){
                               return localStatusGroupTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusGroup(){
                               return localStatusGroup;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusGroup
                               */
                               public void setStatusGroup(java.lang.String param){
                            localStatusGroupTracker = true;
                                   
                                            this.localStatusGroup=param;
                                       

                               }
                            

                        /**
                        * field for StatusType
                        */

                        
                                    protected java.lang.String localStatusType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusTypeTracker = false ;

                           public boolean isStatusTypeSpecified(){
                               return localStatusTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusType(){
                               return localStatusType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusType
                               */
                               public void setStatusType(java.lang.String param){
                            localStatusTypeTracker = true;
                                   
                                            this.localStatusType=param;
                                       

                               }
                            

                        /**
                        * field for ThermalPrinterName
                        */

                        
                                    protected java.lang.String localThermalPrinterName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localThermalPrinterNameTracker = false ;

                           public boolean isThermalPrinterNameSpecified(){
                               return localThermalPrinterNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getThermalPrinterName(){
                               return localThermalPrinterName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ThermalPrinterName
                               */
                               public void setThermalPrinterName(java.lang.String param){
                            localThermalPrinterNameTracker = true;
                                   
                                            this.localThermalPrinterName=param;
                                       

                               }
                            

                        /**
                        * field for ThermalPrinterSize
                        */

                        
                                    protected java.lang.String localThermalPrinterSize ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localThermalPrinterSizeTracker = false ;

                           public boolean isThermalPrinterSizeSpecified(){
                               return localThermalPrinterSizeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getThermalPrinterSize(){
                               return localThermalPrinterSize;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ThermalPrinterSize
                               */
                               public void setThermalPrinterSize(java.lang.String param){
                            localThermalPrinterSizeTracker = true;
                                   
                                            this.localThermalPrinterSize=param;
                                       

                               }
                            

                        /**
                        * field for ThermalPrinterType
                        */

                        
                                    protected java.lang.String localThermalPrinterType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localThermalPrinterTypeTracker = false ;

                           public boolean isThermalPrinterTypeSpecified(){
                               return localThermalPrinterTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getThermalPrinterType(){
                               return localThermalPrinterType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ThermalPrinterType
                               */
                               public void setThermalPrinterType(java.lang.String param){
                            localThermalPrinterTypeTracker = true;
                                   
                                            this.localThermalPrinterType=param;
                                       

                               }
                            

                        /**
                        * field for ToDestinationArea
                        */

                        
                                    protected java.lang.String localToDestinationArea ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localToDestinationAreaTracker = false ;

                           public boolean isToDestinationAreaSpecified(){
                               return localToDestinationAreaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getToDestinationArea(){
                               return localToDestinationArea;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ToDestinationArea
                               */
                               public void setToDestinationArea(java.lang.String param){
                            localToDestinationAreaTracker = true;
                                   
                                            this.localToDestinationArea=param;
                                       

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
                           namespacePrefix+":PODStatusEntry",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "PODStatusEntry",
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
                             } if (localAdditionalDetailsConsigneeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "AdditionalDetailsConsigneeName", xmlWriter);
                             

                                          if (localAdditionalDetailsConsigneeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAdditionalDetailsConsigneeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBatchNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BatchNo", xmlWriter);
                             

                                          if (localBatchNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBatchNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommonFieldsTracker){
                                    if (localCommonFields==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "CommonFields", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCommonFields.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CommonFields"),
                                        xmlWriter);
                                    }
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
                             } if (localCreditCardShipmentTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CreditCardShipment", xmlWriter);
                             

                                          if (localCreditCardShipment==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCreditCardShipment);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDSTATUSDTTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DSTATUSDT", xmlWriter);
                             

                                          if (localDSTATUSDT==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DSTATUSDT cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDSTATUSDT));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeliveryDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeliveryDate", xmlWriter);
                             

                                          if (localDeliveryDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DeliveryDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeliveryDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeliveryEmployeeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeliveryEmployeeName", xmlWriter);
                             

                                          if (localDeliveryEmployeeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeliveryEmployeeName);
                                            
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
                             } if (localDisplayWarningsTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DisplayWarnings", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DisplayWarnings cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDisplayWarnings));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDutyTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Duty", xmlWriter);
                             

                                          if (localDuty==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDuty);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFODCODFlagTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FODCODFlag", xmlWriter);
                             

                                          if (localFODCODFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFODCODFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIdentityGroupTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IdentityGroup", xmlWriter);
                             

                                          if (localIdentityGroup==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdentityGroup);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIdentityNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IdentityNumber", xmlWriter);
                             

                                          if (localIdentityNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdentityNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIdentityTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IdentityType", xmlWriter);
                             

                                          if (localIdentityType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdentityType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInscanDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "InscanDate", xmlWriter);
                             

                                          if (localInscanDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("InscanDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInscanDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsClosureStatusTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsClosureStatus", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsClosureStatus cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsClosureStatus));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsCodTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsCod", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsCod cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsCod));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsIDCheckRequiredTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsIDCheckRequired", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsIDCheckRequired cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsIDCheckRequired));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsLastOutscannedTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsLastOutscanned", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsLastOutscanned cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsLastOutscanned));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsOTMDeliveryTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsOTMDelivery", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsOTMDelivery cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOTMDelivery));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLocationDetailTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LocationDetail", xmlWriter);
                             

                                          if (localLocationDetail==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocationDetail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLoggerTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LoggerType", xmlWriter);
                             

                                          if (localLoggerType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLoggerType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMobileNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "MobileNumber", xmlWriter);
                             

                                          if (localMobileNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMobileNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localModeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Mode", xmlWriter);
                             

                                          if (localMode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewAWBNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NewAWBNumber", xmlWriter);
                             

                                          if (localNewAWBNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNewAWBNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewDestinationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NewDestination", xmlWriter);
                             

                                          if (localNewDestination==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNewDestination);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNumberOfDCsTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NumberOfDCs", xmlWriter);
                             

                                          if (localNumberOfDCs==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNumberOfDCs);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNumberOfDaysForSOPTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NumberOfDaysForSOP", xmlWriter);
                             

                                          if (localNumberOfDaysForSOP==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNumberOfDaysForSOP);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOctroiConeeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OctroiConeeName", xmlWriter);
                             

                                          if (localOctroiConeeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOctroiConeeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOctroiDutyTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OctroiDuty", xmlWriter);
                             

                                          if (localOctroiDuty==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOctroiDuty);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOctroiMobileNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OctroiMobileNo", xmlWriter);
                             

                                          if (localOctroiMobileNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOctroiMobileNo);
                                            
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
                             } if (localOutscanDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OutscanDate", xmlWriter);
                             

                                          if (localOutscanDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OutscanDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOutscanDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEDDDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEDDDate", xmlWriter);
                             

                                          if (localPODEDDDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PODEDDDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPODEDDDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEntDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEntDate", xmlWriter);
                             

                                          if (localPODEntDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PODEntDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPODEntDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEntTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEntTime", xmlWriter);
                             

                                          if (localPODEntTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPODEntTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEntryDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEntryDate", xmlWriter);
                             

                                          if (localPODEntryDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PODEntryDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPODEntryDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEntryEmployeeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEntryEmployeeCode", xmlWriter);
                             

                                          if (localPODEntryEmployeeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPODEntryEmployeeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPODEntryEmployeeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PODEntryEmployeeName", xmlWriter);
                             

                                          if (localPODEntryEmployeeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPODEntryEmployeeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPSCODETracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PSCODE", xmlWriter);
                             

                                          if (localPSCODE==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPSCODE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localParcelShopPhoneNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ParcelShopPhoneNumber", xmlWriter);
                             

                                          if (localParcelShopPhoneNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localParcelShopPhoneNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPickupDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PickupDate", xmlWriter);
                             

                                          if (localPickupDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PickupDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPickupDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPickupTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PickupTime", xmlWriter);
                             

                                          if (localPickupTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPickupTime);
                                            
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
                             } if (localPincodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Pincode", xmlWriter);
                             

                                          if (localPincode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPincode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPreviousStatusGroupTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PreviousStatusGroup", xmlWriter);
                             

                                          if (localPreviousStatusGroup==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPreviousStatusGroup);
                                            
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
                             } if (localRecievedByTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RecievedBy", xmlWriter);
                             

                                          if (localRecievedBy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRecievedBy);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRelationCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RelationCode", xmlWriter);
                             

                                          if (localRelationCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelationCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRelationDescriptionTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RelationDescription", xmlWriter);
                             

                                          if (localRelationDescription==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelationDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRelationGroupTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RelationGroup", xmlWriter);
                             

                                          if (localRelationGroup==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelationGroup);
                                            
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
                             } if (localServiceCenterPhoneNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ServiceCenterPhoneNumber", xmlWriter);
                             

                                          if (localServiceCenterPhoneNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localServiceCenterPhoneNumber);
                                            
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
                             } if (localSorryAlternateInstructionTracker){
                                    if (localSorryAlternateInstruction==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "SorryAlternateInstruction", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localSorryAlternateInstruction.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SorryAlternateInstruction"),
                                        xmlWriter);
                                    }
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
                             } if (localStatusEntryTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusEntryTime", xmlWriter);
                             

                                          if (localStatusEntryTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusEntryTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusGroupTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusGroup", xmlWriter);
                             

                                          if (localStatusGroup==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusGroup);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusType", xmlWriter);
                             

                                          if (localStatusType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localThermalPrinterNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ThermalPrinterName", xmlWriter);
                             

                                          if (localThermalPrinterName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localThermalPrinterName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localThermalPrinterSizeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ThermalPrinterSize", xmlWriter);
                             

                                          if (localThermalPrinterSize==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localThermalPrinterSize);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localThermalPrinterTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ThermalPrinterType", xmlWriter);
                             

                                          if (localThermalPrinterType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localThermalPrinterType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localToDestinationAreaTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ToDestinationArea", xmlWriter);
                             

                                          if (localToDestinationArea==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localToDestinationArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTransactionCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "TransactionCode", xmlWriter);
                             

                                          if (localTransactionCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTransactionCode);
                                            
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
        public static PODStatusEntry parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            PODStatusEntry object =
                new PODStatusEntry();

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
                    
                            if (!"PODStatusEntry".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (PODStatusEntry)org.tempuri.imports.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","AdditionalDetailsConsigneeName").equals(reader.getName()) || new javax.xml.namespace.QName("","AdditionalDetailsConsigneeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAdditionalDetailsConsigneeName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BatchNo").equals(reader.getName()) || new javax.xml.namespace.QName("","BatchNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBatchNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CommonFields").equals(reader.getName()) || new javax.xml.namespace.QName("","CommonFields").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCommonFields(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCommonFields(org.datacontract.schemas._2004._07.bd_entities_area.PODStatusEntryCommonFields.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CreditCardShipment").equals(reader.getName()) || new javax.xml.namespace.QName("","CreditCardShipment").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCreditCardShipment(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DSTATUSDT").equals(reader.getName()) || new javax.xml.namespace.QName("","DSTATUSDT").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DSTATUSDT" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDSTATUSDT(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeliveryDate").equals(reader.getName()) || new javax.xml.namespace.QName("","DeliveryDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DeliveryDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeliveryDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeliveryEmployeeName").equals(reader.getName()) || new javax.xml.namespace.QName("","DeliveryEmployeeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeliveryEmployeeName(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DisplayWarnings").equals(reader.getName()) || new javax.xml.namespace.QName("","DisplayWarnings").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"DisplayWarnings" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDisplayWarnings(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Duty").equals(reader.getName()) || new javax.xml.namespace.QName("","Duty").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDuty(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FODCODFlag").equals(reader.getName()) || new javax.xml.namespace.QName("","FODCODFlag").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFODCODFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IdentityGroup").equals(reader.getName()) || new javax.xml.namespace.QName("","IdentityGroup").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdentityGroup(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IdentityNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","IdentityNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdentityNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IdentityType").equals(reader.getName()) || new javax.xml.namespace.QName("","IdentityType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdentityType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","InscanDate").equals(reader.getName()) || new javax.xml.namespace.QName("","InscanDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"InscanDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInscanDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsClosureStatus").equals(reader.getName()) || new javax.xml.namespace.QName("","IsClosureStatus").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsClosureStatus" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsClosureStatus(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsCod").equals(reader.getName()) || new javax.xml.namespace.QName("","IsCod").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsCod" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsCod(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsIDCheckRequired").equals(reader.getName()) || new javax.xml.namespace.QName("","IsIDCheckRequired").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsIDCheckRequired" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsIDCheckRequired(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsLastOutscanned").equals(reader.getName()) || new javax.xml.namespace.QName("","IsLastOutscanned").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsLastOutscanned" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsLastOutscanned(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsOTMDelivery").equals(reader.getName()) || new javax.xml.namespace.QName("","IsOTMDelivery").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsOTMDelivery" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsOTMDelivery(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LocationDetail").equals(reader.getName()) || new javax.xml.namespace.QName("","LocationDetail").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocationDetail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LoggerType").equals(reader.getName()) || new javax.xml.namespace.QName("","LoggerType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLoggerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","MobileNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","MobileNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMobileNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Mode").equals(reader.getName()) || new javax.xml.namespace.QName("","Mode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NewAWBNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","NewAWBNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewAWBNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NewDestination").equals(reader.getName()) || new javax.xml.namespace.QName("","NewDestination").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewDestination(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NumberOfDCs").equals(reader.getName()) || new javax.xml.namespace.QName("","NumberOfDCs").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNumberOfDCs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NumberOfDaysForSOP").equals(reader.getName()) || new javax.xml.namespace.QName("","NumberOfDaysForSOP").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNumberOfDaysForSOP(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiConeeName").equals(reader.getName()) || new javax.xml.namespace.QName("","OctroiConeeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOctroiConeeName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiDuty").equals(reader.getName()) || new javax.xml.namespace.QName("","OctroiDuty").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOctroiDuty(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiMobileNo").equals(reader.getName()) || new javax.xml.namespace.QName("","OctroiMobileNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOctroiMobileNo(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OutscanDate").equals(reader.getName()) || new javax.xml.namespace.QName("","OutscanDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"OutscanDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOutscanDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEDDDate").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEDDDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PODEDDDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEDDDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEntDate").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEntDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PODEntDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEntDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEntTime").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEntTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEntTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEntryDate").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEntryDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PODEntryDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEntryDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEntryEmployeeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEntryEmployeeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEntryEmployeeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PODEntryEmployeeName").equals(reader.getName()) || new javax.xml.namespace.QName("","PODEntryEmployeeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPODEntryEmployeeName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PSCODE").equals(reader.getName()) || new javax.xml.namespace.QName("","PSCODE").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPSCODE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ParcelShopPhoneNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","ParcelShopPhoneNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setParcelShopPhoneNumber(
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
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"PickupDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPickupDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PickupTime").equals(reader.getName()) || new javax.xml.namespace.QName("","PickupTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPickupTime(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Pincode").equals(reader.getName()) || new javax.xml.namespace.QName("","Pincode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPincode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PreviousStatusGroup").equals(reader.getName()) || new javax.xml.namespace.QName("","PreviousStatusGroup").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPreviousStatusGroup(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RecievedBy").equals(reader.getName()) || new javax.xml.namespace.QName("","RecievedBy").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecievedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RelationCode").equals(reader.getName()) || new javax.xml.namespace.QName("","RelationCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelationCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RelationDescription").equals(reader.getName()) || new javax.xml.namespace.QName("","RelationDescription").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelationDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RelationGroup").equals(reader.getName()) || new javax.xml.namespace.QName("","RelationGroup").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelationGroup(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ServiceCenterPhoneNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","ServiceCenterPhoneNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setServiceCenterPhoneNumber(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SorryAlternateInstruction").equals(reader.getName()) || new javax.xml.namespace.QName("","SorryAlternateInstruction").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setSorryAlternateInstruction(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setSorryAlternateInstruction(org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfSorryCardAlternateInstruction.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusEntryTime").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusEntryTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusEntryTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusGroup").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusGroup").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusGroup(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusType").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ThermalPrinterName").equals(reader.getName()) || new javax.xml.namespace.QName("","ThermalPrinterName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setThermalPrinterName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ThermalPrinterSize").equals(reader.getName()) || new javax.xml.namespace.QName("","ThermalPrinterSize").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setThermalPrinterSize(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ThermalPrinterType").equals(reader.getName()) || new javax.xml.namespace.QName("","ThermalPrinterType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setThermalPrinterType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ToDestinationArea").equals(reader.getName()) || new javax.xml.namespace.QName("","ToDestinationArea").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setToDestinationArea(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","TransactionCode").equals(reader.getName()) || new javax.xml.namespace.QName("","TransactionCode").equals(reader.getName()) ){
                                
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
           
    