package com.gym.modules.subscription.dto;

import java.util.Date;

import com.gym.common.dto.BaseDto;
import com.gym.modules.subscription.model.Subscription;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;

public class BaseSubscriptionDto extends BaseDto {

	private double price;
	private Date startDate;
	private Date endDate;
	private double paidAmount;
	private boolean isActive;
	private UserListDto user;
	private String subscriptionNumber;
	
	public static void mapEntityToDto(Subscription entity, BaseSubscriptionDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setPrice(entity.getPrice());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setPaidAmount(entity.getPaidAmount());
		dto.setUser(UserListDto.mapEntityToDto(entity.getUser()));
		dto.setSubscriptionNumber(entity.getSubscriptionNumber());
	}

	public static void mapDtoToEntity(BaseSubscriptionDto dto, Subscription entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setPrice(dto.getPrice());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setPaidAmount(dto.getPaidAmount());
		entity.setUser(new User(dto.getUser().getId()));
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public UserListDto getUser() {
		return user;
	}

	public void setUser(UserListDto user) {
		this.user = user;
	}

	public String getSubscriptionNumber() {
		return subscriptionNumber;
	}

	public void setSubscriptionNumber(String subscriptionNumber) {
		this.subscriptionNumber = subscriptionNumber;
	}
}
