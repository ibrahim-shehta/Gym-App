package com.bataryat.modules.subscription.service;

import org.springframework.data.domain.Page;

import com.bataryat.common.request.FilterDataWithPaginationAndSort;
import com.bataryat.common.service.BaseService;
import com.bataryat.modules.subscription.model.Subscription;

public interface SubscriptionService extends BaseService<Subscription, Long> {

	public Page<Subscription> filterSubscriptions(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
}
