package com.gym.user.service.impl;

import java.io.Serializable;
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
import com.gym.common.service.impl.BaseStatusServiceImpl;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;
import com.gym.modules.settings.service.SettingsService;
import com.gym.user.dto.PermissionDto;
import com.gym.user.model.User;
import com.gym.user.repository.UserRepository;
import com.gym.user.repository.specification.UserSpecification;
import com.gym.user.service.PermissionService;
import com.gym.user.service.UserService;

@Service(value = "userService")
@Transactional
public class UserServiceImpl<E extends User, ID extends Serializable> extends BaseStatusServiceImpl<E, ID> implements UserService<E, ID> {

	@Autowired
	private UserRepository<E, ID> userRepository;
	
	@Autowired
	private FilesStorageService filesStorageService;

	@Override
	public UserRepository<E, ID> getRepository() {
		return userRepository;
	}

	 @Autowired
	 private SettingsService settingsService;
	 
	 @Autowired
	 private PermissionService permissionService;
	
	 @Override
	public Specification<E> getSpecifications(Map<String, Object> filterDataMap) {
		return UserSpecification.filterUsers(filterDataMap);
	}

	@Override
	public E save(E entity) {
		List<E> users = userRepository.findByUsernameOrEmailOrMobile(entity.getUsername(), entity.getEmail(),
				entity.getMobile());
		if (users != null && !users.isEmpty())
			throwErrorEntityDuplicateAttributes(entity, users);

		return super.save(entity);
	}

	
	private void throwErrorEntityDuplicateAttributes(E entity, List<E> users) {
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

	@SuppressWarnings("unchecked")
	@Override
	public E saveUserImage(MultipartFile file) {
		Settings settings = settingsService.findByCode(SettingsCode.PROFILES_IMAGES_PATH);
		User user = AppUtils.getCurrentUser().get();
		AppUtils.deleteFileByFullPath(settings.getValue() + "/" + user.getImageName());
		String fileName = user.getId() + AppConstant.UNIQE_SEPERATOR + user.getUsername() + AppConstant.UNIQE_SEPERATOR + System.currentTimeMillis() + AppConstant.PNG_FILE;
		filesStorageService.save(file, settings.getValue(), fileName);
		userRepository.updateImageName(fileName, user.getId());
		return userRepository.findById((ID)user.getId()).get();
	}

	@Override
	public void updateUserPassword(String password, Long id) {
		userRepository.updateUserPassword(password, id);	
	}

	@Override
	public E findByEmail(String email) {
		E user = userRepository.findByEmail(email);
		if (user == null) {
			throw new BusinessException(MessagesKeys.RESET_PASSWORD_EMAIL_NOTFOUND);
		}
		return user;
	}

	@Override
	public List<PermissionDto> getPermissionToUser(Long id) {
		return permissionService.getPermissionToUser(id);
	}
}
