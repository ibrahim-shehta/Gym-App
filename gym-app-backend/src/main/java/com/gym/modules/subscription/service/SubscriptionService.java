package com.gym.modules.subscription.service;


import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.subscription.model.Subscription;
public interface SubscriptionService extends BaseServiceWithSepecification<Subscription, Long> {
	
	public void validateUserSubscription(Long userId);
}
