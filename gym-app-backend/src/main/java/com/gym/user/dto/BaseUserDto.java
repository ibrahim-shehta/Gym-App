package com.gym.user.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.dto.BaseDto;
import com.gym.user.model.User;

public class BaseUserDto extends BaseDto {

	@NotNull(message=MessagesKeys.VALIDATION_USER_NAME)
	@Length(min=3, message=MessagesKeys.VALIDATION_USER_NAME)
	private String name;

	@NotNull(message=MessagesKeys.VALIDATION_USER_EMAIL)
	@Email(message=MessagesKeys.VALIDATION_USER_EMAIL)
	private String email;

	@NotNull(message=MessagesKeys.VALIDATION_USER_USERNAME)
	@Length(min=4, message=MessagesKeys.VALIDATION_USER_USERNAME)
	private String username;

	@NotNull(message=MessagesKeys.VALIDATION_USER_MOBILE)
	@Length(min=10, message=MessagesKeys.VALIDATION_USER_MOBILE)
	private String mobile;

	private String address;
	
	private String imageName;

	public static void mapEntityToDto(User entity, BaseUserDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setUsername(entity.getUsername());
		dto.setMobile(entity.getMobile());
		dto.setAddress(entity.getAddress());
		dto.setImageName(entity.getImageName());
	}
	
	public static void mapDtoToEntity(BaseUserDto dto, User entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setUsername(dto.getUsername());
		entity.setMobile(dto.getMobile());
		entity.setAddress(dto.getAddress());
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

}
