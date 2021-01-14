package com.bataryat.modules.plan.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.dto.BaseDto;
import com.bataryat.modules.plan.model.Plan;

public abstract class BasePlanDto extends BaseDto {

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

	BasePlanDto() {

	}

	public static void mapEntityToDto(Plan entity, BasePlanDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setPrice(entity.getPrice());
		dto.setIsActive(entity.isActive());
		dto.setIsSpecial(entity.isSpecial());
		dto.setDiscount(entity.getDiscount());
		dto.setNumberOfDays(entity.getNumberOfDays());
		dto.setNumberOfReservedDays(entity.getNumberOfReservedDays());
		dto.setNumberOfInvitations(entity.getNumberOfInvitations());
	}

	public static void mapDtoToEntity(BasePlanDto dto, Plan entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setPrice(dto.getPrice());
		entity.setIsActive(dto.isActive());
		entity.setIsSpecial(dto.isSpecial());
		entity.setDiscount(dto.getDiscount());
		entity.setNumberOfDays(dto.getNumberOfDays());
		entity.setNumberOfReservedDays(dto.getNumberOfReservedDays());
		entity.setNumberOfInvitations(dto.getNumberOfInvitations());
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

	public void setIsSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
