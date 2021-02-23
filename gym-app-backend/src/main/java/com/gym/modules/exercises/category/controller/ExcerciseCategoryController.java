package com.gym.modules.exercises.category.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryDto;
import com.gym.modules.exercises.category.dto.ExcerciseCategoryListDto;
import com.gym.modules.exercises.category.model.ExcerciseCategory;
import com.gym.modules.exercises.category.service.ExcerciseCategoryService;


@Controller
@RequestMapping("/api/v1/excercises/category")
public class ExcerciseCategoryController {

	@Autowired
	private ExcerciseCategoryService excerciseCategoryService;
	
	
	@PostMapping
	public ResponseEntity<BaseResponse<ExcerciseCategoryDto>> save(@Valid @RequestBody ExcerciseCategoryDto dto) {
		ExcerciseCategory entity = ExcerciseCategoryDto.mapDtoToEntity(dto);
		entity = this.excerciseCategoryService.save(entity);
		dto = ExcerciseCategoryDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<ExcerciseCategoryDto>(dto));
	}
	
	@PutMapping
	public ResponseEntity<BaseResponse<ExcerciseCategoryDto>> edit(@Valid @RequestBody ExcerciseCategoryDto dto) {
		ExcerciseCategory entity = ExcerciseCategoryDto.mapDtoToEntity(dto);
		entity = this.excerciseCategoryService.update(entity);
		dto = ExcerciseCategoryDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<ExcerciseCategoryDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ExcerciseCategoryDto>> getById(@PathVariable Long id) {
		ExcerciseCategory entity = this.excerciseCategoryService.findById(id);
		ExcerciseCategoryDto dto = ExcerciseCategoryDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<ExcerciseCategoryDto>(dto));
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse<ExcerciseCategoryListDto>> findAllByLang() {
		List<ExcerciseCategory> entity = this.excerciseCategoryService.getAll();
		List<ExcerciseCategoryListDto> dto = ExcerciseCategoryListDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<ExcerciseCategoryListDto>(dto));
	}
	
	
	@PostMapping("/paginated-filter")
	public ResponseEntity<BaseResponse<ExcerciseCategoryDto>> paginatedFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Page<ExcerciseCategory> entity = this.excerciseCategoryService.filterCategoryByName(filterDataWithPaginationAndSort); //this.excerciseCategoryService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<ExcerciseCategoryDto> dto = ExcerciseCategoryDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<ExcerciseCategoryDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}

	
}
