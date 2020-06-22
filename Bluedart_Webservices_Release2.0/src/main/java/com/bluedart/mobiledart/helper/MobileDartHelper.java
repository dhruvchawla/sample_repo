package com.bluedart.mobiledart.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.mobiledart.dao.MobileDartDao;
import com.bluedart.mobiledart.dto.MobileDartDto;
import com.bluedart.trackdart.service.TrackingService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.SpringApplicationContext;
/*
 * @author CH848113
 */
@Component
public class MobileDartHelper {
	
	@Autowired
	private MobileDartDao mobileDartDao;
	
	@Autowired
	TrackingService trackingService;
	
	 // private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
	 private static String dateFormat ="dd MMMM yyyy";
	 private static String statusDesc ;
	 private static String formatedStatusDesc;
	 private static String statusDescNext="";
	 private static String dispatchDate ;
	 private static String dispatchTime ;
	 private static String recipient ;
	
	private static final Logger logger = Logger.getLogger(MobileDartHelper.class);
	
	public MobileDartDto trackByAwb(List<String> awbNumbers) {
		MobileDartDto mobileDart = new MobileDartDto();
		try{
		TrackDto trackDto = trackingService.trackByAwbNos(awbNumbers, null, 0, null,null);
		
	   
		if(null != trackDto  && null != trackDto.getShipmentList()){
			mobileDart = getStatusMessage(trackDto);
		}else{
			mobileDart = getStatusMessage();
		}
		}catch(BlueDartException exp){
			mobileDart.setError(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return mobileDart;
	}
	
	public MobileDartDto intimateMe(List<String> awbNumbers,String mobileNumber) {
		MobileDartDto mobileDart= new MobileDartDto();
		
		try{
		if(null != awbNumbers && !(awbNumbers.isEmpty()) && (null != mobileNumber && mobileNumber.length() >=10)){
		int value = mobileDartDao.intimateMe(awbNumbers, mobileNumber);
		if(value == 0){
			mobileDart.setSucess("Both Data  is updated for sms Scheduler");
			mobileDart.setSmsMessage("Thank you for using Blue Dart.You will be advised as soon as your shipment is delivered.");
		}else{
			//mobileDart.setError("Please select your Waybill Number(s) from previous screen and enter valid MobileNumber.");
			mobileDart.setSmsMessage("Error message. For shipment delivery intimation, please re-type I '<space>' Airwaybill Number. Have a good day. Blue Dart.");
		}
		}else if((null == awbNumbers || awbNumbers.isEmpty()) || (null == mobileNumber || mobileNumber.length() <10)){
			mobileDart.setError("Please select your Waybill Number(s) from previous screen and enter valid Mobile number.");
			
		}
		mobileDart.setSendToMessage("Your request has been actioned.");
		}catch(BlueDartException exp){
			 logger.info(Constants.DB_DOWN_ERROR_MESSAGE);
			mobileDart.setError(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return mobileDart;
		
		
	}
	
	public MobileDartDto reverseSMS(String message,String mobileNumber){
		MobileDartDto mobileDart= new MobileDartDto();
		try{
		if((null != message && !(message.isEmpty())) && (null != mobileNumber && mobileNumber.length() >=10)){
			int value= mobileDartDao.reverseSMS(message,mobileNumber);
			if(value == 0){
				mobileDart.setSucess("Both Data  is updated for sms Scheduler");
				mobileDart.setSmsMessage(" Thank you for your response. The shipment status can be tracked anytime on http://www.bluedart.com.");
			}else{
				//mobileDart.setError("Please select your option from previous screen and enter valid keyword.");
				mobileDart.setSmsMessage("Error Message : Option selected is invalid , please select correct option D A or D B with date and send to 56767.");
			}
			
		}else if((null == message || message.isEmpty()) && (message.length() < 1) ){
			mobileDart.setError("Error Message : Option selected is invalid , please select correct option D A or D B with date and send to 56767.");
			
        }else if((null == message  || message.isEmpty()) || (null == mobileNumber || mobileNumber.length() <10)){
			mobileDart.setError("Please select your  Option properly.");
        }
		mobileDart.setSendToMessage("Your request has been actioned.");
		}catch(BlueDartException exp){
			 logger.info(Constants.DB_DOWN_ERROR_MESSAGE);
			mobileDart.setError(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return mobileDart;
	}
	
	// method will be called from SMSScheduler
	public boolean intimateMe() {
		TrackDto trackDto = mobileDartDao.intimateMe();
		boolean isMessageSent = false;
		if(null != trackDto){
			try {
				isMessageSent = generateMessage(trackDto);
			} catch (IOException e) {
				throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
			}
		}
		
		return isMessageSent;
	}

	private static MobileDartDto getStatusMessage(TrackDto trackDart){
		
		  long todayDate = ((new GregorianCalendar()).getTime()).getTime();	
		  java.sql.Date currentDate = new java.sql.Date(todayDate);
		  MobileDartDto mobileDart=  new MobileDartDto();
		 if(null != trackDart  && null != trackDart.getShipmentList() && !(trackDart.getShipmentList().isEmpty())
				&& null != trackDart.getShipmentList().get(0)){
			ShipmentDto shipment = trackDart.getShipmentList().get(0);
			if(null != shipment.getCawbno()){
				String dateDelivery;
				String recievedBy;
				String exptdDateOfDelivery;
				
				if( (null == shipment.getCstatus() ) || shipment.getCstatus().equals(Constants.TNT_NOTFOUND) ) {
					logger.info("Shipment Status Not Found.");
					mobileDart.setSmsMessage("Please recheck WayBill Number given or contact our customer Service");
				}
			
				else if( (null != shipment.getCstatus() ) && shipment.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED ) ){
					logger.info("Shipment Status : "+shipment.getCstatus());
					if(null != shipment.getDeptdtdlv() && null != shipment.getDstatdate()  
					&& (shipment.getDstatdate().equals(shipment.getDeptdtdlv())) 
					||(DateUtil.getStringToDateDefaultFormat(shipment.getDstatdate()).before(DateUtil.getStringToDateDefaultFormat(shipment.getDeptdtdlv()))
					|| (DateUtil.getStringToDateDefaultFormat(shipment.getDstatdate()).after(DateUtil.getStringToDateDefaultFormat(shipment.getDeptdtdlv())))) ){
						
						 statusDesc =  shipment.getCstatdesc1();
						     if(statusDesc!=null)
							logger.info("Shipment Status getCstatdesc1: "+shipment.getCstatdesc1());
							StringTokenizer tokenizedLine = new StringTokenizer(statusDesc, "|");
							if( tokenizedLine.hasMoreTokens() )	{
									statusDesc = tokenizedLine.nextToken().trim();
									if(tokenizedLine.hasMoreTokens()){
										statusDescNext = tokenizedLine.nextToken().trim();
									 }
									 statusDesc = (statusDesc + statusDescNext).trim();
							 }else{
								statusDesc = statusDesc.trim();
							 }
						 
						 dateDelivery = DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipment.getDstatdate()),dateFormat);
						if ((null != shipment.getCstattime() ) && (shipment.getCstattime().length() >= 4)){
							dispatchTime = shipment.getCstattime().substring(0,2) + ":" + shipment.getCstattime().substring(2);
						}
						 recievedBy = shipment.getCrecdby().trim();
						 mobileDart.setSmsMessage(shipment.getCawbno() + "  " + statusDesc + " at "+dispatchTime+" on "+ dateDelivery + " to "+recievedBy );
				     }
			 }
			else if(null != shipment.getCstatus() && shipment.getCstatus().equalsIgnoreCase(Constants.TNT_UNDELIVERED) ){
					logger.info("Shipment Status : "+shipment.getCstatus());
					
					statusDesc = shipment.getCstatdesc1();

					 StringTokenizer tokenizedLine = new StringTokenizer(statusDesc, "|");
							if( tokenizedLine.hasMoreTokens() )	{
									statusDesc = tokenizedLine.nextToken().trim();
									if(tokenizedLine.hasMoreTokens()){
										statusDescNext = tokenizedLine.nextToken().trim();
										statusDesc = (statusDesc +". "+ statusDescNext).trim();
									 }
							}else{
								statusDesc = statusDesc.trim();
							 }
					mobileDart.setSmsMessage(shipment.getCawbno() + " " + statusDesc );
			}
			else if (null != shipment.getCstatus()  &&  shipment.getCstatus().equalsIgnoreCase(Constants.TNT_INTRANSIT)){
				logger.info("Shipment Status : "+shipment.getCstatus());
					 if(null != shipment.getDeptdtdlv()   
					 && (((java.lang.Math.abs(DateUtil.getStringToDateDefaultFormat(shipment.getDeptdtdlv()).getTime()) - currentDate.getTime()) < 86400000) 
						 || ( (DateUtil.getStringToDateDefaultFormat(shipment.getDeptdtdlv()).getTime() - currentDate.getTime()) > 86400000) ) ){
						 exptdDateOfDelivery = DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipment.getDeptdtdlv()),dateFormat); 
						 mobileDart.setSmsMessage(shipment.getCawbno() + " in Transit. Expected to deliver on " + exptdDateOfDelivery);
					 }else{
						mobileDart.setSmsMessage(shipment.getCawbno() + " in Transit.");
					}
			
			}
			else if (null != shipment.getCstatus()  && (shipment.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)|| 
					shipment.getCstatus().equalsIgnoreCase(Constants.TNT_RTO) )){
				logger.info("Shipment Status : "+shipment.getCstatus());
				statusDesc = shipment.getCstatdesc1();
				StringTokenizer tokenizedLine = new StringTokenizer(statusDesc, "|");
				if( tokenizedLine.hasMoreTokens()){
						statusDesc = tokenizedLine.nextToken().trim();
				 }else{
					 statusDesc = statusDesc.trim();
				 }
				if (null != shipment.getCnewawbno()){
					mobileDart.setSmsMessage("Airwaybill Number "+shipment.getCawbno().trim() + " " +statusDesc +" on Airwaybill Number "+ shipment.getCnewawbno()+". Contact Customer Service for further details");
				}else{
					mobileDart.setSmsMessage(shipment.getCawbno().trim() + " " +statusDesc +". Contact Customer Service for further details");
				}
			}	
			
		}
			
		}else{
			    logger.info("Recheck WayBill number.or contact our customer Service");
				mobileDart.setSmsMessage("Please recheck WayBill Number given or contact our customer Service");
		}
		return mobileDart;
	}

	private MobileDartDto getStatusMessage(){ 
		MobileDartDto mobileDart=  new MobileDartDto();
		logger.info("Recheck WayBill number.or contact our customer Service");
		mobileDart.setSmsMessage("Please recheck WayBill Number given or contact our customer Service");
		return mobileDart;
	}
	
	
	  private static boolean generateMessage(TrackDto trackDto) throws IOException{
		  	 String awbNumber = null;
			
		  	 StringBuilder smsMessage = null;
			 boolean isMessageSent = false;
	    	 
	    	try {
	    			if(null != trackDto && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())){
	    			
	    				ShipmentDto shipmentDto=null;
	    				for(int i=0;i<trackDto.getShipmentList().size();i++){
	    					shipmentDto = trackDto.getShipmentList().get(i);
	    					smsMessage = new StringBuilder();
	    					if(null != shipmentDto.getCawbno() ){
	    						    awbNumber = shipmentDto.getCawbno().trim();
	    					 	   if(shipmentDto.getCstatdesc1() != null){
	    							   statusDesc = toGetStatusDesc(shipmentDto.getCstatdesc1().trim());
	     						   }
	    						if((null != shipmentDto.getCmobileno() ) && (shipmentDto.getCmobileno().length() != 0) ){
	    							if ((null != shipmentDto.getCstatus() ) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED)){
	    								logger.info("Scheduler SMS for Delivered");
	    								 if( (null != shipmentDto.getCstatcode() ) && (null != shipmentDto.getCstattype() )
													&& shipmentDto.getCstatcode().equals("000") && shipmentDto.getCstattype().equalsIgnoreCase("T") )
													{
														if(null != shipmentDto.getDstatdate())//&& shipmentDto.getDstatdate().after(DATE) ) 
														 {
															dispatchDate = DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),dateFormat);
															 if( (null != shipmentDto.getCstattime()) && (shipmentDto.getCstattime().length() >= 4) )
															 {
															  dispatchTime = shipmentDto.getCstattime() .substring(0,2)  + ":" + shipmentDto.getCstattime() .substring(2);
															 }
														  }
														if(null != shipmentDto.getCrecdby())
														  {
															 recipient = shipmentDto.getCrecdby();
														  }
													 }
	    									smsMessage.append( awbNumber+" "+statusDesc+" at "+dispatchTime+" on "+dispatchDate+" to "+recipient+".");
	    								
	    							} else 
									 {
	    								logger.info("Scheduler SMS for Rto or Redirected");
	    								smsMessage.append(appendRedirected(trackDto, i));	
									 }
	    							
	    							isMessageSent = constructXmlSendSms(shipmentDto.getCmobileno().trim(),awbNumber,smsMessage.toString());	
	    							
	    						}
	    						
	    					}
	    					
	    				}
	    			}
		} catch (BlueDartException e) {
				isMessageSent = false;
				return isMessageSent;
			}
	    	return isMessageSent;
	    }
	
	  
	  private static StringBuilder appendRedirected(TrackDto trackDartDto, int startPos){
		  StringBuilder smsMessage = new StringBuilder() ;
			 ShipmentDto shipmentDto = trackDartDto.getShipmentList().get(startPos);
						//
				         if (null != shipmentDto.getCawbno())
						 {
							   if(null != shipmentDto.getCstatdesc1()) 
								{	/*
									*@ Logic for  statdesc1 has more then one description separated by "|"
									*/
								   statusDesc = toGetStatusDesc(shipmentDto.getCstatdesc1().trim());
								}
							   if ( (null != shipmentDto.getCstatus()) && (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
									|| shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) ) {
								
								if(null != shipmentDto.getCnewawbno() )
				                {
									smsMessage.append( "AirWaybill Number "+shipmentDto.getCawbno().trim()+" "+ formatedStatusDesc.trim() + " on waybill Number " +shipmentDto.getCnewawbno().trim()+".Contact Customer Service for further Details.");
								}
								else
								{
									smsMessage.append("AirWaybill Number "+ shipmentDto.getCawbno().trim()+" "+ formatedStatusDesc.trim() + "Contact Customer Service on same Waybill");			
								}
									
				              
				            } 
							else if ( (null != shipmentDto.getCstatus()) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED) ) 
							{
				            			//if statdesc has more then one description
									if( (null != statusDescNext ) && (statusDescNext.trim().length() > 0) ) {
									statusDesc = statusDesc + ". " +  statusDescNext;
									}
									
								if( (null != shipmentDto.getCstatcode() ) && (null != shipmentDto.getCstattype() )
									&& shipmentDto.getCstatcode().equals("000") && shipmentDto.getCstattype().equalsIgnoreCase("T") )
									{
											
									if(null != shipmentDto.getDstatdate() )//&& shipmentDto.getDstatdate().after(DATE) ) 
									 {
										
										dispatchDate = DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),dateFormat);
												
										 if( (null != shipmentDto.getCstattime()) && (shipmentDto.getCstattime().length() >= 4) )
										 {
										  dispatchTime = shipmentDto.getCstattime() .substring(0,2)  + ":" + shipmentDto.getCstattime() .substring(2);
										 }
									  }
									
								
									if(null != shipmentDto.getCrecdby() )
									  {
										 recipient = shipmentDto.getCrecdby();
									  }
								 }	
								smsMessage.append( shipmentDto.getCawbno()+" "+statusDesc+" at "+dispatchTime.trim()+" on "+dispatchDate+" to "+recipient+".");
							} 
						} 
							
				        return smsMessage;
				    }
	  
	    private static boolean  constructXmlSendSms(String mobileNumber,String awbNumber, String smsMessage) throws IOException{
					String messageId = generateMessageId(awbNumber);
					String masking = "true";	
					String xmlSms  = null;
					String message = smsMessage;
					boolean isMessageSent = false;
					String smsId = null; 
			    	String password= null; 
			    	String smsAppId= null; 
			    	String smsSubAppId= null; 
			    	String aclHost = null; 
			    	Properties properties = new Properties();
			    	try {
			    	properties.load(MobileDartHelper.class.getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
			    	
				 	 smsId = SpringApplicationContext.schedulerProperty.getProperty(Constants.SMSUID);
					 password = SpringApplicationContext.schedulerProperty.getProperty(Constants.PWD);
					 smsAppId =SpringApplicationContext.schedulerProperty.getProperty(Constants.SMSAPPID);
					 smsSubAppId = SpringApplicationContext.schedulerProperty.getProperty(Constants.SMSSUBAPPID);
					 aclHost = SpringApplicationContext.schedulerProperty.getProperty(Constants.ACLHOST);  
			    	
					
					
						xmlSms = "<?xml version=\"1.0\"?><push><appid>"+smsAppId+"</appid><subappid>"+smsSubAppId+"</subappid><userid>"+smsId+"</userid>"
								+ "<pass>"+password+"</pass><acct-type>1</acct-type><msgid>"+messageId+"</msgid><content-type>1</content-type>"
								+ "<priority>true</priority><masking>"+masking+"</masking><from>BlueDart</from><to><address>"+mobileNumber+"</address></to> "
								+ "<msg>"+message+"</msg> <dlr>true</dlr><alert>1</alert></push>";
						isMessageSent = sendSMS(xmlSms,aclHost);
						if(isMessageSent){
							logger.info("Message is Sent");
						}else{
							logger.info("Message is not delivered.");
						}
						return isMessageSent;
			    	} catch (IOException e1) {
			    		throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
					}
	    	}
	    
	    private static String generateMessageId(String awbNumber){
	    	long currentTime = System.currentTimeMillis();
			Long longTimestamp = currentTime;
			return longTimestamp.toString() + awbNumber;
	    }
	    
	    private static boolean sendSMS(String xmlSms,String aclUrl ) throws IOException{
		try { 																		  
			byte[] buffer = xmlSms.getBytes("ISO-8859-1");                       
		
			URL url = new URL(aclUrl);
		 
			URLConnection conn = url.openConnection();                          
			conn.setDoOutput(true);                                           
			OutputStream out = conn.getOutputStream();                         
			out.write(buffer);                                                
			out.flush();                                                      
			InputStream instream = conn.getInputStream();                       
			buffer = new byte[3000];                                           
			instream.read(buffer);                                             
			//logger.info("Response :" + new String(buffer).trim());   
			return true;
		   }catch (MalformedURLException ex) { 
			   return false;
		}
									 
	}
	
	    
		private static String toGetStatusDesc(String statusDesc1)
		{
				String statusDesc ;
				String statusDescNext = null;
				StringTokenizer tokenizedLine = new StringTokenizer(statusDesc1, "|,.");
					if( tokenizedLine.hasMoreTokens() )
					{
							statusDesc = tokenizedLine.nextToken().trim();
							formatedStatusDesc = statusDesc;
							if(tokenizedLine.hasMoreTokens()) 
							{
								statusDescNext = tokenizedLine.nextToken().trim();
								if (statusDescNext != null)
								 {
									statusDesc = statusDesc + ". "+statusDescNext;
								 }
							 }
					 } 
					  else
					  {
						statusDesc = statusDesc1.trim();
					   }
			return statusDesc.trim();
		}
	
}
