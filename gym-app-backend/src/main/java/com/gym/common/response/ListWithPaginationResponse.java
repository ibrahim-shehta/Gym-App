package com.gym.common.response;

import java.util.List;

public class ListWithPaginationResponse<T> extends BaseResponse<T> {
	private int currentPage;
	private int pageSize;
	private long totalRows;
	private List<T> data;
	

	public ListWithPaginationResponse() {}

	public ListWithPaginationResponse(List<T> data) {
		this.setData(data);
	}
	
	

	public ListWithPaginationResponse(List<T> data, int currentPage, int pageSize, long totalRows) {
		super();
		this.data = data;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

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

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
}
