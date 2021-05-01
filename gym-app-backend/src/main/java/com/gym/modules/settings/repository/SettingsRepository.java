package com.gym.modules.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {

	public Settings findByCode(SettingsCode code);
}
