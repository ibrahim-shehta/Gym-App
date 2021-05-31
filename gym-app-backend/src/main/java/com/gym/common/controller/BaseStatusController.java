package com.gym.common.controller;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gym.common.dto.BaseStatusDto;
import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.common.model.BaseStatusEntity;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.service.BaseStatusService;

public abstract class BaseStatusController <E extends BaseStatusEntity, ID extends Serializable ,EDto extends BaseStatusDto, LDto extends BaseStatusDto>
	extends BaseAuditController<E, ID, EDto, LDto> {

	protected abstract BaseStatusService<E, ID> getService();
	protected abstract BaseStatusMapper<E, EDto> getEntityDtoMapper();
	protected abstract BaseStatusMapper<E, LDto> getListDtoMapper();


	
	@SuppressWarnings("unchecked")
	@PutMapping("/status")
	public ResponseEntity<BaseResponse<String>> updateStatus(@Valid @RequestBody EDto dto) {
		getService().updateStatus((ID)dto.getId(), dto.getStatus(), dto.getStatusReason(), new Date());
		return ResponseEntity.ok(new EntityResponse<String>("updated"));
	} 
	
}
