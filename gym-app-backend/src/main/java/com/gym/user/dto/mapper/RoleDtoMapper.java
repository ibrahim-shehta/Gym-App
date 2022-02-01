package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.user.dto.RoleDto;
import com.gym.user.model.Role;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper extends BaseDtoMapper<Role, RoleDto> {


}
