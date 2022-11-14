package net.spring_registration.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		String rawPassword = "passer";
		String encodePassword = encode.encode(rawPassword);
		System.out.println(encodePassword);
		
	}

}
