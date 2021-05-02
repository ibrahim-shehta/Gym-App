package com.gym.common.dto;

import java.util.List;

import com.gym.common.model.BaseEntity;

public abstract interface BaseMapper <E extends BaseEntity, Dto extends BaseDto> {

	public abstract Dto mapEntityToDto(E entity);
	public abstract E mapDtoToEntity(Dto dto);
	public abstract List<Dto> mapListToDtos(List<E> entity);
}
