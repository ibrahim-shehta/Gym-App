package com.gym.modules.exercises.category.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.exercises.category.model.ExcerciseCategory;

public class ExcerciseCategoryListDto extends BaseExcerciseCategoryDto {

	private String nextExcerciseCategoryName;

	public static ExcerciseCategoryListDto mapEntityToDto(ExcerciseCategory entity) {
		if (entity == null) {
			return null;
		}
		ExcerciseCategoryListDto dto = new ExcerciseCategoryListDto();
		BaseExcerciseCategoryDto.mapEntityToDto(entity, dto);
		dto.setNextExcerciseCategoryName(entity.getNextExcerciseCategory() != null ? entity.getNextExcerciseCategory().getName() : null);
		return dto;
	}

	public static ExcerciseCategory mapDtoToEntity(ExcerciseCategoryListDto dto) {
		if (dto == null) {
			return null;
		}
		ExcerciseCategory entity = new ExcerciseCategory();
		BaseExcerciseCategoryDto.mapDtoToEntity(dto, entity);
		return entity;
	}
	
	public static List<ExcerciseCategoryListDto> mapListToDtos(List<ExcerciseCategory> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}

	public String getNextExcerciseCategoryName() {
		return nextExcerciseCategoryName;
	}

	public void setNextExcerciseCategoryName(String nextExcerciseCategoryName) {
		this.nextExcerciseCategoryName = nextExcerciseCategoryName;
	}

}
