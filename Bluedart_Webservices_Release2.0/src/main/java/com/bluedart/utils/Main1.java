package com.bluedart.utils;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class Main1 {
	
	public static String  getMonthForInt(int num) {
	      String month = "wrong";
	      DateFormatSymbols dfs = new DateFormatSymbols();
	      String[] months = dfs.getMonths();
	      if (num >= 0 && num <= 11 ) {
	          month = months[num];
	      }
	      return month;
	  }
	
  public static void main(String[] args) {
    String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December" };

    
    //15/12/2017
    Calendar cal = Calendar.getInstance();
    String month = monthName[cal.get(Calendar.MONTH)];

    int tmp = 12 - 1;
    System.out.println("Month name: " + getMonthForInt(tmp));
  }
  
}
