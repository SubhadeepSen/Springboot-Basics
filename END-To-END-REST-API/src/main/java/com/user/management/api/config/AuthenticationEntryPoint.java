package com.user.management.api.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*
 * ### SPRING SECURITY COMPONENT
 * 
 * This Class is required to disable the Browser pop up if URL is unauthorized.
 * Sends a response message in the HTTP header instead and displays "HTTP Status 401 -  Unauthenticated message" in the Browser.
 */

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	// Overriding the default commence strategy
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		response.addHeader("Authentication", "Basic authentication required for this " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 - " + authEx.getMessage());
	}

	// setting the realm name and it's required along with the above method.
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("application API");
		super.afterPropertiesSet();
	}

}
