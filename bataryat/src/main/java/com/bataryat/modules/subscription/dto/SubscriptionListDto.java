package com.bataryat.modules.subscription.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bataryat.modules.plan.dto.BasePlanDto;
import com.bataryat.modules.subscription.model.Subscription;

public class SubscriptionListDto extends BaseSubscriptionDto {

	public static SubscriptionListDto mapEntityToDto(Subscription entity) {
		if (entity == null)
			return null;
		SubscriptionListDto dto = new SubscriptionListDto();
		BasePlanDto.mapEntityToDto(entity, dto);
		return dto;
	}

	public static List<SubscriptionListDto> mapListToDtos(List<Subscription> entity) {
		if (entity == null)
			return Collections.emptyList();
		List<SubscriptionListDto> dto = entity.stream().map(plan -> mapEntityToDto(plan)).collect(Collectors.toList());
		return dto;
	}


}
