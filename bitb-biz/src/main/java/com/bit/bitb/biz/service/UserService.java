package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

public interface UserService {

	/**
	 * 短信验证
	 * @return
	 */
	public boolean doSMSverification(User user);
	
}
