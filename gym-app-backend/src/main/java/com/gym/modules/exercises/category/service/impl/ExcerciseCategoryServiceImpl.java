package com.gym.modules.exercises.category.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.modules.exercises.category.dao.ExcerciseCategoryRepostory;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.modules.exercises.category.model.ExcerciseCategory_;
import com.gym.modules.exercises.category.service.ExcerciseCategoryService;

@Service
public class ExcerciseCategoryServiceImpl extends BaseAuditServiceImpl<ExcerciseCategory, Long> implements ExcerciseCategoryService {

	
	@Autowired
	private ExcerciseCategoryRepostory excerciseCategoryRepostory;
	
	@Override
	public ExcerciseCategoryRepostory getRepository() {
		return excerciseCategoryRepostory;
	}
	
	@Override
	public Specification<ExcerciseCategory> getSpecifications(Map<String, Object> filterDataMap) {return null;}
	
	@Override
	public Page<ExcerciseCategory> filterCategoryByName(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Object nameObj = filterDataWithPaginationAndSort.getFilterMap().get(ExcerciseCategory_.NAME);
		String name = String.valueOf(nameObj != null ? nameObj : "");
		
		return excerciseCategoryRepostory.findByNameContains(
				name == null || name.isEmpty() ? "" : name, 
				filterDataWithPaginationAndSort.getPageRequest()
			);
	}

}
