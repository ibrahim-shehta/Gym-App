package com.gym.security.model;

import com.gym.user.dto.UserListDto;

public class AuthenticationResponse {

	private String token;
	private UserListDto user;
	
	public AuthenticationResponse()
	{
		
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	
	public AuthenticationResponse(String token, UserListDto user) {
		super();
		this.token = token;
		this.setUser(user);
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

	
	
}
