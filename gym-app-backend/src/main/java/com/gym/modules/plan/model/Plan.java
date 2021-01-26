package com.gym.modules.plan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gym.common.model.Auditable;

@Entity
@Table(name = "plans")
public class Plan extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private double price;
	private int numberOfDays;
	private int numberOfReservedDays;
	private int numberOfInvitations;
	private int discount;
	private boolean isSpecial;
	private boolean isActive;

//	@OneToMany(mappedBy = "plan", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<PlanTranslate> planTranslate = new ArrayList<>();

	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public Plan(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
