package com.bluedart.maildart.dao;

import java.util.List;

import com.bluedart.common.dto.TrackDto;

/*
 * @author CH848113
 */
public interface MailDartDao {
	public int intimateMe(List<String> awbNumbers,String fromMailId);
	public TrackDto intimateMeDeliveredInfo();
	
}
