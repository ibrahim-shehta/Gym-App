package com.gym.modules.equipments.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.modules.equipments.model.Equipment;

@Repository
public interface EquipmentRepostory extends JpaRepository<Equipment, Long>, JpaSpecificationExecutor<Equipment> {
	
}
