package com.gym.modules.plan.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.model.Plan;

@Mapper(componentModel = "spring")
public interface PlanListDtoMapper extends BaseDtoMapper<Plan, PlanListDto> {

}
