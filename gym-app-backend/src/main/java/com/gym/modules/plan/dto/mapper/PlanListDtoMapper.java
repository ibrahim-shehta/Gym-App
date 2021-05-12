package com.gym.modules.plan.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.model.Plan;

@Component
public class PlanListDtoMapper implements BaseMapper<Plan, PlanListDto> {

	@Override
	public PlanListDto mapEntityToDto(Plan entity) {
		return PlanListDto.mapEntityToDto(entity);
	}
	
	@Override
	public List<PlanListDto> mapListToDtos(List<Plan> entity) {
		return PlanListDto.mapListToDtos(entity);
	}

}
