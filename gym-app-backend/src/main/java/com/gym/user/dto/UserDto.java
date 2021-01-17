package com.gym.user.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.user.model.User;
import com.gym.user.model.UserType;

public class UserDto extends BaseUserDto {

	private Date birthDate;

	private boolean isActive;

	private boolean isDeleted;

	private boolean isBlocked;

	private String password;
	
	private UserType userType;
	
	private UserDetailsDto userDetails;
	
	public static UserDto mapEntityToDto(User entity) {
		if (entity == null) {
			return null;
		}
		UserDto dto = new UserDto();
		BaseUserDto.mapEntityToDto(entity, dto);
		dto.setBirthDate(entity.getBirthDate());
		dto.setActive(entity.isActive());
		dto.setBlocked(entity.isBlocked());
		dto.setDeleted(entity.isDeleted());
		dto.setUserType(entity.getUserType());
		dto.setUserDetails(UserDetailsDto.mapEntityToDto(entity.getUserDetails()));
		return dto;
	}

	public static User mapDtoToEntity(UserDto dto) {
		if (dto == null) {
			return null;
		}
		User entity = new User();
		BaseUserDto.mapDtoToEntity(dto, entity);
		entity.setBirthDate(dto.getBirthDate());
		entity.setActive(dto.isActive());
		entity.setBlocked(dto.isBlocked());
		entity.setDeleted(dto.isDeleted());
		entity.setPassword(dto.getPassword());
		entity.setUserType(dto.getUserType());
		entity.setUserDetails(UserDetailsDto.mapDtoToEntity(dto.getUserDetails()));
		return entity;
	}
	
	public static List<UserDto> mapListToDtos(List<User> entity) {
		if (entity == null) {
			return null;
		}
		List<UserDto> dto = entity.stream().map(user -> mapEntityToDto(user)).collect(Collectors.toList());
		return dto;
	}
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
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

}
