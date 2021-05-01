package com.gym.modules.settings.service;

import com.gym.common.service.BaseService;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;

public interface SettingsService extends BaseService<Settings, Long> {

	public Settings findByCode(SettingsCode code);
}
