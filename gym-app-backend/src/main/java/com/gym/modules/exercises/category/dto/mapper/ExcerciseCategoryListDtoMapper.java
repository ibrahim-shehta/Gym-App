package com.gym.modules.exercises.category.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryListDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Component
public class ExcerciseCategoryListDtoMapper implements BaseMapper<ExcerciseCategory, ExcerciseCategoryListDto> {

	@Override
	public ExcerciseCategoryListDto mapEntityToDto(ExcerciseCategory entity) {
		return ExcerciseCategoryListDto.mapEntityToDto(entity);
	}

	@Override
	public List<ExcerciseCategoryListDto> mapListToDtos(List<ExcerciseCategory> entity) {
		return ExcerciseCategoryListDto.mapListToDtos(entity);
	}

}
