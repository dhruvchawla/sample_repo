package com.bluedart.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author DH839598
 *
 */

public final class StringUtils {

	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean isValidEmail(String emailStr) {
		pattern = Pattern.compile(Constants.EMAIL_PATTERN);
		matcher = pattern.matcher(emailStr);
		return matcher.matches();

	}

	/**
	 * This method will split the String based on the SplitType
	 */
	public static List<String> StringSplit(String givenStr, String splitType) {
		String[] out = null;
		ArrayList<String> listOfSplittedStr = null;
		if (givenStr.contains(splitType)) {
			out = givenStr.split(splitType);
		}
		if (out != null) {
			listOfSplittedStr = new ArrayList<String>(Arrays.asList(out));
		} else {
			listOfSplittedStr = new ArrayList<String>();
			listOfSplittedStr.add(givenStr);
		}
		return listOfSplittedStr;
	}

	/**
	 * checks if string is empty or null or all spaces etc.
	 */
	public static boolean hasValid(String str) {
		if (str == null || str.trim().equals(""))
			return false;
		else
			return true;
	}

	/**
	 * checks if string has only digit
	 */
	public static boolean hasOnlyDigit(String str) {
		if (str == null)
			return false;
		char[] strChars = new char[str.length()];
		str.getChars(0, str.length(), strChars, 0);
		for (char ch : strChars) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * checks if string has only alpha numeric content
	 */
	public static boolean hasAlphaNumeric(String str) {
		boolean success = true;
		char[] strChars = new char[str.length()];
		for (char ch : strChars) {
			if (!Character.isLetterOrDigit(ch)) {
				success = false;
				return (success);
			}
		}
		return (success);
	}

	/**
	 * checks if is a valid amount. ie., if the amount is in the set {0-9 . , $
	 * }
	 */
	public static boolean isValidAmount(String str) {
		char[] strChars = new char[str.length()];
		str.getChars(0, str.length(), strChars, 0);
		for (char ch : strChars) {
			if (!Character.isDigit(ch) && ch != '.' && ch != '$' && ch != ',') {
				return false;
			}
		}
		return true;
	}

	/**
	 * checks if the input string starts with an alphabet
	 */
	public static boolean startsWithAlphabet(String str) {
		boolean success = false;
		if (str != null && Character.isLetter(str.charAt(0)))
			success = true;
		return (success);
	}

	/**
	 * This method remove commas from Number
	 */
	public static String removeCommasFromNumber(String str) {
		String newValue = "";
		for (int index = 0; index < str.length(); index++) {
			if (str.charAt(index) != ',')
				newValue += str.charAt(index);
		}
		return newValue;
	}
	/**
	 * @param c
	 * @return
	 * If list is null/Empty, than It will return true.
	 */
	public static boolean isNullOrEmpty( final Collection< ? > c ) {
	    return c == null || c.isEmpty();
	}
	
	public static boolean isNullOrEmpty( final String[] c ) {
	    return c == null;
	}

	public static Date getDateFromStringDefaultFormat(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date dateVal = sdf.parse(date);
			Date sqlDate = new Date(dateVal.getTime());
			return sqlDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getStringFormGivenDateFormat(Date date, String givenDateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(givenDateFormat);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static String properCase(String inputstring) {
		  if(inputstring == null) return null;
		  String u = inputstring.toUpperCase();
		  String specialChars = " ~`@#$%^&*()_-+={}[]|\\:;\"'<>,.?/1234567890";
		  String fixedProperCase = "";
		  char twoPast = ' ';
	      char lastChar = ' ';
		  char char1;
		  int place;
		  for (place=0; place < inputstring.length(); place++) {
			char1 = u.charAt(place);      
			if (specialChars.indexOf(lastChar) != -1) {
				if ((lastChar == '\'') && (twoPast != 'D')) {
					char1 = Character.toUpperCase(char1);
				}
			}else { 
				char1 = Character.toLowerCase(char1);
			}
			fixedProperCase += char1;
			twoPast = lastChar;
			lastChar = char1;
		 }   
	     fixedProperCase = fixedProperCase.trim();
		 return fixedProperCase;
	}
	
	/**
	 * To Remove last Comma
	 * @param givenStr
	 * @return
	 */
	public static String removeLastComma(String givenStr){
		String commaremovedStr = null;
		if (null != givenStr && givenStr.length() > 0) {
			commaremovedStr =  givenStr.substring(0, givenStr.length() - 1);
		} 
		return commaremovedStr;
	}
	
	/**
	 * 
	 * @param givenNos
	 * @return
	 */
	public static List<String> getListFromStringWithComma(String givenName) {
		List<String> listOfModuleName = null;
		if (givenName != null && givenName.length() > 0) {
			listOfModuleName = StringUtils.StringSplit(givenName, ",");
		}	
		return listOfModuleName;
	}
	
	 
}
