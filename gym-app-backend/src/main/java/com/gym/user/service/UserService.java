package com.gym.user.service;


import org.springframework.web.multipart.MultipartFile;

import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.user.model.User;

public interface UserService extends BaseServiceWithSepecification<User, Long> {

	public User saveUserImage(MultipartFile file);
	
}
