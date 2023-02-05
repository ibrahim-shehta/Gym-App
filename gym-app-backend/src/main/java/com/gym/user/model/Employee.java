package com.gym.user.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Employee")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double salary;
	
}
