package com.gym.modules.exercises.excercises.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.exercises.excercises.dto.ExerciseListDto;
import com.gym.modules.exercises.excercises.model.Exercise;

@Mapper(componentModel = "spring")
public interface ExerciseListDtoMapper extends BaseDtoMapper<Exercise, ExerciseListDto> {

}
