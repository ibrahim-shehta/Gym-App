package com.gym.user.dto;

import java.util.HashSet;
import java.util.Set;

import com.gym.common.dto.BaseDto;

public class RoleDto extends BaseDto  {

	private String name;
	private Set<PermissionDto> permissions = new HashSet<>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PermissionDto> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionDto> permissions) {
		this.permissions = permissions;
	}
}
