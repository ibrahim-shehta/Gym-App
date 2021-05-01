package com.gym.modules.settings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseServiceImpl;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;
import com.gym.modules.settings.repository.SettingsRepository;
import com.gym.modules.settings.service.SettingsService;

@Service
public class SettingsServiceImpl extends BaseServiceImpl<Settings, Long> implements SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;
	
	@Override
	public JpaRepository<Settings, Long> getRepository() {
		return settingsRepository;
	}

	@Override
	public Settings findByCode(SettingsCode code) {
		return settingsRepository.findByCode(code);
	}
	
	

}
