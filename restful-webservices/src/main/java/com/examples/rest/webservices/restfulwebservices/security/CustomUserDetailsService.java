package com.examples.rest.webservices.restfulwebservices.security;
//package com.in28minutes.rest.webservices.restfulwebservices.security;
//
//import java.util.Arrays;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
////@Component
//public class CustomUserDetailsService implements UserDetailsService{
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if(username.equals("user")) {
//			return new User(username, "$2a$10$5CN9dWnZ30IoDQBUfox3COf.8Kg8aWhcwHMprqh/C9Gz2hm45shZ.", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
//		}
//		return null;
//	}
//
//}
