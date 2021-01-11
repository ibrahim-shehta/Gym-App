package com.bataryat.modules.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bataryat.common.response.BaseResponse;
import com.bataryat.common.response.EntityResponse;
import com.bataryat.common.response.ListResponse;
import com.bataryat.modules.plan.dto.PlanDto;
import com.bataryat.modules.plan.dto.PlanListDto;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@PostMapping
	public ResponseEntity<BaseResponse<PlanDto>> save(@RequestBody PlanDto dto) {
		Plan entity = PlanDto.mapDtoToEntity(dto);
		entity = this.planService.save(entity);
		dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));	}
	
	@PutMapping
	public ResponseEntity<BaseResponse<PlanDto>> edit(@RequestBody PlanDto dto) {
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
		Plan entity = this.planService.findByIdAndLang(id);
		PlanDto dto = PlanDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<PlanDto>(dto));
	}
	
	@GetMapping("/local/all")
	public ResponseEntity<BaseResponse<PlanListDto>> findAllByLang() {
		List<Plan> entity = this.planService.findAllByLang();
		List<PlanListDto> dto = PlanListDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<PlanListDto>(dto));
	}
	
}
