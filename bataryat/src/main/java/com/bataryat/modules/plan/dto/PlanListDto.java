package com.bataryat.modules.plan.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bataryat.modules.plan.model.Plan;

public class PlanListDto extends BasePlanDto {

	private String name;
	private String description;

	public static PlanListDto mapEntityToDto(Plan entity) {
		if (entity == null)
			return null;
		PlanListDto dto = new PlanListDto();
		BasePlanDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getPlanTranslate().get(0).getName());
		dto.setDescription(entity.getPlanTranslate().get(0).getDescription());
		return dto;
	}

	public static List<PlanListDto> mapListToDtos(List<Plan> entity) {
		if (entity == null)
			return Collections.emptyList();
		List<PlanListDto> planListDtoList = entity.stream().map(plan -> mapEntityToDto(plan))
				.collect(Collectors.toList());
		return planListDtoList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
