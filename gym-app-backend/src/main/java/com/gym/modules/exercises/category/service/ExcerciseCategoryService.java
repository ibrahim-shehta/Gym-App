package com.gym.modules.exercises.category.service;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseService;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

public interface ExcerciseCategoryService extends BaseService<ExcerciseCategory, Long> {

	public Page<ExcerciseCategory> filterCategoryByName(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort);
}
