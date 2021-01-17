package com.bataryat.modules.subscription.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.bataryat.common.model.Auditable;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.user.model.User;

@Entity
public class Subscription extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double price;
	private int numberOfDays;
	private int numberOfReservedDays;
	private int numberOfInvitations;
	private int discount;
	private boolean isSpecial;

	private Date startDate;
	private Date endDate;
	private double paidAmount;
	private boolean isActive;

	@ManyToOne
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Plan plan;

	public Subscription() {

	}

	public Subscription(Long id) {
		super(id);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfReservedDays() {
		return numberOfReservedDays;
	}

	public void setNumberOfReservedDays(int numberOfReservedDays) {
		this.numberOfReservedDays = numberOfReservedDays;
	}

	public int getNumberOfInvitations() {
		return numberOfInvitations;
	}

	public void setNumberOfInvitations(int numberOfInvitations) {
		this.numberOfInvitations = numberOfInvitations;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}
