package net.spring_registration.repository;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.spring_registration.model.User;

public class CustomUserDetails implements UserDetails {
	
	/**
	 
	 Cette classe contient les methodes concernant les détails de l'utilisateur. Elle implémente l'interface UserDetails de Spring Security
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
		
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName(){
		
		return user.getFirstName() + " "+ user.getLastName();
	}
}
