package com.gym.modules.subscription.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.constant.FilterKeys;
import com.gym.common.constant.enums.Status;
import com.gym.common.controller.BaseStatusController;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.modules.subscription.dto.SubscriptionDto;
import com.gym.modules.subscription.dto.SubscriptionListDto;
import com.gym.modules.subscription.dto.mapper.SubscriptionDtoMapper;
import com.gym.modules.subscription.dto.mapper.SubscriptionListDtoMapper;
import com.gym.modules.subscription.model.Subscription;
import com.gym.modules.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController extends BaseStatusController<Subscription, Long, SubscriptionDto, SubscriptionListDto> {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private SubscriptionDtoMapper subscriptionDtoMapper;
	
	@Autowired
	private SubscriptionListDtoMapper subscriptionListDtoMapper;
	

	
	@Override
	protected SubscriptionService getService() {
		return subscriptionService;
	}

	@Override
	protected SubscriptionDtoMapper getEntityDtoMapper() {
		return subscriptionDtoMapper;
	}

	@Override
	protected SubscriptionListDtoMapper getListDtoMapper() {
		return subscriptionListDtoMapper;
	}
	
	
	@PutMapping("/remain-amount")
	public ResponseEntity<BaseResponse<SubscriptionDto>> payRemainAmount(@RequestBody SubscriptionDto dto) {
		Subscription entity = getEntityDtoMapper().mapDtoToEntity(dto);
		this.subscriptionService.payRemainAmount(entity);
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(null));
	}
	
	@GetMapping("/{userId}/in-progress-subscription")
	public ResponseEntity<BaseResponse<SubscriptionDto>> getInProgressSubscription(@PathVariable Long userId) {
		FilterDataWithPaginationAndSort filterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.USER_ID, userId);
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.STATUS, Status.IN_PROGRESS.ordinal());
		
		Page<Subscription> entity = this.subscriptionService.filterDataPaginated(filterDataWithPaginationAndSort);
		List<Subscription> list = entity.get().collect(Collectors.toList());
		if (list.isEmpty()) {
			return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(null));
		}
		SubscriptionDto dto = getEntityDtoMapper().mapEntityToDto(list.get(0));
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));
	}

}
