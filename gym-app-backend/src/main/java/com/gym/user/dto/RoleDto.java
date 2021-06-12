package com.gym.user.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.user.model.Permission;
import com.gym.user.model.Role;

public class RoleDto extends BaseDto  {

	private String name;
	private Set<PermissionDto> permissions = new HashSet<>();
	
	public static RoleDto mapEntityToDto(Role entity) {
		if (entity == null) {
			return null;
		}
		
		RoleDto dto = new RoleDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		if (entity.getPermissions() != null || entity.getPermissions().size() != 0) {
			Set<PermissionDto> permissions = new HashSet<>();
			entity.getPermissions().forEach(item -> {
				permissions.add(PermissionDto.mapEntityToDto(item));
			});
			dto.setPermissions(permissions);
		}
		return dto;
	}
	
	public static Role mapDtoToEntity(RoleDto dto) {
		if (dto == null) {
			return null;
		}
		Role entity = new Role();
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		Set<Permission> permissions = new HashSet<>();
		dto.getPermissions().forEach(item -> {
			Permission p = PermissionDto.mapDtoToEntity(item);
			permissions.add(p);
		});
		entity.setPermissions(permissions);
		return entity;
	}
	
	public static List<RoleDto> mapListToDtos(List<Role> entity) {
		
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapListToDtos(item)).collect(Collectors.toList());
	}
	
	public static List<Role> mapListToEntities(List<RoleDto> entity) {
		
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		List<Role> roles = new ArrayList<>();
		entity.forEach(item -> {
			Role role = new Role();
			BaseDto.mapDtoToEntity(item, role);
			roles.add(role);
		});
		
		return roles;
	}
	
	private static RoleDto mapListToDtos(Role entity) {
		if (entity == null) {
			return null;
		}
		
		RoleDto dto = new RoleDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		return dto;
	}

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
