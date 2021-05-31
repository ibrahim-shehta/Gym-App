package com.gym.modules.plan.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.modules.plan.dao.PlanRepository;
import com.gym.modules.plan.dao.specification.PlanSpecification;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;

@Service
public class PlanServiceImpl extends BaseAuditServiceImpl<Plan, Long> implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public PlanRepository getRepository() {
		return this.planRepository;
	}
	
	@Override
	public Specification<Plan> getSpecifications(Map<String, Object> filterDataMap) {
		return PlanSpecification.filterPlans(filterDataMap);
	}
	
}
