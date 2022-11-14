package net.spring_registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.spring_registration.model.User;
import net.spring_registration.repository.CustomUserDetails;
import net.spring_registration.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	//Pour charger le username(ici l'email) de l'utilisateur. C'est un service partagé
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
