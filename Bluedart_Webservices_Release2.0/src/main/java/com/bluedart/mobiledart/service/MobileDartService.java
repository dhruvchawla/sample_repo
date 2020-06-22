package com.bluedart.mobiledart.service;

import java.util.List;

import com.bluedart.mobiledart.dto.MobileDartDto;
/*
 * @author CH848113
 */
public interface MobileDartService {
	public MobileDartDto trackByAwb(List<String> awbNumbers);
	public MobileDartDto intimateMe(List<String> awbNumbers,String mobileNumber);
	public MobileDartDto reverseSMS(String message,String mobileNumber);
	public boolean intimateMe();

}
