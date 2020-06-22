package com.bluedart.internetdart.daoImpl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.AreaDTO;
import com.bluedart.common.entity.CustomerMst;
import com.bluedart.common.service.MISLogService;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.DataBaseException;
import com.bluedart.internetdart.dao.InternetDartDao;
import com.bluedart.internetdart.dto.PinDescDto;
import com.bluedart.internetdart.dto.SearchDto;
import com.bluedart.internetdart.dto.StreamDataDto;
import com.bluedart.internetdart.dto.StreamReportDto;
import com.bluedart.internetdart.dto.ViewOnlineDto;
import com.bluedart.locationfinder.dao.ServiceStationDao;
import com.bluedart.masters.dto.AffiliatesDto;
import com.bluedart.masters.dto.CountryMstDto;
import com.bluedart.masters.service.AffiliatesService;
import com.bluedart.masters.service.CountryMstService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.Converter;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.ErrorMessageStatusCode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 * 
 * @author DH839598
 *
 */
@Repository
@PropertySource("classpath:procedure.properties")
public class InternetDartDaoImpl extends BaseDaoImpl implements InternetDartDao {

	private static final Logger internetDartlogger = Logger.getLogger(InternetDartDaoImpl.class);

	@Autowired
	private ServiceStationDao serviceStationDao;

	@Autowired
	private CountryMstService countryMstService;

	@Autowired
	private TrackTraceDBManager dbManager;

	@Autowired
	private AffiliatesService affiliatesService;

	@Autowired
	private MISLogService mISLogService;

	@Autowired
	private Environment environment;

	private boolean trackByLoginId = false;
	private boolean doQuery = false;
	private String custAC = null;
	private String custCC = null;
	private String dArea = null;
	private String orgAreaCode = null;
	private String dstAreaCode = null;
	private java.sql.Date fromDate = null;
	private java.sql.Date toDate = null;
	private Integer pageNo = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluedart.internetdart.dao.InternetDartDao#getStreamDataDto(com.
	 * bluedart.internetdart.dto.SearchDto)
	 */
	@Transactional
	@Override
	public StreamDataDto getStreamDataDto(SearchDto searchDto) {
		internetDartlogger.debug("InternetDartDaoImpl : getStreamDataDto");
		StreamDataDto streamDataDto = null;
		try{
			if (null != searchDto) {
				streamDataDto = new StreamDataDto();
				getValue(searchDto);
				if (doQuery && null != searchDto.getDownloadFlag()) {
					if (Constants.INTERNET_DART_DATA.equalsIgnoreCase(searchDto.getDownloadFlag())
							|| Constants.INTERNET_DART_REPORT.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						doQuery = false;
					}

					if (Constants.INTERNETDART_DATA_VALIDATION.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						List<StreamDataDto> streamDataDtoList = downloadData(trackByLoginId, searchDto.getSecLevel(), searchDto.getLoginId(),
								custCC, custAC, fromDate, toDate, searchDto.getProdCode(), searchDto.getStatus(),
								orgAreaCode, dstAreaCode, searchDto.getSortBy(), searchDto.getSortOrder(), true);
						streamDataDto.setStreamDataList(streamDataDtoList);
					}

					if (isDownloadScheduledNow()
							&& Constants.INTERNET_DART_DATA.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						List<StreamDataDto> streamDataDtoList = downloadData(trackByLoginId, searchDto.getSecLevel(), searchDto.getLoginId(),
								custCC, custAC, fromDate, toDate, searchDto.getProdCode(), searchDto.getStatus(),
								orgAreaCode, dstAreaCode, searchDto.getSortBy(), searchDto.getSortOrder(), false);
						streamDataDto.setStreamDataList(streamDataDtoList);
					}
				}
			}
		} finally {
			makeNullable();
		}
		
		return streamDataDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.internetdart.dao.InternetDartDao#getStreamReportDto(com.
	 * bluedart.internetdart.dto.SearchDto)
	 */
	@Transactional
	@Override
	public StreamReportDto getStreamReportDto(SearchDto searchDto) {
		internetDartlogger.debug("InternetDartDaoImpl : getStreamReportDto");
		StreamReportDto streamReportDto = null;

		try{
			if (null != searchDto) {
				streamReportDto = new StreamReportDto();
				getValue(searchDto);

				if (doQuery && null != searchDto.getDownloadFlag()) {
					if (Constants.INTERNET_DART_DATA.equalsIgnoreCase(searchDto.getDownloadFlag())
							|| Constants.INTERNET_DART_REPORT.equalsIgnoreCase(searchDto.getDownloadFlag()) || Constants.INTERNET_DART_EXCEL.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						doQuery = false;
					}

					if (Constants.INTERNETDART_REPORT_VALIDATION.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						List<StreamReportDto> streamReportDtoList = downloadReport(trackByLoginId, searchDto.getSecLevel(),
								searchDto.getLoginId(), custCC, custAC, fromDate, toDate, searchDto.getProdCode(),
								searchDto.getStatus(), orgAreaCode, dstAreaCode, searchDto.getSortBy(),
								searchDto.getSortOrder(), true);
						streamReportDto.setStreamReportDtoList(streamReportDtoList);
					}

					if (isDownloadScheduledNow()
							&& Constants.INTERNET_DART_REPORT.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						List<StreamReportDto> streamReportDtoList = downloadReport(trackByLoginId, searchDto.getSecLevel(),
								searchDto.getLoginId(), custCC, custAC, fromDate, toDate, searchDto.getProdCode(),
								searchDto.getStatus(), orgAreaCode, dstAreaCode, searchDto.getSortBy(),
								searchDto.getSortOrder(), false);
						streamReportDto.setStreamReportDtoList(streamReportDtoList);
					}
					if (isDownloadScheduledNow()
							&& Constants.INTERNET_DART_EXCEL.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						List<StreamReportDto> streamReportDtoList = downloadReport(trackByLoginId, searchDto.getSecLevel(),
								searchDto.getLoginId(), custCC, custAC, fromDate, toDate, searchDto.getProdCode(),
								searchDto.getStatus(), orgAreaCode, dstAreaCode, searchDto.getSortBy(),
								searchDto.getSortOrder(), false);
						streamReportDto.setStreamReportDtoList(streamReportDtoList);
					}
				}
			}
		} finally {
			makeNullable();
		}

		return streamReportDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.internetdart.dao.InternetDartDao#viewOnline(com.bluedart.
	 * internetdart.dto.SearchDto)
	 */
	@Transactional
	@Override
	public ViewOnlineDto viewOnline(SearchDto searchDto) {
		internetDartlogger.debug("InternetDartDaoImpl : viewOnline");
		ViewOnlineDto viewOnlineDto = null;
		try{
			if (null != searchDto) {
				getValue(searchDto);

				if (doQuery && null != searchDto.getDownloadFlag()) {
					if (Constants.INTERNETDART_DOWNLOAD.equalsIgnoreCase(searchDto.getDownloadFlag())
							|| "report".equalsIgnoreCase(searchDto.getDownloadFlag())) {
						doQuery = false;
					}

					if (doQuery && null != searchDto.getDownloadFlag()
							&& Constants.INTERNETDART_ONLINE.equalsIgnoreCase(searchDto.getDownloadFlag())) {
						if (trackByLoginId) {
							if (searchDto.getLoginId() != null && searchDto.getLoginId().trim().length() > 0) {
								try {
									searchDto.setOrigin(orgAreaCode);
									searchDto.setDest(dstAreaCode);
									searchDto.setPageNo(pageNo);
									viewOnlineDto = dbManager.trackByLoginID(fromDate, toDate, searchDto);
									mISLogService.saveMIS(Constants.INTERNET_DART_VIEW_ONLINE, searchDto.getLoginId());
									if (viewOnlineDto.isLimitExceeded()) {
										checkFlag(searchDto.getLoginId(), "1");
									}

								} catch (Exception exception) {
									internetDartlogger.error("EXCEPTION TYPE :",exception);
									
									internetDartlogger.error(exception.getMessage());
									throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
											ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
								}
							}
						} else {
							if ((null != custCC) && (custCC.trim().length() > 0) && (null != custAC)
									&& (custAC.trim().length() > 0)) {
								try {
									searchDto.setOrigin(orgAreaCode);
									searchDto.setDest(dstAreaCode);
									searchDto.setPageNo(pageNo);
									viewOnlineDto = dbManager.trackByCustCode(custCC, custAC, fromDate, toDate, searchDto);
									mISLogService.saveMIS(Constants.INTERNET_DART_VIEW_ONLINE, searchDto.getLoginId());
								} catch (Exception exception) {
									
									internetDartlogger.error("EXCEPTION TYPE :",exception);
									internetDartlogger.error(exception.getMessage());
									throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
											ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
								}

							}
						}
					}
				}
			}
		} finally {
			makeNullable();
		}
		return viewOnlineDto;
	}

	/**
	 * 
	 * @param searchDto
	 */
	private void getValue(SearchDto searchDto) {
		internetDartlogger.debug("InternetDartDaoImpl : getValue");

		
		dstAreaCode = searchDto.getDestinationCountry();
		
		List<PinDescDto> orgDetailList = new ArrayList<>();
		List<PinDescDto> destDetailList = new ArrayList<>();
		Vector destDetails = new Vector();
		List<CountryMstDto> countryMstDtoList = new ArrayList<>();
		String errorString = "noErrors";
		Date dateFrom = null;
		Date dateTo = null;
		
		if (null != searchDto.getCustAff() && "ALL".equalsIgnoreCase(searchDto.getCustAff())) {
			doQuery = true;
			searchDto.setReqAffiliatesFlag(1);
			trackByLoginId = true;
		} else {
			StringTokenizer st = new StringTokenizer(searchDto.getCustAff(), "-");
			if (st.hasMoreTokens()) {
				custAC = st.nextToken();
				if (st.hasMoreTokens()) {
					custCC = st.nextToken();
				}
			}
			AffiliatesDto dto = affiliatesService.getAffiliates(searchDto.getLoginId());
			if (null != dto.getAffiliatesDtoList()) {
				for (AffiliatesDto affiliatesDto : dto.getAffiliatesDtoList()) {
					if (custAC.equalsIgnoreCase(affiliatesDto.getAc())
							&& custCC.equalsIgnoreCase(affiliatesDto.getCc())) {
						doQuery = true;
						break;
					}
				}
			}

		}

		fromDate = new java.sql.Date(DateUtil.getCurrentDate() - 86400000L);
		if (null != searchDto.getDateFrom()) {
			dateFrom = DateUtil.getDateFromStringGivenFormat(searchDto.getDateFrom(), "dd-MM-yyyy");
			if (null != dateFrom && dateFrom.after(DateUtil.getCurrentUtilDate())) {
				doQuery = false;
				// To test we loaded 90 days record from Tables - this must be
				// changed to 45 days ! should be remove
			} else if (null != dateFrom && dateFrom.before(DateUtil.getBack90Days())) {
				doQuery = false;
			} else {
				fromDate = new java.sql.Date(dateFrom.getTime());
			}
		} else {
			doQuery = false;
		}

		toDate = new java.sql.Date(DateUtil.getCurrentDate() - 86400000L);
		if (null != searchDto.getDateTo()) {
			dateTo = DateUtil.getDateFromStringGivenFormat(searchDto.getDateTo(), "dd-MM-yyyy");
			if (null != dateTo && dateTo.after(DateUtil.getCurrentUtilDate())) {
				doQuery = false;
			} else {
				toDate = new java.sql.Date(dateTo.getTime());
			}
		} else {
			doQuery = false;
		}

		
		//Added for performance testing
		
		/*fromDate = new java.sql.Date(DateUtil.getCurrentDate() - 86400000L);
				if (null != searchDto.getDateFrom()) {
					dateFrom = DateUtil.getDateFromStringGivenFormat(searchDto.getDateFrom(), "dd-MM-yyyy");
					if (null != dateFrom && dateFrom.after(DateUtil.getCurrentUtilDate())) {
					//if (null != dateFrom && dateFrom.after(DateUtil.getCurrentUtilDate())) {
						doQuery = false;
						// To test we loaded 90 days record from Tables - this must be
						// changed to 45 days ! should be remove
					} else if (null != dateFrom) {
					//} else if (null != dateFrom && dateFrom.before(DateUtil.getBack90Days())) {
						doQuery = true;
					//} else {
						fromDate = new java.sql.Date(dateFrom.getTime());
					}else{
						doQuery = false;
					}
				} else {
					doQuery = false;
				}

				//toDate = new java.sql.Date(DateUtil.getCurrentDate() - 86400000L);
				if (null != searchDto.getDateTo()) {
					dateTo = DateUtil.getDateFromStringGivenFormat(searchDto.getDateTo(), "dd-MM-yyyy");
					if (null != dateTo) {
						doQuery = true;
					//} else {
						toDate = new java.sql.Date(dateTo.getTime());
					}else{
						doQuery = false;
					}
				} else {
					doQuery = false;
				}
		*/
		//------

		String string = new String();
		if ((null != searchDto.getOrigin().trim() || null != searchDto.getDest().trim())
				&& (searchDto.getOrigin().length() > 0 || searchDto.getDest().length() > 0)) {
			if (null == searchDto.getOrigin()) {
				searchDto.setOrigin(string);
			}
			if (null == searchDto.getDest()) {
				searchDto.setDest(string);
			}

			AreaDTO areaDTO = serviceStationDao.getAreaCodes(searchDto.getOrigin());
			String oarea = null;
			if (null != areaDTO) {
				if (null != areaDTO.getCarea() && null != areaDTO.getCscrcd()) {
					oarea = areaDTO.getCarea();
				} else {
					errorString = Constants.INTERNETDART_FALSEORG;
					orgDetailList = getServiceability(searchDto.getOrigin());
				}
			}
			if ("I".equalsIgnoreCase(searchDto.getProdCode())) { // International
				
				if(!"".equalsIgnoreCase(searchDto.getDestinationCountry())){
					dArea = searchDto.getDestinationCountry();
				} else {
					if (Constants.INTERNETDART_FALSEORG.equalsIgnoreCase(errorString)) {
						errorString = Constants.INTERNETDART_FALSEBOTH;
					} else {
						errorString = Constants.INTERNETDART_FALSEDEST;
					}
					countryMstDtoList = countryMstService.getCountryList();
					destDetails.addAll(countryMstDtoList);
				}
			} else { // Domestic
				areaDTO = serviceStationDao.getAreaCodes(searchDto.getDest());
				if (null != areaDTO) {
					if (null != areaDTO.getCarea() && null != areaDTO.getCscrcd()) {
						dArea = areaDTO.getCarea();
					} else {
						if (Constants.INTERNETDART_FALSEORG.equalsIgnoreCase(errorString)) {
							errorString = Constants.INTERNETDART_FALSEBOTH;
						} else {
							errorString = Constants.INTERNETDART_FALSEDEST;
						}
						destDetailList = getServiceability(searchDto.getDest());
						destDetails.addAll(destDetailList);
					}
				}
			}
			if (trackByLoginId) {
				if (null != searchDto.getOrigin() && searchDto.getOrigin().trim().length() > 0) {
					if (Constants.INTERNETDART_FALSEBOTH.equalsIgnoreCase(errorString)
							|| Constants.INTERNETDART_FALSEORG.equalsIgnoreCase(errorString)) {
						if (null != orgDetailList) {
							doQuery = false;
						}
					} else {
						orgAreaCode = oarea;
					}
				}
				if (null != searchDto.getDest() && searchDto.getDest().trim().length() > 0 ) {
					if (Constants.INTERNETDART_FALSEBOTH.equalsIgnoreCase(errorString)
							|| Constants.INTERNETDART_FALSEDEST.equalsIgnoreCase(errorString)) {
						if (!destDetails.isEmpty() && null != destDetails) {
							doQuery = false;
						}
					} else {
						dstAreaCode = dArea;
					}
				}
			} else { // end trackByLoginId - true
				
				if (null != searchDto.getOrigin() && searchDto.getOrigin().trim().length() > 0) {
					if (Constants.INTERNETDART_FALSEBOTH.equalsIgnoreCase(errorString)
							|| Constants.INTERNETDART_FALSEORG.equalsIgnoreCase(errorString)) {
						if (null != orgDetailList) {
							doQuery = false;
						}
					} else {
						orgAreaCode = oarea;
					}
				}
				
				if (null != searchDto.getDest() && searchDto.getDest().trim().length() > 0 ) {
					if (Constants.INTERNETDART_FALSEBOTH.equalsIgnoreCase(errorString)
							|| Constants.INTERNETDART_FALSEDEST.equalsIgnoreCase(errorString)) {
						if (!destDetails.isEmpty() && null != destDetails) {
							doQuery = false;
						}
					} else {
						dstAreaCode = dArea;
					}
				}
			}
		}

		if (null == searchDto.getViewBy()) {
			searchDto.setViewBy("TPT");
		}

		try {
			if (searchDto.getPageSize() > 100 || searchDto.getPageSize() < 10) {
				searchDto.setPageSize(10);
			}
		} catch (NumberFormatException e) {
			searchDto.setPageSize(10);
			internetDartlogger.error("EXCEPTION TYPE :",e);
			
		}
		try {
			pageNo = searchDto.getPageNo();
		} catch (NumberFormatException e) {
			internetDartlogger.error("EXCEPTION TYPE :",e);
			
			internetDartlogger.error(e.getMessage());
			pageNo = 1;
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.internetdart.dao.InternetDartDao#getServiceability(java.lang
	 * .String)
	 */
	@Transactional
	@Override
	public List<PinDescDto> getServiceability(String cityName) {
		internetDartlogger.debug("InternetDartDaoImpl : getServiceability");
		try{
			return getSession().doReturningWork(new ReturningWork<List<PinDescDto>>() {
				@Override
				public List<PinDescDto> execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					ResultSet resultSet = null;
					try{
					callableStatement = connection.prepareCall("{call uprofile4.loc_finder_new.locinfo1(?,?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).setString(1, cityName.trim());
					((OracleCallableStatement) callableStatement).registerOutParameter(2, OracleTypes.CURSOR);
					callableStatement.execute();
					resultSet = (ResultSet) ((OracleCallableStatement) callableStatement).getObject(2);
					PinDescDto descDto;
					List<PinDescDto> pinDescDtoList = new ArrayList<>();
					while (resultSet.next()) {
						descDto = new PinDescDto();
						descDto.setPinCodeDesc(resultSet.getString("CPINDESC"));
						pinDescDtoList.add(descDto);
					}
					
					return pinDescDtoList;
				}catch(Exception exception){
					internetDartlogger.error("EXCEPTION TYPE :",exception);
					
					
					internetDartlogger.error("----------getServiceability---------"+exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());

				}finally{
					internetDartlogger.debug("----------getServiceability finally---------");
					CloseConnections.closeResultSet(resultSet);
					CloseConnections.closeCallableStatement(callableStatement);
				}
				}
			});
		}catch(Exception exception){
			
			internetDartlogger.error("EXCEPTION TYPE :",exception);
			
			
			internetDartlogger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
			
		}
		
	}

	/**
	 * 
	 * @return
	 */
	private boolean isDownloadScheduledNow() {
		internetDartlogger.debug("InternetDartDaoImpl : isDownloadScheduledNow");
		boolean retVal = false;
		GregorianCalendar currentTime = new GregorianCalendar();
		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		startTime.set(GregorianCalendar.SECOND, 0);
		startTime.set(GregorianCalendar.MILLISECOND, 0);
		endTime.set(GregorianCalendar.SECOND, 0);
		endTime.set(GregorianCalendar.MILLISECOND, 0);

		StringTokenizer startTokenizer = new StringTokenizer("00:00", ":");
		StringTokenizer endTokenizer = new StringTokenizer("00:00", ":");

		int startHr = -1;
		int startMin = -1;
		int endHr = -1;
		int endMin = -1;
		try {
			if (startTokenizer.hasMoreTokens()) {
				startHr = Integer.parseInt(startTokenizer.nextToken());
				if (startTokenizer.hasMoreTokens()) {
					startMin = Integer.parseInt(startTokenizer.nextToken());
				}
			}
			if (endTokenizer.hasMoreTokens()) {
				endHr = Integer.parseInt(endTokenizer.nextToken());
				if (endTokenizer.hasMoreTokens()) {
					endMin = Integer.parseInt(endTokenizer.nextToken());
				}
			}
			if ((startHr > -1) && (startMin > -1) && (endHr > -1) && (endMin > -1)) {
				startTime.set(GregorianCalendar.HOUR_OF_DAY, startHr);
				startTime.set(GregorianCalendar.MINUTE, startMin);
				endTime.set(GregorianCalendar.HOUR_OF_DAY, endHr);
				endTime.set(GregorianCalendar.MINUTE, endMin);

				if ((currentTime.after(startTime) && currentTime.before(endTime)) || startTime.equals(endTime)) {
					retVal = true;
				} else {
					retVal = false;
				}
			} else {
				retVal = false;
			}
		} catch(Exception exception) {
			
			internetDartlogger.error("EXCEPTION TYPE :",exception);
			
			
			internetDartlogger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return retVal;
	}

	/**
	 * 
	 * @param trackByLoginId
	 * @param secLevel
	 * @param loginid
	 * @param custCC
	 * @param custAC
	 * @param fromDate
	 * @param toDate
	 * @param prodCode
	 * @param status
	 * @param orgAreaCode
	 * @param dstAreaCode
	 * @param sortBy
	 * @param sortOrder
	 * @param isCount
	 * @return
	 */
	private List<StreamReportDto> downloadReport(boolean trackByLoginId, int secLevel, String loginid, String custCC,
			String custAC, java.sql.Date fromDate, java.sql.Date toDate, String prodCode, String status,
			String orgAreaCode, String dstAreaCode, String sortBy, String sortOrder, boolean isCount) {
		internetDartlogger.debug("InternetDartDaoImpl : downloadReport");
		List<StreamReportDto> streamReportDtoList = new ArrayList<>();
		ScrollableResults results = null;
		try{
		SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMdd");
		StringBuilder query = new StringBuilder();
		if (isCount) {
			query.append("select count(1)  from (");
		}
		query.append("SELECT ");
		query.append("RPAD(TO_CHAR(rownum), 5, ' ') AS RECNO, a.* ");
		query.append(" from (");
		query.append("SELECT  DISTINCT ");
		query.append("RPAD(NVL(S.CMODE, ' '), 1, ' ') AS CMODE, ");
		query.append("RPAD(TO_CHAR(S.NPCS), 4, ' ') AS NPCS, ");
		query.append("RPAD(TO_CHAR(S.NWEIGHT), 5, ' ') AS NWEIGHT, ");
		query.append("RPAD(NVL(S.CSTATCODE, ' '), 8, ' ') AS CSTATCODE, ");
		query.append("RPAD(NVL(S.cprodcode, ' '), 1, ' ') AS CPRODCODE, ");

		query.append("RPAD(NVL(S.cawbno, ' '), 12, ' ') AS AWBNO, ");
		query.append("RPAD(NVL(S.ccrcrdref, ' '), 20, ' ') AS REFNO, ");
		query.append("RPAD(NVL(TO_CHAR(S.dpudate, 'dd-Mon-yy'), ' '), 9, ' ') AS PUDATE, ");
		query.append(
				"RPAD(NVL(DECODE (S.cprodcode, 'X', CTO1.ccityname, 'V', CTO1.ccityname, AO1.careadesc), ' '), 25, ' ') AS ORGAREA, ");
		query.append(
				"SUBSTR(RPAD(NVL(DECODE (S.cprodcode, 'I', CTD1.ccityname, NVL(AD1.careadesc, AD2.careadesc)), ' '), 25, ' '),1,15) AS DSTAREA, ");
		query.append("RPAD(NVL(S.cattention, ' '), 20, ' ') AS CONSIGNEE, ");
		if (secLevel > 1) {
			query.append(
					"SUBSTR(RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc), ' '), 50, ' '),1,30) AS STATDESC, ");
		} else {
			query.append(
					"SUBSTR(RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc2), ' '), 50, ' '),1,30) AS STATDESC, ");
		}
		query.append("RPAD(NVL(STAT.cqrygrp, 'IT'), 2, ' ') AS STATGROUP, ");
		query.append("RPAD(NVL(TO_CHAR(S.dstatdate, 'dd-Mon-yy'), ' '), 9, ' ') AS STATDATE, ");
		query.append("RPAD(NVL(S.cstattime, ' '), 6, ' ') AS STATTIME, ");
		query.append(
				"SUBSTR(RPAD(NVL(DECODE(S.cstattype, 'T', DECODE(S.cstatcode, '000', S.crecdby, ' '), ' '), ' '), 30, ' '),1,20) AS RECDBY, ");
		query.append("SUBSTR(RPAD(NVL(S.crelation, ' '), 30, ' '),1,20) AS RELATION, ");
		query.append("RPAD(NVL(S.cidtype, ' '), 2, ' ') AS IDTYPE, ");
		query.append("RPAD(NVL(S.cidno, ' '), 20, ' ') AS IDNO, ");
		query.append("RPAD(NVL(S.corgarea, ' '), 3, ' ') AS ORGACODE, ");
		query.append("RPAD(NVL(S.ccustcode, ' '), 6, ' ') AS CUSTCODE ");

		query.append("FROM ");

		if (trackByLoginId) {
			query.append("affiliates_t AFF, ");
		}
		query.append("shipment S, ");
		query.append("statmst STAT, ");
		query.append("areamst AO1, ");
		query.append("citymst CTO1, ");
		query.append("areamst AD1, ");
		query.append("(select carea,careadesc from areamst group by carea,careadesc) AD2, citymst CTD1 ");
		
		if (trackByLoginId) {
			query.append(" WHERE AFF.loginid = '" + loginid + "' ");
			query.append(
					" AND  (( S.ccustcode = AFF.aff_cc  AND S.corgarea = AFF.aff_ac ) OR  (S.CBTPCODE = AFF.aff_cc  AND S.CBTPAREA = AFF.aff_ac )) ");
		} else {
			query.append(" where (( S.ccustcode = '" + custCC + "' AND S.corgarea = '" + custAC
					+ "') or ( S.cbtpcode = '" + custCC + "' AND S.cbtparea = '" + custAC + "' ))");
		}

		query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') >= '" + dfDownloads.format(fromDate) + "' ");
		query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') <= '" + dfDownloads.format(toDate) + "' ");

		if ((null != prodCode) && (prodCode.trim().length() > 0)) {
			query.append("AND S.cprodcode = '" + prodCode + "' ");
		}

		if (null != status) {
			if ("DL".equalsIgnoreCase(status)) {
				query.append(Constants.INTERNETDART_QUERY_1);
				query.append(Constants.INTERNETDART_QUERY_2);
				query.append("AND STAT.cqrygrp = 'DL' ");
			} else if ("RT".equalsIgnoreCase(status)) {
				query.append(Constants.INTERNETDART_QUERY_1);
				query.append(Constants.INTERNETDART_QUERY_2);
				query.append("AND STAT.cqrygrp = 'RT' ");
			} else if ("RD".equalsIgnoreCase(status)) {
				query.append(Constants.INTERNETDART_QUERY_1);
				query.append(Constants.INTERNETDART_QUERY_2);
				query.append("AND STAT.cqrygrp = 'RD' ");
			} else if ("UD".equalsIgnoreCase(status)) {
				query.append(Constants.INTERNETDART_UD_1);
				query.append(Constants.INTERNETDART_UD_2);
				query.append("AND (STAT.cqrygrp = 'UD' OR STAT.cqrygrp IS NULL)");
			} else {
				query.append(Constants.INTERNETDART_UD_1);
				query.append(Constants.INTERNETDART_UD_2);
			}
		} else {
			query.append(Constants.INTERNETDART_UD_1);
			query.append(Constants.INTERNETDART_UD_2);
		}

		if (trackByLoginId && (null != orgAreaCode) && (orgAreaCode.trim().length() > 0)) {
			query.append("AND nvl(S.corgarea,'***') = '" + orgAreaCode + "' ");
		} else if((null != orgAreaCode) && (orgAreaCode.trim().length() > 0)){
			query.append("AND nvl(S.corgarea,'***') = '" + orgAreaCode + "' ");
		}

		if ((null != dstAreaCode) && (dstAreaCode.trim().length() > 0)) {
			if ((null != prodCode) && ("I".equals(prodCode))) {
				query.append("AND S.cdstarea IN (SELECT DISTINCT CCITYCODE  FROM CITYMST WHERE CCNTRYCODE = '"
						+ dstAreaCode + "') ");
			} else {
				query.append("AND S.cdstarea = '" + dstAreaCode + "' ");
			}
		}

		query.append("AND AO1.cscrcd (+) = S.corgscrcd ");
		query.append("AND CTO1.ccitycode (+) = S.corgarea ");
		query.append("AND AD1.cscrcd (+) = S.cdstscrcd ");
		query.append("AND AD2.carea (+) = S.cdstarea ");
		query.append("AND CTD1.ccitycode (+) = S.cdstarea ");

		String sortString = Constants.INTERNETDART_SORT;

		if ((null != sortBy) && (sortBy.trim().length() > 0)) {
			if (Constants.INTERNETDART_PICKUPDATE.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_PUDATE;
			} else if (Constants.INTERNETDART_AWBNO.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_AWBNO;
			} else if (Constants.INTERNETDART_REFNO.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_REFNO;
			} else if (Constants.INTERNETDART_ORGAREA.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_ORGAREA;
			} else if (Constants.INTERNETDART_DSTAREA.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_DSTAREA;
			} else if (Constants.INTERNETDART_CONSIGNEE.equalsIgnoreCase(sortBy)) {
				sortString = Constants.INTERNETDART_CONSIGNEE;
			} else {
				sortString = Constants.INTERNETDART_PUDATE;
			}

			if ((null != sortOrder) && (sortOrder.trim().length() > 0)) {
				if ("A".equalsIgnoreCase(sortOrder)) {
					sortString = sortString.concat(Constants.INTERNETDART_QUERYASC);
				} else {
					sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
				}
			} else {
				sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
			}
		}

		query.append(" ORDER BY ORGACODE,CUSTCODE ");
		if ((null != sortBy) && (sortBy.trim().length() > 0)) {
			query.append(" ," + sortString);
		}
		query.append(") a");

		if (isCount) {
			query.append(")");
		}

		results = getSession().createSQLQuery(query.toString()).setReadOnly(true).setCacheable(true)
				.scroll(ScrollMode.FORWARD_ONLY);
		StreamReportDto streamReportDto = null;

		if (isCount) {
			streamReportDto = new StreamReportDto();
			BigDecimal count = new BigDecimal(0);
			while (results.next()) {
				count = (BigDecimal) results.get()[0];
			}
			streamReportDto.setTotalRecord(count.longValue());

			// More then Config record size
			String thresholdLimitStr = environment.getProperty("THRESHOLD_LIMIT");
			if (Integer.parseInt(thresholdLimitStr) > count.intValue()) {
				streamReportDto.setLimitExceeded(false);
			} else {
				streamReportDto.setLimitExceeded(true);
				checkFlag(loginid, "1");
			}
			streamReportDtoList.add(streamReportDto);

		} else {
			while (results.next()) {
				streamReportDto = new StreamReportDto();
				streamReportDto.setRecordNo(results.get()[0].toString());
				streamReportDto.setMode(results.get()[1].toString());
				streamReportDto.setNpcs(results.get()[2].toString());
				streamReportDto.setnWeight(results.get()[3].toString());
				streamReportDto.setStatCode(results.get()[4].toString());
				streamReportDto.setProductCode(results.get()[5].toString());
				streamReportDto.setAwbNo(results.get()[6].toString());
				streamReportDto.setRefNo(results.get()[7].toString());
				streamReportDto.setPuDate(results.get()[8].toString());
				streamReportDto.setOrgArea(results.get()[9].toString());
				streamReportDto.setDstArea(results.get()[10].toString());
				streamReportDto.setConsignee(results.get()[11].toString());
				streamReportDto.setStatDesc(results.get()[12].toString());
				streamReportDto.setStatGroup(results.get()[13].toString());
				streamReportDto.setStatDate(results.get()[14].toString());
				streamReportDto.setStatTime(results.get()[15].toString());
				streamReportDto.setRecBy(results.get()[16].toString());
				streamReportDto.setRelation(results.get()[17].toString());
				streamReportDto.setIdType(results.get()[18].toString());
				streamReportDto.setIdNo(results.get()[19].toString());
				streamReportDto.setOrgCode(results.get()[20].toString());
				streamReportDto.setCustCode(results.get()[21].toString());
				streamReportDtoList.add(streamReportDto);
			}
		}
		if (isCount) {
			mISLogService.saveMIS(Constants.INTERNET_DART_REPORT, loginid);
		}
		internetDartlogger.info(" CustomQuerySearchDBManager : downloadReport Size " + streamReportDtoList.size());
		
		
		}catch(Exception exception){
			internetDartlogger.error("EXCEPTION TYPE :",exception);
			
			internetDartlogger.error("----------downloadReport---------"+exception.getMessage());
		}finally{
			internetDartlogger.debug("----------downloadReport finally---------");
			CloseConnections.closeScrollableResults(results);
		}
		return streamReportDtoList;
	}

	
	private List<StreamDataDto> downloadData(boolean trackByLoginId, int secLevel, String loginid, String custCC,
			String custAC, java.sql.Date fromDate, java.sql.Date toDate, String prodCode, String status,
			String orgAreaCode, String dstAreaCode, String sortBy, String sortOrder, boolean isCount) {

		internetDartlogger.debug("InternetDartDaoImpl : downloadData");
		boolean retVal = false;
		StringBuilder query = new StringBuilder();
		List<StreamDataDto> streamDataDtoList = new ArrayList<>();
		if ("RD".equalsIgnoreCase(status)) {
			streamDataDtoList = allRedirectedShipments(trackByLoginId, secLevel, loginid, custCC, custAC, fromDate,
					toDate, prodCode, status, orgAreaCode, dstAreaCode, sortBy, sortOrder, retVal, isCount);
			StreamDataDto streamData;
			
			if (isCount) {
				streamData = new StreamDataDto();
				BigDecimal count = new BigDecimal(0);
				
				//streamData.setTotalRecord();
				if(null != streamDataDtoList){
					count = BigDecimal.valueOf(streamDataDtoList.size());
				}
				internetDartlogger.info("Number of count for RD status :"+count);
				streamData.setTotalRecord(count.longValue());
				// More then Config record size
				String thresholdLimitStr = environment.getProperty("THRESHOLD_LIMIT");
				if (Integer.parseInt(thresholdLimitStr) > count.intValue()) {
					streamData.setLimitExceeded(false);
				} else {
					streamData.setLimitExceeded(true);
					checkFlag(loginid, "1");
				}
				streamDataDtoList = new ArrayList<>();
				streamDataDtoList.add(streamData);
			}
			
		} else {
			if (isCount) {
				query.append("select count(1)  from (");
			}
			ScrollableResults results = null;
			try{
			query.append("SELECT  DISTINCT ");
			query.append("RPAD(NVL(S.cawbno, ' '), 12, ' ') AS AWBNO, ");
			query.append("RPAD(NVL(S.ccrcrdref, ' '), 20, ' ') AS REFNO, ");
			query.append("RPAD(NVL(TO_CHAR(S.dpudate, 'YYYYMMDD'), ' '), 8, ' ') AS PUDATE, ");
			query.append("RPAD(NVL(S.CpuTIME,' '), 4, ' ') AS PUTIME, ");
			query.append(
					"RPAD(NVL(DECODE (S.cprodcode, 'X', CTO1.ccityname, 'V', CTO1.ccityname, AO1.careadesc), ' '), 25, ' ') AS ORGAREA, ");
			query.append(
					"RPAD(NVL(DECODE (S.cprodcode, 'I', CTD1.ccityname, NVL(AD1.careadesc, AD2.careadesc)), ' '), 25, ' ') AS DSTAREA, ");
			query.append("RPAD(NVL(S.cattention, ' '), 20, ' ') AS CONSIGNEE, ");
			if (secLevel > 1) {
				query.append(
						"RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc), ' '), 50, ' ') AS STATDESC, ");
			} else {
				query.append(
						"RPAD(NVL(DECODE(STAT.cqrygrp, NULL, 'In Transit. Await delivery information.', STAT.cstatdesc2), ' '), 50, ' ') AS STATDESC, ");
			}
			query.append("RPAD(NVL(STAT.cqrygrp, 'IT'), 2, ' ') AS STATGROUP, ");
			query.append("RPAD(NVL(TO_CHAR(S.dstatdate, 'YYYYMMDD'), ' '), 8, ' ') AS STATDATE, ");
			query.append("RPAD(NVL(S.cstattime, ' '), 4, ' ') AS STATTIME, ");
			query.append(
					"RPAD(NVL(DECODE(S.cstattype, 'T', DECODE(S.cstatcode, '000', S.crecdby, ' '), ' '), ' '), 30, ' ') AS RECDBY, ");
			query.append("RPAD(NVL(S.crelation, ' '), 30, ' ') AS RELATION, ");
			query.append("RPAD(NVL(S.cidtype, ' '), 2, ' ') AS IDTYPE, ");
			query.append("RPAD(NVL(S.cidno, ' '), 20, ' ') AS IDNO, ");
			query.append("RPAD(NVL(S.corgarea, ' '), 3, ' ') AS ORGACODE, ");
			query.append("RPAD(NVL(S.ccustcode, ' '), 6, ' ') AS CUSTCODE, ");
			query.append("RPAD(TO_CHAR(S.NWEIGHT), 7, ' ') AS NWEIGHT, ");
			query.append("RPAD(TO_CHAR(S.NPCS), 4, ' ') AS NPCS, ");
			query.append("RPAD(NVL(TO_CHAR(S.DEPTDTDLV, 'dd-Mon-yy'), ' '), 9, ' ') AS DEPTDTDLV, ");
			if (secLevel >= 1) {
				query.append("SUBSTR(RPAD(NVL(S.CSPLINST, ' '), 25, ' '),1,25) AS CSPLINST , ");
			} else {
				query.append(" RPAD(' ',25)  AS CSPLINST , ");
			}
			query.append(" RPAD(NVL('', ' '), 12, ' ')  AS NEWAWBNO , ");
			query.append("RPAD(NVL(S.csender, ' '), 20, ' ') AS CSENDER ,");
			query.append(
					"RPAD(NVL( case when s.cstatcode in ('074','027') then uprofile4.PACKGET_CUSTCENTDET.get_custcent_rtostat3(S.cawbno, s.dstatdate, s.cstattime ,s.cstatcode    ) else ' ' end , ' '), 40, ' ') AS CRTOREASON , ");
			query.append("RPAD(NVL(s.cprodcode, ''), 1, ' ') AS cprodcode, ");
			query.append("RPAD(NVL(s.cprodtype, ''), 1, ' ') AS cprodtype  ");
			query.append(" FROM ");
			if (trackByLoginId) {
				query.append("affiliates_t AFF, ");
			}
			query.append("shipment S, ");
			query.append("statmst STAT, ");
			query.append("areamst AO1, ");
			query.append("citymst CTO1, ");
			query.append("areamst AD1, ");
			query.append("(select carea,careadesc from areamst group by carea,careadesc) AD2, citymst CTD1 ");
			if (trackByLoginId) {
				query.append("where AFF.loginid = '" + loginid + "' ");
				query.append(
						" AND  (( S.ccustcode = AFF.aff_cc  AND S.corgarea = AFF.aff_ac ) OR  (S.CBTPCODE = AFF.aff_cc  AND S.CBTPAREA = AFF.aff_ac )) ");
			} else {
				query.append(" where (( S.ccustcode = '" + custCC + "' AND S.corgarea = '" + custAC
						+ "') or ( S.cbtpcode = '" + custCC + "' AND S.cbtparea = '" + custAC + "' ))");
			}
			SimpleDateFormat dfDownloads = new SimpleDateFormat("yyyyMMdd");
			query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') >= '" + dfDownloads.format(fromDate) + "' ");
			query.append("AND TO_CHAR(S.dpudate, 'YYYYMMDD') <= '" + dfDownloads.format(toDate) + "' ");

			if ((null != prodCode) && (prodCode.trim().length() > 0)) {
				query.append("AND S.cprodcode = '" + prodCode + "' ");
			}
			if (null != status) {
				if ("DL".equalsIgnoreCase(status)) {
					query.append(Constants.INTERNETDART_QUERY_1);
					query.append(Constants.INTERNETDART_QUERY_2);
					query.append("AND STAT.cqrygrp = 'DL' ");
				} else if ("RT".equalsIgnoreCase(status)) {
					query.append(Constants.INTERNETDART_QUERY_1);
					query.append(Constants.INTERNETDART_QUERY_2);
					query.append("AND STAT.cqrygrp = 'RT' ");
				} else if ("RD".equalsIgnoreCase(status)) {
					query.append(Constants.INTERNETDART_QUERY_1);
					query.append(Constants.INTERNETDART_QUERY_2);
					query.append("AND STAT.cqrygrp = 'RD' ");
				} else if ("UD".equalsIgnoreCase(status)) {
					query.append(Constants.INTERNETDART_UD_1);
					query.append(Constants.INTERNETDART_UD_2);
					query.append("AND (STAT.cqrygrp = 'UD' OR STAT.cqrygrp IS NULL)");
				} else {
					query.append(Constants.INTERNETDART_UD_1);
					query.append(Constants.INTERNETDART_UD_2);
				}
			}

			if (trackByLoginId && (null != orgAreaCode) && (orgAreaCode.trim().length() > 0)) {
				query.append("AND nvl(S.corgarea,'***') = '" + orgAreaCode + "' ");
			} else if ((null != orgAreaCode) && (orgAreaCode.trim().length() > 0)) {
				query.append("AND nvl(S.corgarea,'***') = '" + orgAreaCode + "' ");
			}

			if ((null != dstAreaCode) && (dstAreaCode.trim().length() > 0)) {
				if ((null != prodCode) && (prodCode.equals("I"))) {
					query.append("AND S.cdstarea IN (SELECT DISTINCT CCITYCODE  FROM CITYMST WHERE CCNTRYCODE = '"
							+ dstAreaCode + "') ");
				} else {
					query.append("AND S.cdstarea = '" + dstAreaCode + "' ");
				}
			}

			query.append("AND AO1.cscrcd (+) = S.corgscrcd ");
			query.append("AND CTO1.ccitycode (+) = S.corgarea ");
			query.append("AND AD1.cscrcd (+) = S.cdstscrcd ");
			query.append("AND AD2.carea (+) = S.cdstarea ");
			query.append("AND CTD1.ccitycode (+) = S.cdstarea ");

			String sortString = Constants.INTERNETDART_SORT;
			if ((null != sortBy) && (sortBy.trim().length() > 0)) {
				if (Constants.INTERNETDART_PICKUPDATE.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_PUDATE;
				} else if (Constants.INTERNETDART_AWBNO.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_AWBNO;
				} else if (Constants.INTERNETDART_REFNO.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_REFNO;
				} else if (Constants.INTERNETDART_ORGAREA.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_ORGAREA;
				} else if (Constants.INTERNETDART_DSTAREA.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_DSTAREA;
				} else if (Constants.INTERNETDART_CONSIGNEE.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_CONSIGNEE;
				} else {
					sortString = Constants.INTERNETDART_PUDATE;
				}

				if ((null != sortOrder) && (sortOrder.trim().length() > 0)) {
					if ("A".equalsIgnoreCase(sortOrder)) {
						sortString = sortString.concat(Constants.INTERNETDART_QUERYASC);
					} else {
						sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
					}
				} else {
					sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
				}
			}

			query.append(" ORDER BY " + sortString);

			if (isCount) {
				query.append(")");
			}

			results = getSession().createSQLQuery(query.toString()).setReadOnly(true)
					.setCacheable(true).scroll(ScrollMode.FORWARD_ONLY);
			StreamDataDto streamData;

			if (isCount) {
				streamData = new StreamDataDto();
				BigDecimal count = new BigDecimal(0);
				while (results.next()) {
					count = (BigDecimal) results.get()[0];
				}
				streamData.setTotalRecord(count.longValue());
				// More then Config record size
				String thresholdLimitStr = environment.getProperty("THRESHOLD_LIMIT");
				if (Integer.parseInt(thresholdLimitStr) > count.intValue()) {
					streamData.setLimitExceeded(false);
				} else {
					streamData.setLimitExceeded(true);
					checkFlag(loginid, "1");
				}
				streamDataDtoList.add(streamData);
			} else {
				while (results.next()) {
					streamData = new StreamDataDto();
					streamData.setAwbNo(results.get()[0].toString());
					streamData.setRefNo(results.get()[1].toString());
					streamData.setPuDate(results.get()[2].toString());
					streamData.setPuTime(results.get()[3].toString());
					streamData.setOrgArea(results.get()[4].toString());
					streamData.setDstArea(results.get()[5].toString());
					streamData.setConsignee(results.get()[6].toString());
					streamData.setStatDesc(results.get()[7].toString());
					streamData.setStatGroup(results.get()[8].toString());
					streamData.setStatDate(results.get()[9].toString());
					streamData.setStatTime(results.get()[10].toString());
					streamData.setRecBy(results.get()[11].toString());
					streamData.setRelation(results.get()[12].toString());
					streamData.setIdType(results.get()[13].toString());
					streamData.setIdNo(results.get()[14].toString());
					streamData.setOrgCode(results.get()[15].toString());
					streamData.setCustCode(results.get()[16].toString());
					streamData.setnWeight(results.get()[17].toString());
					streamData.setNpcs(results.get()[18].toString());
					streamData.setExptDlv(results.get()[19].toString());
					streamData.setSplInst(results.get()[20].toString());
					streamData.setNewAwNo(results.get()[21].toString());
					streamData.setSender(results.get()[22].toString());
					streamData.setRtoReason(results.get()[23].toString());
					streamData.setProductCode(results.get()[24].toString());
					streamData.setProductType(results.get()[25].toString());
					streamDataDtoList.add(streamData);
				}
			}
			}
			catch(Exception exception){
				internetDartlogger.error("EXCEPTION TYPE :",exception);
				
				internetDartlogger.error("----------downloadData---------"+exception.getMessage());
			}finally{
				internetDartlogger.debug("----------downloadData finally---------");
				CloseConnections.closeScrollableResults(results);
			}
		}
		if (isCount) {
			mISLogService.saveMIS(Constants.INTERNET_DART_DATA, loginid);
		}
		return streamDataDtoList;
	}

	/**
	 * 
	 * @param trackByLoginId
	 * @param secLevel
	 * @param loginid
	 * @param custCC
	 * @param custAC
	 * @param dateFrom
	 * @param dateTo
	 * @param prodCode
	 * @param status
	 * @param orgAreaCode
	 * @param dstAreaCode
	 * @param sortBy
	 * @param sortOrder
	 * @param retVal
	 * @return
	 */
	@Transactional
	public List<StreamDataDto> allRedirectedShipments(boolean trackByLoginId, int secLevel, String loginid,
			String custCC, String custAC, java.sql.Date dateFrom, java.sql.Date dateTo, String prodCode, String status,
			String orgAreaCode, String dstAreaCode, String sortBy, String sortOrder, boolean retVal, boolean isCount) {
		internetDartlogger.debug("InternetDartDaoImpl : allRedirectedShipments");
		List<StreamDataDto> streamDataDtoList = null;
		String trackById = "F";
		String sorder = "ASC";
		String tempcustAC = null;
		String tempcustCC = null;
		if (trackByLoginId) {
			trackById = "T";
			tempcustAC = null;
			tempcustCC = null;
		} else {
			tempcustAC = custAC;
			tempcustCC = custCC;
		}

		if ("D".equalsIgnoreCase(sortOrder)) {
			sorder = "DESC";
		}

		int retValue = dbManager.getRDShipments(trackById, secLevel, loginid, tempcustCC, tempcustAC, dateFrom, dateTo,
				prodCode, status, orgAreaCode, dstAreaCode, sortBy, sorder);
		internetDartlogger.info("Return value from getRDShipments procedure :"+retValue);
		
		
		if (retValue != 0 ) {
			streamDataDtoList = new ArrayList<>();
			StringBuilder selectQuery = new StringBuilder();
			ScrollableResults results = null;
			try{
				
			
			selectQuery.append(
					"SELECT  DISTINCT RPAD(NVL(temp.CAWBNO, ' '), 12, ' ') AS AWBNO, RPAD(NVL(temp.CCRCRDREF, ' '), 20, ' ') AS REFNO, RPAD(NVL(TO_CHAR(temp.DPUDATE, 'YYYYMMDD'), ' '), 8, ' ') AS PUDATE, RPAD(NVL(temp.CPUTIME,' '), 4, ' ') AS PUTIME,"); // 4
			selectQuery.append("RPAD(temp.CORGAREA, 25, ' ') AS ORGAREA,"); // 5
			selectQuery.append("RPAD(temp.CDSTAREA, 25, ' ') AS DSTAREA,");
			selectQuery.append("RPAD(NVL(temp.CATTENTION, ' '), 20, ' ') AS CONSIGNEE,"); // 7
			selectQuery.append("RPAD(temp.CSTATDESC, 50, ' ') AS STATDESC, "); // 7
			selectQuery.append("RPAD(CSTATGROUP, 2, ' ') AS STATGROUP,"); // 8
			selectQuery.append("RPAD(NVL(TO_CHAR(temp.DSTATDATE, 'YYYYMMDD'), ' '), 8, ' ') AS STATDATE,");
			selectQuery.append("RPAD(NVL(temp.CSTATTIME, ' '), 4, ' ') AS STATTIME,"); // 10
			selectQuery.append("RPAD(NVL(temp.CRECDBY,' '), 30, ' ') AS RECDBY,");
			selectQuery.append("RPAD(NVL(temp.CRELATION,' '), 30, ' ') AS RELATION, ");
			selectQuery.append("RPAD(NVL(temp.CIDTYPE, ' '), 2, ' ') AS IDTYPE,");
			selectQuery.append("RPAD(NVL(temp.CIDNO, ' '), 20, ' ') AS IDNO, ");
			selectQuery.append("RPAD(NVL(temp.CORGCODE, ' '), 3, ' ') AS ORGACODE, ");
			selectQuery.append("RPAD(NVL(temp.CCUSTCODE, ' '), 6, ' ') AS CUSTCODE, ");
			selectQuery.append("RPAD(TO_CHAR(temp.NWEIGHT), 7, ' ') AS NWEIGHT, ");
			selectQuery.append("RPAD(TO_CHAR(temp.NPCS), 4, ' ') AS NPCS,");
			selectQuery.append("RPAD(NVL(TO_CHAR(temp.DEPTDTDLV, 'dd-Mon-yy'), ' '), 9, ' ') AS DEPTDTDLV,");
			selectQuery.append("SUBSTR(RPAD(NVL(temp.CSPLINST, ' '), 25, ' '),1,25) AS CSPLINST, ");
			selectQuery.append("RPAD(NVL(temp.CNEWAWBNO, ' '), 12, ' ') AS NAWBNO,");
			selectQuery.append("RPAD(NVL(temp.CSENDER, ' '), 20, ' ') AS CSENDER,");
			selectQuery.append(
					"RPAD(NVL (  trim(  uprofile4.PACKGET_CUSTCENTDET.get_custcent_rtostat3(temp.cawbno, temp.dstatdate, temp.CSTATTIME , '027' ) ) , ' '), 40, ' ') AS CRTOREASON  ");
			selectQuery.append(" FROM indtemp temp ");

			String sortString = " PUDATE DESC, AWBNO DESC ";
			if (null != sortBy && sortBy.trim().length() > 0) {
				if (Constants.INTERNETDART_PICKUPDATE.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_PUDATE;
				} else if (Constants.INTERNETDART_AWBNO.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_AWBNO;
				} else if (Constants.INTERNETDART_REFNO.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_REFNO;
				} else if (Constants.INTERNETDART_ORGAREA.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_ORGAREA;
				} else if (Constants.INTERNETDART_DSTAREA.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_DSTAREA;
				} else if (Constants.INTERNETDART_CONSIGNEE.equalsIgnoreCase(sortBy)) {
					sortString = Constants.INTERNETDART_CONSIGNEE;
				} else {
					sortString = Constants.INTERNETDART_PUDATE;
				}

				if ((null != sortOrder) && (sortOrder.trim().length() > 0)) {
					if ("A".equalsIgnoreCase(sortOrder)) {
						sortString = sortString.concat(Constants.INTERNETDART_QUERYASC);
					} else {
						sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
					}
				} else {
					sortString = sortString.concat(Constants.INTERNETDART_QUERYDESC);
				}
			}

			selectQuery.append(" ORDER BY " + sortString);
			
			results = getSession().createSQLQuery(selectQuery.toString()).setReadOnly(true).setCacheable(true)
					.scroll(ScrollMode.SCROLL_SENSITIVE);
			
			StreamDataDto streamData;
			while (results.next()) {
				streamData = new StreamDataDto();
				streamData.setAwbNo(Converter.objToString(results.get()[0]));
				streamData.setRefNo(Converter.objToString(results.get()[1]));
				streamData.setPuDate(Converter.objToString(results.get()[2]));
				streamData.setPuTime(Converter.objToString(results.get()[3]));
				streamData.setOrgArea(Converter.objToString(results.get()[4]));
				streamData.setDstArea(Converter.objToString(results.get()[5]));
				streamData.setConsignee(Converter.objToString(results.get()[6]));
				streamData.setStatDesc(Converter.objToString(results.get()[7]));
				streamData.setStatGroup(Converter.objToString(results.get()[8]));
				streamData.setStatDate(Converter.objToString(results.get()[9]));
				streamData.setStatTime(Converter.objToString(results.get()[10]));
				streamData.setRecBy(Converter.objToString(results.get()[11]));
				streamData.setRelation(Converter.objToString(results.get()[12]));
				streamData.setIdType(Converter.objToString(results.get()[13]));
				streamData.setIdNo(Converter.objToString(results.get()[14]));
				streamData.setOrgCode(Converter.objToString(results.get()[15]));
				streamData.setCustCode(Converter.objToString(results.get()[16]));
				streamData.setnWeight(Converter.objToString(results.get()[17]));
				streamData.setNpcs(Converter.objToString(results.get()[18]));
				streamData.setExptDlv(Converter.objToString(results.get()[19]));
				streamData.setSplInst(Converter.objToString(results.get()[20]));
				streamData.setNewAwNo(Converter.objToString(results.get()[21]));
				streamData.setSender(Converter.objToString(results.get()[22]));
				streamData.setRtoReason(results.get()[23].toString());
				
				
				streamDataDtoList.add(streamData);
			}
			}catch(Exception exception){
				internetDartlogger.error("EXCEPTION TYPE :",exception);
				
				internetDartlogger.error("----------allRedirectedShipments---------"+exception.getMessage());
			}finally{
				internetDartlogger.debug("----------allRedirectedShipments finally---------");
				CloseConnections.closeScrollableResults(results);
			}
		} 
		/*else {
			System.out.println("-----------------ELSE BLOCK------------");
			streamDataDtoList = new ArrayList<>();
			StreamDataDto streamData = new StreamDataDto();
			streamData.setTotalRecord(streamDataDtoList.size());
			streamDataDtoList.add(streamData);
		}*/
		
		return streamDataDtoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.internetdart.dao.InternetDartDao#getCustomerName(java.lang.
	 * String, java.lang.String)
	 */
	@Transactional
	@Override
	public String getCustomerName(String areaCode, String custCode) {
		internetDartlogger.debug("InternetDartDaoImpl : getCustomerName");
		String customerName = null;
		try {
			Criteria criteria = getSession().createCriteria(CustomerMst.class);
			criteria.add(Restrictions.eq("customerArea", areaCode));
			criteria.add(Restrictions.eq("customerCode", custCode));
			CustomerMst customerMaster = (CustomerMst) criteria.uniqueResult();
			if (null != customerMaster) {
				customerName = customerMaster.getCustomerName();
			}
		} catch (Exception exception) {
			internetDartlogger.error("EXCEPTION TYPE :",exception);
			
			internetDartlogger.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}finally{
			internetDartlogger.debug("----------getCustomerName-------------");
		}
		return customerName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluedart.internetdart.dao.InternetDartDao#checkFlag(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int checkFlag(String loginId, String flag) {
		internetDartlogger.debug("InternetDartDaoImpl : checkFlag");
		return dbManager.checkFlag(loginId, flag);
	}
	
	private void makeNullable(){
		trackByLoginId = false;
		doQuery = false;
		custAC = null;
		custCC = null;
		dArea = null;
		orgAreaCode = null;
		dstAreaCode = null;
		fromDate = null;
		toDate = null;
		pageNo = 1;
	}

}
