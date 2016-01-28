package com.urong.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.urong.dao.UserDao;
import com.urong.dto.User;
import com.urong.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
