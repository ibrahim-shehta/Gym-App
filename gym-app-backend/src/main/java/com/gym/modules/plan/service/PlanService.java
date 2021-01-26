package com.gym.modules.plan.service;

import java.util.List;


import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.plan.model.Plan;

public interface PlanService extends BaseServiceWithSepecification<Plan, Long> {

	public Plan findByIdAndLang(Long id);
	
	public List<Plan> findAllByLang();
	
}
