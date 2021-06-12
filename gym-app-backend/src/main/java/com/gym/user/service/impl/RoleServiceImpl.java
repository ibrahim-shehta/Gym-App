package com.gym.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.user.model.Role;
import com.gym.user.model.Role_;
import com.gym.user.repository.RoleRepository;
import com.gym.user.service.RoleService;

@Service
public class RoleServiceImpl extends BaseAuditServiceImpl<Role, Long> implements RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public RoleRepository getRepository() {
		return roleRepository;
	}

	@Override
	public Specification<Role> getSpecifications(Map<String, Object> filterDataMap) {
		return null;
	}

	@Override
	public Page<Role> filterCategoryByName(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Object nameObj = filterDataWithPaginationAndSort.getFilterMap().get(Role_.NAME);
		String name = String.valueOf(nameObj != null ? nameObj : "");
		
		return roleRepository.findByNameContains(
				name == null || name.isEmpty() ? "" : name, 
				filterDataWithPaginationAndSort.getPageRequest()
			);
	}


}
