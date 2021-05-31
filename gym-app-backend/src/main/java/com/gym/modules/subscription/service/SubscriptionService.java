package com.gym.modules.subscription.service;


import com.gym.common.service.BaseAuditService;
import com.gym.modules.subscription.model.Subscription;
public interface SubscriptionService extends BaseAuditService<Subscription, Long> {
	
	public Long validateUserSubscription(Long userId);
	
	public void payRemainAmount(Subscription subscription);
}
