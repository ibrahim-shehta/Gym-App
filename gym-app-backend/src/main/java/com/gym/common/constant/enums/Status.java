package com.gym.common.constant.enums;

public enum Status {
	IN_ACTIVE(0),
	ACTIVE(1),
	DELETED(2),
	IN_PROGRESS(3),
	NEW(4),
	DRAFT(5),
	BLOCKED(6),
	RENEWED(7),
	EXPIRED(8);
	
	private int value;
	
	private Status(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
