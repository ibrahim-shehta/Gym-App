package com.gym.modules.attendance.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.attendance.model.Attendance;

public class AttendanceListDto extends BaseAttendanceDto {

	private String excerciseCategoryName;

	
	public static AttendanceListDto mapEntityToDto(Attendance entity) {
		if (entity == null) {
			return null;
		}
		AttendanceListDto dto = new AttendanceListDto();
		BaseAttendanceDto.mapEntityToDto(entity, dto);
		dto.setExcerciseCategoryName(entity.getExcerciseCategory().getName());
		return dto;
	}


	public static List<AttendanceListDto> mapListToDtos(List<Attendance> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}
	
	
	public String getExcerciseCategoryName() {
		return excerciseCategoryName;
	}

	public void setExcerciseCategoryName(String excerciseCategoryName) {
		this.excerciseCategoryName = excerciseCategoryName;
	}
	
	
}
