package com.bataryat.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bataryat.security.model.MyUserDetails;
import com.bataryat.user.dto.UserDto;
import com.bataryat.user.model.User;
import com.bataryat.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user != null) {
			return new MyUserDetails(user);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
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
