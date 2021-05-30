package com.gym.common.service;

import java.io.Serializable;

import com.gym.common.model.BaseStatusEntity;

public interface BaseStatusWithSpcificationService<E extends BaseStatusEntity, ID extends Serializable> 
		extends BaseStatusService<E, ID>, BaseServiceWithSepecification<E, ID> {

}
