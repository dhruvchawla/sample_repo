
/**
 * NFormDataEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package org.datacontract.schemas._2004._07.bd_entities_area;
            

            /**
            *  NFormDataEntity bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class NFormDataEntity extends org.datacontract.schemas._2004._07.bd_entities_common.EntityBase
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = NFormDataEntity
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Area
                Namespace Prefix = ns10
                */
            

                        /**
                        * field for BDLocation
                        */

                        
                                    protected java.lang.String localBDLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBDLocationTracker = false ;

                           public boolean isBDLocationSpecified(){
                               return localBDLocationTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBDLocation(){
                               return localBDLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BDLocation
                               */
                               public void setBDLocation(java.lang.String param){
                            localBDLocationTracker = true;
                                   
                                            this.localBDLocation=param;
                                       

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
                        * field for ExportMode
                        */

                        
                                    protected java.lang.String localExportMode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExportModeTracker = false ;

                           public boolean isExportModeSpecified(){
                               return localExportModeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getExportMode(){
                               return localExportMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExportMode
                               */
                               public void setExportMode(java.lang.String param){
                            localExportModeTracker = true;
                                   
                                            this.localExportMode=param;
                                       

                               }
                            

                        /**
                        * field for ExportPlace
                        */

                        
                                    protected java.lang.String localExportPlace ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExportPlaceTracker = false ;

                           public boolean isExportPlaceSpecified(){
                               return localExportPlaceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getExportPlace(){
                               return localExportPlace;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExportPlace
                               */
                               public void setExportPlace(java.lang.String param){
                            localExportPlaceTracker = true;
                                   
                                            this.localExportPlace=param;
                                       

                               }
                            

                        /**
                        * field for ImportMode
                        */

                        
                                    protected java.lang.String localImportMode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImportModeTracker = false ;

                           public boolean isImportModeSpecified(){
                               return localImportModeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImportMode(){
                               return localImportMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ImportMode
                               */
                               public void setImportMode(java.lang.String param){
                            localImportModeTracker = true;
                                   
                                            this.localImportMode=param;
                                       

                               }
                            

                        /**
                        * field for IsFormClosed
                        */

                        
                                    protected java.lang.String localIsFormClosed ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsFormClosedTracker = false ;

                           public boolean isIsFormClosedSpecified(){
                               return localIsFormClosedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIsFormClosed(){
                               return localIsFormClosed;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsFormClosed
                               */
                               public void setIsFormClosed(java.lang.String param){
                            localIsFormClosedTracker = true;
                                   
                                            this.localIsFormClosed=param;
                                       

                               }
                            

                        /**
                        * field for IsFormReceived
                        */

                        
                                    protected java.lang.String localIsFormReceived ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsFormReceivedTracker = false ;

                           public boolean isIsFormReceivedSpecified(){
                               return localIsFormReceivedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIsFormReceived(){
                               return localIsFormReceived;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsFormReceived
                               */
                               public void setIsFormReceived(java.lang.String param){
                            localIsFormReceivedTracker = true;
                                   
                                            this.localIsFormReceived=param;
                                       

                               }
                            

                        /**
                        * field for LandedAt
                        */

                        
                                    protected java.lang.String localLandedAt ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLandedAtTracker = false ;

                           public boolean isLandedAtSpecified(){
                               return localLandedAtTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLandedAt(){
                               return localLandedAt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LandedAt
                               */
                               public void setLandedAt(java.lang.String param){
                            localLandedAtTracker = true;
                                   
                                            this.localLandedAt=param;
                                       

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
                        * field for NFormAction
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint localNFormAction ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormActionTracker = false ;

                           public boolean isNFormActionSpecified(){
                               return localNFormActionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint getNFormAction(){
                               return localNFormAction;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormAction
                               */
                               public void setNFormAction(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint param){
                            localNFormActionTracker = true;
                                   
                                            this.localNFormAction=param;
                                       

                               }
                            

                        /**
                        * field for NFormArticles
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormArticles ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormArticlesTracker = false ;

                           public boolean isNFormArticlesSpecified(){
                               return localNFormArticlesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormArticles(){
                               return localNFormArticles;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormArticles
                               */
                               public void setNFormArticles(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormArticlesTracker = true;
                                   
                                            this.localNFormArticles=param;
                                       

                               }
                            

                        /**
                        * field for NFormAwbCnee
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormAwbCnee ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormAwbCneeTracker = false ;

                           public boolean isNFormAwbCneeSpecified(){
                               return localNFormAwbCneeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormAwbCnee(){
                               return localNFormAwbCnee;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormAwbCnee
                               */
                               public void setNFormAwbCnee(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormAwbCneeTracker = true;
                                   
                                            this.localNFormAwbCnee=param;
                                       

                               }
                            

                        /**
                        * field for NFormAwbShipper
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormAwbShipper ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormAwbShipperTracker = false ;

                           public boolean isNFormAwbShipperSpecified(){
                               return localNFormAwbShipperTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormAwbShipper(){
                               return localNFormAwbShipper;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormAwbShipper
                               */
                               public void setNFormAwbShipper(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormAwbShipperTracker = true;
                                   
                                            this.localNFormAwbShipper=param;
                                       

                               }
                            

                        /**
                        * field for NFormAwbs
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormAwbs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormAwbsTracker = false ;

                           public boolean isNFormAwbsSpecified(){
                               return localNFormAwbsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormAwbs(){
                               return localNFormAwbs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormAwbs
                               */
                               public void setNFormAwbs(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormAwbsTracker = true;
                                   
                                            this.localNFormAwbs=param;
                                       

                               }
                            

                        /**
                        * field for NFormDate
                        */

                        
                                    protected java.util.Calendar localNFormDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormDateTracker = false ;

                           public boolean isNFormDateSpecified(){
                               return localNFormDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getNFormDate(){
                               return localNFormDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormDate
                               */
                               public void setNFormDate(java.util.Calendar param){
                            localNFormDateTracker = param != null;
                                   
                                            this.localNFormDate=param;
                                       

                               }
                            

                        /**
                        * field for NFormInvoice
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormInvoice ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormInvoiceTracker = false ;

                           public boolean isNFormInvoiceSpecified(){
                               return localNFormInvoiceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormInvoice(){
                               return localNFormInvoice;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormInvoice
                               */
                               public void setNFormInvoice(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormInvoiceTracker = true;
                                   
                                            this.localNFormInvoice=param;
                                       

                               }
                            

                        /**
                        * field for NFormNo
                        */

                        
                                    protected java.lang.String localNFormNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormNoTracker = false ;

                           public boolean isNFormNoSpecified(){
                               return localNFormNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNFormNo(){
                               return localNFormNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormNo
                               */
                               public void setNFormNo(java.lang.String param){
                            localNFormNoTracker = true;
                                   
                                            this.localNFormNo=param;
                                       

                               }
                            

                        /**
                        * field for NFormOriginLocations
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormOriginLocations ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormOriginLocationsTracker = false ;

                           public boolean isNFormOriginLocationsSpecified(){
                               return localNFormOriginLocationsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormOriginLocations(){
                               return localNFormOriginLocations;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormOriginLocations
                               */
                               public void setNFormOriginLocations(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormOriginLocationsTracker = true;
                                   
                                            this.localNFormOriginLocations=param;
                                       

                               }
                            

                        /**
                        * field for NFormPieces
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint localNFormPieces ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormPiecesTracker = false ;

                           public boolean isNFormPiecesSpecified(){
                               return localNFormPiecesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint getNFormPieces(){
                               return localNFormPieces;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormPieces
                               */
                               public void setNFormPieces(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint param){
                            localNFormPiecesTracker = true;
                                   
                                            this.localNFormPieces=param;
                                       

                               }
                            

                        /**
                        * field for NFormPkgDesc
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormPkgDesc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormPkgDescTracker = false ;

                           public boolean isNFormPkgDescSpecified(){
                               return localNFormPkgDescTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormPkgDesc(){
                               return localNFormPkgDesc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormPkgDesc
                               */
                               public void setNFormPkgDesc(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormPkgDescTracker = true;
                                   
                                            this.localNFormPkgDesc=param;
                                       

                               }
                            

                        /**
                        * field for NFormProductCodes
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring localNFormProductCodes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormProductCodesTracker = false ;

                           public boolean isNFormProductCodesSpecified(){
                               return localNFormProductCodesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getNFormProductCodes(){
                               return localNFormProductCodes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormProductCodes
                               */
                               public void setNFormProductCodes(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring param){
                            localNFormProductCodesTracker = true;
                                   
                                            this.localNFormProductCodes=param;
                                       

                               }
                            

                        /**
                        * field for NFormReceipt
                        */

                        
                                    protected java.lang.String localNFormReceipt ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormReceiptTracker = false ;

                           public boolean isNFormReceiptSpecified(){
                               return localNFormReceiptTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNFormReceipt(){
                               return localNFormReceipt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormReceipt
                               */
                               public void setNFormReceipt(java.lang.String param){
                            localNFormReceiptTracker = true;
                                   
                                            this.localNFormReceipt=param;
                                       

                               }
                            

                        /**
                        * field for NFormReferenceNo
                        */

                        
                                    protected java.lang.String localNFormReferenceNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormReferenceNoTracker = false ;

                           public boolean isNFormReferenceNoSpecified(){
                               return localNFormReferenceNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNFormReferenceNo(){
                               return localNFormReferenceNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormReferenceNo
                               */
                               public void setNFormReferenceNo(java.lang.String param){
                            localNFormReferenceNoTracker = true;
                                   
                                            this.localNFormReferenceNo=param;
                                       

                               }
                            

                        /**
                        * field for NFormValues
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localNFormValues ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormValuesTracker = false ;

                           public boolean isNFormValuesSpecified(){
                               return localNFormValuesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getNFormValues(){
                               return localNFormValues;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormValues
                               */
                               public void setNFormValues(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localNFormValuesTracker = true;
                                   
                                            this.localNFormValues=param;
                                       

                               }
                            

                        /**
                        * field for NFormWeight
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localNFormWeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNFormWeightTracker = false ;

                           public boolean isNFormWeightSpecified(){
                               return localNFormWeightTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getNFormWeight(){
                               return localNFormWeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NFormWeight
                               */
                               public void setNFormWeight(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localNFormWeightTracker = true;
                                   
                                            this.localNFormWeight=param;
                                       

                               }
                            

                        /**
                        * field for OctroiCharges
                        */

                        
                                    protected com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble localOctroiCharges ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOctroiChargesTracker = false ;

                           public boolean isOctroiChargesSpecified(){
                               return localOctroiChargesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble
                           */
                           public  com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble getOctroiCharges(){
                               return localOctroiCharges;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OctroiCharges
                               */
                               public void setOctroiCharges(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble param){
                            localOctroiChargesTracker = true;
                                   
                                            this.localOctroiCharges=param;
                                       

                               }
                            

                        /**
                        * field for ReceivedFrom
                        */

                        
                                    protected java.lang.String localReceivedFrom ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localReceivedFromTracker = false ;

                           public boolean isReceivedFromSpecified(){
                               return localReceivedFromTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getReceivedFrom(){
                               return localReceivedFrom;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ReceivedFrom
                               */
                               public void setReceivedFrom(java.lang.String param){
                            localReceivedFromTracker = true;
                                   
                                            this.localReceivedFrom=param;
                                       

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
                           namespacePrefix+":NFormDataEntity",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "NFormDataEntity",
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
                             } if (localBDLocationTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "BDLocation", xmlWriter);
                             

                                          if (localBDLocation==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBDLocation);
                                            
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
                             } if (localExportModeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ExportMode", xmlWriter);
                             

                                          if (localExportMode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localExportMode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExportPlaceTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ExportPlace", xmlWriter);
                             

                                          if (localExportPlace==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localExportPlace);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImportModeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ImportMode", xmlWriter);
                             

                                          if (localImportMode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImportMode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsFormClosedTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsFormClosed", xmlWriter);
                             

                                          if (localIsFormClosed==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIsFormClosed);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsFormReceivedTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "IsFormReceived", xmlWriter);
                             

                                          if (localIsFormReceived==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIsFormReceived);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLandedAtTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LandedAt", xmlWriter);
                             

                                          if (localLandedAt==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLandedAt);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLocationCodeTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "LocationCode", xmlWriter);
                             

                                          if (localLocationCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocationCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNFormActionTracker){
                                    if (localNFormAction==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormAction", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormAction.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAction"),
                                        xmlWriter);
                                    }
                                } if (localNFormArticlesTracker){
                                    if (localNFormArticles==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormArticles", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormArticles.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormArticles"),
                                        xmlWriter);
                                    }
                                } if (localNFormAwbCneeTracker){
                                    if (localNFormAwbCnee==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormAwbCnee", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormAwbCnee.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbCnee"),
                                        xmlWriter);
                                    }
                                } if (localNFormAwbShipperTracker){
                                    if (localNFormAwbShipper==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormAwbShipper", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormAwbShipper.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbShipper"),
                                        xmlWriter);
                                    }
                                } if (localNFormAwbsTracker){
                                    if (localNFormAwbs==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormAwbs", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormAwbs.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbs"),
                                        xmlWriter);
                                    }
                                } if (localNFormDateTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NFormDate", xmlWriter);
                             

                                          if (localNFormDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("NFormDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNFormDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNFormInvoiceTracker){
                                    if (localNFormInvoice==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormInvoice", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormInvoice.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormInvoice"),
                                        xmlWriter);
                                    }
                                } if (localNFormNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NFormNo", xmlWriter);
                             

                                          if (localNFormNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNFormNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNFormOriginLocationsTracker){
                                    if (localNFormOriginLocations==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormOriginLocations", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormOriginLocations.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormOriginLocations"),
                                        xmlWriter);
                                    }
                                } if (localNFormPiecesTracker){
                                    if (localNFormPieces==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormPieces", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormPieces.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormPieces"),
                                        xmlWriter);
                                    }
                                } if (localNFormPkgDescTracker){
                                    if (localNFormPkgDesc==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormPkgDesc", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormPkgDesc.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormPkgDesc"),
                                        xmlWriter);
                                    }
                                } if (localNFormProductCodesTracker){
                                    if (localNFormProductCodes==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormProductCodes", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormProductCodes.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormProductCodes"),
                                        xmlWriter);
                                    }
                                } if (localNFormReceiptTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NFormReceipt", xmlWriter);
                             

                                          if (localNFormReceipt==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNFormReceipt);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNFormReferenceNoTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "NFormReferenceNo", xmlWriter);
                             

                                          if (localNFormReferenceNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNFormReferenceNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNFormValuesTracker){
                                    if (localNFormValues==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormValues", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormValues.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormValues"),
                                        xmlWriter);
                                    }
                                } if (localNFormWeightTracker){
                                    if (localNFormWeight==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "NFormWeight", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localNFormWeight.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormWeight"),
                                        xmlWriter);
                                    }
                                } if (localOctroiChargesTracker){
                                    if (localOctroiCharges==null){

                                        writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Area", "OctroiCharges", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOctroiCharges.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiCharges"),
                                        xmlWriter);
                                    }
                                } if (localReceivedFromTracker){
                                    namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Area";
                                    writeStartElement(null, namespace, "ReceivedFrom", xmlWriter);
                             

                                          if (localReceivedFrom==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localReceivedFrom);
                                            
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
        public static NFormDataEntity parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            NFormDataEntity object =
                new NFormDataEntity();

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
                    
                            if (!"NFormDataEntity".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (NFormDataEntity)org.tempuri.imports.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","BDLocation").equals(reader.getName()) || new javax.xml.namespace.QName("","BDLocation").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBDLocation(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ExportMode").equals(reader.getName()) || new javax.xml.namespace.QName("","ExportMode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setExportMode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ExportPlace").equals(reader.getName()) || new javax.xml.namespace.QName("","ExportPlace").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setExportPlace(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ImportMode").equals(reader.getName()) || new javax.xml.namespace.QName("","ImportMode").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImportMode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsFormClosed").equals(reader.getName()) || new javax.xml.namespace.QName("","IsFormClosed").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsFormClosed(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","IsFormReceived").equals(reader.getName()) || new javax.xml.namespace.QName("","IsFormReceived").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsFormReceived(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LandedAt").equals(reader.getName()) || new javax.xml.namespace.QName("","LandedAt").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLandedAt(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","LocationCode").equals(reader.getName()) || new javax.xml.namespace.QName("","LocationCode").equals(reader.getName()) ){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAction").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormAction").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormAction(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormAction(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormArticles").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormArticles").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormArticles(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormArticles(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbCnee").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormAwbCnee").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormAwbCnee(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormAwbCnee(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbShipper").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormAwbShipper").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormAwbShipper(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormAwbShipper(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormAwbs").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormAwbs").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormAwbs(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormAwbs(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormDate").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormDate").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"NFormDate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNFormDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormInvoice").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormInvoice").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormInvoice(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormInvoice(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormNo").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNFormNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormOriginLocations").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormOriginLocations").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormOriginLocations(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormOriginLocations(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormPieces").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormPieces").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormPieces(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormPieces(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormPkgDesc").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormPkgDesc").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormPkgDesc(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormPkgDesc(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormProductCodes").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormProductCodes").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormProductCodes(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormProductCodes(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormReceipt").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormReceipt").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNFormReceipt(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormReferenceNo").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormReferenceNo").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNFormReferenceNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormValues").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormValues").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormValues(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormValues(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","NFormWeight").equals(reader.getName()) || new javax.xml.namespace.QName("","NFormWeight").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setNFormWeight(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setNFormWeight(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","OctroiCharges").equals(reader.getName()) || new javax.xml.namespace.QName("","OctroiCharges").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOctroiCharges(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOctroiCharges(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Area","ReceivedFrom").equals(reader.getName()) || new javax.xml.namespace.QName("","ReceivedFrom").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setReceivedFrom(
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
           
    