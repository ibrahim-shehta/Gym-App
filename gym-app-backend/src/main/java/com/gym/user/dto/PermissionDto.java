package com.gym.user.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.user.model.Permission;

public class PermissionDto extends BaseDto {

	private String name;
	private String code;
	private boolean isModule;
	private boolean isScreen;
	private String path;
	private Long parentId;
	private String icon;
	
	public PermissionDto() {}
	
	public PermissionDto(Long id, String name, String code, boolean isModule, boolean isScreen, String path, String icon, Long parentId) {
		this.setId(id);
		this.name = name;
		this.code = code;
		this.isModule = isModule;
		this.isScreen = isScreen;
		this.path = path;
		this.icon = icon;
		this.parentId = parentId;
	}



	public static PermissionDto mapEntityToDto(Permission entity) {
		if (entity == null) {
			return null;
		}
		PermissionDto dto = new PermissionDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setModule(entity.isModule());
		dto.setScreen(entity.isScreen());
		dto.setPath(entity.getPath());
		dto.setIcon(entity.getIcon());
		//dto.setParentId(entity.getParent().getpa);
		return dto;
	}

	
	public static List<PermissionDto> mapListToDtos(List<Permission> entity) {
		if (entity == null) {
			return null;
		}
		
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}
	
	public static Permission mapDtoToEntity(PermissionDto dto) {
		Permission entity = new Permission();
		BaseDto.mapDtoToEntity(dto, entity);
		return entity;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public boolean isModule() {
		return isModule;
	}

	public void setModule(boolean isModule) {
		this.isModule = isModule;
	}

	public boolean isScreen() {
		return isScreen;
	}

	public void setScreen(boolean isScreen) {
		this.isScreen = isScreen;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
