package com.gym.modules.attendance.dto;

import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.user.dto.UserListDto;

public class AttendanceDto extends BaseAttendanceDto {


	private UserListDto user;
	private ExcerciseCategoryDto excerciseCategory;
	
	
	public UserListDto getUser() {
		return user;
	}
	public void setUser(UserListDto user) {
		this.user = user;
	}
	public ExcerciseCategoryDto getExcerciseCategory() {
		return excerciseCategory;
	}

	public void setExcerciseCategory(ExcerciseCategoryDto excerciseCategory) {
		this.excerciseCategory = excerciseCategory;
	}
	
	
	
}
