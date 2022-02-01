package com.gym.modules.exercises.excercises.dto;

import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.exercises.category.dto.BaseExcerciseCategoryDto;

public class ExerciseDto extends BaseExerciseDto {

	private BaseExcerciseCategoryDto category;
	private EquipmentDto equipment;

	public BaseExcerciseCategoryDto getCategory() {
		return category;
	}

	public void setCategory(BaseExcerciseCategoryDto category) {
		this.category = category;
	}

	public EquipmentDto getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentDto equipment) {
		this.equipment = equipment;
	}

}
