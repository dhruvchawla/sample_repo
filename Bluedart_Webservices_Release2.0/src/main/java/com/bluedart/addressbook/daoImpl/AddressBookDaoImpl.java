package com.bluedart.addressbook.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.addressbook.dao.AddressBookDao;
import com.bluedart.addressbook.dto.AddressAreaDto;
import com.bluedart.addressbook.dto.AddressBookDto;
import com.bluedart.addressbook.dto.AddressBookImportDetailDto;
import com.bluedart.addressbook.dto.AddressBookListDto;
import com.bluedart.addressbook.dto.CityDto;
import com.bluedart.addressbook.dto.CountryDto;
import com.bluedart.addressbook.dto.ImportDto;
import com.bluedart.addressbook.dto.SearchDto;
import com.bluedart.addressbook.dto.StateDto;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AffiliatePermissionDto;
import com.bluedart.common.entity.AddressBookMaster;
import com.bluedart.common.entity.CitiesMst;
import com.bluedart.common.entity.CountryMst;
import com.bluedart.common.entity.IntlStateMst;
import com.bluedart.common.entity.SubCitiesMst;
import com.bluedart.common.service.AffiliatePermissionService;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.utils.Constants;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * @author AN765570
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class AddressBookDaoImpl extends BaseDaoImpl implements AddressBookDao{

	@Autowired 
	private Environment environment;
	@Autowired
	private AffiliatePermissionService affiliatePermissionService;

	private static final Logger addressBookLogger = Logger.getLogger(AddressBookDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getDefaultAndMostlyUsedAddresses(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public AddressBookListDto getDefaultAndMostlyUsedAddresses(String loginId, String addressType, String flag) {
		addressBookLogger.debug("AddressBookDaoImpl:getDefaultAndMostlyUsedAddresses");
		AddressBookListDto addressBookListDto = new AddressBookListDto();
		List<AddressBookListDto> listOfDefltMstlyAddress = new ArrayList<>();
		try {
			getSession().doWork(new Work() {
				@Override
				public void execute(Connection connection) {
					CallableStatement callableStatement = null;
					ResultSet defaultAddressSet = null;
					ResultSet mostlyAddressSet = null;
					try {
						CountryDto countryDto = null;
						CityDto cityDto = null;
						AddressBookListDto addressBookListDto;
						callableStatement = connection
								.prepareCall(Constants.DEFAULT_MOSTLYUSEDADDRESS_PROC);
						callableStatement.setString(1, loginId);
						callableStatement.setString(2, addressType);
						callableStatement.setString(3, flag);
						callableStatement.setInt(4, Integer.parseInt(environment.getProperty(Constants.MOSTLYADDRESSCOUNT)));
						//callableStatement.setInt(4, Integer.valueOf(environment.getProperty(Constants.MOSTLYADDRESSCOUNT)));
						callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
						callableStatement.registerOutParameter(6, OracleTypes.CURSOR);
						callableStatement.execute();

						// Default Address
						 defaultAddressSet = (ResultSet) callableStatement.getObject(6);
						if (null != defaultAddressSet) {
							while (defaultAddressSet.next()) {
								addressBookListDto = new AddressBookListDto();
								addressBookListDto.setAddressId(Long.valueOf(defaultAddressSet.getString(1)));
								addressBookListDto.setCountryCode(defaultAddressSet.getString(3));
								addressBookListDto.setName(defaultAddressSet.getString(4));
								addressBookListDto.setAddressLine1(defaultAddressSet.getString(5));
								addressBookListDto.setAddressLine2(defaultAddressSet.getString(6));
								addressBookListDto.setLandmark(defaultAddressSet.getString(7));
								addressBookListDto.setEmailId(defaultAddressSet.getString(8));
								addressBookListDto.setPincode(defaultAddressSet.getString(9));
								addressBookListDto.setTelephoneNumber(defaultAddressSet.getString(10));
								addressBookListDto.setVendorCode(defaultAddressSet.getString(12));
								addressBookListDto.setContactPerson(defaultAddressSet.getString(13));
								addressBookListDto.setAreaCode(defaultAddressSet.getString(15));
								addressBookListDto.setCustomerCode(defaultAddressSet.getString(16));
								addressBookListDto.setCityCode(defaultAddressSet.getString(17));
								addressBookListDto.setStateCode(defaultAddressSet.getString(18));
								addressBookListDto.setAddressType(defaultAddressSet.getString(19));
								addressBookListDto.setMobileNumber(defaultAddressSet.getString(20));
								addressBookListDto.setDefaultAddress(defaultAddressSet.getString(21));
								addressBookListDto.setOfficeClosureTime(defaultAddressSet.getString(24));

								countryDto = AddressBookDaoImpl.this.getCountries();
								for (CountryDto cntryDto : countryDto.getCountryList()) {
									if (defaultAddressSet.getString(3).equalsIgnoreCase(cntryDto.getCountryCode()))
									{
										addressBookListDto.setCountryName(cntryDto.getCountryName());
										cityDto = AddressBookDaoImpl.this.getCities(cntryDto.getCountryCode());
										for (CityDto cityDtoList : cityDto.getCityList()) {
											if (defaultAddressSet.getString(17).equalsIgnoreCase(cityDtoList.getCityCode())) {
												addressBookListDto.setCityName(cityDtoList.getCityName());
											}
										}
									}
								}
								listOfDefltMstlyAddress.add(addressBookListDto);
							}
						}

						// Mostly Used Address
						mostlyAddressSet = (ResultSet) callableStatement.getObject(5);
						while (mostlyAddressSet.next()) {addressBookListDto = new AddressBookListDto();
						if (null != mostlyAddressSet.getString(1)) {
							addressBookListDto.setAddressId(Long.valueOf(mostlyAddressSet.getString(1)));
						} else {
							addressBookListDto.setAddressId(Long.valueOf(0));
						}
						addressBookListDto.setCountryCode(mostlyAddressSet.getString(2));
						addressBookListDto.setCityCode(mostlyAddressSet.getString(3));
						addressBookListDto.setStateCode(mostlyAddressSet.getString(4));
						addressBookListDto.setMobileNumber(mostlyAddressSet.getString(5));
						addressBookListDto.setName(mostlyAddressSet.getString(6));
						addressBookListDto.setDefaultAddress(mostlyAddressSet.getString(7));
						addressBookListDto.setAddressLine1(mostlyAddressSet.getString(8));
						addressBookListDto.setAddressLine2(mostlyAddressSet.getString(9));
						addressBookListDto.setLandmark(mostlyAddressSet.getString(10));
						addressBookListDto.setEmailId(mostlyAddressSet.getString(11));
						addressBookListDto.setPincode(mostlyAddressSet.getString(12));
						addressBookListDto.setTelephoneNumber(mostlyAddressSet.getString(13));
						addressBookListDto.setContactPerson(mostlyAddressSet.getString(14));
						addressBookListDto.setAreaCode(mostlyAddressSet.getString(15));
						addressBookListDto.setCustomerCode(mostlyAddressSet.getString(16));
						addressBookListDto.setOfficeClosureTime(mostlyAddressSet.getString(17));
						// 20200309: Juhi
						if(!mostlyAddressSet.getString(2).trim().equalsIgnoreCase("IN")) {
							addressBookListDto.setCityName(mostlyAddressSet.getString(20));
						}			// 20200309: Juhi

						countryDto = AddressBookDaoImpl.this.getCountries();
						for (CountryDto cntryDto : countryDto.getCountryList()) {
							if (mostlyAddressSet.getString(2).equalsIgnoreCase(cntryDto.getCountryCode()))
							{
								addressBookListDto.setCountryName(cntryDto.getCountryName());
								if(addressBookListDto.getCityName()== "" || addressBookListDto.getCityName()== null){			//Juhi 20200309: If City is not present in table, then populate using cityList.
									cityDto = AddressBookDaoImpl.this.getCities(cntryDto.getCountryCode());
									for (CityDto cityDtoList : cityDto.getCityList()) {
										if (mostlyAddressSet.getString(3).equalsIgnoreCase(cityDtoList.getCityCode()) && mostlyAddressSet.getString(2).equalsIgnoreCase("IN")) {			// 20200309: Juhi
											addressBookListDto.setCityName(cityDtoList.getCityName());
										}
									}
								}
							}
						}

						listOfDefltMstlyAddress.add(addressBookListDto);
						}

						
						
					} catch (Exception e) {
						
						addressBookLogger.error("EXCEPTION TYPE :",e);
						
						addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						addressBookLogger.debug("----------------getDefaultAndMostlyUsedAddresses finnaly----------------------");
						CloseConnections.closeResultSet(defaultAddressSet);
						CloseConnections.closeResultSet(mostlyAddressSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);

			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		addressBookListDto.setListOfDefltMstlyAddress(listOfDefltMstlyAddress);

		return addressBookListDto;
	}


	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getDetailsFromPincode(java.lang.String)
	 */
	@Transactional
	@Override
	public AddressAreaDto getDetailsFromPincode(String pincode) {
		addressBookLogger.debug("AddressBookDaoImpl:getDetailsFromPincode");
		String getServiceStationsByPincodeSQL = Constants.PININFO_PROC;
		AddressAreaDto addressAreaDto = null;
		try {
			addressAreaDto = getSession().doReturningWork(new ReturningWork<AddressAreaDto>() {

				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public AddressAreaDto execute(Connection connection) throws SQLException {
					AddressAreaDto addressAreaDto = null;
					try {
						callableStatement = connection.prepareCall(getServiceStationsByPincodeSQL);
						callableStatement.setString(1, pincode);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						while (rs.next()) {
							addressAreaDto = new AddressAreaDto();
							addressAreaDto.setPincode(rs.getString("careapin"));
							addressAreaDto.setAreaCode(rs.getString("carea"));
							addressAreaDto.setCity(rs.getString("CAREACITY"));
							addressAreaDto.setState(rs.getString("CSTATE"));
							addressAreaDto.setCountry(Constants.COUNTRY_INDIA);
							addressAreaDto.setCityCode(rs.getString("CAREA"));
							addressAreaDto.setStateCode(rs.getString("CSTATECD"));
							addressAreaDto.setCountryCode(Constants.COUNTRYCODE_IN);
						}
					} catch(Exception exception){
						addressBookLogger.error("EXCEPTION TYPE :",exception);


					}
					finally {
						addressBookLogger.debug("------------getDetailsFromPincode finally-----------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return addressAreaDto;
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
		return addressAreaDto;
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#validateDomesticIntlPin(java.lang.String)
	 */
	 @Transactional
	@Override
	public AddressAreaDto validateDomesticIntlPin(String pincode) {
		addressBookLogger.debug("AddressBookDaoImpl : validateDomesticIntlPin");
		String getServiceStationsByPincodeSQL = Constants.SP_GET_PINCODE;
		AddressAreaDto addressAreaDto = null;
		try {
			addressAreaDto = getSession().doReturningWork(new ReturningWork<AddressAreaDto>() {

				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public AddressAreaDto execute(Connection connection) throws SQLException {
					AddressAreaDto addressAreaDto = null;
					try {
						callableStatement = connection.prepareCall(getServiceStationsByPincodeSQL);
						callableStatement.setString(1, pincode);
						callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						while (rs.next()) {
							addressAreaDto = new AddressAreaDto();
							addressAreaDto.setPincode(rs.getString("careapin"));
							addressAreaDto.setAreaCode(rs.getString("carea"));
							addressAreaDto.setCity(rs.getString("CAREACITY"));
							addressAreaDto.setState(rs.getString("CSTATE"));
							addressAreaDto.setCountry(Constants.COUNTRY_INDIA);
							addressAreaDto.setCityCode(rs.getString("CAREA"));
							addressAreaDto.setStateCode(rs.getString("CSTATECD"));
							addressAreaDto.setCountryCode(Constants.COUNTRYCODE_IN);
						}
					}catch(Exception exception){
						addressBookLogger.error("EXCEPTION TYPE :",exception);
					}
					finally {
						addressBookLogger.debug("------------validateDomesticIntlPin finally-----------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return addressAreaDto;
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
		return addressAreaDto;
	}
	
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getDetailsFromPincodeBookaShipment(java.lang.String)
	 */
	@Transactional
	@Override
	public AddressAreaDto getDetailsFromPincodeBookaShipment(String loginId,String pincode) {
		addressBookLogger.debug("AddressBookDaoImpl:getDetailsFromPincodeBookaShipment");
		AddressAreaDto addressAreaDto = null;
		try {
			addressAreaDto = getSession().doReturningWork(new ReturningWork<AddressAreaDto>() {

				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public AddressAreaDto execute(Connection connection) throws SQLException {
					AddressAreaDto addressAreaDto = null;
					try {
						callableStatement = connection.prepareCall("{call UPROFILE4.PACK_ADDRESS_BOOK.GET_ADDRESS_SP_BS_SEARCH(?,?,?,?)}");
						callableStatement.setString(1, loginId);
						callableStatement.setString(2, pincode);
						callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
						callableStatement.registerOutParameter(4, OracleTypes.INTEGER);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(3);
						while (rs.next()) {
							addressAreaDto = new AddressAreaDto();
							addressAreaDto.setAreaCode(rs.getString("carea"));
							addressAreaDto.setCity(rs.getString("CAREACITY"));
							addressAreaDto.setState(rs.getString("CSTATE"));
							addressAreaDto.setCountry(rs.getString("cntryname"));
							addressAreaDto.setCityCode(rs.getString("CAREA"));
							addressAreaDto.setStateCode(rs.getString("CSTATECD"));
							addressAreaDto.setCountryCode(rs.getString("ccntrycode"));
						}
					}
					catch(Exception exception) {
						addressBookLogger.error("EXCEPTION TYPE :",exception);
					}
					finally {
						addressBookLogger.debug("------------getDetailsFromPincodeBookaShipment finally-----------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return addressAreaDto;
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
		return addressAreaDto;
	}





	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getCountries()
	 */
	@Transactional
	@Override
	public CountryDto getCountries() {
		addressBookLogger.debug("AddressBookDaoImpl:getCountries");
		CountryDto countryDto = new CountryDto();
		List<CountryDto> countryList = getCountryList();
		countryDto.setCountryList(countryList);
		return countryDto;
	}

	/**
	 * @return
	 */
	private List<CountryDto> getCountryList(){

		try{
			CountryDto countryDto;
			List<CountryDto>  countryMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(CountryMst.class).addOrder(Order.asc("countryName"));
			@SuppressWarnings("unchecked")
			List<CountryMst> countryList = (List<CountryMst>) criteria.list();
			for(CountryMst countryMst : countryList){
				countryDto = new CountryDto();
				CopyUtils.copy(countryMst, countryDto);
				countryMstDtoList.add(countryDto);
			}
			return countryMstDtoList;
		}catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getCities(java.lang.String)
	 */
	@Transactional
	@Override
	public CityDto getCities(String countryCode) {
		addressBookLogger.debug("AddressBookDaoImpl:getCities");
		CityDto cityDto = new CityDto();
		List<CityDto> cityList = getCityList(countryCode);
	//	List<CityDto> cityList =getSubCityList(countryCode);
		cityDto.setCityList(cityList);
		return cityDto;
	}

	@SuppressWarnings("unused")
	private List<CityDto> getSubCityList(String countryCode ,String cityFilter)
	{
		
		try{
			CityDto cityDto;
			List<CityDto>  cityMstDtoList = new ArrayList<>();
			String cityValue = cityFilter.toUpperCase();
/*			Criteria criteria = getSession().createCriteria(SubCitiesMst.class);
			Criterion filter1 =(Criterion) criteria.add(Restrictions.eq("countryCode", countryCode));
			Criterion filter2=(Criterion) criteria.add(Restrictions.ilike("cityName","cityValue%"));
			// Fetch records with the OR condition
		
			criteria.addOrder(Order.asc("cityName"));
			Criterion filter1 =(Criterion) criteria.add(Restrictions.eq("countryCode", countryCode));
			Criterion filter2 =(Criterion) criteria.add(Restrictions.like("cityName", "cityValue",MatchMode.START));
			LogicalExpression expression = Restrictions.and(filter1, filter2);
			criteria.add( expression);
			criteria.addOrder(Order.asc("cityName"));
			@SuppressWarnings("unchecked")
			List<SubCitiesMst> list = (List<SubCitiesMst>) criteria.list();*/
			//String query = "select st.cityName ,st.cityCode ,st.countryCode  from WEBMASTER.SUBCTMST st where st.countryCode =:countryCode AND st.cityName like :cityFilter''
	        String hql=" from SubCitiesMst emp WHERE emp.countryCode ='"+countryCode+"' AND emp.cityName like '"+cityValue+"%' ";
            Query data =getSession().createQuery(hql);
          //  System.out.println(hql);
			List<SubCitiesMst> list =data.list();
			Set<SubCitiesMst> cityList = new LinkedHashSet<SubCitiesMst>(list);
			System.out.println("Country Code :  "+ countryCode + " Size of cityList : " + cityList.size());
			for(SubCitiesMst citiesMst : cityList){
				cityDto = new CityDto();
				CopyUtils.copy(citiesMst, cityDto);
				cityMstDtoList.add(cityDto);
			}
			return cityMstDtoList;
		}catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}


	/**
	 * @param countryCode
	 * @return
	 */
	private List<CityDto> getCityList(String countryCode){

		try{
			CityDto cityDto;
			List<CityDto>  cityMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(CitiesMst.class);
			criteria.add(Restrictions.eq("countryCode", countryCode));
			criteria.addOrder(Order.asc("cityName"));
			@SuppressWarnings("unchecked")
			List<CitiesMst> cityList = (List<CitiesMst>) criteria.list();
			//System.out.println("Country Code :  "+ countryCode + " Size of cityList : " + cityList.size());
			for(CitiesMst citiesMst : cityList){
				cityDto = new CityDto();
				CopyUtils.copy(citiesMst, cityDto);
				cityMstDtoList.add(cityDto);
			}
			return cityMstDtoList;
		}catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}

	private List<CityDto> getSubCityList(String countryCode){

		try{
			CityDto cityDto;
			List<CityDto>  cityMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(SubCitiesMst.class);
			criteria.add(Restrictions.eq("countryCode", countryCode));
			criteria.addOrder(Order.asc("cityName"));
			@SuppressWarnings("unchecked")
			List<SubCitiesMst> cityData= (List<SubCitiesMst>) criteria.list();
			Set<SubCitiesMst> cityList =new LinkedHashSet<SubCitiesMst>(cityData);
			System.out.println("Country Code :  "+ countryCode + " Size of cityList : " + cityList.size());
			for(SubCitiesMst citiesMst : cityList){
				cityDto = new CityDto();
				CopyUtils.copy(citiesMst, cityDto);
				cityMstDtoList.add(cityDto);
			}
			return cityMstDtoList;
		}catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}
	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getAddressList(com.bluedart.addressbook.dto.AddressBookListDto)
	 */
	@Transactional
	@Override
	public AddressBookListDto getAddressList(AddressBookListDto addressBookListDto) {
		addressBookLogger.debug("AddressBookDaoImpl:getAddressList");
		String sql = Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?Constants.GET_SHIPPER_ADDRESS_PROC:Constants.GET_CONSIGNEE_ADDRESS_PROC;
		AddressBookListDto addressBookListDto1 = null;
		List<AddressBookListDto> list = new ArrayList<>();
		try {
			addressBookListDto1 = getSession().doReturningWork(new ReturningWork<AddressBookListDto>() {

				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public AddressBookListDto execute(Connection connection) throws SQLException {
					AddressBookListDto addressBookListDto1 = null;
					try {
						callableStatement = connection.prepareCall(sql);
						callableStatement.setString(1, addressBookListDto.getLoginId());
						callableStatement.setString(2, addressBookListDto.getAddressType());
						callableStatement.setString(3, addressBookListDto.getName());
						callableStatement.setString(4, addressBookListDto.getAddressLine1());
						callableStatement.setString(5, addressBookListDto.getPincode());
						callableStatement.setString(6, addressBookListDto.getAreaCode());
						callableStatement.setString(7, addressBookListDto.getCustomerCode());
						callableStatement.setInt(8, addressBookListDto.getPageSize());
						callableStatement.setInt(9, addressBookListDto.getPageNumber());
						callableStatement.registerOutParameter(10, OracleTypes.CURSOR); 
						callableStatement.registerOutParameter(11, OracleTypes.NUMBER);
						callableStatement.execute();
						addressBookListDto.setTotalRecords(callableStatement.getInt(11));
						rs = (ResultSet) callableStatement.getObject(10);
						while (rs.next()) {
							addressBookListDto1 = new AddressBookListDto();
							addressBookListDto1.setLoginId(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(5):rs.getString(3));
							addressBookListDto1.setAddressType(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(21):rs.getString(20));
							addressBookListDto1.setAreaCode(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(18):rs.getString(16));
							addressBookListDto1.setCustomerCode(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(19):rs.getString(17));
							addressBookListDto1.setName(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(7):rs.getString(5));
							addressBookListDto1.setPincode(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(12):(rs.getString(10)!= null ?rs.getString(10):""));
							addressBookListDto1.setAddressLine1(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(8):rs.getString(6));
							addressBookListDto1.setContactPerson(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(16):rs.getString(14));
							addressBookListDto1.setMobileNumber(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(22):rs.getString(21));
							addressBookListDto1.setAddressId(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getLong(4):rs.getLong(2));
							addressBookListDto1.setEditDeletePermissionFlag(Constants.SHIPPER.equalsIgnoreCase(addressBookListDto.getAddressType())?rs.getString(3):Constants.YES);
							list.add(addressBookListDto1);
						}
					}catch(Exception exception){
						addressBookLogger.error("EXCEPTION TYPE :",exception);
					} finally {
						addressBookLogger.debug("--------------getAddressList finally------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return addressBookListDto;
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
		addressBookListDto1.setAddressBookListDtos(list);

		return addressBookListDto1;
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#addAddress(com.bluedart.addressbook.dto.AddressBookDto)
	 */
	/*@Transactional
	@Override
	public AddressBookDto addAddress(AddressBookDto addressBookDto) {
		addressBookLogger.debug("AddressBookDaoImpl : addAddress");
		AddressBookDto addrBookDto = null;
		if(Constants.SHIPPER.equalsIgnoreCase(addressBookDto.getAddressType())){
			AddressBookMaster addrMasterDto = null;
			if(Constants.TRUE.equalsIgnoreCase(addressBookDto.getDefaultAddress())){// if checked
				String prevDefaultAddressUpdated = "failure"; 
				Criteria criteria = getSession().createCriteria(AddressBookMaster.class);
				criteria.add(Restrictions.eq("loginId", addressBookDto.getLoginId()));
				criteria.add(Restrictions.eq("defaultAddress", Constants.TRUE));
				@SuppressWarnings("unchecked")
				List<AddressBookMaster> defaultAddressList = (List<AddressBookMaster>) criteria.list();
				if(!defaultAddressList.isEmpty()){
					for (AddressBookMaster addressBook : defaultAddressList) {
						//System.out.println(addressBook.getAddressId());
						addrMasterDto = (AddressBookMaster)getSession().get(AddressBookMaster.class,addressBook.getAddressId());
						addrMasterDto.setDefaultAddress(Constants.FALSE);
						try{
							getSession().update(addrMasterDto);
							prevDefaultAddressUpdated = "success";
						}catch (Exception exception) {
							//System.out.println("1");
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}
					}
					if("success".equalsIgnoreCase(prevDefaultAddressUpdated)){
						try {
							getSession().clear();
							addrMasterDto = new AddressBookMaster();
							addrBookDto = new AddressBookDto();
							CopyUtils.copy(addressBookDto, addrMasterDto);
							getSession().save(addrMasterDto);
							addrBookDto.setStatus(true);
						}catch (Exception exception) {
							//System.out.println("2");  
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}
					}
				}else{
					try {
						addrMasterDto = new AddressBookMaster();
						addrBookDto = new AddressBookDto();
						CopyUtils.copy(addressBookDto, addrMasterDto);
						getSession().save(addrMasterDto);
						addrBookDto.setStatus(true);
					}catch (Exception exception) {
						//System.out.println("3");
						addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
					}
				}
			}else{
				try {
					addrMasterDto = new AddressBookMaster();
					addrBookDto = new AddressBookDto();
					CopyUtils.copy(addressBookDto, addrMasterDto);
					getSession().save(addrMasterDto);
					addrBookDto.setStatus(true);
				}catch (Exception exception) {
					//System.out.println("4");
					addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
				}
			}
		}else{
			AddressBookMaster addrMasterDto = null;
			try {
				addrMasterDto = new AddressBookMaster();
				addrBookDto = new AddressBookDto();
				CopyUtils.copy(addressBookDto, addrMasterDto);
				getSession().save(addrMasterDto);
				addrBookDto.setStatus(true);
			}catch (Exception exception) {
				addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}
		}
		return addrBookDto;
	}*/


	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#addAddress(com.bluedart.addressbook.dto.AddressBookDto)
	 */
	@Transactional
	@Override
	public AddressBookDto addAddress(AddressBookDto addressBookDto) {
		addressBookLogger.debug("AddressBookDaoImpl : addAddress");
		AddressBookDto addrBookDto = null;
		StringBuilder sqlQuery = new StringBuilder();

		if(Constants.SHIPPER.equalsIgnoreCase(addressBookDto.getAddressType())){
			sqlQuery.append("insert into")
			.append(" UPROFILE4.CNEEMST_T")
			.append(" (")
			.append("CCADDRID,CLOGINID,CADDRESSTYPE,AFF_AC,AFF_CC,CCNEENAME,CCONTACT,")
			.append("CCNEEADR1,CCNEEADR2,CCNEEADR3,CCNEEPIN,CCITYCODE,CSTATECD,CCNTRYCODE,")
			.append("CCNEETEL,CCNEEMOB,CCNEEEML,COFFICECLOSURETIME,CDEFAULTADDRESS,INSERTIONDATE,CCNEECODE,CSEARCHADDRESS,CGSTN_UIDCODE,CCITYNAME")
			.append(")")
			.append(" values")
			.append("(")
			.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
			.append(")");
			try {
				addrBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {
					@Override
					public AddressBookDto execute(Connection connection) throws SQLException {
						int addressId = 0;
						String logIdQuery = "select UPROFILE4.CNEEMST_T_SEQ.NEXTVAL from dual";
						PreparedStatement pst = connection.prepareStatement(logIdQuery);
						ResultSet rs = pst.executeQuery();
						if(rs.next())
							addressId = rs.getInt(1);


						AddressBookDto addrDTO;
						PreparedStatement pStmt =null;
						pStmt = connection.prepareStatement(sqlQuery.toString());
						pStmt.setInt(1, addressId);
						pStmt.setString(2, addressBookDto.getLoginId().toUpperCase());
						pStmt.setString(3, addressBookDto.getAddressType().toUpperCase());
						pStmt.setString(4, addressBookDto.getAreaCode().toUpperCase());
						pStmt.setString(5, addressBookDto.getCustomerCode().toUpperCase());
						pStmt.setString(6, addressBookDto.getName().toUpperCase());
						pStmt.setString(7, addressBookDto.getContactPerson().toUpperCase());
						pStmt.setString(8, addressBookDto.getAddressLine1().toUpperCase());
						pStmt.setString(9, addressBookDto.getAddressLine2().toUpperCase());
						pStmt.setString(10, addressBookDto.getLandmark().toUpperCase());
						pStmt.setString(11, addressBookDto.getPincode().toUpperCase());
						pStmt.setString(12, addressBookDto.getCityCode().toUpperCase());
						pStmt.setString(13, addressBookDto.getStateCode().toUpperCase());
						pStmt.setString(14, addressBookDto.getCountryCode().toUpperCase());
						pStmt.setString(15, addressBookDto.getTelephoneNumber().toUpperCase());
						pStmt.setString(16, addressBookDto.getMobileNumber().toUpperCase());
						pStmt.setString(17, addressBookDto.getEmailId().toUpperCase());
						pStmt.setString(18, addressBookDto.getOfficeClosureTime().toUpperCase());
						pStmt.setDate(20, DateUtil.convertSQLDate(addressBookDto.getCreationDate()));
						getVendoCode(addressBookDto);
						pStmt.setString(21, addressBookDto.getVendorCode());
						pStmt.setString(22, addressBookDto.getName().toUpperCase()+","+addressBookDto.getAreaCode().toUpperCase()+","+addressBookDto.getCustomerCode().toUpperCase()
								+","+addressBookDto.getAddressLine1().toUpperCase()+","+addressBookDto.getAddressLine2()+","+
								addressBookDto.getLandmark().toUpperCase()+","+addressBookDto.getPincode().toUpperCase());
						pStmt.setString(23, addressBookDto.getGstIn());
						pStmt.setString(24,addressBookDto.getCity());
						if(Constants.TRUE.equalsIgnoreCase(addressBookDto.getDefaultAddress())){// if checked
							Criteria criteria = getSession().createCriteria(AddressBookMaster.class);
							criteria.add(Restrictions.eq("loginId", addressBookDto.getLoginId()));
							criteria.add(Restrictions.eq("defaultAddress", Constants.TRUE));
							@SuppressWarnings("unchecked")
							List<AddressBookMaster> defaultAddressList = (List<AddressBookMaster>) criteria.list();
							if(!defaultAddressList.isEmpty()){// if previously default shipper present
								String prevDefaultAddressUpdated = "";
								PreparedStatement prepStmt =null;
								for (AddressBookMaster addressBook : defaultAddressList) {
									String updatePrevDefaultAddressQuery = "update UPROFILE4.CNEEMST_T set CDEFAULTADDRESS = ? where CCADDRID = ?";
									prepStmt = connection.prepareStatement(updatePrevDefaultAddressQuery);
									prepStmt.setString(1, Constants.FALSE);
									prepStmt.setLong(2, addressBook.getAddressId());
									int defaultPrevUpdateSize = 0;
									try{
										defaultPrevUpdateSize = prepStmt.executeUpdate();
									}catch(Exception exception){
										addressBookLogger.error("EXCEPTION TYPE :",exception);
										
										addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
										throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
									}finally{
										addressBookLogger.debug("-------- inner finally blocak-----------");
										CloseConnections.closePreparedStatement(prepStmt);
									}
									if(defaultPrevUpdateSize > 0)
										prevDefaultAddressUpdated = Constants.TRUE;
									else
										prevDefaultAddressUpdated = Constants.FALSE;
									if(Constants.TRUE.equalsIgnoreCase(prevDefaultAddressUpdated)){
										pStmt.setString(19, addressBookDto.getDefaultAddress().toUpperCase());
									}
								}
							}else{
								pStmt.setString(19, addressBookDto.getDefaultAddress().toUpperCase());
							}
						}else{
							pStmt.setString(19, addressBookDto.getDefaultAddress().toUpperCase());
						}
						int size = 0;
						try{
							size = pStmt.executeUpdate();
						}catch(Exception exception){
							
							addressBookLogger.error("EXCEPTION TYPE :",exception);
							
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}finally{
							addressBookLogger.debug("-----------------addAddress finally-----------------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closePreparedStatement(pStmt);
						}
						addrDTO = new AddressBookDto(); 
						if(size > 0)
							addrDTO.setStatus(true);
						else
							addrDTO.setStatus(false);
						return addrDTO;								

					}
				});
			} catch(Exception e){
				addressBookLogger.error("EXCEPTION TYPE :",e);
				
				
				addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}

			return addrBookDto;
		}else{
			sqlQuery.append("insert into")
			.append(" UPROFILE4.CNEEMST_T")
			.append(" (")
			.append(" CCADDRID,CLOGINID,CADDRESSTYPE,")
			.append(" CCNEENAME,CCONTACT,CCNEEADR1,CCNEEADR2,CCNEEADR3,CCNEEPIN,CCITYCODE,")
			.append(" CSTATECD,CCNTRYCODE,CCNEETEL,CCNEEMOB,CCNEEEML,INSERTIONDATE,CSEARCHADDRESS,CCITYNAME")
			.append(")")
			.append(" values")
			.append("(")
			.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
			.append(")");

			try {
				addrBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {
					@Override
					public AddressBookDto execute(Connection connection) throws SQLException {

						int addressId = 0;
						String logIdQuery = "select UPROFILE4.CNEEMST_T_SEQ.NEXTVAL from dual";
						PreparedStatement pst = connection.prepareStatement(logIdQuery);
						ResultSet rs = pst.executeQuery();
						if(rs.next())
							addressId = rs.getInt(1);

						AddressBookDto addrDTO = null;
						PreparedStatement pStmt =null;
						try{
							pStmt = connection.prepareStatement(sqlQuery.toString());
							pStmt.setInt(1, addressId);
							pStmt.setString(2, addressBookDto.getLoginId().toUpperCase());
							pStmt.setString(3, addressBookDto.getAddressType().toUpperCase());
							pStmt.setString(4, addressBookDto.getName().toUpperCase());
							pStmt.setString(5, addressBookDto.getContactPerson().toUpperCase());
							pStmt.setString(6, addressBookDto.getAddressLine1().toUpperCase());
							pStmt.setString(7, addressBookDto.getAddressLine2().toUpperCase());
							pStmt.setString(8, addressBookDto.getLandmark().toUpperCase());
							pStmt.setString(9, addressBookDto.getPincode().toUpperCase());
							pStmt.setString(10, addressBookDto.getCityCode().toUpperCase());
							System.out.println("CityCode in addressbook DAOIML"  +addressBookDto.getCityCode().toUpperCase());
							pStmt.setString(11, addressBookDto.getStateCode().toUpperCase());
							System.out.println("StateCode in addressbook DAOIML"  +addressBookDto.getStateCode().toUpperCase());
							pStmt.setString(12, addressBookDto.getCountryCode().toUpperCase());
							pStmt.setString(13, addressBookDto.getTelephoneNumber().toUpperCase());
							pStmt.setString(14, addressBookDto.getMobileNumber().toUpperCase());
							pStmt.setString(15, addressBookDto.getEmailId().toUpperCase());
							pStmt.setDate(16, addressBookDto.getCreationDate());
							pStmt.setString(17, addressBookDto.getName().toUpperCase()+","+addressBookDto.getAddressLine1().toUpperCase()+","+addressBookDto.getAddressLine2()+","+
									addressBookDto.getLandmark().toUpperCase()+","+addressBookDto.getPincode().toUpperCase());
                            pStmt.setString(18, addressBookDto.getCity());
							int size = pStmt.executeUpdate();
							addrDTO = new AddressBookDto(); 
							if(size > 0)
								addrDTO.setStatus(true);
							else
								addrDTO.setStatus(false);
							return addrDTO;
						}catch(Exception exception){
							addressBookLogger.error("EXCEPTION TYPE :",exception);
							
							addressBookLogger.info("Inner Exception block----------------------");
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}finally{
							
							addressBookLogger.debug("-------- addAddress finally-----------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closePreparedStatement(pStmt);
						}

					}
				});
			} catch(Exception e){
				
				addressBookLogger.error("EXCEPTION TYPE :",e);
				
				e.printStackTrace();
				addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}
			return addrBookDto;
		}
	}


	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getAddressById(long)
	 */
	@Transactional
	@Override
	public AddressBookDto getAddressById(long addrId) {
		addressBookLogger.debug("AddressBookDaoImpl:getAddressById");
		AddressBookDto addrDto = null;
		try {
			Query query = getSession()
					.createQuery("from AddressBookMaster addr where addr.addressId = :addressId").setParameter("addressId", addrId);
			@SuppressWarnings("unchecked")
			List<AddressBookMaster> addrList = query.list();
			if (addrList != null && !addrList.isEmpty()) {
				for (AddressBookMaster addressBookMaster : addrList) {
					addrDto = new AddressBookDto();
					CopyUtils.copy(addressBookMaster, addrDto);
				}
			}

			if(Constants.SHIPPER.equalsIgnoreCase(addrDto.getAddressType())){
				List<AffiliatePermissionDto> affPermissionDtoList = affiliatePermissionService.getAffiliateLevelPermissions(addrDto.getLoginId(),null,null,"SHIPPER_ADDRESS_BOOK-CREATE_UPDATE_DELETE");
				addrDto.setAffiliateCodes(affPermissionDtoList);
				AddressAreaDto addressAreaDto = getDetailsFromPincode(addrDto.getPincode());
				if(addressAreaDto!=null){
					addrDto.setCity(addressAreaDto.getCity());
					addrDto.setState(addressAreaDto.getState());
					addrDto.setCountry(addressAreaDto.getCountry());
					addrDto.setCityCode(addressAreaDto.getCityCode());
					addrDto.setStateCode(addressAreaDto.getStateCode());
					addrDto.setCountryCode(addressAreaDto.getCountryCode());
				}
			}else{
				if(Constants.COUNTRYCODE_IN.equalsIgnoreCase(addrDto.getCountryCode())){
					AddressAreaDto addressAreaDto = getDetailsFromPincode(addrDto.getPincode());
					if(addressAreaDto!=null){
						addrDto.setCity(addressAreaDto.getCity());
						addrDto.setState(addressAreaDto.getState());
						addrDto.setCountry(addressAreaDto.getCountry());
						addrDto.setCityCode(addressAreaDto.getCityCode());
						addrDto.setStateCode(addressAreaDto.getStateCode());
						addrDto.setCountryCode(addressAreaDto.getCountryCode());
					}
					List<CountryDto> countryList = getCountries().getCountryList();
					addrDto.setCountryList(countryList);
				}else{
					List<CountryDto> countryList = getCountries().getCountryList();
					addrDto.setCountryList(countryList);
					//Juhi 20200312
					//List<CityDto> cityList = getCities(addrDto.getCountryCode()).getCityList();
					List<CityDto> cityList = getSubCityList(addrDto.getCountryCode());
					// addrDto.setCity(addrDto.getCity());
					addrDto.setCityDtoList(cityList);
				}
			}
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}

		return addrDto;
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#updateAddress(com.bluedart.addressbook.dto.AddressBookDto)
	 */
	@Transactional
	@Override
	public AddressBookDto updateAddress(AddressBookDto addressBookDto) {
		addressBookLogger.debug("AddressBookDaoImpl : updateAddress");
		AddressBookDto addrBookDto;
		StringBuilder sqlQuery = new StringBuilder();
		if(Constants.SHIPPER.equalsIgnoreCase(addressBookDto.getAddressType())){
			sqlQuery.append("update")
			.append(" UPROFILE4.CNEEMST_T")
			.append(" set")
			.append(" AFF_AC = ?,AFF_CC = ?,CCNEENAME = ?,CCONTACT = ?,CCNEEADR1 = ?,CCNEEADR2 = ?,")
			.append("CCNEEADR3 = ?,CCNEEPIN = ?,CCITYCODE = ?,CSTATECD = ?,CCNTRYCODE = ?,CCNEETEL = ?,")
			.append("CCNEEMOB = ?,CCNEEEML = ?,COFFICECLOSURETIME = ?,CDEFAULTADDRESS = ?,DMODIFICATIONDATE = ?,CSEARCHADDRESS = ?,CGSTN_UIDCODE = ?,CCITYNAME= ?")
			.append(" where")
			.append(" CCADDRID = ?");

			try {
				addrBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {
					@Override
					public AddressBookDto execute(Connection connection) throws SQLException {
						AddressBookDto addrDTO;
						PreparedStatement pStmt =null;
						pStmt = connection.prepareStatement(sqlQuery.toString());
						pStmt.setString(1, addressBookDto.getAreaCode().toUpperCase());
						pStmt.setString(2, addressBookDto.getCustomerCode().toUpperCase());
						pStmt.setString(3, addressBookDto.getName().toUpperCase());
						pStmt.setString(4, addressBookDto.getContactPerson().toUpperCase());
						pStmt.setString(5, addressBookDto.getAddressLine1().toUpperCase());
						pStmt.setString(6, addressBookDto.getAddressLine2().toUpperCase());
						pStmt.setString(7, addressBookDto.getLandmark().toUpperCase());
						pStmt.setString(8, addressBookDto.getPincode().toUpperCase());
						pStmt.setString(9, addressBookDto.getCityCode().toUpperCase());
						pStmt.setString(10, addressBookDto.getStateCode().toUpperCase());
						pStmt.setString(11, addressBookDto.getCountryCode().toUpperCase());
						pStmt.setString(12, addressBookDto.getTelephoneNumber().toUpperCase());
						pStmt.setString(13, addressBookDto.getMobileNumber().toUpperCase());
						pStmt.setString(14, addressBookDto.getEmailId().toUpperCase());
						pStmt.setString(15, addressBookDto.getOfficeClosureTime().toUpperCase());
						pStmt.setDate(17, addressBookDto.getModificationDate());
						pStmt.setString(18, addressBookDto.getName().toUpperCase()+","+addressBookDto.getAreaCode().toUpperCase()+","+addressBookDto.getCustomerCode().toUpperCase()
								+","+addressBookDto.getAddressLine1().toUpperCase()+","+addressBookDto.getAddressLine2()+","+
								addressBookDto.getLandmark().toUpperCase()+","+addressBookDto.getPincode().toUpperCase());
						pStmt.setString(19, addressBookDto.getGstIn());
						pStmt.setString(20, addressBookDto.getCity());
						pStmt.setLong(21, addressBookDto.getAddressId());
						if(Constants.TRUE.equalsIgnoreCase(addressBookDto.getDefaultAddress())){// if checked
							Criteria criteria = getSession().createCriteria(AddressBookMaster.class);
							criteria.add(Restrictions.eq("loginId", addressBookDto.getLoginId()));
							criteria.add(Restrictions.eq("defaultAddress", Constants.TRUE));
							@SuppressWarnings("unchecked")
							List<AddressBookMaster> defaultAddressList = (List<AddressBookMaster>) criteria.list();
							if(!defaultAddressList.isEmpty()){// if previously default shipper present
								String prevDefaultAddressUpdated = "";
								PreparedStatement prepStmt =null;
								for (AddressBookMaster addressBook : defaultAddressList) {
									String updatePrevDefaultAddressQuery = "update UPROFILE4.CNEEMST_T set CDEFAULTADDRESS = ? where CCADDRID = ?";
									prepStmt = connection.prepareStatement(updatePrevDefaultAddressQuery);
									prepStmt.setString(1, Constants.FALSE);
									prepStmt.setLong(2, addressBook.getAddressId());
									int defaultPrevUpdateSize = 0;
									try{
										defaultPrevUpdateSize = prepStmt.executeUpdate();
									}catch(Exception exception){
										
										addressBookLogger.error("EXCEPTION TYPE :",exception);
										
										
										addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
										throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
									}finally{
										addressBookLogger.debug("----------inner finally blocak----------");
										CloseConnections.closePreparedStatement(prepStmt);
									}
									if(defaultPrevUpdateSize > 0)
										prevDefaultAddressUpdated = Constants.TRUE;
									else
										prevDefaultAddressUpdated = Constants.FALSE;
									if(Constants.TRUE.equalsIgnoreCase(prevDefaultAddressUpdated)){
										pStmt.setString(16, addressBookDto.getDefaultAddress().toUpperCase());
									}
								}
							}else{
								pStmt.setString(16, addressBookDto.getDefaultAddress().toUpperCase());
							}
						}else{
							pStmt.setString(16, addressBookDto.getDefaultAddress().toUpperCase());
						}
						int size = 0;
						try{
							size = pStmt.executeUpdate();
						}catch(Exception exception){
							
							addressBookLogger.error("EXCEPTION TYPE :",exception);
							
							
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}finally{
							addressBookLogger.debug("----------updateAddress finally----------");
							CloseConnections.closePreparedStatement(pStmt);
						}
						addrDTO = new AddressBookDto(); 
						if(size > 0)
							addrDTO.setStatus(true);
						else
							addrDTO.setStatus(false);
						return addrDTO;								

					}
				});
			} catch(Exception e){
				addressBookLogger.error("EXCEPTION TYPE :",e);
				
				addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}

			return addrBookDto;
		}else{
			sqlQuery.append("update")
			.append(" UPROFILE4.CNEEMST_T")
			.append(" set")
			.append(" CCNEENAME = ?,CCONTACT = ?,CCNEEADR1 = ?,CCNEEADR2 = ?,")
			.append(" CCNEEADR3 = ?,CCNEEPIN = ?,CCITYCODE = ?,CSTATECD = ?,CCNTRYCODE = ?,")
			.append(" CCNEETEL = ?,CCNEEMOB = ?,CCNEEEML = ?,DMODIFICATIONDATE = ?,CSEARCHADDRESS = ?,CCITYNAME= ?")
			.append(" where")
			.append(" CCADDRID = ?");
			try {
				addrBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {
					@Override
					public AddressBookDto execute(Connection connection) throws SQLException {
						AddressBookDto addrDTO = null;
						PreparedStatement pStmt =null;
						try{
							pStmt = connection.prepareStatement(sqlQuery.toString());
							pStmt.setString(1, addressBookDto.getName().toUpperCase());
							pStmt.setString(2, addressBookDto.getContactPerson().toUpperCase());
							pStmt.setString(3, addressBookDto.getAddressLine1().toUpperCase());
							pStmt.setString(4, addressBookDto.getAddressLine2().toUpperCase());
							pStmt.setString(5, addressBookDto.getLandmark().toUpperCase());
							pStmt.setString(6, addressBookDto.getPincode().toUpperCase());
							pStmt.setString(7, addressBookDto.getCityCode().toUpperCase());
							pStmt.setString(8, addressBookDto.getStateCode().toUpperCase());
							pStmt.setString(9, addressBookDto.getCountryCode().toUpperCase());
							pStmt.setString(10, addressBookDto.getTelephoneNumber().toUpperCase());
							pStmt.setString(11, addressBookDto.getMobileNumber().toUpperCase());
							pStmt.setString(12, addressBookDto.getEmailId().toUpperCase());
							pStmt.setDate(13, addressBookDto.getModificationDate());
							pStmt.setString(14, addressBookDto.getName().toUpperCase()+","+addressBookDto.getAddressLine1().toUpperCase()+","+addressBookDto.getAddressLine2()+","+
									addressBookDto.getLandmark().toUpperCase()+","+addressBookDto.getPincode().toUpperCase());
							pStmt.setString(15, addressBookDto.getCity());
							pStmt.setLong(16, addressBookDto.getAddressId());
							addrDTO = new AddressBookDto(); 
							int size = 0;
							size = pStmt.executeUpdate();
							if(size > 0)
								addrDTO.setStatus(true);
							else
								addrDTO.setStatus(false);
							return addrDTO;
						}catch(Exception exception){
							addressBookLogger.error("EXCEPTION TYPE :",exception);
							
							
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}finally{
							addressBookLogger.debug("---------updateAddress finally------------");
							CloseConnections.closePreparedStatement(pStmt);
						}

					}
				});
			} catch(Exception e){
				
				addressBookLogger.error("EXCEPTION TYPE :",e);
				
				
				addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}
			return addrBookDto;
		}
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#deleteAddress(long)
	 */
	@Transactional
	@Override
	public AddressBookDto deleteAddress(long addrId) {
		addressBookLogger.debug("AddressBookDaoImpl : deleteAddress");
		AddressBookDto addrBookDto  = null;
		try {
			addrBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {
				@Override
				public AddressBookDto execute(Connection connection) throws SQLException {
					AddressBookDto addrDTO = new AddressBookDto();
					addrDTO = getAddressById(addrId);
					//PreparedStatement pStmt =null;
					AddressBookDto addrDto  = null;
					Query q = getSession().createQuery("delete from AddressBookMaster addr where addr.addressId = :addressId").setParameter("addressId", addrId);
					int size = q.executeUpdate();
					if(size > 0){
						try{
							long logId = 0;
							String logIdQuery = "select UPROFILE4.CNEEMST_LOG_T_SEQ.NEXTVAL from dual";
							PreparedStatement pst = connection.prepareStatement(logIdQuery);
							ResultSet rs = pst.executeQuery();
							if(rs.next())
								logId = rs.getInt(1);
							PreparedStatement st =null;
							StringBuilder insertLogQuery = new StringBuilder();
							int loggedSize = 0;
							try{
								if(Constants.SHIPPER.equalsIgnoreCase(addrDTO.getAddressType())){
									insertLogQuery.append("insert into")
									.append(" UPROFILE4.CNEEMST_LOG_T")
									.append(" (")
									.append("NADDRLOGID,CCADDRID,CLOGINID,CADDRESSTYPE,AFF_AC,AFF_CC,CCNEENAME,CCONTACT,")
									.append("CCNEEADR1,CCNEEADR2,CCNEEADR3,CCNEEPIN,CCITYCODE,CSTATECD,CCNTRYCODE,")
									.append("CCNEETEL,CCNEEMOB,CCNEEEML,COFFICECLOSURETIME,CDEFAULTADDRESS,INSERTIONDATE,")
									.append("CCNEECODE,DMODIFICATIONDATE,DSPBSDATE,CGSTN_UIDCODE")
									.append(")")
									.append(" values")
									.append("(")
									.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
									.append(")");
									st = connection.prepareStatement(insertLogQuery.toString());

									st.setLong(1, logId);
									st.setLong(2, addrDTO.getAddressId());
									st.setString(3, addrDTO.getLoginId().toUpperCase());
									st.setString(4, addrDTO.getAddressType().toUpperCase());
									st.setString(5, addrDTO.getAreaCode().toUpperCase());
									st.setString(6, addrDTO.getCustomerCode().toUpperCase());
									st.setString(7, addrDTO.getName().toUpperCase());
									st.setString(8, addrDTO.getContactPerson().toUpperCase());
									st.setString(9, addrDTO.getAddressLine1().toUpperCase());
									st.setString(10, addrDTO.getAddressLine2().toUpperCase());
									st.setString(11, (null!=addrDTO.getLandmark())?addrDTO.getLandmark().toUpperCase():null);
									st.setString(12, addrDTO.getPincode().toUpperCase());
									st.setString(13, (null!=addrDTO.getCityCode())?addrDTO.getCityCode().toUpperCase():null);
									st.setString(14, (null!=addrDTO.getStateCode())?addrDTO.getStateCode().toUpperCase():null);
									st.setString(15, addrDTO.getCountryCode().toUpperCase());
									st.setString(16, (null!=addrDTO.getTelephoneNumber())?addrDTO.getTelephoneNumber().toUpperCase():null);
									st.setString(17, (null!=addrDTO.getMobileNumber())?addrDTO.getMobileNumber().toUpperCase():null);
									st.setString(18, (null!=addrDTO.getEmailId())?addrDTO.getEmailId().toUpperCase():null);
									st.setString(19, addrDTO.getOfficeClosureTime().toUpperCase());
									st.setString(20, addrDTO.getDefaultAddress().toUpperCase());
									st.setDate(21, addrDTO.getCreationDate());
									st.setString(22, addrDTO.getVendorCode().toUpperCase());
									st.setDate(23, addrDTO.getModificationDate());
									st.setDate(24, addrDTO.getSpbsDateTime());
									st.setString(25, addrDTO.getGstIn());
								}else{
									insertLogQuery.append("insert into")
									.append(" UPROFILE4.CNEEMST_LOG_T")
									.append(" (")
									.append(" NADDRLOGID,CCADDRID,CLOGINID,CADDRESSTYPE,")
									.append(" CCNEENAME,CCONTACT,CCNEEADR1,CCNEEADR2,CCNEEADR3,CCNEEPIN,CCITYCODE,")
									.append(" CSTATECD,CCNTRYCODE,CCNEETEL,CCNEEMOB,CCNEEEML,INSERTIONDATE,")
									.append(" DMODIFICATIONDATE,DSPBSDATE")
									.append(")")
									.append(" values")
									.append("(")
									.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
									.append(")");
									st = connection.prepareStatement(insertLogQuery.toString());
									st.setLong(1, logId);
									st.setLong(2, addrDTO.getAddressId());
									st.setString(3, addrDTO.getLoginId().toUpperCase());
									st.setString(4, addrDTO.getAddressType().toUpperCase());
									st.setString(5, addrDTO.getName().toUpperCase());
									st.setString(6, addrDTO.getContactPerson().toUpperCase());
									st.setString(7, addrDTO.getAddressLine1().toUpperCase());
									st.setString(8, addrDTO.getAddressLine2().toUpperCase());
									st.setString(9, (null!=addrDTO.getLandmark())?addrDTO.getLandmark().toUpperCase():null);
									st.setString(10, (null!=addrDTO.getPincode())?addrDTO.getPincode().toUpperCase():null);
									st.setString(11, (null!=addrDTO.getCityCode())?addrDTO.getCityCode().toUpperCase():null);
									st.setString(12, (null!=addrDTO.getStateCode())?addrDTO.getStateCode().toUpperCase():null);
									st.setString(13, addrDTO.getCountryCode().toUpperCase());
									st.setString(14, (null!=addrDTO.getTelephoneNumber())?addrDTO.getTelephoneNumber().toUpperCase():null);
									st.setString(15, (null!=addrDTO.getMobileNumber())?addrDTO.getMobileNumber().toUpperCase():null);
									st.setString(16, (null!=addrDTO.getEmailId())?addrDTO.getEmailId().toUpperCase():null);
									st.setDate(17, addrDTO.getCreationDate());
									st.setDate(18, addrDTO.getModificationDate());
									st.setDate(19, addrDTO.getSpbsDateTime());
								}
								addrDto = new AddressBookDto();
								loggedSize = st.executeUpdate();
								if(loggedSize > 0)
									addrDto.setStatus(true);
								else
									addrDto.setStatus(false);
							}catch(Exception exception){
								
								addressBookLogger.error("EXCEPTION TYPE :",exception);
								
								
								addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
								throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
							}finally{
							logger.debug("--------------------DeleteAddress finally-------------------");
								CloseConnections.closeResultSet(rs);
								CloseConnections.closePreparedStatement(pst);
								CloseConnections.closePreparedStatement(st);
							}
						}catch(Exception exception){
							
							addressBookLogger.error("EXCEPTION TYPE :",exception);
							
							
							addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}finally{
							
							
							
						}
					}
					return addrDto;
				}
			});
		} catch(Exception e){
			addressBookLogger.error("EXCEPTION TYPE :",e);
			
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}
		return addrBookDto;

	}

	/* (non-Javadoc)
	 * @see com.bluedart.ssbook.dao.AddressBookDao#importAddresses(com.bluedart.addressbook.dto.ImportDto)
	 */
	@Transactional
	@Override
	public ImportDto importAddresses(ImportDto importDto) {
		addressBookLogger.debug("AddressBookDaoImpl:importAddresses");
		ImportDto importAddrDto = new ImportDto();
		List<AddressBookDto> importAddressList = importDto.getImportAddressList();
		List<AddressBookImportDetailDto> addressBookImportDetailDtos = new ArrayList<>();
		List<AddressBookDto> addressBookDtos = new ArrayList<>();
		if(Constants.SHIPPER.equalsIgnoreCase(importDto.getAddressType())){
			for (AddressBookDto addressBookDto : importAddressList) {
				AddressBookImportDetailDto addressBookImportDetailDto1 = new AddressBookImportDetailDto();
				addressBookImportDetailDto1.setRowNumber(addressBookDto.getRowNumber());
				addressBookImportDetailDto1.setColumnName(addressBookDto.getColumnName());
				addressBookImportDetailDto1.setAreaCode(addressBookDto.getAreaCode());
				addressBookImportDetailDto1.setCustomerCode(addressBookDto.getCustomerCode());
				addressBookImportDetailDto1.setName(addressBookDto.getName());
				addressBookImportDetailDto1.setContactPerson(addressBookDto.getContactPerson());
				addressBookImportDetailDto1.setAddressLine1(addressBookDto.getAddressLine1());
				addressBookImportDetailDto1.setAddressLine2(addressBookDto.getAddressLine2());
				addressBookImportDetailDto1.setLandmark(addressBookDto.getLandmark());
				addressBookImportDetailDto1.setPincode(addressBookDto.getPincode());
				addressBookImportDetailDto1.setTelephoneNumber(addressBookDto.getTelephoneNumber());
				addressBookImportDetailDto1.setMobileNumber(addressBookDto.getMobileNumber());
				addressBookImportDetailDto1.setEmailId(addressBookDto.getEmailId());
				addressBookImportDetailDto1.setOfficeClosureTime(addressBookDto.getOfficeClosureTime());
				addressBookImportDetailDto1.setDefaultAddress(addressBookDto.getDefaultAddress());
				addressBookImportDetailDto1.setCountryCode(addressBookDto.getCountry());
				addressBookImportDetailDto1.setCityCode(addressBookDto.getCity());
				addressBookImportDetailDto1.setGstIn(addressBookDto.getGstIn());
				addressBookImportDetailDto1.setImportRemarks(addressBookDto.getImportRemarks());
				addressBookImportDetailDto1.setSql_type(environment.getProperty(Constants.IMPORT_ADDRESS_OBJ));

				addressBookImportDetailDtos.add(addressBookImportDetailDto1);
			}
		}else if(Constants.CONSIGNEE.equalsIgnoreCase(importDto.getAddressType())){   
			StringBuilder checkPinFormatQuery = new StringBuilder();
			checkPinFormatQuery.append("select nvl(trim(cpinformat),0) pinformat from")
			.append(" (sELECT t.cpinformat FROM cntrymst t  where t.CCNTRYCODE=")
			.append(" (select ccntrycode from WEBMASTER.CNTRYMST where upper(ccntryname)=?))");
			List<AddressBookDto> countryPinList = null;
			try {
				countryPinList = getSession().doReturningWork(new ReturningWork<List<AddressBookDto>>() {
					@Override
					public List<AddressBookDto> execute(Connection connection) throws SQLException {
						String pinFormat = "";
						List<AddressBookDto> countryPinList = new ArrayList<AddressBookDto>();
						ResultSet rs = null;
						PreparedStatement pStmt =null;
						pStmt = connection.prepareStatement(checkPinFormatQuery.toString());
						try {
							for (AddressBookDto addressBookDto : importAddressList) {
								pStmt.setString(1, addressBookDto.getCountry().trim().toUpperCase());
								rs = pStmt.executeQuery();
								if (rs!=null && rs.next()) {
									pinFormat = rs.getString("pinformat");
								} 
								addressBookDto.setPincodeFormats(pinFormat);
								countryPinList.add(addressBookDto);
							}
						} catch (HibernateException e) {
							addressBookLogger.error("EXCEPTION TYPE :",e);
							
							
							return null;
						} finally {
							logger.debug("------------importAddresses finally inner--------------");
							CloseConnections.closeResultSet(rs);
							CloseConnections.closePreparedStatement(pStmt);
							
						}
						return countryPinList;
					}
				});
			} catch(Exception e){
				
				addressBookLogger.error("EXCEPTION TYPE :",e);
				
				
				addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
				throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
			}

			for (AddressBookDto addressBookDto : countryPinList) {
				AddressBookImportDetailDto addressBookImportDetailDto1 = new AddressBookImportDetailDto();
				if(!Constants.COUNTRY_INDIA.equalsIgnoreCase(addressBookDto.getCountry().trim())){
					boolean match = false; 
					if(!"0".equalsIgnoreCase(addressBookDto.getPincodeFormats()) || "".equalsIgnoreCase(addressBookDto.getPincodeFormats())){
						String[] pincodeFormatArray =  addressBookDto.getPincodeFormats().split(",");
						for (int i = 0;i< pincodeFormatArray.length;i++) {
							String individualPinFormats = pincodeFormatArray[i];
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
							Pattern completeRegEx = Pattern.compile(addRegEx.toString());
							Matcher completeRegExMatcher = completeRegEx.matcher(addressBookDto.getPincode());
							if((completeRegExMatcher).matches()){
								match = true;
								break;
							}else{
								match = false;
							}
						}
						if(!match){
							AddressBookDto addressBookDto2 = null;
							addressBookDto2 = new AddressBookDto();
							addressBookDto2.setRowNumber(addressBookDto.getRowNumber());
							addressBookDto2.setColumnName(Constants.PINCODE_FORMAT);
							addressBookDto2.setAreaCode(addressBookDto.getAreaCode());
							addressBookDto2.setCustomerCode(addressBookDto.getCustomerCode());
							addressBookDto2.setName(addressBookDto.getName());
							addressBookDto2.setContactPerson(addressBookDto.getContactPerson());
							addressBookDto2.setAddressLine1(addressBookDto.getAddressLine1());
							addressBookDto2.setAddressLine2(addressBookDto.getAddressLine2());
							addressBookDto2.setLandmark(addressBookDto.getLandmark());
							addressBookDto2.setPincode(addressBookDto.getPincode());
							addressBookDto2.setTelephoneNumber(addressBookDto.getTelephoneNumber());
							addressBookDto2.setMobileNumber(addressBookDto.getMobileNumber());
							addressBookDto2.setEmailId(addressBookDto.getEmailId());
							addressBookDto2.setOfficeClosureTime(addressBookDto.getOfficeClosureTime());
							addressBookDto2.setDefaultAddress(addressBookDto.getDefaultAddress());
							addressBookDto2.setCountryCode(addressBookDto.getCountryCode());
							addressBookDto2.setCityCode(addressBookDto.getCityCode());
							addressBookDto2.setImportRemarks(Constants.PINCODE_FORMAT);
							addressBookDtos.add(addressBookDto2);
						}else{
							addressBookImportDetailDto1.setRowNumber(addressBookDto.getRowNumber());
							addressBookImportDetailDto1.setColumnName(addressBookDto.getColumnName());
							addressBookImportDetailDto1.setAreaCode(addressBookDto.getAreaCode());
							addressBookImportDetailDto1.setCustomerCode(addressBookDto.getCustomerCode());
							addressBookImportDetailDto1.setName(addressBookDto.getName()); 
							addressBookImportDetailDto1.setContactPerson(addressBookDto.getContactPerson());
							addressBookImportDetailDto1.setAddressLine1(addressBookDto.getAddressLine1());
							addressBookImportDetailDto1.setAddressLine2(addressBookDto.getAddressLine2());
							addressBookImportDetailDto1.setLandmark(addressBookDto.getLandmark());
							addressBookImportDetailDto1.setPincode(addressBookDto.getPincode());
							addressBookImportDetailDto1.setTelephoneNumber(addressBookDto.getTelephoneNumber());
							addressBookImportDetailDto1.setMobileNumber(addressBookDto.getMobileNumber());
							addressBookImportDetailDto1.setEmailId(addressBookDto.getEmailId());
							addressBookImportDetailDto1.setOfficeClosureTime(addressBookDto.getOfficeClosureTime());
							addressBookImportDetailDto1.setDefaultAddress(addressBookDto.getDefaultAddress());
							addressBookImportDetailDto1.setCountryCode(addressBookDto.getCountry());
							addressBookImportDetailDto1.setCityCode(addressBookDto.getCity());
							addressBookImportDetailDto1.setImportRemarks(addressBookDto.getImportRemarks());
							addressBookImportDetailDto1.setSql_type(environment.getProperty(Constants.IMPORT_ADDRESS_OBJ));
							//System.out.println("INTERNATIONAL::"+addressBookImportDetailDto1.toString());
							addressBookImportDetailDtos.add(addressBookImportDetailDto1);
						}
					}else if("0".equalsIgnoreCase(addressBookDto.getPincodeFormats())){
						addressBookImportDetailDto1.setRowNumber(addressBookDto.getRowNumber());
						addressBookImportDetailDto1.setColumnName(addressBookDto.getColumnName());
						addressBookImportDetailDto1.setAreaCode(addressBookDto.getAreaCode());
						addressBookImportDetailDto1.setCustomerCode(addressBookDto.getCustomerCode());
						addressBookImportDetailDto1.setName(addressBookDto.getName());
						addressBookImportDetailDto1.setContactPerson(addressBookDto.getContactPerson());
						addressBookImportDetailDto1.setAddressLine1(addressBookDto.getAddressLine1());
						addressBookImportDetailDto1.setAddressLine2(addressBookDto.getAddressLine2());
						addressBookImportDetailDto1.setLandmark(addressBookDto.getLandmark());
						addressBookImportDetailDto1.setPincode(addressBookDto.getPincode());
						addressBookImportDetailDto1.setTelephoneNumber(addressBookDto.getTelephoneNumber());
						addressBookImportDetailDto1.setMobileNumber(addressBookDto.getMobileNumber());
						addressBookImportDetailDto1.setEmailId(addressBookDto.getEmailId());
						addressBookImportDetailDto1.setOfficeClosureTime(addressBookDto.getOfficeClosureTime());
						addressBookImportDetailDto1.setDefaultAddress(addressBookDto.getDefaultAddress());
						addressBookImportDetailDto1.setCountryCode(addressBookDto.getCountry());
						addressBookImportDetailDto1.setCityCode(addressBookDto.getCity());
						addressBookImportDetailDto1.setImportRemarks(addressBookDto.getImportRemarks());
						addressBookImportDetailDto1.setSql_type(environment.getProperty(Constants.IMPORT_ADDRESS_OBJ));
						//System.out.println("INTERNATIONAL::"+addressBookImportDetailDto1.toString());
						addressBookImportDetailDtos.add(addressBookImportDetailDto1);
					}
				}else{
					addressBookImportDetailDto1.setRowNumber(addressBookDto.getRowNumber());
					addressBookImportDetailDto1.setColumnName(addressBookDto.getColumnName());
					addressBookImportDetailDto1.setAreaCode(addressBookDto.getAreaCode());
					addressBookImportDetailDto1.setCustomerCode(addressBookDto.getCustomerCode());
					addressBookImportDetailDto1.setName(addressBookDto.getName());
					addressBookImportDetailDto1.setContactPerson(addressBookDto.getContactPerson());
					addressBookImportDetailDto1.setAddressLine1(addressBookDto.getAddressLine1());
					addressBookImportDetailDto1.setAddressLine2(addressBookDto.getAddressLine2());
					addressBookImportDetailDto1.setLandmark(addressBookDto.getLandmark());
					addressBookImportDetailDto1.setPincode(addressBookDto.getPincode());
					addressBookImportDetailDto1.setTelephoneNumber(addressBookDto.getTelephoneNumber());
					addressBookImportDetailDto1.setMobileNumber(addressBookDto.getMobileNumber());
					addressBookImportDetailDto1.setEmailId(addressBookDto.getEmailId());
					addressBookImportDetailDto1.setOfficeClosureTime(addressBookDto.getOfficeClosureTime());
					addressBookImportDetailDto1.setDefaultAddress(addressBookDto.getDefaultAddress());
					addressBookImportDetailDto1.setCountryCode(addressBookDto.getCountry());
					addressBookImportDetailDto1.setCityCode(addressBookDto.getCity());
					addressBookImportDetailDto1.setImportRemarks(addressBookDto.getImportRemarks());
					addressBookImportDetailDto1.setSql_type(environment.getProperty(Constants.IMPORT_ADDRESS_OBJ));
					//System.out.println("INDIAN::"+addressBookImportDetailDto1.toString());
					addressBookImportDetailDtos.add(addressBookImportDetailDto1);
				}
			}
			if(!addressBookDtos.isEmpty()){
				importAddrDto.setImportFailedAddressList(addressBookDtos);
			}
			/*for (AddressBookDto addressBookDto2 : importAddrDto.getImportFailedAddressList()) {
				System.out.println("NOT MATCHING    "+addressBookDto2.toString());
			}*/
		}
		AddressBookDto addressBookDto = null;
		List<AddressBookImportDetailDto> addressList = null;
		AddressBookImportDetailDto[] addressBookImportDetailDtosArray = addressBookImportDetailDtos.toArray(new AddressBookImportDetailDto[addressBookImportDetailDtos.size()]);
		try {
			addressList = getSession().doReturningWork(new ReturningWork<List<AddressBookImportDetailDto>>() {
				@Override
				public List<AddressBookImportDetailDto> execute(Connection connection) throws SQLException {
					List list = null;
					List<AddressBookImportDetailDto> importAddressList = null;
					CallableStatement callableStatement = null;

					try {
						ArrayDescriptor des = ArrayDescriptor.createDescriptor(environment.getProperty(Constants.IMPORTADDRESS_LIST),connection);
						ARRAY addressArrayToPass = null;
						try {
							addressArrayToPass = new ARRAY(des, connection, addressBookImportDetailDtosArray);
							Map<String, Class<?>> localMap = connection.getTypeMap();
							localMap.put(environment.getProperty(Constants.IMPORT_ADDRESS_OBJ),Class.forName(Constants.ADDRESSBOOK_IMPORT_DTO));

							connection.setTypeMap(localMap);

						} catch (Exception e) {
							
							addressBookLogger.error("EXCEPTION TYPE :",e);
							
							
							addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
							throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
						}

						callableStatement = connection.prepareCall(Constants.IMPORT_ADDRESS_PROC);
						callableStatement.clearParameters();						

						((OracleCallableStatement) callableStatement).setArray(1, addressArrayToPass);
						((OracleCallableStatement) callableStatement).setString(2, importDto.getLoginId());
						((OracleCallableStatement) callableStatement).setString(3, importDto.getAddressType());
						((OracleCallableStatement) callableStatement).registerOutParameter(4, java.sql.Types.ARRAY, environment.getProperty(Constants.IMPORTADDRESS_LIST));
						((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.INTEGER);

						((OracleCallableStatement) callableStatement).execute();

						ARRAY addrList = ((OracleCallableStatement) callableStatement).getARRAY(4);
						if (addrList != null && addrList.length() != 0) {
							list = Arrays.asList((Object[]) addrList.getArray());
							importAddressList = new ArrayList<>(list);
						} 
					}catch(DataBaseException exception)	{
						
						addressBookLogger.error("EXCEPTION TYPE :",exception);
						
						
						addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
					finally {
						addressBookLogger.debug("-------------------------import address finally-------------------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return importAddressList;
				}
			});

			if(addressList!=null){
				addressBookDto = new AddressBookDto();
				addressBookDto.setAddressBookImportDetailDtoList(addressList);
				AddressBookDto addrBookDto = null;
				for (AddressBookImportDetailDto addressDto : addressBookDto.getAddressBookImportDetailDtoList()) {
					addrBookDto = new AddressBookDto();
					addrBookDto.setRowNumber(addressDto.getRowNumber());
					addrBookDto.setColumnName(addressDto.getColumnName());
					addrBookDto.setAreaCode(addressDto.getAreaCode());
					addrBookDto.setCustomerCode(addressDto.getCustomerCode());
					addrBookDto.setName(addressDto.getName());
					addrBookDto.setContactPerson(addressDto.getContactPerson());
					addrBookDto.setAddressLine1(addressDto.getAddressLine1());
					addrBookDto.setAddressLine2(addressDto.getAddressLine2()); 
					addrBookDto.setLandmark(addressDto.getLandmark());
					addrBookDto.setPincode(addressDto.getPincode());
					addrBookDto.setTelephoneNumber(addressDto.getTelephoneNumber());
					addrBookDto.setMobileNumber(addressDto.getMobileNumber());
					addrBookDto.setEmailId(addressDto.getEmailId());
					addrBookDto.setOfficeClosureTime(addressDto.getOfficeClosureTime());
					addrBookDto.setDefaultAddress(addressDto.getDefaultAddress());
					addrBookDto.setCountryCode(addressDto.getCountryCode());
					addrBookDto.setCityCode(addressDto.getCityCode());
					addrBookDto.setImportRemarks(addressDto.getImportRemarks());
					//	addrBookDto.setGstIn(addrBookDto.getGstIn());
					//System.out.println("RETURNED::  "+addrBookDto.toString());
					addressBookDtos.add(addrBookDto);
				}
				if(!addressBookDtos.isEmpty()){
					importAddrDto.setImportFailedAddressList(addressBookDtos);
				}
			}
		} catch(Exception e){
			addressBookLogger.error("EXCEPTION TYPE :",e);
			
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return importAddrDto;
	}

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#exportAddresses(java.lang.String, java.lang.String)
	 */
	/*	@Transactional
	@Override
	public AddressBookDto exportAddresses(String loginId, String addressType) {
		addressBookLogger.debug("AddressBookDaoImpl:exportAddresses");
		AddressBookDto addressBookDto = null;
		AddressAreaDto addressAreaDto = null;
		CountryDto countryDto = null;
		CityDto cityDto = null;
		List<AddressBookDto> addressBookDtosList = new ArrayList<>();
		try {
			Query query = getSession()
					.createQuery("from AddressBookMaster addr where addr.loginId = :loginId and addressType = :addressType").setParameter("loginId", loginId).setParameter("addressType", addressType);
			List<AddressBookMaster> addrList = query.list();
			AddressBookDto addrDto;
			if (addrList != null && !addrList.isEmpty()) {
				for (AddressBookMaster addressBookMaster : addrList) {
					addrDto = new AddressBookDto();
					CopyUtils.copy(addressBookMaster, addrDto);
					if(Constants.SHIPPER.equalsIgnoreCase(addressType)){
						addressAreaDto = new AddressAreaDto();
						addressAreaDto = getDetailsFromPincode(addressBookMaster.getPincode());
						addrDto.setCity(addressAreaDto.getCity());
						addrDto.setState(addressAreaDto.getState());
						addrDto.setCountry(addressAreaDto.getCountry());
					}
					else 
					if(Constants.CONSIGNEE.equalsIgnoreCase(addressType) && !Constants.COUNTRYCODE_IN.equalsIgnoreCase(addrDto.getCountryCode())){
						countryDto = new CountryDto();
						countryDto = getCountries();
						for (CountryDto cntryDto : countryDto.getCountryList()) {
							if(addressBookMaster.getCountryCode().equalsIgnoreCase(cntryDto.getCountryCode())){
								addrDto.setCountry(cntryDto.getCountryName());
								cityDto = new CityDto();
								cityDto = getCities(addrDto.getCountryCode());
								for (CityDto cityDtoList : cityDto.getCityList()) {
									if(addressBookMaster.getCityCode().equalsIgnoreCase(cityDtoList.getCityCode())){
										addrDto.setCity(cityDtoList.getCityName());
									}
								}
							}
						}
					}else if(Constants.CONSIGNEE.equalsIgnoreCase(addressType) && Constants.COUNTRYCODE_IN.equalsIgnoreCase(addrDto.getCountryCode())){
						addressAreaDto = new AddressAreaDto();
						addressAreaDto = getDetailsFromPincode(addressBookMaster.getPincode());
						addrDto.setCity(addressAreaDto.getCity());
						addrDto.setState(addressAreaDto.getState());
						addrDto.setCountry(Constants.COUNTRY_INDIA);
					}
					addressBookDtosList.add(addrDto);
				}
				//System.out.println(addressBookDtosList.size());
				 addressBookDto = new AddressBookDto();
				addressBookDto.setAddressBookDtoList(addressBookDtosList);
			}
		} catch (Exception exception) {
			addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		for (AddressBookDto addressDto : addressBookDto.getAddressBookDtoList()) {
			//System.out.println(addressDto.getAddressLine1());
		}
		return addressBookDto;
	}*/

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#exportAddresses(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public AddressBookDto exportAddresses(String loginId, String addressType) {
		addressBookLogger.debug("AddressBookDaoImpl:getAddressList");
		String sql = Constants.SHIPPER.equalsIgnoreCase(addressType)?Constants.GET_SHIPPER_ADDRESS_PROC:Constants.GET_CONSIGNEE_ADDRESS_PROC;
		AddressBookDto addressBookDto = null;

		List<AddressBookDto> list = new ArrayList<>();
		try {
			addressBookDto = getSession().doReturningWork(new ReturningWork<AddressBookDto>() {

				CallableStatement callableStatement = null;
				ResultSet rs = null;

				@Override
				public AddressBookDto execute(Connection connection) throws SQLException {
					AddressAreaDto addressAreaDto = null;
					CountryDto countryDto = null;
					CityDto cityDto = null;
					AddressBookDto addressBookDto = new AddressBookDto();
					AddressBookDto addressBookDto1 = null;
					try {
						callableStatement = connection.prepareCall(sql);
						callableStatement.setString(1, loginId);
						callableStatement.setString(2, addressType);
						callableStatement.setString(3, null);
						callableStatement.setString(4, null);
						callableStatement.setString(5, null);
						callableStatement.setString(6, null);
						callableStatement.setString(7, null);
						callableStatement.setInt(8, 0);
						callableStatement.setInt(9, 1);
						callableStatement.registerOutParameter(10, OracleTypes.CURSOR); 
						callableStatement.registerOutParameter(11, OracleTypes.NUMBER);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(10);
						while (rs.next()) {
							addressBookDto1 = new AddressBookDto();
							addressBookDto1.setAddressId(rs.getLong("CCADDRID"));
							addressBookDto1.setLoginId(rs.getString("CLOGINID"));
							addressBookDto1.setAddressType(rs.getString("CADDRESSTYPE"));
							addressBookDto1.setAreaCode(rs.getString("AFF_AC"));
							addressBookDto1.setCustomerCode(rs.getString("AFF_CC"));
							addressBookDto1.setName(rs.getString("CCNEENAME"));
							
							if(rs.getString("CCNEEPIN") != null){
							addressBookDto1.setPincode(rs.getString("CCNEEPIN"));
							}else{
								addressBookDto1.setPincode("");
							}
							addressBookDto1.setAddressLine1(rs.getString("CCNEEADR1"));
							addressBookDto1.setAddressLine2(rs.getString("CCNEEADR2"));
							addressBookDto1.setLandmark(rs.getString("CCNEEADR3"));
							addressBookDto1.setContactPerson(rs.getString("CCONTACT"));
							addressBookDto1.setMobileNumber(rs.getString("CCNEEMOB"));
							addressBookDto1.setTelephoneNumber(rs.getString("CCNEETEL"));
							addressBookDto1.setEmailId(rs.getString("CCNEEEML"));
							addressBookDto1.setOfficeClosureTime(rs.getString("COFFICECLOSURETIME"));
							addressBookDto1.setDefaultAddress(rs.getString("CDEFAULTADDRESS"));
							if(Constants.SHIPPER.equalsIgnoreCase(addressType)){
								addressBookDto1.setGstIn(rs.getString("CGSTN_UIDCODE"));
								addressAreaDto = getDetailsFromPincode(rs.getString("CCNEEPIN"));
								addressBookDto1.setCity(addressAreaDto.getCity());
								addressBookDto1.setState(addressAreaDto.getState());
								addressBookDto1.setCountry(addressAreaDto.getCountry());
							}else if(Constants.CONSIGNEE.equalsIgnoreCase(addressType) && !Constants.COUNTRYCODE_IN.equalsIgnoreCase(rs.getString("CCNTRYCODE"))){
								countryDto = getCountries();
								for (CountryDto cntryDto : countryDto.getCountryList()) {
									if(rs.getString("CCNTRYCODE").equalsIgnoreCase(cntryDto.getCountryCode())){
										addressBookDto1.setCountry(cntryDto.getCountryName());
										cityDto = getCities(cntryDto.getCountryCode());
										for (CityDto cityDtoList : cityDto.getCityList()) {
											if(rs.getString("CCITYCODE") != null){
											if(rs.getString("CCITYCODE").equalsIgnoreCase(cityDtoList.getCityCode())){
												addressBookDto1.setCity(cityDtoList.getCityName());
											}
											}
										}
									}
								}
							}else if(Constants.CONSIGNEE.equalsIgnoreCase(addressType) && Constants.COUNTRYCODE_IN.equalsIgnoreCase(rs.getString("CCNTRYCODE"))){
								addressAreaDto = getDetailsFromPincode(rs.getString("CCNEEPIN"));
								addressBookDto1.setCity(addressAreaDto.getCity());
								addressBookDto1.setState(addressAreaDto.getState());
								addressBookDto1.setCountry(Constants.COUNTRY_INDIA);
							}
							list.add(addressBookDto1);
						}
						addressBookDto.setAddressBookDtoList(list);
					}catch(Exception e){
						addressBookLogger.error("EXCEPTION TYPE :",e);
						
					}
					finally {
						addressBookLogger.debug("-------------------------export address finally-------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closeCallableStatement(callableStatement);
					}
					return addressBookDto;
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 

		return addressBookDto;
	}


	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getSearchAddress(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public AddressBookListDto getSearchAddress(String loginId, String searchAddress, String addrType) {
		addressBookLogger.debug(" AddressBookDaoImpl : getSearchAddress");
		AddressBookListDto addressBookListDto = new AddressBookListDto();
		List<AddressBookListDto> listOfMatchedAddress = new ArrayList<>();
		String searchAddressTemp = "%"+searchAddress+"%";
		try {
			getSession().doWork(new Work() {
				@Override  
				public void execute(Connection connection) {
					CallableStatement callableStatement = null;
					ResultSet searchAddressSet = null;
					try {
						AddressBookListDto addressBookListDto;
						callableStatement = connection.prepareCall(Constants.SEARCH_ADDRESS_PROC);
						callableStatement.setString(1, loginId);
						callableStatement.setString(2, searchAddressTemp);
						callableStatement.setString(3, addrType);
						callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
						callableStatement.registerOutParameter(5, OracleTypes.NUMBER);
						callableStatement.execute();

						// Search Address
						searchAddressSet = (ResultSet) callableStatement.getObject(4);
						while (searchAddressSet.next()) {
							addressBookListDto = new AddressBookListDto();
							if (null != searchAddressSet.getString(1)){
								addressBookListDto.setAddressId(Long.valueOf(searchAddressSet.getString(1)));
							} else {
								addressBookListDto.setAddressId(Long.valueOf(0));
							}

							addressBookListDto.setCountryCode(searchAddressSet.getString(2));
							addressBookListDto.setCityCode(searchAddressSet.getString(3));
							addressBookListDto.setStateCode(searchAddressSet.getString(4));
							addressBookListDto.setMobileNumber(searchAddressSet.getString(5));
							addressBookListDto.setDefaultAddress(searchAddressSet.getString(6));
							addressBookListDto.setName(searchAddressSet.getString(7));
							addressBookListDto.setAddressLine1(searchAddressSet.getString(8));
							addressBookListDto.setAddressLine2(searchAddressSet.getString(9));
							addressBookListDto.setLandmark(searchAddressSet.getString(10));
							addressBookListDto.setEmailId(searchAddressSet.getString(11));
							addressBookListDto.setPincode(searchAddressSet.getString(12));
							addressBookListDto.setTelephoneNumber(searchAddressSet.getString(13));
							addressBookListDto.setContactPerson(searchAddressSet.getString(14));
							addressBookListDto.setAreaCode(searchAddressSet.getString(15));
							addressBookListDto.setCustomerCode(searchAddressSet.getString(16));
							addressBookListDto.setOfficeClosureTime(searchAddressSet.getString(17));
							addressBookListDto.setCountryName(searchAddressSet.getString(20));
							addressBookListDto.setCityName(searchAddressSet.getString(21));
							listOfMatchedAddress.add(addressBookListDto);
						}
						
						
					} catch (Exception e) {
						addressBookLogger.error("EXCEPTION TYPE :",e);
						
						addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						addressBookLogger.debug("-------------------------Search address finally-------------------");
						CloseConnections.closeResultSet(searchAddressSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			
			addressBookLogger.error("EXCEPTION TYPE :",exception);
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		addressBookListDto.setListOfMatchedAddress(listOfMatchedAddress);

		return addressBookListDto;

	}


	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getSearchAddress(com.bluedart.addressbook.dto.SearchDto)
	 */
	@Transactional
	@Override
	public AddressBookListDto getSearchAddress(SearchDto searchDto) {
		addressBookLogger.debug(" AddressBookDaoImpl : getSearchAddress");
		AddressBookListDto addressBookListMainDto = new AddressBookListDto();
		List<AddressBookListDto> listOfMatchedAddress = new ArrayList<>();
		try {
			getSession().doWork(new Work() {
				@Override  
				public void execute(Connection connection) {
					CallableStatement callableStatement = null;
					ResultSet searchAddressSet = null;
					try {
						CountryDto countryDto = null;
						CityDto cityDto = null;
						AddressBookListDto addressBookListDto;
						callableStatement = connection.prepareCall(Constants.ADVANCED_SEARCH);
						callableStatement.setString(1, searchDto.getLoginId());
						callableStatement.setString(2, searchDto.getAreaCode());
						callableStatement.setString(3, searchDto.getCustCode());
						callableStatement.setString(4, searchDto.getName());
						callableStatement.setString(5, searchDto.getAddress());
						callableStatement.setString(6, searchDto.getPincode());
						callableStatement.setString(7, searchDto.getAddressType());
						callableStatement.setInt(8, searchDto.getPageSize());
						callableStatement.setInt(9, searchDto.getPageNo());
						callableStatement.registerOutParameter(10, OracleTypes.CURSOR);
						callableStatement.registerOutParameter(11, OracleTypes.NUMBER);
						callableStatement.execute();

						long recordSize = ((OracleCallableStatement) callableStatement).getLong(11);

						// Search Address
						searchAddressSet = (ResultSet) callableStatement.getObject(10);
						while (searchAddressSet.next()) {
							addressBookListDto = new AddressBookListDto();
							if (null != searchAddressSet.getString(2)){
								addressBookListDto.setAddressId(Long.valueOf(searchAddressSet.getString(2)));
							} else {
								addressBookListDto.setAddressId(Long.valueOf(0));
							}

							addressBookListDto.setCountryCode(searchAddressSet.getString(3));
							addressBookListDto.setCityCode(searchAddressSet.getString(4));
							addressBookListDto.setStateCode(searchAddressSet.getString(5));
							addressBookListDto.setMobileNumber(searchAddressSet.getString(6));
							addressBookListDto.setDefaultAddress(searchAddressSet.getString(7));
							addressBookListDto.setName(searchAddressSet.getString(8));
							addressBookListDto.setAddressLine1(searchAddressSet.getString(9));
							addressBookListDto.setAddressLine2(searchAddressSet.getString(10));
							addressBookListDto.setLandmark(searchAddressSet.getString(11));
							addressBookListDto.setEmailId(searchAddressSet.getString(12));
							addressBookListDto.setPincode(searchAddressSet.getString(13));
							addressBookListDto.setTelephoneNumber(searchAddressSet.getString(14));
							addressBookListDto.setContactPerson(searchAddressSet.getString(15));
							addressBookListDto.setAreaCode(searchAddressSet.getString(16));
							addressBookListDto.setCustomerCode(searchAddressSet.getString(17));
							addressBookListDto.setOfficeClosureTime(searchAddressSet.getString(18));

							countryDto = AddressBookDaoImpl.this.getCountries();
							for (CountryDto cntryDto : countryDto.getCountryList()) {
								if (searchAddressSet.getString(3).equalsIgnoreCase(cntryDto.getCountryCode()))
								{
									addressBookListDto.setCountryName(cntryDto.getCountryName());
									
									addressBookListDto.setCityName(searchAddressSet.getString(21));
									
									//cityDto = AddressBookDaoImpl.this.getCities(cntryDto.getCountryCode());
									/*for (CityDto cityDtoList : cityDto.getCityList()) {
										if (searchAddressSet.getString(4).equalsIgnoreCase(cityDtoList.getCityCode())) {
											addressBookListDto.setCityName(cityDtoList.getCityName());
										}
									}*/
								}
							}

							listOfMatchedAddress.add(addressBookListDto);
						}

						String tempVal = String.valueOf(recordSize);
						addressBookListMainDto.setTotalRecords(Integer.valueOf(tempVal));
						

					} catch (Exception e) {
						
						addressBookLogger.error("EXCEPTION TYPE :",e);
						
						addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
								ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						addressBookLogger.debug("-------------------------getSearchAddress address finally-------------------");
						CloseConnections.closeResultSet(searchAddressSet);
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
			});
		} catch (Exception exception) {
			addressBookLogger.error("EXCEPTION TYPE :",exception);

			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		addressBookListMainDto.setListOfMatchedAddress(listOfMatchedAddress);

		return addressBookListMainDto;

	}



	/**
	 * @param resultSet
	 */
	/*private void releaseResult(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
			addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
	}*/

	@Transactional
	@Override
	public AddressBookDto getVendoCode(AddressBookDto addressBookDto)
	{
		addressBookLogger.debug("AddressBookDaoImpl : addAddress");
		AddressBookDto addrBookDTO=new AddressBookDto();
		try {
			getSession().doWork(new Work() {
				@Override  
				public void execute(Connection connection)throws SQLException  {
					PreparedStatement pst = null;
					ResultSet rs = null;
					
					try{
						String venderCode =null;
					
					String logIdQuery ="select max(ccneecode) from UPROFILE4.CNEEMST_T where caddresstype ='S' and aff_ac= ? and aff_cc= ? and ccneecode like 'W%'";
					pst = connection.prepareStatement(logIdQuery);
					pst.setString(1, addressBookDto.getAreaCode());
					pst.setString(2, addressBookDto.getCustomerCode());
					rs = pst.executeQuery();
					if(rs.next())
					{
						venderCode = rs.getString(1);
						if(venderCode==null || venderCode=="")
						{
							venderCode="noDeta";
							addrBookDTO.setVendorCode(venderCode);
						}
						else
						{

							addrBookDTO.setVendorCode(venderCode);
						}
					} 
					}catch(Exception exception){
						addressBookLogger.error("EXCEPTION TYPE :",exception);
	
					}
					finally{
						addressBookLogger.debug("------------------getVendoCode finally-------------------------");
						CloseConnections.closeResultSet(rs);
						CloseConnections.closePreparedStatement(pst);
					}
				}
			});
		} catch(Exception e){
			addressBookLogger.error("EXCEPTION TYPE :",e);

			
			//e.printStackTrace();
			addressBookLogger.error(Constants.ERROR_OCCURED+ e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		}

		return addrBookDTO;	
	}


	

	/* (non-Javadoc)
	 * @see com.bluedart.addressbook.dao.AddressBookDao#getStates(java.lang.String)
	 */
	@Transactional
	@Override
	public StateDto getStates(String countryCode) {
		addressBookLogger.debug("AddressBookDaoImpl:getStates");
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
			addressBookLogger.error("EXCEPTION TYPE :",exception);

			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	}
	
	@Transactional
	@Override
	public CountryDto getCountry(String countryName) {
		addressBookLogger.debug("AddressBookDaoImpl:getCountries");
		CountryDto countryDto = new CountryDto();
		List<CountryDto> countryList = getCountryList(countryName);
		countryDto.setCountryList(countryList);
		return countryDto;
	}

	/**
	 * @return
	 */
	private List<CountryDto> getCountryList(String countryName){

		try{
			CountryDto countryDto;
			List<CountryDto>  countryMstDtoList = new ArrayList<>();
			Criteria criteria = getSession().createCriteria(CountryMst.class);
			criteria.add(Restrictions.eq("countryName", countryName.toUpperCase()));
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
			addressBookLogger.error("EXCEPTION TYPE :",exception);

			
			
			addressBookLogger.error(Constants.ERROR_OCCURED+ exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DB_ERROR.getCode(), ErrorMessageStatusCode.DB_ERROR.getDescription());
		} 
	} 
	
	@Transactional
	@Override
	public CityDto getCitiesWithFilter(String countryCode ,String cityValue) {
		addressBookLogger.debug("AddressBookDaoImpl:getCities");
		CityDto cityDto = new CityDto();
		List<CityDto> cityList =getSubCityList(countryCode ,cityValue);
		cityDto.setCityList(cityList);
		return cityDto;
	}

}