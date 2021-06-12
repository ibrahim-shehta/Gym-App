package com.gym.user.repository;

import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.user.model.RolePermission;

@Repository
public interface RolePermissionRepository extends BaseAuditRepository<RolePermission, Long> {

}
