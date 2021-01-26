package com.gym.modules.plan.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.plan.model.Plan;

public class PlanListDto extends BasePlanDto {

	public static PlanListDto mapEntityToDto(Plan entity) {
		if (entity == null)
			return null;
		PlanListDto dto = new PlanListDto();
		BasePlanDto.mapEntityToDto(entity, dto);
		return dto;
	}

	public static List<PlanListDto> mapListToDtos(List<Plan> entity) {
		if (entity == null)
			return Collections.emptyList();
		List<PlanListDto> dto = entity.stream().map(plan -> mapEntityToDto(plan)).collect(Collectors.toList());
		return dto;
	}

}
