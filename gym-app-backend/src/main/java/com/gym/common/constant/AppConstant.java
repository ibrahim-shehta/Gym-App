package com.gym.common.constant;

import org.springframework.data.domain.Sort.Direction;

public abstract class AppConstant {
	
	public static final int DEFAULT_PAGE = 0;
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final String DEFAULT_SORT_COLUMN = "id";
	public static final Direction DEFAULT_SORT_DIR = Direction.ASC;
}
