package com.gym.modules.subscription.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.subscription.dto.SubscriptionListDto;
import com.gym.modules.subscription.model.Subscription;
import com.gym.user.model.User;

@Mapper(componentModel = "spring")
public interface SubscriptionListDtoMapper extends BaseStatusMapper<Subscription, SubscriptionListDto> {

	@Mapping(source = "user", target = "playerName")
	@Mapping(source = "plan", target = "planName")
	SubscriptionListDto mapEntityToDto(Subscription entity);
	
	
	default String mapUserToString(User user) {
		return user != null ? user.getName() : "";
	}
	
	default String mapPlanToString(Plan plan) {
		return plan != null ? plan.getName() : "";
	}
}
