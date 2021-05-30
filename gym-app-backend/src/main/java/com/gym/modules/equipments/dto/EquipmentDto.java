package com.gym.modules.equipments.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.common.dto.BaseStatusDto;
import com.gym.modules.equipments.model.Equipment;

public class EquipmentDto extends BaseStatusDto {

	private String name;
	private String description;
	private String Code;
	
	public static EquipmentDto mapEntityToDto(Equipment entity) {
		if (entity == null) {
			return null;
		}
		EquipmentDto dto = new EquipmentDto();
		BaseStatusDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setCode(entity.getCode());
		return dto;
	}

	public static Equipment mapDtoToEntity(EquipmentDto dto) {
		if (dto == null) {
			return null;
		}
		Equipment entity = new Equipment();
		BaseStatusDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setCode(dto.getCode());
		return entity;
	}
	
	public static List<EquipmentDto> mapListToDtos(List<Equipment> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

}
