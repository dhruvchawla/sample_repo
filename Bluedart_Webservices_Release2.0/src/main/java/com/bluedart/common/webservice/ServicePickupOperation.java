/**
 * ServicePickupOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package com.bluedart.common.webservice;


/*
 *  ServicePickupOperation java interface
 */
public interface ServicePickupOperation {
    /**
     * Auto generated method signature
     *
     * @param registerCalledPickup0
     */
    public org.tempuri.RegisterCalledPickupResponse registerCalledPickup(
        org.tempuri.RegisterCalledPickup registerCalledPickup0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param registerCalledPickup0
     */
    public void startregisterCalledPickup(
        org.tempuri.RegisterCalledPickup registerCalledPickup0,
        final com.bluedart.common.webservice.ServicePickupOperationCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
