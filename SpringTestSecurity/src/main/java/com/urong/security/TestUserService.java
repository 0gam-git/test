package com.urong.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.urong.dto.User;
import com.urong.repository.UserRepository;

public class TestUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String sid) throws UsernameNotFoundException {
		
		User user  = userRepository.findOne(sid);
		
		String id = user.getId();
		String password = user.getPassword();
		
		TestUserDetail detail = new TestUserDetail(id, password);
		
		return detail;
	}

}
