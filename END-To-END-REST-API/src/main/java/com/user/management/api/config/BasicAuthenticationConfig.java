package com.user.management.api.config;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/*
 * ### SPRING SECURITY CUSTOM CONFIGURATION
 * 
 * Basic Authentication configuration which overrides the default configuration to add application specific configuration. 
 * The @EnableWebSecurity annotation tells Spring to enable spring security with the given configuration.
 * The @Configuration annotation creates a configuration bean inside spring container.
 */
@Configuration
@EnableWebSecurity
public class BasicAuthenticationConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${com.user.management.api.username}")
	private String username;
	
	@Value("${com.user.management.api.password}")
	private String password;

	// Custom AuthenticationEntryPoint required to tell spring to use this.
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable().authorizeRequests()
				.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()	// antMatcher allows to access Swagger URL
				.antMatchers("/h2Console/**").permitAll().anyRequest().fullyAuthenticated().and().httpBasic()	// antMatcher allows to access h2-console
				.authenticationEntryPoint(authEntryPoint);
		http.headers().frameOptions().sameOrigin();		// allows to access h2-console
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Configuration for in memory authentication with the given username, password and role.
		auth.inMemoryAuthentication().withUser(username).password("{noop}" + new String(Base64.getDecoder().decode(password)))
			.roles("USER");
	}
}
