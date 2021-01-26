package com.gym.common.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;

public interface BaseServiceWithSepecification<E, ID> extends BaseService<E, ID> {

	public Page<E> filterDataPaginated(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
	
	public List<E> filterAllData(FilterData filterData);

}
