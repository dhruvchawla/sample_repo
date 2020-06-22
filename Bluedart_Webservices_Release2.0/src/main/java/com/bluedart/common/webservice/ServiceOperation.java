

/**
 * ServiceOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.bluedart.common.webservice;

    /*
     *  ServiceOperation java interface
     */

    public interface ServiceOperation {
          

        /**
          * Auto generated method signature
          * 
                    * @param oPSINBOUNDAPI0
                
         */

         
                     public org.tempuri.OPSINBOUNDAPIResponse oPSINBOUNDAPI(

                        org.tempuri.OPSINBOUNDAPI oPSINBOUNDAPI0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param oPSINBOUNDAPI0
            
          */
        public void startoPSINBOUNDAPI(

            org.tempuri.OPSINBOUNDAPI oPSINBOUNDAPI0,

            final com.bluedart.common.webservice.ServiceOperationCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAwbSryAltInstruction2
                
         */

         
                     public org.tempuri.GetAwbSryAltInstructionResponse getAwbSryAltInstruction(

                        org.tempuri.GetAwbSryAltInstruction getAwbSryAltInstruction2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAwbSryAltInstruction2
            
          */
        public void startgetAwbSryAltInstruction(

            org.tempuri.GetAwbSryAltInstruction getAwbSryAltInstruction2,

            final com.bluedart.common.webservice.ServiceOperationCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    