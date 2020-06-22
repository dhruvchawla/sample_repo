
/**
 * MPSDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package service.bd;
            

            /**
            *  MPSDetail bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class MPSDetail
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = MPSDetail
                Namespace URI = BD.Service
                Namespace Prefix = ns11
                */
            

                        /**
                        * field for AWBId
                        */

                        
                                    protected long localAWBId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAWBIdTracker = false ;

                           public boolean isAWBIdSpecified(){
                               return localAWBIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getAWBId(){
                               return localAWBId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AWBId
                               */
                               public void setAWBId(long param){
                            
                                       // setting primitive attribute tracker to true
                                       localAWBIdTracker =
                                       param != java.lang.Long.MIN_VALUE;
                                   
                                            this.localAWBId=param;
                                    

                               }
                            

                        /**
                        * field for AWBNo
                        */

                        
                                    protected java.lang.String localAWBNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAWBNoTracker = false ;

                           public boolean isAWBNoSpecified(){
                               return localAWBNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAWBNo(){
                               return localAWBNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AWBNo
                               */
                               public void setAWBNo(java.lang.String param){
                            localAWBNoTracker = true;
                                   
                                            this.localAWBNo=param;
                                    

                               }
                            

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
                        * field for AwbIDE
                        */

                        
                                    protected java.lang.String localAwbIDE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAwbIDETracker = false ;

                           public boolean isAwbIDESpecified(){
                               return localAwbIDETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAwbIDE(){
                               return localAwbIDE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AwbIDE
                               */
                               public void setAwbIDE(java.lang.String param){
                            localAwbIDETracker = true;
                                   
                                            this.localAwbIDE=param;
                                    

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
                        * field for CStatclremplcode
                        */

                        
                                    protected java.lang.String localCStatclremplcode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCStatclremplcodeTracker = false ;

                           public boolean isCStatclremplcodeSpecified(){
                               return localCStatclremplcodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCStatclremplcode(){
                               return localCStatclremplcode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CStatclremplcode
                               */
                               public void setCStatclremplcode(java.lang.String param){
                            localCStatclremplcodeTracker = true;
                                   
                                            this.localCStatclremplcode=param;
                                    

                               }
                            

                        /**
                        * field for Cemplcode
                        */

                        
                                    protected java.lang.String localCemplcode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCemplcodeTracker = false ;

                           public boolean isCemplcodeSpecified(){
                               return localCemplcodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCemplcode(){
                               return localCemplcode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cemplcode
                               */
                               public void setCemplcode(java.lang.String param){
                            localCemplcodeTracker = true;
                                   
                                            this.localCemplcode=param;
                                    

                               }
                            

                        /**
                        * field for CmLocCode
                        */

                        
                                    protected java.lang.String localCmLocCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCmLocCodeTracker = false ;

                           public boolean isCmLocCodeSpecified(){
                               return localCmLocCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCmLocCode(){
                               return localCmLocCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CmLocCode
                               */
                               public void setCmLocCode(java.lang.String param){
                            localCmLocCodeTracker = true;
                                   
                                            this.localCmLocCode=param;
                                    

                               }
                            

                        /**
                        * field for Cmdtycode
                        */

                        
                                    protected java.lang.String localCmdtycode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCmdtycodeTracker = false ;

                           public boolean isCmdtycodeSpecified(){
                               return localCmdtycodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCmdtycode(){
                               return localCmdtycode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cmdtycode
                               */
                               public void setCmdtycode(java.lang.String param){
                            localCmdtycodeTracker = true;
                                   
                                            this.localCmdtycode=param;
                                    

                               }
                            

                        /**
                        * field for Cod
                        */

                        
                                    protected java.lang.String localCod ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCodTracker = false ;

                           public boolean isCodSpecified(){
                               return localCodTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCod(){
                               return localCod;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cod
                               */
                               public void setCod(java.lang.String param){
                            localCodTracker = true;
                                   
                                            this.localCod=param;
                                    

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
                        * field for CrunCode
                        */

                        
                                    protected java.lang.String localCrunCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCrunCodeTracker = false ;

                           public boolean isCrunCodeSpecified(){
                               return localCrunCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCrunCode(){
                               return localCrunCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CrunCode
                               */
                               public void setCrunCode(java.lang.String param){
                            localCrunCodeTracker = true;
                                   
                                            this.localCrunCode=param;
                                    

                               }
                            

                        /**
                        * field for CrunOrg
                        */

                        
                                    protected java.lang.String localCrunOrg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCrunOrgTracker = false ;

                           public boolean isCrunOrgSpecified(){
                               return localCrunOrgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCrunOrg(){
                               return localCrunOrg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CrunOrg
                               */
                               public void setCrunOrg(java.lang.String param){
                            localCrunOrgTracker = true;
                                   
                                            this.localCrunOrg=param;
                                    

                               }
                            

                        /**
                        * field for CstatClrAction
                        */

                        
                                    protected java.lang.String localCstatClrAction ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCstatClrActionTracker = false ;

                           public boolean isCstatClrActionSpecified(){
                               return localCstatClrActionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCstatClrAction(){
                               return localCstatClrAction;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CstatClrAction
                               */
                               public void setCstatClrAction(java.lang.String param){
                            localCstatClrActionTracker = true;
                                   
                                            this.localCstatClrAction=param;
                                    

                               }
                            

                        /**
                        * field for CstatCode
                        */

                        
                                    protected java.lang.String localCstatCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCstatCodeTracker = false ;

                           public boolean isCstatCodeSpecified(){
                               return localCstatCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCstatCode(){
                               return localCstatCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CstatCode
                               */
                               public void setCstatCode(java.lang.String param){
                            localCstatCodeTracker = true;
                                   
                                            this.localCstatCode=param;
                                    

                               }
                            

                        /**
                        * field for CvehicleNo
                        */

                        
                                    protected java.lang.String localCvehicleNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCvehicleNoTracker = false ;

                           public boolean isCvehicleNoSpecified(){
                               return localCvehicleNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCvehicleNo(){
                               return localCvehicleNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CvehicleNo
                               */
                               public void setCvehicleNo(java.lang.String param){
                            localCvehicleNoTracker = true;
                                   
                                            this.localCvehicleNo=param;
                                    

                               }
                            

                        /**
                        * field for DCCount
                        */

                        
                                    protected java.lang.String localDCCount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDCCountTracker = false ;

                           public boolean isDCCountSpecified(){
                               return localDCCountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDCCount(){
                               return localDCCount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DCCount
                               */
                               public void setDCCount(java.lang.String param){
                            localDCCountTracker = true;
                                   
                                            this.localDCCount=param;
                                    

                               }
                            

                        /**
                        * field for DRundate
                        */

                        
                                    protected java.util.Calendar localDRundate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDRundateTracker = false ;

                           public boolean isDRundateSpecified(){
                               return localDRundateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDRundate(){
                               return localDRundate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DRundate
                               */
                               public void setDRundate(java.util.Calendar param){
                            localDRundateTracker = true;
                                   
                                            this.localDRundate=param;
                                    

                               }
                            

                        /**
                        * field for DataEntryLoc
                        */

                        
                                    protected java.lang.String localDataEntryLoc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataEntryLocTracker = false ;

                           public boolean isDataEntryLocSpecified(){
                               return localDataEntryLocTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDataEntryLoc(){
                               return localDataEntryLoc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataEntryLoc
                               */
                               public void setDataEntryLoc(java.lang.String param){
                            localDataEntryLocTracker = true;
                                   
                                            this.localDataEntryLoc=param;
                                    

                               }
                            

                        /**
                        * field for DeclaredValue
                        */

                        
                                    protected java.lang.String localDeclaredValue ;
                                
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
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeclaredValue(){
                               return localDeclaredValue;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeclaredValue
                               */
                               public void setDeclaredValue(java.lang.String param){
                            localDeclaredValueTracker = true;
                                   
                                            this.localDeclaredValue=param;
                                    

                               }
                            

                        /**
                        * field for DestArea
                        */

                        
                                    protected java.lang.String localDestArea ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDestAreaTracker = false ;

                           public boolean isDestAreaSpecified(){
                               return localDestAreaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDestArea(){
                               return localDestArea;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DestArea
                               */
                               public void setDestArea(java.lang.String param){
                            localDestAreaTracker = true;
                                   
                                            this.localDestArea=param;
                                    

                               }
                            

                        /**
                        * field for DestSC
                        */

                        
                                    protected java.lang.String localDestSC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDestSCTracker = false ;

                           public boolean isDestSCSpecified(){
                               return localDestSCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDestSC(){
                               return localDestSC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DestSC
                               */
                               public void setDestSC(java.lang.String param){
                            localDestSCTracker = true;
                                   
                                            this.localDestSC=param;
                                    

                               }
                            

                        /**
                        * field for DocumentAttached
                        */

                        
                                    protected java.lang.String localDocumentAttached ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocumentAttachedTracker = false ;

                           public boolean isDocumentAttachedSpecified(){
                               return localDocumentAttachedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDocumentAttached(){
                               return localDocumentAttached;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DocumentAttached
                               */
                               public void setDocumentAttached(java.lang.String param){
                            localDocumentAttachedTracker = true;
                                   
                                            this.localDocumentAttached=param;
                                    

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
                        * field for FlightNo
                        */

                        
                                    protected java.lang.String localFlightNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlightNoTracker = false ;

                           public boolean isFlightNoSpecified(){
                               return localFlightNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFlightNo(){
                               return localFlightNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlightNo
                               */
                               public void setFlightNo(java.lang.String param){
                            localFlightNoTracker = true;
                                   
                                            this.localFlightNo=param;
                                    

                               }
                            

                        /**
                        * field for Gate
                        */

                        
                                    protected service.bd.GateDetail localGate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGateTracker = false ;

                           public boolean isGateSpecified(){
                               return localGateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return service.bd.GateDetail
                           */
                           public  service.bd.GateDetail getGate(){
                               return localGate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gate
                               */
                               public void setGate(service.bd.GateDetail param){
                            localGateTracker = true;
                                   
                                            this.localGate=param;
                                    

                               }
                            

                        /**
                        * field for MPSNo
                        */

                        
                                    protected java.lang.String localMPSNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMPSNoTracker = false ;

                           public boolean isMPSNoSpecified(){
                               return localMPSNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMPSNo(){
                               return localMPSNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MPSNo
                               */
                               public void setMPSNo(java.lang.String param){
                            localMPSNoTracker = true;
                                   
                                            this.localMPSNo=param;
                                    

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
                        * field for NoPics
                        */

                        
                                    protected java.lang.String localNoPics ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNoPicsTracker = false ;

                           public boolean isNoPicsSpecified(){
                               return localNoPicsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNoPics(){
                               return localNoPics;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NoPics
                               */
                               public void setNoPics(java.lang.String param){
                            localNoPicsTracker = true;
                                   
                                            this.localNoPics=param;
                                    

                               }
                            

                        /**
                        * field for OrgArea
                        */

                        
                                    protected java.lang.String localOrgArea ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrgAreaTracker = false ;

                           public boolean isOrgAreaSpecified(){
                               return localOrgAreaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOrgArea(){
                               return localOrgArea;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrgArea
                               */
                               public void setOrgArea(java.lang.String param){
                            localOrgAreaTracker = true;
                                   
                                            this.localOrgArea=param;
                                    

                               }
                            

                        /**
                        * field for OrgSC
                        */

                        
                                    protected java.lang.String localOrgSC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrgSCTracker = false ;

                           public boolean isOrgSCSpecified(){
                               return localOrgSCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOrgSC(){
                               return localOrgSC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrgSC
                               */
                               public void setOrgSC(java.lang.String param){
                            localOrgSCTracker = true;
                                   
                                            this.localOrgSC=param;
                                    

                               }
                            

                        /**
                        * field for Packtype
                        */

                        
                                    protected java.lang.String localPacktype ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPacktypeTracker = false ;

                           public boolean isPacktypeSpecified(){
                               return localPacktypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPacktype(){
                               return localPacktype;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Packtype
                               */
                               public void setPacktype(java.lang.String param){
                            localPacktypeTracker = true;
                                   
                                            this.localPacktype=param;
                                    

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
                        * field for RFIDNo
                        */

                        
                                    protected java.lang.String localRFIDNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRFIDNoTracker = false ;

                           public boolean isRFIDNoSpecified(){
                               return localRFIDNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRFIDNo(){
                               return localRFIDNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RFIDNo
                               */
                               public void setRFIDNo(java.lang.String param){
                            localRFIDNoTracker = true;
                                   
                                            this.localRFIDNo=param;
                                    

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
                        * field for Splinst
                        */

                        
                                    protected java.lang.String localSplinst ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSplinstTracker = false ;

                           public boolean isSplinstSpecified(){
                               return localSplinstTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSplinst(){
                               return localSplinst;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Splinst
                               */
                               public void setSplinst(java.lang.String param){
                            localSplinstTracker = true;
                                   
                                            this.localSplinst=param;
                                    

                               }
                            

                        /**
                        * field for StateCode
                        */

                        
                                    protected java.lang.String localStateCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStateCodeTracker = false ;

                           public boolean isStateCodeSpecified(){
                               return localStateCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStateCode(){
                               return localStateCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StateCode
                               */
                               public void setStateCode(java.lang.String param){
                            localStateCodeTracker = true;
                                   
                                            this.localStateCode=param;
                                    

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
                        * field for StatusDate
                        */

                        
                                    protected java.util.Calendar localStatusDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusDateTracker = false ;

                           public boolean isStatusDateSpecified(){
                               return localStatusDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getStatusDate(){
                               return localStatusDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusDate
                               */
                               public void setStatusDate(java.util.Calendar param){
                            localStatusDateTracker = true;
                                   
                                            this.localStatusDate=param;
                                    

                               }
                            

                        /**
                        * field for StatusDesc
                        */

                        
                                    protected java.lang.String localStatusDesc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusDescTracker = false ;

                           public boolean isStatusDescSpecified(){
                               return localStatusDescTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatusDesc(){
                               return localStatusDesc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusDesc
                               */
                               public void setStatusDesc(java.lang.String param){
                            localStatusDescTracker = true;
                                   
                                            this.localStatusDesc=param;
                                    

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
                        * field for ActivityCodeE
                        */

                        
                                    protected java.lang.String localActivityCodeE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localActivityCodeETracker = false ;

                           public boolean isActivityCodeESpecified(){
                               return localActivityCodeETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getActivityCodeE(){
                               return localActivityCodeE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ActivityCodeE
                               */
                               public void setActivityCodeE(java.lang.String param){
                            localActivityCodeETracker = true;
                                   
                                            this.localActivityCodeE=param;
                                    

                               }
                            

                        /**
                        * field for CStatClrDate
                        */

                        
                                    protected java.util.Calendar localCStatClrDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCStatClrDateTracker = false ;

                           public boolean isCStatClrDateSpecified(){
                               return localCStatClrDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getCStatClrDate(){
                               return localCStatClrDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CStatClrDate
                               */
                               public void setCStatClrDate(java.util.Calendar param){
                            localCStatClrDateTracker = true;
                                   
                                            this.localCStatClrDate=param;
                                    

                               }
                            

                        /**
                        * field for CTally
                        */

                        
                                    protected java.lang.String localCTally ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCTallyTracker = false ;

                           public boolean isCTallySpecified(){
                               return localCTallyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCTally(){
                               return localCTally;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CTally
                               */
                               public void setCTally(java.lang.String param){
                            localCTallyTracker = true;
                                   
                                            this.localCTally=param;
                                    

                               }
                            

                        /**
                        * field for Docattached
                        */

                        
                                    protected java.lang.String localDocattached ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocattachedTracker = false ;

                           public boolean isDocattachedSpecified(){
                               return localDocattachedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDocattached(){
                               return localDocattached;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Docattached
                               */
                               public void setDocattached(java.lang.String param){
                            localDocattachedTracker = true;
                                   
                                            this.localDocattached=param;
                                    

                               }
                            

                        /**
                        * field for NParentContainerId
                        */

                        
                                    protected int localNParentContainerId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNParentContainerIdTracker = false ;

                           public boolean isNParentContainerIdSpecified(){
                               return localNParentContainerIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getNParentContainerId(){
                               return localNParentContainerId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NParentContainerId
                               */
                               public void setNParentContainerId(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localNParentContainerIdTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localNParentContainerId=param;
                                    

                               }
                            

                        /**
                        * field for Remarks
                        */

                        
                                    protected java.lang.String localRemarks ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRemarksTracker = false ;

                           public boolean isRemarksSpecified(){
                               return localRemarksTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRemarks(){
                               return localRemarks;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Remarks
                               */
                               public void setRemarks(java.lang.String param){
                            localRemarksTracker = true;
                                   
                                            this.localRemarks=param;
                                    

                               }
                            

                        /**
                        * field for UnRdblCmdTy
                        */

                        
                                    protected java.lang.String localUnRdblCmdTy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUnRdblCmdTyTracker = false ;

                           public boolean isUnRdblCmdTySpecified(){
                               return localUnRdblCmdTyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUnRdblCmdTy(){
                               return localUnRdblCmdTy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UnRdblCmdTy
                               */
                               public void setUnRdblCmdTy(java.lang.String param){
                            localUnRdblCmdTyTracker = true;
                                   
                                            this.localUnRdblCmdTy=param;
                                    

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
                           namespacePrefix+":MPSDetail",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "MPSDetail",
                           xmlWriter);
                   }

               
                   }
                if (localAWBIdTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "AWBId", xmlWriter);
                             
                                               if (localAWBId==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("AWBId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAWBId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAWBNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "AWBNo", xmlWriter);
                             

                                          if (localAWBNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAWBNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localActivityCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ActivityCode", xmlWriter);
                             

                                          if (localActivityCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActivityCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAwbIDETracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "AwbID", xmlWriter);
                             

                                          if (localAwbIDE==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAwbIDE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBatchNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "BatchNo", xmlWriter);
                             

                                          if (localBatchNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBatchNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCStatclremplcodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CStatclremplcode", xmlWriter);
                             

                                          if (localCStatclremplcode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCStatclremplcode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCemplcodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Cemplcode", xmlWriter);
                             

                                          if (localCemplcode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCemplcode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCmLocCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CmLocCode", xmlWriter);
                             

                                          if (localCmLocCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCmLocCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCmdtycodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Cmdtycode", xmlWriter);
                             

                                          if (localCmdtycode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCmdtycode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCodTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Cod", xmlWriter);
                             

                                          if (localCod==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCod);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommodityTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Commodity", xmlWriter);
                             

                                          if (localCommodity==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCommodity);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeNameTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ConsigneeName", xmlWriter);
                             

                                          if (localConsigneeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsigneeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCrunCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CrunCode", xmlWriter);
                             

                                          if (localCrunCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCrunCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCrunOrgTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CrunOrg", xmlWriter);
                             

                                          if (localCrunOrg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCrunOrg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCstatClrActionTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CstatClrAction", xmlWriter);
                             

                                          if (localCstatClrAction==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCstatClrAction);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCstatCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CstatCode", xmlWriter);
                             

                                          if (localCstatCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCstatCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCvehicleNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "CvehicleNo", xmlWriter);
                             

                                          if (localCvehicleNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCvehicleNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDCCountTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DCCount", xmlWriter);
                             

                                          if (localDCCount==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDCCount);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDRundateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DRundate", xmlWriter);
                             

                                          if (localDRundate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDRundate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDataEntryLocTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DataEntryLoc", xmlWriter);
                             

                                          if (localDataEntryLoc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDataEntryLoc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeclaredValueTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DeclaredValue", xmlWriter);
                             

                                          if (localDeclaredValue==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeclaredValue);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestAreaTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DestArea", xmlWriter);
                             

                                          if (localDestArea==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestSCTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DestSC", xmlWriter);
                             

                                          if (localDestSC==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestSC);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDocumentAttachedTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "DocumentAttached", xmlWriter);
                             

                                          if (localDocumentAttached==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDocumentAttached);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlightDateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "FlightDate", xmlWriter);
                             

                                          if (localFlightDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlightDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlightNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "FlightNo", xmlWriter);
                             

                                          if (localFlightNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFlightNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localGateTracker){
                                    if (localGate==null){

                                        writeStartElement(null, "BD.Service", "Gate", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localGate.serialize(new javax.xml.namespace.QName("BD.Service","Gate"),
                                        xmlWriter);
                                    }
                                } if (localMPSNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "MPSNo", xmlWriter);
                             

                                          if (localMPSNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMPSNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localModeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Mode", xmlWriter);
                             

                                          if (localMode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNoPicsTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "NoPics", xmlWriter);
                             

                                          if (localNoPics==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNoPics);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOrgAreaTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "OrgArea", xmlWriter);
                             

                                          if (localOrgArea==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOrgArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOrgSCTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "OrgSC", xmlWriter);
                             

                                          if (localOrgSC==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOrgSC);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPacktypeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Packtype", xmlWriter);
                             

                                          if (localPacktype==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPacktype);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPiecesTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Pieces", xmlWriter);
                             

                                          if (localPieces==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPieces);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPriorityTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Priority", xmlWriter);
                             

                                          if (localPriority==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPriority);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProductCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ProductCode", xmlWriter);
                             

                                          if (localProductCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProductTypeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ProductType", xmlWriter);
                             

                                          if (localProductType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRFIDNoTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "RFIDNo", xmlWriter);
                             

                                          if (localRFIDNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRFIDNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipperNameTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "ShipperName", xmlWriter);
                             

                                          if (localShipperName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipperName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSplinstTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Splinst", xmlWriter);
                             

                                          if (localSplinst==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSplinst);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStateCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "StateCode", xmlWriter);
                             

                                          if (localStateCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStateCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "StatusCode", xmlWriter);
                             

                                          if (localStatusCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusDateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "StatusDate", xmlWriter);
                             

                                          if (localStatusDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusDescTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "StatusDesc", xmlWriter);
                             

                                          if (localStatusDesc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatusDesc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubCodeTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "SubCode", xmlWriter);
                             

                                          if (localSubCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWeightTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "Weight", xmlWriter);
                             

                                          if (localWeight==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localWeight);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localActivityCodeETracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "activityCode", xmlWriter);
                             

                                          if (localActivityCodeE==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActivityCodeE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCStatClrDateTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "cStatClrDate", xmlWriter);
                             

                                          if (localCStatClrDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCStatClrDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCTallyTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "cTally", xmlWriter);
                             

                                          if (localCTally==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCTally);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDocattachedTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "docattached", xmlWriter);
                             

                                          if (localDocattached==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDocattached);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNParentContainerIdTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "nParentContainerId", xmlWriter);
                             
                                               if (localNParentContainerId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("nParentContainerId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNParentContainerId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRemarksTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "remarks", xmlWriter);
                             

                                          if (localRemarks==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRemarks);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUnRdblCmdTyTracker){
                                    namespace = "BD.Service";
                                    writeStartElement(null, namespace, "unRdblCmdTy", xmlWriter);
                             

                                          if (localUnRdblCmdTy==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUnRdblCmdTy);
                                            
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

                 if (localAWBIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "AWBId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAWBId));
                            } if (localAWBNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "AWBNo"));
                                 
                                         elementList.add(localAWBNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAWBNo));
                                    } if (localActivityCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ActivityCode"));
                                 
                                         elementList.add(localActivityCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActivityCode));
                                    } if (localAwbIDETracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "AwbID"));
                                 
                                         elementList.add(localAwbIDE==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAwbIDE));
                                    } if (localBatchNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "BatchNo"));
                                 
                                         elementList.add(localBatchNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatchNo));
                                    } if (localCStatclremplcodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CStatclremplcode"));
                                 
                                         elementList.add(localCStatclremplcode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCStatclremplcode));
                                    } if (localCemplcodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Cemplcode"));
                                 
                                         elementList.add(localCemplcode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCemplcode));
                                    } if (localCmLocCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CmLocCode"));
                                 
                                         elementList.add(localCmLocCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCmLocCode));
                                    } if (localCmdtycodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Cmdtycode"));
                                 
                                         elementList.add(localCmdtycode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCmdtycode));
                                    } if (localCodTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Cod"));
                                 
                                         elementList.add(localCod==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCod));
                                    } if (localCommodityTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Commodity"));
                                 
                                         elementList.add(localCommodity==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCommodity));
                                    } if (localConsigneeNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ConsigneeName"));
                                 
                                         elementList.add(localConsigneeName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConsigneeName));
                                    } if (localCrunCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CrunCode"));
                                 
                                         elementList.add(localCrunCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCrunCode));
                                    } if (localCrunOrgTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CrunOrg"));
                                 
                                         elementList.add(localCrunOrg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCrunOrg));
                                    } if (localCstatClrActionTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CstatClrAction"));
                                 
                                         elementList.add(localCstatClrAction==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCstatClrAction));
                                    } if (localCstatCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CstatCode"));
                                 
                                         elementList.add(localCstatCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCstatCode));
                                    } if (localCvehicleNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "CvehicleNo"));
                                 
                                         elementList.add(localCvehicleNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCvehicleNo));
                                    } if (localDCCountTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DCCount"));
                                 
                                         elementList.add(localDCCount==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDCCount));
                                    } if (localDRundateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DRundate"));
                                 
                                         elementList.add(localDRundate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDRundate));
                                    } if (localDataEntryLocTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DataEntryLoc"));
                                 
                                         elementList.add(localDataEntryLoc==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataEntryLoc));
                                    } if (localDeclaredValueTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DeclaredValue"));
                                 
                                         elementList.add(localDeclaredValue==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeclaredValue));
                                    } if (localDestAreaTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DestArea"));
                                 
                                         elementList.add(localDestArea==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDestArea));
                                    } if (localDestSCTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DestSC"));
                                 
                                         elementList.add(localDestSC==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDestSC));
                                    } if (localDocumentAttachedTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "DocumentAttached"));
                                 
                                         elementList.add(localDocumentAttached==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDocumentAttached));
                                    } if (localFlightDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "FlightDate"));
                                 
                                         elementList.add(localFlightDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlightDate));
                                    } if (localFlightNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "FlightNo"));
                                 
                                         elementList.add(localFlightNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlightNo));
                                    } if (localGateTracker){
                            elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Gate"));
                            
                            
                                    elementList.add(localGate==null?null:
                                    localGate);
                                } if (localMPSNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "MPSNo"));
                                 
                                         elementList.add(localMPSNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMPSNo));
                                    } if (localModeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Mode"));
                                 
                                         elementList.add(localMode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMode));
                                    } if (localNoPicsTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "NoPics"));
                                 
                                         elementList.add(localNoPics==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNoPics));
                                    } if (localOrgAreaTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "OrgArea"));
                                 
                                         elementList.add(localOrgArea==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrgArea));
                                    } if (localOrgSCTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "OrgSC"));
                                 
                                         elementList.add(localOrgSC==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrgSC));
                                    } if (localPacktypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Packtype"));
                                 
                                         elementList.add(localPacktype==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPacktype));
                                    } if (localPiecesTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Pieces"));
                                 
                                         elementList.add(localPieces==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPieces));
                                    } if (localPriorityTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Priority"));
                                 
                                         elementList.add(localPriority==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPriority));
                                    } if (localProductCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ProductCode"));
                                 
                                         elementList.add(localProductCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductCode));
                                    } if (localProductTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ProductType"));
                                 
                                         elementList.add(localProductType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductType));
                                    } if (localRFIDNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "RFIDNo"));
                                 
                                         elementList.add(localRFIDNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRFIDNo));
                                    } if (localShipperNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "ShipperName"));
                                 
                                         elementList.add(localShipperName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShipperName));
                                    } if (localSplinstTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Splinst"));
                                 
                                         elementList.add(localSplinst==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSplinst));
                                    } if (localStateCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "StateCode"));
                                 
                                         elementList.add(localStateCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStateCode));
                                    } if (localStatusCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "StatusCode"));
                                 
                                         elementList.add(localStatusCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusCode));
                                    } if (localStatusDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "StatusDate"));
                                 
                                         elementList.add(localStatusDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusDate));
                                    } if (localStatusDescTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "StatusDesc"));
                                 
                                         elementList.add(localStatusDesc==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusDesc));
                                    } if (localSubCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "SubCode"));
                                 
                                         elementList.add(localSubCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubCode));
                                    } if (localWeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "Weight"));
                                 
                                         elementList.add(localWeight==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWeight));
                                    } if (localActivityCodeETracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "activityCode"));
                                 
                                         elementList.add(localActivityCodeE==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActivityCodeE));
                                    } if (localCStatClrDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "cStatClrDate"));
                                 
                                         elementList.add(localCStatClrDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCStatClrDate));
                                    } if (localCTallyTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "cTally"));
                                 
                                         elementList.add(localCTally==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCTally));
                                    } if (localDocattachedTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "docattached"));
                                 
                                         elementList.add(localDocattached==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDocattached));
                                    } if (localNParentContainerIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "nParentContainerId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNParentContainerId));
                            } if (localRemarksTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "remarks"));
                                 
                                         elementList.add(localRemarks==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemarks));
                                    } if (localUnRdblCmdTyTracker){
                                      elementList.add(new javax.xml.namespace.QName("BD.Service",
                                                                      "unRdblCmdTy"));
                                 
                                         elementList.add(localUnRdblCmdTy==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUnRdblCmdTy));
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
        public static MPSDetail parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            MPSDetail object =
                new MPSDetail();

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
                    
                            if (!"MPSDetail".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (MPSDetail)org.tempuri.imports.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","AWBId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"AWBId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAWBId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setAWBId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","AWBNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAWBNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","AwbID").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAwbIDE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","BatchNo").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CStatclremplcode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCStatclremplcode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Cemplcode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCemplcode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CmLocCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCmLocCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Cmdtycode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCmdtycode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Cod").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCod(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Commodity").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ConsigneeName").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CrunCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCrunCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CrunOrg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCrunOrg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CstatClrAction").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCstatClrAction(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CstatCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCstatCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","CvehicleNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCvehicleNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DCCount").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDCCount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DRundate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDRundate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DataEntryLoc").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataEntryLoc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DeclaredValue").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeclaredValue(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DestArea").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDestArea(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DestSC").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDestSC(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","DocumentAttached").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDocumentAttached(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","FlightDate").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","FlightNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlightNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Gate").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setGate(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setGate(service.bd.GateDetail.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","MPSNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMPSNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Mode").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","NoPics").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNoPics(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","OrgArea").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOrgArea(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","OrgSC").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOrgSC(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Packtype").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPacktype(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Pieces").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Priority").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ProductCode").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ProductType").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","RFIDNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRFIDNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","ShipperName").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Splinst").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSplinst(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","StateCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStateCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","StatusCode").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","StatusDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","StatusDesc").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusDesc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","SubCode").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","Weight").equals(reader.getName())){
                                
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
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","activityCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActivityCodeE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","cStatClrDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCStatClrDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","cTally").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCTally(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","docattached").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDocattached(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","nParentContainerId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nParentContainerId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNParentContainerId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNParentContainerId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","remarks").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRemarks(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("BD.Service","unRdblCmdTy").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUnRdblCmdTy(
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
           
    