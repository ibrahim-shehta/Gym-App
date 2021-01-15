package com.bataryat.common.exception.exceptions;

import java.util.List;

import com.bataryat.common.exception.model.AppSubError;

public class EntityDuplicateAttributes extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<AppSubError> errors;
	
	public EntityDuplicateAttributes(String msg) {
		super(msg);
	}
	
	public EntityDuplicateAttributes(String msg, List<AppSubError> errors) {
		this(msg);
		this.setErrors(errors);
	}

	public List<AppSubError> getErrors() {
		return errors;
	}

	public void setErrors(List<AppSubError> errors) {
		this.errors = errors;
	}

}
