package com.gym.user.service;

import java.util.List;

import com.gym.user.dto.PermissionDto;

public interface PermissionService {

	List<PermissionDto> getPermissionToUser(Long userId);
}
