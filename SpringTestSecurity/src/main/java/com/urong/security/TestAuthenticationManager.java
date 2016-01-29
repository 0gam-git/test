package com.urong.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class TestAuthenticationManager implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		return authenticate(authentication);
	}

}
