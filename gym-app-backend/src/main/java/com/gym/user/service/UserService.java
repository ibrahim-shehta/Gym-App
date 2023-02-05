package com.gym.user.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gym.common.model.BaseStatusEntity;
import com.gym.common.service.BaseStatusService;
import com.gym.user.dto.PermissionDto;
import com.gym.user.model.User;

public interface UserService<E extends User, ID extends Serializable> extends BaseStatusService<E, ID> {

	public E saveUserImage(MultipartFile file);
	
	public E findByEmail(String email);
	
	void updateUserPassword(String password, Long id);
	
	List<PermissionDto> getPermissionToUser(Long id);
}
