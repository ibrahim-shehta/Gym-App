package com.gym.modules.equipments.model;

import javax.persistence.Entity;

import com.gym.common.model.BaseStatusEntity;



@Entity
public class Equipment extends BaseStatusEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String Code;

	 
	public Equipment() {}
	
	public Equipment(Long id) {
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

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
}
