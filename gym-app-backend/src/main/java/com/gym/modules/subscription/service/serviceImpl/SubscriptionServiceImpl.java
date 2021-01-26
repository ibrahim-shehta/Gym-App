package com.gym.modules.subscription.service.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseServiceWithSepecificationImpl;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;
import com.gym.modules.subscription.dao.SubscriptionRepository;
import com.gym.modules.subscription.dao.specification.SubscriptionSpecification;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl extends BaseServiceWithSepecificationImpl<Subscription, Long> implements SubscriptionService{

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
	
	public JpaSpecificationExecutor<Subscription> getSpecificationRepository() {
		return subscriptionRepository;
	}
	
	public Specification<Subscription> getSpecifications(Map<String, Object> filterDataMap) {
		return SubscriptionSpecification.filterSubscriptions(filterDataMap);
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
	
}
