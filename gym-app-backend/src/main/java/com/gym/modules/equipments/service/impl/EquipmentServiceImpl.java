package com.gym.modules.equipments.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.gym.common.dao.BaseStatusRepository;
import com.gym.common.service.impl.BaseStatusWithSpcificationServiceImpl;
import com.gym.modules.equipments.dao.EquipmentRepository;
import com.gym.modules.equipments.dao.specification.EquipmentSpecification;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.service.EquipmentService;





@Service
@Transactional
public class EquipmentServiceImpl extends BaseStatusWithSpcificationServiceImpl<Equipment, Long> implements EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Override
	public BaseStatusRepository<Equipment, Long> getRepository() {
		return equipmentRepository;
	}

	@Override
	public JpaSpecificationExecutor<Equipment> getSpecificationRepository() {
		return equipmentRepository;
	}

	@Override
	public Specification<Equipment> getSpecifications(Map<String, Object> filterDataMap) {
		return EquipmentSpecification.filterEquipments(filterDataMap);
	}

}
