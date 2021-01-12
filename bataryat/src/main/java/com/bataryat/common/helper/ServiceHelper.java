package com.bataryat.common.helper;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.bataryat.common.constant.AppConstant;
import com.bataryat.common.request.FilterDataWithPaginationAndSort;

public abstract class ServiceHelper {

	public static PageRequest getPageRequest(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		PageRequest pageRequest = PageRequest.of(
				filterDataWithPaginationAndSort.getPage() != null ? filterDataWithPaginationAndSort.getPage() : AppConstant.DEFAULT_PAGE,
				filterDataWithPaginationAndSort.getSize() != null ? filterDataWithPaginationAndSort.getSize() : AppConstant.DEFAULT_PAGE_SIZE,
				filterDataWithPaginationAndSort.getSortDirection()  != null ? Direction.fromString(filterDataWithPaginationAndSort.getSortDirection()) : AppConstant.DEFAULT_SORT_DIR,
				filterDataWithPaginationAndSort.getSortColumn() != null ? filterDataWithPaginationAndSort.getSortColumn() : AppConstant.DEFAULT_SORT_COLUMN
				);
		return pageRequest;
	}
}
