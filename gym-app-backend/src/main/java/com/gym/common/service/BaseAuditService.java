package com.gym.common.service;

import java.io.Serializable;

import com.gym.common.dto.AuditDto;
import com.gym.common.model.Auditable;

public interface BaseAuditService<E extends Auditable, ID extends Serializable> extends BaseService<E, ID> {

	public AuditDto findAuditByEntityId(ID id);
}
