package com.bataryat.common.response;

import java.util.List;

public class ListWithPaginationResponse<T> extends BaseResponse<T> {
	private List<T> data;
	private int currentPage;
	private int pageSize;
	private int totalRows;

	public ListWithPaginationResponse() {}

	public ListWithPaginationResponse(List<T> data) {
		this.setData(data);
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

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
}
