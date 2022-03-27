package com.gym.modules.exercises.excercises.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.modules.exercises.excercises.dto.ExerciseListDto;
import com.gym.modules.exercises.excercises.model.Exercise;

@Mapper(componentModel = "spring")
public interface ExerciseListDtoMapper extends BaseDtoMapper<Exercise, ExerciseListDto> {

	@Mapping(source = "category", target = "exerciseCategoryName")
	@Mapping(source = "equipment", target = "equipmentName")
	ExerciseListDto mapEntityToDto(Exercise entity);
	
	
	default String mapUserToString(ExcerciseCategory excerciseCategory) {
		return excerciseCategory != null ? excerciseCategory.getName() : "";
	}
	
	default String mapPlanToString(Equipment equipment) {
		return equipment != null ? equipment.getName() : "";
	}
}
