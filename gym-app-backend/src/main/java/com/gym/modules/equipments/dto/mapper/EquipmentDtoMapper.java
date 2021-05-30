package com.gym.modules.equipments.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.equipments.model.Equipment;

@Component
public class EquipmentDtoMapper implements BaseStatusMapper<Equipment, EquipmentDto> {


	@Override
	public EquipmentDto mapEntityToDto(Equipment entity) {
		return EquipmentDto.mapEntityToDto(entity);
	}

	@Override
	public Equipment mapDtoToEntity(EquipmentDto dto) {
		return EquipmentDto.mapDtoToEntity(dto);
	}

	@Override
	public List<EquipmentDto> mapListToDtos(List<Equipment> entity) {
		return EquipmentDto.mapListToDtos(entity);
	}



}
