package com.gym.user.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.gym.common.model.Auditable;

@Entity
public class RolePermission extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Permission permission;
	
	@ManyToOne
	private Role role;

	public RolePermission() {
		// TODO Auto-generated constructor stub
	}
	
	public RolePermission(Long id) {
		super(id);
	}
	
	public RolePermission(Role role, Permission permission) {
		this.role = role;
		this.permission = permission;
	}
	
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
