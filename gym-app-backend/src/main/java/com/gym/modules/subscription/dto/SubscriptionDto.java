package com.gym.modules.subscription.dto;

import com.gym.modules.plan.dto.BasePlanDto;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.subscription.model.Subscription;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;

public class SubscriptionDto extends BaseSubscriptionDto {

	 private int numberOfDays;
	 private int numberOfReservedDays;
	 private int numberOfInvitations;
	 private int discount;
	 private boolean isSpecial;
	 private BasePlanDto plan;
	 private UserListDto user;
	 
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
			dto.setUser(UserListDto.mapEntityToDto(entity.getUser()));
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
			entity.setUser(new User(dto.getUser().getId()));
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
	
	public UserListDto getUser() {
		return user;
	}

	public void setUser(UserListDto user) {
		this.user = user;
	}

	 

}
