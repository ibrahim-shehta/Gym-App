package com.bataryat.modules.plan.dto;

import java.util.ArrayList;
import java.util.List;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.common.dto.MapperDto;
import com.bataryat.modules.plan.model.Plan;

public class PlanDto extends BaseDto implements MapperDto<Plan, PlanDto, Long>{

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
	@Override
	public PlanDto mapEntityToDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		this.setId(entity.getId());
		this.setCode(entity.getCode());
		this.setValue(entity.getValue());
		entity.getPlanTranslate().forEach(item -> {
			this.planTranslate.add(new PlanTranslateDto().mapEntityToDto(item));
		});
		return this;
	}
	@Override
	public Plan mapDtoToEntity(PlanDto dto) {
		if (dto == null) {
			return null;
		}
		Plan entity = new Plan();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setValue(dto.getValue());
		dto.getPlanTranslate().forEach(item -> {
			entity.addTranslate(new PlanTranslateDto().mapDtoToEntity(item));
		});
		return entity;
	}
	
	
	
	
}
