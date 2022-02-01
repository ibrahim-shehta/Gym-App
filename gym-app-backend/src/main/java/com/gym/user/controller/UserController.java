package com.gym.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gym.common.constant.FilterKeys;
import com.gym.common.controller.BaseStatusController;
import com.gym.common.request.FilterData;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.user.dto.UserDto;
import com.gym.user.dto.UserListDto;
import com.gym.user.dto.mapper.UserDtoMapper;
import com.gym.user.dto.mapper.UserListDtoMapper;
import com.gym.user.model.User;
import com.gym.user.model.UserType;
import com.gym.user.service.UserService;

@RestController
@RequestMapping({"/api/v1/employee", "/api/v1/player", "/api/v1/trainer"})
public class UserController extends BaseStatusController<User, Long, UserDto, UserListDto> {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDtoMapper userDtoMapper;
	
	@Autowired
	private UserListDtoMapper userListDtoMapper;
	

	@Override
	protected UserService getService() {
		return userService;
	}

	@Override
	protected UserDtoMapper getEntityDtoMapper() {
		return userDtoMapper;
	}

	@Override
	protected UserListDtoMapper getListDtoMapper() {
		return userListDtoMapper;
	}
	
	@Override
	public  ResponseEntity<BaseResponse<UserDto>> save(UserDto dto, HttpServletRequest req) {
		dto.setUserType(getUserType(req));
		if (dto.getPassword() != null && dto.getPassword().length() > 0) {
			dto.setPassword(passwordEncoder.encode(dto.getPassword() != null ? dto.getPassword() : "1234"));
		}
		return super.save(dto, req);
	}
	
	@Override
	public  ResponseEntity<BaseResponse<UserDto>> edit(UserDto dto, HttpServletRequest req) {
		dto.setUserType(getUserType(req));
		return super.edit(dto, req);
	}
	
	@Override
	public ResponseEntity<BaseResponse<UserListDto>> getPaginatedFilterData(FilterDataWithPaginationAndSort filterDataWithPaginationAndSort, HttpServletRequest req) {
		filterDataWithPaginationAndSort.getFilterMap().put(FilterKeys.USER_TYPE, getUserType(req));
		return super.getPaginatedFilterData(filterDataWithPaginationAndSort, req);
	}
	
	@Override
	public ResponseEntity<BaseResponse<UserListDto>> filterAllData(@RequestBody FilterData filterData, HttpServletRequest req) {
		filterData.getFilterMap().put(FilterKeys.USER_TYPE, getUserType(req));
		return super.filterAllData(filterData, req);
	}
	
	@PostMapping("/upload/profile")
	  public ResponseEntity<BaseResponse<UserListDto>> uploadFile(@RequestParam("file") MultipartFile file) {
		User entity = userService.saveUserImage(file);
		UserListDto dto = userListDtoMapper.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<UserListDto>(dto));
	  }

	
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
