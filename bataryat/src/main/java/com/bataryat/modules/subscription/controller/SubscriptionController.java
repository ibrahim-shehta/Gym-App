package com.bataryat.modules.subscription.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bataryat.common.response.BaseResponse;
import com.bataryat.common.response.EntityResponse;
import com.bataryat.modules.subscription.dto.SubscriptionDto;
import com.bataryat.modules.subscription.model.Subscription;
import com.bataryat.modules.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

	private SubscriptionService subscriptionService;

	@Autowired
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PostMapping
	public ResponseEntity<BaseResponse<SubscriptionDto>> save(@RequestBody SubscriptionDto dto) {
		Subscription entity = SubscriptionDto.mapDtoToEntity(dto);
		entity = this.subscriptionService.save(entity);
		dto.setId(entity.getId());
		return ResponseEntity.ok(new EntityResponse<SubscriptionDto>(dto));
	}
}
