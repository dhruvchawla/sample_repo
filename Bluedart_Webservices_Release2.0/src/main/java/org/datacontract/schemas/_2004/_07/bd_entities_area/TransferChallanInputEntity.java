
/**
 * TransferChallanInputEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  TransferChallanInputEntity bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class TransferChallanInputEntity extends org.datacontract.schemas._2004._07.bd_entities_area.AreaEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = TransferChallanInputEntity
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Area
                Namespace Prefix = ns10
                */
            

                        /**
                        * field for ATD
                        */

                        
                                    protected java.lang.String localATD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localATDTracker = false ;

                           public boolean isATDSpecified(){
                               return localATDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getATD(){
                               return localATD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ATD
                               */
                               public void setATD(java.lang.String param){
                            localATDTracker = true;
                                   
                                            this.localATD=param;
                                       

                               }
                            

                        /**
                        * field for ContractorCode
                        */

                        
                                    protected java.lang.String localContractorCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContractorCodeTracker = false ;

                           public boolean isContractorCodeSpecified(){
                               return localContractorCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContractorCode(){
                               return localContractorCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContractorCode
                               */
                               public void setContractorCode(java.lang.String param){
                            localContractorCodeTracker = true;
                                   
                                            this.localContractorCode=param;
                                       

                               }
                            

                        /**
                        * field for ContractorName
                        */

                        
                                    protected java.lang.String localContractorName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContractorNameTracker = false ;

                           public boolean isContractorNameSpecified(){
                               return localContractorNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContractorName(){
                               return localContractorName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContractorName
                               */
                               public void setContractorName(java.lang.String param){
                            localContractorNameTracker = true;
                                   
                                            this.localContractorName=param;
                                       

                               }
                            

                        /**
                        * field for DocumentNo
                        */

                        
                                    protected java.lang.String localDocumentNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocumentNoTracker = false ;

                           public boolean isDocumentNoSpecified(){
                               return localDocumentNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDocumentNo(){
                               return localDocumentNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DocumentNo
                               */
                               public void setDocumentNo(java.lang.String param){
                            localDocumentNoTracker = true;
                                   
                                            this.localDocumentNo=param;
                                       

                               }
                            

                        /**
                        * field for DriverName
                        */

                        
                                    protected java.lang.String localDriverName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDriverNameTracker = false ;

                           public boolean isDriverNameSpecified(){
                               return localDriverNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDriverName(){
                               return localDriverName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DriverName
                               */
                               public void setDriverName(java.lang.String param){
                            localDriverNameTracker = true;
                                   
                                            this.localDriverName=param;
                                       

                               }
                            

                        /**
                        * field for EmployeeCode
                        */

                        
                                    protected java.lang.String localEmployeeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmployeeCodeTracker = false ;

                           public boolean isEmployeeCodeSpecified(){
                               return localEmployeeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmployeeCode(){
                               return localEmployeeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EmployeeCode
                               */
                               public void setEmployeeCode(java.lang.String param){
                            localEmployeeCodeTracker = true;
                                   
                                            this.localEmployeeCode=param;
                                       

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
                        * field for FleetNumber
                        */

                        
                                    protected java.lang.String localFleetNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFleetNumberTracker = false ;

                           public boolean isFleetNumberSpecified(){
                               return localFleetNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFleetNumber(){
                               return localFleetNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FleetNumber
                               */
                               public void setFleetNumber(java.lang.String param){
                            localFleetNumberTracker = true;
                                   
                                            this.localFleetNumber=param;
                                       

                               }
                            

                        /**
                        * field for GPSDeviceID
                        */

                        
                                    protected java.lang.String localGPSDeviceID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGPSDeviceIDTracker = false ;

                           public boolean isGPSDeviceIDSpecified(){
                               return localGPSDeviceIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGPSDeviceID(){
                               return localGPSDeviceID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GPSDeviceID
                               */
                               public void setGPSDeviceID(java.lang.String param){
                            localGPSDeviceIDTracker = true;
                                   
                                            this.localGPSDeviceID=param;
                                       

                               }
                            

                        /**
                        * field for ISAIRONTRAIN
                        */

                        
                                    protected boolean localISAIRONTRAIN ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localISAIRONTRAINTracker = false ;

                           public boolean isISAIRONTRAINSpecified(){
                               return localISAIRONTRAINTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getISAIRONTRAIN(){
                               return localISAIRONTRAIN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ISAIRONTRAIN
                               */
                               public void setISAIRONTRAIN(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localISAIRONTRAINTracker =
                                       true;
                                   
                                            this.localISAIRONTRAIN=param;
                                       

                               }
                            

                        /**
                        * field for ISCCMRCIAL
                        */

                        
                                    protected java.lang.String localISCCMRCIAL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localISCCMRCIALTracker = false ;

                           public boolean isISCCMRCIALSpecified(){
                               return localISCCMRCIALTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getISCCMRCIAL(){
                               return localISCCMRCIAL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ISCCMRCIAL
                               */
                               public void setISCCMRCIAL(java.lang.String param){
                            localISCCMRCIALTracker = true;
                                   
                                            this.localISCCMRCIAL=param;
                                       

                               }
                            

                        /**
                        * field for IsApexSurfaceRun
                        */

                        
                                    protected boolean localIsApexSurfaceRun ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsApexSurfaceRunTracker = false ;

                           public boolean isIsApexSurfaceRunSpecified(){
                               return localIsApexSurfaceRunTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsApexSurfaceRun(){
                               return localIsApexSurfaceRun;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsApexSurfaceRun
                               */
                               public void setIsApexSurfaceRun(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsApexSurfaceRunTracker =
                                       true;
                                   
                                            this.localIsApexSurfaceRun=param;
                                       

                               }
                            

                        /**
                        * field for IsRunRailConnected
                        */

                        
                                    protected boolean localIsRunRailConnected ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsRunRailConnectedTracker = false ;

                           public boolean isIsRunRailConnectedSpecified(){
                               return localIsRunRailConnectedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsRunRailConnected(){
                               return localIsRunRailConnected;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsRunRailConnected
                               */
                               public void setIsRunRailConnected(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsRunRailConnectedTracker =
                                       true;
                                   
                                            this.localIsRunRailConnected=param;
                                       

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
                        * field for MultipleDestination
                        */

                        
                                    protected java.lang.String localMultipleDestination ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMultipleDestinationTracker = false ;

                           public boolean isMultipleDestinationSpecified(){
                               return localMultipleDestinationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMultipleDestination(){
                               return localMultipleDestination;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MultipleDestination
                               */
                               public void setMultipleDestination(java.lang.String param){
                            localMultipleDestinationTracker = true;
                                   
                                            this.localMultipleDestination=param;
                                       

                               }
                            

                        /**
                        * field for OVC
                        */

                        
                                    protected java.lang.String localOVC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOVCTracker = false ;

                           public boolean isOVCSpecified(){
                               return localOVCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOVC(){
                               return localOVC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OVC
                               */
                               public void setOVC(java.lang.String param){
                            localOVCTracker = true;
                                   
                                            this.localOVC=param;
                                       

                               }
                            

                        /**
                        * field for RouteCode
                        */

                        
                                    protected java.lang.String localRouteCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRouteCodeTracker = false ;

                           public boolean isRouteCodeSpecified(){
                               return localRouteCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRouteCode(){
                               return localRouteCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RouteCode
                               */
                               public void setRouteCode(java.lang.String param){
                            localRouteCodeTracker = true;
                                   
                                            this.localRouteCode=param;
                                       

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
                        * field for STD
                        */

                        
                                    protected java.lang.String localSTD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSTDTracker = false ;

                           public boolean isSTDSpecified(){
                               return localSTDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSTD(){
                               return localSTD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param STD
                               */
                               public void setSTD(java.lang.String param){
                            localSTDTracker = true;
                                   
                                            this.localSTD=param;
                                       

                               }
                            

                        /**
                        * field for SealNumber
                        */

                        
                                    protected java.lang.String localSealNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSealNumberTracker = false ;

                           public boolean isSealNumberSpecified(){
                               return localSealNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSealNumber(){
                               return localSealNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SealNumber
                               */
                               public void setSealNumber(java.lang.String param){
                            localSealNumberTracker = true;
                                   
                                            this.localSealNumber=param;
                                       

                               }
                            

                        /**
                        * field for StartKms
                        */

                        
                                    protected long localStartKms ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStartKmsTracker = false ;

                           public boolean isStartKmsSpecified(){
                               return localStartKmsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getStartKms(){
                               return localStartKms;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StartKms
                               */
                               public void setStartKms(long param){
                            localStartKmsTracker = true;
                                   
                                            this.localStartKms=param;
                                       

                               }
                            

                        /**
                        * field for TC_flag
                        */

                        
                                    protected java.lang.String localTC_flag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTC_flagTracker = false ;

                           public boolean isTC_flagSpecified(){
                               return localTC_flagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTC_flag(){
                               return localTC_flag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TC_flag
                               */
                               public void setTC_flag(java.lang.String param){
                            localTC_flagTracker = true;
                                   
                                            this.localTC_flag=param;
                                       

                               }
                            

                        /**
                        * field for VehicleCost
                        */

                        
                                    protected java.math.BigDecimal localVehicleCost ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVehicleCostTracker = false ;

                           public boolean isVehicleCostSpecified(){
                               return localVehicleCostTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getVehicleCost(){
                               return localVehicleCost;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VehicleCost
                               */
                               public void setVehicleCost(java.math.BigDecimal param){
                            localVehicleCostTracker = param != null;
                                   
                                            this.localVehicleCost=param;
                                       

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
                        * field for VehicleRemarks
                        */

                        
                                    protected java.lang.String localVehicleRemarks ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVehicleRemarksTracker = false ;

                           public boolean isVehicleRemarksSpecified(){
                               return localVehicleRemarksTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVehicleRemarks(){
                               return localVehicleRemarks;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VehicleRemarks
                               */
                               public void setVehicleRemarks(java.lang.String param){
                            localVehicleRemarksTracker = true;
                                   
                                            this.localVehicleRemarks=param;
                                       

                               }
                            

                        /**
                        * field for VehicleType
                        */

                        
                                    protected java.lang.String localVehicleType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVehicleTypeTracker = false ;

                           public boolean isVehicleTypeSpecified(){
                               return localVehicleTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVehicleType(){
                               return localVehicleType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VehicleType
                               */
                               public void setVehicleType(java.lang.String param){
                            localVehicleTypeTracker = true;
                                   
                                            this.localVehicleType=param;
                                       

                               }
                            

                        /**
                        * field for VehicleTypeValue
                        */

                        
                                    protected java.lang.String localVehicleTypeValue ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVehicleTypeValueTracker = false ;

                           public boolean isVehicleTypeValueSpecified(){
                               return localVehicleTypeValueTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVehicleTypeValue(){
                               return localVehicleTypeValue;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VehicleTypeValue
                               */
                               public void setVehicleTypeValue(java.lang.String param){
                            localVehicleTypeValueTracker = true;
                                   
                                            this.localVehicleTypeValue=param;
                                       

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
                           namespacePrefix+":TransferChallanInputEntity",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "TransferChallanInputEntity",
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
                             } if (localATDTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ATD", xmlWriter);
                             

                                          if (localATD==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localATD);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContractorCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ContractorCode", xmlWriter);
                             

                                          if (localContractorCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContractorCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContractorNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ContractorName", xmlWriter);
                             

                                          if (localContractorName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContractorName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDocumentNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DocumentNo", xmlWriter);
                             

                                          if (localDocumentNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDocumentNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDriverNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DriverName", xmlWriter);
                             

                                          if (localDriverName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDriverName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEmployeeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "EmployeeCode", xmlWriter);
                             

                                          if (localEmployeeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmployeeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFleetDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FleetDate", xmlWriter);
                             

                                          if (localFleetDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFleetDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFleetNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "FleetNumber", xmlWriter);
                             

                                          if (localFleetNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFleetNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localGPSDeviceIDTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "GPSDeviceID", xmlWriter);
                             

                                          if (localGPSDeviceID==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGPSDeviceID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localISAIRONTRAINTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ISAIRONTRAIN", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ISAIRONTRAIN cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localISAIRONTRAIN));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localISCCMRCIALTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ISCCMRCIAL", xmlWriter);
                             

                                          if (localISCCMRCIAL==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localISCCMRCIAL);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsApexSurfaceRunTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsApexSurfaceRun", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsApexSurfaceRun cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsApexSurfaceRun));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsRunRailConnectedTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsRunRailConnected", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsRunRailConnected cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsRunRailConnected));
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
                             } if (localMultipleDestinationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "MultipleDestination", xmlWriter);
                             

                                          if (localMultipleDestination==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMultipleDestination);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOVCTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OVC", xmlWriter);
                             

                                          if (localOVC==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOVC);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRouteCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RouteCode", xmlWriter);
                             

                                          if (localRouteCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRouteCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RunCode", xmlWriter);
                             

                                          if (localRunCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRunCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRunDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "RunDate", xmlWriter);
                             

                                          if (localRunDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRunDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSTDTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "STD", xmlWriter);
                             

                                          if (localSTD==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSTD);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSealNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "SealNumber", xmlWriter);
                             

                                          if (localSealNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSealNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStartKmsTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StartKms", xmlWriter);
                             
                                               if (localStartKms==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStartKms));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTC_flagTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "TC_flag", xmlWriter);
                             

                                          if (localTC_flag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTC_flag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleCostTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "VehicleCost", xmlWriter);
                             

                                          if (localVehicleCost==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VehicleCost cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVehicleCost));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "VehicleNumber", xmlWriter);
                             

                                          if (localVehicleNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVehicleNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleRemarksTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "VehicleRemarks", xmlWriter);
                             

                                          if (localVehicleRemarks==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVehicleRemarks);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "VehicleType", xmlWriter);
                             

                                          if (localVehicleType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVehicleType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVehicleTypeValueTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "VehicleTypeValue", xmlWriter);
                             

                                          if (localVehicleTypeValue==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVehicleTypeValue);
                                            
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
        public static TransferChallanInputEntity parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            TransferChallanInputEntity object =
                new TransferChallanInputEntity();

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
                    
                            if (!"TransferChallanInputEntity".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (TransferChallanInputEntity)org.tempuri.imports.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ATD").equals(reader.getName()) || new javax.xml.namespace.QName("","ATD").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setATD(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContractorCode").equals(reader.getName()) || new javax.xml.namespace.QName("","ContractorCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContractorCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ContractorName").equals(reader.getName()) || new javax.xml.namespace.QName("","ContractorName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContractorName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DocumentNo").equals(reader.getName()) || new javax.xml.namespace.QName("","DocumentNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDocumentNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DriverName").equals(reader.getName()) || new javax.xml.namespace.QName("","DriverName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDriverName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","EmployeeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","EmployeeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmployeeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FleetDate").equals(reader.getName()) || new javax.xml.namespace.QName("","FleetDate").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","FleetNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","FleetNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFleetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","GPSDeviceID").equals(reader.getName()) || new javax.xml.namespace.QName("","GPSDeviceID").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGPSDeviceID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ISAIRONTRAIN").equals(reader.getName()) || new javax.xml.namespace.QName("","ISAIRONTRAIN").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ISAIRONTRAIN" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setISAIRONTRAIN(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ISCCMRCIAL").equals(reader.getName()) || new javax.xml.namespace.QName("","ISCCMRCIAL").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setISCCMRCIAL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsApexSurfaceRun").equals(reader.getName()) || new javax.xml.namespace.QName("","IsApexSurfaceRun").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsApexSurfaceRun" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsApexSurfaceRun(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsRunRailConnected").equals(reader.getName()) || new javax.xml.namespace.QName("","IsRunRailConnected").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsRunRailConnected" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsRunRailConnected(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","MultipleDestination").equals(reader.getName()) || new javax.xml.namespace.QName("","MultipleDestination").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMultipleDestination(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OVC").equals(reader.getName()) || new javax.xml.namespace.QName("","OVC").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOVC(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RouteCode").equals(reader.getName()) || new javax.xml.namespace.QName("","RouteCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRouteCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RunCode").equals(reader.getName()) || new javax.xml.namespace.QName("","RunCode").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","RunDate").equals(reader.getName()) || new javax.xml.namespace.QName("","RunDate").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","STD").equals(reader.getName()) || new javax.xml.namespace.QName("","STD").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSTD(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","SealNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","SealNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSealNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StartKms").equals(reader.getName()) || new javax.xml.namespace.QName("","StartKms").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStartKms(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setStartKms(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setStartKms(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","TC_flag").equals(reader.getName()) || new javax.xml.namespace.QName("","TC_flag").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTC_flag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","VehicleCost").equals(reader.getName()) || new javax.xml.namespace.QName("","VehicleCost").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"VehicleCost" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVehicleCost(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","VehicleNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","VehicleNumber").equals(reader.getName()) ){
                                
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
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","VehicleRemarks").equals(reader.getName()) || new javax.xml.namespace.QName("","VehicleRemarks").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVehicleRemarks(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","VehicleType").equals(reader.getName()) || new javax.xml.namespace.QName("","VehicleType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVehicleType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","VehicleTypeValue").equals(reader.getName()) || new javax.xml.namespace.QName("","VehicleTypeValue").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVehicleTypeValue(
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
           
    