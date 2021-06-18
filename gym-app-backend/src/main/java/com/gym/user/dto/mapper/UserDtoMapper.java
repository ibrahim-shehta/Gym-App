package com.gym.user.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.UserDto;
import com.gym.user.model.User;

@Component
public class UserDtoMapper implements BaseStatusMapper<User, UserDto> {

	@Override
	public UserDto mapEntityToDto(User entity) {
		return UserDto.mapEntityToDto(entity);
	}

	@Override
	public User mapDtoToEntity(UserDto dto) {
		return UserDto.mapDtoToEntity(dto);
	}
}
