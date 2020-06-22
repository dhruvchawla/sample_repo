package com.bluedart.trackdart.daoImpl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedart.common.dao.MISLogDao;
import com.bluedart.common.daoImpl.BaseDaoImpl;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.PodDto;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.common.util.CloseConnections;
import com.bluedart.exception.BlueDartException;
import com.bluedart.exception.DataBaseException;
import com.bluedart.trackdart.dao.TrackingDao;
import com.bluedart.trackdart.dto.ShipmentsDto;
import com.bluedart.trackdart.dto.TrackEmailDto;
import com.bluedart.trackdart.dto.TrackOnMapDto;
import com.bluedart.trackdart.dto.TrackOnMapListDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.CopyUtils;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.ErrorMessageStatusCode;
import com.bluedart.utils.StringUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * 
 * @author DH839598
 * @version 0.1
 *
 */
@Repository
@PropertySource("classpath:feature.properties")
public class TrackingDaoImpl extends BaseDaoImpl implements TrackingDao {

	private static final Logger log = Logger.getLogger(TrackingDaoImpl.class);

	@Autowired
	private TrackTraceValidator trackTraceValidator;

	@Autowired
	private MISLogDao misLogDao;

	@Autowired
	private Environment environment;

	@Transactional
	@Override
	public TrackDto trackByAwbNos(List<String> awbNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber) {
		log.debug(" TrackingDaoImpl : trackByAwbNos");
		log.info("awbNos Size:-------------------------------------"+awbNos.size());
		log.info("AwbNos:"+awbNos+":loginId:"+loginId+":reqScanFlag:"+reqScanFlag+":ipAddress:"+ipAddress+":awbNumber:"+awbNumber);
		
		
		TrackDto trackDto = null;
		String[] listOfValidAwbNos = null;
		if (!StringUtils.isNullOrEmpty(awbNos)) {
			listOfValidAwbNos = awbNos.toArray(new String[awbNos.size()]);
		}
		log.info("listOfValidAwbNos in Tracking DaoImpl-----------------------------------------------------------:"+listOfValidAwbNos);
		try {
			trackDto = getTrackByAwbNoList(listOfValidAwbNos, loginId, reqScanFlag);
			if (environment.getProperty(Constants.LOGS_STATUS).equals("Y")) {
				if (null != loginId && loginId.trim().length() > 0 && !"null".equalsIgnoreCase(loginId)) {
					saveMIS(Constants.TRACK_AND_TRACE, loginId);
				} else {
					saveMISWithOutLogin(Constants.TRACK_AND_TRACE, null, ipAddress, awbNumber, "");
				}
			}

		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
		//	log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}  
		
		return trackDto;
	}

	@Transactional
	@Override
	public TrackDto trackByRefNos(List<String> refNos, String loginId, int reqScanFlag, String ipAddress,
			String awbNumber) {
		log.debug(" TrackingDaoImpl : trackByRefNos");
		TrackDto trackDto = null;
		String[] listOfValidRefs = null;
		List<String> refArrayList = new ArrayList<>();
		
		 for(String string : refNos){
			 if(string.contains("--")){
				 string = string.replace("--", "/");
				 refArrayList.add(string); 
			 } else {
				 refArrayList.add(string); 
			 }
		 }
		
		if (!StringUtils.isNullOrEmpty(refArrayList)) {
			listOfValidRefs = refArrayList.toArray(new String[refArrayList.size()]);
		}
		
		try {
			trackDto = getTrackByRefNoList(listOfValidRefs, loginId, reqScanFlag);
			if (environment.getProperty(Constants.LOGS_STATUS).equals("Y")) {
				if (null != loginId && loginId.trim().length() > 0 && !"null".equalsIgnoreCase(loginId)) {
					saveMIS(Constants.TRACK_AND_TRACE, loginId);
				} else {
					saveMISWithOutLogin(Constants.TRACK_AND_TRACE, null, ipAddress, awbNumber, "");
				}
			}
			
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}  
		
		log.debug(" TrackingDaoImpl : trackByRefNos ");
		return trackDto;
	}

	@Transactional
	@Override
	public TrackEmailDto trackByAwbNosByEmail(String awbNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber) {

		log.debug(" TrackingDaoImpl : trackByAwbNosByEmail");
		TrackDto trackDto = null;
		String[] listOfValidAwbNos = null;
		List<String> invalidNumbers = new ArrayList<>();
		List<String> listOfValidAwbNoList = trackTraceValidator.getListOfAwbNos(awbNos, invalidNumbers);
		if (!StringUtils.isNullOrEmpty(listOfValidAwbNoList)) {
			listOfValidAwbNos = listOfValidAwbNoList.toArray(new String[listOfValidAwbNoList.size()]);
		} else {
			listOfValidAwbNos = null;
		}
		TrackEmailDto trackEmailDto = null;
		try {

			if (null != loginId && loginId.trim().length() > 0 && !"null".equalsIgnoreCase(loginId)) {
				saveMIS(Constants.TRACK_AND_TRACE, loginId);
			}
			 
			if (null != listOfValidAwbNos) {
				trackDto = getTrackByAwbNoList(listOfValidAwbNos, loginId, reqScanFlag);
			}

		} catch (DataBaseException dartServiceException) {
			log.error("EXCEPTION TYPE :",dartServiceException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		} 

			trackEmailDto = new TrackEmailDto();
			EmailContent emailContent = new EmailContent();
			emailContent.setFrom(Constants.BD_MAIL);
			emailContent.setTo(emailId);
			emailContent.setSubject(Constants.BD_MAIL_SUB);
			List<String> wrongWaybillNo = new ArrayList<>();
			
			StringBuilder msgContentMain = new StringBuilder();
			if(null!=trackDto){
				String msgContent = getEmailBody(trackDto, loginId, wrongWaybillNo);
				msgContentMain.append(msgContent);
			}
			
			
			if(!wrongWaybillNo.isEmpty()){
				StringBuilder message = new StringBuilder();
				message.append("<html><body>");
				message.append("<br><br>");
				message.append("<b>" + Constants.EMPTYREC_MSG +"</b>");
				message.append("<br>");
				for(String wrong : wrongWaybillNo){
					message.append("<b>" + wrong +"</b>");
					message.append("<br>");
				}
				message.append("</body></html>");
				msgContentMain.append(message.toString());
			}
			
			if(!invalidNumbers.isEmpty()){
				StringBuilder message = new StringBuilder();
				message.append("<html><body>");
				message.append("<br><br>");
				message.append("<b>" + Constants.INVVALID_MSG +"</b>");
				message.append("<br>");
				for(String wrong : invalidNumbers){
					message.append("<b>" + wrong +"</b>");
					message.append("<br>");
				}
				message.append("</body></html>");
				msgContentMain.append(message.toString());
			}
			
			if(StringUtils.isNullOrEmpty(listOfValidAwbNos)){
				StringBuilder message = new StringBuilder();
				message.append("<html><body>");
				message.append("<br><br>");
				message.append("<b>" + Constants.INVVALID_MSG +"</b>");
				message.append("<br>");
				for(String wrong : invalidNumbers){
					message.append("<b>" + wrong +"</b>");
					message.append("<br>");
				}
				message.append("</body></html>");
				msgContentMain.append(message.toString());
			}
			 
			emailContent.setText(msgContentMain.toString());
			try {
				EmailUtil.sendEmailWithHtmlText(emailContent);
				trackEmailDto.setIsMailSent("Y");
			} catch (MessagingException e) {
				log.error("EXCEPTION TYPE :",e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(),ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}   

		return trackEmailDto;
	}

	@Transactional
	@Override
	public TrackEmailDto trackByRefNosByEmail(String refNos, String loginId, int reqScanFlag, String emailId,
			String ipAddress, String awbNumber) {
		log.debug(" TrackingDaoImpl : trackByRefNosByEmail");
		String[] listOfValidRefs = null;
		TrackDto trackDto = null;
		List<String> invalidNumbers = new ArrayList<>();
		List<String> listOfValidRefNoList = trackTraceValidator.getListOfRefNos(refNos, invalidNumbers);
		if (!StringUtils.isNullOrEmpty(listOfValidRefNoList)) {
			listOfValidRefs = listOfValidRefNoList.toArray(new String[listOfValidRefNoList.size()]);
		}
		TrackEmailDto trackEmailDto = null;
		try {

			if (null != loginId && loginId.trim().length() > 0 && !loginId.equalsIgnoreCase("null")) {
				saveMIS(Constants.TRACK_AND_TRACE, loginId);
			}
			
			trackDto = getTrackByRefNoList(listOfValidRefs, loginId, reqScanFlag);
			 
		} catch (DataBaseException dartServiceException) {
			log.error("EXCEPTION TYPE :",dartServiceException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}

		if (StringUtils.isNullOrEmpty(listOfValidRefs)) {
			trackEmailDto = new TrackEmailDto();
			trackEmailDto.setIsMailSent("N");
			return trackEmailDto;
		}

		if (null != trackDto) {
			trackEmailDto = new TrackEmailDto();
			EmailContent emailContent = new EmailContent();
			emailContent.setFrom("response@bluedart.com");
			emailContent.setTo(emailId);
			emailContent.setSubject("Shipment Tracking Details");
			List<String> wrongWaybillNo = new ArrayList<>();
			String msgContent = getEmailBody(trackDto, loginId, wrongWaybillNo);
			emailContent.setText(msgContent);
			try {
				EmailUtil.sendEmailWithHtmlText(emailContent);
				trackEmailDto.setIsMailSent("Y");
			} catch (MessagingException e) {
				log.error("EXCEPTION TYPE :",e);
				throw new BlueDartException(ErrorMessageStatusCode.EMAIL_NOT_SENT.getCode(),ErrorMessageStatusCode.EMAIL_NOT_SENT.getDescription());
			}
		}

		return trackEmailDto;
	}

	/**
	 * 
	 * @param trackDto
	 * @param loginId
	 * @return
	 */
	private String getEmailBody(TrackDto trackDto, String loginId, List<String> wrongWaybillNo) {
		log.debug(" TrackingDaoImpl : getEmailBody");
		trackDto = TrackDartHelper.getTrackDetails(trackDto, true, loginId);

		StringBuilder message = new StringBuilder();
		for (ShipmentDto shipmentDto : trackDto.getShipmentList()) {
			
			if("NF".equalsIgnoreCase(shipmentDto.getCstatus())){
				wrongWaybillNo.add(shipmentDto.getCawbno());
			} else {
				message.append("<html><body>");
				message.append("<br><br>");
				message.append("<b>Waybill No</b> " + shipmentDto.getCawbno());
				message.append("<table border='1'>");
				if (null!= shipmentDto.getServiceFlag() && "Y".equalsIgnoreCase(shipmentDto.getServiceFlag())) {
					message.append("<tr><td><b>Service </b></td><td>" + shipmentDto.getCproddesc() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getFormalDateFlag() && "Y".equalsIgnoreCase(shipmentDto.getFormalDateFlag())) {
					message.append("<tr><td><b>Formal date of entry in India </b></td><td>" + shipmentDto.getDpudate()
							+ Constants.TRACKDART_HTML);
				}
				if ( null!= shipmentDto.getPickupDateFlag()  && "Y".equalsIgnoreCase(shipmentDto.getPickupDateFlag())) {
					message.append("<tr><td><b>Pickup Date </b></td><td>" + shipmentDto.getDpudate() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCountryOrigin() && "Y".equalsIgnoreCase(shipmentDto.getCountryOrigin())) {
					message.append("<tr><td><b>Country Origin Location </b></td><td>" + shipmentDto.getCorgscrdesc()
							+ Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getFrom() && "Y".equalsIgnoreCase(shipmentDto.getFrom())) {
					message.append("<tr><td><b>From </b></td><td>" + shipmentDto.getCorgareadesc() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCountryDelivery() && "Y".equalsIgnoreCase(shipmentDto.getCountryDelivery())) {
					message.append("<tr><td><b>Country Delivery Location </b></td><td>" + shipmentDto.getCdstscrdesc()
							+ Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getTo() && "Y".equalsIgnoreCase(shipmentDto.getTo())) {
					message.append("<tr><td><b>To </b></td><td>" + shipmentDto.getCdstareadesc() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getShowProdType() && "Y".equalsIgnoreCase(shipmentDto.getShowProdType())) {
					message.append("<tr><td><b>Product Type </b></td><td>" + shipmentDto.getCprodtype() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCshpcname() && "Y".equalsIgnoreCase(shipmentDto.getCshpcname())) {
					message.append("<tr><td><b>Customer Name </b></td><td>" + shipmentDto.getCshpcname() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCsender() && "Y".equalsIgnoreCase(shipmentDto.getCsender())) {
					message.append("<tr><td><b>Sender's Name </b></td><td>" + shipmentDto.getCsender() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCattention() && "Y".equalsIgnoreCase(shipmentDto.getCattention())) {
					message.append("<tr><td><b>Consignee Name </b></td><td>" + shipmentDto.getCattention() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCconscadr1() && null!= shipmentDto.getSecLevelFlag()
						&& ("0".equalsIgnoreCase(shipmentDto.getSecLevelFlag())
								|| "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag()))) {
					message.append(
							"<tr><td><b>Consignee Address1 </b></td><td>" + shipmentDto.getCconscadr1() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCconscadr2() && null!= shipmentDto.getSecLevelFlag()
						&& ("0".equalsIgnoreCase(shipmentDto.getSecLevelFlag())
								|| "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag()))) {
					message.append(
							"<tr><td><b>Consignee Address2 </b></td><td>" + shipmentDto.getCconscadr2() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCconscadr3() && null!= shipmentDto.getSecLevelFlag()
						&& ("0".equalsIgnoreCase(shipmentDto.getSecLevelFlag())
								|| "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag()))) {
					message.append(
							"<tr><td><b>Consignee Address3 </b></td><td>" + shipmentDto.getCconscadr3() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCconsctel() && null!= shipmentDto.getSecLevelFlag() 
						&& ("0".equalsIgnoreCase(shipmentDto.getSecLevelFlag())
								|| "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag()))) {
					message.append("<tr><td><b>Telephone </b></td><td>" + shipmentDto.getCconsctel() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getNpcs() && null!= shipmentDto.getSecLevelFlag()
						&& "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag())) {
					message.append("<tr><td><b>No. of pieces </b></td><td>" + shipmentDto.getNpcs() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCfocdesc() && null!= shipmentDto.getSecLevelFlag()
						&& "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag())) {
					message.append("<tr><td><b>FOC. Reason </b></td><td>" + shipmentDto.getCfocdesc() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCpacktype() && null!= shipmentDto.getSecLevelFlag()
						&& "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag())
						&& ("Y".equalsIgnoreCase(shipmentDto.getShowPackType()))) {
					message.append("<tr><td><b>Packaging Type </b></td><td>" + shipmentDto.getCpacktype() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCcmdtyname() && null!= shipmentDto.getSecLevelFlag() 
						&& "1".equalsIgnoreCase(shipmentDto.getSecLevelFlag())) {
					message.append(
							"<tr><td><b>Commodity Description </b></td><td>" + shipmentDto.getCcmdtyname() + Constants.TRACKDART_HTML);
				}
				if ( null!= shipmentDto.getNweight()) {
					message.append("<tr><td><b>Weight </b></td><td>" + shipmentDto.getNweight() + Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getCstatdesc() && null!= shipmentDto.getShowStatus()
						&& "Y".equalsIgnoreCase(shipmentDto.getShowStatus())) {
					message.append("<tr><td><b>Status </b></td><td>" + shipmentDto.getCstatdesc() +Constants.TRACKDART_HTML);
				}
				if (null!= shipmentDto.getDstatdate() && null!=  shipmentDto.getDateOfDelivery() 
						&& "Y".equalsIgnoreCase(shipmentDto.getDateOfDelivery())) {
					message.append("<tr><td><b>Date of Delivery </b></td><td>" + shipmentDto.getDstatdate() + Constants.TRACKDART_HTML);
				}
				if (null!=  shipmentDto.getCstattime()  && null!=  shipmentDto.getTimeOfDelivery()
						&& "Y".equalsIgnoreCase(shipmentDto.getTimeOfDelivery())) {
					message.append("<tr><td><b>Time of Delivery </b></td><td>" + shipmentDto.getCstattime() + Constants.TRACKDART_HTML);
				}
				if (null!=  shipmentDto.getCrecdby() ) {
					message.append("<tr><td><b>Recipient </b></td><td>" + shipmentDto.getCrecdby() + Constants.TRACKDART_HTML);
				}
				if (null!=  shipmentDto.getCrelation() ) {
					message.append("<tr><td><b>Relation of the Recipient </b></td><td>" + shipmentDto.getCrelation()
							+ "</td></tr>");
				}
				if (null!=  shipmentDto.getCidtype()) {
					message.append("<tr><td><b>Identification </b></td><td>" + shipmentDto.getCidtype() + Constants.TRACKDART_HTML);
				}
				if (null!=  shipmentDto.getDeptdtdlv()) {
					message.append("<tr><td><b>Expected Date of Delivery </b></td><td>" + shipmentDto.getDeptdtdlv()
							+ "</td></tr>");
				}
				if (null!=  shipmentDto.getNewWayBillNo() && "Y".equalsIgnoreCase(shipmentDto.getNewWayBillNo())
						&& null!=  shipmentDto.getCnewawbno()) {
					message.append("<tr><td><b>New Waybill No </b></td><td>" + shipmentDto.getCnewawbno() + Constants.TRACKDART_HTML);
				}
				message.append("</table>");
				message.append("<br>");
				message.append("<table border='1'>");
				message.append(
						"<tr><th colspan='4'>Status and Scans of the Waybill No " + shipmentDto.getCawbno() + "</th></tr>");
				message.append(
						"<tr><th><b>Locations</b></th><th><b>Details</b></th><th><b>Date</b></th><th><b>Time</b></th></tr>");
				if (null!=  shipmentDto.getPodDtoList()) {
					for (PodDto podDto : shipmentDto.getPodDtoList()) {
						message.append("<tr><td>" + podDto.getPclocdesc() + Constants.TRACKDART_HTML1 + podDto.getPcstatdesc() + Constants.TRACKDART_HTML1
								+ podDto.getPdstatdate() + Constants.TRACKDART_HTML1 + podDto.getPcstattime() + Constants.TRACKDART_HTML);
					}
				}
				message.append("</table>");
				message.append("</body></html>");
			}
		}
		return message.toString();
	}

	@Transactional
	public boolean saveMIS(String featureName, String loginId) {
		log.debug(" TrackingDaoImpl : saveMIS"+featureName+"@@@@"+loginId);
		boolean flag = false;
		try {
			flag = misLogDao.saveMIS(featureName, loginId);
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}
	
	@Transactional
	public boolean saveMISWithOutLogin(String featureName, String emailId, String ip, String awbnos, String maildate) {
		log.debug(" TrackingDaoImpl : saveMISWithOutLogin"+featureName+"-----"+ip);
		boolean flag = false;
		try {
			flag = misLogDao.saveMISWithOutLogin(featureName, emailId, ip, awbnos, maildate);
		} catch (Exception exception) {
			
			log.error("EXCEPTION TYPE :",exception);
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(), ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return flag;
	}

	@Transactional
	public TrackDto getTrackByAwbNoList(String[] awbnos, String loginId, int reqScanFlag) {

		log.debug(" TrackingDaoImpl : getTrackByAwbNoList-------"+awbnos.length);
		
		Properties properties = new Properties();
		TrackDto trackDto = null;
		try { 
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		} catch (IOException e) {
			log.error("EXCEPTION TYPE :",e);
			// log.error(e.getMessage());
			 throw new DataBaseException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
  
		try {
			trackDto = getSession().doReturningWork(new ReturningWork<TrackDto>() {
 
				@Override
				public TrackDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					try{
					List commonDto = null;
					List<ShipmentDto> shipmentList = new ArrayList<>();  
					List<ShipmentsDto> shipmentSOList = null;
					List<PodDto> podList = null;
					TrackDto trackDto = new TrackDto();
					Map<String, Class<?>> map = connection.getTypeMap();
					try {
						map.put(properties.getProperty(Constants.SHIPOBJS), Class.forName(Constants.SHIPMENTS_DTO));
						map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
					} catch (Exception exception) {
						exception.printStackTrace();
						log.error(exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
					connection.setTypeMap(map);
					ArrayDescriptor descAwbnoList = ArrayDescriptor
							.createDescriptor(properties.getProperty(Constants.NUMLIST), connection);
					ARRAY awbnoList = new ARRAY(descAwbnoList, connection, awbnos);
					callableStatement = connection
							.prepareCall("{call UPROFILE4.TNT_MANG_new.trackByAwbnos_version1(?,?,?,?,?,?,?,?,?,?,?,?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							properties.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							properties.getProperty(Constants.SHIPLISTS));
					((OracleCallableStatement) callableStatement).setArray(3, awbnoList);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
							properties.getProperty(Constants.NUMLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(4, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).setString(6, loginId);
					log.debug("-------------------------loginId-"+loginId+"--------reqScanFlag-"+reqScanFlag);
						
					((OracleCallableStatement) callableStatement).setInt(7, reqScanFlag);
					((OracleCallableStatement) callableStatement).setString(8, null);
					((OracleCallableStatement) callableStatement).setString(9, null);
					((OracleCallableStatement) callableStatement).setString(10, null);
					((OracleCallableStatement) callableStatement).setString(11, null);
					((OracleCallableStatement) callableStatement).registerOutParameter(12, Types.INTEGER);
					
					callableStatement.execute();
 
					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					ShipmentDto shipmentDtoList ;
					if (shipArayList != null && shipArayList.length() != 0) {
						commonDto = Arrays.asList((Object[]) shipArayList.getArray());
						shipmentSOList = new ArrayList<>(commonDto);
						for(ShipmentsDto shipmentSo : shipmentSOList){
							shipmentDtoList = new ShipmentDto();
							CopyUtils.copy(shipmentSo, shipmentDtoList);
							shipmentList.add(shipmentDtoList);
						}
						
						trackDto.setShipmentList(shipmentList);
					}

					if (podArrayList != null && podArrayList.length() != 0) {
						commonDto = Arrays.asList((Object[]) podArrayList.getArray());
						podList = new ArrayList<>(commonDto);
						trackDto.setPodList(podList);
					}
					
					return trackDto;
					}catch(Exception exception){
						log.error("EXCEPTION TYPE :",exception);
						log.error("----------getTrackByAwbNoList---------"+exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						log.debug("----------getTrackByAwbNoList finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
				}
				
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			log.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return trackDto;
	}

	@Transactional
	public TrackDto getTrackByRefNoList(String[] refnos, String loginId, int reqScanFlag){
		log.debug(" TrackingDaoImpl : getTrackByRefNoList");
		Properties properties = new Properties();
		TrackDto trackDto = null;
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		} catch (IOException e) {
			log.error("EXCEPTION TYPE :",e);
			// log.error(e.getMessage());
			 throw new DataBaseException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}
 
		try {
			trackDto = getSession().doReturningWork(new ReturningWork<TrackDto>() {
				
				@Override
				public TrackDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					try{
					List commonDto = null;
					List<ShipmentDto> shipmentList =  new ArrayList<>();
					
					List<PodDto> podList = null;
					List<ShipmentsDto> shipmentSOList = null;
					TrackDto trackDto = new TrackDto();
					Map<String, Class<?>> map = connection.getTypeMap();
					try {
						map.put(properties.getProperty(Constants.SHIPOBJS), Class.forName(Constants.SHIPMENTS_DTO));
						map.put(properties.getProperty(Constants.PODOBJ), Class.forName(Constants.POD_DTO));
					} catch (Exception exception) {
						log.error("EXCEPTION TYPE :",exception);
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}
					connection.setTypeMap(map);
					ArrayDescriptor descAwbnoList = ArrayDescriptor
							.createDescriptor(properties.getProperty(Constants.NUMLIST), connection);
					ARRAY refnoList = new ARRAY(descAwbnoList, connection, refnos);
					callableStatement = connection
							.prepareCall("{call UPROFILE4.TNT_MANG_NEW.trackByRefnos_Version1(?,?,?,?,?,?,?)}");
					callableStatement.clearParameters();
					((OracleCallableStatement) callableStatement).registerOutParameter(1, java.sql.Types.ARRAY,
							properties.getProperty(Constants.PODLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(2, java.sql.Types.ARRAY,
							properties.getProperty(Constants.SHIPLISTS));
					((OracleCallableStatement) callableStatement).setArray(3, refnoList);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, java.sql.Types.ARRAY,
							properties.getProperty(Constants.NUMLIST));
					((OracleCallableStatement) callableStatement).registerOutParameter(4, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).registerOutParameter(5, Types.VARCHAR);
					((OracleCallableStatement) callableStatement).setString(6, loginId);
					((OracleCallableStatement) callableStatement).setInt(7, reqScanFlag);
					callableStatement.execute();

					ARRAY podArrayList = ((OracleCallableStatement) callableStatement).getARRAY(1);
					ARRAY shipArayList = ((OracleCallableStatement) callableStatement).getARRAY(2);
					ShipmentDto shipmentDtoList ;
					if (shipArayList != null && shipArayList.length() != 0) {
						commonDto = Arrays.asList((Object[]) shipArayList.getArray());
						shipmentSOList = new ArrayList<>(commonDto);
						for(ShipmentsDto shipmentSo : shipmentSOList){
							shipmentDtoList = new ShipmentDto();
							CopyUtils.copy(shipmentSo, shipmentDtoList);
							shipmentList.add(shipmentDtoList);
						}
						
						trackDto.setShipmentList(shipmentList);
					}

					if (podArrayList != null && podArrayList.length() != 0) {
						commonDto = Arrays.asList((Object[]) podArrayList.getArray());
						podList = new ArrayList<>(commonDto);
						trackDto.setPodList(podList);
					}
					
					return trackDto;
					
				} catch (Exception exception) {
					log.error("EXCEPTION TYPE :",exception);
					log.error("----------getTrackByRefNoList---------"+exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}finally{
					log.debug("----------getTrackByRefNoList finally---------");
					CloseConnections.closeCallableStatement(callableStatement);
				}
				}
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return trackDto;
	}
	
	
	
	@Transactional
	@Override
	public TrackOnMapListDto trackOnMap(String awbNo,String status) throws IOException {
		log.info(" TrackingDaoImpl : trackOnMap awbNo"+awbNo+"status"+status);
		Properties properties = new Properties();
		TrackOnMapListDto trackOnMapServiceStationDto = null;
		properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		try {
			trackOnMapServiceStationDto = getSession().doReturningWork(new ReturningWork<TrackOnMapListDto>() {
				@Override
				public TrackOnMapListDto execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					ResultSet rs = null;
					try{
						
					List<TrackOnMapDto> trackOnMapDtosList = new ArrayList<>();
					TrackOnMapDto trackOnMapDtoRes = null;
					TrackOnMapListDto trackOnMapServiceStationDto = new TrackOnMapListDto();
					if(Constants.TRACK_ON_MAP_STATUS_OUTFORDELIVERY.equalsIgnoreCase(status)){
						log.info(" TrackingDaoImpl RACK_ON_MAP_STATUS_OUTFORDELIVERY:");
						callableStatement = connection
								.prepareCall("{call uprofile4.tnt_mang_new.trackbylastmilemap_V1(?,?)}");
						callableStatement.clearParameters();
						((OracleCallableStatement) callableStatement).setString(1, awbNo);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						
						while (rs.next()) {
							trackOnMapDtoRes = new TrackOnMapDto();
							if(!awbNo.equalsIgnoreCase(rs.getString("cawbno"))){
								trackOnMapDtoRes.setLatitude(rs.getString("cgpslat"));
								trackOnMapDtoRes.setLongitude(rs.getString("cgpslon"));
								trackOnMapDtoRes.setDeliveryDate(rs.getString(Constants.TRACK_ON_MAP_DSTATDATE));
								trackOnMapDtoRes.setDeliveryTime(rs.getString("dstattime"));
								trackOnMapDtoRes.setEmployeeCode(rs.getString("cemplcode"));
								trackOnMapDtoRes.setStatusCode(rs.getString(Constants.TRACK_ON_MAP_CSTATCODE));
								log.info("Latitude"+trackOnMapDtoRes.getLatitude()+"Longitude"+trackOnMapDtoRes.getLongitude()+"DeliveryDate"+trackOnMapDtoRes.getDeliveryDate()+"DeliveryTime"+trackOnMapDtoRes.getDeliveryTime()+"Empoyee code"+trackOnMapDtoRes.getEmployeeCode()+"Status code"+trackOnMapDtoRes.getStatusCode());
								trackOnMapDtosList.add(trackOnMapDtoRes);
							}
							else{
								trackOnMapDtoRes.setLatitude(rs.getString("cgpslat"));
								trackOnMapDtoRes.setLongitude(rs.getString("cgpslon"));
								trackOnMapDtoRes.setDeliveryDate(rs.getString(Constants.TRACK_ON_MAP_DSTATDATE));
								trackOnMapDtoRes.setDeliveryTime(rs.getString("dstattime"));
								trackOnMapDtoRes.setEmployeeCode(rs.getString("cemplcode"));
								trackOnMapDtoRes.setStatusCode(rs.getString(Constants.TRACK_ON_MAP_CSTATCODE));
								log.info("Latitude"+trackOnMapDtoRes.getLatitude()+"Longitude"+trackOnMapDtoRes.getLongitude()+"DeliveryDate"+trackOnMapDtoRes.getDeliveryDate()+"DeliveryTime"+trackOnMapDtoRes.getDeliveryTime()+"Empoyee code"+trackOnMapDtoRes.getEmployeeCode()+"Status code"+trackOnMapDtoRes.getStatusCode());
								trackOnMapDtosList.add(trackOnMapDtoRes);
								break;
							}
						}
						trackOnMapServiceStationDto.setMapType(Constants.TRACK_ON_MAP_LASTMILE);
						trackOnMapServiceStationDto.setServiceStationsList(trackOnMapDtosList);
					}else{
						log.info(" TrackingDaoImpl Other status");
						callableStatement = connection
								.prepareCall("{call uprofile4.tnt_mang_new.trackbynetworkmap(?,?)}");
						callableStatement.clearParameters();
						((OracleCallableStatement) callableStatement).setString(1, awbNo);
						((OracleCallableStatement) callableStatement).registerOutParameter(2, OracleTypes.CURSOR);
						callableStatement.execute();
						rs = (ResultSet) callableStatement.getObject(2);
						
						while (rs.next()) {
							trackOnMapDtoRes = new TrackOnMapDto();
							trackOnMapDtoRes.setServiceStationCode(rs.getString("lcscrcd"));
							trackOnMapDtoRes.setServiceStationDesc(rs.getString("cscrcddesc"));
							trackOnMapDtoRes.setServiceStationAddr1(rs.getString("careaadr1"));
							trackOnMapDtoRes.setServiceStationAddr2(rs.getString("careaadr2"));
							trackOnMapDtoRes.setServiceStationAddr3(rs.getString("careaadr3"));
							trackOnMapDtoRes.setServiceStationCity(rs.getString("careacity"));
							trackOnMapDtoRes.setServiceStationState(rs.getString("cstate"));
							trackOnMapDtoRes.setServiceStationPincode(rs.getString("careapin"));
							trackOnMapDtoRes.setLatitude(rs.getString("clatitude"));
							trackOnMapDtoRes.setLongitude(rs.getString("clongitude"));
							trackOnMapDtoRes.setDeliveryDate(rs.getString(Constants.TRACK_ON_MAP_DSTATDATE));
							trackOnMapDtoRes.setDeliveryTime(rs.getString("cstattime"));
							trackOnMapDtoRes.setStatusCode(rs.getString(Constants.TRACK_ON_MAP_CSTATCODE));
							trackOnMapDtoRes.setStatusType(rs.getString("cstattype"));
							log.info("ServiceStationCode"+trackOnMapDtoRes.getServiceStationCode()+
									"ServiceStationDesc"+trackOnMapDtoRes.getServiceStationDesc()+
									"setServiceStationAddr1"+trackOnMapDtoRes.getServiceStationAddr1()
									+"ServiceStationAddr2"+trackOnMapDtoRes.getServiceStationAddr2()
									+"setServiceStationAddr3"+trackOnMapDtoRes.getServiceStationAddr3()
									+"setServiceStationCity"+trackOnMapDtoRes.getServiceStationCity()
									+"setServiceStationState"+trackOnMapDtoRes.getServiceStationState()
									+"setServiceStationPincode"+trackOnMapDtoRes.getServiceStationPincode()
									+"Latitude"+trackOnMapDtoRes.getLatitude()
									+"Longitude"+trackOnMapDtoRes.getLongitude()
									+"DeliveryDate"+trackOnMapDtoRes.getDeliveryDate()
									+"DeliveryTime"+trackOnMapDtoRes.getDeliveryTime()
									+"Empoyee code"+trackOnMapDtoRes.getEmployeeCode()
									+"Status code"+trackOnMapDtoRes.getStatusCode()
									);
							trackOnMapDtosList.add(trackOnMapDtoRes);
						}
						trackOnMapServiceStationDto.setMapType(Constants.TRACK_ON_MAP_NETWORKMAP);
						trackOnMapServiceStationDto.setServiceStationsList(trackOnMapDtosList);
					}
					
					return trackOnMapServiceStationDto;
					
				} catch (Exception exception) {
					log.error("EXCEPTION TYPE :",exception);
					log.error("----------trackOnMap---------"+exception.getMessage());
					throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
				}finally{
					log.debug("----------trackOnMap finally---------");
					CloseConnections.closeResultSet(rs);
					CloseConnections.closeCallableStatement(callableStatement);
				}
				}
				
				
			});
		} catch (Exception exception) {
			log.error("EXCEPTION TYPE :",exception);
			log.error(exception.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return trackOnMapServiceStationDto;
	}
	
	/**
	 * 
	 */
	@Transactional
	@Override
	public Integer intimateMe(List<String> awbNos, String emailId, String loginId, String ipAddress, String awbNoMis) {
		String[] listOfValidAwbNos = null;
		Integer retValue = -1;
		if (!StringUtils.isNullOrEmpty(awbNos)) {
			listOfValidAwbNos = awbNos.toArray(new String[awbNos.size()]);
		}
		
		try{
			retValue = intimateMe(listOfValidAwbNos, emailId);
			if (null != loginId && loginId.trim().length() > 0 && !"null".equalsIgnoreCase(loginId)) {
				saveMIS(Constants.INTIMATE_ME, loginId);
			} else {
				saveMISWithOutLogin(Constants.INTIMATE_ME, null, ipAddress, awbNoMis, "");
			}
		}catch(DataBaseException blueDartException){
			log.error("EXCEPTION TYPE :",blueDartException);
			//log.error(blueDartException);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		
		return retValue;
	}
	
	/**
	 * 
	 * @param awbnos
	 * @param emailId
	 * @param loginId
	 * @return
	 */
	@Transactional
	public Integer intimateMe(String[] awbnos, String emailId) {
		Properties properties = new Properties();
		
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.PROCEDURE_PROPERTIES));
		} catch (IOException e) {
			log.error("EXCEPTION TYPE :",e);
			log.error(e.getMessage());
			throw new DataBaseException(ErrorMessageStatusCode.UNEXPECTED_ERROR.getCode(),
					ErrorMessageStatusCode.UNEXPECTED_ERROR.getDescription());
		}

		int retValue = -1;
		try {
			retValue = getSession().doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					CallableStatement callableStatement = null;
					int retValue = -1;
					try{
					ArrayDescriptor descAwbnoList = ArrayDescriptor
							.createDescriptor(properties.getProperty(Constants.NUMLIST), connection);
					ARRAY awbnoList = new ARRAY(descAwbnoList, connection, awbnos);
					callableStatement = connection
							.prepareCall("{call tnt_mang_new.intimateMe(?,?,?)}");
					callableStatement.clearParameters();

					((OracleCallableStatement) callableStatement).setArray(1, awbnoList);
					((OracleCallableStatement) callableStatement).setString(2, emailId);
					((OracleCallableStatement) callableStatement).registerOutParameter(3, Types.INTEGER);
					callableStatement.execute();

					retValue = ((OracleCallableStatement) callableStatement).getInt(3);
					
					
					return retValue;
				
					}catch (Exception exception) {
						log.error("EXCEPTION TYPE :",exception);
						log.error("----------intimateMe---------"+exception.getMessage());
						throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),	ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
					}finally{
						log.debug("----------intimateMe finally---------");
						CloseConnections.closeCallableStatement(callableStatement);
					}
					}
			});
		} catch (DataBaseException exception) {

			log.error("EXCEPTION TYPE :",exception);
			//log.error(exception);
			throw new DataBaseException(ErrorMessageStatusCode.DATABASE_DOWN.getCode(),
					ErrorMessageStatusCode.DATABASE_DOWN.getDescription());
		}
		return retValue;
	}
	
}
