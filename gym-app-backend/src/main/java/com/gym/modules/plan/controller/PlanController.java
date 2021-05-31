package com.gym.modules.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.controller.BaseAuditController;
import com.gym.modules.plan.dto.PlanDto;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.dto.mapper.PlanDtoMapper;
import com.gym.modules.plan.dto.mapper.PlanListDtoMapper;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController extends BaseAuditController<Plan, Long, PlanDto, PlanListDto> {

	@Autowired
	private PlanService planService;
	
	@Autowired
	PlanDtoMapper planDtoMapper;
	
	@Autowired
	PlanListDtoMapper planListDtoMapper;
	
	
	@Override
	protected PlanService getService() {
		return planService;
	}

	
	@Override
	protected PlanDtoMapper getEntityDtoMapper() {
		return planDtoMapper;
	}

	@Override
	protected PlanListDtoMapper getListDtoMapper() {
		return planListDtoMapper;
	}
}
