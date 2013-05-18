package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;


/**
 * 用户管理模块，包括用户注册， 资料修改，密码修改等等
 * @author jimmy.du
 * May 13, 2013
 */
public interface UserService {

	public User getUserById(String buyer);

	
}
