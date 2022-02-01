package com.gym.security.dto;

import java.util.List;

import com.gym.common.dto.BaseDto;
import com.gym.user.dto.PermissionDto;

public class UserAuthDto extends BaseDto {

	private String name;
	private String email;
	private String username;
	private String mobile;
	private String address;
	private String imageName;
	private List<PermissionDto> permission;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public List<PermissionDto> getPermission() {
		return permission;
	}

	public void setPermission(List<PermissionDto> permission) {
		this.permission = permission;
	}

}
