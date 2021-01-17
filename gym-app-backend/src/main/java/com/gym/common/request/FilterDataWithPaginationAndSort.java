package com.gym.common.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.gym.common.constant.AppConstant;

public class FilterDataWithPaginationAndSort extends FilterData {

	private Integer page;
	private Integer size;
	private String sortColumn;
	private String sortDirection;
	
	public Pageable getPageRequest() {
		PageRequest pageRequest = PageRequest.of(
				this.page != null ? this.page : AppConstant.DEFAULT_PAGE,
				this.size != null ? this.size : AppConstant.DEFAULT_PAGE_SIZE,
				this.sortDirection != null ? Direction.fromString(this.sortDirection) : AppConstant.DEFAULT_SORT_DIR,
				this.sortColumn != null ? this.sortColumn : AppConstant.DEFAULT_SORT_COLUMN
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
