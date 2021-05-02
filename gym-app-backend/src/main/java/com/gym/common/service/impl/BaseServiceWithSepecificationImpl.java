package com.gym.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseServiceWithSepecification;

public abstract class BaseServiceWithSepecificationImpl<E, ID> extends BaseServiceImpl<E, ID> implements BaseServiceWithSepecification<E, ID> {

	public abstract JpaSpecificationExecutor<E> getSpecificationRepository();
	public abstract Specification<E> getSpecifications(Map<String, Object> filterDataMap);
	
	@Override
	public Page<E> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Pageable pageRequest = filterDataWithPaginationAndSort.getPageRequest();
		Page<E> list = getSpecificationRepository().findAll(getSpecifications(filterDataWithPaginationAndSort.getFilterMap()), pageRequest);
		return list;
	}

	@Override
	public List<E> filterAllData(FilterData filterData) {
		List<E> list = getSpecificationRepository().findAll(getSpecifications(filterData.getFilterMap()));
		if (list.isEmpty()) {
			throw new EnityNotFoundException(MessagesKeys.EXCEPTION_MESSAGES_ENTITY_NOT_FOUND);
		}
		return list;
	}

}
