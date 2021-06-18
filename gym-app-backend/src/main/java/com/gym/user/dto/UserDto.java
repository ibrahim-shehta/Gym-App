package com.gym.user.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.user.model.User;
import com.gym.user.model.UserType;

public class UserDto extends BaseUserDto {

	private Date birthDate;

	private String password;
	
	private UserType userType;
	
	private UserDetailsDto userDetails;
	
	private List<RoleDto> roles = new ArrayList<>(); 
	
	public static UserDto mapEntityToDto(User entity) {
		if (entity == null) {
			return null;
		}
		UserDto dto = new UserDto();
		BaseUserDto.mapEntityToDto(entity, dto);
		dto.setBirthDate(entity.getBirthDate());
		dto.setUserType(entity.getUserType());
		dto.setUserDetails(UserDetailsDto.mapEntityToDto(entity.getUserDetails()));
		dto.setRoles(RoleDto.mapListToDtos(entity.getRoles()));
		return dto;
	}

	public static User mapDtoToEntity(UserDto dto) {
		if (dto == null) {
			return null;
		}
		User entity = new User();
		BaseUserDto.mapDtoToEntity(dto, entity);
		entity.setBirthDate(dto.getBirthDate());
		entity.setPassword(dto.getPassword());
		entity.setUserType(dto.getUserType());
		entity.setUserDetails(UserDetailsDto.mapDtoToEntity(dto.getUserDetails()));
		entity.setRoles(RoleDto.mapListToEntities(dto.getRoles()));
		return entity;
	}
	
	public static List<UserDto> mapListToDtos(List<User> entity) {
		if (entity == null) {
			return null;
		}
		List<UserDto> dto = entity.stream().map(user -> mapEntityToDto(user)).collect(Collectors.toList());
		return dto;
	}

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
