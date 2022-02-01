package com.gym.modules.attendance.dto;

import java.util.Date;

import com.gym.common.dto.BaseDto;

public class BaseAttendanceDto extends BaseDto {

	private Date date;
	private String signIn;
	private String signOut;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSignIn() {
		return signIn;
	}

	public void setSignIn(String signIn) {
		this.signIn = signIn;
	}

	public String getSignOut() {
		return signOut;
	}

	public void setSignOut(String signOut) {
		this.signOut = signOut;
	}

}
