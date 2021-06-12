package com.gym.user.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.user.dto.RoleDto;
import com.gym.user.model.Role;

@Component
public class RoleDtoMapper implements BaseMapper<Role, RoleDto> {

	@Override
	public RoleDto mapEntityToDto(Role entity) {
		return RoleDto.mapEntityToDto(entity);
	}
	
	@Override
	public Role mapDtoToEntity(RoleDto dto) {
		return RoleDto.mapDtoToEntity(dto);
	}
	
	@Override
	public List<RoleDto> mapListToDtos(List<Role> entity) {
		return RoleDto.mapListToDtos(entity);
	}

}
