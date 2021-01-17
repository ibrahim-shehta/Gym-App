package com.gym.user.dto;

import com.gym.common.dto.BaseDto;
import com.gym.user.model.UserDetails;

public class UserDetailsDto extends BaseDto {

	private int tall;
	private int weight;

	public static UserDetailsDto mapEntityToDto(UserDetails entity) {
		if (entity == null) {
			return null;
		}
		UserDetailsDto dto = new UserDetailsDto();
		BaseDto.mapEntityToDto(entity, dto);
		dto.setTall(entity.getTall());
		dto.setWeight(entity.getWeight());
		return dto;
	}

	public static UserDetails mapDtoToEntity(UserDetailsDto dto) {
		if (dto == null) {
			return null;
		}
		UserDetails entity = new UserDetails();
		BaseDto.mapDtoToEntity(dto, entity);
		entity.setTall(dto.getTall());
		entity.setWeight(dto.getWeight());
		return entity;
	}

	public int getTall() {
		return tall;
	}

	public void setTall(int tall) {
		this.tall = tall;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
