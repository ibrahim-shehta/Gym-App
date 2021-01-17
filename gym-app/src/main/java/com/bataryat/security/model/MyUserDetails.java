package com.bataryat.security.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bataryat.user.model.User;

public class MyUserDetails implements UserDetails{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
     
    public MyUserDetails(User user) {
        this.user = user;
    }
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<Role> roles = user.getRoles();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//         
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
		
		// ** until add roles in app use manual roles 
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		 
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}
	
	public Long getUserId() {
		return this.user.getId();
	}
	
	public User getUser() {
		return this.user;
	}

}
