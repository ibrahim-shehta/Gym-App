package com.bataryat.common.dto;

public interface MapperDto <Entity, Dto, Id>{

	public Dto mapEntityToDto(Entity entity);
	
	public Entity mapDtoToEntity(Dto dto);
	
}
