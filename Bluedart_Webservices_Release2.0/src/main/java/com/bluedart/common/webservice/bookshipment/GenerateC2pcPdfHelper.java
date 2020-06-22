package com.bluedart.common.webservice.bookshipment;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfDimensionEntity;
import org.datacontract.schemas._2004._07.bd_entities_area.ArrayOfIntlgstdetails;
import org.datacontract.schemas._2004._07.bd_entities_area.DimensionEntity;
import org.datacontract.schemas._2004._07.bd_entities_area.Intlgstdetails;
import org.datacontract.schemas._2004._07.bd_entities_area.WybillGenerationEntity;
import org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase;
import org.datacontract.schemas._2004._07.bd_entities_common.BDResponse;
import org.datacontract.schemas._2004._07.bd_entities_common.EntityBase;
import org.datacontract.schemas._2004._07.bd_entities_common.StringEntity;
import org.springframework.context.annotation.PropertySource;
import org.tempuri.WaybillGenerationForWebsite;
import org.tempuri.WaybillGenerationForWebsiteResponse;

import com.bluedart.common.dto.DimensionEntityDto;
import com.bluedart.common.dto.EmailContent;
import com.bluedart.common.dto.GenerateRequestPdfClientDto;
import com.bluedart.common.dto.GenerateRequestPdfDto;
import com.bluedart.common.dto.GenerateResponsePdfDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.EmailUtil;

@PropertySource("classpath:emailConfig.properties")
public class GenerateC2pcPdfHelper {

	private static final Logger logger = Logger.getLogger(GenerateC2pcPdfHelper.class);

	public GenerateResponsePdfDto generatePDFData(GenerateRequestPdfDto generateRequestPdfDto,
			GenerateRequestPdfClientDto generateReqPdfClientDto) {

		GenerateResponsePdfDto genererateResponseDto = new GenerateResponsePdfDto();
		String wayBillValue = "";

		try {
			WybillGenerationEntity wayBillGenerationEntity = new WybillGenerationEntity();

			Calendar modifiedDate = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			Calendar calendar1 = new GregorianCalendar(year, month, date);
			Date date1 = sdf.parse(sdf.format(calendar1.getTime()));
			modifiedDate.setTime(date1);

			//SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

			String puDateStr = generateRequestPdfDto.getDlpudate();
			String puyear = puDateStr.substring(6, 10);
			String pumonth = puDateStr.substring(3, 5);
			String pudate = puDateStr.substring(0, 2);
			String pickupdate = puyear + "-" + pumonth + "-" + pudate;
			logger.info(" pickupdate ::: " + pickupdate);
			Date puDateObj = sdf.parse(pickupdate);
			Calendar puDate = Calendar.getInstance();
			puDate.setTime(puDateObj);
			
			logger.info("------------------------------------Request Values Started---------------------------------------------------------------");
			wayBillGenerationEntity.setModifiedDate(modifiedDate);
			logger.info("ModifiedDate = "+wayBillGenerationEntity.getModifiedDate());
			
			wayBillGenerationEntity.setCBATCHNO( Constants.CBATCHNO);
			logger.info("CBATCHNO = "+wayBillGenerationEntity.getCBATCHNO());
			
			wayBillGenerationEntity.setCATTENTION(generateRequestPdfDto.getCattention());
			logger.info("CATTENTION = "+wayBillGenerationEntity.getCATTENTION());
			
			//wayBillGenerationEntity.setCCALTMOB(generateRequestPdfDto.getCcaltmob());
			//logger.info("CCALTMOB = "+wayBillGenerationEntity.getCCALTMOB());
			
			wayBillGenerationEntity.setCCMDTYCODE( generateRequestPdfDto.getCcmdtycode() );
			logger.info("CCMDTYCODE = "+wayBillGenerationEntity.getCCMDTYCODE());
			
			wayBillGenerationEntity.setCCNEEADR1(generateRequestPdfDto.getCcneeadr1());
			logger.info("CCNEEADR1 = "+wayBillGenerationEntity.getCCNEEADR1());
			
			wayBillGenerationEntity.setCCNEEADR2(generateRequestPdfDto.getCcneeadr2());
			logger.info("CCNEEADR2 = "+wayBillGenerationEntity.getCCNEEADR2());
			
			wayBillGenerationEntity.setCCNEEADR3(generateRequestPdfDto.getCcneeadr3());
			logger.info("CCNEEADR3 = "+wayBillGenerationEntity.getCCNEEADR3());
			
			wayBillGenerationEntity.setCCNEEPIN(generateRequestPdfDto.getCcneepin());
			logger.info("CCNEEPIN = "+wayBillGenerationEntity.getCCNEEPIN());
			
			wayBillGenerationEntity.setCCNEEADRDT(pickupdate);
			logger.info("CCNEEADRDT = "+wayBillGenerationEntity.getCCNEEADRDT());
			
			wayBillGenerationEntity.setCCNEENAME(generateRequestPdfDto.getCcneename());
			logger.info("CCNEENAME = "+wayBillGenerationEntity.getCCNEENAME());
			
			wayBillGenerationEntity.setCCNEEMOB(generateRequestPdfDto.getCcneemob());
			logger.info("CCNEEMOB = "+wayBillGenerationEntity.getCCNEEMOB());			

			wayBillGenerationEntity.setCCUSTADR1(generateRequestPdfDto.getCcustadr1());
			logger.info("CCUSTADR1 = "+wayBillGenerationEntity.getCCUSTADR1());
			
			wayBillGenerationEntity.setCCUSTADR2(generateRequestPdfDto.getCcustadr2());
			logger.info("CCUSTADR2 = "+wayBillGenerationEntity.getCCUSTADR2());
			
			wayBillGenerationEntity.setCCUSTADR3(generateRequestPdfDto.getCcustadr3());
			logger.info("CCUSTADR3 = "+wayBillGenerationEntity.getCCUSTADR3());
			
			wayBillGenerationEntity.setCCUSTCODE( generateRequestPdfDto.getCcustcode() );
			logger.info("CCUSTCODE = "+wayBillGenerationEntity.getCCUSTCODE());
			
			wayBillGenerationEntity.setCCUSTNAME(generateRequestPdfDto.getCcustname());
			logger.info("CCUSTNAME = "+wayBillGenerationEntity.getCCUSTNAME());
			
			wayBillGenerationEntity.setCCUSTPIN(generateRequestPdfDto.getCcustpin());
			logger.info("CCUSTPIN = "+wayBillGenerationEntity.getCCUSTPIN());
			
			wayBillGenerationEntity.setCCUSTTEL(generateRequestPdfDto.getCcusttel());
			logger.info("CCUSTTEL = "+wayBillGenerationEntity.getCCUSTTEL());
			
			wayBillGenerationEntity.setCCUSTMOB(generateRequestPdfDto.getCcustmob());
			logger.info("CCUSTMOB = "+wayBillGenerationEntity.getCCUSTMOB());
			
			
			
			String senderName = generateRequestPdfDto.getCsender();
			if (senderName.length() > 20) {
				wayBillGenerationEntity.setCSENDER(senderName.substring(0, 20));
			} else {
				wayBillGenerationEntity.setCSENDER(senderName);
			}
			logger.info("CSENDER = "+wayBillGenerationEntity.getCSENDER());
			
			wayBillGenerationEntity.setNTOKENNO(generateRequestPdfDto.getTokenno());
			logger.info("NTOKENNO = "+wayBillGenerationEntity.getNTOKENNO());
			
			wayBillGenerationEntity.setIsOverHandlingShipment(generateRequestPdfDto.getOverHandlingShipmnt());
			logger.info("IsOverHandlingShipment = "+wayBillGenerationEntity.getIsOverHandlingShipment());

			wayBillGenerationEntity.setCLPUTIME(generateRequestPdfDto.getClputime());
			logger.info("CLPUTIME = "+wayBillGenerationEntity.getCLPUTIME());
			
			wayBillGenerationEntity.setCKGPOUND(0); // default ckgpound=0
			logger.info("CKGPOUND = "+wayBillGenerationEntity.getCKGPOUND());
			
			wayBillGenerationEntity.setCMRKSNOS1(generateRequestPdfDto.getCmrksnos1());
			logger.info("CMRKSNOS1 = "+wayBillGenerationEntity.getCMRKSNOS1());
			
			wayBillGenerationEntity.setCMRKSNOS2(generateRequestPdfDto.getCmrksnos2());
			logger.info("CMRKSNOS2 = "+wayBillGenerationEntity.getCMRKSNOS2());
			
			wayBillGenerationEntity.setCMRKSNOS3(generateRequestPdfDto.getCmrksnos3());
			logger.info("CMRKSNOS3 = "+wayBillGenerationEntity.getCMRKSNOS3());
			
			if(generateRequestPdfDto.getCcrcrdref()!="" && generateRequestPdfDto.getCcrcrdref()!=null){
				wayBillGenerationEntity.setCCRCRDREF(generateRequestPdfDto.getCcrcrdref());
				logger.info("CCRCRDREF = "+wayBillGenerationEntity.getCCRCRDREF());
			}

			wayBillGenerationEntity.setCOFFCLTIME(generateRequestPdfDto.getCoffcltime());
			logger.info("COFFCLTIME = "+wayBillGenerationEntity.getCOFFCLTIME());
			
			wayBillGenerationEntity.setCORGAREA(generateRequestPdfDto.getCorgarea());
			logger.info("CORGAREA = "+wayBillGenerationEntity.getCORGAREA());
			
			if(generateRequestPdfDto.getIspuregistered().equalsIgnoreCase("N")) {
				wayBillGenerationEntity.setCORGSCRCD(generateRequestPdfDto.getCorgscrcd());
				logger.info("CORGSCRCD = "+wayBillGenerationEntity.getCORGSCRCD());
			}
			
            //commented location code temporarily to test vendor code of shipper
			wayBillGenerationEntity.setCMLOCCODE(generateRequestPdfDto.getCorgscrcd());
			logger.info("CMLOCCODE = "+wayBillGenerationEntity.getCMLOCCODE());
			
			
			//subcode
			wayBillGenerationEntity.setCSUBCODE(generateRequestPdfDto.getCsubcode());
			logger.info("CSUBCODE = "+wayBillGenerationEntity.getCSUBCODE());

			//InvoiceNumber for non-documents
			if(generateRequestPdfDto.getCinvno()!=Constants.EMPTY_STRING && generateRequestPdfDto.getCinvno()!=null) {
				wayBillGenerationEntity.setCINVNO(generateRequestPdfDto.getCinvno());
				logger.info("CINVNO = "+wayBillGenerationEntity.getCINVNO());
				
			}

			//InvoiceDate for non-documents
			Calendar invDate = Calendar.getInstance();
			if (generateRequestPdfDto.getDinvdate() != null && generateRequestPdfDto.getDinvdate() != "" ) {
				String invDateStr = generateRequestPdfDto.getDinvdate();
				String invyear = invDateStr.substring(6, 10);
				String invmonth = invDateStr.substring(3, 5);
				String invdate = invDateStr.substring(0, 2);
				String invoicdate = invyear + "-" + invmonth + "-" + invdate;
				Date invDateObj = sdf.parse(invoicdate);
				invDate.setTime(invDateObj);
				wayBillGenerationEntity.setDINVDATE(invDate);
				logger.info("DINVDATE = "+wayBillGenerationEntity.getDINVDATE());
			}

			//Product code check
			if (generateRequestPdfDto.getCprodcode().equalsIgnoreCase(Constants.INTERNATIONAL_NON_DOCUMENT_PRODCODE)
					|| generateRequestPdfDto.getCprodcode().equalsIgnoreCase(Constants.INTERNATIONAL_DOCUMENT_PRODCODE)) {
				// International flow - common fields
			
				
				
				wayBillGenerationEntity.setCCNEETEL(generateRequestPdfDto.getCcneetel());
				logger.info("CCNEETEL = "+wayBillGenerationEntity.getCCNEETEL());
				
				wayBillGenerationEntity.setCPRODCODE( Constants.INTERNATIONAL_PRODCODE);
				logger.info("CPRODCODE = "+wayBillGenerationEntity.getCPRODCODE());
				
				wayBillGenerationEntity.setCCNTRYCODE(generateRequestPdfDto.getCcntrycode());
				logger.info("CCNTRYCODE = "+wayBillGenerationEntity.getCCNTRYCODE());
				
				if(generateRequestPdfDto.getCcntrycode().equals("AU") || generateRequestPdfDto.getCcntrycode().equals("US")){
					wayBillGenerationEntity.setCSTATECODE(generateRequestPdfDto.getcStateCode());
					logger.info("CSTATECODE = "+wayBillGenerationEntity.getCSTATECODE());
				}
				
				wayBillGenerationEntity.setCINTLCITYNM(generateRequestPdfDto.getCintlcitynm());
				logger.info("CINTLCITYNM = "+wayBillGenerationEntity.getCINTLCITYNM());

				wayBillGenerationEntity.setIsSaturdayDelivery(generateRequestPdfDto.getSaturdayDel());
				logger.info("IsSaturdayDelivery = "+wayBillGenerationEntity.getIsSaturdayDelivery());
				
				wayBillGenerationEntity.setCFLFM(generateRequestPdfDto.getCommNonCom());
				logger.info("CFLFM = "+wayBillGenerationEntity.getCFLFM());
				
				if (generateRequestPdfDto.getCprodcode().equalsIgnoreCase(Constants.INTERNATIONAL_NON_DOCUMENT_PRODCODE)) {
					// International non doc fields
					wayBillGenerationEntity.setCPRODTYPE(Constants.NON_DOCUMENT_PRODTYPE);
					logger.info("CPRODTYPE = "+wayBillGenerationEntity.getCPRODTYPE());

					// Currency code - only for InND
					if(generateRequestPdfDto.getCilloc()!= "" && generateRequestPdfDto.getCilloc()!=null) {
						
						wayBillGenerationEntity.setCILLOC(generateRequestPdfDto.getCilloc());
						logger.info("CILLOC = "+wayBillGenerationEntity.getCILLOC());
					}
					
					//GST related fields
					ArrayOfIntlgstdetails arrayOfIntlgstdetails = new ArrayOfIntlgstdetails();
					Intlgstdetails intlgstdetails = new Intlgstdetails();

					Calendar gstInvDate = Calendar.getInstance();
					if (generateRequestPdfDto.getGstDetailsDto().getCgstinvdate() != "") {
						String gstDateStr = generateRequestPdfDto.getGstDetailsDto().getCgstinvdate();
						String gstyear = gstDateStr.substring(6, 10);
						String gstmonth = gstDateStr.substring(3, 5);
						String gstdate = gstDateStr.substring(0, 2);
						String gstInvdate = gstyear + "-" + gstmonth + "-" + gstdate;
						Date gstDateObj = sdf.parse(gstInvdate);
						gstInvDate.setTime(gstDateObj);
						intlgstdetails.setCgstinvdate(gstInvDate);
						logger.info("Cgstinvdate = "+intlgstdetails.getCgstinvdate());
					}

					intlgstdetails.setCgstinvno(generateRequestPdfDto.getGstDetailsDto().getCgstinvno());
					logger.info("Cgstinvno = "+intlgstdetails.getCgstinvno());
					
					intlgstdetails.setCgstno(generateRequestPdfDto.getGstDetailsDto().getCgstno());
					logger.info("Cgstno = "+intlgstdetails.getCgstno());
					
					intlgstdetails.setCsupofigst(generateRequestPdfDto.getGstDetailsDto().getCsupofigst());
					logger.info("Csupofigst = "+intlgstdetails.getCsupofigst());
					
					intlgstdetails.setCsupofwoigst(generateRequestPdfDto.getGstDetailsDto().getCsupofwoigst());
					logger.info("Csupofwoigst = "+intlgstdetails.getCsupofwoigst());
					
					intlgstdetails.setCtotaligst(generateRequestPdfDto.getGstDetailsDto().getCtotaligst());
					logger.info("Ctotaligst = "+intlgstdetails.getCtotaligst());
					
					intlgstdetails.setCinvoiceno(generateRequestPdfDto.getGstDetailsDto().getCinvoiceno());
					logger.info("Cinvoiceno = "+intlgstdetails.getCinvoiceno());
					
					intlgstdetails.setCinvoicenodate(invDate);
					logger.info("Cinvoicenodate = "+intlgstdetails.getCinvoicenodate());

					arrayOfIntlgstdetails.addIntlgstdetails(intlgstdetails);
					wayBillGenerationEntity.setINTGSTDETAILS(arrayOfIntlgstdetails);
					logger.info("INTGSTDETAILS = "+wayBillGenerationEntity.getINTGSTDETAILS());
					
					wayBillGenerationEntity.setNDCLRDVAL(generateRequestPdfDto.getNdclrdval());
					logger.info("NDCLRDVAL = "+wayBillGenerationEntity.getNDCLRDVAL());
				} else {
					
					// International doc fields
					wayBillGenerationEntity.setCPRODTYPE(Constants.DOCUMENT_PRODTYPE);
					logger.info("CPRODTYPE = "+wayBillGenerationEntity.getCPRODTYPE());

					//GST related fields
					ArrayOfIntlgstdetails arrayOfIntlgstdetails = new ArrayOfIntlgstdetails();
					Intlgstdetails intlgstdetails = new Intlgstdetails();
					arrayOfIntlgstdetails.addIntlgstdetails(intlgstdetails);
					wayBillGenerationEntity.setINTGSTDETAILS(arrayOfIntlgstdetails);
				}
			} else {
				//Domestic flow
				if( generateRequestPdfDto.getCprodcode().equalsIgnoreCase(Constants.DOCUMENT_PRODCODE) ){
					wayBillGenerationEntity.setCPRODTYPE( Constants.DOCUMENT_PRODTYPE);
					logger.info("CPRODTYPE = "+wayBillGenerationEntity.getCPRODTYPE());
				}else {
					//set PRODTYPE as 2 for AIR and GroundPackage
					wayBillGenerationEntity.setCPRODTYPE( Constants.NON_DOCUMENT_PRODTYPE);
					logger.info("CPRODTYPE = "+wayBillGenerationEntity.getCPRODTYPE());
					
					wayBillGenerationEntity.setNDCLRDVAL(generateRequestPdfDto.getNdclrdval());
					logger.info("NDCLRDVAL = "+wayBillGenerationEntity.getNDCLRDVAL());
				}
				wayBillGenerationEntity.setCPRODCODE(generateRequestPdfDto.getCprodcode());
				logger.info("CPRODCODE = "+wayBillGenerationEntity.getCPRODCODE());
				
				wayBillGenerationEntity.setCDSTAREA(generateRequestPdfDto.getCdstarea());
				logger.info("CDSTAREA = "+wayBillGenerationEntity.getCDSTAREA());
				
				wayBillGenerationEntity.setCDSTSCRCD(generateRequestPdfDto.getCdstscrcd());
				logger.info("CDSTSCRCD = "+wayBillGenerationEntity.getCDSTSCRCD());

				// Collectable amount - only for DOD and COD 
				if(generateRequestPdfDto.getNcolamt()>0) {
					wayBillGenerationEntity.setNCOLAMT(generateRequestPdfDto.getNcolamt());
					logger.info("NCOLAMT = "+wayBillGenerationEntity.getNCOLAMT());
				}

				// CFODCODFLG - only for DOD and COD 
				if(generateRequestPdfDto.getCFODCODFLG()!="" && generateRequestPdfDto.getCFODCODFLG()!=null ) {
					wayBillGenerationEntity.setCFODCODFLG(generateRequestPdfDto.getCFODCODFLG());
					logger.info("CFODCODFLG = "+wayBillGenerationEntity.getCFODCODFLG());
				}

				// CCODFAVOUR - only for DOD
				if(generateRequestPdfDto.getCCODFAVOUR()!="" && generateRequestPdfDto.getCCODFAVOUR()!=null) {
					wayBillGenerationEntity.setCCODFAVOUR(generateRequestPdfDto.getCCODFAVOUR());
					logger.info("CCODFAVOUR = "+wayBillGenerationEntity.getCCODFAVOUR());
				}
				
				// CCODPAYBLE - only for DOD 
				if(generateRequestPdfDto.getCCODPAYBLE()!="" && generateRequestPdfDto.getCCODPAYBLE()!=null) {
					wayBillGenerationEntity.setCCODPAYBLE(generateRequestPdfDto.getCCODPAYBLE());
					logger.info("CCODPAYBLE = "+wayBillGenerationEntity.getCCODPAYBLE());
				}
				
				// Cprodfeature - only for FOD and DOD
				if(generateRequestPdfDto.getCprodfeature()!= "" && generateRequestPdfDto.getCprodfeature()!=null) {
					wayBillGenerationEntity.setCprodfeature(generateRequestPdfDto.getCprodfeature());
					logger.info("Cprodfeature = "+wayBillGenerationEntity.getCprodfeature());
				}
			}
			
			
			//Common field mappings
			
			//cincoterms - for Russia
			if(generateRequestPdfDto.getcIncoTerms()!="" && generateRequestPdfDto.getcIncoTerms()!=null){
				wayBillGenerationEntity.setCINCOTERMS(generateRequestPdfDto.getcIncoTerms());
				logger.info("CINCOTERMS = "+wayBillGenerationEntity.getCINCOTERMS());
			}
			
			wayBillGenerationEntity.setISPUREGISTERED(generateRequestPdfDto.getIspuregistered().toUpperCase());
			logger.info("ISPUREGISTERED = "+wayBillGenerationEntity.getISPUREGISTERED());
			
			wayBillGenerationEntity.setNACTWGT(generateRequestPdfDto.getNactwgt());
			logger.info("NACTWGT = "+wayBillGenerationEntity.getNACTWGT());

			//cpacktype - based on selected VAS
			if(generateRequestPdfDto.getCpacktype()!="" && generateRequestPdfDto.getCpacktype()!=null){
				wayBillGenerationEntity.setCPACKTYPE(generateRequestPdfDto.getCpacktype());
				logger.info("CPACKTYPE = "+wayBillGenerationEntity.getCPACKTYPE());
			}
			
			// CMODE - based on selected VAS
			if(generateRequestPdfDto.getCmode()!=Constants.EMPTY_STRING && generateRequestPdfDto.getCmode()!=null) {
				wayBillGenerationEntity.setCMODE( generateRequestPdfDto.getCmode() );
				logger.info("CMODE = "+wayBillGenerationEntity.getCMODE());
			}
			
			// Cfovtype - Risk Flag
			if(generateRequestPdfDto.getCfovtype()!="" && generateRequestPdfDto.getCfovtype()!=null) {
				wayBillGenerationEntity.setCFOVTYPE(generateRequestPdfDto.getCfovtype());
				logger.info("CFOVTYPE = "+wayBillGenerationEntity.getCFOVTYPE());
			}
			
			if(generateRequestPdfDto.getTokenno()>0 ) {
				wayBillGenerationEntity.setNTOKENNO(generateRequestPdfDto.getTokenno());
				logger.info("NTOKENNO = "+wayBillGenerationEntity.getNTOKENNO());
			}
			wayBillGenerationEntity.setDPUDATE(puDate);
			logger.info("DPUDATE = "+wayBillGenerationEntity.getDPUDATE());
			
			wayBillGenerationEntity.setDLPUDATE(puDate);
			logger.info("DLPUDATE = "+wayBillGenerationEntity.getDLPUDATE());

			wayBillGenerationEntity.setCPUTIME(generateRequestPdfDto.getClputime());
			logger.info("CPUTIME = "+wayBillGenerationEntity.getCPUTIME());

			try {
				if(generateRequestPdfDto.getNpcs() >= 1) {
					wayBillGenerationEntity.setNPCS(generateRequestPdfDto.getNpcs());
					logger.info("NPCS = "+wayBillGenerationEntity.getNPCS());
					
					ArrayOfDimensionEntity arrOfDimEntity = new ArrayOfDimensionEntity();
					DimensionEntity dimensionEntity= new DimensionEntity();

					Map<DimensionEntityDto, Integer> dimensionsMap = new HashMap<>();
					if(generateRequestPdfDto.getDimensionEntityDto()!=null){
						logger.info("------------Dimension------------");
						for (DimensionEntityDto dimensionEntityDtoList : generateRequestPdfDto.getDimensionEntityDto()) {
							//Commented by Juhi 20200324
							/*	 double breath = Double.parseDouble(dimensionEntityDtoList.getBreadth());
							dimensionEntity.setBreadth(breath);
							
							logger.info("Breadth = "+dimensionEntity.getBreadth());
							
							double height = Double.parseDouble(dimensionEntityDtoList.getHeight());
							dimensionEntity.setHeight(height);
							
							logger.info("Height = "+dimensionEntity.getHeight());
							double length = Double.parseDouble(dimensionEntityDtoList.getLength());
							dimensionEntity.setLength(length);
							logger.info("Length = "+dimensionEntity.getLength());
*/							
							if (dimensionsMap.containsKey(dimensionEntityDtoList)) {
								Integer count = dimensionsMap.get(dimensionEntityDtoList);
								dimensionsMap.put(dimensionEntityDtoList, count + 1);
							} else {
								Integer count = dimensionsMap.get(dimensionEntityDtoList);
								if (count == null) {
									count = 0;
								}
								dimensionsMap.put(dimensionEntityDtoList, count + 1);
							}
						}
						//Juhi 20200326 : put Dimension Enitity in arrayOfDimensionEntity and their slabWeight using dimensionMap
						/*dimensionsMap.forEach((k,v) ->{
							//dimensionEntity = new DimensionEntity();
							double breath = Double.parseDouble(k.getBreadth());
							dimensionEntity.setBreadth(breath);
							logger.info("Breadth = "+dimensionEntity.getBreadth());
							
							double height = Double.parseDouble(k.getHeight());
							dimensionEntity.setHeight(height);
							logger.info("Height = "+dimensionEntity.getHeight());
							
							double length = Double.parseDouble(k.getLength());
							dimensionEntity.setLength(length);
							logger.info("Length = "+dimensionEntity.getLength());
							
							dimensionEntity.setSlabWeight(v);
							logger.info("SlabWeight = "+dimensionEntity.getSlabWeight());
							
							arrOfDimEntity.addDimensionEntity(dimensionEntity);
						});*/
						 for (Map.Entry<DimensionEntityDto, Integer> map : dimensionsMap.entrySet())  {
							 	dimensionEntity = new DimensionEntity();
								double breath = Double.parseDouble(map.getKey().getBreadth());
								dimensionEntity.setBreadth(breath);
								logger.info("Breadth = "+dimensionEntity.getBreadth());
								
								double height = Double.parseDouble(map.getKey().getHeight());
								dimensionEntity.setHeight(height);
								logger.info("Height = "+dimensionEntity.getHeight());
								
								double length = Double.parseDouble(map.getKey().getLength());
								dimensionEntity.setLength(length);
								logger.info("Length = "+dimensionEntity.getLength());
								
								double slabWeight = (double) map.getValue();
								dimensionEntity.setSlabWeight(slabWeight);
								logger.info("SlabWeight = "+dimensionEntity.getSlabWeight());
								
								arrOfDimEntity.addDimensionEntity(dimensionEntity);
					    } 
						logger.info("------------End Dimension------------");
					} else{																					//Add an else for this
						//Add an else for this
						double slabWeight = (double) dimensionsMap.size();
						dimensionEntity.setSlabWeight(slabWeight);
						logger.info("SlabWeight = "+dimensionEntity.getSlabWeight());
					
						arrOfDimEntity.addDimensionEntity(dimensionEntity);			//Commented by Juhi 20200324
					//Add an else for this
					}
					wayBillGenerationEntity.setDimensions(arrOfDimEntity);
					logger.info("Dimensions = "+wayBillGenerationEntity.getDimensions());
				}else{
					wayBillGenerationEntity.setNPCS(1);
					logger.info("NPCS = "+wayBillGenerationEntity.getNPCS());
				}
			}catch (Exception ex) {
			    logger.error("EXCEPTION TYPE :",ex);
				logger.info("------------------------------------Inside Exception Block of generatePDFData ()---------------------------------------------------------------");
				logger.error("Exception in dimension");
			}
			logger.info("------------------------------------Request Values End---------------------------------------------------------------");
			/*logger.info("modified date ::: " + modifiedDate);
			logger.info("------------------------------------Request Values Started---------------------------------------------------------------");
			logger.info("generateRequestPdfDto.getNpcs() ::: NPCS ::: "+generateRequestPdfDto.getNpcs());
			logger.info("generateRequestPdfDto.getCcmdtycode()::: CCMDTYCODE :::" + generateRequestPdfDto.getCcmdtycode());
			logger.info("generateRequestPdfDto.getCcustcode()::: CCUSTCODE :::" + generateRequestPdfDto.getCcustcode());
			logger.info("generateRequestPdfDto.getTokenno() ::: NTOKENNO :::" + generateRequestPdfDto.getTokenno());
			logger.info("generateRequestPdfDto.getCattention() ::: CATTENTION :::" + generateRequestPdfDto.getCattention());
			logger.info("generateRequestPdfDto.getCcaltmob() ::: CCALTMOB :::" + generateRequestPdfDto.getCcaltmob());
			logger.info("generateRequestPdfDto.getCcneeadr1() ::: CCNEEADR1 :::" + generateRequestPdfDto.getCcneeadr1());
			logger.info("generateRequestPdfDto.getCcneeadr2() ::: CCNEEADR2 :::" + generateRequestPdfDto.getCcneeadr2());
			logger.info("generateRequestPdfDto.getCcneeadr3() ::: CCNEEADR3 :::" + generateRequestPdfDto.getCcneeadr3());
			logger.info("generateRequestPdfDto.getCcneename() ::: CCNEENAME :::" + generateRequestPdfDto.getCcneename());
			logger.info("generateRequestPdfDto.getCcneepin() ::: CCNEEPIN :::" + generateRequestPdfDto.getCcneepin());
			//logger.info("generateRequestPdfDto.getCctmno() ::: CCUSTADR1 :::" + generateRequestPdfDto.getCctmno());
			logger.info("generateRequestPdfDto.getCcustadr1() ::: CCUSTADR1 :::" + generateRequestPdfDto.getCcustadr1());
			logger.info("generateRequestPdfDto.getCcustadr2() ::: CCUSTADR2 :::" + generateRequestPdfDto.getCcustadr2());
			logger.info("generateRequestPdfDto.getCcustadr3()::: CCUSTADR3 ::: " + generateRequestPdfDto.getCcustadr3());
			logger.info("generateRequestPdfDto.getCcustname() ::: CCUSTNAME :::" + generateRequestPdfDto.getCcustname());
			logger.info("generateRequestPdfDto.getCcustpin() ::: CCUSTPIN :::" + generateRequestPdfDto.getCcustpin());
			logger.info("generateRequestPdfDto.getCcneetel() ::: CCNEETEL" + generateRequestPdfDto.getCcneetel());
			logger.info("generateRequestPdfDto.getCcneemob() ::: CCNEEMOB :::" + generateRequestPdfDto.getCcneemob());
			//logger.info("generateRequestPdfDto.getCcneetel() " + generateRequestPdfDto.getCcneetel());
			logger.info("generateRequestPdfDto.getCustel() ::: CCUSTTEL :::" + generateRequestPdfDto.getCcusttel());
			logger.info("generateReqPdfClientDto.getAreaCode()::: " + generateReqPdfClientDto.getAreaCode());
			logger.info("generateReqPdfClientDto.getServiceCentreCode() ::: "+ generateReqPdfClientDto.getServiceCentreCode());
			logger.info("generateRequestPdfDto.getClputime() ::: CLPUTIME ::: " + generateRequestPdfDto.getClputime());
			logger.info("generateRequestPdfDto.getCmloccode() ::: CMLOCCODE :::" + generateRequestPdfDto.getCmloccode());
			logger.info("generateRequestPdfDto.getCoffcltime()::: COFFCLTIME :::" + generateRequestPdfDto.getCoffcltime());
			logger.info("generateRequestPdfDto.getCprodcode() ::: CPRODCODE :::" + generateRequestPdfDto.getCprodcode());
			logger.info("generateRequestPdfDto.getCsender() ::: CSENDER :::" + generateRequestPdfDto.getCsender());
			logger.info("generateRequestPdfDto.getCorgarea() ::: CORGAREA :::" + generateRequestPdfDto.getCorgarea());
			logger.info("generateRequestPdfDto.getCorgscrcd() ::: CORGSCRCD :::" + generateRequestPdfDto.getCorgscrcd());
			logger.info("generateRequestPdfDto.getCdstarea() ::: CDSTAREA :::" + generateRequestPdfDto.getCdstarea());
			logger.info("generateRequestPdfDto.getCdstscrcd() ::: CDSTSCRCD :::" + generateRequestPdfDto.getCdstscrcd());
			logger.info("generateRequestPdfDto.getCcrcrdref() ::: CCRCRDREF :::" + generateRequestPdfDto.getCcrcrdref());
			logger.info("puDate::: " + puDate);
			logger.info("wayBillGenerationEntity.bound ::: CKGPOUND :::" + wayBillGenerationEntity.getCKGPOUND());
			logger.info("isPuRegistered ::: ISPUREGISTERED :::" + generateRequestPdfDto.getIspuregistered().toUpperCase());
			logger.info("generateRequestPdfDto.getNactwgt() ::: Nactwgt :::" + generateRequestPdfDto.getNactwgt());
			logger.info("generateRequestPdfDto.getNcolamt() ::: NCOLAMT ::: " + generateRequestPdfDto.getNcolamt());
			logger.info("generateRequestPdfDto.getNdclrdval() ::: NDCLRDVAL ::: " + generateRequestPdfDto.getNdclrdval());
			logger.info("enerateRequestPdfDto.getNpcs() ::: NPCS ::: " + generateRequestPdfDto.getNpcs());
			logger.info("enerateRequestPdfDto.getCilloc() ::: Cilloc ::: " + generateRequestPdfDto.getCilloc());
			logger.info("CFLFM :::::::::::"+generateRequestPdfDto.getCommNonCom());
			
			//logger.info("generateRequestPdfDto.getNweight() ::: " + generateRequestPdfDto.getNweight());
			logger.info("------------------------------------Request Values End---------------------------------------------------------------");*/
			WaybillGenerationForWebsite waybillGenerationForWebsite2 = new WaybillGenerationForWebsite();
			waybillGenerationForWebsite2.setReq(wayBillGenerationEntity);
			ServiceOperationStub serviceStubObj = new ServiceOperationStub();
			WaybillGenerationForWebsiteResponse waybillGenerationForWebsite1 = serviceStubObj.waybillGenerationForWebsite(waybillGenerationForWebsite2);
			logger.info("waybillGenerationForWebsite Response ::::::::::::::::::::" + waybillGenerationForWebsite1);
		
			logger.info(" waybillGenerationForWebsite1.getWaybillGenerationForWebsiteResult() Response:::::::::::::::::::: "
					+ waybillGenerationForWebsite1.getWaybillGenerationForWebsiteResult());
//			logger.info(" waybillGenerationForWebsite1.errorSpecified() ::: "
//					+ waybillGenerationForWebsite1.getWaybillGenerationForWebsiteResult().getErrors());
			BDResponse wayBillGenerationForWebsiteResult = waybillGenerationForWebsite1.getWaybillGenerationForWebsiteResult();
			logger.info("BDResponse wayBillGenerationForWebsiteResult :::::::::::::::::::: " + wayBillGenerationForWebsiteResult);
//			logger.info("Error ::: " + wayBillGenerationForWebsiteResult.getErrors()+ " ErrorBase "+ wayBillGenerationForWebsiteResult.getErrors().getErrorBase());

			if(wayBillGenerationForWebsiteResult!=null){
				ArrayOfEntityBase arrOfEntityBase = wayBillGenerationForWebsiteResult.getEntities();
				EntityBase[] entityBase = arrOfEntityBase.getEntityBase();
				StringEntity wayBillEntity = (StringEntity) entityBase[0];
				wayBillValue = wayBillEntity.getValue();
				StringEntity tokenNumberEntity = (StringEntity) entityBase[2];
				StringEntity pickUpDateEntity = (StringEntity) entityBase[3];
				StringEntity pdfEntity = (StringEntity) entityBase[4];
				
				logger.info("isErrorsSpecified() ::: "+ wayBillGenerationForWebsiteResult.isErrorsSpecified()+ " ::: wayBillValue ::: "+wayBillValue);
				String emailId = generateRequestPdfDto.getShipperEmailId();
				String ccEmailId = generateRequestPdfDto.getLoggedInUserEmailId();
				if (null == pdfEntity) {
					genererateResponseDto.setValue(wayBillValue);
				} else {
					String pdfData = pdfEntity.getValue();
					byte[] pdfbytearray = Base64.getDecoder().decode(pdfData.getBytes());

					logger.info("Generating PDF Data ::: waybillValue :::" + wayBillValue + "::: pdf data ::: " + pdfData);

					genererateResponseDto.setValue(wayBillValue);
					genererateResponseDto.setPdfbytearray(pdfbytearray);
					
					if(tokenNumberEntity!=null) {
						genererateResponseDto.setTokenNumber(tokenNumberEntity.getValue());
					}
					
					if(pickUpDateEntity!=null) {
						genererateResponseDto.setPickupDate(pickUpDateEntity.getValue());
						logger.info("Pickup Date For Waybill"+wayBillValue+"is "+ pickUpDateEntity.getValue());
					}
					
					genererateResponseDto.setErrorOccured(wayBillGenerationForWebsiteResult.isErrorsSpecified());
					
					if(tokenNumberEntity!=null && pickUpDateEntity!=null){
						sendEmailWithAttachment(pdfbytearray, wayBillValue, emailId, ccEmailId, tokenNumberEntity.getValue(), pickUpDateEntity.getValue());
					}else{
						sendEmailWithAttachment(pdfbytearray, wayBillValue, emailId, ccEmailId, null, null);
					}
				}
			}
		} catch (Exception ex) {
			logger.error("EXCEPTION TYPE :",ex);
			logger.info("Generating PDF Data got Exception " + ex);
			genererateResponseDto.setValue(wayBillValue);
		}
		return genererateResponseDto;
	}

	private void sendEmailWithAttachment(byte[] pdfbytearray, String wayBillNumber, String emailId, String ccEmailId,
			String tokenNumber, String pickupDate) {
		try {

			EmailContent mailContent = null;
			mailContent = new EmailContent();
			boolean notificationSent = false;
			mailContent.setFrom("response@bluedart.com");
			logger.info("emailId in the sending mail::: " + emailId);
			mailContent.setTo(emailId);
			mailContent.setCc(ccEmailId); 
			mailContent.setSubject("Blue Dart >> Book A Shipment");

			Multipart mp = new MimeMultipart();
			
			if(tokenNumber==null && pickupDate==null){
				MimeBodyPart mbp1 = new MimeBodyPart();
				StringBuffer message = new StringBuffer();
				MimeBodyPart mbp2 = new MimeBodyPart();
				mbp2.setDataHandler(new DataHandler(new ByteArrayDataSource(pdfbytearray, "application/pdf")));
				mbp2.setFileName("BookAShipment_"+wayBillNumber+".pdf");
				message.append("Thank you for booking the shipment with us.");
				message.append("Your Waybill Number is " + wayBillNumber+ ". Please use this number for future references.");
				mbp1.setText(message.toString());
				mp.addBodyPart(mbp1);
				mp.addBodyPart(mbp2);
			}else{
				MimeBodyPart mbp1 = new MimeBodyPart();
				StringBuffer message = new StringBuffer();
				MimeBodyPart mbp2 = new MimeBodyPart();
				mbp2.setDataHandler(new DataHandler(new ByteArrayDataSource(pdfbytearray, "application/pdf")));
				String strDate= "";
				if(pickupDate!="" && pickupDate!=null){
					Date date = new Date(pickupDate);  
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
					strDate= formatter.format(date);  
				}
				mbp2.setFileName("BookAShipment_"+wayBillNumber+".pdf");
				message.append("Thank you for booking the shipment with us.");
				message.append(" Kindly note your pick up is scheduled on "+strDate+" and your Token Number is "+tokenNumber+".");
				message.append("Your Waybill Number is " + wayBillNumber+". Please use this number for future references.");
				mbp1.setText(message.toString());
				mp.addBodyPart(mbp1);
				mp.addBodyPart(mbp2);
			}

			Map<String, Object> deactivateUserModel = new HashMap<>();
			deactivateUserModel.put("wayBillNumber", wayBillNumber);
			mailContent.setModel(deactivateUserModel);
			try {
				//notificationSent = EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp, "bookAShipment-template.vm");
				notificationSent = EmailUtil.sendEmailWithImageAndAttachment(mailContent, mp,
						"bookAShipment-template.vm");
				logger.info("pdf download ::: " + notificationSent);
			} catch (Exception e) {
				logger.error("EXCEPTION TYPE :",e);
				logger.info("BookAshipment : Message is not Delivered." + e);
			}
		} catch (Exception e1) {
			logger.error("EXCEPTION TYPE :",e1);
			logger.debug("BookAshipment : Email is not Delivered." + e1);
		}
	}
}
