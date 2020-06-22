package com.bluedart.utils;

import com.bluedart.exception.WSFault;

public class WSFaultFactory {

	public static WSFault getInstance(String faultCode, String faultString) {
		WSFault faultInfo = new WSFault();
		faultInfo.setFaultCode(faultCode);
		faultInfo.setFaultString(faultString);
		return faultInfo;
	}
}
