package com.gym.modules.exercises.excercises.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseMapper;
import com.gym.modules.exercises.excercises.dto.ExerciseListDto;
import com.gym.modules.exercises.excercises.model.Exercise;

@Component
public class ExerciseListDtoMapper implements BaseMapper<Exercise, ExerciseListDto> {

	@Override
	public ExerciseListDto mapEntityToDto(Exercise entity) {
		return ExerciseListDto.mapEntityToDto(entity);
	}
	
	@Override
	public List<ExerciseListDto> mapListToDtos(List<Exercise> entity) {
		return ExerciseListDto.mapListToDtos(entity);
	}

}
