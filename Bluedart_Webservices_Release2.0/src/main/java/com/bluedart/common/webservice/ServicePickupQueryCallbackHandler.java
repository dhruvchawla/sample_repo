
/**
 * ServicePickupQueryCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bluedart.common.webservice;

/**
 *  ServicePickupQueryCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ServicePickupQueryCallbackHandler{



	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the NonBlocking
	 * Web service call is finished and appropriate method of this CallBack is called.
	 * @param clientData Object mechanism by which the user can pass in user data
	 * that will be avilable at the time this callback is called.
	 */
	public ServicePickupQueryCallbackHandler(Object clientData){
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public ServicePickupQueryCallbackHandler(){
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */

	public Object getClientData() {
		return clientData;
	}


	/**
	 * auto generated Axis2 call back method for getTotalRateCA method
	 * override this method for handling normal response from getTotalRateCA operation
	 */
	public void receiveResultgetTotalRateCA(
			org.tempuri.GetTotalRateCAResponse result
			) {
	}

	/**
	 * auto generated Axis2 Error handler
	 * override this method for handling error response from getTotalRateCA operation
	 */
	public void receiveErrorgetTotalRateCA(java.lang.Exception e) {
	}
	
	/**
     * auto generated Axis2 call back method for getEDDDate method
     * override this method for handling normal response from getEDDDate operation
     */
    public void receiveResultgetEDDDate(
             org.tempuri.GetEDDDateResponse result
                 ) {
    }

   /**
    * auto generated Axis2 Error handler
    * override this method for handling error response from getEDDDate operation
    */
     public void receiveErrorgetEDDDate(java.lang.Exception e) {
     }

}
