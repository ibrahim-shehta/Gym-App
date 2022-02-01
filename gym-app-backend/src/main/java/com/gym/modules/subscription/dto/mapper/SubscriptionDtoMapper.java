package com.gym.modules.subscription.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.subscription.dto.SubscriptionDto;
import com.gym.modules.subscription.model.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionDtoMapper extends BaseStatusMapper<Subscription, SubscriptionDto> {

}
