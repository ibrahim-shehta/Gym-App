package com.bataryat.user.model.translate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.bataryat.common.model.Auditable;
import com.bataryat.user.model.Permission;

@Entity
public class PermissionTranslate extends Auditable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String langCode;
	private boolean isDefault;
	
	@ManyToOne
	private Permission permission;
	
	public PermissionTranslate() {
		// TODO Auto-generated constructor stub
	}
	
	public PermissionTranslate(Long id) {
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

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
	
	

}
