package com.bataryat.modules.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bataryat.modules.plan.dto.PlanDto;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;
	
	@PostMapping
	public PlanDto save(@RequestBody PlanDto dto) {
		Plan entity = dto.mapDtoToEntity(dto);
		entity = this.planService.save(entity);
		return new PlanDto().mapEntityToDto(entity);
	}
	
	
	@PutMapping
	public PlanDto edit(@RequestBody PlanDto dto) {
		Plan entity = dto.mapDtoToEntity(dto);
		entity = this.planService.edit(entity);
		return new PlanDto().mapEntityToDto(entity);
	}
	
	@GetMapping("/{id}")
	public PlanDto getById(@PathVariable Long id) {
		Plan entity = this.planService.findById(id);
		PlanDto dto = new PlanDto().mapEntityToDto(entity);
		return dto;
	}
	
	
	@GetMapping
	public String test() {
		return resourceBundleMessageSource.getMessage("name", null, LocaleContextHolder.getLocale());
	}
}
