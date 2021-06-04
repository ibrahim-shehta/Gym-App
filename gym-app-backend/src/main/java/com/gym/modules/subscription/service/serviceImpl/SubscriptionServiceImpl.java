package com.gym.modules.subscription.service.serviceImpl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.constant.AppConstant;
import com.gym.common.constant.AppUtils;
import com.gym.common.constant.MessagesKeys;
import com.gym.common.constant.enums.Status;
import com.gym.common.exception.exceptions.SubscriptionException;
import com.gym.common.service.impl.BaseStatusServiceImpl;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;
import com.gym.modules.subscription.dao.SubscriptionRepository;
import com.gym.modules.subscription.dao.specification.SubscriptionSpecification;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl extends BaseStatusServiceImpl<Subscription, Long> implements SubscriptionService {

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
	public Specification<Subscription> getSpecifications(Map<String, Object> filterDataMap) {
		return SubscriptionSpecification.filterSubscriptions(filterDataMap);
	}
	
	@Override
	@Transactional
	public Subscription save(Subscription entity) {
		setSubscriptionStatus(entity);
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
	
	private void setSubscriptionStatus(Subscription entity) {
		List<Long> expiredIds =  subscriptionRepository.findSubscriptionByStatusAndUser(Status.EXPIRED.getValue(), entity.getUser().getId());
		List<Long> inProgressIds =  subscriptionRepository.findSubscriptionByStatusAndUser(Status.IN_PROGRESS.getValue(), entity.getUser().getId());
		if (expiredIds.isEmpty() && inProgressIds.isEmpty()) {
			entity.setStatus(Status.IN_PROGRESS.getValue());
		} else if (!expiredIds.isEmpty()) {
			entity.setStatus(Status.IN_PROGRESS.getValue());
			subscriptionRepository.updateSubscriptionStatusById(expiredIds.get(0), Status.RENEWED.getValue());
		} else if (!inProgressIds.isEmpty()) {
			entity.setStatus(Status.NEW.getValue());
		}
	}
	
	private String getSubscriptionNumber() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + AppConstant.UNIQE_SEPERATOR + (cal.get(Calendar.MONTH) + 1);
	}

	@Override
	public Long validateUserSubscription(Long userId) {
		List<Subscription> subscriptions = subscriptionRepository.getSubscriptionEntityByStatusAndUserId(Status.IN_PROGRESS.getValue(), userId);
		checkUserNotHaveValidSubscription(subscriptions);
		checkIfPlayerExceededDays(subscriptions.get(0));
		Long diffDays = checkIfDateExceeded(subscriptions.get(0));
		incrementAttendanceDays(subscriptions.get(0).getId());
		return diffDays;
	}
	
	private void checkUserNotHaveValidSubscription(List<Subscription> subscriptions) {
		if (subscriptions.isEmpty()) {
			throw new SubscriptionException(MessagesKeys.PLAYER_NOT_HAVE_VALID_SUBSCRIPTION);
		}
	}
	
	private void checkIfPlayerExceededDays(Subscription subscritpion) {
		if (subscritpion.getNumberOfReservedDays() == subscritpion.getAttendanceDays()) {
			subscriptionRepository.updateSubscriptionStatusById(subscritpion.getId() ,Status.EXPIRED.getValue());
			throw new SubscriptionException(MessagesKeys.SUBSCRIPTION_DAYS_EXPIRED);
		}
	}
	
	private Long checkIfDateExceeded(Subscription subscritpion) {
		LocalDate endDate = AppUtils.convertDateToLocalDate(subscritpion.getEndDate());
		LocalDate currentDate = LocalDate.now();
		
		if (currentDate.isAfter(endDate)) {
			subscriptionRepository.updateSubscriptionStatusById(subscritpion.getId() ,Status.EXPIRED.getValue());
			throw new SubscriptionException(MessagesKeys.SUBSCRIPTION_DATE_EXPIRED);
		}
		return AppUtils.getDurationInDays(currentDate, endDate);
	}
	
	private void incrementAttendanceDays(Long id) {
		subscriptionRepository.incrementDaysBySubscriptionId(id);
	}

	@Override
	@Transactional
	public void payRemainAmount(Subscription subscription) {
		subscriptionRepository.payRemainAmount(subscription.getId(), subscription.getPaidAmount());
	}
}
