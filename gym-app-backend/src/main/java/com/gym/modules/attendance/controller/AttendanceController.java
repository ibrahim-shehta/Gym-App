package com.gym.modules.attendance.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseAuditController;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.attendance.dto.AttendanceDto;
import com.gym.modules.attendance.dto.AttendanceListDto;
import com.gym.modules.attendance.dto.mapper.AttendanceDtoMapper;
import com.gym.modules.attendance.dto.mapper.AttendanceListDtoMapper;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.service.AttendanceService;


@Controller
@RequestMapping("/api/v1/attendance")
public class AttendanceController extends BaseAuditController<Attendance, Long, AttendanceDto, AttendanceListDto> {

	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private AttendanceDtoMapper attendanceDtoMapper;
	
	@Autowired
	private AttendanceListDtoMapper attendanceListDtoMapper;
	
	
	@Override
	protected AttendanceService getService() {
		return attendanceService;
	}

	@Override
	protected AttendanceDtoMapper getEntityDtoMapper() {
		return attendanceDtoMapper;
	}

	@Override
	protected AttendanceListDtoMapper getListDtoMapper() {
		return attendanceListDtoMapper;
	}
	
	@Override
	protected ResponseEntity<BaseResponse<AttendanceListDto>> getPaginatedFilterData(
			FilterDataWithPaginationAndSort filterDataWithPaginationAndSort, HttpServletRequest req) {
		Page<Attendance> entity = this.attendanceService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<AttendanceListDto> dto = getListDtoMapper().mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<AttendanceListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	


	
}
