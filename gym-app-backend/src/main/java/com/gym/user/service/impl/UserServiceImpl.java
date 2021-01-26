package com.gym.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gym.user.model.User_;
import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.exception.exceptions.EntityDuplicateAttributes;
import com.gym.common.exception.model.AppSubError;
import com.gym.common.exception.model.AppValidationError;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.service.impl.BaseServiceImpl;
import com.gym.user.model.User;
import com.gym.user.repository.UserRepository;
import com.gym.user.repository.specification.UserSpecification;
import com.gym.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

	@Override
	public User save(User entity) {
		List<User> users = userRepository.findByUsernameOrEmailOrMobile(entity.getUsername(), entity.getEmail(),
				entity.getMobile());
		if (users != null && !users.isEmpty())
			throwErrorEntityDuplicateAttributes(entity, users);

		return super.save(entity);
	}

	@Override
	public Page<User> findAllByFilter(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
		Pageable pageRequest = filterDataWithPaginationAndSort.getPageRequest();
		Page<User> list = userRepository.findAll(UserSpecification.filterUsers(filterDataWithPaginationAndSort.getFilterMap()), pageRequest);
		if (list.getTotalElements() == 0) {
			throw new EnityNotFoundException(MessagesKeys.EXCEPTION_MESSAGES_ENTITY_NOT_FOUND);
		}
		return list;
	}
	
	private void throwErrorEntityDuplicateAttributes(User entity, List<User> users) {
		List<AppSubError> errors = new ArrayList<>();
		users.forEach(user -> {
			if (entity.getUsername().equals(user.getUsername()))
				errors.add(new AppValidationError(User_.USERNAME, entity.getUsername(), MessagesKeys.VALIDATION_USER_USERNAME_UNIQUE));

			if (entity.getEmail().equals(user.getEmail()))
				errors.add(new AppValidationError(User_.EMAIL, entity.getEmail(), MessagesKeys.VALIDATION_USER_EMAIL_UNIQUE));

			if (entity.getMobile().equals(user.getMobile()))
				errors.add(new AppValidationError(User_.MOBILE, entity.getMobile(), MessagesKeys.VALIDATION_USER_MOBILE_UNIQUE));
		});

		throw new EntityDuplicateAttributes(MessagesKeys.EXCEPTION_MESSAGES_DATA_NOT_VALID, errors);

	}
}
