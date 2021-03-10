package com.gym.common.constant;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public abstract class AppUtils {

	public static String getCurrentTime() {
		return LocalTime.now().toString().substring(0, 5);
	}
	
	public static String getCurrentDate() {
		return LocalDate.now().toString();
	}
	
	public static LocalDate convertDateToLocalDate(Date dateToConvert) {
	    return LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dateToConvert));

	}
	
	public static Long getDurationInDays(LocalDate date1, LocalDate date2) {
		return Duration.between( date1.atStartOfDay(), date2.atStartOfDay()).toDays();
	}
	
	public static boolean isInteger(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
