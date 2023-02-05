package com.gym.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDto extends UserDto {
	private int tall;
	private int weight;
}
