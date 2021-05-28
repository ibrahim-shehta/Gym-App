package com.gym.common.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import com.gym.common.constant.MessagesKeys;
import com.gym.common.dao.BaseRepository;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.model.BaseEntity;
import com.gym.common.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID>{

	public abstract BaseRepository<E, ID> getRepository();
	
	@Override
	public E save(E entity) {
		return getRepository().save(entity);
	}

	@Override
	public E update(E entity) {
		return getRepository().save(entity);
	}

	@Override
	public E findById(ID id) {
		Optional<E> entity =  getRepository().findById(id);
		return entity.orElseThrow(() ->  new EnityNotFoundException(MessagesKeys.EXCEPTION_MESSAGES_ENTITY_NOT_FOUND));
	}

	@Override
	public List<E> getAll() {
		return getRepository().findAll();
	}
}
