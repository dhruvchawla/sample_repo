package com.bluedart.trackdart.daoImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.bluedart.common.dto.PodDto;
import com.bluedart.common.dto.ShipmentDto;
import com.bluedart.common.dto.TrackDto;
import com.bluedart.utils.Constants;
import com.bluedart.utils.DateUtil;
import com.bluedart.utils.StringUtils;

public class TrackDartHelper {

	private static final Logger logger = Logger.getLogger(TrackDartHelper.class);

	private TrackDartHelper() {
	}

	/**
	 * 
	 * @param trackDto
	 * @param isAwbNos
	 * @param loginId
	 * @return
	 */
	public static TrackDto getTrackDetails(TrackDto trackDto, boolean isAwbNos, String loginId) {
		logger.debug(" TrackDartHelper : getTrackDetails ");
		List<ShipmentDto> shipmentDtoList = null;
		StringBuilder noRecFound = null;
		StringBuilder noInfoFound = null;
		if (null != trackDto && null != trackDto.getShipmentList() && !trackDto.getShipmentList().isEmpty()) {
			shipmentDtoList = new ArrayList<>();
			noRecFound = new StringBuilder();
			noInfoFound = new StringBuilder();
			for (ShipmentDto shipmentDto : trackDto.getShipmentList()) {
				boolean isValid = true;
				if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_NOTFOUND)) {
					if (isAwbNos) {
						noRecFound.append(shipmentDto.getCawbno());
						noRecFound.append(",");
					} else {
						noRecFound.append(shipmentDto.getCrefno());
						noRecFound.append(",");
					}
					isValid = false;
					trackDto.setNoRecFound(noRecFound.toString());
				} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_NOINFO)) {
					if (isAwbNos) {
						noInfoFound.append(shipmentDto.getCawbno());
						noInfoFound.append(",");
					} else {
						noInfoFound.append(shipmentDto.getCrefno());
						noInfoFound.append(",");
					}
					isValid = false;
					trackDto.setNoInfoFound(noInfoFound.toString());
				}

				if (isValid) {
					trackDto.setValidShiments("Y");
					List<PodDto> podDtoList = new ArrayList<>();
					if (null != loginId) {
						shipmentDto = shipmentDetailsForLoggedInUser(getProperCase(shipmentDto),
								trackDto.getSecLevel());
					} else {
						shipmentDto = shipmentDetailsForGuestUser(getProperCase(shipmentDto));
					}

					PodDto podDto;
					if (null != trackDto.getShipmentList() && null != trackDto.getPodList()
							&& !trackDto.getPodList().isEmpty() && null != shipmentDto) {
						for (PodDto dto : trackDto.getPodList()) {

							if (dto.getPcawbno().equalsIgnoreCase(shipmentDto.getCawbno())) {
								podDto = getValidPodDetails(dto, trackDto.getSecLevel());
								podDtoList.add(podDto);
								shipmentDto.setPodDtoList(podDtoList);
							}
						}
					}

				}
				shipmentDtoList.add(shipmentDto);
				trackDto.setShipmentList(shipmentDtoList);
			} // Shipment loop end
		} else { // If End
			trackDto = null;
		}

		return trackDto;
	}

	/**
	 * 
	 * @param shipmentDto
	 * @param secLevel
	 * @return Logged in User
	 */
	private static ShipmentDto shipmentDetailsForLoggedInUser(ShipmentDto shipmentDto, int secLevel) {
		logger.debug(" TrackDartHelper : shipmentDetailsForLoggedInUser ");
		Date expetDateDlv = null;
		if (null != shipmentDto.getDeptdtdlv()) {
			expetDateDlv = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDeptdtdlv());
			shipmentDto.setDeptdtdlv(StringUtils.getStringFormGivenDateFormat(expetDateDlv, Constants.DEFAULT_FORMAT));
		}

		Date statDate = null;
		if (null != shipmentDto.getDstatdate()) {
			statDate = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDstatdate());
		}

		if (null != shipmentDto.getDpudate()) {
			Date pudate = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDpudate());
			if (null != shipmentDto.getCprodcode() && "X".equalsIgnoreCase(shipmentDto.getCprodcode())) {
				shipmentDto.setFormalDateFlag("Y");
			} else {
				shipmentDto.setPickupDateFlag("Y");
			}
			shipmentDto.setDpudate(StringUtils.getStringFormGivenDateFormat(pudate, Constants.DEFAULT_FORMAT));
		}

		if (null != shipmentDto.getCorgscrdesc()) {
			if (null != shipmentDto.getCprodcode() && ("X".equalsIgnoreCase(shipmentDto.getCprodcode())
					|| "V".equalsIgnoreCase(shipmentDto.getCprodcode()))) {
				shipmentDto.setCountryOrigin("Y");
			} else {
				shipmentDto.setFrom("Y");
			}
		}

		if (null != shipmentDto.getCdstscrdesc()) {
			if (null != shipmentDto.getCprodcode() && "I".equalsIgnoreCase(shipmentDto.getCprodcode())) {
				shipmentDto.setCountryDelivery("Y");
			} else {
				shipmentDto.setTo("Y");
			}
		}

		String prodTypeDesc = null;
		if (null == shipmentDto.getCprodtype() || "1".equalsIgnoreCase(shipmentDto.getCprodtype())) {
			shipmentDto.setShowProdType("Y");
			prodTypeDesc = "Documents";
		} else {
			shipmentDto.setShowProdType("Y");
			prodTypeDesc = "Non Documents";
		}
		shipmentDto.setCprodtype(prodTypeDesc);

		if (secLevel > 0) {
			shipmentDto.setSecLevelFlag("0");
			if (secLevel > 1) {
				shipmentDto.setSecLevelFlag("1");
				String packTypeDesc = null;
				if (null != shipmentDto.getCpacktype()) {
					if ("E".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "Envelope";
					} else if ("P".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "Fedex Pack";
					} else if ("O".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "Others";
					} else if ("F".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "IPF";
					} else if ("1".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "10 Kg Fedex Box";
					} else if ("2".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "25 Kg Fedex Box";
					} else if ("A".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "10 Kg Smart Box";
					} else if ("B".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "25 Kg Smart Box";
					} else if ("M".equalsIgnoreCase(shipmentDto.getCpacktype())) {
						packTypeDesc = "Multipart Smart Box";
					} else {
						packTypeDesc = "Others";
					}
					shipmentDto.setCpacktype(packTypeDesc);
					shipmentDto.setShowPackType("Y");
				} else if (!"X".equalsIgnoreCase(shipmentDto.getCprodcode())
						|| !"I".equalsIgnoreCase(shipmentDto.getCprodcode())) {
					shipmentDto.setCpacktype(null);
				}
			}
		}

		if (null != shipmentDto.getCstatus()) {
			shipmentDto.setShowStatus("Y");
			if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED)) {
				shipmentDto.setDeliveryProgressBar("Y");
				if ((null != expetDateDlv && null != statDate)
						&& ((statDate.compareTo(expetDateDlv) == 0) || statDate.before(expetDateDlv))) {
					shipmentDto.setShowTick("Y");
				}

				// Remove PIPE (|).
				if (secLevel == 1) {
					String[] valueSplit = shipmentDto.getCstatdesc2().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				}
				if (secLevel > 1) {
					String[] valueSplit = shipmentDto.getCstatdesc().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				} else {
					String[] valueSplit = shipmentDto.getCstatdesc1().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				}

				if (null != shipmentDto.getCstatcode() && null != shipmentDto.getCstattype()
						&& ("000".equalsIgnoreCase(shipmentDto.getCstatcode()))
						&& ("T".equalsIgnoreCase(shipmentDto.getCstattype()))) {
					if (statDate != null) {
						shipmentDto.setDateOfDelivery("Y");
						shipmentDto.setDstatdate(
								StringUtils.getStringFormGivenDateFormat(statDate, Constants.DEFAULT_FORMAT));
					}
					if (null != shipmentDto.getCstattime() && shipmentDto.getCstattime().length() >= 4) {
						shipmentDto.setTimeOfDelivery("Y");
						String time = shipmentDto.getCstattime().substring(0, 2) + ":"
								+ shipmentDto.getCstattime().substring(2);
						shipmentDto.setCstattime(time);
					}
				}

			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_INTRANSIT)) {
				shipmentDto.setInTransitProgressBar("Y");
				if (null != expetDateDlv) {
					shipmentDto.setExptDateOfDelivery("Y");
					shipmentDto.setDeptdtdlv(
							StringUtils.getStringFormGivenDateFormat(expetDateDlv, Constants.DEFAULT_FORMAT));
				}
				shipmentDto.setCstatdesc("In Transit Await Delivery Information");

			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_UNDELIVERED)) {
				shipmentDto.setInTransitProgressBar("Y");
				if (null != expetDateDlv) {
					shipmentDto.setExptDateOfDelivery("Y");
					shipmentDto.setDeptdtdlv(
							StringUtils.getStringFormGivenDateFormat(expetDateDlv, Constants.DEFAULT_FORMAT));
				}
				if (secLevel == 1) {
					String[] valueSplit = shipmentDto.getCstatdesc2().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				}
				if (secLevel > 1) {
					String[] valueSplit = shipmentDto.getCstatdesc().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				} else {
					String[] valueSplit = shipmentDto.getCstatdesc1().split("\\|");
					shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
				}

			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
					|| shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) {
				shipmentDto.setInTransitProgressBar("Y");
				if (null != shipmentDto.getCnewawbno() && shipmentDto.getCnewawbno().length() > 0) {
					shipmentDto.setNewWayBillNo("Y");
				}
			}
		}

		if (null != shipmentDto.getCstatcode() && null != shipmentDto.getCstattype()
				&& "000".equalsIgnoreCase(shipmentDto.getCstatcode())
				&& "T".equalsIgnoreCase(shipmentDto.getCstattype())) {
			shipmentDto.setDateOfDelivery("Y");
		}

		if (null != shipmentDto.getCsplinst()) {
			shipmentDto.setSplinst("Y");
		}

		shipmentDto.setCstatdesc(StringUtils.properCase(shipmentDto.getCstatdesc()));

		return shipmentDto;
	}

	/**
	 * 
	 * @param shipmentDto
	 * @return Guest User
	 */
	private static ShipmentDto shipmentDetailsForGuestUser(ShipmentDto shipmentDto) {
		logger.debug(" TrackDartHelper : shipmentDetailsForGuestUser ");
		Date expetDateDlv = null;
		Date statDate = null;

		if (null != shipmentDto.getDeptdtdlv()) {
			expetDateDlv = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDeptdtdlv());
		}

		if (null != shipmentDto.getDstatdate()) {
			statDate = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDstatdate());
		}

		if (null != shipmentDto.getDpudate()) {
			Date pudate = StringUtils.getDateFromStringDefaultFormat(shipmentDto.getDpudate());
			if (null != pudate) {
				if (null != shipmentDto.getCprodcode() && "X".equalsIgnoreCase(shipmentDto.getCprodcode())) {
					shipmentDto.setFormalDateFlag("Y");
				} else {
					shipmentDto.setPickupDateFlag("Y");
				}
				shipmentDto.setDpudate(StringUtils.getStringFormGivenDateFormat(pudate, Constants.DEFAULT_FORMAT));
			}
		}

		if (null != shipmentDto.getCorgscrdesc()) {
			if (null != shipmentDto.getCprodcode()
					&& ("X".equalsIgnoreCase(shipmentDto.getCprodcode()) || "V".equals(shipmentDto.getCprodcode()))) {
				shipmentDto.setCountryOrigin("Y");
			} else {
				shipmentDto.setFrom("Y");
			}
		}

		if (null != shipmentDto.getCdstscrdesc()) {
			if (null != shipmentDto.getCprodcode() && "I".equalsIgnoreCase(shipmentDto.getCprodcode())) {
				shipmentDto.setCountryDelivery("Y");
			} else {
				shipmentDto.setTo("Y");
			}
		}

		if (null != shipmentDto.getCstatus()) {
			shipmentDto.setShowStatus("Y");
			if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_DELIVERED)) {
				shipmentDto.setDeliveryProgressBar("Y");
				if ((null != expetDateDlv && null != statDate)
						&& ((statDate.compareTo(expetDateDlv) == 0) || statDate.before(expetDateDlv))) {
					shipmentDto.setShowTick("Y");
				}

				if (null != shipmentDto.getCstatcode() && null != shipmentDto.getCstattype()
						&& ("000".equalsIgnoreCase(shipmentDto.getCstatcode()))
						&& ("T".equalsIgnoreCase(shipmentDto.getCstattype()))) {
					if (statDate != null) {
						shipmentDto.setDateOfDelivery("Y");
						shipmentDto.setDstatdate(
								StringUtils.getStringFormGivenDateFormat(statDate, Constants.DEFAULT_FORMAT));
					}
					if (null != shipmentDto.getCstattime() && shipmentDto.getCstattime().length() >= 4) {
						shipmentDto.setTimeOfDelivery("Y");
						String time = shipmentDto.getCstattime().substring(0, 2) + ":"
								+ shipmentDto.getCstattime().substring(2);
						shipmentDto.setCstattime(time);
					}
				}

			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_INTRANSIT)) {
				shipmentDto.setInTransitProgressBar("Y");
				if (null != expetDateDlv) {
					shipmentDto.setExptDateOfDelivery("Y");
					shipmentDto.setDeptdtdlv(
							StringUtils.getStringFormGivenDateFormat(expetDateDlv, Constants.DEFAULT_FORMAT));
				}
				shipmentDto.setCstatdesc("In Transit Await Delivery Information");

			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_UNDELIVERED)) {
				shipmentDto.setInTransitProgressBar("Y");

				if (null != expetDateDlv) {
					shipmentDto.setExptDateOfDelivery("Y");
					shipmentDto.setDeptdtdlv(
							StringUtils.getStringFormGivenDateFormat(expetDateDlv, Constants.DEFAULT_FORMAT));
				}
				String[] valueSplit = shipmentDto.getCstatdesc1().split("\\|");
				shipmentDto.setCstatdesc(StringUtils.properCase(valueSplit[0]));
			} else if (shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_REDIRECTED)
					|| shipmentDto.getCstatus().equalsIgnoreCase(Constants.TNT_RTO)) {
				shipmentDto.setInTransitProgressBar("Y");
				if (shipmentDto.getCnewawbno() != null && shipmentDto.getCnewawbno().length() > 0) {
					shipmentDto.setNewWayBillNo("Y");
				}
			}
		}

		if ((null != expetDateDlv)
				&& (((java.lang.Math.abs(expetDateDlv.getTime() - DateUtil.getCurrentSqlDate().getTime()) < 86400000)
						|| ((expetDateDlv.getTime() - DateUtil.getCurrentSqlDate().getTime()) > 86400000)
								&& shipmentDto.getCstatus().equals(Constants.TNT_INTRANSIT))
						|| ((statDate != null)
								&& (statDate.compareTo(expetDateDlv) == 0 || statDate.before(expetDateDlv))))
				&& (!shipmentDto.getCstatus().equals(Constants.TNT_DELIVERED))
				&& !shipmentDto.getCstatus().equals(Constants.TNT_UNDELIVERED)) {
			shipmentDto.setExptDateOfDelivery("Y");
			shipmentDto.setDeptdtdlv(StringUtils.getStringFormGivenDateFormat(expetDateDlv, "dd MMM yyyy"));
		}

		if (null != shipmentDto.getCstatcode() && null != shipmentDto.getCstattype()
				&& shipmentDto.getCstatcode().equalsIgnoreCase("000")
				&& shipmentDto.getCstattype().equalsIgnoreCase("T")) {
			shipmentDto.setDateOfDelivery("Y");
		}

		shipmentDto.setCstatdesc(StringUtils.properCase(shipmentDto.getCstatdesc()));

		return shipmentDto;
	}

	private static PodDto getValidPodDetails(PodDto podDto, int secLevel) {
		logger.debug(" TrackDartHelper : getValidPodDetails ");
		podDto.setPclocdesc(StringUtils.properCase(podDto.getPclocdesc()));
		if (secLevel == 1) {
			String[] valueSplit = podDto.getPcstatdesc2().split("\\|");
			podDto.setPcstatdesc(StringUtils.properCase(valueSplit[0]));
		} else if (secLevel > 1) {
			String[] valueSplit = podDto.getPcstatdesc().split("\\|");
			podDto.setPcstatdesc(StringUtils.properCase(valueSplit[0]));
		} else {
			String statusdesc1First = "";
			String statusdesc1Next = "";
			if (podDto.getPcstatdesc1() != null) {
				StringTokenizer tokenizedLine = new StringTokenizer(podDto.getPcstatdesc1(), "|");
				if (tokenizedLine.hasMoreTokens()) {
					statusdesc1First = (tokenizedLine.nextToken()).trim();
					if (tokenizedLine.hasMoreTokens()) {
						statusdesc1Next = (tokenizedLine.nextToken()).trim();
					}
				} else {
					statusdesc1First = podDto.getPcstatdesc1();
				}
			}

			String[] statusdesc1FirstSplit = statusdesc1First.split("\\|");
			String[] statusdesc1NextSplit = statusdesc1Next.split("\\|");
			statusdesc1First = StringUtils.properCase(statusdesc1FirstSplit[0]);
			statusdesc1Next = StringUtils.properCase(statusdesc1NextSplit[0]);
			podDto.setPcstatdesc(statusdesc1First + " " + statusdesc1Next);
		}

		Date statDate = StringUtils.getDateFromStringDefaultFormat(podDto.getPdstatdate());
		podDto.setPdstatdate(StringUtils.getStringFormGivenDateFormat(statDate, "dd MMM yyyy"));

		if (podDto.getPcstattime() != null && podDto.getPcstattime().length() >= 4) {
			String time = podDto.getPcstattime().substring(0, 2) + ":" + podDto.getPcstattime().substring(2);
			podDto.setPcstattime(time);
		}

		return podDto;
	}

	private static ShipmentDto getProperCase(ShipmentDto shipmentDto) {
		logger.debug(" TrackDartHelper : getProperCase ");
		shipmentDto.setCproddesc(StringUtils.properCase(shipmentDto.getCproddesc()));
		shipmentDto.setCorgscrdesc(StringUtils.properCase(shipmentDto.getCorgscrdesc()));
		shipmentDto.setCorgareadesc(StringUtils.properCase(shipmentDto.getCorgareadesc()));
		shipmentDto.setCdstscrdesc(StringUtils.properCase(shipmentDto.getCdstscrdesc()));
		shipmentDto.setCdstareadesc(StringUtils.properCase(shipmentDto.getCdstareadesc()));
		shipmentDto.setCprodtype(StringUtils.properCase(shipmentDto.getCprodtype()));
		shipmentDto.setCshpcname(StringUtils.properCase(shipmentDto.getCshpcname()));
		shipmentDto.setCsender(StringUtils.properCase(shipmentDto.getCsender()));
		shipmentDto.setCattention(StringUtils.properCase(shipmentDto.getCattention()));
		shipmentDto.setCconscadr1(StringUtils.properCase(shipmentDto.getCconscadr1()));
		shipmentDto.setCconscadr2(StringUtils.properCase(shipmentDto.getCconscadr2()));
		shipmentDto.setCconscadr3(StringUtils.properCase(shipmentDto.getCconscadr3()));
		shipmentDto.setCfocdesc(StringUtils.properCase(shipmentDto.getCfocdesc()));
		shipmentDto.setCpacktype(StringUtils.properCase(shipmentDto.getCpacktype()));
		shipmentDto.setCcmdtyname(StringUtils.properCase(shipmentDto.getCcmdtyname()));
		shipmentDto.setCrecdby(StringUtils.properCase(shipmentDto.getCrecdby()));
		shipmentDto.setCrelation(StringUtils.properCase(shipmentDto.getCrelation()));
		shipmentDto.setCidtype(StringUtils.properCase(shipmentDto.getCidtype()));
		return shipmentDto;
	}

}
