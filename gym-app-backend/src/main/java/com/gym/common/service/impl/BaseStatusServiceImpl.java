package com.gym.common.service.impl;

import java.io.Serializable;
import java.util.Date;

import com.gym.common.dao.BaseStatusRepository;
import com.gym.common.model.BaseStatusEntity;
import com.gym.common.service.BaseStatusService;

public abstract class BaseStatusServiceImpl<E extends BaseStatusEntity, ID extends Serializable> extends BaseServiceImpl<E, ID>
		implements BaseStatusService<E, ID> {

	public abstract BaseStatusRepository<E, ID> getRepository();
	
	@Override
	public void updateStatus(ID id, int status, String reason, Date date) {
		getRepository().updateStatus(id, status, reason, date);
	}

}
