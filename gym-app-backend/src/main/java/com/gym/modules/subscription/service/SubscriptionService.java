package com.gym.modules.subscription.service;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseService;
import com.gym.modules.subscription.model.Subscription;

public interface SubscriptionService extends BaseService<Subscription, Long> {

	public Page<Subscription> filterSubscriptions(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
}
