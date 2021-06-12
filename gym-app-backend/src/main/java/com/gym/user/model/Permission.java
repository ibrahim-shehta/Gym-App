package com.gym.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gym.common.model.BaseEntity;

@Entity
@Table(name="permissions")
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String code;
	private boolean isModule;
	private boolean isScreen;
	private String path;
	private String icon;
	
	@ManyToOne
	private Permission parent;
	
	@ManyToMany(mappedBy="permissions")
	private Set<Role> roles = new HashSet<>();
	
	public Permission() {
		// TODO Auto-generated constructor stub
	}
	
	public Permission(Long id) {
		super(id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isModule() {
		return isModule;
	}

	public void setModule(boolean isModule) {
		this.isModule = isModule;
	}

	public boolean isScreen() {
		return isScreen;
	}

	public void setScreen(boolean isScreen) {
		this.isScreen = isScreen;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
