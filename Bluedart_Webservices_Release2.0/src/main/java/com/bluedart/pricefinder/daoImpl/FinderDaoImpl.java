package com.bluedart.pricefinder.daoImpl;

import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.common.webservice.FinderHandler;
import com.bluedart.common.webservice.FinderServiceFault;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.exception.FinderServiceException;
import com.bluedart.locationfinder.dao.ServiceStationDao;
import com.bluedart.locationfinder.dto.LocationFinderDto;
import com.bluedart.locationfinder.dto.ServiceStationDTO;
import com.bluedart.pricefinder.dao.FinderDao;
import com.bluedart.pricefinder.dto.AddressBookDto;
import com.bluedart.pricefinder.dto.ProductServicesDTO;
import com.bluedart.pricefinder.dto.RateAndTransitDTO;
import com.bluedart.pricefinder.dto.RateInputDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.Converter;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.OracleConnection;

/**
 * @author Subhransu Maharana
 * This is DAO implementation class which extends the DAO interface. 
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class FinderDaoImpl extends BaseDaoImpl implements FinderDao {

	private static Logger log = Logger.getLogger(FinderDaoImpl.class.getName());
	
	@Autowired
	private ServiceStationDao serviceStationDao;
	@Autowired
	Environment environment;

	
	/**
	 * @Description This Method returns the List of transitTime for the base
	 */
	@Transactional
	@Override
	public RateAndTransitDTO findTransitTimePrice(RateAndTransitDTO rateAndTransitDTO){
		
		log.debug(" FinderDaoImpl : findTransitTimePrice");
		
		rateAndTransitDTO.setError(false);
		rateAndTransitDTO.setServiceable(true);

		// --------------------------------------------
		// Check Pincode Serviceability
		// --------------------------------------------
		// ---------------------------------------------
		// Check Origin Pincode
		// ---------------------------------------------
		LocationFinderDto locationFinderDto;
			
			if (!StringUtils.isEmpty(rateAndTransitDTO.getOriginAddress().getPincode())) {
				try{
				locationFinderDto = serviceStationDao
						.getServiceStationsByPincode(rateAndTransitDTO.getOriginAddress().getPincode());
				List<ServiceStationDTO> originDtos = locationFinderDto.getServiceStationDTOList();
				if (originDtos == null || CollectionUtils.isEmpty(originDtos)) {
					rateAndTransitDTO.setError(true);
					rateAndTransitDTO.setErrorCode(Constants.FINDER_ORIGIN_ERRORCODE);
					rateAndTransitDTO.setErrorMessage(Constants.FINDER_ORIGIN_ERROR_MSG);
					return rateAndTransitDTO;
				} else {
					rateAndTransitDTO.setOriginAreaCode(originDtos.get(0).getAreaCode());
					rateAndTransitDTO.getOriginAddress().setCity(originDtos.get(0).getAreaCity());
					rateAndTransitDTO.setOriginServiceCenterCode(Constants.EMPTY_STRING);
				}}
				catch(DataBaseException e)
				{
					e.printStackTrace();
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured in Origin Location : " + e.getMessage());
					throw new DataBaseException(e.getErrorCode(),e.getErrorMessage());

				}
			} else  {
				try{
				AreaDTO originAreaDto = serviceStationDao
						.getAreaCodes(rateAndTransitDTO.getOriginAddress().getCity().toUpperCase());
				if (originAreaDto == null) {
					rateAndTransitDTO.setError(true);
					rateAndTransitDTO.setErrorCode(Constants.FINDER_ORIGIN_ERRORCODE);
					rateAndTransitDTO.setErrorMessage(Constants.FINDER_ORIGIN_ERROR_MSG);
					return rateAndTransitDTO;
				}
				
				rateAndTransitDTO.setOriginAreaCode(originAreaDto.getCarea());
				rateAndTransitDTO.getOriginAddress().setCity(originAreaDto.getCareacity());
				rateAndTransitDTO.setOriginServiceCenterCode(originAreaDto.getCscrcd());
				}catch(DataBaseException e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured in Origin Location : " + e.getMessage());
					throw new DataBaseException(e.getErrorCode(),e.getErrorMessage());

				}
			}
			// ---------------------------------------------
			// Check Destination Pincode
			// ---------------------------------------------
	
			// If destination is in india ("IN"/"")
			if (Constants.INDIA_COUNTRYCODE.equalsIgnoreCase(rateAndTransitDTO.getDestinationAddress().getCountryCode())
					|| StringUtils.isEmpty(rateAndTransitDTO.getDestinationAddress().getCountryCode())) {
				if (!StringUtils.isEmpty(rateAndTransitDTO.getDestinationAddress().getPincode())) {
					log.debug("indian destination with pincode..");
					try{
					locationFinderDto = serviceStationDao
							.getServiceStationsByPincode(rateAndTransitDTO.getDestinationAddress().getPincode());
					List<ServiceStationDTO> destinationDtos = locationFinderDto.getServiceStationDTOList();
					if (destinationDtos == null || CollectionUtils.isEmpty(destinationDtos)){
						rateAndTransitDTO.setError(true);
						rateAndTransitDTO.setErrorCode(Constants.FINDER_DESTINATION_ERRORCODE);
						rateAndTransitDTO.setErrorMessage(Constants.FINDER_DESTINATION_ERROR_MSG);
						return rateAndTransitDTO;
						
					}
					rateAndTransitDTO.setDestinationAreaCode(destinationDtos.get(0).getAreaCode());
					rateAndTransitDTO.getDestinationAddress().setCity(destinationDtos.get(0).getAreaCity());
					rateAndTransitDTO.setDestinationServiceCenterCode(Constants.EMPTY_STRING);}
					catch(DataBaseException e)
					{
						log.error("EXCEPTION TYPE :",e);
						log.error("Error Occured in Destination Location : " + e.getMessage());
						throw new DataBaseException(e.getErrorCode(),e.getErrorMessage());

					}
					
				} else {
					
					
					try{
					AreaDTO destinationAreaDto = serviceStationDao
							.getAreaCodes(rateAndTransitDTO.getDestinationAddress().getCity().toUpperCase());
					if (destinationAreaDto == null) {
						rateAndTransitDTO.setError(true);
						rateAndTransitDTO.setErrorCode(Constants.FINDER_DESTINATION_ERRORCODE);
						rateAndTransitDTO.setErrorMessage(Constants.FINDER_DESTINATION_ERROR_MSG);
						return rateAndTransitDTO;

					}
					rateAndTransitDTO.setDestinationAreaCode(destinationAreaDto.getCarea());
					rateAndTransitDTO.getDestinationAddress().setCity(destinationAreaDto.getCareacity());
					rateAndTransitDTO.setDestinationServiceCenterCode(destinationAreaDto.getCscrcd());
					}
					catch(DataBaseException e)
					{
						log.error("EXCEPTION TYPE :",e);
						log.error("Error Occured in Destination Location : " + e.getMessage());
						throw new DataBaseException(e.getErrorCode(),e.getErrorMessage());

					}
				}
			} else {
				// If destination is international
				try{
				String destinationAreaCode = serviceStationDao.getInternationalCityCode(
						rateAndTransitDTO.getDestinationAddress().getPincode(),
						rateAndTransitDTO.getDestinationAddress().getCountryCode(),
						rateAndTransitDTO.getDestinationAddress().getCity());
				if (Constants.EMPTY_STRING.equalsIgnoreCase(destinationAreaCode)) {
					rateAndTransitDTO.setError(true);
					rateAndTransitDTO.setErrorCode(Constants.FINDER_DESTINATION_ERRORCODE);
					rateAndTransitDTO.setErrorMessage(Constants.FINDER_DESTINATION_ERROR_MSG);
					return rateAndTransitDTO;

				}
				rateAndTransitDTO.setDestinationAreaCode(destinationAreaCode);
				rateAndTransitDTO.setDestinationServiceCenterCode(Constants.EMPTY_STRING);
				AddressBookDto addressBookDto = rateAndTransitDTO.getDestinationAddress();
				addressBookDto.setPincode(Constants.EMPTY_STRING);
				rateAndTransitDTO.setDestinationAddress(addressBookDto);
				}
				catch(DataBaseException e)
				{
					log.error("EXCEPTION TYPE :",e);
					log.error("Error Occured in Destination Location(International) : " + e.getMessage());
					throw new DataBaseException(e.getErrorCode(),e.getErrorMessage());

				}
				
			}
			// ------------------------------------------
			// Get Transit Time & Price For Base Products Details
			// ------------------------------------------
			
			return getProductServicesList(rateAndTransitDTO);
		
	} 

	
	/**
	 * 
	 * @param rateTransitDTO
	 * @return
	 * @Description This Method calculates the transit time and internally calls a private method to fetch the approximate price.
	 */
	public RateAndTransitDTO getProductServicesList(RateAndTransitDTO rateTransitDTO){
		
		log.debug(" FinderDaoImpl : getProductServicesList");
		
		String[] baseProdList = { Constants.PRODCODE_DOMESTIC, Constants.PRODCODE_APEX, Constants.PRODCODE_EXPRESS,
				Constants.PRODCODE_INTERNATIONAL };
		String[] baseProdNameList = { Constants.BASE_PRODUCT_DOCUMENT, Constants.BASE_PRODUCT_AIR_PACKAGE, Constants.BASE_PRODUCT_GROUND_PACKAGE, Constants.BASE_PRODUCT_INTERNATIONAL_NONDOCUMENTS,
				Constants.BASE_PRODUCT_INTERNATIONAL_DOCUMENTS };
		List<ProductServicesDTO> productServicesDTOsResult = new ArrayList<>();

		if (rateTransitDTO.isServiceable()) {
			String getTransitTimeSql = "{call NEWTTC.pr_ttc_list(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				getSession().doWork(new Work() {

					CallableStatement cs = null;
					OracleConnection oracleConnection = null;

					@Override
					public void execute(Connection connection) throws SQLException {

						try {
							oracleConnection = (OracleConnection) connection.getMetaData().getConnection();
							Struct[] structArray = new Struct[baseProdList.length];
							for (int j = 0; j < structArray.length; j++) {
								String[] str = { baseProdList[j] };
								Struct struct = oracleConnection.createStruct(environment.getProperty("newttc.input.obj"), str);
								structArray[j] = struct;
							}
							Array arrayToPass = oracleConnection.createOracleArray(environment.getProperty("newttc.input.type"),
									structArray);
							cs = connection.prepareCall(getTransitTimeSql);
							cs.setArray(1, arrayToPass);// Product Array
							cs.setString(2, rateTransitDTO.getOriginAreaCode().toUpperCase());
							cs.setString(3, rateTransitDTO.getOriginServiceCenterCode().toUpperCase());
							cs.setString(4, rateTransitDTO.getDestinationAreaCode().toUpperCase());
							cs.setString(5, rateTransitDTO.getDestinationServiceCenterCode().toUpperCase());
							cs.setDate(6,
									DateUtil.convertSQLDateGivenFormat(rateTransitDTO.getBookingDate(), "MM/dd/yyyy"));
							cs.setString(7, rateTransitDTO.getBookingTime());
							cs.setString(9, Constants.EMPTY_STRING);
							cs.setString(10, Constants.EMPTY_STRING);// P or D
							cs.setString(11, Constants.EMPTY_STRING);
							cs.setString(12, Constants.EMPTY_STRING);
							cs.setString(13, Constants.EMPTY_STRING);
							cs.registerOutParameter(8, OracleTypes.ARRAY, environment.getProperty("newttc.output.type"));
							cs.execute();
							
							Array resultArray = cs.getArray(8);
							Object[] arrOfProducts = (Object[]) resultArray.getArray();
							ProductServicesDTO productServicesDTO;
							RateInputDto rateInputDto = null;
							boolean isDestinationInternational = Constants.INDIA_COUNTRYCODE
									.equalsIgnoreCase(rateTransitDTO.getDestinationAddress().getCountryCode())
									|| StringUtils.isEmpty(rateTransitDTO.getDestinationAddress().getCountryCode())
											? false : true;
							int strt = isDestinationInternational ? 3 : 0;
							int end = isDestinationInternational ? 4 : 3;
							for (int j = strt; (j < end) && (!rateTransitDTO.isError()); j++) {
								productServicesDTO = new ProductServicesDTO();
								Struct struct2 = (Struct) arrOfProducts[j];
								Object[] fields = struct2.getAttributes();
								// Dummy Product Type ,insurance and
								// CustomerCode
								String prodType = Constants.DUMMY_PRODTYPE;
								String insurance = Constants.DUMMY_INSURANCE;
								String customerCode = Constants.DUMMY_CUSTOMERCODE;
								rateTransitDTO.setCustomerCode(customerCode);
								double approxPrice;
							

								productServicesDTO.setProductName(baseProdNameList[j]);
								productServicesDTO.setProductCode(Converter.objToString(fields[0]));
								///here to change
								
								rateTransitDTO.setProductCode(productServicesDTO.getProductCode());
								if( !StringUtils.isEmpty(rateTransitDTO.getDestinationAddress().getCountryCode()) && !Constants.INDIA_COUNTRYCODE
										.equalsIgnoreCase(rateTransitDTO.getDestinationAddress().getCountryCode())){
									productServicesDTO
									.setExpectedDateOfDel(Converter.objToString(fields[1]).substring(0, 11));
								}else{
									String expectedDateOfDel=findTransitTimeFromC2pc(rateTransitDTO);
									productServicesDTO.setExpectedDateOfDel(expectedDateOfDel);
								}
								boolean isApex = Constants.PRODCODE_APEX
										.equalsIgnoreCase(productServicesDTO.getProductCode());
								boolean isExpress = Constants.PRODCODE_EXPRESS
										.equalsIgnoreCase(productServicesDTO.getProductCode());

								double minChargebleWeight = (isApex || isExpress) ? 10.0 : 0.5;

								productServicesDTO.setMinChargebleWeight(minChargebleWeight);

								rateInputDto = new RateInputDto();
								rateInputDto.setCustomerCode(rateTransitDTO.getCustomerCode());
								rateInputDto.setProductCode(productServicesDTO.getProductCode());
								rateInputDto.setProductType(prodType);
								rateInputDto.setOriginAreaCode(rateTransitDTO.getOriginAreaCode());
								rateInputDto.setDestinationAreaCode(rateTransitDTO.getDestinationAreaCode());
								String destPincode = rateTransitDTO.getDestinationAddress().getPincode();
								rateInputDto.setDestinationPincode(
										Constants.NULL_STRING.equalsIgnoreCase(String.valueOf(destPincode)) ? Constants.EMPTY_STRING : destPincode);
								rateInputDto.setInsurance(insurance);
								rateInputDto.setActualWeight(rateTransitDTO.getActualWeight());
								approxPrice = findPriceFromC2pc(rateInputDto,isDestinationInternational,productServicesDTO.getProductName());
								productServicesDTO.setApproxPrice(approxPrice);
								if (isDestinationInternational) {
									ProductServicesDTO internationalDocumentDTOProdType1 = new ProductServicesDTO();
									CopyUtils.copy(productServicesDTO, internationalDocumentDTOProdType1);
									internationalDocumentDTOProdType1.setProductName(baseProdNameList[4]);
									double approxPriceDoc = findPriceFromC2pc(rateInputDto,isDestinationInternational,Constants.BASE_PRODUCT_INTERNATIONAL_DOCUMENTS);
									internationalDocumentDTOProdType1.setApproxPrice(approxPriceDoc);
									productServicesDTOsResult.add(internationalDocumentDTOProdType1);
								}
								productServicesDTOsResult.add(productServicesDTO);
							}
						}
						catch(BlueDartException e) {
							e.printStackTrace();
							log.error("EXCEPTION TYPE :",e);
							log.error("Error: "+e.getErrorCode());
							throw new BlueDartException(e.getErrorCode(), e.getErrorMessage());
						}
						catch(Exception e) {
							e.printStackTrace();
							log.error("EXCEPTION TYPE :",e);
						
						
						}
						finally{
							log.debug("----------getProductServicesList finally---------");
							CloseConnections.closeCallableStatement(cs);
							
						}
						
					}
				});
			} catch (HibernateException e) {
				log.error("EXCEPTION TYPE :",e);
				//log.error("Error : "+e);
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR_TTF.getCode(), ErrorMessageStatusCode.DB_ERROR_TTF.getDescription());
			}
		}

		if (rateTransitDTO.isError()) {
			FinderServiceFault fault = getFaultInstance(rateTransitDTO.getErrorCode(),
					rateTransitDTO.getErrorMessage());
			throw new BlueDartException("C2PC Fault Occured", fault.getFaultString());
		}
		rateTransitDTO.setProductServicesDTOs(productServicesDTOsResult);		
		return rateTransitDTO;
	}

	/**
	 * 
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 * @Description This method returns the fault details
	 */
	private FinderServiceFault getFaultInstance(String errorCode, String errorMsg) {
		FinderServiceFault fault = new FinderServiceFault();
		fault.setFaultCode(errorCode);
		fault.setFaultString(errorMsg);
		return fault;
	}

	/**
	 * 
	 * @param rateInputDto
	 * @param isDestinationInternational
	 * @return
	 * @Description This method returns the approximate price calculated from C2PC
	 */
   private double findPriceFromC2pc(RateInputDto rateInputDto,boolean isDestinationInternational,String productName) 
   {
	   double approxPriceC2pc;
	   try {
			// C2PC call here
		   approxPriceC2pc = FinderHandler.findRate(rateInputDto);
			if (isDestinationInternational) {
				
				if(Constants.BASE_PRODUCT_INTERNATIONAL_DOCUMENTS.equalsIgnoreCase(productName))
				{
					rateInputDto.setProductType(Constants.PRODUCTTYPE_1);
				}
				
				approxPriceC2pc = FinderHandler.findRate(rateInputDto);
			}
		} catch (RemoteException e) {
			log.error("EXCEPTION TYPE :",e);
			//log.error("c2pc remote error : ", e);
			throw new BlueDartException(ErrorMessageStatusCode.FINDER_C2PC_REMOTE_ERROR.getCode(), ErrorMessageStatusCode.FINDER_C2PC_REMOTE_ERROR.getDescription());
		} catch (FinderServiceException e) {
			log.error("EXCEPTION TYPE :",e);
		//	log.error("Error : "+e);
			String code = e.getFaultInfo().getFaultCode();
			switch (code) {
			case Constants.FINDER_ORIGIN_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.ORIGIN_NOT_SERVICEABLE.getCode(), ErrorMessageStatusCode.ORIGIN_NOT_SERVICEABLE.getDescription());

			case Constants.FINDER_DESTINATION_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.DESTINATION_NOT_SERVICEABLE.getCode(), ErrorMessageStatusCode.DESTINATION_NOT_SERVICEABLE.getDescription());

			case Constants.FINDER_C2PC_INVALID_PINCODE_ERROR:
				throw new BlueDartException(ErrorMessageStatusCode.INVALID_PINCODE.getCode(), ErrorMessageStatusCode.INVALID_PINCODE.getDescription());

				
			case Constants.FINDER_DESTINATION_INTL_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.INVALID_PINCODE.getCode(), ErrorMessageStatusCode.INVALID_PINCODE.getDescription());

			default:
				throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(), ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			}

		}
	return approxPriceC2pc;
   }
   
   private String findTransitTimeFromC2pc(RateAndTransitDTO rateAndTransitDTO) 
   {
	   String trasitTime;
	   try {
			// C2PC call here
		  String originPincode = rateAndTransitDTO.getOriginAddress().getPincode();
		  String destinationPincode = rateAndTransitDTO.getDestinationAddress().getPincode();
		  // String pincode ="400098"; 
		   trasitTime = FinderHandler.findTransitTime(rateAndTransitDTO,originPincode,destinationPincode);
			
		} catch (RemoteException e) {
			log.error("c2pc remote error : ", e);
			throw new BlueDartException(ErrorMessageStatusCode.FINDER_C2PC_REMOTE_ERROR.getCode(), ErrorMessageStatusCode.FINDER_C2PC_REMOTE_ERROR.getDescription());
		} catch (FinderServiceException e) {
			log.error("Error : "+e);
			String code = e.getFaultInfo().getFaultCode();
			switch (code) {
			case Constants.FINDER_ORIGIN_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.ORIGIN_NOT_SERVICEABLE.getCode(), ErrorMessageStatusCode.ORIGIN_NOT_SERVICEABLE.getDescription());

			case Constants.FINDER_DESTINATION_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.DESTINATION_NOT_SERVICEABLE.getCode(), ErrorMessageStatusCode.DESTINATION_NOT_SERVICEABLE.getDescription());

			case Constants.FINDER_C2PC_INVALID_PINCODE_ERROR:
				throw new BlueDartException(ErrorMessageStatusCode.INVALID_PINCODE.getCode(), ErrorMessageStatusCode.INVALID_PINCODE.getDescription());

				
			case Constants.FINDER_DESTINATION_INTL_ERRORCODE:
				throw new BlueDartException(ErrorMessageStatusCode.INVALID_PINCODE.getCode(), ErrorMessageStatusCode.INVALID_PINCODE.getDescription());

			default:
				throw new BlueDartException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(), ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
			}

		}
	return trasitTime;
   }
   
}
