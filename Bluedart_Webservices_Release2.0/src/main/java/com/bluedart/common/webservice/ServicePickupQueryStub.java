/**
 * ServicePickupQueryStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.bluedart.common.webservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedart.utils.C2PCConstants;
import com.bluedart.utils.C2PCPropertiesLoader;

/*
 *  ServicePickupQueryStub java implementation
 */


public class ServicePickupQueryStub extends org.apache.axis2.client.Stub
implements ServicePickupQuery{
	protected org.apache.axis2.description.AxisOperation[] _operations;

	//hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static C2PCPropertiesLoader c2pcPropertiesLoader = new C2PCPropertiesLoader();

	private static synchronized java.lang.String getUniqueSuffix(){
		// reset the counter if it is greater than 99999
		if (counter > 99999){
			counter = 0;
		}
		counter = counter + 1; 
		return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
	}


	private void populateAxisService() throws org.apache.axis2.AxisFault {

		//creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("ServicePickupQuery" + getUniqueSuffix());
		addAnonymousOperations();

		//creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutInAxisOperation();


		__operation.setName(new javax.xml.namespace.QName("http://tempuri.org/", "getTotalRateCA"));
		_service.addOperation(__operation);




		_operations[0]=__operation;
		
		
		__operation = new org.apache.axis2.description.OutInAxisOperation();


		__operation.setName(new javax.xml.namespace.QName("http://tempuri.org/", "getEDDDate"));
		_service.addOperation(__operation);




		_operations[1]=__operation;


	}

	//populates the faults
	private void populateFaults(){



	}

	/**
	 *Constructor that takes in a configContext
	 */

	public ServicePickupQueryStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint)
					throws org.apache.axis2.AxisFault {
		this(configurationContext,targetEndpoint,false);
	}


	/**
	 * Constructor that takes in a configContext  and useseperate listner
	 */
	public ServicePickupQueryStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener)
					throws org.apache.axis2.AxisFault {
		//To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);


		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
				targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


	}

	/**
	 * Default Constructor
	 */
	public ServicePickupQueryStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
		this(configurationContext,c2pcPropertiesLoader.loadC2PCProperty(C2PCConstants.uat_c2pc_servicepickupquery));
	}

	/**
	 * Default Constructor
	 */
	public ServicePickupQueryStub() throws org.apache.axis2.AxisFault {
		this(c2pcPropertiesLoader.loadC2PCProperty(C2PCConstants.uat_c2pc_servicepickupquery));
	}

	/**
	 * Constructor taking the target endpoint
	 */
	public ServicePickupQueryStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null,targetEndpoint);
	}




	/**
	 * Auto generated method signature
	 * 
	 * @see com.bluedart.common.webservice.ServicePickupQuery#getTotalRateCA
	 * @param getTotalRateCA2

	 */



	public  org.tempuri.GetTotalRateCAResponse getTotalRateCA(

			org.tempuri.GetTotalRateCA getTotalRateCA2)


					throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try{
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("http://tempuri.org/IServicePickupQuery/GetTotalRateCA");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



			addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();



			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;


			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
					getTotalRateCA2,
					optimizeContent(new javax.xml.namespace.QName("http://tempuri.org/",
							"getTotalRateCA")), new javax.xml.namespace.QName("http://tempuri.org/",
									"getTotalRateCA"));

			//adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			//execute the operation client
			_operationClient.execute(true);


			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
					org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement() ,
					org.tempuri.GetTotalRateCAResponse.class,
					getEnvelopeNamespaces(_returnEnv));


			return (org.tempuri.GetTotalRateCAResponse)object;

		}catch(org.apache.axis2.AxisFault f)
		{
               f.printStackTrace();
			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt!=null){
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"))){
					//make the fault by reflection
					try{
						java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
						//message class
						java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[]{messageClass});
						m.invoke(ex,new java.lang.Object[]{messageObject});


						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					}catch(java.lang.ClassCastException e){
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}catch (java.lang.NoSuchMethodException e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}  catch (java.lang.IllegalAccessException e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}   catch (java.lang.InstantiationException e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
					catch (Exception e) {
						e.printStackTrace();
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				}else{
					throw f;
				}
			}else{
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bluedart.common.webservice.ServicePickupQuery#startgetTotalRateCA
	 * @param getTotalRateCA2

	 */
	public  void startgetTotalRateCA(

			org.tempuri.GetTotalRateCA getTotalRateCA2,

			final com.bluedart.common.webservice.ServicePickupQueryCallbackHandler callback)

					throws java.rmi.RemoteException{

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("http://tempuri.org/IServicePickupQuery/GetTotalRateCA");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



		addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env=null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


		//Style is Doc.


		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
				getTotalRateCA2,
				optimizeContent(new javax.xml.namespace.QName("http://tempuri.org/",
						"getTotalRateCA")), new javax.xml.namespace.QName("http://tempuri.org/",
								"getTotalRateCA"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);



		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							org.tempuri.GetTotalRateCAResponse.class,
							getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgetTotalRateCA(
							(org.tempuri.GetTotalRateCAResponse)object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgetTotalRateCA(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt!=null){
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"))){
							//make the fault by reflection
							try{
								java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
								java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
								//message class
								java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetTotalRateCA"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
										new java.lang.Class[]{messageClass});
								m.invoke(ex,new java.lang.Object[]{messageObject});


								callback.receiveErrorgetTotalRateCA(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch(java.lang.ClassCastException e){
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetTotalRateCA(f);
							}
						} else {
							callback.receiveErrorgetTotalRateCA(f);
						}
					} else {
						callback.receiveErrorgetTotalRateCA(f);
					}
				} else {
					callback.receiveErrorgetTotalRateCA(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorgetTotalRateCA(axisFault);
				}
			}
		});


		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(
					_callbackReceiver);
		}

		//execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.bluedart.common.webservice.ServicePickupQuery#getEDDDate
	 * @param getEDDDate298

	 */



	public  org.tempuri.GetEDDDateResponse getEDDDate(

			org.tempuri.GetEDDDate getEDDDate298)


					throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try{
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction("http://tempuri.org/IServicePickupQuery/GetEDDDate");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



			addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();



			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;


			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
					getEDDDate298,
					optimizeContent(new javax.xml.namespace.QName("http://tempuri.org/",
							"getEDDDate")), new javax.xml.namespace.QName("http://tempuri.org/",
									"getEDDDate"));

			//adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			//execute the operation client
			_operationClient.execute(true);


			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
					org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement() ,
					org.tempuri.GetEDDDateResponse.class,
					getEnvelopeNamespaces(_returnEnv));


			return (org.tempuri.GetEDDDateResponse)object;

		}catch(org.apache.axis2.AxisFault f){

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt!=null){
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"))){
					//make the fault by reflection
					try{
						java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
						//message class
						java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[]{messageClass});
						m.invoke(ex,new java.lang.Object[]{messageObject});


						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					}catch(java.lang.ClassCastException e){
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}  catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}   catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				}else{
					throw f;
				}
			}else{
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bluedart.common.webservice.ServicePickupQuery#startgetEDDDate
	 * @param getEDDDate298

	 */
	public  void startgetEDDDate(

			org.tempuri.GetEDDDate getEDDDate298,

			final com.bluedart.common.webservice.ServicePickupQueryCallbackHandler callback)

					throws java.rmi.RemoteException{

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction("http://tempuri.org/IServicePickupQuery/GetEDDDate");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



		addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env=null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


		//Style is Doc.


		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
				getEDDDate298,
				optimizeContent(new javax.xml.namespace.QName("http://tempuri.org/",
						"getEDDDate")), new javax.xml.namespace.QName("http://tempuri.org/",
								"getEDDDate"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);



		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							org.tempuri.GetEDDDateResponse.class,
							getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgetEDDDate(
							(org.tempuri.GetEDDDateResponse)object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgetEDDDate(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt!=null){
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"))){
							//make the fault by reflection
							try{
								java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
								java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
								//message class
								java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEDDDate"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
										new java.lang.Class[]{messageClass});
								m.invoke(ex,new java.lang.Object[]{messageObject});


								callback.receiveErrorgetEDDDate(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch(java.lang.ClassCastException e){
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetEDDDate(f);
							}
						} else {
							callback.receiveErrorgetEDDDate(f);
						}
					} else {
						callback.receiveErrorgetEDDDate(f);
					}
				} else {
					callback.receiveErrorgetEDDDate(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorgetEDDDate(axisFault);
				}
			}
		});


		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(
					_callbackReceiver);
		}

		//execute the operation client
		_operationClient.execute(false);

	}



	/**
	 *  A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
		}
		return returnMap;
	}



	private javax.xml.namespace.QName[] opNameArray = null;
	private boolean optimizeContent(javax.xml.namespace.QName opName) {


		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;   
			}
		}
		return false;
	}
	//http://172.18.100.93:180/uatc2pcgama/Pickup/ServicePickupQuery.svc/basic
	private  org.apache.axiom.om.OMElement  toOM(org.tempuri.GetTotalRateCA param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(org.tempuri.GetTotalRateCA.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement  toOM(org.tempuri.GetTotalRateCAResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(org.tempuri.GetTotalRateCAResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement  toOM(org.tempuri.GetEDDDate param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(org.tempuri.GetEDDDate.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}
	private  org.apache.axiom.om.OMElement  toOM(org.tempuri.GetEDDDateResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(org.tempuri.GetEDDDateResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.tempuri.GetEDDDate param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{


		try{

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(org.tempuri.GetEDDDate.MY_QNAME,factory));
			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}


	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.tempuri.GetTotalRateCA param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{


		try{

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(org.tempuri.GetTotalRateCA.MY_QNAME,factory));
			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}


	/* methods to provide back word compatibility */




	/**
	 *  get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
		return factory.getDefaultEnvelope();
	}


	private  java.lang.Object fromOM(
			org.apache.axiom.om.OMElement param,
			java.lang.Class type,
			java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

		try {

			if (org.tempuri.GetTotalRateCA.class.equals(type)){

				return org.tempuri.GetTotalRateCA.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (org.tempuri.GetTotalRateCAResponse.class.equals(type)){

				return org.tempuri.GetTotalRateCAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (org.tempuri.GetEDDDate.class.equals(type)){

				return org.tempuri.GetEDDDate.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}
			if (org.tempuri.GetEDDDateResponse.class.equals(type)){

				return org.tempuri.GetEDDDateResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}


		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}



}

