package com.gym.user.dto;

import com.gym.common.dto.BaseStatusDto;

public class BaseUserDto extends BaseStatusDto {

	//@NotNull(message=MessagesKeys.VALIDATION_USER_NAME)
	//@Length(min=3, message=MessagesKeys.VALIDATION_USER_NAME)
	private String name;

	//@NotNull(message=MessagesKeys.VALIDATION_USER_EMAIL)
	//@Email(message=MessagesKeys.VALIDATION_USER_EMAIL)
	private String email;

	//@NotNull(message=MessagesKeys.VALIDATION_USER_USERNAME)
	//@Length(min=4, message=MessagesKeys.VALIDATION_USER_USERNAME)
	private String username;

	//@NotNull(message=MessagesKeys.VALIDATION_USER_MOBILE)
	//@Length(min=10, message=MessagesKeys.VALIDATION_USER_MOBILE)
	private String mobile;

	private String address;
	
	private String imageName;

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
