package com.gym.modules.subscription.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.subscription.dto.SubscriptionListDto;
import com.gym.modules.subscription.model.Subscription;

@Component
public class SubscriptionListDtoMapper implements BaseStatusMapper<Subscription, SubscriptionListDto> {

	@Override
	public SubscriptionListDto mapEntityToDto(Subscription entity) {
		return SubscriptionListDto.mapEntityToDto(entity);
	}

	@Override
	public List<SubscriptionListDto> mapListToDtos(List<Subscription> entity) {
		return SubscriptionListDto.mapListToDtos(entity);
	}
}
