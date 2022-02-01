package com.gym.modules.exercises.category.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Mapper(componentModel = "spring")
public interface ExcerciseCategoryDtoMapper extends BaseDtoMapper<ExcerciseCategory, ExcerciseCategoryDto> {

}
