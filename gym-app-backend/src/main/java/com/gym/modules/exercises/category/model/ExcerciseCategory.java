package com.gym.modules.exercises.category.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gym.common.model.Auditable;


@Entity
public class ExcerciseCategory extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(nullable=true)
	private ExcerciseCategory nextExcerciseCategory;
;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExcerciseCategory getNextExcerciseCategory() {
		return nextExcerciseCategory;
	}

	public void setNextExcerciseCategory(ExcerciseCategory nextExcerciseCategory) {
		this.nextExcerciseCategory = nextExcerciseCategory;
	}
	
}
