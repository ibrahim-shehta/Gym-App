package com.bataryat.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.exception.exceptions.EntityDuplicateAttributes;
import com.bataryat.common.exception.model.AppSubError;
import com.bataryat.common.exception.model.AppValidationError;
import com.bataryat.common.request.FilterDataWithPaginationAndSort;
import com.bataryat.common.service.impl.BaseServiceImpl;
import com.bataryat.user.model.User;
import com.bataryat.user.model.User_;
import com.bataryat.user.repository.UserRepository;
import com.bataryat.user.repository.specification.UserSpecification;
import com.bataryat.user.service.UserService;

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
		PageRequest pageRequest = filterDataWithPaginationAndSort.getPageRequest(filterDataWithPaginationAndSort);
		Page<User> list = userRepository.findAll(UserSpecification.filterUsers(filterDataWithPaginationAndSort.getFilterMap()), pageRequest);
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
