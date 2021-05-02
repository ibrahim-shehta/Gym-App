package com.gym.modules.exercises.category.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Component
public class ExcerciseCategoryDtoMapper implements BaseMapper<ExcerciseCategory, ExcerciseCategoryDto> {

	@Override
	public ExcerciseCategoryDto mapEntityToDto(ExcerciseCategory entity) {
		return ExcerciseCategoryDto.mapEntityToDto(entity);
	}

	@Override
	public ExcerciseCategory mapDtoToEntity(ExcerciseCategoryDto dto) {
		return ExcerciseCategoryDto.mapDtoToEntity(dto);
	}

}
