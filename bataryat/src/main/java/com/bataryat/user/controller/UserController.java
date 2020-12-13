package com.bataryat.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bataryat.user.dto.PermissionDto;
import com.bataryat.user.model.Permission;
import com.bataryat.user.model.translate.PermissionTranslate;
import com.bataryat.user.service.PermissionService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	
	private PermissionService permissionService;
	
	@Autowired
	public UserController(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@RequestMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}
	
	
	@RequestMapping("/permission/{id}/{langCode}")
	public PermissionDto getPermissionById(@PathVariable Long id, @PathVariable String langCode) {
		Permission entity = permissionService.getPermissionById(id, langCode);
		return new PermissionDto().mapEntityToDto(entity);
	}
	
}
