package com.gym.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.common.jasper.impl.JasperExporterServiceImpl;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.modules.resetpassword.dao.ResetPasswordRequest;
import com.gym.modules.resetpassword.service.ResetPasswordService;
import com.gym.security.model.AuthenticationRequest;
import com.gym.security.model.AuthenticationResponse;
import com.gym.security.service.CustomUserDetailsService;
import com.gym.security.utils.JwtUtil;
import com.gym.user.dto.PermissionDto;
import com.gym.user.dto.UserDto;
import com.gym.user.dto.mapper.UserListDtoMapper;
import com.gym.user.model.User;
import com.gym.user.service.UserService;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private ResetPasswordService resetPasswordService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JasperExporterServiceImpl jasperExporterServiceImpl;
	
	
	@Autowired
	UserListDtoMapper userListDtoMapper;

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
		List<PermissionDto> permissions = userService.getPermissionToUser(user.getId());
		return ResponseEntity.ok(new EntityResponse<>(new AuthenticationResponse(token, userListDtoMapper.mapEntityToDto(user), permissions)));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@GetMapping
	public String showMessage() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", new Long(26));
		params.put("startDate", "2021-03-10");
		params.put("endDate", "2021-03-24");
		jasperExporterServiceImpl.exportPdfToFile("D:/gym/report-templates/UserAttendance.jasper", "D:/gym/report-templates/UserAttendance.pdf", params);
		return "Hello My Client To Gym App !";
	}
	
	@PostMapping("/send-email")
	public void sendEmailToResetPassword(@RequestBody ResetPasswordRequest resetPasswordReq) {
		User user = userService.findByEmail(resetPasswordReq.getEmail());
		resetPasswordService.generateResetPassword(user);
	}
	
	@PostMapping("/reset-password")
	public void resetPassword(@RequestBody ResetPasswordRequest resetPassword) {
		resetPasswordService.verifyResetPasswordCode(resetPassword.getCode(), resetPassword.getPassword());
	}

}
