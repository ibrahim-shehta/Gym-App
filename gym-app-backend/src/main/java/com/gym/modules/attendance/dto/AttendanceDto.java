package com.gym.modules.attendance.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.user.dto.UserListDto;

public class AttendanceDto extends BaseAttendanceDto {


	private UserListDto user;
	private ExcerciseCategoryDto excerciseCategory;
	
	
	public static AttendanceDto mapEntityToDto(Attendance entity) {
		if (entity == null) {
			return null;
		}
		AttendanceDto dto = new AttendanceDto();
		BaseAttendanceDto.mapEntityToDto(entity.getUser(), dto);
		dto.setExcerciseCategory(ExcerciseCategoryDto.mapEntityToDto(entity.getExcerciseCategory()));
		dto.setUser(UserListDto.mapEntityToDto(entity.getUser()));
		return dto;
	}

	public static Attendance mapDtoToEntity(AttendanceDto dto) {
		if (dto == null) {
			return null;
		}
		Attendance entity = new Attendance();
		BaseAttendanceDto.mapDtoToEntity(dto, entity);
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
	public ExcerciseCategoryDto getExcerciseCategory() {
		return excerciseCategory;
	}

	public void setExcerciseCategory(ExcerciseCategoryDto excerciseCategory) {
		this.excerciseCategory = excerciseCategory;
	}
	
	
	
}
