package com.gym.modules.equipments.dto;

import com.gym.common.dto.BaseStatusDto;

public class EquipmentDto extends BaseStatusDto {

	private String name;
	private String description;
	private String Code;

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
