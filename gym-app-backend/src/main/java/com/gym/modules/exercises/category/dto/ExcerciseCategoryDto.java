package com.gym.modules.exercises.category.dto;

public class ExcerciseCategoryDto extends BaseExcerciseCategoryDto {

	private ExcerciseCategoryDto nextExcerciseCategory;

	public ExcerciseCategoryDto getNextExcerciseCategory() {
		return nextExcerciseCategory;
	}

	public void setNextExcerciseCategory(ExcerciseCategoryDto nextExcerciseCategory) {
		this.nextExcerciseCategory = nextExcerciseCategory;
	}

}
