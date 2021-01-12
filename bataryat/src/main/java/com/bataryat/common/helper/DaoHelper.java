package com.bataryat.common.helper;

import javax.persistence.criteria.CriteriaQuery;

public abstract class DaoHelper {

	/**
	 * As Per https://jira.spring.io/browse/DATAJPA-105 Spring Data JPA Throw Query Exception 
	 * query specified join fetching, but the owner of the fetched association was not present 
	 * When Use Specification Fetch With Pagination Problem In Count Query. This Method Check 
	 * If Count Query So You Can Use Join Instead Of Fetch And Use Fetch If Not Count Query
	 * @param query
	 * @return
	 */
	public static <T> boolean isCountQuery(CriteriaQuery<T> query) {
		return Long.class == query.getResultType();
	}
}
