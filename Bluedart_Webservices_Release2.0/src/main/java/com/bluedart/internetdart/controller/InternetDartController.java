package com.bluedart.internetdart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.service.MISLogService;
import com.bluedart.exception.DataBaseException;
import com.bluedart.internetdart.dto.CountryListDto;
import com.bluedart.internetdart.dto.PinDescDto;
import com.bluedart.internetdart.dto.ProductMasterDto;
import com.bluedart.internetdart.dto.SearchDto;
import com.bluedart.internetdart.dto.StreamDataDto;
import com.bluedart.internetdart.dto.StreamReportDto;
import com.bluedart.internetdart.dto.ViewOnlineDto;
import com.bluedart.internetdart.service.InternetDartService;
import com.bluedart.internetdart.service.ProductMasterService;
import com.bluedart.locationfinder.service.ServiceStationService;
import com.bluedart.masters.dto.AffiliatesDto;
import com.bluedart.masters.dto.CountryMstDto;
import com.bluedart.masters.service.AffiliatesService;
import com.bluedart.masters.service.CountryMstService;
import com.bluedart.trackdart.service.FindSecurityLevelService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.ErrorMessageStatusCode;

/**
 * 
 * @author DH839598
 *
 */

@RestController
public class InternetDartController {

	private static final Logger logger = Logger.getLogger(InternetDartController.class);
	
	@Autowired
	private ServiceStationService serviceStationService;
	
	@Autowired
	private InternetDartService internetDartService;
	
	@Autowired
	private AffiliatesService affiliatesService;
	
	@Autowired
	private ProductMasterService productMasterService;
	
	@Autowired
	private FindSecurityLevelService findSecurityLevelService;
	
	@Autowired
	private CountryMstService countryMstService;
	
	@Autowired
	private MISLogService mISLogService;
	
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "/internetdart/viewonline/searchDto", method = RequestMethod.POST)
	public ViewOnlineDto viewOnline(@RequestBody SearchDto searchDto) {
		logger.debug("InternetDartController : viewOnline");
		ViewOnlineDto viewOnlineDto = null;
		try{
			viewOnlineDto = internetDartService.viewOnline(searchDto);
			if (null != viewOnlineDto) {
				viewOnlineDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
			}
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			viewOnlineDto = new ViewOnlineDto();
			viewOnlineDto.setErrorCode(dataBaseException.getErrorCode());
		} 
		return viewOnlineDto;
	}
	
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "/internetdart/downloaddata/searchDto", method = RequestMethod.POST)
	public StreamDataDto getStreamDataDto(@RequestBody SearchDto searchDto) {
		logger.debug("InternetDartController : getStreamDataDto");
		StreamDataDto streamDataDto = null;
		try{
			streamDataDto = internetDartService.getStreamDataDto(searchDto);
			if (null != streamDataDto) {
				streamDataDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
			}
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			streamDataDto = new StreamDataDto();
			streamDataDto.setErrorCode(dataBaseException.getErrorCode());
		}
		return streamDataDto;
	}
	
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "/internetdart/downloadreport/searchDto", method = RequestMethod.POST)
	public StreamReportDto getStreamReportDto(@RequestBody SearchDto searchDto) {
		logger.debug("InternetDartController : getStreamReportDto");
		
		StreamReportDto streamReportDto = null;
		try {
			streamReportDto = internetDartService.getStreamReportDto(searchDto);
			if (null != streamReportDto) {
				streamReportDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
			}
		} catch (DataBaseException dataBaseException) {
				logger.error(dataBaseException.getMessage());
				streamReportDto = new StreamReportDto();
				streamReportDto.setErrorCode(dataBaseException.getErrorCode());
		}
		return streamReportDto;
	}
	
	/**
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/internetdart/validatecity/{cityName}",  method = RequestMethod.GET, headers = "Accept=application/json")
	public String validateCity(@PathVariable String cityName) {
		logger.debug("InternetDartController : validateCity");
		String returnCityName = null;
		try{
		AreaDTO areaDTO = serviceStationService.getAreaCodes(cityName);
		if(areaDTO!=null){
			returnCityName = Constants.INTERNETDART_YES;
		} else {
			List<PinDescDto> orgDetailList = internetDartService.getServiceability(cityName);
			if(!orgDetailList.isEmpty()){
				for(PinDescDto descDto : orgDetailList){
					returnCityName = descDto.getPinCodeDesc();
				}
			} else {
				returnCityName = null;
			}
		}
		}catch(DataBaseException  dataBaseException){
			logger.error(dataBaseException.getMessage());
			returnCityName = Constants.INTERNETDART_NO;
		}
		return returnCityName;
	}
	
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/internetdart/getaffiliates/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AffiliatesDto getAffiliates(@PathVariable String loginId) {
		logger.debug("InternetDartController : getAffiliates");
		AffiliatesDto affiliatesDto = null;
		try{
			affiliatesDto = affiliatesService.getAffiliates(loginId);
			if (null != affiliatesDto) {
				affiliatesDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
			}
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			affiliatesDto = new AffiliatesDto();
			affiliatesDto.setErrorCode(dataBaseException.getErrorCode());
		}
		return affiliatesDto;
	}
	
	/**
	 * 
	 * @param all
	 * @return
	 */
	@RequestMapping(value = "/internetdart/getproductlist/{all}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ProductMasterDto getProductList(@PathVariable String all) {
		logger.debug("InternetDartController : getProductList");
		ProductMasterDto productMasterDto = null; 
		try{
			List<ProductMasterDto> productMasterDtoList = productMasterService.getAllProduct();
			if (null != productMasterDtoList && !productMasterDtoList.isEmpty()){
				productMasterDto = new ProductMasterDto();
				productMasterDto.setProductMasterDtoList(productMasterDtoList);
				productMasterDto.setErrorCode(ErrorMessageStatusCode.OK.getCode());
			}
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			productMasterDto = new ProductMasterDto();
			productMasterDto.setErrorCode(dataBaseException.getErrorCode());
		}
		return productMasterDto;
	}
	
	/**
	 * 
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/internetdart/getseclevel/{loginId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int getSecLevel(@PathVariable String loginId) {
		logger.debug("InternetDartController : getSecLevel");
		int val = 0;
		try{
			val = findSecurityLevelService.findSecurityLevel(loginId);
		}catch(DataBaseException dataBaseException) {
			logger.error(dataBaseException.getMessage());
			val = -1;
		}
		return val;
	}
	
	/**
	 * 
	 * @param areaCode
	 * @param custCode
	 * @return
	 */
	@RequestMapping(value = "/internetdart/getcustomername/{areaCode}/{custCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCustomerName(@PathVariable String areaCode,@PathVariable String custCode) {
		logger.debug("InternetDartController : getCustomerName");
		String custName = null;
		try{
			custName = internetDartService.getCustomerName(areaCode, custCode);
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			custName = null;
		}
		return custName;
	}
	
	/**
	 * 
	 * @param loginId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "/internetdart/checkflag/{loginId}/{flag}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int checkFlag(@PathVariable String loginId,@PathVariable String flag) {
		logger.debug("InternetDartController : checkFlag");
		int val = 0;
		try{
			val = internetDartService.checkFlag(loginId, flag);
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			val = -1;
		}
		return val;
	}
	
	/**
	 * 
	 * @param loginId
	 * @param filesize
	 * @return
	 */
	@RequestMapping(value = "/internetdart/savedownloadedfileize/{loginId}/{filesize}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Boolean saveDownloadedFileSizeMIS(@PathVariable String loginId,@PathVariable String filesize) {
		logger.debug("InternetDartController : checkFlag");
		Boolean isSaved = false;
		try{
			isSaved = mISLogService.saveDownloadedFileSizeMIS(loginId, Long.parseLong(filesize));
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			isSaved = false;
		}
		return isSaved;
	}
	
	@RequestMapping(value = "/internetdart/getcountrylist/{all}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CountryListDto getCountryList(@PathVariable String all) {
		logger.debug("InternetDartController : getProductList");
		CountryListDto countryMstDto = null;
		try{
			List<CountryMstDto> countryMstDtoList = countryMstService.getCountryList();
			if (null != countryMstDtoList && !countryMstDtoList.isEmpty()){
				countryMstDto = new CountryListDto();
				countryMstDto.setCountryMstDtoList(countryMstDtoList);
			}
		}catch(DataBaseException dataBaseException){
			logger.error(dataBaseException.getMessage());
			countryMstDto = new CountryListDto();
			countryMstDto.setErrorCode(dataBaseException.getErrorCode());
		}
		return countryMstDto;
	}

}
