/**
 * 
 */
package com.bluedart.shipdart.dao;

import com.bluedart.shipdart.dto.MasterListDto;
import com.bluedart.shipdart.dto.ShipDartDto;
import com.bluedart.shipdart.dto.ShipDartLogDto;
import com.bluedart.shipdart.dto.StatusDto;
import com.bluedart.shipdart.dto.TrackAwbDto;



/**
 * @author CH851827
 *
 */
public interface ShipDartDao{

  	public MasterListDto downloadFile(TrackAwbDto trackAwbDto);
 
  	public StatusDto saveDownloadLog(String loginId, long fileSize);
  	
  	public ShipDartDto getLogs(String loginId, String logs, String fileType);
  	
    public ShipDartDto showUsage(TrackAwbDto trackAwbDto);
    
    public String saveGetUploadLog(ShipDartLogDto shipDartLogDto);  
    
    public ShipDartDto validateLicenseKey(TrackAwbDto trackAwbDto); 
    
}
