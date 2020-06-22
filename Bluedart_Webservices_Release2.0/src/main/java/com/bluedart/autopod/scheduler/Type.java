/* Company      : NetKraft Pvt Ltd
 * Project      : BlueDart
 * Module   	: API
 * Class Name 	: Type
 * Filename 	: Type.java
 * Created on	: April 28, 2000
 * Version	    : 0.01
 * Author       : Mitesh Saraf
 * Copyright    : This software contains confidential and proprietary information of
 *                NetKraft Pvt Ltd.
 */
// Modified on: March 08, 2001
// Modified by: Mitesh Saraf

// Modified on: 12.05.01, 13:24 M.S - Mapped ShipDart featureID

package com.bluedart.autopod.scheduler;
	/*	
		* Type class has member variables which are used to store types of all kinds.
		* The class will just ease and standardize the coding and development process.
	 */

// WARNING -- do NOT CHANGE without consulting the TEAM
public class Type {

    public static final int DEBUG_CRITICAL = 0;
    public static final int DEBUG_SERIOUS_ERROR = 1;
    public static final int DEBUG_STANDARD_EXCEPTION = 2;
    public static final int DEBUG_DATA = 3;
    public static final int DEBUG_FLOW = 4;

    public static final int DEBUG_LEVEL = DEBUG_FLOW + 1;
//    public static final int DEBUG_LEVEL = 0;
    /* To be used like --
        if(Type.DEBUG_LEVEL > Type.DEBUG_DATA) {
            System.out.println("Some Debug Information");
        }
    */

    // USER STATUS
    // unregistered user for the portal, awaiting approval from admin.
    public static final String USER_STATUS_UNREG = "UNREGISTERED";
    // only the registered user for the portal.
    public static final String USER_STATUS_REG = "REGISTERED";
    // only the registered user for the portal forced to change password.
    public static final String USER_STATUS_FORCE = "FORCE";

    // USER TYPES
    // any visitor to the portal who is not logged in.
    public static final String USER_TYPE_VISITOR = "VISITOR";
    // user is an admin. Admins can add users to the portal.
    public static final String USER_TYPE_ADMIN = "ADMIN";
    // only the registered user for web service.
    public static final String USER_TYPE_WEB = "CREDIT_CUST";
    // only the user asking for client code
    public static final String USER_TYPE_CUST = "CREDIT_CUST_REQ";
    // pod user created by pod admin.
    public static final String USER_TYPE_POD = "POD_USER";
    //nladmin created for newsletteradmin
    public static final String USER_TYPE_NLADMIN = "NLADMIN";
	//hradmin created for resume and other Module
    public static final String USER_TYPE_HRADMIN = "HRADMIN";

    // USER STATES
    // user is logged in to the portal.
    public static final int USER_NOT_LOGGED_IN = 0;
    // user not logged in to the portal.
    public static final int USER_LOGGED_IN = 1;


    // TNT STATUS TYPES
    public static final String TNT_DELIVERED 	= 	"DL";
    public static final String TNT_INTRANSIT 	= 	"IT";
	public static final String TNT_RTO 			= 	"RT";
    public static final String TNT_REDIRECTED 	= 	"RD";
    public static final String TNT_UNDELIVERED 	= 	"UD";
    public static final String TNT_NOTFOUND 	= 	"NF";
    public static final String TNT_NOINFO		= 	"NI";


    // For MIS Reports
    public static final int STATS_LOCATION_FINDER_INTERNATIONAL = 0;
    public static final int STATS_LOCATION_FINDER_DOMESTIC_PINCODE = 1;
    public static final int STATS_LOCATION_FINDER_DOMESTIC_LOCATION = 2;
    public static final int STATS_RATE_CALC = 3;
    public static final int STATS_TRANSITTIME_FINDER = 4;
    public static final int STATS_DIM_WGT_CALC = 5;
    public static final int STATS_CONTACT_US_STATES = 6;
    public static final int STATS_CONTACT_US_LOCATION = 7;
    public static final int STATS_CONTACT_US_PINCODE = 8;
    public static final int STATS_CONTACT_US_EMAIL = 9;
    public static final int STATS_CONTACT_US_24HR = 10;
    public static final int PODUSER_LOGIN = 11;
    public static final int POD_INBOUND = 12;//pod inbound
    public static final int POD_OUTBOUND = 13;//pod outbound
    public static final int POD_ENTERPOD = 14;//enter pod
    public static final int ADMIN_LOGIN = 20;
    public static final int USER_LOGIN = 21;
    public static final int USER_FORCE_PWD = 22;
    public static final int SCHEDULE_PICKUP = 24;//schedule pickup
    public static final int STATUS_QUERY = 27;//track and trace
    public static final int TRACKINGAPI = 28;//api license key
    public static final int STATS_MANAGEDOWNLOADS_PROCESS = 30;
    public static final int DOWNLOADS = 31;
    public static final int STATS_AWBDETAIL = 40;//trackdart
    public static final int STATS_INTIMATE = 41;
    public static final int STATS_CUSTOMERCARE = 42;
    public static final int BILL_PAYMENTS = 44;//bills and payments
    public static final int WAYBILL_GENERATION = 45;//waybill generation
    public static final int ADDRESS_BOOK = 49;//address book
    public static final int SHIPDART = 50; //shipDart
    public static final int BILL_PAYMENTS_PAYONLINE = 51;//bills & payments pay-online
    public static final int BILL_PAYMENTS_PARTIALPAY = 52;//bills & payments partial pay

    // Added on 20-06-2001 by Jinaraj for MIS reports pat of SAPI
    public static final int SAPI_SCHEDULE_PICKUP = 53;
    public static final int SAPI_WAY_BILL = 54;
    public static final int SAPI_SERVICE_TOOLS = 55;
    // End of changes for MIS part of SAPI

    public static final int SCHEDULE_PICKUP_PAYONLINE = 26;//schedule pickup payonline
    public static final int SCHEDULE_PICKUP_RATEDISPLAY = 25;//schedule pickup ratedisplay


    //for delete schedule
    public static final int DELETE_SCHEDULE = 0;

    //for POD admin phase2 noncomputer locations
    public static final String NON_COMP_LOC = "F";
    //for POD admin phase2 disabling POD User
    public static final String DISABLE_POD = "N";

    //for client admin creation,showing the list of modules from feature_t based on this flag
    //public static final String SHOW_MODULE_FLAG = "T";
    //for client admin creation,will be used in bills and payments
    public static final String PAY_ONLINE_ENABLED = "Y";
    public static final String PAY_ONLINE_DISABLED = "N";
    //for client admin creation,will be used in bills and payments
    public static final String PARTIAL_PAY_ENABLED = "Y";
    public static final String PARTIAL_PAY_DISABLED = "N";

    //for client admin creation,will be used in Schedule Pickup
    public static final String SPICKUP_PAYONLINE_ENABLED = "Y";
    public static final String SPICKUP_PAYONLINE_DISABLED = "N";

    //for client admin creation,will be used in Schedule Pickup
    public static final String RATEDISPLAY_FLAG_ENABLED = "C";
    public static final String RATEDISPLAY_FLAG_DISABLED = "S";

    // for newsletter added on 10 mar 2001
    public static final String GENERALUSER = "GeneralUser";
    public static final String CREDITCUSTOMER = "CreditCustomer";
    public static final String PODUSER = "PodUser";
    public static final String ENABLE = "Y";
    public static final String DISABLE = "N";
    public static final String DATEFORMAT = "DD-MM-YYYY";
    public static final String CONTENT_HEADER = "Content-Type";
    public static final String TEXT_MIME_TYPE = "text/plain";
    public static final String HTML_MIME_TYPE = "text/html";
    public static final String HTML = "html";
    public static final String TEXT = "txt";
    public static final String UNSUBSCRIBER = "unSubscriber";



}
