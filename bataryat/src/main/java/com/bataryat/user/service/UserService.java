package com.bataryat.user.service;

import org.springframework.data.domain.Page;

import com.bataryat.common.request.FilterDataWithPaginationAndSort;
import com.bataryat.common.service.BaseService;
import com.bataryat.user.model.User;

public interface UserService extends BaseService<User, Long> {

	public Page<User> findAllByFilter(FilterDataWithPaginationAndSort filterData);

}
