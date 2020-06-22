package com.bluedart.trackdart.service;

import java.util.List;

import com.bluedart.common.dto.TrackDto;
import com.bluedart.trackdart.dto.TrackEmailDto;
import com.bluedart.trackdart.dto.TrackOnMapListDto;

/**
 * 
 * @author DH839598
 * @version 0.1
 *
 */

public interface TrackingService {

	/**
	 * 
	 * @param awbNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @param awbNumber
	 * @return
	 */
	public TrackDto trackByAwbNos(List<String> awbNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber);

	/**
	 * 
	 * @param refNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @param awbNumber
	 * @return
	 */
	public TrackDto trackByRefNos(List<String> refNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber);

	/**
	 * 
	 * @param awbNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param emailId
	 * @param ipAddress
	 * @param awbNumber
	 * @return
	 */
	public TrackEmailDto trackByAwbNosByEmail(String awbNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber);

	/**
	 * 
	 * @param refNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param emailId
	 * @param ipAddress
	 * @param awbNumber
	 * @return
	 */
	public TrackEmailDto trackByRefNosByEmail(String refNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber);
	
	/**
	 * 
	 * @param awbNo
	 * @param status
	 * @return
	 */
	public TrackOnMapListDto trackOnMap(String awbNo,String status) throws Exception;
	
	/**
	 * 
	 * @param refNos
	 * @param loginId
	 * @param reqScanFlag
	 * @param ipAddress
	 * @param awbNumber
	 * @return
	 */
	public Integer intimateMe(List<String> awbNos, String emailId, String loginId, String ipAddress, String awbNoMis);

}
