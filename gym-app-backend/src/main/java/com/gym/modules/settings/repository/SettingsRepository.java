package com.gym.modules.settings.repository;

import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;

@Repository
public interface SettingsRepository extends BaseRepository<Settings, Long> {

	public Settings findByCode(SettingsCode code);
}
