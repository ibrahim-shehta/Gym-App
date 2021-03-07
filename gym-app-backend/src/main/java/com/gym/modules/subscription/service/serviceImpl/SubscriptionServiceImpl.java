package com.gym.modules.subscription.service.serviceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.gym.common.constant.AppConstant;
import com.gym.common.service.impl.BaseServiceWithSepecificationImpl;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;
import com.gym.modules.subscription.dao.SubscriptionRepository;
import com.gym.modules.subscription.dao.specification.SubscriptionSpecification;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.model.enums.SubscriptionStatus;
import com.gym.modules.subscription.service.SubscriptionService;

@Service
@Transactional
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
		List<Long> expiredIds =  subscriptionRepository.findSubscriptionByStatusAndUser(SubscriptionStatus.EXPIRED, entity.getUser().getId());
		List<Long> inProgressIds =  subscriptionRepository.findSubscriptionByStatusAndUser(SubscriptionStatus.IN_PROGRESS, entity.getUser().getId());
		if (expiredIds.isEmpty() && inProgressIds.isEmpty()) {
			entity.setStatus(SubscriptionStatus.IN_PROGRESS);
		} else if (!expiredIds.isEmpty()) {
			entity.setStatus(SubscriptionStatus.IN_PROGRESS);
			subscriptionRepository.updateSubscriptionStatusById(expiredIds.get(0), SubscriptionStatus.RENEWED);
		} else if (!inProgressIds.isEmpty()) {
			entity.setStatus(SubscriptionStatus.NEW);
		}

		Plan plan = planService.findById(entity.getPlan().getId());
		entity.setPrice(plan.getPrice());
		entity.setDiscount(plan.getDiscount());
		entity.setNumberOfDays(plan.getNumberOfDays());
		entity.setNumberOfReservedDays(plan.getNumberOfReservedDays());
		entity.setNumberOfInvitations(plan.getNumberOfInvitations());
		entity.setSpecial(plan.isSpecial());
		entity.setSubscriptionNumber(entity.getUser().getId() + AppConstant.UNIQE_SEPERATOR + getSubscriptionNumber());
		return  super.save(entity);
	}
	
	
	private String getSubscriptionNumber() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + AppConstant.UNIQE_SEPERATOR + (cal.get(Calendar.MONTH) + 1);
	}
}
