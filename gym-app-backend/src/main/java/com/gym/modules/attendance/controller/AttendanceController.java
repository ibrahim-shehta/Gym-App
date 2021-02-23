package com.gym.modules.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.modules.attendance.service.AttendanceService;

@Controller
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	
}
