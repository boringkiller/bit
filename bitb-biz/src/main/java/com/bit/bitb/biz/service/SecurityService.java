package com.bit.bitb.biz.service;


/**
 * 安全模块
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
	 * 短信验证,从session中获取当前用户，发送验证码到手机，并将验证码存入session。在前台比较用户输入的验证码是否正确。
	 * @return
	 */
	public String doSMSverification();
	
	/**
	 * 加密
	 * @param input
	 * @return
	 */
	public String encrypt(String input);
	
	/**
	 * 解密
	 * @param input
	 * @return
	 */
	public String decrypt(String input);
}
