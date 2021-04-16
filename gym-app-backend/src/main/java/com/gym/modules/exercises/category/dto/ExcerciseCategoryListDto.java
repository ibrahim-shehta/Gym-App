package com.gym.modules.exercises.category.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

public class ExcerciseCategoryListDto extends BaseDto {

	private String name;
	private String nextExcerciseCategoryName;

	public static ExcerciseCategoryListDto mapEntityToDto(ExcerciseCategory entity) {
		if (entity == null) {
			return null;
		}
		ExcerciseCategoryListDto dto = new ExcerciseCategoryListDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setNextExcerciseCategoryName(entity.getNextExcerciseCategory() != null ? entity.getNextExcerciseCategory().getName() : null);
		return dto;
	}

	public static List<ExcerciseCategoryListDto> mapListToDtos(List<ExcerciseCategory> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNextExcerciseCategoryName() {
		return nextExcerciseCategoryName;
	}

	public void setNextExcerciseCategoryName(String nextExcerciseCategoryName) {
		this.nextExcerciseCategoryName = nextExcerciseCategoryName;
	}

}
