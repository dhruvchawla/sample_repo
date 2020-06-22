package com.bluedart.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author DH839598
 *
 */
public final class Constants {

	
	private Constants() {
	}

	public static final String EXT_WEBSERVICE_PROPERTIES = "ext-webservice.properties";
	public static final String PROCEDURE_PROPERTIES = "procedure.properties";
	public static final String SHIPOBJ = "SHIPOBJ";
	public static final String SHIPMENT_DTO = "com.bluedart.common.dto.ShipmentDto";
	public static final String PODOBJ = "PODOBJ";
	public static final String POD_DTO = "com.bluedart.common.dto.PodDto";
	public static final String PODLIST = "PODLIST";
	public static final String SHIPLIST = "SHIPLIST";
	public static final String NUMLIST = "NUMLIST";
	
	public static final String SHIPMENTS_DTO = "com.bluedart.trackdart.dto.ShipmentsDto";
	public static final String SHIPOBJS = "SHIPOBJ_DC";
	public static final String SHIPLISTS = "SHIPLIST_DC";

	public static final String COMMA_DELIMETER = ",";

	public static final String DASH_LINE = "------------------------------------";

	public static final String NEW_LINE = "\n";

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String DEFAULT_FORMAT = "dd MMM yyyy";

	public static final String MONTH_FORMAT = "MM";

	public static final String YEAR_FORMAT = "YYYY";

	// --------------------------------------Transit Time Price
	// Finder--------------------------------------------
	public static final String PRODCODE_DOMESTIC = "D";
	public static final String PRODCODE_APEX = "A";
	public static final String PRODCODE_EXPRESS = "E";
	public static final String PRODCODE_INTERNATIONAL = "I";

	public static final String FEATURE_NAME_FINDER_INTERNATIONAL = "LOCATION_FINDER_INTERNATIONAL";
	public static final String FEATURE_NAME_FINDER_DOMESTIC_LOCATION = "LOCATION_FINDER_DOMESTIC_LOCATION";
	public static final String FEATURE_NAME_FINDER_RATE_TRANSIT = "RATE_AND_TRANSIT_FINDER";

	public static final String BASE_PRODUCT_DOCUMENT = "Document";
	public static final String BASE_PRODUCT_AIR_PACKAGE = "Air package";
	public static final String BASE_PRODUCT_GROUND_PACKAGE = "Ground packages";
	public static final String BASE_PRODUCT_INTERNATIONAL_NONDOCUMENTS = "International Non-Documents";
	public static final String BASE_PRODUCT_INTERNATIONAL_DOCUMENTS = "International Documents";
	public static final String INDIA_COUNTRYCODE = "IN";

	public static final String DUMMY_PRODTYPE = "2";
	public static final String DUMMY_INSURANCE = "O";
	public static final String DUMMY_CUSTOMERCODE = "000000";
	public static final String PRODUCTTYPE_1 = "1";

	// --------------------------------------------------------------------------------------------------------------

	public static final String FEATURE_NAME_MANAGE_USER_CREATEUSER = "MANAGE_USER_CREATEUSER";
	public static final String FEATURE_NAME_MANAGE_USER_EDITUSER = "MANAGE_USER_EDITUSER";
	public static final String FEATURE_NAME_MANAGE_USER_DELETEUSER = "MANAGE_USER_DELETEUSER";
	public static final String FEATURE_NAME_MANAGE_USER_VIEWUSER = "MANAGE_USER_VIEWUSER";
	public static final String FEATURE_NAME_MANAGE_USER_RESET_PWD = "MANAGE_USER_RESETPASSWORD";

	public static final String FEATURE_CORPORATE_REGISTRATION = "CORPORATE_REGISTRATION";
	public static final String FEATURE_CORPORATE_FORGOT_PASSWORD = "CORPORATE_FORGOT_PASSWORD";
	public static final String FEATURE_CORPORATE_CHANGE_PASSWORD = "CORPORATE_CHANGE_PASSWORD";

	public static final String FINDER_ORIGIN_ERRORCODE = "511";
	public static final String FINDER_ORIGIN_ERROR_MSG = "OriginNotServiceable";
	public static final String FINDER_DESTINATION_ERRORCODE = "512";
	public static final String FINDER_DESTINATION_ERROR_MSG = "DestinationNotServiceable";
	public static final String FINDER_DESTINATION_INTL_ERRORCODE = "519";
	public static final String FINDER_PINCODE_ERRORCODE = "503";
	public static final String FINDER_DB_ERROR = "520";
	public static final String FINDER_DB_ERROR_MSG = "DB Error";
	public static final String FINDER_INPUT_ERRORCODE = "515";
	public static final String FINDER_INPUT_ERROR_MSG = "INPUT ERROR";
	public static final String FINDER_C2PC_INSTANTIATION_ERROR = "100";
	public static final String FINDER_C2PC_ILLEGALACCESS_ERROR = "101";
	public static final String FINDER_C2PC_REMOTE_ERROR = "102";
	public static final String FINDER_C2PC_INVALID_PINCODE_ERROR = "503";
	public static final String[] CITIES_SET_VALUES = new String[] { "CALCUTTA", "MUMBAI", "BOMBAY", "NEW DELHI",
			"NEW_DELHI", "DELHI", "MADRAS", "HYDERABAD", "CHENNAI", "BANGALORE", "AHMEDABAD", "HYDERABAD" };
	public static final Set<String> FINDER_AIRPORT_CITIES_SET = new HashSet<String>(Arrays.asList(CITIES_SET_VALUES));

	public static final String TNT_DELIVERED = "DL";
	public static final String TNT_INTRANSIT = "IT";
	public static final String TNT_RTO = "RT";
	public static final String TNT_REDIRECTED = "RD";
	public static final String TNT_UNDELIVERED = "UD";
	public static final String TNT_NOTFOUND = "NF";
	public static final String TNT_NOINFO = "NI";

	public static final String CORP_USERTYPE = "CREDIT_CUST";
	public static final String UNREG_CORP_ADMIN = "UNREGISTERED";
	public static final String REG_FLAG_NO = "N";
	public static final Integer FEATURE_ID_TRACKTRACE = 27;
	public static final Integer FEATURE_ID_DOWNLOADS = 31;
	public static final String CUST_REG_DB_FAULTCODE = "300";
	public static final String CUST_REG_IO_FAULTCODE = "301";
	public static final String FORGOT_PWD_DB_FAULTCODE = "302";
	public static final String CHANGE_PWD_DB_FAULTCODE = "303";
	public static final String ClIENTADMIN_DB_ERRORCODE = "600";
	public static final String DB_DOWN_ERROR_CODE = "701";

	public static final String CONTACTUS_FEEDBACK_APPRECIATION = "FEEDBACK_APPRECIATION";
	public static final String CONTACTUS_FEEDBACK_COMPLAINT = "FEEDBACK_COMPLAINT";
	public static final String CONTACTUS_FEEDBACK_WRITE_TO_US = "FEEDBACK_WRITE_TO_US";

	public static final String TRACK_AND_TRACE = "TRACK_AND_TRACE";
	public static final String INTERNET_DART_DATA = "INTERNET_DART_DATA";
	public static final String INTERNET_DART_REPORT = "INTERNET_DART_REPORT";
	public static final String INTERNET_DART_EXCEL = "INTERNET_DART_EXCEL";
	public static final String INTERNET_DART_VIEW_ONLINE = "INTERNET_DART_VIEW_ONLINE";
	public static final String INTERNET_DART_REPORT_DOWNLOAD = "INTERNET_DART_REPORT_DOWNLOAD";
	public static final String SECURITY_LEVEL = "SECURITY_LEVEL";
	public static final String INTIMATE_ME = "INTIMATE";

	public static final String SUCESSCODE = "200";
	public static final String SUCESSMESSAGE = "OK";
	public static final String RESULT="Lead Inserted Successfully";
	public static final String LOGS_STATUS = "LOG_STATUS";

	public static final String ACL_URL = "acl.url";
	public static final String ACL_URL_PATH = "acl.urlpath";

	public static final String EMAIL_CONFIGURATION__PROPERTIES = "emailConfig.properties";
	public static final String SCHEDULER_PROPERTIES = "scheduler.properties";
	public static final String BLUEDART_PROPERTIES = "bluedart.properties";

	public static final String CONTACTUS_COMPLAINT = "C";
	public static final String CONTACTUS_APPRECIATION = "A";
	public static final String CONTACTUS_SHIPPER = "S";
	public static final String CONTACTUS_CONGINEE = "C";
	public static final String CONTACTUS_NOT_IDENTIFIED = "TP";

	// --------------------InternetDart
	// Constants---------------------------------------
	public static final String INTERNETDART_REPORT = "REPORT";
	public static final String INTERNETDART_DATA = "DATA";
	public static final String INTERNETDART_DOWNLOAD = "DOWNLOAD";
	public static final String INTERNETDART_ONLINE = "ONLINE";
	public static final String INTERNETDART_DATA_VALIDATION = "DATA_VALIDATION";
	public static final String INTERNETDART_REPORT_VALIDATION = "REPORT_VALIDATION";
	public static final String INTERNETDART_PICKUPDATE = "PICKUPDATE";
	public static final String INTERNETDART_PUDATE = "PUDATE";
	public static final String INTERNETDART_AWBNO = "AWBNO";
	public static final String INTERNETDART_REFNO = "REFNO";
	public static final String INTERNETDART_ORGAREA = "ORGAREA";
	public static final String INTERNETDART_DSTAREA = "DSTAREA";
	public static final String INTERNETDART_CONSIGNEE = "CONSIGNEE";
	public static final String INTERNETDART_FALSEBOTH = "falseBoth";
	public static final String INTERNETDART_FALSEDEST = "falseDest";
	public static final String INTERNETDART_FALSEORG = "falseOrig";
	public static final String INTERNETDART_YES = "Y";
	public static final String INTERNETDART_NO = "N";
	public static final String INTERNETDART_QUERYASC = " ASC, AWBNO ASC";
	public static final String INTERNETDART_QUERYDESC = " DESC, AWBNO DESC";
	public static final String INTERNETDART_SORT = "PUDATE DESC, AWBNO DESC";

	public static final String INTERNETDART_QUERY_1 = "AND STAT.cstattype = S.cstattype ";
	public static final String INTERNETDART_QUERY_2 = "AND STAT.cstatcode = S.cstatcode ";

	public static final String INTERNETDART_UD_1 = "AND STAT.cstattype (+) = S.cstattype ";
	public static final String INTERNETDART_UD_2 = "AND STAT.cstatcode (+) = S.cstatcode ";

	// --------------------TracckDart Constants
	public static final String TRACKDART_HTML = "</td></tr>";
	public static final String TRACKDART_HTML1 = "</td><td>";
	public static final String EMPTYREC_MSG = "No Shipment found for following waybill number(s) : ";
	public static final String INVVALID_MSG = "Following waybill number(s) are Invalid : ";
	public static final String BD_MAIL = "response@bluedart.com";
	public static final String BD_MAIL_SUB = "Shipment Tracking Details";

	// Location Finder Constants
	public static final String NOT_A_VALID_INPUT = "Please provide a valid input. ";
	public static final String NULL_STRING = "null";
	public static final String EMPTY_STRING = "";
	public static final char Y = 'Y';
	public static final char N = 'N';
	public static final char I = 'I';
	public static final char C = 'C';
	public static final char Z = 'Z';
	public static final String I_STRING = "I";
	public static final String N_STRING = "N";
	public static final String O = "O";
	public static final String OYIY = "OYIY";
	public static final String ONIN = "ONIN";
	public static final String OYIN = "OYIN";
	public static final String ONIY = "ONIY";
	public static final String DELIVERY = "Delivery";
	public static final String INTERNATIONAL_PRIORITY_SERVICE_COL = "CIPSERV";
	public static final String APEX_PRIORITY_SERVICE_COL = "CAPESERV";
	public static final String STATE_COL = "CSTATE";

	// Track On Map Constants
	public static final String TRACK_ON_MAP_STATUS_OUTFORDELIVERY = "SOFD";
	public static final String TRACK_ON_MAP_GPS_URL = "https://www.fareye.co/api/v1/gps_tracking_history?api_key=IYGlfZ9YGCZmq884lmAL2eqCCr04oaML";
	public static final String TRACK_ON_MAP_GPS_URL_DATEFORMAT = "yyyy-MM-dd";
	public static final String TRACK_ON_MAP_GPS_URL_EMPCODE = "empCode=";
	public static final String TRACK_ON_MAP_GPS_URL_DATE = "date=";
	public static final String TRACK_ON_MAP_GPS_URL_AND = "&";
	public static final String TRACK_ON_MAP_GET_REQUEST = "GET";
	public static final String TRACK_ON_MAP_USER_AGENT = "User-Agent";
	public static final String TRACK_ON_MAP_NETWORKMAP = "network";
	public static final String TRACK_ON_MAP_LASTMILE = "lastMile";
	public static final String TRACK_ON_MAP_DSTATDATE = "dstatdate";
	public static final String TRACK_ON_MAP_CSTATCODE = "cstatcode";

	// AFFILIATE
	public static final String MANAGEUSERCA_AFFILIATESDTO = "com.bluedart.manageuserCA.dto.AffiliatesDto";
	public static final String BASE_AFF_FLAG = "Y";

	// -----------------SHIPDART---------------------------------------
	public static final String FILE_TYPE = "K";
	public static final String FILE_STATUS = "OK";
	public static final String SDMASTER = "SDMASTER.zip";
	public static final String PICKUP_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String TYPE = "T";

	public static final int AWBSTARTNO = 12;
	public static final int AWBENDNO = 12;
	public static final int ERRORCODE = 4;

	public static final String SHIPDART = "SHIPDART";
	public static final String SHIPDART_ERROR = "ERROR";
	public static final String SHIPDART_SUCCESS = "SUCCESS";
	public static final String LICENSE_ERROR = "License key mismatch";


	// -------------------------------- CA Manage Users ----------------------------- //

	public static final String CA_MODULE_NAME = "CLIENTADMIN";
	public static final String CA_ADMINFLAG = "CA";

	public static final String CA_LIST_USER_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.CA_GET_CORPLIST(?,?,?,?,?,?,?)}";
	public static final String CA_SEARCH_AFF_PROC = "{call UPROFILE4.aff_mang_bd_admin.searchAffiliates(?,?,?,?,?,?,?,?)}";
	public static final String CA_UPDATESTATUS_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.PRC_UPDATE_USER_STATUS(?,?,?,?,?,?,?)}";
	public static final String CA_EDIT_USER_PROC = "{call UPROFILE4.CA_EDIT_USER(?,?,?,?,?,?,?,?)}";
	public static final String CA_CREATE_PROC = "{call UPROFILE4.PKGCLIENT_CORPORATE.PrcCreateuser_updated(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	public static final String ALL_USERS = "ALL";
	
	public static final String FEATURE_CA_VIEW_USERS = "MANAGE_USER_VIEWUSER";
	public static final String FEATURE_CA_CREATE_USER = "MANAGE_USER_CREATEUSER";
	public static final String FEATURE_CA_EDIT_USER = "MANAGE_USER_EDITUSER";
	public static final String FEATURE_CA_UPDATE_STATUS = "MANAGE_USER_UPDATE_STATUS";
	public static final String FEATURE_CA_SEARCH_AFF = "MANAGE_USER_SEARCH_AFF";
	public static final String FEATURE_CA_ADD_AFF = "MANAGE_USER_ADD_AFF";
	public static final String FEATURE_CA_DEL_AFF = "MANAGE_USER_DEL_AFF";
	public static final String FEATURE_CA_AFF_PERMISSION = "MANAGE_USER_AFF_PERMISSION";
	public static final String FEATURE_CA_LOGIN_PERMISSION = "MANAGE_USER_LOGIN_PERMISSION";
	public static final String FEATURE_CA_RESET_PWD = "MANAGE_USER_RESETPASSWORD";
	
	
	public static final String CA_DEFAULT_STATUS = "FORCE";
	public static final String FEATURELIST = "FEATUREINLIST";
	
	// - POD INBOUND,OUTBOUND---------------------------------------

	public static final String SHIPMENT_DTO_POD = "com.bluedart.pod.dto.ShipmentDto";
	public static final String POD_DTO_POD = "com.bluedart.pod.dto.PodObjDto";
	public static final String SPSOBJ = "SPSOBJ";
	public static final String PRODUCTOBJ = "PRODUCTOBJ";
	public static final String PACKTYPE_OBJ = "PACKTYPE_OBJ";

	public static final String SPSLIST = "SPSLIST";
	public static final String PRODLIST = "PRODLIST";
	public static final String PACKLIST = "PACKLIST";
	public static final String SpslistDTO = "com.bluedart.pod.dto.SpslistDTO";
	public static final String ProdlistDTO = "com.bluedart.pod.dto.ProdlistDTO";
	public static final String PacklistDTO = "com.bluedart.pod.dto.PacklistDTO";

	public static final String E_BUSINESS_SOLUTIONS = "E_BUSINESS_SOLUTIONS";

	public static final String TRACK = "track";
	public static final String INTIMATEME = "intimateme";
	public static final String AUTOSORRY = "autosry";

	// -----------------------------------------------------------------------------------

	public static final String MAILDART_AWBQUERYSCHEDULER = "MAILDART_AWBQUERYSCHEDULER";
	public static final String MAILDART_REFQUERYSCHEDULER = "MAILDART_REFQUERYSCHEDULER";
	public static final String MAILDART_INTIMATEMESCHEDULER = "MAILDART_INTIMATEMESCHEDULER";
	public static final String DB_DOWN_ERROR_MESSAGE = "The service is temporarily unavailable! Try again later.";

	// ---------------SP and BS--------------------------------------------
	public static final String ROUTECODE = "99";
	public static final String DELIVERY_TIME_SLOT = "{call UPROFILE4.PACK_SPBS.GET_TIMESLOT(?,?)}";
	public static final String RISKDETAIL = "{call UPROFILE4.PACK_SPBS.GET_RISK(?,?,?)}";
	public static final String UPDATE_COUNT = "{call UPROFILE4.PACK_SPBS.UPDATE_MSTLY_COUNT(?,?,?,?,?,?)}";
	public static final String VALIDATE_PINCODE = "{call UPROFILE4.PACK_SPBS.VALIATE_PINCODE(?,?,?,?)}";
	public static final String EMAIL_SUB = "Pickup Confirmed";
	public static final String EMAIL_TEMPLATE = "pickup-template.vm";
	
	
	public static final String PACKLIST_SPBS = "UPROFILE4.PACKLIST";
	public static final String PAPERWRKLIST = "UPROFILE4.PAPERWRKLIST";
	public static final String PACKOBJ = "UPROFILE4.PACKTYPE_OBJ";
	public static final String PAPERWORKOBJ = "UPROFILE4.PAPERWRKOBJ"; 
	public static final String VALUE_ADDED_SERVICE_DTO = "com.bluedart.scheduleapickupbookashipment.dto.ValueAddedServiceDto";
	public static final String PAPER_WORK_DTO = "com.bluedart.scheduleapickupbookashipment.dto.PaperWorkDto";

	// --------------------Address Book----------------------------- //
	public static final String FEATURE_NAME_ADDRESS_BOOK = "ADDRESS_BOOK";
	
	public static final String SP_GET_PINCODE = "{call UPROFILE4.PACK_ADDRESS_BOOK.SP_GET_PINCODE(?,?)}";
	public static final String PININFO_PROC = "{call UPROFILE4.LOC_FINDER_NEW.pininfo_list(?,?)}";
	public static final String DEFAULT_MOSTLYUSEDADDRESS_PROC = "{call UPROFILE4.PACK_ADDRESS_BOOK.GET_DEFLT_MSTLY_ADDRESS(?,?,?,?,?,?)}";
	public static final String GET_CONSIGNEE_ADDRESS_PROC = "{call UPROFILE4.PACK_ADDRESS_BOOK.GET_ADDRESS_CONSIGNEE(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String GET_SHIPPER_ADDRESS_PROC = "{call UPROFILE4.PACK_ADDRESS_BOOK.GET_ADDRESS_SHIPPER(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String SEARCH_ADDRESS_PROC = "{call UPROFILE4.PACK_ADDRESS_BOOK.GET_SEARCH_ADDRESS(?,?,?,?,?)}";
	public static final String IMPORTADDRESS_LIST="IMPORTADDRESS_LIST";
	public static final String IMPORT_ADDRESS_PROC = "{call UPROFILE4.PACK_ADDRESS_BOOK.IMPORT_ADDRESSES(?,?,?,?,?)}";
	public static final String ADDRESSBOOK_IMPORT_DTO = "com.bluedart.addressbook.dto.AddressBookImportDetailDto";
	public static final String IMPORT_ADDRESS_OBJ = "IMPORT_ADDRESS_OBJ";
	public static final String MOSTLYADDRESSCOUNT = "MOSTLYADDRESSCOUNT";
	public static final String GET_AFFILIATE_PERMISSION = "{call UPROFILE4.PACK_ADDRESS_BOOK.GET_AFF_PERMISSION(?,?,?,?,?,?)}"; 
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String SHIPPER = "S";
	public static final String CONSIGNEE = "C";
	public static final String YES = "Y";
	public static final String COUNTRYCODE_IN = "IN";
	public static final String COUNTRY_INDIA = "INDIA";
	public static final String PINCODE_FORMAT = "PincodeFormat";
	
	public static final String NO_OF_ADDRESS_TO_MANAGE = "NUMBER_OF_ADDRESS_TO_MANAGE";
	public static final String PERMISSION_NAME = "Permission_Name";
	public static final String SUB_PERMISSION_NAME = "SUB_PERMISSION_NAME";
	public static final String PERMISSION_VALUE = "Permission_Value";
	public static final String ERROR_OCCURED = "Error Occured";
		
		//-----------------pod---------------------------------------//
		public static final String SHIPOBJ_POD = "SHIPOBJ_POD";
		public static final String SHIPLIST_POD = "SHIPLIST_POD";
		public static final String SERVICE_DOWN = "Service Down";
		
		public static final String POD_USER_INBOUND = "{call UPROFILE4.POD_MANG_TRACK_TRACE.TRACKPODINBOUND(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,? )}";
		public static final String PARCEL_INBOUND = "{call UPROFILE4.POD_MANG_TRACK_TRACE.trackParcelInBound(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,? )}";
		
		public static final String PODMAIL_OBJ = "PODMAIL_OBJ";
		public static final String PODMAIL_OBJ_DTO = "com.bluedart.autopod.dto.PodMailObjDto";
		
		public static final String PODMAIL_LIST = "UPROFILE4.PODMAIL_LIST";
		public static final String FEATURE_AUTOPOD = "AUTOPOD";
		
		//------------------------------------MANAGE PARCEL SHOP POD USERS--------------------------------------------------------------------
		
		public static final String FEATURE_NAME_MANAGE_PARCELSHOP_POD_USERS = "MANAGE_PARCEL_SHOP_POD_USERS";
		public static final String AT = "@";
		public static final String FETCH_PARCELSHOPS_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.GET_PARCELSHOPS(?,?,?,?)}";
		public static final String GENERIC_VARCHAR_TYPE =  "UPROFILE4.GENERIC_VARCHAR_TYPE";
		public static final String NULL = "null";
		public static final String FETCH_SERVICECENTERS_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.GET_SERVICECENTERS(?,?,?,?,?)}";
		public static final String USERTYPE_POD_USER = "POD_USER";
		public static final String USERTYPE_PARCEL = "PARCEL";
		public static final String UPROFILE4_PARCELSHOPOBJ = "UPROFILE4.PARCELSHOPOBJ";
		public static final String UPROFILE4_PARCELSHOPPODUSER_DTO = "com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUsersDbObjectDto"; 
		public static final String PARCELSHOPOBJ_PROPERTY= "PARCELSHOPOBJ";
		public static final String CREATE_PARCELSHOPPODUSER_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.CREATE_PS_POD_USER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		public static final String PARCELSHOP_LIST = "UPROFILE4.PARCELSHOPLIST";
		public static final String SUCCESS_STRING = "SUCCESS";
		public static final String FAILURE_STRING = "FAILURE";
		public static final String CREATE_USER_ACTION  = "CREATE_USER";
		public static final String MODULE_NAME_MANAGEPARCELSHOPPODUSERS  = "Manage Parcel Shop POD Users";
		public static final String EMAIL_SUCCESS  = "EMAIL SUCCESS";
		public static final String EMAIL_FAILURE  = "EMAIL FAILURE";
		public static final String NO_EMAIL_REQUIRED  = "NO EMAIL REQUIRED";
		public static final String STRING_N  = "N";
		public static final String STRING_Y = "Y";
		public static final String STRING_RAND1 = "\\[";
		public static final String STRING_RAND2 = "\\]";
		public static final String STRING_RAND3 = "\\s+";
		public static final String GET_PARCELSHOP_POD_USERDETAILS_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.GET_PS_POD_USERDETAILS(?,?,?,?,?,?)}";
		public static final String DEACTIVATE_USER_ACTION = "DEACTIVATE_USER";
		public static final String REACTIVATE_USER_ACTION = "REACTIVATE_USER";
		public static final String UNABLE_TO_DEACTIVATE = "UNABLE TO DEACTIVATE";
		public static final String UNABLE_TO_REACTIVATE = "UNABLE TO REACTIVATE";
		public static final String GET_LIST_PARCELSHOP_POD_USERS_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.GET_PS_POD_USERSLIST(?,?,?,?,?,?,?,?,?)}";
		public static final String UPDATE_PARCELSHOP_POD_USER_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.UPDATE_PS_POD_USER(?,?,?,?,?,?,?,?,?,?,?,?)}";
		public static final String UPDATE_USER_ACTION="UPDATE_USER";
		public static final String UPDATE_SUCCESS = "UPDATE SUCCESS";
		public static final String UPDATE_FAIL = "UPDATE FAIL";
		public static final String LEFT_ROUND_BRACKET = "(";
		public static final String RIGHT_ROUND_BRACKET = ")";
		public static final String SINGLE_QUOTE = "'";
		public static final String SINGLE_QUOTE_COMMA = "',";
		public static final String GET_AREAS_PROCEDURE = "SELECT DISTINCT CREGION,CAREA,CAREADESC FROM areamst WHERE CREGION in ";
		public static final String GET_AUDITLOG_SEQUENCE = "select UPROFILE4.BD_AUDIT_LOG_VALUES_SEQ.NEXTVAL FROM DUAL";
		public static final String UPROFILE4_AUDITLIST = "UPROFILE4.AUDITLIST";
		public static final String UPROFILE_AUDITOBJ = "UPROFILE4.AUDITOBJ";
		public static final String PARCELSHOP_POD_AUDIT_DETAILS_DTO = "com.bluedart.manageparcelshoppodusers.dto.ManageParcelShopPODUserAuditDetails";
		public static final String AUDIT_LOG_PROCEDURE = "{call UPROFILE4.PACK_AUDIT_LOG.SAVE_AUDIT_LOG(?,?)}";
		public static final String DELETE_AUDIT_LOG_RECORDS_QUERY = "delete from uprofile4.bd_audit_log where cid in (";
		public static final String DEACTIVATE_REACTIVATE_PARCELSHOP_POD_USER_PROCEDURE = "{call UPROFILE4.PACK_MANAGE_PARCELSHOP_POD.DEACTIVATE_REACTIVATE_PS_POD(?,?,?,?,?,?,?,?,?)}";
		public static final String FROM_EMAIL_ID = "fromEmailId";
		public static final String NO_CHANGE = "NO CHANGE";
		public static final String POD_STRING = "POD";
		public static final String PARCEL_SHOP_STRING = "parcel shop";
		public static final String DEACTIVATE_PARCELSHOP_USER_EMAIL_SUBJECT = "manageparcelshoppouser.deactivateuserparcel.subject";
		public static final String DEACTIVATE_POD_USER_EMAIL_SUBJECT = "manageparcelshoppouser.deactivateuserpod.subject";
		public static final String DEACTIVATE_PARCELSHOP_POD_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.deactivateuser.template";
		public static final String REACTIVATE_PARCELSHOP_USER_EMAIL_SUBJECT = "manageparcelshoppouser.reactivateuserparcel.subject";
		public static final String REACTIVATE_POD_USER_EMAIL_SUBJECT = "manageparcelshoppouser.reactivateuserpod.subject";
		public static final String REACTIVATE_PARCELSHOP_POD_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.reactivateuser.template";
		public static final String CREATE_PARCELSHOP_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT = "manageparcelshoppouser.createuserlogincredentialsparcel.subject";
		public static final String CREATE_POD_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT = "manageparcelshoppouser.createuserlogincredentialspod.subject";
		public static final String CREATE_PARCELSHOP_POD_USER_EMAIL_LOGIN_CREDENTIALS_TEMPLATE = "manageparcelshoppouser.createuserlogincredentials.template";
		public static final String CREATE_PARCELSHOP_USER_EMAIL_SUBJECT = "manageparcelshoppouser.createuserparcel.subject";
		public static final String CREATE_POD_USER_EMAIL_SUBJECT = "manageparcelshoppouser.createuserpod.subject";
		public static final String CREATE_PARCELSHOP_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.createuserparcel.template";
		public static final String CREATE_POD_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.createuserpod.template";
		public static final String UPDATE_PARCELSHOP_USER_EMAIL_SUBJECT = "manageparcelshoppouser.updateuserparcel.subject";
		public static final String UPDATE_POD_USER_EMAIL_SUBJECT = "manageparcelshoppouser.updateuserpod.subject";
		public static final String UPDATE_PARCELSHOP_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.updateuserparcel.template";
		public static final String UPDATE_POD_USER_EMAIL_TEMPLATE = "manageparcelshoppouser.updateuserpod.template";
		public static final String ADMIN_SITE_URL = "http://www.bluedart.com";
		public static final String REACTIVATE_PARCELSHOP_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT = "manageparcelshoppouser.reactivateuserlogincredentialsparcel.subject";
		public static final String REACTIVATE_POD_USER_EMAIL_LOGIN_CREDENTIALS_SUBJECT = "manageparcelshoppouser.reactivateuserlogincredentialspod.subject";
		public static final String REACTIVATE_PARCELSHOP_POD_USER_EMAIL_LOGIN_CREDENTIALS_TEMPLATE = "manageparcelshoppouser.reactivateuserlogincredentials.template";
		
		// ----------------------SPBS--------------------------------//
		public static final String ADVANCED_SEARCH = "{call UPROFILE4.PACK_SPBS.GET_ADVANCED_SEARCH(?,?,?,?,?,?,?,?,?,?,?)}";
		public static final String CBATCHNO = "5599";
		public static final String COMMODITY_CODE = "000";
		public static final String CUST_CODE = "099960";
		public static final String DOCUMENT_PRODTYPE = "1";
		public static final String NON_DOCUMENT_PRODTYPE = "2";
		public static final String INTERNATIONAL_PRODCODE = "I";
		public static final String DOCUMENT_PRODCODE = "D";
		public static final String INTERNATIONAL_NON_DOCUMENT_PRODCODE = "InND";
		public static final String INTERNATIONAL_DOCUMENT_PRODCODE = "InD";
		
		
		public static final String DATABASE_PROPERTY = "database_file";
		
		public static final String scheduler_prop_file = "scheduler_prop_file";
		public static final String SCHEDULERS ="SCHEDULERS";
		public static final String AwbQuerySchedulerRUNFLAG = "AwbQuerySchedulerRUNFLAG";
		public static final String RefQuerySchedulerRUNFLAG = "RefQuerySchedulerRUNFLAG";
		public static final String IntimateMeSchedulerRUNFLAG = "IntimateMeSchedulerRUNFLAG";
		public static final String SMSSchedulerRUNFLAG = "SMSSchedulerRUNFLAG";
		public static final String PODMAILSchedulerRUNFLAG = "PODMAILSchedulerRUNFLAG";
		
		
		public static final String pop3Port ="pop3Port";
		public static final String pop3Host ="pop3Host";
		
		
		public static final String trackUser ="trackUser";
		public static final String trackPassword ="trackPassword";
		public static final String trackFromAddr="trackFromAddr";
		
		public static final String refUser ="refUser";
		public static final String refPassword ="refPassword";
		public static final String refFromAddr = "refFromAddr";
		
		public static final String intimateMeUser ="intimateMeUser";
		public static final String intimateMePassword = "intimateMePassword";
		public static final String intimateMeFromAddr ="intimateMeFromAddr";
		
		public static final String SMSUID = "SMSUID";
		public static final String PWD = "PWD";
		public static final String SMSAPPID = "SMSAPPID";
		public static final String SMSSUBAPPID = "SMSSUBAPPID";
		public static final String ACLHOST = "ACLHOST";
		
		
		public static final String podMailSchedulerPath = "podMailSchedulerPath";
		
		public static final String SCHEDULE_PICKUP = "SCHEDULE_PICKUP";
		public static final String BOOK_SHIPMENT = "BOOK_SHIPMENT";
		public static final String TRACKINGAPI ="TRACKINGAPI";
		public static final String NEW_USER_REGISTRATION = "NEW_USER_REGISTRATION";
		//public static final String BILLS_AND_PAYMENT = "BILLS_AND_PAYMENT";
		public static final String LOGGED_IN_USER ="LOGGED_IN_USER";
		public static final String BACK_END_SUPPORT ="BACK_END_SUPPORT";
		public static final String MANAGEUSER_VIEW_PROFILE ="MANAGEUSER_VIEW_PROFILE";
		
		public static final String DELIVERED_AUTOPODSCHEDULER = "DELIVERED_AUTOPODSCHEDULER";
		public static final String UNDELIVERED_AUTOPODSCHEDULER = "UNDELIVERED_AUTOPODSCHEDULER";
		public static final String OVERRIDE_AUTOPODSCHEDULER = "OVERRIDE_AUTOPODSCHEDULER";
		
		
		public static final String INVOICE_LISTING ="INVOICE_LISTING";
		public static final String STATEMENT_OF_OUTSTANDING ="STATEMENT_OF_OUTSTANDING";
		public static final String STATEMENT_OF_ACCOUNTS ="STATEMENT_OF_ACCOUNTS";
		public static final String USER_REGISTERATION="USER_REGISTERATION";
}
