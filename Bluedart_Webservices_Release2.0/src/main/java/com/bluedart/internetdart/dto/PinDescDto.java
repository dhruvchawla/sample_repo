package com.bluedart.internetdart.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author DH839598
 *
 */
public class PinDescDto  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String pinCodeDesc;
	private List<PinDescDto> pinDescDtoList;
	
	/**
	 * @return the pinCodeDesc
	 */
	public String getPinCodeDesc() {
		return pinCodeDesc;
	}
	/**
	 * @param pinCodeDesc the pinCodeDesc to set
	 */
	public void setPinCodeDesc(String pinCodeDesc) {
		this.pinCodeDesc = pinCodeDesc;
	}
	/**
	 * @return the pinDescDtoList
	 */
	public List<PinDescDto> getPinDescDtoList() {
		return pinDescDtoList;
	}
	/**
	 * @param pinDescDtoList the pinDescDtoList to set
	 */
	public void setPinDescDtoList(List<PinDescDto> pinDescDtoList) {
		this.pinDescDtoList = pinDescDtoList;
	}

	 
	
	

}
