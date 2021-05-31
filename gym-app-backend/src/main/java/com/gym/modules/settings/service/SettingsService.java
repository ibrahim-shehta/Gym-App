package com.gym.modules.settings.service;

import com.gym.common.service.BaseAuditService;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;

public interface SettingsService extends BaseAuditService<Settings, Long> {

	public Settings findByCode(SettingsCode code);
}
