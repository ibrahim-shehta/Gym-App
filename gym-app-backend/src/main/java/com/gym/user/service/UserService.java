package com.gym.user.service;


import org.springframework.web.multipart.MultipartFile;

import com.gym.common.service.BaseAuditService;
import com.gym.user.model.User;

public interface UserService extends BaseAuditService<User, Long> {

	public User saveUserImage(MultipartFile file);
	
	public User findByEmail(String email);
	
	void updateUserPassword(String password, Long id);
}
