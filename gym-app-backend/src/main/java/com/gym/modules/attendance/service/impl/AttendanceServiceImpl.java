package com.gym.modules.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseServiceImpl;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.repository.AttendanceRepostory;
import com.gym.modules.attendance.service.AttendanceService;

@Service
public class AttendanceServiceImpl extends BaseServiceImpl<Attendance, Long> implements AttendanceService {

	
	@Autowired
	private AttendanceRepostory attendanceRepostory;
	
	@Override
	public AttendanceRepostory getRepository() {
		return attendanceRepostory;
	}
	
	

}
