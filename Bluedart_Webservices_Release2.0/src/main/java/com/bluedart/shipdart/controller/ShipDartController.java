/**
 * 
 */
package com.bluedart.shipdart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.shipdart.dto.MasterListDto;
import com.bluedart.shipdart.dto.ShipDartDto;
import com.bluedart.shipdart.dto.ShipDartLogDto;
import com.bluedart.shipdart.dto.StatusDto;
import com.bluedart.shipdart.dto.TrackAwbDto;
import com.bluedart.shipdart.service.ShipDartService;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * @author CH851827
 *
 */
@RestController
public class ShipDartController {
	
	private static final Logger logger = Logger.getLogger(ShipDartController.class);
	
	@Autowired
	private ShipDartService shipDartService;
	private MasterListDto masterListDto = null;		
	
	/**
	 * 
	 * @param trackAwbDto
	 * @return
	 */
	@RequestMapping(value = "/shipdart/downloadFile", method = RequestMethod.POST)
	public ResponseEntity<MasterListDto> downloadFile(@RequestBody  TrackAwbDto trackAwbDto){
			
		masterListDto = new MasterListDto();
		
		masterListDto = shipDartService.downloadFile(trackAwbDto);	
		return new ResponseEntity(masterListDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param loginId
	 * @param fileSize
	 * @return
	 */	
	@RequestMapping(value = "/shipdart/saveDownloadLog/{loginId}/{fileSize}", method = RequestMethod.GET)
	public StatusDto saveDownloadLog(@PathVariable String loginId,@PathVariable long fileSize){
	
		logger.info("ShipDartController::saveDownloadLog");
		
		StatusDto statusDto = shipDartService.saveDownloadLog(loginId, fileSize);
		statusDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return statusDto;
	}
	
	/**
	 * 
	 * @param shipDartLogDto
	 * @return
	 */

	@RequestMapping(value = "/shipdart/saveGetUploadLog", method = RequestMethod.POST)
	public ShipDartDto saveGetUploadLog(@RequestBody  ShipDartLogDto shipDartLogDto){
				
		ShipDartDto shipDartDto = shipDartService.saveGetUploadLog(shipDartLogDto);
		shipDartDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return shipDartDto;
	}
	/**
	 * 
	 * @param loginId
	 * @param logs
	 * @param fileType
	 * @return
	 */

	@RequestMapping(value = "/shipdart/getLogs/{loginId}/{logs}/{fileType}", method = RequestMethod.GET)
	public ResponseEntity<ShipDartDto> getLogs(@PathVariable String loginId,@PathVariable String logs, @PathVariable String fileType){
		
		ShipDartDto shipDartDto = shipDartService.getLogs(loginId, logs, fileType);
		
		shipDartDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
	    return new ResponseEntity(shipDartDto, HttpStatus.OK); 
	}
	/**
	 * 
	 * @param trackAwbDto
	 * @return
	 */
	@RequestMapping(value = "/shipdart/showUsage", method = RequestMethod.POST)
	public ResponseEntity<ShipDartDto> showUsage(@RequestBody  TrackAwbDto trackAwbDto){
			
		ShipDartDto shipDartDto = shipDartService.showUsage(trackAwbDto);
		
		shipDartDto.setStatusCode(ErrorMessageStatusCode.OK.getCode());
		return new ResponseEntity(shipDartDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 */

    @ExceptionHandler(DataBaseException.class)
	private ShipDartDto shipDartException(DataBaseException serviceException) {		    
	    ShipDartDto shipDartDto = new ShipDartDto();
		shipDartDto.setStatusCode(serviceException.getErrorCode());
		shipDartDto.setStatusMessage(serviceException.getErrorMessage());
	    return shipDartDto;
	}
    
    /**
     * 
     * @param serviceException
     * @return
     */
	
	@ExceptionHandler(BlueDartException.class)
	private ShipDartDto shipDartException(BlueDartException serviceException) {
		 ShipDartDto shipDartDto = new ShipDartDto();
		 shipDartDto.setStatusCode(serviceException.getErrorCode());
		 shipDartDto.setStatusMessage(serviceException.getErrorMessage());
		 return shipDartDto;
	}
	@RequestMapping(value = "/shipdart/validateLicenseKey", method = RequestMethod.POST)
	public ResponseEntity<ShipDartDto> validateLicenseKey(@RequestBody  TrackAwbDto trackAwbDto){
		ShipDartDto shipDartDto = new ShipDartDto();
		shipDartDto = shipDartService.validateLicenseKey(trackAwbDto);	
		return new ResponseEntity(shipDartDto, HttpStatus.OK);
	}
}
