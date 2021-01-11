package com.bataryat.common.request;

import java.util.HashMap;
import java.util.Map;

public class FilterDataWithPagination<T> extends BaseRequest<T> {
	
	private int currentPage;
	private int pageSize;
	private Map<String, Object> searchMap = new HashMap<>();
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getSearchMap() {
		return searchMap;
	}
	public void setSearchMap(Map<String, Object> searchMap) {
		this.searchMap = searchMap;
	}
	
	
}
