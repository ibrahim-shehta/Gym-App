package com.gym.modules.exercises.category.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryListDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Mapper(componentModel = "spring")
public interface ExcerciseCategoryListDtoMapper extends BaseDtoMapper<ExcerciseCategory, ExcerciseCategoryListDto> {

}
