
/**
 * Octroi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  Octroi bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Octroi extends org.datacontract.schemas._2004._07.bd_entities_area.AreaEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Octroi
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Area
                Namespace Prefix = ns10
                */
            

                        /**
                        * field for ADCustomerCode
                        */

                        
                                    protected java.lang.String localADCustomerCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localADCustomerCodeTracker = false ;

                           public boolean isADCustomerCodeSpecified(){
                               return localADCustomerCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getADCustomerCode(){
                               return localADCustomerCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ADCustomerCode
                               */
                               public void setADCustomerCode(java.lang.String param){
                            localADCustomerCodeTracker = true;
                                   
                                            this.localADCustomerCode=param;
                                       

                               }
                            

                        /**
                        * field for ADCustomerLocation
                        */

                        
                                    protected java.lang.String localADCustomerLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localADCustomerLocationTracker = false ;

                           public boolean isADCustomerLocationSpecified(){
                               return localADCustomerLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getADCustomerLocation(){
                               return localADCustomerLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ADCustomerLocation
                               */
                               public void setADCustomerLocation(java.lang.String param){
                            localADCustomerLocationTracker = true;
                                   
                                            this.localADCustomerLocation=param;
                                       

                               }
                            

                        /**
                        * field for ADCustomerType
                        */

                        
                                    protected java.lang.String localADCustomerType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localADCustomerTypeTracker = false ;

                           public boolean isADCustomerTypeSpecified(){
                               return localADCustomerTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getADCustomerType(){
                               return localADCustomerType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ADCustomerType
                               */
                               public void setADCustomerType(java.lang.String param){
                            localADCustomerTypeTracker = true;
                                   
                                            this.localADCustomerType=param;
                                       

                               }
                            

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
                        * field for Amount
                        */

                        
                                    protected double localAmount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAmountTracker = false ;

                           public boolean isAmountSpecified(){
                               return localAmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getAmount(){
                               return localAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Amount
                               */
                               public void setAmount(double param){
                            localAmountTracker = true;
                                   
                                            this.localAmount=param;
                                       

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
                        * field for BelongsToLogInLoc
                        */

                        
                                    protected boolean localBelongsToLogInLoc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBelongsToLogInLocTracker = false ;

                           public boolean isBelongsToLogInLocSpecified(){
                               return localBelongsToLogInLocTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getBelongsToLogInLoc(){
                               return localBelongsToLogInLoc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BelongsToLogInLoc
                               */
                               public void setBelongsToLogInLoc(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localBelongsToLogInLocTracker =
                                       true;
                                   
                                            this.localBelongsToLogInLoc=param;
                                       

                               }
                            

                        /**
                        * field for BillDate
                        */

                        
                                    protected java.util.Calendar localBillDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBillDateTracker = false ;

                           public boolean isBillDateSpecified(){
                               return localBillDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBillDate(){
                               return localBillDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BillDate
                               */
                               public void setBillDate(java.util.Calendar param){
                            localBillDateTracker = true;
                                   
                                            this.localBillDate=param;
                                       

                               }
                            

                        /**
                        * field for BillNumber
                        */

                        
                                    protected java.lang.String localBillNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBillNumberTracker = false ;

                           public boolean isBillNumberSpecified(){
                               return localBillNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBillNumber(){
                               return localBillNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BillNumber
                               */
                               public void setBillNumber(java.lang.String param){
                            localBillNumberTracker = true;
                                   
                                            this.localBillNumber=param;
                                       

                               }
                            

                        /**
                        * field for BillScanDate
                        */

                        
                                    protected java.util.Calendar localBillScanDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBillScanDateTracker = false ;

                           public boolean isBillScanDateSpecified(){
                               return localBillScanDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBillScanDate(){
                               return localBillScanDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BillScanDate
                               */
                               public void setBillScanDate(java.util.Calendar param){
                            localBillScanDateTracker = true;
                                   
                                            this.localBillScanDate=param;
                                       

                               }
                            

                        /**
                        * field for BillSummaryDoneFlag
                        */

                        
                                    protected java.lang.String localBillSummaryDoneFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBillSummaryDoneFlagTracker = false ;

                           public boolean isBillSummaryDoneFlagSpecified(){
                               return localBillSummaryDoneFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBillSummaryDoneFlag(){
                               return localBillSummaryDoneFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BillSummaryDoneFlag
                               */
                               public void setBillSummaryDoneFlag(java.lang.String param){
                            localBillSummaryDoneFlagTracker = true;
                                   
                                            this.localBillSummaryDoneFlag=param;
                                       

                               }
                            

                        /**
                        * field for CashMemoNumber
                        */

                        
                                    protected java.lang.String localCashMemoNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCashMemoNumberTracker = false ;

                           public boolean isCashMemoNumberSpecified(){
                               return localCashMemoNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCashMemoNumber(){
                               return localCashMemoNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CashMemoNumber
                               */
                               public void setCashMemoNumber(java.lang.String param){
                            localCashMemoNumberTracker = true;
                                   
                                            this.localCashMemoNumber=param;
                                       

                               }
                            

                        /**
                        * field for CodeDesc
                        */

                        
                                    protected java.lang.String localCodeDesc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCodeDescTracker = false ;

                           public boolean isCodeDescSpecified(){
                               return localCodeDescTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCodeDesc(){
                               return localCodeDesc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CodeDesc
                               */
                               public void setCodeDesc(java.lang.String param){
                            localCodeDescTracker = true;
                                   
                                            this.localCodeDesc=param;
                                       

                               }
                            

                        /**
                        * field for ConnectionAWBNumber
                        */

                        
                                    protected java.lang.String localConnectionAWBNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConnectionAWBNumberTracker = false ;

                           public boolean isConnectionAWBNumberSpecified(){
                               return localConnectionAWBNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConnectionAWBNumber(){
                               return localConnectionAWBNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConnectionAWBNumber
                               */
                               public void setConnectionAWBNumber(java.lang.String param){
                            localConnectionAWBNumberTracker = true;
                                   
                                            this.localConnectionAWBNumber=param;
                                       

                               }
                            

                        /**
                        * field for ConnectionDate
                        */

                        
                                    protected java.util.Calendar localConnectionDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConnectionDateTracker = false ;

                           public boolean isConnectionDateSpecified(){
                               return localConnectionDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getConnectionDate(){
                               return localConnectionDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConnectionDate
                               */
                               public void setConnectionDate(java.util.Calendar param){
                            localConnectionDateTracker = true;
                                   
                                            this.localConnectionDate=param;
                                       

                               }
                            

                        /**
                        * field for ConnectionLocation
                        */

                        
                                    protected java.lang.String localConnectionLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConnectionLocationTracker = false ;

                           public boolean isConnectionLocationSpecified(){
                               return localConnectionLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConnectionLocation(){
                               return localConnectionLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConnectionLocation
                               */
                               public void setConnectionLocation(java.lang.String param){
                            localConnectionLocationTracker = true;
                                   
                                            this.localConnectionLocation=param;
                                       

                               }
                            

                        /**
                        * field for ConnectionTo
                        */

                        
                                    protected java.lang.String localConnectionTo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConnectionToTracker = false ;

                           public boolean isConnectionToSpecified(){
                               return localConnectionToTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConnectionTo(){
                               return localConnectionTo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConnectionTo
                               */
                               public void setConnectionTo(java.lang.String param){
                            localConnectionToTracker = true;
                                   
                                            this.localConnectionTo=param;
                                       

                               }
                            

                        /**
                        * field for Consignee
                        */

                        
                                    protected java.lang.String localConsignee ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConsigneeTracker = false ;

                           public boolean isConsigneeSpecified(){
                               return localConsigneeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConsignee(){
                               return localConsignee;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Consignee
                               */
                               public void setConsignee(java.lang.String param){
                            localConsigneeTracker = true;
                                   
                                            this.localConsignee=param;
                                       

                               }
                            

                        /**
                        * field for Customer
                        */

                        
                                    protected java.lang.String localCustomer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCustomerTracker = false ;

                           public boolean isCustomerSpecified(){
                               return localCustomerTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCustomer(){
                               return localCustomer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Customer
                               */
                               public void setCustomer(java.lang.String param){
                            localCustomerTracker = true;
                                   
                                            this.localCustomer=param;
                                       

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
                            localDeclaredValueTracker = true;
                                   
                                            this.localDeclaredValue=param;
                                       

                               }
                            

                        /**
                        * field for DeliveredEmployeeCode
                        */

                        
                                    protected java.lang.String localDeliveredEmployeeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeliveredEmployeeCodeTracker = false ;

                           public boolean isDeliveredEmployeeCodeSpecified(){
                               return localDeliveredEmployeeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeliveredEmployeeCode(){
                               return localDeliveredEmployeeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DeliveredEmployeeCode
                               */
                               public void setDeliveredEmployeeCode(java.lang.String param){
                            localDeliveredEmployeeCodeTracker = true;
                                   
                                            this.localDeliveredEmployeeCode=param;
                                       

                               }
                            

                        /**
                        * field for DestinationServiceCentre
                        */

                        
                                    protected java.lang.String localDestinationServiceCentre ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDestinationServiceCentreTracker = false ;

                           public boolean isDestinationServiceCentreSpecified(){
                               return localDestinationServiceCentreTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDestinationServiceCentre(){
                               return localDestinationServiceCentre;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DestinationServiceCentre
                               */
                               public void setDestinationServiceCentre(java.lang.String param){
                            localDestinationServiceCentreTracker = true;
                                   
                                            this.localDestinationServiceCentre=param;
                                       

                               }
                            

                        /**
                        * field for EntryDate
                        */

                        
                                    protected java.util.Calendar localEntryDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEntryDateTracker = false ;

                           public boolean isEntryDateSpecified(){
                               return localEntryDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getEntryDate(){
                               return localEntryDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EntryDate
                               */
                               public void setEntryDate(java.util.Calendar param){
                            localEntryDateTracker = param != null;
                                   
                                            this.localEntryDate=param;
                                       

                               }
                            

                        /**
                        * field for IConnectedLoc
                        */

                        
                                    protected java.lang.String localIConnectedLoc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIConnectedLocTracker = false ;

                           public boolean isIConnectedLocSpecified(){
                               return localIConnectedLocTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIConnectedLoc(){
                               return localIConnectedLoc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IConnectedLoc
                               */
                               public void setIConnectedLoc(java.lang.String param){
                            localIConnectedLocTracker = true;
                                   
                                            this.localIConnectedLoc=param;
                                       

                               }
                            

                        /**
                        * field for IsAccountScanDone
                        */

                        
                                    protected boolean localIsAccountScanDone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsAccountScanDoneTracker = false ;

                           public boolean isIsAccountScanDoneSpecified(){
                               return localIsAccountScanDoneTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsAccountScanDone(){
                               return localIsAccountScanDone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsAccountScanDone
                               */
                               public void setIsAccountScanDone(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsAccountScanDoneTracker =
                                       true;
                                   
                                            this.localIsAccountScanDone=param;
                                       

                               }
                            

                        /**
                        * field for IsBillScanDone
                        */

                        
                                    protected boolean localIsBillScanDone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsBillScanDoneTracker = false ;

                           public boolean isIsBillScanDoneSpecified(){
                               return localIsBillScanDoneTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsBillScanDone(){
                               return localIsBillScanDone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsBillScanDone
                               */
                               public void setIsBillScanDone(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsBillScanDoneTracker =
                                       true;
                                   
                                            this.localIsBillScanDone=param;
                                       

                               }
                            

                        /**
                        * field for IsCOD
                        */

                        
                                    protected boolean localIsCOD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsCODTracker = false ;

                           public boolean isIsCODSpecified(){
                               return localIsCODTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsCOD(){
                               return localIsCOD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsCOD
                               */
                               public void setIsCOD(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsCODTracker =
                                       true;
                                   
                                            this.localIsCOD=param;
                                       

                               }
                            

                        /**
                        * field for IsHeldAtNaka
                        */

                        
                                    protected boolean localIsHeldAtNaka ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsHeldAtNakaTracker = false ;

                           public boolean isIsHeldAtNakaSpecified(){
                               return localIsHeldAtNakaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsHeldAtNaka(){
                               return localIsHeldAtNaka;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsHeldAtNaka
                               */
                               public void setIsHeldAtNaka(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsHeldAtNakaTracker =
                                       true;
                                   
                                            this.localIsHeldAtNaka=param;
                                       

                               }
                            

                        /**
                        * field for IsJVLocation
                        */

                        
                                    protected boolean localIsJVLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsJVLocationTracker = false ;

                           public boolean isIsJVLocationSpecified(){
                               return localIsJVLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsJVLocation(){
                               return localIsJVLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsJVLocation
                               */
                               public void setIsJVLocation(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsJVLocationTracker =
                                       true;
                                   
                                            this.localIsJVLocation=param;
                                       

                               }
                            

                        /**
                        * field for IsMultipleReceipt
                        */

                        
                                    protected boolean localIsMultipleReceipt ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsMultipleReceiptTracker = false ;

                           public boolean isIsMultipleReceiptSpecified(){
                               return localIsMultipleReceiptTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsMultipleReceipt(){
                               return localIsMultipleReceipt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsMultipleReceipt
                               */
                               public void setIsMultipleReceipt(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsMultipleReceiptTracker =
                                       true;
                                   
                                            this.localIsMultipleReceipt=param;
                                       

                               }
                            

                        /**
                        * field for IsOpsScanDone
                        */

                        
                                    protected boolean localIsOpsScanDone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsOpsScanDoneTracker = false ;

                           public boolean isIsOpsScanDoneSpecified(){
                               return localIsOpsScanDoneTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsOpsScanDone(){
                               return localIsOpsScanDone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsOpsScanDone
                               */
                               public void setIsOpsScanDone(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsOpsScanDoneTracker =
                                       true;
                                   
                                            this.localIsOpsScanDone=param;
                                       

                               }
                            

                        /**
                        * field for IsReceiptEntryDone
                        */

                        
                                    protected boolean localIsReceiptEntryDone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsReceiptEntryDoneTracker = false ;

                           public boolean isIsReceiptEntryDoneSpecified(){
                               return localIsReceiptEntryDoneTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsReceiptEntryDone(){
                               return localIsReceiptEntryDone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsReceiptEntryDone
                               */
                               public void setIsReceiptEntryDone(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localIsReceiptEntryDoneTracker =
                                       true;
                                   
                                            this.localIsReceiptEntryDone=param;
                                       

                               }
                            

                        /**
                        * field for JVConfirmedEmplCode
                        */

                        
                                    protected java.lang.String localJVConfirmedEmplCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localJVConfirmedEmplCodeTracker = false ;

                           public boolean isJVConfirmedEmplCodeSpecified(){
                               return localJVConfirmedEmplCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJVConfirmedEmplCode(){
                               return localJVConfirmedEmplCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JVConfirmedEmplCode
                               */
                               public void setJVConfirmedEmplCode(java.lang.String param){
                            localJVConfirmedEmplCodeTracker = true;
                                   
                                            this.localJVConfirmedEmplCode=param;
                                       

                               }
                            

                        /**
                        * field for JVConfirmedLoc
                        */

                        
                                    protected java.lang.String localJVConfirmedLoc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localJVConfirmedLocTracker = false ;

                           public boolean isJVConfirmedLocSpecified(){
                               return localJVConfirmedLocTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJVConfirmedLoc(){
                               return localJVConfirmedLoc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JVConfirmedLoc
                               */
                               public void setJVConfirmedLoc(java.lang.String param){
                            localJVConfirmedLocTracker = true;
                                   
                                            this.localJVConfirmedLoc=param;
                                       

                               }
                            

                        /**
                        * field for JVConnectionLocation
                        */

                        
                                    protected java.lang.String localJVConnectionLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localJVConnectionLocationTracker = false ;

                           public boolean isJVConnectionLocationSpecified(){
                               return localJVConnectionLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getJVConnectionLocation(){
                               return localJVConnectionLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JVConnectionLocation
                               */
                               public void setJVConnectionLocation(java.lang.String param){
                            localJVConnectionLocationTracker = true;
                                   
                                            this.localJVConnectionLocation=param;
                                       

                               }
                            

                        /**
                        * field for LastUpdatedEmployeeName
                        */

                        
                                    protected java.lang.String localLastUpdatedEmployeeName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastUpdatedEmployeeNameTracker = false ;

                           public boolean isLastUpdatedEmployeeNameSpecified(){
                               return localLastUpdatedEmployeeNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLastUpdatedEmployeeName(){
                               return localLastUpdatedEmployeeName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastUpdatedEmployeeName
                               */
                               public void setLastUpdatedEmployeeName(java.lang.String param){
                            localLastUpdatedEmployeeNameTracker = true;
                                   
                                            this.localLastUpdatedEmployeeName=param;
                                       

                               }
                            

                        /**
                        * field for LoggedEmployeeCode
                        */

                        
                                    protected java.lang.String localLoggedEmployeeCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLoggedEmployeeCodeTracker = false ;

                           public boolean isLoggedEmployeeCodeSpecified(){
                               return localLoggedEmployeeCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLoggedEmployeeCode(){
                               return localLoggedEmployeeCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LoggedEmployeeCode
                               */
                               public void setLoggedEmployeeCode(java.lang.String param){
                            localLoggedEmployeeCodeTracker = true;
                                   
                                            this.localLoggedEmployeeCode=param;
                                       

                               }
                            

                        /**
                        * field for OctroiServiceCharge
                        */

                        
                                    protected double localOctroiServiceCharge ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiServiceChargeTracker = false ;

                           public boolean isOctroiServiceChargeSpecified(){
                               return localOctroiServiceChargeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getOctroiServiceCharge(){
                               return localOctroiServiceCharge;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OctroiServiceCharge
                               */
                               public void setOctroiServiceCharge(double param){
                            localOctroiServiceChargeTracker = true;
                                   
                                            this.localOctroiServiceCharge=param;
                                       

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
                        * field for PUDate
                        */

                        
                                    protected java.lang.String localPUDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPUDateTracker = false ;

                           public boolean isPUDateSpecified(){
                               return localPUDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPUDate(){
                               return localPUDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PUDate
                               */
                               public void setPUDate(java.lang.String param){
                            localPUDateTracker = true;
                                   
                                            this.localPUDate=param;
                                       

                               }
                            

                        /**
                        * field for ParentBatch
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.DebitSlip localParentBatch ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParentBatchTracker = false ;

                           public boolean isParentBatchSpecified(){
                               return localParentBatchTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.DebitSlip
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.DebitSlip getParentBatch(){
                               return localParentBatch;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ParentBatch
                               */
                               public void setParentBatch(org.datacontract.schemas._2004._07.bd_entities_area.DebitSlip param){
                            localParentBatchTracker = true;
                                   
                                            this.localParentBatch=param;
                                       

                               }
                            

                        /**
                        * field for Percentage
                        */

                        
                                    protected double localPercentage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPercentageTracker = false ;

                           public boolean isPercentageSpecified(){
                               return localPercentageTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getPercentage(){
                               return localPercentage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Percentage
                               */
                               public void setPercentage(double param){
                            localPercentageTracker = true;
                                   
                                            this.localPercentage=param;
                                       

                               }
                            

                        /**
                        * field for Pieces
                        */

                        
                                    protected int localPieces ;
                                
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
                           * @return int
                           */
                           public  int getPieces(){
                               return localPieces;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pieces
                               */
                               public void setPieces(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localPiecesTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localPieces=param;
                                       

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
                        * field for ReceiptNumber
                        */

                        
                                    protected java.lang.String localReceiptNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReceiptNumberTracker = false ;

                           public boolean isReceiptNumberSpecified(){
                               return localReceiptNumberTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getReceiptNumber(){
                               return localReceiptNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReceiptNumber
                               */
                               public void setReceiptNumber(java.lang.String param){
                            localReceiptNumberTracker = true;
                                   
                                            this.localReceiptNumber=param;
                                       

                               }
                            

                        /**
                        * field for ReceivedAmount
                        */

                        
                                    protected double localReceivedAmount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReceivedAmountTracker = false ;

                           public boolean isReceivedAmountSpecified(){
                               return localReceivedAmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getReceivedAmount(){
                               return localReceivedAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReceivedAmount
                               */
                               public void setReceivedAmount(double param){
                            localReceivedAmountTracker = true;
                                   
                                            this.localReceivedAmount=param;
                                       

                               }
                            

                        /**
                        * field for ReceivedDate
                        */

                        
                                    protected java.util.Calendar localReceivedDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReceivedDateTracker = false ;

                           public boolean isReceivedDateSpecified(){
                               return localReceivedDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getReceivedDate(){
                               return localReceivedDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReceivedDate
                               */
                               public void setReceivedDate(java.util.Calendar param){
                            localReceivedDateTracker = true;
                                   
                                            this.localReceivedDate=param;
                                       

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
                        * field for ServiceTax
                        */

                        
                                    protected double localServiceTax ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localServiceTaxTracker = false ;

                           public boolean isServiceTaxSpecified(){
                               return localServiceTaxTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getServiceTax(){
                               return localServiceTax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ServiceTax
                               */
                               public void setServiceTax(double param){
                            localServiceTaxTracker = true;
                                   
                                            this.localServiceTax=param;
                                       

                               }
                            

                        /**
                        * field for ShipmentType
                        */

                        
                                    protected org.datacontract.schemas._2004._07.bd_entities_area.ShipmentType localShipmentType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipmentTypeTracker = false ;

                           public boolean isShipmentTypeSpecified(){
                               return localShipmentTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.datacontract.schemas._2004._07.bd_entities_area.ShipmentType
                           */
                           public  org.datacontract.schemas._2004._07.bd_entities_area.ShipmentType getShipmentType(){
                               return localShipmentType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShipmentType
                               */
                               public void setShipmentType(org.datacontract.schemas._2004._07.bd_entities_area.ShipmentType param){
                            localShipmentTypeTracker = true;
                                   
                                            this.localShipmentType=param;
                                       

                               }
                            

                        /**
                        * field for Shipper
                        */

                        
                                    protected java.lang.String localShipper ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShipperTracker = false ;

                           public boolean isShipperSpecified(){
                               return localShipperTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getShipper(){
                               return localShipper;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Shipper
                               */
                               public void setShipper(java.lang.String param){
                            localShipperTracker = true;
                                   
                                            this.localShipper=param;
                                       

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
                        * field for StatusDateTime
                        */

                        
                                    protected java.util.Calendar localStatusDateTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusDateTimeTracker = false ;

                           public boolean isStatusDateTimeSpecified(){
                               return localStatusDateTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getStatusDateTime(){
                               return localStatusDateTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatusDateTime
                               */
                               public void setStatusDateTime(java.util.Calendar param){
                            localStatusDateTimeTracker = true;
                                   
                                            this.localStatusDateTime=param;
                                       

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
                        * field for Time
                        */

                        
                                    protected java.lang.String localTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTimeTracker = false ;

                           public boolean isTimeSpecified(){
                               return localTimeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTime(){
                               return localTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Time
                               */
                               public void setTime(java.lang.String param){
                            localTimeTracker = true;
                                   
                                            this.localTime=param;
                                       

                               }
                            

                        /**
                        * field for TypeModificationReason
                        */

                        
                                    protected java.lang.String localTypeModificationReason ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeModificationReasonTracker = false ;

                           public boolean isTypeModificationReasonSpecified(){
                               return localTypeModificationReasonTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTypeModificationReason(){
                               return localTypeModificationReason;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TypeModificationReason
                               */
                               public void setTypeModificationReason(java.lang.String param){
                            localTypeModificationReasonTracker = true;
                                   
                                            this.localTypeModificationReason=param;
                                       

                               }
                            

                        /**
                        * field for Weight
                        */

                        
                                    protected double localWeight ;
                                
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
                           * @return double
                           */
                           public  double getWeight(){
                               return localWeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Weight
                               */
                               public void setWeight(double param){
                            
                                       // setting primitive attribute tracker to true
                                       localWeightTracker =
                                       !java.lang.Double.isNaN(param);
                                   
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
                           namespacePrefix+":Octroi",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Octroi",
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
                             } if (localADCustomerCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ADCustomerCode", xmlWriter);
                             

                                          if (localADCustomerCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localADCustomerCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localADCustomerLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ADCustomerLocation", xmlWriter);
                             

                                          if (localADCustomerLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localADCustomerLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localADCustomerTypeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ADCustomerType", xmlWriter);
                             

                                          if (localADCustomerType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localADCustomerType);
                                            
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
                             } if (localAmountTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Amount", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localAmount)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAmount));
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
                             } if (localBelongsToLogInLocTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BelongsToLogInLoc", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("BelongsToLogInLoc cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBelongsToLogInLoc));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBillDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BillDate", xmlWriter);
                             

                                          if (localBillDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBillDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBillNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BillNumber", xmlWriter);
                             

                                          if (localBillNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBillNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBillScanDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BillScanDate", xmlWriter);
                             

                                          if (localBillScanDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBillScanDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBillSummaryDoneFlagTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BillSummaryDoneFlag", xmlWriter);
                             

                                          if (localBillSummaryDoneFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBillSummaryDoneFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCashMemoNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CashMemoNumber", xmlWriter);
                             

                                          if (localCashMemoNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCashMemoNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCodeDescTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CodeDesc", xmlWriter);
                             

                                          if (localCodeDesc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCodeDesc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConnectionAWBNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConnectionAWBNumber", xmlWriter);
                             

                                          if (localConnectionAWBNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConnectionAWBNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConnectionDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConnectionDate", xmlWriter);
                             

                                          if (localConnectionDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConnectionDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConnectionLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConnectionLocation", xmlWriter);
                             

                                          if (localConnectionLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConnectionLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConnectionToTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ConnectionTo", xmlWriter);
                             

                                          if (localConnectionTo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConnectionTo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConsigneeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Consignee", xmlWriter);
                             

                                          if (localConsignee==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConsignee);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCustomerTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Customer", xmlWriter);
                             

                                          if (localCustomer==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCustomer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCustomerCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "CustomerCode", xmlWriter);
                             

                                          if (localCustomerCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCustomerCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeclaredValueTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeclaredValue", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localDeclaredValue)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeclaredValue));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeliveredEmployeeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DeliveredEmployeeCode", xmlWriter);
                             

                                          if (localDeliveredEmployeeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeliveredEmployeeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDestinationServiceCentreTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "DestinationServiceCentre", xmlWriter);
                             

                                          if (localDestinationServiceCentre==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDestinationServiceCentre);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEntryDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "EntryDate", xmlWriter);
                             

                                          if (localEntryDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("EntryDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEntryDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIConnectedLocTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IConnectedLoc", xmlWriter);
                             

                                          if (localIConnectedLoc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIConnectedLoc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsAccountScanDoneTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsAccountScanDone", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsAccountScanDone cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsAccountScanDone));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsBillScanDoneTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsBillScanDone", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsBillScanDone cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsBillScanDone));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsCODTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsCOD", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsCOD cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsCOD));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsHeldAtNakaTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsHeldAtNaka", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsHeldAtNaka cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsHeldAtNaka));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsJVLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsJVLocation", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsJVLocation cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsJVLocation));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsMultipleReceiptTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsMultipleReceipt", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsMultipleReceipt cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsMultipleReceipt));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsOpsScanDoneTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsOpsScanDone", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsOpsScanDone cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOpsScanDone));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsReceiptEntryDoneTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsReceiptEntryDone", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsReceiptEntryDone cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsReceiptEntryDone));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localJVConfirmedEmplCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "JVConfirmedEmplCode", xmlWriter);
                             

                                          if (localJVConfirmedEmplCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localJVConfirmedEmplCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localJVConfirmedLocTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "JVConfirmedLoc", xmlWriter);
                             

                                          if (localJVConfirmedLoc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localJVConfirmedLoc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localJVConnectionLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "JVConnectionLocation", xmlWriter);
                             

                                          if (localJVConnectionLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localJVConnectionLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastUpdatedEmployeeNameTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LastUpdatedEmployeeName", xmlWriter);
                             

                                          if (localLastUpdatedEmployeeName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLastUpdatedEmployeeName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLoggedEmployeeCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LoggedEmployeeCode", xmlWriter);
                             

                                          if (localLoggedEmployeeCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLoggedEmployeeCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOctroiServiceChargeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "OctroiServiceCharge", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localOctroiServiceCharge)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOctroiServiceCharge));
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
                             } if (localPUDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "PUDate", xmlWriter);
                             

                                          if (localPUDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPUDate);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localParentBatchTracker){
                                    if (localParentBatch==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "ParentBatch", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localParentBatch.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ParentBatch"),
                                        xmlWriter);
                                    }
                                } if (localPercentageTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Percentage", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localPercentage)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPercentage));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPiecesTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Pieces", xmlWriter);
                             
                                               if (localPieces==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Pieces cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPieces));
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
                             } if (localReceiptNumberTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReceiptNumber", xmlWriter);
                             

                                          if (localReceiptNumber==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localReceiptNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localReceivedAmountTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReceivedAmount", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localReceivedAmount)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReceivedAmount));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localReceivedDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReceivedDate", xmlWriter);
                             

                                          if (localReceivedDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReceivedDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRemarksTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Remarks", xmlWriter);
                             

                                          if (localRemarks==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRemarks);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localServiceTaxTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ServiceTax", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localServiceTax)) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServiceTax));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShipmentTypeTracker){
                                    if (localShipmentType==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "ShipmentType", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localShipmentType.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentType"),
                                        xmlWriter);
                                    }
                                } if (localShipperTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Shipper", xmlWriter);
                             

                                          if (localShipper==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localShipper);
                                            
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
                             } if (localStatusDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusDate", xmlWriter);
                             

                                          if (localStatusDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatusDateTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "StatusDateTime", xmlWriter);
                             

                                          if (localStatusDateTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusDateTime));
                                            
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
                             } if (localTimeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Time", xmlWriter);
                             

                                          if (localTime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTypeModificationReasonTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "TypeModificationReason", xmlWriter);
                             

                                          if (localTypeModificationReason==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTypeModificationReason);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWeightTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "Weight", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localWeight)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Weight cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWeight));
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
        public static Octroi parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Octroi object =
                new Octroi();

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
                    
                            if (!"Octroi".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Octroi)org.tempuri.imports.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ADCustomerCode").equals(reader.getName()) || new javax.xml.namespace.QName("","ADCustomerCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setADCustomerCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ADCustomerLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","ADCustomerLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setADCustomerLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ADCustomerType").equals(reader.getName()) || new javax.xml.namespace.QName("","ADCustomerType").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setADCustomerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Amount").equals(reader.getName()) || new javax.xml.namespace.QName("","Amount").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAmount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setAmount(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setAmount(java.lang.Double.NaN);
                                           
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BelongsToLogInLoc").equals(reader.getName()) || new javax.xml.namespace.QName("","BelongsToLogInLoc").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"BelongsToLogInLoc" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBelongsToLogInLoc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BillDate").equals(reader.getName()) || new javax.xml.namespace.QName("","BillDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBillDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BillNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","BillNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBillNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BillScanDate").equals(reader.getName()) || new javax.xml.namespace.QName("","BillScanDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBillScanDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BillSummaryDoneFlag").equals(reader.getName()) || new javax.xml.namespace.QName("","BillSummaryDoneFlag").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBillSummaryDoneFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CashMemoNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","CashMemoNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCashMemoNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CodeDesc").equals(reader.getName()) || new javax.xml.namespace.QName("","CodeDesc").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCodeDesc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConnectionAWBNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","ConnectionAWBNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConnectionAWBNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConnectionDate").equals(reader.getName()) || new javax.xml.namespace.QName("","ConnectionDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConnectionDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConnectionLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","ConnectionLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConnectionLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ConnectionTo").equals(reader.getName()) || new javax.xml.namespace.QName("","ConnectionTo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConnectionTo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Consignee").equals(reader.getName()) || new javax.xml.namespace.QName("","Consignee").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConsignee(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Customer").equals(reader.getName()) || new javax.xml.namespace.QName("","Customer").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCustomer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","CustomerCode").equals(reader.getName()) || new javax.xml.namespace.QName("","CustomerCode").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeclaredValue").equals(reader.getName()) || new javax.xml.namespace.QName("","DeclaredValue").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeclaredValue(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setDeclaredValue(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setDeclaredValue(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DeliveredEmployeeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","DeliveredEmployeeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeliveredEmployeeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","DestinationServiceCentre").equals(reader.getName()) || new javax.xml.namespace.QName("","DestinationServiceCentre").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDestinationServiceCentre(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","EntryDate").equals(reader.getName()) || new javax.xml.namespace.QName("","EntryDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"EntryDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEntryDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IConnectedLoc").equals(reader.getName()) || new javax.xml.namespace.QName("","IConnectedLoc").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIConnectedLoc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsAccountScanDone").equals(reader.getName()) || new javax.xml.namespace.QName("","IsAccountScanDone").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsAccountScanDone" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsAccountScanDone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsBillScanDone").equals(reader.getName()) || new javax.xml.namespace.QName("","IsBillScanDone").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsBillScanDone" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsBillScanDone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsCOD").equals(reader.getName()) || new javax.xml.namespace.QName("","IsCOD").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsCOD" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsCOD(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsHeldAtNaka").equals(reader.getName()) || new javax.xml.namespace.QName("","IsHeldAtNaka").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsHeldAtNaka" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsHeldAtNaka(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsJVLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","IsJVLocation").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsJVLocation" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsJVLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsMultipleReceipt").equals(reader.getName()) || new javax.xml.namespace.QName("","IsMultipleReceipt").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsMultipleReceipt" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsMultipleReceipt(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsOpsScanDone").equals(reader.getName()) || new javax.xml.namespace.QName("","IsOpsScanDone").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsOpsScanDone" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsOpsScanDone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsReceiptEntryDone").equals(reader.getName()) || new javax.xml.namespace.QName("","IsReceiptEntryDone").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IsReceiptEntryDone" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsReceiptEntryDone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","JVConfirmedEmplCode").equals(reader.getName()) || new javax.xml.namespace.QName("","JVConfirmedEmplCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setJVConfirmedEmplCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","JVConfirmedLoc").equals(reader.getName()) || new javax.xml.namespace.QName("","JVConfirmedLoc").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setJVConfirmedLoc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","JVConnectionLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","JVConnectionLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setJVConnectionLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LastUpdatedEmployeeName").equals(reader.getName()) || new javax.xml.namespace.QName("","LastUpdatedEmployeeName").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastUpdatedEmployeeName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LoggedEmployeeCode").equals(reader.getName()) || new javax.xml.namespace.QName("","LoggedEmployeeCode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLoggedEmployeeCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiServiceCharge").equals(reader.getName()) || new javax.xml.namespace.QName("","OctroiServiceCharge").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOctroiServiceCharge(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setOctroiServiceCharge(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOctroiServiceCharge(java.lang.Double.NaN);
                                           
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","PUDate").equals(reader.getName()) || new javax.xml.namespace.QName("","PUDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPUDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ParentBatch").equals(reader.getName()) || new javax.xml.namespace.QName("","ParentBatch").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setParentBatch(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setParentBatch(org.datacontract.schemas._2004._07.bd_entities_area.DebitSlip.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Percentage").equals(reader.getName()) || new javax.xml.namespace.QName("","Percentage").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPercentage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setPercentage(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPercentage(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Pieces").equals(reader.getName()) || new javax.xml.namespace.QName("","Pieces").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Pieces" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPieces(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPieces(java.lang.Integer.MIN_VALUE);
                                           
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReceiptNumber").equals(reader.getName()) || new javax.xml.namespace.QName("","ReceiptNumber").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReceiptNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReceivedAmount").equals(reader.getName()) || new javax.xml.namespace.QName("","ReceivedAmount").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReceivedAmount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setReceivedAmount(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setReceivedAmount(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReceivedDate").equals(reader.getName()) || new javax.xml.namespace.QName("","ReceivedDate").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReceivedDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Remarks").equals(reader.getName()) || new javax.xml.namespace.QName("","Remarks").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ServiceTax").equals(reader.getName()) || new javax.xml.namespace.QName("","ServiceTax").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setServiceTax(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setServiceTax(java.lang.Double.NaN);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setServiceTax(java.lang.Double.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ShipmentType").equals(reader.getName()) || new javax.xml.namespace.QName("","ShipmentType").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setShipmentType(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setShipmentType(org.datacontract.schemas._2004._07.bd_entities_area.ShipmentType.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Shipper").equals(reader.getName()) || new javax.xml.namespace.QName("","Shipper").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShipper(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusDate").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusDate").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","StatusDateTime").equals(reader.getName()) || new javax.xml.namespace.QName("","StatusDateTime").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatusDateTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","Time").equals(reader.getName()) || new javax.xml.namespace.QName("","Time").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","TypeModificationReason").equals(reader.getName()) || new javax.xml.namespace.QName("","TypeModificationReason").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTypeModificationReason(
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
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"Weight" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWeight(java.lang.Double.NaN);
                                           
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
           
    