package com.gym.user.dto;

import com.gym.common.dto.BaseDto;

public class UserDetailsDto extends BaseDto {

	private int tall;
	private int weight;

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
