package com.gym.modules.equipments.service;


import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.equipments.model.Equipment;

public interface EquipmentService extends BaseServiceWithSepecification<Equipment, Long> {

	void updateStatus(boolean isActive, Long id);
}
