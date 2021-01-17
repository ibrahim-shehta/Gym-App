package com.gym.config.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.gym.security.model.MyUserDetails;
import com.gym.user.model.User;


@Component
public class AuditorAwareImpl implements AuditorAware<User>  {
	
	@Override
    public Optional<User> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) { // if user  logged in return current logged user 
			 UsernamePasswordAuthenticationToken myUsernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) auth;
			 MyUserDetails myUserDetails =  (MyUserDetails) myUsernamePasswordAuthenticationToken.getPrincipal();
			 return Optional.of(myUserDetails.getUser());
		 }
		 
		 return Optional.ofNullable(null); // if user not logged in return null
    }

}
