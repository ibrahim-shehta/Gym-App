package com.gym.modules.equipments.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.common.dto.BaseDto;
import com.gym.modules.equipments.model.Equipment;

public class EquipmentDto extends BaseDto {

	private String name;
	private String description;
	private String Code;
	private boolean isActive;
	private String statusReason;
	
	public static EquipmentDto mapEntityToDto(Equipment entity) {
		if (entity == null) {
			return null;
		}
		EquipmentDto dto = new EquipmentDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setCode(entity.getCode());
		dto.setActive(entity.isActive());
		dto.setStatusReason(entity.getStatusReason());
		return dto;
	}

	public static Equipment mapDtoToEntity(EquipmentDto dto) {
		if (dto == null) {
			return null;
		}
		Equipment entity = new Equipment();
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setCode(dto.getCode());
		entity.setActive(dto.isActive());
		entity.setStatusReason(dto.getStatusReason());
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}


}
