package com.gym.modules.subscription.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gym.modules.subscription.model.Subscription;

public class SubscriptionListDto extends BaseSubscriptionDto {
	private String planName;

	public static SubscriptionListDto mapEntityToDto(Subscription entity) {
		if (entity == null)
			return null;
		SubscriptionListDto dto = new SubscriptionListDto();
		BaseSubscriptionDto.mapEntityToDto(entity, dto);
		dto.setPlanName(entity.getPlan().getName());
		return dto;
	}

	public static List<SubscriptionListDto> mapListToDtos(List<Subscription> entity) {
		if (entity == null)
			return Collections.emptyList();
		List<SubscriptionListDto> dto = entity.stream().map(plan -> mapEntityToDto(plan)).collect(Collectors.toList());
		return dto;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}


}
