package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

/**
 * 安全相关
 * @author jimmy.du
 * May 13, 2013
 */
public interface SecurityService {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String userLogin(String username, String password);
	
	
	/**
	 * 用户退出
	 * @param username
	 * @param password
	 * @return
	 */
	public String userLogout(String username);
	
	
	/**
	 * 短信验证
	 * @return
	 */
	public boolean doSMSverification(User user);
}
