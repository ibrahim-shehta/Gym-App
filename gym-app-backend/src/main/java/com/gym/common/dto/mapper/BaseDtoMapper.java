package com.gym.common.dto.mapper;

import java.util.List;

public interface BaseDtoMapper<E, Dto> {

	Dto mapEntityToDto(E entity);
	
	E mapDtoToEntity(Dto dto);
	
	List<Dto> mapListToDtos(List<E> entities);

}
