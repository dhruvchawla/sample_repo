

/**
 * ServicePickupQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bluedart.common.webservice;

/*
 *  ServicePickupQuery java interface
 */

public interface ServicePickupQuery {


	/**
	 * Auto generated method signature
	 * 
	 * @param getTotalRateCA0

	 */


	public org.tempuri.GetTotalRateCAResponse getTotalRateCA(

			org.tempuri.GetTotalRateCA getTotalRateCA0)
					throws java.rmi.RemoteException
					;


	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param getTotalRateCA0

	 */
	public void startgetTotalRateCA(

			org.tempuri.GetTotalRateCA getTotalRateCA0,

			final com.bluedart.common.webservice.ServicePickupQueryCallbackHandler callback)

					throws java.rmi.RemoteException;


	
	  public org.tempuri.GetEDDDateResponse getEDDDate(

	           org.tempuri.GetEDDDate getEDDDate104)
	           throws java.rmi.RemoteException
	;


	
	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param getEDDDate104

	 */
	
	
	
	
	public void startgetEDDDate(

			org.tempuri.GetEDDDate getEDDDate104,

			final com.bluedart.common.webservice.ServicePickupQueryCallbackHandler callback)

					throws java.rmi.RemoteException;





	//
}
