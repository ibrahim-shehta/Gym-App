package com.gym.config.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gym.common.constant.enums.Status;
import com.gym.user.model.User;
import com.gym.user.model.UserType;
import com.gym.user.repository.UserRepository;

@Component
public class DataLoader {

    
	private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    
    @Autowired
    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    	this.passwordEncoder = passwordEncoder;
    	this.userRepository = userRepository;
    	
    }
    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        // Add default user on startup if there's no user is available on DB
        if(userRepository.count() == 0) {
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@yahoo.com");
            user.setMobile("01065373918");
            user.setStatus(Status.ACTIVE.getValue());
            user.setUserType(UserType.EMPLOYEE);
            user.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(user);
        }
    }
}
