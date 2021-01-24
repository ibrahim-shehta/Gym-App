package com.gym.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.constant.FilterKeys;
import com.gym.common.helper.ControllerHelper;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.user.dto.UserDto;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;
import com.gym.user.model.UserType;
import com.gym.user.service.UserService;

@RestController
@RequestMapping({"/api/v1/employee", "/api/v1/player", "/api/v1/trainer"})
public class UserController {

	
	private UserService userService;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping
	public  ResponseEntity<BaseResponse<UserDto>> save(@Valid @RequestBody UserDto dto, HttpServletRequest req) {
		dto.setUserType(getUserType(req));
		User entity = UserDto.mapDtoToEntity(dto);
		if (dto.getPassword() != null && dto.getPassword().length() > 0) {
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		}
		entity = userService.save(entity);
		dto.setId(entity.getId());
		if (dto.getUserDetails() != null) {
			dto.getUserDetails().setId(entity.getUserDetails().getId());
		}
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@PutMapping
	public  ResponseEntity<BaseResponse<UserDto>> update(@Valid @RequestBody UserDto dto, HttpServletRequest req) {
		dto.setUserType(getUserType(req));
		User entity = UserDto.mapDtoToEntity(dto);
		entity = userService.update(entity);
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<UserDto>>  getUser(@PathVariable Long id) {
		UserDto dto = UserDto.mapEntityToDto(userService.findById(id));
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	
	@PostMapping("/filter")
	public ResponseEntity<BaseResponse<UserListDto>> findAllByLangAndFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort, HttpServletRequest req) {
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.USER_TYPE, getUserType(req));
		Page<User> entity = userService.findAllByFilter(filterDataWithPaginationAndSort);
		List<UserListDto> dto = UserListDto.mapListToDtos(entity.get().collect(Collectors.toList()));
		return ResponseEntity.ok(new ListWithPaginationResponse<UserListDto>(dto, entity.getNumber(), entity.getSize(), entity.getTotalElements()));
	}
	
	
	
//	@RequestMapping("/permission/{id}")
//	public PermissionDto getPermissionById(@PathVariable Long id) {
//		String langCode = LocaleContextHolder.getLocale().getLanguage();
//		Permission entity = permissionService.getPermissionById(id, langCode);
//		return new PermissionDto().mapEntityToDto(entity);
//	}
	
	
	private  UserType getUserType(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String userTypeString = uri.substring(uri.lastIndexOf("v1/") + 3);
		int haveAnotherSlash = userTypeString.indexOf("/");
		if (haveAnotherSlash >= 0) {
			userTypeString = userTypeString.substring(0, haveAnotherSlash);
		}
		if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.EMPLOYEE) {
			return UserType.EMPLOYEE;
		} else if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.TRAINER) {
			return UserType.TRAINER;
		} else if (UserType.valueOf(userTypeString.toUpperCase()) == UserType.PLAYER) {
			return UserType.PLAYER;
		}
		return null;
	}
	
}
