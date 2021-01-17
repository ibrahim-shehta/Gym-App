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

import com.gym.common.helper.ControllerHelper;
import com.gym.common.request.FilterDataWithPaginationAndSort;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.common.response.ListWithPaginationResponse;
import com.gym.user.dto.UserDto;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;
import com.gym.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	
	private UserService userService;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping(value= {"/employee", "/player", "/trainer"})
	public  ResponseEntity<BaseResponse<UserDto>> save(@Valid @RequestBody UserDto dto, HttpServletRequest req) {
		dto.setUserType(ControllerHelper.getUserType(req));
		User entity = UserDto.mapDtoToEntity(dto);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity = userService.save(entity);
		dto.setId(entity.getId());
		if (dto.getUserDetails() != null) {
			dto.getUserDetails().setId(entity.getUserDetails().getId());
		}
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@PutMapping(value= {"/employee", "/player", "/trainer"})
	public  ResponseEntity<BaseResponse<UserDto>> update(@Valid @RequestBody UserDto dto, HttpServletRequest req) {
		dto.setUserType(ControllerHelper.getUserType(req));
		User entity = UserDto.mapDtoToEntity(dto);
		entity = userService.update(entity);
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<UserDto>>  getUser(@PathVariable Long id) {
		UserDto dto = UserDto.mapEntityToDto(userService.findById(id));
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	
	@PostMapping("/all/filter")
	public ResponseEntity<BaseResponse<UserListDto>> findAllByLangAndFilter(@RequestBody FilterDataWithPaginationAndSort filterDataWithPaginationAndSort) {
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
	
}
