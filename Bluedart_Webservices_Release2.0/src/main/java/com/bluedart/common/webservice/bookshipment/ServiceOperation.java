

/**
 * ServiceOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.bluedart.common.webservice.bookshipment;

    /*
     *  ServiceOperation java interface
     */

    public interface ServiceOperation {
          

        /**
          * Auto generated method signature
          * 
                    * @param waybillGenerationForWebsite0
                
         */

         
                     public org.tempuri.WaybillGenerationForWebsiteResponse waybillGenerationForWebsite(

                        org.tempuri.WaybillGenerationForWebsite waybillGenerationForWebsite0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param waybillGenerationForWebsite0
            
          */
        public void startwaybillGenerationForWebsite(

            org.tempuri.WaybillGenerationForWebsite waybillGenerationForWebsite0,

            final com.bluedart.common.webservice.bookshipment.ServiceOperationCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    