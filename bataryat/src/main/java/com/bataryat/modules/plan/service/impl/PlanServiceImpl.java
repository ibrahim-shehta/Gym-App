package com.bataryat.modules.plan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bataryat.common.service.impl.BaseServiceImpl;
import com.bataryat.modules.plan.dao.PlanRepository;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.service.PlanService;

@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, Long> implements PlanService{

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public JpaRepository<Plan, Long> getRepository() {
		return this.planRepository;
	}
	
}
