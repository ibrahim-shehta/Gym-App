package com.gym.modules.equipments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseStatusController;
import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.equipments.dto.mapper.EquipmentDtoMapper;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.service.EquipmentService;


@Controller
@RequestMapping("/api/v1/equipment")
public class EquipmentController extends BaseStatusController<Equipment, Long, EquipmentDto, EquipmentDto> {

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private EquipmentDtoMapper equipmentDtoMapper;

	@Override
	protected EquipmentService getService() {
		return equipmentService;
	}

	@Override
	protected EquipmentDtoMapper getEntityDtoMapper() {
		return equipmentDtoMapper;
	}

	@Override
	protected EquipmentDtoMapper getListDtoMapper() {
		return equipmentDtoMapper;
	}
	
}
