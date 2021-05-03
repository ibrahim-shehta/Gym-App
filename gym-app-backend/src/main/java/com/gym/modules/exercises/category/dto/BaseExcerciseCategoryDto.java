package com.gym.modules.exercises.category.dto;

import com.gym.common.dto.BaseDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

public class BaseExcerciseCategoryDto extends BaseDto {

	private String name;
	
	public static BaseExcerciseCategoryDto mapEntityToDto(ExcerciseCategory entity, BaseExcerciseCategoryDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		return dto;
	}

	public static ExcerciseCategory mapDtoToEntity(BaseExcerciseCategoryDto dto, ExcerciseCategory entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		return entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
