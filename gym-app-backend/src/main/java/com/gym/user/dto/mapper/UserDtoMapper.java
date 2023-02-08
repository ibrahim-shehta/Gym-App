package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.UserDto;
import com.gym.user.model.User;

@Mapper(componentModel = "spring")
public interface UserDtoMapper extends BaseStatusMapper<User, UserDto> {

    @Mapping(target = "password", ignore = true)
	UserDto mapEntityToDto(User entity);
}
