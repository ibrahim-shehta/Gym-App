package com.bataryat.common.dto;

import com.bataryat.common.model.BaseEntity;

public class BaseDto {

	private Long id;
	
	public static void mapEntityToDto(BaseEntity entity, BaseDto dto) {
		dto.setId(entity.getId());
	}
	
	public static void mapDtoToEntity(BaseDto dto, BaseEntity entity) {
		entity.setId(dto.getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
