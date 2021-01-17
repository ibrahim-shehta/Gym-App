package com.gym.common.service;

import java.util.List;

public interface BaseService<E, ID> {

	public E save(E entity);
	
	public E update(E entity);
	
	public E findById(ID id);
	
	public List<E> getAll();
}
