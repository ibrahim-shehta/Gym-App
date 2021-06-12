package com.gym.user.service.impl;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.user.model.RolePermission;
import com.gym.user.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl extends BaseAuditServiceImpl<RolePermission, Long> implements RolePermissionService {

	@Override
	public BaseAuditRepository<RolePermission, Long> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specification<RolePermission> getSpecifications(Map<String, Object> filterDataMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
