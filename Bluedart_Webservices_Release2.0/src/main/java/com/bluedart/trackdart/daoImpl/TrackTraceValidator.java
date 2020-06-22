package com.bluedart.trackdart.daoImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bluedart.utils.StringUtils;

/**
 * 
 * @author DH839598
 *
 */
@Component
public class TrackTraceValidator {
	
	private TrackTraceValidator() {
	}
	
	/**
	 * 
	 * @param awbNos
	 * @param listInvalidAwbNos
	 * @return
	 */
	public static List<String> getListOfAwbNos(String awbNos, List<String> listInvalidAwbNos){
		List<String> listOfGivenNos = getNos(awbNos);
		return getAwbNosToTrack(listOfGivenNos, listInvalidAwbNos);
	}
	
	/**
	 * 
	 * @param refNos
	 * @param listInvalidRefNos
	 * @return
	 */
	public static List<String> getListOfRefNos(String refNos,List<String> listInvalidRefNos){
		List<String> listOfGivenNos = getNos(refNos);
		return getRefNosToTrack(listOfGivenNos,listInvalidRefNos);
	}
	
	/**
	 * 
	 * @param listOfGivenNos
	 * @return
	 */
	public static List<String> getListOfRefNos(List<String> listOfGivenNos) {
		List<String> listOfValidRefNosList = getRefNosToTrack(listOfGivenNos);
		return listOfValidRefNosList;
	}
	
	/**
	 * 
	 * @param listOfGivenNos
	 * @param listInvalidAwbNos
	 * @return
	 */
	public static List<String> getListOfAwbNos(List<String> listOfGivenNos, List<String> listInvalidAwbNos) {
		List<String> listOfValidAwbNosList = getAwbNosToTrack(listOfGivenNos, listInvalidAwbNos);
		return listOfValidAwbNosList;
	}
	
	/**
	 * 
	 * @param givenNos
	 * @return
	 */
	private static List<String> getNos(String givenNos) {
		List<String> listOfGivenNos = null;
		if (givenNos != null && givenNos.length() > 0) {
			listOfGivenNos = StringUtils.StringSplit(givenNos, ",");
		}	
		return listOfGivenNos;
	}
	
	/**
	 * 
	 * @param refNos
	 * @return
	 */
	private static List<String> getRefNosToTrack(List<String> refNos) {
		List<String> listOfRefNos = new ArrayList<>();
		for (String refNo : refNos) {
			boolean flag = isValidRefNo(refNo);
			if (flag) {
				listOfRefNos.add(refNo);
			}
		}
		List<String> uniqueRefnos = new ArrayList<String>(new LinkedHashSet<String>(listOfRefNos));
		return uniqueRefnos;
	}
	
	/**
	 * 
	 * @param awbNos
	 * @param listInvalidAwbNos
	 * @return
	 */
	private static List<String> getAwbNosToTrack(List<String> awbNos, List<String> listInvalidAwbNos) {
		List<String> listOfAwbNos = new ArrayList<>();
		for (String awbNo : awbNos) {
			boolean flag = isValidAwsNo(awbNo);
			if (flag) {
				listOfAwbNos.add(awbNo);
			} else {
				listInvalidAwbNos.add(awbNo);
			}
		}
		return new ArrayList<>(new LinkedHashSet<String>(listOfAwbNos));
	}
	
	/**
	 * 
	 * @param refNos
	 * @param listInvalidRefNos
	 * @return
	 */
	private static List<String> getRefNosToTrack(List<String> refNos, List<String> listInvalidRefNos) {
		listInvalidRefNos = new ArrayList<>();
		List<String> listOfRefNos = new ArrayList<>();
		for (String refNo : refNos) {
			boolean flag = isValidRefNo(refNo);
			if (flag) {
				listOfRefNos.add(refNo);
			} else {
				listInvalidRefNos.add(refNo);
			}
		}
		return new ArrayList<>(new LinkedHashSet<String>(listOfRefNos));
	}
	
	/**
	 * 
	 * @param awbNo
	 * @return
	 */
	private static boolean isValidAwsNo(String awbNo) {
		boolean valid = false;
		if (awbNo.length() >= 8 && awbNo.length() <= 12) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * 
	 * @param refNo
	 * @return
	 */
	private static boolean isValidRefNo(String refNo) {
		boolean valid = false;
		if (refNo.length() >= 0 && refNo.length() <= 20) {
			valid = true;
		}
		return valid;
	}

}
