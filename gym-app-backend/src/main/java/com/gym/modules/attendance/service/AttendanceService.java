package com.gym.modules.attendance.service;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseAuditService;
import com.gym.modules.attendance.model.Attendance;

public interface AttendanceService extends BaseAuditService<Attendance, Long> {

	Page<Attendance> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
}
