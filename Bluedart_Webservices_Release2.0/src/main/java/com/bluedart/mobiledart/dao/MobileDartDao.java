package com.bluedart.mobiledart.dao;

import java.util.List;

import com.bluedart.common.dto.TrackDto;
public interface MobileDartDao {
	public int intimateMe(List<String> awbNumbers,String mobileNumber);
	public int reverseSMS(String message,String mobileNumber);
	public TrackDto intimateMe();
}
