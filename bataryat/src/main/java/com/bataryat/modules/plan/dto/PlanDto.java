package com.bataryat.modules.plan.dto;

import java.util.ArrayList;
import java.util.List;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.common.dto.MapperDto;
import com.bataryat.modules.plan.model.Plan;

public class PlanDto extends BaseDto implements MapperDto{

	private String code;
	private Long value;
	private List<PlanTranslateDto> planTranslate = new ArrayList<>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public List<PlanTranslateDto> getPlanTranslate() {
		return planTranslate;
	}
	public void setPlanTranslate(List<PlanTranslateDto> planTranslate) {
		this.planTranslate = planTranslate;
	}
	
	
	public static PlanDto mapEntityToDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setValue(entity.getValue());
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
		entity.setValue(dto.getValue());
		dto.getPlanTranslate().forEach(item -> {
			entity.addTranslate(PlanTranslateDto.mapDtoToEntity(item));
		});
		return entity;
	}
	
	
	
	
}
