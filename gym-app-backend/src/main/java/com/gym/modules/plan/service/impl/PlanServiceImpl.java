package com.gym.modules.plan.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.service.impl.BaseServiceWithSepecificationImpl;
import com.gym.modules.plan.dao.PlanRepository;
import com.gym.modules.plan.dao.specification.PlanSpecification;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;

@Service
public class PlanServiceImpl extends BaseServiceWithSepecificationImpl<Plan, Long> implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public PlanRepository getRepository() {
		return this.planRepository;
	}
	
	public JpaSpecificationExecutor<Plan> getSpecificationRepository() {
		return planRepository;
	}
	
	public Specification<Plan> getSpecifications(Map<String, Object> filterDataMap) {
		return PlanSpecification.filterPlans(filterDataMap);
	}

	@Override
	public Plan findByIdAndLang(Long id) {
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Optional<Plan> entity = getRepository().findByIdAndLang(id, langCode);
		return entity.orElseThrow(() -> new EnityNotFoundException(MessagesKeys.EXCEPTION_MESSAGES_ENTITY_NOT_FOUND));
	}
	
	@Override
	public List<Plan> findAllByLang() {
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		return getRepository().findAllByLang(langCode);
	}
	
	
}
