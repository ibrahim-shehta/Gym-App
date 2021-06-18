package com.gym.modules.exercises.category.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseAuditController;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryListDto;
import com.gym.modules.exercises.category.dto.mapper.ExcerciseCategoryDtoMapper;
import com.gym.modules.exercises.category.dto.mapper.ExcerciseCategoryListDtoMapper;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.modules.exercises.category.service.ExcerciseCategoryService;


@Controller
@RequestMapping("/api/v1/excercises/category")
public class ExcerciseCategoryController extends BaseAuditController<ExcerciseCategory, Long, ExcerciseCategoryDto, ExcerciseCategoryListDto>{

	@Autowired
	private ExcerciseCategoryService excerciseCategoryService;
	
	@Autowired
	private ExcerciseCategoryDtoMapper excerciseCategoryDtoMapper;
	
	@Autowired
	private ExcerciseCategoryListDtoMapper excerciseCategoryListDtoMapper;

	@Override
	protected ExcerciseCategoryService getService() {
		return excerciseCategoryService;
	}

	@Override
	protected ExcerciseCategoryDtoMapper getEntityDtoMapper() {
		return excerciseCategoryDtoMapper;
	}

	@Override
	protected ExcerciseCategoryListDtoMapper getListDtoMapper() {
		return excerciseCategoryListDtoMapper;
	}

	@Override
	protected ResponseEntity<BaseResponse<ExcerciseCategoryListDto>> getPaginatedFilterData(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort, HttpServletRequest req) {
		Page<ExcerciseCategory> entity = this.excerciseCategoryService.filterCategoryByName(filterDataWithPaginationAndSort);
		List<ExcerciseCategoryListDto> dto = ExcerciseCategoryListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<ExcerciseCategoryListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	
	
}
