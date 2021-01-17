package com.gym.user.service;

import org.springframework.data.domain.Page;

import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.BaseService;
import com.gym.user.model.User;

public interface UserService extends BaseService<User, Long> {

	public Page<User> findAllByFilter(FilterDataWithPaginationAndSort filterData);

}
