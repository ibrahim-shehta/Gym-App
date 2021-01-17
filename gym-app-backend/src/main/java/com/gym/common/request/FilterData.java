package com.gym.common.request;

import java.util.HashMap;
import java.util.Map;

public class FilterData extends BaseRequest {

	private Map<String, Object> filterMap = new HashMap<>();

	public Map<String, Object> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(Map<String, Object> filterMap) {
		this.filterMap = filterMap;
	}

}
