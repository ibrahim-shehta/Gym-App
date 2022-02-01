package com.gym.modules.exercises.excercises.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.exercises.excercises.dto.ExerciseDto;
import com.gym.modules.exercises.excercises.model.Exercise;

@Mapper(componentModel = "spring")
public interface ExerciseDtoMapper extends BaseDtoMapper<Exercise, ExerciseDto> {

}
