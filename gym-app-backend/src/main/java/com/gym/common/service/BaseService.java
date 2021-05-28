package com.gym.common.service;

import java.io.Serializable;
import java.util.List;

import com.gym.common.model.BaseEntity;

public interface BaseService<E extends BaseEntity, ID extends Serializable> {

	public E save(E entity);
	
	public E update(E entity);
	
	public E findById(ID id);
	
	public List<E> getAll();
	
}
