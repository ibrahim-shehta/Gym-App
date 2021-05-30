package com.gym.common.service.impl;

import java.io.Serializable;
import java.util.Date;

import javax.transaction.Transactional;

import com.gym.common.dao.BaseStatusRepository;
import com.gym.common.model.BaseStatusEntity;
import com.gym.common.service.BaseStatusWithSpcificationService;

@Transactional
public abstract class BaseStatusWithSpcificationServiceImpl<E extends BaseStatusEntity, ID extends Serializable> 
	extends BaseServiceWithSepecificationImpl<E, ID> implements BaseStatusWithSpcificationService<E, ID> {

	public abstract BaseStatusRepository<E, ID> getRepository();
	
	@Override
	public void updateStatus(ID id, int status, String reason, Date date) {
		getRepository().updateStatus(id, status, reason, date);
	}
}
