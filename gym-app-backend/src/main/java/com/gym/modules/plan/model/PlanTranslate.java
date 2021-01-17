package com.gym.modules.plan.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.gym.common.model.BaseEntity;

@Entity
public class PlanTranslate extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String langCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Plan plan;

	public PlanTranslate() {
		// TODO Auto-generated constructor stub
	}
	
	public PlanTranslate(Long id) {
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

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
