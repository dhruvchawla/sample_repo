/**
 * ServicePickupOperationCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package com.bluedart.common.webservice;


/**
 *  ServicePickupOperationCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ServicePickupOperationCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ServicePickupOperationCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ServicePickupOperationCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for registerCalledPickup method
     * override this method for handling normal response from registerCalledPickup operation
     */
    public void receiveResultregisterCalledPickup(
        org.tempuri.RegisterCalledPickupResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from registerCalledPickup operation
     */
    public void receiveErrorregisterCalledPickup(java.lang.Exception e) {
    }
}
