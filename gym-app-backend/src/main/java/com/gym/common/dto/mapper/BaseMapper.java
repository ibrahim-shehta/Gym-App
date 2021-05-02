package com.gym.common.dto.mapper;

import java.util.List;

import com.gym.common.dto.BaseDto;
import com.gym.common.model.BaseEntity;

public interface BaseMapper <E extends BaseEntity, Dto extends BaseDto> {

	public abstract Dto mapEntityToDto(E entity);
	
	public default E mapDtoToEntity(Dto dto) {
		return null;
	};
	
	public default List<Dto> mapListToDtos(List<E> entity) {
		return null;
	}
}
