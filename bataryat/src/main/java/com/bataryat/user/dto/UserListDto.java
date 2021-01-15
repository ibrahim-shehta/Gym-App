package com.bataryat.user.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.bataryat.user.model.User;

public class UserListDto extends BaseUserDto {

	public static UserListDto mapEntityToDto(User entity) {
		if (entity == null) {
			return null;
		}
		UserListDto dto = new UserListDto();
		BaseUserDto.mapEntityToDto(entity, dto);
		return dto;
	}

	public static User mapDtoToEntity(UserListDto dto) {
		if (dto == null) {
			return null;
		}
		User entity = new User();
		BaseUserDto.mapDtoToEntity(dto, entity);
		return entity;
	}
	
	public static List<UserListDto> mapListToDtos(List<User> entity) {
		if (entity == null) {
			return null;
		}
		List<UserListDto> dto = entity.stream().map(user -> mapEntityToDto(user)).collect(Collectors.toList());
		return dto;
	}
}
