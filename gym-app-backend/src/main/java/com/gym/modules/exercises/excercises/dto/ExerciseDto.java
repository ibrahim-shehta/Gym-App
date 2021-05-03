package com.gym.modules.exercises.excercises.dto;

import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.exercises.category.dto.BaseExcerciseCategoryDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.modules.exercises.excercises.model.Exercise;

public class ExerciseDto extends BaseExerciseDto {

	private BaseExcerciseCategoryDto category;
	private EquipmentDto equipment;
	
	 public static ExerciseDto mapEntityToDto(Exercise entity) {
		 if (entity == null) {
			 return null;
		 }
		 
		 ExerciseDto dto = new ExerciseDto();
		 BaseExerciseDto.mapEntityToDto(entity, dto);
		 dto.setCategory(entity.getCategory() != null ? BaseExcerciseCategoryDto.mapEntityToDto(entity.getCategory(), new BaseExcerciseCategoryDto()) : null);
		 dto.setEquipment(EquipmentDto.mapEntityToDto(entity.getEquipment()));
		 return dto;
	 }
	 
	 
	 public static Exercise mapDtoToEntity(ExerciseDto dto) {
		 if (dto == null) {
			 return null;
		 }
		 
		 Exercise entity = new Exercise();
		 BaseExerciseDto.mapDtoToEntity(dto, entity);
		 entity.setCategory(dto.getCategory() != null ? BaseExcerciseCategoryDto.mapDtoToEntity(dto.getCategory(), new ExcerciseCategory()) : null);
		 entity.setEquipment(EquipmentDto.mapDtoToEntity(dto.getEquipment()));
		 return entity;
	 }
	
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
