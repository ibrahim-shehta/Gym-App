package com.bataryat.modules.subscription.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bataryat.common.request.FilterDataWithPaginationAndSort;
import com.bataryat.common.service.impl.BaseServiceImpl;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.service.PlanService;
import com.bataryat.modules.subscription.dao.SubscriptionRepository;
import com.bataryat.modules.subscription.dao.specification.SubscriptionSpecification;
import com.bataryat.modules.subscription.model.Subscription;
import com.bataryat.modules.subscription.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl extends BaseServiceImpl<Subscription, Long> implements SubscriptionService{

	private SubscriptionRepository subscriptionRepository;
	private PlanService planService;
	
	@Autowired
	public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, PlanService planService) {
		this.subscriptionRepository = subscriptionRepository;
		this.planService = planService;
	}
	
	@Override
	public SubscriptionRepository getRepository() {
		return subscriptionRepository;
	}
	
	@Override
	public Subscription save(Subscription entity) {
		Plan plan = planService.findById(entity.getPlan().getId());
		entity.setPrice(plan.getPrice());
		entity.setDiscount(plan.getDiscount());
		entity.setNumberOfDays(plan.getNumberOfDays());
		entity.setNumberOfReservedDays(plan.getNumberOfReservedDays());
		entity.setNumberOfInvitations(plan.getNumberOfInvitations());
		entity.setSpecial(plan.isSpecial());
		return super.save(entity);
	}

	@Override
	public Page<Subscription> filterSubscriptions(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Pageable pageRequest = filterDataWithPaginationAndSort.getPageRequest();
		return subscriptionRepository.findAll(SubscriptionSpecification.filterSubscriptions(filterDataWithPaginationAndSort.getFilterMap()), pageRequest);
	}

}
