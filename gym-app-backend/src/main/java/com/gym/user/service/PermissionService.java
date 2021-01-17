package com.gym.user.service;

import com.gym.user.model.Permission;

public interface PermissionService {

	Permission getPermissionById(Long id, String langCode);
}
