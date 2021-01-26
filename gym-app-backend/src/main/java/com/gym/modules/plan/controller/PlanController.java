package com.gym.modules.plan.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.plan.dto.PlanDto;
import com.gym.modules.plan.dto.PlanListDto;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@PostMapping
	public ResponseEntity<BaseResponse<PlanDto>> save(@Valid @RequestBody PlanDto dto) {
		Plan entity = PlanDto.mapDtoToEntity(dto);
		entity = this.planService.save(entity);
		dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));	}
	
	@PutMapping
	public ResponseEntity<BaseResponse<PlanDto>> edit(@Valid @RequestBody PlanDto dto) {
		Plan entity = PlanDto.mapDtoToEntity(dto);
		entity = this.planService.update(entity);
		dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<PlanDto>> getById(@PathVariable Long id) {
		Plan entity = this.planService.findById(id);
		PlanDto dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));
	}
	
	@GetMapping("/local/{id}")
	public ResponseEntity<BaseResponse<PlanDto>> findByIdAndLang(@PathVariable Long id) {
		Plan entity = this.planService.findById(id);
		PlanDto dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse<PlanListDto>> findAllByLang() {
		List<Plan> entity = this.planService.getAll();
		List<PlanListDto> dto = PlanListDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<PlanListDto>(dto));
	}
	
	
	@PostMapping("/paginated-filter")
	public ResponseEntity<BaseResponse<PlanListDto>> paginatedFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Page<Plan> entity = this.planService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<PlanListDto> dto = PlanListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<PlanListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}

	@PostMapping("/all-filter")
	public ResponseEntity<BaseResponse<PlanListDto>> allFilter(@RequestBody FilterData filterData) {
		List<Plan> entity = this.planService.filterAllData(filterData);
		List<PlanListDto> dto = PlanListDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<PlanListDto>(dto));
	}
}
