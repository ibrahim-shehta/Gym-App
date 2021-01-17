package com.gym.user.model;

import javax.persistence.Entity;

import com.gym.common.model.BaseEntity;

@Entity
public class UserDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tall;
	private int weight;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Long id) {
		super(id);
	}

	public int getTall() {
		return tall;
	}

	public void setTall(int tall) {
		this.tall = tall;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
