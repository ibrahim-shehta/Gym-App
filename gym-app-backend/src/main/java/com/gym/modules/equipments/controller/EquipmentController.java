package com.gym.modules.equipments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseController;
import com.gym.common.dto.mapper.BaseMapper;
import com.gym.common.service.BaseService;
import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.equipments.dto.mapper.EquipmentDtoMapper;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.service.EquipmentService;


@Controller
@RequestMapping("/api/v1/equipment")
public class EquipmentController extends BaseController<Equipment, Long, EquipmentDto, EquipmentDto>{

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private EquipmentDtoMapper equipmentDtoMapper;

	@Override
	protected BaseService<Equipment, Long> getService() {
		return equipmentService;
	}

	@Override
	protected BaseServiceWithSepecification<Equipment, Long> getServiceWithSepecification() {
		return equipmentService;
	}

	@Override
	protected BaseMapper<Equipment, EquipmentDto> getEntityDtoMapper() {
		return equipmentDtoMapper;
	}

	@Override
	protected BaseMapper<Equipment, EquipmentDto> getListDtoMapper() {
		return equipmentDtoMapper;
	}
	
}