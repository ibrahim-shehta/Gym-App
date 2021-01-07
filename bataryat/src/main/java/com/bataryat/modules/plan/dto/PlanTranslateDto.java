package com.bataryat.modules.plan.dto;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.common.dto.MapperDto;
import com.bataryat.modules.plan.model.PlanTranslate;

public class PlanTranslateDto extends BaseDto implements MapperDto<PlanTranslate, PlanTranslateDto, Long>{

	private String langCode;
	private String name;
	private String description;
	
	@Override
	public PlanTranslateDto mapEntityToDto(PlanTranslate entity) {
		if (entity == null) {
			return null;
		}
		this.setId(entity.getId());
		this.langCode = entity.getLangCode();
		this.name = entity.getName();
		this.description = entity.getDescription();
		return this;
	}
	
	@Override
	public PlanTranslate mapDtoToEntity(PlanTranslateDto dto) {
		if (dto == null) {
			return null;
		}
		PlanTranslate entity = new PlanTranslate();
		entity.setId(dto.getId());
		entity.setLangCode(dto.getLangCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
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
