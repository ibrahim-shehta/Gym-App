package com.gym.modules.attendance.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.gym.common.model.Auditable;
import com.gym.user.model.User;

public class Attendance extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

}
