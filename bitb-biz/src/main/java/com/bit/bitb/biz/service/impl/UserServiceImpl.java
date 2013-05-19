package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.dao.UserDao;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public User getUserById(String userId) {
		
		return userDao.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
