package com.gym.user.repository;

import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.user.model.UserRole;

@Repository
public interface UserRoleRepository extends BaseAuditRepository<UserRole, Long> {

}
