package com.gym.common.service;

import java.io.Serializable;
import java.util.Date;

import com.gym.common.model.BaseStatusEntity;

public interface BaseStatusService<E extends BaseStatusEntity, ID extends Serializable> extends BaseService<E, ID> {
	
	public void updateStatus(ID id, int status,String reason, Date date);
}
