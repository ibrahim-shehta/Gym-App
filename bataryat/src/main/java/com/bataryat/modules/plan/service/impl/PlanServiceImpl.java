package com.bataryat.modules.plan.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.exception.exceptions.EnityNotFoundException;
import com.bataryat.common.service.impl.BaseServiceImpl;
import com.bataryat.modules.plan.dao.PlanRepository;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.service.PlanService;

@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, Long> implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public PlanRepository getRepository() {
		return this.planRepository;
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
