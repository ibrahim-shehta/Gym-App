package com.gym.security.model;

import java.util.List;

import com.gym.user.dto.PermissionDto;
import com.gym.user.dto.UserListDto;

public class AuthenticationResponse {

	private String token;
	private UserListDto user;
	private List<PermissionDto> permissions;
	
	public AuthenticationResponse()
	{
		
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	
	public AuthenticationResponse(String token, UserListDto user, List<PermissionDto> permissions) {
		super();
		this.token = token;
		this.user = user;
		this.permissions = permissions;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserListDto getUser() {
		return user;
	}

	public void setUser(UserListDto user) {
		this.user = user;
	}

	public List<PermissionDto> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDto> permissions) {
		this.permissions = permissions;
	}
	
}
