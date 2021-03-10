package com.gym.modules.attendance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gym.common.constant.AppUtils;
import com.gym.common.constant.FilterKeys;
import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.EntityDuplicateAttributes;
import com.gym.common.exception.exceptions.SubscriptionException;
import com.gym.common.exception.model.AppSubError;
import com.gym.common.exception.model.AppValidationError;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.impl.BaseServiceImpl;
import com.gym.modules.attendance.model.Attendance;
import com.gym.modules.attendance.model.Attendance_;
import com.gym.modules.attendance.repository.AttendanceRepostory;
import com.gym.modules.attendance.service.AttendanceService;
import com.gym.modules.subscription.service.SubscriptionService;

@Service
public class AttendanceServiceImpl extends BaseServiceImpl<Attendance, Long> implements AttendanceService {

	
	@Autowired
	private AttendanceRepostory attendanceRepostory;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Override
	public AttendanceRepostory getRepository() {
		return attendanceRepostory;
	}
	
	@Override
	@Transactional(dontRollbackOn= {SubscriptionException.class})
	public Attendance save(Attendance entity) {
		thorwExceptionIfUserDuplicateLoggin(entity);
		Long days = subscriptionService.validateUserSubscription(entity.getUser().getId());
		entity.setDate(new Date());
		entity.setSignIn(AppUtils.getCurrentTime());
		entity =  super.save(entity);
		if (days == 0) {
			throw new SubscriptionException(MessagesKeys.LAST_DAY_IN_SUBSCRIPTION, true);
		}
		if (days < 7) {
			throw new SubscriptionException(MessagesKeys.REMAIN_DAYS_TO_EXPIRE_SUBSCRIPTION, days.toString(), true);
		}
		 return entity;
	}
	
	@Override
	@Transactional
	public Attendance update(Attendance entity) {
		String currentTime = AppUtils.getCurrentTime();
		entity.setSignOut(currentTime);
		attendanceRepostory.signOut(currentTime, entity.getId());
		return entity;
	}

	@Override
	public Page<Attendance> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		return attendanceRepostory.getUserAttendance(Long.parseLong(filterDataWithPaginationAndSort.getFilterMap().get(FilterKeys.USER_ID) + ""),
					filterDataWithPaginationAndSort.getPageRequest());
	}
	
	
	private void thorwExceptionIfUserDuplicateLoggin(Attendance entity) {
		if (attendanceRepostory.existsByUserIdAndDate(entity.getUser().getId(), new Date()))  {
			List<AppSubError> errors = new ArrayList<>();
			errors.add(new AppValidationError(Attendance_.DATE, "" , MessagesKeys.VALIDATION_USER_DUPLICATE_LOGIN));
			throw new EntityDuplicateAttributes(MessagesKeys.VALIDATION_USER_DUPLICATE_LOGIN, errors);
		}

	}

}
