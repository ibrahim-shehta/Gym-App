package com.gym.modules.exercises.excercises.dto;

public class ExerciseListDto extends BaseExerciseDto {

	private String exerciseCategoryName;
	private String equipmentName;

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
