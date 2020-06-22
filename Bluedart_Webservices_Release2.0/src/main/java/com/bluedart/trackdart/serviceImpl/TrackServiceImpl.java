package com.bluedart.trackdart.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedart.common.dto.TrackDto;
import com.bluedart.trackdart.dao.TrackingDao;
import com.bluedart.trackdart.dto.TrackEmailDto;
import com.bluedart.trackdart.dto.TrackGpsDto;
import com.bluedart.trackdart.dto.TrackOnMapDto;
import com.bluedart.trackdart.dto.TrackOnMapListDto;
import com.bluedart.trackdart.service.TrackingService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;

/**
 * 
 * @author DH839598
 * @version 0.1
 *
 */

@Service
public class TrackServiceImpl implements TrackingService {

	private static final Logger logger = Logger.getLogger(TrackServiceImpl.class);
	
	private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

	@Autowired
	private TrackingDao trackDartDao;

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.TrackingService#trackByAwbNos(java.util.List, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public TrackDto trackByAwbNos(List<String> awbNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber) {
		logger.debug(" TrackServiceImpl : trackByAwbNos");
		return trackDartDao.trackByAwbNos(awbNos, loginId, reqScanFlag, ipAddress, awbNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.TrackingService#trackByRefNos(java.util.List, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public TrackDto trackByRefNos(List<String> refNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber) {
		logger.debug(" TrackServiceImpl : trackByRefNos");
		return trackDartDao.trackByRefNos(refNos, loginId, reqScanFlag, ipAddress, awbNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.TrackingService#trackByAwbNosByEmail(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public TrackEmailDto trackByAwbNosByEmail(String awbNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber) {
		logger.debug(" TrackServiceImpl : trackByAwbNosByEmail");
		return trackDartDao.trackByAwbNosByEmail(awbNos, loginId, reqScanFlag, emailId, ipAddress, awbNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.TrackingService#trackByRefNosByEmail(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public TrackEmailDto trackByRefNosByEmail(String refNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber) {
		logger.debug(" TrackServiceImpl : trackByRefNosByEmail");
		return trackDartDao.trackByRefNosByEmail(refNos, loginId, reqScanFlag, emailId, ipAddress, awbNumber);
	}
	
	
	@Override
	public TrackOnMapListDto trackOnMap(String awbNo,String status) throws Exception {
		logger.debug(" TrackServiceImpl : trackOnMap");
		TrackOnMapListDto trackMapServiceStationDto = trackDartDao.trackOnMap(awbNo,status);
		if(Constants.TRACK_ON_MAP_STATUS_OUTFORDELIVERY.equalsIgnoreCase(status)){
		 URI oldUri = new URI(Constants.TRACK_ON_MAP_GPS_URL);
		 String employeeCode = "";
		 Date date = null;
		 String appendEmpCodeQuery = Constants.TRACK_ON_MAP_GPS_URL_EMPCODE;
		 String appendDateQuery = Constants.TRACK_ON_MAP_GPS_URL_DATE;
		 for(TrackOnMapDto trackOnMapDto : trackMapServiceStationDto.getServiceStationsList()){
			 employeeCode = trackOnMapDto.getEmployeeCode();
			 date = DateUtil.getDateFromStringGivenFormat(trackOnMapDto.getDeliveryDate(), Constants.TRACK_ON_MAP_GPS_URL_DATEFORMAT);
		 }
	        String newQuery = oldUri.getQuery();
	        if (newQuery == null) {
	            newQuery = appendEmpCodeQuery+employeeCode+Constants.TRACK_ON_MAP_GPS_URL_AND+appendDateQuery+DateUtil.formatDateToStringGivenFormat(date, Constants.TRACK_ON_MAP_GPS_URL_DATEFORMAT);
	        } else {
	            newQuery += Constants.TRACK_ON_MAP_GPS_URL_AND + appendEmpCodeQuery+employeeCode+Constants.TRACK_ON_MAP_GPS_URL_AND+appendDateQuery+DateUtil.formatDateToStringGivenFormat(date, Constants.TRACK_ON_MAP_GPS_URL_DATEFORMAT);  
	        }
	        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
	                oldUri.getPath(), newQuery, oldUri.getFragment());
			/*System.setProperty("http.proxyHost", "proxy4.wipro.com");
			System.setProperty("http.proxyPort", "8080");
			
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy4.wipro.com", 8080));*/
			
		
			URL obj = new URL(newUri.toString());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			//HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
			con.setRequestMethod(Constants.TRACK_ON_MAP_GET_REQUEST);
			con.setRequestProperty(Constants.TRACK_ON_MAP_USER_AGENT, USER_AGENT);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		 
			JSONParser parser = new JSONParser();
			 
			Object object = parser.parse(response.toString());
			JSONArray  jsonObject = (JSONArray) object;
			 Iterator<JSONObject> iterator = jsonObject.iterator();
			 TrackGpsDto trackGpsDto =new TrackGpsDto();
			 while (iterator.hasNext()) {
				 JSONObject jsonObject2 = iterator.next();
	             trackGpsDto.setFieldExecutive(jsonObject2.get("fieldExecutive").toString());
	             trackGpsDto.setLatitude(jsonObject2.get("latitude").toString());
	             trackGpsDto.setLongitude(jsonObject2.get("longitude").toString());
	             trackGpsDto.setTrackTime(jsonObject2.get("trackTime").toString());
	             trackGpsDto.setSpeed(jsonObject2.get("speed").toString());
	             trackGpsDto.setGpsSignal(jsonObject2.get("gpsSignal").toString());
	             trackGpsDto.setBattery(jsonObject2.get("battery").toString());
			}
			 
		trackMapServiceStationDto.setTrackGpsDto(trackGpsDto);	
		}
		return trackMapServiceStationDto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bluedart.trackdart.service.TrackingService#trackByRefNos(java.util.List, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer intimateMe(List<String> awbNos, String emailId, String loginId, String ipAddress,String awbNoMis) {
		logger.debug(" TrackServiceImpl : intimateMe");
		return trackDartDao.intimateMe(awbNos, emailId, loginId, ipAddress, awbNoMis);
	}

}
