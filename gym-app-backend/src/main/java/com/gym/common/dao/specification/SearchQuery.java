package com.gym.common.dao.specification;

import java.util.List;

public class SearchQuery {

	private int pageNumber;
	private int pageSize;

	private SortOrder sortOrder;
	private List<SearchFilter> searchFitlers;
	private List<JoinColumnProps> joinColumnProps;



	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<JoinColumnProps> getJoinColumnProps() {
		return joinColumnProps;
	}

	public void setJoinColumnProps(List<JoinColumnProps> joinColumnProps) {
		this.joinColumnProps = joinColumnProps;
	}

	public List<SearchFilter> getSearchFitlers() {
		return searchFitlers;
	}

	public void setSearchFitlers(List<SearchFilter> searchFitlers) {
		this.searchFitlers = searchFitlers;
	}

}