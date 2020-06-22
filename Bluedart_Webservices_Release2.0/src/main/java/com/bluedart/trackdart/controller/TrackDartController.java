package com.bluedart.trackdart.controller;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.TrackDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.trackdart.dto.ImageDartDto;
import com.bluedart.trackdart.dto.TrackEmailDto;
import com.bluedart.trackdart.dto.TrackOnMapListDto;
import com.bluedart.trackdart.service.ImageDartService;
import com.bluedart.trackdart.service.TrackingService;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.StringUtils;

/**
 * 
 * @author DH839598
 * @version 0.1
 *
 */

@RestController
public class TrackDartController {

	private static final Logger logger = Logger.getLogger(TrackDartController.class);

	@Autowired
	private TrackingService trackDartService;

	@Autowired
	private ImageDartService imageDartService;

	/**
	 * 
	 * @param awbNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @return
	 */
	@RequestMapping(value = "trackdart/trackbyawbnos/{awbNos}/{loginId}/{reqScanFlag}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TrackDto trackByAwbNos(@PathVariable String awbNos, @PathVariable String loginId,
			@PathVariable int reqScanFlag, @PathVariable String ipAddress) {

		logger.debug(" TrackDartController : trackByAwbNos");
		List<String> trackingAwbNoList = new ArrayList<>(Arrays.asList(awbNos.trim().split(",")));
		TrackDto trackDto = null;
		trackDto = trackDartService.trackByAwbNos(trackingAwbNoList, loginId, reqScanFlag, ipAddress, awbNos);
		trackDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return trackDto;
	}

	/**
	 * 
	 * @param refNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @return
	 */
	@RequestMapping(value = "trackdart/trackbyrefnos/{refNos}/{loginId}/{reqScanFlag}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TrackDto trackByRefNos(@PathVariable String refNos, @PathVariable String loginId,
			@PathVariable int reqScanFlag, @PathVariable String ipAddress) {
		logger.debug(" TrackDartController : trackByRefNos");
		List<String> trackingRefNoList = new ArrayList<>(Arrays.asList(refNos.trim().split(",")));
		TrackDto trackDto = null;
		trackDto = trackDartService.trackByRefNos(trackingRefNoList, loginId, reqScanFlag, ipAddress, refNos);
		trackDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return trackDto;
	}

	/**
	 * 
	 * @param awbNos
	 * @param loginId
	 * @param emailId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @return
	 */
	@RequestMapping(value = "trackdart/trackbyawbnosbyemail/{awbNos}/{loginId}/{emailId}/{reqScanFlag}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TrackEmailDto trackByAwbNosByEmail(@PathVariable String awbNos, @PathVariable String loginId,
			@PathVariable String emailId, @PathVariable int reqScanFlag, @PathVariable String ipAddress) {
		logger.debug(" TrackDartController : trackByRefNos");
		TrackEmailDto trackEmailDto = null;
		trackEmailDto = trackDartService.trackByAwbNosByEmail(awbNos, loginId, reqScanFlag, emailId, ipAddress, awbNos);
		trackEmailDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return trackEmailDto;
	}

	/**
	 * 
	 * @param refNos
	 * @param loginId
	 * @param emailId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @return
	 */
	@RequestMapping(value = "trackdart/trackbyrefnosbyemail/{refNos}/{loginId}/{emailId}/{reqScanFlag}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TrackEmailDto trackByRefNosByEmail(@PathVariable String refNos, @PathVariable String loginId,
			@PathVariable String emailId, @PathVariable int reqScanFlag, @PathVariable String ipAddress) {
		logger.debug(" TrackDartController : trackByRefNosByEmail");
		TrackEmailDto trackEmailDto = null;
		trackEmailDto = trackDartService.trackByRefNosByEmail(refNos, loginId, reqScanFlag, emailId, ipAddress, refNos);
		trackEmailDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		return trackEmailDto;
	}

	/**
	 * 
	 * @param awbNos
	 * @param ndc
	 * @return
	 */
	@RequestMapping(value = "trackdart/validateanddownloadpodimages/{awbNos}/{ndc}/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ImageDartDto validateAndDownloadPodImages(@PathVariable String awbNos, @PathVariable String ndc, @PathVariable String loginId) {
		logger.debug(" TrackDartController : validatePodImages");
		ImageDartDto imageDartDto = null;
		try{
		if(!awbNos.isEmpty() && awbNos!= null ){	
		List<ImageDartDto> imageDartDtoList = imageDartService.validateAndGetPodImages(awbNos, ndc,loginId);
		if (!StringUtils.isNullOrEmpty(imageDartDtoList)) {
			imageDartDto = new ImageDartDto();
			imageDartDto = getImage(imageDartDtoList, loginId);
			if (null != imageDartDto) {
				imageDartDto.setErrorCode("200");
			}
		}
		}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return imageDartDto;
	}
	
	/**
	 * 
	 * @param awbNo
	 * @param status
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "trackdart/trackonmap/{awbNo}/{status}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TrackOnMapListDto trackOnMap(@PathVariable String awbNo,@PathVariable String status) {
		logger.debug(" TrackDartController : trackOnMap");
		TrackOnMapListDto trackOnMapServicesDto = null;
		try{
			trackOnMapServicesDto = trackDartService.trackOnMap(awbNo,status);
			trackOnMapServicesDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
		}catch(Exception e){
			logger.error("Error " + e);
		}
		return trackOnMapServicesDto;
	}
	
	/**
	 * 
	 * @param imageDartDtoList
	 * @param loginId
	 * @return
	 */
	private ImageDartDto getImage(List<ImageDartDto> imageDartDtoList, String loginId){
		byte[] blobAsBytes = null;
		Blob imgageBlob = null;
		ImageDartDto imageDartDto = null;
		String DC_IMAGE="-DC";
		String POD_IMAGE="-POD";
		Map<String, byte[]> map = null;
		if (!StringUtils.isNullOrEmpty(imageDartDtoList)) {
			imageDartDto = new ImageDartDto();
			map = new HashMap<>();
			int i=0; 
			for(ImageDartDto dto : imageDartDtoList){
				try {
					imgageBlob = new javax.sql.rowset.serial.SerialBlob(dto.getByteImage());
					if (StringUtils.hasValid(loginId) && !"null".equalsIgnoreCase(loginId) && dto.isImagePermission()) {
						if(dto.isDCImage()){
							int blobLength = (int) imgageBlob.length();  
							blobAsBytes = imgageBlob.getBytes(1, blobLength);
							map.put(dto.getAwbNo()+DC_IMAGE+i, blobAsBytes);	
						}else{
							int blobLength = (int) imgageBlob.length();  
							blobAsBytes = imgageBlob.getBytes(1, blobLength);
							map.put(dto.getAwbNo()+POD_IMAGE+i, blobAsBytes);
						}
						
					} else {
						try{
							blobAsBytes = getCropImage(imgageBlob);	
							if (null != blobAsBytes && !dto.isDCImage()) {
								map.put(dto.getAwbNo()+POD_IMAGE+i, blobAsBytes);
							}
						}catch(Exception e){
							int blobLength = (int) imgageBlob.length();  
							blobAsBytes = imgageBlob.getBytes(1, blobLength);
							map.put(dto.getAwbNo()+POD_IMAGE+i, blobAsBytes);
							logger.error("EXCEPTION TYPE :"+e);
						}
						
						
					}
				} catch (Exception e) {
					logger.error("Error " + e);
				}  
				imageDartDto.setMap(map);
				i++;
			}
		}
		return imageDartDto;
	}

	/**
	 * 
	 * @param image
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private byte[] getCropImage(Blob image) throws IOException, SQLException {
		logger.debug(" TrackDartController : getCropImage");
		byte[] imageInByte = null;
		
			ImageIO.setUseCache(false);
			BufferedImage originalImgage = ImageIO.read(image.getBinaryStream());
			BufferedImage cropedImgage = null;
			if (originalImgage.getHeight() >= 1000) {
				cropedImgage = originalImgage.getSubimage(0, originalImgage.getHeight() - 803,
						originalImgage.getWidth(), originalImgage.getHeight() - 803);
			} else {
				cropedImgage = originalImgage.getSubimage(0, originalImgage.getHeight() - 303,
						originalImgage.getWidth(), originalImgage.getHeight() - 303);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			ImageIO.write(cropedImgage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		
		return imageInByte;
	}
	
	/**
	 * 
	 * @param awbNos
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "trackdart/intimateMe/{awbNos}/{emailId}/{loginId}/{ipAddress}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Integer intimateMe(@PathVariable String awbNos, @PathVariable String emailId, @PathVariable String loginId, @PathVariable String ipAddress) {
		logger.debug(" TrackDartController : intimateMe");
		List<String> trackingAwbNoList = new ArrayList<>(Arrays.asList(awbNos.trim().split(",")));		
		return trackDartService.intimateMe(trackingAwbNoList, emailId, loginId, ipAddress,awbNos);			
	}

	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(DataBaseException.class)
	private TrackDto TrackDartException(DataBaseException serviceException) {
		TrackDto errorDto = new TrackDto();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}
	
	/**
	 * 
	 * @param serviceException
	 * @return
	 */
	@ExceptionHandler(BlueDartException.class)
	private TrackEmailDto TrackDartException(BlueDartException serviceException) {
		TrackEmailDto errorDto = new TrackEmailDto();
		errorDto.setErrorCode(serviceException.getErrorCode());
		errorDto.setErrorMessage(serviceException.getErrorMessage());
		return errorDto;
	}

}

