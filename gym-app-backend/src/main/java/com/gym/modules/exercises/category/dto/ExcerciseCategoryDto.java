package com.gym.modules.exercises.category.dto;

import com.gym.common.dto.BaseDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

public class ExcerciseCategoryDto extends BaseDto {

	private String name;

	private ExcerciseCategoryDto nextExcerciseCategory;

	public static ExcerciseCategoryDto mapEntityToDto(ExcerciseCategory entity) {
		if (entity == null) {
			return null;
		}
		ExcerciseCategoryDto dto = new ExcerciseCategoryDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		if (entity.getNextExcerciseCategory() != null) {
			ExcerciseCategoryDto nextExcerciseCategory = new ExcerciseCategoryDto();
			BaseDto.mapEntityToDto(entity.getNextExcerciseCategory(), nextExcerciseCategory);
			nextExcerciseCategory.setName(entity.getNextExcerciseCategory().getName());
			dto.setNextExcerciseCategory(nextExcerciseCategory);
		}
		return dto;
	}

	public static ExcerciseCategory mapDtoToEntity(ExcerciseCategoryDto dto) {
		if (dto == null) {
			return null;
		}
		
		ExcerciseCategory entity = new ExcerciseCategory();
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		if (dto.getNextExcerciseCategory() != null && dto.getNextExcerciseCategory().getId() != null) {
			ExcerciseCategory nextExcerciseCategory = new ExcerciseCategory();
			BaseDto.mapDtoToEntity(dto.getNextExcerciseCategory(), nextExcerciseCategory);
			entity.setNextExcerciseCategory(nextExcerciseCategory);
		}
		return entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExcerciseCategoryDto getNextExcerciseCategory() {
		return nextExcerciseCategory;
	}

	public void setNextExcerciseCategory(ExcerciseCategoryDto nextExcerciseCategory) {
		this.nextExcerciseCategory = nextExcerciseCategory;
	}

}
