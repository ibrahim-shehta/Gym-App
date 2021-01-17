package com.bataryat.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.bataryat.common.model.BaseEntity;
import com.bataryat.user.model.translate.PermissionTranslate;

@Entity
@Table(name="permissions")
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	@Enumerated(EnumType.STRING)
	private PermissionType type;
	
	@ManyToOne
	private Permission parent;
	
	@OneToMany(mappedBy="permission")
	private List<RolePermission> rolePermission = new ArrayList<>();
	
	@OneToMany(mappedBy="permission")
	private List<PermissionTranslate> permissionTranslate = new ArrayList<>();

	
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

	public List<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(List<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public List<PermissionTranslate> getPermissionTranslate() {
		return permissionTranslate;
	}

	public void setPermissionTranslate(List<PermissionTranslate> permissionTranslate) {
		this.permissionTranslate = permissionTranslate;
	}
	
	
	
	
}
