package com.bataryat.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.bataryat.common.model.BaseEntity;

@Entity
public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	
	@OneToMany(mappedBy="role")
	private Set<UserRole> userRole = new HashSet<>();
	
	@OneToMany(mappedBy="role")
	private Set<RolePermission> rolePermission = new HashSet<>();

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<RolePermission> getRolePermission() {
		return rolePermission;
	}
	public void setRolePermission(Set<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	
}
