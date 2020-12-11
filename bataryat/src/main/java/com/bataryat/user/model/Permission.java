package com.bataryat.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bataryat.common.model.BaseEntity;

@Entity
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private PermissionType type;
	
	@ManyToOne
	private Permission parent;
	
	@OneToMany(mappedBy="permission")
	private Set<RolePermission> rolePermission = new HashSet<>();
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PermissionType getType() {
		return type;
	}

	public void setType(PermissionType type) {
		this.type = type;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public Set<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(Set<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}
	
	
	
	
}
