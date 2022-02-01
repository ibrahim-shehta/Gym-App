package com.gym.user.dto;

import com.gym.common.dto.BaseDto;

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
