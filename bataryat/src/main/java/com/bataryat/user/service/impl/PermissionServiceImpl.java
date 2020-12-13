package com.bataryat.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bataryat.user.model.Permission;
import com.bataryat.user.repository.PermissionRepository;
import com.bataryat.user.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public Permission getPermissionById(Long id, String langCode) {
		return permissionRepository.getPermission(id, langCode);
	}
	
	

	
}
