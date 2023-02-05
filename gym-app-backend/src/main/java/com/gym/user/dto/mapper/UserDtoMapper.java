package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.UserDto;
import com.gym.user.model.User;

@Mapper(componentModel = "spring")
public interface UserDtoMapper extends BaseStatusMapper<User, UserDto> {

}
