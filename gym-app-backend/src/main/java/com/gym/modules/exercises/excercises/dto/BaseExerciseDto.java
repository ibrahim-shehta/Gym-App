package com.gym.modules.exercises.excercises.dto;

import com.gym.common.dto.BaseDto;
import com.gym.modules.exercises.excercises.model.Exercise;

public class BaseExerciseDto extends BaseDto {

	private String name;
	private String description;
	private String imageName;
	private String videoName;
	private int defaultCount;
	private boolean isActive;
	
	public static void mapEntityToDto(Exercise entity, BaseExerciseDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setImageName(entity.getImageName());
		dto.setVideoName(entity.getVideoName());
		dto.setDefaultCount(entity.getDefaultCount());
		dto.setActive(entity.isActive());
	}
	
	public static void mapDtoToEntity(BaseExerciseDto dto, Exercise entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImageName(dto.getImageName());
		entity.setVideoName(dto.getVideoName());
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	
	
}
