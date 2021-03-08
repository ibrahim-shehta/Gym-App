package com.gym.common.constant;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class AppUtils {

	public static String getCurrentTime() {
		return LocalTime.now().toString().substring(0, 5);
	}
	
	public static String getCurrentDate() {
		return LocalDate.now().toString();
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
