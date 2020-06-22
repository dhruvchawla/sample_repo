package com.bluedart.common.dto;

import java.util.List;

public class GenerateRequestPdfClientDto {
	
	private static final long serialVersionUID = 192534330345341234L;
	
	// private String modifieddate; java activity
	private String cdstarea; 
	private String cdstscrcd;
	//private String cputime; Java imp;
	 private String nweight;	
	
	
	public String getAreaCode() {
		return cdstarea;
	}
	public void setAreaCode(String areaCode) {
		this.cdstarea = areaCode;
	}
	public String getServiceCentreCode() {
		return cdstscrcd;
	}
	public void setServiceCentreCode(String serviceCentreCode) {
		this.cdstscrcd = serviceCentreCode;
	}	
	
	public String getNweight() {
		return nweight;
	}
	public void setNweight(String weight) {
		this.nweight = weight;
	}
}
