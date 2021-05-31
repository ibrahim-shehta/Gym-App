package com.gym.modules.settings.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;
import com.gym.modules.settings.repository.SettingsRepository;
import com.gym.modules.settings.service.SettingsService;

@Service
public class SettingsServiceImpl extends BaseAuditServiceImpl<Settings, Long> implements SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;
	
	@Override
	public SettingsRepository getRepository() {
		return settingsRepository;
	}

	@Override
	public Specification<Settings> getSpecifications(Map<String, Object> filterDataMap) {return null;}
	
	@Override
	public Settings findByCode(SettingsCode code) {
		return settingsRepository.findByCode(code);
	}


	
	
	

}
