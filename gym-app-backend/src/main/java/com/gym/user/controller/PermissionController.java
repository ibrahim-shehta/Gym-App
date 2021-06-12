package com.gym.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.response.BaseResponse;
import com.gym.common.response.ListResponse;
import com.gym.user.dto.PermissionDto;
import com.gym.user.service.PermissionService;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping
	public ResponseEntity<BaseResponse<PermissionDto>> getAll() {
		List<PermissionDto> dto = permissionService.getAll();
		//List<PermissionDto> dto = PermissionDto.mapListToDtos(entity);
		return ResponseEntity.ok(new ListResponse<PermissionDto>(dto));
	}
}
