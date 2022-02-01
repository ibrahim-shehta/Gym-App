package com.gym.modules.plan.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.dto.BaseDto;

public class BasePlanDto extends BaseDto {

	@NotBlank(message = MessagesKeys.VALIDATION_PLAN_NAME)
	@Length(min = 3, message = MessagesKeys.VALIDATION_PLAN_NAME)
	private String name;
	private String description;
	@Positive(message = MessagesKeys.VALIDATION_PLAN_PRICE)
	private double price;
	@Positive(message = MessagesKeys.VALIDATION_PLAN_NUMBEROFDAYS)
	private int numberOfDays;
	@Positive(message = MessagesKeys.VALIDATION_PLAN_NUMBEROFRESRVEDDAYS)
	private int numberOfReservedDays;
	@PositiveOrZero(message = MessagesKeys.VALIDATION_PLAN_NUMBEROFINVITATIONS)
	private int numberOfInvitations;
	@PositiveOrZero(message = MessagesKeys.VALIDATION_PLAN_DISCOUNT)
	private int discount;
	private boolean isSpecial;
	private boolean isActive;

	public BasePlanDto() {

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
