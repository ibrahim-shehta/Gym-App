package com.bataryat.user.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.bataryat.common.model.Auditable;

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
