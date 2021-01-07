package com.bataryat.modules.plan.service;

import java.util.List;

import com.bataryat.common.service.BaseService;
import com.bataryat.modules.plan.model.Plan;

public interface PlanService extends BaseService<Plan, Long> {

	public Plan findByIdAndLang(Long id);
	
	public List<Plan> findAllByLang();
}
