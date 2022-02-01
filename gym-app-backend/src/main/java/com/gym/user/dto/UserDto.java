package com.gym.user.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gym.user.model.UserType;

public class UserDto extends BaseUserDto {

	private Date birthDate;

	private String password;
	
	private UserType userType;
	
	private UserDetailsDto userDetails;
	
	private List<RoleDto> roles = new ArrayList<>(); 
	


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserDetailsDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsDto userDetails) {
		this.userDetails = userDetails;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

}
