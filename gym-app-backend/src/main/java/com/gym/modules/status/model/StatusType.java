package com.gym.modules.status.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gym.common.model.BaseEntity;
import com.gym.modules.status.model.enums.StatusTypeCode;

@Entity
public class StatusType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	@Enumerated(EnumType.STRING)
	private StatusTypeCode code;
	
	public StatusType() {
		// TODO Auto-generated constructor stub
	}
	
	public StatusType(Long id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public StatusTypeCode getCode() {
		return code;
	}

	public void setCode(StatusTypeCode code) {
		this.code = code;
	}
	
}
