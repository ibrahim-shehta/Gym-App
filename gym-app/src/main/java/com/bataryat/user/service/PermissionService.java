package com.bataryat.user.service;

import com.bataryat.user.model.Permission;

public interface PermissionService {

	Permission getPermissionById(Long id, String langCode);
}
