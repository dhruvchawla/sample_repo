package com.bluedart.security;

public interface UserConstants {
	
	public final static String USERTYPE_GUEST= "GUEST";
	public final static String USERTYPE_ADMIN= "ADMIN";
	public final static String USERTYPE_CORPORATE= "CORPORATE";
	public final static String USERTYPE_POD= "POD";
	public final static String USERTYPE_SUPERADMIN= "SUPERADMIN";
	
	public final static String USER_GUESTROLE= "ROLE_GUEST";
	public final static String USER_ADMINROLE= "ROLE_ADMIN";
	public final static String USER_CORPORATEROLE= "ROLE_CORPORATE";
	public final static String USER_PODROLE= "ROLE_POD";
	public final static String USER_SUPERADMINROLE= "ROLE_SUPERADMIN";
	
	public final static String USER_GUEST_PASSWORD = "BDGUEST6789";
	public final static String USER_ADMIN_PASSWORD = "BDADMIN5273";
	public final static String USER_CORPORATE_PASSWORD = "BDCORPORATE2096";
	public final static String USER_POD_PASSWORD = "BDPOD0092";
	public final static String SUPERADMIN_PASSWORD = "BDSADMIN5295";
	
	public final static String SECRETKEY = "blued8548";
	public final static int ITERATIONCOUNT = 19;
	public final static String SECRETCODE = "PBEWithMD5AndDES";
	public final static String CHARSET = "UTF-8";

}
