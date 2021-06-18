package com.gym.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.controller.BaseAuditController;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.user.dto.RoleDto;
import com.gym.user.dto.mapper.RoleDtoMapper;
import com.gym.user.model.Role;
import com.gym.user.service.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends BaseAuditController<Role, Long, RoleDto, RoleDto> {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleDtoMapper roleDtoMapper;
	
	@Override
	protected RoleService getService() {
		return roleService;
	}

	@Override
	protected RoleDtoMapper getEntityDtoMapper() {
		return roleDtoMapper;
	}

	@Override
	protected RoleDtoMapper getListDtoMapper() {
		return roleDtoMapper;
	}
	
	@Override
	protected ResponseEntity<BaseResponse<RoleDto>> getPaginatedFilterData(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort,  HttpServletRequest req) {
		Page<Role> entity = this.roleService.filterCategoryByName(filterDataWithPaginationAndSort);
		List<RoleDto> dto = roleDtoMapper.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<RoleDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}

}
