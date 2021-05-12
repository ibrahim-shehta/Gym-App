package com.gym.modules.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.controller.BaseController;
import com.gym.common.dto.mapper.BaseMapper;
import com.gym.common.service.BaseService;
import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.plan.dto.PlanDto;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.dto.mapper.PlanDtoMapper;
import com.gym.modules.plan.dto.mapper.PlanListDtoMapper;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController extends BaseController<Plan, Long, PlanDto, PlanListDto> {

	@Autowired
	private PlanService planService;
	
	@Autowired
	PlanDtoMapper planDtoMapper;
	
	@Autowired
	PlanListDtoMapper planListDtoMapper;
	
	
	@Override
	protected BaseService<Plan, Long> getService() {
		return planService;
	}

	@Override
	protected BaseServiceWithSepecification<Plan, Long> getServiceWithSepecification() {
		return planService;
	}
	
	@Override
	protected BaseMapper<Plan, PlanDto> getEntityDtoMapper() {
		return planDtoMapper;
	}

	@Override
	protected BaseMapper<Plan, PlanListDto> getListDtoMapper() {
		return planListDtoMapper;
	}
}
