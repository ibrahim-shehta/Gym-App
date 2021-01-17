package com.bataryat.user.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bataryat.common.model.BaseEntity;

@Entity
@Table(name="roles")
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
	private List<RolePermission> rolePermission = new ArrayList<>();

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
	public List<RolePermission> getRolePermission() {
		return rolePermission;
	}
	public void setRolePermission(List<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	
}
