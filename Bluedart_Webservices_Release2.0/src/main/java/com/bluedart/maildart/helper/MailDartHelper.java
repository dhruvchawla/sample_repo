package com.bluedart.maildart.helper;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.exception.BlueDartException;
import com.bluedart.maildart.dao.MailDartDao;
import com.bluedart.maildart.dto.MailDartDto;
import com.bluedart.trackdart.service.TrackingService;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.EmailUtil;
import com.bluedart.utils.SpringApplicationContext;
/*
 * @author CH848113
 */
@Component
public class MailDartHelper {
	//private static SchedulerPropertiesLoader propertiesLoader = new SchedulerPropertiesLoader();
		
	@Autowired
	TrackingService trackingService;
	
	@Autowired
	MailDartDao mailDartDao;
	
	private static Properties properties = new Properties();
	
	private static String DATE_FORMAT ="dd MMMM yyyy";
	private static final Logger logger = Logger.getLogger(MailDartHelper.class);
	String lineSeperation ="\n-------------------------------------------------------------------------------------------------------------------\n";
	public boolean trackByAwb(MailDartDto mailDartDto){
		boolean isMailSent = false;
		//String statusMessage = null;
		Map<String,String> trackingDetails = null;
		try{
			if(!(mailDartDto.getAwbNumbers().isEmpty()) && null != mailDartDto.getAwbNumbers() ){
			TrackDto trackDto = trackingService.trackByAwbNos(mailDartDto.getAwbNumbers(), null, 0, null,null);
	
			if(null != trackDto && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())){
				trackingDetails = getStatusMessage(trackDto);
				isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartTrackByAwb-template.vm");
			}
			else{
				isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartNoStatus-template.vm");
				//statusMessage = getStatusMessage();
			}
			}else if(!(mailDartDto.getInvalidAwbNumbers().isEmpty()) && null != mailDartDto.getInvalidAwbNumbers()){
				isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartNoStatus-template.vm");
				//statusMessage = getStatusMessage();
			}
			/*if(null != statusMessage){
				isMailSent = sendMail(statusMessage,mailDartDto);
			}*/
			 
		}catch(BlueDartException exp){
			isMailSent = false;
			logger.debug(Constants.DB_DOWN_ERROR_MESSAGE);
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return isMailSent;
	} 
	

	public boolean trackByRef(MailDartDto mailDartDto){
		boolean isMailSent = false;
		//String statusMessage;
		Map<String,String> trackingDetails = null;
			try{
			if(!(mailDartDto.getRefNumbers().isEmpty()) && null != mailDartDto.getRefNumbers() ){	
				logger.info("Ref Number  " + mailDartDto.getRefNumbers());
			TrackDto trackDto = trackingService.trackByRefNos(mailDartDto.getRefNumbers(), null, 0, null,null);
			if(null != trackDto && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())){
				trackingDetails = getStatusMessage(trackDto);
				isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartTrackByRef-template.vm");
				//statusMessage = getStatusMessage(trackDto);
			}
			else{
				isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartNoStatus-template.vm");
				//statusMessage = getStatusMessage();
			}
		}else{
			isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartNoStatus-template.vm");
			//statusMessage = getStatusMessage();
		}
			// 
		/*if(null != statusMessage){
			isMailSent = sendMail(statusMessage,mailDartDto);
		}*/
		
		}catch(BlueDartException exp){
			isMailSent = false;
			 logger.info(Constants.DB_DOWN_ERROR_MESSAGE);
			 throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return isMailSent;
	}

	
	public boolean intimateMe(MailDartDto mailDartDto){
		boolean isInserted = false;
		try{
			int returnValue= mailDartDao.intimateMe(mailDartDto.getAwbNumbers(), mailDartDto.getToEmailId());
			if(0 == returnValue){
				isInserted = true;
			}else{
				isInserted = false;
			}
			
		}catch(BlueDartException exp){
			isInserted = false;
			 logger.info(Constants.DB_DOWN_ERROR_MESSAGE);
			 throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return isInserted;
	}
	
	
	
	// method will be called from IntimateMecheduler
	public boolean intimateMeDeliveredInfo() {
		TrackDto trackDto = mailDartDao.intimateMeDeliveredInfo();
		logger.info("intimateMeDeliveredInfo called");
		boolean isMailSent = false;
		if(null != trackDto && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())){
			isMailSent = sendMailForIntimateMe(trackDto);
		}else{
			logger.info("intimateMeDeliveredInfo no AWB fetched");
			isMailSent = false;
		}
		return isMailSent;
	}
	
	
	
	private boolean sendMailForIntimateMe(TrackDto trackDto) {
		boolean isMailSent = false;
		//String newAwbNo ="";
		Map<String,String> trackingDetails = null ;
		//StringBuffer statusMessage =null;
		if(null != trackDto && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())){
			//statusMessage  = new StringBuffer("Dear Customer,\nEnclosed is the update on your shipment(s) as requested. ");
			ShipmentDto shipmentDto;
			for(int i=0;i< trackDto.getShipmentList().size();i++  ){
				trackingDetails = new LinkedHashMap<String,String>();
				  shipmentDto = trackDto.getShipmentList().get(i);
			
				  if(null != shipmentDto){
					  if(null != shipmentDto.getCawbno()) {
					  String statusDesc = new String();
						String statusDescNext = new String();
	    		        if(shipmentDto.getCstatdesc1() != null) {
		    		        StringTokenizer tokenizedLine = new StringTokenizer(shipmentDto.getCstatdesc1(), "|");
			    	        if( tokenizedLine.hasMoreTokens() ) {
				    	        statusDesc = tokenizedLine.nextToken().trim();
					            if(tokenizedLine.hasMoreTokens()) {
						            statusDescNext = tokenizedLine.nextToken().trim();
					            }
				            } else {
					            statusDesc = shipmentDto.getCstatdesc1();
				            }
			            }
	    		        
	    		    	if( (null != shipmentDto.getCemailid()) && (shipmentDto.getCemailid().length() != 0)
	                		    && (!(shipmentDto.getCemailid().trim().equalsIgnoreCase("response@bluedart.com"))) ) { // need to be changed 
	    		    		//newAwbNo = shipmentDto.getCawbno();
	    		    		//statusMessage = new StringBuffer(statusMessage + "\n\n\n");
	    		    		
	    		    		if ( (null != shipmentDto.getCstatus()) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED) ) {
	    		    			trackingDetails.put("Waybill Number"+"_"+i, shipmentDto.getCawbno());
	    		    			//statusMessage.append(" Waybill Number : " + shipmentDto.getCawbno());
								if(shipmentDto.getCrefno() != null) {
									trackingDetails.put("Reference No"+"_"+i, shipmentDto.getCrefno());
									//statusMessage.append("       Reference No : " + shipmentDto.getCrefno());
								}
								//statusMessage.append(lineSeperation);
							    if(null != shipmentDto.getDpudate())  {
							        if("X".equalsIgnoreCase(shipmentDto.getCprodcode())) {
							        	trackingDetails.put("Formal date of entry in India"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
							        	//statusMessage.append(" Formal date of entry in India : " + DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT)+ " \n");
							        } else {
							        	trackingDetails.put("Pickup Date"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
							        	//statusMessage.append(" Pickup Date : " + DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT) + " \n");
							        }
							    }
							    if(null != shipmentDto.getCprodcode() && "X".equalsIgnoreCase(shipmentDto.getCprodcode())) {
							    	trackingDetails.put("Country Origin Location"+"_"+i, shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")");
							    	//statusMessage.append(" Country Origin Location : " + shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")" + "\n");
							    } else {
							    	trackingDetails.put("From"+"_"+i, shipmentDto.getCorgareadesc());
							    	//statusMessage.append(" From : " + shipmentDto.getCorgareadesc()+ "\n");
			                    }
			                    if(null != shipmentDto.getCprodcode() && "I".equalsIgnoreCase(shipmentDto.getCprodcode())) {
			                    	trackingDetails.put("Country Delivery Location"+"_"+i, shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")");
			                    	//statusMessage.append(" Country Delivery Location : " + shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")" + "\n");
			                    } else {
			                    	trackingDetails.put("To"+"_"+i, shipmentDto.getCdstareadesc() );
			                    	//statusMessage.append(" To : " + shipmentDto.getCdstareadesc() + "\n");
			                    }
			                    if(null != statusDesc && (statusDesc.trim().length() >0)){
			                    trackingDetails.put("Status"+"_"+i, statusDesc );
			                    }
			                    //statusMessage.append(" Status : " + statusDesc + "\n");
			                    if( (null != statusDescNext ) && (statusDescNext.trim().length() > 0) ) {
			                    	trackingDetails.put("Status"+"_"+i, statusDesc+" "+ statusDescNext);
			                    	//statusMessage.append("          " + statusDescNext + "\n");
				                }
				                if( (null != shipmentDto.getCstatcode()) && (null != shipmentDto.getCstattype())
				                    && ("000").equals(shipmentDto.getCstatcode()) && "T".equalsIgnoreCase(shipmentDto.getCstattype())) {
                                    if(null != shipmentDto.getDstatdate()) {
                                    	trackingDetails.put("Date of Delivery"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT));
                                    	//statusMessage.append(" Date of Delivery : " +DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT)+ "\n");
                                        if(null != shipmentDto.getCstattime() && (shipmentDto.getCstattime().length() >= 4) ) {
                                        	trackingDetails.put("Time of Delivery"+"_"+i, shipmentDto.getCstattime().substring(0,2)  + ":" +  shipmentDto.getCstattime().substring(2));
                                        	//statusMessage.append(" Time of Delivery : " + shipmentDto.getCstattime().substring(0,2)  + ":" +  shipmentDto.getCstattime().substring(2)+ "\n");
                                        }
                                    }
                                    if(null != shipmentDto.getCrecdby()) {
                                    	trackingDetails.put("Recipient"+"_"+i, shipmentDto.getCrecdby());
                                    	//statusMessage.append(" Recipient : " + shipmentDto.getCrecdby() + "\n");
                                    }
                                }
				                //statusMessage.append("\n\n");
							}else {
									
								trackingDetails = getRedirectStatusForIntimateMe(trackingDetails,trackDto.getShipmentList(),i);
								//statusMessage.append(getRedirectStatusForIntimateMe(trackDto.getShipmentList(),i));
							
								
								
								
								/*if ( (shipmentDto.getCstatus() != null) && (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
									|| shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) ) {
								statusMessage.append(" Status : " + statusDesc + "\n");
								if( (statusDescNext != null) && (statusDescNext.trim().length() > 0) ) {
									statusMessage.append("          " + statusDescNext + "\n");
								}
								statusMessage.append(" New AWB Number : " + shipmentDto.getCnewawbno()+ "\n");
								statusMessage.append("\n\n");

				                for (int i = startPos + 1; i < shipmentVector.size(); i++) {
				                	ShipObj newS1 = (ShipObj)shipmentVector.elementAt(i);
				                	if(newS1.awbno.equalsIgnoreCase(s1.newawbno)) {
				                		theMsg.append(appendRedirected(shipmentVector, i));
				                		break;
				                	}
				                }
								 */
				            }
								/*else{
				            	statusMessage.append(getIntimateMeStatusMessage());
				            }*/
	    		    		
	    		    		//sending mail
	    		    		if(trackingDetails != null){
	    		    			MailDartDto mailDartDto = new MailDartDto(); 
	    		    			//Properties properties = new Properties();
	    		    			mailDartDto.setToEmailId(shipmentDto.getCemailid());
	    		    			logger.info("---To EmailID from Shipment---"+shipmentDto.getCemailid()+":---Way bill Number---:"+shipmentDto.getCawbno());
	    		    			/*try {
									properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
								} catch (IOException e) {
									 throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
								}*/
	    		    			if(shipmentDto.getCemailid()!=null){
	    		    				mailDartDto.setFromMailId(SpringApplicationContext.schedulerProperty.getProperty(Constants.intimateMeFromAddr));
		    		    			isMailSent = sendMail(trackingDetails,mailDartDto,"mailDartIntimateMe-template.vm");
		    		    			if(isMailSent){
		    		    				logger.info("Email sent successfully for waybill"+shipmentDto.getCawbno());
		    		    			}else{
		    		    				logger.info("Email not sent  for waybill"+shipmentDto.getCawbno());
		    		    			}
	    		    			}else{
	    		    				logger.info("----------Mail will not be sent as email address for ---Way bill Number---"+shipmentDto.getCawbno()+"to email is null");
	    		    			}
	    		    			
	    		    		}else{
	    		    			isMailSent = false;
	    		    		}
	    		    		
	    		    	}
				  }
				  }
			}
		}
		
		
		
		return isMailSent;
	}
		
		
	private Map<String,String> getRedirectStatusForIntimateMe(Map<String,String> trackingDetails ,List<ShipmentDto> shipmentDtoList, int pos){
		//StringBuffer statusMessage = new StringBuffer();
		ShipmentDto shipmentDto = shipmentDtoList.get(pos);
		int k=pos;
		 if (null != shipmentDto.getCawbno()) {
			 String statusDesc = new String();
	         String statusDescNext = new String();
	         if(null != shipmentDto.getCstatdesc1() ) {
					StringTokenizer tokenizedLine = new StringTokenizer(shipmentDto.getCstatdesc1(), "|");
					if( tokenizedLine.hasMoreTokens() ) {
						statusDesc = tokenizedLine.nextToken().trim();
						if(tokenizedLine.hasMoreTokens()) {
							statusDescNext = tokenizedLine.nextToken().trim();
						}
					} else {
						statusDesc = shipmentDto.getCstatdesc1();
					}
				}
	         if(null != shipmentDto.getCawbno()){
	        	 trackingDetails.put("Waybill Number"+"_"+k, shipmentDto.getCawbno());
	        	 //statusMessage.append(" Waybill Number : " + shipmentDto.getCawbno());
	         }
	         if(null != shipmentDto.getCrefno()) {
	        	 trackingDetails.put("Reference No"+"_"+k, shipmentDto.getCrefno());
	        	 //statusMessage.append("       Reference No : " + shipmentDto.getCrefno() );
			}
	         //statusMessage.append(lineSeperation);
	         if( null != shipmentDto.getDpudate()) {
					if( "X".equalsIgnoreCase(shipmentDto.getCprodcode())) {
						 trackingDetails.put("Formal date of entry in India"+"_"+k, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
						//statusMessage.append(" Formal date of entry in India : " +DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT)+ " \n");
					} else {
						trackingDetails.put("Pickup Date"+"_"+k, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
						//statusMessage.append(" Pickup Date : " + DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT) + " \n");
	                }
				}
	         
	         if( (shipmentDto.getCprodcode() != null) && shipmentDto.getCprodcode().equalsIgnoreCase("X") ) {
	        	    trackingDetails.put("Country Origin Location"+"_"+k, shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")");
	        	 	//statusMessage.append(" Country Origin Location : " + shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")" + "\n");
				} else {
					trackingDetails.put("From"+"_"+k, shipmentDto.getCorgareadesc());
					//statusMessage.append(" From : " + shipmentDto.getCorgareadesc() + "\n");
				}
	         
	         if( shipmentDto.getCprodcode().equalsIgnoreCase("I") ) {
	        	 	trackingDetails.put("Country Delivery Location"+"_"+k, shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")");
	        	 	//statusMessage.append(" Country Delivery Location : " + shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")" + "\n");
				} else {
					trackingDetails.put("To"+"_"+k, shipmentDto.getCdstareadesc());
					//statusMessage.append(" To : " + shipmentDto.getCdstareadesc() + "\n");
				}
	         
	         
	         if ( (shipmentDto.getCstatus() != null) && (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
						|| shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) ) {
	        	 if(null != statusDesc && (statusDesc.trim().length() >0))
	        	 trackingDetails.put("Status"+"_"+k, statusDesc);
	        	// statusMessage.append(" Status : " + statusDesc + "\n");
					if( (statusDescNext != null) && (statusDescNext.trim().length() > 0) ) {
						 trackingDetails.put("Status"+"_"+k, statusDesc+" "+statusDescNext);
						//statusMessage.append("          " + statusDescNext + "\n");
					}
					if(null != shipmentDto.getCnewawbno()){
					 trackingDetails.put("New AWB Number"+"_"+k, shipmentDto.getCnewawbno());
					//statusMessage.append(" New AWB Number : " + shipmentDto.getCnewawbno()+ "\n");
	                //statusMessage.append("\n\n");
					}
	                for (int i = pos + 1; i < shipmentDtoList.size(); i++) {
	                	ShipmentDto newShipmentDto = shipmentDtoList.get(i);
	                	if(newShipmentDto.getCawbno().equalsIgnoreCase(shipmentDto.getCnewawbno())) {
	                		trackingDetails = getRedirectStatusForIntimateMe(trackingDetails,shipmentDtoList, i);
	                		//statusMessage.append(getRedirectStatusForIntimateMe(shipmentDtoList, i));
	                		break;
	                	}
	                }

	            } else if ( (shipmentDto.getCstatus() != null) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED) ) {
	            	 
	            	if(null != statusDesc && statusDesc.trim().length() >0){
	            	trackingDetails.put("Status"+"_"+k, statusDesc);
	            	//statusMessage.append(" Status : " + statusDesc + "\n");
	            	}
					if( (statusDescNext != null) && (statusDescNext.trim().length() > 0) ) {
						 trackingDetails.put("Status"+"_"+k, statusDesc+" "+statusDescNext);
						//statusMessage.append("          " + statusDescNext + "\n");
					}
					if( (shipmentDto.getCstatcode() != null) && (shipmentDto.getCstattype() != null)
						&& shipmentDto.getCstatcode().equals("000") && shipmentDto.getCstattype().equalsIgnoreCase("T") ) {
	                    if( (shipmentDto.getDstatdate() != null) ) {
	                    	 trackingDetails.put("Date of Delivery"+"_"+k, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT));
	                    	//statusMessage.append(" Date of Delivery : " +  DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT)  + "\n");
	                        if( (shipmentDto.getCstattime() != null) && (shipmentDto.getCstattime().length() >= 4) ) {
	                        	trackingDetails.put("Time of Delivery"+"_"+k, shipmentDto.getCstattime().substring(0,2)  + ":" +  shipmentDto.getCstattime().substring(2));
	                        	//statusMessage.append(" Time of Delivery : " + shipmentDto.getCstattime().substring(0,2)  + ":" +  shipmentDto.getCstattime().substring(2)+ "\n");
	                        }
	                    }
	                    if(shipmentDto.getCrecdby() != null) {
	                    	trackingDetails.put("Recipient"+"_"+k, shipmentDto.getCrecdby());
	                        //statusMessage.append(" Recipient : " + shipmentDto.getCrecdby() + "\n");
	                    }
	                }
	               // statusMessage.append("\n\n");
				}
	         
		 }
		return trackingDetails;
		//return statusMessage.toString();
	}
	
	
	/*private String getIntimateMeStatusMessage() {
		String statusMessage = new String(" The Waybill query that you sent to us was not as per the instructions. Please enter the Waybill numbers separated by commas in the Subject or Body of the mail and mark that mail to intimateme@bluedart.com ");
		return statusMessage;
	}*/
	// method is used for get the status information for both track by awb & track by ref
	/*private String getStatusMessage() {
		 String statusMessage = new String (" The Waybill query that you sent to us was not as per the instructions. Please enter the Waybill numbers separated by commas in the Subject or Body of the mail and mark that mail to track@bluedart.com ");
		 return statusMessage;
	}*/
	
	
	// method is used for get the status information for both track by awb & track by ref
	private Map<String,String> getStatusMessage(TrackDto trackDto) {
		//StringBuffer statusMessage = null;
		long todayDate = ((new GregorianCalendar()).getTime()).getTime();	
		java.sql.Date currentDate = new java.sql.Date(todayDate); 
		Map<String,String> trackingDetails = new LinkedHashMap<String,String>();
		if( (null != trackDto ) && null != trackDto.getShipmentList() && !(trackDto.getShipmentList().isEmpty())) {
			//statusMessage = new StringBuffer("Dear Customer,\nEnclosed is the update on your shipment(s) as requested. "+"\n\n\n");  
				ShipmentDto shipmentDto; 
				for (int i=0; i < trackDto.getShipmentList().size(); i++) {
					   shipmentDto = trackDto.getShipmentList().get(i);
						if( (null != shipmentDto.getCawbno()) || (null != shipmentDto.getCrefno()) ) {
							
						    String statusDesc = new String();
	                        String nextStatusDesc = new String();
		    		        if(null != shipmentDto.getCstatdesc1()) {
			    		        StringTokenizer tokenizedLine = new StringTokenizer(shipmentDto.getCstatdesc1(), "|");
				    	        if( tokenizedLine.hasMoreTokens() ) {
					    	        statusDesc = tokenizedLine.nextToken().trim();
						            if(tokenizedLine.hasMoreTokens()) {
							            nextStatusDesc = tokenizedLine.nextToken().trim();
						            }
					            } else {
						            statusDesc = shipmentDto.getCstatdesc1();
					            }
				            }
		    		        
		    		        
		    		        if(null != shipmentDto.getCawbno()) {
		    		        	trackingDetails.put("Waybill Number"+"_"+i, shipmentDto.getCawbno());
		    		        	//statusMessage.append(" Waybill Number : " + shipmentDto.getCawbno());
							}
	        				if(null != shipmentDto.getCrefno()) {
	        					trackingDetails.put("Reference No"+"_"+i, shipmentDto.getCrefno());
	        					//statusMessage.append("       Reference No : " + shipmentDto.getCrefno() );
				            }
	        				//statusMessage.append(lineSeperation);
							

	        				if( (null == shipmentDto.getCstatus()) || shipmentDto.getCstatus().equals(Constants.TNT_NOTFOUND) ) {
	        					trackingDetails.put("Status"+"_"+i, "Incorrect Waybill/ Reference number or No Information");
	        					//statusMessage.append(" Status : " + "Incorrect Waybill/ Reference number or No Information" + "\n");

							} else{
								  if(null != shipmentDto.getDpudate()) {
							            if((null != shipmentDto.getCprodcode()) && ("X").equalsIgnoreCase(shipmentDto.getCprodcode())) {
							            	trackingDetails.put("Formal date of entry in India"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
							            	//statusMessage.append(" Formal date of entry in India : ");
							            } else {
							            	trackingDetails.put("Pickup Date"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT));
							            	//statusMessage.append(" Pickup Date : ");
		                	            }
							          //  statusMessage.append( DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDpudate()),DATE_FORMAT) + " \n");
							       }
								  
								  if( (null != shipmentDto.getCprodcode()) && ("X").equalsIgnoreCase(shipmentDto.getCprodcode())) {
									  trackingDetails.put("Country Origin Location"+"_"+i, shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")" );
									  //statusMessage.append(" Country Origin Location : " + shipmentDto.getCorgscrdesc() + " (" + shipmentDto.getCorgareadesc() + ")" + "\n");
						            } else {
						            	trackingDetails.put("From"+"_"+i, shipmentDto.getCorgareadesc());
						            	//statusMessage.append(" From : " + shipmentDto.getCorgareadesc() + "\n");
						            }
								  
								  if(null != shipmentDto.getCprodcode() && ("I").equalsIgnoreCase(shipmentDto.getCprodcode())) {
									  	trackingDetails.put("Country Delivery Location"+"_"+i, shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")");
									  	//statusMessage.append(" Country Delivery Location : " + shipmentDto.getCdstscrdesc() + " (" + shipmentDto.getCdstareadesc() + ")" + "\n");
						            } else {
						            	if(null != shipmentDto.getCdstareadesc()){
						            	trackingDetails.put("To"+"_"+i, shipmentDto.getCdstareadesc());
						            	//statusMessage.append(" To : " + shipmentDto.getCdstareadesc() + "\n");
						            	}
						            }
								  
								  if ( (null != shipmentDto.getCstatus()) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED) ) {
									  if(null != statusDesc && (statusDesc.trim().length() >0)){
									  trackingDetails.put("Status"+"_"+i, statusDesc);
									  //statusMessage.append(" Status : " + statusDesc + "\n");
									  }
							            if( (null != nextStatusDesc) && (nextStatusDesc.trim().length() > 0) ) {
							            	trackingDetails.put("Status"+"_"+i, statusDesc +" "+nextStatusDesc);
							            	//statusMessage.append("          " + nextStatusDesc + "\n");
							            }
							            if( (null != shipmentDto.getCstatcode()) && (null != shipmentDto.getCstattype())
							                && ("000").equals(shipmentDto.getCstatcode()) && "T".equalsIgnoreCase(shipmentDto.getCstattype())) {
		                                    if( null != shipmentDto.getDstatdate())  {
		                                    	trackingDetails.put("Date of Delivery"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT) );
		                                    	//statusMessage.append(" Date of Delivery : " +  DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDstatdate()),DATE_FORMAT) + "\n");
		                                        if( (null!= shipmentDto.getCstattime()) && (shipmentDto.getCstattime().length() >= 4) ) {
		                                        	trackingDetails.put("Time of Delivery"+"_"+i, shipmentDto.getCstattime().substring(0,2) +" : "+shipmentDto.getCstattime().substring(2));
		                                        	//statusMessage.append(" Time of Delivery : " + shipmentDto.getCstattime().substring(0,2)  + ":" +  shipmentDto.getCstattime().substring(2)+ "\n");
		                                        }
		                                    }
		                                    if(null != shipmentDto.getCrecdby()) {
		                                    	trackingDetails.put("Recipient"+"_"+i, shipmentDto.getCrecdby());
		                                    	//statusMessage.append(" Recipient : " + shipmentDto.getCrecdby()  + "\n");
		                                    }
		                                }
		                            }else if ( (null != shipmentDto.getCstatus()) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_INTRANSIT) ) {
		                            	
		                            	trackingDetails.put("Status"+"_"+i, "In Transit , Await delivery information");
		                            	//statusMessage.append(" Status : " + "In Transit" + "\n");
		                            	//statusMessage.append("          " + "Await delivery information" + "\n");
			        				    

			        				    if( (null != shipmentDto.getDeptdtdlv())
			        				        && (((java.lang.Math.abs(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDeptdtdlv()).getTime()) - currentDate.getTime()) < 86400000) 
			        				        || ( (DateUtil.getStringToDateDefaultFormat(shipmentDto.getDeptdtdlv()).getTime() - currentDate.getTime()) > 86400000) ) ) {
			        				    	trackingDetails.put("Expected Date of Delivery"+"_"+i, DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDeptdtdlv()),DATE_FORMAT));
			        				    	//statusMessage.append(" Expected Date of Delivery : " +
			        				    	//DateUtil.getStringFormGivenDateFormat(DateUtil.getStringToDateDefaultFormat(shipmentDto.getDeptdtdlv()),DATE_FORMAT) + "\n");
			        				    }
			        			    }else if ( (null != shipmentDto.getCstatus()) && shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_UNDELIVERED) ) {
			        			    	if(null != statusDesc && (statusDesc.trim().length() >0)){
			        			    	trackingDetails.put("Status"+"_"+i, statusDesc);
			        			    	//statusMessage.append(" Status : " + statusDesc + "\n");
			        			    	}
			        				    if( (null != nextStatusDesc ) && (nextStatusDesc.trim().length() > 0) ) {
			        				    	trackingDetails.put("Status"+"_"+i, statusDesc +" "+ nextStatusDesc);
			        				    	//statusMessage.append("          " + nextStatusDesc + "\n");
			        				    }
			        			    }else if ( (shipmentDto.getCstatus() != null) && (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
										    || shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) ) {
			        			    	if(null != statusDesc && (statusDesc.trim().length() >0)){
			        			    		trackingDetails.put("Status"+"_"+i, statusDesc );
			        			    		//statusMessage.append(" Status : " + statusDesc + "\n");
			        			    	}
			                   		    if( (nextStatusDesc != null) && (nextStatusDesc.trim().length() > 0) ) {
			                   		    	trackingDetails.put("Status"+"_"+i, statusDesc +" "+ nextStatusDesc);
			                   		    	//statusMessage.append("          " + nextStatusDesc + "\n");
			                   		    }
			                   		    if(null != shipmentDto.getCnewawbno()){
			                   		    trackingDetails.put("New AWB Number"+"_"+i, shipmentDto.getCnewawbno());
			                   		    //statusMessage.append(" New AWB Number : " + shipmentDto.getCnewawbno() + "\n");
			                   		    }
		                            } 
								  }
	        				//statusMessage.append("\n\n");
						}
				}
		 }else{
			 
			// statusMessage.append(getStatusMessage());
		 }
		return trackingDetails;
		//return statusMessage.toString();
	}
	
	
	private boolean sendMail(Map<String,String> trackingDetails, MailDartDto mailDartDto,String templateName){
		boolean isMailSent= false; 
		EmailContent emailContent = new EmailContent();
		emailContent.setFrom(mailDartDto.getFromMailId());
		emailContent.setTo(mailDartDto.getToEmailId());
		logger.info("------------To Email Id for -----------"+mailDartDto.getToEmailId()+"----TemplateName----"+templateName);
		
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(Constants.BLUEDART_PROPERTIES));
			emailContent.setSubject(properties.getProperty("mailDartEmailSubject"));
		}catch(IOException exp){
			emailContent.setSubject("BlueDart >> MailDart");
		}
		if(null != trackingDetails && !(trackingDetails.isEmpty())){
		Map <String, Object> statusMessageMap = new HashMap <> ();
		statusMessageMap.put("trackingDetails", trackingDetails);   
		emailContent.setModel(statusMessageMap);
		}
		//emailContent.setText(statusMessage);
		try {
			if(null != emailContent.getTo() ){
			isMailSent = EmailUtil.sendEmailWithImage(emailContent,templateName);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			logger.info("MessagingException "+ e);
			isMailSent = false;
			throw new BlueDartException(Constants.DB_DOWN_ERROR_CODE,Constants.DB_DOWN_ERROR_MESSAGE);
		}
		return isMailSent;
	}

}
