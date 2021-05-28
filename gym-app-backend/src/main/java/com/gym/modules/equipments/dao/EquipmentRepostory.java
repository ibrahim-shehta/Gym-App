package com.gym.modules.equipments.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.equipments.model.Equipment;

@Repository
public interface EquipmentRepostory extends BaseRepository<Equipment, Long>, JpaSpecificationExecutor<Equipment> {
	
}
