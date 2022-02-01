package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;

@Mapper(componentModel = "spring")
public interface UserListDtoMapper extends BaseDtoMapper<User, UserListDto> {

}
