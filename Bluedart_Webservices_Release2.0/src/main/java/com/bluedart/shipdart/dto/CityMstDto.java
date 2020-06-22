/**
 * 
 */
package com.bluedart.shipdart.dto;

import java.io.Serializable;

/**
 * @author CH851827
 *
 */
public class CityMstDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String ccitycode;
	private String ccityname;
	private String ccntrycode;
	private String ccntryname;
		
	public String getCcntryname() {
		return ccntryname;
	}
	public void setCcntryname(String ccntryname) {
		this.ccntryname = ccntryname;
	}
	public String getCcitycode() {
		return ccitycode;
	}
	public void setCcitycode(String ccitycode) {
		this.ccitycode = ccitycode;
	}
	public String getCcityname() {
		return ccityname;
	}
	public void setCcityname(String ccityname) {
		this.ccityname = ccityname;
	}
	public String getCcntrycode() {
		return ccntrycode;
	}
	public void setCcntrycode(String ccntrycode) {
		this.ccntrycode = ccntrycode;
	}
	@Override
	public String toString() {
		return "CityMstDto [ccitycode=" + ccitycode + ", ccityname="
				+ ccityname + ", ccntrycode=" + ccntrycode + ", ccntryname="
				+ ccntryname + "]";
	}
	
}
