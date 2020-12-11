package com.bataryat.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bataryat.user.model.User;
import com.bataryat.user.repository.UserRepository;
import com.bataryat.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	
}
