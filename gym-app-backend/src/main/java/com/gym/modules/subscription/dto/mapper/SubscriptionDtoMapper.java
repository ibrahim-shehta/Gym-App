package com.gym.modules.subscription.dto.mapper;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.subscription.dto.SubscriptionDto;
import com.gym.modules.subscription.model.Subscription;

@Component
public class SubscriptionDtoMapper implements BaseStatusMapper<Subscription, SubscriptionDto> {

	@Override
	public SubscriptionDto mapEntityToDto(Subscription entity) {
		return SubscriptionDto.mapEntityToDto(entity);
	}

	@Override
	public Subscription mapDtoToEntity(SubscriptionDto dto) {
		return SubscriptionDto.mapDtoToEntity(dto);
	}
}