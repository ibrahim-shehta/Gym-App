package com.gym.user.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.gym.common.model.Auditable;

@Entity
@Table(name="roles")
public class Role extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> roles = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(
			  name = "roles_permissions", 
			  joinColumns = @JoinColumn(name = "roleId"), 
			  inverseJoinColumns = @JoinColumn(name = "permissionId"))
	private Set<Permission> permissions = new HashSet<>();

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(Long id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<User> getRoles() {
		return roles;
	}

	public void setRoles(List<User> roles) {
		this.roles = roles;
	}
	
}
