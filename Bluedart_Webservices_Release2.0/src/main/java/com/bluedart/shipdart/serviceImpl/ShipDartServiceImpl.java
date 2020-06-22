/**
 * 
 */
package com.bluedart.shipdart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.shipdart.dao.ShipDartDao;
import com.bluedart.shipdart.dto.MasterListDto;
import com.bluedart.shipdart.dto.ShipDartDto;
import com.bluedart.shipdart.dto.ShipDartLogDto;
import com.bluedart.shipdart.dto.StatusDto;
import com.bluedart.shipdart.dto.TrackAwbDto;
import com.bluedart.shipdart.service.ShipDartService;

/**
 * @author CH851827
 *
 */
@Service
public class ShipDartServiceImpl implements ShipDartService{
	 	 
	private ShipDartDto shipDartDto = null;
	private String flag = null;
	
	@Autowired
	private ShipDartDao shipDartDao;
	
	@Override
	public MasterListDto downloadFile(TrackAwbDto trackAwbDto){
		return shipDartDao.downloadFile(trackAwbDto);
	}

	@Override
	public StatusDto saveDownloadLog(String loginId, long fileSize){
		
		return shipDartDao.saveDownloadLog(loginId, fileSize);
	}

	@Override
	public ShipDartDto saveGetUploadLog(ShipDartLogDto shipDartLogDto){	
		
		flag = shipDartDao.saveGetUploadLog(shipDartLogDto);
		
	    shipDartDto = shipDartDao.getLogs(shipDartLogDto.getLoginId(), shipDartLogDto.getLogs(), shipDartLogDto.getFileType());
		
	    if(null!= shipDartDto){
	    	shipDartDto.setFlag(flag);	
	    }
					    
		return shipDartDto;
	}
		
	@Override
	public ShipDartDto getLogs(String loginId, String logs, String fileType){
		return shipDartDao.getLogs(loginId, logs, fileType);
	}

	@Override
	public ShipDartDto showUsage(TrackAwbDto trackAwbDto){
		return shipDartDao.showUsage(trackAwbDto);
	}
	@Override
	public ShipDartDto validateLicenseKey(TrackAwbDto trackAwbDto){
		return shipDartDao.validateLicenseKey(trackAwbDto);
	}
	
}
