package com.gym.modules.resetpassword.service;

import com.gym.modules.resetpassword.dao.ResetPasswordRequest;
import com.gym.user.model.User;

public interface ResetPasswordService  {
	
	public void generateResetPassword(User user);
	
	public void verifyResetPasswordCode(String code, String password);
}
