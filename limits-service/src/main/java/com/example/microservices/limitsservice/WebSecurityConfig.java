package com.example.microservices.limitsservice;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER", "ACTUATOR").build());
		return manager;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/application/shutdown").ignoringAntMatchers("/application/refresh").ignoringAntMatchers("/application/bus/refresh")
		.ignoringAntMatchers("/actuator/bus-refresh");
		http
			.authorizeRequests()
				.antMatchers("/application/**")
				.permitAll()
				.anyRequest().permitAll();
				//authenticated()
	}
}

