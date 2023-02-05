package com.gym.user.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Member")
@Data
@EqualsAndHashCode(callSuper = true)
public class Member extends User {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tall;
	private int weight;

	
}
