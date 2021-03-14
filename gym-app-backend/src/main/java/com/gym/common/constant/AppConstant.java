package com.gym.common.constant;

import org.springframework.data.domain.Sort.Direction;

public abstract class AppConstant {
	
	public static final int DEFAULT_PAGE = 0;
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final String DEFAULT_SORT_COLUMN = "id";
	public static final Direction DEFAULT_SORT_DIR = Direction.DESC;
	public static final String UNIQE_SEPERATOR = "-";
	
	public static final String UPLOAD_PROFILE_PATH = "D:/gym/uploads/profile";
	public static final String UPLOAD_EXCERCISES_PATH = "D:/gym/uploads/excercises";
	public static final String MAX_FILE_SIZE_IN_MEGA = "2";
	public static final String PNG_FILE = ".png";
}
