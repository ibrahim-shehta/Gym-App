package com.gym.modules.subscription.service;


import com.gym.common.service.BaseStatusService;
import com.gym.modules.subscription.model.Subscription;
public interface SubscriptionService extends BaseStatusService<Subscription, Long> {
	
	public Long validateUserSubscription(Long userId);
	
	public void payRemainAmount(Subscription subscription);
}
