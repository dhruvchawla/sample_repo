package com.bluedart.utils;

/**
 * 
 * @author PR334023
 *
 */
public final class BDAdminConstants {

	private BDAdminConstants(){}
	
	// ------------------------ BD admin - Manage Admin & Corporate Users Constants-------------------------------------//
	
	public static final String FLAG_ENABLED = "Y";
	public static final String FLAG_DISABLED = "N";
	public static final String CTYPE = "D";
	public static final String ADMINOBJ = "ADMINOBJ";
	public static final String ADMINOBJLIST="ADMINOBJLIST";
	public static final String AFFOBJ = "AFFOBJ";
	public static final String ADMIN_DTO = "com.bluedart.bdmanageadminusers.dto.AdminDetailDto";
	public static final String GENERIC_VARCHAR_TYPE="GENERIC_VARCHAR";
	public static final String AFFOBJ_BD_ADMIN = "AFFOBJ_BD_ADMIN";
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
	public static final String ADD_EMAIL_DATA = "ADD_EMAIL_DATA";
	public static final String NO_DATA = "NO_DATA";
	public static final String AFF_DTO = "com.bluedart.common.dto.AffiliateDetailDto";
	public static final String AFFLIST = "AFFLIST";
	public static final String AFFLIST_BD_ADMIN = "AFFLIST_BD_ADMIN";
	public static final String USERSOBJ = "USERSOBJ";
	public static final String USERSLIST = "USERSLIST";
	public static final String PERMISSIONMPNGOBJ="PERMISSIONMPNGOBJ";
	public static final String PERMISSIONMPNGLIST="PERMISSIONMPNGLIST";
	public static final String PERMISSIONMPNGLIST_CAS = "PERMISSIONMPNGLIST_CAS";
	public static final String PERMISSIONMPNGOBJ_CAS = "PERMISSIONMPNGOBJ_CAS";
	public static final String PERMISSION_DTO = "com.bluedart.common.dto.PermissionDto";
	public static final String USERSOBJ_DTO = "com.bluedart.common.dto.CorporateUserDto";
	public static final String EMAIL_NOTIFY_DTO= "com.bluedart.bdmanageadminusers.dto.EmailNotifyValuesRecord";
	public static final String AUDIT_DTO= "com.bluedart.common.dto.AdminAuditDetails";
	public static final String AUDITLIST = "UPROFILE4.AUDITLIST";
	public static final String AUDITOBJ = "UPROFILE4.AUDITOBJ";
	
	public static final String BD_MODULE_NAME="BDADMIN";
	
	//--------------------------------------------------------------------------------------------------------------//
	
	public static final String GET_ADMINS_LIST_PROC="{call UPROFILE4.PACK_MANAGEUSERS.GET_ADMINLIST(?,?,?,?,?,?,?,?,?,?)}";
	public static final String VALIDATE_EMPCODE_PROC="{call UPROFILE4.PACK_MANAGEUSERS.VALIDATE_EMPCODE(?,?,?,?,?,?,?)}";  
	public static final String CREATE_ADMIN_PROC="{call UPROFILE4.PACK_MANAGEUSERS.CREATE_ADMIN_USERS(?,?,?,?,?,?,?)}";
	public static final String UPDATE_ADMIN_PROC="{call UPROFILE4.PACK_MANAGEUSERS.UPDATE_ADMIN_USERS(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CREATE_SUPERADMIN_PROC="{call UPROFILE4.PACK_MANAGEUSERS.CREATE_SUPER_ADMIN(?,?,?,?,?)}";
	
	public static final String CORP_LIST_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.GET_USERSLIST_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	public static final String 	VALIDATE_USER_CREATION_PROC = "{call uprofile4.PACK_MANAGEUSERS.VALIDATE_CREATE_CUSTOMER(?,?,?,?,?,?,?,?)}";
	public static final String CREATE_CUSTOMER_PROC = "{call uprofile4.PACK_MANAGEUSERS.CREATE_CUSTOMER(?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String EDIT_CUSTOMER_PROC = "{call uprofile4.PACK_MANAGEUSERS.update_corp_user(?,?,?,?,?,?,?)";
	
	public static final String CORP_RESET_PWD = "{call UPROFILE4.PACK_MANAGEUSERS.RESETPASSWORD_BD_ADMIN(?,?,?,?,?,?)}";
	
	public static final String SAVE_LOGIN_PERMISSION_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.SAVE_LOGIN_PERMISSION(?,?,?,?,?,?,?,?,?)}";
	public static final String CASCADE_LOGIN_PER_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.CASCADE_LOGIN_PERMISSION(?,?,?,?,?,?,?,?,?)}";
	
	public static final String  GET_AFFILIATES_PROC = "{call uprofile4.aff_mang_bd_admin.getAffiliates(?,?,?,?,?,?)}";
	
	public static final String  GET_AFFILIATES_PROC_V1 = "{call uprofile4.aff_mang_bd_admin.getAffiliates_V1(?,?,?,?,?,?,?)}";
	
	public static final String GET_AFF_USERS_PROC = "{call UPROFILE4.aff_mang_bd_admin.get_user_add_affiliates(?,?,?,?)}";
	public static final String ADD_AFFILIATES_PROC = "{call UPROFILE4.AFF_MANG_BD_ADMIN.addAffiliates_V1(?,?,?,?,?,?)}";
	
	public static final String DEL_AFFILIATES_PROC = "{call UPROFILE4.aff_mang_bd_admin.delAffiliates(?,?,?,?)}";
	
	public static final String GET_AFF_PER_USERS_PROC = "{call UPROFILE4.aff_mang_bd_admin.get_aff_users_permission(?,?,?,?,?,?)}";
	public static final String GET_AFF_PERM_PROC = "{call UPROFILE4.pack_manageusers.get_affiliate_permission(?,?,?,?)}";
	
	public static final String CASCADE_AFF_PER_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.CASCADE_AFF_PERMISSION(?,?,?,?,?,?,?,?,?)}";
	public static final String SAVE_AFF_PERM_PROC="{call UPROFILE4.pack_manageusers.save_affiliate_permission(?,?,?,?,?,?,?,?,?)}";
	
	public static final String GET_LOGIN_PERM_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.GET_LOGIN_PERMISSION(?,?)}";
	public static final String GET_LOGINPERM_USERS_PROC = "{call UPROFILE4.PACK_MANAGEUSERS.GET_LOGINPERMSN_USERS(?,?,?,?)}";
	
	public static final String GET_CORP_USERS_PROC="{call UPROFILE4.PACK_MANAGEUSERS.PRC_GET_CORPORATE_USERS(?,?,?)}";
	public static final String UPDATE_STATUS_PROC="{call UPROFILE4.PACK_MANAGEUSERS.PRC_UPDATE_USER_STATUS(?,?,?,?,?,?,?)}";
	public static final String ADMIN_UPDATE_STATUS="{call uprofile4.PACK_MANAGEUSERS.ADMIN_UPDATE_STATUS(?,?,?,?,?,?)}";
	
	public static final String SAVE_AUDIT_PROC = "{call UPROFILE4.PACK_AUDIT_LOG.SAVE_AUDIT_LOG(?,?)}";
	public static final String AUDIT_SEQ_QUERY = "select UPROFILE4.BD_AUDIT_LOG_VALUES_SEQ.NEXTVAL FROM DUAL";
	
	//------------------------------------------Notification Constatnts---------------------------------------------------------------//
	public static final String INSERT_EMAIL_NOTIFICATION = "{call UPROFILE4.PACK_MANAGEUSERS.INSERT_EMAIL_NOTIFICATION(?,?,?,?,?,?,?)}";
	public static final String EMAIL_VALUE_OBJ = "EMAIL_VALUE_OBJ";
	public static final String EMAILLIST = "EMAIL_LIST";
	public static final String EMAIL_VAL_SQLTYPE= "UPROFILE4.EMAIL_VALUE_OBJ";
	
	public static final String ADMIN = "BD_ADMIN";
	public static final String SALES_ADMIN = "SALES_ADMIN";
	
	
	//---------------------------------------Permissions--------------------------------------//
	
	public static final String PERMISSION_SECURITY_LEVEL = "SECURITY_LEVEL";
    public static final String PERMISSION_TRACK_AND_TRACE = "TRACK_AND_TRACE";
    public static final String PERMISSION_POD_IMAGE_DOWNLOAD = "POD_IMAGE_DOWNLOAD";
    public static final String PERMISSION_INTERNET_DART_REPORT_DOWNLOAD = "INTERNET_DART_REPORT_DOWNLOAD";
    public static final String PERMISSION_SHIPDART = "SHIPDART";
    public static final String PERMISSION_MANAGE_AFFILIATES = "MANAGE_AFFILIATES";
    public static final String PERMISSION_CONSIGNEE_ADDRESS_BOOK_VIEW = "CONSIGNEE_ADDRESS_BOOK-VIEW_CONSIGNEE_ADDRESS_BOOK";
    public static final String PERMISSION_CONSIGNEE_ADDRESS_BOOK_CUD = "CONSIGNEE_ADDRESS_BOOK-CREATE_UPDATE_DELETE";
    public static final String PERMISSION_CONSIGNEE_ADDRESS_BOOK_IE = "CONSIGNEE_ADDRESS_BOOK-IMPORT_EXPORT";
    public static final String PERMISSION_NO_OF_USERS_TO_BE_CREATED = "NO_OF_USERS_TO_BE_CREATED";
    
    public static final String PERMISSION_BILLS_AND_PAYMENTS = "BILLS_AND_PAYMENTS";
    public static final String PERMISSION_STATEMENT_OF_OUTSTANDING_INVOICES = "STATEMENT_OF_OUTSTANDING_INVOICES";
    public static final String PERMISSION_INVOICE_LISTING = "INVOICE_LISTING";
    public static final String PERMISSION_STATEMENT_OF_ACCOUNTS = "STATEMENT_OF_ACCOUNTS";
    public static final String PERMISSION_SCHEDULE_A_PICKUP = "SCHEDULE_A_PICKUP";
    public static final String PERMISSION_BOOK_A_SHIPMENT = "BOOK_A_SHIPMENT";
    public static final String PERMISSION_SHIPPER_ADDRESS_BOOK_VIEW = "SHIPPER_ADDRESS_BOOK-VIEW_SHIPPER_ADDRESS_BOOK";
    public static final String PERMISSION_SHIPPER_ADDRESS_BOOK_CUD = "SHIPPER_ADDRESS_BOOK-CREATE_UPDATE_DELETE";
    public static final String PERMISSION_NUMBER_OF_ADDRESS_TO_MANAGE = "NUMBER_OF_ADDRESS_TO_MANAGE";
    
}

