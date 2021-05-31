package com.gym.modules.subscription.dto;

import java.util.Date;

import com.gym.common.dto.BaseStatusDto;
import com.gym.modules.subscription.model.Subscription;
public class BaseSubscriptionDto extends BaseStatusDto {

	private double price;
	private Date startDate;
	private Date endDate;
	private double paidAmount;
	private String subscriptionNumber;
	private double requiredAmount;
	
	public static void mapEntityToDto(Subscription entity, BaseSubscriptionDto dto) {
		BaseStatusDto.mapEntityToDto(entity, dto);
		dto.setPrice(entity.getPrice());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setPaidAmount(entity.getPaidAmount());
		dto.setSubscriptionNumber(entity.getSubscriptionNumber());
		dto.setRequiredAmount(entity.getRequiredAmount());
	}

	public static void mapDtoToEntity(BaseSubscriptionDto dto, Subscription entity) {
		BaseStatusDto.mapDtoToEntity(dto, entity);
		entity.setPrice(dto.getPrice());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setPaidAmount(dto.getPaidAmount());
		entity.setRequiredAmount(dto.getRequiredAmount());
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

	public String getSubscriptionNumber() {
		return subscriptionNumber;
	}

	public void setSubscriptionNumber(String subscriptionNumber) {
		this.subscriptionNumber = subscriptionNumber;
	}
	
	public double getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(double requiredAmount) {
		this.requiredAmount = requiredAmount;
	}
}
