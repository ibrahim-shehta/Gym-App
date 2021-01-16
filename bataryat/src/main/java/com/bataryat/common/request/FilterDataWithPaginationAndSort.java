package com.bataryat.common.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.bataryat.common.constant.AppConstant;

public class FilterDataWithPaginationAndSort extends FilterData {

	private Integer page;
	private Integer size;
	private String sortColumn;
	private String sortDirection;
	
	public PageRequest getPageRequest(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		PageRequest pageRequest = PageRequest.of(
				filterDataWithPaginationAndSort.getPage() != null ? filterDataWithPaginationAndSort.getPage() : AppConstant.DEFAULT_PAGE,
				filterDataWithPaginationAndSort.getSize() != null ? filterDataWithPaginationAndSort.getSize() : AppConstant.DEFAULT_PAGE_SIZE,
				filterDataWithPaginationAndSort.getSortDirection()  != null ? Direction.fromString(filterDataWithPaginationAndSort.getSortDirection()) : AppConstant.DEFAULT_SORT_DIR,
				filterDataWithPaginationAndSort.getSortColumn() != null ? filterDataWithPaginationAndSort.getSortColumn() : AppConstant.DEFAULT_SORT_COLUMN
				);
		return pageRequest;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

}
