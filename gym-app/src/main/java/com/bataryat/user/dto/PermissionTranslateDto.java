package com.bataryat.user.dto;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.user.model.translate.PermissionTranslate;

public class PermissionTranslateDto extends BaseDto {

	private String langCode;
	private String name;
	private String description;
	
	public static PermissionTranslateDto mapEntityToDto(PermissionTranslate entity) {
		if (entity == null) {
			return null;
		}
		PermissionTranslateDto dto = new PermissionTranslateDto();
		dto.setId(entity.getId());
		dto.langCode = entity.getLangCode();
		dto.name = entity.getName();
		dto.description = entity.getDescription();
		return dto;
	}
	
	public static PermissionTranslate mapDtoToEntity(PermissionTranslateDto dto) {
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
