package com.bataryat.modules.plan.dto;

import javax.validation.constraints.Positive;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.dto.BaseDto;
import com.bataryat.modules.plan.model.Plan;

public abstract class BasePlanDto extends BaseDto {

	private String code;
	
	@Positive(message=MessagesKeys.VALIDATION_PLAN_PRICE)
	private double price;

	BasePlanDto() {

	}

	public static void mapEntityToDto(Plan entity, BasePlanDto dto) {
		BaseDto.mapEntityToDto(entity, dto);
		dto.setCode(entity.getCode());
		dto.setPrice(entity.getPrice());
	}

	public static void mapDtoToEntity(BasePlanDto dto, Plan entity) {
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setCode(dto.getCode());
		entity.setPrice(dto.getPrice());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
