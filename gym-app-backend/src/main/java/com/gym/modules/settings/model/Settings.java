package com.gym.modules.settings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gym.common.model.Auditable;
import com.gym.modules.settings.model.enums.SettingsCode;

@Entity
public class Settings extends Auditable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	@Column(unique = true)
	@Enumerated(EnumType.STRING)
	private SettingsCode code;
	private String value;
	
	Settings() {}
	Settings(Long id) {
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
	public SettingsCode getCode() {
		return code;
	}
	public void setCode(SettingsCode code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
 
}
