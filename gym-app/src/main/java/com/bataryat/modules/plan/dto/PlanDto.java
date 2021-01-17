package com.bataryat.modules.plan.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bataryat.common.dto.AuditableDto;
import com.bataryat.modules.plan.model.Plan;

public class PlanDto extends BasePlanDto {

	private List<@Valid PlanTranslateDto> planTranslate = new ArrayList<>();
	private AuditableDto audit;
	
	public static PlanDto mapEntityToDtoWithAudit(Plan entity) {
		 PlanDto dto = mapEntityToDto(entity);
		 dto.setAudit(AuditableDto.mapEntityToDto(entity));
		 return dto;
	}
	public static PlanDto mapEntityToDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();
		BasePlanDto.mapEntityToDto(entity, dto);
		entity.getPlanTranslate().forEach(item -> {
			dto.planTranslate.add(PlanTranslateDto.mapEntityToDto(item));
		});
		return dto;
	}
	
	public static Plan mapDtoToEntity(PlanDto dto) {
		if (dto == null) {
			return null;
		}
		Plan entity = new Plan();
		BasePlanDto.mapDtoToEntity(dto, entity);
		dto.getPlanTranslate().forEach(item -> {
			entity.addTranslate(PlanTranslateDto.mapDtoToEntity(item));
		});
		return entity;
	}
	
	public static List<PlanDto> mapListToDtos(List<Plan> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDto(item)).collect(Collectors.toList());
	}
	
	
	public static List<PlanDto> mapListToDtosWithAudit(List<Plan> entity) {
		if (entity == null || entity.isEmpty()) {
			return Collections.emptyList();
		}
		return entity.stream().map(item -> mapEntityToDtoWithAudit(item)).collect(Collectors.toList());
	}
	

	public List<PlanTranslateDto> getPlanTranslate() {
		return planTranslate;
	}
	public void setPlanTranslate(List<PlanTranslateDto> planTranslate) {
		this.planTranslate = planTranslate;
	}

	public AuditableDto getAudit() {
		return audit;
	}

	public void setAudit(AuditableDto audit) {
		this.audit = audit;
	}	
	
}
