package com.gym.modules.exercises.excercises.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.exercises.excercises.model.Exercise;

public class ExerciseListDto extends BaseExerciseDto {
	
	private String exerciseCategoryName;
	private String equipmentName;
	
	public static ExerciseListDto mapEntityToDto(Exercise entity) {
		if (entity == null) {
			return null;
		}
		ExerciseListDto dto = new ExerciseListDto();
		BaseExerciseDto.mapEntityToDto(entity, dto);
		dto.setExerciseCategoryName(entity.getCategory() != null ? entity.getCategory().getName() : null);
		dto.setEquipmentName(entity.getEquipment() != null ? entity.getEquipment().getName() : null);
		return dto;
	}
	
	public static List<ExerciseListDto> mapListToDtos(List<Exercise> entity) {
		if (entity == null)
			return Collections.emptyList();
		List<ExerciseListDto> dto = entity.stream().map(exercise -> mapEntityToDto(exercise)).collect(Collectors.toList());
		return dto;
	}
	
	public String getExerciseCategoryName() {
		return exerciseCategoryName;
	}
	public void setExerciseCategoryName(String exerciseCategoryName) {
		this.exerciseCategoryName = exerciseCategoryName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
}
