package com.gym.modules.exercises.excercises.dto;

import com.gym.common.dto.BaseDto;
import com.gym.modules.exercises.excercises.model.Exercise;

public class BaseExerciseDto extends BaseDto {

	private String name;
	private String description;
	private String imagePath;
	private String vedioPath;
	private int defaultCount;
	private boolean isActive;
	
	public static void mapEntityToDto(Exercise entity, BaseExerciseDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setImagePath(entity.getImagePath());
		dto.setVedioPath(entity.getVedioPath());
		dto.setDefaultCount(entity.getDefaultCount());
		dto.setActive(entity.isActive());
	}
	
	public static void mapDtoToEntity(BaseExerciseDto dto, Exercise entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImagePath(dto.getImagePath());
		entity.setVedioPath(dto.getVedioPath());
		entity.setDefaultCount(dto.getDefaultCount());
		entity.setActive(dto.isActive());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getVedioPath() {
		return vedioPath;
	}
	public void setVedioPath(String vedioPath) {
		this.vedioPath = vedioPath;
	}
	public int getDefaultCount() {
		return defaultCount;
	}
	public void setDefaultCount(int defaultCount) {
		this.defaultCount = defaultCount;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
