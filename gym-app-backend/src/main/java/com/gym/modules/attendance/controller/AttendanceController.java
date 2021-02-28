package com.gym.modules.attendance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.modules.attendance.dto.AttendanceDto;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.service.AttendanceService;


@Controller
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping
	public ResponseEntity<BaseResponse<AttendanceDto>> save(@Valid @RequestBody AttendanceDto dto) {
		Attendance entity = AttendanceDto.mapDtoToEntity(dto);
		entity = this.attendanceService.save(entity);
		dto = AttendanceDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<AttendanceDto>(dto));
	}
	
	
	@PutMapping
	public ResponseEntity<BaseResponse<AttendanceDto>> edit(@Valid @RequestBody AttendanceDto dto) {
		Attendance entity = AttendanceDto.mapDtoToEntity(dto);
		entity = this.attendanceService.update(entity);
		dto = AttendanceDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<AttendanceDto>(dto));
	}
	
	
}
