package com.bluedart.scheduleapickupbookashipment.daoImpl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.GenerateRequestPdfClientDto;
import com.bluedart.common.dto.StatusDto;
import com.bluedart.common.entity.CountryMst;
import com.bluedart.common.entity.IntlStateMst;
import com.bluedart.common.entity.LoginMaster;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao;
import com.bluedart.scheduleapickupbookashipment.dto.CountryDto;
import com.bluedart.scheduleapickupbookashipment.dto.DeliveryTimeSlotDto;
import com.bluedart.scheduleapickupbookashipment.dto.PaperWorkDto;
import com.bluedart.scheduleapickupbookashipment.dto.ParcelShopDto;
import com.bluedart.scheduleapickupbookashipment.dto.StateDto;
import com.bluedart.scheduleapickupbookashipment.dto.ValueAddedPaperWorkDto;
import com.bluedart.scheduleapickupbookashipment.dto.ValueAddedServiceDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * 
 * @author DH839598
 *
 */
@Repository
public class ScheduleBookShipmentDaoImpl extends BaseDaoImpl implements ScheduleBookShipmentDao{

	private static final Logger logger = Logger.getLogger(ScheduleBookShipmentDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getParcelShop(java.lang.String)
	 */
	@Transactional
	@Override
	public Boolean updateAddressID(String adressID) {
		logger.debug("ScheduleBookShipmentDaoImpl.updateAddressID ");
		logger.info("Input param(adressID): "+adressID);
		Boolean result = false;
		try {
			result = getSession().doReturningWork(new ReturningWork<Boolean>() {
				@Override
				public Boolean execute(Connection connection) throws SQLException {
					Boolean sqlstatus= false ;
					String updatePrevDefaultAddressQuery = "update CNEEMST_T set NMOSTLYUSEDCOUNTER =Coalesce(NMOSTLYUSEDCOUNTER,0)+1,DSPBSDATE =?  where CCADDRID = ? ";		
					PreparedStatement prepStmt = connection.prepareStatement(updatePrevDefaultAddressQuery);  
					prepStmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
					prepStmt.setString(2, adressID);
					
					try{
						int value=prepStmt.executeUpdate();
						logger.info("DB execute update vaule : "+value);
						if(value>0) {
							sqlstatus= true;
						}

					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}finally{
						logger.debug("---------------updateAddressID finally--------------");
						CloseConnections.closePreparedStatement(prepStmt);
					}
					logger.info("updateAddressID Result: "+sqlstatus);
					return sqlstatus;

				}

			}); } catch(Exception e) {
			} 
	
		return result;
	}


	/*
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getRiskDetail(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public String getRiskDetail(String custCode, String areaCode) {
		String riskVal = "EXP";
		try {
			riskVal = getSession().doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) throws SQLException {
					String riskVal = null;
					CallableStatement callableStatement = null;
					try{
					callableStatement = connection.prepareCall(Constants.RISKDETAIL);
					callableStatement.setString(1, custCode);
					callableStatement.setString(2, areaCode);
					callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
					callableStatement.execute();

					riskVal = (String) callableStatement.getObject(3);
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}
						
					finally{
						logger.debug("---------------getRiskDetail finally--------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return riskVal;
				}
			});

		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return riskVal;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getDeliveryTimeSlot(java.lang.String)
	 */
	@Transactional
	@Override
	public DeliveryTimeSlotDto getDeliveryTimeSlot(String pincode) {
		List<DeliveryTimeSlotDto> listOfTimeSlot = new ArrayList<>();
		DeliveryTimeSlotDto deliveryTimeSlotDto = new DeliveryTimeSlotDto();
		try {
			getSession().doWork(new Work() {
				@Override  
				public void execute(Connection connection) {
					CallableStatement callableStatement = null;
					ResultSet timeSlotSet = null;
					try {
						DeliveryTimeSlotDto deliveryTimeSlotDto = null;
						callableStatement = connection.prepareCall(Constants.DELIVERY_TIME_SLOT);
						callableStatement.setString(1, pincode);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();

						timeSlotSet = (ResultSet) callableStatement.getObject(2);
						while (timeSlotSet.next()) {
							deliveryTimeSlotDto = new DeliveryTimeSlotDto();
							deliveryTimeSlotDto.setTimeSlot(timeSlotSet.getString(1));
							listOfTimeSlot.add(deliveryTimeSlotDto);
						}
						
					} catch (Exception e) {
						logger.error("EXCEPTION TYPE :",e);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("---------------deliveryTimeSlotDto finally--------------");
						CloseConnections.closeResultSet(timeSlotSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 
		deliveryTimeSlotDto.setListOfTimeSlot(listOfTimeSlot);
		return deliveryTimeSlotDto;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getParcelShop(java.lang.String)
	 */
	@Transactional
	@Override
	public ParcelShopDto getParcelShop(String pincode) {

		ParcelShopDto parcelShopDto = new ParcelShopDto();
		List<ParcelShopDto> listOfParcelShop = new ArrayList<>();
		ScrollableResults results =null;
		try{
			ParcelShopDto parcelShop = null;
			String query = "select * from WEBMASTER.PSMST where CPSPIN in (select b.cpincode from pincdmst b,psmst ps where b.CSCRCD in(select CSCRCD from pincdmst a where a.CPINCODE = '"+pincode+"') and b.CPINCODE=ps.CPSPIN)";
			results = getSession().createSQLQuery(query.toString()).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				parcelShop = new ParcelShopDto();
				parcelShop.setParcelShopCode(results.get()[1].toString());
				parcelShop.setParcelShopAddress1(results.get()[2].toString());
				parcelShop.setParcelShopAddress2(results.get()[3].toString());
				parcelShop.setParcelShopAddress3(results.get()[4].toString());
				parcelShop.setParcelShopPincode(results.get()[6].toString());
				listOfParcelShop.add(parcelShop);
			}
			parcelShopDto.setListOfParcelShop(listOfParcelShop);
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} finally{
			logger.debug("---------------getParcelShop finally--------------");
			CloseConnections.closeScrollableResults(results);
		}
		return parcelShopDto;
	}

	@Transactional
	@Override
	public String updateMstlyCount(Integer addrId, String loginId, String custCode, String areaCode, Integer flag) {
		BigDecimal count = null;
		try {
			count = getSession().doReturningWork(new ReturningWork<BigDecimal>() {
				@Override
				public BigDecimal execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					BigDecimal count = null;
					try{
					callableStatement = connection.prepareCall(Constants.UPDATE_COUNT);
					callableStatement.setInt(1, addrId);
					callableStatement.setString(2, loginId);
					callableStatement.setString(3, custCode);
					callableStatement.setString(4, areaCode);
					callableStatement.setInt(5, flag);
					callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
					callableStatement.execute();

					count = (BigDecimal) callableStatement.getObject(6);
					}
					catch(Exception e){
						logger.error("EXCEPTION TYPE :",e);
					}
					finally{
						logger.debug("---------------updateMstlyCount finally--------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return count;
				}
			});

		} catch (Exception exception) {
		//	logger.error(exception);
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return count.toString();
	}

	@Transactional
	@Override
	public String getServiceCenterCode(String pincode) {
		ScrollableResults results = null;
		String serviceCenterCode = null;
		try{
			String query = "select DISTINCT(CSCRCD) from pincdmst where CPINCODE = " + "'" + pincode + "'";
			results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				serviceCenterCode = (String) (results.get()[0]);
			}

		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			serviceCenterCode = "EXP";
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("---------------getServiceCenterCode finally--------------");
			CloseConnections.closeScrollableResults(results);
		}

		return serviceCenterCode;
	}

	@Transactional
	@Override
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(String pincode) {
		ScrollableResults results = null;
		GenerateRequestPdfClientDto generateReqPdfClientDto = new GenerateRequestPdfClientDto();
		try{
			String query = "select DISTINCT(CSCRCD), CAREA from pincdmst where CPINCODE = " + "'" + pincode + "'";
			results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				generateReqPdfClientDto.setServiceCentreCode((String) (results.get()[0]));
				generateReqPdfClientDto.setAreaCode((String) (results.get()[1]));
			}

		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			generateReqPdfClientDto.setServiceCentreCode("EXP");
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("---------------getServiceCenterAndAreaCode finally--------------");
			CloseConnections.closeScrollableResults(results);
		}

		return generateReqPdfClientDto;
	}
	
	@Transactional
	@Override
	public GenerateRequestPdfClientDto getServiceCenterAndAreaCode(String custCode,String custAreaCode) {
		ScrollableResults results = null;
		GenerateRequestPdfClientDto generateReqPdfClientDto = new GenerateRequestPdfClientDto();
		try{    
			String query = " SELECT CAREA,CSCRCD FROM CUSTMST WHERE CAREA= " + "'" + custAreaCode + "'"+ " AND CCUSTCODE= "+ "'" + custCode + "'";
			results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				generateReqPdfClientDto.setAreaCode((String) (results.get()[0]));
				generateReqPdfClientDto.setServiceCentreCode((String) (results.get()[1]));
			}

		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			generateReqPdfClientDto.setServiceCentreCode("EXP");
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("---------------getServiceCenterAndAreaCode finally--------------");
			CloseConnections.closeScrollableResults(results);
		}

		return generateReqPdfClientDto;
	}

	@Transactional
	@Override
	public String getUserId(String loginId) {
		LoginMaster loginMaster = (LoginMaster)getSession().get(LoginMaster.class, loginId);
		String userId = null;
		if (null != loginMaster) {
			userId = String.valueOf(loginMaster.getUserID());
		}
		return userId;
	}

	@Transactional
	@Override
	public ValueAddedPaperWorkDto getValueAddedService(String custCode, String custArea, String fromPincode,
			String toPincode, String productCode) {

		ValueAddedPaperWorkDto valueAddedPaperWorkDto = null;
		try{
			valueAddedPaperWorkDto = getSession().doReturningWork(new ReturningWork<ValueAddedPaperWorkDto>() {

				@Override
				public ValueAddedPaperWorkDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					ValueAddedPaperWorkDto valueAddedPaperWorkDto = new ValueAddedPaperWorkDto();
					try{
						
					
					List commonDto = null;
					List<ValueAddedServiceDto> valueAddedServiceDtoList = new ArrayList<>();
					List<PaperWorkDto> paperWorkDtoList = new ArrayList<>();
					Map<String, Class<?>> map = connection.getTypeMap();
					try{
						map.put(Constants.PACKOBJ, Class.forName(Constants.VALUE_ADDED_SERVICE_DTO));
						map.put(Constants.PAPERWORKOBJ, Class.forName(Constants.PAPER_WORK_DTO));
					}catch(ClassNotFoundException classNotFoundException){
						logger.error(classNotFoundException.getMessage());
					}
					connection.setTypeMap(map);
					callableStatement = connection.prepareCall("{call UPROFILE4.VALUE_ADDED_SERVICES_V3(?,?,?,?,?,?,?,?,?)}");
					callableStatement.clearParameters();  

					((OracleCallableStatement) callableStatement).setString(1, custCode);
					((OracleCallableStatement) callableStatement).setString(2, custArea);
					((OracleCallableStatement) callableStatement).setString(3, fromPincode);
					((OracleCallableStatement) callableStatement).setString(4, toPincode);
					((OracleCallableStatement) callableStatement).setString(5, productCode);
					((OracleCallableStatement) callableStatement).setString(6, "2");// TRN Code
					((OracleCallableStatement) callableStatement).registerOutParameter(7, Types.INTEGER);
					((OracleCallableStatement) callableStatement).registerOutParameter(8, java.sql.Types.ARRAY,	Constants.PACKLIST_SPBS);
					((OracleCallableStatement) callableStatement).registerOutParameter(9, java.sql.Types.ARRAY,	Constants.PAPERWRKLIST);
					callableStatement.execute();

					ARRAY valueAddedServiceArray = ((OracleCallableStatement) callableStatement).getARRAY(8);
					ARRAY paperWorkArray = ((OracleCallableStatement) callableStatement).getARRAY(9);

					if (valueAddedServiceArray != null && valueAddedServiceArray.length() != 0) {
						commonDto = Arrays.asList((Object[]) valueAddedServiceArray.getArray());
						valueAddedServiceDtoList = new ArrayList<ValueAddedServiceDto>(commonDto);
						valueAddedPaperWorkDto.setValueAddedServiceDtoList(valueAddedServiceDtoList);
					}

					if (paperWorkArray != null && paperWorkArray.length() != 0) {
						commonDto = Arrays.asList((Object[]) paperWorkArray.getArray());
						paperWorkDtoList = new ArrayList<PaperWorkDto>(commonDto);
						valueAddedPaperWorkDto.setPaperWorkDtoList(paperWorkDtoList);
					}
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}
						
					finally{
						logger.debug("---------------getValueAddedService finally--------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return valueAddedPaperWorkDto;
				}
			});
		}catch(Exception exception){
			logger.error("EXCEPTION TYPE :",exception);
			logger.info("Exception while calling value added services.");;
			logger.error(exception.getMessage());
		}
		return valueAddedPaperWorkDto;
	}

	@Transactional
	@Override
	public String validatePincode(String pincode, String addrType, String loginId) {
		BigDecimal count = null;
		try {
			count = getSession().doReturningWork(new ReturningWork<BigDecimal>() {
				@Override
				public BigDecimal execute(Connection connection) throws SQLException {
					BigDecimal count = null;
					CallableStatement callableStatement =null;
					try{
					callableStatement = connection.prepareCall(Constants.VALIDATE_PINCODE);
					callableStatement.setString(1, pincode);
					callableStatement.setString(2, addrType);
					callableStatement.setString(3, loginId);
					callableStatement.registerOutParameter(4, OracleTypes.NUMBER);
					callableStatement.execute();

					count = (BigDecimal) callableStatement.getObject(4);
					}catch(Exception exception){
						logger.error("EXCEPTION TYPE :",exception);
					}finally{
						logger.debug("---------------validatePincode finally--------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return count;
				}
			});

		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return count.toString();
	}


	@Transactional
	@Override
	public int valDecValueWithDomestic(int fromPincode, int toPincode, int decValue, String vas) {

		try {

			Number queryValue = 0;
			String fromState = "";
			String stateCD   = "";
			String stateAPin  = "";  
			Object[] stateCDobj = null;
			Object[] stateAPinobj = null;
			int statePinCode =0;

			/*String sqlQuery = "select distinct CSTATE,cstatecd,careapin from areamst where careapin in ('"+fromPincode+"', '"+toPincode+"')";
			Query exeQuery = getSession().createSQLQuery(sqlQuery);

			List<String> stateSet = new ArrayList<>();
			List<String> stateCDSet = new ArrayList<>();
			List<Object[]> list = exeQuery.list();
			for (Object[] string2 : list) {
				fromState = (String) string2[0];
				System.out.println("fromState ::: "+fromState);
				stateCD   = (String) string2[1];
				stateSet.add(fromState);	
				stateCDSet.add(stateCD);
			}*/

			Set<String> stateSet = new HashSet<>();
			List<String> stateCDSet = new ArrayList<>();
			List statePinList = new ArrayList<>();
			ScrollableResults results = null;
			try {
				String sqlQuery = "select distinct CSTATE,cstatecd,careapin from areamst where careapin in ('"+fromPincode+"', '"+toPincode+"')";
				 results = getSession().createSQLQuery(sqlQuery).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
				while (results.next()) {
					fromState = (String) (results.get()[0]);
					stateCD   = (String) (results.get()[1]);
					stateAPin  = (String) (results.get()[2]);
					stateSet.add(fromState);	
					stateCDSet.add(stateCD);
					statePinList.add(stateAPin);
				}

			} catch (Exception exception) {
				logger.error("EXCEPTION TYPE :",exception);
				//logger.error(exception);
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
						ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}finally{
				logger.debug("---------------valDecValueWithDomestic inner--------------");
				CloseConnections.closeScrollableResults(results);
			}

			if (stateSet.size() > 0 ) {

				stateCDobj = stateCDSet.toArray();
				stateAPinobj = statePinList.toArray();
				//System.out.println(stateCDobj[0]);
				//System.out.println(stateCDobj[1]);

			}else {
				System.out.println("Incorrect pincode");
				decValue = 0;
				return decValue;
			}

			System.out.println("outsides ::: "+stateSet+" sizes ::: "+stateSet.size()+" vases ::: "+vas+" stateCDs ::: "+stateCD);

			String query = "select ";
			if(vas.equals("APEX COD") && stateSet.size() == 1) {
				query= query + "NAPEXEINT";
			}

			else if(vas.equalsIgnoreCase("APEX COD") && stateSet.size() == 2) {
				query= query + "NAPEXEVAL";
			}
			else if(vas.equals("SFC COD") && stateSet.size() == 1) {
				query= query + "NSFCEINT";
			}
			else if(vas.equalsIgnoreCase("SFC COD") && stateSet.size() == 2) {
				query= query + "NSFCEVAL";
			}
			else if(vas.equalsIgnoreCase("SFC PREPAID") && stateSet.size() == 1) {
				query= query + "NSFCEPINT";
			}
			else if(vas.equalsIgnoreCase("SFC PREPAID") && stateSet.size() == 2) {
				query= query + "NSFCEPVAL";
			}
			else if(vas.equalsIgnoreCase("APEX PREPAID") && stateSet.size() == 1) {
				query= query + "NAPEXEPINT";
			}
			else if(vas.equalsIgnoreCase("APEX PREPAID") && stateSet.size() == 2) {
				query= query + "NAPEXEPVAL";
			}
			else if(vas.equalsIgnoreCase("DOMESTIC DUTS")) {
				query= query + "NDPDVAL";
			}

			String getPincodeQuery = "";
			if ( stateCDobj[0] == null || stateCDobj[0] == "" ) {
				decValue = 0;
				return decValue;
			}
			getPincodeQuery = query + " from statemst where cstatecd='"+stateCDobj[0]+"'";
			System.out.println("check query :::"+getPincodeQuery);
			Query decValQuery = getSession().createSQLQuery(getPincodeQuery);

			ScrollableResults results1 = getSession().createSQLQuery(getPincodeQuery).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			try {

				while (results1.next()) {
					queryValue = (Number) (results1.get()[0]);
				}

			}catch(Exception ex) {
				logger.error("EXCEPTION TYPE :",ex);
				System.out.println("check query :::"+ex.getMessage());
			}finally{
				logger.debug("---------------valDecValueWithDomestic finally--------------");
				CloseConnections.closeScrollableResults(results1);
			}


			if(decValue < queryValue.intValue()) {
				return decValue;
			} else {
				return queryValue.intValue();
			}

		} catch (HibernateException exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
	}

	@Transactional
	@Override
	public float getConvertedCurrToINR(String currCode, int declaredValue) {
		Number exchangeRate = 0;
		Number   units        = 0;
		float InrValue     = 0;
		ScrollableResults results =null;
		try {
			String query = "select NEXCHRATE,NUNITS from CURRMST where CCURRCODE =" + "'" + currCode.toUpperCase() + "'";
			results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				exchangeRate = (Number) (results.get()[0]);
				units = (Number) (results.get()[1]);
			}
			units = units.intValue() != 0 ? units : 1;
			InrValue = (exchangeRate.intValue() * declaredValue) / units.intValue();

		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("---------------getConvertedCurrToINR finally--------------");
			CloseConnections.closeScrollableResults(results);
		}

		return InrValue;
	}

	@Transactional
	@Override
	public String getCountryCode(String countryName) {
		String countryCode = "EXP";
		ScrollableResults results = null;
		
		if(!StringUtils.isEmpty(countryName)){
		//if(countryName!="" && countryName!=null){
			try {
				String query = "select * from WEBMASTER.CNTRYMST where upper(CCNTRYNAME) like " + "'%" + countryName.toUpperCase() + "%'";
				results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
				while (results.next()) {
					countryCode = (String) (results.get()[0]);
				}
				
			} catch (Exception exception) {
				logger.error("EXCEPTION TYPE :",exception);
				//logger.error(exception);
				throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
						ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			}finally{
				logger.debug("---------------getCountryCode finally--------------");
				CloseConnections.closeScrollableResults(results);
			}
		}
		return countryCode;
	}


	@Transactional
	@Override
	public String getCityName(String cityName) {
		String returnCityName = "EXP";
		ScrollableResults results = null;
		try {
			String query = "select a.careadesc from areamst a where A.COLDNAME ="+ "'"+cityName+"'" + "union select a.careadesc from areamst a where A.careadesc = " + "'" + cityName + "'";
			 results = getSession().createSQLQuery(query).setReadOnly(true).setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			while (results.next()) {
				returnCityName = (String) (results.get()[0]);
			}
			
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//logger.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			logger.debug("---------------getCityName finally--------------");
			CloseConnections.closeScrollableResults(results);
		}

		return returnCityName;
	}

	@Transactional
	@Override
	public String test() {

		try {
			getSession().doWork(new Work() {
				@Override  
				public void execute(Connection connection) {
					CallableStatement callableStatement = null;
					ResultSet permissionSet = null;
					try {
						String permissionName = "SHIPPER_ADDRESS_BOOK-CREATE_UPDATE_DELETE";
						// String[] permissionsArray = {"SHIPPER_ADDRESS_BOOK-CREATE_UPDATE_DELETE"};
						String[] permissionsArray = new String[1];
						if(permissionName.contains(",")){
							permissionsArray = permissionName.split(",");
						}else{
							permissionsArray[0] = permissionName;
						} 

						ArrayDescriptor des = ArrayDescriptor.createDescriptor("UPROFILE4.GENERIC_VARCHAR_TYPE",connection);
						ARRAY permissionNameArrayToPass = new ARRAY(des, connection, permissionsArray);

						callableStatement = connection.prepareCall(Constants.GET_AFFILIATE_PERMISSION);
						((OracleCallableStatement) callableStatement).setString(1, "SYSDEV001");
						((OracleCallableStatement) callableStatement).setString(2, null);
						((OracleCallableStatement) callableStatement).setString(3, null);
						((OracleCallableStatement) callableStatement).setArray(4, permissionNameArrayToPass);
						((OracleCallableStatement) callableStatement).registerOutParameter(5, OracleTypes.CURSOR);
						((OracleCallableStatement) callableStatement).registerOutParameter(6, OracleTypes.NUMBER);

						try{
							callableStatement.execute();
							System.out.println("here2");
							permissionSet = (ResultSet) callableStatement.getObject(5);
						}catch(Exception exception) {
							logger.error("EXCEPTION TYPE :",exception);
						}
						System.out.println(callableStatement.getInt(6));
						while (permissionSet.next ()){ 

							System.out.println(permissionSet.getString("AFF_CC"));
						}
						
					} catch (Exception e) {
						logger.error("EXCEPTION TYPE :",e);
					//	e.printStackTrace();
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						logger.debug("---------------test finally--------------");
						CloseConnections.closeResultSet(permissionSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			//exception.printStackTrace();
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		return null;
	}
	
	
	@Override
	@Transactional
	public StatusDto validateConsgnPin(String pincode, String countryName, String cityName){
		
		logger.info("validateConsgnPin method");
		StatusDto statusDto = new StatusDto();
		StringBuilder checkPinFormatQuery = new StringBuilder();
		checkPinFormatQuery.append("select nvl(trim(cpinformat),0) pinformat from")
		.append(" (sELECT t.cpinformat FROM cntrymst t  where t.CCNTRYCODE=")
		.append(" (select ccntrycode from WEBMASTER.CNTRYMST where upper(ccntryname) like ?))");
		String pinFormat = "";
		logger.info("validateConsgnPin query :: "+checkPinFormatQuery);
		if(!StringUtils.isEmpty(countryName)){
		//if(countryName!="" && countryName!=null){
			logger.info("validateConsgnPin countryName :: "+countryName);
			try {
				pinFormat = getSession().doReturningWork(new ReturningWork<String>() {
					@Override
					public String execute(Connection connection) throws SQLException {
						String pinFormat = "";
						ResultSet rs = null;
						PreparedStatement pStmt =null;
						pStmt = connection.prepareStatement(checkPinFormatQuery.toString());
						try {
							pStmt.setString(1, "%"+countryName.toUpperCase()+"%");
							rs = pStmt.executeQuery();
							if (rs!=null && rs.next()) {
								pinFormat = rs.getString("pinformat");
								logger.info("validateConsgnPin pinFormat :: "+pinFormat);
							} 
							} catch (HibernateException e) {
								logger.error("EXCEPTION TYPE :",e);
								return null;
							} finally {
								logger.debug("---------------validateConsgnPin finally--------------");
								CloseConnections.closeResultSet(rs);
								CloseConnections.closePreparedStatement(pStmt);
								
							}
						return pinFormat;
					}
				});
			} catch(Exception e){
				logger.error("EXCEPTION TYPE :",e);
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}
		}
		
		if(!Constants.COUNTRY_INDIA.equalsIgnoreCase(countryName)){  //international pincode
			boolean match = false; 
			logger.info("international pinFormat :: "+pinFormat);
			if(!"0".equalsIgnoreCase(pinFormat) || "".equalsIgnoreCase(pinFormat)){
				String[] pincodeFormatArray =  pinFormat.split(",");
				for (int i = 0;i< pincodeFormatArray.length;i++) {
					String individualPinFormats = pincodeFormatArray[i];
					logger.info("international individualPinFormats :: "+individualPinFormats);
					Pattern alphabetTest = Pattern.compile("[A-Za-z]");
					Pattern numTest = Pattern.compile("[0-9]");
					Pattern hyphenTest = Pattern.compile("[-]");
					Pattern spaceTest = Pattern.compile("[ ]");
					StringBuilder addRegEx = new StringBuilder();
					for (int j = 0; j < individualPinFormats.length();  j++) {
						Matcher alphabetMatcher = alphabetTest.matcher(String.valueOf(individualPinFormats.charAt(j)));
						Matcher numberMatcher = numTest.matcher(String.valueOf(individualPinFormats.charAt(j)));
						Matcher hyphenMatcher = hyphenTest.matcher(String.valueOf(individualPinFormats.charAt(j)));
						Matcher spaceMatcher = spaceTest.matcher(String.valueOf(individualPinFormats.charAt(j)));
						if ((alphabetMatcher.matches())) {
							addRegEx.append("[A-Za-z]");
						}else if((numberMatcher).matches()){
							addRegEx.append("[0-9]");
						}else if((hyphenMatcher).matches()){
							addRegEx.append("[-]");
						}else if((spaceMatcher).matches()){
							addRegEx.append("[ ]"); 
						}
					}
					logger.info("international addRegEx :: "+addRegEx);
					Pattern completeRegEx = Pattern.compile(addRegEx.toString());
						Matcher completeRegExMatcher = completeRegEx.matcher(pincode);
						if((completeRegExMatcher).matches()){
							match = true;
							break;
						}else{
							match = false;
						}
					}
					logger.info("international match :: "+match);
					if(match==true){
						statusDto.setStatusMessage("VALID");
					}else{
						statusDto.setStatusMessage("INVALID");
					}
				}else if("0".equalsIgnoreCase(pinFormat)){  
					statusDto.setStatusMessage("VALID");
				}
		}else{   //india 
			statusDto.setStatusMessage("INDIAN_PIN");
		}
		return statusDto;
	
	}

	/*
	 * Method to get international city
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getInternationalCity(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public StatusDto getInternationalCity(String cityName, String countryCode) {
		System.out.println("getInternationalCity input parameter"+"cityName"+cityName+"countryCode"+countryCode);
		StatusDto statusDto = new StatusDto();
		String cityNameVal = "";
		if(cityName!=null){
			cityNameVal = "%"+cityName+"%";
		}
		String intQuery = "select CCITYCODE from WEBMASTER.CITYMST where upper(CCITYNAME) like upper(:cityName) and upper(CCNTRYCODE)=upper(:countryCode) and rownum=1";
		System.out.println("getInternationalCity query"+intQuery);
		
		String cityCode = "";
		try {
			Query query = getSession().createSQLQuery(intQuery);
			query.setString("cityName", cityNameVal.toUpperCase());
			query.setString("countryCode", countryCode.toUpperCase());
			cityCode = (String) query.uniqueResult();
			System.out.println("getInternationalCity result"+cityCode);
		} catch(Exception e){
			logger.error("EXCEPTION TYPE :",e);
			//System.out.println("getInternationalCity exception");
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		statusDto.setStatusMessage(cityCode);
		return statusDto;
	}

	/*
	 * Method to get GST Number from AddressBook
	 * (non-Javadoc)
	 * @see com.bluedart.scheduleapickupbookashipment.dao.ScheduleBookShipmentDao#getGSTNumber(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public StatusDto getGSTNumber(Integer addressId) {
		StatusDto statusDto = new StatusDto();

		String getGSTQuery = "select AFF_CC, AFF_AC, CGSTN_UIDCODE from UPROFILE4.CNEEMST_T where CCADDRID=:addressId";
		try {
			Query query = getSession().createSQLQuery(getGSTQuery);
			query.setInteger("addressId", addressId);
			@SuppressWarnings("unchecked")
			List<Object> outList = query.list();
			Object[] objArray = (Object[]) outList.get(0);
			
			if(objArray[2]!="" && objArray[2]!=null && !(objArray[2].equals(null))){
				statusDto.setStatusMessage(objArray[2].toString());
			}else{
				getGSTQuery = "select CGSTN_UIDCODE from CUSTMST where upper(CAREA)=:carea and ccustcode=:custCode";
				query = getSession().createSQLQuery(getGSTQuery);
				query.setString("carea", objArray[0].toString().toUpperCase());
				query.setString("custCode", objArray[1].toString());
				
				String gstNumber = (String) query.uniqueResult();
				statusDto.setStatusMessage(gstNumber);
			}
		} catch(Exception e){
			logger.error("EXCEPTION TYPE :",e);
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		return statusDto;
	}
	
	
	@Transactional
	@Override
	public StateDto getStates(String countryCode) {
		StateDto stateDto = new StateDto();
		List<StateDto> stateList = getStatesList(countryCode);
		stateDto.setStateList(stateList);
		return stateDto;
	}
	
	/**
	 * @param countryCode
	 * @return
	 */
	private List<StateDto> getStatesList(String countryCode){

		try{
			StateDto stateDto;
			List<StateDto>  stateMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(IntlStateMst.class);
			criteria.add(Restrictions.eq("countryCode", countryCode));
			@SuppressWarnings("unchecked")
			List<IntlStateMst> stateList = (List<IntlStateMst>) criteria.list();
			for(IntlStateMst stateMst : stateList){
				stateDto = new StateDto();
				CopyUtils.copy(stateMst, stateDto);
				stateMstDtoList.add(stateDto);
			}
			return stateMstDtoList;
		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}
	
	
	@Transactional
	@Override
	public CountryDto getCountry(String countryCode) {
		
		CountryDto countryDto = new CountryDto();
		List<CountryDto> countryList = getCountryList(countryCode);
		countryDto.setCountryList(countryList);
		return countryDto;
	}

	/**
	 * @return
	 */
	private List<CountryDto> getCountryList(String countryCode){

		try{
			CountryDto countryDto;
			List<CountryDto>  countryMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(CountryMst.class);
			criteria.add(Restrictions.eq("countryCode", countryCode.toUpperCase()));
			//criteria.addOrder(Order.asc("countryName"));
			@SuppressWarnings("unchecked")
			List<CountryMst> countryList = (List<CountryMst>) criteria.list();
			for(CountryMst countryMst : countryList){
				countryDto = new CountryDto();
				CopyUtils.copy(countryMst, countryDto);
				countryMstDtoList.add(countryDto);
			}
			return countryMstDtoList;
		}catch (Exception exception) {
			logger.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	} 
	
	
	
	
}
