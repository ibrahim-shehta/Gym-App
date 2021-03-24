package com.gym.modules.subscription.controller;

import java.util.Arrays;
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

import com.gym.common.constant.FilterKeys;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.modules.subscription.dto.SubscriptionDto;
import com.gym.modules.subscription.dto.SubscriptionListDto;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.model.enums.SubscriptionStatus;
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
	
	@PutMapping("/remain-amount")
	public ResponseEntity<BaseResponse<SubscriptionDto>> payRemainAmount(@RequestBody SubscriptionDto dto) {
		Subscription entity = SubscriptionDto.mapDtoToEntity(dto);
		this.subscriptionService.payRemainAmount(entity);
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(null));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<SubscriptionDto>> findById(@PathVariable Long id) {
		Subscription entity = subscriptionService.findById(id);
		SubscriptionDto dto = SubscriptionDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));	
		
	}
	
	@PostMapping("/paginated-filter")
	public ResponseEntity<BaseResponse<SubscriptionListDto>> paginatedFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Page<Subscription> entity = this.subscriptionService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<SubscriptionListDto> dto = SubscriptionListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<SubscriptionListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	
	@PostMapping("/all-filter")
	public ResponseEntity<BaseResponse<SubscriptionListDto>> allFilter(@RequestBody FilterData filterData) {
		List<Subscription> entity = this.subscriptionService.filterAllData(filterData);
		List<SubscriptionListDto> dto = SubscriptionListDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<SubscriptionListDto>(dto));
	}
	
	@GetMapping("/status-list")
	public ResponseEntity<BaseResponse<List<String>>> getStatusList() {
		List<String> statusList = Arrays.asList(SubscriptionStatus.values()).stream().map(status -> status.toString()).collect(Collectors.toList());
		return ResponseEntity.ok(new EntityResponse<List<String>>(statusList));	
	}
	
	@GetMapping("/{userId}/in-progress-subscription")
	public ResponseEntity<BaseResponse<SubscriptionDto>> getInProgressSubscription(@PathVariable Long userId) {
		FilterDataWithPaginationAndSort filterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.USER_ID, userId);
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.STATUS, SubscriptionStatus.IN_PROGRESS);
		
		Page<Subscription> entity = this.subscriptionService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<Subscription> list = entity.get().collect(Collectors.toList());
		if (list.isEmpty()) {
			return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(null));
		}
		SubscriptionDto dto = SubscriptionDto.mapEntityToDto(list.get(0));
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));
	}
	
	
}
