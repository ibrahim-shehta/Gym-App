package com.gym.modules.plan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gym.common.model.Auditable;

@Entity
@Table(name = "plans")
public class Plan extends Auditable {

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
	private boolean isActive;

	@OneToMany(mappedBy = "plan", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PlanTranslate> planTranslate = new ArrayList<>();

	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public Plan(Long id) {
		super(id);
	}

	public void addTranslate(PlanTranslate planTranslate) {
		this.planTranslate.add(planTranslate);
		planTranslate.setPlan(this);
	}

	public void removeTranslate(PlanTranslate planTranslate) {
		this.planTranslate.remove(planTranslate);
		planTranslate.setPlan(null);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<PlanTranslate> getPlanTranslate() {
		return planTranslate;
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

	public void setIsSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getPrice() {
		return price;
	}

	public void setPlanTranslate(List<PlanTranslate> planTranslate) {
		this.planTranslate = planTranslate;
	}

}
