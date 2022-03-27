package com.gym.common.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gym.common.dao.specification.SearchQuery;
import com.gym.common.dto.BaseDto;
import com.gym.common.dto.mapper.BaseDtoMapper;
import com.gym.common.model.BaseEntity;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.common.service.BaseService;


public abstract class BaseController<E extends BaseEntity, ID extends Serializable ,EDto extends BaseDto, LDto extends BaseDto> {

	  private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

	
	protected abstract BaseService<E, ID> getService();
	protected abstract BaseDtoMapper<E, EDto> getEntityDtoMapper();
	protected abstract BaseDtoMapper<E, LDto> getListDtoMapper();

	
	@PostMapping
	public ResponseEntity<BaseResponse<EDto>> insert(@Valid @RequestBody EDto dto,  HttpServletRequest req) {
		  return save(dto, req);
	}	
	
	protected ResponseEntity<BaseResponse<EDto>> save(EDto dto, HttpServletRequest req) {
		  E entity = getEntityDtoMapper().mapDtoToEntity(dto); 
		  entity = getService().save(entity); 
		  dto = getEntityDtoMapper().mapEntityToDto(entity);
		  return ResponseEntity.ok(new EntityResponse<EDto>(dto));
	}
	
	@PutMapping
	public ResponseEntity<BaseResponse<EDto>> update(@Valid @RequestBody EDto dto,  HttpServletRequest req) {
		return edit(dto, req);
	}
	
	protected ResponseEntity<BaseResponse<EDto>> edit(EDto dto,  HttpServletRequest req) {
		E entity = getEntityDtoMapper().mapDtoToEntity(dto);
		entity = getService().update(entity);
		dto = getEntityDtoMapper().mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<EDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<EDto>> getById(@PathVariable ID id,  HttpServletRequest req) {
		return findById(id, req);
	}
	
	protected ResponseEntity<BaseResponse<EDto>> findById(ID id, HttpServletRequest req) {
		E entity = getService().findById(id);
		EDto dto = getEntityDtoMapper().mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<EDto>(dto));
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse<LDto>> getAll( HttpServletRequest req) {
		return findAll(req);
	}
	
	protected ResponseEntity<BaseResponse<LDto>> findAll( HttpServletRequest req) {
		List<E> entity = getService().getAll();
		List<LDto> dto = getListDtoMapper().mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<LDto>(dto));
	}
	
	@PostMapping("/all-filter")
	public ResponseEntity<BaseResponse<LDto>> allFilter(@RequestBody FilterData filterData,  HttpServletRequest req) {
		return filterAllData(filterData, req);
	}
	
	protected ResponseEntity<BaseResponse<LDto>> filterAllData(FilterData filterData,  HttpServletRequest req) {
		List<E> entity = getService().filterAllData(filterData);
		List<LDto> dto = getListDtoMapper().mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<LDto>(dto));
	}
	
	@PostMapping("/paginated-filter")
	public ResponseEntity<BaseResponse<LDto>> paginatedFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort,  HttpServletRequest req) {
		return getPaginatedFilterData(filterDataWithPaginationAndSort, req);
	}
	
	protected ResponseEntity<BaseResponse<LDto>> getPaginatedFilterData(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort,  HttpServletRequest req) {
		Page<E> entity = getService().filterDataPaginated(filterDataWithPaginationAndSort); 
		List<LDto> dto = (List<LDto>) getListDtoMapper().mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<LDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	
	
	@PostMapping("/advanced-search")
	public ResponseEntity<BaseResponse<LDto>> advancedSearch(@RequestBody SearchQuery searchQuery,  HttpServletRequest req) {
		LOG.info("======>" + req + "======>" + searchQuery);
		return getAdvancedSearchPaginated(searchQuery, req);
	}
	
	protected ResponseEntity<BaseResponse<LDto>> getAdvancedSearchPaginated(SearchQuery searchQuery,  HttpServletRequest req) {
		Page<E> entity = getService().findAll(searchQuery); 
		List<LDto> dto = (List<LDto>) getListDtoMapper().mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<LDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	
}
