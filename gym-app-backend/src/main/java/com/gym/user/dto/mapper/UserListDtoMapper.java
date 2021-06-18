package com.gym.user.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;

@Component
public class UserListDtoMapper implements BaseStatusMapper<User, UserListDto> {

	@Override
	public UserListDto mapEntityToDto(User entity) {
		return UserListDto.mapEntityToDto(entity);
	}

	@Override
	public List<UserListDto> mapListToDtos(List<User> entity) {
		return UserListDto.mapListToDtos(entity);
	}
}
