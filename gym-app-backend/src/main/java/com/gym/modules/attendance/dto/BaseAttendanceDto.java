package com.gym.modules.attendance.dto;

import java.util.Date;

import com.gym.common.dto.BaseDto;
import com.gym.modules.attendance.model.Attendance;


public class BaseAttendanceDto extends BaseDto {

	private Date date;
	private String signIn;
	private String signOut;
	
	public static void mapEntityToDto(Attendance entity, BaseAttendanceDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setDate(entity.getDate());
		dto.setSignIn(entity.getSignIn());
		dto.setSignOut(entity.getSignOut());
	}

	public static void mapDtoToEntity(BaseAttendanceDto dto, Attendance entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setDate(dto.getDate());
		entity.setSignIn(dto.getSignIn());
		entity.setSignOut(dto.getSignOut());
	}
	
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
