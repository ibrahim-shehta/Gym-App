package com.bataryat.modules.plan.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.modules.plan.model.Plan;

public class PlanListDto extends BaseDto {

	private String name;
	private String description;
	private double price;
	
	public static PlanListDto mapEntityToDto(Plan entity) {
		if (entity == null) 
			return null;
		PlanListDto planListDto= new PlanListDto();
		planListDto.setId(entity.getId());
		planListDto.setName(entity.getPlanTranslate().get(0).getName());
		planListDto.setDescription(entity.getPlanTranslate().get(0).getDescription());
		planListDto.setPrice(entity.getPrice());
		return planListDto;
	}
	
	public static List<PlanListDto> mapListToDtos(List<Plan> entity) {
		if (entity == null) 
			return Collections.emptyList();
		List<PlanListDto> planListDtoList = entity.stream().map(plan -> mapEntityToDto(plan)).collect(Collectors.toList());
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
