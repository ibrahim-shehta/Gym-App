package com.gym.common.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.dao.BaseRepository;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.model.BaseEntity;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID> {

	public abstract BaseRepository<E, ID> getRepository();
	public abstract Specification<E> getSpecifications(Map<String, Object> filterDataMap);
	
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
	
	@Override
	public Page<E> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Pageable pageRequest = filterDataWithPaginationAndSort.getPageRequest();
		Page<E> list = getRepository().findAll(getSpecifications(filterDataWithPaginationAndSort.getFilterMap()), pageRequest);
		return list;
	}

	@Override
	public List<E> filterAllData(FilterData filterData) {
		List<E> list = getRepository().findAll(getSpecifications(filterData.getFilterMap()));
		if (list.isEmpty()) {
			throw new EnityNotFoundException(MessagesKeys.EXCEPTION_MESSAGES_ENTITY_NOT_FOUND);
		}
		return list;
	}
}
