package com.gym.modules.exercises.excercises.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.gym.common.model.Auditable;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Entity
public class Exercise extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String imagePath;
	private String vedioPath;
	private int defaultCount;
	private boolean isActive;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Equipment equipment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ExcerciseCategory category;
	
	public Exercise() {};
	
	public Exercise(Long id) {
		super(id);
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

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public ExcerciseCategory getCategory() {
		return category;
	}

	public void setCategory(ExcerciseCategory category) {
		this.category = category;
	}
	
	
}
