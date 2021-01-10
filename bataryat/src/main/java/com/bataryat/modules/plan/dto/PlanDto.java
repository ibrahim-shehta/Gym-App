package com.bataryat.modules.plan.dto;

import java.util.ArrayList;
import java.util.List;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.modules.plan.model.Plan;

public class PlanDto extends BaseDto {

	private String code;
	private double price; 
	private List<PlanTranslateDto> planTranslate = new ArrayList<>();
	
	
	public static PlanDto mapEntityToDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setPrice(entity.getPrice());
		entity.getPlanTranslate().forEach(item -> {
			dto.planTranslate.add(PlanTranslateDto.mapEntityToDto(item));
		});
		return dto;
	}
	public static Plan mapDtoToEntity(PlanDto dto) {
		if (dto == null) {
			return null;
		}
		Plan entity = new Plan();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setPrice(dto.getPrice());
		dto.getPlanTranslate().forEach(item -> {
			entity.addTranslate(PlanTranslateDto.mapDtoToEntity(item));
		});
		return entity;
	}
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public List<PlanTranslateDto> getPlanTranslate() {
		return planTranslate;
	}
	public void setPlanTranslate(List<PlanTranslateDto> planTranslate) {
		this.planTranslate = planTranslate;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
