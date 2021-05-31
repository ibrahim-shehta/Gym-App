package com.gym.modules.equipments.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseStatusServiceImpl;
import com.gym.modules.equipments.dao.EquipmentRepository;
import com.gym.modules.equipments.dao.specification.EquipmentSpecification;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.service.EquipmentService;





@Service
@Transactional
public class EquipmentServiceImpl extends BaseStatusServiceImpl<Equipment, Long> implements EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Override
	public EquipmentRepository getRepository() {
		return equipmentRepository;
	}

	@Override
	public Specification<Equipment> getSpecifications(Map<String, Object> filterDataMap) {
		return EquipmentSpecification.filterEquipments(filterDataMap);
	}

}
