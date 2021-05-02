package com.gym.modules.equipments.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseServiceWithSepecificationImpl;
import com.gym.modules.equipments.dao.EquipmentRepostory;
import com.gym.modules.equipments.dao.specification.EquipmentSpecification;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.service.EquipmentService;

@Service
public class EquipmentServiceImpl extends BaseServiceWithSepecificationImpl<Equipment, Long> implements EquipmentService {

	
	@Autowired
	private EquipmentRepostory equipmentRepostory;
	
	@Override
	public EquipmentRepostory getRepository() {
		return equipmentRepostory;
	}
	
	@Override
	public JpaSpecificationExecutor<Equipment> getSpecificationRepository() {
		return equipmentRepostory;
	}
	
	@Override
	public Specification<Equipment> getSpecifications(Map<String, Object> filterDataMap) {
		return EquipmentSpecification.filterEquipments(filterDataMap);
	}

	
	


}
