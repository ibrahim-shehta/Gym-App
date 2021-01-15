package com.bataryat.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bataryat.common.request.FilterDataWithPaginationAndSort;
import com.bataryat.common.response.BaseResponse;
import com.bataryat.common.response.EntityResponse;
import com.bataryat.common.response.ListWithPaginationResponse;
import com.bataryat.user.dto.UserDto;
import com.bataryat.user.dto.UserListDto;
import com.bataryat.user.model.User;
import com.bataryat.user.service.UserService;

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
	
	@PostMapping
	public  ResponseEntity<BaseResponse<UserDto>> save(@Valid @RequestBody UserDto dto) {
		User entity = UserDto.mapDtoToEntity(dto);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity = userService.save(entity);
		dto = UserDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@PutMapping
	public  ResponseEntity<BaseResponse<UserDto>> update(@Valid @RequestBody UserDto dto) {
		User entity = UserDto.mapDtoToEntity(dto);
		entity = userService.update(entity);
		dto = UserDto.mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<UserDto>(dto));
	}
	
	@RequestMapping("/{id}")
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
