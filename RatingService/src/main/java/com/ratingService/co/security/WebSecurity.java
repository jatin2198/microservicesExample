package com.ratingService.co.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity {
	
	@Bean
	public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests().anyRequest()
		            .authenticated().and().oauth2ResourceServer().jwt();
		
		
		return httpSecurity.build();
		
	}

}
