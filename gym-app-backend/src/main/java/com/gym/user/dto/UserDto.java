package com.gym.user.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gym.user.model.UserType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseUserDto {

	private Date birthDate;

	private String password;
	
	private UserType userType;
	
	private UserDetailsDto userDetails;
	
	private List<RoleDto> roles = new ArrayList<>(); 

}
