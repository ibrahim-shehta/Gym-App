package com.gym.user.service;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseAuditService;
import com.gym.user.model.Role;

public interface RoleService extends BaseAuditService<Role, Long> {

	Page<Role> filterCategoryByName(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);

}
