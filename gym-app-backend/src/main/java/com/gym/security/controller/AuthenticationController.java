package com.gym.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.security.model.AuthenticationRequest;
import com.gym.security.model.AuthenticationResponse;
import com.gym.security.service.CustomUserDetailsService;
import com.gym.security.utils.JwtUtil;
import com.gym.user.dto.UserDto;
import com.gym.user.dto.UserListDto;
import com.gym.user.model.User;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping
	public ResponseEntity<BaseResponse<AuthenticationResponse>> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtUtil.generateToken(userdetails);
		User user = userDetailsService.findUserByUsername(authenticationRequest.getUsername());
		return ResponseEntity.ok(new EntityResponse<>(new AuthenticationResponse(token, UserListDto.mapEntityToDto(user))));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@GetMapping
	public String showMessage() {
		return "Hello My Client To Gym App !";
	}
}
