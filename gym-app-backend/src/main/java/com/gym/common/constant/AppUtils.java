package com.gym.common.constant;

import java.time.LocalTime;

public abstract class AppUtils {

	public static String getCurrentTime() {
		return LocalTime.now().toString().substring(0, 5);
	}
}
