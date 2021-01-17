package com.gym.modules.subscription.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.subscription.dto.SubscriptionDto;
import com.gym.modules.subscription.dto.SubscriptionListDto;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

	private SubscriptionService subscriptionService;

	@Autowired
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PostMapping
	public ResponseEntity<BaseResponse<SubscriptionDto>> save(@Valid @RequestBody SubscriptionDto dto) {
		Subscription entity = SubscriptionDto.mapDtoToEntity(dto);
		entity = this.subscriptionService.save(entity);
		dto.setId(entity.getId());
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<SubscriptionDto>> findById(@PathVariable Long id) {
		Subscription entity = subscriptionService.findById(id);
		SubscriptionDto dto = SubscriptionDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));	
		
	}
	
	@PostMapping("/filter")
	public ResponseEntity<BaseResponse<SubscriptionListDto>> findAllByLangAndFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Page<Subscription> entity = this.subscriptionService.filterSubscriptions(filterDataWithPaginationAndSort);
		List<SubscriptionListDto> dto = SubscriptionListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<SubscriptionListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
}
