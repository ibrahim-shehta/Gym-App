package com.bataryat.user.dto;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.common.dto.MapperDto;
import com.bataryat.user.model.translate.PermissionTranslate;

public class PermissionTranslateDto extends BaseDto implements MapperDto<PermissionTranslate, PermissionTranslateDto, Long>{

	private String langCode;
	private String name;
	private String description;
	
	@Override
	public PermissionTranslateDto mapEntityToDto(PermissionTranslate entity) {
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
	public PermissionTranslate mapDtoToEntity(PermissionTranslateDto dto) {
		// TODO Auto-generated method stub
		return null;
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
