package com.gym.common.helper;

import javax.servlet.http.HttpServletRequest;

import com.gym.user.model.UserType;

public abstract class ControllerHelper {

	public static UserType getUserType(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String userTypeString = uri.substring(uri.lastIndexOf("/") + 1);
		if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.EMPLOYEE) {
			return UserType.EMPLOYEE;
		} else if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.TRAINER) {
			return UserType.TRAINER;
		} else if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.PLAYER) {
			return UserType.PLAYER;
		}
		return null;
	}
}
