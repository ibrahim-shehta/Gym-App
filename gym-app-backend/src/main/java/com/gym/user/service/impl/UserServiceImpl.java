package com.gym.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.user.model.User_;
import com.gym.common.constant.AppConstant;
import com.gym.common.constant.AppUtils;
import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.BusinessException;
import com.gym.common.exception.exceptions.EntityDuplicateAttributes;
import com.gym.common.exception.model.AppSubError;
import com.gym.common.exception.model.AppValidationError;
import com.gym.common.files.service.FilesStorageService;
import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;
import com.gym.modules.settings.service.SettingsService;
import com.gym.user.model.User;
import com.gym.user.repository.UserRepository;
import com.gym.user.repository.specification.UserSpecification;
import com.gym.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseAuditServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilesStorageService filesStorageService;

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

	 @Autowired
	 private SettingsService settingsService;
	
	 @Override
	public Specification<User> getSpecifications(Map<String, Object> filterDataMap) {
		return UserSpecification.filterUsers(filterDataMap);
	}

	@Override
	public User save(User entity) {
		List<User> users = userRepository.findByUsernameOrEmailOrMobile(entity.getUsername(), entity.getEmail(),
				entity.getMobile());
		if (users != null && !users.isEmpty())
			throwErrorEntityDuplicateAttributes(entity, users);

		return super.save(entity);
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

	@Override
	public User saveUserImage(MultipartFile file) {
		Settings settings = settingsService.findByCode(SettingsCode.PROFILES_IMAGES_PATH);
		User user = AppUtils.getCurrentUser().get();
		AppUtils.deleteFileByFullPath(settings.getValue() + "/" + user.getImageName());
		String fileName = user.getId() + AppConstant.UNIQE_SEPERATOR + user.getUsername() + AppConstant.UNIQE_SEPERATOR + System.currentTimeMillis() + AppConstant.PNG_FILE;
		filesStorageService.save(file, settings.getValue(), fileName);
		userRepository.updateImageName(fileName, user.getId());
		return userRepository.findById(user.getId()).get();
	}

	@Override
	public void updateUserPassword(String password, Long id) {
		userRepository.updateUserPassword(password, id);	
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new BusinessException(MessagesKeys.RESET_PASSWORD_EMAIL_NOTFOUND);
		}
		return user;
	}
}
