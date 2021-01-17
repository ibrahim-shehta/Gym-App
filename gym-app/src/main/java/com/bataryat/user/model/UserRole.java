package com.bataryat.user.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.bataryat.common.model.Auditable;

@Entity
public class UserRole  extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Role role;
	
	@ManyToOne
	private User user;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

}
