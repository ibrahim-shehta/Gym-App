package com.gym.modules.attendance.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseController;
import com.gym.common.dto.mapper.BaseMapper;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.common.service.BaseService;
import com.gym.modules.attendance.dto.AttendanceDto;
import com.gym.modules.attendance.dto.AttendanceListDto;
import com.gym.modules.attendance.dto.mapper.AttendanceDtoMapper;
import com.gym.modules.attendance.dto.mapper.AttendanceListDtoMapper;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.service.AttendanceService;


@Controller
@RequestMapping("/api/v1/attendance")
public class AttendanceController extends BaseController<Attendance, Long, AttendanceDto, AttendanceListDto> {

	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private AttendanceDtoMapper attendanceDtoMapper;
	
	@Autowired
	private AttendanceListDtoMapper attendanceListDtoMapper;
	
	
	@Override
	protected BaseService<Attendance, Long> getService() {
		return attendanceService;
	}

	@Override
	protected BaseMapper<Attendance, AttendanceDto> getEntityDtoMapper() {
		return attendanceDtoMapper;
	}

	@Override
	protected BaseMapper<Attendance, AttendanceListDto> getListDtoMapper() {
		return attendanceListDtoMapper;
	}
	
	@Override
	protected ResponseEntity<BaseResponse<AttendanceListDto>> getPaginatedFilterData(
			FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Page<Attendance> entity = this.attendanceService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<AttendanceListDto> dto = AttendanceListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<AttendanceListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	


	
}
