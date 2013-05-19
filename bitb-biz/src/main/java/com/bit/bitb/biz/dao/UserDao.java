package com.bit.bitb.biz.dao;

import com.bit.bitb.biz.entity.User;

public interface UserDao {

	public void updateUser(User user);

	public User getUserById(String userId);

}
