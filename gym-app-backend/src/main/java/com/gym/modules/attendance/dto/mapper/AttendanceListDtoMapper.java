package com.gym.modules.attendance.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.attendance.dto.AttendanceListDto;
import com.gym.modules.attendance.model.Attendance;

@Mapper(componentModel = "spring")
public interface AttendanceListDtoMapper extends BaseDtoMapper<Attendance, AttendanceListDto> {



}
