package com.gym.modules.plan.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseService;
import com.gym.modules.plan.model.Plan;

public interface PlanService extends BaseService<Plan, Long> {

	public Plan findByIdAndLang(Long id);
	
	public List<Plan> findAllByLang();
	
	public Page<Plan> findAllByLangAndFilter(FilterDataWithPaginationAndSort filterData);
}
