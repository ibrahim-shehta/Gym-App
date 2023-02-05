package com.gym.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.gym.common.constant.enums.Status;
import com.gym.common.model.BaseStatusEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users") // , uniqueConstraints=@UniqueConstraint(columnNames={"email", "username", "mobile"})
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseStatusEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private String username;

	private String mobile;

	private String address;

	@Type(type="date")
	private Date birthDate;

	@Column(updatable=false)
	private String password;
	
	@Column(updatable=false)
	private String imageName;

	private boolean isTokenExpired;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	private UserDetails userDetails;
	
	
	@ManyToMany(cascade= {CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(
			  name = "users_roles", 
			  joinColumns = @JoinColumn(name = "userId"), 
			  inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles = new ArrayList<>();

	public User() {
		setStatus(Status.ACTIVE.getValue());
	}

	public User(Long id) {
		super(id);
	}


}
