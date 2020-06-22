package com.bluedart.maildart.service;

import com.bluedart.maildart.dto.MailDartDto;

/*
 * @author CH848113
 */
public interface MailDartService {
	public boolean trackByAwb(MailDartDto mailDartDto);
	public boolean trackByRef(MailDartDto mailDartDto);
	public boolean intimateMe(MailDartDto mailDartDto);
	public boolean intimateMeDeliveredInfo();
	
}
