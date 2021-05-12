package com.gym.modules.attendance.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.attendance.dto.AttendanceDto;
import com.gym.modules.attendance.model.Attendance;

@Component
public class AttendanceDtoMapper implements BaseMapper<Attendance, AttendanceDto> {

	@Override
	public AttendanceDto mapEntityToDto(Attendance entity) {
		return AttendanceDto.mapEntityToDto(entity);
	}
	
	@Override
	public Attendance mapDtoToEntity(AttendanceDto dto) {
		return AttendanceDto.mapDtoToEntity(dto);
	}

}
