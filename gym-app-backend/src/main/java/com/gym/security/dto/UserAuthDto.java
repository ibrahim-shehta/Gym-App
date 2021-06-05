package com.gym.security.dto;

import java.util.List;

import com.gym.common.dto.BaseDto;
import com.gym.user.dto.PermissionDto;
import com.gym.user.model.User;

public class UserAuthDto extends BaseDto {

	private String name;
	private String email;
	private String username;
	private String mobile;
	private String address;
	private String imageName;
	private List<PermissionDto> permission;
	
	public static UserAuthDto mapEntityToDto(User entity) {
		UserAuthDto dto = new UserAuthDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setUsername(entity.getUsername());
		dto.setMobile(entity.getMobile());
		dto.setAddress(entity.getAddress());
		dto.setImageName(entity.getImageName());
		return dto;
	}

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
