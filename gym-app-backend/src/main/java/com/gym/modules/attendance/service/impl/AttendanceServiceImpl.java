package com.gym.modules.attendance.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.common.constant.AppUtils;
import com.gym.common.service.impl.BaseServiceImpl;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.repository.AttendanceRepostory;
import com.gym.modules.attendance.service.AttendanceService;

@Service
@Transactional
public class AttendanceServiceImpl extends BaseServiceImpl<Attendance, Long> implements AttendanceService {

	
	@Autowired
	private AttendanceRepostory attendanceRepostory;
	
	@Override
	public AttendanceRepostory getRepository() {
		return attendanceRepostory;
	}
	
	@Override
	public Attendance save(Attendance entity) {
		entity.setDate(new Date());
		entity.setSignIn(AppUtils.getCurrentTime());
		return super.save(entity);
	}
	
	@Override
	public Attendance update(Attendance entity) {
		String currentTime = AppUtils.getCurrentTime();
		entity.setSignOut(currentTime);
		attendanceRepostory.signOut(currentTime, entity.getId());
		return entity;
	}

}
