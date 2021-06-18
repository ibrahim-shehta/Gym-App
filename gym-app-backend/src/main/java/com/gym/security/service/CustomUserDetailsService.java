package com.gym.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gym.security.model.MyUserDetails;
import com.gym.user.dto.UserDto;
import com.gym.user.model.User;
import com.gym.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUserByUsername(username);
		if (user != null) {
			return new MyUserDetails(user);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
	}

	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getUsername());
		newUser.setName(user.getName());
		newUser.setMobile(user.getMobile());
		// newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}

}
