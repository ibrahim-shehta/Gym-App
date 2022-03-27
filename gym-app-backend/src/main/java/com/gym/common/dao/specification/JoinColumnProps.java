package com.gym.common.dao.specification;

import java.util.List;

import javax.persistence.criteria.JoinType;

public class JoinColumnProps {
	private String joinColumnName;
	private List<SearchFilter> searchFilter;
	private JoinType joinType;

	public String getJoinColumnName() {
		return joinColumnName;
	}

	public void setJoinColumnName(String joinColumnName) {
		this.joinColumnName = joinColumnName;
	}

	
	public JoinType getJoinType() {
		return joinType;
	}

	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}

	public List<SearchFilter> getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(List<SearchFilter> searchFilter) {
		this.searchFilter = searchFilter;
	}
}
