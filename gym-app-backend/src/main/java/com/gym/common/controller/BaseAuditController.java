package com.gym.common.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gym.common.dto.AuditDto;
import com.gym.common.dto.BaseDto;
import com.gym.common.model.Auditable;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.service.BaseAuditService;

public abstract class BaseAuditController <E extends Auditable, ID extends Serializable ,EDto extends BaseDto, LDto extends BaseDto>
	extends BaseController<E, ID, EDto, LDto>
{

	protected abstract BaseAuditService<E, ID> getService();
	
	@GetMapping("/audit/{id}")
	public ResponseEntity<BaseResponse<AuditDto>> findAuditByEntityId(@PathVariable ID id) {
		AuditDto auditDto = getService().findAuditByEntityId(id);
		return ResponseEntity.ok(new EntityResponse<AuditDto>(auditDto));
	}
	
}
