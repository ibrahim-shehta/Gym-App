package com.gym.user.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.user.dto.PermissionDto;
import com.gym.user.repository.PermissionRepository;
import com.gym.user.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public List<PermissionDto> getPermissionToUser(Long userId) {
		return permissionRepository.getPermissionToUser(userId);
	}
	
	

	
}
