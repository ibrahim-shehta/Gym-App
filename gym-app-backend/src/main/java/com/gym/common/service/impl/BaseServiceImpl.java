package com.gym.common.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.service.BaseService;

public abstract class BaseServiceImpl<E, ID> implements BaseService<E, ID>{

	public abstract JpaRepository<E, ID> getRepository();
	
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