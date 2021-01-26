package com.gym.modules.plan.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import com.gym.modules.plan.model.Plan;

public class PlanDto extends BasePlanDto {

	public static PlanDto mapEntityToDtoWithAudit(Plan entity) {
		PlanDto dto = mapEntityToDto(entity);
		return dto;
	}

	public static PlanDto mapEntityToDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();
		BasePlanDto.mapEntityToDto(entity, dto);
		return dto;
	}

	public static Plan mapDtoToEntity(PlanDto dto) {
		if (dto == null) {
			return null;
		}
		Plan entity = new Plan();
		BasePlanDto.mapDtoToEntity(dto, entity);
		return entity;
	}

	public static List<PlanDto> mapListToDtos(List<Plan> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}

	public static List<PlanDto> mapListToDtosWithAudit(List<Plan> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDtoWithAudit(item)).collect(Collectors.toList());
	}

}
