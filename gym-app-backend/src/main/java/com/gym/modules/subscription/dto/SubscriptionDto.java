package com.gym.modules.subscription.dto;

import com.gym.modules.plan.dto.BasePlanDto;
import com.gym.user.dto.UserListDto;

public class SubscriptionDto extends BaseSubscriptionDto {

	private int numberOfDays;
	private int numberOfReservedDays;
	private int numberOfInvitations;
	private int discount;
	private boolean isSpecial;
	private BasePlanDto plan;
	private UserListDto user;

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

	public BasePlanDto getPlan() {
		return plan;
	}

	public void setPlan(BasePlanDto plan) {
		this.plan = plan;
	}

	public UserListDto getUser() {
		return user;
	}

	public void setUser(UserListDto user) {
		this.user = user;
	}

}
