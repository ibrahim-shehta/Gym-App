package com.gym.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.gym.common.model.BaseEntity;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;

public interface BaseService<E extends BaseEntity, ID extends Serializable> {

	public E save(E entity);
	
	public E update(E entity);
	
	public E findById(ID id);
	
	public List<E> getAll();
	
	public Page<E> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
	
	public List<E> filterAllData(FilterData filterData);
}
