package com.bluedart.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bluedart.exception.BlueDartException;

/**
 * 
 * @author DH839598
 *
 */

public final class SMSUtil {
	
	private Properties properties = new Properties();

	public void sendSMS( String mobileNo, String message ) {
		StringBuilder content = new StringBuilder();
		try
		{
			//enterpriseid=pushenterpriseid&subEnterpriseid=pushsubenterpriseid&pusheid=userid&pushepwd=password&msisdn=919910490359&sender=sender&msgtext=TestingOTP
			String pushEnterpriseId = "pushenterpriseid";
			String pushSubEnterpriseId = "pushsubenterpriseid";
			String userId ="Test";
			String password = "Welcome";
			String sender = "sender";
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.EXT_WEBSERVICE_PROPERTIES));
			String theUrl = properties.getProperty(Constants.ACL_URL)+"enterpriseid="+pushEnterpriseId+"&subEnterpriseid="+pushSubEnterpriseId+"&pusheid="+userId+"&pushepwd="+password+"&msisdn="+mobileNo+"&sender="+sender+"&msgtext="+message;
			URL url = new URL(theUrl);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null)
			{
				content.append(line + "\n");
			}
			bufferedReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//return content.toString();
	}

}

