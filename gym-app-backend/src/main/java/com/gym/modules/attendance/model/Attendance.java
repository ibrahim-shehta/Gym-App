package com.gym.modules.attendance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.gym.common.model.Auditable;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.user.model.User;

@Entity
public class Attendance extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Type(type="date")
	private Date date;
	private String signIn;
	private String signOut;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ExcerciseCategory excerciseCategory;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSignIn() {
		return signIn;
	}
	public void setSignIn(String signIn) {
		this.signIn = signIn;
	}
	public String getSignOut() {
		return signOut;
	}
	public void setSignOut(String signOut) {
		this.signOut = signOut;
	}
	public ExcerciseCategory getExcerciseCategory() {
		return excerciseCategory;
	}
	public void setExcerciseCategory(ExcerciseCategory excerciseCategory) {
		this.excerciseCategory = excerciseCategory;
	}
	
	

}
