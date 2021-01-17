package com.gym.modules.plan.dto;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.dto.BaseDto;
import com.gym.modules.plan.model.PlanTranslate;

public class PlanTranslateDto extends BaseDto {

	private String langCode;
	
	@NotBlank(message=MessagesKeys.VALIDATION_PLAN_NAME)
	@Length(min=3, message=MessagesKeys.VALIDATION_PLAN_NAME)
	private String name;
	private String description;
	
	public static PlanTranslateDto mapEntityToDto(PlanTranslate entity) {
		if (entity == null) {
			return null;
		}
		PlanTranslateDto dto = new PlanTranslateDto();
		dto.setId(entity.getId());
		dto.langCode = entity.getLangCode();
		dto.name = entity.getName();
		dto.description = entity.getDescription();
		return dto;
	}
	
	public static PlanTranslate mapDtoToEntity(PlanTranslateDto dto) {
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
