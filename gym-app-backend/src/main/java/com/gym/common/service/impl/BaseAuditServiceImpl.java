package com.gym.common.service.impl;

import java.io.Serializable;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.common.dto.AuditDto;
import com.gym.common.model.Auditable;
import com.gym.common.service.BaseAuditService;

public abstract class BaseAuditServiceImpl <E extends Auditable, ID extends Serializable> extends BaseServiceImpl<E, ID> implements BaseAuditService<E, ID> {

	public abstract BaseAuditRepository<E, ID> getRepository();
	
	@Override
	public AuditDto findAuditByEntityId(ID id) {
		return getRepository().findAuditByEntityId(id);
	}
}
