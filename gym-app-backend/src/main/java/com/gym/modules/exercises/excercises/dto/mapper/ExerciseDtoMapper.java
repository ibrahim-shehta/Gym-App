package com.gym.modules.exercises.excercises.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.exercises.excercises.dto.ExerciseDto;
import com.gym.modules.exercises.excercises.model.Exercise;

@Component
public class ExerciseDtoMapper implements BaseMapper<Exercise, ExerciseDto> {

	@Override
	public ExerciseDto mapEntityToDto(Exercise entity) {
		return ExerciseDto.mapEntityToDto(entity);
	}

	@Override
	public Exercise mapDtoToEntity(ExerciseDto dto) {
		return ExerciseDto.mapDtoToEntity(dto);
	}

}
