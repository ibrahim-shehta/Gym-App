package com.gym.modules.attendance.dto;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.user.dto.UserListDto;

public class AttendanceDto extends BaseDto {


	private UserListDto user;
	private Date date;
	private String signIn;
	private String signOut;
	private ExcerciseCategoryDto excerciseCategory;
	
	
	public static AttendanceDto mapEntityToDto(Attendance entity) {
		if (entity == null) {
			return null;
		}
		AttendanceDto dto = new AttendanceDto();
		BaseDto.mapEntityToDto(entity, dto);
		UserListDto.mapEntityToDto(entity.getUser());
		dto.setDate(entity.getDate());
		dto.setSignIn(entity.getSignIn());
		dto.setSignOut(entity.getSignOut());
		dto.setExcerciseCategory(ExcerciseCategoryDto.mapEntityToDto(entity.getExcerciseCategory()));
		dto.setUser(UserListDto.mapEntityToDto(entity.getUser()));
		return dto;
	}

	public static Attendance mapDtoToEntity(AttendanceDto dto) {
		if (dto == null) {
			return null;
		}
		Attendance entity = new Attendance();
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setDate(dto.getDate());
		entity.setSignIn(dto.getSignIn());
		entity.setSignOut(dto.getSignOut());
		entity.setExcerciseCategory(ExcerciseCategoryDto.mapDtoToEntity(dto.getExcerciseCategory()));
		entity.setUser(UserListDto.mapDtoToEntity(dto.getUser()));
		return entity;
	}

	public static List<AttendanceDto> mapListToDtos(List<Attendance> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}
	
	
	public UserListDto getUser() {
		return user;
	}
	public void setUser(UserListDto user) {
		this.user = user;
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

	public ExcerciseCategoryDto getExcerciseCategory() {
		return excerciseCategory;
	}

	public void setExcerciseCategory(ExcerciseCategoryDto excerciseCategory) {
		this.excerciseCategory = excerciseCategory;
	}
	
	
	
}
