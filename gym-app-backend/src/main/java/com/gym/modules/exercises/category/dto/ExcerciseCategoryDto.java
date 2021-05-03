package com.gym.modules.exercises.category.dto;

import com.gym.modules.exercises.category.model.ExcerciseCategory;

public class ExcerciseCategoryDto extends BaseExcerciseCategoryDto {

	private ExcerciseCategoryDto nextExcerciseCategory;

	public static ExcerciseCategoryDto mapEntityToDto(ExcerciseCategory entity) {
		if (entity == null) {
			return null;
		}
		ExcerciseCategoryDto dto = new ExcerciseCategoryDto();
		BaseExcerciseCategoryDto.mapEntityToDto(entity, dto);
		if (entity.getNextExcerciseCategory() != null) {
			ExcerciseCategoryDto nextExcerciseCategory = new ExcerciseCategoryDto();
			BaseExcerciseCategoryDto.mapEntityToDto(entity.getNextExcerciseCategory(), nextExcerciseCategory);
			dto.setNextExcerciseCategory(nextExcerciseCategory);
		}
		return dto;
	}

	public static ExcerciseCategory mapDtoToEntity(ExcerciseCategoryDto dto) {
		if (dto == null) {
			return null;
		}
		
		ExcerciseCategory entity = new ExcerciseCategory();
		BaseExcerciseCategoryDto.mapDtoToEntity(dto, entity);
		if (dto.getNextExcerciseCategory() != null && dto.getNextExcerciseCategory().getId() != null) {
			ExcerciseCategory nextExcerciseCategory = new ExcerciseCategory();
			BaseExcerciseCategoryDto.mapDtoToEntity(dto.getNextExcerciseCategory(), nextExcerciseCategory);
			entity.setNextExcerciseCategory(nextExcerciseCategory);
		}
		return entity;
	}

	public ExcerciseCategoryDto getNextExcerciseCategory() {
		return nextExcerciseCategory;
	}

	public void setNextExcerciseCategory(ExcerciseCategoryDto nextExcerciseCategory) {
		this.nextExcerciseCategory = nextExcerciseCategory;
	}

}
