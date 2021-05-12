package com.gym.modules.attendance.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.attendance.dto.AttendanceListDto;
import com.gym.modules.attendance.model.Attendance;

@Component
public class AttendanceListDtoMapper  implements BaseMapper<Attendance, AttendanceListDto> {

	@Override
	public AttendanceListDto mapEntityToDto(Attendance entity) {
		return AttendanceListDto.mapEntityToDto(entity);
	}
	
	@Override
	public List<AttendanceListDto> mapListToDtos(List<Attendance> entity) {
		return AttendanceListDto.mapListToDtos(entity);
	}

}
