package com.gym.modules.plan.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.plan.dto.PlanDto;
import com.gym.modules.plan.model.Plan;

@Component
public class PlanDtoMapper implements BaseMapper<Plan, PlanDto> {

	@Override
	public PlanDto mapEntityToDto(Plan entity) {
		return PlanDto.mapEntityToDto(entity);
	}

	@Override
	public Plan mapDtoToEntity(PlanDto dto) {
		return PlanDto.mapDtoToEntity(dto);
	}
}
