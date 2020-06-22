

/**
 * WebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.bluedart.common.webservice;

    /*
     *  WebService java interface
     */

    public interface WebService {
          

        /**
          * Auto generated method signature
          * 
                    * @param sendLeadInfoToSafire0
                
         */

         
                     public com.providian.bluedart.wipro.ws.SendLeadInfoToSafireResponseE sendLeadInfoToSafire(

                        com.providian.bluedart.wipro.ws.SendLeadInfoToSafire sendLeadInfoToSafire0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendLeadInfoToSafire0
            
          */
        public void startsendLeadInfoToSafire(

            com.providian.bluedart.wipro.ws.SendLeadInfoToSafire sendLeadInfoToSafire0,

            final com.bluedart.common.webservice.WebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    