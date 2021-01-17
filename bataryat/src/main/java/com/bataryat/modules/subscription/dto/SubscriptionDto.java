package com.bataryat.modules.subscription.dto;

import com.bataryat.modules.plan.dto.BasePlanDto;
import com.bataryat.modules.plan.dto.PlanListDto;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.subscription.model.Subscription;

public class SubscriptionDto extends BaseSubscriptionDto {

	 private int numberOfDays;
	 private int numberOfReservedDays;
	 private int numberOfInvitations;
	 private int discount;
	 private boolean isSpecial;
	 private BasePlanDto plan;
	 
		public static SubscriptionDto mapEntityToDto(Subscription entity) {
			if (entity == null) 
				return null;
			SubscriptionDto dto = new SubscriptionDto();
			BaseSubscriptionDto.mapEntityToDto(entity, dto);
			dto.setNumberOfDays(entity.getNumberOfDays());
			dto.setNumberOfReservedDays(entity.getNumberOfReservedDays());
			dto.setNumberOfInvitations(entity.getNumberOfInvitations());
			dto.setDiscount(entity.getDiscount());
			dto.setSpecial(entity.isSpecial());
			dto.setPlan(PlanListDto.mapEntityToDto(entity.getPlan()));
			return dto;
		}

		public static Subscription mapDtoToEntity(SubscriptionDto dto ) {
			if (dto == null) 
				return null;
			Subscription entity = new Subscription();
			BaseSubscriptionDto.mapDtoToEntity(dto, entity);
			entity.setNumberOfDays(dto.getNumberOfDays());
			entity.setNumberOfReservedDays(dto.getNumberOfReservedDays());
			entity.setNumberOfInvitations(dto.getNumberOfInvitations());
			entity.setDiscount(dto.getDiscount());
			entity.setSpecial(dto.isSpecial());
			entity.setPlan(new Plan(dto.getPlan().getId()));
			return entity;
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

	public BasePlanDto getPlan() {
		return plan;
	}

	public void setPlan(BasePlanDto plan) {
		this.plan = plan;
	}
	 
	 

}
