package com.bluedart.maildart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.maildart.dto.MailDartDto;
import com.bluedart.maildart.helper.MailDartHelper;
import com.bluedart.maildart.service.MailDartService;

/*
 * @author CH848113
 */
@Service
public class MailDartServiceImpl implements MailDartService{

	@Autowired
	private MailDartHelper mailDartHelper;
	
	
	@Override
	public boolean trackByAwb(MailDartDto mailDartDto){
		return mailDartHelper.trackByAwb(mailDartDto);
	}

	

	@Override
	public boolean trackByRef(MailDartDto mailDartDto) {
		return mailDartHelper.trackByRef(mailDartDto);
	}



	@Override
	public boolean intimateMe(MailDartDto mailDartDto) {
		return mailDartHelper.intimateMe(mailDartDto);
	}



	@Override
	public boolean intimateMeDeliveredInfo(){
		return  mailDartHelper.intimateMeDeliveredInfo();
	}



	

	
	


	

}
