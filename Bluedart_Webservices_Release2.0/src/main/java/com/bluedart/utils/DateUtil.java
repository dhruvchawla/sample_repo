package com.bluedart.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author DH839598
 *
 */

public final class DateUtil {
	
	private DateUtil() { }
	
	private static final long millis45Days = 3888000000L;  
	private static final long millis60Days = 5184000000L;  
	private static final long millis90Days = 7776000000L;  

	/**
	 * Converts SQL date to String with default Format.
	 */
	public static String convertDefaultFormat(java.sql.Date sqlDate) {
		if (sqlDate == null) {
			return null;
		}
		DateFormat defaultDateFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
		return defaultDateFormat.format(new Date(sqlDate.getTime()));
	}

	/**
	 * Converts SQL date to String with given Format.
	 */
	public static String convertGivenFormat(java.sql.Date sqlDate, String dateFormat) {
		if (sqlDate == null) {
			return null;
		}
		DateFormat defaultDateFormat = new SimpleDateFormat(dateFormat);
		return defaultDateFormat.format(new Date(sqlDate.getTime()));
	}

	/**
	 * Converts Util date to SQL Date Format.
	 */
	public static java.sql.Date convertSQLDate(Date utilDate) {
		if (utilDate == null) {
			return null;
		}
		return new java.sql.Date(utilDate.getTime());
	}

	/**
	 * This method return util Date from String Object with default format.
	 */
	public static Date getDateFromStringDefaultFormat(String date) {
		return getDateFromString(date, Constants.DEFAULT_DATE_FORMAT);
	}

	/**
	 * This method return util Date from String Object with given Format.
	 */
	public static Date getDateFromStringGivenFormat(String date, String givenFormat) {
		return getDateFromString(date, givenFormat);
	}

	/**
	 * This method return SQL Date from String Object with default Format.
	 */
	public static java.sql.Date getFormatedSqlDateDefaultFormat(String date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		return new java.sql.Date(getDateFromString(date, Constants.DEFAULT_DATE_FORMAT).getTime());
	}

	/**
	 * This method return SQL Date from String Object with default Format.
	 */
	public static java.sql.Date getFormatedSqlDateGivenFormat(String date, String givenFomat) {
		if (date == null || "".equals(date)) {
			return null;
		}
		return new java.sql.Date(getDateFromString(date, givenFomat).getTime());
	}

	private static Date getDateFromString(String date, String pattern) {
		try {
			if (date == null || "".equals(date)) {
				return null;
			}
			SimpleDateFormat df = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
			df.applyPattern(pattern);
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method return date String from Date Object with default format.
	 */
	public static String formatDateToStringDefaultFormat(Date date) {
		return formatDateToString(date, Constants.DEFAULT_DATE_FORMAT);
	}

	/**
	 * This method return date String from Date Object with given format.
	 */
	public static String formatDateToStringGivenFormat(Date date, String givenFormat) {
		return formatDateToString(date, givenFormat);
	}

	/**
	 * Converts string date to SQL date with default Format.
	 */
	public static java.sql.Date convertSQLDateDefaultFormat(String dateString) {
		return convert(dateString, Constants.DEFAULT_DATE_FORMAT);
	}

	/**
	 * Converts string date to SQL date with given Format.
	 */
	public static java.sql.Date convertSQLDateGivenFormat(String dateString, String givenFormat) {
		return convert(dateString, givenFormat);
	}

	private static java.sql.Date convert(String dateString, String format) {
		try {
			if (dateString == null || dateString.equals("")) {
				return null;
			}
			if (format == null) {
				format = Constants.DEFAULT_DATE_FORMAT;
			}
			return new java.sql.Date(new SimpleDateFormat(format).parse(dateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * returns current system Date with default format.
	 */
	public static String currentDateStringDefaultFormat() {
		DateFormat defaultDateFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
		return defaultDateFormat.format(new Date());
	}

	/**
	 * returns current system Date with given format .
	 */
	public static String currentDateStringGivenFormat(String givenFormat) {
		DateFormat defaultDateFormat = new SimpleDateFormat(givenFormat);
		return defaultDateFormat.format(new Date());
	}

	/**
	 * This method adds the specified year, months and days to argument date and
	 * returns the new Date.
	 */
	public static Date getAddedDate(Date date, int year, int months, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		if (date == null) {
			return null;
		}
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, months);
		cal.add(Calendar.DATE, days);
		Date dt = cal.getTime();
		return dt;
	}

	/**
	 * returns current Month From Date.
	 */
	public static String currentMonth() {
		DateFormat monthFormat = new SimpleDateFormat(Constants.MONTH_FORMAT);
		return monthFormat.format(new Date());
	}

	/**
	 * returns current Year From Date.
	 */
	public static String currentYear() {
		DateFormat yearFormat = new SimpleDateFormat(Constants.YEAR_FORMAT);
		return yearFormat.format(new Date());
	}

	/**
	 * returns current SQL Date
	 */
	public static java.sql.Date getCurrentSqlDate() {
		return new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}

	/**
	 * This method return time different between two dates
	 */
	public static long timeDiff(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}

	/**
	 * returns the current day plus 30 days as a date
	 */
	public static String getCurrentDatePlusN(int noOfDays) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, noOfDays);
		return formatDateToString(c.getTime(), Constants.DEFAULT_DATE_FORMAT);
	}

	private static String formatDateToString(Date date, String formatString) {
		if (date != null) {
			return new SimpleDateFormat(formatString).format(date);
		}
		return "";
	}

	/**
	 * This method returns Integer number based in Given String
	 */
	public static int getMonth(String month) {
		if ("JANUARY".equalsIgnoreCase(month) || month.startsWith("Jan")) {
			return 1;
		} else if ("FEBRUARY".equalsIgnoreCase(month) || month.startsWith("Feb")) {
			return 2;
		} else if ("MARCH".equalsIgnoreCase(month) || month.startsWith("Mar")) {
			return 3;
		} else if ("APRIL".equalsIgnoreCase(month) || month.startsWith("Apr")) {
			return 4;
		} else if ("MAY".equalsIgnoreCase(month) || month.startsWith("May")) {
			return 5;
		} else if ("JUNE".equalsIgnoreCase(month) || month.startsWith("Jun")) {
			return 6;
		} else if ("JULY".equalsIgnoreCase(month) || month.startsWith("Jul")) {
			return 7;
		} else if ("AUGUST".equalsIgnoreCase(month) || month.startsWith("Aug")) {
			return 8;
		} else if ("SEPTEMBER".equalsIgnoreCase(month) || month.startsWith("Sep")) {
			return 9;
		} else if ("OCTOBER".equalsIgnoreCase(month) || month.startsWith("Oct")) {
			return 10;
		} else if ("NOVEMBER".equalsIgnoreCase(month) || month.startsWith("Nov")) {
			return 11;
		} else if ("DECEMBER".equalsIgnoreCase(month) || month.startsWith("Dec")) {
			return 12;
		} else {
			throw new RuntimeException("Improper Month " + month);
		}
	}

	/**
	 * This method will return Date based on Input
	 */
	public static final String getDate(int date, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date);
		return cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
	}

	/**
	 * This method will return days different
	 * 
	 * @return Days
	 */
	public static long getDateDiffinDays(Date date1, Date date2) {
		long diffDays = timeDiff(date1, date2) / (24 * 60 * 60 * 1000);
		return diffDays;
	}

	/**
	 * This method will return Hours different
	 * 
	 * @return Hours
	 */
	public static long getDateDiffinHours(Date date1, Date date2) {
		long diffHours = timeDiff(date1, date2) / (60 * 60 * 1000) % 24;
		return diffHours;
	}
	
	public static Date getBack45Days(){
		long today = ((new GregorianCalendar()).getTime()).getTime();
		long back45Days = (today - millis45Days);
		Date back45days = new Date(back45Days);
		return back45days;
		
	}
	
	public static Date getBack60Days(){
		long today = ((new GregorianCalendar()).getTime()).getTime();
		long back45Days = (today - millis60Days);
		Date back45days = new Date(back45Days);
		return back45days;
	}
	
	public static Date getBack90Days(){
		long today = ((new GregorianCalendar()).getTime()).getTime();
		long back45Days = (today - millis90Days);
		Date back45days = new Date(back45Days);
		return back45days;
		
	}
	
	public static Date getCurrentUtilDate(){
		long today = ((new GregorianCalendar()).getTime()).getTime();
		Date todayDate = new java.util.Date(today);
		return todayDate;
	}
	
	public static long getCurrentDate(){
	  long today = ((new GregorianCalendar()).getTime()).getTime();
	  return today;
	}
	
	public static java.sql.Date getStringToDateDefaultFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
                        java.util.Date dateVal = sdf.parse(date);
                        java.sql.Date sqlDate = new java.sql.Date(dateVal.getTime());
                        return sqlDate;
        } catch (ParseException e) {
                        e.printStackTrace();
        }
        return null;
	}
	
	public static String getStringFormGivenDateFormat(java.sql.Date date, String givenDateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(givenDateFormat);
        String dateStr = sdf.format(date);
        return dateStr;
	}
	
	/**
	 * returns Date and Time in required format used in ShipDart
	 */
	
	public static String[] getDateAndTime(){
		
		String[] dt = new String[2];
		java.util.Date d = new Date();
				
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-YYYY");
	  	SimpleDateFormat sdf2 = new SimpleDateFormat("HHmm");
		
        dt[0] = sdf1.format(d);          
        dt[1] = sdf2.format(d);
        return dt;
	}
}